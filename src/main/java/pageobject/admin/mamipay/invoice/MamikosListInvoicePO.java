package pageobject.admin.mamipay.invoice;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
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
    Page.GetByRoleOptions pageRoleOptions;
    Locator.GetByRoleOptions locatorRoleOptions;

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
        pageRoleOptions = new Page.GetByRoleOptions();
        locatorRoleOptions = new Locator.GetByRoleOptions();
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
        invoiceDetail = page.getByRole(AriaRole.ROW, pageRoleOptions.setName(invoiceText)).getByRole(AriaRole.LINK, locatorRoleOptions.setName("Detail Fee"));
        playwright.clickOn(invoiceDetail);
    }

    /**
     * Click on add fee in invoice detail
     */
    public void clickOnAddFeeInInvoice() {
        playwright.clickOn(addFeeButton);
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
}
