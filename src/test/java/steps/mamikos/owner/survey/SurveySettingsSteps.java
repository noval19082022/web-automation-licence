package steps.mamikos.owner.survey;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.HomePO;
import pageobject.common.LoadingPO;
import pageobject.owner.survey.SurveySettingsPO;
import utilities.PlaywrightHelpers;

public class SurveySettingsSteps {
    Page page = ActiveContext.getActivePage();
    SurveySettingsPO surveySettings = new SurveySettingsPO(page);
    HomePO home = new HomePO(page);
    LoadingPO loading = new LoadingPO(page);
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);

    @Given("user navigate to mamikos")
    public void userNavigateToMamikos() {
        playwright.navigateTo(Mamikos.URL);
        playwright.waitTillPageLoaded();
    }


    @And("user click on chat menu")
    public void userClickOnChatMenu() {
        playwright.waitTillPageLoaded();
        page.getByText("Chat").nth(0).click();
        playwright.hardWait(2000);
    }

    @And("user select filter survey")
    public void userSelectFilterSurvey() {
        surveySettings.clickSurveyFilter();
    }

    @Then("Kos Survey Settings page is displayed")
    public void kosSurveySettingsPageIsDisplayed() {
        Assert.assertTrue(surveySettings.isSurveySettingsPageDisplayed(),
            "Kos Survey Settings page is not displayed");
    }

    @Then("same-day survey toggle is displayed inactive off")
    public void sameDaySurveyToggleIsDisplayedInactive() {
        playwright.hardWait(2000);
        Assert.assertTrue(surveySettings.ensureSameDaySurveyToggleOff(),
            "Same-day survey toggle is not inactive (should be off)");
    }

    @Then("same-day survey toggle is displayed inactive on")
    public void sameDaySurveyToggleIsDisplayedActive() {
        playwright.hardWait(2000);
        Assert.assertTrue(surveySettings.isSameDaySurveyToggleActive(),
                "Same-day survey toggle is not inactive (should be on)");
    }

    @And("Copy Text {string} displayed")
    public void copyTextDisplayed(String text) {
        playwright.hardWait(1000);
        Assert.assertTrue(surveySettings.isCopyTextDisplayed(text),
                "Copy text '" + text + "' is not displayed");
    }

    @And("user clicks link {string}")
    public void userClicksLink(String linkText) {
        playwright.hardWait(1000);
        surveySettings.clickLink(linkText);
    }

    @And("pop up onboarding survey appears")
    public void popUpOnboardingSurveyAppears() {
        playwright.hardWait(1000);
        Assert.assertTrue(surveySettings.isOnboardingSurveyPopupDisplayed(),
                "Onboarding survey popup is displayed");
    }

    @And("user click on same day survey toggle")
    public void userClickOnSameDaySurveyToggle() {
        surveySettings.clickSameDaySurveyToggle();
    }

    @Then("activation confirmation pop-up appears")
    public void activationConfirmationPopUpAppears() {
        playwright.hardWait(1000);
        Assert.assertTrue(surveySettings.isOnboardingSurveyPopupDisplayed(),
                "Activation confirmation pop-up is not displayed");
    }

    @Then("user see popup same-day survey access")
    public void userSeePopupSameDaySurveyAccess() {
        playwright.hardWait(1000);
        Assert.assertTrue(surveySettings.isOnboardingSurveyPopupDisplayed(),
                "Popup same-day survey access is not displayed");
    }

    @Given("user has activated the same-day survey toggle")
    public void userHasActivatedTheSameDaySurveyToggle() {
        playwright.hardWait(2000);
        Assert.assertTrue(surveySettings.ensureSameDaySurveyToggleOn(),
                "Failed to activate same-day survey toggle");
    }

    @When("user exit from kost Survey Settings page")
    public void userExitFromKostSurveySettingsPage() {
        surveySettings.exitSurveySettingsPage();
    }
}