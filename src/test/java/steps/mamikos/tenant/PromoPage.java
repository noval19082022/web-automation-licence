package steps.mamikos.tenant;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.tenant.PromoMamikosPO;
import utilities.PlaywrightHelpers;

import java.io.IOException;

public class PromoPage {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    PromoMamikosPO promo= new PromoMamikosPO(page);

    @When("user click next page button")
    public void userClickNextPageButton() {
        promo.clickNextPage();
    }

    @Then("next promo page will be opened")
    public void nextPromoPageWillBeOpened() {
        String pageIndex = promo.getPageIndex();
        if(pageIndex != null){
            Assert.assertEquals(pageIndex, "2", "Page index is not correct");
        }
    }

    @And("user click previous page button")
    public void userClickPreviousPageButton() {
        promo.clickPrevPage();
    }

    @Then("previous promo page will be opened")
    public void previousPromoPageWillBeOpened() {
        String pageIndex = promo.getPageIndex();
        if(pageIndex != null){
            Assert.assertEquals(pageIndex, "1", "Page index is not correct");
        }
    }

    @When("user click page index {string}")
    public void userClickPageIndex(String index){
        promo.clickPageIndex(index);
    }

    @Then("promo page {string} will be opened")
    public void promoPageWillBeOpened(String page) {
        String pageIndex = promo.getPageIndex();
        if(pageIndex != null) {
            Assert.assertEquals(pageIndex, page, "Page index is not correct");
        }
    }

    @When("user click SALIN on any promo")
    public void userClickSALINOnAnyPromo() {
        promo.clickOnFirstCopyPromo();
    }

    @Then("promo code can be copied {string}")
    public void promoCodeCanBeCopied(String promoCode) {
        if (promo.isGetClipboardText()) {
            Assert.assertEquals(promo.getClipboardText2(), promoCode, "ENAKNYANGEKOS18");
        }
    }
}
