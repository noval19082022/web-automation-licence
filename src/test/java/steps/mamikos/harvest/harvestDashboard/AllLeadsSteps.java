package steps.mamikos.harvest.harvestDashboard;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.harvest.harvestDashboard.AllLeadsPO;
import pageobject.harvest.harvestDashboard.LoginHarvestDashboardPO;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

import java.util.List;

public class AllLeadsSteps {

    Page page = ActiveContext.getActivePage();
    AllLeadsPO allLeads = new AllLeadsPO(page);
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    LoginHarvestDashboardPO loginHarvestDashboard = new LoginHarvestDashboardPO(page);

    private String harvestDashboard = "src/test/resources/testdata/harvest/harvestDashboard.properties";
    private String titleConfirmationBatalkanPopUp = JavaHelpers.getPropertyValue(harvestDashboard, "titleConfirmationBatalkanPopUp");
    private String subtitleConfirmationBatalkanPopUp = JavaHelpers.getPropertyValue(harvestDashboard, "subtitleConfirmationBatalkanPopUp");
    private String titleConfirmationPerubahanBelumTersimpanPopUp = JavaHelpers.getPropertyValue(harvestDashboard, "titleConfirmationPerubahanBelumTersimpanPopUp");
    private String subtitleConfirmationPerubahanBelumTersimpanPopUp = JavaHelpers.getPropertyValue(harvestDashboard, "subtitleConfirmationPerubahanBelumTersimpanPopUp");

    //--- Edit Table ---//
    @When("admin clicks on Edit Table button")
    public void admin_clicks_on_Edit_Table_button(){
        allLeads.clicksEditTableButton();
    }

    @Then("Yes and No buttons in every row are displayed")
    public void Yes_and_No_buttons_in_every_row_are_displayed(){
        int totalAllButtons = allLeads.totalAllYesButton();

        for (int i=0; i<totalAllButtons; i++){
            Assert.assertEquals(allLeads.yesButton(i), "Yes", "Yes buttons are not visible!");
            System.out.println("row Yes button ke-" + i + " = " + allLeads.yesButton(i));

            Assert.assertEquals(allLeads.noButton(i), "No", "No buttons are not visible!");
            System.out.println("row No button ke-" + i + " = " + allLeads.noButton(i));
        }
    }

    @When("admin selects {string} on radio button")
    public void admin_selects_on_radio_button(String button){
        if (button.equalsIgnoreCase("Yes")){
            allLeads.selectsYesRadioButton();
        } else if (button.equalsIgnoreCase("No")) {
            allLeads.selectsNoRadioButton();
        } else {
            System.out.println("There is no such a button like that!");
        }
    }
    //--- End of Edit Table ---//

    //--- Filter ---//
    @When("admin filter ILB only")
    public void admin_filter_ILB_only(){
        allLeads.clicksFilter();
        allLeads.clicksOnCheckBoxILB();
        allLeads.clicksOnCheckBoxAgentOffline();
        allLeads.clicksOnCheckBoxScrapping();
        allLeads.clicksOnCheckBoxAreaNonP1();
        allLeads.clicksOnCheckBoxAllArea();
        allLeads.selectsRoomsZeroToFive();
        allLeads.clicksTerapkan();
    }

    @When("admin clicks Filter in Harvest Dashboard")
    public void admin_clicks_Filter_in_Harvest_Dashboard(){
        allLeads.clicksFilter();
    }

    @And("admin selects {string} and {string} from dropdown")
    public void admin_selects_and_from_dropdown(String text, String kabupaten){
        allLeads.inputKota(text, kabupaten);
    }

    @And("admin click on terapkan button")
    public void admin_click_on_terapkan_button(){
        allLeads.clicksTerapkan();
    }

    @Then("admin validate kota name with {string}")
    public void admin_validate_kota_name_with(String text) {
        Assert.assertEquals(allLeads.getKotaName(text), text);
    }

