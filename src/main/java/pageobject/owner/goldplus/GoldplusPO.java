package pageobject.owner.goldplus;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class GoldplusPO {
    private Page page;
    private PlaywrightHelpers playwright;
    Locator broadcastChatBtn;
    Locator warningBroadcastText;
    Locator closePopUpIcon;
    Locator goldplusPhoneNumberInput;
    Locator recurringPhoneNumberInput;
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

    public GoldplusPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        broadcastChatBtn = page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText("'broadcast-message'"));
        warningBroadcastText = page.locator("//h3[@class='bg-c-modal__body-title']");
        closePopUpIcon = page.locator(".bg-c-modal__action-closable");
        goldplusPhoneNumberInput = page.locator("form").filter(new Locator.FilterOptions().setHasText("Reset")).getByPlaceholder("Phone Number");
        recurringPhoneNumberInput = page.getByPlaceholder("Phone Number").nth(1);
        editPackageAdminGP1Button = page.locator("//tr[4]//div[@class='btn-group']");
        editPackageAdminGP2Button = page.locator("//tr[5]//div[@class='btn-group']");
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
        playwright.hardWait(3000);
        playwright.clickOnText(infoUntukAndaMessage);
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
        return playwright.isLocatorVisibleAfterLoad(gpPackageTable, 3000.0);
    }

    /**
     * Verify link Daftar button on Landing page Goldplus
     * @return boolean
     *
     */
    public boolean isLinkButtonDisplayed() {
        return playwright.waitTillLocatorIsVisible(daftarButtonOnLandingPageGP);
    }
}
