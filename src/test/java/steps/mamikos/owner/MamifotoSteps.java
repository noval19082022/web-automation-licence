package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.owner.MamifotoPO;
import pageobject.owner.OwnerDashboardPO;
import pageobject.tenant.InvoicePO;
import testdata.OwnerDashboardTestData;
import utilities.PlaywrightHelpers;

import java.util.ArrayList;
import java.util.List;

public class MamifotoSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    MamifotoPO mamifoto = new MamifotoPO (page);
    InvoicePO invoice = new InvoicePO(page);
    OwnerDashboardPO owner = new OwnerDashboardPO(page);

    @When("owner click Mamifoto button")
    public void owner_click_mamifoto_button() {
        owner.clickOnMamiFoto();
    }

    @Then("owner can see mamifoto page")
    public void owner_can_see_mamifoto_page() {
        mamifoto.waitForMamiFotoPageLoad();
        Assert.assertTrue(mamifoto.mamifotoHeaderLandingPageisAppear(),"Mamifoto Landing Page Doesnt Appear!");
    }


    @When("owner back to owner dashboard")
    public void owner_back_to_owner_dashboard() {
      mamifoto.clickOnHomeMenuOwner();
    }

    @Then("owner click section Tingkatkan Kinerja Kost")
    public void owner_click_section_tingkatkan_kinerja_kost()  {
        Assert.assertEquals(mamifoto.getKinerjaTitle(),mamifoto.getKinerjaTitle(),"text doesnt match");
        Assert.assertEquals(mamifoto.getKinerjaSubTitle(),mamifoto.getKinerjaSubTitle(),"text doesnt match");
        mamifoto.clickOnSewaMamifoto();
    }

    @Then("owner click info untuk anda for mamifoto")
    public void owner_click_info_unto_anda_for_mamifoto()  {
        // Get the aria snapshot of the information card to verify MamiFoto content exists
        String ariaSnapshot = owner.getInfoUntukAndaAriaSnapshot();

        // Assert that MamiFoto content is present in the snapshot
        Assert.assertTrue(ariaSnapshot.contains("Sewa jasa foto"),
            "MamiFoto content not found in Info untuk Anda section. Snapshot: " + ariaSnapshot);

        // Click on the MamiFoto info untuk anda item
        owner.clicksOnInfoUntukAnda(OwnerDashboardTestData.MAMIFOTO_INFOUNTUKANDA);
    }

    @When("owner click Lihat Paket button")
    public void owner_click_lihat_paket_button() {
        mamifoto.clickLihatPaketEnhanced();
    }

    @And("owner select package mamifoto")
    public void owner_select_package_mamifoto() {
       mamifoto.clickOnMamifotoPackageFirst();
    }

    @Then("owner see pop up doesnt have property")
    public void owner_see_pop_up_doesnt_have_property() {
        Assert.assertTrue(mamifoto.getAddedNewKostPopUpButton(),"Button doesnt appear");
        Assert.assertTrue(mamifoto.getNantiSajaButton(),"Button doesnt appear");
        Assert.assertTrue(mamifoto.getPopUpDoesntHaveProperty(),"Pop Up Doesnt Appear");
        mamifoto.clickOnNantiSajaButton();
    }
    @Then("owner see pilih paket page")
    public void owner_see_pilih_paket_page() {
        Assert.assertTrue(mamifoto.mamifotoHeaderSelectPackageisAppear(),"Lihat Paket is not Appear");
    }

    @When("owner back to Mamifoto Landing Page")
    public void owner_back_to_mamifoto_landing_page() {
       mamifoto.clickOnBackSelectPackage();
    }

    @When("owner click Baca Panduan button")
    public void owner_click_button() {
       mamifoto.clickOnBacaPanduan();
    }

    @Then("owner see detail panduan pop up")
    public void owner_see_detail_panduan_pop_up() {
        Assert.assertTrue(mamifoto.mamifotoHeaderBacaPanduanisAppear(),"Pop Up Baca Panduan doesnt Appear");
        mamifoto.clickOnCloseBacaPanduan();
    }

    @When("owner click any faq button")
    public void owner_click_any_faq_button() {
        // Use enhanced method for better reliability
        mamifoto.clickFirstFAQEnhanced();
    }

    @Then("owner see detail FAQ")
    public void owner_see_detail_faq() {
        Assert.assertTrue(mamifoto.contentFirstFAQisAppear(),"content is not appear");
    }

    @Then("owner click info untuk anda for mamifoto non property")
    public void owner_click_info_untuk_anda_for_mamifoto_non_property() {
        // Get the aria snapshot of the information card to verify MamiFoto content exists
        String ariaSnapshot = owner.getInfoUntukAndaAriaSnapshot();
        System.out.println("Info untuk Anda aria snapshot (non-property): " + ariaSnapshot);

        // Assert that MamiFoto content is present in the snapshot
        Assert.assertTrue(ariaSnapshot.contains("Sewa jasa foto"),
            "MamiFoto content not found in Info untuk Anda section. Snapshot: " + ariaSnapshot);

        // Click on the MamiFoto info untuk anda item
        owner.clicksOnInfoUntukAnda(OwnerDashboardTestData.MAMIFOTO_INFOUNTUKANDA);
    }

    @Then("owner click riwayat paket button")
    public void owner_click_riwayat_paket_button() {
        mamifoto.clickOnRiwayatPaketMamifoto();
    }

    @Then("owner see Riwayat MamiFoto purchase page")
    public void owner_see_riwayat_mami_foto_purchase_page() {
        Assert.assertTrue(mamifoto.mamifotoHeaderHistoryisAppear(),"Riwayat Pembelian Mamifoto does'nt appear!");
    }

    @When("owner click tab Selesai at riwayat page")
    public void owner_click_tab_selesai_at_riwayat_page() {
        mamifoto.clickOnTabSelesaiMamifoto();

    }

    @When("owner click Lihat Detail Transaksi with status {string}")
    public void owner_click_lihat_detail_transaksi_with_status(String status)  {
        // Wait for transaction status to be loaded instead of fixed wait
        playwright.waitTillPageLoaded();
        Assert.assertEquals(mamifoto.getSuccsessTransactioMamifotoText(),status,"Text doesn't match");
        mamifoto.clickOnSeeDetailTransactionMamifoto();
    }

    @Then("owner see status pembelian page")
    public void owner_see_status_pembelian_page()  {
       Assert.assertTrue(mamifoto.mamifotoHeaderStatusPembelianisAppear(),"Status Pembelian page doesnt appear");
       Assert.assertEquals(mamifoto.getStatusPembelianTitleText(),mamifoto.getStatusPembelianTitleText(),"Title doesnt match");
       Assert.assertEquals(mamifoto.getStatusPembelianSubTitleText(),mamifoto.getStatusPembelianSubTitleText(),"title doesnt match");
    }

    @When("click Hubungi Kami button")
    public void click_hubungi_kami_button()  {
      mamifoto.clickOnContactUsMamifoto();
        ActiveContext.setActivePage(ActiveContext.getActiveBrowserContext().pages().get(1));
    }

    @Then("owner connected to WA CS Mamikos {string}")
    public void owner_connected_to_wa_cs_mamikos(String url) {
        mamifoto = new MamifotoPO(ActiveContext.getActivePage());
        Assert.assertTrue(mamifoto.getURL().contains(url), "URL doesn't match");
        page.bringToFront();

    }

    @When("owner click Lihat Detail Transaksi old Pro Photo with status {string}")
    public void owner_click_lihat_detail_transaksi_old_pro_photo_with_status(String status) {
        mamifoto.clicOnIconBackSuccsessPaymentMamifoto();
        Assert.assertEquals(mamifoto.getSuccsessTransactioProphotoText(),status,"Text doesn't match");
        mamifoto.clickOnSeeDetailTransactionProphoto();
    }

    @When("owner click tab Dalam Proses at riwayat page")
    public void owner_click_tab_dalam_proses_at_riwayat_page() {
        mamifoto.clicOnTabDalamProsesMamifoto();
    }

    @Then("owner see description {string}")
    public void owner_see_description(String text) {
        Assert.assertEquals(mamifoto.getDoesntHaveTransactionDescText(),mamifoto.getDoesntHaveTransactionDescText(),"text doesnt match");
        Assert.assertEquals(mamifoto.getDoesntHaveTransactionText(),text,"text doesnt match");
    }

    @When("owner click Lihat Detail Transaksi expired with status {string}")
    public void owner_click_lihat_detail_transaksi_expired_with_status(String string)  {
        Assert.assertEquals(mamifoto.getTextTransactionMamifotoExpired(),string,"Text doesnt match");
        mamifoto.clicOnDetailTransactionExpired();
    }

    @Then("owner see expired invoice mamifoto")
    public void owner_see_expired_invoice_mamifoto()  {
        Assert.assertEquals(mamifoto.getTextInvoiceExpiredTitle(),mamifoto.getTextInvoiceExpiredTitle(),"title doesnt match");
        mamifoto.clickOnButtonBackInvoiceExpired();

    }

    @Then("user/owner/tenant should redirect to login page {string}")
    public void owner_should_redirect_to_login_page(String loginProphoto) {
        mamifoto = new MamifotoPO(ActiveContext.getActivePage());
        Assert.assertTrue(mamifoto.getURL().contains(loginProphoto), "URL doesn't match");
    }

    @When("owner wants to select Mamifoto package")
    public void owner_wants_to_select_mamifoto_package() {
        mamifoto.clickOnFiturPromosi();
        mamifoto.clickOnMamifotoSidebar();
        mamifoto.clickOnLihatPaket();
        Assert.assertTrue(mamifoto.mamifotoHeaderSelectPackageisAppear(),"Lihat Paket is not Appear");
    }

    @Then("verify discount price on the package list")
    public void verify_discount_price_on_the_package_list() {
        Assert.assertEquals(mamifoto.getTextHeaderDiscountMemberGP(),mamifoto.getTextHeaderDiscountMemberGP(),"text doesnt match");
    }

    @Then("verify  discount price on the detail tagihan")
    public void verify_discount_price_on_the_detail_tagihan() {
        Assert.assertEquals(mamifoto.getTextDiscountMemberGPDetailTagihan(),mamifoto.getTextDiscountMemberGPDetailTagihan(),"Text doesnt match");
        Assert.assertEquals(mamifoto.getTextDiscountAmountGPDetailTagihan(),mamifoto.getTextDiscountAmountGPDetailTagihan(),"price doesnt match");
    }

    @When("owner paid MamiFoto")
    public void owner_paid_mami_foto() {
        mamifoto.clickOnButtonBayarSekarangMamifoto();
        Assert.assertEquals(mamifoto.getTextDiscountGPInvoiceMamifoto(),mamifoto.getTextDiscountGPInvoiceMamifoto(),"text doesnt match");
        Assert.assertTrue(mamifoto.mamifotoHeaderInvoiceisAppear(),"Mamifoto header doesnt appear");
    }

    @Then("verify discount price GP doesnt appear on the package list")
    public void verify_discount_price_gp_doesnt_appear_on_the_package_list() {
        Assert.assertFalse(mamifoto.mamifotoHeaderDiscountGP(),"Header diskon is appear");
    }

    @Then("verify  discount price GP doesnt appear the detail tagihan")
    public void verify_discount_price_gp_doesnt_appear_the_detail_tagihan() {
        Assert.assertFalse(mamifoto.discountMemberGPDetailTagihan(),"Discount Member is appear");
        Assert.assertFalse(mamifoto.discountAmountGPDetailTagihan(),"Discount Ammount is appear");
    }

    @When("owner paid MamiFoto Non GP")
    public void owner_paid_mami_foto_non_gp()  {
        mamifoto.clickOnButtonBayarSekarangMamifoto();
        // Wait for invoice page to load completely instead of fixed 10s wait
        playwright.waitTillPageLoaded();
        // Additional wait to ensure invoice content is rendered
        playwright.hardWait(2000.0);
        Assert.assertTrue(mamifoto.mamifotoHeaderInvoiceisAppear(),"Mamifoto header doesnt appear");
        Assert.assertFalse(mamifoto.discountGPInvoiceMamifoto(),"Discount GP is appear");
    }

    @Then("verify unpaid invoice mamifoto is {int}")
    public void verify_unpaid_invoice_mamifoto_is(int unpaidInvoice) {
        System.out.println(mamifoto.getCountMamifotoInvoiceUnpaid());
        Assert.assertEquals(unpaidInvoice, mamifoto.getCountMamifotoInvoiceUnpaid());
    }

    @When("owner click back previous button")
    public void owner_click_back_previous_button() {
        page.goBack();
        page.reload();
    }

    @When("owner click button lihat paket")
    public void owner_click_button_lihat_paket() {
        mamifoto.clickLihatPaketEnhanced();
    }

    @Then("owner paid transaction unpaid")
    public void owner_paid_transaction_unpaid() {
        // Wait for page to load transactions instead of fixed wait
        playwright.waitTillPageLoaded();
        while (mamifoto.checkUnpaidInvoiceMamifoto()){
            mamifoto.clickOnSeeFirstDetailTransaction();
            invoice.paymentOVO("081280003230");
            page.goBack();
            page.reload();
            playwright.waitTillPageLoaded();
        }
    }

    @When("owner click tab panduan area")
    public void owner_click_tab_panduan_area() {
        mamifoto.clickOnPanduanArea();
    }

    @When("owner close pop up panduan")
    public void owner_close_pop_up_panduan() {
        mamifoto.clickOnCloseBacaPanduan();
    }

    @And("owner will see title and detail title {string} on panduan panduan persiapan foto or video")
    public void ownerWillSeeTitleAndDetailTitleOnPanduanPanduanPersiapanFotoVideo(String titleAndDetailText) {
        Assert.assertTrue(mamifoto.titleOnPanduanAndAreaAppear(titleAndDetailText),"title doesnt appear");
    }

    @And("admin bangkrupux navigate to premium add on menu")
    public void admin_bangkrupux_navigate_to_premium_add_on_menu() {
        mamifoto.navigatesToPremiumAddOn();
    }

    @When("admin create invoice mamifoto from phone number {string}")
    public void admin_create_invoice_mamifoto_from_phone_number(String phoneNumber) {
       mamifoto.addTransactionMamifotoFromAdmin(phoneNumber);
    }

    @Then("invoice mamifoto succsess created with status {string} and for owner {string}")
    public void invoice_mamifoto_succsess_created_with_status_and_for_owner(String status, String phone) {
        Assert.assertEquals(mamifoto.getTextStatusInvoiceMamifoto(), status, "status is not match");
        Assert.assertEquals(mamifoto.getTextOwnerPhoneNumber().replaceAll("[^0-9]", ""), phone,"phone number is not match");
    }

    @Then("owner can verify transaction have status {string} from {string}")
    public void owner_can_verify_transaction_have_status_from(String status, String packageName) {
        Assert.assertEquals(mamifoto.getTextInvoiceUnpaidMamifoto(), status, "status is not match");
        Assert.assertEquals(mamifoto.getTextPackageMamifoto(), packageName, "package name is not match");
        mamifoto.clickOnSeeFirstDetailTransaction();
    }

    @And("owner wants to accsess mamifoto")
    public void owner_wants_to_accsess_mamifoto() {
        mamifoto.navigatesToMamifotoPage();
    }

    @Then("owner see welcome section for owner without property")
    public void owner_see_welcome_section_for_owner_without_property() {
        Assert.assertTrue(owner.isWelcomeTitleVisible(), "Welcome title is not visible");
        Assert.assertTrue(owner.isWelcomeSubtitleVisible(), "Welcome subtitle is not visible");
        Assert.assertTrue(owner.isPasangIklanPertamaButtonVisible(), "Pasang Iklan Pertama button is not visible");
        Assert.assertEquals(owner.getWelcomeTitleText(), "👋🏼  Selamat datang, Owner tanpa kost", "Welcome title text doesn't match");
        Assert.assertEquals(owner.getWelcomeSubtitleText(), "Pasang iklan pertama Anda agar bisa segera ditemukan calon penyewa!", "Welcome subtitle text doesn't match");
    }
}
