package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.When;
import pageobject.tenant.InvoicePO;
import utilities.PlaywrightHelpers;

public class OwnerPaymentSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    InvoicePO invoice = new InvoicePO(page);

    @When("payment owner success using ovo as payment method")
    public void payment_owner_success_using_ovo_as_payment_method() {
        invoice.clickOnPilihPembayaran();
        invoice.clickOnOVO();
        invoice.inputPhoneNumberOvo("081280003230");
        invoice.clickOnBayarSekarang();
        playwright.hardWait(5);
        playwright.clickOnText("Saya Sudah Bayar");
        page.reload();
    }

}
