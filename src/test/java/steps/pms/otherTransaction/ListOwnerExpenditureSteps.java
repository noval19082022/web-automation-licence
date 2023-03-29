package steps.pms.otherTransaction;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.pms.otherTransaction.listOwnerExpenditurePO;

public class ListOwnerExpenditureSteps {
    Page page = ActiveContext.getActivePage();
    listOwnerExpenditurePO list = new listOwnerExpenditurePO(page);

    @When("admin expand first owner expenditure list")
    public void admin_expand_first_owner_expenditure_list() {
        list.expandFirstList();
    }
    @Then("first owner expenditure detail should be visible")
    public void first_owner_expenditure_detail_should_be_visible() {
        list.assertFirstListDetailVisible();
    }
    @When("admin click lihat lampiran first owner expenditure list")
    public void admin_click_lihat_lampiran_first_owner_expenditure_list() {
        list.clickFirstLihatLampiran();
    }
    @Then("lampiran opened in new tab")
    public void lampiran_opened_in_new_tab() {
        list.assertNewTabOpen();
    }
}
