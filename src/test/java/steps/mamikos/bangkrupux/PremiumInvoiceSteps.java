package steps.mamikos.bangkrupux;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.admin.mamipay.bangkrupux.PremiumInvoicePO;

public class PremiumInvoiceSteps {
    Page page = ActiveContext.getActivePage();
    PremiumInvoicePO premiumInvoicePO = new PremiumInvoicePO(page);

    @And("admin bangkrupux navigate to package invoice list menu on premium invoice")
    public void adminNavigateToPackageInvoiceList() {
        premiumInvoicePO.navigatesIntoPackageInvoiceList();
    }

    @And("admin bangkrupux search package invoice list premium by {string} and input field {string}")
    public void adminBangkrupuxSearchPackageInvoiceListPremiumByAndInputField(String searchBy, String inputField) {
        premiumInvoicePO.searchPackageInvoiceBy(searchBy, inputField);
        premiumInvoicePO.clickOnSearchPackageInvoice();
    }

    @Then("admin bangkerupux get blank data list on package invoice list")
    public void adminBangkerupuxGetBlankDataListOnPackageInvoiceList() {
        premiumInvoicePO.isDataListBlannk();
    }

    @And("admin bangkrupux filter the status of package invoice list premium for {string} transaction")
    public void adminBangkrupuxFilterThePackageInvoiceListPremiumForTransaction(String filter) {
        premiumInvoicePO.filterTransactionStatus(filter);
        premiumInvoicePO.clickOnSearchPackageInvoice();
    }

    @Then("admin bangkerupux see transaction status list on package invoice list is only {string}")
    public void adminBangkerupuxSeeTransactionStatusListOnPackageInvoiceListIsOnly(String status) {
        premiumInvoicePO.getListStatusTransaction().forEach(
                statusActual -> Assert.assertEquals(statusActual, status));
    }

    @Then("admin bangkerupux see transaction status on package invoice list is {string}")
    public void adminBangkerupuxSeeTransactionStatusOnPackageInvoiceListIsOnly(String status) {
        Assert.assertEquals(premiumInvoicePO.getInvoiceStatusTransaction(), status);
    }
}
