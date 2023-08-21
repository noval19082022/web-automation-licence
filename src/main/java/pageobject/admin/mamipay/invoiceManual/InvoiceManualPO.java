package pageobject.admin.mamipay.invoiceManual;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
    private Locator invoiceNumberLast;
    // Invoice List Page

    // Invoice Detail Page
    private Locator jenisPembayaran;
    private Locator totalPembayaranOnLeftSide;
    private Locator listingName;
    private Locator jnsBiayaOnRincianPmbayaran;
    private Locator namaBiayaOnRincianPmbayaran;
    private Locator totalPembayaranOnRightSide;
    // Invoice Detail Page

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
    private Locator deleteInvManual;
    private Locator cancelDeleteInvManual;
    private Locator deleteBtnOnConfirmationDelete;
    private Locator emptyStateBiayaTambahan;
    private Locator emptyStateBiayaSewa;
    private Locator namaBiayaOnTable;
    private Locator awalPeriodOnTable;
    private Locator akhirPeriodOnTable;
    private Locator jumlahBiayaOnTable;
    private Locator disburseToPemilikOnTable;
    private Locator namaBiayaTableList;
    private Locator actionBtn;
    private Locator deleteActionBtn;
    private Locator cancelOnDelConfirmation;
    private Locator deleteOnDelConfirmation;
    private Locator editInvManBtn;
    private Locator popUpChangeInvConfirmTitle;
    private Locator popUpChangeInvConfirmSubtitle;
    private Locator batalBtnOnChangeInvConfirmation;
    private Locator lanjutkanBtnOnChangeInvConfirmation;
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
    private Locator namaBiayaErrMsg;
    private Locator periodeAwalErrMsg;
    private Locator periodeAkhirErrMsg;
    private Locator jumlahBiayaErrMsg;
    private Locator lainnyaField;
    private Locator errMsgLainnya;
    private Locator durasiBiayachar;
    private Locator counterText;
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

    //---Edit Invoice Manual Pop Up---//
    private Locator namaBiayaDropdownEdit;
    //---Edit Invoice Manual Pop Up---//
    
    public InvoiceManualPO(Page page){
        this.page = page;

        //---Invoice List Page---//
        buatInvoiceButton = page.getByTestId("create-invoice-btn");
        paginationButton = page.locator("(//button[@class='bg-c-button bg-c-pagination__item bg-c-button--tertiary bg-c-button--sm'])");
        rowInvoiceData = page.locator("//tbody/tr");
        invoiceNumberLast = page.locator("td > .bg-c-link ").last();

        //---Invoice Detail Page---//
        listingName = page.getByText("Kost Apik Khusus Automation PMAN Tipe A Halmahera Utara");
        namaBiayaOnRincianPmbayaran = page.getByText("Parkir Mobil (3 hari)");
        totalPembayaranOnRightSide = page.locator("//div[@class='invoice-detail-row-section']//p)[4]");

        //---Buat Invoice Page---//
        backButtonBuatInvoice = page.getByRole(AriaRole.IMG).filter(new Locator.FilterOptions().setHasText("back"));
        propertyNameText = page.getByPlaceholder("Masukkan nama listing");
        tenantNameText = page.getByPlaceholder("Masukkan nama penyewa");
        propertySuggestionText = page.locator("(//a[@role='button'])[1]");
        tenantNameSuggestionText = page.locator("(//a[@role='button'])[1]");
        noHPTenantText = page.getByTestId("tenant-phone-number");
        noKamarTenantText = page.getByTestId("tenant-room-number");
        biayaTambahanRadioButton = page.getByText("Biaya Tambahan");
        biayaSewaRadioButton = page.getByText("Biaya Sewa");
        tambahBiayaButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tambah"));
        deleteInvManual = page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText("delete"));
        cancelDeleteInvManual = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Batal"));
        deleteBtnOnConfirmationDelete = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hapus"));
        emptyStateBiayaTambahan = page.getByText("Belum ada biaya tambahan");
        emptyStateBiayaSewa = page.getByText("Belum ada biaya sewa");
        awalPeriodOnTable = page.locator("(//td)[2]");
        akhirPeriodOnTable = page.locator("(//td)[3]");
        actionBtn = page.getByText("edit delete");
        deleteActionBtn = page.locator("((//div[@class='action-button'])[1]/button)[2]");
        cancelOnDelConfirmation = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Batal"));
        deleteOnDelConfirmation = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hapus"));
        editInvManBtn = page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText("edit"));
        popUpChangeInvConfirmTitle = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Yakin ingin mengganti jenis invoice ini?"));
        popUpChangeInvConfirmSubtitle = page.getByText("Anda hanya dapat memilih 1 jenis invoice. Perubahan jenis invoice akan menghapus");
        batalBtnOnChangeInvConfirmation = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Batal"));
        lanjutkanBtnOnChangeInvConfirmation = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lanjutkan"));

        //---Tambah Biaya Pop Up---//
        namaBiayaDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih nama biaya"));
        startDateCalendar = page.getByTestId("billing-modal-start-date").getByPlaceholder("Pilih tanggal di sini");
        endDateCalendar = page.getByTestId("billing-modal-end-date").getByPlaceholder("Pilih tanggal di sini");
        durasiBiayaText = page.getByPlaceholder("Contoh: 2 hari ");
        jumlahBiayaText = page.getByTestId("billing-modal-jumlah-biaya");
        submitBiayaButton = page.getByTestId("add-cost-data");
        toastMessage = page.locator(".global-toast");
        namaBiayaErrMsg = page.getByText("Nama biaya tidak boleh kosong.");
        periodeAwalErrMsg = page.getByText("Periode awal tidak boleh kosong.");
        periodeAkhirErrMsg = page.getByText("Periode akhir tidak boleh kosong.");
        jumlahBiayaErrMsg = page.getByText("Jumlah biaya tidak boleh kosong.");
        lainnyaField = page.locator("//input[@data-testid='billing-modal-nama-biaya']");
        errMsgLainnya = page.getByTestId("error-message");

        //---Buat dan Kirim Pop Up---//
        buatDanKirimButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Buat dan Kirim"));
        buatdanKirimPopUpTable = page.locator("//td");
        closePopUpButton = page.locator("//button[@class='bg-c-modal__action-closable']");
        buatDanKirimModal = page.locator(".bg-c-modal__wrapper");
        kembaliPopUpButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kembali"));
        buatDanKirimPopUpButton = page.getByRole(AriaRole.DIALOG).filter(new Locator.FilterOptions().setHasText("Buat dan Kirim Invoice")).getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Buat dan Kirim"));

        //---Exit Buat Invoice Pop Up---//
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
            startDate = page.locator("(//span[@class='cell day today']/parent::div/following-sibling::*[contains(., '" +tomorrow.format(dt)+ "')])[1]");
        } else if (periodeAwal.equalsIgnoreCase("edit for tomorrow")) {
            //get tomorrow date
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, 1);
            Date dt = calendar.getTime();
            SimpleDateFormat tomorrow = new SimpleDateFormat("d");
            startDate = page.locator("(//span[@class='cell day selected today']/parent::div/following-sibling::*[contains(., '" +tomorrow.format(dt)+ "')])[1]");
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
            endDate = page.locator("//span[@class='cell day today'][contains(text(),'"+today.format(dates)+"')]");
        } else if (periodeAkhir.equalsIgnoreCase("tomorrow")) {
            //get tomorrow date
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, 1);
            Date dt = calendar.getTime();
            SimpleDateFormat tomorrow = new SimpleDateFormat("d");
            endDate = page.locator("(//span[@class='cell day today']/parent::div/following-sibling::*[contains(., '" +tomorrow.format(dt)+ "')])[1]");
        } else if (periodeAkhir.equalsIgnoreCase("day after tomorrow")) {
            //get day after tomorrow
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, 2);
            Date dt = calendar.getTime();
            SimpleDateFormat tomorrow = new SimpleDateFormat("d");
            endDate = page.locator("(//span[@class='cell day disabled today']/parent::div/following-sibling::*[contains(., '" +tomorrow.format(dt)+ "')])[1]");
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

    /**
     * Assert Change Invoice Confirmation Title
     * @param title
     */
    public void assertChangeInvConfirmationTitle(String title) {
        assertThat(popUpChangeInvConfirmTitle).hasText(title);
    }

    /**
     * Assert Change Invoice Confirmation Subtitle
     * @param subtitle
     */
    public void assertChangeInvConfirmationSubtitle(String subtitle){
        assertThat(popUpChangeInvConfirmSubtitle).hasText(subtitle);
    }

    /**
     * Click Batal button on Change Invoice Confirmation
     */
    public void clickBatalOnChangeInvConfirmation(){
        batalBtnOnChangeInvConfirmation.click();
    }

    /**
     * Click Lanjutkan button on Change Invoice Confirmation
     */
    public void clickLanjutkanOnChangeInvConfirmation(){
        lanjutkanBtnOnChangeInvConfirmation.click();
    }

    /**
     * Assert Change Invoice Confirmation Pop Up
     */
    public void changeInvConfirmationPopUpIsNotDisplay(){
        assertThat(popUpChangeInvConfirmTitle).isHidden();
    }

    /**
     * clicks Last Invoice Number
     * @return invoice number
     */
    public Page clickInvoiceNumber(){
        page = page.waitForPopup(() -> {invoiceNumberLast.click();});
        ActiveContext.setActivePage(page);
        return ActiveContext.getActivePage();
    }

    /**
     * assert Jenis Pembayaran on Detail Invoice Page
     * @param invType
     */
    public void assertJenisPembayaran(String invType){
        jenisPembayaran = page.locator("#invoiceBill").getByText(invType);
        assertThat(jenisPembayaran);
        System.out.println(jenisPembayaran);
    }

    /**
     * assert Total Pembayaran on Left Side on Detail Invoice Page
     */
    public void assertTotalPembayaranOnLeftSide(){
        totalPembayaranOnLeftSide = page.locator("#invoiceBill").getByText("Rp25.000");
        assertThat(totalPembayaranOnLeftSide);
        System.out.println(totalPembayaranOnLeftSide);
    }

    /**
     * assert Listing Name on Detail Invoice Page
     */
    public void assertListingName(){
        assertThat(listingName);
        System.out.println(listingName);
    }

    /**
     * assert Jenis Biaya on Rincian Pembayaran at Detail Invoice Page
     * @param invType
     */
    public void assertJenisBiayaOnRincianPembayaran(String invType){
        jnsBiayaOnRincianPmbayaran = page.getByTestId("invoiceBillingDetails-payment").getByText(invType);
        assertThat(jnsBiayaOnRincianPmbayaran);
        System.out.println(jnsBiayaOnRincianPmbayaran);
    }

    /**
     * assert Nama Biaya on Rincian Pembayaran at Detail Invoice Page
     */
    public void assertNamaBiayaOnRincianPembayaran(){
        assertThat(namaBiayaOnRincianPmbayaran);
        System.out.println(namaBiayaOnRincianPmbayaran);
    }

    /**
     * assert Total Pembayaran on Right Side at Detail Invoice Page
     */
    public void assertTotalPembayaranOnRightSide(){
        assertThat(totalPembayaranOnRightSide);
        System.out.println(totalPembayaranOnRightSide);
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

    /**
     * Click Jenis Invoice - Biaya Sewa
     */
    public void clickJenisBiayaSewa(){
        biayaSewaRadioButton.click();
    }

    /**
     * Click Tambah / submit in Pop Up Biaya Tambahan/Sewa
     */
    public void clickTambahSubmitInPopUp(){
        submitBiayaButton.click();
    }

    /**
     * Assert Nama Biaya Error Message
     */
    public void assertNamaBiayaErrMsg() {
        assertThat(namaBiayaErrMsg).hasText("Nama biaya tidak boleh kosong.");
    }

    /**
     * Assert Periode Awal Error Message
     */
    public void assertPeriodeAwalErrMsg() {
        assertThat(periodeAwalErrMsg).hasText("Periode awal tidak boleh kosong.");
    }

    /**
     * Assert Periode Akhir Error Message
     */
    public void assertPeriodeAkhirErrMsg() {
        assertThat(periodeAkhirErrMsg).hasText("Periode akhir tidak boleh kosong.");
    }

    /**
     * Assert Jumlah Biaya Error Message
     */
    public void assertJumlahBiayaErrMsg(){
        assertThat(jumlahBiayaErrMsg).hasText("Jumlah biaya tidak boleh kosong.");
    }

    /**
     * click Delete on trash icon in Buat Invoice page
     * and click Batal on Delete Confirmation
     * and click Delete on trash icon again
     * and click Hapus on Delete Confirmation
     */
    public void clickDeleteInvManual() {
        //click delete on Trash Icon
        deleteInvManual.click();
        //click Batal on Delete Confirmation
        cancelDeleteInvManual.click();
        //click delete on Trash Icon again
        deleteInvManual.click();
        //click Hapus on Delete Confirmation
        deleteBtnOnConfirmationDelete.click();
    }

    /**
     * Assert empty state on Biaya Tambahan table
     */
    public void assertEmptyStateBiayaTambahan() {
        assertThat(emptyStateBiayaTambahan).hasText("Belum ada biaya tambahan");
    }

    /**
     * Assert empty state on Biaya Sewa table
     */
    public void assertEmptyStateBiayaSewa() {
        assertThat(emptyStateBiayaSewa).hasText("Belum ada biaya sewa");
    }

    /**
     * Input value in Lainnya field
     * @param lainnya
     */
    public void setLainnyaInvoiceManual(String lainnya) {
        lainnyaField.fill(lainnya);
    }

    /**
     * Assert Nama Biaya on table
     * @param nama
     */
    public void assertNamaBiayaOnTable(String nama) {
        namaBiayaOnTable = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(nama));
        assertThat(namaBiayaOnTable).hasText(nama);
    }

    /**
     * Assert Awal Periode on table
     */
    public void assertAwalPeriodOnTable() {
        assertThat(awalPeriodOnTable);
    }

    /**
     * Assert Akhir Periode on table
     */
    public void assertAkhirPeriodOnTable() {
        assertThat(akhirPeriodOnTable);
    }

    /**
     * Assert Jumlah Biaya on table
     * @param jml
     */
    public void assertJumlahBiayaOnTable(String jml) {
        jumlahBiayaOnTable = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(jml));
        assertThat(jumlahBiayaOnTable);
    }

    /**
     * Assert Disburse to Pemilik on table
     * @param disburse
     */
    public void assertDisburseToPemilikOnTable(String disburse) {
        disburseToPemilikOnTable = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(disburse));
        assertThat(disburseToPemilikOnTable);
    }

    /**
     * Assert Nama Biaya tambahan in specific row
     * @param row
     */
    public void assertNamaBiayaInRow(int row) {
        int index = 6*(row-1);
        namaBiayaTableList = page.locator("(//td)["+index+"]");
        assertThat(namaBiayaTableList);
    }

    /**
     * Assert Nama Biaya on Table list
     * @param namaBiayaTable
     */
    public void assertNamaBiayaTableList(String namaBiayaTable) {
        namaBiayaOnTable = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(namaBiayaTable));
        assertThat(namaBiayaOnTable).hasText(namaBiayaTable);
    }

    /**
     * Delete all biaya sewa/tambahan
     * Check if the delete button on biaya table appears
     * Then do delete biaya
     * If the delete button on biaya table not appears
     * Then stop delete and return empty state on biaya table
     */
    public void deleteAllBiaya() {
        int i;
        for (i=0; i<=3; i++){
            if (isDeleteBiayaVisible()){
                deleteActionBtn.click();
                cancelOnDelConfirmation.click();
                deleteActionBtn.click();
                deleteOnDelConfirmation.click();
            } else {
                break;
            }
        }
    }

    /**
     * Check if the delete confirmation pop is visible
     * @return String delete confirmation pop is visible
     */
    public boolean isDeleteBiayaVisible(){
        return actionBtn != null;
    }

    /**
     * Click Edit Invoice Manual
     */
    public void clickEditInvoice() {
        editInvManBtn.click();
    }

    /**
     * Choose nama biaya for edit
     * @param namaBiaya
     */
    public void setEditNamaBiayaInvoiceManual(String namaBiaya) {
        namaBiayaDropdownEdit = page.locator("//div[@data-testid='billing-modal-jenis-biaya']");
        namaBiayaDropdownValue = page.locator("//div[@class='bg-c-dropdown']//li[contains(.,'"+namaBiaya+"')]");

        namaBiayaDropdownEdit.click();
        namaBiayaDropdownValue.click();
    }

    /**
     * Clear durasi biaya
     */
    public void clearDurasiBiayaInvoiceManual() {
        durasiBiayaText.clear();
    }

    /**
     * Set Nama Biaya for Lainnya
     */
    public void setNamaBiayaLainnyaInvoiceManual() {
        namaBiayaDropdownValue = page.locator("//div[@class='bg-c-dropdown']//li[contains(.,'Lainnya')]");

        namaBiayaDropdown.click();
        namaBiayaDropdownValue.click();
    }

    /**
     * Assert Error Message on Lainnya Nama Biaya
     * @param error
     */
    public void assertErrMsgLainnya(String error) {
        assertThat(errMsgLainnya).hasText(error);
    }

    /**
     * Clear Lainnya field
     */
    public void clearLainnyaField() {
        lainnyaField.clear();
    }

    /**
     * Assert Durasi Biaya
     * @param char255
     */
    public void assertDurasiBiaya(String char255) {
        durasiBiayachar = page.getByPlaceholder("Contoh: 2 hari ");
        assertThat(durasiBiayachar).hasValue(char255);
    }

    /**
     * Assert counter text
     * @param counter
     */
    public void assertCounterTxt(String counter) {
        counterText = page.getByText("255 / 255");
        assertThat(counterText).hasText(counter);
    }
    //---End of Biaya Tambahan---//
}
