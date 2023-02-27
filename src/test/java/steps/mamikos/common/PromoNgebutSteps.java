package steps.mamikos.common;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.common.promongebut.PromoNgebutLandingAreaPO;
import pageobject.common.promongebut.PromoNgebutLandingPO;

public class PromoNgebutSteps {
    Page page = ActiveContext.getActivePage();
    PromoNgebutLandingPO promo = new PromoNgebutLandingPO(page);
    PromoNgebutLandingAreaPO promoArea = new PromoNgebutLandingAreaPO(page);
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
}
