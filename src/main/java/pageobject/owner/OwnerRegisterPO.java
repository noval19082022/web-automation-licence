package pageobject.owner;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

public class OwnerRegisterPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private LocatorHelpers locatorHelpers;
    private Locator pemilikKostButton;
    Locator registerSekarangButton;
    Locator ButtonDaftar;
    Locator nameInputText;
    Locator phoneInputText;
    Locator emailInputText;
    Locator passwordInputText;
    Locator passwordEyeButton;
    Locator passwordConfirmationInputText;
    Locator emailTittle;
    Locator profilePictureNull;
    Locator profilPictureNotNull;

    public OwnerRegisterPO(Page page){
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.locatorHelpers = new LocatorHelpers(page);
        this.pemilikKostButton = page.getByTestId("pemilikKosButton");
        this.registerSekarangButton = page.getByTestId("registerButton");
        this.ButtonDaftar = page.locator(".registration-form__submit-button");
        this.nameInputText = page.getByTestId("fullnameTextbox");
        this.phoneInputText = page.getByTestId("phoneNumberTextbox");
        this.passwordInputText = page.getByTestId("passwordTextbox");
        this.passwordEyeButton = page.getByRole(AriaRole.BUTTON).nth(2);
        this.passwordConfirmationInputText = page.getByTestId("repeatPasswordTextbox");
        this.emailTittle = page.getByText("Email (Opsional)");
        this.emailInputText =  page.getByTestId("emailTextbox");
        this.profilePictureNull = page.locator("//i[@class='mdi mdi-account-circle mdi-48px']");
        this.profilPictureNotNull = page.locator("//img[@class='c-mk-header__avatar']");

    }

    /**
     * user as owner click pemilik kost button
     */
    public void pemilikKostLogin(){
        pemilikKostButton.click();
    }

    /**
     * user as owner click register button
     */
    public void RegisterSekarang(){
        registerSekarangButton.click();
    }

    /**
     * user as owner click Button Daftar
     * @return
     */
    public Boolean disableButtonRegister() {
        return ButtonDaftar.isDisabled();
    }

    /**
     *
     * @param name User Full Name
     * @param phone User Phone Number
     * @param email User Email
     * @param password User Password
     * @param confrimPassword
     * @throws InterruptedException
     */
    public void fillOutRegistrationFormWithoutClickRegister(String name, String phone, String email, String password, String confrimPassword) throws InterruptedException{
        nameInputText.fill(name);
        phoneInputText.fill(phone);
        emailInputText.fill(email);
        passwordInputText.fill(password);
        page.keyboard().press("Backspace");
        passwordConfirmationInputText.fill(confrimPassword);
        page.keyboard().press("Backspace");
    }

    /**
     * Get error message on form
     * @param error error messages
     * @return error message
     */
    public String getErrorMessages(String error){
        return playwright.getText(page.getByText(error));
    }

    /**
     * Get error message on form
     *
     * @return error message
     */
    public String getPasswordErrorMessages(String error){
        return playwright.getText(page.getByText(error).first());
    }

    /**
     * Get error message on form
     * @param error error messages
     * @return error message
     */
    public String getConfirmPasswordErrorMessages(String error){
        return playwright.getText(page.getByText(error).nth(1));
    }

    /**
     * Click on Password Eye Button
     * @throws InterruptedException
     */
    public void clickPasswordEyeButton() throws InterruptedException {
        passwordEyeButton.click();
    }

    /**
     * Get Password Input Text
     * @return string
     */
    public String getPasswordInputText() throws InterruptedException {
        return playwright.getInputValue(passwordInputText);
    }

    /**
     * Get Email Input Text
     * @return string
     */
    public String getEmailInputText(){
        return playwright.getInputValue(emailInputText);
    }

    /**
     * check email title is available
     * @return true if the screen is present otherwise false (
     */
    public boolean isEmailTitleAvailable(){
        return playwright.waitTillLocatorIsVisible(emailTittle);
    }

    /**
     * Get Name Input Text
     * @return string
     */
    public String getNameInputText(){
        return playwright.getInputValue(nameInputText);
    }

    /**
     * Get Profile Picture Is Null
     */
    public Boolean isProfilePictureNul (){
        playwright.clickOn( page.locator("//a[@class='c-mk-header__menu-item-link user-menu']"));
        return profilePictureNull.isVisible();
    }

    /**
     * Get Profile Picture Is Show
     */
    public Boolean isProfilePictureNotNull(){
        playwright.clickOn( page.locator("//a[@class='c-mk-header__menu-item-link user-menu']"));
        return profilPictureNotNull.isVisible();
    }
}