    @When("admin filter Leads Curation {string}")
    public void admin_filter_leads_curation(String value) {
        allLeads.clicksFilter();
        allLeads.selectsLeadsCuration(value);
        allLeads.clicksTerapkan();
    }

    @Then("system only show {string} leads")
    public void system_only_show_leads(String value) {
        if (value.equalsIgnoreCase("uncurated")){
            value = "";
        }

        for (int i=0; i<allLeads.rowCount(); i++){
            Assert.assertEquals(allLeads.getLeadsCurationStatus(i), value);
        }
    }
    @When("admin resets filter in Harvest Dashboard")
    public void admin_resets_filter_in_Harvest_Dashboard(){
        allLeads.clearSearchField();
        allLeads.clicksFilter();
        allLeads.clicksResetFilter();
        allLeads.clicksSearchButton();
    }
    //--- End of Filter ---//

    //--- Batalkan Edit ---//
    @When("admin clicks on Batalkan Edit button")
    public void admin_clicks_on_Batalkan_Edit_button(){
        allLeads.clicksBatalkanEdit();
    }

    @Then("all Yes and No buttons in every row are dismiss")
    public void all_Yes_and_No_buttons_in_every_row_are_dismiss(){
        int totalAllButtons = allLeads.totalAllYesButton();

        for (int i=0; i<totalAllButtons; i++){
            Assert.assertFalse(allLeads.isYesButtonsVisible(i), "Yes buttons are still visible!");
            System.out.println("row Yes button ke-" + i + " = " + allLeads.isYesButtonsVisible(i));

            Assert.assertFalse(allLeads.isNoButtonsVisible(i), "No buttons are still visible!");
            System.out.println("row No button ke-" + i + " = " + allLeads.isNoButtonsVisible(i));
        }
    }
    //--- End of Batalkan Edit ---//

    //--- Confirmation Pop Up ---//
    @Then("confirmation pop up {string} is displayed")
    public void confirmation_pop_up_is_displayed(String popUp){
        if (popUp.equalsIgnoreCase("Batalkan")){
            Assert.assertEquals(allLeads.titleConfirmationBatalkanPopUp(), titleConfirmationBatalkanPopUp, "Title in Confirmation Batalkan Pop Up does not Match!");
            Assert.assertEquals(allLeads.subtitleConfirmationBatalkanPopUp(), subtitleConfirmationBatalkanPopUp, "Subtitle in Confirmation Pop Up Batalkan does not Match!");
            allLeads.clicksYaBatalkanButton();
        } else if (popUp.equalsIgnoreCase("Perubahan Belum Tersimpan")) {
            Assert.assertEquals(allLeads.titleConfirmationPerubahanBelumTersimpanPopUp(), titleConfirmationPerubahanBelumTersimpanPopUp, "Title in Confirmation Perubahan Tersimpan Belum Tersimpan Pop Up does not Match!");
            Assert.assertEquals(allLeads.subtitleConfirmationPerubahanBelumTersimpanPopUp(), subtitleConfirmationPerubahanBelumTersimpanPopUp, "Subtitle in Confirmation Perubahan Tersimpan Belum Tersimpan Pop Up does not Match!");
            allLeads.clicksCloseButton();
        } else {
            System.out.println("There is no such a confirmation pop up like that!");
        }
    }

    @When("admin clicks {string} button on confirmation Batalkan pop up")
    public void admin_clicks_button_on_confirmation_batalkan_pop_up(String button){
        if (button.equalsIgnoreCase("Close")){
            allLeads.clicksCloseButton();
        } else if (button.equalsIgnoreCase("Tidak")) {
            allLeads.clicksTidakButton();
        } else if (button.equalsIgnoreCase("Ya, Batalkan")) {
            allLeads.clicksYaBatalkanButton();
        } else {
            System.out.println("There is no such a button like that!");
        }
    }

