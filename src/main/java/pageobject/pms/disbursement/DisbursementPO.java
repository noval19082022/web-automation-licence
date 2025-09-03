package pageobject.pms.disbursement;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import config.global.GlobalConfig;
import utilities.PlaywrightHelpers;
import utilities.JavaHelpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DisbursementPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private JavaHelpers java = new JavaHelpers();

    //---Disbursement Page---//
    Locator actionBtn;
    Locator konfirmasiBtn;
    Locator seeDetailBtn;
    Locator statusMenungguKonfirmasi;
    Locator statusTransferWaiting;
    Locator batalkanKonfirmasiBtn;
    Locator filter;
    Locator statusDataPendapatanDropdown;
    Locator statusDtPndptn;
    Locator terapkanBtn;
    Locator cariBtn;
    Locator searchProperty;
    private Locator konfirmasiYaButton;
    private Locator calendarView;
    private Locator calendarDropdown;
    private Locator arrowRightButton;
    private Locator monthJanuari;
    private Locator nextMonth;
    private Locator emptyStateTitle;
    private Locator emptyStateSubtitle;
    private Locator propertyNameText;
    private Locator disbursementPeriodSelect;
    private Locator cancelAutoTransferButton;

    //Filter Disbursement
    private Locator filterTransferType;
    private Locator filterTransferPeriod;
    private Locator totalTransferTitle;
    private Locator filterTransferPeriodValue;
    private Locator filterTransferValue;

    //---Detail Transfer Pendapatan Page---//
    Locator tambahkanTransaksiBtn;
    Locator rincianPenjualanSection;
    Locator tambahkanBtnBiayaLainnya;
    Locator biayaPenguranganSection;
    Locator tambahkanBtnTambahanPendapatan;
    Locator tambahanPendapatanSection;
    Locator riwayatTransferPendapatanBtn;
    Locator refreshHalamanIniBtn;
    Locator modelKerjaSamaBooking;
    Locator modelKerjaSamaDBET;
    Locator addOnJP;
    Locator addOnADP;
    private Locator tambahanPendapatanNameField;
    private Locator tambahanPendapatanKuantitasField;
    private Locator tambahanPendapatanHargaSatuanField;
    private Locator tambahanPendapatanSimpanButton;
    private Locator tambahanPendapatanTable;
    private Locator tambahanPendapatanActionButton;
    private Locator tambahanPendapatanActionUbahButton;
    private Locator tambahanPendapatanActionHapusButton;
    private Locator tambahPendapatanConfirmHapusButton;
    private Locator tambahPendapatanEmptyMessageText;
    private Locator riwayatTransferPendapatanButton;
    private Locator transferPendapatanTitleText;
    private Locator refreshDisbursementButton;
    private Locator konfirmasiDetailButton;
    private Locator batalkanKonfirmasiDetailButton;

    //---Keterangan Tambahan untuk Owner Section---//
    private Locator ubahBtnInKeteranganTambahan;
    private Locator keteranganTambahanField;
    private Locator simpanBtnInKeteranganTambahan;
    private Locator keteranganTambahanValue;
    private Locator toastKeteranganTambahan;
    private Locator keteranganTambahanErrorMessage;
    private Locator errorMessageMoreThan1500Characters;

    public DisbursementPO(Page page) {
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        //---Disbursement Page---//
        actionBtn = page.getByTestId("table-action-trigger").first();
        konfirmasiBtn = page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions()).getByText("Konfirmasi", new Locator.GetByTextOptions().setExact(true)).first();
        seeDetailBtn = page.locator("//*[contains(text(),'Lihat Detail')]").first();
        statusMenungguKonfirmasi = page.locator("((//tr)[2]/td)[3]");
        statusTransferWaiting = page.locator("((//tr)[2]/td)[4]");
        batalkanKonfirmasiBtn = page.getByText("Batalkan Konfirmasi").first();
        filter = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("filterFilter"));
        statusDataPendapatanDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih status data pendapatan dropdown-down"));
        terapkanBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Terapkan"));
        cariBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cari"));
        searchProperty = page.getByPlaceholder("Cari Nama Properti");
        konfirmasiYaButton = page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Ya").setExact(true));
        calendarView = page.getByRole(AriaRole.TEXTBOX).first();
        calendarDropdown = page.locator(".vdp-datepicker__calendar");
        arrowRightButton = page.locator("span").filter(new Locator.FilterOptions().setHasText("arrow-right")).first();
        monthJanuari = page.getByText("Januari", new Page.GetByTextOptions().setExact(true));
        nextMonth = page.locator("//*[@class='cell month selected']//following-sibling::*");
        emptyStateTitle = page.getByText("Data Tidak Ditemukan", new Page.GetByTextOptions().setExact(true));
        emptyStateSubtitle = page.getByText("Data tidak ditemukan di filter atau kata kunci yang Anda gunakan tidak sesuai.");
        propertyNameText = page.locator(".ss-table tbody tr td:nth-of-type(2)");
        disbursementPeriodSelect = page.locator(".bg-c-select__trigger-text");

        //Filter Disbursement
        filterTransferType = page.locator(".bg-c-select__trigger-text").first();
        filterTransferPeriod = page.locator(".bg-c-select__trigger-text").last();
        totalTransferTitle = page.locator("p.bg-u-text-neutral-500");

        //---Detail Transfer Pendapatan Page---//
        tambahkanTransaksiBtn = page.locator("//button[contains(., 'Tambahkan Transaksi')]");
        tambahkanBtnBiayaLainnya = page.locator("//button[contains(., 'Tambahkan')]").nth(1);
        tambahkanBtnTambahanPendapatan = page.locator("//button[contains(., 'Tambahkan')]").nth(2);
        rincianPenjualanSection = page.locator("//div[@class='invoice-interaction mb-24']");
        biayaPenguranganSection = page.locator("//div[@class='flex align-center justify-space-between mb-24']").nth(0);
        tambahanPendapatanSection = page.locator("//div[@class='flex align-center justify-space-between mb-24']").nth(1);
        riwayatTransferPendapatanBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("calendar Riwayat Transfer Pendapatan"));
        refreshHalamanIniBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("reload Refresh Halaman ini"));
        tambahanPendapatanNameField = page.getByTestId("cost-name");
        tambahanPendapatanKuantitasField = page.getByTestId("cost-qty");
        tambahanPendapatanHargaSatuanField = page.getByTestId("cost-amount");
        tambahanPendapatanSimpanButton = page.getByTestId("simpan-btn");
        tambahPendapatanEmptyMessageText = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("Belum Ada Biaya Tambahan Pendapatan"));
        riwayatTransferPendapatanButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Riwayat Transfer Pendapatan"));
        transferPendapatanTitleText = page.locator("#transfer-pendapatan-history");
        refreshDisbursementButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Refresh Halaman ini"));
        konfirmasiDetailButton = page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Konfirmasi").setExact(true));
        batalkanKonfirmasiDetailButton = page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Batalkan Konfirmasi").setExact(true));

        //---Keterangan Tambahan untuk Owner Section---//
        ubahBtnInKeteranganTambahan = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ubah"));
        keteranganTambahanField = page.locator("//*[@class='bg-c-textarea']/textarea");
        simpanBtnInKeteranganTambahan = page.getByTestId("simpan-btn");
    }

    /**
     * Check button is exist or not in Disbursement page
     * @param button
     * @return boolean
     */
    public boolean isButtonExistInDisbursement(String button) {
        boolean exist = false;
        switch (button){
            case "Konfirmasi":
                if (isStatusDataPendapatanMenungguKonfirmasi()){
                    if (playwright.isLocatorVisibleAfterLoad(actionBtn, GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT)){
                        playwright.clickOn(actionBtn);
                        exist = playwright.isLocatorVisibleAfterLoad(konfirmasiBtn, GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT);
                        playwright.clickOn(actionBtn);
                    }
                }
                break;
            case "Lihat Detail":
                if (playwright.isLocatorVisibleAfterLoad(actionBtn,GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT)){
                    playwright.clickOn(actionBtn);
                    exist = playwright.isLocatorVisibleAfterLoad(seeDetailBtn,GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT);
                    playwright.clickOn(actionBtn);
                }
                break;
            default:
                System.out.println("Invalid button");
        }
        return exist;
    }

    /**
     * Check button is exist or not in Disbursement - Detail Transfer Pendapatan page
     * @param button
     * @return
     */
    public boolean isButtonExistInDetailTransferPendapatan(String button){
        boolean exist = false;
        switch (button){
            case "Tambahkan Transaksi":
                if (playwright.isLocatorVisibleAfterLoad(actionBtn, GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT)){
                   playwright.clickOn(actionBtn);
                   playwright.clickOn(seeDetailBtn);
                   playwright.pageScrollInView(rincianPenjualanSection);
                   exist = playwright.isLocatorVisibleAfterLoad(tambahkanTransaksiBtn, GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT);
                }
                break;
            case "Tambahkan in Biaya Lainnya":
                playwright.pageScrollInView(biayaPenguranganSection);
                if (playwright.isLocatorVisibleAfterLoad(tambahkanBtnBiayaLainnya, GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT)){
                    exist = playwright.isLocatorVisibleAfterLoad(tambahkanBtnBiayaLainnya, GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT);
                }
                break;
            case "Tambahkan in Tambahan Pendapatan":
                playwright.pageScrollInView(tambahanPendapatanSection);
                if (playwright.isLocatorVisibleAfterLoad(tambahkanBtnTambahanPendapatan, GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT)){
                    exist = playwright.isLocatorVisibleAfterLoad(tambahkanBtnTambahanPendapatan, GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT);
                }
                break;
            default:
                System.out.println("Invalid button");
        }
        return exist;
    }

    /**
     * Check if Status Data Pendapatan is Menunggu Konfirmasi
     * @return
     */
    public boolean isStatusDataPendapatanMenungguKonfirmasi(){
        playwright.isLocatorVisibleAfterLoad(statusMenungguKonfirmasi, GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT);
        return statusMenungguKonfirmasi.textContent().contains("Menunggu Konfirmasi");
    }

    /**
     * Clicks Filter on Disbursement menu
     */
    public void clicksFilter(){
        playwright.clickOn(filter);
    }

    /**
     * Tick value on Status Data Pendapatan dropdown
     * @param filter
     */
    public void tickStatusDataPendapatan(String filter){
        playwright.clickOn(statusDataPendapatanDropdown);

        statusDtPndptn = page.getByRole(AriaRole.PARAGRAPH).filter(new Locator.FilterOptions().setHasText(filter));
        playwright.clickOn(statusDtPndptn);

        playwright.clickOn(terapkanBtn);
    }

    /**
     * Refresh page on Disbursement menu
     */
    public void refreshPage(){
        playwright.reloadPage();
    }

    /**
     * Search Property name on Disbursement menu
     * @param property
     */
    public void searchProperty(String property){
        playwright.fill(searchProperty, property);
        playwright.clickOn(cariBtn);
    }

    /**
     * Clicks Lihat Detail on Kebab button
     */
    public void clicksLihatDetail(){
        playwright.clickOn(actionBtn);
        playwright.clickOn(seeDetailBtn);
    }

    /**
     * Clicks Refresh Halaman Ini button in Detail Transfer Pendapatan
     */
    public void clicksRefreshHalamanIniBtn() {
        playwright.clickOn(refreshHalamanIniBtn);
    }

    /**
     * Get Model Kerja Sama on Booking
     * @return String model kerja sama booking
     */
    public String getModelKerjaSamaBooking() {
        modelKerjaSamaBooking = page.locator("//div[@class='bg-c-list-item__description']//li/p").nth(0);
        String full = playwright.getText(modelKerjaSamaBooking);
        return full;
    }

    /**
     * Get Model Kerja Sama on DBET
     * @return String model kerja sama DBET
     */
    public String getModelKerjaSamaDBET() {
        modelKerjaSamaDBET = page.locator("//div[@class='bg-c-list-item__description']//li").nth(1);
        String full = playwright.getText(modelKerjaSamaDBET);
        String result = full.substring(6);
        return result;
    }

    /**
     * Get Add On JP
     * @return String Add On JP
     */
    public String getAddOnJP() {
        addOnJP = page.locator("//div[@class='bg-c-list-item__description']//li").nth(2);
        return playwright.getText(addOnJP);
    }

    /**
     * Get Add On ADP
     * @return String Add On ADP
     */
    public String getAddOnADP() {
        addOnADP = page.locator("//div[@class='bg-c-list-item__description']//li").nth(3);
        return playwright.getText(addOnADP);
    }

    /**
     * add tambahan pendapatan in disbursement detail
     * @param fee array contains fee name, qty, price
     */
    public void addTambahanPendapatan(List<String> fee) {
        playwright.clickOn(tambahkanBtnTambahanPendapatan);
        playwright.fill(tambahanPendapatanNameField,fee.get(0));
        playwright.fill(tambahanPendapatanKuantitasField, fee.get(1));
        playwright.fill(tambahanPendapatanHargaSatuanField, fee.get(2));
        playwright.clickOn(tambahanPendapatanSimpanButton);
    }

    /**
     * Get tambahan pendapatan name in row i
     * @param i index
     * @return String
     */
    public String getTambahanPendapatanName(int i) {
        tambahanPendapatanTable = page.locator("((//*[@class='detail-transfer-page-table-list__table'])[4]//tr)["+i+2+"]/td");
        return playwright.getText(tambahanPendapatanTable.nth(0));
    }

    /**
     * Get tambahan pendapatan price in row i
     * @param i index
     * @return String
     */
    public String getTambahanPendapatanPrice(int i) {
        tambahanPendapatanTable = page.locator("((//*[@class='detail-transfer-page-table-list__table'])[4]//tr)["+i+2+"]/td");
        return playwright.getText(tambahanPendapatanTable.nth(1));
    }

    /**
     * Get tambahan pendapatan quantity in row i
     * @param i index
     * @return String
     */
    public String getTambahanPendapatanQty(int i) {
        tambahanPendapatanTable = page.locator("((//*[@class='detail-transfer-page-table-list__table'])[4]//tr)["+i+2+"]/td");
        return playwright.getText(tambahanPendapatanTable.nth(2));
    }

    /**
     * Get tambahan pendapatan total in row i
     * @param i index
     * @return String
     */
    public String getTambahanPendapatanTotal(int i) {
        tambahanPendapatanTable = page.locator("((//*[@class='detail-transfer-page-table-list__table'])[4]//tr)["+(i+2)+"]/td");
        return playwright.getText(tambahanPendapatanTable.nth(3));
    }

    /**
     * Get total of all tambahan pendapatan
     * @return String
     */
    public String getTambahanPendapatanTotalPendapatan() {
        Locator row = page.locator("(//*[@class='detail-transfer-page-table-list__table'])[4]//tr");
        int totalRow = row.count();
        tambahanPendapatanTable = page.locator("((//*[@class='detail-transfer-page-table-list__table'])[4]//tr)["+totalRow+"]/td");
        return playwright.getText(tambahanPendapatanTable.nth(2));
    }

    /**
     * Edit tambahan pendapatan row i
     * @param fee array contains fee name, qty, price
     * @param row index
     */
    public void editTambahanPendapatan(List<String> fee, Integer row) {
        tambahanPendapatanActionButton = page.locator("((//*[@class='detail-transfer-page-table-list__table'])[4]//tr)["+(row+1)+"]/td").last();
        tambahanPendapatanActionUbahButton = page.getByRole(AriaRole.MENU).getByText("Ubah");

        playwright.clickOn(tambahanPendapatanActionButton);
        playwright.clickOn(tambahanPendapatanActionUbahButton);
        playwright.fill(tambahanPendapatanNameField,fee.get(0));
        playwright.fill(tambahanPendapatanKuantitasField, fee.get(1));
        playwright.fill(tambahanPendapatanHargaSatuanField, fee.get(2));
        playwright.clickOn(tambahanPendapatanSimpanButton);
    }

    /**
     * Delete tambahan pendapatan row i
     * @param row index
     */
    public void deleteTambahanPendapatan(Integer row) {
        tambahanPendapatanActionButton = page.locator("((//*[@class='detail-transfer-page-table-list__table'])[4]//tr)["+(row+1)+"]/td").last();
        tambahanPendapatanActionHapusButton = page.getByText("Hapus", new Page.GetByTextOptions().setExact(true));
        tambahPendapatanConfirmHapusButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hapus"));

        playwright.clickOn(tambahanPendapatanActionButton);
        playwright.clickOn(tambahanPendapatanActionHapusButton);
        playwright.clickOn(tambahPendapatanConfirmHapusButton);
    }

    /**
     * Get tambahan pendapatan empty page message
     * @return String
     */
    public String getEmptyTambahanPendapatanMessage() {
        return playwright.getText(tambahPendapatanEmptyMessageText);
    }

    /**
     * Click riwayat transfer pendapatan button in detail disbursement
     */
    public void clickRiwayatTransferPendapatan() {
        playwright.clickOn(riwayatTransferPendapatanButton);
    }

    /**
     * Check is riwayat transfer pendapatan title visible
     * @return Boolean
     */
    public boolean isRiwayatTransferPendapatanVisible() {
        return playwright.isLocatorVisibleAfterLoad(transferPendapatanTitleText,10000.0);
    }

    /**
     * Check is refresh button visible
     * @return Boolean
     */
    public boolean isRefreshButtonVisible() {
        return playwright.isLocatorVisibleAfterLoad(refreshDisbursementButton,10000.0);
    }

    /**
     * Approve disbursement from list
     */
    public void approveFromList() {
        playwright.clickOn(actionBtn);
        playwright.clickOn(konfirmasiBtn);
        playwright.clickOn(konfirmasiYaButton);
    }

    /**
     * Unapprove disbursement from List
     */
    public void unapproveFromList() {
        playwright.clickOn(actionBtn);
        playwright.clickOn(batalkanKonfirmasiBtn);
        playwright.clickOn(konfirmasiYaButton);
    }

    /**
     * Approve disbursement from detail disbursement
     */
    public void approveFromdDetail() {
        playwright.pageScrollInView(konfirmasiDetailButton);
        playwright.clickOn(konfirmasiDetailButton);
        playwright.clickOn(konfirmasiYaButton);
    }

    /**
     * Unapprove disbursement from detail disbursement
     */
    public void unapproveFromDetail() {
        playwright.pageScrollInView(batalkanKonfirmasiDetailButton);
        playwright.clickOn(batalkanKonfirmasiDetailButton);
        playwright.clickOn(konfirmasiYaButton);
    }

    /**
     * Clicks Ubah button in Keterangan Tambahan untuk Owner section
     */
    public void clicksUbahInKeteranganTambahan() {
        playwright.clickOn(ubahBtnInKeteranganTambahan);
    }

    /**
     * Inputs Character Less Than 1500 Characters
     * @param note
     */
    public void inputsCharactersLessInKeteranganTambahan(String note) {
        playwright.fill(keteranganTambahanField, note);
        playwright.clickOn(simpanBtnInKeteranganTambahan);
    }

    /**
     * Get String Value in Keterangan Tambahan untuk Owner section
     * @param note
     * @return String Value in Keterangan Tambahan untuk Owner section
     */
    public String getKeteranganTambahanValue(String note) {
        keteranganTambahanValue = page.getByText(note);
        return playwright.getText(keteranganTambahanValue);
    }

    /**
     * Get String Toast in Keterangan Tambahan untuk Owner section
     * @param toast
     * @return String Toast in Keterangan Tambahan untuk Owner section
     */
    public String getKeteranganTambahanToast(String toast) {
        toastKeteranganTambahan = page.getByText(toast);
        return playwright.getText(toastKeteranganTambahan);
    }

    /**
     * Remove Value in Keterangan Tambahan untuk Owner
     */
    public void clearKeteranganTambahanValue() {
        playwright.clickOn(ubahBtnInKeteranganTambahan);
        playwright.clearText(keteranganTambahanField);
    }

    /**
     * Get String Error Message for Empty State in Keterangan Tambahan untuk Owner section
     * @param errorMessage
     * @return String Error Message for Empty State in Keterangan Tambahan untuk Owner section
     */
    public String errorMessageEmptyStateInKeteranganTambahan(String errorMessage) {
        keteranganTambahanErrorMessage = page.getByText(errorMessage);
        return playwright.getText(keteranganTambahanErrorMessage);
    }

    /**
     * Check if Simpan button in Keterangan Tambahan untuk Owner is disable
     * True = disable
     * False = enable
     * @return Simpan button in Keterangan Tambahan untuk Owner is disable
     */
    public boolean isSimpanButtonInKeteranganTambahanDisable() {
        return playwright.isButtonDisable(simpanBtnInKeteranganTambahan);
    }

    /**
     * Get String Error Message for More Than 1500 characters
     * @param errorMessage
     * @return String Error Message for More Than 1500 characters
     */
    public String errorMessageMoreThan1500Chars(String errorMessage) {
        errorMessageMoreThan1500Characters = page.getByText(errorMessage);
        return playwright.getText(errorMessageMoreThan1500Characters);
    }

    /**
     * Inputs Characters More Than 1500 in Keterangan Tambahan untuk Owner section
     * @param noteMoreThan
     */
    public void inputsCharactersMoreInKeteranganTambahan(String noteMoreThan) {
        playwright.fill(keteranganTambahanField, noteMoreThan);
    }

    /**
     * Get This Month
     * And clicks Calendar Box in Disbursement Page
     * And if this month is Desember, it will clicks arrow right and clicks Month Januari
     * And if this month is not Desember, it will clicks next month
     */
    public void clicksCalendar() {
        SimpleDateFormat today = new SimpleDateFormat("MMMM");
        Date dates = new Date();
        System.out.println(today.format(dates));
        playwright.clickOn(calendarView);
        if (today.format(dates).equalsIgnoreCase("December")){
            playwright.waitForLocatorVisibleAndClickOn(arrowRightButton);
            playwright.clickOn(monthJanuari);
        } else {
            playwright.waitForLocatorVisibleAndClickOn(nextMonth.first());
        }
    }

    /**
     * Get String Empty State Title in Disbursement Page
     * @return String Empty State Title
     */
    public String getEmptyStateTitleInDisbursement() {
        return playwright.getText(emptyStateTitle);
    }

    /**
     * Get String Empty State Subtitle in Disbursement Page
     * @return String Empty State Subtitle
     */
    public String getEmptyStateSubtitleInDisbursement() {
        return playwright.getText(emptyStateSubtitle);
    }

    /**
     * Check empty state list disbursement appear?
     * @return boolean
     */
    public boolean isEmptyStateDisbursementListAppear() {
        return playwright.isLocatorVisibleAfterLoad(emptyStateTitle,5000.0);
    }

    /**
     * Get property name in first row
     * @return String
     */
    public String getPropertyNameinList() {
        return playwright.getText(propertyNameText);
    }

    /**
     * change periode disbursement
     * @param period
     */
    public void selectDisbursementPeriod(String period) {
        Locator periode = page.getByText(period).last();

        if(!playwright.getText(disbursementPeriodSelect.last()).contains(period)) {
            playwright.clickOn(disbursementPeriodSelect.last());
            playwright.clickOn(periode);
        }
    }

    /**
     * Verify button cancel auto transfer button
     * @return boolean
     */
    public boolean isButtonCancelAutoTransferVisible() {
        cancelAutoTransferButton = page.getByText("Cancel Auto Transfer");
        return playwright.isLocatorVisibleAfterLoad(cancelAutoTransferButton,5000.0);
    }

    /**
     * Get filter transfer type in Disbursement page
     * @return  String
     */
    public String getFilterTransferType() {
        return playwright.getText(filterTransferType);
    }

    /**
     * Get filter transfer period in Disbursement page
     * @return  String
     */
    public String getFilterTransferPeriod() {
        return playwright.getText(filterTransferPeriod);
    }

    /**
     * Get total transfer title in Disbursement page
     * @return  String
     */
    public String getTotalTransferTitle() {
        return playwright.getText(totalTransferTitle);
    }

    /**
     * Select filter transfer period in Disbursement page
     * @param transferPeriod String data type
     */
    public void selectFilterTransferPeriod(String transferPeriod) throws ParseException {
        filterTransferPeriodValue = page.locator("a").filter(new Locator.FilterOptions().setHasText(transferPeriod));
        String today = java.updateTime("yyyy MMM dd", java.getTimeStamp("yyy MMM dd"), "d", 0, 0, 0, 0);

        if (transferPeriod.equalsIgnoreCase("Periode 1 (Tanggal 1)") && Integer.parseInt(today) >= 16) {
            filterTransferPeriodValue = page.locator("a")
                    .filter(new Locator.FilterOptions().setHasText("Periode 1 (Tanggal 1)"));
        } else if (transferPeriod.equalsIgnoreCase("Periode 2 (Tanggal 16)") && Integer.parseInt(today) < 16) {
            filterTransferPeriodValue = page.locator("a")
                    .filter(new Locator.FilterOptions().setHasText("Periode 2 (Tanggal 16)"));
        }

        playwright.clickOn(filterTransferPeriod);
        playwright.clickOn(filterTransferPeriodValue);
    }

    /**
     * Apply filter in Disbursement page
     */
    public void applyFilter() {
        playwright.clickOn(cariBtn);
    }

    /**
     * Select filter transfer in Disbursement page
     * @param schedule String data type
     */
    public void selectFilterTransfer(String schedule) {
        filterTransferValue = page.locator("a").filter(new Locator.FilterOptions().setHasText(schedule));
        playwright.clickOn(filterTransferType);
        playwright.clickOn(filterTransferValue);
    }
}
