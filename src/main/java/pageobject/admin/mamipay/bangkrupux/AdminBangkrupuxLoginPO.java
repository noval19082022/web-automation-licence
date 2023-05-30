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
        emailInput.fill(email);
    }

    /**
     * Fill owner password
     * @param password password string type
     * @return AdminBangkrupuxLoginPO class
     */
    @Override
    public AdminBangkrupuxLoginPO fillPassword (String password){
        passwordInput.fill(password);
        return new AdminBangkrupuxLoginPO(page);
    }

    /**
     * Click on login button admin mamipay
     * @return AdminMamipayDashboardPO class
     */
    @Override
    public AdminBangkrupuxLoginPO clickOnLoginButton() {
        loginBtn.click();
        return new AdminBangkrupuxLoginPO(page);
    }

    /**
     * User Log out as a Mamikos Bangkrupux Admin
     */
    public void logoutAsMamikosBangkrupuxAdmin() {
        profileMamikosBangkrupuxAdminBtn.click();
        playwright.clickOnText("Sign Out ");
    }
}
