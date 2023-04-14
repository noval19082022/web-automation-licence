package steps.mamikos.common;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.KostDetailsPO;
import pageobject.common.promongebut.PromoNgebutLandingAreaPO;
import pageobject.common.promongebut.PromoNgebutLandingPO;

public class PromoNgebutSteps {
    Page page = ActiveContext.getActivePage();
    PromoNgebutLandingPO promo = new PromoNgebutLandingPO(page);
    PromoNgebutLandingAreaPO promoArea = new PromoNgebutLandingAreaPO(page);
    KostDetailsPO kostDetail = new KostDetailsPO(page);
    @Then("user can see flash sale landing page")
    public void userCanSeeFlashSaleLandingPage() {
        Assert.assertTrue(promo.isPromoNgebutHeadingVisible(), "Promo ngebut heading text is not visible");
        Assert.assertTrue(promo.isCountDownTimerVisible(), "Count down timer is not visible");
        Assert.assertTrue(promo.isBtnCariKostPromoVisible(), "Cari kost promo button is not visible");
        Assert.assertTrue(promo.isFlashSaleBannerVisible(), "Flash sale banner is not visible");
        Assert.assertTrue(promo.isButtonCariSekarangVisible(), "Button cari sekarang is not visible");
        Assert.assertTrue(promo.isFaqHeadingVisible(), "Flash sale heading is not visible");
    }

    @Then("user can see flash sale landing area")
    public void userCanSeeFlashSaleLandingArea() {
        Assert.assertTrue(promoArea.isPromoNgebutBannerVisible(), "Promo ngebut banner is not visible");
        Assert.assertTrue(promoArea.isFilterContainerVisible(), "Filter container is not visible");
        Assert.assertTrue(promoArea.getSubFilterInformationText().contains("Kost Promo Ngebut Bisa Anda Booking"), "Sub filter information is not visible");
        Assert.assertFalse(promoArea.getDiscountIconLocators().isEmpty(), "Promo kost list is empty");
    }

    @When("user go to promo landing area from Cari Kos Promo Ngebut button")
    public void userGoToPromoLandingAreaFrom() {
        promo.clickOnCariKosPromoNgebut();
    }

    @Then("user can see url link is for Cari Kos Promo Ngebut")
    public void userCanSeeUrlLinkIsForCariKosPromoNgebut() {
        Assert.assertEquals(page.url(), Mamikos.URL + Mamikos.KOST_PROMO_NGEBUT_TOP, "URL is not equal");
    }

    @When("user go to promo landing area from Cari Sekarang button")
    public void userGoToPromoLandingAreaFromCariSekarangButton() {
        promo.clickOnCariSekarangButton();
    }

    @Then("user can see url link is for Cari Sekarang")
    public void userCanSeeUrlLinkIsForCariSekarangButton() {
        Assert.assertEquals(page.url(), Mamikos.URL + Mamikos.KOST_PROMO_NGEBUT_BOTTOM, "URL is not equal");
    }

    @When("user go to kost details from promo ngebut list")
    public void userGoToKostDetailsFromPromoNgebutList() {
        page = promoArea.clickOnPromoIconIndex(0);
    }

    @Then("user can see promo ngebut pop-up")
    public void userCanSeePromoNgebutPopUp() {
        ActiveContext.setActivePage(ActiveContext.getActiveBrowserContext().pages().get(1));
        page = ActiveContext.getActivePage();
        kostDetail = new KostDetailsPO(page);
        kostDetail.scrollDownToUntilPromoPopUpVisible();
        Assert.assertTrue(kostDetail.isMamikosPromoNgebutButtonVisible(), "Mamikos Promo Ngebut Button Is Not Visible");
        Assert.assertTrue(kostDetail.isMauDongButtonVisible(), "Mau Dong Button Is Not Visible");
        Assert.assertTrue(kostDetail.isSayaMengertiButtonVisible(), "Saya Mengerti Button Is Not Visible");
    }
}
