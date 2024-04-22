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

}
