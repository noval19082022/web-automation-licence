package pageobject.admin.mamipay.cpdisbursement;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CpDisbursementPO {

    private Page page;
    PlaywrightHelpers playwright;

    private Locator cpDisbursementMenu;
    private Locator tambahDataTransferButton;
    private Locator cpDisbursementTab;
    private Locator resetFilterButton;
    private Locator row;
    private Locator daftarTransferTab;

    //Tambah Data Transfer
    private Locator namaPropertyField;
    private Locator namaPropertyErrorMessage;
    private Locator propertySuggestion;
    private Locator productTypeText;
    private Locator bankNameSelect;
    private Locator nomorRekeningField;
    private Locator namaPemilikRekeningField;
    private Locator noTeleponPemilikField;
    private Locator totalPendapatanField;
    private Locator tipeTransaksiSelect;
    private Locator tanggalTransferField;
    private Locator date;
    private Locator berkasLaporanFile;
    private Locator tipeDisbursementSelect;
    private Locator closePopUpButton;
    private Locator lainnyaTipeTransaksiField;
    private Locator tambahkanDataTransferButton;
    //Tambah Data Transfer

    //List Daftar Transfer
    private Locator tanggalTransferPemilikTable;
    private Locator namaPropertyTable;
    private Locator productTable;
    private Locator tipeTransaksiTable;
    private Locator totalPendapatanTable;
    private Locator detailRekeningTable;
    private Locator searchByDropdown;
    private Locator searchByValue;
    private Locator searchKeywordField;
    private Locator searchButton;
    private Locator emptyPageMessageTitle;
    private Locator emptyPageMessageDescription;
    //List Daftar Transfer

    //Transfer Diproses
    private Locator statusTransferDropdown;
    private Locator statusTransferValue;
    private Locator statusTransferLabel;
    private Locator tglTransferKePemilikTable;
    private Locator previousButton;
    private Locator statusTransferList;
    private Locator paginationButton;
    //Transfer Diproses

    //Transfer Gagal
    private Locator jadwalTransferDropdown;
    private Locator transferFailedDateDropdown;
    //Transfer Gagal

    //Preview Data Transfer
    private Locator transferActionButton1;
    private Locator totalPendapatanFieldOnPreview;
    private Locator tipeTransaksiSelectOnPreview;
    private Locator propertyNamePreviewModal;
    private Locator tglTransferKePemilikOnPreview;
    private Locator transferSekarangBtn;
    private Locator toastMessage;
    private Locator productTypeTextOnPreviewModal;
    private Locator bankTextOnPreviewModal;
    private Locator nomorRekeningTextOnPreviewModal;
    private Locator namaPemilikRekeningTextOnPreviewModal;
    private Locator nomorTeleponPemilikTextOnPreviewModal;
    private Locator tipeDisbursementOnPreview;
    //Preview Data Transfer

    public CpDisbursementPO(Page page){
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        row = page.locator("tbody tr");

        cpDisbursementMenu = page.getByRole(AriaRole.LINK).filter(new Locator.FilterOptions().setHasText("CP Disbursement"));
        tambahDataTransferButton = page.locator(".open_modal");
        resetFilterButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Reset"));
        namaPropertyField = page.getByPlaceholder("Pilih Nama Property");
        namaPropertyErrorMessage = page.locator("#looking_for_kost_message-add-new");
        propertySuggestion = page.locator(".eac-item");
        productTypeText = page.locator("#kost-level-add-new");
        bankNameSelect = page.locator("#cp-disbursement-level-bank-add-new");
        nomorRekeningField = page.locator("#destination_account-add-new");
        namaPemilikRekeningField = page.locator("#destination_name-add-new");
        noTeleponPemilikField = page.locator("#owner_phone_number-add-new");
        totalPendapatanField = page.locator("#transfer_amount-add-new");
        tipeTransaksiSelect = page.locator("#cp-disbursement-level-multiple-add-new");
        tanggalTransferField = page.locator("#transfer_due_date-add-new");
        berkasLaporanFile = page.locator("#owner_report_file-add-new");
        tipeDisbursementSelect = page.locator("#disbursement_type-add-new");
        closePopUpButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Close"));
        lainnyaTipeTransaksiField = page.locator("#transaction_type_text-add-new");
        tambahkanDataTransferButton = page.locator("#transfer-submit-add-new");
        daftarTransferTab = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Daftar Transfer"));

        tanggalTransferPemilikTable = page.locator("td b");
        namaPropertyTable = page.locator("tr td:nth-of-type(3)");
        productTable = page.locator("tr td:nth-of-type(3) p");
        tipeTransaksiTable = page.locator("tr td:nth-of-type(4)");
        totalPendapatanTable = page.locator("tr td:nth-of-type(5)");
        detailRekeningTable = page.locator("tr td:nth-of-type(6)");
        searchByDropdown = page.locator(".dropdown button").first();
        searchByValue = page.locator("a[role='option'] span");
        searchKeywordField = page.locator("input[name='search_value']");
        searchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search"));
        emptyPageMessageTitle = page.locator(".pay-backoffice__table-empty h3");
        emptyPageMessageDescription = page.locator(".pay-backoffice__table-empty p");
        statusTransferDropdown = page.locator(".filter-option").nth(1);
        statusTransferValue = page.locator("a[role='option'] span");
        statusTransferLabel = page.locator("tr td:nth-of-type(7)");
        tglTransferKePemilikTable = page.locator("tr td:nth-of-type(2) b").first();


        jadwalTransferDropdown = page.locator("#daterange-cp-disbursement");
        transferFailedDateDropdown = page.locator("#daterange-cp-disbursement_failed");
        previousButton = page.locator("a[rel='prev']");
        statusTransferList = page.locator("td:nth-of-type(7) span");
        paginationButton = page.locator(".pagination li a");

        transferActionButton1 = page.locator("(//td)[7]/button");
        propertyNamePreviewModal = page.locator("(//*[@class='easy-autocomplete'])[1]/input");
        totalPendapatanFieldOnPreview = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Masukkan total pendapatan"));
        tipeTransaksiSelectOnPreview = page.locator("//select[@name='transaction_type']");
        tglTransferKePemilikOnPreview = page.locator("//*[@name='transfer_due_date']").first();
        transferSekarangBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Transfer Sekarang"));
        toastMessage = page.locator("//*[@class='callout callout-success']");
        productTypeTextOnPreviewModal = page.getByRole(AriaRole.DIALOG, new Page.GetByRoleOptions().setName("Preview Data Transfer")).getByText("APIK");
        bankTextOnPreviewModal = page.locator("//select[@class='form-control pay-backoffice__input']");
        nomorRekeningTextOnPreviewModal = page.getByRole(AriaRole.DIALOG, new Page.GetByRoleOptions().setName("Preview Data Transfer")).getByPlaceholder("Masukkan nomor rekening");
        namaPemilikRekeningTextOnPreviewModal = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Masukkan nama pemilik rekening"));
        nomorTeleponPemilikTextOnPreviewModal = page.getByRole(AriaRole.DIALOG, new Page.GetByRoleOptions().setName("Preview Data Transfer")).getByPlaceholder("Masukkan nomor telepon pemilik");
        tipeDisbursementOnPreview = page.locator("//select[@name='disbursement_type']");
    }

    /**
     * Go to Menu CP Disbursement
     */
    public void openMenuCpDisbursement() {
        playwright.clickOn(cpDisbursementMenu);
    }

    /**
     * Click Tambah Data Transfer Button
     */
    public void tambahDataTransfer() {
        playwright.clickOn(tambahDataTransferButton);
    }

    /**
     * Search Property in Tambah Data Transfer Modal
     * @param keyword
     */
    public void searchProperty(String keyword) {
        playwright.clearText(namaPropertyField);
        playwright.fillCharacterByCharacter(namaPropertyField,keyword);
    }

    /**
     * Get nama property error message
     * @return
     */
    public String getNamaPropertyErrorMessage() {
        return playwright.getText(namaPropertyErrorMessage);
    }

    /**
     * Choose nama property suggestion by its name
     * @param property property name
     */
    public void choosePropertySuggestion(String property) {
        playwright.clickOn(propertySuggestion.filter(new Locator.FilterOptions().setHasText(property)));
    }

    /**
     * get product type in Tambah Data Transfer
     * @return String
     */
    public String getProductType() {
        return playwright.getText(productTypeText);
    }

    /**
     * get Bank in Tambah Data Transfer
     * @return String
     */
    public String getBank() {
        return playwright.getInputValue(bankNameSelect);
    }

    /**
     * get Nomor Rekening in Tambah Data Transfer
     * @return String
     */
    public String getNoRekening() {
        return playwright.getInputValue(nomorRekeningField);
    }

    /**
     * get nama pemilik rekening in Tambah Data Transfer
     * @return String
     */
    public String getNamaPemilikRekening() {
        return playwright.getInputValue(namaPemilikRekeningField);
    }

    /**
     * get nomor telepon pemilik in Tambah Data Transfer
     * @return String
     */
    public String getNoTelponPemilik() {
        return playwright.getInputValue(noTeleponPemilikField);
    }

    /**
     * set Total Pendapatan in Tambah Data Transfer
     * @param total
     */
    public void setTotalPendapatan(String total) {
        playwright.fill(totalPendapatanField,total);
    }

    /**
     * set tipe transaksi in Tambah Data Transfer
     * @param tipe
     */
    public void setTipeTransaksi(String tipe) {
        playwright.selectDropdownByValue(tipeTransaksiSelect,tipe);
    }

    /**
     * set Tanggal transfer ke pemilik in Tambah Data Transfer
     * @param tanggal
     */
    public void setTanggalTransferPemilik(String tanggal) {
        if (tanggal.equalsIgnoreCase("today")){
            SimpleDateFormat today = new SimpleDateFormat("d");
            Date dates = new Date();
            String hari = today.format(dates);
            date = page.locator(".day:not(.old):not(.new)").getByText(hari, new Locator.GetByTextOptions().setExact(true));
            playwright.clickOn(tanggalTransferField);
            playwright.clickOn(date);
        } else {
            playwright.clickOn(tanggalTransferField);
            playwright.clickOn(date);
        }
    }

    /**
     * upload berkas laporan in Tambah Data Transfer
     * @param pdf
     */
    public void uploadBerkasLaporan(String pdf) {
        berkasLaporanFile.setInputFiles(Paths.get("src/main/resources/file/"+pdf));
    }

    /**
     * set tipe disbursement in Tambah Data Transfer
     * @param disbursement
     */
    public void setTipeDisbursement(String disbursement) {
        playwright.selectDropdownByValue(tipeDisbursementSelect,disbursement);
    }

    /**
     * click X button in tambah data transfer
     */
    public void closeTambahDataTransferPopUp() {
        playwright.clickOn(closePopUpButton);
    }

    /**
     * get property name in Tambah Data Transfer
     * @return String
     */
    public String getPropertyName() {
        return playwright.getInputValue(namaPropertyField);
    }

    /**
     * get total pendapatan in Tambah Data Transfer
     * @return String
     */
    public String getTotalPendapatan() {
        return playwright.getInputValue(totalPendapatanField);
    }

    /**
     * get Tipe Transaksi in Tambah Data Transfer
     * @return String
     */
    public String getTipeTransaksi() {
        return playwright.getInputValue(tipeTransaksiSelect);
    }

    /**
     * get tanggal transfer in Tambah Data Transfer
     * @return String
     */
    public String getTanggalTransfer() {
        return playwright.getInputValue(tanggalTransferField);
    }

    /**
     * get nama file berkas laporan in Tambah Data Transfer
     * @return String
     */
    public String getBerkasLaporan() {
        String pdfname = playwright.getInputValue(berkasLaporanFile).substring(12);
        return pdfname;
    }

    /**
     * get Disbursement type in Tambah Data Transfer
     * @return String
     */
    public String getDisbursementType() {
        return playwright.getInputValue(tipeDisbursementSelect);
    }

    /**
     * set tipe transaksi Lainnya name
     * @param type
     */
    public void setLainnyaTransaksi(String type) {
        playwright.fill(lainnyaTipeTransaksiField,type);
    }

    /**
     * get tipe transaksi lainnya name
     * @return
     */
    public String getTipeTransaksiLainnya() {
        return playwright.getInputValue(lainnyaTipeTransaksiField);
    }

    /**
     * click tambahkan in Tambah Data Transfer
     */
    public void submitTambahDataTransfer() {
        playwright.clickOn(tambahkanDataTransferButton);
    }

    /**
     * get first Tanggal transfer in Daftar Transfer List
     * @return String
     */
    public String getTanggalTransferList() {
        return playwright.getText(tanggalTransferPemilikTable.first());
    }

    /**
     * get first property name in Daftar Transfer List
     * @return String
     */
    public String getPropertyNameList() {
        String name = null;
        if (playwright.getText(productTable.first()).equalsIgnoreCase("APIK")){
            name = playwright.getText(namaPropertyTable.first()).substring(0,(playwright.getText(namaPropertyTable.first()).length()-5)).trim();
        } else if (playwright.getText(productTable.first()).equalsIgnoreCase("SinggahSini")) {
            name = playwright.getText(namaPropertyTable.first()).substring(0,playwright.getText(namaPropertyTable.first()).length()-12).trim();
        }
        return name;
    }

    /**
     * Get property name row i in Daftar Transfer List
     * @param index
     * @return String
     */
    public String getPropertyNameList(int index) {
        String name = null;
        if (playwright.getText(productTable.nth(index)).equalsIgnoreCase("APIK")){
            name = playwright.getText(namaPropertyTable.nth(index)).substring(0,(playwright.getText(namaPropertyTable.first()).length()-5)).trim();
        } else if (playwright.getText(productTable.nth(index)).equalsIgnoreCase("SinggahSini")) {
            name = playwright.getText(namaPropertyTable.nth(index)).substring(0,playwright.getText(namaPropertyTable.first()).length()-12).trim();
        }
        return name;
    }

    /**
     * get first tipe transaksi in Daftar Transfer List
     * @return String
     */
    public String getTipeTransaksiList() {
        return playwright.getText(tipeTransaksiTable.first());
    }

    /**
     * get first total pendapatan in Daftar Transfer List
     * @return String
     */
    public String getTotalPendapatanList() {
        return playwright.getText(totalPendapatanTable.first());
    }

    /**
     * get first detail rekening list in Daftar Transfer List
     * @return String
     */
    public String getDetailRekeningList() {
        return playwright.getText(detailRekeningTable.first());
    }

    /**
     * get detail rekening row i in Daftar Transfer List
     * @param i index
     * @return String
     */
    public String getDetailRekeningList(int i) {
        return playwright.getText(detailRekeningTable.nth(i));
    }

    /**
     * Search Daftar Transfer
     * @param searchBy
     * @param keyword
     */
    public void searchDaftarTransfer(String searchBy, String keyword) {
        playwright.clickOn(searchByDropdown);
        playwright.clickOn(searchByValue.filter(new Locator.FilterOptions().setHasText(searchBy)));
        playwright.fill(searchKeywordField,keyword);
        playwright.clickOn(searchButton);
    }

    /**
     * get Empty page Message Title
     * @return String
     */
    public String getEmptyPageMessageTitle() {
        return playwright.getText(emptyPageMessageTitle);
    }

    /**
     * get Empty page message description
     * @return String
     */
    public String getEmptyPageMessageDescription() {
        return playwright.getText(emptyPageMessageDescription);
    }

    /**
     * Open cp disbursement tab
     * @param tab
     */
    public void openCPDisbursementTab(String tab) {
        cpDisbursementTab = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(tab));;

        playwright.clickOn(cpDisbursementTab);
    }

    /**
     * Click Reset filter button
     */
    public void resetFilter() {
        playwright.clickOn(resetFilterButton);
    }

    /**
     * Filter cp disbursement by status transfer
     * @param status
     */
    public void filterCpDisbursementByStatusTransfer(String status) {
        playwright.clickOn(statusTransferDropdown);
        playwright.clickOn(statusTransferValue.getByText(status, new Locator.GetByTextOptions().setExact(true)));
        playwright.clickOn(searchButton);
    }

    /**
     * Count how many row available
     * @return
     */
    public int countRow() {
        return row.count();
    }

    /**
     * get status transfer label row i from Table Transfer Diproses
     * @param i
     * @return String
     */
    public String getStatusTransfer(int i) {
        return playwright.getText(statusTransferLabel.nth(i));
    }

    /**
     * Get value search by
     * @return String
     */
    public String getSearchByValue() {
        return playwright.getAttributeValue(searchByDropdown,"title");
    }

    /**
     * Get value search keyword
     * @return String
     */
    public String getSearchFieldValue() {
        return playwright.getInputValue(searchKeywordField);
    }

    /**
     * get text jadwal transfer
     * @return String
     */
    public String getJadwalTransferValue() {
        return playwright.getText(jadwalTransferDropdown);
    }

    /**
     * get text jadwal transfer gagal
     * @return String
     */
    public String getTransferFailedValue() {
        return playwright.getText(transferFailedDateDropdown);
    }

    /**
     * Clicks Action Transfer on Daftar Transfer
     */
    public void clickActionTransfer() {
        playwright.clickOn(transferActionButton1);
    }

    /**
     * Edit Nama Property on Preview Data Transfer
     * @param name
     */
    public void editNamaProperty(String name) {
        playwright.clearText(propertyNamePreviewModal);
        playwright.fillCharacterByCharacter(propertyNamePreviewModal, name);
    }

    /**
     * Clicks First Property Suggestion
     */
    public void clickFirstPropertySuggestion() {
        playwright.waitTillPageLoaded(10000.0);
        playwright.clickOn(propertySuggestion.first());
    }

    /**
     * Edit Total Pendapatan on Preview Data Transfer
     * @param s
     */
    public void editTotalPendapatan(String s) {
        playwright.clearText(totalPendapatanFieldOnPreview);
        playwright.fill(totalPendapatanFieldOnPreview, s);
    }

    /**
     * Edit Tipe Transaksi on Preview Data Transfer
     * @param type
     */
    public void editTipeTransaksi(String type) {
        playwright.selectDropdownByValue(tipeTransaksiSelectOnPreview.first(), type);
    }

    /**
     * Edit Tanggal Transfer on Preview Data Transfer
     */
    public void editTanggalTransfer(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        SimpleDateFormat tomorrow = new SimpleDateFormat("d");
        Date dt = calendar.getTime();
        String hari = tomorrow.format(dt);
        playwright.clickOn(tglTransferKePemilikOnPreview);
        date = page.locator("//td[@class='active day']/following-sibling::*[contains(text(),'" +hari+ "')]");
        playwright.clickOn(date);
    }

    /**
     * Clicks Transfer Sekarang button on Preview Data Transfer
     */
    public void clicksTransferSekarang() {
        playwright.clickOn(transferSekarangBtn);
    }

    /**
     * Get string Toast Message when Edit Preview Data Transfer success
     * @return String Toast Message
     */
    public String getToastMessage() {
        return playwright.getText(toastMessage);
    }

    /**
     * Get string Tanggal Transfer Coloumn on Daftar Transfer
     * @return string Tanggal Transfer Coloum
     */
    public String getTglTransferCol() {
        return playwright.getText(tglTransferKePemilikTable);
    }

    /**
     * Get string Nama Property Coloumn on Daftar Transfer
     * @return string Nama Property Coloumn
     */
    public String getNamaPropCol() {
        System.out.println(namaPropertyTable.first());
        return playwright.getText(namaPropertyTable.first()).substring(0, 45);
    }

    /**
     * Get string Tipe Transaksi Coloumn on Daftar Transfer
     * @return string Tipe Transaksi Coloumn
     */
    public String getTipeTransaksiCol() {
        return playwright.getText(tipeTransaksiTable.first());
    }

    /**
     * Get string Total Pendapatan Coloumn on Daftar Transfer
     * @return string Total Pendapatan Coloumn
     */
    public String getTotalPndptnCol() {
        return playwright.getText(totalPendapatanTable.first());
    }

    /**
     * Get string Status Transfer After Edit on Preview Data Transfer
     * @return string Status Transfer After Edit
     */
    public String getStatusTransferAfterEdit() {
        return playwright.getText(statusTransferLabel.first());
    }

    /**
     * Get string Status Transfer Without Edit
     * @return string Status Transfer Without Edit
     */
    public String getStatusTransferWithoutEdit() {
        return playwright.getText(statusTransferLabel.first());
    }

    /**
     * Get string Property Name on Preview Data Transfer
     * @return string Property Name
     */
    public String getPropertyNameOnPreview() {
        return playwright.getInputValue(propertyNamePreviewModal);
    }

    /**
     * Get string Product Type on Preview Data Transfer
     * @return string Product Type
     */
    public String getProductTypeOnPreview() {
        return playwright.getText(productTypeTextOnPreviewModal);
    }

    /**
     * Get string Bank on Preview Data Transfer
     * @return string Bank
     */
    public String getBankOnPreview() {
        return playwright.getInputValue(bankTextOnPreviewModal.first());
    }

    /**
     * Get string Nomor Rekening on Preview Data Transfer
     * @return string Nomor Rekening
     */
    public String getNoRekeningOnPreview() {
        return playwright.getInputValue(nomorRekeningTextOnPreviewModal);
    }

    /**
     * Get string Nama Pemilik Rekening on Preview Data Transfer
     * @return string Nama Pemilik Rekening
     */
    public String getNamaPemilikRekeningOnPreview() {
        return playwright.getInputValue(namaPemilikRekeningTextOnPreviewModal);
    }

    /**
     * Get string Nomor Telepon Pemilik on Preview Data Transfer
     * @return string Nomor Telepon Pemilik
     */
    public String getNoTelponPemilikOnPreview() {
        return playwright.getInputValue(nomorTeleponPemilikTextOnPreviewModal);
    }

    /**
     * Get string Total Pendapatan on Preview Data Transfer
     * @return string Total Pendapatan
     */
    public String getTotalPendapatanOnPreview() {
        return playwright.getInputValue(totalPendapatanFieldOnPreview.first());
    }

    /**
     * Get string Tipe Transaksi on Preview Data Transfer
     * @return string Tipe Transaksi
     */
    public String getTipeTransaksiOnPreview() {
        return playwright.getInputValue(tipeTransaksiSelectOnPreview.first());
    }

    /**
     * Get string Tanggal Transfer on Preview Data Transfer
     * @return string Tanggal Transfer
     */
    public String getTanggalTransferOnPreview() {
        return playwright.getInputValue(tglTransferKePemilikOnPreview);
    }

    /**
     * Get string Disbursement Type on Preview Data Transfer
     * @return string Disbursement Type
     */
    public String getDisbursementTypeOnPreview() {
        return playwright.getInputValue(tipeDisbursementOnPreview.first());
    }

    /**
     * Get string Nama Property Coloumn
     * @return string Nama Property Coloumn
     */
    public String getNamaPropColWithoutEdit() {
        return playwright.getText(namaPropertyTable.first()).substring(0, 48);
    }

    /**
     * Get string Detail Rekening Coloumn
     * @return string Detail Rekening Coloumn
     */
    public String getDetailRekColWithoutEdit() {
        return playwright.getText(detailRekeningTable.first()).substring(0, 13);
    }

    /**
     * Edit Nomor Rekening on Preview Data Transfer
     * @param rek
     */
    public void editNoRekening(String rek) {
        playwright.clearText(nomorRekeningTextOnPreviewModal);
        playwright.fillCharacterByCharacter(nomorRekeningTextOnPreviewModal, rek);
    }

    /**
     * Get string Nomor Rekening on Preview Data Transfer
     * @return string Nomor Rekening
     */
    public String getNoRekeningPreview() {
        return playwright.getInputValue(nomorRekeningTextOnPreviewModal);
    }

    /**
     * Check status Disbursement in Transfer Diproses Tab
     * @param status status transfered that want to be verified
     * @return boolean
     */
    public boolean isDisbursementContainsStatus(String status) {
        boolean result = false;
        if (status.equalsIgnoreCase("processing")){
            if (statusTransferList.nth(0).textContent().trim().equalsIgnoreCase(status)){
                result = true;
            }
        } else {
            //go to last page
            playwright.pageScrollInView(paginationButton.first());
            playwright.clickOn(paginationButton.nth((paginationButton.count()-2)));
            //check every page until found {status}
            while (previousButton.isEnabled()) {
                //check in page n, if there is {status}
                for (int i = 0; i < statusTransferList.count(); i++) {
                    if (statusTransferList.nth(i).textContent().trim().equalsIgnoreCase(status)) {
                        result = true;
                        break;
                    }
                }
                if (result == false) {
                    playwright.clickOn(previousButton);
                } else {
                    break;
                }
            }
        }
        return result;
    }
}