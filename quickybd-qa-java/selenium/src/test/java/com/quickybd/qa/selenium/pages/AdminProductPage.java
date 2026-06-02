package com.quickybd.qa.selenium.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminProductPage {
  private static final List<By> LOGIN_USER_FIELDS = List.of(
      By.cssSelector("input[type='email']"),
      By.cssSelector("input[name='email']"),
      By.cssSelector("input[name='username']"),
      By.cssSelector("input[name='user_email']"),
      By.cssSelector("input[placeholder*='Email']"),
      By.cssSelector("input[placeholder*='email']"),
      By.cssSelector("input[placeholder*='Username']"),
      By.cssSelector("input[placeholder*='username']"));

  private static final List<By> LOGIN_PASSWORD_FIELDS = List.of(
      By.cssSelector("input[type='password']"));

  private static final List<By> LOGIN_SUBMIT_BUTTONS = List.of(
      By.cssSelector("button[type='submit']"),
      By.cssSelector("input[type='submit']"),
      By.xpath("//button[contains(normalize-space(), 'Login') or contains(normalize-space(), 'login') or contains(normalize-space(), 'Sign In') or contains(normalize-space(), 'Sign in') or contains(normalize-space(), 'Log In') or contains(normalize-space(), 'Log in')]"));

  private static final List<By> PRODUCT_TABLE_LOCATORS = List.of(
      By.cssSelector("table"),
      By.cssSelector(".table"),
      By.cssSelector(".datatable"),
      By.cssSelector(".data-table"),
      By.cssSelector(".table-responsive"));

  private final WebDriver driver;
  private final WebDriverWait wait;
  private final String backendUrl;

  public AdminProductPage(WebDriver driver, WebDriverWait wait, String backendUrl) {
    this.driver = driver;
    this.wait = wait;
    this.backendUrl = backendUrl;
  }

  public void open() {
    driver.get(backendUrl);
    wait.until(driver -> driver.getCurrentUrl() != null && !driver.getCurrentUrl().isBlank());
  }

  public boolean isLoginFormVisible() {
    return hasVisibleElement(LOGIN_PASSWORD_FIELDS)
        || pageSourceContains("login")
        || pageSourceContains("sign in");
  }

  public boolean isProductTableVisible() {
    return hasVisibleElement(PRODUCT_TABLE_LOCATORS) || pageSourceContains("product");
  }

  public void login(String username, String password) {
    WebElement usernameField = waitForVisibleElement(LOGIN_USER_FIELDS);
    WebElement passwordField = waitForVisibleElement(LOGIN_PASSWORD_FIELDS);

    usernameField.clear();
    usernameField.sendKeys(username);
    passwordField.clear();
    passwordField.sendKeys(password);

    clickFirstVisible(LOGIN_SUBMIT_BUTTONS);
    wait.until(driver -> isProductTableVisible() || !pageSourceContains("login"));
  }

  private WebElement waitForVisibleElement(List<By> locators) {
    return wait.until(driver -> findVisibleElement(locators));
  }

  private void clickFirstVisible(List<By> locators) {
    WebElement button = findVisibleElement(locators);
    if (button == null) {
      throw new NoSuchElementException("Could not find a visible login submit button.");
    }
    button.click();
  }

  private boolean hasVisibleElement(List<By> locators) {
    return findVisibleElement(locators) != null;
  }

  private WebElement findVisibleElement(List<By> locators) {
    for (By locator : locators) {
      for (WebElement element : driver.findElements(locator)) {
        if (element.isDisplayed()) {
          return element;
        }
      }
    }
    return null;
  }

  private boolean pageSourceContains(String text) {
    return driver.getPageSource().toLowerCase().contains(text.toLowerCase());
  }
}
