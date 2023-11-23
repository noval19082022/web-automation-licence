package steps.mamikos.bangkrupux;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.admin.mamipay.bangkrupux.PointManagementPO;
import utilities.JavaHelpers;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;
import testdata.BangKrupuxTestData;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class pointManagementSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    LocatorHelpers locator = new LocatorHelpers(page);
    PointManagementPO pointManagement = new PointManagementPO(page);

    //Test Data Point And Reward
    private String pointAndReward="src/test/resources/testdata/bangkerupuxAdmin/poinManagement.properties";
    private String popUpConfirmationTitleBlacklist = JavaHelpers.getPropertyValue(pointAndReward,"popUpConfirmationTitleBlacklist");
    private String popUpConfirmationTitleWhitelist = JavaHelpers.getPropertyValue(pointAndReward, "popUpConfirmationTitleWhitelist");
    private String popUpConfirmationBodyBlacklist = JavaHelpers.getPropertyValue(pointAndReward,"popUpConfirmationBodyBlacklist");
    private String popUpConfirmationBodyWhitelist = JavaHelpers.getPropertyValue(pointAndReward,"popUpConfirmationBodyWhitelist");

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

    @When("user filter user point by keyword {string} is {string}")
    public void user_filter_user_point_by_keyword_is(String keyword,String inputKeyword) {
        String newKeyword = "";
        if(keyword.equals("tenant name")){
            newKeyword = inputKeyword;
        }
        else if(keyword.equals("phone number")){
            newKeyword = inputKeyword;
        }
        pointManagement.setKeywordSearchField(newKeyword);
    }

    @When("user clicks on Search button")
    public void user_clicks_on_search_button() throws InterruptedException {
        pointManagement.clickOnSearchButton();

    }

    @Then("system display list user point contains {string}")
    public void system_display_list_user_point_contains(String keyword) {
        String keywordResult = keyword.toLowerCase();
        int resultNumber = pointManagement.getFilterResultNumber();
        for (int i = 1 ; i <= resultNumber ; i++){
            Assert.assertTrue(pointManagement.getFilterResultList(i,1).toLowerCase().contains(keywordResult) || pointManagement.getFilterResultList(i,2).contains(keywordResult));
        }
    }

    @And("user select filter User {string}")
    public void user_select_filter_user(String userType) throws InterruptedException {
        pointManagement.selectUserFilter(userType);
    }

    @Then("system display list user point as {string}")
    public void system_display_list_user_point_as(String userPointType) {
        for(int i = 0 ; i < pointManagement.getFilterResultNumber() ; i++){
            if(userPointType.equals("Owner") || userPointType.equals("Tenant")){
                Assert.assertEquals(pointManagement.getTextUserColumn(i),userPointType, "User is not match");
            }
            else if (userPointType.equals("Whitelist") || userPointType.equals("Blacklist")){
                Assert.assertTrue(pointManagement.getTextStatusColumn(i).contains(userPointType), "Status is not match");
            }
        }
    }

    @And("user select filter Status {string}")
    public void user_select_filter_status(String status) throws InterruptedException {
        pointManagement.selectStatusFilter(status);
    }

    @And("user clicks Total Point header")
    public void user_clicks_total_point_header() throws InterruptedException {
        pointManagement.clickOnTotalPointHeader();
    }

    @Then("user verify total point sorted {string}")
    public void user_verify_total_point_sorted(String condition) {
        List<Long> obtainedList = new ArrayList<>();
        for(int i = 0 ; i < pointManagement.getFilterResultNumber() ; i++){
            obtainedList.add(Long.valueOf(pointManagement.getTextTotalPoint(i)));
        }

        List<Long> sortedList = new ArrayList<>(obtainedList);
        Collections.sort(sortedList);

        if(condition.equals("descending")){
            Collections.reverse(sortedList);
        }
        Assert.assertEquals(obtainedList, sortedList);
    }

    @And("user set the default status to Whitelist")
    public void user_set_default_status_to_whitelist() throws InterruptedException {
       pointManagement.setDefaultStatusToWhitelist();
    }
    @And("user {string} user point and click {string} on pop up confirmation")
    public void user_user_point_and_click_on_pop_up_confirmation(String action, String confirmation) throws InterruptedException {
        String initialStatus = "";
        String popUpConfirmationTitle = "";
        String popUpConfirmationBody = "";
        String popUpConfirmationTitleWhite = "";
        String popUpConfirmationBodyWhite = "";
        if(action.equals("Blacklist")){
            initialStatus = "Whitelist";
            popUpConfirmationTitle = popUpConfirmationTitleBlacklist;
            popUpConfirmationBody = popUpConfirmationBodyBlacklist;
            pointManagement.clickOnUserPointStatus(initialStatus);
            Assert.assertEquals(pointManagement.getTitlePopUpConfirmationChangeStatus(),popUpConfirmationTitle,"title doesmt match");
            Assert.assertEquals(pointManagement.getBodyPopUpConfirmationChangeStatus(),popUpConfirmationBody,"body text doesnt match");
            pointManagement.clickOnPopUpCOnfirmationButton(confirmation);
        }
        else if (action.equals("Whitelist")){
            initialStatus = "Blacklist";
            popUpConfirmationTitleWhite = popUpConfirmationTitleWhitelist;
            popUpConfirmationBodyWhite = popUpConfirmationBodyWhitelist;
            pointManagement.clickOnUserPointStatus(initialStatus);
            Assert.assertEquals(pointManagement.getTitlePopUpConfirmationChangeStatus(),popUpConfirmationTitleWhite,"title doesmt match");
            Assert.assertEquals(pointManagement.getBodyPopUpConfirmationChangeStatus().replace("NOT ", ""),popUpConfirmationBodyWhite,"body text doesnt match");
            pointManagement.clickOnPopUpCOnfirmationButton(confirmation);
        }

    }
}
