package pageobject.owner;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;

public class AddTenantPO {
    private Page page;
    private PlaywrightHelpers playwright;
    Locator kosNameValueTxt;
    Locator fullRoomNameTxt;
    Locator popUpFullRoomRestriction;
    Locator phoneTenantField;
    Locator roomNumberDropdown;
    Locator firstRoomNumber;

    public AddTenantPO(Page page){
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);

       kosNameValueTxt = page.locator("//div[@class='mami-field-dropdown field-item']");
       fullRoomNameTxt = page.getByPlaceholder("Pilih nomor kamar kos");
       popUpFullRoomRestriction = page.locator("add-tenant-kost-full-modal.fade.in ");
       phoneTenantField = page.locator("//input[@id='phoneNumberField']");
       roomNumberDropdown = page.getByPlaceholder("Pilih nomor kamar kos");
       firstRoomNumber = page.locator(".room-option > .mami-radio > .mami-radio-icon").first();
    }

    /**
     * Verify form title
     * @param formTitle
     * @return true if title displayed, and false if title not displayed
     *
     */
    public boolean getFormTitle(String formTitle) {
        return playwright.isTextDisplayed(formTitle);
    }

    /**
     * Verify selected kos name on form add tenant
     * @return kosname
     */
    public String getSelectedKostName() {
        return playwright.getText(kosNameValueTxt).replaceAll("\n+\t\t\t+  Close Save changes","");
    }

    /**
     * Verify room name on form add tenant
     * @return roomname
     */
    public String getFullRoomName() {
        return playwright.getAttributeValue(fullRoomNameTxt, "placeholder");
    }

    /**
     * Click lanjut button on page onboarding add tenant from owner dashboard
     * @param buttonText
     */
    public void clickOnOnboardingAddTenant(String buttonText) {
        playwright.clickOnTextButton(buttonText, 3000.0);
    }

    /**
     * Select how to add contract
     * @param stringText (Minta penyewa untuk mengisi, saya yang menambah kontrak)
     *
     */
    public void selectHowToAddTenant(String stringText) {
        playwright.clickOnText(stringText, 3000.0);
    }

    /**
     * Select kos to add contract
     * @param kosName
     *
     */
    public void selectKosToAddContract(String kosName) {
        playwright.clickOnText(kosName, 3000.0);
    }

    /**
     * Verify the popup full room is displayed
     * @return true if pop up displayed and false if pop up not displayed
     *
     */
    public boolean isFullRoomPopUp() {
        playwright.hardWait(2000.0);
        return playwright.waitTillLocatorIsVisible(popUpFullRoomRestriction, 3000.0);
    }

    /**
     * Verify the text of pop up is displayed
     * @param text
     * @return true if text displayed and false if text not displayed
     *
     */
    public boolean getFullRoomRestriction(String text) {
        return playwright.isTextDisplayed(text);
    }

    /**
     * Click button on pop up
     * @param buttonText (kembali, ubah data kamar)
     *
     */
    public void clickOnPopUpButton(String buttonText) {
        playwright.clickOnTextButton(buttonText, 3000.0);
    }

    /**
     * Input tenant phone number to add tenant
     * @param tenantPhone
     */
    public void inputTenantPhone(String tenantPhone) {
        playwright.clickOn(phoneTenantField);
        phoneTenantField.fill(tenantPhone);
    }

    /**
     * Click dropdown "pilih kamar kos"
     * And then choose the room number
     *
     */
    public void selectFirstRoomNumber() {
        playwright.clickOn(roomNumberDropdown);
        playwright.clickOn(firstRoomNumber);
    }

    /**
     * Click on button in pop up pilih nomor kamar
     * @param buttonText
     */
    public void clickOnTerapkanRoomNumber(String buttonText) {
        playwright.clickOnTextButton(buttonText);
    }

    /**
     * Click on submit on add tenant form
     * @param buttonText
     *
     */
    public void submitAddTenantForm(String buttonText) {
        playwright.clickOnTextButton(buttonText);
    }

    /**
     * Verify the title and description on pop up different gender
     * @param text
     * @return true if text is diplayed and false if text not displayed
     */
    public boolean getDifferentGenderPopUpText(String text) {
        return playwright.isTextDisplayed(text, 3000.0);
    }
}