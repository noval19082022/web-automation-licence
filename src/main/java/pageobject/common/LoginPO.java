package pageobject.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import pageobject.owner.OwnerLoginPO;
import pageobject.tenant.TenantLoginPO;
import utilities.PlaywrightHelpers;

public class LoginPO {
    protected Page page;
    protected PlaywrightHelpers playwright;
    private Locator pencariKostBtn;
    private Locator pemilikKostBtn;
    protected Locator phoneNumberInput;
    protected Locator passwordInput;
    protected Locator loginBtn;
    protected Locator FBLoginTenantFav;
    protected Locator googleLoginTenantFav;
    public LoginPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.pencariKostBtn = page.getByTestId("pencariKosButton");
        this.pemilikKostBtn = page.getByTestId("pemilikKosButton");
        this.phoneNumberInput = page.getByTestId("phoneNumberTextbox");
        this.passwordInput = page.getByTestId("passwordTextbox");
        this.loginBtn = page.getByTestId("loginButton");
        this.FBLoginTenantFav = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("ic_facebook Masuk dengan Facebook"));
        this.googleLoginTenantFav = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("ic_google Masuk dengan Google"));
    }

    /**
     * Click on pencari kost button
     * @return TenantLoginPO class
     */
    public synchronized TenantLoginPO clickOnPencariKostButton() {
        pencariKostBtn.click();
        return new TenantLoginPO(page);
    }

    /**
     * Click on pemilik kost button
     * @return OwnerLoginPO class
     */
    public OwnerLoginPO clickOnPemilikKostButton() {
        pemilikKostBtn.click();
        return new OwnerLoginPO(page);
    }

    protected Object fillPassword(String password) {
        return new Object();
    }

    protected Object fillPhoneNumber(String phoneNumber) {
        return new Object();
    }

    protected Object clickOnLoginButton() {
        return new Object();
    }

    /**
     * Check if login pop up is appear
     * @return
     */
    public boolean checkLoginPopUpFromFavoritePage() {
        return FBLoginTenantFav.isVisible()
                && googleLoginTenantFav.isVisible();
    }
}
