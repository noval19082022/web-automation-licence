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

public class MDRAttemptsSteps {

    Page page = ActiveContext.getActivePage();
    LeadsDetailPO leadsDetail = new LeadsDetailPO(page);
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);

    @When("admin clicks on leads with saved ILB phone number")
    public void admin_clicks_on_leads_with_saved_ILB_phone_number() {
        String phoneNumber = HarvestData.getIlbPhoneNumber();
        System.out.println("Clicking on leads with phone number: " + phoneNumber);
        leadsDetail.clickLeadsRow(phoneNumber);
    }

    @And("admin clicks Assign to me button")
    public void admin_clicks_assign_to_me_button() {
        leadsDetail.clickAssignToMe();
    }

    @Then("leads should be assigned successfully")
    public void leads_should_be_assigned_successfully() {
        playwright.waitTillPageLoaded();
        playwright.hardWait(3000);
        Assert.assertTrue(leadsDetail.isOnFollowUpTab(),
                "Page did not redirect to Follow Up tab after assignment! URL: " + page.url());
    }

    @When("admin navigates back to LBT list")
    public void admin_navigates_back_to_LBT_list() {
        leadsDetail.navigateBackToLBT();
    }

    @When("admin clicks on Follow Up tab")
    public void admin_clicks_on_follow_up_tab() {
        leadsDetail.clickFollowUpTab();
    }

    @When("admin clicks on Done tab")
    public void admin_clicks_on_done_tab() {
        leadsDetail.clickDoneTab();
    }

    @When("admin clicks on leads detail with saved ILB phone number")
    public void admin_clicks_on_leads_detail_with_saved_ILB_phone_number() {
        String phoneNumber = HarvestData.getIlbPhoneNumber();
        System.out.println("Opening leads detail for phone number: " + phoneNumber);
        leadsDetail.clickLeadsDetailByPhone(phoneNumber);
    }

    @When("admin clicks on Visit tab")
    public void admin_clicks_on_visit_tab() {
        leadsDetail.clickVisitTab();
    }

    @And("admin adds new attempt with jenis {string} and response {string}")
    public void admin_adds_new_attempt_with_jenis_and_response(String jenis, String response) {
        leadsDetail.clickAddAttempt();
        leadsDetail.selectJenisFollowUp(jenis);
        leadsDetail.selectResponse(response);

        if (response.equals("Tidak Tertarik")) {
            leadsDetail.selectRejectReason("Okupansi tinggi (>67%)");
        } else if (response.equals("Tertarik")) {
            leadsDetail.selectAssignBD("Yudha");
            leadsDetail.selectJenisVisit("Online");
            leadsDetail.selectVisitDate();
        }

        leadsDetail.saveAttempt();
    }

    @Then("attempt should be saved successfully")
    public void attempt_should_be_saved_successfully() {
        playwright.waitTillPageLoaded();
        playwright.hardWait(3000);
        Assert.assertTrue(leadsDetail.isOnLBTPage(),
                "Page did not redirect to LBT list after saving attempt! URL: " + page.url());
    }

    @Then("leads response should be {string} in the table")
    public void leads_response_should_be_in_the_table(String expectedResponse) {
        String phoneNumber = HarvestData.getIlbPhoneNumber();
        String actualResponse = leadsDetail.getLeadsResponseText(phoneNumber);
        Assert.assertTrue(actualResponse.contains(expectedResponse),
                "Expected response '" + expectedResponse + "' but got '" + actualResponse + "'");
    }

    @And("leads response color should be {string}")
    public void leads_response_color_should_be(String expectedHexColor) {
        String phoneNumber = HarvestData.getIlbPhoneNumber();
        String actualColor = leadsDetail.getLeadsResponseColor(phoneNumber);
        String expectedRgb = hexToRgb(expectedHexColor);
        Assert.assertEquals(actualColor, expectedRgb,
                "Expected response color '" + expectedHexColor + "' (" + expectedRgb + ") but got '" + actualColor + "'");
    }

    @When("admin search LBT by {string} with {string}")
    public void admin_search_LBT_by_with(String searchType, String text) {
        leadsDetail.searchLBT(searchType, text);
    }

    @Then("admin validate {string} column in LBT table with {string}")
    public void admin_validate_column_in_LBT_table_with(String searchType, String expectedText) {
        String result = leadsDetail.getDataInLBTTableByColumn(searchType, expectedText);
        Assert.assertNotNull(result, "Data '" + expectedText + "' not found in LBT table column!");
        Assert.assertTrue(result.contains(expectedText),
                "Expected '" + expectedText + "' in column '" + searchType + "' but got: " + result);
    }

    @Then("admin search LBT by {string} with keyword {string} and validate result {string}")
    public void admin_search_LBT_by_with_keyword_and_validate(String searchType, String keyword, String expectedText) {
        leadsDetail.clearLBTSearch();
        leadsDetail.searchLBT(searchType, keyword);
        String result = leadsDetail.getDataInLBTTableByColumn(searchType, expectedText);
        Assert.assertNotNull(result, "Data '" + expectedText + "' not found in LBT table column!");
        Assert.assertTrue(result.contains(expectedText),
                "Expected '" + expectedText + "' in column '" + searchType + "' but got: " + result);
    }

    @When("admin clears and search LBT with {string}")
    public void admin_clears_and_search_LBT_with(String text) {
        leadsDetail.clearAndSearchLBT(text);
    }

    @When("admin clears LBT search")
    public void admin_clears_LBT_search() {
        leadsDetail.clearLBTSearch();
    }

    /**
     * Convert hex color to rgb format (e.g. "#F5A623" -> "rgb(245, 166, 35)")
     */
    private String hexToRgb(String hex) {
        hex = hex.replace("#", "");
        int r = Integer.parseInt(hex.substring(0, 2), 16);
        int g = Integer.parseInt(hex.substring(2, 4), 16);
        int b = Integer.parseInt(hex.substring(4, 6), 16);
        return "rgb(" + r + ", " + g + ", " + b + ")";
    }
}
