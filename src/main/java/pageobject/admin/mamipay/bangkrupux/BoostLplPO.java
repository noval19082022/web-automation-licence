package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
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
    Locator btnAddBoostLpl;
    Locator inputKostName;
    Locator resultKostLpl;
    Locator btnBoostLpl;
    Locator warningPopUpAddBoost;
    Locator btnYesBoostLpl;
    Locator deleteButtonlpl;
    Locator btnOkDeletedLpl;


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
        btnAddBoostLpl = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Add LPL Boost"));
        inputKostName = page.getByPlaceholder("Keyword");
        btnBoostLpl =  page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Boost LPL"));
        warningPopUpAddBoost = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Apakah sudah yakin untuk boost skor LPL listing ini?"));
        btnYesBoostLpl = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Yes"));
        deleteButtonlpl = page.locator("//tbody[1]/tr[1]//button[@class='btn btn-danger btn-sm']");
        btnOkDeletedLpl = page.locator("//button[@class='btn btn-danger']");

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

    /**
     * Search kos name by listing name
     * @param kosName of Kos ID
     */
    public void searchKosNameToBoost(String kosName) {
        playwright.fill(inputKostName,kosName);
        page.keyboard().press("Enter");
    }

    /**
     * Click button add lpl boost
     */
    public void clickOnButtonAddLpl() {
        playwright.clickOn(btnAddBoostLpl);
    }

    /**
     * Verify kost is present or not
     * @param kost
     * return kost true or false
     */
    public boolean isResultKostPresent(String kost) {
         resultKostLpl = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(kost));
        return playwright.waitTillLocatorIsVisible(resultKostLpl);
    }

    /**
     * Clear text at kost name
     */
    public void clearTextKosNameAddLpl() {
        playwright.clearText(inputKostName);
    }

    /**
     * Verify listing name
     * @param listingName
     * return listing name
     */
    public String getListingName (String listingName) {
       Locator listingNameResult = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(listingName));
        return playwright.getText(listingNameResult);
    }

    /**
     * Verify score lpl
     * @param lplScore
     * return lpl Score
     */
    public String getScoreLpl(String lplScore) {
      Locator lplScoreLocator =  page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(lplScore));
        return playwright.getText(lplScoreLocator);
    }

    /**
     * Click button boost lpl at page add boost lpl
     */
    public void clickButtonBoostLpl() {
        playwright.clickOn(btnBoostLpl);
    }

    /**
     * Check pop up add boost lpl is show
     */
    public boolean isPopUpAddBoostLplAppear() {
        return playwright.waitTillLocatorIsVisible(warningPopUpAddBoost);
    }


    /**
     * Click button yes at pop up warning
     */
    public void clickButtonYesLpl() {
        playwright.clickOn(btnYesBoostLpl);
    }

    /**
     * Click delete button
     */
    public void clickOnDeleteButton() {
        playwright.clickOn(deleteButtonlpl);
        playwright.clickOn(btnOkDeletedLpl);
    }
}
