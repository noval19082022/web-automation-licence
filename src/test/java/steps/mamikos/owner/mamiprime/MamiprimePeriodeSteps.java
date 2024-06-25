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

    @When("owner only choose period {string} with price {string}")
    public void owner_only_choose_period_with_price(String periode, String price) {
        Assert.assertEquals(mamiprimePeriodePO.getPeriodPrime(periode),periode,"Periode not equals");
        Assert.assertEquals(mamiprimePeriodePO.getPricePeriod(price),price,"Price prime not equals");
        mamiprimePeriodePO.clickOnPeriodePrime(periode);
    }

    @When("owner already choose period {string} with price {string}")
    public void owner_already_choose_period_with_price(String periode, String price) {
        owner_only_choose_period_with_price(periode,price);
        mamiprimePendaftaranPO.clickOnlanjutBayarPrime();
    }

    @When("Validate Lanjut Bayar button on periode mamiprime is disable")
    public void validate_lanjut_bayar_button_on_periode_mamiprime_is_disable(){
        Assert.assertTrue(mamiprimePendaftaranPO.isLanjutBayarButtonDisable());
    }

    @When("Validate Lanjut Bayar button on periode mamiprime is enable")
    public void validate_lanjut_bayar_button_on_periode_mamiprime_is_enable(){
        Assert.assertFalse(mamiprimePendaftaranPO.isLanjutBayarButtonDisable());
    }

}
