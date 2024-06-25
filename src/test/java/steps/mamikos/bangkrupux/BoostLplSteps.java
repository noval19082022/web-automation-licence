package steps.mamikos.bangkrupux;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.Given;
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

    @When("admin input kost name with {string} at form add boost lpl")
    public void admin_input_kost_name_with_at_form_add_boost_lpl(String kosName) {
        boostLpl.clickOnButtonAddLpl();
      boostLpl.searchKosNameToBoost(kosName);

    }

    @Then("the result from kost {string} not show")
    public void the_result_from_kost_not_show(String kost) {
        Assert.assertFalse(boostLpl.isResultKostPresent(kost), "user id found");
    }

    @When("admin wants to add listing to boost lpl")
    public void admin_wants_to_add_listing_to_boost_lpl() {
        boostLpl.clickButtonBoostLpl();
        Assert.assertTrue(boostLpl.isPopUpAddBoostLplAppear(),"pop up not appear");
        boostLpl.clickButtonYesLpl();
    }

    @Then("admin can see {string} was added with lpl score is {string}")
    public void admin_can_see_was_added_with_lpl_score_is(String listingName, String lplScore) {
        Assert.assertEquals(boostLpl.getListingName(listingName),listingName,"listing name doesnt match");
        Assert.assertEquals(boostLpl.getScoreLpl(lplScore),lplScore,"score doesnt match");
    }

    @Then("admin delete listing from boost lpl")
    public void admin_delete_listing_from_boost_lpl() {
       boostLpl.clickOnDeleteButton();
    }

    @When("admin search subdistrict with {string}")
    public void admin_search_subdistrict_with(String subdistrict) {
        boostLpl.searchSubdsitrict(subdistrict);
    }

    @Then("admin cannot see result at prime setting")
    public void admin_cannot_see_result_at_prime_setting() {
       Assert.assertFalse(boostLpl.isSubdistrictAppear(),"Coloum result not appear");
    }

    @Given("admin reset form search subdsitrict")
    public void admin_reset_form_search_subdsitrict() {
       boostLpl.clickOnBtnResetPrime();
    }

    @Then("admin can see result data of district id {string} with name {string}")
    public void admin_can_see_result_data_of_district_id_with_name(String id, String name) {
      Assert.assertEquals(id,boostLpl.getSubdistrictId(id),"id subdistrict doesnt equal");
      Assert.assertEquals(name,boostLpl.getSubdistrictName(name),"name subdistrict doesnt equal");
    }

    @Given("admin can see slot is {string}")
    public void admin_can_see_slot_is(String slot) {
        Assert.assertEquals(boostLpl.getSlotSubdistrict(slot),slot,"Slot doesnt equal");
    }

    @When("admin wants to adjust slot {string}")
    public void admin_wants_to_adjust_slot(String slot) {
       boostLpl.inputSlotDistrict(slot);
    }

    @Then("admin can see message {string} at prime setting")
    public void admin_can_see_message_at_prime_setting(String message) {
        Assert.assertEquals(boostLpl.getMessageSlot(message),message,"message doesnt equal");
    }

    @When("admin wants to adjust slot {string} from page slot")
    public void admin_wants_to_adjust_slot_from_page_slot(String slot) {
       boostLpl.inputSlotDistrictFromPageSlot(slot);
    }

    @Then("admin can see package name {string} has label {string}")
    public void admin_can_see_package_name_has_label(String packageName, String label) {
        Assert.assertEquals(boostLpl.getPackageName(packageName),packageName,"package name doesnt equal");
        Assert.assertEquals(boostLpl.getLabelName(label),label,"label doesnt equal");
    }
}
