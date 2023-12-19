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
        playwright.clickOn(editBtn);
    }

    /**
     * Get String Key
     * @return String Key
     */
    public String getKeyAfterEdit() {
        return playwright.getText(keyInTable);
    }
}