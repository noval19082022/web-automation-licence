package pageobject.owner.kelolatagihan;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;

import java.util.List;

public class TenantBillManagementPO {
    Page page;
    PlaywrightHelpers playwright;
    Locator filterKos;
    Locator filterMonth;
    Locator invoiceList;
    public TenantBillManagementPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        filterKos = page.locator("div.bm-filter__kost");
        filterMonth = page.locator("input[type=\"text\"]").first();
        invoiceList = page.getByTestId("invoice-status-label");
    }

    /**
     * Select kos filter by kos name
     * @param kostName Kos Name
     */
    public void selectKosFilter(String kostName) {
        Locator kosNameFilter = page.getByText(kostName);
        playwright.waitFor(filterKos, 30000.0);
        List<String> filterKostInnerTexts = filterKos.allInnerTexts();
        System.out.println(filterKostInnerTexts);
        if (!filterKostInnerTexts.get(0).contains(kostName)) {
            playwright.clickOn(filterKos);
            playwright.clickOn(kosNameFilter);
        }
    }

    /**
     * Select month filter by month name
     * @param month String type month name
     */
    public void selectMonthFilter(String month) {
        Locator monthName = page.getByText(month);
        playwright.waitFor(filterMonth, 30000.0);
        if (!filterMonth.allInnerTexts().get(0).contains(month)) {
            playwright.clickOn(filterMonth);
            playwright.clickOn(monthName);
        }
    }

    /**
     * Click on invoice list and navigate to billing details
     * @return BillDetailsPO class
     */
    public BillDetailsPO clickOnInvoiceList() {
        playwright.clickOn(invoiceList);
        return new BillDetailsPO(page);
    }
}
