package pageobject.tenant.payment;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import data.mamikos.Mamikos;
import utilities.PlaywrightHelpers;

public class PaymentPO {
    Page page;
    PlaywrightHelpers playwright;

    public PaymentPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
    }

    /**
     * this method is step for payment using BNI
     *
     * @param virtualAcount
     * @param amount
     */
    public void paymentUsingBNI(String virtualAcount, String amount) {
        playwright.navigateTo(Mamikos.URL + "/user/booking", 30000.0, LoadState.LOAD);
        Page page1 = page.waitForPopup(() -> {
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Bayar Sekarang")).click();
        });
        page1.getByText("Pilih", new Page.GetByTextOptions().setExact(true)).click();
        page1.locator("#invoicePayment div").filter(new Locator.FilterOptions().setHasText("Bank BNI")).nth(1).click();
        page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Bayar Sekarang")).click();
        page1.navigate("https://portalbeta.bni-ecollection.com/partner/simulator/payment-simulator/index");
        page1.getByLabel("VA Number").click();
        page1.keyboard().type(virtualAcount);
        page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("")).click();
        page1.getByLabel("Payment Amount").click();
        page1.keyboard().type(amount);
        page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Flag")).click();
        page1.getByText("Transaction success. VA number " + virtualAcount + " has been paid with amount IDR " + amount).isVisible();
        page1.close();
    }

    /**
     * Payment method using cc
     */
    public void paymentUsingCC() {
        playwright.navigateTo(Mamikos.URL + "/user/booking", 30000.0, LoadState.LOAD);
        Page page1 = page.waitForPopup(() -> {
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Bayar Sekarang")).click();
        });
        page1.getByText("Pilih", new Page.GetByTextOptions().setExact(true)).click();
        page1.locator("#invoicePayment div").filter(new Locator.FilterOptions().setHasText("Kartu Kredit")).nth(1).click();
        page1.getByPlaceholder("0000 0000 0000 0000").click();
        page1.keyboard().type("4000 0000 0000 1091");
        page1.getByPlaceholder("MM").click();
        page1.keyboard().type("12");
        page1.getByPlaceholder("YY").click();
        page1.keyboard().type("99");
        page1.getByPlaceholder("000", new Page.GetByPlaceholderOptions().setExact(true)).click();
        page1.keyboard().type("010");
        page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Bayar Sekarang")).click();
        page1.waitForLoadState();
        page1.frameLocator("#universalInvoiceContainer iframe").frameLocator("iframe[title=\"Bank Authentication\"]").getByPlaceholder(" Enter Code Here").click();
        page1.frameLocator("#universalInvoiceContainer iframe").frameLocator("iframe[title=\"Bank Authentication\"]").getByPlaceholder(" Enter Code Here").fill("1234");
        page1.frameLocator("#universalInvoiceContainer iframe").frameLocator("iframe[title=\"Bank Authentication\"]").getByText("SUBMIT").click();
        page1.waitForTimeout(3_000);
        String urlPaymentSignature = page1.evaluate("window.location.href")
                .toString()
                .replace("https://pay-jambu.kerupux.com/invoice/select-payment/", "https://pay-jambu.kerupux.com/invoice/success-payment/")
                .replace("step=1", "step=3");
        page1.navigate(urlPaymentSignature);
        page1.close();
    }

    /**
     * it will navigate to detail invoice from riwayat booking after payment
     */
    public void seeInvoiceAfterPayment() {
        page.getByText("Lihat selengkapnya").first().click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Lihat Invoice")).click();
    }
}
