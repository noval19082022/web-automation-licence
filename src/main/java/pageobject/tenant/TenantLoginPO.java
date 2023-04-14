package pageobject.tenant;

import com.microsoft.playwright.Page;
import pageobject.common.HomePO;
import pageobject.common.LoginPO;

public class TenantLoginPO extends LoginPO {
    public TenantLoginPO(Page page) {
        super(page);
        this.page = page;
    }

    /**
     * wait for password input form to be available
     * @return TenantLoginPO class
     */
    public synchronized TenantLoginPO waitForPasswordInput() {
        passwordInput.waitFor();
        return new TenantLoginPO(page);
    }

    @Override
    public synchronized TenantLoginPO fillPassword(String password) {
        passwordInput.fill(password);
        return new TenantLoginPO(page);
    }

    @Override
    public synchronized TenantLoginPO fillPhoneNumber(String phoneNumber) {
        phoneNumberInput.fill(phoneNumber);
        return new TenantLoginPO(page);
    }

    @Override
    public synchronized HomePO clickOnLoginButton() {
        loginBtn.click();
        return new HomePO(page);
    }

    @Override
    public synchronized TenantLoginPO fillEmailAddress(String emailAddress) {
        emailAddressFBInput.fill(emailAddress);
        return new TenantLoginPO(page);
    }

    @Override
    public synchronized TenantLoginPO fillPasswordFacebook(String passwordFB) {
        passwordFBInput.fill(passwordFB);
        return new TenantLoginPO(page);
    }

    @Override
    public synchronized HomePO clickOnLoginFacebookButton() {
        loginFacebookBtn.click();
        return new HomePO(page);
    }
}
