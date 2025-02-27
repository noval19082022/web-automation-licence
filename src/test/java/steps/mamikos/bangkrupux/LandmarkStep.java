package steps.mamikos.bangkrupux;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
        landmark.getIdAndNameText(text);
    }
}
