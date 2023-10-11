package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

import java.nio.file.Paths;
import java.util.Locale;

public class OwnerChatExperimentPO {
    private Page page;
    private PlaywrightHelpers playwright;

    Locator ownerChatExperimentMenu;
    Locator addOwnerButton;
    Locator ownerIDTextBox;
    Locator addButton;
    Locator ownerIdSearchBox;
    Locator searchButton;
    Locator userIdElement;
    Locator deleteButton;
    Locator closeButton;
    Locator bulkAddButton;
    Locator chooseFileButton;

    public OwnerChatExperimentPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);

        ownerChatExperimentMenu = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Owner Chat Experiment"));
        addOwnerButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Add Owner"));
        ownerIDTextBox = page.locator("input[name=\"user_id\"]");
        addButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add").setExact(true));
        ownerIdSearchBox = page.getByPlaceholder("Owner Id");
        searchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Search"));
        deleteButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(""));
        closeButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Close"));
        bulkAddButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Bulk Add"));
        chooseFileButton = page.locator("input[name=\"user_ids_file\"]");
    }

    /**
     * click menu Owner Cha tExperiment
     */
    public void clickOwnerChatExperimentMenu() {
        playwright.clickOn(ownerChatExperimentMenu);
    }

    /**
     * click on button add owner
     */
    public void clickOnAddOwnerButton() {
        playwright.clickOn(addOwnerButton);
    }

    /**
     * input owner id
     */
    public void inputOwnerId(String ownerID) {
        playwright.fill(ownerIDTextBox, ownerID);
    }

    /**
     * click button add owner on pop up
     */
    public void clickOnAddButton() {
        playwright.clickOn(addButton);
    }

    /**
     * search owner id
     */
    public void searchOwnerId(String ownerID) {
        playwright.fill(ownerIdSearchBox, ownerID);
    }

    /**
     * click on search button
     */
    public void clickOnSearchutton() {
        playwright.clickOn(searchButton);
    }

    /**
     * Verify userId is present or not
     * @param userId
     * return user id true or false
     */
    public boolean isUserIdPresent(String userId) {
        userIdElement = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(userId));
        return playwright.waitTillLocatorIsVisible(userIdElement);
    }

    /**
     * Click delete button
     */
    public void clickOnDeleteButton() {
        playwright.clickOn(deleteButton);
    }

    /**
     * Click close button
     */
    public void clickOnCloseButton() {
        playwright.clickOn(closeButton);
    }

    /**
     * click on button bulk add
     */
    public void clickOnBulkAddButton() {
        playwright.clickOn(bulkAddButton);
    }

    /**
     * Upload csv file for bulk add
     */
    public void uploadBulkAddCSVFile() {
        chooseFileButton.setInputFiles(Paths.get("src/main/resources/file/ownerId.csv"));
        playwright.hardWait(2000);
    }
}
