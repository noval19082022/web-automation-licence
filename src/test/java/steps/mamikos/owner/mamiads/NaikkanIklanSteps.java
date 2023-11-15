package steps.mamikos.owner.mamiads;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.owner.goldplus.GoldplusPO;
import pageobject.owner.mamiads.MamiAdsPO;
import pageobject.owner.mamiads.NaikkanIklanPO;
import utilities.PlaywrightHelpers;

import java.util.List;
import java.util.Map;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class NaikkanIklanSteps {
    Page page = ActiveContext.getActivePage();
    MamiAdsPO mamiAdsPO = new MamiAdsPO(page);
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    NaikkanIklanPO naikkanIklanPO = new NaikkanIklanPO(page);

    @Then("user cek status toggle iklan {string} is {string}")
    public void user_cek_status_toggle_iklan_is(String adsName, String posisiIklan) throws InterruptedException {
        if (posisiIklan.equals("Naik")) {
            Assert.assertEquals(naikkanIklanPO.getPosisiIklan(posisiIklan), "Naik", "Posisi iklan doesn't available");
            Assert.assertEquals(naikkanIklanPO.getAdsName(adsName), adsName,"ads name doesnt match");
        } else if (posisiIklan.equals("tidak-naik")) {
            Assert.assertEquals(naikkanIklanPO.getPosisiIklan(posisiIklan), "Tidak Naik", "Posisi iklan available");
            Assert.assertEquals(naikkanIklanPO.getAdsName(adsName), adsName,"ads name doesnt match");
        }
    }

    @Then("user verify the toggle iklan {string} is {string}")
    public void user_verify_the_toggle_iklan_is(String adsName, String toggleStatus) throws InterruptedException {
        Assert.assertTrue(naikkanIklanPO.getToggleStatus(toggleStatus), "toggle doesn't match!");
        Assert.assertEquals(naikkanIklanPO.getAdsName(adsName), adsName,"ads name doesnt match");
    }

    @Then("user verify the wording iklan penuh {string} is {string}")
    public void user_verify_the_wording_iklan_penuh_is(String adsName, String adsDesc) throws InterruptedException {
        Assert.assertEquals(naikkanIklanPO.isFullOcuppancyActiveAds().replaceAll("\n", "").replaceAll("\\s+", " "), adsDesc, "Kamar Penuh doesn't match!");
        Assert.assertEquals(naikkanIklanPO.getAdsName(adsName), adsName,"ads name doesnt match");
    }

    @Then("user verify the alokasi title is {string}")
    public void user_verify_the_alokasi_title_is(String alokasiTitleText) {
        Assert.assertEquals(naikkanIklanPO.getAlokasiTitleText(alokasiTitleText), alokasiTitleText, "Alokasi title doesn't match!");
    }

    @Then("user verify the toggle is {string}")
    public void user_verify_the_toggle_is(String toggleAdsStatus) {
        Assert.assertTrue(naikkanIklanPO.getToggleAdsStatus(toggleAdsStatus), "toggle ads status doesn't match!");
    }

    @Then("user verify the wording ads is {string}")
    public void user_verify_the_wording_ads_is(String adsDescText) {
        switch (adsDescText){
            case "Kamar penuh":
                Assert.assertEquals(naikkanIklanPO.getAdsDescText(adsDescText), "Kamar penuh. Silakan nonaktifkan jika tidak ingin menaikkan posisi iklan ini.");
                break;
        }
    }

    @When("owner select filter active mamiads")
    public void owner_select_filter_active_mamiads() {
       naikkanIklanPO.clickOnFilterActive();
    }

    @Then("user verify the redirection to list mamiads balance")
    public void user_verify_the_redirection_to_list_mamiads_balance() throws InterruptedException {
        naikkanIklanPO.clickOnAllocationSection();
        String actualUrl= playwright.getPageUrl();
        Assert.assertEquals(actualUrl, "https://owner-jambu.kerupux.com/mamiads/balance?redirectionSource=properti%20saya", "Url doesn't match");
    }

}
