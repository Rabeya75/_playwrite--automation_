package com.quickybd.qa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrontendHomePage {
  private final WebDriver driver;
  private final WebDriverWait wait;
  private final String frontendUrl;

  public FrontendHomePage(WebDriver driver, WebDriverWait wait, String frontendUrl) {
    this.driver = driver;
    this.wait = wait;
    this.frontendUrl = frontendUrl;
  }

  public void open() {
    driver.get(frontendUrl);
    wait.until(ExpectedConditions.titleContains("Quicky"));
  }

  public void assertLandingSectionsVisible() {
    assertVisibleText("Categories");
    assertVisibleText("Vendors");
    assertVisibleText("Sell on Quicky");
    assertVisibleText("Shop by Category");
    assertVisibleText("Daily Deals");
    assertVisibleText("Our Featured Offers");
    assertVisibleText("You Might Also Like");
    assertVisibleText("More to Discover");
  }

  public void assertFooterLinksVisible() {
    assertVisibleLink("Blogs");
    assertVisibleLink("About");
    assertVisibleLink("Contact");
    assertVisibleLink("Privacy Policy");
    assertVisibleLink("Terms and Conditions");
    assertVisibleLink("Shipping and Return Policy");
    assertVisibleLink("Sitemap");
  }

  private void assertVisibleText(String text) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(normalize-space(), '" + text + "')]")));
  }

  private void assertVisibleLink(String text) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(text)));
  }
}
