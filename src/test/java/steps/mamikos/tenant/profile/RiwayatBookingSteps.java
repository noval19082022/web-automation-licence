package steps.mamikos.tenant.profile;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
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
        riwayatBooking.clickSelengkapnyaButton();
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
}
