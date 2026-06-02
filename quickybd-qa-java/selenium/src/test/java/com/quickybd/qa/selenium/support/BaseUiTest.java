package com.quickybd.qa.selenium.support;

import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseUiTest {
  protected WebDriver driver;
  protected WebDriverWait wait;

  @BeforeEach
  void setUp() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments(
        "--headless=new",
        "--window-size=1440,1080",
        "--disable-gpu",
        "--no-sandbox",
        "--disable-dev-shm-usage");

    driver = new ChromeDriver(options);
    wait = new WebDriverWait(driver, Duration.ofSeconds(20));
  }

  @AfterEach
  void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }
}
