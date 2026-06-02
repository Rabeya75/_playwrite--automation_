package com.quickybd.qa.selenium.tests;

import com.quickybd.qa.selenium.config.TestConfig;
import com.quickybd.qa.selenium.pages.AdminProductPage;
import com.quickybd.qa.selenium.support.BaseUiTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

public class BackendSmokeTest extends BaseUiTest {

  @Test
  void backendUrlShowsAccessControlOrTheProductArea() {
    AdminProductPage adminProductPage = new AdminProductPage(driver, wait, TestConfig.backendUrl());

    adminProductPage.open();

    Assertions.assertTrue(
        adminProductPage.isLoginFormVisible() || adminProductPage.isProductTableVisible(),
        "Expected the admin page to show either a login form or the product listing");
  }

  @Test
  void authenticatedAdminCanOpenTheProductListWhenCredentialsAreProvided() {
    Assumptions.assumeTrue(
        TestConfig.hasAdminCredentials(),
        "Set QUICKYBD_ADMIN_USERNAME and QUICKYBD_ADMIN_PASSWORD to run the authenticated admin test.");

    AdminProductPage adminProductPage = new AdminProductPage(driver, wait, TestConfig.backendUrl());

    adminProductPage.open();

    if (adminProductPage.isLoginFormVisible()) {
      adminProductPage.login(TestConfig.adminUsername(), TestConfig.adminPassword());
    }

    Assertions.assertTrue(
        adminProductPage.isProductTableVisible(),
        "The admin product table should be visible after login");
  }
}
