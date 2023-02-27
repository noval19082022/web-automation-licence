package steps.mamikos.common;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.common.PromoNgebutLandingAreaPO;

public class PromoNgebutSteps {
    Page page = ActiveContext.getActivePage();
    PromoNgebutLandingAreaPO promo = new PromoNgebutLandingAreaPO(page);
    @Then("user can see flash sale landing area")
    public void userCanSeeFlashSaleLandingArea() {
        Assert.assertTrue(promo.isFaqHeadingVisible(), "Promo ngebut heading text is not visible");
        Assert.assertTrue(promo.isCountDownTimerVisible(), "Count down timer is not visible");
        Assert.assertTrue(promo.isBtnCariKostPromoVisible(), "Cari kost promo button is not visible");
        Assert.assertTrue(promo.isFlashSaleBannerVisible(), "Flash sale banner is not visible");
        Assert.assertTrue(promo.isButtonCariSekarangVisible(), "Button cari sekarang is not visible");
        Assert.assertTrue(promo.isFaqHeadingVisible(), "Flash sale heading is not visible");
    }
}
