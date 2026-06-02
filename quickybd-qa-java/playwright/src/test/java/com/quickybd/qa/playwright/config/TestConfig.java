package com.quickybd.qa.playwright.config;

public final class TestConfig {
  private static final String DEFAULT_FRONTEND_URL = "https://quickybd.com/";
  private static final String DEFAULT_BACKEND_URL = "https://be.quickybd.com/admin/product/show";

  private TestConfig() {
  }

  public static String frontendUrl() {
    return read("QUICKYBD_FRONTEND_URL", "quickybd.frontendUrl", DEFAULT_FRONTEND_URL);
  }

  public static String backendUrl() {
    return read("QUICKYBD_BACKEND_URL", "quickybd.backendUrl", DEFAULT_BACKEND_URL);
  }

  public static String adminUsername() {
    return read("QUICKYBD_ADMIN_USERNAME", "quickybd.adminUsername", "");
  }

  public static String adminPassword() {
    return read("QUICKYBD_ADMIN_PASSWORD", "quickybd.adminPassword", "");
  }

  public static boolean hasAdminCredentials() {
    return !adminUsername().isBlank() && !adminPassword().isBlank();
  }

  private static String read(String environmentName, String propertyName, String defaultValue) {
    String propertyValue = System.getProperty(propertyName);
    if (propertyValue != null && !propertyValue.isBlank()) {
      return propertyValue;
    }

    String environmentValue = System.getenv(environmentName);
    if (environmentValue != null && !environmentValue.isBlank()) {
      return environmentValue;
    }

    return defaultValue;
  }
}
