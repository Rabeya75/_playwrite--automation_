package com.quickybd.qa.playwright.support;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseUiTest {
  protected Playwright playwright;
  protected Browser browser;
  protected BrowserContext context;
  protected Page page;

  @BeforeEach
  void setUp() {
    playwright = Playwright.create();
    browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(true)
        .setArgs(List.of("--no-sandbox", "--disable-dev-shm-usage")));
    context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1440, 1080));
    page = context.newPage();
    page.setDefaultTimeout(15_000);
  }

  @AfterEach
  void tearDown() {
    if (context != null) {
      context.close();
    }
    if (browser != null) {
      browser.close();
    }
    if (playwright != null) {
      playwright.close();
    }
  }
}
