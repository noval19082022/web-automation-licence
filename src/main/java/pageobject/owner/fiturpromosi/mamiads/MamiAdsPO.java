package pageobject.owner.fiturpromosi.mamiads;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import pageobject.common.ModalPopUpPO;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

import java.util.regex.Pattern;

public class MamiAdsPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private LocatorHelpers locatorHelpers;
    private ModalPopUpPO modalPopUpPO;

    //--- Saldo Mamiads Onboarding ---//
    private Locator saldoMamiadsCard;

    //--- history Mamiads ---//
    Locator lastInvoiceOnRiwayat;
    Locator riwayatSaldoMamiads;
    Locator backIconRiwayatMamiads;
    private Locator invoiceMamiads;
    //--- Mamiads Webview Page ---//
    private Locator cobaSekarangBtnOnWebview;
    //--- Mamiads Page ---//
    private Locator cobaSekarangBtnOnPopUp;
    private Locator warningIconBanner;
    private Locator closeBtnWarningBanner;
    private Locator lihatInfoLanjutWarningBanner;
    private Locator beliSaldoBtn;
    private Locator titleEmptyFilterText;
    private Locator messageEmptyFilterText;
    private Locator titleSelesaiRiwayatSaldoText;
    private Locator titleDalamProsesRiwayatSaldoText;
    private Locator paduanMamiadsBackButton;
    private Locator cobaSekarangButtonHeader;
    private Locator saldoTitleName;
    private Locator saldoTitleActualPrice;
    private Locator selectSaldoList;
    private Locator buySaldoBtnList;
    private Locator saldoAmountFirstIndex;
    Locator kamarPenuhText;
    private Locator beliSaldoBtnPopupToggle;
    private Locator continuePaymentBuySaldoMamiads;
    private Locator balanceListContainer;
    private Locator robustBalanceListContainer;
    private Locator promosikanIklanAnda;
    private Locator radioButtons;
  
    //--- Mamiads popup ubah anggaran  ---//
    private Locator saldoMaksimalRadioButton;
    private Locator dibatasiHarianRadioButton;
    private Locator ubahAnggaranInputText;
    private Locator yaGantiButton;
    private Locator beliSaldoBtnPopup;
    Locator simpanPengaturanButton;

    //--- Beli Saldo Mamiads Page ----//
    private Locator countHistoryIcon;
    private Locator detailTagihanSection;
    private Locator unselectedGoldplus;
    private Locator selectedGoldplus;
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
    private Locator lihatDetailVoucher;
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
        this.modalPopUpPO = new ModalPopUpPO(page);
        //--- Saldo Mamiads Onboarding ---//
        this.saldoMamiadsCard = page.locator(".mamiads-card");
        //--- history Mamiads ---//
        this.invoiceMamiads = page.locator("//div[contains(@class, 'transaction')]//a | //div[contains(text(), 'Saldo')] | //*[@data-testid='invoice-link'] | //button[contains(text(), 'Invoice')] | //a[contains(@href, 'invoice')]").first();
        lastInvoiceOnRiwayat = page.locator("//div[@class='transaction-on-process']//div[12]/a[1]");
        riwayatSaldoMamiads = page.getByText("Riwayat");
        backIconRiwayatMamiads = page.locator("a").filter(new Locator.FilterOptions().setHasText("back"));
        //--- Mamiads Webview Page ---//
        this.cobaSekarangBtnOnWebview = playwright.locatorByRoleAndText(AriaRole.BUTTON, "Coba Sekarang").first();
        //--- Mamiads Page ---//
        this.cobaSekarangBtnOnPopUp = playwright.locatorByRoleAndText(AriaRole.BUTTON, "Coba Sekarang");
        this.warningIconBanner = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("warning-triangle-glyph"));
        this.closeBtnWarningBanner = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("close"));
        this.lihatInfoLanjutWarningBanner = page.getByText("Lihat Info lanjut");
        this.beliSaldoBtn = page.getByText("Beli Saldo", new Page.GetByTextOptions().setExact(true));
        this.titleEmptyFilterText = page.locator(".bg-c-empty-state__title");
        this.messageEmptyFilterText = page.locator(".bg-c-empty-state__description");
        this.titleSelesaiRiwayatSaldoText = page.locator("#my-ads-done").getByText("Belum Ada Transaksi");
        this.titleDalamProsesRiwayatSaldoText = page.locator("#my-ads").getByText("Belum Ada Transaksi");
        this.paduanMamiadsBackButton = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("back"));
        this.cobaSekarangButtonHeader = page.locator(".mami-ads-navbar__main-nav-button");
        this.beliSaldoBtnPopupToggle = page.locator("#button-right-modal-toggle-confirm-beli-saldo");
        this.saldoTitleName = page.locator("//p[contains(text(), 'ribu') or contains(text(), 'juta')]");
        this.saldoTitleActualPrice = page.locator("//p[starts-with(text(), 'Rp')]");
        this.selectSaldoList = page.locator(".bg-c-radio__icon > span");
        this.buySaldoBtnList = playwright.locatorByRoleAndText(AriaRole.BUTTON, "Pilih Saldo");
        this.saldoAmountFirstIndex = page.locator(".bg-c-radio__icon > span").first();
        this.continuePaymentBuySaldoMamiads = page.locator("(//a[@class='clickable-history-list'])[1]");
        this.balanceListContainer = page.locator(".balance-list__container");
        this.robustBalanceListContainer = page.locator(".balance-list__container");
        this.promosikanIklanAnda = page.locator("//img[@alt='Icon Promote']");
        this.radioButtons = page.locator("input[type='radio']");
        //--- Mamiads popup ubah anggaran  ---//
        this.ubahAnggaranInputText = page.getByTestId("mamiadsDashboard-inputDailyBudget");
        this.saldoMaksimalRadioButton = page.locator("label").filter(new Locator.FilterOptions().setHasText("Saldo Maksimal")).locator("span").nth(1);
        this.dibatasiHarianRadioButton = page.locator("label").filter(new Locator.FilterOptions().setHasText("Dibatasi Harian")).locator("span").nth(1);
        this.yaGantiButton = page.getByText("Ya, Ganti", new Page.GetByTextOptions().setExact(true));
        this.beliSaldoBtnPopup = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Beli Saldo"));
        simpanPengaturanButton = page.getByText("Simpan Pengaturan");
        //--- Beli Saldo Mamiads Page ---//
        this.countHistoryIcon = page.locator(".history-icon__counter");
        this.detailTagihanSection = page.locator(".purchase-detail__header");
        this.unselectedGoldplus = page.locator("(//button[normalize-space()='Ditambahkan'])[1]");
        this.selectedGoldplus = page.locator("(//button[normalize-space()='Tambahkan'])[1]");

        //--- voucher owner ---//
        this.inputVoucher = page.getByTestId("masukkan_link");
        this.inputVoucherPopUp = page.locator("#wrapper-scroll").getByTestId("masukkan_link");
        this.voucherCodeField = page.getByTestId("codeVoucher_txt");
        this.pakaiVoucherButton = page.getByTestId("pakaiVoucher_btn");
        this.warningMessageVoucher = page.getByTestId("warning_txt");
        this.icnButtonCLose = page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^close$"))).getByRole(AriaRole.BUTTON);
        this.messageOnOffVoucher = page.locator("//*[@class='bg-c-toast__content']");
        this.deleteVoucher = page.getByTestId("hapusVoucher_link");
        this.listElement = page.locator(".scroll-element__item > div:nth-of-type(4) .c-container__left");
        this.lihatDetailVoucher = page.getByTestId("lihatDetailvoucher_btn").first();

        //--- Jemput Bola Entry Point ---//
        this.entryPointJBSection = page.locator("(//div[@class='mami-ads-statistic-main'])[1]");
        this.labelNewJemputBola = page.getByTestId("mamiadsStatistic").getByText("Baru");

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
     *
     * @return String data type
     */
    public String getGpOnboardingpopUpTextHead() {
        return playwright.getText(gpOnboardingPopUpActiveTextHead);
    }

    /**
     * Get gp onboarding pop up text body
     *
     * @return String data type
     */
    public String getGpOnboardingpopUpTextBody() {
        return playwright.getText(gpOnboardingPopUpActiveTextBody);
    }

    /**
     * Get gp onboarding pop up image alt attribute value
     *
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
     * Check if gp onboarding pop up previous button is disabled
     *
     * @return boolean data type
     */
    public boolean isGpOnboardingpopUpPreviousButtonDisabled() {
        return gpOnboardingPopUpPreviousButton.getAttribute("disabled") != null;
    }

    /**
     * Check if gp onboarding pop up next button is disabled
     *
     * @return boolean data type
     */
    public boolean isGpOnboardingpopUpNextButtonDisabled() {
        return gpOnboardingPopUpNextButton.getAttribute("disabled") != null;
    }

    /**
     * Click on gp onboarding pop up swiper bullet
     */
    public void clickGpOnboardingpopUpPreviousButton() {
        playwright.clickOn(gpOnboardingPopUpPreviousButton);
    }

    /**
     * Click on saldo mamiads card
     */
    public void clickSaldoMamiadsCard() {
        playwright.waitTillLocatorIsVisible(saldoMamiadsCard, 15000.0);
        playwright.clickOn(saldoMamiadsCard);
        playwright.waitTillPageLoaded();
    }

    /**
     * Handle popup and button clicks when owner visits Mamiads page.
     * This method addresses the conditions when a popup appears on the page visited by the owner.
     * If the onboarding popup is visible (detected by 'Coba Sekarang' button), close it.
     */
    public void handlePopupMamiAds() {
        // Check if the 'Coba Sekarang' button on the popup is visible (indicates onboarding popup is shown)
        if (playwright.isLocatorVisibleAfterLoad(cobaSekarangBtnOnPopUp, 5000.0)) {
            playwright.clickOn(cobaSekarangBtnOnPopUp);
            playwright.hardWait(1000);
        } else if (playwright.waitTillLocatorIsVisible(icnButtonCLose, 5000.0)) {
            playwright.clickOn(icnButtonCLose);
        }
    }

    /**
     * Check if favorit saldo is displayed
     *
     * @return true if element present otherwise false
     */
    public boolean favoriteSaldo(String saldo) {
        return playwright.isTextDisplayed(saldo, 5000.0);
    }

    /**
     * Get list saldo price, price in rupiah, discount, discount price
     *
     * @param index input with listSaldo
     * @return String saldo price, price in rupiah, discount, discount price
     */
    public String listSaldo(String listSaldo, int index) {
        String element = "";
        System.out.println(getBalanceListSnapshot());
        switch (listSaldo) {
            case "priceTitle":
                element = "//p[contains(text(), 'ribu') or contains(text(), 'juta')]";
                break;
            case "priceInRp":
                element = "//p[starts-with(text(), 'Rp')]";
                break;
            case "disc":
                element = ".bg-u-text-red-600";
                break;
            case "priceStrike":
                element = ".bg-u-text-neutral-400";
                break;
        }
        return playwright.getText(playwright.getLocators(page.locator(element)).get(index));
    }

    /**
     * this method will be clickOn beli saldo btn on the mamiads page 'https://owner-jambu.kerupux.com/mamiads'
     * and this method also handle if pop up is appear on mamiads page
     */
    public void clickOnBeliSaldoBtn() {
        // Wait for page to be loaded first
        playwright.waitTillPageLoaded(10000.0);

        // this condition will handle for pop up that appear when owner visit https://owner-jambu.kerupux.com/mamiads
        if (playwright.waitTillLocatorIsVisible(cobaSekarangBtnOnPopUp, 5000.0))
            playwright.clickOn(cobaSekarangBtnOnPopUp);

        // Click beliSaldo button if visible (may already be on balance page)
        if (playwright.waitTillLocatorIsVisible(beliSaldoBtn, 5000.0))
            playwright.clickOn(beliSaldoBtn);
    }

    /**
     * buy saldo on mamiads saldo page
     *
     * @param saldo you should use ex. 'Rp6.000'
     */
    public void choosingSaldoToBuy(String saldo) {
        // Use robust waiting strategy to ensure page is fully loaded
        waitForBalanceListToLoad();
        
        // Extract just the numeric value from the input (e.g., "Rp80.000" -> "80000")
        String saldoNumeric = formatCurrencyForProcessing(saldo);
        
        // For "Rp80.000", we need to find the radio button for 80 ribu
        // Based on browser inspection, 80k is at index 4 (0-based: 10k=0, 30k=1, 50k=2, 75k=3, 80k=4)
        int indexToClick = -1;
        
        if (saldoNumeric.equals("80000")) {
            indexToClick = 3; // 80 ribu option
        } else if (saldoNumeric.equals("10000")) {
            indexToClick = 0; // 10 ribu option
        } else if (saldoNumeric.equals("30000")) {
            indexToClick = 1; // 30 ribu option
        } else if (saldoNumeric.equals("150000")) {
            indexToClick = 4; // 50 ribu option
        } else if (saldoNumeric.equals("75000")) {
            indexToClick = 2; // 75 ribu option
        } else {
            // Default to first option (10 ribu)
            indexToClick = 0;
        }
        
        // Click on the radio button with additional wait for element to be clickable
        playwright.waitFor(selectSaldoList.nth(indexToClick), 5000.0);
        playwright.clickOn(selectSaldoList.nth(indexToClick));
        
        // Wait for button to become enabled and click it
        playwright.waitTillLocatorIsVisible(buySaldoBtnList);
        playwright.clickOn(buySaldoBtnList);
    }

    /**
     * buy saldo with GP or not GP on mamiads saldo page
     */
    public void selectGoldplusOrunSelectGoldplus(String goldplus) {
        switch (goldplus) {
            case "notBuyGP":
                playwright.clickOn(unselectedGoldplus);
                break;
            case "buyGP":
                playwright.clickOn(selectedGoldplus);
                break;
            default:
                System.out.println("Parameter goldplus = " + goldplus);
        }
    }

    /**
     * this method is use for if owner redirect to mamiads webview
     * example page is 'https://jambu.kerupux.com/mamiads?redirectionSource=Owner%20Dashboard'
     */
    public void handleRedirectToMamiadsWebview() {
        // this condition will handle if owner redirect to the https://jambu.kerupux.com/mamiads?redirectionSource=Owner%20Dashboard
        if (playwright.getActivePageURL().equals(Mamikos.URL + "/mamiads?redirectionSource=Owner%20Dashboard"))
            playwright.clickOn(cobaSekarangBtnOnWebview);
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
     *
     * @return String title
     */
    public String getTitleText() {
        playwright.waitFor(titleEmptyFilterText);
        return playwright.getText(titleEmptyFilterText);
    }

    /**
     * Get message empty filter text
     * ex: Iklan properti Anda akan naik ke posisi yang lebih tinggi pada hasil pencarian.
     *
     * @return String title
     */
    public String getMessageText() {
        playwright.waitFor(messageEmptyFilterText);
        return playwright.getText(messageEmptyFilterText);
    }

    /**
     * Get Title text on Selesai Tab on Riwayat Saldo
     *
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
    public String getTitleDalamProsesText() {
        playwright.waitFor(titleDalamProsesRiwayatSaldoText);
        return playwright.getText(titleDalamProsesRiwayatSaldoText);
    }

    /**
     * Get count riwayat beli saldo
     *
     * @return int countHistoryIcn
     */
    public int getCountRiwayatBeliSaldo() {
        String countText = playwright.waitTillLocatorIsVisible(countHistoryIcon, 3000.0)
            ? playwright.getText(countHistoryIcon)
            : null;
        return countText != null && !countText.isEmpty() ? Integer.parseInt(countText) : 0;
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
     */
    public void clickOnPanduanMamiAdsBackButton() {
        playwright.clickOn(paduanMamiadsBackButton);
    }

    /**
     * Get coba sekarang button at header
     */
    public boolean isCobaSekarangButtonHeaderisDisplayed() {
        return playwright.waitTillLocatorIsVisible(cobaSekarangButtonHeader, 1000.0);
    }

    /**
     * Click On Text Question
     *
     * @param
     * @return
     */
    public void clickOnQuestionText(String questionText) throws InterruptedException {
        playwright.pageScrollUsingCoordinate(5, 5);
        String questionTextLocator = "//p[contains(.,'" + questionText + "')]";
        playwright.waitTillLocatorIsVisible(page.locator(questionTextLocator), 1000.0);
        playwright.clickOn(page.locator(questionTextLocator));

    }

    /**
     * Get Text Answer
     *
     * @param answerText
     * @return answerText
     */
    public String getAnswerText(String answerText) {
        String answerTextLocator = "//p[contains(.,'" + answerText + "')]";
        playwright.waitTillLocatorIsVisible(page.locator(answerTextLocator));
        return playwright.getText(page.locator(answerTextLocator));
    }

    /**
     * Navigates to Mamiads History page
     */
    public void navigatesToMamiadsHistory() {
        playwright.waitTillPageLoaded();
        playwright.navigateTo(Mamikos.OWNER_URL + Mamikos.MAMIADS_HISTORY, 30000.0, LoadState.LOAD);
    }

    /**
     * Navigates to Mamiads page
     */
    public void navigatesToMamiads() {
        playwright.navigateTo(Mamikos.OWNER_URL + Mamikos.MAMIADS, 50000.0, LoadState.LOAD);
    }

    /**
     * Navigates to pembelian saldo Mamiads page
     */
    public void navigatesToMamiadsBalance() {
        playwright.navigateTo(Mamikos.OWNER_URL + Mamikos.TOP_UP_MAMIADS, 30000.0, LoadState.LOAD);
        playwright.bringPageToView(page);
        
        // Ensure balance list loads properly after navigation
        waitForBalanceListToLoad();
    }

    /**
     * Get detail tagihan
     *
     * @param validasi <p> 1 = Nominal Saldo
     *                 <p> 2 = Total Pembayaran
     *                 <p> 3 = Status Transaksi
     * @return String
     */
    public String gettransactionList(int validasi) {
        String element = "";
        switch (validasi) {
            case 1:
                element = "//*[@class='transaction-done'] //*[@class='left-side-saldo-status']";
                break;
            case 2:
                element = "//*[@class='transaction-done'] //*[@class='right-side-saldo-status']";
                break;
            case 3:
                element = "//*[@class='right-side-payment-status-paid']";
                break;
        }
        playwright.waitTillLocatorIsVisible(page.locator(element).first());
        return playwright.getNormalizeText(page.locator(element).first());
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
     *
     * @param voucherCode
     */
    public void inputVoucherCode(String voucherCode) {
        playwright.fill(voucherCodeField, voucherCode);
    }

    /**
     * Click pakai voucher button
     *
     * @throws InterruptedException
     */
    public void clickOnPakaiVoucherButton() throws InterruptedException {
        playwright.clickOn(pakaiVoucherButton.first());
    }

    /**
     * Get message warning invalid input voucher
     *
     * @return warning message
     */
    public String getMessageWarningVoucher() {
        return playwright.getText(warningMessageVoucher);
    }

    /**
     * Clear voucher code text field
     */
    public void clearVoucherCode() {
        playwright.clearText(voucherCodeField);
    }

    /**
     * Clear voucher code text field
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
        voucherTitleElement = page.locator("//div[.='" + voucherTitle + "']");
        return playwright.waitTillLocatorIsVisible(voucherTitleElement, 5000.0);
    }

    /**
     * Click lihat detail voucher from suggestion list
     */
    public void clickLihatDetailOnVoucherOnList() throws InterruptedException {
        playwright.waitTillLocatorIsVisible(lihatDetailVoucher);
        playwright.clickOn(lihatDetailVoucher);
    }

    /**
     * Verify detail voucher
     *
     * @return voucherTitle, voucherCode, voucherExpired, voucherTnC
     */
    public String detailVoucher(String detailVoucher, int index) {
        String element = "";
        switch (detailVoucher) {
            case "voucherTitle":
                element = ".c-voucher__title";
                break;
            case "voucherCode":
                element = ".c-voucher__code";
                break;
            case "voucherExpired":
                element = ".c-voucher__expired";
                break;
            case "voucherTnC":
                element = ".tnc";
                break;
        }
        return playwright.getText(playwright.getLocators(page.locator(element)).get(index));
    }

    /**
     * Get message on toast voucher dihapus or dipakai
     *
     * @return toast message
     */
    public String getTextMessageToastVoucher() {
        playwright.waitTillLocatorIsVisible(messageOnOffVoucher, 10000.0);
        return playwright.getText(messageOnOffVoucher);
    }

    /**
     * Click on delete voucher
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
     * Click on invoice mamiads on history mamiads
     */
    public void clickOnInvoiceMamiads() {
        playwright.clickOn(invoiceMamiads);
    }

    /**
     * click on ubah button on spesific listing
     *
     * @param adsName refres to listing name
     */
    public void clickOnUbahbutton(String adsName) {
        String ubahButton = "//div[@class='mami-ads-widget']/div[contains(.,'" + adsName + "')]//a";
        var locator = page.locator(ubahButton).first();
        playwright.clickOn(locator);
    }

    /**
     * Click coba sekarang header on mamiads onboard page
     */
    public void clickOnCobaSekarangHeader() {
        if (playwright.waitTillLocatorIsVisible(cobaSekarangButtonHeader)) {
        playwright.clickOn(cobaSekarangButtonHeader);
         }
    }
    /**
     * clear and type new daily anggaran MA
     *
     * @param anggaran refers to how much daily anggaran wanna spent
     */
    public void inputNominalAnggaran(String anggaran) {
        playwright.clearText(ubahAnggaranInputText);
        playwright.fill(ubahAnggaranInputText, anggaran);
    }

    /**
     * get text posisi iklan on spesific listing
     *
     * @param adsName
     * @param adsPosition
     * @return ads position text
     */
    public String getPosisiIklan(String adsName, String adsPosition) {
        String textPosisiIklan = "//p[normalize-space()='"+adsName+"']/../..//following-sibling::*//div[@id='ads-position-" + adsPosition + "']";
        playwright.waitTillLocatorIsVisible(page.locator(textPosisiIklan));
        return playwright.getText(page.locator(textPosisiIklan));
    }

    /**
     * check toggle ads based on listing name
     *
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
     *
     * @param adsName
     * @return status description text
     */
    public String getAdsStatusDesc(String adsName) {
        System.out.println("LUBIS");
        String textStatusDesc = "//*[.='" + adsName + "']/../../following-sibling::*//div[@id='ads-status-description']";
        playwright.waitTillLocatorIsVisible(page.locator(textStatusDesc));
        return playwright.getText(page.locator(textStatusDesc));
    }

    /**
     * get text anggaran description on spesific listing
     *
     * @param adsName
     * @return anggaran desciption text
     */
    public String getTextAnggaranDesc(String adsName) {
        String textAnggaranDesc = "//*[.='" + adsName + "']/../../following-sibling::*//div[@id='ads-allocation-description']";
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
     *
     * @return message full occupancy
     * @params adsName
     */
    public String isFullOcuppancyActiveAds(String adsName) {
        System.out.println("RAMOSAN");
        kamarPenuhText = page.locator("//*[.='" + adsName + "']/../../following-sibling::*//div[@class='ads-status__kamar-penuh']");
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
        Locator titleJemputBola = page.locator("//*[text()='" + adsName + "']/ancestor::div[@data-testid='mamiadsWidget']" +
                "//*[@data-testid='mamiadsStatistic']//p[contains(@class,'title')]");
        playwright.assertVisible(titleJemputBola);
    }

    /**
     * check entry point on jemput bola subtitle
     */
    public void isSubtitleJemputBolaVisible(String adsName) {
        Locator subtitleJemputBola = page.locator("//*[text()='" + adsName + "']/ancestor::div[@class='mami-ads-widget']" +
                "//*[@class='mami-ads-statistic-main']//p[contains(@class,'desc')]");
        playwright.assertVisible(subtitleJemputBola);
    }

    /**
     * check is it label visible or not
     *
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
     *
     * @return text on popup
     */
    public String getTextOnPoUpVisible(String textOnPopUp) {
        Locator textOnPopUpMamiads = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName(textOnPopUp));
        playwright.waitFor(textOnPopUpMamiads);
        return playwright.getText(textOnPopUpMamiads);
    }

    public Page clickInvoiceMamiadsOnRiwayat() {
        page = page.waitForPopup(() -> {
            playwright.clickOn(lastInvoiceOnRiwayat);
            playwright.waitTillPageLoaded(50000.0);
        });
        ActiveContext.setActivePage(page);
        return ActiveContext.getActivePage();
    }

    public void clickRiwayatMamiAds() {
        playwright.clickOn(riwayatSaldoMamiads);
    }

    public Page clickBackIconOnRiwayatMamiads() {
        playwright.clickOn(backIconRiwayatMamiads);
        ActiveContext.setActivePage(page);
        return ActiveContext.getActivePage();
    }

    /**
     * Click on Simpan Pengaturan button on pop up ubah anggaran
     */
    public void clickOnSimpanPengaturanUbahAnggaran() {
        playwright.clickOn(simpanPengaturanButton);
    }


    // ----------------- PART OF PRIVATE METHOD -----------------

    private String formatCurrencyForProcessing(String saldo) {
        return saldo
                .replace("Rp", "")
                .replace(".", "");
    }

    /**
     * Click on beli saldo with status menunggu pembayaran
     */
    public void userContinuePaymentBuySaldoMamiads() {
        playwright.clickOn(continuePaymentBuySaldoMamiads);
    }

    public boolean warningBannerIsOccured() {
        return playwright.waitTillLocatorIsVisible(warningIconBanner);
    }

    public void closeWarningBanner() {
        playwright.clickOn(closeBtnWarningBanner);
    }

    public void clickOnLihatInfoLanjutWarningBanner() {
        this.page = page.waitForPopup(() -> {
            playwright.clickOn(lihatInfoLanjutWarningBanner);
        });
    }

    /**
     * Get aria snapshot of the balance list container
     * Useful for accessibility testing and debugging of the balance list section
     * 
     * @return String representation of the balance list container's accessibility tree
     */
    public String getBalanceListSnapshot() {
        return playwright.getAriaSnapshot(balanceListContainer);
    }

    /**
     * Wait for balance list container to load with robust waiting strategy
     * This method addresses the flaky test issue where the page sometimes shows blank/white
     * Uses multiple fallback strategies and content verification to ensure page is fully loaded
     */
    public void waitForBalanceListToLoad() {
        // Dismiss popup if present using ModalPopUpPO
        if (modalPopUpPO.isModalCloseIconVisible()) {
            modalPopUpPO.clicksModalCloseIcon();
            playwright.hardWait(1000);
        }
        
        // Wait for page to be fully loaded
        playwright.waitTillPageLoaded(15000.0);
        playwright.waitTillDomContentLoaded(10000.0);
        
        // Try primary locator first
        if (playwright.isLocatorVisibleAfterLoad(balanceListContainer, 3000.0)) {
            // Verify content is actually loaded by checking for key elements
            if (playwright.isTextDisplayed("Saldo Iklan", 2000.0) && 
                playwright.isTextDisplayed("Harga", 2000.0)) {
                return; // Success - page loaded with content
            }
        }

        playwright.waitFor(radioButtons.first(), 10000.0);

        // Ensure "Favorit" text is visible (indicates 150k option loaded)
        playwright.isTextDisplayed("Favorit", 5000.0);
    }

    /**
     * Click on Promosikan Iklan Anda on homepage
     */
    public void clickOnPromosikanIklanAnda() {
        playwright.waitTillLocatorIsVisible(promosikanIklanAnda);
        playwright.clickOn(promosikanIklanAnda);
    }
}

