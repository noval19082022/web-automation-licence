package steps.mamikos.admin;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.admin.mamipay.bangkrupux.RoomListPO;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

public class RoomListSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    RoomListPO roomList = new RoomListPO(page);

    //---test data---//
    private String roomLevel = "src/test/resources/testdata/bangkerupuxAdmin/roomLevel.properties";
    private String regularLevel = JavaHelpers.getPropertyValue(roomLevel, "roomLevelRegular");
    private String roomPMAN = JavaHelpers.getPropertyValue(roomLevel, "roomPMAN");

    @When("admin clicks on Room List")
    public void admin_clicks_on_Room_List(){
        roomList.clicksRoomList();
    }

    @When("admin click page number {string} on Room List")
    public void admin_click_page_number_on_Room_List(String pageNumber){
        roomList.clicksOnPageNumber(pageNumber);
    }

    @Then("system display Room List page number {string} is active")
    public void system_display_Room_List_page_number_is_active(String pageNumber){
        Assert.assertTrue(roomList.pageNumberButtonIsActive(pageNumber).contains("active"), "Button is not active");
    }

    @When("admin search room by room name {string}")
    public void admin_search_room_by_room_name(String room){
        roomList.searchRoomName(room);
    }

    @When("admin change room level to {string} on Room List")
    public void admin_change_room_level_to_on_Room_List(String roomLevel){
        roomList.clicksEditRoomLevelBtn();

        if (roomLevel.equalsIgnoreCase("Reguler")){
            roomList.selectRoomLevel(regularLevel);
            roomList.clicksSave();
        } else {
            roomList.selectRoomLevel(roomLevel);
            roomList.clicksSave();
        }
    }

    @Then("the room Level is displaying {string}")
    public void the_room_level_is_displaying(String room){
        roomList.searchRoomName(roomPMAN);

        if (room.equalsIgnoreCase("Reguler")){
            Assert.assertEquals(roomList.getLevelName(),"Regular","level name not equals");
        } else {
            Assert.assertEquals(roomList.getLevelName(), room,"level name not equals");
        }
    }

    @When("admin clicks Assign All button")
    public void admin_clicks_Assign_All_button(){
        roomList.clicksAssignAllBtn();
    }

    @When("admin change room level to {string} on Assign All Rooms")
    public void admin_change_room_level_to_on_Assign_All_Rooms(String room){
        if (room.equalsIgnoreCase("Reguler")){
            roomList.selectRoomLevel(regularLevel);
            roomList.clicksSubmit();
        } else {
            roomList.selectRoomLevel(room);
            roomList.clicksSubmit();
        }
    }

    @Then("all room level is changed to {string}")
    public void all_room_level_is_changed_to(String level){
        Assert.assertTrue(roomList.allRoomLevelNameEqual(level));
        System.out.println(roomList.allRoomLevelNameEqual(level));
    }
}
