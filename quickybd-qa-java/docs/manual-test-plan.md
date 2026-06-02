# QuickyBD Manual Test Plan

## 1. Purpose

Validate the customer storefront at `https://quickybd.com/` and the admin product area at `https://be.quickybd.com/admin/product/show` with a practical mix of smoke, functional, regression, and responsive checks.

## 2. Scope

### Frontend scope

- Home page rendering
- Top navigation and branding
- Merchandising sections
- Footer and policy links
- Navigation to static content pages
- Basic responsive behavior

### Backend scope

- Admin product URL accessibility
- Access control and login redirect
- Product listing visibility
- Product search, filtering, and pagination
- Product detail or edit flow
- Logout/session handling

## 3. Test approach

- Smoke tests confirm the site is reachable and the main sections load.
- Functional tests validate primary user journeys.
- Regression tests recheck the most critical pages before release.
- Responsive checks cover desktop, tablet, and mobile layouts.
- Backend checks assume the admin area may require credentials.

## 4. Entry criteria

- URLs are reachable from the test environment.
- Test accounts or credentials are available if authenticated backend testing is required.
- Browser versions for Selenium and Playwright are available.

## 5. Exit criteria

- All critical smoke cases pass.
- No open blocker defects remain in the targeted scope.
- Any skipped backend authentication cases are documented with the missing credentials note.

## 6. Manual test matrix

| ID | Area | Scenario | Expected result | Priority | Automation |
| --- | --- | --- | --- | --- | --- |
| FR-01 | Frontend | Open the home page | The page loads and the title contains Quicky BD | High | Yes |
| FR-02 | Frontend | Verify header/navigation | Categories, Vendors, and Sell on Quicky are visible | High | Yes |
| FR-03 | Frontend | Verify Shop by Category section | The section heading is visible and content renders | High | Yes |
| FR-04 | Frontend | Verify Daily Deals section | The section heading is visible and cards render | High | Yes |
| FR-05 | Frontend | Verify Featured Offers section | The section heading is visible | Medium | Yes |
| FR-06 | Frontend | Verify You Might Also Like / More to Discover | The sections render without broken layout | Medium | Yes |
| FR-07 | Frontend | Verify footer links | Blogs, About, Contact, Privacy Policy, Terms and Conditions, Shipping and Return Policy, and Sitemap are visible | High | Yes |
| FR-08 | Frontend | Open About page | The About page loads successfully | Medium | Manual |
| FR-09 | Frontend | Open Contact page | The Contact page loads successfully | Medium | Manual |
| FR-10 | Frontend | Open policy pages | Privacy Policy, Terms and Conditions, and Shipping and Return Policy open successfully | Medium | Manual |
| FR-11 | Frontend | Check mobile layout | The layout adapts correctly on a mobile viewport | High | Manual |
| BA-01 | Backend | Open admin product URL without credentials | The app redirects to login or shows access control | High | Yes |
| BA-02 | Backend | Log in with valid admin credentials | The admin session is created successfully | High | Yes |
| BA-03 | Backend | Verify product list display | The product list/table becomes visible | High | Yes |
| BA-04 | Backend | Search or filter products | The results change according to the search/filter value | Medium | Manual |
| BA-05 | Backend | Open a product detail/edit view | The requested product detail loads correctly | Medium | Manual |
| BA-06 | Backend | Logout | The session ends and access is removed | Medium | Manual |

## 7. Test data

- Anonymous storefront access: no credentials required
- Backend access: admin username and password, if available
- Product data: use a few active products with distinct names for search and filter checks

## 8. Risks and assumptions

- The backend URL may be protected, so authenticated checks are optional unless credentials are supplied.
- Dynamic product content can change, so selectors should focus on stable headings and sections.
- If the storefront changes its layout, the automation may need locator updates.

## 9. Defect reporting

- Record the URL, browser, environment, steps to reproduce, and screenshots for each defect.
- Tag issues as frontend, backend, smoke, regression, or responsive for easier triage.
