package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import config.global.GlobalConfig;
import utilities.PlaywrightHelpers;

public class KostListHistoryPO {
    private Page page;
    PlaywrightHelpers playwright;

    Locator historyListBtn;
    Locator historyListPage;
    Locator columnName;
    Locator roomNameField;
    Locator ownerNameField;

    public KostListHistoryPO(Page page) {
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        historyListBtn = page.locator("//a[contains(text(),'History')]");
        historyListPage = page.locator("//h3[contains(., 'Kost Level History')]");
        roomNameField = page.locator("input[type='text']").nth(0);
        ownerNameField = page.locator("input[type='text']").nth(1);
    }

    /**
     * Click Kost List History button
     */
    public void clickKostListHistory() {
        playwright.clickOn(historyListBtn);
        playwright.waitTillLocatorIsVisible(historyListPage, GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT);
    }

    /**
     * Get String Kost List History Column Table
     * @param columnKostListHistory
     * @return String Kost List History Column Table
     */
    public String getKostListHistoryColumnTable(String columnKostListHistory) {
        columnName = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(columnKostListHistory).setExact(true));
        return playwright.getText(columnName);
    }

    /**
     * Get Room Name Text
     * @return String Value of Room Name
     */
    public String getRoomNameText() {
        return roomNameField.inputValue();
    }

    /**
     * Get Owner Name Text
     * @return String Value of Owner Name
     */
    public String getOwnerNameText() {
        return ownerNameField.inputValue();
    }
}