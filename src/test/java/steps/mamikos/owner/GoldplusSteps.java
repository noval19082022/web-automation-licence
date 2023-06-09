package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.owner.GoldplusPO;
import pageobject.owner.OwnerDashboardPO;
import steps.mamikos.common.NavigatesSteps;
import utilities.PlaywrightHelpers;

import java.util.List;
import java.util.Map;

public class GoldplusSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    NavigatesSteps navigate = new NavigatesSteps();
    GoldplusPO goldplus = new GoldplusPO(page);
    private Integer unpaidInvoice;

    @When("user wants to subscribe Goldplus {int}")
    public void user_wants_to_subscribe_goldplus(int pacakge) {
        navigate.userNavigateTo("/goldplus/submission/periode/gp"+pacakge);
        playwright.clickOnTextButton("Pilih");
        playwright.hardWait(3000);
        playwright.clickOnText("Bayar Sekarang");
    }

    @When("user wants to reset Goldplus for owner with phone number {string}")
    public void user_wants_to_reset_Goldplus_for_owner_with_phone_number(String phoneNumber) {
        goldplus.inputGoldplusPhoneNumber(phoneNumber);
        playwright.clickOnTextButton("Reset");
    }

    @Then("user verify list of Periode Berlangganan is appear")
    public void user_verify_list_of_period_berlangganan_is_appear(DataTable dataTable) {
        playwright.hardWait(1000);
        List<Map<String, String>> table = dataTable.asMaps();
        int i=0;
        for (Map<String, String> content : table) {
            Assert.assertEquals(goldplus.listPeriod("periodGP",i).replaceAll("\\s", ""),content.get("periodGP").replaceAll("\\s", ""));
            Assert.assertEquals(goldplus.listPeriod("freeMamiAds",i),content.get("freeMamiAds"));
            Assert.assertEquals(goldplus.listPeriod("actualPrice",i),content.get("actualPrice"));
            Assert.assertEquals(goldplus.listPeriod("discPrice",i),content.get("discPrice"));
            i++;
        }
    }

    @Then("admin successfully sets favorite label to none")
    public void admin_successfully_sets_favorite_label_to_none() {
        goldplus.clickOnEditGP1Button();
        goldplus.clickNoRadioButton();
        playwright.clickOnText("Save");
    }

    @When("admin successfully sets favorite label to active")
    public void admin_successfully_sets_favorite_label_to_active() {
        goldplus.clickOnEditGP1Button();
        goldplus.clickYesRadioButton();
        playwright.clickOnText("Save");
    }

    @When("admin successfully adds additional favorite labels")
    public void admin_successfully_adds_additional_favorite_labels() {
        goldplus.clickOnEditGP2Button();
        goldplus.clickYesRadioButton();
        playwright.clickOnText("Save");
    }

    @When("admin successfully remove additional favorite labels")
    public void admin_successfully_remove_additional_favorite_labels() {
        goldplus.clickOnEditGP2Button();
        goldplus.clickNoRadioButton();
        playwright.clickOnTextButton("Save");
    }

    @And("user purchase {string}")
    public void userPurchase(String gpPackage) {
        goldplus.clickOnRegisterGP();
        if (gpPackage.equals("Goldplus 1")){
            goldplus.choosePaketGP("GP1");
        } else if (gpPackage.equals("Goldplus 2")){
            goldplus.choosePaketGP("GP2");
        }
        goldplus.clickOnPilihPeriodeButton();
        goldplus.clickOnBayarSekarang();
    }

    @And("user click info untuk anda {string}")
    public void userClickInfoUntukAnda(String infoUntukAnda) {
        goldplus.clickOnInfoUntukAnda(infoUntukAnda);
    }

    @Then("verify redirect to pilih periode screen")
    public void verifyRedirectToPilihPeriodeScreen() {
        Assert.assertTrue(goldplus.isPilihPeriodeScreen(), "It's doesn't pilih periode screen!");
    }

    @Then("user verify Lihat Invoice visible")
    public void userVerifyLihatInvoiceVisible() {
        goldplus.isLihatInvoiceDisplayed();
        goldplus.clickOnLihatInvoice();
        Assert.assertTrue(goldplus.isDetailTagihanVisible(), "Detail tagihan doesn't visible");
    }

    @Then("user see Title {string} with message {string} on page {string}")
    public void userSeeTitleWithMessageOnPage(String title, String message, String page) {
        switch (page){
            case "cek properti sekitar":
                Assert.assertEquals(goldplus.getTitleEmptyState(title), title);
                Assert.assertEquals(goldplus.getMessage(), message);
        }
    }

    @Then("user see Title on page {string} is {string} with message:")
    public void userSeeTitleOnPageIsWithMessage(String page, String title, String docString) {
        switch (page){
            case "cek properti sekitar":
                Assert.assertEquals(goldplus.getTitleEmptyState(title), title);
                Assert.assertEquals(goldplus.getMessage(),docString.replaceAll("\\s", ""));
        }
    }

    @Then("verify redirect to invoice universal")
    public void verifyRedirectToInvoiceUniversal() {
        Assert.assertTrue(goldplus.isInvoiceUniversal(), "Doesn't invoice universal!");
    }

    @And("owner click {string} on confirmation pop up")
    public void ownerClickOnConfirmationPopUp(String actionText) {
//        Assert.assertTrue(goldplus.isConfirmationPopUpVisible("Yakin ingin membatalkan pembayaran tagihan?"), "Confirmation pop up doesn't appear!");
        goldplus.clickOnActionButtonPopUp(actionText);
    }

    @Then("verify unpaid invoice is {int}")
    public void verifyUnpaidInvoiceIs(int unpaidInvoiceExpected) {
        unpaidInvoice = goldplus.getCountInvoiceUnpaid();
        System.out.println("Unpaid invoice ="+ unpaidInvoice);
        Assert.assertTrue(unpaidInvoice == unpaidInvoiceExpected);
    }
}
