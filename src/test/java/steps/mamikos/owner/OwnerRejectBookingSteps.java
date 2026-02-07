package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.LoadingPO;
import pageobject.owner.OwnerDashboardPO;
import pageobject.owner.kelolatagihan.BillAndBookingManagementPO;
import pageobject.owner.kelolatagihan.PengajuanSewaPO;
import utilities.PlaywrightHelpers;

public class OwnerRejectBookingSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    OwnerDashboardPO ownerDashboard = new OwnerDashboardPO(page);
    PengajuanSewaPO pengajuanBooking = new PengajuanSewaPO(page);
    BillAndBookingManagementPO billBookingManage = new BillAndBookingManagementPO(page);

    LoadingPO loading = new LoadingPO(page);


    @When("owner reject booking with reason {string}")
    public void ownerRejectBookingWithReason(String reason) {
        ownerDashboard.clickOnManagementKost();
        pengajuanBooking = ownerDashboard.clickOnPengajuanSewa();
        billBookingManage.clickOnLihatDetailButton();
        billBookingManage = pengajuanBooking.ownerRejectBooking();
        billBookingManage.ownerChooseReasonRejectByText(reason);
        billBookingManage.clickPilihButton();
    }

    @And("owner see all kost terisi")
    public void ownerSeeAllKostTerisi() {

    }

    @And("owner reject booking from view detail")
    public void ownerRejectBookingFromViewDetail() {
        billBookingManage = pengajuanBooking.ownerRejectBookingFromViewDetail();
    }

    @Then("owner can see confirmation Atur Booking popup")
    public void ownerCanSeeConfirmationAturBookingPopup() {
        Assert.assertTrue(billBookingManage.isAppearConfirmationPopup());
    }

    @And("owner click on make rules booking button")
    public void ownerClickOnMakeRulesBookingButton() {
        billBookingManage.ownerClickOnMakeRulesBookingButton();
    }

    @Then("owner can see make rules booking page")
    public void ownerCanSeeMakeRulesBookingPage() {
        Assert.assertTrue(billBookingManage.isAppearMakeRuleBookingPage());
    }

    @And("owner choose filter kost for {string}")
    public void ownerChooseFilterKostFor(String kostName) {
        billBookingManage = pengajuanBooking.searchKostOnKostFilter(kostName);
    }

    @When("owner reject booking from dashboard")
    public void user_click_on_reject_booking() {
        ownerDashboard.clickOnPengajuanSewa();
        pengajuanBooking.ownerRejectBooking();
        pengajuanBooking.clickYaTolakOnPengajuanBooking();
    }

    @And("owner select other reject with custom reason {string}")
    public void owner_select_other_reject_with_custom_reason_x(String reason) {
        ownerDashboard.clickOnManagementKost();
        pengajuanBooking = ownerDashboard.clickOnPengajuanSewa();
        billBookingManage.clickOnLihatDetailButton();
        billBookingManage = pengajuanBooking.ownerRejectBooking();
        pengajuanBooking.clickAndFillLainnyaRejectReason(reason);
    }
}
