package pageobject.owner;

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
    Locator editPackageAdminGP1Button;
    Locator editPackageAdminGP2Button;
    Locator selectRadioButtonNo;
    Locator selectRadioButtonYes;
    Locator registerGPButton;
    Locator pilihPeriodeGPButton;
    Locator pilihBayarSekarang;
    Locator pilihPeriodeTitle;
    Locator lihatInvoiceButton;
    Locator messageText;
    Locator lihatTagihan;
    Locator actionButtonPopUp;

    public GoldplusPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        broadcastChatBtn = page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText("'broadcast-message'"));
        warningBroadcastText = page.locator("//h3[@class='bg-c-modal__body-title']");
        closePopUpIcon = page.locator(".bg-c-modal__action-closable");
        goldplusPhoneNumberInput = page.locator("form").filter(new Locator.FilterOptions().setHasText("Reset")).getByPlaceholder("Phone Number");
        editPackageAdminGP1Button = page.locator("//tr[4]//div[@class='btn-group']");
        editPackageAdminGP2Button = page.locator("//tr[5]//div[@class='btn-group']");
        selectRadioButtonNo = page.locator("[value='0'][name='is_recommended']");
        selectRadioButtonYes = page.locator("[value='1'][name='is_recommended']");
        registerGPButton = page.getByTestId("registerGP_btn");
        pilihPeriodeGPButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih"));
        pilihBayarSekarang = page.locator(".bg-c-button--primary");
        pilihPeriodeTitle = page.getByText("Pilih Periode Berlangganan");
        lihatInvoiceButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat Invoice"));
        messageText = page.locator(".bg-c-empty-state__description");
        lihatTagihan = page.locator(".goldplus-payment-list-table__row");

    }

    /**
     * Input phone number to reset Goldplus
     */
    public void inputGoldplusPhoneNumber(String phoneNumberGP) {
        goldplusPhoneNumberInput.fill(phoneNumberGP);
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
     * Click on register GP button on owner dashboard
     *
     *
     */
    public void clickOnRegisterGP() {
        playwright.clickOn(registerGPButton);
    }

    /**
     * Click on GP package button on subscibe GP list package
     * @param gpPackage
     *
     */
    public void choosePaketGP(String gpPackage) {
       String gpPackageButton = "//*[@data-testid='beli" + gpPackage + "_btn']";
       playwright.clickOn(page.locator(gpPackageButton));
    }

    /**
     * Click on Pilih Periode Button
     *
     *
     */
    public void clickOnPilihPeriodeButton() {
        playwright.clickOn(pilihPeriodeGPButton);
    }

    public void clickOnBayarSekarang() {
        playwright.clickOn(pilihBayarSekarang);
    }

    public void clickOnInfoUntukAnda(String infoUntukAndaMessage) {
        String infoUntukAnda = "//p[contains(.,'"+ infoUntukAndaMessage +"')]";
        playwright.clickOn(page.locator(infoUntukAnda));
    }

    public boolean isPilihPeriodeScreen() {
        return playwright.waitTillLocatorIsVisible(pilihPeriodeTitle);
    }

    public void isLihatInvoiceDisplayed() {
        playwright.waitTillLocatorIsVisible(lihatInvoiceButton);
    }

    public void clickOnLihatInvoice() {
        playwright.clickOn(lihatInvoiceButton);
    }

    public boolean isDetailTagihanVisible() {
        return playwright.isTextDisplayed("Detail Tagihan");
    }

    public String getTitleEmptyState(String title) {
       return playwright.getText(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName(title)));
    }

    public String getMessage() {
        return playwright.getText(messageText).replaceAll("\\s", "");
    }

    public boolean isInvoiceUniversal() {
//        String jenisPembayaran = "//*[contains(text(),'Paket GoldPlus ')]";
        return playwright.isTextDisplayed("Paket GoldPlus ", 3);
    }


    public boolean isConfirmationPopUpVisible(String titlePopUp) {
        return playwright.isTextDisplayed(titlePopUp);
    }

    public void clickOnActionButtonPopUp(String actionText) {
        actionButtonPopUp= page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(actionText));
        System.out.println(actionButtonPopUp);
        playwright.pageScrollUntilElementIsVisible(actionButtonPopUp);
        playwright.clickOn(actionButtonPopUp);
    }


    public int getCountInvoiceUnpaid() {
        int unpaidInvoiceCount = (int) page.locator("//tr[@class='goldplus-payment-list-table__row']").count();
        System.out.println(unpaidInvoiceCount);
        return unpaidInvoiceCount;
    }
}
