package steps.mamikos.bangkrupux;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.admin.mamipay.bangkrupux.LandmarkPO;
import utilities.PlaywrightHelpers;

public class LandmarkStep {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    LandmarkPO landmark = new LandmarkPO(page);


    @And("admin can see main menu with {string}")
    public void admin_can_see_main_menu_with(String text){
        landmark.isLandmarkMainMenuVisible(text);
    }

    @When("admin choose search by {string}")
    public void admin_choose_search_id(String text){
        landmark.clickSearchType(text);
    }

    @When("admin choose filter catogory by {string}")
    public void admin_choose_filter_category_by(String text){
        landmark.filterCatrgory(text);
    }

    @When("admin choose filter show in srp with {string}")
    public void admin_choose_filter_show_srp_with(String text){
        landmark.filterShowSrp(text);
    }

    @And("admin input search with {string}")
    public void admin_input_name_search(String text){
        landmark.inputSearchDataText(text);
    }

    @And("admin click search button")
    public void admin_click_search_button(){
        landmark.clickSearchButton();
    }

    @Then("admin can see data with name {string}")
    public void admin_can_see_data_with_name(String text){
        Assert.assertTrue(landmark.getIdAndNameText(text), "not appears id or name");
    }

    @Then("admin can see category with name {string}")
    public void admin_can_see_category_with_name(String name){
        Assert.assertTrue(landmark.getCategory(name),  "not appears category");
    }

    @Then("admin can see show in srp with {string}")
    public void admin_can_see_show_in_srp_with(String text){
        Assert.assertTrue(landmark.getShowSrp(text), "not appears show srp");
    }

    @And("admin click on remapping button")
    public void admin_click_on_remapping_button(){
        landmark.clickRemappingButton();
    }

    @Then("admin can see success alert remapping")
    public void admin_can_see_success_alert_remapping(){
        Assert.assertTrue(landmark.getSuccessAlertRemapping(), "not appears success alert remapping");
    }

    @And("admin clicks on edit button")
    public void admin_clicks_on_edit_button(){
        landmark.clickEditButton();
    }

    @Then("admin can see edit page")
    public void admin_can_see_edit_page(){
        Assert.assertTrue(landmark.getEditPageText(), "not appears edit page");
    }

    @And("admin update score with {string}")
    public void admin_update_score_with(String score){
        landmark.updateScore(score);
    }

}
