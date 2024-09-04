package pageobject.admin.mamipay.invoiceManual;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import utilities.PlaywrightHelpers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class InvoiceManualPO {

    private Page page;
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);

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
    private Locator searchBar;
    private Locator searchBtn;
    private Locator noInvoiceCol;
    private Locator detailPenyewaCol;
    private Locator namaListingCol;
    private Locator searchDropDown;
    private Locator selectSearchBy;
    private Locator notFound;
    private Locator clearSearchValue;
    private Locator dibuatOlehCol;
    private Locator kebabBtn;
    private Locator ubahStatusBtn;
    private Locator statusInvCol;
    private Locator lastInvoiceNumber;
    // Invoice List Page

    //Filter Invoice Manual
    private Locator filter;
    private Locator filterTitle;
    private Locator filterSubtitle;
    private Locator statusInvTitle;
    private Locator jenisBiayaTitle;
    private Locator tanggalInvDibuat;
    private Locator tanggalMulaiTitle;
    private Locator tanggalAkhirTitle;
    private Locator closeFilterBtn;
    private Locator terapkanBtn;
    private Locator valueStatusInv;
    private Locator resetBtn;
    private Locator counterOnFilter;
    private Locator mainResetBtn;
    private Locator statusInvDropdown;
    private Locator tickPaid;
    private Locator calViewTglMulai;
    private Locator calViewTglAkhir;
    private Locator jenisBiayaDropdown;
    private Locator tickJenisBiaya;
    private Locator valueJenisBiaya;
    //Filter Invoice Manual

    // Invoice Detail Page
    private Locator jenisPembayaran;
    private Locator totalPembayaranOnLeftSide;
    private Locator listingName;
    private Locator jnsBiayaOnRincianPmbayaran;
    private Locator namaBiayaOnRincianPmbayaran;
    private Locator durasiBiayaOnRincianPmbayaran;
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
    private Locator buatDanKirimBtnDisable;
    // Buat Invoice Page

    // Tambah Biaya Pop Up
    private Locator namaBiayaDropdown;
    private Locator namaBiayaDropdownValue;
    private Locator startDateCalendar;
    private Locator startDate;
    private Locator endDateCalendar;
    private Locator endDate;
    private Locator tambahDurasiButton;
    private Locator kurangiDurasiButton;
    private Locator satuanDurasiDropdown;
    private Locator satuanDurasiValue;
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

    //---Ubah Status Invoice---//
    private Locator kembaliBtnOnUbahStatus;
    private Locator calViewOnUbahStatus;
    private Locator timeOnUbahStatus;
    private Locator timeField;
    private Locator simpanBtnOnUbahStatus;
    private Locator ubahBtnOnUbahStatus;
    private Locator toastUbahStatus;
    //---Ubah Status Invoice---//

    public InvoiceManualPO(Page page){
        this.page = page;

        //---Invoice List Page---//
        buatInvoiceButton = page.getByTestId("create-invoice-btn");
        paginationButton = page.locator("(//button[@class='bg-c-button bg-c-pagination__item bg-c-button--tertiary bg-c-button--sm'])");
        rowInvoiceData = page.locator("//tbody/tr");
        invoiceNumberLast = page.locator("td > .bg-c-link ").last();
        searchBar = page.getByTestId("invoice-manual-filter-searchbar");
        searchBtn = page.getByTestId("invoice-manual-filter-button-apply");
        noInvoiceCol = page.locator("//tr[@data-testid='invoice-manual-item-0']/td/a").nth(0);
        detailPenyewaCol = page.locator("//tr[@data-testid='invoice-manual-item-0']/td").nth(1);
        namaListingCol = page.locator("//tr[@data-testid='invoice-manual-item-0']/td").nth(2);
        searchDropDown = page.locator("//span[@class='bg-c-select__trigger-text']");
        notFound = page.getByText("Data yang dicari tidak ditemukan");
        clearSearchValue = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("close-round"));
        dibuatOlehCol = page.locator("//tr[@data-testid='invoice-manual-item-0']/td").nth(6);
        kebabBtn = page.getByTestId("invoice-manual-action-btn");
        ubahStatusBtn = page.getByTestId("invoice-manual-change-status");
        statusInvCol = page.locator("//tr").last().locator("td").nth(5);

        //---Filter Invoice Manual---//
        filter = page.getByTestId("invoice-manual-filter-button-filter");
        filterTitle = page.getByTestId("invoice-manual-filter-modal").getByText("Filter");
        filterSubtitle = page.getByText("Silakan pilih sesuai kebutuhan anda");
        closeFilterBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("close"));
        terapkanBtn = page.getByTestId("invoice-manual-filter-modal-apply");
        resetBtn = page.getByTestId("invoice-manual-filter-modal-reset");
        counterOnFilter = page.locator("//div[@class='mr-8 bg-c-badge-counter bg-c-badge-counter--black']");
        mainResetBtn = page.getByTestId("invoice-manual-filter-button-reset");
        statusInvDropdown = page.getByTestId("invoice-manual-filter-status").getByTestId("select-checkbox");
        calViewTglMulai = page.getByTestId("invoice-manual-filter-startdate").getByPlaceholder("Pilih tanggal di sini");
        calViewTglAkhir = page.getByTestId("invoice-manual-filter-enddate").getByPlaceholder("Pilih tanggal di sini");
        jenisBiayaDropdown = page.getByTestId("invoice-manual-filter-type").getByTestId("select-checkbox");

        //---Invoice Detail Page---//
        jenisPembayaran = page.locator("#invoiceContent div p").nth(3);
        totalPembayaranOnLeftSide = page.locator("p.invoice-total-amount");
        listingName = page.locator("p.property-name");
        jnsBiayaOnRincianPmbayaran = page.locator(".collapse-content p").first();
        namaBiayaOnRincianPmbayaran = page.locator(".invoice-detail-row-section div p").first();
        durasiBiayaOnRincianPmbayaran = page.locator(".invoice-detail-row-section div p").nth(1);
        totalPembayaranOnRightSide = page.locator("p.invoice-detail-price");

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
        buatDanKirimBtnDisable = page.locator("//button[contains(., 'Buat dan Kirim')]");

        //---Tambah Biaya Pop Up---//
        namaBiayaDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih nama biaya"));
        startDateCalendar = page.getByTestId("start-period-date-0").getByPlaceholder("Pilih tanggal di sini");
        endDateCalendar = page.getByTestId("end-period-date-0").getByPlaceholder("Pilih tanggal di sini");
        tambahDurasiButton = page.getByTestId("increase-time-qty-0");
        kurangiDurasiButton = page.getByTestId("decrease-time-qty-0");
        satuanDurasiDropdown = page.getByTestId("fee-time-unit-0").first();
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
        yaButtonExitBuatInvoicePopUp = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ya").setExact(true));

        //---Ubah Status Invoice---//
        kembaliBtnOnUbahStatus = page.getByTestId("change-status-cancel");
        calViewOnUbahStatus = page.getByPlaceholder("Pilih tanggal di sini");
        timeOnUbahStatus = page.getByTestId("change-status-paid-time");
        timeField = page.locator("//*[@data-testid='change-status-paid-time']");
        simpanBtnOnUbahStatus = page.getByTestId("change-status-save");
        ubahBtnOnUbahStatus = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ubah"));
        toastUbahStatus = page.locator("//*[@class='global-toast bg-c-toast bg-c-toast--fixed']");
    }

    /**
     * Click buat invoice in Invoice Manual
     */
    public void clickBuatInvoice() {
        playwright.waitTillLocatorIsVisible(buatInvoiceButton);
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
        } else if (periodeAwal.equalsIgnoreCase("selected today")) {
            //get selected today date
            SimpleDateFormat today = new SimpleDateFormat("d");
            Date dates = new Date();
            startDate = page.locator("//span[@class='cell day selected today'][contains(., '" +today.format(dates)+ "')]").nth(0);
        } else {
            startDate = page.getByTestId("billing-modal-start-date").getByText(periodeAwal);
        }

        startDateCalendar.click();
        startDate.click();
    }

    /**
     * Fill durasi biaya in Pop Up Tambah Biaya
     * @param durasi
     * @param satuanWaktu
     */
    public void setDurasiBiayaInvoiceManual(String durasi, String satuanWaktu) {
        satuanDurasiValue = page.locator("[data-testid='fee-time-unit-0'] .bg-c-dropdown__menu-item-content",new Page.LocatorOptions().setHasText(satuanWaktu));

        for (int i=1;i<Integer.parseInt(durasi);i++){
            playwright.clickOn(tambahDurasiButton);
        }

        playwright.clickOn(satuanDurasiDropdown);
        playwright.clickOn(satuanDurasiValue);
    }

    /**
     * Fill jumlah biaya in Pop Up Tambah Biaya
     * @param jumlahBiaya
     */
    public void setJumlahBiayaInvoiceManual(String jumlahBiaya) {
        jumlahBiayaText.fill(jumlahBiaya);
    }

    /**
     * Click Buat dan Kirim button
     */
    public void previewBuatdanKirimInvoiceManual() {
        buatDanKirimButton.click();
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
     * get Nama Biaya Hover
     * @return
     */
    public String getNamaBiayaHover() {
        namaBiayaHover = page.locator("((//tbody/tr)["+rowInvoiceData.all().size()+"]/td)[4]//p").nth(0);
        return playwright.getNormalizeText(namaBiayaHover);
    }

    /**
     * get Jumlah Biaya when hover
     * @return
     */
    public String getJumlahBiayaHover() {
        jumlahBiayaHover = page.locator("((//tbody/tr)["+rowInvoiceData.all().size()+"]/td)[4]//p").nth(1);
        return playwright.getNormalizeText(jumlahBiayaHover);
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
     * Assert Buat dan Kirim button when disable
     */
    public void assertBuatDanKirimDisable(){
        assertThat(buatDanKirimBtnDisable).isDisabled();
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
     * Get Jenis Pembayaran on Detail Invoice Page
     * @return String
     */
    public String getJenisPembayaran(){
        return playwright.getText(jenisPembayaran);
    }

    /**
     * Get Total Pembayaran on Left Side on Detail Invoice Page
     * @return String
     */
    public String getTotalPembayaran(){
        return playwright.getText(totalPembayaranOnLeftSide);
    }

    /**
     * Get Listing Name on Detail Invoice Page
     * @return String
     */
    public String getListingName(){
        return playwright.getText(listingName);
    }

    /**
     * Get Jenis Biaya on Rincian Pembayaran at Detail Invoice Page
     * @return String
     */
    public String getJenisPembayaranRincian(){
        return playwright.getText(jnsBiayaOnRincianPmbayaran);
    }

    /**
     * assert Nama Biaya on Rincian Pembayaran at Detail Invoice Page
     * @return String
     */
    public String getNamaBiayaRincian(){
        return playwright.getText(namaBiayaOnRincianPmbayaran);
    }

    /**
     * Get Durasi Biaya in Rincian Pembayaran
     * @return String
     */
    public String getDurasiBiayaRincian() {
        return playwright.getText(durasiBiayaOnRincianPmbayaran);
    }

    /**
     * Get Total Pembayaran on Right Side at Detail Invoice Page
     * @return String
     */
    public String getTotalPembayaranRincian(){
        return playwright.getText(totalPembayaranOnRightSide);
    }

    /**
     * enter Search Value on the Search Bar
     * @param value
     */
    public void enterSearchValue(String value){
        searchBar.click();
        searchBar.fill(value);
        searchBtn.click();
    }

    /**
     * Get Nomor Invoice on No Invoice coloumn
     * @return String
     */
    public String getNoInvoiceFirstRow(){
        return playwright.getText(noInvoiceCol);
    }

    /**
     * Get Nama Penyewa on Detail Penyewa coloumn
     * Split the detail penyewa value
     * And get the nama penyewa only
     * @return String
     */
    public String getDetailPenyewaFirstRow(){
        String full = playwright.getText(detailPenyewaCol);
        String result = full.substring(0,24);
        System.out.println(result);
        return result;
    }

    /**
     * Get Nama Listing on Nama Listing coloumn
     * @return String
     */
    public String getNamaListingFirstRow(){
        return playwright.getText(namaListingCol);
    }

    /**
     * clicks on Search By dropdown
     * then selects Search By based on Value
     * @param searchBy
     */
    public void selectSearchBy(String searchBy){
        searchDropDown.click();
        selectSearchBy = page.locator("a").filter(new Locator.FilterOptions().setHasText(searchBy));
        selectSearchBy.click();
    }

    /**
     * assert if result is not found
     * @param result
     */
    public void assertNotFound(String result){
        assertThat(notFound).hasText(result);
    }

    /**
     * click X on search bar
     */
    public void clearSearchValue(){
        clearSearchValue.click();
    }

    /**
     * clicks Kebab button on Action coloumn
     */
    public void clicksKebabBtn(){
        playwright.clickOn(kebabBtn.last());
    }

    /**
     * clicks Ubah Status button
     */
    public void clicksUbahStatus(){
        playwright.clickOn(ubahStatusBtn.last());
    }

    /**
     * clicks Kembali button on Ubah Status Invoice pop up
     */
    public void clicksKembaliOnUbahStatus(){
        playwright.clickOn(kembaliBtnOnUbahStatus);
    }

    /**
     * clicks Calendar View on Ubah Status Invoice pop up
     */
    public void clicksCalViewOnUbahStatus(){
        playwright.clickOn(calViewOnUbahStatus);
    }

    /**
     * set Time on Ubah Status Invoice
     * @param time
     */
    public void setTimeOnUbahStatus(String time){
        playwright.fillCharacterByCharacter(timeField, time);
    }

    /**
     * clicks Simpan on Ubah Status Invoice
     */
    public void  clicksSimpanOnUbahStatus(){
        playwright.clickOn(simpanBtnOnUbahStatus);
    }

    /**
     * clicks Ubah on 'Yakin ubah status invoice ini?' pop up
     */
    public void clicksUbahOnUbahStatus(){
        playwright.clickOn(ubahBtnOnUbahStatus);
    }

    /**
     * Get toast success add biaya sewa / biaya tambahan
     * @return String biaya sewa / biaya tambahan toast
     */
    public String getToastUbahStatus(){
        return playwright.getText(toastUbahStatus);
    }

    /**
     * get Paid Time on Status Invoice coloumn
     * @return String Time
     */
    public String getPaidTime(){
        return playwright.getText(statusInvCol);
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

    //---Filter Invoice Manual---//

    /**
     * click on Filter
     */
    public void clicksFilter(){
        playwright.clickOn(filter);
    }

    /**
     * assert Filter title
     * assert Filter subtitle
     */
    public void assertFilterTitleNSubtitle(){
        assertThat(filterTitle);
        assertThat(filterSubtitle);
    }

    /**
     * assert Status Invoice title
     * @param statusInv
     */
    public void assertStatusInvTitle(String statusInv){
        statusInvTitle = page.getByTestId("invoice-manual-filter-modal").getByText(statusInv, new Locator.GetByTextOptions().setExact(true));
        assertThat(statusInvTitle).hasText(statusInv);
    }

    /**
     * assert Jenis Biaya title
     * @param jnsBiaya
     */
    public void assertJenisBiaya(String jnsBiaya){
        jenisBiayaTitle = page.getByTestId("invoice-manual-filter-modal").getByText(jnsBiaya, new Locator.GetByTextOptions().setExact(true));
        assertThat(jenisBiayaTitle).hasText(jnsBiaya);
    }

    /**
     * assert Tanggal Invoice Dibuat
     * @param tglInvDibuat
     */
    public void assertTanggalInvoiceDibuat(String tglInvDibuat){
        tanggalInvDibuat = page.getByText(tglInvDibuat);
        assertThat(tanggalInvDibuat).hasText(tglInvDibuat);
    }

    /**
     * assert Tanggal Mulai title
     * @param tglMulai
     */
    public void assertTanggalMulaiTitle(String tglMulai){
        tanggalMulaiTitle = page.getByText(tglMulai);
        assertThat(tanggalMulaiTitle).hasText(tglMulai);
    }

    /**
     * assert Tanggal Akhir title
     * @param tglAkhir
     */
    public void assertTanggalAkhirTitle(String tglAkhir){
        tanggalAkhirTitle = page.getByText(tglAkhir);
        assertThat(tanggalAkhirTitle).hasText(tglAkhir);
    }

    /**
     * click Close (X) on Filter
     */
    public void clicksCloseOnFilter(){
        playwright.clickOn(closeFilterBtn);
        playwright.clickOn(filter);
    }

    /**
     * click on Terapkan button
     */
    public void clicksTerapkan(){
        playwright.clickOn(terapkanBtn);
    }

    /**
     * assert Unpaid on Status Invoice coloumn
     * @param result
     */
    public void assertValueStatusInv(String result){
        valueStatusInv = page.getByTestId("invoice-manual-item-0").getByText(result);
        assertThat(valueStatusInv).hasText(result);
    }

    /**
     * get Value on Status Invoice coloumn
     * @param statusInvoice
     * @return String Status Invoice
     */
    public String getValueStatusInv(String statusInvoice){
        valueStatusInv = page.locator("//tr/td/div[contains(., '" +statusInvoice+ "')]").last();
        return playwright.getText(valueStatusInv);
    }

    /**
     * click Reset button on Filter pop up
     */
    public void clicksReset(){
        playwright.clickOn(resetBtn);
    }

    /**
     * Counter on Filter is hidden
     */
    public void counterOnFilterIsHidden(){
        counterOnFilter.isHidden();
    }

    /**
     * clicks Main Reset button on Invoice Manual
     */
    public void clicksMainReset(){
        playwright.clickOn(mainResetBtn);
    }

    /**
     * ticks on Status Invoice dropdown
     * @param statusInv
     */
    public void ticksStatusInvoice(String statusInv){
        //clicks Status Invoice dropdown
        playwright.clickOn(statusInvDropdown);

        //ticks Paid/Unpaid/Expired
        tickPaid = page.locator("//p[contains(., '" +statusInv+ "')]");
        playwright.clickOn(tickPaid);

        //clicks Terapkan button
        playwright.clickOn(terapkanBtn);
    }

    /**
     * ticks on Status Invoice dropdown
     * and without clicks Terapkan
     * @param statusInv
     */
    public void ticksStatusInvoiceWithoutClicksTerapkan(String statusInv){
        //clicks Status Invoice dropdown
        playwright.clickOn(statusInvDropdown);

        //ticks Paid/Unpaid/Expired
        tickPaid = page.locator("//p[contains(., '" +statusInv+ "')]");
        playwright.clickOn(tickPaid);
    }

    public void tickJenisBiayaCheckbox(String value) {
        if (value.equalsIgnoreCase("Biaya Sewa")){
            tickJenisBiaya = page.getByTestId("select-checkbox-rent-0");
        } else if (value.equalsIgnoreCase("Biaya Tambahan")) {
            tickJenisBiaya = page.getByTestId("select-checkbox-additional_cost-1");
        } else if (value.equalsIgnoreCase("Master Data")) {
            tickJenisBiaya = page.getByTestId("select-checkbox-additional_fee-2");
        }

        playwright.clickOn(jenisBiayaDropdown);
        playwright.clickOn(tickJenisBiaya);
    }

    /**
     * refresh page on Invoice Manual
     */
    public void refreshPageInvoiceManual(){
        page.reload();
    }

    /**
     * clicks Calendar View on Tanggal Mulai
     */
    public void clickCalViewOnTglMulai(){
        playwright.clickOn(calViewTglMulai);
    }

    /**
     * clicks Calendar View on Tanggal Akhir
     */
    public void clickCalViewOnTglAkhir(){
        playwright.clickOn(calViewTglAkhir);
    }

    /**
     * clicks date on Calendar Tanggal Mulai
     * @param date
     */
    public void setTanggalMulai(String date){
        if (date.equalsIgnoreCase("today")){
            //get today date
            SimpleDateFormat today = new SimpleDateFormat("d");
            Date dates = new Date();
            startDate = page.locator("//span[@class='cell day today'][contains(., '" +today.format(dates)+ "')]").nth(0);
            playwright.clickOn(startDate);
        } else if (date.equalsIgnoreCase("tomorrow")) {
            //get tomorrow date
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, 1);
            Date dt = calendar.getTime();
            SimpleDateFormat tomorrow = new SimpleDateFormat("d");
            startDate = page.locator("(//span[@class='cell day today']/parent::div/following-sibling::*[contains(., '" +tomorrow.format(dt)+ "')])[1]");
            playwright.clickOn(startDate);
        } else if (date.equalsIgnoreCase("selected today")) {
            //get today date
            SimpleDateFormat today = new SimpleDateFormat("d");
            Date dates = new Date();
            startDate = page.locator("//span[@class='cell day selected today'][contains(., '" +today.format(dates)+ "')]").nth(0);
            playwright.clickOn(startDate);
        }
    }

    /**
     * clicks date on Calendar Tanggal Akhir
     * @param date
     */
    public void setTanggalAkhir(String date){
        if (date.equalsIgnoreCase("today")){
            //get today date
            SimpleDateFormat today = new SimpleDateFormat("d");
            Date dates = new Date();
            startDate = page.locator("//span[@class='cell day today'][contains(., '" +today.format(dates)+ "')]").nth(0);
            playwright.clickOn(startDate);
        } else if (date.equalsIgnoreCase("tomorrow")) {
            //get tomorrow date
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, 1);
            Date dt = calendar.getTime();
            SimpleDateFormat tomorrow = new SimpleDateFormat("d");
            startDate = page.locator("(//span[@class='cell day today']/parent::div/following-sibling::*[contains(., '" +tomorrow.format(dt)+ "')])[1]");
            playwright.clickOn(startDate);
        }
    }

    /**
     * assert date on Dibuat Oleh coloumn
     * @param expectedDate
     */
    public void assertDibuatOleh(String expectedDate){
        assertThat(dibuatOlehCol).containsText(expectedDate);
    }

    /**
     * ticks on Biaya Tambahan at Jenis Biaya dropdown
     * and clicks Terapkan
     * @param value
     */
    public void tickJenisBiayaTambahan(String value){
        //clicks Jenis Biaya dropdown
        playwright.clickOn(jenisBiayaDropdown);

        //biaya tambahan
        tickJenisBiaya = page.locator("//p[contains(., '" +value+ "')]").first();
        playwright.clickOn(tickJenisBiaya);

        //clicks Terapkan button
        playwright.clickOn(terapkanBtn);
    }

    /**
     * ticks on Biaya Sewa at Jenis Biaya dropdown
     * and clicks Terapkan
     * @param value
     */
    public void tickJenisBiayaSewa(String value){
        //clicks Jenis Biaya dropdown
        playwright.clickOn(jenisBiayaDropdown);

        //biaya sewa
        tickJenisBiaya = page.locator("//p[contains(., '" +value+ "')]").first();
        playwright.clickOn(tickJenisBiaya);

        //clicks Terapkan button
        playwright.clickOn(terapkanBtn);
    }

    /**
     * assert Value Jenis Biaya on Jenis Biaya coloumn
     * @param result
     */
    public void assertValueJenisBiaya(String result){
        valueJenisBiaya = page.locator("//a[@class='bg-c-link bg-c-link--high'][contains(., '" +result+ "')]");
        for (int i=0; i<valueJenisBiaya.count(); i++){
            System.out.println(valueJenisBiaya.nth(i));
            assertThat(valueJenisBiaya.nth(i)).hasText(result);
        }
    }

    /**
     * Get last invoice number
     * @return String
     */
    public String getLastInvoiceNumber() {
        lastInvoiceNumber = page.locator("tr td>a:nth-of-type(1)").last();
        return playwright.getText(lastInvoiceNumber);
    }
    //---End of Filter Invoice Manual---//
}