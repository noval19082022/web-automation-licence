package steps.mamikos.bangkrupux;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.admin.mamipay.bangkrupux.PointManagementPO;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;
import testdata.BangKrupuxTestData;

import java.util.List;

public class pointManagementSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    LocatorHelpers locator = new LocatorHelpers(page);
    PointManagementPO pointManagement = new PointManagementPO(page);

    @When("admin successfully {string} user named {string} with status {string}")
    public void admin_successfully_do_action_for_user_point(String action, String user, String status) {
        playwright.pageScrollUntilElementIsVisible(playwright.filterLocatorHasText(locator.span, "User Point"));
        playwright.clickOnText("User Point");
        pointManagement.searchUserpoinTextBox(user);
        playwright.clickOnText("Search");
        pointManagement.statusUser(status).click();
        playwright.clickOnTextButton("Yes, Do It!");
        Assert.assertTrue(playwright.isTextDisplayed("Success! " + user + " successfully "+action));
    }

    @And("user clicks on Point Management-Owner Room Group menu")
    public void userClicksOnPointManagementOwnerRoomGroupMenu() {
        pointManagement.clickOnOwnerRoomGroupMenu();
    }

    @And("user clicks on Add Owner Room Group button")
    public void userClicksOnAddOwnerRoomGroupButton() {
        pointManagement.clickOnAddOwnerRoomGroupButton();
    }

    @And("user create owner room group {string} until {string}")
    public void userCreateOwnerRoomGroupUntil(String ownerRoomGroup, String ownerRoomGroupUntil) {
        pointManagement.setRoomGroupFloor(ownerRoomGroup);
        BangKrupuxTestData.setOwnerRoomGroup(ownerRoomGroup);
        pointManagement.setRoomGroupCeil(ownerRoomGroupUntil);
        BangKrupuxTestData.setOwnerRoomGroupUntil(ownerRoomGroupUntil);
    }

    @Then("user verify allert success {string} and {string}")
    public void user_verify_allert_success_and(String titleMessage, String contentMessage) {
        Assert.assertEquals(pointManagement.getTitleMessageAllert(), titleMessage,"Title message is false");
        Assert.assertTrue(pointManagement.getContentMessageAllert().contains(contentMessage), "Content message is false");
    }

    @And("user verify new room group added displayed")
    public void userVerifyNewRoomGroupAddedDisplayed() {
        Assert.assertTrue(pointManagement.checkRoomGroupIsPresent(BangKrupuxTestData.getOwnerRoomGroup()+"-"+BangKrupuxTestData.getOwnerRoomGroupUntil()));
    }

    @When("user clicks on Point Management-Owner Setting menu")
    public void user_clicks_on_point_management_owner_setting_menu() {
        pointManagement.clickOnOwnerSettingMenu();
    }

    @And("user click save create owner group button")
    public void userClickSaveCreateOwnerGroupButton() {
        pointManagement.clickOnSaveButton();
    }

    @Then("user see validation")
    public void user_see_validation(List<String> validationList) {
        for (String message: validationList) {
            pointManagement.assertActivityValidationMessage(message);
        }
    }

    @And("user click edit on room group")
    public void userClickEditOnRoomGroup() {
        int roomGroupNumber = pointManagement.getRoomGroupNumber();
        for(int i=0;i<roomGroupNumber;i++){
            if (pointManagement.getGroupText(i).contains("1002")) {
                pointManagement.clickOnEditRoomGroup(i + 1);
                break;
            }
        }
    }

    @And("user click delete on room group")
    public void userClickDeleteOnRoomGroup() {
        int roomGroupNumber = pointManagement.getRoomGroupNumber();
        for(int i=0;i<roomGroupNumber;i++){
            if (pointManagement.getGroupText(i).contains(BangKrupuxTestData.getOwnerRoomGroup())){
                pointManagement.clickOnDeleteRoomGroup(i+1);
                break;
            }
        }
    }

    @And("user verify new room group added not displayed")
    public void userVerifyNewRoomGroupAddedNotDisplayed() {
        Assert.assertFalse(pointManagement.checkRoomGroupIsPresent(BangKrupuxTestData.getOwnerRoomGroup()+"-"+BangKrupuxTestData.getOwnerRoomGroupUntil()));
    }

    @Then("user verify the pagination of Owner Room Group")
    public void user_verify_the_pagination_of_Owner_Room_Group() {
        Assert.assertTrue(pointManagement.isPaginationAppear(), "Pagination in Owner Room Group is not appeared");
    }

    @Then("user verify Manage Point Owner Room Group page items")
    public void user_verify_Manage_Point_Owner_Room_Group_page_items(List<String> data) {
        for (int i = 1; i < data.size(); i++) {
            System.out.println("LUBIS "+data.get(i));
            System.out.println("RAMOSAN "+pointManagement.getTableTitleText(i));
            Assert.assertEquals(pointManagement.getTableTitleText(i), data.get(i), "Table title text is not equal to " + data.get(i));
            Assert.assertTrue(pointManagement.isPaginationAppear(), "Pagination in Owner Room Group is not appeared");
        }
    }
}
