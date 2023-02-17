package steps.mamikos.tenant;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.KostDetailsPO;
import pageobject.common.SearchPO;

public class KostDetailSteps {
    Page page = ActiveContext.getActivePage();

    SearchPO search = new SearchPO(page);
    KostDetailsPO kostDetail = new KostDetailsPO(page);

    @When("user search property by name {string} and select the matching result to go to kos details page")
    public void userSearchAndSelectKost(String kostName) {
        search.searchKostFromHomePage(kostName);
    }

    @Then("user can see overview section on detail page")
    public void userCanSeeOverViewSection() {
        Assert.assertTrue(kostDetail.getKostTitle().contains("Kos Dom Automation PLM"));
    }
}
