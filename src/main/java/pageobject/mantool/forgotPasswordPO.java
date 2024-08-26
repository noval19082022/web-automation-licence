package pageobject.mantool;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class forgotPasswordPO {
    private Page page;
    private PlaywrightHelpers playwright;

    private Locator pageTitleText;
    private Locator noHandphoneField;
    private Locator verifikasiButton;
    private Locator errorMessagePhoneNumberText;

    public forgotPasswordPO(Page page){
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);

        pageTitleText = page.locator(".bg-c-text--heading-4");
        noHandphoneField = page.locator(".bg-c-input__field");
        verifikasiButton = page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Verifikasi").setExact(true));
        errorMessagePhoneNumberText = page.locator(".bg-c-field__message");
    }

    /**
     * Set phone number in forgot password mantool
     * @param phone agen phone number
     */
    public void setPhoneNumberForgotPassword(String phone) {
        playwright.clearText(noHandphoneField);
        playwright.fillCharacterByCharacter(noHandphoneField,phone,200.0);
    }

    /**
     * Get phone number forgot password mantool
     * @return String phone number
     */
    public String getPhoneNumber() {
        return playwright.getInputValue(noHandphoneField);
    }

    /**
     * Check verifikasi button disable or not
     * @return boolean
     */
    public boolean isVerifikasiStatusDisable() {
        return playwright.isButtonDisable(verifikasiButton);
    }

    /**
     * Check forgot password title visible or not
     * @return boolean
     */
    public boolean isForgotPasswordPage() {
        return playwright.isLocatorVisibleAfterLoad(pageTitleText,5000.0);
    }

    /**
     * click verifikasi button
     */
    public void clickVerifikasiButton() {
        playwright.clickOn(verifikasiButton);
    }

    /**
     * Get error message from phone number forgot password
     * @return String
     */
    public String getForgotPasswordMantoolErrorMessage() {
        return playwright.getText(errorMessagePhoneNumberText);
    }

    public String getTitlePage() {
        return playwright.getText(pageTitleText);
    }
}
