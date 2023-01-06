package pageobject.tenant;

import com.microsoft.playwright.Page;
import pageobject.common.HeaderPO;
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

    public HeaderPO clickOnLoginButton() {
        loginBtn.click();
        return new HeaderPO(page);
    }
}
