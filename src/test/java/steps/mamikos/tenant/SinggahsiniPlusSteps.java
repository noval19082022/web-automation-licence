package steps.mamikos.tenant;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.tenant.profile.SinggahsiniPlusPO;
import utilities.PlaywrightHelpers;

public class SinggahsiniPlusSteps {
    Page page = ActiveContext.getActivePage();
    SinggahsiniPlusPO singgahsiniPlus = new SinggahsiniPlusPO(page);;

    @Then("tenant can see {string} label")
    public void tenantCanSeeLabel(String text){
        if(text.equalsIgnoreCase("Baru")){
            singgahsiniPlus.getNewlabelText(text);
        } else if (text.equalsIgnoreCase(text)) {
            singgahsiniPlus.getLabelActiveTierText(text);
        }
    }

    @Then("tenant should see tier message in Singgahsini plus with {string}")
    public void tenantShouldSeeTierMessageInSinggahsiniPlus(String expectedText) {
        Assert.assertTrue(singgahsiniPlus.isTierMessageVisible(), "Tier message is not visible. Expected text: " + expectedText);
    }

    @When("tenant clicks on Singgahsini text")
    public void tenantClicksOnSinggahsiniPText() {
        singgahsiniPlus.clickSinggahsiniPlusText();
    }

    @Then("tenant can see tier message description on singgahsini page is visible")
    public void tenantCanSeeTierMessageDescriptionOnSinggahsiniPageIsVisible(){
        Assert.assertTrue(singgahsiniPlus.isTierDescriptionVisible(), "introduction new singgahsini plus not visible");
    }

    @Then("tenant can see paused allert with {string}")
    public void tenantCanSeePausedAllert(String text){
        Assert.assertTrue(singgahsiniPlus.isAllertPausedVisible(text), "allert is not visisble");
    }

    @Then("tenant can see tier active with {string}")
    public void tenantCanSeeTierActive(String text){
        Assert.assertTrue(singgahsiniPlus.isTierActiveVisible(text), "tier active is not visible");
    }

    @And("tenant clicks on Reward & Poin in Singgahsini Plus card")
    public void tenantClicksOnRewardPoinInSinggahsiniPlusCard() {
        singgahsiniPlus.clickRewardPoin();
    }

    @And("tenant clicks on MamiPoin in Singgahsini Plus card")
    public void tenantClicksOnMamiPoinInSinggahsiniPlusCard() {
        singgahsiniPlus.clickMamiPoin();
    }

    @Then("tenant should see Singgahsini Plus summary card")
    public void tenantShouldSeeSinggahsiniPlusSummaryCard() {
        Assert.assertTrue(singgahsiniPlus.isSinggahsiniPlusSummaryCardVisible(), "Singgahsini is not visible");
    }

    @Then("tenant should see Reward & Poin option")
    public void tenantShouldSeeRewardPoinOption() {
        Assert.assertTrue(singgahsiniPlus.isRewardPoinTextVisible(),
            "Reward & Poin option is not visible");
    }

    @Then("tenant should see MamiPoin option")
    public void tenantShouldSeeMamiPoinOption() {
        Assert.assertTrue(singgahsiniPlus.isMamiPoinTextVisible(),
            "MamiPoin option is not visible");
    }

    @When("tenant clicks on Singgahsini Plus Level Starter text")
    public void tenantClicksOnSinggahsiniPlusLevelStarterText() {
        singgahsiniPlus.clickStarterLevelText();
    }

    @When("tenant clicks on MamiPoin link")
    public void tenantClicksOnMamiPoinLink() {
        singgahsiniPlus.clickMamiPoinLink();
    }

    @When("tenant clicks on MamiPoin link in Singgahsini Plus card")
    public void tenantClicksOnMamiPoinLinkInSinggahsiniPlusCard() {
        singgahsiniPlus.clickMamiPoinLink();
    }

    @When("tenant clicks on mamipoin card tier bar title")
    public void tenantClicksOnMamipoinCardTierBarTitle() {
        singgahsiniPlus.clickMamipoinCardTierBarTitle();
    }

    @Then("tenant should see mamipoin card tier bar title")
    public void tenantShouldSeeMamipoinCardTierBarTitle() {
        Assert.assertTrue(singgahsiniPlus.isMamipoinCardTierBarTitleVisible(),
            "Mamipoin card tier bar title is not visible");
    }

    @Then("tenant should see tier description text with {string}")
    public void tenantShouldSeeTierDescriptionText(String text) {
        Assert.assertTrue(singgahsiniPlus.isTierDescriptionTextVisible(text),
            "Tier description text is not visible");
    }

    @Then("tenant can see mamipoin menu with {string}")
    public void tenantCanSeeMamipoinMenuWith(String text){
        Assert.assertTrue(singgahsiniPlus.isMamipoinMenutextVisible(text), "mamipoin menu is not visible");
    }

    @Then("tenant can not see Singgahsini Plus summary card")
    public void tenantCanNotSeeSinggahsiniPlusSummarycard(){
        Assert.assertFalse(singgahsiniPlus.isMamipoinCardTierBarTitleVisible(), "singgahsini plus summary card is visible");
    }

    @Then("tenant can see locked tier")
    public void tenantCanSeeLockedTier(){
        Assert.assertTrue(singgahsiniPlus.isLockedTierVisible(), "locked tier is not visible");
    }

    @Then("tenant can see {string} in singgahsini plus card")
    public void tenantCanSeeTextInSinggahsiniPlusCard(String text){
        Assert.assertTrue(singgahsiniPlus.isSinggahsiniPlusCardTextVisible(text), text + " is not visible in singgahsini plus card");
    }

    @And("tenant clicks on singgahsini card on kost saya")
    public void tenantClicksOnSinggahsiniCardOnKostSaya(){
        singgahsiniPlus.clickSinggahsiniCardKostSaya();
    }

    @Then("tenant can see singgahsini level on invoice")
    public void tenantCanSeeSinggahsiniLevelOnInvoice(){
        Assert.assertTrue(singgahsiniPlus.isInvoiceSSLevel(), "singgahsini level is not visible on invoice");
    }

    @Then("tenant can see tier passed")
    public void tenantCanSeeTierPassedWith(){
        Assert.assertTrue(singgahsiniPlus.isPassedTierVisible(), "singgahsini not appears passed tier");
    }

    @Then("tenant can see tier passed description {string}")
    public void tenantCanSeeTierPassedDescription(String text){
        singgahsiniPlus.passedDescriptionTextVisible(text);
    }

}