package pageobject.harvest.harvestDashboard;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import data.mamikos.Mamikos;
import utilities.PlaywrightHelpers;
import com.microsoft.playwright.Locator;

public class LoginHarvestDashboardPO {

    private Page page;
    private PlaywrightHelpers playwright;

    Locator emailField;
    Locator passwordField;
    Locator loginButton;

    public LoginHarvestDashboardPO(Page page){
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        emailField = page.getByPlaceholder("Masukkan email Mamikos");
        passwordField = page.getByPlaceholder("Masukkan Password");
        loginButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"));
    }

    /**
     * Navigates to Harvest Dahsboard Login Page
     */
    public void navigateToHarvestDashboardLoginPage(){
        playwright.navigateTo(Mamikos.URL + "/leads/harvest/auth", 30000.0, LoadState.LOAD);
    }

    /**
     * Fills Username
     * @param username
     */
    public void fillsUsername(String username) {
        playwright.fill(emailField, username);
    }

    /**
     * Fills Password
     * @param password
     */
    public void fillsPassword(String password) {
        playwright.fill(passwordField, password);
    }

    /**
     * Clicks on Login Button
     */
    public void clicksLogin() {
        playwright.clickOn(loginButton);
        page.waitForLoadState();
    }
}
