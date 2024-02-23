package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import data.mamikos.Mamikos;
import utilities.PlaywrightHelpers;

import java.util.List;

public class PremiumInvoicePO {
    Page page;
    PlaywrightHelpers playwrightHelpers;
    private Locator premiumInvoiceMenu;
    private Locator packageInvoiceList;
    private Locator searchByOption;
    private Locator inputSearchBy;
    private Locator statusOption;
    private Locator cariInvoiceBtn;
    private Locator tableListData;
    private Locator statusList;

    public PremiumInvoicePO(Page page) {
        this.page = page;
        this.playwrightHelpers = new PlaywrightHelpers(page);
        this.premiumInvoiceMenu = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Premium Invoice"));
        this.packageInvoiceList = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Package Invoice List"));
        this.searchByOption = page.locator("select[name='search_by']");
        this.inputSearchBy = page.locator("input[name='search_value']");
        this.statusOption = page.locator("select[name='status']");
        this.cariInvoiceBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cari Invoice"));
        this.tableListData = page.locator(".box-body");
        this.statusList = page.locator("//tbody/tr/td[8]/span");
    }

    /**
     * user navigates into package invoice list on premium invoice
     */
    public void navigatesIntoPackageInvoiceList() {
        playwrightHelpers.navigateTo(Mamikos.ADMINMAMIPAY + "/backoffice/invoice/premium/package");
    }

    /**
     * user sorting package invoice premium
     *
     * @param searchBy
     * @param inputField
     */
    public void searchPackageInvoiceBy(String searchBy, String inputField) {
        playwrightHelpers.selectDropdownByValue(searchByOption, searchBy.toLowerCase().replaceAll(" ", "_"));
        playwrightHelpers.clickLocatorAndTypeKeyboard(inputSearchBy, inputField);
    }

    /**
     * click on search btn package invoice
     */
    public void clickOnSearchPackageInvoice() {
        playwrightHelpers.clickOn(cariInvoiceBtn);
    }

    /**
     * check if data list is null or blank
     */
    public boolean isDataListBlannk() {
        return playwrightHelpers.isDataBlankorNull(tableListData);
    }

    /**
     * filtering the transaction status for 'expired, paid, unpaid'
     *
     * @param status
     */
    public void filterTransactionStatus(String status) {
        playwrightHelpers.selectDropdownByValue(statusOption, status.toLowerCase());
    }

    /**
     * get list transaction status 'expired, paid, unpaid'
     *
     * @return
     */
    public List<String> getListStatusTransaction() {
        return playwrightHelpers.getListInnerTextFromListLocator(statusList);
    }

    /**
     * get status transaction the first invoice on list
     *
     * @return
     */
    public String getInvoiceStatusTransaction() {
        return playwrightHelpers.getText(statusList.first());
    }
}
