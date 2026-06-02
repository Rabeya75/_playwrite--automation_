# QuickyBD QA Java Project

This project packages a manual QA plan plus Java automation for:

- Frontend: `https://quickybd.com/`
- Backend: `https://be.quickybd.com/admin/product/show`

## What is included

- `docs/manual-test-plan.md` - manual test strategy and test matrix
- `selenium/` - Selenium + JUnit 5 smoke/regression examples
- `playwright/` - Playwright Java + JUnit 5 smoke/regression examples

## Requirements

- Java 17 or newer
- Maven 3.9 or newer
- Google Chrome or Chromium for Selenium runs
- Playwright Chromium browser binaries for Playwright runs

## Optional environment variables

- `QUICKYBD_FRONTEND_URL` - defaults to `https://quickybd.com/`
- `QUICKYBD_BACKEND_URL` - defaults to `https://be.quickybd.com/admin/product/show`
- `QUICKYBD_ADMIN_USERNAME` - optional admin login username
- `QUICKYBD_ADMIN_PASSWORD` - optional admin login password

## Local admin login setup

Set the admin credentials in your shell before running the authenticated backend test.

PowerShell:

```powershell
$env:QUICKYBD_ADMIN_USERNAME="your-admin-username"
$env:QUICKYBD_ADMIN_PASSWORD="your-admin-password"
mvn -f quickybd-qa-java/pom.xml test
```

You can also copy `quickybd-qa-java/.env.example` to `.env` for reference while keeping secrets out of Git.

## Run the project

Install Playwright Chromium once:

```bash
mvn -f quickybd-qa-java/playwright/pom.xml exec:java -Dexec.classpathScope=test -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install chromium"
```

Run both Java modules:

```bash
mvn -f quickybd-qa-java/pom.xml test
```

Run Selenium only:

```bash
mvn -f quickybd-qa-java/selenium/pom.xml test
```

Run Playwright only:

```bash
mvn -f quickybd-qa-java/playwright/pom.xml test
```

## Notes

- The backend smoke test is designed to work even when the admin area is protected.
- If admin credentials are provided, the authenticated product-list check will run too.
