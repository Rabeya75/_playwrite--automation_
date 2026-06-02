package com.quickybd.qa.playwright.pages;

import com.microsoft.playwright.AriaRole;
import com.microsoft.playwright.Page;
import java.util.regex.Pattern;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class FrontendHomePage {
  private final Page page;
  private final String frontendUrl;

  public FrontendHomePage(Page page, String frontendUrl) {
    this.page = page;
    this.frontendUrl = frontendUrl;
  }

  public void open() {
    page.navigate(frontendUrl);
    page.waitForLoadState(com.microsoft.playwright.options.LoadState.DOMCONTENTLOADED);
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

  public void assertTitleLooksCorrect() {
    assertThat(page).hasTitle(Pattern.compile("Quicky BD", Pattern.CASE_INSENSITIVE));
  }

  private void assertVisibleText(String text) {
    assertThat(page.getByText(text, new Page.GetByTextOptions().setExact(true))).isVisible();
  }

  private void assertVisibleLink(String text) {
    assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(text))).isVisible();
  }
}
