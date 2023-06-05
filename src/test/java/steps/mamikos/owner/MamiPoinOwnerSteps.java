package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.owner.MamiPoinOwnerPO;
import utilities.PlaywrightHelpers;

public class MamiPoinOwnerSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    MamiPoinOwnerPO mamipoinOwner = new MamiPoinOwnerPO(page);

    @Then("user verify MamiPoin onboarding is appear")
    public void user_verify_MamiPoin_onboarding_is_appear() {
        //Mamipoin
        Assert.assertEquals(mamipoinOwner.getMamiPoinLandingPageOnboardingText(),"Ini adalah jumlah poin Anda saat ini yang dapat Anda tukarkan dengan berbagai hadiah.");
        mamipoinOwner.clickOnNextButton();

        //Riwayat Hadiah
        Assert.assertEquals(mamipoinOwner.getRewardHistoryOnboardingText(),"Cek seluruh hadiah yang telah Anda tukarkan dengan poin Anda di sini.");
        mamipoinOwner.clickOnNextButton();

        //Riwayat Poin
        Assert.assertEquals(mamipoinOwner.getPointHistoryOnboardingText(),"Semua poin yang didapat dan aktivitas yang telah dilakukan tercatat di sini.");
        mamipoinOwner.clickOnNextButton();

        //Syarat dan Ketentuan
        Assert.assertEquals(mamipoinOwner.getTermAndConditionOnboardingText(),"Pelajari cara-cara untuk mendapatkan poin di bagian ini.");
        mamipoinOwner.clickOnNextButton();

        //Tukar Poin
        Assert.assertEquals(mamipoinOwner.getRedeemPointOnboardingText(),"Anda dapat menukar poin Anda dengan hadiah di bagian ini.");
        mamipoinOwner.clickOnFinishButton();
    }

    @And("user click lihat status on riwayat hadiah")
    public void user_click_status_on_riwayat_hadiah() {
        mamipoinOwner.clickOnLihatStatusRiwayatHadiah();
    }

    @Then("user see status changed to {string}")
    public void user_see_status_changed_to_berhasil(String berhasilStatus) {
        Assert.assertEquals(mamipoinOwner.getDetailStatusText(), berhasilStatus, "status match!");
    }

    @When("user verify point is > {int}")
    public void user_verify_point_is_bigger(Integer discountMamipoinOwner) {
        Assert.assertTrue(mamipoinOwner.getMamipoinOwnerText() > discountMamipoinOwner);
    }

    @When("user verify point is < {int}")
    public void user_verify_point_is_smaller(Integer discountMamipoinOwner) {
        Assert.assertTrue(mamipoinOwner.getMamipoinOwnerText() < discountMamipoinOwner);
    }
    @And("user click toggle mamipoin")
    public void user_click_toggle_mamipoin(){
        mamipoinOwner.clickOnMamiPoinToggle();
    }

    @Then("user see total potongan mamipoin {int}")
    public void user_see_total_potongan_mamipoin(int totalMamipoin) {
        Assert.assertEquals(mamipoinOwner.getTotalDiscountMamipoinText(), totalMamipoin, "total discount mamipoint is not match");
    }
}
