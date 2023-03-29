package pageobject.pms;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginPMSPO {
    private Page page;

    Locator emailField;
    Locator passwordField;
    Locator loginButton;

    public LoginPMSPO(Page page){
        this.page = page;
        emailField = page.getByPlaceholder("Email");
        passwordField = page.getByPlaceholder("Password");
        loginButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"));
    }

    /**
     * fill username field in login page
     * @param username
     */
    public void fillUsername(String username) {
        emailField.fill(username);
    }

    /**
     * fill password field in login page
     * @param password
     */
    public void fillPassword(String password) {
        passwordField.fill(password);
    }

    /**
     * click login button in login page
     */
    public void clickLogin() {
        loginButton.click();
    }
}
