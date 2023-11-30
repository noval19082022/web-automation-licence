package steps.mamikos.tenant.profile;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.tenant.profile.VoucherSayaPO;
import utilities.PlaywrightHelpers;

public class VoucherSayaSteps {

    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    VoucherSayaPO voucherSaya = new VoucherSayaPO(page);

    @Then("user see voucher list header")
    public void userSeeVoucherListHeader() {
        Assert.assertTrue(voucherSaya.isVoucherTitlePresent(), "voucher title is not present");
        ;
    }

    @And("user see {string} tab on voucher saya page")
    public void userSeeTabOnVoucherSayaPage(String textTab) {
        voucherSaya.isTabPresent(textTab);
    }

    @And("user see Promo Lainnya")
    public void userSeePromoLainnya() {
        voucherSaya.isVoucherPromoLainnyaVisible();
    }

    @Then("user see voucher card")
    public void user_see_voucher_card() {
        Assert.assertTrue(voucherSaya.isVoucherCardVisible(), "voucher card is not present");
    }
    @Then("user see voucher list image")
    public void user_see_voucher_list_image() {
        Assert.assertTrue(voucherSaya.isVoucherListImageVisible(), "voucher list is not present");
    }
    @Then("user see voucher list Expired Date")
    public void user_see_voucher_list_expired_date() {
        Assert.assertTrue(voucherSaya.isVoucherListExpiredDateVisible(), "voucher list expired is not present");
    }
    @Then("user see voucher list Kode Voucher label")
    public void user_see_voucher_list_kode_voucher_label() {
        Assert.assertTrue(voucherSaya.isVoucherListKodeVoucherLabelVisible(), "voucher list Kode Voucher is not present");
    }
    @Then("user see voucher list Voucher code")
    public void user_see_voucher_list_voucher_code() {
        Assert.assertTrue(voucherSaya.isVoucherListVoucherCodeVisible(), "voucher list Voucher Code is not present");
    }
    @Then("user see voucher list Salin button")
    public void user_see_voucher_list_salin_button() {
        Assert.assertTrue(voucherSaya.isVoucherListSalinButtonVisible(), "voucher list Salin Button is not present");
    }
    @When("user click {string} tab on voucher saya page")
    public void user_click_tab_on_voucher_saya_page(String textTab) {
        voucherSaya.clickOnTabOnVoucher(textTab);
    }
    @Then("user see voucher list Terpakai label")
    public void user_see_voucher_list_terpakai_label() {
        Assert.assertTrue(voucherSaya.isVoucherListTerpakaiLabelVisible(), "voucher list Terpakai Label is not present");
    }
    @Then("user see voucher list disabled Kode Voucher label")
    public void user_see_voucher_list_disabled_kode_voucher_label() {
        Assert.assertTrue(voucherSaya.isVoucherListDisabledKodeVoucherLabelVisible(), "voucher list Disabled Kode Voucher Label is not present");

    }
    @Then("user see voucher list disabled Voucher code")
    public void user_see_voucher_list_disabled_voucher_code() {
        Assert.assertTrue(voucherSaya.isVoucherListDisabledVoucherCodeVisible(), "voucher list Disabled Voucher Code is not present");

    }
    @Then("user see voucher list Kedaluwarsa label")
    public void user_see_voucher_list_kedaluwarsa_label() {
        Assert.assertTrue(voucherSaya.isVoucherListKedaluwarsaLabelVisible(), "voucher list Kedaluwarsa Label is not present");
    }

    @When("user click Salin button from voucher list")
    public void user_click_salin_button_from_voucher_list() {
        voucherSaya.clickVoucherListSalinButton();
    }
    @Then("user see kode berhasil disalin toast in voucher list")
    public void user_see_kode_berhasil_disalin_toast_in_voucher_list() {
        Assert.assertTrue(voucherSaya.isVoucherListCopyToastVisible(), "voucher list Copy Toast is not present");
    }

