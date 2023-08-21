package pageobject.owner;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;

public class OwnerSettingPO {
    private Page page;
    private PlaywrightHelpers playwright;

    Locator ubahDataPribadi;
    Locator phoneNumberField;
    Locator submitButton;
    Locator messageValidation;
    Locator messageValidationButton;
    Locator otpPopUp;
    Locator resendCode;

    public OwnerSettingPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);

        phoneNumberField = page.locator("[name='phone_number']");
        submitButton = page.locator(".bg-c-button");
        messageValidation = page.locator(".swal2-content");
        messageValidationButton = page.locator("//button[@class='swal2-confirm swal2-styled']");
        resendCode = page.locator("//button[contains(@class,'resend-button')]");
        otpPopUp = page.locator(".bg-c-pin");
    }

    /**
     * Click ubah on info pribadi (nama, nomor hp, password, email)
     * @param infoPribadi
     *
     */
    public void clickOnUbahInfoPribadi(String infoPribadi) {
        String element = null;
        switch (infoPribadi){
            case "Nama Lengkap": element = "//div[@id='ownerPersonalInfoWrapper']/div[1]//a[.='Ubah']";break;
            case "Nomor Handphone": element = "//div[@id='ownerPersonalInfoWrapper']/div[2]//a[.='Ubah']";break;
            case "Password": element = "//div[@id='ownerPersonalInfoWrapper']/div[3]//a[.='Ubah']";break;
            case "Email": element = "//div[@id='ownerPersonalInfoWrapper']/div[4]//a[.='Ubah']";break;
        }
        ubahDataPribadi = page.locator(element);
        playwright.clickOn(ubahDataPribadi);
    }

    /**
     * Hapus phone number
     *
     */
    public void clearPhoneNumber() {
        phoneNumberField.clear();
    }

    /**
     * Get attribute value of placeholder
     * @return phoneNumberField placeholder
     *
     */
    public String getTextPlaceholder() {
        return playwright.getAttributeValue(phoneNumberField, "placeholder");
    }

    /**
     * Verify simpan button disable
     * @return boolean true, false
     *
     */
    public boolean isSimpanDisable() {
        return playwright.isButtonDisable(submitButton);
    }

    /**
     * Input phone number
     * @param phoneNumber
     *
     */
    public void inputPhoneNumber(String phoneNumber) {
        playwright.forceFill(phoneNumberField, phoneNumber);
    }

    /**
     * Click simpan button
     *
     */
    public void clickOnSubmitButton() {
        playwright.clickOn(submitButton);
    }

    /** Get message validation on pop up
     *
     * @return messageValidation
     */
    public String getMessageValidation() {
        return playwright.getText(messageValidation);
    }

    /**
     * Click Ok button on pop up validasi
     *
     */
    public void clickOnConfirmValidation() {
        playwright.clickOn(messageValidationButton);
    }

    /**
     * Verify OTP pop up displayed
     * @return boolean true, false
     *
     */
    public boolean isVerifikasiNomorPopUp() {
        return playwright.waitTillLocatorIsVisible(otpPopUp, 3000.0);
    }

    /**
     * CLick on resend code
     * After waiting 60 second, resend code appear
     *
     */
    public void clickOnResendCode() {
        playwright.waitTillLocatorIsVisible(resendCode, 62000.0);
        playwright.clickOn(resendCode);
    }
}
