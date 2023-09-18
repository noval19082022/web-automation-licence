package steps.mamikos.owner.mamiads;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.owner.mamiads.MamiAdsPO;
import utilities.PlaywrightHelpers;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class MamiAdsSteps {
    Page page = ActiveContext.getActivePage();
    MamiAdsPO mamiAdsPO = new MamiAdsPO(page);
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);

    @And("owner want to buy mamiads saldo with nominal {string}")
    public void ownerWantToBuyMamiadsSaldo(String saldo) {
        mamiAdsPO.purchaseOwnerSaldoFromMamiads(saldo);
    }

    @And("user filter iklan by iklan nonaktif")
    public void userFilterIklanByIklanNonaktif() {
        mamiAdsPO.clickOnSemuaIklan();
        mamiAdsPO.clickOnIklanNonaktif();
    }

    @And("user close mamiads onboarding popup")
    public void userCloseMamiadsOnboardingPopup() {
        mamiAdsPO.handlePopupMamiAds();
    }

    @And("user see title {string} with message {string}")
    public void user_see_title_x_with_message_x(String title, String message) {
        Assert.assertEquals(mamiAdsPO.getTitleText(), title);
        Assert.assertEquals(mamiAdsPO.getMessageText(), message);

    }

    @When("user navigates to mamiads dashboard")
    public void user_navigates_to_mamiads_dashboard() {
        playwright.navigateTo(Mamikos.OWNER_URL + Mamikos.MAMIADS, 30000.0, LoadState.LOAD);
        playwright.bringPageToView(page);
    }

    @Then("user redirected to guides page mamiAds")
    public void user_redirected_to_guides_page_mami_ads() {
        assertThat(page).hasURL(Mamikos.OWNER_URL + Mamikos.MAMIADS_GUIDE);
    }

    @Then("tap back button on panduan Mamiads.")
    public void tap_back_button_on_panduan_mamiads() {
       mamiAdsPO.clickOnPanduanMamiAdsBackButton();
    }

    @Then("user redirected to guides page mamiAds from GP")
    public void user_redirected_to_guides_page_mami_ads_from_gp() {
        assertThat(page).hasURL(Mamikos.OWNER_URL + Mamikos.MAMIADS_GUIDE_GP);
    }
}
