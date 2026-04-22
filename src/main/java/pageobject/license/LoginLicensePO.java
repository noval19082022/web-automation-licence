package pageobject.license;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;

public class LoginLicensePO {

    private Page page;
    private PlaywrightHelpers playwright;

    Locator usernameField;
    Locator passwordField;
    Locator loginButton;

    public LoginLicensePO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        usernameField = page.locator("#username");
        passwordField = page.locator("#password");
        loginButton = page.locator("#btnLogin");
    }

    /**
     * Navigate to License sign in page
     * @param url the license sign in URL
     */
    public void navigateToLicenseLoginPage(String url) {
        playwright.navigateTo(url, 30000.0);
    }

    /**
     * Fill username field
     * @param username username string
     */
    public void fillUsername(String username) {
        playwright.fill(usernameField, username);
    }

    /**
     * Fill password field
     * @param password password string
     */
    public void fillPassword(String password) {
        playwright.fill(passwordField, password);
    }

    /**
     * Click on login/sign in button
     */
    public void clickSignIn() {
        playwright.clickOn(loginButton);
        page.waitForLoadState();
    }
}
