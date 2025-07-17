package steps.mamikos.bangkrupux;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.admin.mamipay.bangkrupux.ListingFeaturedPO;
import utilities.PlaywrightHelpers;

import java.util.List;

public class ListingFeaturedSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    ListingFeaturedPO listingFeatured = new ListingFeaturedPO(page);

    @And("admin search by {string} and input {string} on fetaured list")
    public void admin_search_by_and_inputon_fetaured_list(String type, String text){
        listingFeatured.searchKosID(type, text);
        listingFeatured.clickSearchButton();
    }

    @Then("admin can see {string} on list")
    public void admin_can_see_on_list(String text){
        Assert.assertEquals(listingFeatured.validateSearchData(text), text);
    }

    @When("admin click {string} on listing")
    public void admin_click_on_listing(String text){
        listingFeatured.clickMarkAsFeatured(text);
    }

    @And("admin search by status {string}")
    public void admin_search_by_status(String status){
        listingFeatured.filteringByStatus(status);
        listingFeatured.clickSearchButton();
    }

    @And("featured table contains column")
    public void featured_table_contains_column(List<String> column) {
        for (int i = 0; i < column.size(); i++) {
            Assert.assertEquals(listingFeatured.getColumnName(i), column.get(i));
        }
    }
}
