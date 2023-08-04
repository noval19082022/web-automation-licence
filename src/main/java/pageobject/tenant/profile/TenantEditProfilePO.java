package pageobject.tenant.profile;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TenantEditProfilePO {
    Page page;
    PlaywrightHelpers playwright;
    Locator selectedProfession;
    Locator selectedJob;
    Locator professionMahasiswa;
    Locator professionKaryawan;
    Locator universityOrProfessionDropdown;
    Locator saveButton;
    Locator okButton;
    Locator popUpHeadTitle;
    Locator popUpDescriptionContent;
    Locator simpanButton;
    Locator searchTextBox;
    Locator emptyDataMessage;
    Locator closePopup;
    Locator ubahInformasiPenyewa;
    Locator professionLainnya;
    Locator lainnyaField;
    Locator searchTextBoxOnEditProfile;
    Locator profileCard;
    Locator kotaAsalDropDown;
    Locator lastEducationTenant;
    Locator nomorDarurat;
    Locator profesi;
    Locator pilihNamaKampus;
    Locator searchNamaKampus;
    Locator listKampus;
    Locator popUpSaveprofil;
    Locator calender;
    Locator chooseTanggal;
    Locator asalKota;
    Locator searchKota;
    Locator martialStatus;
    Locator namaLengkap;

    public TenantEditProfilePO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        selectedProfession = page.locator("#profileProfession .bg-c-radio--checked");
        selectedJob = page.getByTestId("inputProfession-jobDetailOptions");
        professionMahasiswa = page.locator("label").filter(new Locator.FilterOptions().setHasText("Mahasiswa"));
        professionKaryawan = page.locator("label").filter(new Locator.FilterOptions().setHasText("Karyawan"));
        universityOrProfessionDropdown = page.locator("//div[@class='bg-c-select']");
        saveButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Simpan"));
        popUpHeadTitle = page.locator("h2[id]");
        popUpDescriptionContent = page.locator("div[id='swal2-content']");
        okButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("OK"));
        simpanButton = page.locator(".bg-u-ml-md");
        searchTextBox = page.getByPlaceholder("Search").first();
        closePopup = page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText("close")).first();
        ubahInformasiPenyewa = page.locator(".booking-form-tenant-info .booking-form-section__action .bg-c-text");
        professionLainnya = page.locator("label").filter(new Locator.FilterOptions().setHasText("Lainnya"));
        lainnyaField = page.getByTestId("jobDescription-input");
        searchTextBoxOnEditProfile = page.getByTestId("inputProfession-jobDetailOptions").getByPlaceholder("Search");
        profileCard = page.getByTestId("user-profile-card");
        kotaAsalDropDown = page.getByText("Kota Asal Kabupaten Simeulue Kabupaten Aceh Singkil Kabupaten Aceh Selatan Kabup");
        lastEducationTenant = page.getByText("Pendidikan Terakhir S3 S2 S1 Diploma SMK/MAK SMA/MA SMP/MTS SD/MI S1 dropdown-do");
        nomorDarurat = page.getByPlaceholder("xxxx xxxx");
        profesi = page.getByTestId("inputProfession-jobOptions");
        pilihNamaKampus = page.getByTestId("inputProfession-workplaceOption");
        searchNamaKampus = page.getByTestId("inputProfession-workplaceOption").getByPlaceholder("Search");
        listKampus = page.getByTestId("inputProfession-workplaceOption").getByRole(AriaRole.LIST);
        popUpSaveprofil = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Profil Disimpan"));
        calender = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("calendar"));
        chooseTanggal = page.getByText("8", new Page.GetByTextOptions().setExact(true));
        asalKota = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih kota asal dropdown-down"));
        searchKota = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search"));
        martialStatus =  page.getByText("Status Belum Kawin Kawin Kawin memiliki anak Kawin dropdown-down Belum Kawin Kaw");
        namaLengkap = page.getByPlaceholder("Masukan nama lengkap kamu");
    }

    /**
     * Get selected profession
     *
     * @return String data type
     */
    public String getSelectedProfessionText() {
        return playwright.getText(selectedProfession);
    }

    /**
     * click on radio mahasiswa
     */
    public void clickOnRadioMahasiswa() {
        playwright.clickOn(professionMahasiswa);
    }

    /**
     * Select university
     *
     * @param name String type university name
     */
    public void selectUniversity(String name) {
        Locator universityName = page.locator("//a[contains(.,'" + name + "')]");
        playwright.clickOn(universityOrProfessionDropdown);
        playwright.clickOn(universityName);
    }

    /**
     * Click on save button
     */
    public void clickONSaveButton() {
        playwright.clickOn(saveButton);
    }

    /**
     * Click on OK button;
     *
     * @return TenantProfilePO class
     */
    public TenantProfilePO clickOkButton() {
        playwright.clickOn(okButton);
        return new TenantProfilePO(page);
    }

    /**
     * Get pop up title after edit profile success
     *
     * @return String type
     */
    public String getPopUpHeadTitle() {
        return playwright.getText(popUpHeadTitle);
    }

    /**
     * Get pop up description after edit profile success
     *
     * @return String type
     */
    public String getPopUpDescriptionContent() {
        return playwright.getText(popUpDescriptionContent);
    }

    /**
     * Click on radio karyawan
     */
    public void clickOnRadioKaryawan() {
        playwright.clickOn(professionKaryawan);
    }

    /**
     * Select company for karyawan
     *
     * @param companyName String type company name
     */
    public void selectCompany(String companyName) {
        Locator company = page.locator("//a[contains(.,'" + companyName + "')]");
        playwright.clickOn(universityOrProfessionDropdown);
        playwright.clickOn(company);
    }

    /**
     * get text alert on edit profile
     *
     * @return string
     */
    public String getAlertOnProfile(String alert) {
        Locator alartValue = page.locator("//p[contains(.,'" + alert + "')]");
        return playwright.getText(alartValue);
    }

    /**
     * Assert simpan button are disable
     */
    public void assertSimpanButtonDisable() {
        playwright.assertDisable(simpanButton);
    }

    /**
     * Click dropdown and fill search textbox
     *
     * @param textSearch String type company name or university name
     */
    public void clickOnAndFillDropdown(String textSearch) {
        playwright.clickOn(universityOrProfessionDropdown);
        if (playwright.waitTillLocatorIsVisible(searchTextBox, 1000.0)) {
            playwright.forceFill(searchTextBox, textSearch);
        } else {
            playwright.forceFill(searchTextBoxOnEditProfile, textSearch);
        }
    }

    /**
     * Get message empty data after input search value
     *
     * @return String type
     */
    public String getMessageEmptyData(String message) {
        emptyDataMessage = page.getByText(message);
        return playwright.getText(emptyDataMessage);
    }

    /**
     * Click close on popup
     */
    public void clickOnClosePopUp() {
        if (playwright.waitTillLocatorIsVisible(closePopup, 1000.0)) {
            playwright.clickOn(closePopup);
        }
    }

    /**
     * click on Ubah button
     */
    public void clickOnUbahInformasiPenyewa() {
        playwright.clickOn(ubahInformasiPenyewa);
    }

    /**
     * click on Profession button on form booking page
     */
    public void clickOnUbahProfessionTo(String profession) {
        Locator professionRadioEditProfil = page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName(profession));
        playwright.clickOn(professionRadioEditProfil);
    }

    /**
     * click on Profession button on edit profile page
     */
    public void clickOnUbahProfessionToOnEditProfile(String profession) {
        Locator ubahProfession = page.locator("label").filter(new Locator.FilterOptions().setHasText(profession));
        playwright.clickOn(ubahProfession);
    }

    /**
     * Click on radio lainnya
     */
    public void clickOnRadioLainnya() {
        playwright.clickOn(professionLainnya);
    }

    /**
     * Input value in Lainnya field
     *
     * @param lainnya
     */
    public void setLainnyaJobs(String lainnya) {
        playwright.forceFill(lainnyaField, lainnya);
    }

    /**
     * Select company or university
     *
     * @param valueInput String type company or university
     */
    public void selectValueDropdown(String valueInput) {
        Locator dropdownValue = page.locator("//a[contains(.,'" + valueInput + "')]");
        playwright.clickOn(dropdownValue);
    }

    /**
     * Click on profile card
     */
    public void clickOnProfileCard() {
        playwright.clickOn(profileCard);
    }

    /**
     * user click kota asal
     */
    public void userClickKotaAsalDropdown() throws InterruptedException {
        playwright.clickOn(kotaAsalDropDown);
    }

    /**
     * user click simpan button
     *
     * @throws InterruptedException
     */
    public void userClickSimpanButton() throws InterruptedException {
        playwright.clickOn(saveButton);
        playwright.waitTillLocatorIsVisible(popUpSaveprofil);
    }

    /**
     * user click last education tenant
     */
    public void userClickLastEducationTenant() throws InterruptedException {
        playwright.clickOn(lastEducationTenant);
    }

    /**
     * user input phone number more than 14
     *
     * @throws InterruptedException
     */
    public void userInputPhoneNumber(String phone) throws InterruptedException {
        playwright.clickOn(nomorDarurat);
        playwright.clearText(nomorDarurat);
        playwright.forceFill(nomorDarurat, phone);
    }

    /**
     * click on profession radio
     * @param chooseProfessi should be Mahasiswa, Karyawan, Lainnya
     * @throws InterruptedException
     */
    public void userChooseProfession(String chooseProfessi) throws InterruptedException {
        playwright.clickOn(profesi);
        Locator chooseProfesi = page.locator("a").filter(new Locator.FilterOptions().setHasText(chooseProfessi));
        playwright.clickOn(chooseProfesi);
    }

    /**
     * click on choose universitas
     *
     */
    public void userChooseUniversitas(String universitas) throws InterruptedException {
        Locator chooseLainnya =  page.getByTestId("inputProfession-workplaceOption").locator("a");
        playwright.clickOn(pilihNamaKampus);
        playwright.forceFill(searchNamaKampus, universitas);
        playwright.clickOn(chooseLainnya);
    }

    /**
     * Get list university
     * @return String
     */
    public boolean seeListUniversitas() {
        return playwright.waitTillLocatorIsVisible(listKampus);
    }

    /***
     * click on universitas
     */
    public void userClickUniversitas()throws InterruptedException{
        playwright.clickOn(pilihNamaKampus);
    }

    /**
     * click icon calendar
     *
     * @throws InterruptedException
     */
    public void clickIconCalendar() throws InterruptedException {
        playwright.clickOn(calender);
        playwright.clickOn(chooseTanggal);
    }

    /**
     * user select city
     */
    public void userSelectCity(String kota) throws InterruptedException {
        Locator pilihKota = page.locator("a").filter(new Locator.FilterOptions().setHasText(kota)).nth(0);
        Locator kotaAsal = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(kota));
        playwright.clickOn(kotaAsal);
        playwright.forceFill(searchKota, kota);
        playwright.clickOn(pilihKota);
    }

    /**
     * appears dropdown list marital status
     *
     * @throws InterruptedException
     */
    public void clickOnMaritalStatusDropdown(String status) throws InterruptedException {
       Locator martialChoose = page.locator("a").filter(new Locator.FilterOptions().setHasText(status)).nth(1);
       playwright.clickOn(martialStatus);
       playwright.clickOn(martialChoose);
    }
    /**
     * user select pendidikan
     */
    public void userSelectPendidikan(String pendidikan) throws InterruptedException {
        Locator pendidikanTerakhir = page.locator("a").filter(new Locator.FilterOptions().setHasText(pendidikan));
        playwright.clickOn(pendidikanTerakhir);
    }
    /**
     * user click field nama lengkap
     */
    public void userClickFieldFullName(String name) throws InterruptedException {
        playwright.clickOn(namaLengkap);
        playwright.clearText(namaLengkap);
        playwright.forceFill(namaLengkap, name);
    }

    /**
     * appears message error fullname
     */
    public String messageErrorFullName() {
        Locator errorMessageFullName = page.getByText("Nama lengkap wajib diisi");
        playwright.waitTillLocatorIsVisible(errorMessageFullName);
        return playwright.getText(errorMessageFullName);
    }

    /**
     * button simpan not disable
     *
     */
    public void isButtonSimpanNotDisabled() {
        playwright.assertVisible(simpanButton);
    }
}
