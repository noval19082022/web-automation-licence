package pageobject.owner;

import com.microsoft.playwright.Page;
import pageobject.common.LoginPO;

public class OwnerLoginPO extends LoginPO {
    public OwnerLoginPO(Page page) {
        super(page);
        this.page = page;
    }

    @Override
    public OwnerLoginPO fillPassword(String password) {
        passwordInput.fill(password);
        return new OwnerLoginPO(page);
    }

    @Override
    public OwnerLoginPO fillPhoneNumber(String phoneNumber) {
        phoneNumberInput.fill(phoneNumber);
        return new OwnerLoginPO(page);
    }

    @Override
    public OwnerDashboardPO clickOnLoginButton() {
        loginBtn.click();
        return new OwnerDashboardPO(page);
    }
}
