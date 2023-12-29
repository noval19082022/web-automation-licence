package steps.mamikos.bangkrupux;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.admin.mamipay.bangkrupux.MamitourOrderPO;
import utilities.PlaywrightHelpers;

public class MamitourOrderSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    MamitourOrderPO mamitourOrder = new MamitourOrderPO(page);

    @And("admin paid all unpaid transaction for {string}")
    public void admin_paid_all_unpaid_transaction(String phoneNumber) {
        playwright.navigateTo(Mamikos.URL + Mamikos.MAMITOUR_ORDER, 30000.0, LoadState.LOAD);
        mamitourOrder.searchPhoneNumber(phoneNumber);
        while (mamitourOrder.isFirstMarkAsPaidVisible()) {
            mamitourOrder.clickOnFirstMarkAsPaid();
            mamitourOrder.inputManualInvoice("INVOICEAUTOMATIONMAMITOUR0001");
            Assert.assertTrue(mamitourOrder.getSuccessTextAlert().contains(phoneNumber), "Text does not contain phone number");
            mamitourOrder.searchPhoneNumber(phoneNumber);
        }
    }

    @Then("admin verify all unpaid invoice already paid")
    public void admin_verify_all_unpaid_invoice_already_paid() {
        Assert.assertEquals(mamitourOrder.getCountMarkAsPaidOnMamitourOrder(), 0, "There is unpaid invoice");
    }

    @And("admin create request package {string} mamitour for {string}")
    public void admin_create_request_mamitour_for_x(String paket, String phoneNumber) {
        playwright.navigateTo(Mamikos.URL + Mamikos.MAMITOUR_ORDER, 30000.0, LoadState.LOAD);
        mamitourOrder.clickOnCreateRequestMamitourBtn();
        mamitourOrder.fillOwnerPhoneNumber(phoneNumber);
        mamitourOrder.choosePackage(paket);
        mamitourOrder.clickOnSave();
    }

    @Then("admin verify {string} transaction for {string}")
    public void admin_verify_unpaid_transaction_for_x(String status, String phoneNumber) {
        mamitourOrder.searchPhoneNumber(phoneNumber);
        Assert.assertEquals(mamitourOrder.getStatusPaymentText(), status, "The payment status is " + status);
    }
}