    @Then("the confirmation {string} pop up is dismissed")
    public void the_confirmation_pop_up_is_dismissed(String popUp){
        if (popUp.equalsIgnoreCase("Batalkan")){
            Assert.assertFalse(allLeads.isConfirmationBatalkanPopUpVisible(), "The Confirmation Batalkan Pop Up Still Visible!");
        }
    }
    //--- Confirmation Pop Up ---//

    //--- Pagination ---//
    @When("admin clicks on next page {string}")
    public void admin_clicks_on_next_page(String page){
        allLeads.clicksOnPage(page);
    }

    @When("admin clicks on search button in Harvest Dashboard")
    public void admin_clicks_on_search_button_in_harvest_dashboard(){
        allLeads.clicksSearchButton();
    }
    //--- End of Pagination ---//

    @Then("admin should redirect to Harvest Dashboard")
    public void admin_should_redirect_to_harvest_dashboard() {
        Assert.assertTrue(allLeads.isAllLeadsTableVisible());
        Assert.assertEquals(playwright.getPageUrl(), Mamikos.URL+"/leads/harvest/all-leads");
        Assert.assertEquals(allLeads.getProfileName(),"Automation Pman");
        Assert.assertEquals(playwright.getPageTitle(),"Mamikos Harvest");
    }

    @Then("admin should redirect to Harvest Dashboard as admin")
    public void admin_should_redirect_to_harvest_dashboard_as_admin() {
        Assert.assertTrue(allLeads.isAllLeadsTableVisible());
        Assert.assertEquals(playwright.getPageUrl(), Mamikos.URL+"/leads/harvest/all-leads");
        Assert.assertEquals(allLeads.getProfileName(),"PMAN Admin");
        Assert.assertEquals(playwright.getPageTitle(),"Mamikos Harvest");
    }

    @Then("admin stay in login harvest page")
    public void admin_stay_in_login_harvest_page() {
        Assert.assertEquals(playwright.getPageUrl(),Mamikos.URL+"/leads/harvest/auth");
    }
    @Then("show login harvest error message {string}")
    public void show_login_harvest_error_message(String errorMessage) {
        Assert.assertEquals(loginHarvestDashboard.getLoginHarvestErrorMessage(),errorMessage);
    }
    @Then("login button is disabled")
    public void login_button_is_disabled() {
        Assert.assertFalse(loginHarvestDashboard.isLoginButtonEnable());
    }
    @When("admin logout harvest")
    public void admin_logout_harvest() {
        allLeads.logoutHarvest();
    }
    @Then("admin redirect to login harvest page")
    public void admin_redirect_to_login_harvest_page() {
        Assert.assertEquals(playwright.getPageUrl(),Mamikos.URL+"/leads/harvest/auth");
    }
    @Then("all leads table contains column")
    public void all_leads_table_contains_column(List<String> column) {
        for (int i = 0; i < column.size(); i++) {
            Assert.assertEquals(allLeads.getColumnName(i), column.get(i));
        }
    }

    @When("admin search by {string} with {string}")
    public void admin_search_by_with(String searchTypeLeads, String text) {
        allLeads.searchTypeLeads(searchTypeLeads, text);
    }

    @Then("admin validate data in table with {string}")
    public void admin_validate_data_in_table_with(String text) {
        allLeads.getDataInTable(text);
    }

    @When("admin mark leads submit to LBT as {string}")
    public void admin_mark_leads_submit_to_LBT_as(String value) {
        allLeads.clickManageLeads();
        allLeads.selectsSubmitToLBT(value);
        allLeads.clicksSubmitToLBT();
        allLeads.confirmSubmitToLBT();
        allLeads.clicksBatalkanEdit();
    }
    @Then("leads should be have label in Leads Status {string}")
    public void leads_should_be_have_label_in_leads_status(String label) {
        playwright.waitTillPageLoaded();
        Assert.assertEquals(allLeads.getLeadsCurationStatus(0), label);
    }
}
