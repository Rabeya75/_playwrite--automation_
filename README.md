# QuickyBD Project

This repository now includes a dedicated Java QA package for QuickyBD.

## Included

- Manual QA plan: `quickybd-qa-java/docs/manual-test-plan.md`
- Selenium Java suite: `quickybd-qa-java/selenium`
- Playwright Java suite: `quickybd-qa-java/playwright`
- GitHub Actions workflow: `.github/workflows/quickybd-qa-java.yml`

## Quick start

```bash
mvn -f quickybd-qa-java/pom.xml test
```

If you want Playwright browser binaries installed manually first:

```bash
mvn -f quickybd-qa-java/playwright/pom.xml exec:java -Dexec.classpathScope=test -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install chromium"
```
