package pageobject.pms;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

import java.util.List;

public class HomepagePO {
    private final Page page;
    private final PlaywrightHelpers playwright;

    Locator homepageMenu;
    Locator actionBtn;
    Locator seeDetailBtn;
    Locator roomAllotmentBtn;
    Locator searchInput;
    Locator cariButton;
    Locator unduhCsvButton;

    Locator tambahPenyewaButton;
    Locator bookingButton;
    Locator dropdownTipeBooking;
    Locator newBooking;
    Locator selanjutnyaButton;
    Locator dropdownTypeRoom;
    Locator selectedTypeRoom;
    Locator numberHandphoneTenant;
    Locator informasiPenyewa;
    Locator informasiPenyewaLabel;
    Locator nameTenant;
    Locator periodHitunganSewa;

    Locator ScrollToHitunganSewaDropdown;
    Locator durasiSewaDropdown;
    Locator checkInDateDropdown;
    Locator datePicker;
    Locator nomorKamar;
    Locator nomorKamarDropDown;
    Locator metodePembayaranDropDown;
    Locator addOtherFee;
    Locator fieldNameFee0;
    Locator inputNameFee0;
    Locator fieldPriceFee0;
    Locator inputPriceFee0;
    Locator fieldNameFee1;
    Locator inputNameFee1;
    Locator fieldPriceFee1;
    Locator inputPriceFee1;
    Locator addOnOtherFee;
    Locator saveButton;
    String date;
    Locator autoDisburseToggle;
    Locator yesBtnInAutoDisburseToggle;

    //-----------create dbet--------//
    Locator dbetButton;

    Locator phoneNumberErrorMessage;

    Locator tenantNameErrorMessage;

    Locator emailTenant;

    Locator emailErrorMessage;

    Locator tenantGender;

    Locator tenantJobs;

    Locator yaSimpanButton;

    //---Kontrak Kerja Sama Tab---//
    Locator kontrakKerjaSamaTab;
    Locator riwayatPerubahanKontrakBtn;
    Locator overviewTab;

    //---Riwayat Perubahan Kontrak---//
    Locator diubahOlehTable;
    Locator roleTable;
    Locator dataYangDiubahTable;
    Locator inputLamaTable;
    Locator inputBaruTable;
    Locator waktuDiubahDate;

    public HomepagePO(Page page) {
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        homepageMenu = page.getByTestId("homepageSidebarMenu");
        actionBtn = page.getByTestId("table-action-trigger").first();
        seeDetailBtn = page.locator("//*[contains(text(),'Lihat Detail')]").first();
        roomAllotmentBtn = page.locator("//*[contains(text(),'Ketersediaan Kamar')]").first();
        searchInput = page.getByPlaceholder("Cari berdasarkan ID, Nama Properti");
        cariButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cari"));
        unduhCsvButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Unduh CSV"));
        tambahPenyewaButton = page.locator("//*[contains(text(),'Tambah Penyewa')]");
        bookingButton = page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Booking"));
        dropdownTipeBooking = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih tipe booking dropdown-down"));
        newBooking = page.locator("a").filter(new Locator.FilterOptions().setHasText("New Booking"));
        selanjutnyaButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Selanjutnya"));
        dropdownTypeRoom = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih tipe kamar dropdown-down"));
        selectedTypeRoom = page.locator("//a[@class='bg-c-dropdown__menu-item bg-u-radius-md']").first();
        numberHandphoneTenant = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Nomor Handphone"));
        informasiPenyewa = page.getByTestId("fieldWithOptions-options");
        nameTenant = page.getByPlaceholder("Masukkan nama penyewa");
        ScrollToHitunganSewaDropdown = page.locator("a").filter(new Locator.FilterOptions().setHasText("Per Bulan"));
        periodHitunganSewa = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih hitungan sewa dropdown-down"));
        checkInDateDropdown = page.getByPlaceholder("Pilih tanggal");
        durasiSewaDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih durasi sewa dropdown-down"));
        informasiPenyewaLabel = page.getByText("Informasi Penyewa");
        datePicker = page.locator("//div[@class='vdp-datepicker__calendar']");
        nomorKamarDropDown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih kamar dropdown-down"));
        nomorKamar = page.locator("//span[normalize-space()='Pilih kamar']//following::a[1]");
        metodePembayaranDropDown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih metode pembayaran dropdown-down"));
        addOtherFee = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Simpan"));
        fieldNameFee0 = page.getByTestId("additionalPriceName0_txt").getByRole(AriaRole.TEXTBOX).first();
        inputNameFee0 = page.locator("(//input[@id='additionalPriceName0_txt'])[1]");
        fieldPriceFee0 = page.getByTestId("additionalPriceValue0_txt").getByRole(AriaRole.TEXTBOX).filter(new Locator.FilterOptions().setHasText("Rp"));
        inputPriceFee0 = page.locator("(//input[@id='additionalPriceValue0_txt'])[1]");
        fieldNameFee1 = page.getByTestId("additionalPriceName0_txt").getByRole(AriaRole.TEXTBOX).first();
        inputNameFee1 = page.locator("(//input[@id='additionalPriceName1_txt'])[1]");
        fieldPriceFee1 = page.getByTestId("additionalPriceValue1_txt").getByRole(AriaRole.TEXTBOX).filter(new Locator.FilterOptions().setHasText("Rp"));
        inputPriceFee1 = page.locator("(//input[@id='additionalPriceValue1_txt'])[1]");
        addOnOtherFee = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tambah"));
        saveButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Simpan"));
        dbetButton = page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("DBET"));
        phoneNumberErrorMessage = page.locator("//div[@label=\"Nomor Handphone\"]//*[@class=\"bg-c-field__message\"]");
        tenantNameErrorMessage = page.locator("//div[@label=\"Nama Penyewa\"]//*[@class=\"bg-c-field__message\"]");
        emailTenant = page.locator("//input[@id=\"inputEmail_txt\"]");
        emailErrorMessage = page.locator("//div[@label=\"Email\"]//*[@class=\"bg-c-field__message\"]");
        tenantGender = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih jenis kelamin dropdown-down"));
        tenantJobs = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih pekerjaan dropdown-down"));
        yaSimpanButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ya, Simpan"));
        autoDisburseToggle = page.getByTestId("autoDisburse-switch");
        yesBtnInAutoDisburseToggle = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ya"));

