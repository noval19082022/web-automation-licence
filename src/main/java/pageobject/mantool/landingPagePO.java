package pageobject.mantool;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class landingPagePO {
    private Page page;
    private PlaywrightHelpers playwright;

    private Locator loginAgenButton;
    private Locator noHandphoneField;
    private Locator passwordField;
    private Locator loginButton;
    private Locator profileButton;
    private Locator profileMenuText;
    private Locator keluarButton;
    private Locator onboardingButton;

    public landingPagePO(Page page){
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);

        loginAgenButton = page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Login Agen").setExact(true));
        loginButton = page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Login").setExact(true));
        noHandphoneField = page.getByPlaceholder("Nomor Handphone");
        passwordField = page.getByPlaceholder("Masukkan Password");
        profileButton = page.locator(".bg-c-avatar");
        profileMenuText = page.locator("li p");
        keluarButton = page.locator("a").filter(new Locator.FilterOptions().setHasText("Keluar"));
        onboardingButton = page.locator("a").filter(new Locator.FilterOptions().setHasText("Onboarding"));
    }

    /**
     * Login to Mantool
     * @param phoneNumber
     * @param password
     */
    public void loginAgenMantool(String phoneNumber, String password) {
        playwright.clickOn(loginAgenButton);
        playwright.fill(noHandphoneField,phoneNumber);
        playwright.fill(passwordField,password);
        playwright.clickOn(loginButton);
    }

    /**
     * Click Profile avatar in top right corner
     */
    public void clickProfile() {
        playwright.clickOn(profileButton);
    }

    /**
     * Get profile menu text
     * @param i index
     * @return String
     */
    public String getProfileMenu(int i) {
        return playwright.getText(profileMenuText.nth(i));
    }

    /**
     * Logout Mantool
     */
    public void logoutMantool() {
        playwright.clickOn(profileButton);
        playwright.clickOn(keluarButton);
    }

    /**
     * Go to Onboarding page
     */
    public void goToOnboarding() {
        playwright.clickOn(profileButton);
        playwright.clickOn(onboardingButton);
    }
}
