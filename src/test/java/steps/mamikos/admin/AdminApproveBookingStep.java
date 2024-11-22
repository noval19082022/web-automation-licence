package steps.mamikos.admin;
import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.admin.mamipay.bangkrupux.AdminApproveBookingPO;
import utilities.JavaHelpers;

import java.util.List;
import java.util.Map;
public class AdminApproveBookingStep {
    Page page = ActiveContext.getActivePage();
    AdminApproveBookingPO adminApproveBooking = new AdminApproveBookingPO(page);
    private JavaHelpers javaHelpers = new JavaHelpers();
    private String dailyPrice = null;
    private String weeklyPrice = null;
    private String monthlyPrice = null;
    private String threeMonthlyPrice = null;
    private String sixMonthlyPrice = null;
    private String yearlyPrice = null;
    private String kosNamePrefix;
    private String roomTypePrefix;

    private List<Map<String, String>> property;

    @And("admin show filter data booking")
    public void adminShowFilterDataBooking() {
        adminApproveBooking.showOrHideFilter();
    }
    @And("admin filter data booking by tenant phone number:")
    public void adminFilterDataBooking(DataTable tables) {
        property = tables.asMaps(String.class, String.class);
        String tenantPhone = property.get(0).get("Tenant Phone");
        String kosType = property.get(0).get("Kos Type");
        adminApproveBooking.fillFilterDataBooking(tenantPhone, kosType);
    }
    @And("admin click actions button on booking list")
    public void adminClickActionButton() {
        adminApproveBooking.clickActionButton();
    }
    @And("admin accept booking")
    public void adminAcceptBooking() {
        adminApproveBooking.adminAcceptBooking();
    }
    @Then("admin sees other price with name {string} and price {string} show in detail booking")
    public void user_can_sees_other_price_with_name_and_price_on_konfirmasi(String otherPriceName, String totalPrice) {
        adminApproveBooking = adminApproveBooking.getTextOtherPrice(otherPriceName, totalPrice);
    }
    @And("admin click detail in actions button")
    public void adminClickDetailButton() {
        adminApproveBooking.clickDetailButton();
    }

    @And("admin accept booking for kost add fee")
    public void admin_accept_booking_for_kost_add_fee(){
        adminApproveBooking.clickNextOnConfirmBooking();
    }

    @And("admin click on next button accept booking for kost add fee")
    public void admin_click_on_next_button_accept_booking_for_kost_add_fee(){
        adminApproveBooking.clickOnNextButonConfirmBooking();
    }

    @Then("admin can see {string} on confirm booking page")
    public void admin_can_see_on_confirm_booking_page(String addfeeName){
        Assert.assertTrue(adminApproveBooking.isAddFeeTextVisible(addfeeName), "not appears add fee");
    }
}
