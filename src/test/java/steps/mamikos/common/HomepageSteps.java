package steps.mamikos.common;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.common.HomePO;

public class HomepageSteps {
    Page page = ActiveContext.getActivePage();
    HomePO home = new HomePO(page);
    @Then("user see flash sale section")
    public void userSeeFlashSaleSection() {
        home.scrollToViewPromoNgebutHeading();
        Assert.assertTrue(home.promoNgebutHeadingIsVisible(), "Promo ngebut heading is not visible");
        Assert.assertEquals(home.getPromoNgebutOptionsValue(), "Semua Kota", "Default value is not Semua Kota");
        Assert.assertTrue(home.isFlashSaleTimerVisible(), "Flash Sale Timer not visible");
        Assert.assertTrue(home.isFlashSaleLihatSemuaButtonVisible(), "Flash sale lihat semua button is not visible");
        Assert.assertTrue(home.isFlashSaleKostContainerVisible(), "Flash sale kost list is not visible");
    }
}
