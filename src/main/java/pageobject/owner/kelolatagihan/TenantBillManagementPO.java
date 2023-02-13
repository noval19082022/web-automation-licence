package pageobject.owner.kelolatagihan;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
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
     * Only work if there is only one item in the list
     * @return BillDetailsPO class
     */
    public BillDetailsPO clickOnInvoiceList() {
        playwright.clickOn(invoiceList);
        return new BillDetailsPO(page);
    }

    /**
     * Click on invoice list based jatuh tempo text
     * @param setName Set with jatuh tempo test example: Belum bayar - Jatuh tempo sekarang
     * @return BillDetailsPO class
     */
    public BillDetailsPO clickOnInvoiceList(String setName) {
        Locator invoiceList = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(setName)).getByTestId("invoice-status-label");
        playwright.clickOn(invoiceList);
        return new BillDetailsPO(page);
    }

    /**
     * Reload page if filter kos is not visible
     */
    public void reloadOnEmptyKelolaTagihanPage() {
        if(!filterKos.isVisible()) {
            page.reload();
        }
    }
}
