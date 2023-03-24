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
    KostDetailsPO kostDetail = new KostDetailsPO(page);
    BookingFormPO bookingForm;
    SuccessBookingPO successBooking;

    RiwayatBookingPO riwayatBooking = new RiwayatBookingPO(page);

    private List<Map<String, String>> searchKost;
    private List<String> ftueBookingBenefitTextList;

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
        kostDetail.selectBookingDate("today");
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
        page.reload();
        riwayatBooking.clickOnCheckinButton();
        riwayatBooking.clickOnCheckinPopUpButton();
        riwayatBooking.clickOnSelesaiAndKeKostSaya();
    }


    @And("tenant booking kost for {string} and input rent duration equals to {int}")
    public void tenantBookingKostForAndInputRentDurationEqualsTo(String bookingTime, int duration) throws InterruptedException {
        kostDetail.dismissFTUE();
        kostDetail.selectBookingDate(bookingTime);
        kostDetail.selectBookingPeriod("Per Bulan");
        bookingForm = kostDetail.clickOnAjukanSewaButton();
        for (int i = 1; i < duration; i++) {
            bookingForm.increaseRateDuration();
        }
        bookingForm.clickOnAjukanSewaButton();
        bookingForm.clickOnBookingConfirmationCheckmark();
        successBooking = bookingForm.clickOnKirimPengajuanKePemilik();
    }

    @Then("user/owner/tenant can see FTUE booking benefit with wording:")
    public void userCanSeeFTUEBookingBenefit(DataTable table) {
        ftueBookingBenefitTextList = table.asList(String.class);
        Assert.assertTrue(kostDetail.isFTUEBookingBenefitVisible(), "FTUE Slide Booking Benefit is not visible");
        for (int i = 0; i < ftueBookingBenefitTextList.size(); i++) {
            System.out.println("Asserting: " + ftueBookingBenefitTextList.get(i));
            Assert.assertEquals(kostDetail.getFTUEBookingBenefitWording(i), ftueBookingBenefitTextList.get(i), "FTUE wording is not equals");
        }
    }

    @When("user/tenant/owner dismiss FTUE booking benefit")
    public void userDismissFTUEBookingBenefit() {
        kostDetail.dismissFTUE();
    }

    @Then("user can not see FTUE booking benefit")
    public void userCanNotSeeFTUEBookingBenefit() {
        Assert.assertFalse(kostDetail.isFTUEBookingBenefitVisible(), "FTUE Slide booking benefit is still visible");
    }

    @And("user search for Kost with name {string} and selects matching result")
    public void userSearchForKostWithNameAndSelectsMatchingResult(String kosName) {
        searchPO = homePO.clickOnSearchButton();
        kostDetail = searchPO.searchByText(kosName);
        kostDetail.waitTillKostDetailPageVisible();
    }
}
