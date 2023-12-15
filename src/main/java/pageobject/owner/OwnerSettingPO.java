package pageobject.owner;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;
import lombok.Setter;
import utilities.PlaywrightHelpers;

public class OwnerSettingPO {
    private Page page;
    private PlaywrightHelpers playwright;
    @Setter @Getter private String nameOwner;

    Locator ubahDataPribadi;
    Locator phoneNumberField;
    Locator submitButton;
    Locator messageValidation;
    Locator messageValidationButton;
    Locator otpPopUp;
    Locator resendCode;
    Locator nameOwnerField;
    Locator username;
    Locator profilePicture;
    Locator accountSettingsButton;

    public OwnerSettingPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);

        phoneNumberField = page.locator("[name='phone_number']");
        submitButton = page.locator(".bg-c-button");
        messageValidation = page.locator(".swal2-content");
        messageValidationButton = page.locator("//button[@class='swal2-confirm swal2-styled']");
        resendCode = page.locator("//button[contains(@class,'resend-button')]");
        otpPopUp = page.locator(".bg-c-pin");
        nameOwnerField = page.locator("[name='name']");
        username = page.locator("//p[@class='navbar-owner-dashboard__username bg-c-text bg-c-text--body-2']");
        profilePicture = page.locator("//i[@class='mdi mdi-account-circle mdi-48px']");
        accountSettingsButton = page.getByText("Setelan Akun");
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
        playwright.clearText(phoneNumberField);
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

    /**
     * Input Nama Lengkap owner
     * @param text
     */
    public void inputNameOwner(String text) {
        playwright.forceFill(nameOwnerField, text);
        setNameOwner(text);
    }

    /**
     * Get username on navbar
     * @return username
     */
    public String getUsername() {
        return playwright.getText(username);
    }

    /**
     * Verify profile picture displayed or not
     * @return boolean (true, false)
     *
     */
    public boolean isProfilePictureDisplayed() {
        playwright.waitTillLocatorIsVisible(profilePicture, 3000.0);
        return playwright.isLocatorVisibleAfterLoad(profilePicture, 3000.0);
    }

    /**
     * Click pengaturan akun
     * Uncheck rekomendasi via email,notifikasi via chat,notifikasi kos via SMS
     * @param textDescription
     *
     */
    public void clickOnPengaturanAkun(String textDescription) {
        playwright.waitTillPageLoaded();
        Locator element = page.locator("label").filter(new Locator.FilterOptions().setHasText("checkmark" + textDescription)).locator("svg");
        playwright.clickOn(element);
    }

    /**
     * Click / check pengaturan akun
     * @param textDescription
     */
    public void checkPengaturanAkun(String textDescription) {
        playwright.waitTillPageLoaded();
        Locator element = page.locator("label").filter(new Locator.FilterOptions().setHasText("checkmark" + textDescription)).locator("span");
        playwright.clickOn(element);
    }

    /**
     * Delete nama lengkap owner
     *
     *
     */
    public void clearNamaLengkapOwner() {
        playwright.clearText(nameOwnerField);
    }

    /**
     * Click profile picture and then click Setelan Akun
     *
     *
     */
    public void clickOnSettingAccount() {
        playwright.clickOn(profilePicture);
        playwright.clickOn(accountSettingsButton);
    }
}