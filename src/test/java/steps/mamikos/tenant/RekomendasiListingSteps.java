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
}
