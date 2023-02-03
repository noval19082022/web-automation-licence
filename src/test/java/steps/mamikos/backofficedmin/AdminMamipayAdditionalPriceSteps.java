package steps.mamikos.backofficedmin;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pageobject.admin.mamipay.AdminMamipayDashboardPO;
import pageobject.admin.mamipay.invoice.MamikosListInvoicePO;
import testdata.InvoiceTestData;
import utilities.PlaywrightHelpers;

import java.util.Map;

public class AdminMamipayAdditionalPriceSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    MamikosListInvoicePO invoiceAdmin = new MamikosListInvoicePO(page);
    AdminMamipayDashboardPO adminMamipay = new AdminMamipayDashboardPO(page);
    private Map<String, String> additionalPriceData;

    @When("admin add additional price:")
    public void adminAddAdditionalPrice(DataTable table) {
        additionalPriceData = table.asMap(String.class, String.class);
        var additionalPriceSearchBy = additionalPriceData.get("search by");
        var searchValue = additionalPriceData.get("search value");
        var invoiceNumber = additionalPriceData.get("invoice number").equalsIgnoreCase("default");
        var invoiceNumberValue = invoiceNumber ? InvoiceTestData.getInvoiceNumber() : additionalPriceData.get("invoice number");
        var additionalPriceType = additionalPriceData.get("additional price type");
        var additionalPriceName = additionalPriceData.get("additional price title");
        var additionalPriceValue = additionalPriceData.get("addtional price value");
        adminMamipay.goToMamikosSearchInvoice();
        invoiceAdmin.selectSearchInvoiceBy(additionalPriceSearchBy);
        invoiceAdmin.fillInputSearchValue(searchValue);
        invoiceAdmin.clickOnCariInvoice();
        invoiceAdmin.goToInvoiceDetail(invoiceNumberValue);
        invoiceAdmin.clickOnAddFeeInInvoice();
        if (!additionalPriceType.equalsIgnoreCase("default")) {
            invoiceAdmin.selectAdditionalPriceType(additionalPriceType);
        }
        invoiceAdmin.fillAdditionalPriceName(additionalPriceName);
        invoiceAdmin.fillAdditionalPriceCostValue(additionalPriceValue);
        invoiceAdmin.clickOnAddFeeInAdditionalPrice();
    }
}
