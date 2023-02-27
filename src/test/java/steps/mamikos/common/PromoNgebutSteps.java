package steps.mamikos.common;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.common.PromoNgebutLandingAreaPO;

public class PromoNgebutSteps {
    Page page = ActiveContext.getActivePage();
    PromoNgebutLandingAreaPO promo = new PromoNgebutLandingAreaPO(page);
    @Then("user can see flash sale landing area")
    public void userCanSeeFlashSaleLandingArea() {
        Assert.assertTrue(page.title().contains("Promo Seru Mamikos"), "Page title is not contains: Promo Seru Mamikos");
        Assert.assertTrue(promo.isPromoHeadingTextVisible(), "Promo heading text is not visible");
        Assert.assertTrue(promo.isPromoSubtitleTextVisible(), "Promo subtitle text is not visible");
        Assert.assertTrue(promo.isFilterCityTextVisible(), "City filter city is not visible");
        Assert.assertTrue(promo.isKostListVisible(), "Kost list is not visible");
        Assert.assertEquals(promo.getFilterComboBoxValue(), "all", "Default filter is not semua kota");
    }
}
