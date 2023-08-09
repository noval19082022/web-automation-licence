package steps.mamikos.tenant.profile;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.tenant.profile.TenantEditProfilePO;
import utilities.PlaywrightHelpers;

public class TenantEditProfileSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    TenantEditProfilePO tenantEditProfile = new TenantEditProfilePO(page);
    @When("tenant choose profession as mahasiswa studying at {string}")
    public void tenantChooseProfessionAsStudyAt(String university) {
        tenantEditProfile.clickOnRadioMahasiswa();
        tenantEditProfile.selectUniversity(university);
        tenantEditProfile.clickONSaveButton();
    }

    @Then("tenant success update profile")
    public void tenantSuccessUpdateProfile() throws InterruptedException {
        Assert.assertEquals(tenantEditProfile.getPopUpHeadTitle(), "Profil Disimpan");
        Assert.assertEquals(tenantEditProfile.getPopUpDescriptionContent(), "Kamu telah berhasil menyimpan profil");
        tenantEditProfile.clickOkButton();
    }

    @When("tenant choose profession as karyawan working at {string}")
    public void tenantChooseProfessionAsKaryawanWorkingAt(String company) {
        tenantEditProfile.clickOnRadioKaryawan();
        tenantEditProfile.selectCompany(company);
        tenantEditProfile.clickONSaveButton();
    }

    @Then("user can see {string} on profile page")
    public void user_can_see_x_on_profile_page(String textAlert) {
        Assert.assertEquals(tenantEditProfile.getAlertOnProfile(textAlert),textAlert,"not appears alert on profile");
    }

    @Then("user see button simpan edit profile disable")
    public void user_see_button_simpan_edit_profile_disable () {
        tenantEditProfile.assertSimpanButtonDisable();
    }

    @And("user click dropdown and fills {string} on edit profile")
    public void userClickDropdownAndFillsOnEditProfile(String textSearch) {
        tenantEditProfile.clickOnAndFillDropdown(textSearch);
    }

    @Then("user can see information {string}")
    public void userCanSeeInformation(String messageEmptyData) {
        Assert.assertEquals(tenantEditProfile.getMessageEmptyData(messageEmptyData), messageEmptyData, "message don't natch");
        tenantEditProfile.clickOnClosePopUp();
    }

    @Then("red hint {string} text will show up")
    public void redHintTextWillShowUp(String warningMessage) {
        Assert.assertEquals(tenantEditProfile.getMessageEmptyData(warningMessage), warningMessage, "message don't natch");
        tenantEditProfile.clickOnClosePopUp();
    }

    @And("user click on ubah button on informasi penyewa")
    public void user_click_on_ubah_button_on_informasi_penyewa() {
        tenantEditProfile.clickOnUbahInformasiPenyewa();
    }

    @And("user choose profession {string} on ubah informasi penyewa")
    public void userChooseProfessionOnUbahInformasiPenyewa(String profession) {
        tenantEditProfile.clickOnUbahProfessionTo(profession);
    }

    @When("user choose pekerjaan {string} from dropdown")
    public void userChoosePekerjaanFromDropdown(String company) {
        tenantEditProfile.selectValueDropdown(company);
        tenantEditProfile.clickONSaveButton();
    }

    @And("tenant choose profession as lainnya at {string}")
    public void tenantChooseProfessionAsLainnyaAt(String jobs) {
        tenantEditProfile.clickOnRadioLainnya();
        tenantEditProfile.setLainnyaJobs(jobs);
        tenantEditProfile.clickONSaveButton();
    }

    @And("user choose profession {string} on edit profile page")
    public void userChooseProfessionOnEditProfilePage(String profession) {
        tenantEditProfile.clickOnUbahProfessionToOnEditProfile(profession);
    }
    @And("user click on profile card")
    public void userClickOnProfileCard() {
        tenantEditProfile.clickOnProfileCard();
    }

    @And("user click kota asal dropdown")
    public void userClickKotaAsalDropdown() throws InterruptedException {
        tenantEditProfile.userClickKotaAsalDropdown();
    }

    @And("user click simpan button")
    public void userClickSimpanButton() throws InterruptedException {
        tenantEditProfile.userClickSimpanButton();
    }

    @And("user click on last education tenant")
    public void userClickOnLastEducationTenant() throws InterruptedException {
        tenantEditProfile.userClickLastEducationTenant();
    }

    @And("user input phone number darurat more than {string} character")
    public void userInputPhoneNumberDaruratMoreThanCharacter(String phone) throws InterruptedException {
        tenantEditProfile.userInputPhoneNumber(phone);
    }

    @And("user choose profession {string}")
    public void userChooseProfession(String profession1) throws InterruptedException {
        tenantEditProfile.userChooseProfession(profession1);
    }

    @And("user fills {string} in search dropdown pillih universitas")
    public void userFillsInSearchDropdownPillihUniversitas(String universitas) throws InterruptedException {
        tenantEditProfile.userChooseUniversitas(universitas);
    }

    @Then("user see list universitas")
    public void userSeeListUniversitas() {
        Assert.assertTrue(tenantEditProfile.seeListUniversitas(), "Phone number placeholder is not equal to ");
    }

    @And("user click universitas")
    public void userClickUniversitas() throws InterruptedException{
        tenantEditProfile.userClickUniversitas();
    }

    @And("user click icon calendar")
    public void userClickIconCalendar() throws InterruptedException {
        tenantEditProfile.clickIconCalendar();
    }

    @And("user select city {string}")
    public void userSelectCity(String kota)throws InterruptedException {
        tenantEditProfile.userSelectCity(kota);
    }

    @And("user click on marital status dropdown {string}")
    public void userClickOnMaritalStatusDropdown(String status) throws InterruptedException {
        tenantEditProfile.clickOnMaritalStatusDropdown(status);
    }

    @And("user select {string}")
    public void userSelect(String pendidikan) throws InterruptedException {
        tenantEditProfile.userSelectPendidikan(pendidikan);

    }

    @And("user fills fullname {string}")
    public void userFillsFullname(String name) throws InterruptedException {
        tenantEditProfile.userClickFieldFullName(name);
    }

    @Then("user see message error {string}")
    public void userSeeMessageError(String errorMessage) {
        Assert.assertEquals(tenantEditProfile.messageErrorFullName(), errorMessage, "Error message is not equal to " + errorMessage);
    }

    @Then("user verify button simpan is active")
    public void userVerifyButtonSimpanIsActive() {
        tenantEditProfile.isButtonSimpanNotDisabled();
    }

    @And("user choose dropdown {string}")
    public void userChooseDropdown(String jenisKlamin)throws InterruptedException {
        tenantEditProfile.chooseJenisKelamin(jenisKlamin);
    }

    @And("user click dropdown pilih instansi {string}")
    public void userClickDropdownPilihInstansi(String instansi)throws InterruptedException {
        tenantEditProfile.chooseInstansi(instansi);
    }

    @And("user fills instansi {string}")
    public void userFillsInstansi(String instansi) {
        tenantEditProfile.userFillInstansi(instansi);
    }

    @And("user click dropdown prefession")
    public void userClickDropdownPrefession() {
        tenantEditProfile.chooseDropdownProfesi();
    }

    @Then("Dropdown will displayed list office name")
    public void dropdownWillDisplayedListOfficeName() {
        Assert.assertTrue(tenantEditProfile.dropdownWillDisplayed(), "element is displayed");
    }

    @Then("user verify message {string} in search dropdown")
    public void userVerifyMessageInSearchDropdown(String noData) {
        Assert.assertEquals(tenantEditProfile.getDropdownResult(noData), noData, "Dropdown message is not equal to " + noData);
    }

    @And("user fills {string} in pilih universitas")
    public void userFillsInPilihUniversitas(String universitas)throws InterruptedException {
        tenantEditProfile.userChooseNoUniversitas(universitas);
    }

    @Then("user verify dropdown results list contains {string}")
    public void userVerifyDropdownResultsListContains(String result) {
        Assert.assertTrue(tenantEditProfile.isDropdownResultsListContains(result), "Dropdown results not containing " + result);
    }

    @And("user fill {string} on custom university input")
    public void userFillOnCustomUniversityInput(String text) {
        tenantEditProfile.userFillNamaKampus(text);
    }

    @And("user click on marital status dropdown")
    public void userClickOnMaritalStatusDropdown() {
        tenantEditProfile.martialStatus();
    }

    @And("user select martial status {string}")
    public void userSelectMartialStatus(String martial)throws InterruptedException {
        tenantEditProfile.selectMaritalStatus(martial);
    }

    @Then("user see martial status")
    public void userSeeMartialStatus() {
        Assert.assertTrue(tenantEditProfile.dropdownListStatus(), "element is displayed");
    }

    @Then("user see validation message {string}")
    public void userSeeValidationMessage(String number) {
        Assert.assertTrue(tenantEditProfile.verifyErrorMessagePhoneNumber(number), "element is displayed");
    }
}
