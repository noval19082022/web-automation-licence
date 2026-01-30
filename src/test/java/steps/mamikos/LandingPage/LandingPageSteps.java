package steps.mamikos.LandingPage;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.HomePO;
import pageobject.common.KostLandingAreaPO;
import utilities.PlaywrightHelpers;

public class LandingPageSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    HomePO home = new HomePO(page);
    KostLandingAreaPO landing = new KostLandingAreaPO(page);

    @Given("user navigates to mamikos kost kost jogja murah")
    public void userNavigatesToMamikosKostKostJogjaMurah() {
        playwright = new PlaywrightHelpers(page);
        page.setViewportSize(1920, 1080);
        playwright.navigateTo(Mamikos.URL + Mamikos.KOST_MURAH_DIJOGJA, 30000.0, LoadState.LOAD);

    }

    @When("user activate Dikelola Mamikos filter")
    public void userActivateDikelolaMamikosFilter() throws InterruptedException {
        landing.activateFilterDikelolaMamikos();
    }

    @Then("user validate the result kos have Dikelola Mamikos label")
    public void userValidateTheResultKosHaveDikelolaMamikosLabel() throws InterruptedException {
        Assert.assertTrue(landing.isDikelolaMamikosDisplayed(), "is Displayed diekola mamikos");
    }

    @Then("user see Dikelola Mamikos filter is deactivate")
    public void userSeeDikelolaMamikosFilterIsDeactivate() throws InterruptedException {
        Assert.assertTrue(landing.isDikelolaMamikosDisplayed(), "Dikelola Mamikos Label is not displayed");
    }

    @When("user is on the LandingPage EnaknyaNgekos")
    public void userIsOnTheLandingPageEnaknyaNgekos() {
        Assert.assertTrue(playwright.getActivePageTitle().contains("enaknyangekos"));
    }

    @And("user want to play the video on LandingPage EnaknyaNgekos")
    public void userWantToPlayTheVideoOnLandingPageEnaknyaNgekos() {
        landing.openVideoThumbnail();
    }

    @Then("user see pop up video player is shown on EnaknyaNgekos LP and can play video it")
    public void userSeePopUpVideoPlayerIsShownOnEnaknyaNgekosLPAndCanPlayVideoIt() {
        landing.playVideoOnEnaknyaNgekosPage();
    }


    @And("user click on Google play on the footer")
    public void userClickOnGooglePlayOnTheFooter() {
        home.clickOnGooglePlayFooterLink();
    }

    @Then("user verify see button Mulai Cari Kos when scroll into Kenapa #EnaknyaNgekos")
    public void userVerifySeeButtonMulaiCariKosWhenScrollIntoKenapaEnaknyaNgekos() {
        landing.scroolIntoSectionKenapaEnaknyaNgekos();
        landing.mulaiCariKostBtnIsDisplayed();
    }

    @And("user/tenant/admin open gender filter on landing")
    public void adminOpenGenderFilterOnLanding() {
        landing.clickOnGenderFilter();
    }

    @And("user clicks on Fitur Unggulan on the header on enaknyangekos page")
    public void userClicksOnFiturUnggulanOnTheHeaderOnEnaknyangekosPage() {
        landing.clickOnFiturUnggulan();
    }

    @And("user clicks on Product dan layanan on the header on enaknyangekos page")
    public void userClicksOnProductDanLayananOnTheHeaderOnEnaknyangekosPage() {
        landing.clickOnProductDanLayanan();
    }

    @And("user clicks on Mulai Cari Kos Button on enaknyangekos page")
    public void userClicksOnMulaiCariKosButtonOnEnaknyangekosPage() {
        landing.cickOnMulaiCariKosBtn();
    }

    @When("page pause for inspection")
    public void pagePauseForInspection() {
        page.pause();
    }
}
