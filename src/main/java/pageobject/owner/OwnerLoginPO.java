package pageobject.owner;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import pageobject.common.LoginPO;

public class OwnerLoginPO extends LoginPO {
    public OwnerLoginPO(Page page) {
        super(page);
        this.page = page;
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
}
