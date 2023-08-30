package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.owner.MamipayPO;
import pageobject.owner.OwnerDashboardPO;
import utilities.PlaywrightHelpers;

public class MamipaySteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    MamipayPO mamipayPO = new MamipayPO(ActiveContext.getActivePage());
    OwnerDashboardPO ownerDashboardPO = new OwnerDashboardPO(ActiveContext.getActivePage());
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
        mamipayPO.selectBankName(bankName);
    }

    @And("owner check term and condition")
    public void ownerCheckTermAndCondition() {
        page1 = mamipayPO.clickOnTermAndCondition();
        Assert.assertTrue(mamipayPO.getTitlePusatBantuan(), "Title pusat bantuan doesn't match!");
    }

    @And("owner click term and condition")
    public void ownerClickTermAndCondition() {
        mamipayPO.clickOnChecTnC();
    }
}
