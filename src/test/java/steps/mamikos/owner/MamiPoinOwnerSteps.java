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

    @When("user verify mamipoin on widget < {int}")
    public void user_verify_mamipoin_on_widget_smaller(Integer mamipoin) {
        Assert.assertTrue(mamipoinOwner.getMamipoinWidgetText() < mamipoin);
    }

    @When("user verify mamipoin on widget > {int}")
    public void user_verify_mamipoin_on_widget_bigger(Integer mamipoin) {
        Assert.assertTrue(mamipoinOwner.getMamipoinWidgetText() > mamipoin);
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

    @Then("user verify title in the mamipoin owner landing page is displayed")
    public void user_verify_title_in_the_mamipoin_owner_landing_page_is_displayed() {
        Assert.assertTrue(mamipoinOwner.isTitleInTheMamipoinOwnerLandingPageDisplayed());
    }

    @Then("user verify tukar poin button is displayed")
    public void user_verify_tukar_poin_button_is_displayed() {
        Assert.assertTrue(mamipoinOwner.isTukarPoinButtonDisplayed());
    }

    @Then("user verify riwayat hadiah button is displayed")
    public void user_verify_riwayat_hadiah_button_is_displayed() {
        Assert.assertTrue(mamipoinOwner.isRiwayatHadiahButtonDisplayed());
    }

    @Then("user verify riwayat poin owner button is displayed")
    public void user_verify_riwayat_poin_owner_button_is_displayed() {
        Assert.assertTrue(mamipoinOwner.isRiwayatPoinButtonDisplayed());
    }

    @Then("user verify syarat dan ketentuan button is displayed")
    public void user_verify_syarat_dan_ketentuan_button_is_displayed() {
        Assert.assertTrue(mamipoinOwner.isSyaratDanKetentuanButtonDisplayed());
    }

    @When("user clicks on tukar poin button")
    public void user_clicks_on_tukar_poin_button() {
        mamipoinOwner.clickOnTukarPoinButton();
    }

    @Then("user verify tukar poin onboarding is appear")
    public void user_verify_tukar_poin_onboarding_is_appear() {
        //Poin Anda
        Assert.assertEquals(mamipoinOwner.getPoinAndaOnboardingText(),"Pastikan poin Anda cukup untuk ditukarkan dengan hadiah yang Anda inginkan.");
        mamipoinOwner.clickOnNextButton();

        //Hadiah Bisa Ditukar
        Assert.assertEquals(mamipoinOwner.getHadiahBisaDitukarOnboardingText(),"Anda dapat menukar poin Anda sesuai dengan jumlah yang dibutuhkan hadiah terkait.");
        mamipoinOwner.clickOnNextButton();

        //Bantuan
        Assert.assertEquals(mamipoinOwner.getBantuanOnboardingText(),"Tekan tombol Bantuan untuk kembali mempelajari cara penukaran poin.");
        mamipoinOwner.clickOnSelesaiButton();
    }

    @Then("user verify title in the tukar poin page is displayed")
    public void user_verify_title_in_the_tukar_poin_page_is_displayed() {
        Assert.assertTrue(mamipoinOwner.isTitleInTheTukarPoinPageDisplayed());
    }

    @Then("user verify logo in the tukar poin page is displayed")
    public void user_verify_logo_in_the_tukar_poin_page_is_displayed() {
        Assert.assertTrue(mamipoinOwner.isLogoInTheTukarPoinPageDisplayed());
    }

    @Then("user verify the amount of MamiPoin Anda is {string}")
    public void user_verify_the_amount_of_mami_poin_anda_is(String amountOfMamipoinAnda) {
        Assert.assertEquals(mamipoinOwner.verifyAmountOfMamipoinAnda(amountOfMamipoinAnda),"123.456 Poin");
    }

    @Then("user verify bantuan button is displayed")
    public void user_verify_bantuan_button_is_displayed() {
        Assert.assertTrue(mamipoinOwner.isBantuanButtonDisplayed());
    }

}
