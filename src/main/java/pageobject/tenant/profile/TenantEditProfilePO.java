package pageobject.tenant.profile;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

import java.util.ArrayList;
import java.util.List;

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
    Locator jenisKlamin;
    Locator instansi;
    Locator searchInstansi;
    Locator fillInstansi;
    Locator dropDownListProfessi;
    Locator dropdownResult;
    Locator kotaAsal;
    Locator chooseLainnya;
    Locator chooseInstansiSearch;
    Locator errorMessageFullName;
    Locator fillNamaKampus;

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
        lastEducationTenant = page.locator("//*[.='Pendidikan Terakhir']/following-sibling::*");
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
        martialStatus = page.locator("//*[.='Status']/following-sibling::*");
        namaLengkap = page.getByPlaceholder("Masukan nama lengkap kamu");
        jenisKlamin = page.locator("//*[.='Jenis Kelamin']/following-sibling::*");
        instansi = page.getByTestId("inputProfession-workplaceOption");
        searchInstansi = page.getByTestId("inputProfession-workplaceOption").getByPlaceholder("Search");
        fillInstansi = page.getByPlaceholder("Tulis nama instansi Anda di sini");
        dropDownListProfessi = page.getByTestId("inputProfession-workplaceOption").getByRole(AriaRole.LIST);
        dropdownResult = page.locator("//a[contains(.,'Indonesia')]");
        kotaAsal = page.locator("//*[.='Kota Asal']/following-sibling::*");
        chooseLainnya = page.getByTestId("inputProfession-workplaceOption").locator("a");
        chooseInstansiSearch = page.getByTestId("inputProfession-workplaceOption").locator("a");
        errorMessageFullName = page.getByText("Nama lengkap wajib diisi");
        fillNamaKampus = page.getByPlaceholder("Tulis nama kampus/sekolah Anda di sini");
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
    public String getAlertOnProfile(String alert, int index) {
        ElementHandle[] elements = page.querySelectorAll("//i[contains(.,'" + alert + "')]").toArray(new ElementHandle[index]);
        ElementHandle alartValue = elements[index];
        return alartValue.textContent();
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
        playwright.clickOn(kotaAsal);
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
        Locator chooseProfesi = page.locator("a").filter(new Locator.FilterOptions().setHasText(chooseProfessi)).nth(0);
        playwright.clickOn(chooseProfesi);
    }

    /**
     * click on choose universitas
     *
     */
    public void userChooseUniversitas(String universitas) throws InterruptedException {
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

    /**
     * choose jenis kelamin
     */
    public void chooseJenisKelamin(String kelamin)throws InterruptedException {
        Locator chooseKelamin = page.locator("a").filter(new Locator.FilterOptions().setHasText(kelamin));
        playwright.clickOn(jenisKlamin);
        playwright.clickOn(chooseKelamin);
    }

    /**
     * choose instansi
     */
    public void chooseInstansi(String chooseInstansi)throws InterruptedException {
        playwright.clickOn(instansi);
        playwright.forceFill(searchInstansi, chooseInstansi);
        playwright.clickOn(chooseInstansiSearch);
    }

    /**
     * user fill instansi
     */
    public void userFillInstansi(String fillsInstansi){
        playwright.clickOn(fillInstansi);
        playwright.forceFill(fillInstansi,fillsInstansi);
    }

    /**
     * user choose dropdown instansi
     */
    public void chooseDropdownProfesi(){
        playwright.clickOn(instansi);
    }

    /**
     * verfiy dropdown list profesi
     */
    public boolean dropdownWillDisplayed() {
        return playwright.waitTillLocatorIsVisible(dropDownListProfessi);
    }

    /**
     * user verify no data in search universitas
     * @return
     */
    public String getDropdownResult(String message){
        Locator result = page.getByText(message);
        playwright.waitTillLocatorIsVisible(result);
        return message;
    }

    /**
     * click on choose no data universitas
     *
     */
    public void userChooseNoUniversitas(String universitas) throws InterruptedException {
        playwright.clickOn(pilihNamaKampus);
        playwright.forceFill(searchNamaKampus, universitas);
    }

    /**
     * Is Dropdown Result List Contains Inputted Text
     * @param text
     * @return true or false
     */
    public boolean isDropdownResultsListContains(String text){
        List<String> resultList = new ArrayList<>();
        for (String dropDownSearchResult : playwright.getListInnerTextFromListLocator(dropdownResult)) {
            resultList.add(dropDownSearchResult);
        }
        return resultList.get(0).contains(text);
    }

    /**
     * user fill nama kampus
     */
    public void userFillNamaKampus(String text){
        playwright.forceFill(fillNamaKampus, text);
    }

    /**
     * click martila status drop down
     */
    public void martialStatus (){
        playwright.clickOn(martialStatus);
    }

    /**
     * user choose marital status is kawin
     */
    public void selectMaritalStatus(String martial) throws InterruptedException{
        Locator martialChoose = page.locator("a").filter(new Locator.FilterOptions().setHasText(martial));
        playwright.clickOn(martialChoose);
    }
}