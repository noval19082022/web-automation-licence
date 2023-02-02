package steps.mamikos.tenant;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.HomePO;
import pageobject.common.KostDetailsPO;
import pageobject.common.SearchPO;
import pageobject.tenant.BookingFormPO;
import pageobject.tenant.SuccessBookingPO;
import pageobject.tenant.profile.RiwayatBookingPO;

import java.util.List;
import java.util.Map;

public class TenantBookingSteps {
    Page page = ActiveContext.getActivePage();
    HomePO homePO = new HomePO(page);
    SearchPO searchPO;
    KostDetailsPO kostDetail;
    BookingFormPO bookingForm;
    SuccessBookingPO successBooking;

    RiwayatBookingPO riwayatBooking = new RiwayatBookingPO(page);

    private List<Map<String, String>> searchKost;

    @When("tenant search kost then go to kost details:")
    public void tenantSearchKostThenGoToKostDetails(DataTable table) {
        searchKost = table.asMaps(String.class, String.class);
        var kostName = searchKost.get(0).get("kost name " + Mamikos.ENV);
        searchPO = homePO.clickOnSearchButton();
        kostDetail = searchPO.searchByText(kostName);
        kostDetail.waitTillKostDetailPageVisible();
    }

    @When("tenant booking kost")
    public void tenantBookingKost() {
        kostDetail.dismissFTUE();
        kostDetail.selectBookingDate("tomorrow");
        kostDetail.selectBookingPeriod("Per Bulan");
        bookingForm = kostDetail.clickOnAjukanSewaButton();
        bookingForm.clickOnAjukanSewaButton();
        bookingForm.clickOnBookingConfirmationCheckmark();
        successBooking = bookingForm.clickOnKirimPengajuanKePemilik();
    }

    @Then("tenant should success booking kost")
    public void tenantShouldSuccesBookingKost() {
        successBooking.waitUntilSuccessBookingHeadingVisible();
        Assert.assertEquals(successBooking.getSuccessBookingHeadingText(), "Pengajuan sewa berhasil dikirim");
    }

    @And("user cancel booking")
    public void userCancelBooking() {
        page.navigate("https://jambu.kerupux.com/user/booking/");
        bookingForm = new BookingFormPO(page);
        bookingForm.cancelBooking();
        if (bookingForm.waitUntilSuccessCancelHeadingVisible()) {
            Assert.assertEquals(bookingForm.getSuccessCancelText().trim(), "Booking Anda berhasil dibatalkan");
        }
        bookingForm.closeCancelPopUp();
    }

    @When("tenant booking kost for {string}")
    public void tenantBookingKostFor(String bookingTime) {
        kostDetail.dismissFTUE();
        kostDetail.selectBookingDate(bookingTime);
        kostDetail.selectBookingPeriod("Per Bulan");
        bookingForm = kostDetail.clickOnAjukanSewaButton();
        bookingForm.clickOnAjukanSewaButton();
        bookingForm.clickOnBookingConfirmationCheckmark();
        successBooking = bookingForm.clickOnKirimPengajuanKePemilik();
    }

    @When("tenant checkin kost from riwayat booking")
    public void tenantCheckinKostFromRiwayatBooking() {
        riwayatBooking.clickOnCheckinButton();
        riwayatBooking.clickOnCheckinPopUpButton();
        riwayatBooking.clickOnSelesaiAndKeKostSaya();
    }
}
