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
import testdata.HarvestData;
import utilities.PlaywrightHelpers;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class NLBRegistrationSteps {

    Page page = ActiveContext.getActivePage();
    NLBRegistrationPO nlbRegistration = new NLBRegistrationPO(page);
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);

    private List<Map<String, String>> formData;

    @Given("user navigates to NLB registration page")
    public void user_navigates_to_NLB_registration_page() {
        nlbRegistration.navigateToNLBRegistrationPage();
    }

    @And("user fill and submit NLB registration form")
    public void user_fill_and_submit_NLB_registration_form(DataTable tables) {
        formData = tables.asMaps(String.class, String.class);

        String name = formData.get(0).get("Nama Pemilik Kos");
        String totalKamarDikelola = formData.get(0).get("Total Kamar Dikelola");
        String totalKamarTerisi = formData.get(0).get("Total Kamar Terisi");
        String kota = formData.get(0).get("Kota");
        String kecamatan = formData.get(0).get("Kecamatan");
        String kelurahan = formData.get(0).get("Kelurahan");
        String tipeKamar = formData.get(0).get("Tipe Kamar");
        String hargaSewa = formData.get(0).get("Harga Sewa");
        String renovasi = formData.get(0).get("Renovasi");
        String itemRenovasi = formData.get(0).get("Item Renovasi");
        String penjelasanRenovasi = formData.get(0).get("Penjelasan Renovasi");
        String pemilikMamikos = formData.get(0).get("Pemilik Mamikos");

        // Generate random 12-digit phone number starting with 0823
        String phoneNumber = generateRandomPhoneNumber();
        HarvestData.setNlbPhoneNumber(phoneNumber);
        System.out.println("Generated NLB phone number: " + phoneNumber);

        nlbRegistration.fillNamaPemilikKos(name);
        nlbRegistration.fillNomorHP(phoneNumber);
        nlbRegistration.fillTotalKamarDikelola(totalKamarDikelola);
        nlbRegistration.fillTotalKamarTerisi(totalKamarTerisi);
        nlbRegistration.selectKota(kota);
        nlbRegistration.selectKecamatan(kecamatan);
        nlbRegistration.selectKelurahan(kelurahan);
        nlbRegistration.selectTipeKamar(tipeKamar);
        if (hargaSewa != null && !hargaSewa.isEmpty()) {
            nlbRegistration.fillHargaSewa(hargaSewa);
        }
        nlbRegistration.selectRenovasi(renovasi);
        if (itemRenovasi != null && !itemRenovasi.isEmpty()) {
            String[] items = itemRenovasi.split(",");
            for (String item : items) {
                nlbRegistration.selectItemRenovasi(item.trim());
            }
        }
        if (penjelasanRenovasi != null && !penjelasanRenovasi.isEmpty()) {
            nlbRegistration.fillPenjelasanRenovasi(penjelasanRenovasi);
        }
        nlbRegistration.selectPemilikMamikos(pemilikMamikos);
        nlbRegistration.clickDaftarButton();
    }

    @Then("system show NLB registration success message")
    public void system_show_NLB_registration_success_message() {
        Assert.assertTrue(nlbRegistration.isSuccessPopUpVisible(), "NLB registration success pop up is not visible!");
        nlbRegistration.closeSuccessPopUp();
    }

    @When("admin search leads by {string} with saved NLB phone number")
    public void admin_search_leads_by_with_saved_NLB_phone_number(String searchType) {
        String phoneNumber = HarvestData.getNlbPhoneNumber();
        System.out.println("Searching LBT with phone number: " + phoneNumber);
        nlbRegistration.searchLBTByPhoneNumber(phoneNumber);
    }

    @Then("leads with saved NLB phone number found in LBT")
    public void leads_with_saved_NLB_phone_number_found_in_LBT() {
        String phoneNumber = HarvestData.getNlbPhoneNumber();
        playwright.waitTillPageLoaded();
        String result = nlbRegistration.getPhoneNumberInLBT(phoneNumber);
        Assert.assertNotNull(result, "Leads with phone number " + phoneNumber + " not found in LBT!");
        Assert.assertTrue(result.contains(phoneNumber),
                "Phone number " + phoneNumber + " not found in LBT table!");
    }

    @And("leads status is {string}")
    public void leads_status_is(String expectedStatus) {
        String phoneNumber = HarvestData.getNlbPhoneNumber();
        String actualStatus = nlbRegistration.getLeadsStatus(phoneNumber);
        Assert.assertTrue(actualStatus.contains(expectedStatus),
                "Expected leads status '" + expectedStatus + "' but got '" + actualStatus + "'");
    }

    @Then("leads with saved NLB phone number not found in LBT")
    public void leads_with_saved_NLB_phone_number_not_found_in_LBT() {
        String phoneNumber = HarvestData.getNlbPhoneNumber();
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
