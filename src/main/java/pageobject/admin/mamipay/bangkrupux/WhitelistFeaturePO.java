package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class WhitelistFeaturePO {
    private Page page;
    private PlaywrightHelpers playwright;
    Locator buttonAdd;
    Locator selectFeature;
    Locator inputOwnerId;
    Locator ownerIdPlaceHolder;
    Locator searchBtn;
    Locator deleteBtn;

    public WhitelistFeaturePO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        buttonAdd = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Add"));
        selectFeature = page.locator("//select[@name='name']");
        inputOwnerId = page.getByPlaceholder("user_id");
        ownerIdPlaceHolder = page.getByPlaceholder("Owner Id");
        searchBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Search"));
        deleteBtn = page.getByTitle("delete");
    }

    /**
     * Choose feature whitelist
     */
    public void chooseFeatureWhitelist(String feature) {
        playwright.selectDropdownByValue(selectFeature, feature);
    }

    /**
     * input user id (owner id)
     */
    public void inputOwnerId(String ownerId) {
        playwright.fill(inputOwnerId, ownerId);
    }

    /**
     * click on button add whitelist feature
     */
    public void addButtonWhitelist() {
        playwright.clickOn(buttonAdd);
    }

    /**
     * Get Text of alert from whitelist feature
     *
     * @return Text of Messsage Allert
     */
    public String getTitleMessageAllertWhitelist(String message) {
        Locator messageAllert = page.getByText(message);
        return playwright.getText(messageAllert);
    }

    /**
     * search owner by user_d
     *
     * @param userId
     */
    public void searchByUserId(String userId) {
        playwright.clickLocatorAndTypeKeyboard(ownerIdPlaceHolder, userId);
        playwright.clickOn(searchBtn);
    }

    /**
     * clickOn delete Btn
     *
     * @param index
     */
    public void clickOnDeleteBtn(String index) {
        var order = Integer.parseInt(index);
        // Ensure the position is at least 1
        var position = Math.max(order, 1);

        // Adjust for 0-based indexing in Playwright
        var deleteButton = deleteBtn.nth(position - 1);

        // Click and accept the dialog
        if (playwright.waitTillLocatorIsVisible(deleteButton)) {
            playwright.acceptDialog(deleteButton);
        } else {
            playwright.reloadPage();
        }
    }
}