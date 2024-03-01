package pageobject.tenant.payment;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import data.mamikos.Mamikos;
import data.payment.Payment;
import utilities.PlaywrightHelpers;

public class PaymentPO {
    Page page;
    private PlaywrightHelpers playwright;
    private Locator paymentSuccessText;
    // BNI
    private Locator vaNumberPlaceHolder;
    private Locator searchBtn;
    private Locator paymentAmount;
    private Locator flagBtn;
    // CC
    private Locator codeCCPlaceHolder;
    private Locator submitBtnForCC;
    // riwayat booking
    private Locator lihatSelengkapnya;
    private Locator lihatInvoice;


    public PaymentPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.paymentSuccessText = page.getByText("Pembayaran Berhasil").first();
        // BNI
        this.vaNumberPlaceHolder = page.getByLabel("VA Number");
        this.searchBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(""));
        this.paymentAmount = page.getByLabel("Payment Amount");
        this.flagBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Flag"));
        // CC
        this.codeCCPlaceHolder = page.frameLocator("iframe").frameLocator("iframe[title='Bank Authentication']").getByPlaceholder(" Enter Code Here");
        this.submitBtnForCC = page.frameLocator("iframe").frameLocator("iframe[title='Bank Authentication']").getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("SUBMIT"));
        // riwayat booking
        this.lihatSelengkapnya = page.getByText("Lihat selengkapnya").first();
        this.lihatInvoice = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Lihat Invoice"));
    }

    /**
     * this method is step for payment using BNI
     *
     * @param virtualAcount
     * @param amount
     */
    public void paymentUsingBNI(String virtualAcount, String amount) {
        playwright.navigateTo(Payment.BNI_SIMULATOR, 30000.0, LoadState.LOAD);
        playwright.clickLocatorAndTypeKeyboard(vaNumberPlaceHolder, virtualAcount);
        playwright.clickOn(searchBtn);
        playwright.clickLocatorAndTypeKeyboard(paymentAmount, amount);
        playwright.clickOn(flagBtn);
        var transactionSuccessTxt = page.getByText("Transaction success. VA number " + virtualAcount + " has been paid with amount IDR " + amount);
        playwright.assertVisible(transactionSuccessTxt);
    }

    /**
     * Payment method using cc
     */
    public void paymentUsingCC() {
        playwright.clickLocatorAndTypeKeyboard(codeCCPlaceHolder, "1234");
        playwright.clickOn(submitBtnForCC);
        playwright.hardWait(3_000.00);
        playwright.reloadPage();
    }

    /**
     * it will navigate to detail invoice from riwayat booking after payment
     */
    public void seeInvoiceAfterPayment() {
        playwright.navigateTo(Mamikos.URL + Mamikos.TENANT_RIWAYAT_BOOKING);
        if (!playwright.waitTillLocatorIsVisible(lihatSelengkapnya, 5_000.0)) {
            playwright.reloadPage();
        }
        playwright.clickOn(lihatSelengkapnya);
        playwright.clickOn(lihatInvoice);
    }

    /**
     * check if payment is success
     *
     * @return String "Pembayaran Berhasil"
     */
    public String isPaymentSuccessText() {
        return playwright.getText(paymentSuccessText);
    }
}
