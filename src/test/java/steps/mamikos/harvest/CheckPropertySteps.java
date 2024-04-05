package steps.mamikos.harvest;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.harvest.CheckPropertyPO;

public class CheckPropertySteps {
    Page page = ActiveContext.getActivePage();
    CheckPropertyPO checkProperty = new CheckPropertyPO(page);

    @When("admin search property in search bar {string} by Nama Properti")
    public void admin_search_property_in_search_bar_by_Nama_Properti(String keyword){
        checkProperty.searchNamaProperti(keyword);
    }

    @Then("property is displayed with name {string}")
    public void property_is_displayed_with_name(String result){
        Assert.assertEquals(checkProperty.getPropertyName(result), result, "Property Name does not Match!");
    }

    @And("the address is displayed {string}")
    public void the_address_is_displayed(String result){
        Assert.assertEquals(checkProperty.getPropertyAddress(result), result, "Property Address does not Match!");
    }

    @And("admin clear keyword in search bar")
    public void admin_clear_keyword_in_search_bar(){
        checkProperty.clearKeywordInSearchBar();
    }

    @When("admin search property in search bar {string} by Nomor HP Pemilik")
    public void admin_search_property_in_search_bar_by_Nomor_HP_Pemilik(String keyword){
        checkProperty.searchNamaProperti(keyword);
    }

    @When("admin opens property")
    public void admin_opens_property(){
        checkProperty.opensProperty();
    }

    @When("admin clicks on next image")
    public void admin_clicks_on_next_image(){
        for (int i=0; i<5; i++){
            if (checkProperty.isNextButtonDisable()){
                checkProperty.closePopUpProperty();
                break;
            } else {
                checkProperty.clicksNextButtonOnImage();
            }
        }
    }

    @Then("property title in pop up is displayed {string}")
    public void property_title_in_pop_up_is_displayed(String title){
        Assert.assertEquals(checkProperty.getPropertyTitle(title), title, "Property Title does not Match!");
    }
}