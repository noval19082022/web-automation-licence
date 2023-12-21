package steps.mamikos.owner.mamiads;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import pageobject.owner.mamiads.UniversalInvoicePO;

public class UniversalInvoiceSteps {

    Page page = ActiveContext.getActivePage();
    UniversalInvoicePO universalInvoicePO = new UniversalInvoicePO(page);
    Page page1;

    @And("user using voucher {string} to pay mamiads")
    public void user_using_voucher_to_pay_mamiads(String voucher){
        universalInvoicePO.clickOnMasukkanText();
        universalInvoicePO.clickOnMasukkanTextInVoucherAnda();
        universalInvoicePO.inputKodeVoucher(voucher);
        universalInvoicePO.clickOnPakaiVoucherButton();
    }

    @And("owner click button selesai on universal invoice")
    public void owner_click_button_selesai_on_universal_invoice() {
        page1 = universalInvoicePO.clickOnSelesaiButton();
    }

}
