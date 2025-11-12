package pageobject.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class LoginPO {
    // Timeout constants
    private static final double PROFILE_BUTTON_WAIT_TIMEOUT = 5_000.0;
    private static final int FB_CONTINUE_WAIT_MS = 5_000;

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
    private Locator profileTenantButton;
    private Locator keluarButton;
    private Locator profilPictureTenant;
    private Locator profilePictureNull;
    private Locator continueFBLogin;
    private Locator loginPopUpTitle;


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
        // More robust locator using role-based selection for Facebook continue button
        continueFBLogin = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue"));
        loginPopUpTitle = page.getByText("Masuk ke Mamikos");
    }

    /**
     * Click on pencari kost button
     *
     * @return LoginPO class
     */
    public synchronized LoginPO clickOnPencariKostButton() {
        playwright.clickOn(pencariKostBtn);
        return this;
    }

    /**
     * Click on pemilik kost button
     *
     * @return LoginPO class
     */
    public LoginPO clickOnPemilikKostButton() {
        playwright.clickOn(pemilikKostBtn);
        return this;
    }


    /**
     * Check if login pop up is appear
     *
     * @return true if both Facebook and Google login buttons are visible
     */
    public boolean checkLoginPopUpFromFavoritePage() {
        return playwright.waitTillLocatorIsVisible(FBLoginTenantFav)
                && playwright.waitTillLocatorIsVisible(googleLoginTenantFav);
    }

    /**
     * Click on Sign in With Facebook button
     *
     * @return LoginPO class
     */
    public synchronized LoginPO clickOnSignInWithFacebookButton() {
        playwright.clickOn(signInWithFBtBtn);
        return this;
    }




    /**
     * Verify that login owner pop up is appear
     *
     * @return Boolean true if login owner popup is visible
     */
    public Boolean popUpOwnerLogin() {
        return playwright.waitTillLocatorIsVisible(loginOwnerPopUp);
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
     * Check if login popup is displayed
     *
     * @return Boolean true if login popup is visible
     */
    public Boolean popUpLogin() {
        return playwright.waitTillLocatorIsVisible(loginPopUpTitle);
    }

    /**
     * User Log out as a Tenant
     */
    public void logoutAsTenant() {
        playwright.clickOn(profileTenantButton);
        playwright.clickOn(keluarButton);
    }


    /**
     * Try to Logout from mamikos
     */
    public void tryToLogoutFromMamikos() {
        if (playwright.waitTillLocatorIsVisible(profileTenantButton, PROFILE_BUTTON_WAIT_TIMEOUT)) {
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
     * Get dynamic locator for paragraph containing text
     *
     * @param text Text to search for in paragraph
     * @return Locator for paragraph containing the specified text
     */
    private Locator getParagraphByText(String text) {
        return page.locator("//p[contains(., '" + text + "')]");
    }

    /**
     * Get login error messages text
     *
     * @param error Error message text to search for
     * @return string error message text
     */
    public String getLoginErrorMessagesText(String error){
        Locator errorLocator = getParagraphByText(error);
        playwright.waitTillLocatorIsVisible(errorLocator);
        return playwright.getText(errorLocator);
    }

    /**
     * Get Login Title Pop Up Text
     *
     * @param text text to search for in title
     * @return string title text
     */
    public String getLoginTitlePopUpText(String text){
        return playwright.getText(getParagraphByText(text));
    }

    /**
     * Get Login Subtitle Pop Up Text
     *
     * @param text text to search for in subtitle
     * @return string subtitle text
     */
    public String getLoginSubtitleText(String text){
        return playwright.getText(getParagraphByText(text));
    }

    /**
     * Check if popup title text appeared
     *
     * @param text text to search for in title
     * @return true if title is visible
     */
    public boolean isPopupTitleTextAppeared(String text){
        return playwright.waitTillLocatorIsVisible(getParagraphByText(text));
    }

    /**
     * Check if popup subtitle text appeared
     *
     * @param text text to search for in subtitle
     * @return true if subtitle is visible
     */
    public Boolean isPopupSubtitleTextAppeared(String text){
        return playwright.waitTillLocatorIsVisible(getParagraphByText(text));
    }

    /**
     * Check if profile picture is not null (default profile icon visible)
     *
     * @return Boolean true if default profile picture is visible
     */
    public Boolean isProfilePictureNotNull(){
        return playwright.waitTillLocatorIsVisible(profilePictureNull);
    }

    /**
     * Click on continue button on facebook login
     */
    public void clickOnContinueFBButton() {
        playwright.clickOn(continueFBLogin);
        playwright.hardWait(FB_CONTINUE_WAIT_MS);
    }

    /**
     * Wait for password input form to be available
     * @return LoginPO class
     */
    public synchronized LoginPO waitForPasswordInput() {
        playwright.waitFor(passwordInput);
        return this;
    }

    /**
     * Fill password
     * @param password password string type
     * @return LoginPO class
     */
    public synchronized LoginPO fillPassword(String password) {
        playwright.fill(passwordInput, password);
        return this;
    }

    /**
     * Fill phone number
     * @param phoneNumber phone number string type
     * @return LoginPO class
     */
    public synchronized LoginPO fillPhoneNumber(String phoneNumber) {
        playwright.fill(phoneNumberInput, phoneNumber);
        return this;
    }

    /**
     * Fill email address for Facebook login
     * @param emailAddress email address string
     * @return LoginPO class
     */
    public synchronized LoginPO fillEmailAddress(String emailAddress) {
        playwright.fill(emailAddressFBInput, emailAddress);
        return this;
    }

    /**
     * Fill password for Facebook login
     * @param passwordFB Facebook password string
     * @return LoginPO class
     */
    public synchronized LoginPO fillPasswordFacebook(String passwordFB) {
        playwright.fill(passwordFBInput, passwordFB);
        return this;
    }

    /**
     * Click on login button
     * @return LoginPO class
     */
    public synchronized LoginPO clickOnLoginButton() {
        playwright.clickOn(loginBtn);
        return this;
    }

    /**
     * Click on login Facebook button
     * @return LoginPO class
     */
    public synchronized LoginPO clickOnLoginFacebookButton() {
        playwright.clickOn(loginFacebookBtn);
        playwright.hardWait(2000);
        return this;
    }
}
