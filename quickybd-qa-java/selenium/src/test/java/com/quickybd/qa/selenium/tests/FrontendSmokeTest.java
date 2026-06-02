package com.quickybd.qa.selenium.tests;

import com.quickybd.qa.selenium.config.TestConfig;
import com.quickybd.qa.selenium.pages.FrontendHomePage;
import com.quickybd.qa.selenium.support.BaseUiTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FrontendSmokeTest extends BaseUiTest {

  @Test
  void homepageLoadsWithTheCoreSectionsVisible() {
    FrontendHomePage homePage = new FrontendHomePage(driver, wait, TestConfig.frontendUrl());

    homePage.open();

    Assertions.assertTrue(
        driver.getTitle().contains("Quicky BD"),
        "The storefront title should contain Quicky BD");
    homePage.assertLandingSectionsVisible();
    homePage.assertFooterLinksVisible();
  }
}
