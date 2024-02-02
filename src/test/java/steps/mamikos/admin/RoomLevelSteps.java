package steps.mamikos.admin;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.admin.mamipay.bangkrupux.RoomLevelPO;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

public class RoomLevelSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);

    //---Test Data---//
    private String roomLevelPage = "src/test/resources/testdata/bangkerupuxAdmin/roomLevel.properties";
    private String levelName = JavaHelpers.getPropertyValue(roomLevelPage, "levelName");
    private String levelNameForEdit = JavaHelpers.getPropertyValue(roomLevelPage, "levelNameForEdit");
    private String chargingName = JavaHelpers.getPropertyValue(roomLevelPage, "chargingName");
    private String chargingFee = JavaHelpers.getPropertyValue(roomLevelPage, "chargingFee");
    private String chargingRules = JavaHelpers.getPropertyValue(roomLevelPage, "chargingRules");
    private String errorMessageExistingKey = JavaHelpers.getPropertyValue(roomLevelPage, "errorMessageExistingKey");
    private String keyForEdit = JavaHelpers.getPropertyValue(roomLevelPage, "keyForEdit");

    RoomLevelPO roomLevel = new RoomLevelPO(page);

    @When("admin add room level with existing key {string}")
    public void admin_add_room_level_with_existing_key(String key){
        roomLevel.clicksAddRoomLevel();
        roomLevel.inputsLevelName(levelName);
        roomLevel.inputsKey(key);
        roomLevel.inputsChargingName(chargingName);
        roomLevel.inputsChargingFee(chargingFee);
        roomLevel.tickChargingRulesFor(chargingRules);
        roomLevel.clicksSave();
    }

    @Then("error message existing key is displayed")
    public void error_message_existing_key_is_displayed(){
        Assert.assertEquals(roomLevel.getErrorMessageExistingKey(), errorMessageExistingKey, "Toast does not match!");
    }

    @And("room level is not created")
    public void room_level_is_not_created(){
        roomLevel.searchLevelName(levelName);
        Assert.assertFalse(roomLevel.isLevelNameDisplayed(), "Level Name is Displayed!");
    }

    @When("admin edit room level with existing key {string}")
    public void admin_edit_room_level_with_existing_key(String key){
        roomLevel.searchLevelName(levelNameForEdit);
        roomLevel.editRoomLevel();
        roomLevel.inputsKey(key);
        roomLevel.clicksSave();
    }

    @Then("the key is not changed")
    public void the_key_is_not_changed(){
        Assert.assertEquals(roomLevel.getKeyAfterEdit(), keyForEdit, "The Key is Changed!");
    }
    @When("admin search room level {string}")
    public void admin_search_room_level(String name) {
        roomLevel.searchLevelName(name);
    }
    @When("admin edit room level with empty level name")
    public void admin_edit_room_level_with_empty_level_name() {
        roomLevel.editRoomLevel();
        roomLevel.inputsLevelName("");
        roomLevel.clicksSave();
    }
    @Then("show error message {string}")
    public void show_error_message(String error) {
        Assert.assertEquals(roomLevel.getErrorMessage(),error);
    }
    @Then("should show room level menu content")
    public void should_show_room_level_menu_content() {
        String[] expectedColumn = {"ID" , "Level Name", "Key", "Status", "Charging Name", "Charging Fee", "Charging Type", "Charge for Booking Contract", "Charge for Consultant Contract", "Charge for Owner Contract", "Invoice Type", "Notes", "Actions"};

        Assert.assertEquals(roomLevel.getMenuTitle(),"Manage Room Level");
        Assert.assertTrue(roomLevel.isButtonAddRoomLevelVisible());
        Assert.assertTrue(roomLevel.isSearchFieldVisible());
        Assert.assertTrue(roomLevel.isButtonSearchVisible());
        for (int i = 0; i < expectedColumn.length; i++) {
            Assert.assertEquals(roomLevel.getColumnName(i),expectedColumn[i]);
        }
    }
    @When("admin go to page {string}")
    public void admin_go_to_page(String page) {
        roomLevel.clickPaginationNumber(page);
    }
    @Then("page number {string} is active")
    public void page_number_is_active(String no) {
        Assert.assertEquals(roomLevel.getActivePaginationPage(),no);
    }
}