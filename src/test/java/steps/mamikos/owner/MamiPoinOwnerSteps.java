package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
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
}
