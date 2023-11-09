package pageobject.owner.mamiads;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

public class MamiAdsPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private LocatorHelpers locatorHelpers;
    //--- Saldo Mamiads Onboarding ---//
    private Locator saldoMamiadsCard;
    //--- history Mamiads ---//
    private  Locator invoiceMamiads;
    //--- Mamiads Page ---//
    private Locator cobaSekarangBtnOnPopUp;
    private Locator beliSaldoBtn;
    private Locator titleEmptyFilterText;
    private Locator messageEmptyFilterText;
    private Locator titleSelesaiRiwayatSaldoText;
    private Locator titleDalamProsesRiwayatSaldoText;
    private Locator paduanMamiadsBackButton;
    private Locator cobaSekarangButtonHeader;
    //--- Beli Saldo Mamiads Page ----//
    private Locator bayarSekarangBtnOnDetailTagihan;
    private Locator countHistoryIcon;
    private Locator detailTagihanSection;
    //--- voucher ---//
    private Locator inputVoucher;
    private Locator inputVoucherPopUp;
    private Locator voucherCodeField;
    private Locator pakaiVoucherButton;
    private Locator warningMessageVoucher;
    private Locator icnButtonCLose;
    private Locator messageOnOffVoucher;
    private Locator deleteVoucher;
    private Locator listElement;
    private Locator voucherTitleElement;



    //--- GP Onboarding Pop - Up ---//
    Locator gpOnboardingPopUpActiveCounter;
    Locator gpOnboardingPopUpActiveTextHead;
    Locator gpOnboardingPopUpActiveTextBody;
    Locator gpOnboardingPopUpActiveImage;
    Locator gpOnboardingPopUpNextButton;
    Locator gpOnboardingPopUpSwipperBullet;
    Locator gpOnboardingPopUpPreviousButton;
    //--- GP Onboarding Pop - Up ---//

    public MamiAdsPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.locatorHelpers = new LocatorHelpers(page);
        //--- Saldo Mamiads Onboarding ---//
        this.saldoMamiadsCard = page.locator(".mamiads-card");
        //--- history Mamiads ---//
        this.invoiceMamiads = page.locator("//div[@class='transaction-done']/div[@class='transaction-available']/div[1]//span[@class='right-side-saldo-status']");
        //--- Mamiads Page ---//
        this.cobaSekarangBtnOnPopUp = playwright.locatorByRoleAndText(AriaRole.BUTTON, "Coba Sekarang");
        this.beliSaldoBtn = page.getByText("Beli Saldo");
        this.titleEmptyFilterText = page.locator(".bg-c-empty-state__title");
        this.messageEmptyFilterText = page.locator(".bg-c-empty-state__description");
        this.titleSelesaiRiwayatSaldoText = page.locator("#my-ads-done").getByText("Belum Ada Transaksi");
        this.titleDalamProsesRiwayatSaldoText = page.locator("#my-ads").getByText("Belum Ada Transaksi");
        this.paduanMamiadsBackButton = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("back"));
        this.cobaSekarangButtonHeader = page.locator(".mami-ads-navbar__main-nav-button");
        //--- Beli Saldo Mamiads Page ---//
        this.bayarSekarangBtnOnDetailTagihan = playwright.locatorByRoleAndText(AriaRole.BUTTON, "Bayar Sekarang");
        this.countHistoryIcon = page.locator(".history-icon__counter");
        this.detailTagihanSection = page.locator(".purchase-detail__header");

        //--- voucher owner ---//
        this.inputVoucher = page.getByTestId("masukkan_link");
        this.inputVoucherPopUp = page.locator("#wrapper-scroll").getByTestId("masukkan_link");
        this.voucherCodeField = page.getByTestId("codeVoucher_txt");
        this.pakaiVoucherButton =  page.getByTestId("pakaiVoucher_btn");
        this.warningMessageVoucher = page.getByTestId("warning_txt");
        this.icnButtonCLose = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("close"));
        this.messageOnOffVoucher = page.locator("//*[@class='bg-c-toast__content']");
        this.deleteVoucher = page.getByTestId("hapusVoucher_link");
        this.listElement = page.locator(".scroll-element__item > div:nth-of-type(4) .c-container__left");

        //--- GP Onboarding Pop - Up ---//
        gpOnboardingPopUpActiveCounter = page.locator(".swiper-slide-active .gp-swiper__slide-counter");
        gpOnboardingPopUpActiveTextHead = page.locator(".swiper-slide-active .gp-swiper__slide-text p:nth-child(1)");
        gpOnboardingPopUpActiveTextBody = page.locator(".swiper-slide-active .gp-swiper__slide-text p:nth-child(2)");
        gpOnboardingPopUpActiveImage = page.locator(".swiper-slide-active img");
        gpOnboardingPopUpNextButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next slide"));
        gpOnboardingPopUpSwipperBullet = page.locator(".swiper-pagination-bullet");
        gpOnboardingPopUpPreviousButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Previous slide"));
    }

    /**
     * Get gp onboarding pop up active counter
     *
     * @return Integer data type
     */
    public int getGpOnboardingpopUpActiveCounter() {
        return Integer.parseInt(gpOnboardingPopUpActiveCounter.innerText());
    }

    /**
     * Get gp onboarding pop up text head
     * @return String data type
     */
    public String getGpOnboardingpopUpTextHead() {
        return playwright.getText(gpOnboardingPopUpActiveTextHead);
    }

    /**
     * Get gp onboarding pop up text body
     * @return String data type
     */
    public String getGpOnboardingpopUpTextBody() {
        return playwright.getText(gpOnboardingPopUpActiveTextBody);
    }

    /**
     * Get gp onboarding pop up image alt attribute value
     * @return String data type
     */
    public String getGpOnboardingpopUpImageAltAttributeValue() {
        return playwright.getAttributeValue(gpOnboardingPopUpActiveImage, "alt");
    }

    /**
     * Click on gp onboarding pop up next button
     */
    public void clickGpOnboardingpopUpNextButton() {
        playwright.clickOn(gpOnboardingPopUpNextButton);
    }

    /**
     * Get gp onboarding pop up swiper bullet count
     * @return Integer data type
     */
    public boolean isGpOnboardingpopUpPreviousButtonDisabled() {
        return playwright.getAttributeValue(gpOnboardingPopUpPreviousButton, "aria-disabled").equals("true");
    }

    /**
     * Get gp onboarding pop up swiper bullet count
     * @return Integer data type
     */
    public boolean isGpOnboardingpopUpNextButtonDisabled() {
        return playwright.getAttributeValue(gpOnboardingPopUpNextButton, "aria-disabled").equals("true");
    }

    /**
     * Click on gp onboarding pop up swiper bullet
     */
    public void clickGpOnboardingpopUpPreviousButton() {
        playwright.clickOn(gpOnboardingPopUpPreviousButton);
    }

    /**
     * owner buy mamiads saldo,
     * This method is only valid for owners who have purchased saldo at Mamiads.
     *
     * @param saldo String
     */
    public void purchaseOwnerSaldoFromMamiads(String saldo) {
        playwright.clickOn(saldoMamiadsCard);
        handlePopupMamiAds();
        clickOnBeliSaldoBtn();
        choosingSaldoToBuy(saldo);
        playwright.clickOn(bayarSekarangBtnOnDetailTagihan);
    }

    /**
     * Handle popup and button clicks when owner visits Mamiads page.
     * This method addresses the conditions when a popup appears on the page visited by the owner.
     * If the 'Coba Sekarang' button on the popup is visible or the 'Beli Saldo' button is not visible,
     * the method clicks on the 'Coba Sekarang' button.
     */
    public void handlePopupMamiAds() {
        // Check if the 'Coba Sekarang' button on the popup is visible
        // OR if the 'Beli Saldo' button is not visible
        if (playwright.waitTillLocatorIsVisible(cobaSekarangBtnOnPopUp)
                || !playwright.waitTillLocatorIsVisible(beliSaldoBtn)) {
            playwright.clickOn(cobaSekarangBtnOnPopUp);
        }
    }

    /**
     * this method will be clickOn beli saldo btn on the mamiads page 'https://owner-jambu.kerupux.com/mamiads'
     */
    public void clickOnBeliSaldoBtn() {
        playwright.clickOn(beliSaldoBtn);
    }

    /**
     * buy saldo on mamiads saldo page
     *
     * @param saldo you should use ex. 'Rp6.000'
     */
    public void choosingSaldoToBuy(String saldo) {
        playwright.clickOn(page.locator("//*[contains(text(),'" + saldo + "')]/following-sibling::button"));
    }

    /**
     * click on filter Semua Iklan on mamiads page
     */
    public void clickOnSemuaIklan() {
        playwright.clickOnText("Semua Iklan");
    }

    /**
     * click on filter Iklan Nonaktif on mamiads page
     */
    public void clickOnIklanNonaktif() {
        playwright.clickOnText("Iklan Nonaktif");
    }

    /**
     * Get title text
     * ex: Semua Iklan Anda Sudah Naik
     * @return String title
     */
    public String getTitleText(){
        playwright.waitFor(titleEmptyFilterText);
        return playwright.getText(titleEmptyFilterText);
    }

    /**
     * Get message empty filter text
     * ex: Iklan properti Anda akan naik ke posisi yang lebih tinggi pada hasil pencarian.
     * @return String title
     */
    public String getMessageText() {
        playwright.waitFor(messageEmptyFilterText);
        return playwright.getText(messageEmptyFilterText);
    }

    /**
     * Get Title text on Selesai Tab on Riwayat Saldo
     * @return String title
     */
    public String getTitleSelesaiText() {
        playwright.waitFor(titleSelesaiRiwayatSaldoText);
        return playwright.getText(titleSelesaiRiwayatSaldoText);
    }

    /**
     * Get Title text on Dalam Proses Tab on Riwayat Saldo
     *
     * @return String title
     */
    public String getTitleDalamProsesText(){
        playwright.waitFor(titleDalamProsesRiwayatSaldoText);
        return playwright.getText(titleDalamProsesRiwayatSaldoText);
    }

    /**
     * Get count riwayat beli saldo
     * @return int countHistoryIcn
     */
    public int getCountRiwayatBeliSaldo(){
        return Integer.parseInt(playwright.getText(countHistoryIcon));
    }

    /**
     * check if detail tagihan is present
     *
     * @return true if appears detail tagihan
     */
    public boolean isDetailTagihanPresent() {
        detailTagihanSection.waitFor();
        return playwright.waitTillLocatorIsVisible(detailTagihanSection);
    }

    /**
     * Click on bayar sekarang button and wait until page loaded
     */
    public void clicksOnBayarSekarangButton() {
        playwright.clickOn(bayarSekarangBtnOnDetailTagihan);
        playwright.waitTillPageLoaded();
    }


    /**
     * Click on Panduan MamiAds Back Button
     *
     */
    public void clickOnPanduanMamiAdsBackButton() {
        playwright.clickOn(paduanMamiadsBackButton);
    }

    /**
     * Get coba sekarang button at header
     *
     */
    public boolean isCobaSekarangButtonHeaderisDisplayed() {
        return playwright.waitTillLocatorIsVisible(cobaSekarangButtonHeader,1000.0);
    }

    /**
     * Click On Text Question
     *
     * @return
     * @param
     */
    public void clickOnQuestionText(String questionText) throws InterruptedException {
        playwright.pageScrollUsingCoordinate(5,5);
        String questionTextLocator = "//p[contains(.,'" + questionText + "')]";
        playwright.waitTillLocatorIsVisible(page.locator(questionTextLocator),1000.0);
        playwright.clickOn(page.locator(questionTextLocator));

    }

    /**
     * Get Text Answer
     *
     * @return answerText
     * @param answerText
     */
    public String getAnswerText(String answerText) {
        String answerTextLocator = "//p[contains(.,'" + answerText + "')]";
        return playwright.getText(page.locator(answerTextLocator));
    }

    /**
     * Navigates to Mamiads History page
     */
    public void navigatesToMamiadsHistory() {
        playwright.navigateTo(Mamikos.OWNER_URL + Mamikos.MAMIADS_HISTORY, 30000.0, LoadState.LOAD);
    }

    /**
     * Navigates to Mamiads page
     */
    public void navigatesToMamiads() {
        playwright.navigateTo(Mamikos.OWNER_URL + Mamikos.MAMIADS, 30000.0, LoadState.LOAD);
        playwright.bringPageToView(page);
    }
    /**
     * Get detail tagihan
     * @param validasi
     *  <p> 1 = Nominal Saldo
     *  <p> 2 = Total Pembayaran
     *  <p> 3 = Status Transaksi
     * @return String
     */
    public String gettransactionList(int validasi){
        String element = "";
        switch (validasi){
            case 1 : element = "//*[@class='transaction-done'] //*[@class='left-side-saldo-status']"; break;
            case 2 : element = "//*[@class='transaction-done'] //*[@class='right-side-saldo-status']"; break;
            case 3 : element = "//*[@class='right-side-payment-status-paid']"; break;
        }
        playwright.waitTillLocatorIsVisible(page.locator(element).first());
        return playwright.getText(page.locator(element).first());
    }

    /**
     * Click on masukkan voucher mamiAds
     */
    public void clickOnInputVoucher() {
       playwright.clickOn(inputVoucher);
       playwright.clickOn(inputVoucherPopUp);
    }


    /**
     * Input voucher code
     * @param voucherCode
     *
     */
    public void inputVoucherCode(String voucherCode) {
       playwright.fill(voucherCodeField,voucherCode);
    }

    /**
     * Click pakai voucher button
     * @throws InterruptedException
     *
     */
    public void clickOnPakaiVoucherButton() throws InterruptedException {
       playwright.clickOn(pakaiVoucherButton);
    }

    /**
     * Get message warning invalid input voucher
     * @return warning message
     *
     */
    public String getMessageWarningVoucher() {
        return playwright.getText(warningMessageVoucher);
    }

    /**
     * Clear voucher code text field
     *
     */
    public void clearVoucherCode() {
        playwright.clearText(voucherCodeField);
    }

    /**
     * Clear voucher code text field
     *
     */
    public void clickOnCLosePopUpVoucher() {
        playwright.clickOn(icnButtonCLose);
    }

    /**
     * Verify Voucher is present on list
     *
     * @return true or false
     */
    public boolean isVoucherPresentOnList(String voucherTitle) {
         voucherTitleElement = page.locator( "//div[.='" + voucherTitle + "']");
        return playwright.waitTillLocatorIsVisible(voucherTitleElement,1000.0);
    }
    /**
     * Click pakai or lihat detail voucher from suggestion list
     *
     */
    public void clickOnVoucherOnList(String element) throws InterruptedException {
        playwright.waitTillLocatorIsVisible(page.locator(element));
       playwright.clickOn(page.locator(element));
    }

    /**
     * Verify detail voucher
     *
     * @return voucherTitle, voucherCode, voucherExpired, voucherTnC
     */
    public String detailVoucher(String detailVoucher, int index) {
        String element = "";
        switch (detailVoucher) {
            case "voucherTitle"  : element = ".c-voucher__title"; break;
            case "voucherCode"   : element = ".c-voucher__code"; break;
            case "voucherExpired": element = ".c-voucher__expired"; break;
            case "voucherTnC"    : element = ".tnc"; break;
        }
        return playwright.getText(playwright.getLocators(page.locator(element)).get(index));
    }
    /**
     * Get message on toast voucher dihapus or dipakai
     *
     * @return toast message
     */
    public String getTextMessageToastVoucher() {
        playwright.waitTillLocatorIsVisible(messageOnOffVoucher,1000.0);
        return playwright.getText(messageOnOffVoucher);
    }

    /**
     * Click on delete voucher
     *
     */
    public void clickOnDeleteVoucher() throws InterruptedException {
        playwright.clickOn(deleteVoucher);
    }

    /**
     * Click on masukkan voucher for accsess voucher list
     */
    public void clickOnInputVoucherList() {
        playwright.clickOn(inputVoucher);
    }

    /**
     *Click on invoice mamiads on history mamiads
     */
    public void clickOnInvoiceMamiads(){
        playwright.clickOn(invoiceMamiads);
    }
}

