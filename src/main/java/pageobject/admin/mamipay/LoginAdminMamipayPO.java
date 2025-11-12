package pageobject.admin.mamipay;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pageobject.common.LoginPO;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

public class LoginAdminMamipayPO extends LoginPO {
    private PlaywrightHelpers playwright;
    private LocatorHelpers locator;
    Locator emailInput;
    public LoginAdminMamipayPO(Page page) {
        super(page);
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.locator = new LocatorHelpers(page);
        emailInput = page.getByPlaceholder("Email Address");
        passwordInput = page.getByPlaceholder("Password");
        loginBtn = playwright.locatorByRoleSetName(locator.roleButton, "Login");
    }

    /**
     * Fill input email
     * @param email email String data type
     */
    public void fillEmail(String email) {
        playwright.waitTillLocatorIsVisible(emailInput, 30000.0);
        playwright.fill(emailInput, email);
    }

    /**
     * Fill password for login admin mamipay
     * @param password password String
     * @return LoginAdminMamipayPO class
     */
    public LoginAdminMamipayPO fillPassword(String password) {
        playwright.fill(passwordInput, password);
        return this;
    }

    /**
     * Click on login button for admin mamipay
     * @return AdminMamipayDashboardPO class
     */
    public AdminMamipayDashboardPO clickOnAdminMamipayLoginButton() {
        playwright.clickOn(loginBtn);
        return new AdminMamipayDashboardPO(page);
    }
}
