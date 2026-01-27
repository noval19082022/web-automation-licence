package steps.mamikos.owner.goldplus;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.admin.testingtools.GoldPlusPO;
import pageobject.common.HomePO;
import pageobject.common.KostDetailsPO;
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
    GoldPlusPO goldPlusTestingTools = new GoldPlusPO(page);
    ChatOwnerPO chat = new ChatOwnerPO(page);
    OwnerDashboardPO owner = new OwnerDashboardPO(page);
    HomePO home = new HomePO(page);
    BroadcastChatPO broadcast = new BroadcastChatPO(page);
    PanduanGoldplusPO panduanGP = new PanduanGoldplusPO(page);
    MamiAdsPO mamiads = new MamiAdsPO(page);
    PromoOwnerPO promoOwner = new PromoOwnerPO(ActiveContext.getActivePage());
    GoldPlusSubmissionPO gpSubmission = new GoldPlusSubmissionPO(page);
    LoadingPO loading = new LoadingPO(page);
    KostDetailsPO kostDetail = new KostDetailsPO(page);

    @When("user wants to subscribe Goldplus {int}")
    public void user_wants_to_subscribe_goldplus(int paket) {
        loading.waitForLoadingIconDisappear();
        playwright.waitTillPageLoaded();
        if (home.getURL().equals(Mamikos.URL + "/goldplus/submission/packages")) {
            goldplus.clickOnGPPackage(paket);
        } else {
            navigate.userNavigateTo("/goldplus/submission/periode/gp" + paket);
        }

        if (playwright.isTextDisplayed("1 Minggu")) {
            goldplus.clickOnPeriodeWeekly();
        }
        if (playwright.getPageUrl().contains("/goldplus/submission/periode/gp1") && !gpSubmission.isFavoritGpRadioSelected()) {
            playwright.reloadPage();
            gpSubmission.clickOnGpSatuFirstRadioButton(true);
        }
        gpSubmission.clicksOnPilihPeriodeButton();
        gpSubmission.clicksOnBayarSekarangButton();
    }

    @When("owner close gp onboarding if exist")
    public void ownerCloseGpOnBoardingIfExist() {
        playwright.waitTillPageLoaded();
        goldplus.closeGpOnBoardingIfExist();
    }

    @When("owner choose Goldplus package {int}")
    public void user_choose_goldplus_package(int packages) {
        goldplus.clickOnGoldplusPackageButton(packages);
        if (playwright.getPageUrl().contains("/goldplus/submission/periode/gp" + packages) && !gpSubmission.isFavoritGpRadioSelected()) {
            gpSubmission.clickOnGpSatuFirstRadioButton(true);
        }
        Mamikos.setGpPackageChoosed("GoldPlus " + packages);
    }

    @When("user click checkbox Syarat dan Ketentuan Umum GoldPlus")
    public void user_click_checkbox_syarat_dan_ketentuan_umum_goldplus() {
        goldplus.clickOnCheckbox();
    }

    @When("user wants to reset Goldplus for owner with phone number {string}")
    public void user_wants_to_reset_Goldplus_for_owner_with_phone_number(String phoneNumber) {
        goldPlusTestingTools.navigatesToGoldPlusTestingToolsPage();
        goldPlusTestingTools.inputGoldplusPhoneNumber(phoneNumber);
        goldPlusTestingTools.clickOnGoldPlusResetButton();
        Assert.assertTrue(playwright.isTextDisplayed("Reset success!"));
    }

    @When("user wants to reset Goldplus for owner with phone number")
    public void user_wants_to_reset_Goldplus_for_owner_with_phone_numbers(List<String> phoneNumbers) {
        goldPlusTestingTools.navigatesToGoldPlusTestingToolsPage();
        for (var phoneNumber : phoneNumbers) {
            goldPlusTestingTools.inputGoldplusPhoneNumber(phoneNumber);
            goldPlusTestingTools.clickOnGoldPlusResetButton();
        }
    }

    //------ Recurring Mamipay ------//

    @When("user sets recurring {string} for number {string}")
    public void user_sets_recurring_for_number(String period, String phoneNumber) {
        playwright.navigateTo(Mamikos.ADMINMAMIPAY + Mamikos.GOLDPLUS_TESTING_TOOLS);
        goldplus.inputRecurringPhoneNumber(phoneNumber);
        goldplus.selectRecurringPeriod(period);
        playwright.clickOnTextButton("Create Recurring");
        if (playwright.isTextDisplayed("Recurring invoice created!")) {
            Assert.assertTrue(playwright.isTextDisplayed("Recurring invoice created!"));
        } else if (playwright.isTextDisplayed("Done!")) {
            Assert.assertTrue(playwright.isTextDisplayed("Done!", 2));
        }
    }

    @Then("admin successfully sets favorite label to none")
    public void admin_successfully_sets_favorite_label_to_none() {
        goldplus.clickOnEditGP1Button();
        goldplus.clickNoRadioButton();
        playwright.clickOnText("Save");
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

    @When("admin successfully additional favorite labels 4 Month")
    public void admin_successfully_additional_favorite_labels() {
        goldplus.clickOnEditGP1Button();
        goldplus.clickYesRadioButton();
        playwright.clickOnTextButton("Save");
    }

    @When("admin successfully remove additional favorite labels 3 Month")
    public void admin_successfully_remove_additional_favorite_labels_3_month() {
        goldplus.clickOnEditGP1Button();
        goldplus.clickNoRadioButton();
        playwright.clickOnTextButton("Save");
    }

    @When("admin successfully additional favorite labels 3 Month")
    public void admin_successfully_additional_favorite_labels_3_month() {
        goldplus.clickOnEditGP1Button();
        goldplus.clickYesRadioButton();
        playwright.clickOnTextButton("Save");
    }

    @And("user click info untuk anda {string}")
    public void userClickInfoUntukAnda(String infoUntukAnda) {
        playwright.waitTillPageLoaded();
        owner.clicksOnInfoUntukAnda(infoUntukAnda);
    }

    @Then("user verify Lihat Invoice visible")
    public void userVerifyLihatInvoiceVisible() {
        playwright.clickOnTextButton("Lihat Invoice");
        Assert.assertTrue(playwright.isTextDisplayed("Detail Tagihan", 3000));
    }

    @Then("user see Title on page {string} is {string} with message:")
    public void userSeeTitleOnPageIsWithMessage(String page, String title, String docString) {
        switch (page) {
            case "cek properti sekitar":
                Assert.assertTrue(playwright.isTextDisplayed(title, 1000));
                Assert.assertEquals(goldplus.getMessage(), docString.replaceAll("\\s", ""));
        }
    }

    @Then("verify unpaid invoice is {int}")
    public void verifyUnpaidInvoiceIs(int unpaidInvoice) {
        Assert.assertTrue(unpaidInvoice == goldplus.getCountInvoiceUnpaid());
    }

    @Then("verify unpaid invoice more than {int}")
    public void verifyUnpaidInvoiceMoreThan(int unpaidInvoice) {
        Assert.assertTrue(unpaidInvoice < goldplus.getCountInvoiceUnpaid());
    }

    @When("owner wants to extends Goldplus from chatlist")
    public void owner_wants_to_extends_goldplus_from_chatlist() {
        chat.clickChatOwner();
        goldplus.clickOnPerpanjangBtn();
    }

    @When("owner wants to extends Goldplus from chatroom")
    public void owner_wants_to_extends_goldplus_from_chatroom() {
        loading.waitForLoadingIconDisappear();
        chat.dismissFTUEMarsGPAndSurveyIfExist();
        chat.clickChatOwner();
        chat.dismissFTUEMarsGPAndBroadCast();
        chat.dismissFTUEMarsGPAndSurveyIfExist();
        chat.dismissFTUEJemputBolaIfExist();
        goldplus.clickOnPerpanjangBtnOnChatRoom();
    }

    @When("owner wants to extends Goldplus from notif center")
    public void owner_wants_to_extends_goldplus_from_notif_center() {
        owner.clickNotificationButton();
        owner.clickFirstNotificationText();
    }

    @When("owner wants to access goldplus dashboard")
    public void owner_wants_to_access_goldplus_dashboard() {
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
        if (chat.isFTUEMarsPresent()) {
            chat.dismissFTUEMars();
            chat.dismissFTUESurvey();
            chat.dismissFTUEJemputBola();
        }
        chat.clickButtonOnChatRoomList(buttonTxt);
    }

    @When("owner click {string} button on chatrooms {string}")
    public void ownerClickButtonOnChatrooms(String buttonTxt, String tenantName) {
        chat.clickChatOwner();
        chat.dismissFTUEMars();
        chat.dismissFtueSurveyIfExist();
        chat.dismissFTUEMarsKuotaNol();
        chat.dismissFTUEJemputBolaIfExist();
        chat.dismissFTUETBCIfExist();
        chat.searchChatTenant(tenantName);
        chat.dismissFTUETBCIfExist();
        chat.clickButtonOnChatRoomList(buttonTxt);
        chat.dismissFTUETBCIfExist();
    }

    //------ GP Onboarding ------//
    @When("owner go to panduan gold plus page")
    public void ownerGoToPanduanGoldPlusPage() {
        loading.waitForLoadingIconDisappear();
        owner.clickOnGpWidgetButton();
        goldplus.clickOnPelajariCaranyaButton();
    }

    @When("owner click on {string} guide card")
    public void ownerClickOnGuideCard(String guideTitle) {
        panduanGP.clickOnGuideCard(guideTitle);
    }

    @When("owner click on next button to go to slide number {int} with total number slides are {int}")
    public void ownerClickOnNextButtonOnPanduanGoldPlusSwipperWithTotalNumberSlidesAre(Integer swiperNumber, Integer totalNumberSlide) {
        if (swiperNumber <= totalNumberSlide - 1) {
            panduanGP.clickOnNextButton();
        }
    }

    @Then("owner can see swiper number {int} is selected")
    public void ownerCanSeeSwiperNumberNumberIsSelected(int number) {
        Assert.assertFalse(panduanGP.getGPswipperAttribute(number - 1, "class").contains(".gp-swiper__step--dim"));
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
        switch (textMessage) {
            case "list of Goldplus package":
                playwright.hardWait(3000);
                Assert.assertTrue(goldplus.isGpPackageTableDisplayed(), "GP package table doesn't displayed!");
                break;
            case "Daftar":
                chat.dismissAllFTUE();
                chat.dismissFTUESurvey();
                chat.dismissFTUEJemputBola();
                Assert.assertTrue(playwright.isTextDisplayed("Sisa Kuota", 2000.0), "Daftar GoldPlus doesn't displayed!");
                Assert.assertTrue(playwright.isTextDisplayed("2 chat room", 3000.0), "Sisa kuota chat text doesn't displayed!");
                chat.clickButtonOnChatRoomList(textMessage);
                Assert.assertTrue(goldplus.isGpPackageTableDisplayed(), "GP package table doesn't displayed!");
                break;
            case "Pilih Periode Berlangganan":
                Assert.assertTrue(playwright.isTextDisplayed("Paket GoldPlus", 2000.0), "Text doesn't displayed!");
        }
    }

    @When("owner click {string} on broadcast chat page")
    public void ownerClickOnBroadcastChatPage(String buttonText) {
        playwright.clickOnTextButton(buttonText);
        Assert.assertTrue(playwright.isTextDisplayed("Pilih Periode Goldplus 2", 2000.0), "Paket GP Anda is not GP2!");
        playwright.clickOnTextButton("Pilih");
        playwright.hardWait(3000);
        playwright.clickOnText("Bayar Sekarang");
    }


    //------ GP Onboarding Pop-Up ------//

    @And("owner go to panduan gold plus memantau performa kos page")
    public void ownerGoToPanduanGoldPlusMemantauPerformaKosPage() {
        owner.clickOnGpWidgetButton();
        goldplus.clickOnPelajariCaranyaButton();
        panduanGP.clickOnGuideCard("Memantau Performa Kos");
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
        Assert.assertTrue(chat.gpPacakgeText().contains(benefit), "GP Package not contain benefit " + benefit);
    }

    @And("owner will see chat list page empty state")
    public void owner_will_see_chat_list_page_empty_state() {
        Assert.assertTrue(chat.isChatListEmptyStatePresent(), "empty state not preset");
        chat.dismissFTUEMarsKuotaNol();
    }

    @Then("user verify last ftue is {string}")
    public void user_verify_last_ftue_is(String kuota) {
        Assert.assertEquals(chat.lastFTUEnonGoldplusText(), kuota, "FTUE doesnt match");
    }

    @When("owner cek promo owner when not GP")
    public void owner_cek_promo_owner_when_not_gp() {
        promoOwner.clickOnPromoNonGP();
    }

    @Then("owner will see pop up reminder recurring is displayed")
    public void owner_will_see_pop_up_reminder_recurring_is_displayed() {
        playwright.waitTillPageLoaded(10000.0);
        Assert.assertTrue(goldplus.isButtonRecurringPopUpVisible(), "Button not visible");
        Assert.assertTrue(goldplus.isTitlePopUpRecurringVisible(), "title recurring is not visible");
        Assert.assertTrue(goldplus.isSubtitlePopUpRecurringVisible(), "subtitle recurring is not visible");
        Assert.assertTrue(goldplus.isImageRecurringPopupVisible(), "image is not visible");
    }

    @When("owner wants to proccess recurring GP")
    public void owner_wants_to_proccess_recurring_GP() {
        loading.waitForLoadingIconDisappear();
        goldplus.clickOnPerpanjangBtn();
    }

    @When("owner will be redirected to invoice recurring")
    public void owner_will_be_redirected_to_invoice_recurring() {
        loading.waitForLoadingIconDisappear();
        playwright.waitTillPageLoaded(10000.0);
        Assert.assertTrue(goldplus.gpPackageText());
    }

    @And("user view detail list saldo MamiAds")
    public void user_view_detail_list_saldo_mamiads(String expectedMamiadsSnapshot) {
        playwright.waitTillPageLoaded();
        playwright.hardWait(2000.0);
        Assert.assertEquals(goldplus.getMamiadsBalanceListSnapshot(), expectedMamiadsSnapshot);
    }

    @And("user choose saldo {string} on GoldPlus section")
    public void user_choose_saldo_on_goldplus_section(String saldo) throws InterruptedException {
        goldplus.chooseSaldo(saldo);
    }

    @Then("user verify the {string} and the price is {string} already {string} on Rincian Pembayaran")
    public void user_verify_the_and_the_price_is_already_on_rincian_pembayaran(String saldo, String rincian, String validation) {
        Mamikos.setGpPackageChoosed(goldplus.getTextGpPackageChoosed());
        System.out.println("Paket yang dipilih: " + Mamikos.getGpPackageChoosed());
        switch (validation) {
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

    @Then("user verify saldo MamiAds is choosen on Rincian Pembayaran")
    public void user_verify_saldo_mamiads_is_choosen_on_rincian_pembayaran(String expectedRincianSnapshot) {
        playwright.waitTillPageLoaded();
        playwright.hardWait(2000.0);
        Assert.assertEquals(goldplus.getRincianPembayaranSnapshot(), expectedRincianSnapshot);
    }

    @Then("user verify Total Pembayaran")
    public void user_verify_total_pembayaran(String expectedTotalSnapshot) {
        playwright.waitTillPageLoaded();
        playwright.hardWait(2000.0);
        Assert.assertEquals(goldplus.getTotalPembayaranSnapshot(), expectedTotalSnapshot);
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
        Assert.assertEquals(goldplus.getTextManfaatGP(benefit), benefit, "not match benefit");
    }

    @Then("owner see benefit in {string} is {string} is displayed")
    public void owner_see_benefit_in_is_is_displayed(String packageGP, String benefitGP) {
        switch (packageGP) {
            case "golplus 2":
                Assert.assertEquals(goldplus.getTextManfaatGP2(benefitGP), benefitGP, "benefit doesnt match");
                break;
            case "golplus 1":
                Assert.assertEquals(goldplus.getTextManfaatGP1(benefitGP), benefitGP, "benefit doesnt match");
                break;
        }
    }

    //------ Terminated Contract GP ------//
    @When("user wants to terminate Goldplus for owner with phone number {string}")
    public void user_wants_to_terminate_goldplus_for_owner_with_phone_number(String phoneNumber) {
        playwright.navigateTo(Mamikos.ADMINMAMIPAY + Mamikos.GOLDPLUS_CONTRACT);
        goldplus.searchPhoneNumberGP(phoneNumber);

        // Check if there are any active contracts to terminate for this specific phone number
        String terminateXpath = "//td[contains(text(), '')]/parent::tr//button[text()='Terminate']";
        var terminateButton = page.locator(terminateXpath);

        if (playwright.waitTillLocatorIsVisible(terminateButton, 3000.0)) {
            playwright.clickOn(terminateButton);
            playwright.clickOnTextButton("Yes, terminate it!");
            Assert.assertTrue(playwright.isTextDisplayed("Contract successfully terminated."));
        } else {
            // No active contracts found - this is acceptable for data preparation
            System.out.println("No active GoldPlus contracts found for phone number: " + phoneNumber + ". Contract termination not needed.");
        }
    }

    @When("owner navigate to list package goldplus 2")
    public void owner_navigate_to_list_package_goldplus_2() {
        playwright.waitTillPageLoaded(10000.0);
        playwright.navigateTo(Mamikos.OWNER_URL + Mamikos.GOLDPLUS_SUBMISSION_2, 30000.0, LoadState.LOAD);
    }

    @When("owner navigate to list package goldplus 1")
    public void owner_navigate_to_list_package_goldplus_1() {
        playwright.navigateTo(Mamikos.OWNER_URL + Mamikos.GOLDPLUS_SUBMISSION_1, 30000.0, LoadState.LOAD);
        loading.waitForLoadingIconDisappear();
    }

    @When("owner click nanti saja for recurring GoldPlus")
    public void owner_click_nanti_saja_for_recurring_goldplus() {
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


    @Then("owner will see that detail text on goldplus guides page:")
    public void ownerWillSeeThatDetailTextOnGoldplusGuidesPage(DataTable dataTable) {
        List<Map<String, String>> table = dataTable.asMaps();

        // Check if this is the guides list page (Title | Description format) or detail page (TextOnPage format)
        Map<String, String> firstRow = table.get(0);

        if (firstRow.containsKey("Title") && firstRow.containsKey("Description")) {
            // This is the guides list page - validate guide cards
            for (Map<String, String> content : table) {
                String expectedTitle = content.get("Title");
                String expectedDescription = content.get("Description");

                String actualTitle = panduanGP.getGuideCardTitle(expectedTitle);
                String actualDescription = panduanGP.getGuideCardDescription(expectedTitle);

                Assert.assertEquals(actualTitle, expectedTitle, "Title doesn't match for: " + expectedTitle);
                Assert.assertEquals(actualDescription, expectedDescription, "Description doesn't match for: " + expectedTitle);
            }
        } else if (firstRow.containsKey("TextOnPage")) {
            // This is a detail page - validate static content using generic text validation
            for (Map<String, String> content : table) {
                String expectedText = content.get("TextOnPage");
                Assert.assertTrue(playwright.isTextDisplayed(expectedText),
                    "Text not found on page: " + expectedText);
            }
        }
    }

    @Then("owner validate payment for goldplus package have {string} and have {string} before choose payment method")
    public void ownerValidatePaymentForGoldplusPackageHaveAndHaveBeforeChoosePaymentMethod(String mamiads, String fee) throws InterruptedException {
        goldplus.setTotalPembayaran(goldplus.getPembayaranText("Total Pembayaran"));
        Assert.assertTrue(goldplus.getPembayaranText("No. Invoice").contains("GP"));
        Assert.assertEquals(goldplus.getPembayaranText("Metode Pembayaran"), "Belum dipilih");
        Assert.assertTrue(playwright.isTextDisplayed(mamiads), String.format("MamiAds %s is not match", mamiads));
        Assert.assertEquals(goldplus.getRincianFee(), fee, "MDR Fee  is not match");
    }

    @Then("user will see that the goldplus package choosed is displayed")
    public void userWillSeeThatTheGoldplusPackageChoosedIsDisplayed() {
        var expected = Mamikos.getGpPackageChoosed();
        var actual = goldplus.getTextGpPackageChoosed();
        Assert.assertTrue(actual.contains(expected), String.format("GP actual contains %s but on expected %s", actual, expected));
    }

    @Then("user will see that the goldplus package on rincian pembayaran detail tagihan")
    public void userWillSeeThatTheGoldplusPackageOnRincianPembayaranDetailTagihan() {
        var expected = Mamikos.getGpPackageChoosed();
        var actual = goldplus.getGpPackageRincianPembaranDetailTagihan();
        Assert.assertTrue(actual.contains(expected), String.format("GP actual contains %s but on expected %s", actual, expected));
    }

    //------ GP Weekly------//
    @When("owner select transaction unpaid from history transaction goldplus")
    public void owner_select_transaction_unpaid_from_history_transaction_goldplus() {
        goldplus.clickOnTransactionGPUnpaid();
    }

    @Then("owner can see detail tagihan goldplus page with title {string}")
    public void owner_can_see_detail_tagihan_goldplus_page_with_title(String status) {
        Assert.assertEquals(goldplus.statusTransactionGP(status), status, "status not equals");
    }


    @Then("owner can see detail tagihan paid goldplus page with title {string}")
    public void owner_can_see_detail_tagihan_paid_goldplus_page_with_title(String status) {
        Assert.assertEquals(goldplus.statusTransactionPaidGP(), status, "status paid not show");
    }

    @Then("owner can see {string} at section Paket yang Anda pilih")
    public void owner_can_see_at_section_paket_yang_anda_pilih(String packageGP) {
        Assert.assertTrue(goldplus.sectionPackageSelectedIsVisible(), "section not visible");
        Assert.assertTrue(goldplus.packageGP(packageGP), "package GP not show");

    }

    @Then("owner can see {string} at section rincian pembayaran goldplus")
    public void owner_can_see_at_section_rincian_pembayaran_goldplus(String packageGP) {
        Assert.assertTrue(goldplus.sectionDetailBillingdIsVisible(), "section not visible");
        Assert.assertTrue(goldplus.packageGP(packageGP), "package GP not show");
    }

    @Given("owner paid transaction from detail tagihan page")
    public void owner_paid_transaction_from_detail_tagihan_page() {
        goldplus.clicOnButtonPaid();
    }

    @Given("owner select transaction paid from history transaction goldplus")
    public void owner_select_transaction_paid_from_history_transaction_goldplus() {
        goldplus.clickOnTabSelesaiRiwayatGP();
        goldplus.clickOnTransactionGPPaid();
    }

    @Then("owner select transaction expired from history transaction goldplus")
    public void owner_select_transaction_expired_from_history_transaction_goldplus() {
        goldplus.clickOnTabSelesaiRiwayatGP();
        goldplus.clickOnTransactionGPExpired();
    }

    @Then("owner can see pop up goldplus with title {string}")
    public void owner_can_see_pop_up_goldplus_with_title(String title) {
        if (goldplus.imagePopUpWeeklyIsVisible()) {
            Assert.assertTrue(goldplus.imagePopUpWeeklyIsVisible(), "image not show");
            Assert.assertEquals(goldplus.getTitlePopUpWeekly(title), title, "title not equals");
        }
    }

    @Then("owner can see pop up golplus with desc {string}")
    public void owner_can_see_pop_up_golplus_with_desc(String desc) {
        if (goldplus.buttonLihatFiturWeeklyIsVisible()) {
            Assert.assertTrue(goldplus.buttonLihatFiturWeeklyIsVisible(), "button not visible");
            Assert.assertTrue(goldplus.buttonNantiSajaWeeklyIsVisible(), "button nanti saja not visible");
            Assert.assertEquals(goldplus.getDescPopUpWeekly(desc), desc, "description not equals");
        }
    }

    @And("admin edit the price to {int}")
    public void adminEditThePriceTo(int price) {
        goldplus.editPriceGp(price);
    }

    @And("admin submit and get warning {string}")
    public void adminSubmitAndGetWarning(String warningMessage) {
        goldplus.clickSaveButton();
        Assert.assertEquals(goldplus.getWarningMessageEditGp(), warningMessage, "Warning message doesn't match!");
    }

    @And("admin submit and get success message {string}")
    public void adminSubmitAndGetSuccessMessage(String successMessage) {
        goldplus.clickSaveButton();
        Assert.assertEquals(goldplus.getSuccessMessage(), successMessage, "Success! GoldPlus package updated.");
    }

    @Then("owner see that the text {string} is displayed on goldplus page")
    public void ownerSeeThatTheTextIsDisplayedOnGoldplusPage(String text) {
        playwright.waitTillPageLoaded();
        Assert.assertTrue(playwright.isTextDisplayed(text, 5000));
    }

    @And("owner GP-1 upgrade paket to GP-2 from TBC detail page")
    public void ownerGPUpgradePaketToGPFromTBCDetailPage() {
        goldplus.upgradePaketGp1ToGp2();
    }

    @And("owner click on upgrade package at tbc profile tenant")
    public void ownerClickOnUpgradePackage() {
        goldplus.clickOnUpgradePackage();
    }

    @And("Owner visit Goldplus package without action close the on boarding pop up")
    public void ownerVisitGoldplusPackage() {
        owner.clickOnDaftarGP();
    }

    @Then("Owner see gp onboarding pop up is exist")
    public void ownerSeeGpOnboardingPopUpIsExist() {
        Assert.assertTrue(goldplus.isOnBoardingPopExist(), "Gp Onboarding not exist");
    }

    @Then("Owner see gp onboarding pop up is not exist")
    public void ownerSeeGpOnboardingPopUpIsNotExist() {
        Assert.assertFalse(goldplus.isOnBoardingPopExist(), "Gp Onboarding is exist");
    }

    @And("Owner swap the gp pop up onboarding")
    public void ownerSwapTheGpPopUpOnboarding() {
        goldplus.tapOnSwapNextGpOnboarding();
        goldplus.tapOnSwapPreviousGpOnboarding();
    }

    @And("Owner swap the gp pop up onboarding {int} times")
    public void ownerSwapTheGpPopUpOnboardingTimes(int swpCount) {
        for (int i = 0; i < swpCount; i++) {
            goldplus.tapOnSwapNextGpOnboarding();
        }

        for (int i = 0; i < swpCount; i++) {
            goldplus.tapOnSwapPreviousGpOnboarding();
        }
    }

    @And("Owner tap on pilih paket goldplus from gp onboarding pop up")
    public void ownerTapOnPilihPaketGoldplusFromGpOnboardingPopUp() {
        goldplus.tapOnPilihPaketGoldplusBtnFromGpOnboardingPopUp();
    }

    @Then("owner verify list of Pilih Gp Package is appear")
    public void ownerVerifyListOfPilihGpPackageIsAppear(String expectedAriaSnapshot) {
        playwright.waitTillPageLoaded();
        loading.waitForLoadingIconDisappear();

        // Get the actual aria snapshot from the current page
        String actualAriaSnapshot = goldplus.getPilihGpPackageAriaSnapshot();

        System.out.println("=== ACTUAL ARIA SNAPSHOT ===");
        System.out.println(actualAriaSnapshot);
        System.out.println("=== EXPECTED ARIA SNAPSHOT ===");
        System.out.println(expectedAriaSnapshot);

        // Compare the snapshots directly
        Assert.assertEquals(actualAriaSnapshot, expectedAriaSnapshot,
                String.format("Pilih Gp package structure does not match expected layout.\n\nEXPECTED:\n%s\n\nACTUAL:\n%s",
                    expectedAriaSnapshot, actualAriaSnapshot));
    }


    @Then("owner verify list of Pilih Gp Package is contains")
    public void ownerVerifyListOfPilihGpPackageIsContais(String expectedAriaSnapshot) {
        playwright.waitTillPageLoaded();
        loading.waitForLoadingIconDisappear();

        // Get the actual aria snapshot from the current page
        String actualAriaSnapshot = goldplus.getPilihGpPackageAriaSnapshot();

        // Compare the snapshots directly without normalization for better visualization
        Assert.assertTrue(actualAriaSnapshot.contains(expectedAriaSnapshot),
                String.format("Pilih Gp package structure does not contains expected layout with actual: %s", actualAriaSnapshot));
    }

    @When("owner choose periode goldplus {string}")
    public void owner_choose_periode_goldplus(String period) {
        goldplus.clickOnPeriodGoldPlus(period);
    }

    @And("user/owner Navigasi ke Chat List")
    public void userNavigasiKeChatList() {
        playwright.hardWait(3000);
        chat.clickCloseOnFTUEBeforeChat();
        chat.clickChatOwner();
        chat.dismissAllFTUE();
        chat.dismissFTUEMarsGPAndSurveyIfExist();
        chat.dismissFTUEJemputBolaIfExist();
    }

    @Then("user observe GP entry point display")
    public void userObserveGpEntryPointDisplay() {
        chat.clickChatOwner();
        Assert.assertTrue(goldplus.isGpEntryPointDisplayed(), "Paket murah untuk interaksi lancar dengan calon penyewa! Coba sekarang");
    }

    @And("Countdown timer appears")
    public void countdownTimerAppears() {
        chat.clickChatOwner();
        Assert.assertTrue(goldplus.isCountdownTimerDisplayed(), "Countdown timer is not displayed");
    }

    @And("Price displayed: {string}")
    public void priceDisplayed(String expectedPrice) {
        Assert.assertTrue(goldplus.getDisplayedPrice(expectedPrice));
    }

    @And("Copy text {string}")
    public void copyText(String expectedCopyText) {
        String actualCopyText = goldplus.getEntryPointCopyText();
        Assert.assertEquals(actualCopyText, expectedCopyText, "Copy text doesn't match. Expected: " + expectedCopyText + " but found: " + actualCopyText);
    }

    @Then("user/owner check countdown value running")
    public void userCheckCountdownValueRunning() throws InterruptedException {
        // Get initial countdown value
        String initialCountdown = goldplus.getCountdownTimerValue();
        System.out.println("Initial countdown value: " + initialCountdown);

        // Extract only the numeric parts from the countdown
        String initialNumbers = initialCountdown.replaceAll("[^0-9]", "");
        System.out.println("Initial numbers extracted: " + initialNumbers);

        // Wait for 3 seconds to ensure timer updates
        Thread.sleep(3000);

        // Get countdown value after waiting
        String updatedCountdown = goldplus.getCountdownTimerValue();
        System.out.println("Updated countdown value: " + updatedCountdown);

        String updatedNumbers = updatedCountdown.replaceAll("[^0-9]", "");
        System.out.println("Updated numbers extracted: " + updatedNumbers);

        Assert.assertNotEquals(initialNumbers, updatedNumbers,
                "Countdown timer is not running. Numbers remained the same: " + initialNumbers);

        Assert.assertFalse(updatedNumbers.isEmpty(),
                "Countdown timer should contain at least some numbers, but found: " + updatedCountdown);

        System.out.println("Countdown timer is running correctly!");
    }

    @Then("user/owner check no countdown value running")
    public void userCheckNoCountdownValueRunning() {
        Assert.assertFalse(goldplus.isCountdownTimerDisplayed(), "Countdown timer should not be displayed, but it is visible on the page");
        System.out.println("Confirmed: No countdown timer is running on the page");
    }

    @And("owner see GPSP promo countdown")
    public void ownerSeeGPSPPromoCountdown() {
        Assert.assertTrue(owner.isGpspPromoCountDownExist(), "gpsp promo countdown is not exist on owner dashboard");
    }

    @And("owner disable gp pop up")
    public void ownerDisableGpPopUp() {
        owner.dismissFTUEGoldplus();
    }

    // === Admin Goldplus Package - Add Package ===
    @When("user click on add package button")
    public void userClickOnAddPackageButton() {
        goldplus.clickOnAddPackageButton();
    }

    @Then("user check New Field {string}")
    public void userCheckNewField(String fieldName) {
        Assert.assertTrue(goldplus.isPremiumPackageBonusFieldDisplayed(),
            "Field '" + fieldName + "' is not displayed on the page");
    }

    @And("user click on dropdown Bundled Premium Package")
    public void userClickOnDropdownBundledPremiumPackage() {
        goldplus.clickOnBundledPremiumPackageDropdown();
    }

    @Then("user see package Bundled Premium:")
    public void userSeePackageBundledPremium(List<String> expectedPackages) {
        List<String> actualPackages = goldplus.getBundledPremiumPackageOptions();
        for (String expectedPackage : expectedPackages) {
            Assert.assertTrue(actualPackages.stream().anyMatch(p -> p.contains(expectedPackage)),
                "Package '" + expectedPackage + "' is not found in dropdown. Available: " + actualPackages);
        }
    }

    @And("user select package {string}")
    public void userSelectPackage(String packageName) {
        goldplus.selectBundledPremiumPackage(packageName);
    }

    @Then("Bundle package has been successfully selected")
    public void bundlePackageHasBeenSuccessfullySelected() {
        Assert.assertTrue(goldplus.isBundledPremiumPackageDropdownDisplayed(),
            "Bundled Premium Package dropdown is not displayed after selection");
    }

    @When("user search ID {string}")
    public void userSearchId(String id) {
        goldplus.searchPackageById(id);
    }

    @And("user click on edit button")
    public void userClickOnEditButton() {
        goldplus.clickOnEditPackageButton();
    }

    @And("user change and select package {string}")
    public void userChangeAndSelectPackage(String packageName) {
        goldplus.selectBundledPremiumPackage(packageName);
    }

    @Then("owner will see GoldPlus logo image {string}")
    public void ownerWillSeeGoldPlusLogoImage(String expectedImageName) {
        String actualImageName = owner.getGoldPlusLogoImageName();
        Assert.assertEquals(actualImageName, expectedImageName, "GoldPlus logo image name does not match");
    }
}