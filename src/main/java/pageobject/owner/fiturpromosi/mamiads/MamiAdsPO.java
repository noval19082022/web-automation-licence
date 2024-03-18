package pageobject.owner.fiturpromosi.mamiads;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
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
    Locator kamarPenuhText;
    private Locator beliSaldoBtnPopupToggle;

    //--- Mamiads popup ubah anggaran  ---//
    private Locator saldoMaksimalRadioButton;
    private Locator dibatasiHarianRadioButton;
    private Locator ubahAnggaranInputText;
    private Locator yaGantiButton;
    private Locator beliSaldoBtnPopup;
    //--- Beli Saldo Mamiads Page ----//
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
    //--- Jemput Bola Entry Point ---//
    private Locator entryPointJBSection;
    private Locator labelNewJemputBola;

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
        this.beliSaldoBtn = page.getByText("Beli Saldo", new Page.GetByTextOptions().setExact(true));
        this.titleEmptyFilterText = page.locator(".bg-c-empty-state__title");
        this.messageEmptyFilterText = page.locator(".bg-c-empty-state__description");
        this.titleSelesaiRiwayatSaldoText = page.locator("#my-ads-done").getByText("Belum Ada Transaksi");
        this.titleDalamProsesRiwayatSaldoText = page.locator("#my-ads").getByText("Belum Ada Transaksi");
        this.paduanMamiadsBackButton = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("back"));
        this.cobaSekarangButtonHeader = page.locator(".mami-ads-navbar__main-nav-button");
        this.beliSaldoBtnPopupToggle = page.locator("#button-right-modal-toggle-confirm-beli-saldo");
        //--- Mamiads popup ubah anggaran  ---//
        this.ubahAnggaranInputText = page.getByTestId("mamiadsDashboard-inputDailyBudget");
        this.saldoMaksimalRadioButton = page.locator("label").filter(new Locator.FilterOptions().setHasText("Saldo Maksimal")).locator("span").nth(1);
        this.dibatasiHarianRadioButton = page.locator("label").filter(new Locator.FilterOptions().setHasText("Dibatasi Harian")).locator("span").nth(1);
        this.yaGantiButton = page.getByText("Ya, Ganti", new Page.GetByTextOptions().setExact(true));
        this.beliSaldoBtnPopup = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Beli Saldo"));
        //--- Beli Saldo Mamiads Page ---//
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
        //--- Jemput Bola Entry Point ---//
        this.entryPointJBSection = page.locator("(//div[@class='mami-ads-statistic-main'])[1]");
        this.labelNewJemputBola = page.getByText("Baru");

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

    public void clickSaldoMamiadsCard(){
        playwright.clickOn(saldoMamiadsCard);
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
        if (playwright.isLocatorVisibleAfterLoad(cobaSekarangBtnOnPopUp, 3000.0)
                || !playwright.isLocatorVisibleAfterLoad(icnButtonCLose, 3000.0)) {
            playwright.clickOn(icnButtonCLose);
        }
    }

    /**
     * Check if favorit saldo is displayed
     * @return true if element present otherwise false
     */
    public boolean favoriteSaldo (String saldo){
        return playwright.isTextDisplayed(saldo, 5000.0);
    }

    /**
     * Get list saldo price, price in rupiah, discount, discount price
     * @param index input with listSaldo
     * @return String saldo price, price in rupiah, discount, discount price
     */
    public String listSaldo (String listSaldo, int index){
        String element = "";
        switch (listSaldo){
            case "price"     : element = ".balance-list-item__name"; break;
            case "priceInRp" : element = ".balance-list-item__price"; break;
            case "disc"      : element = ".percentage"; break;
            case "discPrice" : element = ".amount"; break;
        }
        return playwright.getText(playwright.getLocators(page.locator(element)).get(index));
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
        playwright.waitTillPageLoaded();
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
        playwright.waitTillLocatorIsVisible(beliSaldoBtn, 5000.0);
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
        playwright.navigateTo(Mamikos.OWNER_URL + Mamikos.MAMIADS, 50000.0, LoadState.LOAD);
        playwright.bringPageToView(page);
    }

    /**
     * Navigates to pembelian saldo Mamiads page
     */
    public void navigatesToMamiadsBalance() {
        playwright.navigateTo(Mamikos.OWNER_URL + Mamikos.TOP_UP_MAMIADS, 30000.0, LoadState.LOAD);
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

    /**
     * click on ubah button on spesific listing
     * @param adsName refres to listing name
     */
    public void clickOnUbahbutton(String adsName) {
        String ubahButton = "//div[@class='mami-ads-widget']/div[contains(.,'" + adsName + "')]//a";
        playwright.clickOn(page.locator(ubahButton));
    }

    /**
     *  Click coba sekarang header on mamiads onboard page
     */
    public void clickOnCobaSekarangHeader() {
        playwright.clickOn(cobaSekarangButtonHeader);
    }

    /**
     * clear and type new daily anggaran MA
     * @param anggaran refers to how much daily anggaran wanna spent
     */
    public void inputNominalAnggaran(String anggaran) {
        playwright.clearText(ubahAnggaranInputText);
        playwright.fill(ubahAnggaranInputText, anggaran);
    }

    /**
     * get text posisi iklan on spesific listing
     * @param adsName
     * @param adsPosition
     * @return ads position text
     */
    public String getPosisiIklan(String adsName, String adsPosition) {
        String textPosisiIklan = "//*[.='" + adsName + "']/../..//following-sibling::*//div[@id='ads-position-" + adsPosition + "']";
        playwright.waitTillLocatorIsVisible(page.locator(textPosisiIklan));
        return playwright.getText(page.locator(textPosisiIklan));
    }

    /**
     * check toggle ads based on listing name
     * @param adsName
     * @param toggleStatus
     */
    public void getToggleStaus(String adsName, String toggleStatus) {
        String toggleStatusLocator = "//*[.='" + adsName + "']/../../following-sibling::*//input[@id='room-toggle-switch-" + toggleStatus + "']";
        playwright.waitTillLocatorIsVisible(page.locator(toggleStatusLocator));
        playwright.assertVisible(page.locator(toggleStatusLocator));
    }

    /**
     * get text status description on spesific listing
     * @param adsName
     * @return status description text
     */
    public String getAdsStatusDesc(String adsName) {
        System.out.println("LUBIS");
        String textStatusDesc= "//*[.='" + adsName + "']/../../following-sibling::*//div[@id='ads-status-description']";
        playwright.waitTillLocatorIsVisible(page.locator(textStatusDesc));
        return playwright.getText(page.locator(textStatusDesc));
    }

    /**
     * get text anggaran description on spesific listing
     * @param adsName
     * @return anggaran desciption text
     */
    public String getTextAnggaranDesc(String adsName) {
        String textAnggaranDesc= "//*[.='" + adsName + "']/../../following-sibling::*//div[@id='ads-allocation-description']";
        playwright.waitTillLocatorIsVisible(page.locator(textAnggaranDesc));
        return playwright.getText(page.locator(textAnggaranDesc));
    }

    /**
     * click on saldo maksimal radio button
     */
    public void clickOnSaldoMaksimal() {
        playwright.clickOn(saldoMaksimalRadioButton);
    }

    /**
     * click on dibatasi harian radio button
     */
    public void clickOnDibatasiHarian() {
        playwright.clickOn(dibatasiHarianRadioButton);
    }

    /**
     * click on ya, ganti confirmation ubah anggaran button
     */
    public void clickOnYaGantiButton() {
        playwright.clickOn(yaGantiButton);
    }

    /**
     * click on Beli saldo on popup saldo < 5000
     */
    public void clickOnBeliSaldoOnPopup() {
        playwright.clickOn(beliSaldoBtnPopup);
    }

    /**
     * Verify the description full occupancy
     * @return message full occupancy
     * @params adsName
     */
    public String isFullOcuppancyActiveAds(String adsName) {
        System.out.println("RAMOSAN");
        kamarPenuhText = page.locator("//*[.='"+adsName+"']/../../following-sibling::*//div[@class='ads-status__kamar-penuh']");
        return playwright.getText(kamarPenuhText).replaceAll("[\\n\\s]+", " ");

    }

    /**
     * click on Beli saldo on popup saldo toggle
     */
    public void clickOnBeliSaldoOnPopupToggle() {
        playwright.clickOn(beliSaldoBtnPopupToggle);
    }

    /**
     * check entry point on jemput bola title
     */
    public void isTitleJemputBolaVisible(String adsName) {
        Locator titleJemputBola = page.locator("//*[text()='"+ adsName +"']/../../..//*[@class='mami-ads-statistic-main']//p[contains(@class,'title')]");
        playwright.assertVisible(titleJemputBola);
    }

    /**
     * check entry point on jemput bola subtitle
     */
    public void isSubtitleJemputBolaVisible(String adsName) {
        Locator subtitleJemputBola = page.locator("//*[text()='"+ adsName +"']/../../..//*[@class='mami-ads-statistic-main']//p[contains(@class,'desc')]");
        playwright.assertVisible(subtitleJemputBola);
    }

    /**
     * check is it label visible or not
     * @return boolean
     */
    public boolean isLabelNewJBVisible() {
        return playwright.waitTillLocatorIsVisible(labelNewJemputBola);
    }

    /**
     * click on entry point jemput bola
     */
    public void clickOnEntryPointJB() {
        playwright.clickOn(entryPointJBSection);
    }

    /**
     * Verify the visibility of text on the popup
     * @return text on popup
     */
    public String getTextOnPoUpVisible(String textOnPopUp) {
        Locator textOnPopUpMamiads = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName(textOnPopUp));
        playwright.waitFor(textOnPopUpMamiads);
        return playwright.getText(textOnPopUpMamiads);
    }
}

