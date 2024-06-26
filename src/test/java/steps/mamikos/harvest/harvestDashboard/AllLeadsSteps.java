package steps.mamikos.harvest.harvestDashboard;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.harvest.harvestDashboard.AllLeadsPO;
import utilities.JavaHelpers;

public class AllLeadsSteps {

    Page page = ActiveContext.getActivePage();
    AllLeadsPO allLeads = new AllLeadsPO(page);

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
    //--- End of Pagination ---//
}
