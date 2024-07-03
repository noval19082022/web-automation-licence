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
    private Locator signInWithFBtBtn;
    protected Locator emailAddressFBInput;
    protected Locator passwordFBInput;
    protected Locator loginFacebookBtn;
    private Locator loginOwnerPopUp;
    private Locator backButtonLogin;
    private Locator closeBtn;
    Locator profileTenantButton;
    Locator keluarButton;
    Locator profilPictureTenant;
    Locator profilePictureNull;

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
        this.signInWithFBtBtn = page.getByTestId("loginFacebookButton");
        this.emailAddressFBInput = page.getByPlaceholder("Email address or phone number");
        this.passwordFBInput = page.getByPlaceholder("Password");
        loginFacebookBtn = page.locator("#loginbutton");
        this.loginOwnerPopUp = page.getByText("Login Pemilik Kos");
        this.backButtonLogin = page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText("back"));
        this.closeBtn = page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText("close"));
        profileTenantButton = page.getByAltText("User Photo");
        keluarButton = page.getByTestId("exitButton");
        profilPictureTenant = page.locator("//img[@alt='User Photo']");
        profilePictureNull = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("mamikos").setExact(true));
    }

    /**
     * Click on pencari kost button
     *
     * @return TenantLoginPO class
     */
    public synchronized TenantLoginPO clickOnPencariKostButton() {
        pencariKostBtn.click();
        return new TenantLoginPO(page);
    }

    /**
     * Click on pemilik kost button
     *
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
     *
     * @return
     */
    public boolean checkLoginPopUpFromFavoritePage() {
        return FBLoginTenantFav.isVisible()
                && googleLoginTenantFav.isVisible();
    }

    /**
     * Click on Sign in With Facebook button
     *
     * @return TenantLoginPO class
     */
    public synchronized TenantLoginPO clickOnSignInWithFacebookButton() {
        signInWithFBtBtn.click();
        return new TenantLoginPO(page);
    }

    protected Object fillEmailAddress(String phoneNumber) {
        return new Object();
    }

    protected Object fillPasswordFacebook(String passwordFB) {
        return new Object();
    }

    protected Object clickOnLoginFacebookButton() {
        return new Object();
    }

    /**
     * verify that login owner pop up is appear
     *
     * @return Boolean
     */
    public Boolean popUpOwnerLogin() {
        return loginOwnerPopUp.isVisible();
    }

    /**
     * Click back Pop up Login
     */
    public void clickBackOnPopUpLogin() {
        playwright.clickOn(backButtonLogin);
    }

    /**
     * Click Close on Pop up Login
     */
    public void clickCloseOnPopUpLogin() {
        playwright.clickOn(closeBtn);
    }

    /**
     * Click back Pop up Login
     *
     * @return Boolean
     */
    public Boolean popUpLogin() {
        return page.getByText("Masuk ke Mamikos").isVisible();
    }

    /**
     * User Log out as a Tenant
     */
    public void logoutAsTenant() {
        profileTenantButton.click();
        keluarButton.click();
    }


    /**
     * Try to Logout from mamikos
     */
    public void tryToLogoutFromMamikos() {
        if (playwright.waitTillLocatorIsVisible(profileTenantButton, 5_000.0)) {
            playwright.clickOn(profileTenantButton);
            playwright.clickOn(keluarButton);
        }
    }

    /**
     * Tenant Profile Picture is  Displayed
     *
     * @return Tenant Profile Picture
     */
    public boolean isTenantProfilePictureDisplayed() {
        return playwright.waitTillLocatorIsVisible(profilPictureTenant);
    }

    /**
     * Tenant clear text password
     */
    public void clearTextPassword(){
        playwright.clearText(passwordInput);
    }

    /**
     * Tenant clear text phone number
     */
    public void clearTextPhoneNumber(){
        playwright.clearText(phoneNumberInput);
    }

    /**
     * Get login error messages text
     * @return string
     */
    public String getLoginErrorMessagesText(String error){
        playwright.waitTillLocatorIsVisible(page.locator("//p[contains(., '" + error + "')]"));
        return playwright.getText(page.locator("//p[contains(., '" + error + "')]"));
    }

    /**
     * Get Login Title Pop Up Text
     * @param text text
     * @return string
     */
    public String getLoginTitlePopUpText(String text){
        return playwright.getText(page.locator("//p[contains(., '" + text + "')]"));
    }

    /**
     * Get Login Subtitle Pop Up Text
     * @param text text
     * @return string
     */
    public String getLoginSubtitleText(String text){
        return playwright.getText(page.locator("//p[contains(., '" + text + "')]"));
    }

    /**
     * Is Pop up title text appeared?
     * @param text text
     * @return true or false
     */
    public boolean isPopupTitleTextAppeared(String text){
        return playwright.waitTillLocatorIsVisible(page.locator("//p[contains(., '" + text + "')]"));

    }

    /**
     * Is Pop up subtitle text appeared?
     * @param text text
     * @return true or false
     */
    public Boolean isPopupSubtitleTextAppeared(String text){
        return playwright.waitTillLocatorIsVisible(page.locator("//p[contains(., '" + text + "')]"));
    }

    /**
     * Get Profile Picture Is Null
     */
    public Boolean isProfilePictureNotNull(){
        return profilePictureNull.isVisible();
    }
}
