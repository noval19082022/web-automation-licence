package pageobject.owner;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import pageobject.common.LoginPO;

public class OwnerLoginPO extends LoginPO {

    Locator profileOwnerBtn;

    public OwnerLoginPO(Page page) {
        super(page);
        this.page = page;
        profileOwnerBtn = page.locator(".c-mk-header__username");
    }

    /**
     * Fill owner password
     * @param password password string type
     * @return OwnerLoginPO class
     */
    @Override
    public OwnerLoginPO fillPassword(String password) {
        playwright.fill(passwordInput, password);
        return this;
    }

    /**
     * Fill phone number
     * @param phoneNumber phone number string type
     * @return OwnerLoginPO
     */
    @Override
    public OwnerLoginPO fillPhoneNumber(String phoneNumber) {
        playwright.fill(phoneNumberInput, phoneNumber);
        return this;
    }

    /**
     * Click on login button for owner
     * @return OwnerDashboardPO
     */
    public OwnerDashboardPO clickOnOwnerLoginButton() {
        playwright.clickOn(loginBtn);
        playwright.waitTillPageLoaded();
        // Wait for owner dashboard to be ready (profile button indicates successful login)
        playwright.waitTillLocatorIsVisible(profileOwnerBtn, 10000.0);
        return new OwnerDashboardPO(page);
    }

    /**
     * User Log out as a Owner
     */
    public void logoutAsOwner() {
        playwright.clickOn(profileOwnerBtn);
        playwright.clickOnText("Logout ");
    }

    public void clickOnLoginButtonMA() {
        playwright.clickOn(loginBtn);

    }
}
