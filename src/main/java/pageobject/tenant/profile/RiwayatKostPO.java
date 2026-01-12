package pageobject.tenant.profile;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class RiwayatKostPO {
    Page page;
    PlaywrightHelpers playwright;
    Locator reviewKostCardEmpty;
    Locator reviewKostTitle;
    Locator closeButtonReviewKost;
    Locator yesKeluarButton;
    Locator lihatDetailButton;
    Locator lihatFasilitasButton;
    Locator closeButton;
    Locator lihatRiwayatTransaksiButton;
    Locator kembaliKeBookingButton;
    Locator bookingUlangButton;
    Locator bookingFormTitle;
    Locator emptyStateTitleRiwayatKos;
    Locator emptyStateSubtitleRiwayatKos;
    Locator reviewKostSayaTitle;
    Locator titleReview;
    Locator ajukanBerhentiSewaButton;
    Locator berhentiSewaButtonPopup;

    Locator ajukanBerhentiSewaButtonAfterReviewKos;
    Locator kirimFormButton;
    Locator sayaMengertiButton;
    Locator ajukanSewaTitle;
    Locator reviewPage;
    Locator konfirmAjukanBerhentiSewaButton;
    Locator titleKostReviewSubmitted;
    Locator starsKostReviewSubmitted;

    Locator reviewKebersihan;
    Locator reviewFasilitasKamar;
    Locator reviewFasilitasUmum;
    Locator reviewKesesuaianHarga;
    Locator reviewKeamanan;
    Locator reviewKenyamanan;
    Locator kirimButton;
    Locator fillReviewKost;
    Locator closePopUpButton;
    Locator kostReviewEntryPointNotDisplayed;
    Locator reasonRadioButton;
    Locator subreasonRadioButton;

    //----------tiki taka----------//
    Locator bankNameButton;
    Locator accountNumber;
    Locator accountOwnerName;
    Locator stopRentContractText;


    public RiwayatKostPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        reviewKostCardEmpty = page.getByText("Bagaimana pengalaman ngekosmu?").first();
        reviewKostTitle = page.getByText("Yuk, kasih review untuk kos yang kamu sewa");
        closeButtonReviewKost = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tutup"));
        yesKeluarButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Keluar"));
        lihatDetailButton = page.locator("div.history-kost-card:nth-child(1) > a");
        lihatFasilitasButton = page.getByText("Lihat Fasilitas");
        closeButton = page.locator("#bookingModalFacilities").getByTitle("Tutup");
        lihatRiwayatTransaksiButton = page.getByText("Lihat Riwayat Transaksi");
        kembaliKeBookingButton = page.locator("a").filter(new Locator.FilterOptions().setHasText("Kembali ke Booking"));
        bookingUlangButton = page.locator("div.detail-action-buttons > a > button").first();
        bookingFormTitle = page.getByTestId("booking-request-form__container").getByText("Pengajuan Sewa", new Locator.GetByTextOptions().setExact(true));
        emptyStateTitleRiwayatKos = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Belum Ada Kos"));
        emptyStateSubtitleRiwayatKos = page.getByText("Semua kos yang pernah kamu sewa di Mamikos nantinya akan muncul di halaman ini.");
        reviewKostSayaTitle = page.locator(".user-review-card--flexbox > div");
        titleReview = page.getByText("Yuk, kasih review untuk kos yang kamu sewa");
        ajukanBerhentiSewaButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ajukan berhenti sewa"));
        ajukanBerhentiSewaButtonAfterReviewKos = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ajukan Berhenti Sewa").setExact(true));
        kirimFormButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kirim form ke pemilik"));
        sayaMengertiButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Saya Mengerti"));
        ajukanSewaTitle = page.locator(".user-review-card--flexbox > div");
        konfirmAjukanBerhentiSewaButton = page.locator(".bg-c-button--primary");
        titleKostReviewSubmitted = page.locator("//p[@class=\"user-review-card--reviewed__text bg-c-text bg-c-text--label-2\"]");
        starsKostReviewSubmitted = page.locator("p.bg-c-text--body-1:nth-child(2)");
        reviewKebersihan = page.locator("span:nth-child(5) > .bg-c-icon").first();
        reviewKeamanan = page.locator("div:nth-child(2) > .star-row > div > .star-container > span:nth-child(5) > .bg-c-icon");
        reviewKenyamanan = page.locator("div:nth-child(3) > .star-row > div > .star-container > span:nth-child(5) > .bg-c-icon");
        reviewFasilitasKamar = page.locator("div:nth-child(4) > .star-row > div > .star-container > span:nth-child(5) > .bg-c-icon");
        reviewFasilitasUmum = page.locator("div:nth-child(5) > .star-row > div > .star-container > span:nth-child(5) > .bg-c-icon");
        reviewKesesuaianHarga = page.locator("div:nth-child(6) > .star-row > div > .star-container > span:nth-child(5) > .bg-c-icon");
        kirimButton = page.locator(".bg-c-button--primary");
        fillReviewKost = page.getByPlaceholder("Ceritakan pengalamanmu di sini");
        closePopUpButton = page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText("close")).nth(1);
        kostReviewEntryPointNotDisplayed = page.locator("//div[@id='contentBox']");
        bankNameButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih bank dropdown-down"));
        accountNumber = page.getByPlaceholder("Masukkan nomor rekening");
        accountOwnerName = page.getByPlaceholder("Masukkan nama pemilik rekening");
        berhentiSewaButtonPopup = page.locator("//button[contains(@class, 'bg-c-button--tertiary') and contains(@class, 'bg-c-button--lg')]");
        stopRentContractText = page.locator("//*[@data-testid=\"userKostModalStopRent-contract\"]");
    }

    /**
     * Click review kost card when user not review kos yet
     */
    public void clickReviewKos() {
        playwright.clickOn(reviewKostCardEmpty);
    }

    /**
     * Is review kost page present
     */
    public boolean isReviewKostPagePresent(){
        return reviewKostTitle.isVisible();
    }

    /**
     * This method also use on :
     * - Click close button on review kost page
     * - Click close button on Lihat Fasilitas page
     */
    public void clickCloseRiviewKost() {
        playwright.clickOn(closeButtonReviewKost);
        playwright.waitTillLocatorIsVisible(yesKeluarButton);
        playwright.clickOn(yesKeluarButton);
    }

    /**
     * Click on Lihat Detail button on riwayat kost
     */
    public void clickLihatDetail() {
        playwright.clickOn(lihatDetailButton);
    }

    /**
     * Click Lihat Fasilitas on Riwayat Kost detail
     */
    public void clickLihatFasilitas() {
        playwright.clickOn(lihatFasilitasButton);
    }

    /**
     * Click close on facility popup
     */
    public void clickCloseFacility() {
       playwright.clickOn(closeButton);
    }

    /**
     * Click Lihat Riwayat Transaksi on Riwayat Kost detail
     */
    public void clickLihatRiwayatTransaksi() {
        playwright.clickOn(lihatRiwayatTransaksiButton);
    }

    /**
     * Click Kembali ke Booking
     */
    public void clickKembaliKeBooking() {
        playwright.clickOn(kembaliKeBookingButton);
    }

    /**
     * Click booking ulang on riwayat kost detail
     */
    public void clickBookingUlang() {
        playwright.pageScrollUntilElementIsVisible(bookingUlangButton);
        playwright.clickOn(bookingUlangButton);
    }

    /**
     * Is title Booking form present
     */
    public boolean isTitleBookingFormPresent(){
        return bookingFormTitle.isVisible();
    }

    /**
     * Get empty state title at Riwayat kos
     */
    public String getEmptyStateTitle(){
        return playwright.getText(emptyStateTitleRiwayatKos);
    }

    /**
     * Get empty state subtitle at Riwayat kos
     */
    public boolean isEmptyStateSubtitlePresent(){
        return emptyStateSubtitleRiwayatKos.isVisible();
    }

    /**
     * Get Riwayat Kos Review title Text
     *
     * @return string "Bagaimana pengalaman ngekosmu?"
     */
    public String getTitleRiwayatKosReviewText(){
        return playwright.getText(reviewKostCardEmpty);
    }

    /**
     * Get Kost saya title Text
     *
     * @return string "Bagaimana pengalaman ngekosmu?" on kost saya page
     */
    public String getTitleKosSayaText(){
        return playwright.getText(reviewKostSayaTitle);
    }

    /**
     * Get Review title Text
     *
     * @return string "Tulis review kamu lebih lanjut"
     */
    public String getTitleReviewText(){
        return playwright.getText(titleReview);
    }

    /**
     * Click Ajukan Berhenti Sewa text
     *
     */
    public void clickAjukanBerhentiSewaText() {
        playwright.waitTillPageLoaded();
        playwright.waitTillLocatorIsVisible(ajukanBerhentiSewaButton, 20000.0);
        playwright.pageScrollInView(ajukanBerhentiSewaButton);
        playwright.clickOn(ajukanBerhentiSewaButton);

        if (playwright.waitTillLocatorIsVisible(berhentiSewaButtonPopup, 5000.0)) {
            playwright.clickOn(berhentiSewaButtonPopup);
        }
    }

    /**
     * Get Ajukan sewa title Text
     *
     * @return string title ajukan sewa
     */
    public String getTitleAjukanSewaText(){
        return playwright.getText(ajukanSewaTitle);
    }

    /**
     * Click on Ajukan Sewa Title
     *
     */
    public void clickAjukanSewaTitle() {
        playwright.clickOn(ajukanSewaTitle);
    }

    /**
     * Get Text of Review Title by index
     * @param index - index review title
     * @return text of Review Page
     */
    public String getAllReviewPage (int index){
        reviewPage = page.locator("//*[contains(@data-path, 'lbl')]");
        return playwright.getText(reviewPage.nth(index));
    }

    /**
     * Verify button Ajukan Berhenti Sewa is disabled
     * @return true if disabled
     */
    public boolean isAjukanBerhentiSewaButtonDisabled() {
        return konfirmAjukanBerhentiSewaButton.isDisabled();
    }

    /**
     * Get Kost Review Submitted Text
     *
     * @return string "Kamu memberikan nilai:"
     */
    public String getTitleKostReviewSubmittedText(){
        return playwright.getText(titleKostReviewSubmitted);
    }

    /**
     * Get Kost Review Submitted Stars Amount
     *
     * @return string "3"
     */
    public String getStarsKostReviewSubmittedText(){
        return playwright.getText(starsKostReviewSubmitted);
    }

    /**
     * Verify Kost Review entry point is not displayed
     * @return boolean
     */
    public Boolean isKostReviewEntryPointNotDisplayed() {
        return playwright.waitTillLocatorIsVisible(kostReviewEntryPointNotDisplayed, 2000.0);
    }

    /**
     * Click reason Ajukan Berhenti Sewa text and subreason
     * @param reason
     * @param subreason
     */
    public void clickReasonStopRent(String reason, String subreason) {
        reasonRadioButton = page.getByText(reason);
        playwright.clickOn(reasonRadioButton);
        if (!subreason.equalsIgnoreCase("-")) {
            subreasonRadioButton = page.getByText(subreason);
            playwright.clickOn(subreasonRadioButton);
        }
    }

    /**
     * Click star kebersihan in review kos
     *
     */
    public void clickReviewKebersihan() {
        playwright.clickOn(reviewKebersihan);
    }

    /**
     * Click star keamanan in review kos
     *
     */
    public void clickReviewKeamanan() {
        playwright.clickOn(reviewKeamanan);
    }

    /**
     * Click star kenyamanan in review kos
     *
     */
    public void clickReviewKenyamanan() {
        playwright.clickOn(reviewKenyamanan);
    }

    /**
     * Click star fasilitas kamar in review kos
     *
     */
    public void clickReviewFasilitasKamar() {
        playwright.clickOn(reviewFasilitasKamar);
    }

    /**
     * Click star fasilitas kamar in review kos
     *
     */
    public void clickReviewFasilitasUmum() {
        playwright.clickOn(reviewFasilitasUmum);
    }

    /**
     * Click star kesesuaian harga in review kos
     *
     */
    public void clickReviewKesesuaianHarga() {
        playwright.clickOn(reviewKesesuaianHarga);
    }

    /**
     * Click kirim button in review kos
     *
     */
    public void clickKirimButton() {
        playwright.clickOn(kirimButton);
        playwright.clickOn(closePopUpButton);
    }

    /**
     * fill review in review kos
     *
     */
    public void fillReviewKost(String reviewText) {
        playwright.pageScrollUntilElementIsVisible(fillReviewKost);
        fillReviewKost.fill(reviewText);
    }
    /**
     * Click Ajukan Berhenti Sewa text
     *
     */
    public void clickAjukanBerhentiSewaTextAfterReviewKos() {
        playwright.pageScrollUntilElementIsVisible(ajukanBerhentiSewaButtonAfterReviewKos);
        playwright.clickOn(ajukanBerhentiSewaButtonAfterReviewKos);
        playwright.clickOn(kirimFormButton);
        playwright.clickOn(sayaMengertiButton);
    }

    /**
     * click Ajukan berhenti sewa button only
     */
    public void clickAjukanBerhentiSewaButton(){
        playwright.clickOn(ajukanBerhentiSewaButtonAfterReviewKos);
    }

    /**
     * verify bank account field
     * @param text
     * @return text example: Nama bank
     */
    public boolean validateBankAccount(String text){
        Locator getBankAccountText = page.getByText(""+text+"");
        return getBankAccountText.isVisible();
    }

    /**
     * validate data on confirmation popup terminated contdact
     * @param text
     * @return text example BCA
     */
    public boolean validateConfirmationPopupAccount(String text){
        Locator popupAccountText = page.locator("//*[@class=\"bg-u-mt-sm bg-u-radius-lg bg-c-card bg-c-card--lined bg-c-card--sm bg-c-card--light\"]//p[contains(text(), '"+text+"')]");
        return popupAccountText.isVisible();
    }

    /**
     * click button on popup confirmation
     * @param text example Kembali ke form
     */
    public void clickButtonOnPopup(String text){
        Locator popupAccountButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(""+text+""));
        playwright.clickOn(popupAccountButton);
    }

    /**
     * validate berhenti sewa popup
     * @param text example Sayang banget kalau kamu berhenti sewa sekarang
     * @return text
     */
    public boolean validateBerhentiSewaPopup(String text){
        Locator berhentiSewaText = page.locator("//*[contains(text(),'"+text+"')]");
        return playwright.waitTillLocatorIsVisible(berhentiSewaText);
    }

    /**
     * click berhenti sewa popup
     */
    public void clickBerhentiSewaButtonOnPopup(){
        playwright.clickOn(berhentiSewaButtonPopup);
    }

    /**
     * validate stop rent contract text on berhenti sewa page
     * @return text
     */
    public boolean getStopRentContract(){
        return playwright.waitTillLocatorIsVisible(stopRentContractText);
    }
}
