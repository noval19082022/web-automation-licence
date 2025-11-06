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
    @Override
    public synchronized TenantLoginPO waitForPasswordInput() {
        playwright.waitFor(passwordInput);
        return this;
    }

    @Override
    public synchronized TenantLoginPO fillPassword(String password) {
        playwright.fill(passwordInput, password);
        return this;
    }

    @Override
    public synchronized TenantLoginPO fillPhoneNumber(String phoneNumber) {
        playwright.fill(phoneNumberInput, phoneNumber);
        return this;
    }

    /**
     * Click on login button for tenant
     * @return HomePO class
     */
    public synchronized HomePO clickOnTenantLoginButton() {
        playwright.clickOn(loginBtn);
        return new HomePO(page);
    }

    @Override
    public synchronized TenantLoginPO fillEmailAddress(String emailAddress) {
        playwright.fill(emailAddressFBInput, emailAddress);
        return this;
    }

    @Override
    public synchronized TenantLoginPO fillPasswordFacebook(String passwordFB) {
        playwright.fill(passwordFBInput, passwordFB);
        return this;
    }

    /**
     * Click on login Facebook button for tenant
     * @return HomePO class
     */
    public synchronized HomePO clickOnTenantLoginFacebookButton() {
        playwright.clickOn(loginFacebookBtn);
        playwright.hardWait(2000);
        return new HomePO(page);
    }

}
