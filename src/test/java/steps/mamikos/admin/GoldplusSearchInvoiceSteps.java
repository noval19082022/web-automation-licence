package steps.mamikos.admin;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.When;
import pageobject.admin.mamipay.invoice.MamikosListInvoicePO;
import utilities.PlaywrightHelpers;

public class GoldplusSearchInvoiceSteps {
    private Page page = ActiveContext.getActivePage();
    private PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    private MamikosListInvoicePO mamikosListInvoicePO = new MamikosListInvoicePO(page);

    @When("admin search invoice Goldplus based on {string} and value {string}")
    public void admin_search_invoice_goldplus_based_on_criteria_and_value(String criteria, String value) {
        playwright.clickOnText("Goldplus Invoice List");
        mamikosListInvoicePO.selectSearchInvoiceBy(criteria);
        mamikosListInvoicePO.fillInputSearchValue(value);
        mamikosListInvoicePO.clickOnCariInvoice();
    }

    @When("admin search invoice Goldplus based on Status and value {string}")
    public void admin_search_invoice_goldplus_based_on_status_and_value(String value) {
        playwright.clickOnText("Goldplus Invoice List");
        mamikosListInvoicePO.selectDetailStatus(value);
        mamikosListInvoicePO.clickOnCariInvoice();
    }

    @When("admin search invoice Goldplus based on Package and value {string}")
    public void admin_search_invoice_goldplus_based_on_package_and_value(String value) {
        playwright.clickOnText("Goldplus Invoice List");
        mamikosListInvoicePO.selectPackageType(value);
        mamikosListInvoicePO.clickOnCariInvoice();
    }
}
