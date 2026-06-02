package com.quickybd.qa.playwright.tests;

import com.quickybd.qa.playwright.config.TestConfig;
import com.quickybd.qa.playwright.pages.FrontendHomePage;
import com.quickybd.qa.playwright.support.BaseUiTest;
import org.junit.jupiter.api.Test;

public class FrontendSmokeTest extends BaseUiTest {

  @Test
  void homepageLoadsWithTheCoreSectionsVisible() {
    FrontendHomePage homePage = new FrontendHomePage(page, TestConfig.frontendUrl());

    homePage.open();

    homePage.assertTitleLooksCorrect();
    homePage.assertLandingSectionsVisible();
    homePage.assertFooterLinksVisible();
  }
}
