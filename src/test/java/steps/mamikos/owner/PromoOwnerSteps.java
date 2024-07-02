package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.LoadingPO;
import pageobject.owner.PromoOwnerPO;
import utilities.PlaywrightHelpers;

import java.util.List;
import java.util.Map;

public class PromoOwnerSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    PromoOwnerPO promoOwner = new PromoOwnerPO(ActiveContext.getActivePage());
    LoadingPO loading = new LoadingPO(page);

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

    @And("admin search the title promo {string} on search box")
    public void adminSearchTheTitlePromoOnSearchBox(String promoTitle) {
        promoOwner.clickOnSeachPromo(promoTitle);
    }

    @Then("admin verified the promo owner {string}")
    public void adminVerifiedThePromoOwner(String promoTitle) {
        Assert.assertTrue(promoOwner.isUnverifiedStatus(), "Status doesn't match!");
        promoOwner.clickOnVerificationPromo();
        Assert.assertEquals(promoOwner.getAlertSuccessUpdate(), "Success! Promo is updated.", "message doesn't match!");
        adminSearchTheTitlePromoOnSearchBox(promoTitle);
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

    @And("admin accsess menu promo owner to create promo owner")
    public void adminAccsessMenuPromoOwnerToCreatePromoOwner() {
        promoOwner.adminClickCreatePromoOwnerButton();
    }

    @And("admin fill {string} at search kost form")
    public void adminFillAtSearchKostForm(String kosName) {
        promoOwner.fillKosNameForPromo(kosName);
        promoOwner.clickOnSearchKosCreatePromo();
        promoOwner.clickOnBuatkanPromosi();
    }

    @And("admin fills valid data promo owner as expected")
    public void adminFillsValidDataPromoOwnerAsExpected(DataTable dataTable) {
        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);

        promoOwner.inputPromoOwnerFromAdmin(table.get(0).get("title"), "Title");
        promoOwner.inputPromoOwnerFromAdmin(table.get(0).get("content"), "Content...");

        promoOwner.selectStartDatePromoFromAdmin(table.get(0).get("start-date"));
        promoOwner.selectEndDatePromoFromAdmin(table.get(0).get("end-date"));
    }

    @And("admin clicks on ceate and verify promotion")
    public void adminClicksOnCeateAndVerifyPromotion() {
        promoOwner.clickOnClickAndVerifyPromotion();
    }

    @Then("admin successfully add promo owner")
    public void adminSuccessfullyAddPromoOwner() {
        Assert.assertEquals(promoOwner.getAlertSuccessUpdate(), "Success! Promo created successfully", "Alert doesn't match!");
    }

    @And("admin clicks on ceate promotion")
    public void adminClicksOnCeatePromotion() {
        promoOwner.clickOnCreatePromotion();
    }

    @Then("admin verify the status promo is No verification admin")
    public void adminVerifyTheStatusPromoIsNoVerificationAdmin() {
        Assert.assertTrue(promoOwner.isUnverifiedStatus(), "Verification admin is verified!");
    }

    @When("admin click on action show and edit promo owner")
    public void adminClickOnActionShowAndEditPromoOwner() {
        promoOwner.clickOnShowAndEditPromo();
    }

    @Then("admin verify the confirmation is {string}")
    public void adminVerifyTheConfirmationIs(String status) {
        Assert.assertFalse(promoOwner.isConfirmationTrue(status), "Confirmation status doesn't match!");
    }

    @Then("user not see promo owner on {string} detail")
    public void userNotSeePromoOwnerOnDetail(String propertyType) {
        Assert.assertFalse(promoOwner.isDetailKostPromoOwnerVisible(propertyType), "Detail promo owner not visible!");
    }
}