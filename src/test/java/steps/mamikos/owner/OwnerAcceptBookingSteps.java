package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.LoadingPO;
import pageobject.owner.OwnerDashboardPO;
import pageobject.owner.kelolatagihan.BillAndBookingManagementPO;
import pageobject.owner.kelolatagihan.PengajuanSewaPO;
import utilities.PlaywrightHelpers;

import java.util.List;
import java.util.Map;

public class OwnerAcceptBookingSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    OwnerDashboardPO ownerDashboard = new OwnerDashboardPO(page);
    PengajuanSewaPO pengajuanBooking = new PengajuanSewaPO(page);
    LoadingPO loading = new LoadingPO(page);
    BillAndBookingManagementPO billBookingManage = new BillAndBookingManagementPO(page);
    List<Map<String, String>> tenantNames;
    @When("owner accept booking")
    public void ownerAcceptBooking() throws InterruptedException {
        ownerDashboard.clickOnManagementKost();
        pengajuanBooking = ownerDashboard.clickOnPengajuanSewa();
        billBookingManage = pengajuanBooking.ownerAcceptBooking();
        billBookingManage.clickOnRoomNumberInput();
        billBookingManage.clickOnPilihDitempat();
        billBookingManage.clickOnTerapkanButton();
        billBookingManage.clickOnLanjutkanButton();
        billBookingManage.clickOnSimpan();
        billBookingManage.clickOkButton();
    }

    @Then("owner should redirect back to pengajuan booking page")
    public void ownerShouldRedirectBackToPengajuanBookingPage() {
        Assert.assertEquals(playwright.waitTillUrlToBe("https://owner-jambu.kerupux.com/booking/request"), "https://owner-jambu.kerupux.com/booking/request");
    }

    @When("owner accept booking from tenant:")
    public void ownerAcceptBookingFromTenant(DataTable table) throws InterruptedException {
        tenantNames = table.asMaps(String.class, String.class);
        var tenantName = tenantNames.get(0).get("tenant " + Mamikos.ENV);
        var maxLoop = 0;
        loading.waitForLoadingIconDisappear();
        ownerDashboard.clickOnManagementKost();
        do {
            pengajuanBooking = ownerDashboard.clickOnPengajuanSewa();
            maxLoop++;
            if (maxLoop >= 10) {
                break;
            }
        } while (!pengajuanBooking.terimaButtonWithNameVisible(tenantName));

        billBookingManage = pengajuanBooking.ownerAcceptBooking(tenantName);
        billBookingManage.clickOnRoomNumberInput();
        billBookingManage.clickOnPilihDitempat();
        billBookingManage.clickOnTerapkanButton();
        billBookingManage.clickOnLanjutkanButton();
        billBookingManage.clickOnSimpan();
        billBookingManage.clickOkButton();
    }

    @When("owner accept booking and select the room")
    public void ownerAcceptBookingAndSelectTheRoom() throws InterruptedException {
        ownerDashboard.clickOnManagementKost();
        pengajuanBooking = ownerDashboard.clickOnPengajuanSewa();
        billBookingManage = pengajuanBooking.ownerAcceptBooking();
        billBookingManage.clickOnRoomNumberInput();
        billBookingManage.clickOnOneRooms();
        billBookingManage.clickOnTerapkanButton();
        billBookingManage.clickOnLanjutkanButton();
        billBookingManage.clickOnSimpan();
        billBookingManage.clickOkButton();
    }

    @And("user clicks on Booking Details button")
    public void userClicksOnBookingDetailsButton() {
        billBookingManage.clickOnLihatDetailButton();
    }

    @And("owner go to select the room page from tenant:")
    public void ownerGoToSelectTheRoomPage(DataTable table) throws InterruptedException {
        tenantNames = table.asMaps(String.class, String.class);
        var tenantName = tenantNames.get(0).get("tenant " + Mamikos.ENV);
        ownerDashboard.clickOnManagementKost();
        pengajuanBooking = ownerDashboard.clickOnPengajuanSewa();
        billBookingManage = pengajuanBooking.ownerAcceptBooking(tenantName);
        billBookingManage.clickOnRoomNumberInput();
    }

    @Then("user can not see pilih di tempat as an option")
    public void userCannotSeeUpdateRoomNumber() {
        Assert.assertFalse(billBookingManage.isPilihKamarDiTempatVisible());
    }

    @And("owner accept booking via Homepage")
    public void ownerAcceptBookingViaHomepage() throws InterruptedException {
        ownerDashboard.clickOnTerimaViaHomepage();
        pengajuanBooking.clickOnTerimaPopUp();
        billBookingManage.clickOnRoomNumberInput();
        billBookingManage.clickOnOneRooms();
        billBookingManage.clickOnTerapkanButton();
        billBookingManage.clickOnLanjutkanButton();
        billBookingManage.clickOnSimpan();
    }
    @And("owner click on dropdown rules enter kos button")
    public void ownerClickOnDropdownRulesEnterKos() {
        billBookingManage.ownerClickDropdownRulesEnterKos();
    }
    @And("owner click on toggle pengajuan dan waktu masuk kos")
    public void ownerClickOnToggleCheckInKos() {
        billBookingManage.ownerClickOnToggleCheckInKos();
    }
    @And("owner click on toggle pengajuan dan waktu masuk kos if active")
    public void ownerClickOnToggleCheckInKosIfActive() {
        billBookingManage.ownerClickOnToggleCheckInKosIfActive();
    }
    @And("owner click on dropdown waktu masuk kos")
    public void ownerClickOnDropdownTotalDay() {
        billBookingManage.ownerClickOnDropdownTotalDay();
    }
    @And("owner click on simpan button on popup total day")
    public void ownerClickOnSimpanPopupTotalDay() {
        billBookingManage.ownerClickOnSimpanPopupTotalDay();
    }
    @And("owner click on dropdown jarak waktu terjauh")
    public void ownerClickOnDropdownLongDistance() {
        billBookingManage.ownerClickOnDropdownLongDistance();
    }
    @And("owner click on dropdown satuan waktu")
    public void ownerClickOnDropdownUnitTime() {
        billBookingManage.ownerClickOnDropdownUnitTime();
    }
    @And("owner click on simpan button on popup satuan waktu")
    public void ownerClickOnSimpanPopupUnitTime() {
        billBookingManage.ownerClickOnSimpanPopupUnitTime();
    }
}
