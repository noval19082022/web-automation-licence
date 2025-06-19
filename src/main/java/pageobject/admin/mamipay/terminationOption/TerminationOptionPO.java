package pageobject.admin.mamipay.terminationOption;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;

public class TerminationOptionPO {
    private Page page;
    private PlaywrightHelpers playwright;

    private Locator terminationOptionMenu;
    private Locator addTerminationButton;
    private Locator reasonField;
    private Locator subreasonField;
    private Locator showOnDropdown;
    private Locator AddOptionButton;
    private Locator updateOptionButton;
    private Locator toastMessageText;
    private Locator reasonText;
    private Locator deleteButton;
    private Locator plusButton;
    private Locator editButton;
    private Locator upArrow;
    private Locator downArrow;

    public TerminationOptionPO(Page page){
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);

        terminationOptionMenu = page.getByRole(AriaRole.LINK).filter(new Locator.FilterOptions().setHasText("Termination Option"));
        addTerminationButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add Termination Option"));
        reasonField = page.getByRole(AriaRole.TEXTBOX);
        subreasonField = page.getByRole(AriaRole.TEXTBOX).last();
        showOnDropdown = page.getByRole(AriaRole.COMBOBOX);
        AddOptionButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add Option"));
        updateOptionButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Update Option"));
        toastMessageText = page.locator(".callout");
    }


    /**
     * Click on termination option menu
     */
    public void clickTerminationOptionMenu() {
        playwright.clickOn(terminationOptionMenu);
    }

    /**
     * Add new reason
     * @param reason reason name
     * @param showOn show on dropdown
     */
    public void addNewReason(String reason, String showOn) {
        playwright.clickOn(addTerminationButton);
        playwright.fill(reasonField, reason);
        playwright.selectDropdownByValue(showOnDropdown, showOn);
        playwright.clickOn(AddOptionButton);
    }

    /**
     * Get toast message
     * @return String toast message
     */
    public String getToastMessage() {
        return playwright.getText(toastMessageText);
    }

    /**
     * Check if reason visible in Owner table
     * @param reason reason name
     * @return boolean
     */
    public boolean isOwnerReasonVisible(String reason) {
        reasonText = page.locator("table").nth(0).getByText(reason);
        return playwright.isLocatorVisibleAfterLoad(reasonText,5000.0);
    }

    /**
     * Check if reason visible in Tenant table
     * @param reason reason name
     * @return boolean
     */
    public boolean isTenantReasonVisible(String reason) {
        reasonText = page.locator("table").nth(1).getByText(reason);
        playwright.pageScrollHeightToBottom();
        return playwright.isLocatorVisibleAfterLoad(reasonText,5000.0);
    }

    /**
     * Delete reason
     * @param reason reason name
     */
    public void deleteReason(String reason) {
        deleteButton = page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName(reason)).getByTitle("Remove").last();
        playwright.clickOn(deleteButton);
    }

    /**
     * Check if + button visible
     * @param reason reason name
     * @return boolean
     */
    public boolean isButtonPlusVisible(String reason) {
        plusButton = page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName(reason)).getByTitle("Add");
        return playwright.isLocatorVisibleAfterLoad(plusButton,5000.0);
    }

    /**
     * Add new subreason
     * @param subreason subreason name
     * @param reason reason name
     */
    public void addNewSubreason(String subreason, String reason) {
        plusButton = page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName(reason)).getByTitle("Add");
        playwright.clickOn(plusButton);
        playwright.fill(subreasonField, subreason);
        playwright.clickOn(AddOptionButton);
    }

    /**
     * Edit subreason
     * @param oldSubreason old subreason name
     * @param newSubreason new subreason name
     */
    public void editSubreason(String oldSubreason, String newSubreason) {
        editButton = page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName(oldSubreason)).getByTitle("Remove").first();
        playwright.clickOn(editButton);
        playwright.fill(subreasonField, newSubreason);
        playwright.clickOn(updateOptionButton);
    }

    /**
     * Move subreason
     * @param direction move direction
     * @param subreason subreason name
     */
    public void moveSubreason(String direction, String subreason) {
        upArrow = page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName(subreason)).getByTitle("Move Up");
        downArrow = page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName(subreason)).getByTitle("Move Down");

        if (direction.equalsIgnoreCase("up")){
            playwright.clickOn(upArrow);
        } else if (direction.equalsIgnoreCase("down")){
            playwright.clickOn(downArrow);
        }
    }

    /**
     * Get subreason
     * @param i index
     * @return String
     */
    public String getSubreason(int i) {
        return playwright.getText(page.locator("tr:nth-child("+(24+i)+")"));
    }

    /**
     * Delete subreason
     * @param subreason subreason name
     */
    public void deleteSubreason(String subreason) {
        deleteButton = page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName(subreason)).getByTitle("Remove").last();
        playwright.clickOn(deleteButton);
    }
}
