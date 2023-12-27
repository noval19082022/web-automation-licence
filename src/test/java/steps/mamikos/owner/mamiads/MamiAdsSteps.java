package steps.mamikos.owner.mamiads;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.owner.fiturpromosi.mamiads.DetailTagihanPO;
import pageobject.owner.fiturpromosi.mamiads.MamiAdsPO;
import utilities.PlaywrightHelpers;

import java.util.List;
import java.util.Map;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class MamiAdsSteps {
    Page page = ActiveContext.getActivePage();
    MamiAdsPO mamiAdsPO = new MamiAdsPO(page);
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    private Integer riwayatBeforeBeliSaldo;
    DetailTagihanPO detailTagihanPO = new DetailTagihanPO(page);
    private Map<String, String> adsData;

    @When("user navigates to mamiads dashboard")
    public void user_navigates_to_mamiads_dashboard() {
        mamiAdsPO.navigatesToMamiads();
    }

    @When("user navigates to mamiads pembelian saldo")
    public void user_navigates_to_mamiads_pembelian_saldo() {
        mamiAdsPO.navigatesToMamiadsBalance();
    }

    @And("user navigate to mamiads history page")
    public void userNavigateToMamiadsHistoryPage() {
        mamiAdsPO.navigatesToMamiadsHistory();
    }

    @And("owner want to buy mamiads saldo with nominal {string}")
    public void ownerWantToBuyMamiadsSaldo(String saldo) {
        mamiAdsPO.clickSaldoMamiadsCard();
        mamiAdsPO.handlePopupMamiAds();
        mamiAdsPO.clickOnBeliSaldoBtn();
        mamiAdsPO.choosingSaldoToBuy(saldo);
        detailTagihanPO.clicksOnBayarSekarangButton();
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

    @And("user click Beli Saldo on mamiads dashboard")
    public void user_click_beli_saldo_on_mamiads_dashboard() {
        mamiAdsPO.handlePopupMamiAds();
        mamiAdsPO.clickOnBeliSaldoBtn();
    }

    @And("favorit saldo is {string}")
    public void favorit_saldo_is(String saldo){
        Assert.assertTrue(mamiAdsPO.favoriteSaldo(saldo));
    }

    @And("detail list saldo as expected")
    public void user_see_below_data_is_correct_as_text(DataTable dataTable) {
        List<Map<String, String>> table = dataTable.asMaps();
        int i=0;int j=0;
        for (Map<String, String> content : table) {
            Assert.assertEquals(mamiAdsPO.listSaldo("price",i),content.get("price"));
            Assert.assertEquals(mamiAdsPO.listSaldo("priceInRp",i),content.get("priceInRp"));
            try{
                if(!content.get("disc").isEmpty()){
                    Assert.assertEquals(mamiAdsPO.listSaldo("disc",j),content.get("disc"));
                    Assert.assertEquals(mamiAdsPO.listSaldo("discPrice",j),content.get("discPrice"));
                    j++;
                }
            } catch (java.lang.NullPointerException ignored) { }
            i++;
        }
    }

    @And("owner choose saldo {string}")
    public void owner_choose_saldo(String saldo){
        mamiAdsPO.choosingSaldoToBuy(saldo);
    }

    @And("user wants to buy saldo MamiAds {string}")
    public void userWantsToBuySaldoMamiAds(String saldo) {
        mamiAdsPO.clickOnBeliSaldoBtn();
        mamiAdsPO.choosingSaldoToBuy(saldo);
        mamiAdsPO.isDetailTagihanPresent();
        detailTagihanPO.clicksOnBayarSekarangButton();
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

    @And("owner back to list voucher")
    public void owner_back_to_list_voucher() {
       mamiAdsPO.clickOnCLosePopUpVoucher();
    }

    @Then("user verify {string} is present on list voucher")
    public void user_verify_is_present_on_list_voucher(String voucherTitle) {
        Assert.assertTrue(mamiAdsPO.isVoucherPresentOnList(voucherTitle), "Voucher doesn't present on list!");
    }

    @When("user click on {string} {string} voucher")
    public void user_click_on_voucher(String button, String voucherTitle) throws InterruptedException {
        String element = null;
        switch (button){
            case "Lihat Detail": element = "//*[.='"+ voucherTitle +"']/parent::*/following-sibling::*/button[contains(@class, 'b-detail')]"; break;
            case "Pakai": element = "//*[.='"+ voucherTitle +"']/parent::*/following-sibling::*/button[contains(@class, 'b-apply')]"; break;
        }
        mamiAdsPO.clickOnVoucherOnList(element);
    }

    @Then("verify a detail voucher as expected")
    public void verify_a_detail_voucher_as_expected(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> table = dataTable.asMaps();
        int i=0;
        for (Map<String, String> content : table) {
            Assert.assertEquals(mamiAdsPO.detailVoucher("voucherTitle",i),content.get("voucherTitle"));
            Assert.assertEquals(mamiAdsPO.detailVoucher("voucherCode",i),content.get("voucherCode"));
            Assert.assertEquals(mamiAdsPO.detailVoucher("voucherExpired",i),content.get("voucherExpired"));
            Assert.assertEquals(mamiAdsPO.detailVoucher("voucherTnC",i),content.get("voucherTnC"));
            i++;
        }
    }

    @Then("user verify the toast {string}")
    public void user_verify_the_toast(String messageToastOffIklan) {
        Assert.assertEquals(mamiAdsPO.getTextMessageToastVoucher(), messageToastOffIklan, "Message doesn't match!");
    }

    @When("user click hapus voucher")
    public void user_click_hapus_voucher() throws InterruptedException {
        mamiAdsPO.clickOnDeleteVoucher();
    }

    @Then("owner wants to accsess voucher list")
    public void owner_wants_to_accsess_voucher_list() {
       mamiAdsPO.clickOnInputVoucherList();
    }

    @Then("owner verify invoice success paid mamiads")
    public void ownerVerifyInvoiceSuccessPaidMamiads() {
        mamiAdsPO.navigatesToMamiadsHistory();
        playwright.clickOnText("Selesai");
        var page1 = ActiveContext.getActiveBrowserContext().waitForPage(() -> {
            mamiAdsPO.clickOnInvoiceMamiads();
        });
        var pwHelper2 = new PlaywrightHelpers(page1);
        Assert.assertTrue(pwHelper2.isTextDisplayed("Pembayaran Berhasil", 5000));
    }

    @And("user click coba sekarang header")
    public void user_click_coba_sekarang_header() {
        mamiAdsPO.clickOnCobaSekarangHeader();
    }

    @And("user click ubah on {string}")
    public void user_click_ubah_on_x(String adsName) {
        mamiAdsPO.clickOnUbahbutton(adsName);
    }

    @And("user set anggaran harian to {string}")
    public void user_set_anggaran_harian_to_x(String anggaran) {
        mamiAdsPO.inputNominalAnggaran(anggaran);
    }

    @And("user set anggaran to saldo maksimal")
    public void user_set_anggaran_to_saldo_maksimal() {
        mamiAdsPO.clickOnSaldoMaksimal();
    }

    @And("user set anggaran to dibatasi harian")
    public void user_set_anggaran_to_dibatasi_harian() {
        mamiAdsPO.clickOnDibatasiHarian();
    }

    @And("user click Ya,Ganti button")
    public void user_click_ya_ganti_button() {
        mamiAdsPO.clickOnYaGantiButton();
    }

    @Then("user check ads status:")
    public void user_check_ads_status(DataTable table) {
        adsData = table.asMap(String.class, String.class);
        var adsName = adsData.get("ads name");
        var textStatus = adsData.get("text status");
        var toggleStatus = adsData.get("toggle status");
        var statusDesc = adsData.get("status desc");
        var textAnggaran = adsData.get("text anggaran");

        if (textStatus.equals("Naik")) {
            Assert.assertEquals(mamiAdsPO.getPosisiIklan(adsName, "naik"), "Naik");
        } else {
            Assert.assertEquals(mamiAdsPO.getPosisiIklan(adsName, "tidak-naik"), "Tidak Naik");
        }
        mamiAdsPO.getToggleStaus(adsName,toggleStatus);
        Assert.assertEquals(mamiAdsPO.getAdsStatusDesc(adsName), statusDesc, "Ads status description doesn't match!");
        Assert.assertEquals(mamiAdsPO.getTextAnggaranDesc(adsName), textAnggaran, "Anggaran description doesn't match!");
    }

    @And("user click beli saldo on popup")
    public void user_click_beli_saldo_on_popup() {
        mamiAdsPO.clickOnBeliSaldoOnPopup();
    }

    @And("user click beli saldo on popup on toggle iklan")
    public void user_click_beli_saldo_on_popup_on_toggle() {
        mamiAdsPO.clickOnBeliSaldoOnPopupToggle();
    }
}
