package steps.mamikos.common;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.common.HomePO;
import utilities.PlaywrightHelpers;

import java.util.List;

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
    }

    @Then("user should redirect to kebijakan privasi page")
    public void userShouldRedirectToKebijakanPrivasiPage() {
        home = new HomePO(ActiveContext.getActivePage());
        Assert.assertTrue(home.isKebijakanPrivasiTitleDisplayed(), "Kebijakan Privasi page is not present");
    }

    @And("user open syarat dan ketentuan in footer")
    public void userOpenSyaratDanKetentuanInFooter() {
        home.clickOnSyaratKetentuanButton();
    }

    @Then("user should redirect to link {string}")
    public void userShouldRedirectToLink(String link) {
        home = new HomePO(ActiveContext.getActivePage());
        Assert.assertEquals(home.getSyaratKetentuanLinkURL(), link, "Syarat dan Ketentuan Umum link is not equal");
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
        Assert.assertTrue(home.isApartmentMenuDisplayed(), "Apartment Menu Dropdown is not present");
    }
}
