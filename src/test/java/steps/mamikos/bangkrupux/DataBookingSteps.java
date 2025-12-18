package steps.mamikos.bangkrupux;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.admin.mamipay.bangkrupux.DataBookingPO;

import java.util.List;
import java.util.Map;

public class DataBookingSteps {
    Page page = ActiveContext.getActivePage();
    DataBookingPO dataBooking = new DataBookingPO(page);

    private List<Map<String, String>> searchTenantData;
    private Map<String, String> durationFormData;

    @And("admin go to data booking menu")
    public void admin_go_to_data_booking_menu() {
        dataBooking.goToDataBookingMenu();
    }

    @And("admin click booking now button")
    public void admin_click_booking_now_button() {
        dataBooking.clickBookingNow();
    }

    @And("admin select room with kost name {string}")
    public void admin_select_room_with_kost_kost_name_x(String kostName) {
        dataBooking.chooseListingName(kostName);
        dataBooking.clickNextButton();
    }

    @And("admin fill the input field on booking form with:")
    public void admin_fill_the_input_field_on_booking_form_with(DataTable table) {
        searchTenantData = table.asMaps(String.class, String.class);
        var searchType = searchTenantData.get(0).get("search by");
        var searchValue = searchTenantData.get(0).get("value");
        dataBooking.fillSearchTenantBy(searchType,searchValue);
    }

    @And("admin click search button on booking now")
    public void admin_click_search_button() {
        dataBooking.clickSearchButton();
    }

    @And("admin click next button on booking now")
    public void admin_click_next_button() {
        dataBooking.clickNextButton();
    }

    @Then("admin should be in {string} form step")
    public void admin_should_be_in_x_form_section(String section) {
        dataBooking.isSectionTitleVisible(section);
    }

    @Then("admin verify dialog alert text on form booking is {string}")
    public void admin_verify_dialog_alert_text_on_form_booking_is_x(String text) {
        dataBooking.assertDialogMessageTextTo(text);
        dataBooking.clickSearchButton();
    }

    @And("admin fill duration booking form with:")
    public void admin_fill_duration_booking_form_with(DataTable table) {
        durationFormData = table.asMap(String.class, String.class);
        var bookingType = durationFormData.get("booking type");
        var oldContractId = durationFormData.get("old contract id");
        var rentCount = durationFormData.get("rent count");
        var checkinDate = durationFormData.get("checkin date");
        var duration = durationFormData.get("duration of the lease");
        if (bookingType.equalsIgnoreCase("New Booking")) {
            dataBooking.setBookingTypeTo(bookingType);
        } else {
            dataBooking.setBookingTypeTo(bookingType);
            dataBooking.fillOldContractId(oldContractId);
            dataBooking.clickCheckOldContract();
            Assert.assertTrue(dataBooking.isContractValidOrNotMessageVisible("Contract Valid!"), "contract is not valid");
        }
        dataBooking.selectRentCount(rentCount);
        dataBooking.selectCheckInDate(checkinDate);
        dataBooking.selectRentDuration(duration);
    }

    @And("admin fill booking type with {string} and contract id with {string}")
    public void admin_fill_booking_type_with_x_and_contract_id_with_x(String type, String contractId) {
        dataBooking.setBookingTypeTo(type);
        dataBooking.fillOldContractId(contractId);
    }

    @And("admin click submit button")
    public void admin_click_submit_button() {
        dataBooking.clickSubmitButton();
    }

    @Then("admin should see success message {string} on data booking page")
    public void admin_should_see_success_message_popup_on_data_booking_page(String alertMessage) {
        Assert.assertTrue(dataBooking.isSuccessMessageVisible(alertMessage), "success message popup is not visible");
    }

    @Then("admin should see check contract id alert message is {string}")
    public void admin_should_see_check_contract_id_alert_message_is_x(String message) {
        dataBooking.assertDialogMessageTextTo(message);
        dataBooking.clickCheckOldContract();
    }

    @When("admin process to reject booking")
    public void admin_process_to_reject_booking() {
        dataBooking.clickFirstActionButton();
        dataBooking.clickOnRejectedListButton();
    }

    @And("admin reject booking with {string} as the reason")
    public void admin_reject_booking_with_x_as_the_reason(String reason) {
        dataBooking.chooseRejectReason(reason);
        dataBooking.clickOnSendRejectBookingButton();
    }

    @And("admin search kost all testing and tenant phone number {string}")
    public void admin_search_kost_all_testing_and_tenant_phone_number(String text){
    dataBooking.searchAllTestingKost(text);
    }

    @When("admin click show filter button")
    public void adminClickShowFilterButton() {
        dataBooking.clickOnShowFilter();
    }

    @When("admin click on note category dropdown")
    public void adminClickOnNoteCategoryDropdown() {
        dataBooking.clickOnNoteCategoryDropdown();
    }

    @When("admin select note category {string}")
    public void adminSelectNoteCategory(String categoryName) {
        dataBooking.selectNoteCategoryOption(categoryName);
    }

    @And("admin click search filter button")
    public void adminClickSearchFilterButton(){
        dataBooking.clickSearchFilterButton();
    }

    @When("admin select {string} from textbox dropdown and choose {string}")
    public void adminSelectFromTextboxDropdown(String textboxName, String optionName) {
        dataBooking.selectFromTextboxDropdown(textboxName, optionName);
    }

    @Then("admin should see remarks {string} in the results")
    public void adminShouldSeeRemarksInTheResults(String remarksText) {
        boolean isDisplayed = dataBooking.isRemarksTextDisplayed(remarksText);
        Assert.assertTrue(isDisplayed, "Expected remarks text '" + remarksText + "' should be displayed in the results");
    }

    @Then("remarks text {string} should be displayed")
    public void remarksTextShouldBeDisplayed(String remarksText) {
        boolean isDisplayed = dataBooking.isRemarksTextDisplayed(remarksText);
        Assert.assertTrue(isDisplayed, "Remarks text '" + remarksText + "' should be visible on the page");
    }
}
