package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.owner.kelolatagihan.BillAndBookingManagementPO;
import pageobject.owner.OwnerDashboardPO;
import pageobject.owner.kelolatagihan.PengajuanBookingPO;
import utilities.PlaywrightHelpers;

import java.util.List;
import java.util.Map;

public class OwnerAcceptBookingSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    OwnerDashboardPO ownerDashboard = new OwnerDashboardPO(page);
    PengajuanBookingPO pengajuanBooking;
    BillAndBookingManagementPO billBookingManage;
    List<Map<String, String>> tenantNames;
    @When("owner accept booking")
    public void ownerAcceptBooking() throws InterruptedException {
        ownerDashboard.clickOnManagementKost();
        pengajuanBooking = ownerDashboard.clickOnPengajuanBooking();
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
        ownerDashboard.clickOnManagementKost();
        pengajuanBooking = ownerDashboard.clickOnPengajuanBooking();
        billBookingManage = pengajuanBooking.ownerAcceptBooking(tenantName);
        billBookingManage.clickOnRoomNumberInput();
        billBookingManage.clickOnPilihDitempat();
        billBookingManage.clickOnTerapkanButton();
        billBookingManage.clickOnLanjutkanButton();
        billBookingManage.clickOnSimpan();
        billBookingManage.clickOkButton();
    }
}
