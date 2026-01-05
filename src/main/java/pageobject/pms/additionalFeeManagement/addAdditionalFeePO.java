package pageobject.pms.additionalFeeManagement;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class addAdditionalFeePO {
    private Page page;
    PlaywrightHelpers playwright;

    private Locator tambahBiayaTambahanButton;
    private Locator additionalFeeNameField;
    private Locator namaBiayaErrorMessage;
    private Locator tipePembayaranTetapRadioButton;
    private Locator tipePembayaranSatuKaliRadioButton;
    private Locator waktuPenentuanHargaBiayaDitentukanDiawalRadioButton;
    private Locator waktuPenentuanHargaBiayaDisesuaikanDenganTagihanRadioButton;
    private Locator penyewaBisaPilihMandiriYaRadioButton;
    private Locator penyewaBisaPilihMandiriTidakRadioButton;
    private Locator kategoriAasuransiYaRadioButton;
    private Locator kategoriAasuransiNoRadioButton;
    private Locator satuanBiaya;
    private Locator tambahButton;
    private Locator confirmTambahButton;
    private Locator toastMessage;
    private Locator fasePenyewaPilihBiayaBookingButton;
    private Locator fasePenyewaPilihBiayaStayButton;

    public addAdditionalFeePO(Page page){
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        tambahBiayaTambahanButton = page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Tambah Biaya Tambahan").setExact(true));
        additionalFeeNameField = page.getByTestId("input-fee-name");
        namaBiayaErrorMessage = page.locator(".bg-c-field__message");
        tipePembayaranTetapRadioButton = page.locator("label").filter(new Locator.FilterOptions().setHasText("Tetap"));
        tipePembayaranSatuKaliRadioButton = page.locator("label").filter(new Locator.FilterOptions().setHasText("Satu Kali"));
        waktuPenentuanHargaBiayaDitentukanDiawalRadioButton = page.locator("label").filter(new Locator.FilterOptions().setHasText("Ditentukan di Awal"));
        waktuPenentuanHargaBiayaDisesuaikanDenganTagihanRadioButton = page.locator("label").filter(new Locator.FilterOptions().setHasText("Disesuaikan dengan Tagihan"));
        penyewaBisaPilihMandiriYaRadioButton = page.locator("label[for='tenant-can-choose-0']");
        penyewaBisaPilihMandiriTidakRadioButton = page.locator("label[for='tenant-can-choose-1']");
        kategoriAasuransiYaRadioButton = page.locator("label[for='insurance-options-0']");
        kategoriAasuransiNoRadioButton = page.locator("label[for='insurance-options-1']");
        tambahButton = page.getByTestId("tambah-btn");
        confirmTambahButton = page.getByTestId("simpan-btn");
        toastMessage = page.locator(".global-toast");
        fasePenyewaPilihBiayaBookingButton = page.locator("label").filter(new Locator.FilterOptions().setHasText("Booking"));
        fasePenyewaPilihBiayaStayButton = page.locator("label").filter(new Locator.FilterOptions().setHasText("Stay"));
    }

    /**
     * click tambah biaya tambahan button
     */
    public void clickTambahBiayaTambahan() {
        playwright.clickOn(tambahBiayaTambahanButton);
    }

    /**
     * input Additional Fee Name
     * @param name
     */
    public void setAdditionalFeeName(String name) {
        if (name.equalsIgnoreCase("=60 char")){
            name = "Additional Fee Test Additional Fee Test Additional Fee Test ";
        } else if (name.equalsIgnoreCase(">60 char")) {
            name = "Additional Fee Test Additional Fee Test Additional Fee Test 123";
        }

        playwright.fill(additionalFeeNameField,name);
    }

    /**
     * Get Nama Biaya Error Message
     * @return String
     */
    public String getNamaBiayaErrorMessage() {
        return playwright.getText(namaBiayaErrorMessage);
    }

    /**
     * Verify is nama biaya error message appear?
     * @return boolean
     */
    public boolean isNamaBiayaErrorMessageAppear() {
        return playwright.isLocatorVisibleAfterLoad(namaBiayaErrorMessage,5000.0);
    }

    /**
     * Choose tipe pembayaran biaya
     * @param tipePembayaran
     */
    public void chooseTipePembayaranBiaya(String tipePembayaran) {
        if (tipePembayaran.equalsIgnoreCase("Tetap")){
            playwright.checkBox(tipePembayaranTetapRadioButton);
        } else if (tipePembayaran.equalsIgnoreCase("Satu Kali")) {
            playwright.checkBox(tipePembayaranSatuKaliRadioButton);
        } else {
            System.out.println("Invalid Tipe Pembayaran Biaya");
        }
    }

    /**
     * Verify waktu penentuan harga Ditentukan Diawal is check
     * @return boolean
     */
    public boolean isWaktuPenentuanHargaBiayaDitentukanDiawalChecked() {
        return playwright.isRadioButtonChecked(waktuPenentuanHargaBiayaDitentukanDiawalRadioButton);
    }

    /**
     * Verify is Biaya Disesuaikan Tagihan Radio Button is visible
     * @return boolean
     */
    public boolean isBiayaDisesuaikanTagihanVisible() {
        return playwright.isLocatorVisibleAfterLoad(waktuPenentuanHargaBiayaDisesuaikanDenganTagihanRadioButton,5000.0);
    }

    /**
     * choose waktu penentuan harga biaya
     * @param waktu
     */
    public void chooseWaktuPenentuanHargaBiaya(String waktu) {
        if (waktu.equalsIgnoreCase("Ditentukan di Awal")){
            playwright.clickOn(waktuPenentuanHargaBiayaDitentukanDiawalRadioButton);
        } else if (waktu.equalsIgnoreCase("Disesuaikan dengan Tagihan")) {
            playwright.clickOn(waktuPenentuanHargaBiayaDisesuaikanDenganTagihanRadioButton);
        }
    }

    /**
     * Verify is penyewa bisa pilih mandiri Tidak button is checked
     * @return
     */
    public boolean isPenyewaBisaPilihMandiriTidakChecked() {
        return playwright.isRadioButtonChecked(penyewaBisaPilihMandiriTidakRadioButton);
    }

    /**
     * Verify is penyewa bisa pilih mandiri Ya button is disabled
     * @return boolean
     */
    public boolean isPenyewaBisaPilihMandiriYaDisabled() {
        return playwright.isButtonDisable(penyewaBisaPilihMandiriYaRadioButton);
    }

    /**
     * Verify is penyewa bisa pilih mandiri Tidak button is disabled
     * @return boolean
     */
    public boolean isPenyewaBisaPilihMandiriTidakDisabled() {
        return playwright.isButtonDisable(penyewaBisaPilihMandiriTidakRadioButton);
    }


    /**
     * submit additional fee
     */
    public void submitAddAdditionalFee() {
        playwright.clickOn(tambahButton);
        playwright.clickOn(confirmTambahButton);
        playwright.hardWait(3000.0);
    }

    /**
     * Get Toast Message
     * @return String
     */
    public String getToastMessage() {
        return playwright.getText(toastMessage);
    }

    /**
     * check is tambah button disable
     * @return boolean
     */
    public boolean isTambahButtonDisable() {
        return playwright.isButtonDisable(tambahButton);
    }

    /**
     * choose penyewa bisa pilih mandiri
     * @param option
     */
    public void choosePenyewaBisaPilihMandiri(String option) {
        if (option.equalsIgnoreCase("Ya")){
            playwright.clickOn(penyewaBisaPilihMandiriYaRadioButton);
        } else if (option.equalsIgnoreCase("Tidak")) {
            playwright.clickOn(penyewaBisaPilihMandiriTidakRadioButton);
        } else {
            System.out.println("Invalid Option");
        }
    }

    /**
     * select fase penyewa pilih biaya
     * @param option
     */
    public void selectFasePenyewaPilihBiaya(String option) {
        if (option.equalsIgnoreCase("Booking")){
            playwright.clickOn(fasePenyewaPilihBiayaBookingButton);
        } else if (option.equalsIgnoreCase("Stay")) {
            playwright.clickOn(fasePenyewaPilihBiayaStayButton);
        } else {
            System.out.println("Invalid Option");
        }
    }

    /**
     * Select satuan waktu biaya
     * @param waktu
     */
    public void selectSatuanWaktuBiaya(String waktu) {
        satuanBiaya = page.locator("label").filter(new Locator.FilterOptions().setHasText(waktu)); //page.getByText("checkmarkBulanan")
        playwright.clickOn(satuanBiaya);
    }

    /**
     * Select satuan besaran biaya
     * @param besaran
     */
    public void selectSatuanBesaranBiaya(String besaran) {
        satuanBiaya = page.locator("label").filter(new Locator.FilterOptions().setHasText(besaran)); //page.getByText("checkmarkBulanan")
        playwright.clickOn(satuanBiaya);
    }

    /**
     * Choose kategori asuransi
     * @param option
     */
    public void chooseKategoriAsuransi(String option) {
        if (option.equalsIgnoreCase("Ya")) {
            playwright.clickOn(kategoriAasuransiYaRadioButton);
        } else if (option.equalsIgnoreCase("Tidak")) {
            playwright.clickOn(kategoriAasuransiNoRadioButton);
        } else {
            System.out.println("Invalid Option");
        }
    }
}
