package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.LoadingPO;
import pageobject.owner.MamipayPO;
import pageobject.owner.OwnerDashboardPO;
import pageobject.owner.PropertiSayaPO;
import utilities.PlaywrightHelpers;

public class MamipaySteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    MamipayPO mamipayPO = new MamipayPO(ActiveContext.getActivePage());
    OwnerDashboardPO ownerDashboardPO = new OwnerDashboardPO(ActiveContext.getActivePage());
    PropertiSayaPO propertySaya = new PropertiSayaPO(ActiveContext.getActivePage());
    LoadingPO loadingPO = new LoadingPO(ActiveContext.getActivePage());
    Page page1;


    @Then("verify the title on mamipay owner onboarding displayed")
    public void verifyTheTitleOnMamipayOwnerOnboardingDisplayed() {
        Assert.assertTrue(mamipayPO.getTitleOnboarding(), "Title onboarding mamipay owner doesn't match!");
    }

    @When("owner click Lanjutkan button")
    public void ownerClickLanjutkanButton() {
        mamipayPO.clickLanjutkanButton();
    }

    @Then("verify nama lengkap equals username owner")
    public void verifyNamaLengkapEqualsUsernameOwner() {
        playwright.hardWait(3000);
        Assert.assertEquals(mamipayPO.getNamaLengkap(), ownerDashboardPO.getOwnerUsername(), "Username and Nama Lengkap doesn't match!");
    }

    @When("owner input on {string} {string}")
    public void ownerInputOn(String fieldName, String inputText) {
        // Skip if owner already has mamipay (modal success was shown)
        if (mamipayPO.isOwnerAlreadyHasMamipay()) {
            return;
        }
        mamipayPO.inputTextField(fieldName, inputText);
    }

    @And("verify mamipay form information:")
    public void verifyMamipayFormInformation(String info) {
        Assert.assertEquals(mamipayPO.getInfoMamipay().replaceAll("[\\t ]", " "), info, "Info mamipay doesn't match!");
    }

    @And("verify term and condition is disable")
    public void verifyTermAndConditionIsDisable() {
        Assert.assertTrue(mamipayPO.isTermAndConditionDisable(), "Term and condition is enable");
    }

    @And("verify kirim data button is disable")
    public void verifyKirimDataButtonIsDisable() {
        Assert.assertTrue(mamipayPO.isKirimDataButtonDisable(), "Kirim data button is enable");
    }

    @And("owner select bank name {string}")
    public void ownerSelectBankName(String bankName) {
        // Skip if owner already has mamipay (modal success was shown)
        if (mamipayPO.isOwnerAlreadyHasMamipay()) {
            return;
        }
        mamipayPO.selectBankName(bankName);
    }

    @And("owner check term and condition")
    public void ownerCheckTermAndCondition() {
        playwright.waitTillPageLoaded(5000.0);
        loadingPO.waitForLoadingIconDisappear();
        page1 = mamipayPO.clickOnTermAndCondition();
        Assert.assertTrue(mamipayPO.getTitlePusatBantuan(), "Title pusat bantuan doesn't match!");
    }

    @And("owner click term and condition")
    public void ownerClickTermAndCondition() {
        // Skip if owner already has mamipay (modal success was shown)
        if (mamipayPO.isOwnerAlreadyHasMamipay()) {
            return;
        }
        mamipayPO.clickOnChecTnC();
    }

    @Then("verify info untuk anda Auto BBK is displayed")
    public void verifyInfoUntukAndaAutoBBKIsDisplayed() {
        Assert.assertTrue(mamipayPO.isInfoUntukAndaAutoBbkDisplayed(), "Info untuk anda Auto BBK doesn't appear!");
    }

    @Then("verify form {string} for Auto BBK")
    public void verifyFormForAutoBBK(String title) {
        loadingPO.waitForLoadingIconDisappear();
        Assert.assertEquals(mamipayPO.getTitleForm(), title, "Title doesn't match!");
    }

    @Then("verify info untuk anda Auto BBK not displayed")
    public void verifyInfoUntukAndaAutoBBKNotDisplayed() {
        playwright.hardWait(2000);
        Assert.assertFalse(mamipayPO.isInfoUntukAndaAutoBbkDisplayed(), "Info untuk anda Auto BBK is appear!");
        playwright.hardWait(2000);
    }

    @And("owner verify Auto BBK pop up is displayed")
    public void ownerVerifyAutoBBKPopUpIsDisplayed() {
        Assert.assertTrue(propertySaya.BBKPopUpVisible(), "Auto BBK pop up doesn't displayed!");
        Assert.assertEquals(mamipayPO.getTitleAutoBbkPopUp(), "Ingin Kamar Kosong Anda Cepat Terisi?", "Title pop up doesn't match!");
    }

    @Then("owner verify Auto BBK pop up is not displayed")
    public void ownerVerifyAutoBBKPopUpIsNotDisplayed() {
        Assert.assertFalse(propertySaya.isPopUpModalVisible(), "Auto BBK pop up doesn't displayed!");
    }

    @Then("owner see next button disable")
    public void ownerSeeNextButtonDisable() {
        mamipayPO.kirimDataDisable();
    }
    
}