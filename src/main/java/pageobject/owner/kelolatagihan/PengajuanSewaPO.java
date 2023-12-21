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

    public PengajuanSewaPO(Page page) {
        this.page = page;
        playwright = new PlaywrightHelpers(page);
        locator = new LocatorHelpers(page);
        this.terimaButton = playwright.locatorByRoleSetName(locator.roleButton, "Terima").first();
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
        this.ubahAturanButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Ubah aturan"));
        this.peraturanKosText = page.locator("//*[@id='BookingSettingDesktop']");
        this.selectKosButton = page.getByPlaceholder("Pilih Kos");
        this.simpanPeraturanButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Simpan"));
        this.waktuMulaiNgekosButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Waktu mulai masuk kos chevron-down"));
        this.toogleTodayButton = page.getByRole(AriaRole.CHECKBOX);
        this.minCheckinButton = page.getByTestId("min-checkin-time-unit").getByPlaceholder("hari");
        this.simpanButtonOnModalPopup = page.getByTestId("checkin-option-modal").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Simpan"));
        this.kriteriaCalonPenyewaButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kriteria calon penyewa chevron-down"));

    }

    /**
     * Click on terima and go to tenant room management
     */
    public BillAndBookingManagementPO ownerAcceptBooking() {
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
        playwright.waitTillLocatorIsVisible(terimaButtonWithName);
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
        searchKost.click();
        searchKostInputText.fill(kostName);
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
            selectMinCheckinAmmount = page.locator("div:nth-child(" + tanggal + ") > label > .bg-c-radio__icon > span").first();
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
}
