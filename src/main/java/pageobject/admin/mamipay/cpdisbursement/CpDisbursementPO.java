package pageobject.admin.mamipay.cpdisbursement;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CpDisbursementPO {

    private Page page;
    PlaywrightHelpers playwright;

    private Locator cpDisbursementMenu;
    private Locator tambahDataTransferButton;

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
    //List Daftar Transfer

    public CpDisbursementPO(Page page){
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        cpDisbursementMenu = page.getByRole(AriaRole.LINK).filter(new Locator.FilterOptions().setHasText("CP Disbursement"));
        tambahDataTransferButton = page.locator(".open_modal");
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

        tanggalTransferPemilikTable = page.locator("td b");
        namaPropertyTable = page.locator("tr td:nth-of-type(3)");
        productTable = page.locator("tr td:nth-of-type(3) p");
        tipeTransaksiTable = page.locator("tr td:nth-of-type(4)");
        totalPendapatanTable = page.locator("tr td:nth-of-type(5)");
        detailRekeningTable = page.locator("tr td:nth-of-type(6)");
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
            date = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(hari).setExact(true));
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
     * get first detail rekening list
     * @return String
     */
    public String getDetailRekeningList() {
        return playwright.getText(detailRekeningTable.first());
    }
}
