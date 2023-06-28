package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.owner.OwnerDashboardPO;
import pageobject.owner.kelolatagihan.BillAndBookingManagementPO;
import pageobject.owner.kelolatagihan.PengajuanBookingPO;
import utilities.PlaywrightHelpers;

public class OwnerRejectBookingSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    OwnerDashboardPO ownerDashboard = new OwnerDashboardPO(page);
    PengajuanBookingPO pengajuanBooking = new PengajuanBookingPO(page);
    BillAndBookingManagementPO billBookingManage = new BillAndBookingManagementPO(page);

    @When("owner reject booking")
    public void ownerRejectBooking() {
        ownerDashboard.clickOnManagementKost();
        pengajuanBooking = ownerDashboard.clickOnPengajuanBooking();
        billBookingManage.clickOnLihatDetailButton();
        billBookingManage = pengajuanBooking.ownerRejectBooking();
        billBookingManage.ownerChooseReasonReject();
        billBookingManage.clickPilihButton();
    }

    @And("owner see all kost terisi")
    public void ownerSeeAllKostTerisi() {

    }

    @And("owner reject booking from view detail")
    public void ownerRejectBookingFromViewDetail() {
        billBookingManage = pengajuanBooking.ownerRejectBookingFromViewDetail();
    }

    @And("owner select reason reject kos {string}")
    public void ownerSelectRejectBookingKos(String reason) {
        billBookingManage.ownerSelectRejectBookingKos(reason);
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
}
