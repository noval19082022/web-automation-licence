package steps.mantool;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.mantool.agentRegistrationPO;

import java.util.List;
import java.util.Map;

public class agentRegistrationSteps {
    Page page = ActiveContext.getActivePage();
    agentRegistrationPO registration = new agentRegistrationPO(page);

    private List<Map<String, String>> agenInfo;

    @When("agen not upload photo KTP")
    public void agen_not_upload_photo_ktp() {
        registration.chooseSkemaAgen("Agen Akuisisi");
        registration.fillNamaLengkap("Agen Automation Test");
        registration.fillNomorHandphone("082290901020");
        registration.fillEmail("agenautomation@gmail.com");
        registration.fillUsia("21");
        registration.fillNoKTP("3402091290390002");
        registration.fillAddress("Jl Nurul Huda No 28 RT 22 Macanan");
        registration.fillPassword("qwerty123");
        registration.fillKonfirmasiPassword("qwerty123");
        registration.clickBerikutnya();
    }

    @When("agen upload KTP using file {string}")
    public void agen_upload_ktp_using_file(String file) {
        if (file.equalsIgnoreCase("more than 2MB")){
            registration.uploadPhotoKTP("src/main/resources/images/upload5Mb.jpg");
        } else if (file.equalsIgnoreCase("less than 2MB")) {
            registration.uploadPhotoKTP("src/main/resources/images/kos tampak depan.jpg");
        }
    }

    @Then("no agen registration error message foto ktp")
    public void no_agen_registration_error_message_foto_ktp() {
        Assert.assertFalse(registration.isFotoKTPErrorMessageVisible());
    }

    @When("agen input age {string}")
    public void agen_input_age(String age) {
        registration.fillUsia(age);
    }

    @Then("show agen registration error message {string}")
    public void show_agen_registration_error_message(String message) {
        Assert.assertEquals(registration.getErrorMessage(),message);
    }

    @Then("show agen registration error message upload ktp {string}")
    public void show_agen_registration_error_message_upload_ktp(String message) {
        Assert.assertEquals(registration.getUploadPhotoErrorMessage(), message);
    }

    @Then("no agen registration error message")
    public void no_agen_registration_error_message() {
        Assert.assertFalse(registration.isErrorMessageVisible());
    }

    @When("agen input ktp {string}")
    public void agen_input_ktp(String noKtp) {
        registration.fillNoKTP(noKtp);
    }

    @Then("show agen registration error message ktp {string}")
    public void show_agen_registration_error_message_ktp(String message) {
        Assert.assertEquals(registration.getErrorMessage(),message);
    }

    @When("agen input password {string}")
    public void agen_input_password(String password) {
        registration.fillPassword(password);
    }

    @When("agen input confirmation password {string}")
    public void agen_input_confirmation_password(String password) {
        registration.fillKonfirmasiPassword(password);
    }

    @When("agen input email {string}")
    public void agen_input_email(String email) {
        registration.fillEmail(email);
    }

    @When("agen go to next step agent registration")
    public void agen_go_to_next_step_agent_registration() {
        registration.clickBerikutnya();
    }

    @When("agen select province {string}")
    public void agen_select_province(String province) {
        registration.selectProvince(province);
    }

    @Then("kota dropdown is enable")
    public void kota_dropdown_is_enable() {
        Assert.assertFalse(registration.isKotaDisabled());
    }

    @When("agen select city {string}")
    public void agen_select_city(String city) {
        registration.selectCity(city);
    }

    @When("agen input address {string}")
    public void agen_input_address(String address) {
        if (address.equalsIgnoreCase(">100 char")){
            address = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
        }

        registration.fillAddress(address);
    }

    @Then("agen can only input max 100 char")
    public void agen_can_only_input_max_char() {
        Assert.assertEquals(registration.countAddressText(),100);
    }

    @Then("address counter is {string}")
    public void address_counter_is(String counter){
        Assert.assertEquals(registration.getAddressCounter(),counter);
    }

    @When("agen input nama bank {string}")
    public void agen_input_nama_bank(String bank) {
        registration.chooseBankName(bank);
    }

    @When("agen input nomor rekening {string}")
    public void agen_input_nomor_rekening(String noRek) {
        registration.fillNoRekening(noRek);
    }

    @Then("nomor rekening field is empty")
    public void nomor_rekening_field_is_empty() {
        Assert.assertEquals(registration.getNoRekening(),"");
    }

    @When("agen input pendidikan terakhir {string}")
    public void agen_input_pendidikan_terakhir(String education) {
        registration.choosePendidikanTerakhir(education);
    }

    @When("agen input kegiatan saat ini {string}")
    public void agen_input_kegiatan_saat_ini(String job) {
        registration.chooseKegiatanSaatIni(job);
    }

    @When("agen input sumber informasi {string}")
    public void agen_input_sumber_informasi(String source) {
        registration.chooseSumberInformasi(source);
    }

    @When("agen accept term and conditions")
    public void agen_accept_term_and_conditions() {
        registration.acceptTermsConditionCreateAgen();
    }

    @When("agen Daftar Agen")
    public void agen_daftar_agen() {
        registration.clickDaftarAgen();
    }

    @Then("show pop up data confirmation")
    public void show_pop_up_data_confirmation(DataTable tables) {
        agenInfo = tables.asMaps(String.class, String.class);

        String skema = agenInfo.get(0).get("Skema");
        String noktp = agenInfo.get(0).get("No KTP");
        String email = agenInfo.get(0).get("Email");
        String password = agenInfo.get(0).get("Password Akun");
        String bank = agenInfo.get(0).get("Nama Bank");
        String rekening = agenInfo.get(0).get("Nomor Rekening");

        Assert.assertTrue(registration.isConfirmationPopUpAgentVisible());
        Assert.assertEquals(registration.getConfirmationPopUpInfo("skema"),skema);
        Assert.assertEquals(registration.getConfirmationPopUpInfo("noktp"),noktp);
        Assert.assertEquals(registration.getConfirmationPopUpInfo("email"),email);
        Assert.assertEquals(registration.getConfirmationPopUpInfo("password"),password);
        Assert.assertEquals(registration.getConfirmationPopUpInfo("bank"),bank);
        Assert.assertEquals(registration.getConfirmationPopUpInfo("rekening"),rekening);
    }

    @Then("pop up konfirmasi data have captcha")
    public void pop_up_konfirmasi_data_have_captcha() {
        Assert.assertTrue(registration.isCaptchaVisible());
    }
}