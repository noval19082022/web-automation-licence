package steps.mamikos.tenant;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.TimeoutError;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.HomePO;
import pageobject.common.KostDetailsPO;
import pageobject.common.SearchPO;
import pageobject.common.apartment.ApartmentDetailPO;
import pageobject.tenant.BookingFormPO;
import pageobject.tenant.SuccessBookingPO;
import pageobject.tenant.profile.RiwayatBookingPO;
import utilities.PlaywrightHelpers;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertFalse;

public class TenantBookingSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwrightHelpers;
    HomePO homePO = new HomePO(page);
    SearchPO searchPO;
    KostDetailsPO kostDetail = new KostDetailsPO(page);
    ApartmentDetailPO apartDetail = new ApartmentDetailPO(page);
    BookingFormPO bookingForm;
    SuccessBookingPO successBooking;

    RiwayatBookingPO riwayatBooking = new RiwayatBookingPO(page);

    private List<Map<String, String>> searchKost;
    private List<Map<String, String>> pathUrlKosts;
    private List<String> ftueBookingBenefitTextList;
    private List<Map<String, String>> searchApart;

    @When("tenant search kost then go to kost details:")
    public void tenantSearchKostThenGoToKostDetails(DataTable table) {
        searchKost = table.asMaps(String.class, String.class);
        var kostName = searchKost.get(0).get("kost name " + Mamikos.ENV);
        searchPO = homePO.clickOnSearchButton();
        kostDetail = searchPO.searchByText(kostName);
        kostDetail.waitTillKostDetailPageVisible();
    }

    @When("tenant redirect to kost details:")
    public void tenantGoToKostDetails(DataTable table) {
        playwrightHelpers = new PlaywrightHelpers(ActiveContext.getActivePage());
        pathUrlKosts = table.asMaps(String.class, String.class);
        var pathUrlKost = pathUrlKosts.get(0).get("kost path " + Mamikos.ENV);
        var url = String.format("%s/room/%s", Mamikos.URL, pathUrlKost);

        playwrightHelpers.navigateTo(url);
    }

    @When("tenant booking kost")
    public void tenantBookingKost() {
        kostDetail.dismissFTUE();
        kostDetail.selectBookingDate("today");
        kostDetail.selectBookingPeriod("Per Bulan");
        bookingForm = kostDetail.clickOnAjukanSewaButton();
        bookingForm.clickOnAjukanSewaButton();
        bookingForm.clickOnBookingConfirmationCheckmarkWithValidation();
        successBooking = bookingForm.clickOnKirimPengajuanKePemilik();
    }

    @When("tenant booking kost {string} {string}")
    public void tenantBookingKost(String boardingDate, String paymentPeriod) {
        if (kostDetail.isBookingFtueVisible()) {
            kostDetail.dismissFTUE();
        }
        kostDetail.selectBookingDate(boardingDate);
        kostDetail.selectBookingPeriod(paymentPeriod);
        bookingForm = kostDetail.clickOnAjukanSewaButton();
        bookingForm.clickOnAjukanSewaButton();
        bookingForm.clickOnBookingConfirmationCheckmarkWithValidation();
        successBooking = bookingForm.clickOnKirimPengajuanKePemilik();
    }

    @And("user will see Jumlah Penyewa can add until 3 Penyewa")
    public void add_three_penyewa() {
        bookingForm = new BookingFormPO(page);
        bookingForm.addJumlahPenyewa(3);
    }

    @And("user will see enable and tick Check box {string}")
    public void checkmark(String checkmarkname) {
        bookingForm.checkMark(checkmarkname);
    }

    @When("user want to upload berkas wajib if user haven't upload it")
    public void uploadBerkas() {
        bookingForm.uploadBerkasBooking();
    }

    @And("user can set Ajukan Sewa")
    public void ajukanSewa() {
        bookingForm.clickOnAjukanSewaButton();
        bookingForm.clickOnBookingConfirmationCheckmarkWithValidation();
        successBooking = bookingForm.clickOnKirimPengajuanKePemilik();
    }

    @Then("tenant should success booking kost")
    public void tenantShouldSuccesBookingKost() {
        successBooking.waitUntilSuccessBookingHeadingVisible();
        Assert.assertEquals(successBooking.getSuccessBookingHeadingText(), "Lihat status pengajuan");
    }

    @And("user cancel booking")
    public void userCancelBooking() {
        page.navigate(Mamikos.URL + "/user/booking/");
        bookingForm = new BookingFormPO(page);
        bookingForm.cancelBooking();
    }

    @And("user cancel booking for check recommendation kos")
    public void userCancelBookingForCheckRecommendationKos() {
        page.navigate(Mamikos.URL + "/user/booking/");
        bookingForm = new BookingFormPO(page);
        bookingForm.cancelBookingForCheckRecommendation();
    }

    @And("user cancel booking with reason {string}")
    public void user_cancel_booking_with_reason(String reason) throws InterruptedException {
        page.navigate(Mamikos.URL + "/user/booking/");
        bookingForm = new BookingFormPO(page);
        bookingForm.cancelBookingWithReason(reason);
        if (bookingForm.waitUntilSuccessCancelHeadingVisible()) {
            Assert.assertEquals(bookingForm.getSuccessCancelText().trim(), "Booking Anda berhasil dibatalkan");
        }
        bookingForm.closeCancelPopUp();
    }

    @When("tenant booking kost for {string}")
    public void tenantBookingKostFor(String bookingTime) {
        if (kostDetail.isFTUEBookingBenefitVisible()) {
            kostDetail.dismissFTUE();
        }
        if (bookingTime.equalsIgnoreCase("today")) {
            kostDetail.selectBookingDate(bookingTime);
            kostDetail.selectBookingPeriod("Per Bulan");
            bookingForm = kostDetail.clickOnAjukanSewaButton();
            bookingForm.clickOnAjukanSewaButton();
            bookingForm.clickOnBookingConfirmationCheckmarkWithValidation();
            successBooking = bookingForm.clickOnKirimPengajuanKePemilik();
        } else if (bookingTime.equalsIgnoreCase("Tomorrow")) {
            kostDetail.selectBookingDate(bookingTime);
            kostDetail.selectBookingPeriod("Per Bulan");
            bookingForm = kostDetail.clickOnAjukanSewaButton();
        }
    }

    @When("tenant booking kost for {string} with duration {int}")
    public void tenantBookingKostFor(String bookingTime, int duration) {
        if (kostDetail.isFTUEBookingBenefitVisible()) {
            kostDetail.dismissFTUE();
        }
        if (bookingTime.equalsIgnoreCase("today")) {
            kostDetail.selectBookingDate(bookingTime);
            kostDetail.selectBookingPeriod("Per Bulan");
            bookingForm = kostDetail.clickOnAjukanSewaButton();
            if (duration > 1) {
                for (int i = 0; i < (duration - 1); i++) {
                    bookingForm.increaseRateDuration();
                }
            }
            bookingForm.clickOnAjukanSewaButton();
            bookingForm.clickOnBookingConfirmationCheckmarkWithValidation();
            successBooking = bookingForm.clickOnKirimPengajuanKePemilik();
        } else if (bookingTime.equalsIgnoreCase("Tomorrow")) {
            kostDetail.selectBookingDate(bookingTime);
            kostDetail.selectBookingPeriod("Per Bulan");
            bookingForm = kostDetail.clickOnAjukanSewaButton();
        }
    }

    @When("tenant checkin kost from riwayat booking")
    public void tenantCheckinKostFromRiwayatBooking() {
        riwayatBooking.clickOnCheckinButton();
        riwayatBooking.clickOnCheckinPopUpButton();
        riwayatBooking.clickOnSelesaiAndKeKostSaya();
    }


    @And("tenant booking kost for {string} and input rent duration equals to {int}")
    public void tenantBookingKostForAndInputRentDurationEqualsTo(String bookingTime, int duration) throws InterruptedException {
        kostDetail.dismissFTUE();
        kostDetail.selectBookingDate(bookingTime);
        kostDetail.selectBookingPeriod("Per Bulan");
        bookingForm = kostDetail.clickOnAjukanSewaButton();
        for (int i = 1; i < duration; i++) {
            bookingForm.increaseRateDuration();
        }
        bookingForm.clickOnAjukanSewaButton();
        bookingForm.clickOnBookingConfirmationCheckmarkWithValidation();
        successBooking = bookingForm.clickOnKirimPengajuanKePemilik();
    }

    @Then("user/owner/tenant can see FTUE booking benefit with wording:")
    public void userCanSeeFTUEBookingBenefit(DataTable table) {
        ftueBookingBenefitTextList = table.asList(String.class);
        Assert.assertTrue(kostDetail.isFTUEBookingBenefitVisible(), "FTUE Slide Booking Benefit is not visible");
        for (int i = 0; i < ftueBookingBenefitTextList.size(); i++) {
            System.out.println("Asserting: " + ftueBookingBenefitTextList.get(i));
            Assert.assertEquals(kostDetail.getFTUEBookingBenefitWording(i), ftueBookingBenefitTextList.get(i), "FTUE wording is not equals");
        }
    }

    @When("user/tenant/owner dismiss FTUE booking benefit")
    public void userDismissFTUEBookingBenefit() {
        Page activePage = ActiveContext.getActivePage();
        KostDetailsPO activeKostDetail = new KostDetailsPO(activePage);
        activeKostDetail.dismissFTUE();
    }

    @Then("user can not see FTUE booking benefit")
    public void userCanNotSeeFTUEBookingBenefit() {
        Assert.assertFalse(kostDetail.isFTUEBookingBenefitIsNotVisible(), "FTUE Slide booking benefit is still visible");
    }

    @And("user search for Kost with name {string} and selects matching result")
    public void userSearchForKostWithNameAndSelectsMatchingResult(String kosName) {
        searchPO = homePO.clickOnSearchButton();
        kostDetail = searchPO.searchByText(kosName);
        kostDetail.waitTillKostDetailPageVisible();
    }

    @And("tenant cancel all need confirmation booking request")
    public void tenantCancelAllNeedConfirmationBookingRequest() {
        kostDetail.cancelAllBookingWithDefaultReason();
    }

    @And("user click Save Draft Button")
    public void userClickSaveDraftButton() {
        kostDetail.clickSaveDraftButton();
    }

    @And("user click back button")
    public void userClickBackButton() {
        kostDetail.clickBackButton();
    }

    @Then("user can see shortcut homepage with {string}")
    public void userCanSeeShortcutHomepageWith(String kosCheckedByOwner) {
        Assert.assertEquals(kostDetail.getKosCheckedByOwner(), kosCheckedByOwner, "Mau lanjut ajukan sewa di kos ini?");
    }

    @And("user click on Draft menu")
    public void userClickOnDraftMenu() {
        kostDetail.clickOnDraftMenu();
    }

    @And("user click delete button on tab one draft booking")
    public void userClickDeleteButtonOnTabOneDraftBooking() {
        kostDetail.clickDeleteButtonOnTabOneDraftBooking();
    }

    @And("user click Mau Coba Dong section at homepage")
    public void userClickMauCobaDongSectionAtHomepage() {
        kostDetail.clickMauCobaDongSectionAtHomepage();
    }

    @Then("user can see validation on jobs with {string}")
    public void userCanSeeValidationOnJobsWith(String messsageRequired) {
        bookingForm.clickOnAjukanSewaButton();
        Assert.assertEquals(bookingForm.getAlertJobsTextAfterClick(), messsageRequired, "text not same in the display");
    }

    @And("tenant open calendar from kost detail")
    public void tenantOpenCalendarFromKostDetail() {
        kostDetail.dismissFTUE();
        kostDetail.clickOnCalendar();
    }

    @Then("tenant will see BSS Information {string}")
    public void tenantWillSeeBSSInformation(String infoBSS) {
        Assert.assertEquals(kostDetail.getBSSInformationText(infoBSS), infoBSS, "text not same in the display");
    }

    @When("tenant fill booking data for {string} and {string}")
    public void tenantFillBookingDataFor(String bookingTime, String rentType) {
        if (bookingTime.equalsIgnoreCase("today")) {
            kostDetail.selectBookingDate(bookingTime);
            kostDetail.selectBookingPeriod(rentType);
        } else if (bookingTime.equalsIgnoreCase("tomorrow")) {
            kostDetail.selectBookingDate(bookingTime);
            kostDetail.selectBookingPeriod(rentType);
        }
    }

    @Then("tenant should see ajukan sewa button is {string}")
    public void tenantShouldSeeAjukanSewais(String status) {
        if (status.equalsIgnoreCase("enable")) {
            Assert.assertTrue(kostDetail.isAjukanSewaButtonEnable());
        } else if (status.equalsIgnoreCase("disable")) {
            Assert.assertFalse(kostDetail.isAjukanSewaButtonEnable());
        }
    }

    @When("tenant booking kost after fill date and rent type")
    public void tenantBookingKostAfterFillDateAndRentType() {
        bookingForm = kostDetail.clickOnAjukanSewaButton();
        bookingForm.clickOnAjukanSewaButton();
        bookingForm.clickOnBookingConfirmationCheckmarkWithValidation();
        successBooking = bookingForm.clickOnKirimPengajuanKePemilik();
    }

    @Then("tenant/user can see harga coret on price section")
    public void user_can_see_harga_coret_on_price_section() {
        Assert.assertTrue(kostDetail.isHargaCoretVisible());
    }

    @Then("tenant/user can not see harga coret on price section")
    public void user_can_not_see_harga_coret_on_price_section() {
        Assert.assertTrue(kostDetail.isHargaCoretVisible());
    }

    @And("tenant/user dismiss promo ngebut pop up")
    public void user_dismiss_promo_ngebut_pop_up() {
        kostDetail.scrollDownToUntilPromoPopUpVisible();
        if (kostDetail.isMamikosPromoNgebutButtonVisible()) {
            kostDetail.clickOnSayaMengertiButton();
        }
    }

    @And("tenant/user click ajukan sewa button on kost detail page")
    public void tenant_click_ajukan_sewa_on_kost_detail() {
        bookingForm = kostDetail.clickOnAjukanSewaButton();
    }

    @And("tenant/user click ajukan sewa button on pengajuan sewa page")
    public void tenant_click_ajukan_sewa_on_pengajuan_sewa() {
        bookingForm.clickOnAjukanSewaButton();
    }

    @Then("tenant/user can see TnC with {string}")
    public void user_can_see_tnc_with_x(String text) {
        if (text.equalsIgnoreCase("Syarat Ketentuan Umum") || text.equalsIgnoreCase("Syarat dan Ketentuan Umum")) {
            Assert.assertEquals(bookingForm.getTnCBookingTextReguler(), text, "text not same with tnc booking");
        } else if (text.equalsIgnoreCase("Syarat dan Ketentuan Tinggal di Singgahsini, Apik, & Kos Pilihan")) {
            Assert.assertEquals(bookingForm.getTnCBookingTextSinggahsini(), text, "text not same with tnc booking");
        }
    }

    @When("tenant/user click on TnC with {string}")
    public void user_click_on_tnc_with_x(String text) {
        if (text.equalsIgnoreCase("Syarat Ketentuan Umum") || text.equalsIgnoreCase("Syarat dan Ketentuan Umum")) {
            bookingForm.clickOnTnCBookingReguler();
        } else if (text.equalsIgnoreCase("Syarat dan Ketentuan Tinggal di Singgahsini, Apik, & Kos Pilihan")) {
            bookingForm.clickTnCBookingSinggahsini();
        }
    }

    @Then("tenant/user can see TnC content with {string}")
    public void user_can_see_tnc_content_text_with_x(String text) {
        Assert.assertEquals(bookingForm.getTnCBookingContentText(), text, "text not same with the content");
        bookingForm.clickOkPahamButton();
    }

    @Then("tenant/user can see refund policy on kost detail")
    public void tenant_can_see_refund_policy() {
        Assert.assertTrue(kostDetail.isRefundPolicySectionVisible(), "refund policy in kost detail is not visible");
    }

    @When("tenant/user click bagaimana ketentuannya")
    public void tenant_click_bagaimana_ketentuannya() {
        kostDetail.clickBagaimanaKetentuan();
    }

    @Then("tenant/user can see refund policy information with:")
    public void tenant_can_see_refund_policy_information(List<String> refundSubtitle) {
        Assert.assertTrue(kostDetail.isTnCRefundVisible(), "Syarat dan Ketentuan Refund is not visible");
        for (String s : refundSubtitle) {
            kostDetail.isTnCRefundPoint(s);
        }
    }

    @When("tenant/user click refund policy mamikos")
    public void tenant_click_refund_policy_mamikos() {
        kostDetail.clickRefundPolicyMamikos();
    }

    @When("tenant/user click on ketentuan waktu berikut")
    public void tenant_click_on_ketentuan_waktu_berikut() {
        kostDetail.clickTimeConditionRefund();
    }

    @When("Tenant see booking date according to BSS setting")
    public void TenantSeeBookingDateAccordingToBssSetting() {
        kostDetail.selectBookingDate("today");
    }

    @Then("tenant can see kamar penuh")
    public void tenantCanSeeKamarPenuh() {
        Assert.assertTrue(kostDetail.isFullRoomVisible(), "Kamar penuh, lihat tipe kamar lainnya");
    }

    @When("tenant can see {string} button")
    public void tenantCanSeexButton(String text) {
        if (text.equalsIgnoreCase("Lihat tipe lain")) {
            Assert.assertTrue(kostDetail.isAnotherTypeButtonVisible(), "Lihat tipe lain");
        } else if (text.equalsIgnoreCase("Lihat kost lain")) {
            Assert.assertTrue(kostDetail.isAnotherKosButtonVisible(), "Lihat kos lain");
        } else if (text.equalsIgnoreCase("Ikut daftar Tunggu")) {
            Assert.assertTrue(kostDetail.isWaitingListButtonVisible(), "Ikut Daftar Tunggu");
        } else if (text.equalsIgnoreCase("Tanya pemilik")) {
            Assert.assertTrue(kostDetail.isTanyaPemilikVisible(), "Tanya Pemilik");
        }
    }

    @And("tenant click on {string} button")
    public void tenantClickOnXButton(String text) {
        if (text.equalsIgnoreCase("Lihat tipe lain")) {
            kostDetail.clickAnotherTypeButton();
        } else if (text.equalsIgnoreCase("Lihat kos lain")) {
            kostDetail.clickAnotherKosButton();
        }
        else if (text.equalsIgnoreCase("Salin")){
            kostDetail.clickOnSalinButton();
        }
        else if (text.equalsIgnoreCase("Salin Detail")){
            kostDetail.clickOnSalinDetailButton();
        }
    }

    @Then("tenant see {string} section")
    public void tenantSeeXSection(String text) {
        if (text.equalsIgnoreCase("lihat tipe lain")) {
            kostDetail.isAnotherTypeSectionVisible();
        } else if (text.equalsIgnoreCase("kamu mungkin menyukainya")) {
            kostDetail.isAnotherKosSectionVisible();
        }
    }

    @Then("tenant can't see {string} section")
    public void tenantCantSeeXSection(String text) {
        if (text.equalsIgnoreCase("lihat tipe lain")) {
            kostDetail.isAnotherTypeSectionNotVisible();
        } else if (text.equalsIgnoreCase("kamu mungkin menyukainya")) {
            kostDetail.isAnotherKosSectionNotVisible(); // Memastikan tidak terlihat
        }
    }


    @Then("tenant/user can see {string}")
    public void tenantCanSeeX(String text) {
        if (text.equalsIgnoreCase("Kos ini khusus untuk karyawan")) {
            Assert.assertTrue(kostDetail.isPopupValidationVisible(), "Kos ini khusus untuk karyawan");
        } else if (text.equalsIgnoreCase("Kos ini khusus untuk mahasiswa")) {
            Assert.assertTrue(kostDetail.isPopupValidationVisible(), "Kos ini khusus untuk mahasiswa");
        } else if (text.equalsIgnoreCase("Belum ada data jenis kelamin")) {
            Assert.assertTrue(kostDetail.isPopupValidationVisible(), "Belum ada data jenis kelamin");
        } else if (text.equalsIgnoreCase("Kamu ada di daftar tunggu. Kami akan hubungi jika ada kamar kosong.")) {
            Assert.assertTrue(kostDetail.isSucceSubmitWLTextDisplayed(), "room is available");
        }

    }

    @And("teannt/user click button {string} on popup validation")
    public void userClickButtonOnPopupValidation(String button) {
        if (button.equalsIgnoreCase("Saya mengerti")) {
            kostDetail.clickOnSayaMengertiButton();
        } else if (button.equalsIgnoreCase("Buka profil saya")) {
            kostDetail.clickBukaProfile();
        }
    }

    @Then("tenant should reach booking form")
    public void tenantShouldReachBookingForm() {
        Assert.assertTrue(bookingForm.getPengajuanSewatext(), "Pengajuan Sewa");
    }

    @Then("tenant can see peraturan kost with {string}")
    public void tenantCanSeePeraturanKostWithX(String text) {
        Assert.assertTrue(kostDetail.getPeraturanKosDisinitext(text));
    }

    @Then("tenant can succes waiting list submitted with {string}")
    public void tenantCanSeeSuccessWaitingListSubmitedWithX(String text) {
        Assert.assertTrue(kostDetail.waitingListInformationText(text));
    }

    @Then("tenant cannot see {string} as kost name and kost location")
    public void tenantCannotSeeAsKostNameAndKostLocation(String kosName) {
        assertFalse(kostDetail.isKostNameAndLocationAbsence(kosName), "Kost is present!");
    }

    @Then("tenant verify the confirmation cancel booking pop up")
    public void tenantVerifyTheConfirmationCancelBookingPopUp() {
        Assert.assertTrue(kostDetail.getTextOnPopUp("Pengajuan sewa belum terkirim"));
        Assert.assertTrue(kostDetail.getTextOnPopUp("Jika tidak lanjut, kamu tetap bisa cek pengajuan kos ini di Draft"));
    }

    @And("user click on pilih {string} informasi penyewa")
    public void userClickOnPilihInformasiPenyewa(String indexToClick) {
        kostDetail.clickOnPilihInformasiPenyewa(indexToClick);
    }

    @Then("user will see it has job name")
    public void userWillSeeHaveJobName() {
        kostDetail.userWillSeeHaveJobName();
    }

    @And("user want to upload ID verification")
    public void user_want_to_upload_id_verification() throws InterruptedException {
        kostDetail.uploadIdVerification();
    }

    @When("user click Notifikasi on header")
    public void userClickNotifikasiOnHeader() {
        kostDetail.clickNotifikasiOnHeader();
    }

    @When("user click on toggle foto kartu identitas")
    public void user_click_on_toggle_foto_kartu_identitas() {
        kostDetail.clickOnToggleFotoKartuIdentitas();
    }

    @When("user click on toggle jatuh tempo")
    public void user_click_on_toggle_jatuh_tempo() {
        kostDetail.clickOnToggleJatuhTempo();
    }

    @And("tenant click on close waiting list button")
    public void tenantClickOnCloseWaitingListButton() {
        kostDetail.clickCloseWaitingListButton();
    }

    @Then("tenant see today's date and cannot make booking")
    public void tenantCannotBookingToday() {
        kostDetail.dismissFTUE();
        kostDetail.dateCannotBooking();
    }

    @Then("tenant can choose checkin date in the next {string} month")
    public void tenantCanCheckInNextMonth(String month) {
        kostDetail.dismissFTUE();
        kostDetail.tenantCanCheckInNextMonth(month);
    }

    @Then("tenant can choose checkin date in the next {string} week")
    public void tenantCanCheckInNextWeek(String week) {
        kostDetail.dismissFTUE();
        kostDetail.tenantCanCheckInNextWeek(week);
    }

    @Then("tenant cant see {string} on booking form")
    public void tenant_cant_see_on_booking_form(String text) {
        Assert.assertFalse(bookingForm.getCatatanTambahan(text), "appears fasilitas tambahan");
    }

    @Then("tenant can see {string} on booking form")
    public void tenant_can_see_on_booking_form(String text) {
        bookingForm.getCatatanTambahan(text);
    }

    @And("tenant input catatan tambahan with {string}")
    public void tenant_input_catatan_tambahan_with(String text) {
        bookingForm.inputCatatanTambahan(text);
    }

    @Then("tenant can see allert addfee")
    public void tenant_can_see_allert_addfee() {
        Assert.assertTrue(bookingForm.getSummaryBookingForm(), "not appears allert addfee");
    }

    @And("tenant click on pilih tambahan on booking form")
    public void tenant_click_on_booking_form() {
        bookingForm.clickTambahBarangButton();
    }

    @When("tenant click on ubah tambahan barang on booking form")
    public void tenant_click_on_ubah_tambahan_barang_on_booing_form() {
        bookingForm.clickUbahFasilitas();
    }

    @When("tenant choose biaya tambahan {string} on booking form")
    public void tenant_choose_biaya_tambahan_on_booking_form(String text) {
        bookingForm.clickAddfeeList(text);
    }

    @And("tenant click on save button")
    public void tenant_click_on_save_button() {
        bookingForm.clickSimpanButton();
    }

    @And("tenant click on chat pemilik")
    public void tenant_click_on_vhat_pemilik() {
        bookingForm.clickChatPemilikButton();
    }

    @Then("tenant can see tenant description with {string}")
    public void tenant_can_see_description_with(String text) {
        Assert.assertEquals(bookingForm.getDeskriptionDiri(), text, "description diri is different");
    }

    @And("tenant search apart then go to apartemen details:")
    public void tenantSearchApartThenGoToApartemenDetails(DataTable table) {
        searchApart = table.asMaps(String.class, String.class);
        var apartName = searchApart.get(0).get("apart name " + Mamikos.ENV);
        searchPO = homePO.clickOnSearchButton();
        kostDetail = searchPO.searchByText(apartName);
        apartDetail.waitTillApartDetailPageVisible();
    }

    @Then("tenant can see {string} section")
    public void tenantCanSeeSection(String voucherName) {
        Assert.assertEquals(kostDetail.getVoucherText(voucherName), voucherName, "Voucher is not displayed");
    }

    @And("tenant click on {string} section")
    public void tenantClickOnSection(String voucherName) {
        kostDetail.clickONVoucher(voucherName);
    }

    @Then("tenant can see voucher list")
    public void tenantCanSeeVoucherList() {
        Assert.assertTrue(kostDetail.isVoucherListVisible(), "Voucher list is not displayed");
    }

    @And("tenant click on close icon")
    public void tenantClickOnCloseIcon() {
        kostDetail.clickCloseIcon();
    }

    @Then("tenant can not see voucher list")
    public void tenantCanNotSeeVoucherList() {
        Assert.assertFalse(kostDetail.isVoucherListVisible(), "Voucher list is displayed");
    }

    @And("tenant click on lihat detail button")
    public void tenantClickOnLihatDetailButton() {
        kostDetail.clickOnLihatDetailButton();
    }

    @Then("tenant can see voucher detail with {string}")
    public void tenantCanSeeVoucherDetailWith(String voucherName) {
        Assert.assertEquals(kostDetail.getVoucherName(voucherName), voucherName, "Voucher name is not displayed");
    }

    @Then("tenant can not see {string} section")
    public void tenantCanNotSeeSection(String voucherName) {
        Assert.assertFalse(kostDetail.isVoucherTextVisible(voucherName), "Voucher name is displayed");
    }

    @Then("tenant can see toast message {string}")
    public void tenantCanSeeToastMessage(String toastMessage) {
        Assert.assertEquals(kostDetail.getToastSuccess(), toastMessage, "Toast message is not displayed");
    }

    @Then("tenant not see room limit alert")
    public void tenant_not_see_room_limit_alert() {
        Assert.assertFalse(bookingForm.isRoomLimitAlertDisplayed());
    }

    @Then("tenant can see room limit alert")
    public void tenant_can_see_room_limit_alert() {
        Assert.assertTrue(bookingForm.isRoomLimitAlertDisplayed());
        Assert.assertEquals(bookingForm.getRoomLimitAlertText(),"Sisa n kamar, jangan sampai kehabisan!");
    }
}