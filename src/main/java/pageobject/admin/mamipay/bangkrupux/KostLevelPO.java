package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import config.global.GlobalConfig;
import utilities.PlaywrightHelpers;

public class KostLevelPO {
    private Page page;
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);

    Locator columnName;
    Locator pagination;
    Locator pageNumberBtn;
    Locator addKostLevelButton;
    Locator searchKostLevelNameInput;
    Locator searchKostLevelNameButton;

    public KostLevelPO(Page page) {
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        searchKostLevelNameInput = page.getByPlaceholder("Level Name");
        searchKostLevelNameButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Search"));
        addKostLevelButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Add Kost Level"));
    }

    /**
     * Get String Kost Level Column Table
     * @param columnKostLevel
     * @return String Kost Level Column Table
     */
    public String getKostLevelColumnTable(String columnKostLevel) {
        columnName = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(columnKostLevel).setExact(true));
        System.out.println(columnName);
        return playwright.getText(columnName);
    }

    /**
     * Check the visibility of button add kost level
     * @return boolean
     */
    public boolean isButtonAddKostLevelVisible() {
        return playwright.waitTillLocatorIsVisible(addKostLevelButton);
    }

    /**
     * Check the visibility of search field and button search kost level
     * @return boolean
     */
    public boolean isSearchFieldAndButtonLevelVisible() {
        return playwright.waitTillLocatorIsVisible(searchKostLevelNameInput) &&
                playwright.waitTillLocatorIsVisible(searchKostLevelNameButton);
    }

    /**
     * clicks on Page Number on Kost Level page
     * @param pageNumber
     */
    public void clicksOnPageNumber(String pageNumber) {
        pageNumberBtn = page.locator("//a[@class='page-link'][text()='" +pageNumber+ "']");
        playwright.clickOn(pageNumberBtn);
    }

    /**
     * get String Active Page Number
     * @param pageNumber
     * @return String Active Page Number
     */
    public String pageNumberButtonIsActive(String pageNumber) {
        playwright.waitTillPageLoaded(GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT);
        pagination = page.locator("//span[@class='page-link'][text()='" +pageNumber+ "']/parent::li");
        playwright.waitTillLocatorIsVisible(pagination);
        return playwright.getAttributeValue(pagination, "class");
    }
}