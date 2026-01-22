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
        ownerDashboard.dismissFTUEGoldplus();
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
        ownerDashboard.dismissFTUEGoldplus();
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
        ownerDashboard.clickOnPengajuanSewa();
        ownerDashboard.clickOnTerimaViaHomepage();
        pengajuanBooking.clickOnTerimaPopUp();
        billBookingManage.clickOnRoomNumberInput();
        billBookingManage.clickOnOneRooms();
        billBookingManage.clickOnTerapkanButton();
        billBookingManage.clickOnLanjutkanButton();
        billBookingManage.clickOnSimpan();
    }

    @When("owner navigate to booking page and accept booking from tenant:")
    public void ownerNavigateToBookingPageAndAcceptBookingFromTenant(DataTable table) throws InterruptedException {
        tenantNames = table.asMaps(String.class, String.class);
        var tenantName = tenantNames.get(0).get("tenant " + Mamikos.ENV);

        // Navigate directly to booking request page
        playwright.navigateTo(Mamikos.OWNER_URL + "/booking/request");
        loading.waitForLoadingIconDisappear();

        // Accept booking from specific tenant
        billBookingManage = pengajuanBooking.ownerAcceptBooking(tenantName);
        billBookingManage.clickOnRoomNumberInput();
        billBookingManage.clickOnPilihDitempat();
        billBookingManage.clickOnTerapkanButton();
        billBookingManage.clickOnLanjutkanButton();
        billBookingManage.clickOnSimpan();
        billBookingManage.clickOkButton();
    }
}
