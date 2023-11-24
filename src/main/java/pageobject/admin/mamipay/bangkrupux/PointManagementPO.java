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
    Locator keywordSearchField;
    Locator searchButton;
    Locator filterResultList;
    Locator userDropdown;
    Locator totalPointHeader;
    Locator userList;
    Locator statusList;
    Locator totalPointList;
    Locator blacklistStatus;
    Locator popUpConfirmationChangeStatusTitle;
    Locator popUpConfirmationChangeStatusBody;

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
        keywordSearchField = page.locator("//input[@name='keyword']");
        searchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Search"));
        filterResultList = page.locator("tbody > tr");
        userList = page.locator("(//td[4])");
        statusList = page.locator("(//td[6])");
        totalPointHeader = page.locator("//a[contains(.,'Total Point')]");
        totalPointList = page.locator("(//td[5])");
        blacklistStatus = page.locator("//td[6]/a[contains(.,'Blacklist')]");
        popUpConfirmationChangeStatusTitle = page.locator("//div[@class='modal-dialog']//h4[@class='modal-title']");
        popUpConfirmationChangeStatusBody  = page.locator("//div[@class='modal-dialog']//div[@class='modal-body']");

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


    /**
     * Set Keyword on Search Field
     *
     * @param keyword Keyword
     */
    public void setKeywordSearchField(String keyword) {
        playwright.fill(keywordSearchField, keyword);
    }

    /**
     * Click on Search Button
     *
     * @throws InterruptedException
     */
    public void clickOnSearchButton() throws InterruptedException {
       playwright.clickOn(searchButton);
    }

    /**
     * Get Number of Filter Result
     *
     * @return number of result
     */
    public int getFilterResultNumber() {
        List<Locator> elements = playwright.getLocators(filterResultList);
        return elements.size();
    }

    /**
     * Get Text of Filter Result
     *
     * @param row    row data
     * @param column column data
     * @return Text of Filter Result
     */
    public String getFilterResultList(int row, int column) {
        Locator element = page.locator("//tbody/tr[" + row + "]/td[" + column + "]");
        return  playwright.getText(element);
    }

    /**
     * Click on User Filter Dropdown
     *
     * @throws InterruptedException
     */
    public void clickOnUserDropdown() throws InterruptedException {
       playwright.clickOn(userDropdown);
    }

    /**
     * Select User Filter
     *
     * @param userType Tenant or Owner
     * @throws InterruptedException
     */
    public void selectUserFilter(String userType) throws InterruptedException {
        userDropdown = page.locator("select[name=\"user\"]");
        playwright.selectDropdownByValue(userDropdown,userType);
    }

    /**
     * Get Text of User Column from User Point List
     *
     * @param index row data user point
     * @return text of user column
     */
    public String getTextUserColumn(int index) {
        List<Locator> elements = playwright.getLocators(userList);
        return playwright.getText(elements.get(index));
    }

    /**
     * Get Text of Status Column from User Point List
     *
     * @param index row data user point
     * @return text of user column
     */
    public String getTextStatusColumn(int index) {
        List<Locator> elements = playwright.getLocators(statusList);
        return playwright.getText(elements.get(index));
    }

    /**
     * Select Status Filter
     *
     * @param status Blacklist or Whitelist
     * @throws InterruptedException
     */
    public void selectStatusFilter(String status) throws InterruptedException {
        userDropdown = page.locator("select[name=\"status\"]");
        playwright.selectDropdownByValue(userDropdown,status);
    }

    /**
     * Click on Total Point Header
     *
     * @throws InterruptedException
     */
    public void clickOnTotalPointHeader() throws InterruptedException {
        playwright.clickOn(totalPointHeader);
    }

    /**
     * Get Text of Total Point from User Point List
     *
     * @param index row data
     * @return text of Total Point
     */
    public String getTextTotalPoint(int index) {
        List<Locator> elements = playwright.getLocators(totalPointList);
        return playwright.getText(elements.get(index));
    }

    /**
     * Set default status to Whitelist
     * @throws InterruptedException
     */
    public void setDefaultStatusToWhitelist() throws InterruptedException {
        if (playwright.waitTillLocatorIsVisible(blacklistStatus)) {
            playwright.clickOn(blacklistStatus);
            playwright.clickOn(page.locator("//button[text()='Yes, Do It!']"));
        }
    }

    /**
     * Click on user point status
     *
     * @param initialStatus initial status of user point
     * @throws InterruptedException
     */
    public void clickOnUserPointStatus(String initialStatus) throws InterruptedException {
        playwright.clickOn(page.locator("//td/a[contains(.,'" + initialStatus + "')]"));
    }

    /**
     * Get Text of Title from Pop Up Confirmation Change Status
     *
     * @return text of Pop Up Confirmation Change Status Title
     */
    public String getTitlePopUpConfirmationChangeStatus() {
        return playwright.getText(popUpConfirmationChangeStatusTitle);
    }

    /**
     * Get Text of Body from Pop Up Confirmation Change Status
     *
     * @return text of Pop Up COnfirmation Change Status Body
     */
    public String getBodyPopUpConfirmationChangeStatus() {
        return playwright.getText(popUpConfirmationChangeStatusBody);
    }

    /**
     * Click on Button in Pop Up Confirmation
     *
     * @param confirmation to Whitelist or Blacklist
     * @throws InterruptedException
     */
    public void clickOnPopUpCOnfirmationButton(String confirmation) throws InterruptedException {
       playwright.clickOn(page.locator("//button[text()='" + confirmation + "']"));
    }
}
