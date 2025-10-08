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

//    @Then("tenant should see tier message {string}")
//    public void tenantShouldSeeTierMessage(String expectedMessage) {
//        String actualMessage = singgahsiniPlus.getTierMessageText();
//        Assert.assertTrue(actualMessage.contains(expectedMessage),
//            "Expected tier message not found. Actual: " + actualMessage);
//    }
}