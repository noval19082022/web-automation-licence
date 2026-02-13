package steps.mamikos.harvest;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.harvest.NLBRegistrationPO;
import pageobject.singgahsini.JoinSinggahsiniPO;
import testdata.HarvestData;
import utilities.PlaywrightHelpers;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class ILBRegistrationSteps {

    Page page = ActiveContext.getActivePage();
    JoinSinggahsiniPO joinSinggahsini = new JoinSinggahsiniPO(page);
    NLBRegistrationPO nlbRegistration = new NLBRegistrationPO(page);
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);

    private List<Map<String, String>> formData;

    @Given("user navigates to ILB registration page")
    public void user_navigates_to_ILB_registration_page() {
        joinSinggahsini.navigateToSinggahsiniDaftar();
    }

    @And("user fill and submit ILB registration form")
    public void user_fill_and_submit_ILB_registration_form(DataTable tables) {
        formData = tables.asMaps(String.class, String.class);

        String namaLengkap = formData.get(0).get("Nama Lengkap");
        String namaKos = formData.get(0).get("Nama Kos");
        String totalKamar = formData.get(0).get("Total Kamar");
        String kota = formData.get(0).get("Kota");
        String kecamatan = formData.get(0).get("Kecamatan");
        String kelurahan = formData.get(0).get("Kelurahan");
        String alamat = formData.get(0).get("Alamat");

        // Generate random 12-digit phone number starting with 0823
        String phoneNumber = generateRandomPhoneNumber();
        HarvestData.setIlbPhoneNumber(phoneNumber);
        System.out.println("Generated ILB phone number: " + phoneNumber);

        joinSinggahsini.fillNamaLengkapField(namaLengkap);
        joinSinggahsini.fillNoHandphoneField(phoneNumber);
        joinSinggahsini.fillKosNameField(namaKos);
        joinSinggahsini.fillTotalKamar(totalKamar);
        joinSinggahsini.selectKota(kota);
        joinSinggahsini.selectKecamatan(kecamatan);
        joinSinggahsini.selectKelurahan(kelurahan);
        joinSinggahsini.fillAlamatField(alamat);
        joinSinggahsini.clickDaftarButton();
    }

    @Then("system show ILB registration success message")
    public void system_show_ILB_registration_success_message() {
        String title = "Anda berhasil mengisi form pendaftaran";
        Assert.assertEquals(joinSinggahsini.getSuccessRegisterPopUpTitle(), title,
                "ILB registration success pop up title mismatch!");
        joinSinggahsini.closeSuccessRegisterPopUp();
    }

    @When("admin search leads by {string} with saved ILB phone number")
    public void admin_search_leads_by_with_saved_ILB_phone_number(String searchType) {
        String phoneNumber = HarvestData.getIlbPhoneNumber();
        System.out.println("Searching LBT with ILB phone number: " + phoneNumber);
        nlbRegistration.searchLBTByPhoneNumber(phoneNumber);
    }

    @Then("leads with saved ILB phone number found in LBT")
    public void leads_with_saved_ILB_phone_number_found_in_LBT() {
        String phoneNumber = HarvestData.getIlbPhoneNumber();
        playwright.waitTillPageLoaded();
        String result = nlbRegistration.getPhoneNumberInLBT(phoneNumber);
        Assert.assertNotNull(result, "Leads with phone number " + phoneNumber + " not found in LBT!");
        Assert.assertTrue(result.contains(phoneNumber),
                "Phone number " + phoneNumber + " not found in LBT table!");
    }

    @And("ILB leads status is {string}")
    public void ilb_leads_status_is(String expectedStatus) {
        String phoneNumber = HarvestData.getIlbPhoneNumber();
        String actualStatus = nlbRegistration.getLeadsStatus(phoneNumber);
        Assert.assertTrue(actualStatus.contains(expectedStatus),
                "Expected leads status '" + expectedStatus + "' but got '" + actualStatus + "'");
    }

    @Then("leads with saved ILB phone number not found in LBT")
    public void leads_with_saved_ILB_phone_number_not_found_in_LBT() {
        String phoneNumber = HarvestData.getIlbPhoneNumber();
        playwright.waitTillPageLoaded();
        boolean found = nlbRegistration.isPhoneNumberInLBT(phoneNumber);
        Assert.assertFalse(found, "Leads with phone number " + phoneNumber + " should NOT be found in LBT!");
    }

    /**
     * Generate random 12-digit phone number starting with 0823
     * @return phone number string
     */
    private String generateRandomPhoneNumber() {
        Random random = new Random();
        String suffix = String.format("%08d", random.nextInt(100000000));
        return "0823" + suffix;
    }
}
