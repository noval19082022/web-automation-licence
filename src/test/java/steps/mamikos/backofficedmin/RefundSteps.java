package steps.mamikos.backofficedmin;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import pageobject.admin.mamipay.paidinvoicelist.RefundPO;

import java.util.Optional;

public class RefundSteps {
    Page page = ActiveContext.getActivePage();
    RefundPO refundPO;

    @And("admin pick one invoice on list to refund")
    public void adminRefund() {
        this.refundPO = Optional.ofNullable(refundPO).orElseGet(() -> new RefundPO(page));
        refundPO.clickOnRefundBtn();
    }

    @And("admin fill bank name {string} on refund detail")
    public void adminFillBankNameOnRefundDetail(String bankName) {
        refundPO.fillBankName(bankName);
    }
}
