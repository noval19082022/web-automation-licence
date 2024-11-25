package steps.mamikos.admin;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pageobject.admin.mamipay.bangkrupux.PrimeSuggestionPO;
import utilities.PlaywrightHelpers;

public class PrimeSuggestionStep {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    PrimeSuggestionPO prime = new PrimeSuggestionPO(page);

    @And("admin input kost name {string}")
    public void admin_input_kost_name(String text) {
    prime.inputKosName(text);
    }

    @And("admin click on add kost to prime suggestion button")
    public void admin_click_on_add_kost_to_prime_suggestion_button() {
        prime.clickOnAddKosButton();
    }

    @And("admin click on search button")
    public void admin_click_on_search_button() {
        prime.clickOnSearchButton();
    }

    @And("admin click on select button")
    public void admin_click_on_select_button() {
        prime.clickOnSelectButton();
    }

    @And("admin input file csv")
    public void admin_input_file_csv() {
        prime.clickOnInputFileCsv();
    }

    @And("admin click on preview button")
    public void admin_click_on_preview_button() {
        prime.clickOnPreviewButton();
    }

    @And("admin choose status {string}")
    public void admin_choose_status_active(String text) {
        prime.chooseStatusPrime(text);
    }

    @And("admin click on create button")
    public void admin_click_on_create_button() {
        prime.clickOnCreateButton();
    }

    @And("admin click on edit prime suggestion")
    public void admin_click_on_edit_prime_suggestion() {
        prime.clickOnEditPrimeSuggestion();
    }

    @And("admin click on save prime suggestion")
    public void admin_click_on_save_prime_suggestion() {
        prime.clickOnSavePrimeSuggestion();
    }

    @And("admin click on show keyword button")
    public void admin_click_on_show_keyword_button(){
        prime.adminClickOnShowKeywordButton();
    }

    @And("admin click on add keyword button")
    public void admin_click_on_add_keyword_button(){
        prime.adminClickOnAddKeywordButton();
    }

    @And("admin click on add button")
    public void admin_click_on_add_button(){
        prime.adminClickOnAddButton();
    }

    @And("admin search area {string}")
    public void admin_search_area(String area){
        prime.searchArea(area);
    }

    @When("Admin click on delete")
    public void Admin_click_on_delete(){
        prime.adminClickOnDelete();
    }

    @And("admin click on dropdown all status")
    public void Admin_click_on_dropdown_all_status(){
        prime.adminClickOnDropdownAllStatus();
    }

    @And("admin click on filter {string}")
    public void Admin_click_on_filter(String text){
        prime.adminClickOnfilter(text);
    }

    @And("admin see list status mamiprime {string}")
    public void Admin_list_status_mamiprime (String text){
        prime.adminSeeListStatusMamiprime(text);
    }
}
