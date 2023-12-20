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
}