package pageobject.owner.kelolatagihan;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

public class PengajuanSewaPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private LocatorHelpers locator;
    private Locator terimaButton;
    private Locator yaTerimaButton;
    private Locator terimaButtonWithName;
    private Locator tolakButton;
    private Locator yaTolakButton;
    private Locator rejectButton;
    private Locator acceptButton;
    Locator terimaButtonPopUp;
    private Locator searchKost;
    private Locator searchKostInputText;
    private Locator searchKostFirstOption;
    private Locator lainnyaRejectReasonRadioBtn;
    private Locator lainnyaRejectReasonInput;
    private Locator tncCheckmarkRejectReason;
    private Locator pilihOnRejectButton;

    //-------------peraturan kos----------//
    private Locator ubahAturanButton;
    private Locator peraturanKosText;
    private Locator selectKosButton;
    private Locator pilihKosUbahPeraturanButton;
    private Locator simpanPeraturanButton;
    private Locator simpanPeraturanPopUp;
    private Locator toastPeraturanButton;
    private Locator waktuMulaiNgekosButton;
    private Locator ubahWaktu;
    private Locator toogleTodayButton;
    private Locator minCheckinButton;
    private Locator satuanWaktu;
    private Locator selectSatuanWaktu;
    private Locator simpanButtonOnModalPopup;
    private Locator minCheckinAmmountDropDown;
    private Locator selectMinCheckinAmmount;
    private Locator saveCheckinButton;
    private Locator kriteriaCalonPenyewaButton;
    private Locator kriteriaPenyewa;
    private Locator kriteriaCalonPenyewaText;
    private Locator kriteriaKhususButton;
    private Locator newWordingUbahPeraturan;

    Locator toggleCheckInKos;
    Locator toggleCheckInKosDisable;
    Locator dropdownTotalDay;
    Locator simpanPopupTotalDay;
    Locator dropdownTotalDayDisable;
    Locator dropdownTotalDayEnable;
    Locator closePopup;
    Locator dropdownLongDistance;
    Locator dropdownUnitTime;
    Locator simpanPopupUnitTime;

    public PengajuanSewaPO(Page page) {
        this.page = page;
        playwright = new PlaywrightHelpers(page);
        locator = new LocatorHelpers(page);
        this.terimaButton = page.locator("button").filter(new Locator.FilterOptions().setHasText("Terima")).first();
        this.yaTerimaButton = playwright.locatorByRoleSetName(locator.roleButton, "Ya, Terima");
        this.tolakButton = page.getByTestId("bookingRequestDetail-actionButtonDesktop").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Tolak"));
        this.yaTolakButton = playwright.locatorByRoleSetName(locator.roleButton, "Ya, Tolak");
        this.rejectButton =  page.getByTestId("bookingRequestDetail-actionButtonDesktop").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Tolak"));
        this.acceptButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ya, Tolak"));
        terimaButtonPopUp = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ya, Terima"));
        this.searchKost = page.getByPlaceholder("Pilih Kos");
        this.searchKostInputText = page.getByTestId("bookingRequestKosFilter-searchBar");
        this.searchKostFirstOption = page.locator(".bg-c-dropdown__menu--fixed li:nth-of-type(1) .bg-c-dropdown__menu-item-content");
        this.lainnyaRejectReasonRadioBtn = page.locator("div:nth-child(10) > .reject-modal__reason-option-overlay");
        this.lainnyaRejectReasonInput = page.getByPlaceholder("Masukkan alasan lainnya di sini");
        this.tncCheckmarkRejectReason = page.locator("span").filter(new Locator.FilterOptions().setHasText("checkmark"));
        this.pilihOnRejectButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih"));

        //-------------------------peraturan kos---------------------//
        this.ubahAturanButton = page.locator("//button[@class=\"bg-c-button bg-c-button--primary bg-c-button--lg\"]");
        this.peraturanKosText = page.locator("//*[@id='BookingSettingDesktop']");
        this.selectKosButton = page.getByPlaceholder("Pilih Kos");
        this.simpanPeraturanButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Simpan"));
        this.simpanPeraturanPopUp = page.getByTestId("checkin-save-btn");
        this.waktuMulaiNgekosButton = page.getByText("Waktu mulai masuk kos");
        this.toogleTodayButton = page.getByRole(AriaRole.CHECKBOX);
        this.minCheckinButton = page.getByTestId("min-checkin-time-unit").getByPlaceholder("hari");
        this.simpanButtonOnModalPopup = page.getByTestId("checkin-option-modal").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Simpan"));
        this.kriteriaCalonPenyewaButton = page.getByText("Kriteria calon penyewa chevron-down");
        dropdownTotalDay = page.locator("//input[@id='min-checkin-amount']");
        simpanPopupTotalDay = page.locator("//button[@class='bg-c-button booking-checkin-select-option-modal__save-button bg-c-button--primary bg-c-button--lg']");
        dropdownTotalDayDisable = page.locator("bg-c-input input-modal-trigger__trigger bg-c-input--disabled bg-c-input--lg");
        dropdownTotalDayEnable = page.locator("bg-c-input input-modal-trigger__trigger bg-c-input--lg");
        toggleCheckInKosDisable = page.locator("//div[@class='bg-c-switch checkin-setting-modal__d-day-checkin-switch bg-c-switch--off bg-c-switch--hover']");
        toggleCheckInKos = page.locator("//div[@class='bg-c-switch checkin-setting-modal__d-day-checkin-switch bg-c-switch--on bg-c-switch--hover']");
        closePopup = page.locator("//button[@class='bg-c-modal__action-closable']//*[name()='svg']");
        dropdownLongDistance = page.locator("//input[@id='max-checkin-amount']");
        dropdownUnitTime = page.locator("//input[@id='max-checkin-time-unit']");
        simpanPopupUnitTime = page.locator("//button[@class='bg-c-button booking-checkin-select-option-modal__save-button bg-c-button--secondary bg-c-button--lg']");
    }

    /**
     * Check if there are any booking requests available
     * @return true if booking requests exist, false otherwise
     */
    public boolean hasBookingRequests() {
        playwright.waitTillPageLoaded();
        playwright.hardWait(2000);
        return terimaButton.isVisible();
    }

    /**
     * Click on terima and go to tenant room management
     * Skips if no booking request is available
     */
    public BillAndBookingManagementPO ownerAcceptBooking() {
        playwright.waitTillPageLoaded();
        playwright.hardWait(2000);
        terimaButton.click();
        yaTerimaButton.click();
        return new BillAndBookingManagementPO(page);
    }

    /**
     * Owner accept booking by tenant name
     * @param tenantName Tenant Name
     * @return BillAndBookingManagementPO class
     */
    public BillAndBookingManagementPO ownerAcceptBooking(String tenantName) {
        terimaButtonWithName = page.getByTestId("bookingRequestList-list")
                .locator("div").filter(new Locator.FilterOptions()
                        .setHasText(tenantName)).getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Terima"));
        playwright.waitTillLocatorIsVisible(terimaButtonWithName, 30000.0);
        playwright.clickOn(terimaButtonWithName);
        playwright.clickOn(yaTerimaButton);
        return new BillAndBookingManagementPO(page);
    }

    /**
     * Check if terima button with name visible
     * @param tenantName Tenant Name
     * @return boolean
     */
    public boolean terimaButtonWithNameVisible(String tenantName) {
        terimaButtonWithName = page.getByTestId("bookingRequestList-list")
                .locator("div").filter(new Locator.FilterOptions()
                        .setHasText(tenantName)).getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Terima"));
        return playwright.waitTillLocatorIsVisible(terimaButtonWithName);
    }

    /**
     * Click on tolak and go to popup reason reject booking
     */
    public BillAndBookingManagementPO ownerRejectBooking() {
        tolakButton.click();
        yaTolakButton.click();
        return new BillAndBookingManagementPO(page);
    }

    /**
     * Click on tolak and go to popup reason reject booking from view detail
     */
    public BillAndBookingManagementPO ownerRejectBookingFromViewDetail() {
        rejectButton.waitFor();
        rejectButton.click();
        acceptButton.click();
        return new BillAndBookingManagementPO(page);
    }

    /**
     * Click on terima popup from view detail
     */
    public void clickOnTerimaPopUp() {
        terimaButtonPopUp.click();
    }

    /**
     * search kost name on filter pengajuan booking page
     * @param kostName that want to search
     */
    public  BillAndBookingManagementPO searchKostOnKostFilter(String kostName) {
        playwright.waitTillLocatorIsVisible(searchKost);
        playwright.clickOn(searchKost);
        searchKostInputText.fill(kostName);
        playwright.waitTillLocatorIsVisible(searchKostFirstOption);
        searchKostFirstOption.click();
        return new BillAndBookingManagementPO(page);
    }

    /**
     * click "Ya, Tolak" when reject booking request
     */
    public void clickYaTolakOnPengajuanBooking() {
        playwright.waitTillLocatorIsVisible(yaTolakButton);
        yaTolakButton.click();
    }

    /**
     * click and input reason on lainnya
     * reject reason until check tnc and click pilih
     * @param reason stands for input reason string
     */
    public void clickAndFillLainnyaRejectReason(String reason) {
        lainnyaRejectReasonRadioBtn.click();
        lainnyaRejectReasonInput.fill(reason);
        tncCheckmarkRejectReason.click();
        pilihOnRejectButton.click();
        playwright.hardWait(1000);
    }

    /**
     * click Ubah Aturan button on pengajuan sewa page
     */
    public void clickUbahAturanButton(){
        playwright.waitFor(ubahAturanButton);
        if (ubahAturanButton.isVisible()){
            playwright.clickOn(ubahAturanButton);
        }
    }

    /**
     * Check if Peraturan kos is visible
     * @return peraturan kos page
     */
    public boolean getPeraturanBookingText(){
        playwright.waitFor(peraturanKosText);
        return peraturanKosText.isVisible();
    }

    /**
     * Select kost name on peraturan booking page
     */
    public void selectKostName(String kosName){
        playwright.clickOn(selectKosButton);
        searchKost = page.locator("label").filter(new Locator.FilterOptions().setHasText("" +kosName+ ""));
        playwright.pageScrollInView(searchKost);
        playwright.clickOn(searchKost);
        pilihKosUbahPeraturanButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih nama kos"));
        playwright.clickOn(pilihKosUbahPeraturanButton);
    }

    /**
     * Click Simpan button on peraturan waktu ngekos
     */
    public void simpanPeraturanButton(){
        playwright.clickOn(simpanPeraturanButton);
    }

    /**
     * Click Simpan button on peraturan waktu ngekos pop-up
     */
    public void simpanPeraturanPopUp(){
        playwright.clickOn(simpanPeraturanPopUp);
    }

    /**
     * Check if toast success update is visible
     * @return toast
     */
    public boolean getToastText(String toast){
        toastPeraturanButton = page.getByText("" +toast+ "");
        toastPeraturanButton.isVisible();
        return toastPeraturanButton.isVisible();
    }

    /**
     * click on waktu mulai ngekos menu
     */
    public void clickWaktuMulaiNgekosButton(){
        playwright.clickOn(waktuMulaiNgekosButton);
        ubahWaktu = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ubah waktu"));
        playwright.clickOn(ubahWaktu);
    }

    /**
     * edit jarak waktu terdekat
     * @param waktu
     * @param tanggal
     */
    public void editWaktuMulaiNgekos(String waktu, String tanggal){
        if (toogleTodayButton.isChecked()) {
            playwright.clickOn(toogleTodayButton);
            playwright.hardWait(3);
            playwright.clickOn(minCheckinButton);
            selectSatuanWaktu = page.getByText("" + waktu + "");
            playwright.clickOn(selectSatuanWaktu);
            playwright.clickOn(simpanButtonOnModalPopup);
            minCheckinAmmountDropDown = page.getByTestId("min-checkin-amount").getByRole(AriaRole.TEXTBOX);
            playwright.clickOn(minCheckinAmmountDropDown);
            selectMinCheckinAmmount = page.locator("//p[normalize-space()='"+tanggal+"']");
            playwright.clickOn(selectMinCheckinAmmount);
            playwright.clickOn(simpanButtonOnModalPopup);
            saveCheckinButton = page.getByTestId("checkin-save-btn");
            playwright.clickOn(saveCheckinButton);
        }
    }

    /**
     * activated toogle button for today
     */
    public void clickToogleCheckin(){
        toogleTodayButton.check();
        playwright.clickOn(saveCheckinButton);
    }

    /**
     * click tanggal
     */
    public void clickOnTanggal(String tanggal){
        selectMinCheckinAmmount = page.locator("//p[normalize-space()='"+tanggal+"']");
        playwright.clickOn(selectMinCheckinAmmount);
    }

    /**
     * click checkbox today
     */
    public void clickOnToday(){
        playwright.clickOn(toogleTodayButton);
    }

    /**
     * click kriteria calon penyewa button
     */
    public void clickKriteriaCalonPenyewaButton() {
        playwright.clickOn(kriteriaCalonPenyewaButton);
    }

    /**
     * click toogle jenis kriteria
     * @param kriteria
     */
    public void clickToogleKriteria(String kriteria){
        kriteriaPenyewa = page.getByLabel("" +kriteria+ "");
        kriteriaPenyewa.check();
    }

    /**
     * validate button will disable or not
     * @param kriteria
     * @return
     */
    public boolean validateDisableButton(String kriteria){
       return kriteriaPenyewa.isDisabled();
    }

    /**
     * uncheck toogle
     * @param kriteria
     */
    public void unCheckToogle(String kriteria) {
        kriteriaPenyewa = page.getByLabel("" +kriteria+ "");
        kriteriaPenyewa.uncheck();
    }

    /**
     * validate button will disable or not
     * @param kriteriaPenyewa
     * @return
     */
    public boolean validateEnableButton(String kriteriaPenyewa){
        kriteriaCalonPenyewaText = page.getByText(""+kriteriaPenyewa+"");
        return kriteriaCalonPenyewaText.isDisabled();
    }

    /**
     * click button Kost khusus mahasiswa or karyawan
     * @param text
     */
    public void clickKosKhususButton(String text){
        kriteriaKhususButton = page.getByText(""+text+"");
        playwright.clickOn(kriteriaKhususButton);
    }

    /**
     * get validate wording on ubah peraturan page
     * @param text
     * @return text
     */
    public boolean validateWordingOnUbahPeraturan(String text){
        newWordingUbahPeraturan =  page.getByText(""+text+"");
        return newWordingUbahPeraturan.isVisible();
    }
    /**
     * Click on toggle check in kos
     */
    public void ownerClickOnToggleCheckInKos() {
        if (toggleCheckInKosDisable.isVisible()) {
            playwright.clickOn(toggleCheckInKosDisable);
        } else {
            playwright.clickOn(closePopup);
        }
    }
    /**
     * Click on toggle check in kos if active
     */
    public void ownerClickOnToggleCheckInKosIfActive() {
        if (toggleCheckInKos.isVisible()) {
            playwright.clickOn(toggleCheckInKos);
        } else if (toggleCheckInKosDisable.isVisible()){
            playwright.isTextDisplayed("Jarak waktu terdekat (pengajuan dan tanggal masuk kos)");
        }
    }

    /**
     * Click on dropdown total day
     */
    public void ownerClickOnDropdownTotalDay() {
        playwright.clickOn(dropdownTotalDay);
    }

    /**
     * Click on simpan on popup total day
     */
    public void ownerClickOnSimpanPopupTotalDay() {
        playwright.clickOn(simpanPopupTotalDay);
    }
    /**
     * Click on simpan on popup unit time
     */
    public void ownerClickOnSimpanPopupUnitTime() {
        playwright.clickOn(simpanPopupUnitTime);
    }
    /**
     * Click on dropdown long distance
     */
    public void ownerClickOnDropdownLongDistance() {
        playwright.clickOn(dropdownLongDistance);
    }
    /**
     * Click on dropdown unit time
     */
    public void ownerClickOnDropdownUnitTime() {
        playwright.clickOn(dropdownUnitTime);
    }
}
