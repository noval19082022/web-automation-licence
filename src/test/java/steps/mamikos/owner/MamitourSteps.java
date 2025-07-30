package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.LoadingPO;
import pageobject.owner.MamitourPO;

public class MamitourSteps {
    Page page = ActiveContext.getActivePage();
    MamitourPO mamitour = new MamitourPO(page);
    LoadingPO loading = new LoadingPO(page);

    @And("user click on pesan sekarang button")
    public void user_click_on_pesan_sekarang_button() {
        mamitour.clickOnPesanSekarang();
    }

    @Then("user will see text title with {string} and subtitle with {string}")
    public void user_will_see_text_title_with_x_and_subtitle_with_x(String title, String subtitle) {
        Assert.assertEquals(mamitour.getTitleBelumAdaProperti(), title, "String doesn't match");
        Assert.assertEquals(mamitour.getSubtitleBelumAdaProperti(), subtitle, "String doesn't match");
    }

    @When("user click on pusat bantuan mamitour")
    public void user_click_on_pusat_bantuan_mamitour() {
        mamitour.clickOnPusatBantuan();
    }

    @And("user will see title {string} on landing page mamitour")
    public void user_will_see_title_x_on_landing_page_mamitour(String title) {
        mamitour.isContentOnMamitourVisible(title);
    }

    @Then("user will {string} Lihat Riwayat button")
    public void user_will_x_riwayat_button(String state) {
        if (state.equals("see")) {
            Assert.assertTrue(mamitour.isRiwayatButtonVisible(), "Riwayat button is not visible");
        } else {
            Assert.assertFalse(mamitour.isRiwayatButtonVisible(), "Riwayat button is visible");
        }
    }

    @And("user click on Lihat Riwayat Button")
    public void user_click_on_lihat_riwayat_button() {
        mamitour.clickOnRiwayatButton();
    }

    @And("user click on tab dalam proses")
    public void user_click_on_tab_dalam_proses() {
        mamitour.clickOnDalamProsesTab();
    }

    @And("user click on tab selesai")
    public void user_click_on_tab_selesai() {
        mamitour.clickOnSelesaiTab();
    }

    @Then("user will see empty state text {string} as title and {string} as subtitle")
    public void user_will_see_empty_state_text_x_as_title_and_x_as_subtitle(String title, String subtitle) {
        Assert.assertEquals(mamitour.getEmptyStateTitleText(), title, "Title text is not match");
        Assert.assertEquals(mamitour.getEmptyStateSubtitleText(), subtitle, "Subtitle text is not match");
    }

    @Then("user verify there is transaction")
    public void user_verify_there_is_transaction() {
        Assert.assertTrue(mamitour.isHistoryListVisible(), "List history is not visible");
    }

    @And("user choose {string} mamitour")
    public void user_choose_x_mamitour(String mamitourPackage) {
        mamitour.clickAndChooseMamitourPackage(mamitourPackage);
    }

    @And("user wants to buy mamitour {string}")
    public void user_wants_to_buy_mamitour_x(String mamitourPackage) {
        mamitour.clickOnPesanSekarang();
        mamitour.clickAndChooseMamitourPackage(mamitourPackage);
        mamitour.clickOnPesanSekarangDetail();
    }

    @And("user verify default state of detail pemesanan")
    public void user_verify_default_state_of_detail_pemesanan() {
        Assert.assertTrue(mamitour.isChooseMamitourPackageDropdownVisible(), "Choose mamitour package not visible");
        Assert.assertFalse(mamitour.isPesanSekarangDetailPemesananEnable(), "Pesan sekarang btn not disable");
        Assert.assertEquals(mamitour.getTotalPriceText(), "Rp0", "Total is not the same");
    }

    @And("user click on baca panduan button")
    public void user_click_on_baca_panduan_button() {
        mamitour.clickOnBacaPanduan();
    }

    @Then("user will see pesanan diterima popup")
    public void user_will_see_pesanan_diterima_popup() {
        Assert.assertTrue(mamitour.isTitleOrderAcceptedPopupVisible(), "Title pesanan diterima not visible");
        Assert.assertTrue(mamitour.isSubtitleOrderAcceptedPopupVisible(), "Subtitle pesanan diterima not visible");
    }

    @Then("user will see also close pesanan diterima popup")
    public void user_will_see_also_close_pesanan_diterima_popup() {
        user_will_see_pesanan_diterima_popup();
        mamitour.clickOnClosePopupOrderMamitour();
    }

    @And("user want to buy Paket 3 Bulan from mamitour landing page")
    public void user_want_to_buy_Paket_3_Bulan_from_mamitour_landing_page() {
        mamitour.clickOnPesanSekarangPaket3Bulan();
        mamitour.clickOnPesanSekarangDetail();
    }

    @Then("user will see also close panduan mamitour popup")
    public void user_will_see_also_closepanduan_mamitour_popup() {
        Assert.assertTrue(mamitour.isPopupPanduanVisible());
        mamitour.clickOnClosePanduanPopup();
        mamitour.clickOnClosePopupOrderMamitour();
    }

    @And("user click on add extra {int} lantai and {int} ruangan")
    public void user_click_on_add_extra_lantai_x_and_ruangan_x(int lantai, int ruangan) {
        mamitour.clickOnAddExtra(lantai, "Lantai");
        mamitour.clickOnAddExtra(ruangan, "Ruangan");
    }

    @And("user click on remove extra {int} lantai and {int} ruangan")
    public void user_click_on_remove_extra_lantai_x_and_ruangan_x(int lantai, int ruangan) {
        mamitour.clickOnRemoveExtra(lantai, "Lantai");
        mamitour.clickOnRemoveExtra(ruangan, "Ruangan");
    }

    @Then("user verify total price is {string}")
    public void user_verify_total_price_is_x(String total) {
        Assert.assertEquals(mamitour.getTotalPriceText(), total, "Total is not the same");
    }
}