    @When("user click Salin button from voucher detail")
    public void user_click_salin_button_from_voucher_detail() {
        voucherSaya.clickVoucherDetailSalinButton();
    }
    @Then("user see kode berhasil disalin toast in voucher detail")
    public void user_see_kode_berhasil_disalin_toast_in_voucher_detail() {
        Assert.assertTrue(voucherSaya.isVoucherListCopyToastVisible(), "voucher list List Copy Toast is not present");
    }
    @Then("user see voucher detail Image banner")
    public void user_see_voucher_detail_image_banner() {
        Assert.assertTrue(voucherSaya.isVoucherDetailImageBannerVisible(),"voucher detail image banner is not present");
    }
    @Then("user see voucher detail Campaign Title")
    public void user_see_voucher_detail_campaign_title() {
        Assert.assertTrue(voucherSaya.isVoucherDetailCampaignTitleVisible(),"voucher detail Campaign Title is not present");
    }
    @Then("user see voucher detail Expired Date")
    public void user_see_voucher_detail_expired_date() {
        Assert.assertTrue(voucherSaya.isVoucherDetailExpiredDateVisible(),"voucher detail Expired Date is not present");
    }
    @Then("user see voucher detail Syarat dan Ketentuan label")
    public void user_see_voucher_detail_syarat_dan_ketentuan_label() {
        Assert.assertTrue(voucherSaya.isVoucherDetailSyaratDanKetentuanLabelVisible(), "Syarat dan Ketentuan Label is not present");
    }
    @Then("user see voucher detail Syarat dan Ketentuan description")
    public void user_see_voucher_detail_syarat_dan_ketentuan_description() {
        Assert.assertTrue(voucherSaya.isVoucherDetailSyaratDanKetentuanDescriptionVisible(), "Syarat dan Ketentuan Description is not present");
    }
    @Then("user see voucher detail Kode Voucher label")
    public void user_see_voucher_detail_kode_voucher_label() {
        Assert.assertTrue(voucherSaya.isVoucherDetailKodeVoucherLabelVisible(), "Kode Voucher Label is not present");
    }
    @Then("user see voucher detail Voucher code")
    public void user_see_voucher_detail_voucher_code() {
        Assert.assertTrue(voucherSaya.isVoucherDetailVoucherCodeVisible(), "Kode Voucher Code is not present");
    }
    @Then("user see voucher detail Ticket icon")
    public void user_see_voucher_detail_ticket_icon() {
        Assert.assertTrue(voucherSaya.isVoucherDetailTicketIconVisible(), "Ticket Icon is not present");
    }

    @When("user see voucher detail Terpakai Label")
    public void user_see_voucher_detail_terpakai_label() {
        Assert.assertTrue(voucherSaya.isVoucherDetailTerpakaiLabelVisible(),"voucher detail terpakai label is not present");
    }

    @When("user see voucher detail disabled Kode Voucher label")
    public void user_see_voucher_detail_disabled_kode_voucher_label() {
        Assert.assertTrue(voucherSaya.isVoucherDetailDisabledKodeVoucherLabelVisible(),"voucher detail voucher kode label disable is not present");
    }
    @When("user see voucher detail disabled Voucher code")
    public void user_see_voucher_detail_disabled_voucher_code() {
        Assert.assertTrue(voucherSaya.isVoucherDetailDisabledVoucherCodeVisible(),"voucher detail voucher code disable is not present");
    }

    @When("user clicks Voucher Card in Kedaluwarsa tab")
    public void user_clicks_voucher_card_in_kedaluwarsa_tab() {
        voucherSaya.clickKedaluwarsaVoucherCard();
    }
    @When("user see voucher detail Kedaluwarsa Label")
    public void user_see_voucher_detail_kedaluwarsa_label() {
        Assert.assertTrue(voucherSaya.isVoucherDetailKedaluwarsaLabelVisible(),"voucher detail kadaluarsa label is not present");
    }

    @When("user click first voucher on list")
    public void userClickFirstVocuherOnList() {
        voucherSaya.clickVoucherOnList();
    }

    @And ("user clicks Voucher Card in Terpakai tab")
    public void user_clicks_voucher_card_in_terpakai_tab() {
        voucherSaya.clickTerpakaiVoucherCard();
    }

    @And("user see disabled Salin button in voucher detail")
    public void user_see_disabled_salin_button_in_voucher_detail() {
        voucherSaya.isVoucherDetailSalinButtonDisabledVisible();
    }

    @And("user see voucher list disabled Kode Voucher label on kadaluwarsa page")
    public void userSeeVoucherListDisabledKodeVoucherLabelOnKadaluwarsaPage() {
        Assert.assertTrue(voucherSaya.isVoucherListDisabledKodeVoucherKadaluwarsaLabelVisible(), "voucher list Disabled Kode Voucher Label is not present");
    }

    @And("user see voucher list disabled Voucher code on kadaluwarsa page")
    public void userSeeVoucherListDisabledVoucherCodeOnKadaluwarsaPage() {
        Assert.assertTrue(voucherSaya.isVoucherListDisabledVoucherCodeKadaluwarsaVisible(), "voucher list Disabled Voucher Code is not present");
    }

    @Then ("user see Tersedia Empty State Landing Page")
    public void user_see_tersedia_empty_state_landing_page(){
        Assert.assertTrue(voucherSaya.isTersediaEmptyStateVisible(), "voucher is present");
    }

    @Then ("user see Terpakai Empty State Landing Page")
    public void user_see_terpakai_empty_state_landing_page() {
        Assert.assertTrue(voucherSaya.isTerpakaiEmptyStateVisible(), "voucher is present");
    }

    @Then ("user see Kedaluwarsa Empty State Landing Page")
    public void
    user_see_kedaluwarsa_empty_state_landing_page() {
        Assert.assertTrue(voucherSaya.isKedaluwarsaEmptyStateVisible(), "voucher is present");
    }

}
