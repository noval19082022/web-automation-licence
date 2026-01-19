package pageobject.midtrans;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import config.playwright.context.ActiveContext;
import data.payment.Payment;
import utilities.PlaywrightHelpers;

import java.util.Optional;

public class MidtransPaymentPO {
    private Page page;
    private PlaywrightHelpers playwright;
    Locator billerCode;
    Locator paymentCode;
    Locator vaCodePlaceHolder;
    Locator inquireButton;
    Locator bayarButtonOnMidtrans;
    Locator payButton;
    Locator successTransaction;
    Locator targetBankSelection;
    Locator paymentAmountBNINewText;
    Locator flagButtonBNI;
    Locator searchButtonPaymentBNI;
    Locator vaCodePlaceHolderButtonBNINew;
    Locator bniSuccessPayment;

    public MidtransPaymentPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        billerCode = page.locator("#billerCode");
        paymentCode = page.locator("#billKey");
        vaCodePlaceHolder = page.locator("#inputMerchantId");
        inquireButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Inquire"));
        payButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pay"));
        bayarButtonOnMidtrans = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pay"));
        successTransaction = page.getByText("Simulated payment is successful");
        targetBankSelection = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Target Bank selection"));
        paymentAmountBNINewText = page.getByLabel("Payment Amount");
        flagButtonBNI = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Flag"));
        searchButtonPaymentBNI = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(""));
        vaCodePlaceHolderButtonBNINew = page.getByLabel("VA Number");
        bniSuccessPayment = page.locator(".note.note-success");
    }

    /**
     * Input company number
     * @param code company code number
     */
    public void inputBillerCode(String code) {
        billerCode.fill(code);
    }

    /**
     * Input payment virtual account code
     * @param code payment virtual account
     */
    public void inputPaymentCode(String code) {
        paymentCode.fill(code);
    }

    /**
     * Payment process midtrans for permata
     * @param kodePembayaran payment virtual account
     */
    public void paymentForPermata(String kodePembayaran, String Bank) {
        playwright = Optional.ofNullable(playwright).orElseGet(() -> new PlaywrightHelpers(ActiveContext.getActivePage()));
        playwright.navigateTo(Payment.PERMATA_MIDTRANS, 30000.0, LoadState.LOAD);
        playwright.clickLocatorAndTypeKeyboard(vaCodePlaceHolder, kodePembayaran);
        playwright.selectDropdownByValue(targetBankSelection, Bank);
        playwright.clickOn(inquireButton);
        playwright.waitTillLocatorIsVisible(bayarButtonOnMidtrans, 15000.0);
        playwright.clickOn(bayarButtonOnMidtrans);
        playwright.hardWait(2000);
    }

    /**
     * Payment process midtrans for BNI
     * @param kodePembayaran payment virtual account
     */
    public void paymentForBNI(String kodePembayaran){
        playwright = Optional.ofNullable(playwright).orElseGet(() -> new PlaywrightHelpers(page));
        playwright.navigateTo(Payment.BNI_SIMULATOR, 30000.0, LoadState.LOAD);
        playwright.clickLocatorAndTypeKeyboard(vaCodePlaceHolderButtonBNINew, kodePembayaran);
        playwright.clickOn(searchButtonPaymentBNI);
        playwright.waitTillLocatorIsVisible(paymentAmountBNINewText, 30000.0);
    }

    /**
     * payment process BNI simulator fro BNI
     * @param amountBNI
     */
    public void amountBNI(String amountBNI) {
        playwright = Optional.ofNullable(playwright).orElseGet(() -> new PlaywrightHelpers(page));
        playwright.clickLocatorAndTypeKeyboard(paymentAmountBNINewText, amountBNI);
        playwright.clickOn(flagButtonBNI);
        playwright.waitTillLocatorIsVisible(bniSuccessPayment, 60000.0);
        playwright.hardWait(5000.0);
    }
    /**
     * Payment process midtrans for BRI
     * @param kodePembayaran payment virtual account
     */
    public void paymentForBRI(String kodePembayaran) {
        playwright = Optional.ofNullable(playwright).orElseGet(() -> new PlaywrightHelpers(page));
        playwright.navigateTo(Payment.BRI_SIMULATOR, 30000.0, LoadState.LOAD);
        playwright.clickLocatorAndTypeKeyboard(vaCodePlaceHolder, kodePembayaran);
        playwright.clickOn(inquireButton);
        playwright.clickOn(bayarButtonOnMidtrans);
    }

    /**
     * Click on inquire button
     */
    public void clickOnInquireButton() {
        playwright.clickOn(inquireButton);
    }

    /**
     * Click on pay button
     */
    public void clickOnPayButton() {
        playwright.waitFor(payButton);
        playwright.clickOn(payButton);
    }

    /**
     * Wait for payment success
     */
    public void waitForSuccessTransaction() {
        playwright.waitFor(successTransaction, 30000.0);
    }
}
