package steps.mamikos.owner.mamiprime;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.owner.mamiprime.MamiprimePendaftaranPO;

import java.util.List;
import java.util.Map;

public class MamiprimePendaftaranSteps {
    Page page = ActiveContext.getActivePage();
    MamiprimePendaftaranPO mamiprimePendaftaran = new MamiprimePendaftaranPO(page);
    MamiprimePeriodeSteps mamiprimePeriodeSteps = new MamiprimePeriodeSteps();
    MamiprimeDetailTagihanSteps mamiprimeDetailTagihanSteps = new MamiprimeDetailTagihanSteps();
    private List<Map<String, String>> keyword;

    @When("owner navigate to pendaftaran mamiprime page")
    public void owner_navigate_to_pendaftaran_mamiprime_page() {
        mamiprimePendaftaran.navigatesToPendaftaranMamiprime();
    }

    @When("owner select option mamiprime {string} from mamiprime landing")
    public void owner_navigate_to_pendaftaran_mamiprime_page_and_select_mamiprime_srp(String mamiprimeOption) {
        mamiprimePendaftaran.selectOptionMamiprime(mamiprimeOption);
        mamiprimePendaftaran.clickOnLanjutkanBtnFromMamiprimeLanding();
    }

    @Then("owner will see additional information related to GP")
    public void owner_will_see_additional_information_related_to_gp() {
        String expected = "Anda belum memakai GoldPlus. Pemakaian MamiPrime bersama GoldPlus akan membawa hasil yang optimal.";
        Assert.assertEquals(mamiprimePendaftaran.getNonGPInformationText(), expected.replaceAll("\\s", ""));
    }

    @Then("owner can see {string} has label {string} at section select property")
    public void owner_can_see_has_label_at_section_select_property(String kost, String label) {
        Assert.assertEquals(mamiprimePendaftaran.getPropertyNamePrime(), kost, "Name property does not equals");
        Assert.assertEquals(mamiprimePendaftaran.getLabelTextFull(), label, "Label name doesnt equal");
    }

    @Then("owner can see information {string} at section select periode")
    public void owner_can_see_information_at_section_select_periode(String information) {
        Assert.assertEquals(mamiprimePendaftaran.getInformationTextPrimeFull(), information, "Information does not equal");
    }

    @Then("owner can see description information {string} at section select periode")
    public void owner_can_see_description_information_at_section_select_periode(String desc) {
        Assert.assertEquals(mamiprimePendaftaran.getDescInformationTextPrimeFull(), desc, "Description does not equal");
    }

    @Then("owner can see {string} doesnt have label {string} at section select property")
    public void owner_can_see_doesnt_have_label_at_section_select_property(String kost, String label) {
        Assert.assertEquals(mamiprimePendaftaran.getPropertyNamePrime(), kost, "Name property does not equals");
        Assert.assertFalse(mamiprimePendaftaran.isLabelFullPrimeisAppear(), "Label full is appear");

    }

    @Then("owner will see Pilih Periode section will display package prices")
    public void owner_will_see_pilih_periode_section_will_display_package_prices() {
        Assert.assertTrue(mamiprimePendaftaran.isListPeriodeAppear(), "List periode not appear");
    }

    @When("owner wants to change {string} at detail tagihan page")
    public void owner_wants_to_change_at_detail_tagihan_page(String packgaePrime) {
        Assert.assertTrue(mamiprimePendaftaran.isDetailTagihanAppear(), "detail tagihan page doesnt appear");
        Assert.assertEquals(mamiprimePendaftaran.getPackagePrimeDetailTagihan(packgaePrime), packgaePrime, "package prime doesnt equal");
        mamiprimePendaftaran.clickOnUbahTagihanPrime();
    }

    @Then("owner will back to pendafatarn mamiprime page")
    public void owner_will_back_to_pendafatarn_mamiprime_page() {
        Assert.assertTrue(mamiprimePendaftaran.isPendaftaranPrimeAppear(), "Pendaftaran prime page doesnt appear");
    }

    @Then("owner can see package prime selected is {string}")
    public void owner_can_see_package_prime_selected_is(String packgaePrime) {
        Assert.assertTrue(mamiprimePendaftaran.isDetailTagihanAppear(), "detail tagihan page doesnt appear");
        Assert.assertEquals(mamiprimePendaftaran.getPackagePrimeDetailTagihan(packgaePrime), packgaePrime, "package prime doesnt equal");
    }

    @When("Owner purchase mamiprime periode {string}")
    public void owner_purchase_mamiprime_periode(String periode) {
        mamiprimePeriodeSteps.owner_choose_periode(periode);
        mamiprimePendaftaran.clickOnlanjutBayarPrime();
        mamiprimeDetailTagihanSteps.owner_click_bayar_sekarang_at_detail_tagihan_mamiprime();
    }

    @Then("owner see auto-select would be the first order")
    public void owner_see_auto_select_would_be_the_first_order() {
        mamiprimePendaftaran.ownerSeeAutoSelectFirstOrder();
    }

    @Then("{string} are displayed in the register mamiprime")
    public void areDisplayedInTheKosAndalan(String name, DataTable tables) {
        keyword = tables.asMaps();
        int limit = name.equalsIgnoreCase("Keyword") ? 5 : 0;
        limit = Math.min(limit, keyword.size());

        for (int i = 0; i < limit; i++) {
            String assertkeywordTable = keyword.get(i).get(name);
            mamiprimePendaftaran.assertkeyword(assertkeywordTable);
        }
    }

    @When("owner click on Hubungi Kami")
    public void owner_click_on_Hubungi_Kami() {
        mamiprimePendaftaran.ownerClickOnHubungiKami();
    }

    @When("owner click on Chat dengan CS")
    public void owner_click_on_Chat_dengan_CS() {
        mamiprimePendaftaran.ownerClickOnChatDenganCS();
    }

}
