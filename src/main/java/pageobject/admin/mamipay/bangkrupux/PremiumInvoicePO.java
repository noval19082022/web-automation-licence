package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class PremiumInvoicePO {
    Page page;
    PlaywrightHelpers playwrightHelpers;
    private Locator premiumInvoiceMenu;
    private Locator packageInvoiceList;
    private Locator searchByOption;
    private Locator inputSearchBy;
    private Locator cariInvoiceBtn;
    private Locator tableListData;

    public PremiumInvoicePO(Page page) {
        this.page = page;
        this.playwrightHelpers = new PlaywrightHelpers(page);
        this.premiumInvoiceMenu = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Premium Invoice"));
        this.packageInvoiceList = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Package Invoice List"));
        this.searchByOption = page.locator("select[name='search_by']");
        this.inputSearchBy = page.locator("input[name='search_value']");
        this.cariInvoiceBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cari Invoice"));
        this.tableListData = page.locator(".box-body");
    }

    /**
     * user navigates into package invoice list on premium invoice
     */
    public void navigatesIntoPackageInvoiceList() {
        playwrightHelpers.clickOn(premiumInvoiceMenu);
        playwrightHelpers.clickOn(packageInvoiceList);
    }

    /**
     * user sorting package invoice premium
     *
     * @param searchBy
     * @param inputField
     */
    public void searchPackageInvoiceBy(String searchBy, String inputField) {
        playwrightHelpers.selectDropdownByValue(searchByOption, searchBy);
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
}
