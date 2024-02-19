package steps.singgahsini;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.singgahsini.JoinSinggahsiniPO;
import utilities.JavaHelpers;

import java.util.List;
import java.util.Map;

public class JoinSinggahsiniSteps {
    Page page = ActiveContext.getActivePage();
    JoinSinggahsiniPO joinSinggahsini = new JoinSinggahsiniPO(page);

    private List<Map<String, String>> dataProperty;

    private static final String MAMIKOS = "src/main/resources/mamikos.properties";
    public static final String ENV = JavaHelpers.getPropertyValue(MAMIKOS, "env");
    public static final String singgahsiniUrl = JavaHelpers.getPropertyValue(MAMIKOS, "singgahsiniUrl_"+ENV);

    @Given("user navigates to singgahsini.id")
    public void user_navigates_to_singgahsini_id() {
        joinSinggahsini.navigateToSinggahsiniId();
    }

    @When("user open register form")
    public void user_open_register_form() {
        joinSinggahsini.clickDaftarSekarang();
    }

    @Then("user should redirect/stay to/in {string}")
    public void user_should_redirect_to(String url) {
        String daftarURL = singgahsiniUrl+url;

        Assert.assertEquals(joinSinggahsini.getURLSinggahsini(),daftarURL);
    }
    @Then("page contains title {string}")
    public void page_contains_title(String title) {
        Assert.assertEquals(joinSinggahsini.getDaftarPageTitle(),title);
    }
    @Then("page contains subtitle {string}")
    public void page_contains_subtitle(String subtitle) {
        Assert.assertEquals(joinSinggahsini.getDaftarPageSubtitle(),subtitle);
    }
    @When("user submit form daftar singgahsini")
    public void user_submit_form_daftar_singgahsini() {
        joinSinggahsini.clickDaftarButton();
    }
    @Then("nama lengkap field should show error validation {string}")
    public void nama_lengkap_field_should_show_error_validation(String message) {
        Assert.assertEquals(joinSinggahsini.getNamaLengkapErrorMessage(),message);
    }
    @Then("no handphone field should show error validation {string}")
    public void no_handphone_field_should_show_error_validation(String message) {
        Assert.assertEquals(joinSinggahsini.getNoHandphoneErrorMessage(),message);

    }
    @Then("nama kos field should show error validation {string}")
    public void nama_kos_field_should_show_error_validation(String message) {
        Assert.assertEquals(joinSinggahsini.getNamaKosErrorMessage(),message);

    }

    @Then("total kamar field should show error validation {string}")
    public void total_kamar_field_should_show_error_validation(String message){
        Assert.assertEquals(joinSinggahsini.getTotalKamarErrorMessage(),message);
    }

    @Then("kabupaten kota field should show error validation {string}")
    public void kabupaten_kota_field_should_show_error_validation(String message) {
        Assert.assertEquals(joinSinggahsini.getKabupatenKotaErrorMessage(),message);
    }
    @Then("alamat lengkap field should show error validation {string}")
    public void alamat_lengkap_field_should_show_error_validation(String message) {
        Assert.assertEquals(joinSinggahsini.getAlamatErrorMessage(),message);

    }
    @When("user fill nama lengkap {string}")
    public void user_fill_nama_lengkap(String name) {
        joinSinggahsini.fillNamaLengkapField(name);
    }
    @When("user fill no handphone {string}")
    public void user_fill_no_handphone(String phoneNumber) {
        joinSinggahsini.fillNoHandphoneField(phoneNumber);
    }
    @When("user fill kos name {string}")
    public void user_fill_kos_name(String kosName) {
        joinSinggahsini.fillKosNameField(kosName);
    }
    @When("user fill alamat {string}")
    public void user_fill_alamat(String address) {
        joinSinggahsini.fillAlamatField(address);
    }
    @When("user search kota {string}")
    public void user_search_kota(String city) {
        joinSinggahsini.fillCitySearchField(city);
    }
    @Then("kota not found message should be display")
    public void kota_not_found_message_should_be_display() {
        Assert.assertEquals(joinSinggahsini.getSearchCityErrorMessage(),"Kota tidak ditemukan");
    }
    @When("user click kembali button")
    public void user_click_kembali_button() {
        joinSinggahsini.clickKembaliButton();
    }
    @When("user choose {string} in confirmation pop up")
    public void user_choose_in_confirmation_pop_up(String action) {
        if (action.equalsIgnoreCase("Keluar")){
            joinSinggahsini.clickKeluarButton();
        } else if (action.equalsIgnoreCase("Lanjut Isi")) {
            joinSinggahsini.clickLanjutIsiButton();
        } else {
            System.out.println("invalid action");
        }
    }
    @Then("user should be redirect to singgahsini.id")
    public void user_should_be_redirect_to_singgahsini_id() {
        String url = singgahsiniUrl;
        if (ENV.equalsIgnoreCase("prod")){
            url = singgahsiniUrl+"/";
        }
        Assert.assertEquals(joinSinggahsini.getURLSinggahsini(),url);
    }
    @When("user submit daftar singgahsini")
    public void user_submit_daftar_singgahsini(DataTable tables) {
        dataProperty = tables.asMaps(String.class, String.class);

        String name = dataProperty.get(0).get("Nama Lengkap");
        String phone = dataProperty.get(0).get("No Handphone");
        String kos = dataProperty.get(0).get("Kos Name");
        String kamar = dataProperty.get(0).get("Total Kamar");
        String kota = dataProperty.get(0).get("Kota");
        String kecamatan = dataProperty.get(0).get("Kecamatan");
        String kelurahan = dataProperty.get(0).get("Kelurahan");
        String alamat = dataProperty.get(0).get("Alamat");

        joinSinggahsini.fillNamaLengkapField(name);
        joinSinggahsini.fillNoHandphoneField(phone);
        joinSinggahsini.fillKosNameField(kos);
        joinSinggahsini.fillTotalKamar(kamar);
        joinSinggahsini.selectKota(kota);
        joinSinggahsini.selectKecamatan(kecamatan);
        joinSinggahsini.selectKelurahan(kelurahan);
        joinSinggahsini.fillAlamatField(alamat);
        joinSinggahsini.clickDaftarButton();
    }

    @Then("system show pop up success register")
    public void system_show_pop_up_success_register() {
        String title = "Anda berhasil mengisi form pendaftaran";
        String subtitle = "Terima kasih telah mendaftar. Tim kami akan menghubungi Anda.";

        Assert.assertEquals(joinSinggahsini.getSuccessRegisterPopUpTitle(),title);
        Assert.assertEquals(joinSinggahsini.getSuccessRegisterPopUpSubtitle(),subtitle);
    }
    @When("user confirm pop up")
    public void user_confirm_pop_up() {
        joinSinggahsini.closeSuccessRegisterPopUp();
    }
}
