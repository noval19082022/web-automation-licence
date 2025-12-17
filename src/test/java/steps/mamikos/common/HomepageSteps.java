package steps.mamikos.common;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.HomePO;
import utilities.PlaywrightHelpers;

import java.util.Map;

public class HomepageSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    HomePO home = new HomePO(page);

    @Then("user see flash sale section")
    public void userSeeFlashSaleSection() {
        home.scrollToViewPromoNgebutHeading();
        Assert.assertTrue(home.promoNgebutHeadingIsVisible(), "Promo ngebut heading is not visible");
        Assert.assertEquals(home.getPromoNgebutOptionsValue(), "Semua Kota", "Default value is not Semua Kota");
        Assert.assertTrue(home.isFlashSaleTimerVisible(), "Flash Sale Timer not visible");
        Assert.assertTrue(home.isFlashSaleLihatSemuaButtonVisible(), "Flash sale lihat semua button is not visible");
        Assert.assertTrue(home.isFlashSaleKostContainerVisible(), "Flash sale kost list is not visible");
        Assert.assertTrue(home.getAllFlashSaleLocator().size() > 0, "Flash sale icon is not present");
    }

    @And("user open kebijakan privasi in footer")
    public void userOpenKebijakanPrivasiInFooter() {
        home.clickOnKebijakanPrivasiButton();
        ActiveContext.setActivePage(ActiveContext.getActiveBrowserContext().pages().get(1));
    }

    @Then("user should redirect to kebijakan privasi page")
    public void userShouldRedirectToKebijakanPrivasiPage() {
        home = new HomePO(ActiveContext.getActivePage());
        Assert.assertTrue(home.isKebijakanPrivasiTitleDisplayed(), "Kebijakan Privasi page is not present");
    }

    @And("user open syarat dan ketentuan in footer")
    public void userOpenSyaratDanKetentuanInFooter() {
        home.clickOnSyaratKetentuanButton();
        ActiveContext.setActivePage(ActiveContext.getActiveBrowserContext().pages().get(1));
    }

    @Then("user should redirect to link {string}")
    public void userShouldRedirectToLink(String url) {
        playwright = new PlaywrightHelpers(ActiveContext.getActivePage());
        home = new HomePO(ActiveContext.getActivePage());
        
        // Wait for navigation away from about:blank
        if (home.getURL().contains("about:blank")) {
            playwright.waitTillUrlToBe(url, 10000.0);
        } else {
            // If not blank, just wait for page to fully load
            playwright.waitTillPageLoaded(10000.0);
        }
        
        Assert.assertEquals(home.getURL(), url, "Link is not equal");
    }

    @Then("tenant can see profile dropdown option")
    public void tenantCanSeeProfileDropdownOption() {
        home.clickOnProfileDropdown();
        Assert.assertTrue(home.isProfileMenuDisplayed(), "Profile Menu is not present");
        Assert.assertTrue(home.isRiwayatTransaksiMenuDisplayed(), "Riwayat Transaksi Menu is not present");
        Assert.assertTrue(home.isLogOutButtonDisplayed(), "Log Out Button is not present");
    }

    @Then("tenant can see ads dropdown option")
    public void tenantCanSeeAdsDropdownOption() {
        home.clickOnAdsDropdown();
        Assert.assertTrue(home.isKostMenuDisplayed(), "Kost Menu Dropdown is not present");
        Assert.assertTrue(home.isSinggahsiniApikMenuDisplayed(), "Singgahsini and Apik Menu Dropdown is not present");
        Assert.assertTrue(home.isKosAndalanMenuDisplayed(), "Kos Andalan Menu Dropdown is not present");
        Assert.assertTrue(home.isApartmentMenuDisplayed(), "Apartment Menu Dropdown is not present");
    }

    @When("user open tentang kami in footer")
    public void userOpenTentangKamiInFooter() {
        home.clickOnTentangKamiButton();
        ActiveContext.setActivePage(ActiveContext.getActiveBrowserContext().pages().get(1));
    }

    @Then("user should redirect to link that contains {string}")
    public void userShouldRedirectToLinkThatContains(String url) {
        // Wait a bit for navigation to start
        playwright = new PlaywrightHelpers(ActiveContext.getActivePage());
        playwright.hardWait(2000.0);
        
        // Refresh references after potential page change
        playwright = new PlaywrightHelpers(ActiveContext.getActivePage());
        home = new HomePO(ActiveContext.getActivePage());
        
        String currentUrl = home.getURL();
        
        // Check if it's an external URL (like WhatsApp API) or still on about:blank
        if (url.contains("api.whatsapp.com") || url.contains("twitter.com") || url.contains("x.com") || 
            currentUrl.contains("api.whatsapp.com") || currentUrl.contains("twitter.com") || currentUrl.contains("x.com")) {
            // For external URLs, just wait a bit more
            playwright.hardWait(2000.0);
        } else if (currentUrl.contains("about:blank")) {
            // Wait for navigation away from about:blank
            playwright.waitTillPageLoaded(10000.0);
            playwright.waitTillNetworkIdle();
        } else {
            // If not blank or external, wait for page to fully load
            playwright.waitTillPageLoaded(10000.0);
        }
        
        Assert.assertTrue(home.getURL().contains(url), "URL doesn't match");
    }

    @When("user open job mamikos in footer")
    public void userOpenJobMamikosInFooter() {
        home.clickOnJobMamikosButton();
        ActiveContext.setActivePage(ActiveContext.getActiveBrowserContext().pages().get(1));
    }

    @When("user open promosikan kost anda in footer")
    public void userOpenPromosikanKostAndaInFooter() {
        home.clickOnPromosikanIklanAndaButton();
        ActiveContext.setActivePage(ActiveContext.getActiveBrowserContext().pages().get(1));
    }

    @When("user open pusat bantuan in footer")
    public void userOpenPusatBantuanInFooter() {
        home.clickOnPusatBantuanButton();
        ActiveContext.setActivePage(ActiveContext.getActiveBrowserContext().pages().get(1));
    }

    @When("user open facebook in footer")
    public void userOpenFacebookInFooter() {
        home.clickOnFacebookButton();
        ActiveContext.setActivePage(ActiveContext.getActiveBrowserContext().pages().get(1));
    }

    @When("user open twitter in footer")
    public void userOpenTwitterInFooter() {
        home.clickOnTwitterButton();
        ActiveContext.setActivePage(ActiveContext.getActiveBrowserContext().pages().get(1));
    }

    @When("user open instagram in footer")
    public void userOpenInstagramInFooter() {
        home.clickOnInstagramButton();
        ActiveContext.setActivePage(ActiveContext.getActiveBrowserContext().pages().get(1));
    }

    @When("user open e-mail in footer")
    public void userOpenEMailInFooter() {
        home.clickOnEmailFooterLink();
        ActiveContext.setActivePage(ActiveContext.getActiveBrowserContext().pages().get(1));
    }

    @Then("user should redirect to Form Bantuan page")
    public void userShouldRedirectToFormBantuanPage() {
        home = new HomePO(ActiveContext.getActivePage());
        Assert.assertEquals(home.isFormBantuanTitleDisplayed(), "Form Bantuan page is not present");
    }

    @When("user open whatsapp in footer")
    public void userOpenWhatsappInFooter() {
        home.clickOnWhatsappNumber();
        ActiveContext.setActivePage(ActiveContext.getActiveBrowserContext().pages().get(1));
    }

    @Then("user can see copyright is {string}")
    public void userCanSeeCopyrightIs(String copyright) {
        Assert.assertEquals(home.getCopyrightText(), copyright, "Copyright is not as expected!");
    }

    @When("user see all owner promo")
    public void userSeeAllOwnerPromo() {
        home.clickOnSeeAllPromoOwnerButton();
        ActiveContext.setActivePage(ActiveContext.getActiveBrowserContext().pages().get(1));
    }

    @When("user see all promo ads")
    public void userSeeAllPromoAds() {
        home.clickOnSeeAllPromoAdsButton();
    }

    @When("user open Download App menu")
    public void userOpenDownloadAppMenu() {
        home.clickOnDownloadAppButton();
    }

    @When("user open Booking Kos menu")
    public void userOpenBookingKosMenu() {
        home.clickOnBookingKosHeaderButton();
    }

    @When("user open Popular Area in Jakarta")
    public void userOpenPopularAreaInJakarta() {
        home.clickPopularAreaOnJakarta();
    }

    @When("user open Popular Area in Yogyakarta")
    public void userOpenPopularAreaInYogyakarta() {
        home.clickPopularAreaOnYogyakarta();
    }

    @When("user open Around University in UGM")
    public void userOpenAroundUniversityInUGM() {
        home.clickAroundUGM();
    }

    @When("user open Around University in UNDIP")
    public void userOpenAroundUniversityInUNDIP() {
        home.clickAroundUNDIP();
    }

    @Then("user can see Lihat pengajuan sewa lainnya text")
    public void user_can_see_lihat_pengajuan_sewa_text() {
        Assert.assertTrue(home.isLihatPengajuanLainBtnVisible(), "lihat pengajuan sewa lainnya not visible");
    }

    @When("user click on Lihat pengajuan sewa lainnya button")
    public void user_click_on_lihat_pengajuan_sewa_lainnya_button() {
        home.clickLihatPengajuanLainBtn();
    }


    @When("user scroll into promo kost section")
    public void userScrollIntoPromoKostSection() {
        home.scrollIntoPromoNgebut();
    }

    @Then("user will see promo ngebut info on kost card")
    public void userWillSeePromoNgebutInfoOnKostCard() {
        Assert.assertNotNull(home.promoNgebutInfo());
    }


    @When("user want to visit apartment list page from ads Dropdown")
    public void userWantToVisitApartementListPageFromAdsDropdown() {
        home.visitApartmentListPage();
    }

    @And("user want to click on App Store on the footer")
    public void userWantToClickOnAppStoreOnTheFooter() {
        var page1 = ActiveContext.getActiveBrowserContext().waitForPage(() -> {
            home.clickOnAppStore();
        });
        ActiveContext.setActivePage(page1);
    }

    @And("user want to visit cari kost list page from ads Dropdown")
    public void userWantToVisitCariKostListPageFromAdsDropdown() {
        home.visitCariKosttListPage();
    }

    @And("user check promo ngebut label")
    public void userCheckPromoNgebutLabel() {
        Assert.assertTrue(home.promoNgebutHeadingIsVisible(), "Promo ngebut heading is not visible");
    }

    @And("user open blog mamikos in footer")
    public void userOpenBlogMamikosInFooter() {
        home.clickOnBlogMamikos();
    }

    @And("user open sewa kost untuk perusahaan in footer")
    public void userOpenSewaKostUntukPerusahaanInFooter() {
        home.clickOnSewaKostUntukPerusahaan();
    }

    @And("user open singgahsini in footer")
    public void userOpenSinggahsiniInFooter() {
        home.clickOnSinggahSiniOnFooter();
    }

    @When("user go to lihat semua Sekitar Kampus")
    public void userGoToLihatSemuaSekitarKampus() {
        home.clickOnLihatSemuaSekitarKampus();
    }

    @Then("Lihat semua kost sekitar kampus , there's this city :")
    public void lihatSemuaKostSekitarKampusThereSThisCity(DataTable table) {
        var cities = table.asMaps(String.class, String.class);
        for (Map<String, String> city : cities) {
            Assert.assertTrue(home.listKostDekatKampus(city.get("city " + Mamikos.ENV)), city.get("city " + Mamikos.ENV) + " is not displayed");
        }
    }

    @When("user go to lihat semua Area kost terpopuler")
    public void userGoToLihatSemuaAreaKostTerpopuler() {
        home.clickonLihatSemuaAreaKosTerpopuler();
    }
}
