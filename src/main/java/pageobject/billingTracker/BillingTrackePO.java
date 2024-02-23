package pageobject.billingTracker;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class BillingTrackePO {
    private final Page page;
    private final PlaywrightHelpers playwright;

    Locator searchTypeButton;
    Locator searchTypeText;
    Locator searchInputField;
    Locator searchButton;
    Locator resultDataTable;
    Locator resetButton;
    Locator filterButton;
    Locator filterBseButton;
    Locator applyButton;
    Locator iconActionButton;

    public BillingTrackePO(Page page) {
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        searchTypeButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Nama Penyewa dropdown-down"));
        searchInputField = page.getByPlaceholder("Cari");
        searchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("search Cari"));
        resultDataTable = page.locator("tbody > tr:nth-child(1)").first();
        resetButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Reset"));
        filterButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("filterFilter"));
        filterBseButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih akun BSE dropdown-down"));
        applyButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Terapkan"));
        iconActionButton = page.locator("div.table-action-menu__activator").first();
    }

    public void searchType(String type, String text){
        playwright.clickOn(searchTypeButton);
        searchTypeText = page.locator("a").filter(new Locator.FilterOptions().setHasText(""+type+""));
        playwright.clickOn(searchTypeText);
        playwright.fill(searchInputField, text);
        playwright.clickOn(searchButton);
    }

    /**
     * get validation on search
     * @param text
     * @return text
     */
    public boolean getValidationBillingTrackertext(String text){
        Locator tenantName = page.getByText(text);
        return playwright.waitTillLocatorIsVisible(tenantName);
    }

    /**
     * get result data after search
     * @return data list
     */
    public boolean getResutlDataTable(){
        return playwright.waitTillLocatorIsVisible(resultDataTable,3000.0);
    }

    /**
     * click on reset button
     */
    public void clickResetButton(){
        playwright.clickOn(resetButton);
    }

    /**
     * click on filter button
     * @param text example : bse name
     */
    public void clickFilterButton(String text){
        playwright.clickOn(filterButton);
        playwright.clickOn(filterBseButton);
        Locator bseFilter = page.locator("a").filter(new Locator.FilterOptions().setHasText(""+text+""));
        playwright.clickOn(bseFilter);
        playwright.clickOn(applyButton);
        playwright.clickOn(searchButton);
    }

    /**
     * click on bulk follow up
     * @param text example "Tandai sudah follow-up
     */
    public void clickBulkFollowUp(String text){
        playwright.clickOn(iconActionButton);
        playwright.hardWait(100);
        Locator bulkFollow = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("file-booking "+text+""));
        playwright.clickOn(bulkFollow);
    }

    /**
     * validate bulk will visible
     * @param text example: Tandai sudah follow-up
     * @return text Tandai sudah follow-up
     */
    public String getBulkText(String text){
        playwright.clickOn(iconActionButton);
        Locator bulkText = page.locator("//p[contains(., '"+text+"')]");
        return playwright.getText(bulkText);
    }
}
