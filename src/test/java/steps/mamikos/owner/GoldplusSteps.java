package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.HomePO;
import pageobject.owner.OwnerDashboardPO;
import pageobject.owner.chat.BroadcastChatPO;
import pageobject.owner.chat.ChatOwnerPO;
import pageobject.owner.goldplus.GoldplusPO;
import pageobject.owner.goldplus.PanduanGoldplusPO;
import pageobject.owner.mamiads.MamiAdsPO;
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

    @When("user wants to subscribe Goldplus {int}")
    public void user_wants_to_subscribe_goldplus(int pacakge) {
       if (home.getURL().equals("https://owner-jambu.kerupux.com/goldplus/submission/packages")){
            goldplus.clickOnGPPackage(pacakge);
        } else{
            navigate.userNavigateTo("/goldplus/submission/periode/gp"+pacakge);
        }
        playwright.hardWait(3000);
        if (playwright.isTextDisplayed("1 Minggu") == true) {
            goldplus.clickOnPeriodeWeekly();
        }
        playwright.hardWait(3000);
        playwright.clickOnTextButton("Pilih");
        playwright.hardWait(3000);
        playwright.clickOnText("Bayar Sekarang");
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

    @When("user sets recurring for number {string}")
    public void user_sets_recurring_for_number(String phoneNumber) {
        playwright.navigateTo(Mamikos.ADMINMAMIPAY+Mamikos.GOLDPLUS_TESTING_TOOLS);
        goldplus.inputRecurringPhoneNumber(phoneNumber);
        playwright.clickOnTextButton("Create Recurring");
        Assert.assertTrue(playwright.isTextDisplayed("Recurring invoice created!"));
    }

    @Then("user verify list of Periode Berlangganan is appear")
    public void user_verify_list_of_period_berlangganan_is_appear(DataTable dataTable) {
        playwright.hardWait(1000);
        List<Map<String, String>> table = dataTable.asMaps();
        int i=0;
        for (Map<String, String> content : table) {
            Assert.assertEquals(goldplus.listPeriod("periodGP",i).replaceAll("\\s", ""),content.get("periodGP").replaceAll("\\s", ""));
            Assert.assertEquals(goldplus.listPeriod("freeMamiAds",i),content.get("freeMamiAds"));
            Assert.assertEquals(goldplus.listPeriod("actualPrice",i),content.get("actualPrice"));
            Assert.assertEquals(goldplus.listPeriod("discPrice",i),content.get("discPrice"));
            i++;
        }
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
    }

    @When("admin successfully adds additional favorite labels")
    public void admin_successfully_adds_additional_favorite_labels() {
        goldplus.clickOnEditGP2Button();
        goldplus.clickYesRadioButton();
        playwright.clickOnText("Save");
    }

    @When("admin successfully remove additional favorite labels")
    public void admin_successfully_remove_additional_favorite_labels() {
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
        playwright.clickOnTextButton("Perpanjang");
    }

    @When("owner wants to extends Goldplus from chatroom")
    public void owner_wants_to_extends_goldplus_from_chatroom() {
        chat.clickChatOwner();
        chat.dismissFTUEMarsGPAndBroadCast();
        playwright.clickOnTextButton("Akbar Susilo");
        playwright.clickOnTextButton("Perpanjang");
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
        playwright.hardWait(3000);
        Assert.assertTrue(playwright.isButtonWithTextDisplayed("Lihat Detail Paket"));
        Assert.assertTrue(playwright.isButtonWithTextDisplayed("Beli Paket"));
    }

    @And("owner click lanjut bayar button on chatlist")
    public void ownerClickLanjutBayarButtonOnChatlist(){
        chat.clickChatOwner();
        playwright.clickOnTextButton("Lanjut Bayar");
    }

    @And("owner click lanjut bayar button on chatrooms {string}")
    public void ownerClickLanjutBayarButtonOnChatrooms(String tenantName) {
        chat.clickChatOwner();
        chat.dismissFTUEMars();
        chat.dismissFTUEMarsKuotaNol();
        broadcast.clickOnCloseTooltip();
        playwright.hardWait(3000);
        playwright.clickOnTextButton(tenantName);
        playwright.hardWait(3000);
        playwright.clickOnTextButton("Lanjut Bayar");
    }

    //------ GP Onboarding ------//
    @When("owner go to panduan gold plus page")
    public void ownerGoToPanduanGoldPlusPage() {
        owner.clickOnGpWidgetButton();
        goldplus.clickOnPelajariCaranyaButton();
        panduanGP.clickOnNaikkanIklanAndaButton();
    }

    @When("owner click on next button to go to slide number {int}")
    public void ownerClickOnNextButtonOnPanduanGoldPlusSwipper(Integer swiperNumber) {
        if (swiperNumber <= 6) {
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
}
