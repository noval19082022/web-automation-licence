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
        passwordInput.fill(password);
        return new OwnerLoginPO(page);
    }

    /**
     * Fill phone number
     * @param phoneNumber phone number string type
     * @return OwnerLoginPO
     */
    @Override
    public OwnerLoginPO fillPhoneNumber(String phoneNumber) {
        phoneNumberInput.fill(phoneNumber);
        return new OwnerLoginPO(page);
    }

    /**
     * Click on login button
     * @return OwnerDashboardPO
     */
    @Override
    public OwnerDashboardPO clickOnLoginButton() {
        loginBtn.click();
        page.waitForLoadState(LoadState.LOAD);
        page.waitForTimeout(5000);
        return new OwnerDashboardPO(page);
    }

    /**
     * User Log out as a Owner
     */
    public void logoutAsOwner() {
        profileOwnerBtn.click();
        playwright.clickOnText("Logout ");
    }

    public void clickOnLoginButtonMA() {
        playwright.clickOn(loginBtn);

    }
}
