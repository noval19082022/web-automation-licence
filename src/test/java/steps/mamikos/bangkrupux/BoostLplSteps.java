package steps.mamikos.bangkrupux;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.admin.mamipay.bangkrupux.BoostLplPO;
import utilities.PlaywrightHelpers;



public class BoostLplSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    BoostLplPO boostLpl = new BoostLplPO(page);

    @Then("admin can see data kost already boosted with list view")
    public void admin_can_see_data_kost_already_boosted_with_list_view() {
        Assert.assertTrue(boostLpl.isHeaderLPLAppear(),"header lpl not appear");
        Assert.assertTrue(boostLpl.isTableLPLisAppear(), "table lpl not appear");
        Assert.assertTrue(boostLpl.isColoumnLPLisAppear(), "coloumn lpl not appear");
    }

    @When("admin wants to search kost with kost id {string}")
    public void admin_wants_to_search_kost_with_kost_id(String kosID) {
       boostLpl.searchKosNameLPL(kosID);
    }
    @Then("admin succsess see result search")
    public void admin_succsess_see_result_search() {
      Assert.assertEquals(boostLpl.getKostId(),boostLpl.getKostId(),"result not equals");
      boostLpl.clearTextKosId();

    }
    @Then("admin see information not found")
    public void admin_see_information_not_found() {
        Assert.assertFalse(boostLpl.isResultKosNameisAppear(), "kost name is appear");
        boostLpl.clearTextKosId();
    }

    @Then("admin wants to search kost with kost name {string}")
    public void admin_wants_to_search_kost_with_kost_name(String kosName) {
      boostLpl.searchKosNameLPLbyListing(kosName);
    }

    @Then("admin succsess see result search by kost name")
    public void admin_succsess_see_result_search_by_kost_name() {
        Assert.assertEquals(boostLpl.getListingName(),boostLpl.getListingName(),"result not equals");
        boostLpl.clearTextKosName();
    }

}
