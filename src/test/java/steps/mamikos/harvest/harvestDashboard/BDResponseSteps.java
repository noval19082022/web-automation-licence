package steps.mamikos.harvest.harvestDashboard;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.harvest.harvestDashboard.LeadsDetailPO;
import testdata.HarvestData;
import utilities.PlaywrightHelpers;

public class BDResponseSteps {

    Page page = ActiveContext.getActivePage();
    LeadsDetailPO leadsDetail = new LeadsDetailPO(page);
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);

    @And("admin updates BD visit status to {string}")
    public void admin_updates_BD_visit_status_to(String status) {
        leadsDetail.updateBDVisitStatus(status);
    }

    @Then("BD response should be saved successfully")
    public void bd_response_should_be_saved_successfully() {
        playwright.waitTillPageLoaded();
        playwright.hardWait(3000);
        Assert.assertTrue(leadsDetail.isOnLBTPage(),
                "Page did not redirect to LBT list after saving BD response! URL: " + page.url());
    }

    @Then("BD response should be {string} in the table")
    public void bd_response_should_be_in_the_table(String expectedResponse) {
        String phoneNumber = HarvestData.getIlbPhoneNumber();
        String actualResponse = leadsDetail.getBDResponseText(phoneNumber);
        Assert.assertTrue(actualResponse.contains(expectedResponse),
                "Expected BD response '" + expectedResponse + "' but got '" + actualResponse + "'");
    }

    @And("BD response color should be {string}")
    public void bd_response_color_should_be(String expectedHexColor) {
        String phoneNumber = HarvestData.getIlbPhoneNumber();
        String actualColor = leadsDetail.getBDResponseColor(phoneNumber);
        String expectedRgb = hexToRgb(expectedHexColor);
        Assert.assertEquals(actualColor, expectedRgb,
                "Expected BD response color '" + expectedHexColor + "' (" + expectedRgb + ") but got '" + actualColor + "'");
    }

    @And("leads status should be {string} in the table")
    public void leads_status_should_be_in_the_table(String expectedStatus) {
        String phoneNumber = HarvestData.getIlbPhoneNumber();
        String actualStatus = leadsDetail.getLeadsStatusInVisitDoneTab(phoneNumber);
        Assert.assertTrue(actualStatus.contains(expectedStatus),
                "Expected leads status '" + expectedStatus + "' but got '" + actualStatus + "'");
    }

    private String hexToRgb(String hex) {
        hex = hex.replace("#", "");
        int r = Integer.parseInt(hex.substring(0, 2), 16);
        int g = Integer.parseInt(hex.substring(2, 4), 16);
        int b = Integer.parseInt(hex.substring(4, 6), 16);
        return "rgb(" + r + ", " + g + ", " + b + ")";
    }
}
