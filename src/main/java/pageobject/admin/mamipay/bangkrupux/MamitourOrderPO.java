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


    public MamitourOrderPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.searchPhoneNumberInput = page.getByPlaceholder("Owner Phone Number");
        this.searchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Search"));
        this.firstMarkAsPaidOnPage = page.locator("//button[@type='button' and normalize-space()='Mark as Paid']").first();
        this.manualInvoiceInput = page.getByLabel("Manual Invoice Code");
        this.markAsPaidOnPopup = page.locator("//button[@type='submit' and normalize-space()='Mark as Paid']").first();
        this.successAlert = page.locator("//div[contains(@class,'alert-dismissable')]");
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
}
