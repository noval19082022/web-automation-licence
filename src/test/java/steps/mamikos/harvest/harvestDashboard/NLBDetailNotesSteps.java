package steps.mamikos.harvest.harvestDashboard;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.harvest.harvestDashboard.LeadsDetailPO;
import testdata.HarvestData;
import utilities.PlaywrightHelpers;

public class NLBDetailNotesSteps {

    Page page = ActiveContext.getActivePage();
    LeadsDetailPO leadsDetail = new LeadsDetailPO(page);
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);

    @When("admin filter leads source {string} in LBT")
    public void admin_filter_leads_source_in_LBT(String source) {
        leadsDetail.filterLeadsSource(source);
    }

    @When("admin clicks on leads with saved NLB phone number")
    public void admin_clicks_on_leads_with_saved_NLB_phone_number() {
        String phoneNumber = HarvestData.getNlbPhoneNumber();
        System.out.println("Clicking on leads with phone number: " + phoneNumber);
        leadsDetail.clickLeadsRow(phoneNumber);
    }

    @And("admin clicks on tab {string}")
    public void admin_clicks_on_tab(String tabName) {
        leadsDetail.clickTab(tabName);
    }

    @Then("Notes should contain {string}")
    public void notes_should_contain(String expectedText) {
        String notesText = leadsDetail.getNotesText();
        Assert.assertTrue(notesText.contains(expectedText),
                "Expected Notes to contain '" + expectedText + "' but got: " + notesText);
    }
}
