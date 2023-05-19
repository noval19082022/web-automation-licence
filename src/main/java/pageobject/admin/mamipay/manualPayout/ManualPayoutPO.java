package pageobject.admin.mamipay.manualPayout;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import data.mamikos.Mamikos;
import utilities.JavaHelpers;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

public class ManualPayoutPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private LocatorHelpers locator;
    private Locator searchButton;
    private Locator invoiceType;
    private Locator invoiceStatus;

    public ManualPayoutPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.locator = new LocatorHelpers(page);
        searchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search"));
        invoiceType = page.locator("select[name=\"type\"]");
        invoiceStatus = page.locator("select[name=\"status\"]");
    }

    /**
     * Click on serch button
     */
    public void clickOnSearchButton() {
        searchButton.click();
    }

    /**
     * verify the search result
     *
     * @throws InterruptedException
     */
    public void getSearchResult(String searchResult){
        playwright.waitTillLocatorIsVisible(page.locator("(//td[.='" + searchResult + "'])[1]"));
    }

    /**
     * Search invoice by Type
     *
     * @param searchBy String data type
     */
    public void selectInvoiceType(String searchBy) {
        playwright.selectDropdownByValue(invoiceType, searchBy);
    }



    /**
     * Search invoice by Type
     *
     * @param searchBy String data type
     */
    public void selectInvoiceStatus(String searchBy) {
        playwright.selectDropdownByValue(invoiceStatus, searchBy);
    }
}
