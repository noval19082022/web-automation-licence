package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import pageobject.common.LoginPO;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

public class AdminBangkrupuxLoginPO extends LoginPO {
    private PlaywrightHelpers playwright;
    private LocatorHelpers locator;
    Locator emailInput;
    Locator profileMamikosBangkrupuxAdminBtn;

    public AdminBangkrupuxLoginPO(Page page) {
        super(page);
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.locator = new LocatorHelpers(page);
        emailInput = page.getByPlaceholder("Phone Number");
        passwordInput = page.getByPlaceholder("Password");
        loginBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign me in"));
        profileMamikosBangkrupuxAdminBtn = page.locator(".dropdown-toggle");

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
     * Fill owner password
     * @param password password string type
     * @return AdminBangkrupuxLoginPO class
     */
    public AdminBangkrupuxLoginPO fillPassword (String password){
        playwright.fill(passwordInput, password);
        return this;
    }

    /**
     * Click on login button for bangkrupux admin
     * @return AdminBangkrupuxLoginPO class
     */
    public AdminBangkrupuxLoginPO clickOnBangkrupuxLoginButton() {
        playwright.clickOn(loginBtn);
        return this;
    }

    /**
     * User Log out as a Mamikos Bangkrupux Admin
     */
    public void logoutAsMamikosBangkrupuxAdmin() {
        playwright.clickOn(profileMamikosBangkrupuxAdminBtn);
        playwright.clickOnText("Sign Out ");
    }
}
