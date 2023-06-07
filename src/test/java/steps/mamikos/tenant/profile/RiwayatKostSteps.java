package steps.mamikos.tenant.profile;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.HomePO;
import pageobject.tenant.profile.RiwayatKostPO;
import utilities.PlaywrightHelpers;

public class RiwayatKostSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    HomePO home = new HomePO(page);
    RiwayatKostPO riwayatKost = new RiwayatKostPO(page);

    @And("user click review kost")
    public void user_click_review_kost() {
        riwayatKost.clickReviewKos();
    }
    @Then("user will see review page and user click close on review page")
    public void user_will_see_review_page_and_user_click_close_on_review_page() {
        riwayatKost.isReviewKostPagePresent();
        riwayatKost.clickCloseRiviewKost();
    }
    @When("user click Lihat Detail")
    public void user_click_lihat_detail() {
        riwayatKost.clickLihatDetail();
    }
    @When("user click Lihat Fasilitas and close pop up fasilitas")
    public void user_click_lihat_fasilitas_and_close_pop_up_fasilitas() {
        riwayatKost.clickLihatFasilitas();
        riwayatKost.clickCloseFacility();
    }

    @When("user click Lihat Riwayat Transaksi and user click Kembali ke Booking button")
    public void user_click_lihat_riwayat_transaksi_and_user_click_kembali_ke_booking_button() {
        riwayatKost.clickLihatRiwayatTransaksi();
        riwayatKost.clickKembaliKeBooking();
    }
    @When("user click Booking Ulang")
    public void user_click_booking_ulang() {
        riwayatKost.clickBookingUlang();
    }
    @Then("user will open new tab and go to Booking form")
    public void user_will_open_new_tab_and_go_to_booking_form() {
        riwayatKost.isTitleBookingFormPresent();
    }

    @Then("user will see empty state")
    public void userWillSeeEmptyState() {
        Assert.assertEquals(riwayatKost.getEmptyStateTitle(), "Belum Ada Kos", "Empty state title is not correct");
        Assert.assertTrue(riwayatKost.isEmptyStateSubtitlePresent(), "Empty State Subtitle not present");
    }
}
