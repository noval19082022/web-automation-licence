package pageobject.tenant;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
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
    }

    /**
     * Click on "delete voucher" button
     * Wait for the page to be fully loaded before interacting with elements
     * Check if the "delete voucher" button is visible before clicking on it
     */
    public void clickOnDeleteVoucher() {
        page.waitForLoadState(LoadState.LOAD);
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
     * @return int data type
     */
    public int getTotalPembayaran() {
        return JavaHelpers.extractNumber(playwright.getText(totalPembayaran));
    }

    /**
     * Extract the numerical value of the "subtotal" text and return it
     * @return int data type
     */
    public int getSubTotal() {
        return JavaHelpers.extractNumber(playwright.getText(subTotal));
    }

    /**
     * Extract the numerical value of the "voucher reduction price" text for the given voucher code and return it
     * @param voucherCodeName string data type of voucher code name
     * @return int data type
     */
    public int getVoucherReductionPrice(String voucherCodeName) {
        return JavaHelpers.extractNumber(playwright.getText(page.locator(String.format(appliedVoucher, voucherCodeName))));
    }

    /**
     * Return the text of the toast message
     * @return String data type
     */
    public String getToastText() {
        return playwright.getText(toast);
    }
}
