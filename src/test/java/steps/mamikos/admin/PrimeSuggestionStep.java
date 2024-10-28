package steps.mamikos.admin;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
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

}
