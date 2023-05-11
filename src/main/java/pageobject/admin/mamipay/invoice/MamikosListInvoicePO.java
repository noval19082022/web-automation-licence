package pageobject.admin.mamipay.invoice;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.JavaHelpers;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

public class MamikosListInvoicePO {
    private Page page;
    private PlaywrightHelpers playwright;
    private LocatorHelpers locator;
    Locator searchInvoiceBy;
    Locator inputSearchValue;
    Locator cariInvoice;
    Locator invoiceDetail;
    Locator addFeeButton;
    Locator inputCostTitle;
    Locator inputCostValue;
    Locator addFeeAdditionalPriceButton;
    Locator additionalPriceTypeOption;
    Locator detailFirst;
    Locator detailSecond;
    Page.GetByRoleOptions pageRoleOptions;
    Locator.GetByRoleOptions locatorRoleOptions;
    Locator otherPrice;
    Locator otherPriceName;
    Locator getOtherPriceNumber;
    Locator txtBasicAmount;
    Locator editBasicAmount;
    Locator basicAmountTextField;
    Locator updateButton;

    public MamikosListInvoicePO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.locator = new LocatorHelpers(page);
        searchInvoiceBy = page.locator("select[name=\"search_by\"]");
        inputSearchValue = page.locator("input[name=\"search_value\"]");
        cariInvoice = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cari Invoice"));
        addFeeButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add Fee"));
        inputCostTitle = page.locator("input[name=\"cost_title\"]");
        inputCostValue = page.locator("input[name=\"cost_value\"]");
        addFeeAdditionalPriceButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add Fee"));
        additionalPriceTypeOption = page.locator("#cost-type-select");
        detailFirst = page.locator("tr:first-of-type td a:first-of-type + a");
        detailSecond = page.locator("//tr[2]//td[@class='invoice-action']//*[@class='btn btn-xs bg-maroon btn-flat']");
        txtBasicAmount = page.locator("//*[.='Basic Amount']/following-sibling::dd[1]");
        pageRoleOptions = new Page.GetByRoleOptions();
        locatorRoleOptions = new Locator.GetByRoleOptions();
        editBasicAmount = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(""));
        basicAmountTextField = page.getByRole(AriaRole.TEXTBOX);
        updateButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Update"));

    }

    /**
     * This method will set status on Change Status Invoice Page
     * @param status
     */
    public void setStatusPaidOrUnpaid(String status) {
        page.getByRole(AriaRole.COMBOBOX).selectOption(status);
    }

    /**
     * this method will fill date on change status invoice page
     * @param date
     */
    public void setDate(String date) {
        page.getByPlaceholder("Transaction Date").fill(date);
    }

    /**
     * Search invoice by
     * @param searchBy String data type
     */
    public void selectSearchInvoiceBy(String searchBy) {
        playwright.selectDropdownByValue(searchInvoiceBy, searchBy);
    }

    /**
     * Fill search value
     * @param searchValue String data type
     */
    public void fillInputSearchValue(String searchValue) {
        inputSearchValue.fill(searchValue);
    }

    /**
     * Click on cari invoice
     */
    public void clickOnCariInvoice() {
        playwright.clickOn(cariInvoice);
    }

    /**
     * Go to invoice detail
     * @param invoiceText Text of unique parameter of invoice(e.g invoice number)
     */
    public void goToInvoiceDetail(String invoiceText) {
        invoiceDetail = page.getByRole(AriaRole.ROW, pageRoleOptions.setName(invoiceText)).getByRole(AriaRole.LINK, locatorRoleOptions.setName("Detail Fee")).first();
        playwright.clickOn(invoiceDetail);
    }

    /**
     * Click on add fee in invoice detail
     */
    public void clickOnAddFeeInInvoice() {
        playwright.clickOn(addFeeButton);
    }

    /**
     * Click on Detail in first invoice detail
     */
    public void clickOnDetailFirstButton() {
        playwright.clickOn(detailFirst);
    }

    /**
     * Click on Detail in first invoice detail
     */
    public void clickOnDetailSecondButton() {
        playwright.clickOn(detailSecond);
    }

    /**
     * Fill additional price name
     * @param priceName Price/Title name of addiontal price
     */
    public void fillAdditionalPriceName(String priceName) {
        inputCostTitle.fill(priceName);
    }

    /**
     * Fill additional price cost value
     * @param priceValue String data type number
     */
    public void fillAdditionalPriceCostValue(String priceValue) {
        inputCostValue.fill(priceValue);
    }

    /**
     * Click on add fee in additional price
     */
    public void clickOnAddFeeInAdditionalPrice(){
        playwright.clickOn(addFeeAdditionalPriceButton);
    }

    /**
     * Select additional price type
     * @param costType cost type one of the following list: fixed, other, admin, discount, addon.
     * by default dropdown value is other
     */
    public void selectAdditionalPriceType(String costType) {
        playwright.selectDropdownByValue(additionalPriceTypeOption,costType);
    }

    /**
     * Get invoice detail element value
     * @param invoiceEl input with element name that present on invoice detail
     * @return string data type
     */
    public String getInvoiceElementValue(String invoiceEl) {
        return playwright.getText(page.locator("//*[.='"+invoiceEl+"']/following-sibling::*[1]")).trim();
    }

    /**
     * Get other price's price number
     * @param invoiceEl input with other price Fee Type example "Admin", "Biaya Tetap" etc
     * @return Integer data type of other price's price number
     */
    public Integer getOtherPriceNumber(String invoiceEl) {
        getOtherPriceNumber = page.locator("//*[.='"+invoiceEl+"']/following-sibling::*[1]");
        return JavaHelpers.extractNumber(playwright.getText(getOtherPriceNumber));
    }

    /**
     * Get basic amount as text
     * @return string data type
     */
    public String getBasicAmountText() {
        return playwright.getText(txtBasicAmount);
    }

    /**
     * Delete active other price
     * @param otherPriceName input with other price name
     * @throws InterruptedException
     */
    public void deleteAdditionalOtherPrice(String otherPriceName) throws InterruptedException {
        otherPrice = page.locator("//*[.='"+otherPriceName+"']/following-sibling::*//*[@title='Delete Fee']");
        playwright.clickOn(otherPrice);
        page.waitForSelector(".callout.callout-success");
    }

    /**
     * Get total amount by it index
     * @param invoiceIndex index input with number. By element index.
     * @return string data type
     */
    public String getTotalAmount(int invoiceIndex) {
        return playwright.getText(page.locator("tr:nth-child("+ invoiceIndex +") td:nth-child(5)"));
    }

    /**
     * Edit basic amount on admin invoice
     * @param newBasicAmountPrice input with desired price
     * @throws InterruptedException
     */
    public void editBasicAmount(Integer newBasicAmountPrice) throws InterruptedException {
        playwright.clickOn(editBasicAmount);
        playwright.forceFill(basicAmountTextField, newBasicAmountPrice.toString());
        playwright.clickOn(updateButton);
    }

    /**
     * Check the visibility of aditional price is visible
     * @return boolean
     */
    public boolean isAdditionalPriceNameIsVisible(String otherPrice) {
        otherPriceName = page.locator("//*[.='"+otherPrice+"']");
        for (int i = 0; i < 4; i++) {
            if (otherPriceName.isVisible()) {
                break;
            }
        }
        return playwright.waitTillLocatorIsVisible(otherPriceName);
    }
}
