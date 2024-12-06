package steps.mamikos.harvest.harvestDashboard;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.harvest.harvestDashboard.HarvestDashboardPO;
import utilities.PlaywrightHelpers;

public class HarvestDashboardSteps {

    Page page = ActiveContext.getActivePage();
    HarvestDashboardPO dashboard = new HarvestDashboardPO(page);
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);

    @Then("admin should redirect to All leads menu")
    public void admin_should_redirect_to_all_leads_menu() {
        Assert.assertEquals(playwright.getPageUrl(), Mamikos.URL+"/leads/harvest/all-leads");
    }

    @When("admin click sidebar menu {string}")
    public void admin_click_sidebar_menu(String menu) {
        dashboard.clickSidebarMenu(menu);
    }

    @Then("admin should redirect to harvest {string}")
    public void admin_should_redirect_to_harvest(String url) {
        Assert.assertEquals(playwright.getPageUrl(), Mamikos.URL+"/leads/harvest/"+url);
    }
}
