package steps.mamikos.tenant;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.KostDetailsPO;
import pageobject.common.SearchPO;
import pageobject.tenant.RekomendasiListingPO;
import utilities.PlaywrightHelpers;

public class RekomendasiListingSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    RekomendasiListingPO rekomendasiListing = new RekomendasiListingPO(page);
    SearchPO searchListing = new SearchPO(page);
    KostDetailsPO kostDetail = new KostDetailsPO(page);
    Page page1;


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
        Assert.assertTrue(rekomendasiListing.isRekomendasiSectionVisible(), "Rekomendasi listing doesn't displayed!");
    }

    @Then("user verify the rekomendasi listing max is {int} page")
    public void user_verify_the_rekomendasi_listing_max_is_page(int paginationNumberExpected) {
        int paginationNumberActual = rekomendasiListing.getPaginationActual();
        Assert.assertTrue(paginationNumberActual <= paginationNumberExpected, "Rekomendasi doesn't match!");
    }

    @Then("user verify the max {int} rekomendasi listing")
    public void user_verify_the_max_rekomendasi_listing(int maxRekomendasiExpected) {
        int rekomendasiActual = rekomendasiListing.getRekomendasiActual();
        Assert.assertTrue(rekomendasiActual <= maxRekomendasiExpected, "Rekomendasi listing more than 8!");
    }

    @Then("do validation rekomendasi {string} on {string} page")
    public void do_validation_rekomendasi_on_page(String validation, String menuUser) {
        rekomendasiListing.clickOnUserPhoto();
        rekomendasiListing.clickOnProfile();
        Assert.assertEquals(rekomendasiListing.getMenuUserTenant(menuUser), menuUser, "You didn't on menu " + menuUser);
        switch (validation) {
            case "displayed":
                Assert.assertTrue(rekomendasiListing.isRekomendasiSectionVisible(), "Rekomendasi Listing not displayed");
                break;
            case "not displayed":
                Assert.assertFalse(rekomendasiListing.isRekomendasiSectionVisible(), "Rekomendasi Listing is displayed");
        }
    }

    @And("tenant open menu favorite")
    public void tenant_open_menu_favorite() {
        rekomendasiListing.clickOnFavoriteHeader();
    }

    @Then("verify last seen property doesn't display on rekomendasi section")
    public void verify_last_seen_property_doesn_t_display_on_rekomendasi_section() {
        Assert.assertTrue(rekomendasiListing.isRekomendasiSectionVisible(), "Mungkin cocok untuk anda doesn't display!");
        Assert.assertFalse(rekomendasiListing.isPropertyVisible(searchListing.getProperty()), "Property already display!");
    }

    @Then("tenant open menu kost saya")
    public void tenant_open_menu_kost_saya() {
        rekomendasiListing.clickOnUserPhoto();
        rekomendasiListing.clickOnProfile();
    }

    @When("tenant see first kost rekomendasi at kos saya page")
    public void tenant_see_first_kost_rekomendasi_at_kos_saya_page() throws InterruptedException {
        rekomendasiListing.getFirstProperty("Kos Saya");
        page1 = rekomendasiListing.clickOnFirstRekomendasi();

    }
    @Then("tenant can not see kos after favorited that kos at recomendation section")
    public void tenant_can_not_see_kos_after_favorited_that_kos_at_recomendation_section() throws InterruptedException {
        Assert.assertFalse(rekomendasiListing.isRekomendasiAfterFavoritVisible(rekomendasiListing.getFavoritPropertyRekomendasi()), "Property already display!");
        rekomendasiListing.clickOnFavoriteHeader();
        rekomendasiListing.clickOnPropertyFavoritRecomendation(rekomendasiListing.getFavoritPropertyRekomendasi());
    }

    @Then("user can verify kost after unfavorite the kost")
    public void user_can_verify_kost_after_unfavorite_the_kost() {
        rekomendasiListing.clickOnFavoriteHeader();
        Assert.assertFalse(rekomendasiListing.isRekomendasiAfterFavoritVisible(rekomendasiListing.getFavoritPropertyRekomendasi()),"Property not display!");
    }

    @When("tenant wants to open detail kost {string} from favorite page")
    public void tenant_wants_to_open_detail_kost_from_favorite_page(String kostName) throws InterruptedException {
        page1 = rekomendasiListing.clickOnPropertyFavorit(kostName);
    }

}
