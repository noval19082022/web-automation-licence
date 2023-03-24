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
import utilities.PlaywrightHelpers;

public class LandingPageSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    HomePO home = new HomePO(page);

    @Given("user navigates to mamikos kost kost jogja murah")
    public void userNavigatesToMamikosKostKostJogjaMurah() {
        playwright = new PlaywrightHelpers(page);
        playwright.navigateTo(Mamikos.URL + Mamikos.KOST_MURAH_DIJOGJA, 30000.0, LoadState.LOAD);

    }

    @When("user activate Dikelola Mamikos filter")
    public void userActivateDikelolaMamikosFilter() throws InterruptedException {
        home.activateFilterDikelolaMamikos();
    }

    @Then("user validate the result kos have Dikelola Mamikos label")
    public void userValidateTheResultKosHaveDikelolaMamikosLabel() throws InterruptedException {
        Assert.assertTrue(home.isDikelolaMamikosDisplayed(), "is Displayed diekola mamikos");
    }

    @Then("user see Dikelola Mamikos filter is deactivate")
    public void userSeeDikelolaMamikosFilterIsDeactivate() throws InterruptedException {
        Assert.assertTrue(home.isDikelolaMamikosDisplayed(), "Dikelola Mamikos Label is not displayed");
    }

    @And("user not active filter dikelola mamikos")
    public void userNotActiveFilterDikelolaMamikos() {
        home.toggleDikelolaMamikosInActive();

    }
}
