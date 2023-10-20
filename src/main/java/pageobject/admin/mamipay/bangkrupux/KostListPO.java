package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import config.global.GlobalConfig;
import utilities.PlaywrightHelpers;
import com.microsoft.playwright.options.AriaRole;

public class KostListPO {
    private Page page;
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);

    Locator uploadCSVBtn;
    Locator kostName;
    Locator ownerName;
    Locator ownerPhoneNumber;
    Locator allLevelDropdown;
    Locator searchBtn;
    Locator columnName;
    Locator pageNumberBtn;
    Locator pagination;
    Locator editKostLevelBtn;
    Locator kosLevelDropdown;
    Locator saveBtn;
    Locator levelNameText;
    Locator chargeBy;
    Locator chargeByDropdowntText;

    public KostListPO(Page page){
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        uploadCSVBtn = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Upload CSV"));
        kostName = page.getByPlaceholder("Kost Name");
        ownerName = page.getByPlaceholder("Owner Name");
        ownerPhoneNumber = page.getByPlaceholder("Owner Phone Number");
        allLevelDropdown = page.locator("select[name=\"level-id\"]");
        searchBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Search"));
        editKostLevelBtn = page.locator("//a[contains(text(),'Edit Kost Level')]");
        kosLevelDropdown = page.locator("//select[@id='level-id']");
        saveBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save"));
        levelNameText = page.locator("(//tbody/tr/td)[5]");
        chargeBy = page.locator("//select[@id='is-charge-by-room']");
        chargeByDropdowntText = page.locator("//select[@id='is-charge-by-room']/option[@selected='true']");
    }

    /**
     * check Upload CSV button is visible
     * @return boolean element status
     */
    public boolean isUploadCSVButtonAppears(){
        return playwright.isLocatorVisibleAfterLoad(uploadCSVBtn, GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT);
    }

    /**
     * check Kost Name search bar is visible
     * @return boolean element status
     */
    public boolean isKostNameSearchAppears() {
        return playwright.isLocatorVisibleAfterLoad(kostName, GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT);
    }

    /**
     * check Owner Name search bar is visible
     * @return boolean element status
     */
    public boolean isOwnerNameSearchAppears() {
        return playwright.isLocatorVisibleAfterLoad(ownerName, GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT);
    }

    /**
     * check Owner Phone Number search bar is visible
     * @return boolean element status
     */
    public boolean isOwnerPhoneNumberSearchAppears() {
        return playwright.isLocatorVisibleAfterLoad(ownerPhoneNumber, GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT);
    }

    /**
     * check All Level dropdown is visible
     * @return boolean element status
     */
    public boolean isAllLevelDropdownAppears() {
        return playwright.isLocatorVisibleAfterLoad(allLevelDropdown, GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT);
    }

    /**
     * check Search button is visible
     * @return boolean element status
     */
    public boolean isSearchButtonAppears() {
        return playwright.isLocatorVisibleAfterLoad(searchBtn, GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT);
    }

    /**
     * get String Coloumn Name
     * @param index coloumn
     * @return string coloumn name
     */
    public String getColumnName(int index) {
        columnName = page.locator("(//tr/th)[" +index+ "]");
        return playwright.getText(columnName);
    }

    /**
     * clicks on Page Number on Kist List page
     * @param pageNumber
     */
    public void clicksOnPageNumber(String pageNumber) {
        pageNumberBtn = page.locator("//a[@class='page-link'][text()='" +pageNumber+ "']");
        playwright.clickOn(pageNumberBtn);
    }

    /**
     * get String Active Page Number
     * @param pageNumber
     * @return string active page number
     */
    public String pageNumberButtonIsActive(String pageNumber) {
        playwright.waitTillPageLoaded(GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT);
        pagination = page.locator("//span[@class='page-link'][text()='" +pageNumber+ "']/parent::li");
        playwright.waitTillLocatorIsVisible(pagination);
        return playwright.getAttributeValue(pagination, "class");
    }

    /**
     * Search Kost on Kost Name search bar
     * @param kost
     */
    public void searchKostName(String kost) {
        playwright.fill(kostName, kost);
        playwright.clickOn(searchBtn);
        playwright.waitTillPageLoaded(GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT);
    }

    /**
     * Clicks Edit Kost Level
     */
    public void clicksEditKostLevel() {
        playwright.clickOn(editKostLevelBtn);
    }

    /**
     * Select Kost Level on dropdown
     * @param level
     */
    public void selectKostLevel(String level) {
        playwright.selectDropdownByValue(kosLevelDropdown, level);
    }

    /**
     * Clicks Save on Kost List page
     */
    public void clicksSave() {
        playwright.clickOn(saveBtn);
    }

    /**
     * get String Level Name
     * @return string level name
     */
    public String getLevelName() {
        return playwright.getText(levelNameText);
    }

    /**
     * Selects Charge By on Kost List
     * @param charge
     */
    public void selectChargeBy(String charge) {
        playwright.selectDropdownByValue(chargeBy, charge);
    }

    /**
     * get String Charge By on Kost List
     * @return string charge by
     */
    public String getChargeBy() {
        return playwright.getText(chargeByDropdowntText);
    }
}
