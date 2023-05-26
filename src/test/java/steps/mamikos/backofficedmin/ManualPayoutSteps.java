package steps.mamikos.backofficedmin;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobject.admin.mamipay.AdminMamipayDashboardPO;
import pageobject.admin.mamipay.invoice.MamikosListInvoicePO;
import pageobject.admin.mamipay.manualPayout.ManualPayoutPO;
import utilities.PlaywrightHelpers;

public class ManualPayoutSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    private AdminMamipayDashboardPO admin = new AdminMamipayDashboardPO(page);
    private MamikosListInvoicePO invoicePO = new MamikosListInvoicePO(page);
    private ManualPayoutPO manualPayout = new ManualPayoutPO(page);

    @And("admin want to search invoice number in manual payout menu {string}")
    public void adminWantToSearchInvoiceNumberInManualPayoutMenu(String invoiceNumber){
        admin.clickOnTextHyperlink("Manual Payout");
        invoicePO.selectSearchInvoiceBy("Invoice Number");
        invoicePO.fillInputSearchValue(invoiceNumber);
        manualPayout.clickOnSearchButton();
    }

    @Then("admin will see the search result in manual payout menu is {string}")
    public void adminWillSeeTheSearchResultInManualPayoutMenuIs(String searchResult) throws InterruptedException {
        manualPayout.getSearchResult(searchResult);
    }

    @And("admin want to search account name in manual payout menu {string}")
    public void adminWantToSearchAccountNameInManualPayoutMenu(String accountName) {
        admin.clickOnTextHyperlink("Manual Payout");
        invoicePO.selectSearchInvoiceBy("Account Name");
        invoicePO.fillInputSearchValue(accountName);
        manualPayout.clickOnSearchButton();
    }

    @And("admin want to search invoice with select type {string}")
    public void adminWantToSearchInvoiceWithSelectType(String type) {
        admin.clickOnTextHyperlink("Manual Payout");
        manualPayout.selectInvoiceType(type);
        manualPayout.clickOnSearchButton();
    }

    @And("admin want to search invoice with select status {string}")
    public void adminWantToSearchInvoiceWithSelectStatus(String status) {
        admin.clickOnTextHyperlink("Manual Payout");
        manualPayout.selectInvoiceStatus(status);
        manualPayout.clickOnSearchButton();
    }
}
