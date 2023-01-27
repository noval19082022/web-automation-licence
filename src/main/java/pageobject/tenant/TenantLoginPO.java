package pageobject.tenant;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import pageobject.common.HomePO;
import pageobject.common.LoginPO;

public class TenantLoginPO extends LoginPO {
    public TenantLoginPO(Page page) {
        super(page);
        this.page = page;
    }

    @Override
    public TenantLoginPO fillPassword(String password) {
        passwordInput.fill(password);
        return new TenantLoginPO(page);
    }

    @Override
    public TenantLoginPO fillPhoneNumber(String phoneNumber) {
        phoneNumberInput.fill(phoneNumber);
        return new TenantLoginPO(page);
    }

    @Override
    public HomePO clickOnLoginButton() {
        loginBtn.click();
        page.waitForLoadState(LoadState.LOAD);
        return new HomePO(page);
    }
}
