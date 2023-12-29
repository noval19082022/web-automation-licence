package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class MamitourOrderPO {
    private Page page;
    private PlaywrightHelpers playwright;

    private Locator searchPhoneNumberInput;
    private Locator searchButton;
    private Locator firstMarkAsPaidOnPage;
    private Locator manualInvoiceInput;
    private Locator markAsPaidOnPopup;
    private Locator successAlert;
    private Locator statusPayment;
    private Locator createOrderButton;
    private Locator phoneNumberInput;
    private Locator paketMamitour;
    private Locator saveButton;


    public MamitourOrderPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.searchPhoneNumberInput = page.getByPlaceholder("Owner Phone Number");
        this.searchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Search"));
        this.firstMarkAsPaidOnPage = page.locator("//button[@type='button' and normalize-space()='Mark as Paid']").first();
        this.manualInvoiceInput = page.getByLabel("Manual Invoice Code");
        this.markAsPaidOnPopup = page.locator("//button[@type='submit' and normalize-space()='Mark as Paid']").first();
        this.successAlert = page.locator("//div[contains(@class,'alert-dismissable')]");
        this.statusPayment = page.locator("//td/span").first();
        this.createOrderButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Create MamiTour Order"));
        this.phoneNumberInput = page.locator("#phone_number");
        this.paketMamitour = page.locator("select[name='package']");
        this.saveButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save"));
    }

    /**
     * search owner phone number
     * @param number
     */
    public void searchPhoneNumber(String number) {
        playwright.fill(searchPhoneNumberInput, number);
        playwright.clickOn(searchButton);
    }

    /**
     * click on the first mark as paid on the page
     */
    public void clickOnFirstMarkAsPaid() {
        playwright.clickOn(firstMarkAsPaidOnPage);
    }

    /**
     * fill manual invoice input and click mark as paid on popup
     * @param manualInvoice
     */
    public void inputManualInvoice(String manualInvoice) {
        playwright.fill(manualInvoiceInput, manualInvoice);
        playwright.clickOn(markAsPaidOnPopup);
    }

    /**
     * get success alert text
     * @return String
     */
    public String getSuccessTextAlert() {
        playwright.waitTillLocatorIsVisible(successAlert);
        return playwright.getText(successAlert);
    }

    /**
     * check is it mark as paid still visible on the page
     * @return boolean
     */
    public boolean isFirstMarkAsPaidVisible() {
        return playwright.waitTillLocatorIsVisible(firstMarkAsPaidOnPage);
    }

    /**
     * count mark as paid on the page
     * @return integer
     */
    public int getCountMarkAsPaidOnMamitourOrder() {
        return playwright.getLocators(firstMarkAsPaidOnPage).size();
    }

    /**
     * get text value of status payment request mamitour
     * @return String
     */
    public String getStatusPaymentText() {
        playwright.waitTillLocatorIsVisible(statusPayment);
        return playwright.getText(statusPayment);
    }

    /**
     * click on create request mamitour on mamitour order page
     */
    public void clickOnCreateRequestMamitourBtn() {
        playwright.clickOn(createOrderButton);
    }

    /**
     * fill owner phone number who request mamitour
     * @param phoneNumber
     */
    public void fillOwnerPhoneNumber(String phoneNumber) {
        playwright.fill(phoneNumberInput, phoneNumber);
    }

    /**
     * select mamitour package (e.g 3 Bulan, 6 Bulan, 12 Bulan)
     * @param paket
     */
    public void choosePackage(String paket) {
        playwright.selectDropdownByValue(paketMamitour, paket);
    }

    /**
     * click on save button on creating mamitour request
     */
    public void clickOnSave() {
        playwright.clickOn(saveButton);
    }
}
