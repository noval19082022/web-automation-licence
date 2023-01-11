package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.owner.BillAndBookingManagementPO;
import pageobject.owner.OwnerDashboardPO;
import pageobject.owner.PengajuanBookingPO;
import utilities.PlaywrightHelpers;

public class OwnerAcceptBookingSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    OwnerDashboardPO ownerDashboard = new OwnerDashboardPO(page);
    PengajuanBookingPO pengajuanBooking;
    BillAndBookingManagementPO billBookingManage;
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
}
