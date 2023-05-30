package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

import java.util.List;

public class RewardManagementPO {
    private Page page;
    private PlaywrightHelpers playwright;
    Locator rewardListMenu;
    Locator rewardListHeader;
    Locator filterButton;
    Locator addRewardButton;
    Locator rewardNameFilter;
    Locator updateButton;
    Locator activeCheckbox;
    Locator updateRewardButton;
    Locator yesUpdateRewardButton;
    Locator successAddRewardLabel;
    Locator addRewardNameTextBox;
    Locator addDescriptionTextBox;
    Locator addTotalQuotaTextBox;
    Locator startDateReward;
    Locator dateToday;
    Locator endDateReward;
    Locator addTotalEachTextBox;
    Locator addRedemptionPointTextBox;
    Locator sequenceReward;
    Locator addRewardType;
    Locator addRewardSubmit;

    public RewardManagementPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        rewardListMenu = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Reward List"));
        rewardListHeader = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Reward List Management").setExact(true));
        filterButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Filter"));
        addRewardButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Add Reward"));
        rewardNameFilter = page.getByPlaceholder("ID / Reward Name");
        updateButton = page.locator("//*[@class='fa fa-pencil']").first();
        activeCheckbox = page.locator("label").filter(new Locator.FilterOptions().setHasText("Active")).getByRole(AriaRole.INSERTION);
        updateRewardButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Update Reward"));
        yesUpdateRewardButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Yes, Do It!"));
        successAddRewardLabel = page.locator(".alert");
        addRewardNameTextBox = page.locator("input[name=\"name\"]");
        addDescriptionTextBox = page.locator("textarea[name=\"description\"]");
        startDateReward = page.locator("//input[@name='start_date']");
        addTotalQuotaTextBox = page.locator("input[name=\"quota\\[total\\]\"]");
        dateToday = page.locator("//*[@class=' ui-datepicker-days-cell-over  ui-datepicker-today']");
        endDateReward = page.locator("//input[@name='end_date']");
        addTotalEachTextBox = page.locator("input[name=\"quota\\[total_user\\]\"]");
        addRedemptionPointTextBox = page.locator("input[name=\"redeem_value\"]");
        sequenceReward = page.locator("input[name=\"sequence\"]");
        addRewardType = page.locator("select[name=\"type_id\"]");
        addRewardSubmit = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add Reward"));

    }

    /**
     * Click on Reward List Menu on Left Bar
     *
     */
    public void clickOnRewardListMenu() {
        playwright.clickOn(rewardListMenu);
    }

    /**
     * Check success add new reward type label is displayed
     *
     * @return status true or false
     */
    public Boolean fieldOnTableIsDisplayed(Integer counter){
        Locator element = page.locator("//table[@class='table table-hover']//tr/th");
        List<Locator> elements = playwright.getLocators(element);
        return playwright.waitTillLocatorIsVisible(elements.get(counter));
    }

    /**
     * Check success add new reward type label is displayed
     *
     * @return status true or false
     */
    public boolean rewardListHeaderIsDisplayed() {
        return playwright.waitTillLocatorIsVisible(rewardListHeader);
    }

    /**
     * Check success add new reward type label is displayed
     *
     * @return status true or false
     */
    public boolean filterButtonIsDisplayed() {
        return playwright.waitTillLocatorIsVisible(filterButton);
    }

    /**
     * Check success add new reward type label is displayed
     *
     * @return status true or false
     */
    public boolean addRewardButtonIsDisplayed() {
        return playwright.waitTillLocatorIsVisible(addRewardButton);
    }

    /**
     * input reward type name on filter reward list
     * @param rewardName
     */
    public void setRewardTypeNameOnFilter(String rewardName) {
        rewardNameFilter.fill(rewardName);
    }

    /**
     * Click fliter button on reward list
     *
     */
    public void clickOnFilterRewardList() {
        playwright.clickOn(filterButton);
    }

    /**
     * Click update button on reward list
     *
     */
    public void clickOnUpdateRewardList() {
        playwright.clickOn(updateButton);
    }

    /**
     * set status reward list
     *
     */
    public void setStatusRewardList() {
        playwright.clickOn(activeCheckbox);
    }

    /**
     * Click update button on page detail reward
     *
     */
    public void clickOnUpdateReward() {
        playwright.clickOn(updateRewardButton);
        playwright.hardWait(3000);
        playwright.clickOn(yesUpdateRewardButton);
    }

    /**
     * Check success add new reward type label is displayed
     *
     * @return status true or false
     */
    public boolean successAddRewardTypeIsDisplayed() {
        playwright.hardWait(3000);
        return playwright.waitTillLocatorIsVisible(successAddRewardLabel);
    }

    /**
     * Click add reward button on reward list management page
     *
     */
    public void clickOnAddRewardButton() {
        playwright.clickOn(addRewardButton);
    }

    /**
     * input rewald field with correct value
     *
     */
    public void inputRewardField() {
        addRewardNameTextBox.fill("Add Active Reward Automation");
        addDescriptionTextBox.fill("Reward from Automation");
        playwright.clickOn(startDateReward);
        playwright.clickOn(dateToday);
        playwright.clickOn(endDateReward);
        playwright.clickOn(dateToday);
        addTotalQuotaTextBox.fill("100");
        addTotalEachTextBox.fill("10");
        playwright.selectDropdownByValue(addRewardType,"11");
        addRedemptionPointTextBox.fill("10");
        sequenceReward.fill("1");
    }

    /**
     * Click Add Reward button on Add Reward Page
     *
     */
    public void clickOnSubmmitReward() {
        playwright.clickOn(addRewardSubmit);
    }
}
