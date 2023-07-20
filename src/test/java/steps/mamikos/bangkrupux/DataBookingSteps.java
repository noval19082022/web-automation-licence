package steps.mamikos.bangkrupux;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobject.admin.mamipay.bangkrupux.DataBookingPO;

import java.util.List;
import java.util.Map;

public class DataBookingSteps {
    Page page = ActiveContext.getActivePage();
    DataBookingPO dataBooking = new DataBookingPO(page);

    private List<Map<String, String>> searchTenantData;

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
        dataBooking.searchTenantBy(searchType,searchValue);
    }

    @And("admin click next button")
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
    }
}
