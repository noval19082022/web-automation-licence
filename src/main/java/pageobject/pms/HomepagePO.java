package pageobject.pms;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

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
    Locator emptyStateTitleInHomepage;
    Locator emptyStateSubtitleInHomepage;
    Locator ketersediaanKamarBtn;
    Locator propertyListings;
    Locator outsideActionButton;
    Locator propertyRow;

    Locator RoomNotAvailable;
    Locator selectMethodPayment;
    Locator selectMethodPaymentFullPayment;

    //---Filter---//
    Locator filterBtn;
    Locator totalFilter;
    Locator tglLiveMulai;
    Locator monthYear;
    Locator year;
    Locator monthOctober;
    Locator monthDecember;
    Locator selectDate;
    Locator terapkanBtn;
    Locator tglLiveAkhir;
    Locator tglExpiredMulai;
    Locator year2023;
    Locator tglExpiredAkhir;
    Locator year2024;
    Locator year2025;
    Locator pilihProdukDropdown;
    Locator produkValue;
    Locator pilihBSEDropdown;
    Locator BSEValue;
    Locator pilihBDDropdown;
    Locator BDValue;
    Locator pilihASDropdown;
    Locator ASValue;
    Locator pilihHospitalityDropdown;
    Locator hospitalityValue;
    Locator pilihKotaDropdown;
    Locator kotaValue;
    Locator clicksClearBtn;
    Locator namaPropertiInTable;
    Locator kotaInTable;
    Locator produkInTable;
    Locator BSEInTable;
    Locator BDInTable;
    Locator ASInTable;
    Locator hospitalityInTable;
    Locator resetBtn;

    Locator tambahPenyewaButton;
    Locator bookingButton;
    Locator dropdownTipeBooking;
    Locator newBooking;
    Locator selanjutnyaButton;
    Locator dropdownTypeRoom;
    Locator selectedTypeRoom;
    Locator kostSelectedType;
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
    Locator listItemName;
    Locator listItemName1;
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
    Locator totalPropertyText;

    //-----------create dbet--------//
    Locator dbetButton;
    Locator phoneNumberErrorMessage;
    Locator tenantNameErrorMessage;
    Locator emailTenant;
    Locator emailErrorMessage;
    Locator tenantGender;
    Locator tenantJobs;
    Locator yaSimpanButton;
    Locator dbetCategoryButton;
    Locator contractIdText;
    Locator notestext;
    Locator notesCountertext;
    Locator contractIdErrorMessage;

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

    //-------Billing tracker--------//
    Locator billingTrackerMenu;

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
        inputNameFee0 = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search"));
        listItemName = page.getByTestId("additionalFeeInput_listItem").locator("a");
        listItemName1 = page.locator("a").filter(new Locator.FilterOptions().setHasText("Parkir Mobil"));
        fieldPriceFee0 = page.getByTestId("additionalPriceValue0_txt").getByRole(AriaRole.TEXTBOX).filter(new Locator.FilterOptions().setHasText("Rp"));
        inputPriceFee0 = page.locator("#additionalFeeInput_price0_txt");
        fieldNameFee1 = page.getByTestId("additionalPriceName0_txt").getByRole(AriaRole.TEXTBOX).first();
        inputNameFee1 = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search"));
        fieldPriceFee1 = page.getByTestId("additionalPriceValue1_txt").getByRole(AriaRole.TEXTBOX).filter(new Locator.FilterOptions().setHasText("Rp"));
        inputPriceFee1 = page.locator("#additionalFeeInput_price1_txt");
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
        emptyStateTitleInHomepage = page.getByText("Data Tidak Ditemukan", new Page.GetByTextOptions().setExact(true));
        emptyStateSubtitleInHomepage = page.getByText("Data tidak ditemukan di filter atau kata kunci yang Anda gunakan.");
        ketersediaanKamarBtn = page.getByText("Ketersediaan Kamar");
        propertyListings = page.locator("tbody tr").first();
        outsideActionButton = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("Hospitality"));
        propertyRow = page.locator("tbody tr");
        RoomNotAvailable = page.locator("//div[contains(text(),'Kamar tidak tersedia')]");
        selectMethodPayment = page.locator("//span[normalize-space()='Pilih metode pembayaran']");
        selectMethodPaymentFullPayment = page.locator("//p[normalize-space()='Full Payment']");
        dbetCategoryButton = page.locator("//div[@data-testid=\"categorySelect_ddl\"]//div[@class=\"bg-c-select__trigger bg-c-select__trigger--lg\"]");
        contractIdText = page.locator("//input[@id=\"contractId_txt\"]");
        notestext = page.getByPlaceholder("Isi catatan di sini");
        notesCountertext = page.locator(".bg-c-textarea__counter");
        contractIdErrorMessage = page.locator("//div[@label=\"Contract ID\"]//*[@class=\"bg-c-field__message\"]");

        //---Filter---//
        filterBtn = page.locator("//span[contains(., 'Filter')]");
        totalFilter = page.locator(".bg-c-badge-counter");
        tglLiveMulai = page.getByTestId("homeFilterModalDate-datePickerStart").getByPlaceholder("Pilih tanggal mulai");
        terapkanBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Terapkan"));
        tglLiveAkhir = page.getByTestId("homeFilterModalDate-datePickerEnd").getByPlaceholder("Pilih tanggal akhir");
        tglExpiredMulai = page.getByTestId("undefined-datePickerStart").getByPlaceholder("Pilih tanggal mulai");
        tglExpiredAkhir = page.getByTestId("undefined-datePickerEnd").getByPlaceholder("Pilih tanggal akhir");
        pilihProdukDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih produk dropdown-down"));
        pilihBSEDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih BSE dropdown-down"));
        pilihBDDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih BD dropdown-down"));
        pilihASDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih AS dropdown-down"));
        pilihHospitalityDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih Hospitality dropdown-down"));
        pilihKotaDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih kota dropdown-down"));
        clicksClearBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("close-round"));
        totalPropertyText = page.locator(".total-data");

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

        //-------------Billing Tracker------------//
        billingTrackerMenu = page.getByTestId("billingTrackerSideMenu");
    }

    /**
     * Click action button in homepage
     */
    public void clicksActionButton() {
        playwright.waitFor(actionBtn);
        playwright.clickOn(actionBtn);
    }

    /**
     * Click lihat detail menu in homepage
     */
    public void clickSeeDetail() {
        playwright.clickOn(seeDetailBtn);
    }

    /**
     * Click ketersediaan kamar menu in homepage
     */
    public void clickRoomAllotment() {
        roomAllotmentBtn.click();
        playwright.hardWait(15000.0);
    }

    /**
     * Search property Homepage
     * @param name name or id property
     */
    public void searchProperty(String name) {
        searchInput.fill(name);
        playwright.clickOn(cariButton);
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
        playwright.hardWait(10000.0);
        playwright.clickOn(tambahPenyewaButton);
    }

    /**
     * Click on booking menu in homepage
     */
    public void clickOnBooking() {
        playwright.clickOn(bookingButton);
    }

    /**
     * Click on tipe booking menu in popup
     */
    public void clickOnDropdownTipeBooking() {
        playwright.clickOn(dropdownTipeBooking);
    }

    /**
     * Click on new booking in dropdown
     */
    public void clickOnNewBooking() {
        playwright.clickOn(newBooking);
    }

    /**
     * Click on selanjutnya button in popup
     */
    public void clickOnSelanjutnyaButton() {
        playwright.clickOn(selanjutnyaButton);
        playwright.hardWait(2000);
    }

    /**
     * Click on type room dropdown and selected type room
     */
    public void clickOnTypeRoom() {
        playwright.waitFor(dropdownTypeRoom);
        playwright.clickOn(dropdownTypeRoom);
        playwright.clickOn(selectedTypeRoom);
    }

    /**
     * Select dbet category
     * @param text
     */
    public void selectDbetCategory(String text){
        playwright.clickOn(dbetCategoryButton);
        Locator categoryNametext = page.locator("a").filter(new Locator.FilterOptions().setHasText(""+text+""));
        playwright.clickOn(categoryNametext);
    }

    /**
     * click on dbet category
     */
    public void clickDbetCategoryButton(){
        playwright.clickOn(dbetCategoryButton);
    }

    /**
     * validate category dbet is visible
     * @param option
     * @return option
     */
    public String getDbetCategoryResult(String option){
        Locator categoryNametext = page.locator("a").filter(new Locator.FilterOptions().setHasText(""+option+""));
        return playwright.getText(categoryNametext);
    }

    /**
     * Assert contract id button when disable
     */
    public void assertContractIdDisable(){;
        assertThat(contractIdText).isDisabled();
    }

    /**
     * Assert contract id button when enabled
     */
    public void assertContractIdEnabled(){;
        assertThat(contractIdText).isEnabled();
    }

    /**
     * input contract id
     * @param number
     */
    public void fillContractId(String number){
        contractIdText.fill(number);
        Locator contractIdText = page.getByTestId("fieldWithOptions-options").locator("a");
        playwright.clickOn(contractIdText);
    }

    /**
     * get error message on contract id
     * @return
     */
    public String errorTextVisible(){
        return playwright.getText(contractIdErrorMessage);
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
        playwright.clickOn(informasiPenyewa);
        return informasiPenyewaLabel.isEnabled();
    }

    /**
     * admin fill hitungan sewa
     */
    public void fillHitunganSewa(String hitunganSewaKos) {
        playwright.pageScrollUntilElementIsVisible(ScrollToHitunganSewaDropdown);
        playwright.clickOn(periodHitunganSewa);
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
        playwright.clickOn(durasiSewaDropdown);
        String durasiSewaKos = "//div[normalize-space()='" + durasiSewa + "']";
        ElementHandle element = page.querySelector(durasiSewaKos);
        element.click();
    }

    /**
     * admin fill nomor kamar
     */
    public void fillNomorKamar() {
        playwright.clickOn(nomorKamarDropDown);
        if (playwright.waitTillLocatorIsVisible(RoomNotAvailable)) {
            playwright.assertVisible(RoomNotAvailable);
        } else {
            playwright.clickOn(nomorKamar);
        }
    }

    /**
     * admin fill metode pembayaran
     */
    public void fillMetodePembayaran(String fullPayment) {
        playwright.clickOn(metodePembayaranDropDown);
        if (playwright.waitTillLocatorIsVisible(selectMethodPaymentFullPayment)) {
            String metodePembayaran = "//p[normalize-space()='" + fullPayment + "']";
        ElementHandle element = page.querySelector(metodePembayaran);
        element.click();
        } else {
            playwright.assertVisible(selectMethodPayment);
        }
    }

    /**
     * admin fill other fee
     */

    public void fillOtherFeeName(String nameFee0, String nameFee1) {
        playwright.pageScrollUntilElementIsVisible(addOtherFee);
        playwright.clickOn(page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih biaya tambahan dropdown-down")));
        playwright.fill(inputNameFee0, nameFee0);
        playwright.clickOn(listItemName);
        playwright.clickOn(addOnOtherFee);
        playwright.clickOn(page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih biaya tambahan dropdown-down")));
        playwright.fill(inputNameFee1, nameFee1);
        Locator addFeeList = page.locator("a").filter(new Locator.FilterOptions().setHasText(nameFee1));
        playwright.clickOn(addFeeList);
    }

    /**
     * admin fill other fee amount
     */

    public void fillOtherFeeAmount(String amountFee0, String amountFee1) {
        playwright.clickOn(inputPriceFee0);
        playwright.fill(inputPriceFee0, amountFee0);
        playwright.clickOn(inputPriceFee1);
        playwright.fill(inputPriceFee1, amountFee1);
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
        String harga0 = "//p['" + amountFee0 + "']";
        String harga1 = "//p['" + amountFee1 + "']";
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
        playwright.hardWait(100);
        playwright.clickOn(yaSimpanButton);
    }

    /**
     * admin see status booking waiting for payment
     *
     * @return
     */
    public String getStatusBooking(String text) {
        Locator statusBooking = page.locator("//*[contains(text(),'" + text + "')]");
        playwright.waitTillPageLoaded();
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
        playwright.backToPreviousPage();
        playwright.clickOn(overviewTab);
    }

    /**
     * Clicks Homepage menu
     */
    public void clicksHomepage() {
        playwright.clickOn(homepageMenu);
    }

    /**
     * Get String Empty State Title in Homepage menu
     * @return String Empty State Title
     */
    public String getEmptyStateTitleInHomepage() {
        return playwright.getText(emptyStateTitleInHomepage);
    }

    /**
     * Get String Empty State Subtitle in Homepage menu
     * @return String Empty State Subtitle
     */
    public String getEmptyStateSubtitleInHomepage() {
        return playwright.getText(emptyStateSubtitleInHomepage);
    }

    /**
     * Get String URL in Detail Property
     * @return String URL in Detail Property
     */
    public String getURLDetailProperty(){
        return playwright.getPageUrl();
    }

    /**
     * Clicks on Ketersediaan Kamar button in Kebab button
     */
    public void clicksKetersediaanKamarButton() {
        playwright.clickOn(ketersediaanKamarBtn);
    }

    /**
     * Get String URL in Room Allotment
     * @return String URL in Room Allotment
     */
    public String getURLRoomAllotmentPage() {
        return playwright.getPageUrl();
    }

    /**
     * Search Property using Property ID
     * @param id
     */
    public void searchPropertyId(String id) {
        playwright.fill(searchInput, id);
        playwright.clickOn(cariButton);
    }

    /**
     * Clicks on Filter in Homepage
     */
    public void clicksFilter() {
        playwright.clickOn(filterBtn);
    }

    /**
     * Selects Date in Tanggal Mulai at Tanggal Live section
     * @param tanggalLiveMulai
     */
    public void inputsTanggalMulaiLiveDate(String tanggalLiveMulai) {
        playwright.clickOn(tglLiveMulai);

        //clicks Bulan Tahun in Calendar View
        monthYear = page.locator("//span[@class='day__month_btn up']");
        playwright.clickOn(monthYear);

        //clicks Tahun in Calendar View
        year = page.locator("//span[@class='month__year_btn up']");
        playwright.clickOn(year);

        //clicks Year 2023
        year2023 = page.locator("//span[8]");
        playwright.clickOn(year2023);

        //clicks Month October
        monthOctober = page.locator("//span[10]");
        playwright.clickOn(monthOctober);

        //select date based on parameter
        selectDate = page.getByTestId("homeFilterModalDate-datePickerStart").getByText(tanggalLiveMulai, new Locator.GetByTextOptions().setExact(true)).first();
        playwright.clickOn(selectDate);
    }

    /**
     * Selects Date in Tanggal Akhir at Tanggal Live section
     * @param tanggalLiveAkhir
     */
    public void inputsTanggalAkhirLiveDate(String tanggalLiveAkhir) {
        playwright.clickOn(tglLiveAkhir);

        //clicks Bulan Tahun in Calendar View
        monthYear = page.locator("//span[@class='day__month_btn up']");
        playwright.clickOn(monthYear);

        //clicks Tahun in Calendar View
        year = page.locator("//span[@class='month__year_btn up']");
        playwright.clickOn(year);

        //clicks Year 2024
        year2024 = page.locator("//span[9]");
        playwright.clickOn(year2024);

        //clicks Month October
        monthOctober = page.locator("//span[10]");
        playwright.clickOn(monthOctober);

        //select date based on parameter
        selectDate = page.getByTestId("homeFilterModalDate-datePickerEnd").getByText(tanggalLiveAkhir, new Locator.GetByTextOptions().setExact(true)).first();
        playwright.clickOn(selectDate);
    }

    /**
     * Selects Date in Tanggal Mulai at Tanggal Expired section
     * @param tanggalExpiredMulai
     */
    public void inputsTanggalMulaiExpiredDate(String tanggalExpiredMulai) {
        playwright.clickOn(tglExpiredMulai);

        //clicks Bulan Tahun in Calendar View
        monthYear = page.locator("//span[@class='day__month_btn up']");
        playwright.clickOn(monthYear);

        //clicks Tahun in Calendar View
        year = page.locator("//span[@class='month__year_btn up']");
        playwright.clickOn(year);

        //clicks Year 2024
        year2024 = page.locator("//span[9]");
        playwright.clickOn(year2024);

        //clicks Month October
        monthOctober = page.locator("//span[10]");
        playwright.clickOn(monthOctober);

        //select date based on parameter
        selectDate = page.getByTestId("undefined-datePickerStart").getByText(tanggalExpiredMulai, new Locator.GetByTextOptions().setExact(true)).first();
        playwright.clickOn(selectDate);
    }

    /**
     * Selects Date in Tanggal Akhir at Tanggal Expired section
     * @param tanggalExpiredAkhir
     */
    public void inputsTanggalAkhirExpiredDate(String tanggalExpiredAkhir) {
        playwright.clickOn(tglExpiredAkhir);

        //clicks Bulan Tahun in Calendar View
        monthYear = page.locator("//span[@class='day__month_btn up']");
        playwright.clickOn(monthYear);

        //clicks Tahun in Calendar View
        year = page.locator("//span[@class='month__year_btn up']");
        playwright.clickOn(year);

        //clicks Year 2025
        year2025 = page.locator("//span[10]");
        playwright.clickOn(year2025);

        //clicks Month December
        monthDecember = page.locator("//span[12]");
        playwright.clickOn(monthDecember);

        //select date based on parameter
        selectDate = page.getByTestId("undefined-datePickerEnd").getByText(tanggalExpiredAkhir);
        playwright.clickOn(selectDate);
    }

    /**
     * Ticks on Produk Dropdown
     * @param pilihProduk
     */
    public void ticksProduk(String pilihProduk) {
        playwright.clickOn(pilihProdukDropdown);

        produkValue = page.getByRole(AriaRole.LIST).getByText(pilihProduk);
        playwright.clickOn(produkValue);
    }

    /**
     * Ticks on BSE Dropdown
     * @param pilihBSE
     */
    public void ticksBSE(String pilihBSE) {
        playwright.clickOn(pilihBSEDropdown);
        BSEValue = page.locator("label[for='search-checkbox-bse-30']");
        playwright.pageScrollInView(BSEValue);
        playwright.clickOn(BSEValue);
    }

    /**
     * Ticks on BD Dropdown
     * @param pilihBD
     */
    public void ticksBD(String pilihBD) {
        playwright.clickOn(pilihBDDropdown);
        BDValue = page.getByText(pilihBD);
        playwright.clickOn(BDValue);
    }

    /**
     * Ticks on AS Dropdown
     * @param pilihAS
     */
    public void ticksAS(String pilihAS) {
        playwright.clickOn(pilihASDropdown);
        ASValue = page.getByRole(AriaRole.LIST).getByText(pilihAS);
        playwright.clickOn(ASValue);
    }

    /**
     * Ticks on Hospitality Dropdown
     * @param pilihHospitality
     */
    public void ticksHospitality(String pilihHospitality) {
        playwright.clickOn(pilihHospitalityDropdown);
        hospitalityValue = page.getByText(pilihHospitality);
        playwright.clickOn(hospitalityValue);
    }

    /**
     * Selects on Kota Dropdown
     * @param pilihKota
     */
    public void selectsKota(String pilihKota) {
        playwright.pageScrollInView(pilihKotaDropdown);
        playwright.clickOn(pilihKotaDropdown);
        kotaValue = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(pilihKota));
        playwright.clickOn(kotaValue);
    }

    /**
     * Clear Keyword
     * With clicks on Close (x) in search bar
     */
    public void clearKeyword() {
        playwright.clickOn(clicksClearBtn);
    }

    /**
     * Get String Nama Properti in Homepage Table
     * @param namaProperti
     * @return String Nama Properti in Homepage Table
     */
    public String getNamaPropertiInTable(String namaProperti) {
        namaPropertiInTable = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(namaProperti));
        return playwright.getText(namaPropertiInTable);
    }

    /**
     * Get String Kota in Homepage Table
     * @param kota
     * @return String Kota in Homepage Table
     */
    public String getKotaInTable(String kota) {
        kotaInTable = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(kota));
        return playwright.getText(kotaInTable);
    }

    /**
     * Get String Produk in Homepage Table
     * @param produk
     * @return String Produk in Homepage Table
     */
    public String getProdukInTable(String produk) {
        produkInTable = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(produk).setExact(true));
        return playwright.getText(produkInTable);
    }

    /**
     * Get String BSE in Homepage Table
     * @param bse
     * @return String BSE in Homepage Table
     */
    public String getBSEInTable(String bse) {
        BSEInTable = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(bse));
        return playwright.getText(BSEInTable);
    }

    /**
     * Get String BD in Homepage Table
     * @param bd
     * @return String BD in Homepage Table
     */
    public String getBDInTable(String bd) {
        BDInTable = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(bd));
        return playwright.getText(BDInTable);
    }

    /**
     * Get String AS in Homepage Table
     * @param as
     * @return String AS in Homepage Table
     */
    public String getASInTable(String as) {
        ASInTable = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(as));
        return playwright.getText(ASInTable);
    }

    /**
     * Get String Hospitality in Homepage Table
     * @param hospitality
     * @return String Hospitality in Homepage Table
     */
    public String getHospitality(String hospitality) {
        hospitalityInTable = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(hospitality));
        return playwright.getText(hospitalityInTable);
    }

    /**
     * Check is total property visible
     * @return boolean
     */
    public boolean isTotalPropertyVisible() {
        return playwright.isLocatorVisibleAfterLoad(totalPropertyText,10000.0);
    }

    /**
     * Clicks Reset button
     */
    public void clicksReset() {
        resetBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Reset"));
        playwright.clickOn(resetBtn);
    }

    /**
     * Clicks Reset button inside filter modal
     */
    public void clicksResetFilterModal() {
        resetBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Reset")).first();
        playwright.clickOn(resetBtn);
    }

    /**
     * Check if Keyword is still visible after clear keyword
     * True = blank / not visible
     * False = not blank / visible
     * @return Keyword is still visible
     */
    public boolean isKeywordVisible() {
        return playwright.isDataBlankorNull(searchInput);
    }

    /**
     * Get String Keyword in search bar
     * @return String Keyword
     */
    public String getKeyword() {
        return playwright.getInputValue(searchInput);
    }

    //---------------billing tracker---------//

    /**
     * click on Billing tracker menu
     */
    public void clickBillingTrackerMenu(){
        playwright.clickOn(billingTrackerMenu);
    }

    //---BSE Filter---//

    /**
     * Clicks Dropdown BSE
     * And scroll down to BSE value
     * Then clicks BSE value
     * @param filter
     */
    public void filterBSE(String filter) {
        playwright.clickOn(pilihBSEDropdown);
        BSEValue = page.locator("(//div[@data-testid='search-checkbox-dropdown'])[3]//p[contains(., '" +filter+ "')]");
        playwright.pageScrollInView(BSEValue);
        playwright.clickOn(BSEValue);
    }

    /**
     * Get String All BSE Value in Table
     * @param indexBSE ke-i
     * @return String All BSE Value
     */
    public String getAllBSEValueInTable(int indexBSE) {
        BSEInTable = page.locator("tr td:nth-of-type(5)").nth(indexBSE);
        return playwright.getText(BSEInTable);
    }

    /**
     * Clicks Terapkan button in Filter
     */
    public void clicksTerapkanBtn() {
        playwright.clickOn(terapkanBtn);
    }

    /**
     * Get String All Kota Value in Table
     * @param indexKota ke-i
     * @return String All Kota Value
     */
    public String getAllKotaValueInTable(int indexKota) {
        kotaInTable = page.locator("tr td:nth-of-type(3)").nth(indexKota);
        return playwright.getText(kotaInTable);
    }

    /**
     * Get String All Produk Value in Table
     * @param indexProduk value ke-i
     * @return String All Produk Value
     */
    public String getAllProdukValueInTable(int indexProduk) {
        produkInTable = page.locator("tr td:nth-of-type(4)").nth(indexProduk);
        return playwright.getText(produkInTable);
    }

    /**
     * Get Total Row in Daftar Properti page
     * @return Total Row
     */
    public int getTotalRow(){
        BSEInTable = page.locator("tr td:nth-of-type(5)");
        return BSEInTable.count();
    }

    /**
     * Clicks Cari Button
     */
    public void clicksCariButton() {
        playwright.clickOn(cariButton);
    }

    /**
     * Check if Property Displayed
     * True = displayed
     * False = not displayed
     * @return Property Displayed
     */
    public boolean isPropertyDisplayed() {
        return playwright.isLocatorVisibleAfterLoad(propertyListings, 50000.0);
    }
    //---End of BSE Filter---//

    /**
     * Retrieves the total filter value from the totalFilter element and returns it as an integer.
     *
     * @return the total filter value as an integer
     */
    public int getTotalFilter() {
        return Integer.parseInt(totalFilter.textContent().trim());
    }

    //-----------add fee MVP----------//
    /**
     * get empty state text on pms
     * @param text
     * @return text example : Tidak ada biaya tambahan yang tersedia di kos ini.
     */
    public Boolean getEmptyState(String text){
        Locator emptyPmsKKText = page.locator("//p[normalize-space()='" +text+ "']");
        playwright.pageScrollInView(emptyPmsKKText);
        return playwright.waitTillLocatorIsVisible(emptyPmsKKText,2000.0);
    }

    /**
     * Check is Disesuaikan dengan Tagihan is displayed
     * @param text
     * @return text "Disesuaikan dengan Tagihan"
     */
    public boolean getPriceTextNewRules(String text){
        Locator priceTextAddFee = page.locator("//*[contains(text(),'"+text+"')]");
        return playwright.waitTillLocatorIsVisible(priceTextAddFee);
    }

    /**
     * verify add fee from pms kk on booking form
     * @param addfeetext
     * @return text
     */
    public boolean getAddFeeKK(String addfeetext){
        Locator addFeeKKtext = page.locator("//p[contains(.,'"+addfeetext+"')]");
        return playwright.waitTillLocatorIsVisible(addFeeKKtext);
    }

    public boolean getAddFeeSelected(String addfeename){
        Locator addFeeSelectedText = page.locator("//input[@name =\"costs[fixed][0][name]\"]");
        return playwright.waitTillLocatorIsVisible(addFeeSelectedText);
    }



    //---Daftar Properti---//

    /**
     * Check if Lihat Detail button is displayed
     * True = displayed
     * False = not displayed
     * @return if Lihat Detail button is displayed
     */
    public boolean isLihatDetailButtonVisible(){
        playwright.waitTillLocatorIsVisible(seeDetailBtn);
        return playwright.isLocatorVisibleAfterLoad(seeDetailBtn, 50000.0);
    }

    /**
     * Check if Ketersediaan Kamar button is displayed
     * True = displayed
     * False = not displayed
     * @return if Ketersediaan Kamar button is displayed
     */
    public boolean isKetersediaanKamarButtonVisible(){
        return playwright.isLocatorVisibleAfterLoad(roomAllotmentBtn, 30000.0);
    }

    /**
     * Clicks Outside Action Button
     */
    public void clicksOutsideActionButton() {
        playwright.clickOn(outsideActionButton);
    }

    /**
     * Get Total Properties
     * @return Total Properties
     */
    public int getTotalProperties(){
        return propertyRow.count();
    }

    /**
     * Get String All Nama Properti
     * @param indexNamaProperti
     * @return String All Nama Properti
     */
    public String getAllNamaProperti(int indexNamaProperti){
        namaPropertiInTable = page.locator("tr td:nth-of-type(2)").nth(indexNamaProperti);
        return playwright.getText(namaPropertiInTable);
    }
    //---End of Daftar Properti---//

    //-----contract accuracy----//

    /**
     * verify notes is visible
     * @return notes field
     */
    public boolean isNotesVisible(){
        return playwright.waitTillLocatorIsVisible(notestext, 3000.0);
    }

    /**
     * Input notes
     * @param text
     */
    public void inputNotes(String text){
        playwright.fill(notestext, text);
    }

    /**
     * verify notes counter is visible
     */
    public void notesCounterVisible(){
        playwright.getText(notesCountertext);
    }
}
