package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class RoomLevelPO {
    private Page page;
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);

    //---Create Room Level---//
    private Locator addRoomLevel;
    private Locator levelName;
    private Locator keyField;
    private Locator chargingNameField;
    private Locator chargingFeeField;
    private Locator chargingRulesCheckBox;
    private Locator saveBtn;
    private Locator errorMessageExistingKey;

    //---Manage Room Level---//
    private Locator searchBar;
    private Locator searchBtn;
    private Locator roomLevelRow;
    private Locator editBtn;
    private Locator keyInTable;
    private Locator errorMessage;
    private Locator menuTitleText;
    private Locator columnNameText;
    private Locator paginationPageText;
    private Locator activePaginationPageText;
    private Locator levelNameData;

    public RoomLevelPO(Page page){
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        //---Create Room Level---//
        addRoomLevel = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add Room Level"));
        levelName = page.getByLabel("Level Name");
        keyField = page.getByLabel("Key");
        chargingNameField = page.locator("#level-charging-name");
        chargingFeeField = page.locator("#level-count");
        saveBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save"));
        errorMessageExistingKey = page.getByText("The key has already been taken.");

        //---Manage Room Level---//
        searchBar = page.getByPlaceholder("Level Name");
        searchBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search"));
        roomLevelRow = page.locator("tr td:nth-of-type(2)").first();
        editBtn = page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions()).getByTitle("Edit");
        keyInTable = page.locator("td:nth-child(3)").first();
        errorMessage = page.locator(".alert li");
        menuTitleText = page.locator(".box-header h3");
        columnNameText = page.locator("th");
        activePaginationPageText = page.locator(".page-item.active span");
        levelNameData = page.locator("tr td:nth-of-type(2)");
    }

    /**
     * Clicks Add Room Level button
     */
    public void clicksAddRoomLevel() {
        playwright.clickOn(addRoomLevel);
    }

    /**
     * Inputs Level Name
     * @param name
     */
    public void inputsLevelName(String name) {
        playwright.fill(levelName, name);
    }

    /**
     * Inputs Key
     * @param key
     */
    public void inputsKey(String key) {
        playwright.fill(keyField, key);
    }

    /**
     * Inputs Charging Name
     * @param chargingName
     */
    public void inputsChargingName(String chargingName) {
        playwright.fill(chargingNameField, chargingName);
    }

    /**
     * Inputs Charging Fee
     * @param chargingFee
     */
    public void inputsChargingFee(String chargingFee) {
        playwright.clearText(chargingFeeField);
        playwright.fill(chargingFeeField, chargingFee);
    }

    /**
     * Tick on Charging Rules For
     * @param chargingRules
     */
    public void tickChargingRulesFor(String chargingRules) {
        chargingRulesCheckBox = page.locator("//label[@class='form-check-label'][contains(., '" +chargingRules+ "')]");
        playwright.clickOn(chargingRulesCheckBox);
    }

    /**
     * Clicks Save button
     */
    public void clicksSave() {
        playwright.clickOn(saveBtn);
    }

    /**
     * Get String Error Message Existing Key
     * @return String Error Message Existing Key
     */
    public String getErrorMessageExistingKey() {
        return playwright.getText(errorMessageExistingKey);
    }

    /**
     * Search Level Name
     * @param levelName
     */
    public void searchLevelName(String levelName) {
        playwright.fill(searchBar, levelName);
        playwright.clickOn(searchBtn);
    }

    /**
     * Check if Level Name is displayed
     * True = element is displayed
     * False = element is not displayed
     * @return Level Name
     */
    public boolean isLevelNameDisplayed() {
        return playwright.isLocatorVisibleAfterLoad(roomLevelRow, 10000.0);
    }

    /**
     * Clicks Edit button
     */
    public void editRoomLevel() {
        playwright.clickOn(editBtn.first());
    }

    /**
     * Get String Key
     * @return String Key
     */
    public String getKeyAfterEdit() {
        return playwright.getText(keyInTable);
    }

    /**
     * Get Error Message
     * @return
     */
    public String getErrorMessage() {
        return playwright.getText(errorMessage);
    }

    /**
     * Get menu title
     * @return String
     */
    public String getMenuTitle() {
        return playwright.getText(menuTitleText);
    }

    /**
     * Check Add Room level button visible
     * @return Boolean
     */
    public boolean isButtonAddRoomLevelVisible() {
        return playwright.isLocatorVisibleAfterLoad(addRoomLevel,5000.0);
    }

    /**
     * Check search field visible
     * @return Boolean
     */
    public boolean isSearchFieldVisible() {
        return playwright.isLocatorVisibleAfterLoad(searchBar,5000.0);
    }

    /**
     * Check Search button visible
     * @return Boolean
     */
    public boolean isButtonSearchVisible() {
        return playwright.isLocatorVisibleAfterLoad(searchBtn, 5000.0);
    }

    /**
     * Get Column Name index i
     * @param i index
     * @return String
     */
    public String getColumnName(int i) {
        return playwright.getText(columnNameText.nth(i));
    }

    /**
     * Click page number
     * @param no page number
     */
    public void clickPaginationNumber(String no) {
        paginationPageText = page.locator(".page-item a").getByText(no);

        playwright.clickOn(paginationPageText);
    }

    /**
     * Get active pagination page
     * @return String
     */
    public String getActivePaginationPage() {
        playwright.pageScrollInView(activePaginationPageText);
        return playwright.getText(activePaginationPageText);
    }

    /**
     * Get String Level Name Data
     * @return String Level Name Data
     */
    public String getLevelName() {
        return playwright.getText(roomLevelRow);
    }

    /**
     * Clicks Search Button
     */
    public void clicksSearchButton() {
        playwright.clickOn(searchBtn);
    }

    /**
     * Get Total Data in Level Name Coloumn
     * @return int Total
     */
    public int getTotalLevelNameData(){
        return playwright.getLocators(levelNameData).size();
    }

    /**
     * Get String All Data in Level Name Coloumn
     * @param levelName
     * @return String All Data
     */
    public String getAllLevelNameData(int levelName) {
        return playwright.getText(levelNameData.nth(levelName));
    }

    /**
     * Clear Keyword in Room Level Search Bar
     */
    public void clearKeywordInSearchBar() {
        playwright.clearText(searchBar);
    }
}