        //---Kontrak Kerja Sama Tab---//
        kontrakKerjaSamaTab = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Kontrak Kerja Sama"));
        riwayatPerubahanKontrakBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("activity Riwayat Perubahan Kontrak"));
        overviewTab = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Overview"));

        //---Riwayat Perubahan Kontrak---//
        diubahOlehTable = page.locator("td").first();
        roleTable = page.locator("td:nth-child(2)").first();
        dataYangDiubahTable = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("Transfer Pendapatan Otomatis"));
        inputLamaTable = page.locator("tr td:nth-of-type(4)");
        inputBaruTable = page.locator("tr td:nth-of-type(5)");
        waktuDiubahDate = page.locator("tr td:nth-of-type(6)");
    }

    /**
     * Click action button in homepage
     */
    public void clickActionButton() {
        actionBtn.waitFor();
        actionBtn.click();
    }

    /**
     * Click lihat detail menu in homepage
     */
    public void clickSeeDetail() {
        seeDetailBtn.click();
    }

    /**
     * Click ketersediaan kamar menu in homepage
     */
    public void clickRoomAllotment() {
        roomAllotmentBtn.click();
    }

    /**
     * Search property Homepage
     *
     * @param name name or id property
     */
    public void searchProperty(String name) {
        searchInput.fill(name);
        cariButton.click();
    }

    /**
     * Check button is exist or not in page
     *
     * @param button
     * @return boolean
     */
    public boolean isButtonExist(String button) {
        boolean exist = false;
        switch (button) {
            case "Lihat Detail":
                if (playwright.isLocatorVisibleAfterLoad(actionBtn, 3000.0)) {
                    playwright.clickOn(actionBtn);
                    exist = playwright.isLocatorVisibleAfterLoad(seeDetailBtn, 1000.0);
                    playwright.clickOn(actionBtn);
                }
                break;
            case "Ketersediaan Kamar":
                if (playwright.isLocatorVisibleAfterLoad(actionBtn, 3000.0)) {
                    playwright.clickOn(actionBtn);
                    exist = playwright.isLocatorVisibleAfterLoad(roomAllotmentBtn, 1000.0);
                    playwright.clickOn(actionBtn);
                }
                break;
            case "Unduh CSV":
                exist = playwright.isLocatorVisibleAfterLoad(unduhCsvButton, 3000.0);
                break;
            default:
                System.out.println("Invalid button");
        }
        return exist;
    }

    /**
     * Click on tambah penyewa menu in homepage
     */
    public void clickOnTambahPenyewa() {
        tambahPenyewaButton.click();
    }

    /**
     * Click on booking menu in homepage
     */
    public void clickOnBooking() {
        bookingButton.click();
    }

    /**
     * Click on tipe booking menu in popup
     */
    public void clickOnDropdownTipeBooking() {
        dropdownTipeBooking.click();
    }

    /**
     * Click on new booking in dropdown
     */
    public void clickOnNewBooking() {
        newBooking.click();
    }

    /**
     * Click on selanjutnya button in popup
     */
    public void clickOnSelanjutnyaButton() {
        selanjutnyaButton.click();
    }

    /**
     * Click on type room dropdown and selected type room
     */
    public void clickOnTypeRoom() {
        dropdownTypeRoom.click();
        selectedTypeRoom.click();
    }

    /**
     * admin fill phone number tenant
     */
    public void fillNumberHandphoneTenant(String number) {
        numberHandphoneTenant.fill(number);
    }

    /**
     * admin fill name tenant
     */
    public void fillNameTenant(String name) {
        nameTenant.fill(name);
    }

    /**
     * admin see informasi penyewa
     */
    public boolean isInformasiPenyewaDisplayed() {
        playwright.waitFor(informasiPenyewa);
        informasiPenyewa.click();
        return informasiPenyewaLabel.isEnabled();
    }

    /**
     * admin fill hitungan sewa
     */
    public void fillHitunganSewa(String hitunganSewaKos) {
        playwright.pageScrollUntilElementIsVisible(ScrollToHitunganSewaDropdown);
        periodHitunganSewa.click();
        String periodHitunganSewa = "//a[contains(.,'" + hitunganSewaKos + "')]";
        ElementHandle element = page.querySelector(periodHitunganSewa);
        element.click();
    }

    /**
     * admin fill tanggal Check in
     */
    public void fillTanggalCheckInKos(String date) {
        Locator datePick;
        if (date.equalsIgnoreCase("tomorrow")) {
            this.date = JavaHelpers.getCostumDateOrTime("d", 1, 0, 0);
        } else if (date.equalsIgnoreCase("today")) {
            this.date = JavaHelpers.getCurrentDateOrTime("d");
        } else {
            this.date = date;
        }
        checkInDateDropdown.click();
        playwright.waitFor(datePicker, 5000.0);
        datePick = page.locator("//div[@class='date-wrapper']").getByText(this.date);
        List<Locator> datePicks = playwright.getLocators(datePick);
        for (Locator pick : datePicks) {
            if (pick.isEnabled() && pick.isVisible()) {
                pick.click();
            }
        }
    }

    /**
     * admin fill durasi sewa
     */
    public void fillDurasiSewa(String durasiSewa) {
        durasiSewaDropdown.click();
        String durasiSewaKos = "//div[normalize-space()='" + durasiSewa + "']";
        ElementHandle element = page.querySelector(durasiSewaKos);
        element.click();
    }

    /**
     * admin fill nomor kamar
     */
    public void fillNomorKamar() {
        nomorKamarDropDown.click();
        nomorKamar.click();
    }

    /**
     * admin fill metode pembayaran
     */
    public void fillMetodePembayaran(String fullPayment) {
        metodePembayaranDropDown.click();
        String metodePembayaran = "//p[normalize-space()='" + fullPayment + "']";
        ElementHandle element = page.querySelector(metodePembayaran);
        element.click();
    }

    /**
     * admin fill other fee
     */

    public void fillOtherFeeName(String nameFee0, String nameFee1) {
        playwright.pageScrollUntilElementIsVisible(addOtherFee);
        playwright.clickOn(addOnOtherFee);
        playwright.clickOn(fieldNameFee0);
        playwright.fill(inputNameFee0, nameFee0);
        playwright.clickOn(fieldNameFee1);
        playwright.fill(inputNameFee1, nameFee1);
    }

    /**
     * admin fill other fee amount
     */

    public void fillOtherFeeAmount(String priceFee0, String priceFee1) {
        playwright.clickOn(fieldPriceFee0);
        playwright.fill(inputPriceFee0, priceFee0);
        playwright.clickOn(fieldPriceFee1);
        playwright.fill(inputPriceFee1, priceFee1);
    }

    /**
     * admin click on save button
     */
    public void clickOnSaveButton() {
        playwright.clickOn(saveButton);
    }

    /**
     * admin see Informasi Biaya Lain Displayed
     */

    public boolean isInformasiBiayaLainDisplayed(String nameFee0, String nameFee1, String amountFee0, String amountFee1) {
        String listrik = "//p[normalize-space()='" + nameFee0 + "']";
        String parkir = "//p[normalize-space()='" + nameFee1 + "']";
        String harga0 = "(//p[@class='bg-c-text bg-c-text--body-1 price-list-item__price-label'][normalize-space()='" + amountFee0 + "'])[1]";
        String harga1 = "(//p[@class='bg-c-text bg-c-text--body-1 price-list-item__price-label'][normalize-space()='" + amountFee1 + "'])[2]";
        return page.querySelector(listrik) != null && page.querySelector(parkir) != null && page.querySelector(harga0) != null && page.querySelector(harga1) != null;
    }

    /**
     * admin click on dbet button
     */
    public void clickDbetButton() {
        playwright.clickOn(dbetButton);
    }

    /**
     * admin see phone number error message
     *
     * @return
     */
    public String getPhoneNumberErrorMessage() {
        return playwright.getText(phoneNumberErrorMessage);
    }

    /**
     * admin see tenant name error message
     *
     * @return
     */
    public String getTenantNameErrorMessage() {
        return playwright.getText(tenantNameErrorMessage);
    }

    /**
     * admin fill email
     *
     * @param email
     */
    public void fillEmailTenant(String email) {
        emailTenant.fill(email);
    }

    /**
     * admin see email error message
     *
     * @return
     */
    public String getEmailErrorMessage() {
        return playwright.getText(emailErrorMessage);
    }

    /**
     * admin click on ya simpan button
     */
    public void clickOnYaSimpanButton() {
        playwright.clickOn(yaSimpanButton);
    }

    /**
     * admin see status booking waiting for payment
     *
     * @return
     */
    public String getStatusBooking(String text) {
        Locator statusBooking = page.locator("//*[contains(text(),'" + text + "')]");
        return playwright.getText(statusBooking);
    }

    /**
     * Set Auto Disbursement toggle
     */
    public void setToggleAutoDisbursement() {
        playwright.clickOn(autoDisburseToggle);
        playwright.clickOn(yesBtnInAutoDisburseToggle);
    }

    /**
     * Get String Diubah oleh in Riwayat Perubahan Kontrak table
     * @return String Diubah oleh
     */
    public String getDiubahOleh() {
        return playwright.getText(diubahOlehTable);
    }

    /**
     * Get String Role in Riwayat Perubahan Kontrak table
     * @return String Role
     */
    public String getRole() {
        return playwright.getText(roleTable);
    }

    /**
     * Get String Data yang diubah in Riwayat Perubahan Kontrak table
     * @return String Data yang diubah
     */
    public String getDataYangDiubah() {
        return playwright.getText(dataYangDiubahTable.first());
    }

    /**
     * Get String Input Lama in Riwayat Perubahan Kontrak table
     * @return String Input Lama
     */
    public String getInputLama() {
        return playwright.getText(inputLamaTable.first());
    }

    /**
     * Get String Input Baru in Riwayat Perubahan Kontrak table
     * @return String Input Baru
     */
    public String getInputBaru() {
        return playwright.getText(inputBaruTable.first());
    }

    /**
     * Get String Waktu Diubah in Riwayat Perubahan Kontrak table
     * @return String Waktu Diubah
     */
    public String getWaktuDiubah() {
        return playwright.getText(waktuDiubahDate.first()).substring(0, 10);
    }

    /**
     * Clicks Kontrak Kerja Sama tab
     */
    public void goToKontrakKerjaSamaTab() {
        playwright.clickOn(kontrakKerjaSamaTab);
    }

    /**
     * Clicks Riwayat Perubahan Kontrak
     */
    public void clicksRiwayatPerubahanKontrak() {
        playwright.clickOn(riwayatPerubahanKontrakBtn);
    }

    /**
     * Clicks Overview tab
     */
    public void goToOverviewTab() {
        //back to kontrak kerja sama page
        playwright.backToPreviousPage();

        playwright.clickOn(overviewTab);
    }

    public void clicksHomepage() {
        playwright.clickOn(homepageMenu);
    }
}