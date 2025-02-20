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
    Locator lplScoreLocator;
    Locator searchSubdsitrict;
    Locator btnSearchDistrict;
    Locator coloumResultSubdis;
    Locator btnResetDistrict;
    Locator inputSlot;
    Locator btnSaveSlot;
    Locator btnEditSlot;


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
        searchSubdsitrict = page.getByPlaceholder("Subdistrict id or name");
        btnSearchDistrict = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Search"));
        coloumResultSubdis = page.locator("//tr[1]/td[contains(.,'Edit Slot')]");
        btnResetDistrict = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Reset"));
        inputSlot = page.getByPlaceholder("Slot");
        btnSaveSlot = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save"));
        btnEditSlot = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Edit Slot"));


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
        playwright.waitTillPageLoaded();
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
        lplScoreLocator =  page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(lplScore));
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

    /**
     * Search subdistrict by id kost or name
     * @param subdistrict of subdistrict
     */
    public void searchSubdsitrict(String subdistrict) {
        playwright.fill(searchSubdsitrict,subdistrict);
        playwright.clickOn(btnSearchDistrict);
    }

    /**
     * Check one of coloumn list from result is appear or not
     */
    public boolean isSubdistrictAppear() {
        return playwright.waitTillLocatorIsVisible(coloumResultSubdis);
    }

    /**
     * Click button reset primme setting
     */
    public void clickOnBtnResetPrime() {
        playwright.clickOn(btnResetDistrict);
    }

    /**
     * Verify Subdistrict name
     * @param subDistrict
     * return Subdistrict name
     */
    public String getSubdistrictName (String subDistrict) {
        Locator subDistrictNameResult = page.locator("//td[.='"+subDistrict+"']");
        return playwright.getText(subDistrictNameResult);
    }

    /**
     * Verify Subdistrict id
     * @param subDistrictId
     * return Subdistrict id
     */
    public String getSubdistrictId (String subDistrictId) {
        Locator subDistrictIdResult = page.locator("//td[contains(.,'"+subDistrictId+"')]");
        return playwright.getText(subDistrictIdResult);
    }

    /**
     * Verify setting table from halaman hasil pencarian havevisible props
     * @param props
     * return true if props visible
     */
    public Boolean isHalamanHasilPencarianPropsVisible(String props) {
        Locator halamanHasilPencarianSubdistrik = page.locator("//td[contains(.,'Halaman Hasil Pencarian')]/preceding-sibling::td[contains(.,'"+props+"')]");
        return playwright.waitTillLocatorIsVisible(halamanHasilPencarianSubdistrik, 30000.0);
    }

    /**
     * Verify setting table from halaman pencarian kos have visible props
     * @param props
     * return true if props visible
     */
    public Boolean isHalamanPencarianKosPropsVisible(String props) {
        Locator halamanPencarianKosSubdistrik = page.locator("//td[contains(.,'Halaman Pencarian Kos')]/preceding-sibling::td[contains(.,'"+props+"')]");
        return playwright.waitTillLocatorIsVisible(halamanPencarianKosSubdistrik, 30000.0);
    }

    /**
     * Verify slot subdistrict
     * @param slot
     * return slot subdistrict
     */
    public String getSlotSubdistrict (String slot) {
        Locator slotResult = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(slot).setExact(true));
        return playwright.getText(slotResult);
    }

    /**
     * Click button on edit slot
     */
    public void clickOnBtnEditSlot() {
        playwright.clickOn(coloumResultSubdis);
    }

    /**
     * Input slot district
     * @param slotDistrict of slot subdistrict
     */
    public void inputSlotDistrict(String slotDistrict) {
        playwright.waitTillLocatorIsVisible(btnEditSlot);
        playwright.clickOn(btnEditSlot);
        playwright.fill(inputSlot,slotDistrict);
        playwright.clickOn(btnSaveSlot);
    }

    /**
     * Input slot district
     * @param slotDistrict of slot subdistrict
     */
    public void inputSlotDistrictFromPageSlot(String slotDistrict) {
        playwright.fill(inputSlot,slotDistrict);
        playwright.clickOn(btnSaveSlot);
    }

    /**
     * Verify warning and succsess message
     * @param message
     * return The slot field is required. or Success! Slot updated.
     */
    public String getMessageSlot (String message) {
        Locator messageResult = page.getByText(message);
        return playwright.getText(messageResult);
    }

    /**
     * Verify package name of subdistrict
     * @param packageName
     * return package name prime
     */
    public String getPackageName(String packageName) {
        Locator pacakgeNameResult = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(packageName));
        return playwright.getText(pacakgeNameResult);
    }

    /**
     * Verify label favorite of subdistrict
     * @param favoritLabel
     * return favorit label at prime setting
     */
    public String getLabelName(String favoritLabel) {
        Locator labelNameResult = page.locator("//span[.='"+favoritLabel+"']");
        return playwright.getText(labelNameResult);
    }
}
