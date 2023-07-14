package steps.mamikos.tenant.profile;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.tenant.profile.PoinSayaPO;
import utilities.PlaywrightHelpers;


public class PoinSayaSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    PoinSayaPO poinSaya = new PoinSayaPO(page);

    @Then("user verify title in the dapatkan poin page is displayed")
    public void userVerifyTitleInTheDapatkanPoinPageIsDisplayed() {
        Assert.assertTrue(poinSaya.isTitleInTheDapatkanPoinPageDisplayed());
    }

    @And("user verify tab petunjuk in the dapatkan poin page is displayed")
    public void userVerifyTabPetunjukInTheDapatkanPoinPageIsDisplayed() {
        Assert.assertTrue(poinSaya.isTabPetunjukInTheDapatkanPoinPageDisplayed());
    }

    @And("user verify tab syarat dan ketentuan in the dapatkan poin page is displayed")
    public void userVerifyTabSyaratDanKetentuanInTheDapatkanPoinPageIsDisplayed() {
        Assert.assertTrue(poinSaya.isTabSyaratDanKetentuanInTheDapatkanPoinPageDisplayed());
    }

    @And("user verify link pusat bantuan in the dapatkan poin page is displayed")
    public void userVerifyLinkPusatBantuanInTheDapatkanPoinPageIsDisplayed() {
        Assert.assertTrue(poinSaya.isLinkPusatBantuanInTheDapatkanPoinPageDisplayed());
    }

    @And("user verify dapatkan poin headline {string}")
    public void user_verify_dapatkan_poin_headline(String headline) {
        Assert.assertEquals(poinSaya.getDapatkanPointHeadline(), headline, "Headline text is not equal to " + headline);
    }

    @Then("user verify dapatkan poin subtitle {string}")
    public void user_verify_dapatkan_poin_subtitle(String subtitle) {
        Assert.assertEquals(poinSaya.getDapatkanPoinSubtitle(), subtitle, "Subtitle text is not equal to " + subtitle);
    }

    @Then("user verify content on dapatkan poin page")
    public void user_verify_content_on_dapatkan_poin_page() {
        Assert.assertTrue(poinSaya.isFooterOnDapatkanPoinAppear(), "Footer on dapatkan poin page is not appeared");
    }

    @And("user verify only the header that is sticky or {string}")
    public void user_verify_only_the_header_that_is_sticky_or_(String attrib) {
        Assert.assertEquals(poinSaya.getHeaderElementAttribute().substring(16,21), attrib, "the header is not sticky");
    }

    @And("user click on tab Syarat dan Ketentuan")
    public void user_click_on_tab_() {
        poinSaya.clickOnSyaratDanKetentuanTab();
    }

    @Then("user verify {string} has {string} attribute")
    public void user_verify_input_has_input_attribute(String text, String attrib) {
        Assert.assertEquals(poinSaya.getSyaratDanKetentuanTabText(), text, "Tab content is not equal to " + text);
        Assert.assertEquals(poinSaya.getSyaratDanKetentuanAttribute().substring(18,24), attrib, "Syarat dan Ketentuan doesn't have " + attrib + " attribute");
    }

    @When("user clicks link on pusat bantuan")
    public void user_clicks_link_on_pusat_bantuan() {
        poinSaya.clickLinkOnPusatBantuan();
    }

    @Then("user verify mamipoin tenant entry point is not displayed")
    public void userVerifyMamipoinTenantEntryPointIsNotDisplayed() {
        Assert.assertFalse(poinSaya.isMamipoinTenantEntryPointNotDisplayed());
    }

    @And("user verify the amount of poin owned by the tenant is {string}")
    public void userVerifyTheAmountOfPoinOwnedByTheTenantIs(String mamipoinTenant) {
        Assert.assertEquals(poinSaya.verifyAmountOfPoinOwnedByTenant(mamipoinTenant), mamipoinTenant, "Amount of poin text not equals!");
    }

    @And("user clicks on mamipoin tenant entry point button")
    public void userClicksOnMamipoinTenantEntryPointButton() {
        poinSaya.clickOnEntryPointTenantMamipoin();
    }

    @Then("user verify title in the mamipoin tenant landing page is displayed")
    public void userVerifyTitleInTheMamipoinTenantLandingPageIsDisplayed() {
        Assert.assertTrue(poinSaya.isTitleInTheMamipoinTenantLandingPageDisplayed());
    }

    @And("user verify informasi poin button is displayed")
    public void userVerifyInformasiPoinButtonIsDisplayed() {
        Assert.assertTrue(poinSaya.isInformasiPoinButtonDisplayed());
    }

    @And("user verify riwayat poin button is displayed")
    public void userVerifyRiwayatPoinButtonIsDisplayed() {
        Assert.assertTrue(poinSaya.isRiwayatPoinButtonDisplayed());
    }

    @And("user verify dapatkan poin button is displayed")
    public void userVerifyDapatkanPoinButtonIsDisplayed() {
        Assert.assertTrue(poinSaya.isDapatkanPoinButtonDisplayed());
    }

    @And("user verify expired point information on mamipoin landing page {string}")
    public void userVerifyExpiredPointInformationOnMamipoinLandingPage(String expPoinInfo) {
        Assert.assertEquals(poinSaya.getTextExpiredPointInfoOnLandingPage(), expPoinInfo, "Expired information point not equal to " + expPoinInfo);
    }

    @Then("user will see display MamiPoin with text {string}")
    public void displayMamiPoinWithText(String textMamipoin) {
        Assert.assertEquals(poinSaya.getTextNoHaveMamipoin(), textMamipoin, "Text is not equal to " +textMamipoin);
    }
}
