package com.quickybd.qa.playwright.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import java.util.Locale;

public class AdminProductPage {
  private final Page page;
  private final String backendUrl;

  public AdminProductPage(Page page, String backendUrl) {
    this.page = page;
    this.backendUrl = backendUrl;
  }

  public void open() {
    page.navigate(backendUrl);
    page.waitForLoadState(LoadState.DOMCONTENTLOADED);
  }

  public boolean isLoginFormVisible() {
    return isVisible("input[type='password']")
        || bodyText().contains("login")
        || bodyText().contains("sign in");
  }

  public boolean isProductTableVisible() {
    return isVisible("table")
        || isVisible(".table")
        || isVisible(".datatable")
        || isVisible(".data-table")
        || bodyText().contains("product");
  }

  public void login(String username, String password) {
    Locator usernameField = firstVisible(
        "input[type='email']",
        "input[name='email']",
        "input[name='username']",
        "input[name='user_email']",
        "input[placeholder*='Email']",
        "input[placeholder*='email']",
        "input[placeholder*='Username']",
        "input[placeholder*='username']");
    Locator passwordField = firstVisible("input[type='password']");
    Locator submitButton = firstVisible(
        "button[type='submit']",
        "input[type='submit']",
        "button:has-text('Login')",
        "button:has-text('login')",
        "button:has-text('Sign In')",
        "button:has-text('Sign in')",
        "button:has-text('Log In')",
        "button:has-text('Log in')");

    if (usernameField == null || passwordField == null || submitButton == null) {
      throw new IllegalStateException("Could not locate the admin login form.");
    }

    usernameField.fill(username);
    passwordField.fill(password);
    submitButton.click();
    page.waitForLoadState(LoadState.DOMCONTENTLOADED);
  }

  private Locator firstVisible(String... selectors) {
    for (String selector : selectors) {
      Locator locator = page.locator(selector);
      if (locator.count() > 0 && locator.first().isVisible()) {
        return locator.first();
      }
    }
    return null;
  }

  private boolean isVisible(String selector) {
    Locator locator = page.locator(selector);
    return locator.count() > 0 && locator.first().isVisible();
  }

  private String bodyText() {
    return page.locator("body").innerText().toLowerCase(Locale.ROOT);
  }
}
