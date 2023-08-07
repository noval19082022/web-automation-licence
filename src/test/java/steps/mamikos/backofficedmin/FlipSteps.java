package steps.mamikos.backofficedmin;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.admin.mamipay.flip.FlipPO;

public class FlipSteps {
    Page page = ActiveContext.getActivePage();
    FlipPO flipPO = new FlipPO(page);

    @Given("admin go to big flip bussiness and login for test mode")
    public void adminGoToBigFlipTestMode() {
        flipPO.visitFlipSandboxAndLogin("attkrismamikos", "aji@mamiteam.com", "mamipayoke123go!");
    }

    @Then("admin verify on flip test mode")
    public void adminVerifyOnFlipTestMode() {
        Assert.assertTrue(flipPO.verifyOnTestMode());
        Assert.assertEquals("https://business.flip.id/sandbox/overview", page.url());
    }

    @When("admin navigate to riwayat transaksi domestic page on big flip test mode")
    public void adminNavigateToRiwayatTransaksiDomesticPageOnBigFlipTestMode() {
        flipPO.navigateToDomesticTransaction();
        Assert.assertTrue(flipPO.verifyOnTestMode());
    }

    @And("admin set force success transaction on flip")
    public void adminSetForceSuccessTransactionOnFlip() {
        Assert.assertTrue(flipPO.verifyOnTestMode());
        flipPO.setForceTransaction();
    }
}