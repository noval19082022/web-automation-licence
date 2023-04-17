package pageobject.owner;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;
import com.microsoft.playwright.options.AriaRole;

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
     * @throws InterruptedException
     */
    public void fillOutRegistrationFormWithoutClickRegister(String name, String phone, String email, String password) throws InterruptedException{
        nameInputText.fill(name);
        phoneInputText.fill(phone);
        playwright.hardWait(3);
        emailInputText.fill(email);
        playwright.hardWait(3);
        passwordInputText.fill(password);
        passwordConfirmationInputText.fill(password);
    }

    /**
     * Get error message on form
     * @param error error messages
     * @return error message
     */
    public String getErrorMessages(String error){
        return playwright.getText(page.locator("//div[normalize-space()='" + error + "']"));
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
}
