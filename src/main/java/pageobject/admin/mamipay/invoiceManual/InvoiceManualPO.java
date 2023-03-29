package pageobject.admin.mamipay.invoiceManual;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import data.mamikos.Mamikos;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class InvoiceManualPO {

    private Page page;

    // Invoice List Page
    private Locator buatInvoiceButton;
    private Locator paginationButton;
    private Locator rowInvoiceData;
    private Locator lastNamaListing;
    private Locator lastJenisBiaya;
    private Locator lastTotalInvoice;
    private Locator lastStatusInvoice;
    private Locator lastInvoiceData;
    private Locator namaBiayaHover;
    private Locator jumlahBiayaHover;
    // Invoice List Page

    // Buat Invoice Page
    private Locator propertyNameText;
    private Locator propertySuggestionText;
    private Locator tenantNameText;
    private Locator tenantNameSuggestionText;
    private Locator noHPTenantText;
    private Locator noKamarTenantText;
    private Locator biayaTambahanRadioButton;
    private Locator biayaSewaRadioButton;
    private Locator tambahBiayaButton;
    private Locator toastMessage;
    private Locator buatDanKirimButton;
    private Locator backButtonBuatInvoice;
    // Buat Invoice Page

    // Tambah Biaya Pop Up
    private Locator namaBiayaDropdown;
    private Locator namaBiayaDropdownValue;
    private Locator startDateCalendar;
    private Locator startDate;
    private Locator endDateCalendar;
    private Locator endDate;
    private Locator durasiBiayaText;
    private Locator jumlahBiayaText;
    private Locator submitBiayaButton;
    // Tambah Biaya Pop Up

    // Buat dan Kirim Pop Up
    private Locator buatDanKirimPopUpButton;
    private Locator closePopUpButton;
    private Locator kembaliPopUpButton;
    private Locator buatDanKirimModal;
    private Locator buatdanKirimPopUpTable;
    // Buat dan Kirim Pop Up

    //Exit Buat Invoice Pop Up
    private Locator titleExitBuatInvoicePopUp;
    private Locator descriptionExitBuatInvoicePopUp;
    private Locator tidakButtonExitBuatInvoicePopUp;
    private Locator yaButtonExitBuatInvoicePopUp;
    private Locator exitBuatInvoiceModal;
    //Exit Buat Invoice Pop Up
    
    public InvoiceManualPO(Page page){
        this.page = page;
        buatInvoiceButton = page.getByTestId("create-invoice-btn");
        propertyNameText = page.getByPlaceholder("Masukkan nama listing");
        tenantNameText = page.getByPlaceholder("Masukkan nama penyewa");
        propertySuggestionText = page.locator("(//a[@role='button'])[1]");
        tenantNameSuggestionText = page.locator("(//a[@role='button'])[1]");
        noHPTenantText = page.getByTestId("tenant-phone-number");
        noKamarTenantText = page.getByTestId("tenant-room-number");
        biayaTambahanRadioButton = page.getByText("Biaya Tambahan");
        biayaSewaRadioButton = page.getByText("Biaya Sewa");
        tambahBiayaButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tambah"));
        namaBiayaDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih nama biaya dropdown-down"));
        startDateCalendar = page.getByTestId("billing-modal-start-date").getByPlaceholder("Pilih tanggal di sini");
        endDateCalendar = page.getByTestId("billing-modal-end-date").getByPlaceholder("Pilih tanggal di sini");
        durasiBiayaText = page.getByPlaceholder("Contoh: 2 hari ");
        jumlahBiayaText = page.getByTestId("billing-modal-jumlah-biaya");
        submitBiayaButton = page.getByTestId("add-cost-data");
        toastMessage = page.locator(".global-toast");
        buatDanKirimButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Buat dan Kirim"));
        buatdanKirimPopUpTable = page.locator("//td");
        closePopUpButton = page.locator("//button[@class='bg-c-modal__action-closable']");
        buatDanKirimModal = page.locator(".bg-c-modal__wrapper");
        kembaliPopUpButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kembali"));
        buatDanKirimPopUpButton = page.getByRole(AriaRole.DIALOG).filter(new Locator.FilterOptions().setHasText("close Buat dan Kirim Invoice Mohon pastikan data pada invoice sudah sesuai sebel")).getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Buat dan Kirim"));
        paginationButton = page.locator("(//button[@class='bg-c-button bg-c-pagination__item bg-c-button--tertiary bg-c-button--sm'])");
        rowInvoiceData = page.locator("//tbody/tr");
        backButtonBuatInvoice = page.getByRole(AriaRole.IMG).filter(new Locator.FilterOptions().setHasText("back"));
        exitBuatInvoiceModal = page.locator("//*[@class='bg-c-modal__inner']");
        titleExitBuatInvoicePopUp = page.locator("//*[@class='bg-c-modal__body-title']");
        descriptionExitBuatInvoicePopUp = page.locator("//*[@class='bg-c-modal__body-description']");
        tidakButtonExitBuatInvoicePopUp = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tidak"));
        yaButtonExitBuatInvoicePopUp = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ya"));
    }

    /**
     * Click buat invoice in Invoice Manual
     */
    public void clickBuatInvoice() {
        buatInvoiceButton.click();
    }

    /**
     * Fill listing name in Nama Listing field
     * @param listing
     */
    public void inputListingName(String listing) {
        propertyNameText.click();
        propertyNameText.fill(listing);
        propertySuggestionText.waitFor();
        propertySuggestionText.click();
    }

    /**
     * Fill tenant name in Nama Penyewa field
     * @param tenant
     */
    public void inputTenantName(String tenant) {
        tenantNameText.click();
        tenantNameText.fill(tenant);
        tenantNameSuggestionText.waitFor();
        tenantNameSuggestionText.click();
    }

    /**
     * Assert No HP Penyewa value are equal, and field is disabled
     * @param noHP
     */
    public void assertNoHPTenant(String noHP) {
        assertThat(noHPTenantText).isDisabled();
        assertThat(noHPTenantText).hasValue(noHP);
    }

    /**
     * Assert No Kamar value are equal, and field is disabled
     * @param noKamar
     */
    public void assertNoKamarTenant(String noKamar) {
        assertThat(noKamarTenantText).isDisabled();
        assertThat(noKamarTenantText).hasValue(noKamar);
    }

    /**
     * Select jenis invoice
     * @param type (Biaya Tambahan / Biaya Sewa)
     */
    public void selectJenisInvoice(String type) {
        if (type.equalsIgnoreCase("Biaya Tambahan")){
            biayaTambahanRadioButton.click();
        }else if (type.equalsIgnoreCase("Biaya Sewa")){
            biayaSewaRadioButton.click();
        }
    }

    /**
     * Click Tambah Biaya to add Biaya Tambahan / Sewa
     */
    public void tambahBiayaButton() {
        tambahBiayaButton.click();
    }

    /**
     * Select nama biaya in Pop Up Tambah Biaya
     * @param namaBiaya
     */
    public void setNamaBiayaInvoiceManual(String namaBiaya) {
        namaBiayaDropdownValue = page.locator("//div[@class='bg-c-dropdown']//li[contains(.,'"+namaBiaya+"')]");

        namaBiayaDropdown.click();
        namaBiayaDropdownValue.click();
    }

    /**
     * Select date periode awal in Pop Up Tambah Biaya
     * @param periodeAwal
     */
    public void setPeriodeAwalInvoiceManual(String periodeAwal) {
        if (periodeAwal.equalsIgnoreCase("today")){
            //get today date
            SimpleDateFormat today = new SimpleDateFormat("d");
            Date dates = new Date();
            startDate = page.locator("//span[@class='cell day today'][contains(., '" +today.format(dates)+ "')]").nth(0);
        } else if (periodeAwal.equalsIgnoreCase("tomorrow")) {
            //get tomorrow date
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, 1);
            Date dt = calendar.getTime();
            SimpleDateFormat tomorrow = new SimpleDateFormat("d");
            startDate = page.locator("//span[@class='cell day today']/parent::div/following-sibling::*[contains(., '" +tomorrow.format(dt)+ "')]");
        } else {
            startDate = page.getByTestId("billing-modal-start-date").getByText(periodeAwal);
        }

        startDateCalendar.click();
        startDate.click();
    }

    /**
     * Select date periode akhir in Pop Up Tambah Biaya
     * @param periodeAkhir
     */
    public void setPeriodeAkhirInvoiceManual(String periodeAkhir) {
        if (periodeAkhir.equalsIgnoreCase("today")){
            //get today date
            SimpleDateFormat today = new SimpleDateFormat("d");
            Date dates = new Date();
            endDate = page.locator("//span[@class='cell day today'][contains(., '" +today.format(dates)+ "')]").nth(1);
        } else if (periodeAkhir.equalsIgnoreCase("tomorrow")) {
            //get tomorrow date
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, 1);
            Date dt = calendar.getTime();
            SimpleDateFormat tomorrow = new SimpleDateFormat("d");
            endDate = page.locator("//span[@class='cell day today']/parent::div/following-sibling::*[contains(., '" +tomorrow.format(dt)+ "')]");
        } else {
            endDate = page.getByTestId("billing-modal-end-date").getByText(periodeAkhir);
        }

        endDateCalendar.click();
        endDate.click();
    }

    /**
     * Fill durasi biaya in Pop Up Tambah Biaya
     * @param durasiBiaya
     */
    public void setDurasiBiayaInvoiceManual(String durasiBiaya) {
        durasiBiayaText.fill(durasiBiaya);
    }

    /**
     * Fill jumlah biaya in Pop Up Tambah Biaya
     * @param jumlahBiaya
     */
    public void setJumlahBiayaInvoiceManual(String jumlahBiaya) {
        jumlahBiayaText.fill(jumlahBiaya);
    }

    /**
     * Submit biaya and assert toast message
     * @param type (Biaya Tambahan / Biaya Sewa)
     */
    public void submitBiayaInvoiceManual(String type) {
        submitBiayaButton.click();
        toastMessage.waitFor();
        if (type.equalsIgnoreCase("Biaya Tambahan")){
            assertThat(toastMessage).hasText("Biaya Tambahan berhasil ditambahkan");
        } else if (type.equalsIgnoreCase("Biaya Sewa")) {
            assertThat(toastMessage).hasText("Biaya Sewa berhasil ditambahkan");
        }
    }

    /**
     * Click Buat dan Kirim button
     */
    public void previewBuatdanKirimInvoiceManual() {
        buatDanKirimButton.click();
    }

    /**
     * Assert nama biaya in Buat dan Kirim pop up
     * @param namaBiaya
     * @param type (Biaya Tambahan / Biaya Sewa)
     */
    public void assertNamaBiayaInPreviewBuatDanKirim(String namaBiaya, String type) {
        if (type.equalsIgnoreCase("Biaya Tambahan")){
            assertThat(buatdanKirimPopUpTable.nth(6)).hasText(namaBiaya);
        } else if (type.equalsIgnoreCase("Biaya Sewa"))
            assertThat(buatdanKirimPopUpTable.nth(5)).hasText(namaBiaya);
    }

    /**
     * Assert periode awal in Buat dan Kirim pop up
     * @param periodeAwal
     * @param type (Biaya Tambahan / Biaya Sewa)
     */
    public void assertPeriodeAwalInPreviewBuatDanKirim(String periodeAwal,String type) {
        if (periodeAwal.equalsIgnoreCase("today")){
            //get today
            SimpleDateFormat today = new SimpleDateFormat("dd/MM/yyyy");
            Date dates = new Date();

            if (type.equalsIgnoreCase("Biaya Tambahan")){
                assertThat(buatdanKirimPopUpTable.nth(7)).hasText(today.format(dates));
            } else if (type.equalsIgnoreCase("Biaya Sewa")) {
                assertThat(buatdanKirimPopUpTable.nth(6)).hasText(today.format(dates));

            }
        } else {
            //get today
            SimpleDateFormat today = new SimpleDateFormat("/MM/yyyy");
            Date dates = new Date();

            if (type.equalsIgnoreCase("Biaya Tambahan")){
                assertThat(buatdanKirimPopUpTable.nth(7)).hasText(periodeAwal+today.format(dates));
            } else if (type.equalsIgnoreCase("Biaya Sewa")) {
                assertThat(buatdanKirimPopUpTable.nth(6)).hasText(periodeAwal+today.format(dates));
            }
        }
    }

    /**
     * Assert periode akhir in Buat dan Kirim pop up
     * @param periodeAkhir
     * @param type (Biaya Tambahan / Biaya Sewa)
     */
    public void assertPeriodeAkhirInPreviewBuatDanKirim(String periodeAkhir, String type) {
        if (periodeAkhir.equalsIgnoreCase("tomorrow")){
            //get tomorrow
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, 1);
            SimpleDateFormat tomorrow = new SimpleDateFormat("dd/MM/yyyy");
            Date dt = calendar.getTime();

            if (type.equalsIgnoreCase("Biaya Tambahan")){
                assertThat(buatdanKirimPopUpTable.nth(8)).hasText(tomorrow.format(dt));
            } else if (type.equalsIgnoreCase("Biaya Sewa")) {
                assertThat(buatdanKirimPopUpTable.nth(7)).hasText(tomorrow.format(dt));
            }
        } else {
            //get today
            SimpleDateFormat today = new SimpleDateFormat("/MM/yyyy");
            Date dates = new Date();

            if (type.equalsIgnoreCase("Biaya Tambahan")){
                assertThat(buatdanKirimPopUpTable.nth(8)).hasText(periodeAkhir+today.format(dates));
            } else if (type.equalsIgnoreCase("Biaya Sewa")) {
                assertThat(buatdanKirimPopUpTable.nth(7)).hasText(periodeAkhir+today.format(dates));
            }
        }
    }

    /**
     * Assert julah biaya in Buat dan Kirim pop up
     * @param jumlahBiaya
     * @param type (Biaya Tambahan / Biaya Sewa)
     */
    public void assertJumlahBiayaInPreviewBuatDanKirim(String jumlahBiaya, String type) {
        if (type.equalsIgnoreCase("Biaya Tambahan")){
            assertThat(buatdanKirimPopUpTable.nth(9)).hasText(jumlahBiaya);
        } else if (type.equalsIgnoreCase("Biaya Sewa")) {
            assertThat(buatdanKirimPopUpTable.nth(8)).hasText(jumlahBiaya);
        }
    }

    /**
     * Assert disburse to pemilik in Buat dan Kirim pop up
     * @param disburseToPemilik
     * @param type (Biaya Tambahan / Biaya Sewa)
     */
    public void assertDisburseToPemilikInPreviewBuatDanKirim(String disburseToPemilik,String type) {
        if (!disburseToPemilik.equalsIgnoreCase("-")){
            if (type.equalsIgnoreCase("Biaya Tambahan")){
                assertThat(buatdanKirimPopUpTable.nth(10)).hasText(disburseToPemilik);
            } else if (type.equalsIgnoreCase("Biaya Sewa")) {
                assertThat(buatdanKirimPopUpTable.nth(9)).hasText(disburseToPemilik);
            }
        }
    }

    /**
     * Assert Buat dan Kirim Pop up is not visible
     */
    public void assertPopUpInInvoiceManual() {
        assertThat(buatDanKirimModal).isHidden();
    }

    /**
     * Click Kembali button in Buat dan Kirim pop up
     */
    public void kembaliPopupButton() {
        kembaliPopUpButton.click();
    }

    /**
     * Click Buat dan Kirim button in Buat dan Kirim pop up
     */
    public void confirmPopUpBuatDanKirim() {
        buatDanKirimPopUpButton.click();
    }

    /**
     * Navigate to last page Invoice Manual
     */
    public void goToLastPageInvoiceManual() {
        paginationButton.nth(2).click();
    }

    /**
     * Assert last listing name in Invoice Manual List
     * @param namaListing
     */
    public void assertNewNamaListing(String namaListing) {
        lastNamaListing = page.locator("((//tbody/tr)["+rowInvoiceData.all().size()+"]/td)[3]");
        assertThat(lastNamaListing).hasText(namaListing);
    }

    /**
     * Assert last Jenis Invoice in Invoice Manual List
     * @param type
     */
    public void assertNewJenisInvoice(String type) {
        lastJenisBiaya = page.locator("((//tbody/tr)["+rowInvoiceData.all().size()+"]/td)[4]//a");
        assertThat(lastJenisBiaya).hasText(type);
    }

    /**
     * Assert last Total Invoice in Invoice Manual List
     * @param jumlahBiaya
     */
    public void assertNewTotalInvoice(String jumlahBiaya) {
        lastTotalInvoice = page.locator("((//tbody/tr)["+rowInvoiceData.all().size()+"]/td)[5]");
        assertThat(lastTotalInvoice).hasText(jumlahBiaya);
    }

    /**
     * Assert last Status Invoice in Invoice Manual List
     * @param statusInvoice
     */
    public void assertNewStatusInvoice(String statusInvoice) {
        lastStatusInvoice = page.locator("((//tbody/tr)["+rowInvoiceData.all().size()+"]/td)[6]//div");
        assertThat(lastStatusInvoice).hasText(statusInvoice);
    }

    /**
     * Hover last Jenis Biaya in Invoice Manual List
     */
    public void hoverLastInvoiceData() {
        lastInvoiceData = page.locator("((//tbody/tr)["+rowInvoiceData.all().size()+"]/td)[4]");
        lastInvoiceData.scrollIntoViewIfNeeded();
        lastInvoiceData.hover();
    }

    /**
     * Assert nama biaya in Jenis Biaya tooltips
     * @param namaBiaya
     */
    public void assertNamaBiayaHover(String namaBiaya) {
        namaBiayaHover = page.locator("((//tbody/tr)["+rowInvoiceData.all().size()+"]/td)[4]//p").nth(1);
        assertThat(namaBiayaHover).hasText(namaBiaya);
    }

    /**
     * Assert jumlah biaya in Jenis Biaya tooltips
     * @param jumlahBiaya
     */
    public void assertJumlahBiayaHover(String jumlahBiaya) {
        jumlahBiayaHover = page.locator("((//tbody/tr)["+rowInvoiceData.all().size()+"]/td)[4]//p").nth(2);
        assertThat(jumlahBiayaHover).hasText(jumlahBiaya);
    }

    /**
     * click back button in buat invoice page
     */
    public void clickBackButtonBuatInvoice() {
        backButtonBuatInvoice.click();
    }

    /**
     * Assert title in Exit confirmation Buat Invoice Pop Up
     */
    public void assertExitBuatInvoicePopUpTitle() {
        assertThat(titleExitBuatInvoicePopUp).hasText("Yakin keluar dari halaman ini?");
    }

    /**
     * Assert description in Exit confirmation Buat Invoice Pop Up
     */
    public void assertExitBuatInvoicePopUpDescription() {
        assertThat(descriptionExitBuatInvoicePopUp).hasText("Invoice yang dibuat tidak akan tersimpan dan tidak dapat dikembalikan.");
    }

    /**
     * Assert button in Exit confirmation Buat Invoice Pop Up
     */
    public void assertExitBuatInvoicePopUpButton() {
        assertThat(tidakButtonExitBuatInvoicePopUp).hasText("Tidak");
        assertThat(yaButtonExitBuatInvoicePopUp).hasText("Ya");
    }

    /**
     * click tidak in Exit confirmation Buat Invoice Pop Up
     */
    public void cancelExitBuatInvoice() {
        tidakButtonExitBuatInvoicePopUp.click();
    }

    /**
     * Assert is confirmation Buat Invoice Pop Up closed ?
     */
    public void assertExitInvoicePopUpClosed() {
        assertThat(exitBuatInvoiceModal).isHidden();
    }

    /**
     * Assert is confirmation Buat Invoice Pop Up appear ?
     */
    public void assertExitInvoicePopUpAppear() {
        assertThat(exitBuatInvoiceModal).isVisible();
    }

    /**
     * click ya in Exit confirmation Buat Invoice Pop Up
     */
    public void confirmExitBuatInvoice() {
        yaButtonExitBuatInvoicePopUp.click();
    }

    /**
     * Assert URL is equal to Invoice Manual URL
     */
    public void assertURLInvoiceManual() {
        if (Mamikos.ENV.equalsIgnoreCase("stag")){
            assertThat(page).hasURL("https://pay-jambu.kerupux.com/backoffice/invoice/manual");
        } else if (Mamikos.ENV.equalsIgnoreCase("prod")) {
            assertThat(page).hasURL("https://bang-pay.kerupux.com/backoffice/invoice/manual");
        }
    }

    //---Biaya Tambahan---//
    /**
     * Click Jenis Invoice - Biaya Tambahan
     */
    public void clickJenisBiayaTambahan() {
        biayaTambahanRadioButton.click();
    }

    /**
     * Click Tambah button in Buat Invoice page
     */
    public void clickTambah() {
        tambahBiayaButton.click();
    }

    /**
     * Assert period start date and period end date are disable
     */
    public void assertPeriodDate(){
        assertThat(startDateCalendar).isDisabled();
        assertThat(endDateCalendar).isDisabled();
    }

    /**
     * Click close (X) button in Invoice Manual pop up
     */
    public void clickClosePopUp() {
        closePopUpButton.click();
    }
    //---End of Biaya Tambahan---//
}
