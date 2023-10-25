package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import config.playwright.context.ActiveContext;
import utilities.PlaywrightHelpers;
public class BoostLplPO {
    private Page page;
    PlaywrightHelpers playwright;

    Locator headerBoostLPL;
    Locator tableListLPL;
    Locator coloumnLpl;
    Locator searchByKostId;
    Locator searchByKostName;
    Locator listingName;
    Locator idKost;
    Locator tableDataLpl;


    public BoostLplPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        headerBoostLPL = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName(" LPL Boost Menu"));
        tableListLPL = page.locator("//table[@class='table table-bordered table-hover text-center']");
        coloumnLpl =  page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("LPL Score"));
        searchByKostId = page.getByPlaceholder("Listing ID / Song ID");
        searchByKostName = page.getByPlaceholder("Listing Name");
        listingName = page.locator("td:nth-of-type(3)");
        idKost = page.locator("//td[contains(.,'ID: 1000034428')]");
        tableDataLpl = page.locator("//tbody[1]/tr[1]");
    }


    /**
     * Check header lpl is appear
     */
    public boolean isHeaderLPLAppear() {
        return playwright.waitTillLocatorIsVisible(headerBoostLPL);
    }

    /**
     * Check table list lpl is appear
     */
    public boolean isTableLPLisAppear() {
        return playwright.waitTillLocatorIsVisible(tableListLPL);
    }

    /**
     * Check one of coloumn list lpl is appear
     */
    public boolean isColoumnLPLisAppear() {
        return playwright.waitTillLocatorIsVisible(coloumnLpl);
    }

    /**
     * Search kos name by id kost or song id
     * @param kosID of Kos ID
     */
    public void searchKosNameLPL(String kosID) {
        playwright.fill(searchByKostId,kosID);
        page.keyboard().press("Enter");
    }

    /**
     * get id from search result
     *
     */
    public String getKostId() {
       return playwright.getText(idKost);
    }

    /**
     * Check one of coloumn list lpl is appear
     */
    public boolean isResultKosNameisAppear() {
        return playwright.waitTillLocatorIsVisible(tableDataLpl);
    }

    /**
     * Clear text at song or kost id after search
     */
    public void clearTextKosId() {
       playwright.clearText(searchByKostId);
    }


    /**
     * Search kos name by listing name
     * @param kosName of Kos ID
     */
    public void searchKosNameLPLbyListing(String kosName) {
        playwright.fill(searchByKostName,kosName);
        page.keyboard().press("Enter");
    }

    /**
     * get listing name from search result
     *
     */
    public String getListingName() {
        return playwright.getText(listingName);
    }

    /**
     * Clear text at listing name after search
     */
    public void clearTextKosName() {
        playwright.clearText(searchByKostName);
    }
}
