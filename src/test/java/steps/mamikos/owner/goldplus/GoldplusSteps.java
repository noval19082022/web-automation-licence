package steps.mamikos.owner.goldplus;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.HomePO;
import pageobject.common.LoadingPO;
import pageobject.owner.OwnerDashboardPO;
import pageobject.owner.PromoOwnerPO;
import pageobject.owner.chat.ChatOwnerPO;
import pageobject.owner.fiturpromosi.BroadcastChatPO;
import pageobject.owner.fiturpromosi.mamiads.MamiAdsPO;
import pageobject.owner.goldplus.GoldPlusSubmissionPO;
import pageobject.owner.goldplus.GoldplusPO;
import pageobject.owner.goldplus.PanduanGoldplusPO;
import steps.mamikos.common.NavigatesSteps;
import utilities.PlaywrightHelpers;

import java.util.List;
import java.util.Map;

public class GoldplusSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    NavigatesSteps navigate = new NavigatesSteps();
    GoldplusPO goldplus = new GoldplusPO(page);
    ChatOwnerPO chat = new ChatOwnerPO(page);
    OwnerDashboardPO owner = new OwnerDashboardPO(page);
    HomePO home = new HomePO(page);
    BroadcastChatPO broadcast = new BroadcastChatPO(page);
    PanduanGoldplusPO panduanGP = new PanduanGoldplusPO(page);
    MamiAdsPO mamiads = new MamiAdsPO(page);
    PromoOwnerPO promoOwner = new PromoOwnerPO(ActiveContext.getActivePage());
    GoldPlusSubmissionPO gpSubmission = new GoldPlusSubmissionPO(page);
    LoadingPO loading = new LoadingPO(page);

    @When("user wants to subscribe Goldplus {int}")
    public void user_wants_to_subscribe_goldplus(int paket) {
        loading.waitForLoadingIconDisappear();
        playwright.waitTillPageLoaded();
        if (home.getURL().equals(Mamikos.URL+"/goldplus/submission/packages")){
            goldplus.clickOnGPPackage(paket);
        } else{
            navigate.userNavigateTo("/goldplus/submission/periode/gp"+paket);
        }

        if (playwright.isTextDisplayed("1 Minggu")) {
            goldplus.clickOnPeriodeWeekly();
        }
        if (playwright.getPageUrl().contains("/goldplus/submission/periode/gp1") && !gpSubmission.isFavoritGpRadioSelected()) {
            playwright.reloadPage();
            gpSubmission.clickOnGpSatuFirstRadioButton();
        }
        gpSubmission.clicksOnPilihPaketButton();
        gpSubmission.clicksOnBayarSekarangButton();
    }

    @When("user choose Goldplus package {int}")
    public void user_choose_goldplus_package(int packages) {
        goldplus.clickOnGoldplusPackageButton(packages);
        playwright.clickOnTextButton("Pilih");
    }

    @When("user click checkbox Syarat dan Ketentuan Umum GoldPlus")
    public void user_click_checkbox_syarat_dan_ketentuan_umum_goldplus(){
        goldplus.clickOnCheckbox();
    }

    @When("user wants to reset Goldplus for owner with phone number {string}")
    public void user_wants_to_reset_Goldplus_for_owner_with_phone_number(String phoneNumber) {
        playwright.navigateTo(Mamikos.ADMINMAMIPAY+Mamikos.GOLDPLUS_TESTING_TOOLS);
        goldplus.inputGoldplusPhoneNumber(phoneNumber);
        playwright.clickOnTextButton("Reset");
        Assert.assertTrue(playwright.isTextDisplayed("Reset success!"));
    }

    //------ Recurring Mamipay ------//

    @When("user sets recurring {string} for number {string}")
    public void user_sets_recurring_for_number(String period, String phoneNumber) {
        playwright.navigateTo(Mamikos.ADMINMAMIPAY+Mamikos.GOLDPLUS_TESTING_TOOLS);
        goldplus.inputRecurringPhoneNumber(phoneNumber);
        goldplus.selectRecurringPeriod(period);
        playwright.clickOnTextButton("Create Recurring");
        Assert.assertTrue(playwright.isTextDisplayed("Recurring invoice created!"));
    }

    @Then("admin successfully sets favorite label to none")
    public void admin_successfully_sets_favorite_label_to_none() {
        goldplus.clickOnEditGP1Button();
        goldplus.clickNoRadioButton();
        playwright.clickOnText("Save");
    }

    @When("admin successfully sets favorite label to active")
    public void admin_successfully_sets_favorite_label_to_active() {
        goldplus.clickOnEditGP1Button();
        goldplus.clickYesRadioButton();
        playwright.clickOnText("Save");
        playwright.waitTillPageLoaded(10000.0);
    }

    @When("admin successfully adds additional favorite labels")
    public void admin_successfully_adds_additional_favorite_labels() {
        goldplus.clickOnEditGP2Button();
        goldplus.clickYesRadioButton();
        playwright.clickOnText("Save");
    }

    @When("admin successfully remove additional favorite labels 4 Month")
    public void admin_successfully_remove_additional_favorite_labels() {
        goldplus.clickOnEditGP1Button();
        goldplus.clickNoRadioButton();
        playwright.clickOnTextButton("Save");
    }

    @When("admin successfully remove additional favorite labels 3 Month")
    public void admin_successfully_remove_additional_favorite_labels_3_month() {
        goldplus.clickOnEditGP2Button();
        goldplus.clickNoRadioButton();
        playwright.clickOnTextButton("Save");
    }

    @And("user click info untuk anda {string}")
    public void userClickInfoUntukAnda(String infoUntukAnda) {
        goldplus.clickOnInfoUntukAnda(infoUntukAnda);
    }

    @Then("user verify Lihat Invoice visible")
    public void userVerifyLihatInvoiceVisible() {
        playwright.clickOnTextButton("Lihat Invoice");
        Assert.assertTrue(playwright.isTextDisplayed("Detail Tagihan", 3000));
    }

    @Then("user see Title on page {string} is {string} with message:")
    public void userSeeTitleOnPageIsWithMessage(String page, String title, String docString) {
        switch (page){
            case "cek properti sekitar":
                Assert.assertTrue(playwright.isTextDisplayed(title, 1000));
                Assert.assertEquals(goldplus.getMessage(),docString.replaceAll("\\s", ""));
        }
    }

    @Then("verify unpaid invoice is {int}")
    public void verifyUnpaidInvoiceIs(int unpaidInvoice) {
        Assert.assertTrue(unpaidInvoice == goldplus.getCountInvoiceUnpaid());
    }

    @When("owner wants to extends Goldplus from chatlist")
    public void owner_wants_to_extends_goldplus_from_chatlist() {
        chat.clickChatOwner();
        goldplus.clickOnPerpanjangBtn();
    }

    @When("owner wants to extends Goldplus from chatroom")
    public void owner_wants_to_extends_goldplus_from_chatroom() {
        loading.waitForLoadingIconDisappear();
        chat.clickChatOwner();
        chat.dismissFTUEMarsGPAndBroadCast();
        playwright.clickOnTextButton("Irvi Tenant Add Ons");
        goldplus.clickOnPerpanjangBtnOnChatRoom();
    }

    @When("owner wants to extends Goldplus from notif center")
    public void owner_wants_to_extends_goldplus_from_notif_center() {
        owner.clickNotificationButton();
        owner.clickFirstNotificationText();
    }

    @When("owner wants to access goldplus dashboard")
    public void owner_wants_to_access_goldplus_dashboard(){
        playwright.clickOnText("Perpanjang paket Goldplus yuk!");
    }

    @And("user click widget GP {string}")
    public void userClickWidgetGP(String statusGP) {
        goldplus.clickOnWidgetGP();
    }

    @And("user click {string} on pop up {string}")
    public void userClickOnPopUp(String action, String titlePopUp) {
        Assert.assertTrue(playwright.isTextDisplayed(titlePopUp, 1000));
        playwright.clickOnTextButton(action);
    }

    @When("user click Lihat Tagihan on riwayat")
    public void userClickLihatTagihanOnRiwayat() {
        playwright.hardWait(3000.0);
        playwright.clickOnText("Lihat Tagihan");
        playwright.clickOnText("Bayar Sekarang");
    }

    @Then("owner see jenis pembayaran {string}")
    public void ownerSeeJenisPembayaran(String jenisPembayaran) {
        Assert.assertEquals(goldplus.getJenisPembayaran(jenisPembayaran), jenisPembayaran, "Jenis Pembayaran doesnt match!");
    }

    @Then("verify button on broadcast page")
    public void verifyButtonOnBroadcastPage() {
        playwright.hardWait(5000);
        Assert.assertTrue(playwright.isButtonWithTextDisplayed("Lihat Detail Paket"));
        Assert.assertTrue(playwright.isButtonWithTextDisplayed("Beli Paket"));
    }

    @When("owner click {string} button on chatlist")
    public void ownerClickButtonOnChatlist(String buttonTxt) {
        loading.waitForLoadingIconDisappear();
        chat.clickChatOwner();
        chat.clickButtonOnChatRoomList(buttonTxt);
    }

    @When("owner click {string} button on chatrooms {string}")
    public void ownerClickButtonOnChatrooms(String buttonTxt, String tenantName) {
        chat.clickChatOwner();
        chat.dismissFTUEMars();
        chat.dismissFTUEMarsKuotaNol();
        broadcast.clickOnCloseTooltip();
        chat.searchChatTenant(tenantName);
        chat.dismissFTUETBC();
        chat.clickButtonOnChatRoomList(buttonTxt);
    }

    //------ GP Onboarding ------//
    @When("owner go to panduan gold plus page")
    public void ownerGoToPanduanGoldPlusPage() {
        loading.waitForLoadingIconDisappear();
        owner.clickOnGpWidgetButton();
        goldplus.clickOnPelajariCaranyaButton();
        panduanGP.clickOnNaikkanIklanAndaButton();
    }

    @When("owner click on next button to go to slide number {int} with total number slides are {int}")
    public void ownerClickOnNextButtonOnPanduanGoldPlusSwipperWithTotalNumberSlidesAre(Integer swiperNumber, Integer totalNumberSlide) {
        if (swiperNumber <= totalNumberSlide - 1) {
            panduanGP.clickOnNextButton();
        }
    }

    @Then("owner can see swiper number {int} is selected")
    public void ownerCanSeeSwiperNumberNumberIsSelected(int number) {
        Assert.assertFalse(panduanGP.getGPswipperAttribute(number -1 , "class").contains(".gp-swiper__step--dim"));
    }

    @Then("owner can see selected swiper with title {int}")
    public void ownerCanSeeSelectedSwiperWithTitleNumber(int number) {
        Assert.assertEquals(Integer.parseInt(panduanGP.getSelectedSwiperTitle()), number);
    }

    @Then("owner can see swiper text body is {string}")
    public void ownerCanSeeSwiperTextBodyIsTextBody(String textbody) {
        Assert.assertEquals(panduanGP.getSelectedSwiperBodyText(), textbody);
    }

    @Then("owner can see swiper right or next button is disabled")
    public void ownerCanSeeSwiperRightNextButtonIsDisabled() {
        Assert.assertTrue(panduanGP.isNextButtonDisabled());
    }

    @Then("owner can see swiper left or previous button is disabled")
    public void ownerCanSeeSwiperLeftOrPreviousButtonIsDisabled() {
        Assert.assertTrue(panduanGP.isPreviousButtonDisabled());
    }

    @When("owner click on previous button to go to slide number {int}")
    public void ownerClickOnPreviousButtonToGoToSlideNumberNumber(int number) {
        if (number >= 2) {
            panduanGP.clickOnPreviousButton();
        }
    }

    @When("owner clicks on coba sekarang button")
    public void ownerClickOnCobaSekarangButton() {
        panduanGP.clickCobaSekarangButton();
    }

    @Then("owner can see gp onboarding text title is {string}")
    public void ownerCanSeeGpOnboardingTextTitleIs(String textTitle) {
        Assert.assertEquals(panduanGP.getSelectedOnboardingTitle(), textTitle);
    }

    @Then("owner can see gp onboarding text body is {string}")
    public void ownerCanSeeGpOnboardingTextBodyIs(String textBody) {
        Assert.assertEquals(panduanGP.getSelectedOnboardingBodyText(), textBody);
    }

    @Then("owner can see gp onboarding number {int} is selected")
    public void ownerCanSeeGpOnboardingNumberNumberIsSelected(int number) {
        Assert.assertEquals(panduanGP.getSelectedOnboardingNumber(), number);
    }

    @Then("owner can see gp onboarding image alt text is {string}")
    public void ownerCanSeeGpOnboardingImageAltTextIs(String altText) {
        Assert.assertEquals(panduanGP.getSelectedOnboardingImageAltText(), altText);
    }
    //------ GP Onboarding ------//

    //------ GP Onboarding Pop-Up ------//
    @Then("owner can see gp onboarding swiper number {int} is selected")
    public void ownerCanSeeGpOnboardingSwiperNumberSwiperNumberIsSelected(int swiperNumber) {
        Assert.assertEquals(mamiads.getGpOnboardingpopUpActiveCounter(), swiperNumber);
    }

    @Then("owner can see gp onboarding pop-up text head {string} is selected")
    public void ownerCanSeeGpOnboardingPopUpTextHeadTextHeadIsSelected(String textHead) {
        Assert.assertEquals(mamiads.getGpOnboardingpopUpTextHead(), textHead);
    }

    @Then("owner can see gp onboarding pop-up text body {string} is selected")
    public void ownerCanSeeGpOnboardingPopUpTextBodyTextBodyIsSelected(String textBody) {
        Assert.assertEquals(mamiads.getGpOnboardingpopUpTextBody(), textBody);
    }

    @Then("owner can see gp onboarding pop-up image alt text {string} is visible")
    public void ownerCanSeeGpOnboardingPopUpImageAltTextImageAltTextIsVisible(String imageAltValue) {
        Assert.assertEquals(mamiads.getGpOnboardingpopUpImageAltAttributeValue(), imageAltValue);
    }

    @When("owner click on next button on gp onboarding pop-up to go to slide number {int}")
    public void ownerClickOnNextButtonOnGpOnboardingPopUpToGoToSlideNumberSwiperNumber(int swiperNumber) {
        if (swiperNumber <= 6) {
            mamiads.clickGpOnboardingpopUpNextButton();
        }
    }

    @Then("owner can see swiper left or previous button on gold plus onboarding pop-up is disabled")
    public void ownerCanSeeSwiperLeftOrPreviousButtonOnGoldPlusOnboardingPopUpIsDisabled() {
        Assert.assertTrue(mamiads.isGpOnboardingpopUpPreviousButtonDisabled());
    }

    @Then("owner can see swiper right or next button on gold plus onboarding pop-up is disabled")
    public void ownerCanSeeSwiperRightOrNextButtonOnGoldPlusOnboardingPopUpIsDisabled() {
        Assert.assertTrue(mamiads.isGpOnboardingpopUpNextButtonDisabled());
    }

    @When("onwer click on previous button on gp onboarding pop-up to go to slide number {int}")
    public void onwerClickOnPreviousButtonOnGpOnboardingPopUpToGoToSlideNumberSwiperNumber(int swiperNumber) {
        if (swiperNumber >= 2) {
            mamiads.clickGpOnboardingpopUpPreviousButton();
        }
    }

    @Then("user verify {string} is appear")
    public void userVerifyIsAppear(String textMessage) {
        switch(textMessage){
            case "list of Goldplus package":
                playwright.hardWait(3000);
                Assert.assertTrue(goldplus.isGpPackageTableDisplayed(), "GP package table doesn't displayed!");
                break;
            case "Daftar GoldPlus":
                chat.dismissFTUEMars();
                chat.dismissFTUEMarsKuotaNol();
                Assert.assertTrue(playwright.isTextDisplayed("Sisa kuota mingguan", 2000.0), "Daftar GoldPlus doesn't displayed!");
                Assert.assertTrue(playwright.isTextDisplayed("1 chat room", 3000.0), "Sisa kuota chat text doesn't displayed!");
                playwright.clickOnTextButton(textMessage);
                Assert.assertTrue(goldplus.isGpPackageTableDisplayed(), "GP package table doesn't displayed!");
                break;
            case "Pilih Periode Berlangganan":
                Assert.assertTrue(playwright.isTextDisplayed("Paket GoldPlus", 2000.0), "Text doesn't displayed!");
                Assert.assertTrue(playwright.isTextDisplayed("Pilih satu paket GoldPlus di bawah ini.", 2000.0), "Paket GP Anda is not GP2!");
        }
    }

    @When("owner click {string} on broadcast chat page")
    public void ownerClickOnBroadcastChatPage(String buttonText) {
        playwright.clickOnTextButton(buttonText);
        Assert.assertTrue(playwright.isTextDisplayed("Paket Anda: Goldplus 2", 2000.0), "Paket GP Anda is not GP2!");
        playwright.clickOnTextButton("Pilih");
        playwright.hardWait(3000);
        playwright.clickOnText("Bayar Sekarang");
    }


    //------ GP Onboarding Pop-Up ------//

    @And("owner go to panduan gold plus memantau performa kos page")
    public void ownerGoToPanduanGoldPlusMemantauPerformaKosPage() {
        owner.clickOnGpWidgetButton();
        goldplus.clickOnPelajariCaranyaButton();
        panduanGP.clickOnMemantauPerformaKosButton();
    }
    @When("owner close pop up detail manfaat")
    public void owner_close_pop_up_detail_manfaat() {
        playwright.hardWait(1000.0);
        goldplus.clickOnCLosePopUpManfaat();
    }

    //------ Dashboard GP ------//
    @When("owner wants to accses dashboard GP")
    public void owner_wants_to_accses_dashboard_gp() {
        owner.clickOnGpWidgetButton();
        loading.waitForLoadingIconDisappear();
    }

    @When("user see status goldplus is {string}")
    public void user_see_status_goldplus_is(String statusGP) {
        Assert.assertEquals(goldplus.getStatusPaketGoldPlus(), statusGP, "status paket goldplus is not match");
    }

    @When("owner click back to dashboard GP")
    public void owner_click_back_to_dashboard_gp() {
        goldplus.clickOnIconBackFilter();
    }

    @When("user scroll to section pembayaran tagihan goldplus")
    public void user_scroll_to_section_pembayaran_tagihan_goldplus() {
       goldplus.scrollToTagihanSection();
    }

    @Then("user see list detail tagihan goldplus")
    public void user_see_list_detail_tagihan_goldplus() {
        goldplus.isListDetailTagihanIsDisplayed();
    }

    @When("user click tab selesai")
    public void user_click_tab_selesai() {
        goldplus.clickTabSelesai();
    }

    @When("owner click lihat selengkapnya at section tagihan")
    public void owner_click_lihat_selengkapnya_at_section_tagihan() {
        goldplus.lihatSelngkapnyaSectionDetailTagihan();
    }

    @Then("owner will see card box contains {string}")
    public void owner_will_see_card_box_contains(String benefit) {
        Assert.assertTrue(chat.gpPacakgeText().contains(benefit),"GP Package not contain benefit "+benefit);
    }

    @And("owner will see chat list page empty state")
    public void owner_will_see_chat_list_page_empty_state(){
        Assert.assertTrue(chat.isChatListEmptyStatePresent(), "emphty state not preset");
        chat.dismissFTUEMarsKuotaNol();
    }

    @Then("user verify last ftue is {string}")
    public void user_verify_last_ftue_is(String kuota) {
        Assert.assertEquals(chat.lastFTUEnonGoldplusText(),kuota,"FTUE doesnt match");
    }

    @When("owner cek promo owner when not GP")
    public void owner_cek_promo_owner_when_not_gp() {
        promoOwner.clickOnPromoNonGP();
    }

    @Then("owner will see pop up reminder recurring is displayed")
    public void owner_will_see_pop_up_reminder_recurring_is_displayed(){
        playwright.waitTillPageLoaded(10000.0);
        Assert.assertTrue(goldplus.isButtonRecurringPopUpVisible(),"Button not visible");
        Assert.assertTrue(goldplus.isTitlePopUpRecurringVisible(),"title recurring is not visible");
        Assert.assertTrue(goldplus.isSubtitlePopUpRecurringVisible(),"subtitle recurring is not visible");
        Assert.assertTrue(goldplus.isImageRecurringPopupVisible(),"image is not visible");
    }

    @When("owner wants to proccess recurring GP")
    public void owner_wants_to_proccess_recurring_GP(){
        loading.waitForLoadingIconDisappear();
        goldplus.clickOnPerpanjangBtn();
    }

    @When("owner will be redirected to invoice recurring")
    public void owner_will_be_redirected_to_invoice_recurring(){
        loading.waitForLoadingIconDisappear();
        playwright.waitTillPageLoaded(10000.0);
        Assert.assertTrue(goldplus.gpPackageText());
    }
    @And("user view detail list saldo MamiAds")
    public void user_view_detail_list_saldo_mamiads( DataTable dataTable) {
        playwright.waitTillPageLoaded();
        playwright.hardWait(3000.0);
        List<Map<String, String>> table = dataTable.asMaps();
        int i = 0;
        int j = 0;
        for (Map<String, String> content : table) {
            Assert.assertEquals(goldplus.mamiadsSaldo("saldo", i), content.get("saldo"));
            Assert.assertEquals(goldplus.mamiadsSaldo("cashback", i), content.get("cashback"));
            Assert.assertEquals(goldplus.mamiadsSaldo("salePrice", i), content.get("salePrice"));
            Assert.assertEquals(goldplus.mamiadsSaldo("saving", i), content.get("saving"));
            try {
                if (!content.get("disc").isEmpty()) {
                    Assert.assertEquals(goldplus.mamiadsSaldo("disc", j), content.get("disc"));
                    Assert.assertEquals(goldplus.mamiadsSaldo("discPriceMamiAds", j), content.get("discPriceMamiAds"));
                    j++;
                }
            } catch (java.lang.NullPointerException ignored) {
            }
            i++;
        }
    }

    @And("user choose saldo {string} on GoldPlus section")
    public void user_choose_saldo_on_goldplus_section(String saldo) throws InterruptedException {
        goldplus.chooseSaldo(saldo);
    }

    @Then("user verify the {string} and the price is {string} already {string} on Rincian Pembayaran")
    public void user_verify_the_and_the_price_is_already_on_rincian_pembayaran(String saldo, String rincian, String validation) {
        switch (validation){
            case "choosen":
                Assert.assertEquals(goldplus.getTextSaldoMamiAds(), saldo, "saldo MamiAds  is not match");
                Assert.assertEquals(goldplus.getTextRinicianMamiAds(), rincian, "rincian MamiAds  is not match");
                break;
            case "removed":
                Assert.assertFalse(goldplus.isRincianNotVisible(), "rincian Mamiads doesn't removed");
                Assert.assertFalse(goldplus.isSaldoNotVisible(), "saldo MamiAds doesn't removed");
                break;
        }
        goldplus.scrollToUbahPackage();
    }

    @And("user click on ubah package gold plus button")
    public void user_click_on_ubah_package_gold_plus_button() throws InterruptedException {
        goldplus.clickOnUbahGoldPlus();
    }

    @Then("user unchoose saldo on GoldPlus section")
    public void user_unchoose_saldo_on_gold_plus_section() throws InterruptedException {
        goldplus.unCheckedSaldo();
    }

    @Then("owner click bayar sekarang on detail tagihan page goldplus")
    public void owner_wants_to_process_goldplus() {
        gpSubmission.clicksOnBayarSekarangButton();
    }

    @Then("owner validate payment for {string} have {string} and have {string} before choose payment method")
    public void owner_validate_payment_for_have_and_have_before_choose_payment_method(String product, String mamiads, String fee) throws InterruptedException {
        goldplus.setTotalPembayaran(goldplus.getPembayaranText("Total Pembayaran"));
        Assert.assertTrue(goldplus.getPembayaranText("No. Invoice").contains("GP"));
        Assert.assertEquals(goldplus.getPembayaranText("Jenis Pembayaran"),product);
        Assert.assertEquals(goldplus.getPembayaranText("Metode Pembayaran"),"Belum dipilih");
        Assert.assertEquals(goldplus.getRincianGP(), product, "GoldPlus  is not match");
        Assert.assertEquals(goldplus.getRincianMA(), mamiads, "MamiAds  is not match");
        Assert.assertEquals(goldplus.getRincianFee(), fee, "MDR Fee  is not match");
    }

    @Then("owner wants to paid GP crosseling by click {string} on pop up {string}")
    public void owner_wants_to_paid_gp_crosseling_by_click_on_pop_up(String action, String titlePopUp) {
        goldplus.clickOnWidgetGP();
        Assert.assertTrue(playwright.isTextDisplayed(titlePopUp, 1000));
        playwright.clickOnTextButton(action);

    }

    @When("owner wants to see Lihat Detail Manfaat Goldplus Satu")
    public void owner_wants_to_see_lihat_detail_manfaat_goldplus_satu() {
       goldplus.clickOnDetailManfaatGP1();
    }

    @When("owner wants to see Lihat Detail Manfaat Goldplus Dua")
    public void owner_wants_to_see_lihat_detail_manfaat_goldplus_dua() {
        goldplus.clickOnDetailManfaatGP2();
    }

    @Then("owner see benefit {string} is displayed")
    public void owner_see_benefit_is_displayed(String benefit) {
        Assert.assertEquals(goldplus.getTextManfaatGP(benefit),benefit,"not match benefit");
    }

    @Then("owner see benefit in {string} is {string} is displayed")
    public void owner_see_benefit_in_is_is_displayed(String packageGP, String benefitGP) {
        switch (packageGP){
            case "golplus 2":
                Assert.assertEquals(goldplus.getTextManfaatGP2(benefitGP),benefitGP,"benefit doesnt match");
                break;
            case "golplus 1":
                Assert.assertEquals(goldplus.getTextManfaatGP1(benefitGP),benefitGP,"benefit doesnt match");
                break;
        }
    }

    //------ Terminated Contract GP ------//
    @When("user wants to terminate Goldplus for owner with phone number {string}")
    public void user_wants_to_terminate_goldplus_for_owner_with_phone_number(String phoneNumber) {
        playwright.navigateTo(Mamikos.ADMINMAMIPAY+Mamikos.GOLDPLUS_CONTRACT);
        goldplus.searchPhoneNumberGP(phoneNumber);
        playwright.clickOnTextButton("Terminate");
        playwright.clickOnTextButton("Yes, terminate it!");
        Assert.assertTrue(playwright.isTextDisplayed("Contract successfully terminated."));
    }

    @When("owner navigate to list package goldplus 2")
    public void owner_navigate_to_list_package_goldplus_2(){
        playwright.waitTillPageLoaded(10000.0);
        playwright.navigateTo(Mamikos.OWNER_URL + Mamikos.GOLDPLUS_SUBMISSION_2, 30000.0, LoadState.LOAD);
    }

    @When("owner navigate to list package goldplus 1")
    public void owner_navigate_to_list_package_goldplus_1(){
        playwright.navigateTo(Mamikos.OWNER_URL + Mamikos.GOLDPLUS_SUBMISSION_1, 30000.0, LoadState.LOAD);
        loading.waitForLoadingIconDisappear();
    }

    @When("owner click nanti saja for recurring GoldPlus")
    public void owner_click_nanti_saja_for_recurring_goldplus(){
        playwright.clickOnTextButton("Nanti Saja");
    }
    @And("owner click filter {string} in Pembayaran Tagihan Goldplus page")
    public void ownerClickFilterInPembayaranTagihanGoldplusPage(String filter) {
        goldplus.clickFilterInPaymentBillingGp(filter);
    }

    @When("user choose filter {string} on paket goldplus anda page")
    public void userChooseFilterOnPaketGoldplusAndaPage(String filter) {
        goldplus.clickFilterPaketGoldplusAnda(filter);
    }
}
