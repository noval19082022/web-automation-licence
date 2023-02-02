package pageobject.tenant;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

public class InvoicePO {
    private Page page;
    private PlaywrightHelpers playwright;
    Locator deleteVoucher;
    Locator masukkanVoucher;
    Locator masukkanVoucherPopUp;
    Locator voucherAndaPopUp;
    Locator voucherCodeInput;
    Locator pakaiVoucherButton;
    Locator totalPembayaran;
    Locator subTotal;
    String appliedVoucher;
    Locator toast;
    Locator invoiceSection;
    Locator invalidVoucherIcon;
    Locator hapusToastButton;
    Locator voucherToastWarningText;
    Locator closeVoucherPopUpButton;
    Locator voucherInputPopUpWarningText;
    Locator pilihPembayaranButton;
    Locator bankMandiri;
    Locator bayarSekarangButton;
    Locator kodePerusahaanText;
    Locator virtualAccountText;

    public InvoicePO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        masukkanVoucher = page.getByTestId("masukkan_link");
        masukkanVoucherPopUp = page.locator("#wrapper-scroll").getByTestId("masukkan_link");
        voucherAndaPopUp = page.getByText("Voucher Anda");
        voucherCodeInput = page.getByTestId("codeVoucher_txt");
        pakaiVoucherButton = page.getByTestId("pakaiVoucher_btn");
        totalPembayaran = page.locator("//*[.='Total Pembayaran']/following-sibling::*");
        subTotal = page.locator("//*[.='Sub Total']/following-sibling::*");
        appliedVoucher = "//*[@class='invoice-detail-row-section']//*[contains(text(), '%s')]/following-sibling::*";
        toast = page.locator(".bg-c-toast__content");
        deleteVoucher = page.locator("#invoiceContent .invoice-voucher-switch");
        invoiceSection = page.locator("invoiceBill");
        invalidVoucherIcon = page.locator("//*[@href='#basic-error-round-glyph']");
        hapusToastButton = page.locator("//button[@class='bg-c-button bg-c-button--tertiary-naked-inversed bg-c-button--md']");
        voucherToastWarningText = page.getByTestId("warning_txt");
        closeVoucherPopUpButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("close"));
        voucherInputPopUpWarningText = page.getByTestId("warning_txt");
        pilihPembayaranButton = page.locator("a").filter(new Locator.FilterOptions().setHasText("Pilih"));
        bankMandiri = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("Bank Mandiri - MamiPAY"));
        bayarSekarangButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Bayar Sekarang"));
        kodePerusahaanText = page.locator("//*[.='Kode Perusahaan']/following-sibling::*");
        virtualAccountText = page.locator("//*[.='No. Virtual Account']/following-sibling::*");
    }

    /**
     * Click on "delete voucher" button
     * Wait for the page to be fully loaded before interacting with elements
     * Check if the "delete voucher" button is visible before clicking on it
     */
    public void clickOnDeleteVoucher() throws InterruptedException {
        page.waitForLoadState(LoadState.LOAD);
        page.waitForTimeout(3000);
        if (deleteVoucher.isVisible()) {
            playwright.clickOn(deleteVoucher);
        }
    }

    /**
     * Click on the "masukkan voucher" button
     */
    public void clickOnMasukkanVoucher() {
        playwright.clickOn(masukkanVoucher);
    }

    /**
     * Click on the "masukkan voucher" button on the pop-up
     */
    public void clickOnMasukkanVoucherPopUp() {
        playwright.clickOn(masukkanVoucherPopUp);
    }

    /**
     * Fill in the voucher ID input field with the provided voucher ID
     *
     * @param voucherIdName String data type of voucher id name
     */
    public void fillVoucherID(String voucherIdName) {
        voucherCodeInput.fill(voucherIdName);
    }

    /**
     * Click on the "pakai voucher" button
     */
    public void clickOnPakaiVoucherButton() {
        playwright.clickOn(pakaiVoucherButton);
    }

    /**
     * Extract the numerical value of the "total pembayaran" text and return it
     *
     * @return int data type
     */
    public int getTotalPembayaran() {
        return JavaHelpers.extractNumber(playwright.getText(totalPembayaran));
    }

    /**
     * Extract the numerical value of the "subtotal" text and return it
     *
     * @return int data type
     */
    public int getSubTotal() {
        return JavaHelpers.extractNumber(playwright.getText(subTotal));
    }

    /**
     * Extract the numerical value of the "voucher reduction price" text for the given voucher code and return it
     *
     * @param voucherCodeName string data type of voucher code name
     * @return int data type
     */
    public int getVoucherReductionPrice(String voucherCodeName) {
        return JavaHelpers.extractNumber(playwright.getText(page.locator(String.format(appliedVoucher, voucherCodeName))));
    }

    /**
     * Return the text of the toast message
     *
     * @return String data type
     */
    public String getToastText() {
        return playwright.getText(toast);
    }

    /**
     * Wait until voucher warning text appear
     *
     * @return
     */
    public boolean waitUntilvoucherUsedTextVisible() {
        return voucherToastWarningText.isVisible();
    }

    /**
     * Get success Voucher User Text text
     *
     * @return String data type
     */
    public String getVoucherUsedText() {
        return playwright.getText(voucherToastWarningText);
    }

    /**
     * Click on the "close button" in the voucher pop-up
     */
    public void closeVoucherPopUp() {
        for (int i = 0; i < 2; i++) {
            closeVoucherPopUpButton.click();
        }

    }

    /**
     * Check is icon "x" is visible
     * @return boolean true or false
     */
    public boolean isInvalidVoucherIconVisible() {
        return playwright.isLocatorVisibleAfterLoad(invalidVoucherIcon, 2000.0);
    }

    /**
     * click on hapus in toast button
     */
    public void clickOnHapusInToast() {
        playwright.clickOn(hapusToastButton);
        masukkanVoucher.waitFor();
    }

    /**
     * Get voucher input warning text, after inputted invalid voucher
     * @return String data type
     */
    public String voucherInputPopUpWarningText() {
        return playwright.getText(voucherInputPopUpWarningText);
    }

    /**
     * Click on pilih pembayaran to choose what method to the payment.
     */
    public void clickOnPilihPembayaran() {
        playwright.clickOn(pilihPembayaranButton);
    }

    /**
     * Choose mandiri as payment
     */
    public void clickOnMandiri() {
        playwright.clickOn(bankMandiri);
    }

    /**
     * Click on bayar sekarang button
     */
    public void clickOnBayarSekarang() {
        playwright.clickOn(bayarSekarangButton);
    }

    /**
     * Get company code text to use on midtrans
     * @return String data type
     */
    public String getCompanyCodeText() {
        return playwright.getText(kodePerusahaanText);
    }

    /**
     * Get virtual account number to use on midtrans
     * @return String data type
     */
    public String getVirtualAccountNumberText() {
        return playwright.getText(virtualAccountText);
    }
}
