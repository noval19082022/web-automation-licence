package steps.mamikos.tenant.profile;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.common.HomePO;
import pageobject.tenant.profile.RiwayatBookingPO;
import utilities.PlaywrightHelpers;

public class RiwayatBookingSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    HomePO home = new HomePO(page);
    RiwayatBookingPO riwayatBooking = new RiwayatBookingPO(page);

    @And("tenant click button lihat selengkapnya riwayat booking")
    public void tenantClickButtonLihatSelengkapnyaRiwayatBooking() {
        riwayatBooking.clickFirstSelengkapnyaButton();
    }

    @And("user click on link refund")
    public void userClickOnLinkRefund() {
        riwayatBooking.clickOnRefundLink();
    }

    @Then("user can see {string} on mamihelp page")
    public void userCanSeeOnMamihelpPage(String link) {
        page = ActiveContext.getActivePage();
        playwright = new PlaywrightHelpers(page);
        Assert.assertTrue(playwright.getActivePageURL().contains(link), "Url doesn't match");

    }

    @Then("tenant/user should reached history booking page")
    public void x_should_reached_history_booking_page() {
        Assert.assertTrue(riwayatBooking.isInHistoryBookingSection());
    }

    @Then("user check booking status is rejected by owner with reason {string}")
    public void user_check_booking_status_is_rejected_by_owner_with_reason_x(String reason) {
        Assert.assertEquals(riwayatBooking.getFirstListBookingStatusText(), "Pemilik Menolak");
        Assert.assertEquals(riwayatBooking.getRejectReasonOnDetailsFirstKostList(), reason);
    }

    @Then("tenant check status booking is {string}")
    public void tenant_check_status_booking_is(String status) {
        page.navigate(Mamikos.URL + "/user/booking/");
        Assert.assertEquals(riwayatBooking.getFirstListBookingStatusText(), status);
    }
}
