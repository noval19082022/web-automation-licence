package steps.mamikos.bangkrupux;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
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
}
