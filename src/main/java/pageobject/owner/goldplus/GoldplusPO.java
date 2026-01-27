package pageobject.owner.goldplus;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import data.mamikos.Mamikos;
import utilities.PlaywrightHelpers;

import java.util.List;

public class GoldplusPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private static String saldoMamiads, totalPembayaran;
    Locator broadcastChatBtn;
    Locator warningBroadcastText;
    Locator closePopUpIcon;
    Locator recurringPhoneNumberInput;
    Locator selectRecurringPeriod;
    Locator editPackageAdminGP1Button;
    Locator editPackageAdminGP2Button;
    Locator selectRadioButtonNo;
    Locator selectRadioButtonYes;
    Locator messageText;
    Locator lihatTagihanTable;
    Locator widgetGP;
    Locator snkGoldplusCheckbox;
    Locator weeklyPeriode;
    Locator pelajariCaranyaButton;
    Locator gpPackageTable;
    Locator closePopUpDetailManfaat;
    Locator gpStatusFilter;
    Locator backFromFilter;
    Locator tagihanGPSection;
    Locator tableTagihanGP;
    Locator lihatSelengkapnyaTagihanGP;
    Locator tabSelesaiRincianBayar;
    Locator gpPackageText;
    Locator infoUntukAndaOption;
    Locator tutupListBalanceGP;
    Locator rincianMamiadsText;
    Locator saldoMamiadsText;
    Locator changeGPButton;
    Locator listGPPage;
    Locator rincianGp;
    Locator rincianMA;
    Locator rincianFee;
    Locator searchPhoneNumber;
    Locator buttonSearchContract;
    Locator detailManfaatGP1;
    Locator benefitGP;
    Locator detailManfaatGP2;
    Locator filterPaketGoldplusAnda;
    Locator closeBtn;
    Locator perpanjangButton;
    Locator gpOnboardingPopUp;
    Locator gpOnboardingNextPopUpBtn;
    Locator gpOnboardingPreviousPopUpBtn;
    Locator pilihPaketBtn;
    Locator countdownValueInMenuPackageGP;
    Locator countdownValueOwnerDashboard;
    Locator gpEntryPoint;
    Locator copyTextElement;
    Locator countdownTimer;

    //==== Popup Recurring ===//
    Locator imagePopupRecurring;
    Locator textTitlePopupRecurring;
    Locator textSubtitlePopUpRecurring;
    Locator buttonExtendGPpopUp;
    Locator gpPackageChoosed;
    Locator gpPackageRincianPembayaranDetailTagihan;
    Locator gpPeriodeChoosed;
    Locator favoritLabel;

    //==== Riwayat Goldplus ===//
    Locator selectTransactionUnpaid;
    Locator statusDetailTagihan;
    Locator sectionPackageSelected;
    Locator sectionDetailBilling;
    Locator buttonPaidDetailTagihan;
    Locator selectTranscationPaid;
    Locator selectTransactionExpired;
    Locator tabSelesaiRiwayatGP;
    Locator titleStatusPaid;

    //==== Pop Up after buy GP weekly ===//
    Locator imageGPWeeklyPopup;
    Locator titlePopUpGpWeekly;
    Locator descPopUpGpWeekyly;
    Locator buttonNantiWeekly;
    Locator buttonLihatFiturWeekly;

    // === Admin Goldplus Package === //
    Locator priceField;
    Locator saveButton;
    Locator warningMessage;
    Locator successMessage;
    Locator addPackageButton;
    Locator premiumPackageBonusField;
    Locator bundledPremiumPackageDropdown;
    Locator bundledPremiumPackageOptions;
    Locator searchIdField;
    Locator searchButton;
    Locator editPackageButton;

    //====== TBC Detail page =======//
    Locator upgradePaketBtnOnTbc;
    Locator upgradePaketBtnPopUpOnTbc;

    private Locator mamikosActionCard;
    private Locator mamiadsBalanceListContainer;
    private Locator rincianPembayaranSection;
    private Locator totalPembayaranSection;

    // === GoldPlus Period Selection Popup === //
    private Locator goldplusPeriodSelectionPopup;
    private Locator goldplusPeriodOptions;
    private Locator pilihPeriodeButton;
    private Locator periodeBerlanggananContainer;
    private Locator paketJangkaPanjangContainer;
    private Locator pilihPaketGoldplusContainer;
    private Locator activeMamiadsBalance;
    private Locator favoriteOption;


    public GoldplusPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        broadcastChatBtn = page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText("'broadcast-message'"));
        warningBroadcastText = page.locator("//h3[@class='bg-c-modal__body-title']");
        closePopUpIcon = page.locator(".bg-c-modal__action-closable");
        recurringPhoneNumberInput = page.getByPlaceholder("Phone Number").nth(2);
        selectRecurringPeriod = page.locator("[name='h']");
        editPackageAdminGP1Button = page.locator("//a[@href='https://jambu.kerupux.com/admin/gold-plus/package/148/edit#gold-plus']");
        editPackageAdminGP2Button = page.locator("//a[@href='https://jambu.kerupux.com/admin/gold-plus/package/159/edit#gold-plus']");
        selectRadioButtonNo = page.locator("[value='0'][name='is_recommended']");
        selectRadioButtonYes = page.locator("[value='1'][name='is_recommended']");
        messageText = page.locator(".bg-c-empty-state__description");
        lihatTagihanTable = page.locator("//tr[@class='goldplus-payment-list-table__row']");
        widgetGP = page.getByTestId("goldplus-card");
        snkGoldplusCheckbox =  page.locator("label");
        weeklyPeriode = page.locator(".bg-c-radio__icon").first();
        pelajariCaranyaButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Pelajari caranya"));
        gpPackageTable = page.locator(".goldplus-package-content__packages-wrapper");
        closePopUpDetailManfaat = page.locator(".bg-c-modal__action-closable");
        gpStatusFilter = page.locator(".goldplus-room-card__gp-status");
        backFromFilter = page.getByTestId("back-button");
        tagihanGPSection = page.locator("//div[@class='gold-plus-features']/div[4]");
        tableTagihanGP = page.locator("//div[@id='goldplusPaymentDone']");
        lihatSelengkapnyaTagihanGP = page.locator("//div[4]//a[.='Lihat Selengkapnya']");
        tabSelesaiRincianBayar = page.locator("//h4[.='Selesai']");
        gpPackageText = page.locator("//p[.='Jenis Pembayaran']/../../following-sibling::div");
        gpPackageText = page.getByText("Rincian Pembayaran");
        tutupListBalanceGP = page.locator(".goldplus-mamiads-detail__expand");
        rincianMamiadsText = page.locator(".bg-u-mb-md.bg-c-list-item .bg-c-text");
        saldoMamiadsText = page.locator(".bg-u-mb-md.bg-c-list-item .bg-c-list-item__description");
        changeGPButton = page.locator("//*[@class='bg-c-button bg-c-button--tertiary-naked bg-c-button--md']");
        listGPPage = page.locator("//h2[contains(.,'Paket GoldPlus')]");
        rincianGp = page.getByTestId("invoiceBillingDetails-payment").getByText("GoldPlus 1");
        rincianMA = page.locator(".collapse-content > div:nth-of-type(2) > .bg-c-text--body-2");
        rincianFee = page.getByText("Biaya Transaksi");
        searchPhoneNumber = page.getByPlaceholder("Keyword");
        buttonSearchContract = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Search"));
        detailManfaatGP1 = page.locator("a").filter(new Locator.FilterOptions().setHasText("Manfaat GoldPlus 1"));
        detailManfaatGP2 = page.locator("a").filter(new Locator.FilterOptions().setHasText("Manfaat GoldPlus 2"));
        closeBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("close"));
        imagePopupRecurring = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("business-with-goldplus"));
        textTitlePopupRecurring = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Masa aktif GoldPlus akan habis."));
        textSubtitlePopUpRecurring = page.getByText("Ayo, segera perpanjang paket GoldPlus Anda sekarang.");
        buttonExtendGPpopUp = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Perpanjang"));
        gpPackageChoosed = page.locator(".goldplus-package-detail__item-title");
        gpPackageRincianPembayaranDetailTagihan = page.locator("//p[@class='goldplus-package-detail__item-title bg-c-text bg-c-text--body-1']");
        gpPeriodeChoosed = page.locator(".goldplus-periode-select__periode-card-footer");
        favoritLabel = page.getByText("Favorit");
        selectTransactionUnpaid = page.getByTestId("goldplusPaymentUnpaid-0").getByText("Lihat Tagihan");
        sectionPackageSelected = page.locator(".goldplus-package-detail");
        sectionDetailBilling = page.locator("//div[@class='goldplus-billing-detail']/div[3]");
        buttonPaidDetailTagihan = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Bayar Sekarang Rp28.500"));
        selectTranscationPaid =  page.locator("td").filter(new Locator.FilterOptions().setHasText("Lunas"));
        selectTransactionExpired = page.locator("td").filter(new Locator.FilterOptions().setHasText("Dibatalkan"));
        tabSelesaiRiwayatGP = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Selesai"));
        titleStatusPaid = page.locator("//div[@class='bg-c-label bg-c-label--rainbow bg-c-label--rainbow-green']");
        imageGPWeeklyPopup = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("gp illustration"));
        titlePopUpGpWeekly = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Selamat bergabung di GoldPlus 1!"));
        buttonNantiWeekly = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Nanti Saja"));
        buttonLihatFiturWeekly = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat Fitur"));
        priceField = page.locator("//input[@id='price']");
        saveButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save"));
        warningMessage = page.locator("//div[@class='alert alert-danger alert-dismissable']");
        successMessage = page.locator("//div[@class='alert alert-success alert-dismissable']");
        addPackageButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add Package"));
        premiumPackageBonusField = page.locator("//label[contains(text(),'Premium Package (bonus)')]");
        bundledPremiumPackageDropdown = page.locator("//select[@name='bundled_premium_package_id']");
        bundledPremiumPackageOptions = page.locator("//select[@name='bundled_premium_package_id']/option");
        searchIdField = page.locator("//input[@name='id']");
        searchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search"));
        editPackageButton = page.locator("//table//tbody//tr[1]//a[contains(@href, '/edit')]");
        upgradePaketBtnOnTbc = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Upgrade Paket"));
        upgradePaketBtnPopUpOnTbc = page.getByTestId("tenant-background-checker-modal-upgrade-gp").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Upgrade Paket"));
        perpanjangButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Perpanjang"));
        gpOnboardingPopUp = page.getByTestId("goldplus-onboarding-feature");
        gpOnboardingNextPopUpBtn = page.getByTestId("goldplus-onboarding-feature").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Next slide"));
        gpOnboardingPreviousPopUpBtn = page.getByTestId("goldplus-onboarding-feature").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Previous slide"));
        pilihPaketBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih Paket GoldPlus"));
        countdownValueInMenuPackageGP = page.locator("//div[@class='counter-promo']");
        countdownValueOwnerDashboard = page.getByTestId("popperReference").getByTestId("countdown-container");
        gpEntryPoint = page.locator("a").filter(new Locator.FilterOptions().setHasText("Paket murah untuk interaksi"));
        copyTextElement = page.getByTestId("popperReference").getByText("Paket murah untuk interaksi");
        countdownTimer = page.getByTestId("popperReference").getByTestId("countdown-container");
        mamikosActionCard = page.locator(".mk-action-card__main");
        periodeBerlanggananContainer = page.locator("div.goldplus-subscribe-periode-desktop");
        paketJangkaPanjangContainer = page.locator("div.goldplus-periode-select__list").nth(1);
        mamiadsBalanceListContainer = page.locator(".goldplus-mamiads-detail");
        rincianPembayaranSection = page.locator(".goldplus-billing-detail").locator("div").filter(new Locator.FilterOptions().setHasText("Rincian Pembayaran"));
        totalPembayaranSection = page.locator(".goldplus-billing-detail__billing-total");
        pilihPaketGoldplusContainer = page.getByTestId("goldplusPackages");

        // GoldPlus Period Selection Popup locators
        goldplusPeriodSelectionPopup = page.locator("//div[contains(@class, 'goldplus-periode-select')]");
        goldplusPeriodOptions = page.locator("//div[contains(@class, 'goldplus-periode-select__option')]");
        pilihPeriodeButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih Periode"));
        activeMamiadsBalance = page.locator("//div[@class='goldplus-mamiads-detail__item bg-c-card bg-c-card--md bg-c-card--light active']");
        favoriteOption = page.locator("//div[contains(@class, 'goldplus-periode-select__option') and .//div[contains(text(), 'Favorit')]]");

    }

    /**
     * Get list periode gp, salldo free mamiads, actual price, discount price
     *
     * @param goldplus input goldplus package 1 or 2
     */
    public void clickOnGoldplusPackageButton(int goldplus){
        playwright.waitTillPageLoaded();
        playwright.clickOn(page.locator("(//div[@class='goldplus-package-card__footer-actions'])["+goldplus+"]"));

    }

    /**
     * Click on Checkbox Syarat dan Ketentuan Goldplus
     *
     */
    public void clickOnCheckbox(){
        playwright.clickOn(snkGoldplusCheckbox);
    }

    /**
     * Input phone number to recurring Goldplus
     */
    public void inputRecurringPhoneNumber (String phoneNumberGP) {
        recurringPhoneNumberInput.fill(phoneNumberGP);
    }

    /**
     * set recurring days for Goldplus (H-7 - H-0)
     */
    public void selectRecurringPeriod (String period) {
        playwright.selectDropdownByValue(selectRecurringPeriod,period);
    }
    /**
     * Get list periode gp, salldo free mamiads, actual price, discount price
     *
     * @param index input with listPeriod
     * @return String periode gp, salldo free mamiads, actual price, discount price
     */
    public String listPeriod(String listPeriod, int index) {
        String element = "";
        switch (listPeriod) {
            case "periodGP":
                element = ".goldplus-periode-select__periode-card-header-right p.bg-c-text.bg-c-text--body-1";
                break;
            case "freeMamiAds":
                element = ".goldplus-periode-select__periode-card-footer-left p.bg-c-text.bg-c-text--label-4";
                break;
            case "actualPrice":
                element = ".goldplus-periode-select__periode-card-header-left p.bg-c-text.bg-c-text--body-1";
                break;
            case "discPrice":
                element = ".goldplus-periode-select__periode-card-discount p.bg-u-text-neutral-400.bg-c-text.bg-c-text--body-4.bg-c-text--strikethrough";
                break;
        }
        playwright.waitFor(page.locator(element).first());
        return playwright.getText(playwright.getLocators(page.locator(element)).get(index));
    }

    /**
     * Click on edit golplus button
     *
     */
    public void clickOnEditGP1Button() {
        playwright.clickOn(editPackageAdminGP1Button);
    }

    /**
     * Click on edit golplus button
     *
     */
    public void clickOnEditGP2Button() {
        playwright.waitFor(editPackageAdminGP2Button);
        playwright.clickOn(editPackageAdminGP2Button);
    }

    /**
     * Click on radio button No
     *
     */
    public void clickNoRadioButton() {
        playwright.clickOn(selectRadioButtonNo);
    }

    /**
     * Click on radio button Yes
     *
     */
    public void clickYesRadioButton() {
        playwright.clickOn(selectRadioButtonYes);
    }

    /**
     * Click on Info Untuk Anda on owner dashboard
     * @param infoUntukAndaMessage
     *
     */
    public void clickOnInfoUntukAnda(String infoUntukAndaMessage) {
        List<Locator> mamikosActionCardLocators = playwright.getLocators(mamikosActionCard);
        for (Locator locator : mamikosActionCardLocators) {
            String mamikosActionCardInnerText = playwright.getLocatorTextContent(locator);
            System.out.println("mamikosActionCardInnerText: " + mamikosActionCardInnerText);
            if (mamikosActionCardInnerText.contains(infoUntukAndaMessage)) {
                playwright.clickOn(locator);
                break;
            }
        }
    }

    /**
     * Get message text empty state
     * @return String message text
     */
    public String getMessage() {
        return playwright.getText(messageText).replaceAll("\\s", "");
    }

    /**
     * Get unpaid invoice GP
     * @return int, count of unpaid invoice GP
     */
    public int getCountInvoiceUnpaid() {
        playwright.hardWait(4000);
        playwright.waitTillPageLoaded();
        return playwright.getLocators(lihatTagihanTable).size();
    }

    /**
     * Click widget GP when status menunggu pembayaran
     */
    public void clickOnWidgetGP() {
        playwright.waitTillLocatorIsVisible(widgetGP);
        playwright.clickOn(widgetGP);
    }

    /**
     * Click Pilih on GP package
     * Entry point from status menunggu pembayaran Then ganti paket
     * Redirect to GP package list
     */
    public void clickOnGPPackage(int pacakge) {
        Locator pilihGPButton = page.getByTestId("beliGP"+pacakge+"_btn");
        playwright.clickOn(pilihGPButton);
    }

    /**
     * Verify jenis pembayaran (Goldplus monthly, Goldplus weekly, Mamiads, Mamifoto)
     * @param jenisPembayaran
     * @return text jenisPembayaran
     */
    public String getJenisPembayaran(String jenisPembayaran) {
        return playwright.getText(page.locator("#invoiceBill").getByText(jenisPembayaran));
    }

    /**
     * Select periode weekly
     */
    public void clickOnPeriodeWeekly() {
        playwright.clickOn(weeklyPeriode);

    }

    /**
     * Click on Pelajari Caranya button
     */
    public void clickOnPelajariCaranyaButton() {
        playwright.clickOn(pelajariCaranyaButton);
        playwright.waitTillPageLoaded();
    }

    /**
     * Verify package table is display
     * @return boolean (true if table displayed, false if table doesn't displayed)
     */
    public boolean isGpPackageTableDisplayed() {
        return playwright.isLocatorVisibleAfterLoad(gpPackageTable, 5000.0);
    }

    /**
    * Click on icon close pop up detail manfaat
    */
    public void clickOnCLosePopUpManfaat() {
        playwright.pageScrollUntilElementIsVisible(closePopUpDetailManfaat);
        playwright.clickOn(closePopUpDetailManfaat);
    }

    /**
     * Get status paket goldplus at tab filter
     * @return String status paket goldplus
     */
    public String getStatusPaketGoldPlus() {
        return playwright.getText(gpStatusFilter).replaceAll("\n", " ");
    }

    /**
     * Click on icon back from filter gp
     */
    public void clickOnIconBackFilter() {
        playwright.clickOn(backFromFilter);
    }

    /**
     * Scroll to tagihan goldplus at dashboard GP
     */
    public void scrollToTagihanSection() {
        tagihanGPSection.scrollIntoViewIfNeeded();
    }

    /**
     * Verify list tagihan GP is display
     * @return boolean (true if table displayed, false if table doesn't displayed)
     */
    public boolean isListDetailTagihanIsDisplayed() {
        return playwright.waitTillLocatorIsVisible(tableTagihanGP);
    }

    /**
     * Click on tab Selesai at page rincian pembayaran goldplus
     */
    public void clickTabSelesai() {
        playwright.clickOn(tabSelesaiRincianBayar);
    }

    /**
     * Click on lihat selengkapnya at section detail tagihan dashboard GP
     */
    public void lihatSelngkapnyaSectionDetailTagihan() {
        playwright.clickOn(lihatSelengkapnyaTagihanGP);
    }


    /**
     * Click 'Perpanjang' button on pop up recurring GoldPlus
     */
    public void clickOnPerpanjangBtn(){
        playwright.clickOnTextButton("Perpanjang");
    }

    /**
     * Verify 'GoldPlus 1 periode 4 Bulan' is display
     * @return boolean (true if text displayed, false if text doesn't displayed)
     */
    public Boolean gpPackageText(){
        playwright.waitTillPageLoaded(10000.0);
        playwright.waitForElementStateToBe(gpPackageText, "visible");
        return playwright.waitTillLocatorIsVisible(gpPackageText);
    }

    /**
     * Get MamiAds saldo, cashback, disc, salePrice, discount price MamiAds and saving
     * @param index input with mamiadsSaldo
     * @return String MAmiAds saldo, cashback, disc, salePrice, discount price MamiAds and saving
     */
    public String mamiadsSaldo(String mamiadsSaldo, int index) {
        String element = "";
        switch (mamiadsSaldo) {
            case "saldo":
                element = "//*[contains(@class,'goldplus-mamiads-detail__item-name')]";
                break;
            case "cashback":
                element = "//*[contains(@class,'goldplus-mamiads-detail__item-cashback')]";
                break;
            case "disc":
                element = "//*[contains(@class,'goldplus-mamiads-detail__item-discount bg-c-text bg-c-text--body-4')]";
                break;
            case "salePrice":
                element = "//*[contains(@class,'goldplus-mamiads-detail__item-sale-price')]";
                break;
            case "discPriceMamiAds":
                element = "//*[contains(@class,'goldplus-mamiads-detail__item-discount-price')]";
                break;
            case "saving":
                element = "//*[contains(@class,'goldplus-mamiads-detail__item-saving')]";
                break;
        }
        playwright.waitFor(tutupListBalanceGP);
        playwright.pageScrollUntilElementIsVisible(tutupListBalanceGP);
        return  playwright.getText(playwright.getLocators(page.locator(element)).get(index));
    }

    /**
     * user choose saldo
     * @param saldo type saldo
     * @throws InterruptedException
     */
    public void chooseSaldo(String saldo) throws InterruptedException {
        setSaldo(saldo);
        Locator element = page.locator("//p[contains(.,'" + saldo + "')]");
        playwright.clickOn(element);
    }

    /**
     * user unchoose saldo
     * @throws InterruptedException
     */
    public void unCheckedSaldo() throws InterruptedException {
        playwright.clickOn(activeMamiadsBalance);
    }

    /**
     * Get text rincian MamiAds
     * @return String text rincian MamiAds
     */
    public String getTextRinicianMamiAds() {
        return playwright.getText(rincianMamiadsText);
    }

    /**
     * Get text saldo MamiAds
     * @return String text saldo MamiAds
     */
    public String getTextSaldoMamiAds() {
        playwright.waitTillLocatorIsVisible(saldoMamiadsText);
        return playwright.getText(saldoMamiadsText);
    }

    /**
     * Verify the mamiads package not displayed from rincian pembayaran
     * @return false
     */
    public boolean isRincianNotVisible() {
        return playwright.waitTillLocatorIsVisible(rincianMamiadsText);
    }

    /**
     * Verify the saldo mamiads not displayed from rincian pembayaran
     * @return false
     */
    public boolean isSaldoNotVisible() {
        return playwright.waitTillLocatorIsVisible(saldoMamiadsText);
    }

    /**
     * Scroll to element Ubah Package GP
     */
    public void scrollToUbahPackage() {
        playwright.pageScrollUntilElementIsVisible(changeGPButton);
    }

    /**
     * Click on ubah gold plus
     * @throws InterruptedException
     */
    public void clickOnUbahGoldPlus() throws InterruptedException {
        // Check if close button is visible and click it if present
        playwright.pageScrollUntilElementIsVisible(changeGPButton);
        playwright.clickOn(changeGPButton);
        playwright.pageScrollUntilElementIsVisible(listGPPage);
    }

    /**
     * Get pembayaran
     *  <p> - No. Invoice
     *  <p> - Jenis Pembayaran
     *  <p> - Metode Pembayaran
     * @return String
     */
    public String getPembayaranText(String text) throws InterruptedException {
        if(text.contains("Status Transaksi")) {
            return playwright.getText(page.locator(".bg-c-label"));

        } else if (text.contains("Total Pembayaran")) {
            return playwright.getText(page.locator(".invoice-total-amount"));

        } else {
            // Try multiple XPath strategies to find the value - robust implementation
            String[] xpathStrategies = {
                "//p[normalize-space()='"+text+"']/following-sibling::p[1]",
                "//p[normalize-space()='"+text+"']/following::p[1]",
                "//p[normalize-space()='"+text+"']/../following-sibling::*/p[1]",
                "//p[normalize-space()='"+text+"']/../following-sibling::*[1]//p[1]",
                "//p[normalize-space()='"+text+"']/parent::*/following-sibling::*[1]//p",
                "//p[normalize-space()='"+text+"']/../../following-sibling::div//p[1]",
                "//p[normalize-space()='"+text+"']/../../following-sibling::div"
            };

            for (String xpath : xpathStrategies) {
                try {
                    Locator locator = page.locator(xpath);
                    if (playwright.waitTillLocatorIsVisible(locator, 2000.0)) {
                        String result = playwright.getText(locator);
                        if (result != null && !result.trim().isEmpty()) {
                            return result;
                        }
                    }
                } catch (Exception e) {
                    // XPath strategy failed, trying next strategy
                    System.out.println("XPath strategy failed for field '" + text + "': " + e.getMessage());
                }
            }
            throw new RuntimeException("Could not find value for field: " + text + ". Tried " + xpathStrategies.length + " XPath strategies.");
        }
    }

    public String getTotalPembayaran() {
        return totalPembayaran;
    }

    public void setTotalPembayaran(String totalPembayaran) throws InterruptedException {
        GoldplusPO.totalPembayaran = totalPembayaran;
    }


    /**
     * user get saldo
     * @return 27.000
     */
    public String getSaldo() {
        return GoldplusPO.saldoMamiads.replaceAll("Rp","");
    }

    /**
     * user set saldo from input
     * @return Rp27.000
     */
    public void setSaldo(String saldo) {
        GoldplusPO.saldoMamiads = saldo;
    }

    /**
     * Get rincian text for Goldplus
     * @return String paket goldplus
     */
    public String getRincianGP() {
        return playwright.getText(rincianGp);
    }

    /**
     * Get rincian text for Mamiads
     * @return String paket mamiads
     */
    public String getRincianMA() {
        return playwright.getText(rincianMA);
    }

    /**
     * Get rincian text for MDR Fee
     * @return String biaya transaksi
     */
    public String getRincianFee() {
        return playwright.getText(rincianFee);
    }

    /**
     * Input phone number to terminated Goldplus
     */
    public void searchPhoneNumberGP(String phoneNumberGP) {
        playwright.fill(searchPhoneNumber,phoneNumberGP);
        playwright.clickOn(buttonSearchContract);
    }

    /**
     * Check widget GP is appear or not
     */
    public boolean isWidgetGPAppear() {
        playwright.hardWait(3000);
        return  playwright.waitTillLocatorIsVisible(widgetGP);
    }


    /**
     * Check Info Untuk Anda on owner dashboard
     */
    public boolean isInfoUntukAndaAppear(String infoUntukAndaMessage) {
        infoUntukAndaOption = page.locator("//p[contains(.,'"+infoUntukAndaMessage+"')]");
        playwright.waitFor(infoUntukAndaOption);
       return playwright.waitTillLocatorIsVisible(infoUntukAndaOption);
    }

    /**
     * Check Info Untuk Anda on owner dashboard
     */
    public boolean isInfoUntukAndaIsNotAppear(String infoUntukAndaMessage) {
        playwright.waitTillPageLoaded(10000.0);
        infoUntukAndaOption = page.locator("//p[contains(.,'"+infoUntukAndaMessage+"')]");
        return playwright.waitTillLocatorIsVisible(infoUntukAndaOption);
    }

    /**
     * Click on detail manfaat GP 1
     */
    public void clickOnDetailManfaatGP1() {
        playwright.clickOn(detailManfaatGP1);
    }

    /**
     * Get benefit GP
     * @return String benefit GP
     */
    public String getTextManfaatGP(String benefit) {
        benefitGP = page.getByText(benefit);
        playwright.waitTillLocatorIsVisible(benefitGP);
        return playwright.getText(benefitGP);
    }

    /**
     * Click on detail manfaat GP 2
     */
    public void clickOnDetailManfaatGP2() {
        playwright.clickOn(detailManfaatGP2);
    }

    /**
     * Get one of list benefit GP 2
     * @return String benefit GP 2
     */
    public String getTextManfaatGP2(String benefitGP2) {
        benefitGP = page.getByText(benefitGP2).first();
        playwright.waitTillLocatorIsVisible(benefitGP);
        return playwright.getText(benefitGP);
    }

    /**
     * Get one of list benefit GP 1
     * @return String benefit GP 1
     */
    public String getTextManfaatGP1(String benefitGP1) {
        benefitGP = page.getByText(benefitGP1).nth(1);
        playwright.waitTillLocatorIsVisible(benefitGP);
        return playwright.getText(benefitGP);
    }

    /**
     * Click on radio button on Pilih Periode Berlangganan page
     */
    public void clickOnPeriodGoldPlus(String period){
        playwright.clickOn(page.locator(".goldplus-periode-select__periode-card").filter(new Locator.FilterOptions().setHasText(period)));
    }
    /**
     * Click on filter in payment billing GP
     */
    public void clickFilterInPaymentBillingGp(String filter) {
        playwright.hardWait(3000);
        String filterBilling = "//h4[normalize-space()='"+filter+"']";
        ElementHandle element = page.querySelector(filterBilling);
        element.click();
        if (playwright.isTextDisplayed("Belum Ada Tagihan yang Selesai")) {
            playwright.reloadPage();
            filterBilling = "//h4[normalize-space()='" + filter + "']";
            element = page.querySelector(filterBilling);
            element.click();
        }
    }

    /**
     * Click 'Perpanjang' button on chat room
     */
    public void clickOnPerpanjangBtnOnChatRoom(){
        playwright.clickOn(perpanjangButton);
    }

    /**
     * Choose filter paket goldplus anda
     */
    public void clickFilterPaketGoldplusAnda(String filter){
        filterPaketGoldplusAnda = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(filter));
        playwright.clickOn(filterPaketGoldplusAnda);
    }

    /**
     * check is image recurring visible or not
     * @return boolean
     */
    public boolean isImageRecurringPopupVisible() {
        playwright.waitForElementStateToBe(imagePopupRecurring, "visible");
        return playwright.waitTillLocatorIsVisible(imagePopupRecurring);
    }

    /**
     * check is title pop up recurring visible
     * @return boolean
     */
    public boolean isTitlePopUpRecurringVisible() {
        playwright.waitForElementStateToBe(textTitlePopupRecurring, "visible");
        return playwright.waitTillLocatorIsVisible(textTitlePopupRecurring);
    }

    /**
     * check is title pop up recurring visible
     * @return boolean
     */
    public boolean isSubtitlePopUpRecurringVisible() {
        playwright.waitForElementStateToBe(textSubtitlePopUpRecurring, "visible");
        return playwright.waitTillLocatorIsVisible(textSubtitlePopUpRecurring);
    }

    /**
     * check is title pop up recurring visible
     * @return boolean
     */
    public boolean isButtonRecurringPopUpVisible() {
        playwright.waitForElementStateToBe(buttonExtendGPpopUp, "visible");
        return playwright.waitTillLocatorIsVisible(buttonExtendGPpopUp);
    }


    /**
     * Verify the visibility of text on page
     * @return text on page
     */
    public String getTextOnPageVisible(String textOnPage) {
        Locator textOnPageNaikkanIklan = page.getByText(textOnPage);
        playwright.waitFor(textOnPageNaikkanIklan);
        return playwright.getText(textOnPageNaikkanIklan);
    }

    /**
     * Get gp package when owner choose on detail tagihan
     * @return gpPackageChoosed
     * e.g. GoldPlus 1 periode 1 Bulan
     */
    public String getTextGpPackageChoosed() {
        return playwright.getText(gpPackageChoosed);
    }

    /**
     * Get GP package on detail tagihan page section rincian pembayaran
     * @return GpPackageRincianPembayaran
     * e.g. Goldplus 1 (4 Bulan)
     */
    public String getGpPackageRincianPembaranDetailTagihan() {
        return playwright.getText(gpPackageRincianPembayaranDetailTagihan);
    }

    /**
     * Get periode owner choose on page Pilih periode
     * e.g 1 Bulan, 1 minggu, etc
     * if periode contains Favorit, remove text favorit
     */
    public void getTextPeriodeChoosed() {
       if (playwright.getText(gpPeriodeChoosed).contains("Favorit")){
           Mamikos.setGpPeriodeChoosed(playwright.getText(gpPeriodeChoosed).replaceAll("\\s+", " ").replaceAll(" Favorit",""));
       }else{
           Mamikos.setGpPeriodeChoosed(playwright.getText(gpPeriodeChoosed));
       }
    }


    /**
     * Click on transaction with status Unpaid at riwayat goldplus page
     */
    public void clickOnTransactionGPUnpaid() {
        playwright.clickOn(selectTransactionUnpaid);
    }

    /**
     * Click on transaction with status paid at riwayat goldplus page
     */
    public void clickOnTransactionGPPaid() {
        playwright.clickOn(selectTranscationPaid);
    }

    /**
     * Click on transaction with status expired at riwayat goldplus page
     */
    public void clickOnTransactionGPExpired() {
        playwright.clickOn(selectTransactionExpired);
    }

    /**
     * Get text transaction goldplus at detail tagihan page
     * @return text 'Dibatalkan' and 'Menunggu Pembayaran'
     */
    public String statusTransactionGP(String status) {
        statusDetailTagihan = page.getByText(status);
        playwright.waitFor(statusDetailTagihan);
        return playwright.getText(statusDetailTagihan);
    }

    /**
     * Get text transaction paid goldplus at detail tagihan page
     * @return text 'Lunas'
     */
    public String statusTransactionPaidGP() {
        playwright.waitFor(titleStatusPaid);
        return playwright.getText(titleStatusPaid);
    }

    /**
     * Check section paket yang anda pilih is visible
     * @return boolean type, visible true otherwise false
     */
    public boolean sectionPackageSelectedIsVisible() {
        return playwright.waitTillLocatorIsVisible(sectionPackageSelected);
    }

    /**
     * Check package goldplus at detail tagihan page
     * @return boolean type, appear true otherwise false
     */
    public boolean packageGP(String packageGP) {
        Locator packageGPDetailTagihan = page.getByText(packageGP).first();
        playwright.waitTillLocatorIsVisible(packageGPDetailTagihan);
        return playwright.waitTillLocatorIsVisible(packageGPDetailTagihan);
    }

    /**
     * Check rincian pembayaran is visible at detail tagihan page
     * @return boolean type, visible true otherwise false
     */
    public boolean sectionDetailBillingdIsVisible() {
        return playwright.waitTillLocatorIsVisible(sectionDetailBilling);
    }

    /**
     * Click on button bayar sekarang at detail tagihan page
     */
    public void clicOnButtonPaid() {
        playwright.clickOn(buttonPaidDetailTagihan);
    }

    /**
     * Click on tab selesai at riwayat tagihan goldplus
     */
    public void clickOnTabSelesaiRiwayatGP() {
        playwright.clickOn(tabSelesaiRiwayatGP);
    }

    /**
     * Check image pop weekly is visible
     * @return boolean type, visible true otherwise false
     */
    public boolean imagePopUpWeeklyIsVisible() {
        playwright.waitFor(imageGPWeeklyPopup);
        return playwright.waitTillLocatorIsVisible(imageGPWeeklyPopup);
    }

    /**
     * Check button 'Nanti Saja' is visible
     * @return boolean type, visible true otherwise false
     */
    public boolean buttonNantiSajaWeeklyIsVisible() {
        return playwright.waitTillLocatorIsVisible(buttonNantiWeekly);
    }

    /**
     * Check button 'Lihat Fitur' is visible
     * @return boolean type, visible true otherwise false
     */
    public boolean buttonLihatFiturWeeklyIsVisible() {
        return playwright.waitTillLocatorIsVisible(buttonLihatFiturWeekly);
    }

    /**
     * Get text title pop up weekly
     * @return text title
     */
    public String getTitlePopUpWeekly(String title) {
        titlePopUpGpWeekly = page.getByText(title);
        playwright.waitFor(titlePopUpGpWeekly);
        return playwright.getText(titlePopUpGpWeekly);
    }

    /**
     * Get text desc pop up weekly
     * @return text description
     */
    public String getDescPopUpWeekly(String desc) {
        descPopUpGpWeekyly= page.getByText(desc);
        playwright.waitFor(descPopUpGpWeekyly);
        return playwright.getText(descPopUpGpWeekyly);
    }

    /**
     * Edit field price on goldplus package edit
     * @param price
     */
    public void editPriceGp(int price) {
        playwright.forceFill(priceField, String.valueOf(price));
    }

    /**
     * Click save button
     */
    public void clickSaveButton() {
        playwright.clickOn(saveButton);
    }

    /**
     * Verify the warning message
     * @return warningMessage
     */
    public String getWarningMessageEditGp() {
        return playwright.getText(warningMessage).replaceAll("×\\s+", "");
    }

    /**
     * Verify the success message
     * @return successMessage
     */
    public String getSuccessMessage() {
        return playwright.getText(successMessage).replaceAll(" ID \\d+ ", "").replaceAll("×\\s+", "");
    }

    /**
     * Click on Add Package button on Admin Goldplus Package page
     */
    public void clickOnAddPackageButton() {
        playwright.waitFor(addPackageButton);
        playwright.clickOn(addPackageButton);
    }

    /**
     * Search Goldplus package by ID
     * @param id the package ID to search
     */
    public void searchPackageById(String id) {
        playwright.waitFor(searchIdField);
        playwright.fill(searchIdField, id);
        playwright.clickOn(searchButton);
        playwright.waitTillPageLoaded();
    }

    /**
     * Click on edit button for the first package in search result
     */
    public void clickOnEditPackageButton() {
        playwright.waitFor(editPackageButton);
        playwright.clickOn(editPackageButton);
        playwright.waitTillPageLoaded();
    }

    /**
     * Check if Premium Package (bonus) field is displayed
     * @return true if field is displayed, false otherwise
     */
    public boolean isPremiumPackageBonusFieldDisplayed() {
        playwright.waitTillPageLoaded();
        return playwright.waitTillLocatorIsVisible(premiumPackageBonusField);
    }

    /**
     * Get the text of Premium Package (bonus) field label
     * @return String label text
     */
    public String getPremiumPackageBonusFieldText() {
        playwright.waitFor(premiumPackageBonusField);
        return playwright.getText(premiumPackageBonusField);
    }

    /**
     * Click on Bundled Premium Package dropdown
     */
    public void clickOnBundledPremiumPackageDropdown() {
        playwright.waitFor(bundledPremiumPackageDropdown);
        playwright.clickOn(bundledPremiumPackageDropdown);
    }

    /**
     * Get all Bundled Premium Package options text
     * @return List of option texts
     */
    public List<String> getBundledPremiumPackageOptions() {
        // Wait for the select dropdown to be attached (not the option elements)
        // Option elements inside native <select> are not considered "visible" by Playwright
        playwright.waitFor(bundledPremiumPackageDropdown);
        List<String> options = new java.util.ArrayList<>();
        List<String> allTexts = bundledPremiumPackageOptions.allTextContents();
        for (String text : allTexts) {
            if (!text.isEmpty() && !text.contains("---") && !text.equals("Select Package")) {
                options.add(text.trim());
            }
        }
        return options;
    }

    /**
     * Check if Bundled Premium Package dropdown is displayed
     * @return true if displayed, false otherwise
     */
    public boolean isBundledPremiumPackageDropdownDisplayed() {
        return playwright.waitTillLocatorIsVisible(bundledPremiumPackageDropdown);
    }

    /**
     * Select a Bundled Premium Package by visible text
     * @param packageName the package name to select
     */
    public void selectBundledPremiumPackage(String packageName) {
        playwright.waitFor(bundledPremiumPackageDropdown);
        bundledPremiumPackageDropdown.selectOption(new com.microsoft.playwright.options.SelectOption().setLabel(packageName));
    }

    /**
     * Get selected Bundled Premium Package value
     * @return selected package text
     */
    public String getSelectedBundledPremiumPackage() {
        playwright.waitFor(bundledPremiumPackageDropdown);
        return page.locator("//select[@id='bundled_premium_package_id']/option[@selected]").textContent();
    }

    /**
     * Check if a specific package option exists in Bundled Premium Package dropdown
     * @param packageName the package name to check
     * @return true if exists, false otherwise
     */
    public boolean isBundledPremiumPackageOptionExists(String packageName) {
        List<String> options = getBundledPremiumPackageOptions();
        return options.contains(packageName);
    }

    public void closeGpOnBoardingIfExist() {
        playwright.hardWait(1);
        if (playwright.waitTillLocatorIsVisible(closeBtn)) {
            playwright.clickOn(closeBtn);
        }
    }

    /**
     * upgrade paket Gp1 to Gp 2 from TBC detail page
     */
    public void upgradePaketGp1ToGp2() {
        playwright.clickOn(upgradePaketBtnOnTbc);
        playwright.clickOn(upgradePaketBtnPopUpOnTbc);
    }
    /**
     * click on upgrade paket at profile tenant
     */
    public void clickOnUpgradePackage() {
        playwright.clickOn(upgradePaketBtnOnTbc);
    }

    /**
     * Get aria snapshot of the MamiAds balance list container in GoldPlus cross-selling section
     * Useful for accessibility testing and debugging of the balance list section
     *
     * @return String representation of the MamiAds balance list container's accessibility tree
     */
    public String getMamiadsBalanceListSnapshot() {
        return playwright.getAriaSnapshot(mamiadsBalanceListContainer);
    }

    /**
     * Get aria snapshot of the Rincian Pembayaran section in GoldPlus billing detail
     * Useful for accessibility testing and debugging of the billing details section
     *
     * @return String representation of the Rincian Pembayaran section's accessibility tree
     */
    public String getRincianPembayaranSnapshot() {
        return playwright.getAriaSnapshot(rincianPembayaranSection);
    }

    /**
     * Get aria snapshot of the Total Pembayaran section in GoldPlus billing detail
     * Useful for accessibility testing and debugging of the total billing amount
     *
     * @return String representation of the Total Pembayaran section's accessibility tree
     */
    public String getTotalPembayaranSnapshot() {
        return playwright.getAriaSnapshot(totalPembayaranSection);
    }

    /**
     * Handle the GoldPlus period selection popup that appears when clicking "daftar GP button"
     * This popup appears in the @TEST_LIMO-1393 scenario
     *
     * @param periodOption The period option to select (e.g., "4 Bulan", "3 Bulan", "1 Bulan")
     */
    public void handleGoldplusPeriodSelectionPopup(String periodOption) {
        playwright.waitTillPageLoaded();

        // Check if we're on the GoldPlus period selection page
        if (page.url().contains("goldplus/submission/periode")) {
            System.out.println("GoldPlus period selection popup detected. Selecting period: " + periodOption);

            // Wait for the period options to be visible
            playwright.waitFor(goldplusPeriodOptions.first());

            // Click the specific period option
            Locator periodToSelect = page.locator("//div[contains(@class, 'goldplus-periode-select__option') and contains(., '" + periodOption + "')]");
            if (playwright.waitTillLocatorIsVisible(periodToSelect, 5000.0)) {
                playwright.clickOn(periodToSelect);
                System.out.println("Selected period: " + periodOption);
            } else {
                System.out.println("Period option not found: " + periodOption + ". Selecting default favorite option.");
                selectDefaultFavoritePeriod();
            }

            // Click the "Pilih Periode" button if it exists
            if (playwright.waitTillLocatorIsVisible(pilihPeriodeButton, 3000.0)) {
                playwright.clickOn(pilihPeriodeButton);
                System.out.println("Clicked 'Pilih Periode' button");
            }
        } else {
            System.out.println("Not on GoldPlus period selection page. Current URL: " + page.url());
        }
    }

    /**
     * Select the default favorite period option in the GoldPlus period selection popup
     */
    private void selectDefaultFavoritePeriod() {
        // Look for the favorite option (marked with "Favorit" badge)
        if (playwright.waitTillLocatorIsVisible(favoriteOption, 3000.0)) {
            playwright.clickOn(favoriteOption);
            System.out.println("Selected favorite period option");
        } else {
            // If no favorite option, select the first available option
            Locator firstOption = goldplusPeriodOptions.first();
            if (playwright.waitTillLocatorIsVisible(firstOption, 3000.0)) {
                playwright.clickOn(firstOption);
                System.out.println("Selected first available period option");
            }
        }
    }

    /**
     * Check if the GoldPlus period selection popup is visible
     *
     * @return true if popup is visible, false otherwise
     */
    public boolean isGoldplusPeriodSelectionPopupVisible() {
        return page.url().contains("goldplus/submission/periode") &&
               playwright.waitTillLocatorIsVisible(goldplusPeriodOptions.first(), 3000.0);
    }

    /**
     * Handle any popup that appears when clicking "daftar GP button"
     * This is the main method that should be called in the test steps
     *
     * @param periodOption Optional period to select, defaults to favorite if not specified
     */
    public void handleDaftarGPPopup(String periodOption) {
        if (isGoldplusPeriodSelectionPopupVisible()) {
            if (periodOption != null && !periodOption.isEmpty()) {
                handleGoldplusPeriodSelectionPopup(periodOption);
            } else {
                handleGoldplusPeriodSelectionPopup("4 Bulan"); // Default to favorite option
            }
        }
    }

    /**
     * Handle popup with default favorite period selection
     */
    public void handleDaftarGPPopup() {
        handleDaftarGPPopup(null);
    }

    /**
     * Get aria snapshot of the pilih gp package container
     * This captures the accessibility tree representation of all subscription packages
     * @return String representation of the accessibility tree
     */
    public String getPilihGpPackageAriaSnapshot() {
        // Use the pre-initialized container locator
        playwright.waitFor(pilihPaketGoldplusContainer);
        return playwright.getAriaSnapshot(pilihPaketGoldplusContainer);
    }


    /**
     * Get aria snapshot of the Periode Berlangganan package container
     * This captures the accessibility tree representation of all subscription packages
     * @return String representation of the accessibility tree
     */
    public String getPeriodeBerlanggananAriaSnapshot() {
        // Use the pre-initialized container locator
        playwright.waitFor(periodeBerlanggananContainer);
        return playwright.getAriaSnapshot(periodeBerlanggananContainer);
    }

    /**
     * Get aria snapshot of a specific package by index
     * @param index The index of the package (0-based)
     * @return String representation of the package accessibility tree
     */
    public String getPackageAriaSnapshotByIndex(int index) {
        Locator packageCard = page.locator(".goldplus-periode-select__periode-card").nth(index);
        playwright.waitFor(packageCard);
        return playwright.getAriaSnapshot(packageCard);
    }

    /**
     * Get aria snapshot of the Paket Jangka Panjang section (2nd goldplus-periode-select__list)
     * This captures the accessibility tree representation of the long-term packages
     * @return String representation of the accessibility tree
     */
    public String getPaketJangkaPanjangAriaSnapshot() {
        // Use the pre-initialized container locator
        playwright.waitFor(paketJangkaPanjangContainer);
        return playwright.getAriaSnapshot(paketJangkaPanjangContainer);
    }

    public boolean isOnBoardingPopExist() {
        playwright.waitTillLocatorIsVisible(gpOnboardingPopUp);

        return playwright.isLocatorVisibleAfterLoad(gpOnboardingPopUp, 3000.0);
    }

    public void tapOnSwapNextGpOnboarding() {
        playwright.clickOn(gpOnboardingNextPopUpBtn);
    }

    public void tapOnSwapPreviousGpOnboarding() {
        playwright.clickOn(gpOnboardingPreviousPopUpBtn);
    }

    public void tapOnPilihPaketGoldplusBtnFromGpOnboardingPopUp() {
        playwright.clickOn(pilihPaketBtn);
    }

    /**
     * Check if GP entry point is displayed in chat list
     * @return boolean
     */
    public boolean isGpEntryPointDisplayed() {
        return playwright.waitTillLocatorIsVisible(gpEntryPoint);
    }

    /**
     * Check if countdown timer is displayed
     * @return boolean
     */
    public boolean isCountdownTimerDisplayed() {
        return playwright.waitTillLocatorIsVisible(countdownTimer);
    }

    /**
     * Get displayed price in GP entry point
     * @return String price
     */
    public boolean getDisplayedPrice(String expectedPrice) {
        Locator priceElement = page.getByText(expectedPrice);
        playwright.waitTillLocatorIsVisible(priceElement);
        return true;
    }

    /**
     * Get entry point copy text
     * @return String copy text
     */
    public String getEntryPointCopyText() {
        playwright.waitFor(copyTextElement);
        return playwright.getText(copyTextElement);
    }

    /**
     * Get countdown timer value
     * @return String countdown value (e.g., "23:59:59")
     */
    public String getCountdownTimerValue() {
        if (playwright.waitTillLocatorIsVisible(countdownValueOwnerDashboard)) {
            playwright.waitFor(countdownValueOwnerDashboard);
        return playwright.getText(countdownValueOwnerDashboard);
    } else {
        playwright.waitFor(countdownValueInMenuPackageGP);
        return playwright.getText(countdownValueInMenuPackageGP);
    }
    }
}