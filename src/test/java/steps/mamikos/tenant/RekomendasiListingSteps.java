package steps.mamikos.tenant;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.tenant.RekomendasiListingPO;
import utilities.PlaywrightHelpers;

public class RekomendasiListingSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    RekomendasiListingPO rekomendasiListing = new RekomendasiListingPO (page);

    @Then("verify message {string} di Favorit page")
    public void verifyMessageDiFavoritPage(String message) {
        rekomendasiListing.clickOnFavoritPage();
        Assert.assertEquals(rekomendasiListing.getMessageEmptyState(message), message, "Empty state doesnt match!");
    }

    @And("verify no rekomendasi on kos saya page")
    public void verifyNoRekomendasiOnKosSayaPage() {
        rekomendasiListing.clickOnUserPhoto();
        rekomendasiListing.clickOnProfile();
        Assert.assertTrue(rekomendasiListing.isMulaiCariDanSewaKosIsVisible(), "Mulai Cari dan Sewa Kos doesnt appear");
        Assert.assertTrue(rekomendasiListing.isMasukkanKodeDariPemilikIsVisible(), "Masukkan kode dari pemilik doesnt appear!");
    }

    @Then("user verify rekomendasi listing section is displayed")
    public void user_verify_rekomendasi_listing_section_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user verify the rekomendasi listing max is {int} page")
    public void user_verify_the_rekomendasi_listing_max_is_page(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user verify the max {int} rekomendasi listing")
    public void user_verify_the_max_rekomendasi_listing(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("do validation rekomendasi {string} on kos saya page")
    public void do_validation_rekomendasi_on_kos_saya_page(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
