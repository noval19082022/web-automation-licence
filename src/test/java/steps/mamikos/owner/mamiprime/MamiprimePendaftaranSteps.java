package steps.mamikos.owner.mamiprime;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.owner.mamiprime.MamiprimePendaftaranPO;

public class MamiprimePendaftaranSteps {
    Page page = ActiveContext.getActivePage();
    MamiprimePendaftaranPO mamiprimePendaftaran = new MamiprimePendaftaranPO(page);

    @When("owner navigate to pendaftaran mamiprime page")
    public void owner_navigate_to_pendaftaran_mamiprime_page(){
        mamiprimePendaftaran.navigatesToPendaftaranMamiprime();
    }

    @Then("owner will see additional information related to GP")
    public void owner_will_see_additional_information_related_to_gp(){
        String expected = "Anda belum memakai GoldPlus. Pemakaian MamiPrime bersama GoldPlus akan membawa hasil yang optimal.";
        Assert.assertEquals(mamiprimePendaftaran.getNonGPInformationText(), expected.replaceAll("\\s", ""));
    }

    @Then("owner can see {string} has label {string} at section select property")
    public void owner_can_see_has_label_at_section_select_property(String kost, String label) {
       Assert.assertEquals(mamiprimePendaftaran.getPropertyNamePrime(),kost,"Name property doesnt equals");
       Assert.assertEquals(mamiprimePendaftaran.getLabelTextFull(),label,"Label name doesnt equal");
    }

    @Then("owner can see information {string} at section select periode")
    public void owner_can_see_information_at_section_select_periode(String information) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("owner can see description information {string} at section select periode")
    public void owner_can_see_description_information_at_section_select_periode(String desc) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
