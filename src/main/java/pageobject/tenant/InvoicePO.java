package pageobject.tenant;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import pageobject.tenant.payment.PaymentPO;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

import java.util.List;

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
    Locator bankPermata;
    Locator bankBNI;
    Locator kartuKredit;
    Locator dana;
    Locator linkAja;
    Locator inputKartuKreditNumber;
    Locator inputKartuKreditMonth;
    Locator inputKartuKreditYear;
    Locator inputKartuKreditCCV;
    Locator bayarSekarangButton;
    Locator kodePerusahaanText;
    Locator virtualAccountText;
    Locator kodePembayaranPermata;
    Locator txtAdminCost;
    Locator txtRentPerPeriod;
    Locator filterKostName;
    Locator invoiceNumber;
    Locator additionalPriceDiv;
    Locator closeFilter;
    Locator openTagihan;
    Locator kelolaTagihanButton;
    Locator selectKostName;
    Locator nextButton;
    Locator inputMonthFilter;
    Locator checkMonth;
    Locator txtRentPerPeriodInvoiceDetail;
    Locator txtTotalCostInvoiceDetail;
    Locator txtAddCostInvoiceDetail;
    Locator txtOVO;
    Locator noOvoTextBox;
    Locator additionalPriceDivAddOn;
    Locator voucherDivSection;
    Locator perDurationPriceText;
    Locator biayaLayananMamikosText;
    Locator tncInvoiceFullText;
    Locator tncInvoiceText;
    Locator mamipoinToggleButtonOn;
    Locator mamipoinToggleButtonOff;
    Locator tenantPointEstimate;
    Locator discountMamipoinText;

    public InvoicePO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        masukkanVoucher = page.getByTestId("masukkan_link");
        masukkanVoucherPopUp = page.locator("#wrapper-scroll").getByTestId("masukkan_link");
        voucherAndaPopUp = page.getByText("Voucher Anda");
        voucherCodeInput = page.getByTestId("codeVoucher_txt");
        pakaiVoucherButton = page.getByTestId("pakaiVoucher_btn");
        totalPembayaran = page.locator("//*[.='Total Pembayaran']/following-sibling::*");
        subTotal = page.locator("//*[.='Sub Total']/following-sibling::*").first();
        appliedVoucher = "//*[@class='invoice-detail-row-section']//*[contains(text(), '%s')]/following-sibling::*";
        toast = page.locator(".bg-c-toast__content");
        deleteVoucher = page.locator("#invoiceContent .invoice-voucher-switch");
        invoiceSection = page.locator("invoiceBill");
        invalidVoucherIcon = page.locator("//*[@href='#basic-error-round-glyph']");
        hapusToastButton = page.locator("//button[@class='bg-c-button bg-c-button--tertiary-naked-inversed bg-c-button--md']");
        voucherToastWarningText = page.getByTestId("warning_txt");
        closeVoucherPopUpButton = page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText("close"));
        voucherInputPopUpWarningText = page.getByTestId("warning_txt");
        pilihPembayaranButton = page.getByText("Pilih", new Page.GetByTextOptions().setExact(true));
        bankMandiri = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("Bank Mandiri - MamiPAY"));
        bankPermata = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("Bank Permata - MamiPAY"));
        bankBNI = page.locator("#invoicePayment div").filter(new Locator.FilterOptions().setHasText("Bank BNI")).nth(1);
        kartuKredit = page.locator("#invoicePayment div").filter(new Locator.FilterOptions().setHasText("Kartu Kredit")).nth(1);
        dana = page.locator("#invoicePayment div").filter(new Locator.FilterOptions().setHasText("DANA")).nth(1);
        linkAja = page.locator("#invoicePayment div").filter(new Locator.FilterOptions().setHasText("LinkAja")).nth(1);
        inputKartuKreditNumber = page.getByPlaceholder("0000 0000 0000 0000");
        inputKartuKreditMonth = page.getByPlaceholder("MM");
        inputKartuKreditYear = page.getByPlaceholder("YY");
        inputKartuKreditCCV = page.getByPlaceholder("000", new Page.GetByPlaceholderOptions().setExact(true));
        bayarSekarangButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Bayar Sekarang"));
        kodePerusahaanText = page.locator("//*[.='Kode Perusahaan']/following-sibling::*");
        virtualAccountText = page.locator("//*[.='No. Virtual Account']/following-sibling::*");
        kodePembayaranPermata = page.locator(".column > .columns > .second-column").first();
        invoiceNumber = page.locator("//*[.='No. Invoice']/following-sibling::*");
        additionalPriceDiv = page.getByTestId("invoiceBillingRoomContent-additionalCost");
        txtRentPerPeriod = page.locator("//p[contains(text(),'Harga Sewa')]/../following-sibling::p");
        txtAdminCost = page.locator("[data-testid='invoiceBillingRoomContent-admin'] > .bg-c-text--body-1");
        filterKostName = page.locator(".column").first();
        closeFilter = page.locator("i").nth(1);
        openTagihan = page.locator("//*[@class='billing-management-table__row']").first();
        kelolaTagihanButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kelola Tagihan"));
        nextButton = page.getByRole(AriaRole.IMG).filter(new Locator.FilterOptions().setHasText("arrow-right"));
        inputMonthFilter = page.locator("//*[@class='billing-management-input-trigger bg-c-dropdown'][1]");
        txtRentPerPeriodInvoiceDetail = page.locator("div:nth-child(10) > div:nth-child(2)");
        txtTotalCostInvoiceDetail = page.locator("div:nth-child(14) > div:nth-child(2)");
        txtAddCostInvoiceDetail = page.locator("div:nth-child(12) > .item-section > div:nth-child(2)");
        txtOVO = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("OVO - MamiPAY"));
        noOvoTextBox = page.getByPlaceholder("08...");
        additionalPriceDivAddOn = page.locator(".collapse.details-collapsible");
        voucherDivSection = page.locator("#invoiceVoucherInput #invoiceContent");
        biayaLayananMamikosText = page.locator("//*[contains(text(), 'Biaya layanan mamikos')]/following-sibling::*").first();
        perDurationPriceText = page.locator("//*[contains(text(), 'Harga Sewa')]/parent::*/following-sibling::*").first();
        tncInvoiceFullText = page.locator(".first-column.column");
        tncInvoiceText = page.getByText("Syarat dan Ketentuan Umum");
        mamipoinToggleButtonOn = page.locator("//div[@class='bg-c-switch invoice-point-switch bg-c-switch--off']");
        mamipoinToggleButtonOff = page.locator("//div[@class='bg-c-switch invoice-point-switch bg-c-switch--on']");
        tenantPointEstimate = page.locator(".mamipoin-estimated-text");
        discountMamipoinText = page.locator("xpath = //p[text()='Potongan MamiPoin']/following-sibling::p");

    }

    /**
     * Click on "delete voucher" button
     * Wait for the page to be fully loaded before interacting with elements
     * Check if the "delete voucher" button is visible before clicking on it
     */
    public void clickOnDeleteVoucher() {
        page.waitForLoadState(LoadState.LOAD);
        playwright.waitFor(voucherDivSection, 5000.0);
        if (playwright.waitTillLocatorIsVisible(deleteVoucher)) {
            playwright.clickOn(deleteVoucher);
        }
    }

    /**
     * Click on the "masukkan voucher" button
     */
    public void clickOnMasukkanVoucher() {
        masukkanVoucher.waitFor();
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
        playwright.hardWait(250);
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
        playwright.hardWait(1000);
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
     * Choose permata as payment
     */
    public void clickOnPermata() {
        playwright.clickOn(bankPermata);
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

    /**
     * Get kode pembayaran number to use on midtrans PERMATA
     * @return String data type
     */
    public String getKodePembayaranNumberText() {
        return kodePembayaranPermata.textContent().trim();
    }

    /**
     * Get invoice number
     * @return String data type of invoice number
     */
    public String getInvoiceNumber() {
        return playwright.getText(invoiceNumber);
    }

    /**
     * Get additional price inner text
     * @return String data type list of additional price section
     */
    public List<String> getAdditionalPriceInnerText() {
        List<String> textAdditionalPrice = null;
        page.waitForLoadState(LoadState.LOAD);
        playwright.hardWait(3000);
        if (playwright.waitTillLocatorIsVisible(additionalPriceDiv)){
            playwright.waitFor(additionalPriceDiv,10000.0);
            textAdditionalPrice = additionalPriceDiv.allInnerTexts();
        }else {
            additionalPriceDivAddOn.waitFor();
            textAdditionalPrice = additionalPriceDivAddOn.allInnerTexts();
        }
        return textAdditionalPrice;
    }

    /**
     * Get Total Cost number
     * @return String data type of invoice number
     */
    public String getTotalCost() {
        return playwright.getText(totalPembayaran).trim();
    }

    /**
     * Get Total Cost number in Invoice Detail
     * @return String data type of invoice number
     */
    public String getTotalCostInvoiceDetail() {
        return playwright.getText(txtTotalCostInvoiceDetail).trim();
    }

    /**
     * Get Admin Cost number
     * @return String data type of invoice number
     */
    public String getAdminCost() {
        return playwright.getText(txtAdminCost).trim();
    }

    /**
     * Get Additional Cost number
     * @return String data type of invoice number
     */
    public String getAddCostInvoiceDetail() {
        return playwright.getText(txtAddCostInvoiceDetail).trim();
    }

    /**
     * Get Rent Cost Per Period number
     * @return String data type of invoice number
     */
    public String getRentCostPerPeriod() {
        return playwright.getText(txtRentPerPeriod).trim();
    }

    /**
     * Get Rent Cost Per Period number in Invoice Detail
     * @return String data type of invoice number
     */
    public String getRentCostPerPeriodInvoiceDetail() {
        return playwright.getText(txtRentPerPeriodInvoiceDetail).trim();
    }

    /**
     * filter Open Kelola Tagihan
     */
    public void openKelolaTagihan() {
        playwright.clickOn(kelolaTagihanButton);
    }

    /**
     * filter Tagihan Kost Name
     */
    public void filterTagihanKost(String filter) {
        playwright.clickOn(filterKostName);
        selectKostName = page.locator("span").filter(new Locator.FilterOptions().setHasText(filter)).locator("div");
        playwright.clickOn(selectKostName);
        playwright.clickOn(closeFilter);
    }


    /**
     * filter Open Tagihan Kost
     */
    public void openBills() {
        playwright.clickOn(openTagihan.last());
    }

    /**
     * Select month filter by month number
     * @param monthNumber 1 = January
     * @throws InterruptedException
     */
    public void selectManageNextBillsMonthFilter(String monthNumber) throws InterruptedException {
        playwright.clickOn(inputMonthFilter);
        if (monthNumber.equals("12")) {
            playwright.clickOn(nextButton);
            playwright.clickOn(page.getByText("Januari"));
        } else {
            checkMonth = page.locator("//*[@class='date-wrapper']//*[@class='cell month'][" + monthNumber + "]");
            playwright.clickOn(checkMonth);
            page.waitForLoadState(LoadState.LOAD);
            page.waitForTimeout(3000);
        }
    }

    /**
     * payment using ovo as payment method
     * @param number phone number ovo
     */
    public void paymentOVO(String number) {
        clickOnPilihPembayaran();
        playwright.clickOn(txtOVO);
        noOvoTextBox.fill(number);
        clickOnBayarSekarang();
        playwright.hardWait(5);
        playwright.clickOnText("Saya Sudah Bayar");
        page.reload();
    }

    /**
     * choose payment using ovo as payment method without input phone number
     */
    public void choosePaymentUsing(String method){
        clickOnPilihPembayaran();
        if (method.equalsIgnoreCase("Kartu Kredit")) {
            playwright.clickOn(kartuKredit);
        } else if (method.equalsIgnoreCase("OVO")) {
            playwright.clickOn(txtOVO);
        }
    }

    /**
     * select payment method using BNI
     * @return PaymentPO with next active page
     */
    public PaymentPO paymentUsingBNI() {
        clickOnPilihPembayaran();
        bankBNI.click();
        clickOnBayarSekarang();
        return new PaymentPO(page);
    }

    /**
     * select payment method using kredit card
     * @param ccNumber
     * @param month
     * @param years    (2 digit)
     * @param ccv
     * @return PaymentPO with next active page
     */
    public PaymentPO paymentUsingCC(String ccNumber, String month, String years, String ccv) {
        clickOnPilihPembayaran();
        kartuKredit.click();
        inputKartuKreditNumber.click();
        page.keyboard().type(ccNumber);
        inputKartuKreditMonth.click();
        page.keyboard().type(month);
        inputKartuKreditYear.click();
        page.keyboard().type(years);
        inputKartuKreditCCV.click();
        page.keyboard().type(ccv);
        clickOnBayarSekarang();
        return new PaymentPO(page);
    }

    /**
     * Select payment method and direct process using dana
     * @return PaymentPO
     */
    public PaymentPO paymentUsingDANA() {
        clickOnPilihPembayaran();
        dana.click();
        clickOnBayarSekarang();
        page = page.waitForPopup(() -> {
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Bayar langsung via DANA")).click();
        });
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Proceed to Pay")).click();
        return new PaymentPO(page);
    }

    /**
     * Select payment method and direct process using Link aja
     * @return PaymentPO
     */
    public PaymentPO paymentUsingLinkAja() {
        clickOnPilihPembayaran();
        linkAja.click();
        clickOnBayarSekarang();
        page = page.waitForPopup(() -> {
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Bayar langsung via LinkAja")).click();
        });
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Proceed to Pay")).click();
        return new PaymentPO(page);
    }

    /**
     * Get per period / or basic amount price
     * @return per period price / or basic amount price as integer
     */
    public int getBasicPrice() {
        return JavaHelpers.extractNumber(playwright.getText(perDurationPriceText));
    }

    /**
     * Get admin fee
     * @return integer data type of biaya Layanan Mamikos
     */
    public int getAdminPrice(){
        return JavaHelpers.extractNumber(playwright.getText(biayaLayananMamikosText));
    }

    /**
     * get full text of term and condition on invoice page
     * @return string
     */
    public String getTnCInvoiceFullText() {
        return tncInvoiceFullText.innerText();
    }

    /**
     * click term and condition on invoice
     */
    public void clickTnCInvoice() {
        tncInvoiceText.click();
    }

    /**
     * Click MamiPoin Toggle Button to On
     */
    public void clickMamipoinToggleButtonToOn() {
        playwright.hardWait(3000.0);
        if (playwright.waitTillLocatorIsVisible(mamipoinToggleButtonOn)) {
            playwright.clickOn(mamipoinToggleButtonOn);
        } else {
            playwright.clickOn(mamipoinToggleButtonOff);
            playwright.hardWait(3000.0);
            playwright.clickOn(mamipoinToggleButtonOn);
            playwright.hardWait(3000.0);
        }
    }

    /**
     * Click MamiPoin Toggle Button to Off
     */
    public void clickMamipoinToggleButtonToOff() {
        if (playwright.waitTillLocatorIsVisible(mamipoinToggleButtonOff)) {
            playwright.clickOn(mamipoinToggleButtonOff);
        } else {
            playwright.clickOn(mamipoinToggleButtonOn);
            playwright.hardWait(3000.0);
            playwright.clickOn(mamipoinToggleButtonOff);
        }
    }

    /**
     * Check if Point Estimate is not visible on invoice
     */
    public Boolean isPointEstimateTenantVisible() {
        playwright.hardWait(3000.0);
        return tenantPointEstimate.isVisible();
    }

    /**
     * return discount mamipoin text
     *
     * @return int data type
     */
    public int getDiscountMamipoinText() {
        return JavaHelpers.extractNumber(playwright.getText(discountMamipoinText));
    }

    /**
     * Click on the "pakai voucher" button
     */
    public boolean isVoucherSuggestionEmptyStateVisible() {
        String xpathLocator = "//div[@class='box-empty__title']";
        return page.querySelector(xpathLocator).isVisible();
    }
}
