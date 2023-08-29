package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.owner.PromoOwnerPO;
import utilities.PlaywrightHelpers;

public class PromoOwnerSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    PromoOwnerPO promoOwner = new PromoOwnerPO(ActiveContext.getActivePage());
    Page page1;

    @And("owner atur promo owner")
    public void ownerAturPromoOwner() {
        promoOwner.clickOnSelengkapnya();
        page1 = promoOwner.clickOnAturPromo();
    }

    @Then("verify status promo is {string}")
    public void verifyStatusPromoIs(String promoStatus) {
        playwright.hardWait(3000);
        Assert.assertEquals(promoOwner.getTextStatus(promoStatus), promoStatus);
        Assert.assertTrue(promoOwner.isButtonPromo("Buat Promo"), "Button doesn't match!");
    }

    @When("owner create new promo owner with title {string} for periode promo {string}")
    public void ownerCreateNewPromoOwnerWithTitleForPeriodePromo(String titleText, String periodePromo) {
        promoOwner.clickOnBuatPromo();
        promoOwner.inputPromoOwner(titleText);
        promoOwner.selectStartDatePromo(periodePromo);
        promoOwner.selectEndDatePromo(periodePromo);
        promoOwner.clickOnPasangPromo();
    }

    @Then("verify judul promo {string}")
    public void verifyJudulPromo(String titleText) {
        Assert.assertEquals(promoOwner.getJudulPromoOwner(), titleText, "Judul promo Anda doesn't match!");
    }

    @When("owner edit promo kost owner with title {string}")
    public void ownerEditPromoKostOwnerWithTitle(String titleText) {
        playwright.hardWait(2000);
        promoOwner.clickOnBuatPromo();
        Assert.assertTrue(promoOwner.isEditPromoButton(), "Button doesn't match!");
        promoOwner.editPromoOwner(titleText);
    }

    @When("owner edit promo kost owner with start date {string} and end date {string}")
    public void ownerEditPromoKostOwnerWithStartDateAndEndDate(String startPromo, String endPromo) {
        promoOwner.clickOnBuatPromo();
        promoOwner.selectStartDatePromo(startPromo);
        promoOwner.selectEndDatePromo(endPromo);
    }

    @Then("verify warning {string} is displayed")
    public void verifyWarningIsDisplayed(String warningText) {
        Assert.assertEquals(promoOwner.getTextWarningMessage(warningText), warningText, "Warning doesn't match!");
        playwright.hardWait(3000.0);
    }

    @And("admin search the title promo on search box")
    public void adminSearchTheTitlePromoOnSearchBox() {
        promoOwner.clickOnSeachPromo();
    }

    @Then("admin verified the promo owner")
    public void adminVerifiedThePromoOwner() {
        Assert.assertTrue(promoOwner.isUnverifiedStatus(), "Status doesn't match!");
        promoOwner.clickOnVerificationPromo();
        Assert.assertEquals(promoOwner.getAlertSuccessUpdate(), "Success! Promo is updated.", "message doesn't match!");
        adminSearchTheTitlePromoOnSearchBox();
        Assert.assertFalse(promoOwner.isUnverifiedStatus(), "Status doesn't match!");
    }

    @Then("admin unverified the promo owner")
    public void adminUnverifiedThePromoOwner() {
        Assert.assertFalse(promoOwner.isUnverifiedStatus(), "Status doesn't match!");
        promoOwner.clickOnUnverificationPromo();
        Assert.assertEquals(promoOwner.getAlertSuccessUpdate(), "Success! Berhasil mengganti status", "message doesn't match!");
        Assert.assertTrue(promoOwner.isUnverifiedStatus(), "Status doesn't match!");
    }

    @When("owner click edit promo button")
    public void ownerClickEditPromoButton() {
        promoOwner.clickOnEditPromo();
    }

    @And("admin delete the promo admin")
    public void adminDeleteThePromoAdmin() {
        promoOwner.clickOnDeletePromo();
    }
}