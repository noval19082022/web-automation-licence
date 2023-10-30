package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import pageobject.common.LoginPO;
import utilities.PlaywrightHelpers;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class PointManagementPO extends LoginPO {

    Locator inputSearch;
    Locator ownerRoomGroupMenu;
    Locator addOwnerRoomGroupButton;
    Locator roomGroupFloorField;
    Locator roomGroupFloorCeil;
    Locator saveButton;
    Locator titleMessageAllert;
    Locator contentMessageAllert;
    Locator dataAdded;
    Locator ownerSettingMenu;
    Locator errorEmptyData;
    Locator roomGroupList;
    Locator editButton;
    Locator deleteButton;
    Locator pagination;
    Locator fieldTable;

    public PointManagementPO(Page page) {
        super(page);
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        inputSearch = page.getByPlaceholder("Name / Email / Phone");
        ownerRoomGroupMenu = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Owner Room Group"));
        addOwnerRoomGroupButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Add Owner Room Group"));
        roomGroupFloorField = page.getByLabel("Room Group");
        roomGroupFloorCeil = page.locator("#room-group-ceil");
        saveButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save"));
        titleMessageAllert = page.locator("b");
        contentMessageAllert = page.locator(".alert");
        ownerSettingMenu = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Owner Point Setting"));
        roomGroupList = page.locator("(//tbody[1]//td[2])");
        pagination = page.locator(".pagination");
    }

    /**
     * Search user based on Name / Email / Phone
     *
     * @param user name
     */
    public void searchUserpoinTextBox(String user) {
        inputSearch.fill(user);
    }

    /**
     * Status user as owner
     *
     * @param action whitelist or blacklist
     */
    public Locator statusUser(String action) {
        return page.locator("//td/a[contains(.,'" + action + "')]");
    }

    /**
     * Click on Owner Room Group on Point Management Left Bar
     */
    public void clickOnOwnerRoomGroupMenu() {
        playwright.clickOn(ownerRoomGroupMenu);
    }

    /**
     * Click on Add Owner Room Group Button
     */
    public void clickOnAddOwnerRoomGroupButton() {
        playwright.clickOn(addOwnerRoomGroupButton);
    }

    /**
     * Enter Text to Room Group Floor Field
     * @param floor room group floor
     */
    public void setRoomGroupFloor(String floor){
        playwright.fill(roomGroupFloorField, floor);
    }

    /**
     * Enter Text to Room Group Floor Ceil
     * @param ceil room group ceil
     */
    public void setRoomGroupCeil(String ceil){
        playwright.fill(roomGroupFloorCeil, ceil);
    }

    /**
     * Click on Save Button
     */
    public void clickOnSaveButton() {
        playwright.clickOn(saveButton);
    }

    /**
     * Get Text of Title Message Allert in Segment Page
     * @return Text of Title Messsage Allert
     */
    public String getTitleMessageAllert() {
        playwright.waitTillLocatorIsVisible(titleMessageAllert);
        return playwright.getText(titleMessageAllert);
    }

    /**
     * Get Text of Content Message Allert in Segment Page
     * @return Text of Content Messsage Allert
     */
    public String getContentMessageAllert(){
        return playwright.getText(contentMessageAllert);
    }

    /**
     * Check if Room Group is Present
     *
     * @param group room group
     * @return boolean
     */
    public boolean checkRoomGroupIsPresent(String group){
        dataAdded = page.locator("//td[contains(.,'"+group+"')]").first();
        return playwright.waitTillLocatorIsVisible(dataAdded);
    }

    /**
     * Click on Owner Setting Menu on Point Management Left Bar
     */
    public void clickOnOwnerSettingMenu() {
        playwright.clickOn(ownerSettingMenu);
    }

    /**
     * assert Text of Activity Validation
     */
    public void assertActivityValidationMessage(String validation) {
        errorEmptyData = page.getByText(validation);
        assertThat(errorEmptyData).containsText(validation);
    }

    /**
     * Get Number of Owner Room Group List
     * @return owner room group list number
     */
    public int getRoomGroupNumber(){
        return playwright.getLocators(roomGroupList).size();
    }

    /**
     * Get Text of Owner Room Group
     * @return owner room group text
     */
    public String getGroupText(int index){
        List<Locator> elements = playwright.getLocators(roomGroupList);
        playwright.waitTillLocatorIsVisible(elements.get(index));
        return playwright.getText(elements.get(index));
    }

    /**
     * Click on Icon Edit Room Group
     * @param row group
     */
    public void clickOnEditRoomGroup(int row){
        editButton = page.locator("//tbody[1]/tr["+row+"]//i[@class='fa fa-pencil']");
        playwright.clickOn(editButton);
    }

    /**
     * Click on Icon Delete Room Group
     * @param row group
     */
    public void clickOnDeleteRoomGroup(int row) {
        deleteButton = page.locator("//tbody[1]/tr["+row+"]//i[@class='fa fa-trash']");
        playwright.clickOn(deleteButton);
        playwright.acceptDialog(deleteButton);
    }

    /**
     * Is Pagination Appear?
     * @return true or false
     */
    public Boolean isPaginationAppear(){
        return playwright.waitTillLocatorIsVisible(pagination);
    }

    /**
     * Get Table Title Index
     * @param index input integer that will match table head index
     * @return string
     */
    public String getTableTitleText(int index){
        fieldTable = page.locator("//tr/th["+index+"]");
        return playwright.getText(fieldTable);
    }

}
