package steps.mamikos.backofficedmin;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.admin.mamipay.AdminMamipayDashboardPO;
import pageobject.admin.mamipay.invoice.MamikosListInvoicePO;
import testdata.InvoiceTestData;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

import java.util.List;
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

    @Then("admin can sees total cost is basic amount + deposit fee + additional fee + admin fee")
    public void adminCanSeesTotalCostIsBasicAmountDepositFeeAdditionalFeeAdminFee() {
        Integer totalCost = JavaHelpers.extractNumber(invoiceAdmin.getInvoiceElementValue("Total Amount").split(",", 2)[0]);
        Integer deposit = JavaHelpers.extractNumber(invoiceAdmin.getInvoiceElementValue("Invoice Deposit Fee").split(",", 2)[0]);
        Integer basicAmount = JavaHelpers.extractNumber(invoiceAdmin.getInvoiceElementValue("Basic Amount").split(",", 2)[0]);
        Integer otherPrice = invoiceAdmin.getOtherPriceNumber("Biaya Tetap");
        Integer adminFee = invoiceAdmin.getOtherPriceNumber("Admin");
        Integer totalToAssert = deposit + basicAmount + otherPrice + adminFee;
        Assert.assertEquals(totalCost, totalToAssert, "Is not match");
    }


    @Then("admin can sees total cost is basic amount + deposit fee + admin fee")
    public void admin_can_sees_total_cost_is_basic_amount_deposit_fee_admin_fee() {
        Integer totalCost = JavaHelpers.extractNumber(invoiceAdmin.getInvoiceElementValue("Total Amount").split(",", 2)[0]);
        Integer deposit = JavaHelpers.extractNumber(invoiceAdmin.getInvoiceElementValue("Invoice Deposit Fee").split(",", 2)[0]);
        Integer basicAmount = JavaHelpers.extractNumber(invoiceAdmin.getInvoiceElementValue("Basic Amount").split(",", 2)[0]);
        Integer adminFee = invoiceAdmin.getOtherPriceNumber("Admin");
        Integer totalToAssert = deposit + basicAmount + adminFee;
        Assert.assertEquals(totalCost, totalToAssert, "Is not match");
    }

    @And("admin search invoice by contact number:")
    public void adminSearchInvoiceByContactNumber(DataTable table) {
        additionalPriceData = table.asMap(String.class, String.class);
        var additionalPriceSearchBy = additionalPriceData.get("search by");
        var searchValue = additionalPriceData.get("search value");
        adminMamipay.goToMamikosSearchInvoice();
        invoiceAdmin.selectSearchInvoiceBy(additionalPriceSearchBy);
        invoiceAdmin.fillInputSearchValue(searchValue);
        invoiceAdmin.clickOnCariInvoice();
        invoiceAdmin.clickOnDetailFirstButton();
    }

    @When("^admin deletes additional other price with name below :$")
    public void admin_deletes_additional_other_price_with_name(List<String> otherPriceName) throws InterruptedException {
        for (String s : otherPriceName) {
            invoiceAdmin.deleteAdditionalOtherPrice(s);
        }
    }

    @Then("admin can sees total cost is basic amount + admin fee")
    public void admin_can_sees_total_cost_is_basic_amount_admin_fee() throws InterruptedException {
        int totalCost = JavaHelpers.extractNumber(invoiceAdmin.getInvoiceElementValue("Total Amount").split(",", 2)[0]);
        int basicAmount = JavaHelpers.extractNumber(invoiceAdmin.getBasicAmountText().split(",", 2)[0]);
        int adminFee = invoiceAdmin.getOtherPriceNumber("Admin");
        Assert.assertEquals(totalCost, basicAmount + adminFee);
    }
}
