package steps.mamikos.admin;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.admin.mamipay.bangkrupux.KostLevelPO;
import utilities.PlaywrightHelpers;

import java.util.List;

public class KostLevelSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    KostLevelPO kostLevel = new KostLevelPO(page);

    @Then("kost level column contains")
    public void kost_level_column_contains(List<String> table){
        for (String kostLevelColumn: table){
            Assert.assertEquals(kostLevel.getKostLevelColumnTable(kostLevelColumn), kostLevelColumn, "Column Name in Kost Level Table does not match!");
        }
    }

    @Then("show button add kost level")
    public void show_button_add_kost_level() {
        Assert.assertTrue(kostLevel.isButtonAddKostLevelVisible());
    }

    @Then("show field and button search kost level")
    public void show_button_search_field_and_button_kost_level() {
        Assert.assertTrue(kostLevel.isSearchFieldAndButtonLevelVisible());
    }

    @When("admin clicks on page number {string} of kost level")
    public void admin_clicks_on_page_number_of_kost_level(String pageNumber){
        kostLevel.clicksOnPageNumber(pageNumber);
    }

    @Then("system display kost level page number {string} is active")
    public void system_display_kost_level_page_number_is_active(String pageNumber){
        Assert.assertTrue(kostLevel.pageNumberButtonIsActive(pageNumber).contains("active"), "Button is not active");
    }
}