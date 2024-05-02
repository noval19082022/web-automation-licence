package steps.mamikos.bangkrupux;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.admin.mamipay.bangkrupux.PointManagementPO;
import testdata.BangKrupuxTestData;
import utilities.JavaHelpers;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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
    private String pointAmount = JavaHelpers.getPropertyValue(pointAndReward,"pointAmount");
    private String noteAdjustPointTopup =JavaHelpers.getPropertyValue(pointAndReward, "noteAdjustPointTopup");
    private String noteAdjustPointTopdown = JavaHelpers.getPropertyValue(pointAndReward, "noteAdjustPointTopdown");

    @When("admin successfully {string} user named {string} with status {string}")
    public void admin_successfully_do_action_for_user_point(String action, String user, String status) {
        playwright.pageScrollUntilElementIsVisible(playwright.filterLocatorHasText(locator.span, "User Point"));
        playwright.clickOnText("User Point");
        pointManagement.searchUserpoinTextBox(user);
        playwright.clickOnText("Search");
        pointManagement.statusUser(status).click();
        playwright.clickOnTextButton("Yes, Do It!");
        Assert.assertEquals(pointManagement.getMessageSuccess(), "Success! " + user + " successfully "+action, "Message doesn't match!");
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
            if (pointManagement.getGroupText(i).contains("1001")) {
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

    @When("user clicks Adjust Point icon")
    public void user_clicks_Adjust_Point_icon() throws InterruptedException {
       pointManagement.clickOnAdjustPointIcon();
    }

    @When("user choose adjustment type {string}")
    public void user_choose_adjustment_type(String adjustmentType) throws InterruptedException {
        pointManagement.choosePointAdjustmentType(adjustmentType);
    }

    @When("user fills out point amount")
    public void user_fills_out_point_amount() {
        pointManagement.setPointAmount(pointAmount);
    }

    @When("user fills out note for {string}")
    public void user_fills_out_note_for(String noteType) {
        String type = "";
        if (noteType.equals("topup")){
            type = noteAdjustPointTopup;
        }
        else if (noteType.equals("topdown")){
            type = noteAdjustPointTopdown;
        }
        pointManagement.setPointAdjusmentNote(type);
    }

    @When("user clicks on Submit button on Adjust Point form")
    public void user_clicks_on_Submit_button_on_Adjust_Point_form() throws InterruptedException {
        pointManagement.clickOnSubmitAdjustPointButton();
    }

    @Then("user see Bulk Adjust Point button")
    public void user_see_Bulk_Adjust_Point_button() throws InterruptedException {
        pointManagement.checkBulkAdjustPointButton();
    }

    @And("user see Bulk Update Blacklist button")
    public void user_see_Bulk_Update_Blacklist_button() throws InterruptedException {
        pointManagement.checkBulkUpdateBlacklistButton();
    }

    @And("user see Keyword Filter")
    public void user_see_Keyword_Filter() throws InterruptedException {
        pointManagement.checkKeywordFilter();
    }

    @And("user see User Filter")
    public void user_see_User_Filter() throws InterruptedException {
        pointManagement.checkUserFilter();
    }

    @And("user see Status Filter")
    public void user_see_Status_Filter() throws InterruptedException {
        pointManagement.checkStatusFilter();
    }

    @And("user see Search button")
    public void user_see_Search_button() throws InterruptedException {
        pointManagement.checkSearchButton();
    }

    @And("user see Name")
    public void user_see_Name() throws InterruptedException {
        pointManagement.checkName();
    }

    @And("user see Email")
    public void user_see_Email() throws InterruptedException {
        pointManagement.checkEmail();
    }

    @And("user see Phone Number")
    public void user_see_Phone_Number() throws InterruptedException {
        pointManagement.checkPhoneNumber();
    }

    @And("user see User")
    public void user_see_User() throws InterruptedException {
        pointManagement.checkUser();
    }

    @And("user see Total Point")
    public void user_see_Total_Point() throws InterruptedException {
        pointManagement.checkTotalPoint();
    }

    @And("user see Status")
    public void user_see_Status() throws InterruptedException {
        pointManagement.checkStatus();
    }

    @And("user see Adjust Point icon")
    public void user_see_Adjust_Point_icon() throws InterruptedException {
        pointManagement.checkAdjustPointIcon();
    }

    @And("user see History icon")
    public void user_see_History_icon() throws InterruptedException {
        pointManagement.checkHistoryIcon();
    }

    @And("user see Pagination")
    public void user_see_Pagination() throws InterruptedException {
        pointManagement.checkPagination();
    }

    @When("user click history icon on manage user point page")
    public void user_click_history_icon_on_manage_user_point_page() throws InterruptedException {
        pointManagement.clickHistoryIcon();
    }

    @Then("user see at manage user point history contains:")
    public void user_see_at_manage_user_point_history_contain(DataTable dataTable) {
        List<Map<String, String>> table = dataTable.asMaps();
        for (Map<String, String> content : table) {
            System.out.println(content);
            Assert.assertTrue(pointManagement.getContentManagePointHistoryPage().contains(content.get("Content")),"Review page should contain" + content.get("Content"));
        }
    }

    @When("user choose to filter all activity with value {string}")
    public void user_choose_to_filter_all_activity_with_value(String value) throws InterruptedException {
        pointManagement.chooseDropDownAllActivity(value);
        pointManagement.clickOnSearchButton();
    }

    @Then("history with selected filter value {string} is displayed")
    public void voucher_with_selected_filter_value_is_displayed(String value){
        Assert.assertTrue(pointManagement.getContentManagePointHistoryPage().contains(value));
    }

    @When("user click next page button on manage user point")
    public void user_click_next_page_button_on_manage_user_point() throws InterruptedException {
       pointManagement.clickNextPage();
    }

    @Then("next manage user point page will be opened")
    public void next_manage_user_point_page_will_be_opened() {
        String pageIndex = pointManagement.getPageIndex();
        if(pageIndex != null){
            Assert.assertEquals(pageIndex, "2", "Page index is not correct");
        }
    }

    @When("user click previous page button on manage user point")
    public void user_click_previous_page_button_on_manage_user_point() throws InterruptedException {
        pointManagement.clickPrevPage();
    }

    @Then("previous manage user point page will be opened")
    public void previous_manage_user_point_page_will_be_opened() {
        String pageIndex = pointManagement.getPageIndex();
        if(pageIndex != null){
            Assert.assertEquals(pageIndex, "1", "Page index is not correct");
        }
    }

    @When("user click page index {string} at user point")
    public void user_click_page_index_at_user_point(String index) throws InterruptedException {
        pointManagement.clickPageIndex(index);
    }

    @Then("manage user point page {string} will be opened")
    public void manage_user_point_page_will_be_opened(String page) {
        String pageIndex = pointManagement.getPageIndex();
        if(pageIndex != null) {
            Assert.assertEquals(pageIndex, page, "Page index is not correct");
        }
    }

    @And("admin click Bulk Update Blacklist")
    public void admin_click_bulk_update_blacklist() throws InterruptedException {
        pointManagement.clickOnBulkUpdateBlacklistButton();
    }

    @Then("admin see {string} pop-up appear")
    public void admin_see_pop_up_appear(String popUp) throws InterruptedException {
        Assert.assertTrue(pointManagement.checkBulkUpdateBlacklistPopUp(popUp), "bulk update blacklis popup is not present");
    }

    @And("user click button submit csv bulk blacklist")
    public void user_click_button_submit_csv_bulk_blacklist() {
       pointManagement.clickOnSubmitBulkUpdateButton();
    }

    @Then("success Update Blacklist using csv")
    public void success_update_blacklist_using_csv() throws InterruptedException{
        Assert.assertTrue(pointManagement.successSaveTnCIsDisplayed(), "succes upload csv is not present");
    }

    @When("admin upload csv file {string}")
    public void admin_upload_csv_file(String file) {
       pointManagement.uploadBulkAddCSVFileUserPoint(file);
    }

    @And("user click Bulk Adjust Point")
    public void user_click_bulk_adjust_point() throws InterruptedException{
        pointManagement.clickOnBulkAdjustPointButton();
    }

    @And("user click button submit csv bulk adjust point")
    public void user_click_button_submit_csv_bulk_adjust_point() {
        pointManagement.clickOnSubmitBulkAdjustPointButton();
    }

    @And("user fill Owner Point Expiry in with {string}")
    public void user_fill_Owner_Point_Expiry_in_with(String value){
        pointManagement.fillOwnerPointExpiry(value);
    }

    @And("user fill Tenant Point Expiry in with {string}")
    public void user_fill_Tenant_Point_Expiry_in_with(String value){
        pointManagement.fillTenantPointExpiry(value);
    }

    @And("user click on Point Expiry Save button")
    public void user_click_on_Point_Expiry_Save_button() throws InterruptedException{
       pointManagement.clickOnSaveButton();
    }

}
