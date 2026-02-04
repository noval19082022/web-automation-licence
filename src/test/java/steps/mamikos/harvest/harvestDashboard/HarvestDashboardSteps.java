package steps.mamikos.harvest.harvestDashboard;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
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
        page.waitForLoadState(LoadState.LOAD);
        Assert.assertEquals(playwright.getPageUrl(), Mamikos.URL+"/leads/harvest/all-leads");
    }

    @When("owner/admin click sidebar menu {string}")
    public void admin_click_sidebar_menu(String menu) {
        dashboard.clickSidebarMenu(menu);
    }

    @Then("admin should redirect to harvest {string}")
    public void admin_should_redirect_to_harvest(String url) {
        page.waitForLoadState(LoadState.LOAD);
        Assert.assertEquals(playwright.getPageUrl(), Mamikos.URL+"/leads/harvest/"+url);
    }

    @Then("admin can view {string} button")
    public void admin_can_view_button(String buttonName) {
        page.waitForLoadState(LoadState.LOAD);
        Assert.assertTrue(dashboard.isButtonVisible(buttonName));
    }

    @Then("admin can't view {string} button")
    public void admin_can_t_view_button(String buttonName) {
        page.waitForLoadState(LoadState.LOAD);
        Assert.assertFalse(dashboard.isButtonVisible(buttonName));
    }
}
