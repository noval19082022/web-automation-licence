package pageobject.owner.goldplus;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

import java.util.List;

public class GoldplusPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private static String saldoMamiads, totalPembayaran;
    Locator broadcastChatBtn;
    Locator warningBroadcastText;
    Locator closePopUpIcon;
    Locator goldplusPhoneNumberInput;
    Locator recurringPhoneNumberInput;
    Locator selectRecurringPeriod;
    Locator editPackageAdminGP1Button;
    Locator editPackageAdminGP2Button;
    Locator selectRadioButtonNo;
    Locator selectRadioButtonYes;
    Locator messageText;
    Locator lihatTagihanTable;
    Locator actionButtonPopUp;
    Locator widgetGP;
    Locator snkGoldplusCheckbox;
    Locator weeklyPeriode;
    Locator pelajariCaranyaButton;
    Locator gpPackageTable;
    Locator daftarButtonOnLandingPageGP;
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


    public GoldplusPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        broadcastChatBtn = page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText("'broadcast-message'"));
        warningBroadcastText = page.locator("//h3[@class='bg-c-modal__body-title']");
        closePopUpIcon = page.locator(".bg-c-modal__action-closable");
        goldplusPhoneNumberInput = page.locator("form").filter(new Locator.FilterOptions().setHasText("Reset")).getByPlaceholder("Phone Number");
        recurringPhoneNumberInput = page.getByPlaceholder("Phone Number").nth(1);
        selectRecurringPeriod = page.locator("[name='h']");
        editPackageAdminGP1Button = page.locator("//tr[5]//div[@class='btn-group']");
        editPackageAdminGP2Button = page.locator("//tr[4]//div[@class='btn-group']");
        selectRadioButtonNo = page.locator("[value='0'][name='is_recommended']");
        selectRadioButtonYes = page.locator("[value='1'][name='is_recommended']");
        messageText = page.locator(".bg-c-empty-state__description");
        lihatTagihanTable = page.locator("//div[@id='goldplusPaymentUnpaid']//tr[@class='goldplus-payment-list-table__row']");
        widgetGP = page.locator(".membership-card__label");
        snkGoldplusCheckbox =  page.locator("label");
        weeklyPeriode = page.locator(".bg-c-radio__icon").first();
        pelajariCaranyaButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Pelajari caranya"));
        gpPackageTable = page.locator(".goldplus-package-content__packages-wrapper");
        daftarButtonOnLandingPageGP = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Daftar")).nth(1);
        closePopUpDetailManfaat = page.locator(".bg-c-modal__action-closable");
        gpStatusFilter = page.locator(".goldplus-room-card__gp-status");
        backFromFilter = page.locator(".bg-c-icon[data-v-7e8d294e]");
        tagihanGPSection = page.locator("//div[@class='gold-plus-features']/div[4]");
        tableTagihanGP = page.locator("//div[@id='goldplusPaymentDone']");
        lihatSelengkapnyaTagihanGP = page.locator("//div[4]//a[.='Lihat Selengkapnya']");
        tabSelesaiRincianBayar = page.locator("//h4[.='Selesai']");
        gpPackageText = page.getByText("GoldPlus 1 periode 4 Bulan").first();
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

    }

    /**
     * Get list periode gp, salldo free mamiads, actual price, discount price
     *
     * @param goldplus input goldplus package 1 or 2
     */
    public void clickOnGoldplusPackageButton(int goldplus){
        playwright.clickOn(page.getByTestId("beliGP"+goldplus+"_btn"));

    }

    /**
     * Click on Checkbox Syarat dan Ketentuan Goldplus
     *
     */
    public void clickOnCheckbox(){
        playwright.clickOn(snkGoldplusCheckbox);
    }

    /**
     * Input phone number to reset Goldplus
     */
    public void inputGoldplusPhoneNumber(String phoneNumberGP) {
        goldplusPhoneNumberInput.fill(phoneNumberGP);
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
                element = ".goldplus-periode-select__option-label-package";
                break;
            case "freeMamiAds":
                element = ".goldplus-periode-select__option-label-mamiads";
                break;
            case "actualPrice":
                element = ".goldplus-periode-select__option-price-actual";
                break;
            case "discPrice":
                element = ".goldplus-periode-select__option-price-discount";
                break;
        }
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
        playwright.waitTillPageLoaded(5000.0);
        infoUntukAndaOption = page.locator("//p[contains(.,'"+infoUntukAndaMessage+"')]");
        playwright.clickOn(infoUntukAndaOption);
    }

    /**
     * Get message text empty state
     * @return String message text
     *
     */
    public String getMessage() {
        return playwright.getText(messageText).replaceAll("\\s", "");
    }

    /**
     * Get unpaid invoice GP
     * @return int, count of unpaid invoice GP
     *
     */
    public int getCountInvoiceUnpaid() {
        playwright.hardWait(3000);
        return playwright.getLocators(lihatTagihanTable).size();
    }

    /**
     * Click widget GP when status menunggu pembayaran
     *
     *
     */
    public void clickOnWidgetGP() {
        playwright.hardWait(3000);
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
     *
     *
     */
    public void clickOnPeriodeWeekly() {
        playwright.clickOn(weeklyPeriode);

    }

    /**
     * Click on Pelajari Caranya button
     *
     *
     */
    public void clickOnPelajariCaranyaButton() {
        playwright.clickOn(pelajariCaranyaButton);
    }

    /**
     * Verify package table is display
     * @return boolean (true if table displayed, false if table doesn't displayed)
     *
     */
    public boolean isGpPackageTableDisplayed() {
        return playwright.isLocatorVisibleAfterLoad(gpPackageTable, 5000.0);
    }

    /**
    * Click on icon close pop up detail manfaat
    *
    *
    */
    public void clickOnCLosePopUpManfaat() {
        playwright.pageScrollUntilElementIsVisible(closePopUpDetailManfaat);
        playwright.clickOn(closePopUpDetailManfaat);
    }

    /**
     * Get status paket goldplus at tab filter
     *
     * @return String status paket goldplus
     */
    public String getStatusPaketGoldPlus() {
        return playwright.getText(gpStatusFilter).replaceAll("\n", " ");
    }

    /**
     * Click on icon back from filter gp
     *
     */
    public void clickOnIconBackFilter() {
        playwright.clickOn(backFromFilter);
    }

    /**
     * Scroll to tagihan goldplus at dashboard GP
     *
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
     *
     */
    public void clickOnPerpanjangBtn(){
        playwright.clickOnTextButton("Perpanjang");
    }

    /**
     * Verify 'GoldPlus 1 periode 4 Bulan' is display
     * @return boolean (true if text displayed, false if text doesn't displayed)
     *
     */
    public Boolean gpPackageText(){
        playwright.hardWait(3000);
        playwright.waitTillLocatorIsVisible(gpPackageText);
        return gpPackageText.isVisible();
    }

    /**
     * Get MamiAds saldo, cashback, disc, salePrice, discount price MamiAds and saving
     *
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
        playwright.pageScrollUntilElementIsVisible(tutupListBalanceGP);
        return  playwright.getText(playwright.getLocators(page.locator(element)).get(index));
    }

    /**
     * user choose saldo
     *
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
     *
     * @throws InterruptedException
     */
    public void unCheckedSaldo() throws InterruptedException {
        Locator element = page.locator("//div[@class='goldplus-mamiads-detail__item bg-c-card bg-c-card--md bg-c-card--light active']");
        playwright.clickOn(element);
    }

    /**
     * Get text rincian MamiAds
     *
     * @return String text rincian MamiAds
     */
    public String getTextRinicianMamiAds() {
        return playwright.getText(rincianMamiadsText);
    }

    /**
     * Get text saldo MamiAds
     *
     * @return String text saldo MamiAds
     */
    public String getTextSaldoMamiAds() {
        return playwright.getText(saldoMamiadsText);
    }

    /**
     * Verify the mamiads package not displayed from rincian pembayaran
     *
     * @return false
     */
    public boolean isRincianNotVisible() {
        return playwright.waitTillLocatorIsVisible(rincianMamiadsText);
    }

    /**
     * Verify the saldo mamiads not displayed from rincian pembayaran
     *
     * @return false
     */
    public boolean isSaldoNotVisible() {
        return playwright.waitTillLocatorIsVisible(saldoMamiadsText);
    }

    /**
     * Scroll to element Ubah Package GP
     *
     */
    public void scrollToUbahPackage() {
        playwright.pageScrollUntilElementIsVisible(changeGPButton);
    }

    /**
     * Click on ubah gold plus
     *
     * @throws InterruptedException
     */
    public void clickOnUbahGoldPlus() throws InterruptedException {
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
            return playwright.getText(page.locator("//*[contains(text(),'"+text+"')]/../../following-sibling::div"));
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
}
