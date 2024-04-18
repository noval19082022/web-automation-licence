package steps.mamikos.admin;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.admin.mamipay.bangkrupux.LevelManagementPO;
import utilities.PlaywrightHelpers;

public class LevelManagementSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    LevelManagementPO levelManagementPO = new LevelManagementPO(ActiveContext.getActivePage());

    @And("admin click on add {string} level")
    public void adminClickOnAddLevel(String levelType) {
        levelManagementPO.clickAddKostLevel(levelType);
    }

    @And("admin fill out form {string} level {string}")
    public void adminFillOutFormLevel(String type, String levelText) {
        if (type.equals("add kost")){
            levelManagementPO.inputFormKostLevel("level-name", levelText);
            levelManagementPO.setKostLevelName(levelText);
            levelManagementPO.inputFormKostLevel("level-notes", "Untuk Testing Automation Web");
            levelManagementPO.inputBenefits();
        } else if (type.equals("edit kost")){
            levelManagementPO.inputFormKostLevel("level-name", levelText);
            levelManagementPO.setKostLevelName(levelText);
        } else if (type.equals("add room")){
            levelManagementPO.inputFormKostLevel("level-name", levelText);
            levelManagementPO.setRoomLevelName(levelText);
            levelManagementPO.inputFormKostLevel("level-notes", "Untuk Testing Automation Web");
            levelManagementPO.inputFormKostLevel("level-charging-name", "Automation");
            levelManagementPO.inputFormKostLevel("level-count", "20");
        } else if (type.equals("edit room")){
            levelManagementPO.inputFormKostLevel("level-name", levelText);
            levelManagementPO.setRoomLevelName(levelText);
            levelManagementPO.inputFormKostLevel("level-charging-name", "Automation");
            levelManagementPO.inputFormKostLevel("level-count", "10000");
            levelManagementPO.selectChargingType("Amount");
        }
        levelManagementPO.clickOnSaveButton();
    }

    @And("admin {string} save kost level data pop up confirmation")
    public void adminSaveKostLevelDataPopUpConfirmation(String actionText) {
        levelManagementPO.clickOnButtonPopUpConfirmation(actionText);
    }

    @Then("verify the {string} level {string} already displayed")
    public void verifyTheLevelAlreadyDisplayed(String type, String levelName) {
        if (type.equals("kost")){
            Assert.assertEquals(levelManagementPO.getKostLevelName(), levelName, "Kost level doesn't match!");
        } else if(type.equals("room")){
            Assert.assertEquals(levelManagementPO.getRoomLevelName(), levelName, "Kost level doesn't match!");
        }
    }

    @Then("verify pop up message {string} success added")
    public void verifyPopUpMessageSuccessAdded(String messageText) {
        Assert.assertEquals(levelManagementPO.getMessageValidation(), messageText, "Message doesn't match!");
        levelManagementPO.clickOnButtonPopUpConfirmation("confirm");
    }

    @When("admin click {string} on kost level")
    public void adminClickOnKostLevel(String action) {
       if (action.equals("edit")){
           levelManagementPO.clickEditKostLevel();
       } else{
           levelManagementPO.clickDeleteKostLevel();
       }
    }

    @Then("verify success {string} message is displayed")
    public void verifySuccessMessageIsDisplayed(String type) {
        if (type.equals("add rooms")) {
            Assert.assertEquals(levelManagementPO.getSuccessDeleteMessage(), "Success! Room level was successfully added.", "message doesn't match!");
        } else if (type.equals("delete")) {
            Assert.assertEquals(levelManagementPO.getSuccessDeleteMessage(), "Success! Level successfully deleted.", "message doesn't match!");
        } else if (type.equals("delete room")){
            Assert.assertEquals(levelManagementPO.getSuccessDeleteMessage(), "Success! Room Level was successfully deleted.", "message doesn't match!");
        } else if (type.equals("edit room")){
            Assert.assertEquals(levelManagementPO.getSuccessDeleteMessage(), "Success! Room Level was successfully updated.", "message doesn't match!");
        }
    }

    @When("admin search {string} level")
    public void adminSearchLevel(String type) {
        levelManagementPO.searchLevelName(type);
        levelManagementPO.clickOnSearchButton();
    }

    @When("admin access menu {string} sub menu of management level")
    public void admin_access_menu_sub_menu_of_management_level(String submenu){
        levelManagementPO.clickOnSubMenuOfManagementLevel(submenu);
    }
    @When("admin add new kost level {string} with charging fee {string}")
    public void admin_add_new_kost_level_with_charging_fee(String name, String fee) {
        levelManagementPO.clickAddKostLevel("Kost");
        levelManagementPO.inputFormKostLevel("level-name", name);
        levelManagementPO.setKostLevelName(name);
        levelManagementPO.setChargingFee(fee);
        levelManagementPO.clickOnSaveButton();
        levelManagementPO.clickOnButtonPopUpConfirmation("confirm");

    }
    @Then("show error message pop up {string}")
    public void show_error_message_pop_up(String message) {
        Assert.assertEquals(levelManagementPO.getErrorMessagePopUp(),message);
    }
    @When("admin edit charging fee to {string}")
    public void admin_edit_charging_fee_to(String fee) {
        levelManagementPO.clickEditKostLevel();
        levelManagementPO.setChargingFee(fee);
        levelManagementPO.clickOnSaveButton();
        levelManagementPO.clickOnButtonPopUpConfirmation("confirm");
    }
    @When("admin search kost level {string}")
    public void admin_search_kost_level(String name) {
        levelManagementPO.searchLevelName(name);
        levelManagementPO.clickOnSearchButton();
    }
}