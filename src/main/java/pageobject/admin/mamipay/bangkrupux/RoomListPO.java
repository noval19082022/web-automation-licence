package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import config.global.GlobalConfig;
import utilities.PlaywrightHelpers;

public class RoomListPO {
    private Page page;
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);

    Locator roomListBtn;
    Locator pageNumberBtn;
    Locator pagination;
    Locator roomName;
    Locator searchBtn;
    Locator editRoomLevelBtn;
    Locator roomLevelDropdown;
    Locator saveBtn;
    Locator roomLevelNameText;
    Locator assignAllBtn;
    Locator submitAssignBtn;
    Locator roomLevelTable;
    Locator roomNameTable;
    Locator roomListPage;
    Locator floorTable;
    Locator occupiedTable;
    Locator levelTable;

    public RoomListPO(Page page){
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        roomListBtn = page.locator("//a[contains(text(),'Room List')]");
        roomName = page.getByPlaceholder("Room Name");
        searchBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Search"));
        editRoomLevelBtn = page.locator("//*[@title='Edit Room Level']");
        roomLevelDropdown = page.locator("//select[@id='level-id']");
        saveBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save"));
        roomLevelNameText = page.locator("(//tbody/tr/td)[5]");
        assignAllBtn = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Assign All"));
        submitAssignBtn = page.locator("(//*[@class='btn btn-primary'])[3]");
        roomListPage = page.locator("//h3[contains(., 'Room List')]");
    }

    /**
     * Clicks Room List button
     */
    public void clicksRoomList() {
        playwright.clickOn(roomListBtn);
        playwright.waitTillLocatorIsVisible(roomListPage, GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT);
    }

    /**
     * Clicks Page Number on Room List page
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

    /**
     * Search Room Name on Room Name search bar
     * @param room
     */
    public void searchRoomName(String room) {
        playwright.fill(roomName, room);
        playwright.clickOn(searchBtn);
    }

    /**
     * Clicks Edit Room Level
     */
    public void clicksEditRoomLevelBtn() {
        playwright.clickOn(editRoomLevelBtn);
    }

    /**
     * Select Room Level on Room List page
     * @param roomLevel
     */
    public void selectRoomLevel(String roomLevel){
        playwright.selectDropdownByValue(roomLevelDropdown, roomLevel);
    }

    /**
     * Clicks Save on Room List page
     */
    public void clicksSave() {
        playwright.clickOn(saveBtn);
    }

    /**
     * get String Room Level name
     * @return String Room Level name
     */
    public String getLevelName() {
        return playwright.getText(roomLevelNameText);
    }

    /**
     * Clicks Assign All button on Room List page
     */
    public void clicksAssignAllBtn() {
        playwright.clickOn(assignAllBtn);
    }

    /**
     * Click Submit on Assign All pop up
     */
    public void clicksSubmit() {
        playwright.clickOn(submitAssignBtn);
        playwright.waitTillPageLoaded(GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT);
        playwright.waitTillLocatorIsVisible(roomListPage, GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT);
    }

    /**
     * Check All Room Level Name is Equal
     * @param level
     * @return boolean element is equal
     */
    public boolean allRoomLevelNameEqual(String level) {
        boolean result = false;

        roomLevelTable = page.locator("tr td:nth-of-type(5)");
        roomNameTable = page.locator("tr td:nth-of-type(2)");

        for (int i=0; i<roomLevelTable.count(); i++){
            String actualLevel = playwright.getText(roomLevelTable.nth(i));
            String roomName = playwright.getText(roomNameTable.nth(i));
            //compare actual and expected level name
            result = actualLevel.equalsIgnoreCase(level);

            //break if result is false, and give information about which room is not equals to expected level
            if (result == false){
                System.out.println("Room "+roomName+ " is not equal to "+level);
                System.out.println("Room level in room "+roomName+" = "+actualLevel);
                break;
            }
        }
        return result;
    }

    /**
     * Get Integer Total Room Name data in Table
     * @return Integer Total Room Name data
     */
    public int getTotalRoomName(){
        roomNameTable = page.locator("tr td:nth-of-type(2)");
        return playwright.getLocators(roomNameTable).size();
    }

    /**
     * Get String Room Name in Table
     * @param indexRoomName
     * @return String Room Name
     */
    public String getRoomNameInTable(int indexRoomName) {
        roomNameTable = page.locator("tr td:nth-of-type(2)").nth(indexRoomName);
        return playwright.getText(roomNameTable);
    }

    /**
     * Get String Floor in Table
     * @param indexFloor
     * @return String Floor
     */
    public String getFloorInTable(int indexFloor) {
        floorTable = page.locator("tr td:nth-of-type(3)").nth(indexFloor);
        return playwright.getText(floorTable);
    }

    /**
     * Get String Occupied in Table
     * @param indexOccupied
     * @return String Occupied
     */
    public String getOccupiedInTable(int indexOccupied) {
        occupiedTable = page.locator("tr td:nth-of-type(4)").nth(indexOccupied);
        return playwright.getText(occupiedTable);
    }

    /**
     * Get String Level in Table
     * @param indexLevel
     * @return String Level
     */
    public String getLevelInTable(int indexLevel) {
        levelTable = page.locator("tr td:nth-of-type(5)").nth(indexLevel);
        return playwright.getText(levelTable);
    }
}
