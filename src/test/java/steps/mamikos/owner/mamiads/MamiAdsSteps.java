package steps.mamikos.owner.mamiads;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.owner.goldplus.GoldplusPO;
import pageobject.owner.mamiads.MamiAdsPO;
import utilities.PlaywrightHelpers;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class MamiAdsSteps {
    Page page = ActiveContext.getActivePage();
    MamiAdsPO mamiAdsPO = new MamiAdsPO(page);
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    private Integer riwayatBeforeBeliSaldo;
    GoldplusPO goldplus = new GoldplusPO(page);

    @When("user navigates to mamiads dashboard")
    public void user_navigates_to_mamiads_dashboard() {
        mamiAdsPO.navigatesToMamiads();
    }

    @And("user navigate to mamiads history page")
    public void userNavigateToMamiadsHistoryPage() {
        mamiAdsPO.navigatesToMamiadsHistory();
    }

    @And("owner want to buy mamiads saldo with nominal {string}")
    public void ownerWantToBuyMamiadsSaldo(String saldo) {
        mamiAdsPO.purchaseOwnerSaldoFromMamiads(saldo);
    }

    @And("user filter iklan by iklan nonaktif")
    public void userFilterIklanByIklanNonaktif() {
        mamiAdsPO.clickOnSemuaIklan();
        mamiAdsPO.clickOnIklanNonaktif();
    }

    @And("user close mamiads onboarding popup")
    public void userCloseMamiadsOnboardingPopup() {
        mamiAdsPO.handlePopupMamiAds();
    }

    @And("user see title {string} with message {string}")
    public void user_see_title_x_with_message_x(String title, String message) {
        Assert.assertEquals(mamiAdsPO.getTitleText(), title);
        Assert.assertEquals(mamiAdsPO.getMessageText(), message);
    }

    @And("user verify count of riwayat before beli saldo")
    public void userVerifyCountOfRiwayatBeforeBeliSaldo() {
        riwayatBeforeBeliSaldo = mamiAdsPO.getCountRiwayatBeliSaldo();
    }

    @And("user wants to buy saldo MamiAds {string}")
    public void userWantsToBuySaldoMamiAds(String saldo) {
        mamiAdsPO.clickOnBeliSaldoBtn();
        mamiAdsPO.choosingSaldoToBuy(saldo);
        mamiAdsPO.isDetailTagihanPresent();
        mamiAdsPO.clicksOnBayarSekarangButton();
    }

    @Then("user verify count of riwayat added {int}")
    public void userVerifyCountOfRiwayatAdded(int numberAdded) {
        int riwayatAfterBeliSaldo = mamiAdsPO.getCountRiwayatBeliSaldo();
        Assert.assertEquals(riwayatAfterBeliSaldo, (riwayatBeforeBeliSaldo+numberAdded), "Count of riwayat doesn't Match");
    }

    @Then("user redirected to guides page mamiAds")
    public void user_redirected_to_guides_page_mami_ads() {
        assertThat(page).hasURL(Mamikos.OWNER_URL + Mamikos.MAMIADS_GUIDE);
    }

    @Then("tap back button on panduan Mamiads.")
    public void tap_back_button_on_panduan_mamiads() {
       mamiAdsPO.clickOnPanduanMamiAdsBackButton();
    }

    @Then("user redirected to guides page mamiAds from GP")
    public void user_redirected_to_guides_page_mami_ads_from_gp() {
        assertThat(page).hasURL(Mamikos.OWNER_URL + Mamikos.MAMIADS_GUIDE_GP);
    }

    @And("user will see title and message on Dalam Proses tab")
    public void willSeeTitleAndMessageOnDalamProsesTab() {
        Assert.assertEquals(mamiAdsPO.getTitleDalamProsesText(), "Belum Ada Transaksi");
        Assert.assertTrue(playwright.isTextDisplayed("Transaksi yang masih dalam proses akan muncul di halaman ini."));
    }

    @And("user will see title and message on Selesai tab")
    public void willSeeTitleAndMessageOnSelesaiTab() {
        Assert.assertEquals(mamiAdsPO.getTitleSelesaiText(), "Belum Ada Transaksi");
        Assert.assertTrue(playwright.isTextDisplayed("Transaksi yang sudah selesai akan muncul di halaman ini."));
    }

    @When("owner see button coba sekarang at header")
    public void owner_see_button_coba_sekarang_at_header() {
        mamiAdsPO.isCobaSekarangButtonHeaderisDisplayed();
    }

    @And("user click question {string}")
    public void user_click_question(String questionText) throws InterruptedException {
        mamiAdsPO.clickOnQuestionText(questionText);
    }

    @Then("user verify answer text {string}")
    public void user_verify_answer_text(String answerText) {
        Assert.assertEquals(mamiAdsPO.getAnswerText(answerText), answerText);
    }

    @And("validate status transaction mamiads is {string} with price {string} saldo {string}")
    public void validate_status_transaction_mamiads_with_price(String status, String price, String saldo) {
        Assert.assertEquals(mamiAdsPO.gettransactionList(1), saldo);
        Assert.assertEquals(mamiAdsPO.gettransactionList(2), price);
        Assert.assertEquals(mamiAdsPO.gettransactionList(3), status);
    }

    @When("user input {string} as kode voucher")
    public void user_input_as_kode_voucher(String voucherCode) {
       mamiAdsPO.inputVoucherCode(voucherCode);
    }

    @When("user click Pakai button")
    public void user_click_pakai_button() throws InterruptedException {
       mamiAdsPO.clickOnPakaiVoucherButton();
    }

    @Then("validate the warning {string}")
    public void validate_the_warning(String warningText) {
        Assert.assertEquals(mamiAdsPO.getMessageWarningVoucher(), warningText, "Warning message doesn't match!");
    }

    @When("user clear the voucher code")
    public void user_clear_the_voucher_code() {
        mamiAdsPO.clearVoucherCode();
    }

    @When("owner click masukkan voucher")
    public void owner_click_masukkan_voucher() {
        mamiAdsPO.clickOnInputVoucher();
    }


}
