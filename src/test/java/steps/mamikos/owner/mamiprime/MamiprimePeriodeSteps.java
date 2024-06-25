package steps.mamikos.owner.mamiprime;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.owner.mamiprime.MamiprimePendaftaranPO;
import pageobject.owner.mamiprime.MamiprimePeriodePO;

public class MamiprimePeriodeSteps {
    Page page = ActiveContext.getActivePage();
    MamiprimePeriodePO mamiprimePeriodePO = new MamiprimePeriodePO(page);
    MamiprimePendaftaranPO mamiprimePendaftaranPO = new MamiprimePendaftaranPO(page);

    @When("owner already choose period {string} with price {string}")
    public void owner_already_choose_period_with_price(String periode, String price) {
        Assert.assertEquals(mamiprimePeriodePO.getPeriodPrime(periode),periode,"Periode not equals");
        Assert.assertEquals(mamiprimePeriodePO.getPricePeriod(price),price,"Price prime not equals");
        mamiprimePeriodePO.clickOnPeriodePrime(periode);
        mamiprimePendaftaranPO.clickOnlanjutBayarPrime();
    }

    @When("Validate Lanjut Bayar button on periode mamiprime is disable")
    public void owner_navigate_to_pendaftaran_mamiprime_page(){
        Assert.assertTrue(mamiprimePendaftaranPO.isLanjutBayarButtonDisable());
    }

}
