package pageobject.owner.fiturpromosi.mamiads;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

public class NaikkanIklanPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private LocatorHelpers locatorHelpers;

    Locator selectFilter;
    Locator filterChoice;
    Locator quickAllocateTitle;
    Locator toggleAds;
    Locator titlePopUpConfirmation;
    Locator descPopUpConfirmation;
    Locator keMamiAdsButton;
    Locator nantiSaja;
    Locator titlePopUp;
    Locator nonAktifkanAdsButton;
    Locator posisiIklanLocator;
    Locator toggleLocator;
    Locator adsStatusLocator;
    Locator anggaranDescLocator;
    Locator switchToggleLocator;
    Locator saldoMamiAdsValue;
    Locator actionButtonLocator;
    Locator currentStatusSaldo;



    public NaikkanIklanPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.locatorHelpers = new LocatorHelpers(page);
        selectFilter = page.locator(".bg-c-dropdown__trigger");
        quickAllocateTitle = page.locator("//div[@class='owner-kos-list col-xs-12']/div[1]//div[@class='alokasi-ads__purchase-desc']");
        toggleAds = page.locator("//div[@class='owner-kos-list col-xs-12']/div[1]//input[@class='bg-c-switch__input']");
        titlePopUpConfirmation = page.locator("//h3[@class='bg-c-modal__body-title']");
        descPopUpConfirmation = page.locator("#description-modal-toggle");
        keMamiAdsButton = page.locator("//*[contains(text(),'Ke MamiAds')]");
        nantiSaja = page.locator("//*[contains(text(),'Nanti Saja')]");
        titlePopUp = page.locator(".bg-c-modal__body-title");
        nonAktifkanAdsButton = page.locator("//*[contains(text(),'Ya, Nonaktifkan')]");
        saldoMamiAdsValue = page.locator(".amount");

    }


    /**
     * Get kost name from mamiads
     *
     * @return ads name or kost name
     * @params adsName
     */
    public String getAdsName(String adsName) {
        Locator adsNameLocator = page.getByText(adsName);
        return playwright.getText(adsNameLocator);

    }

    /**
     * Get posisi iklan (naik / tidak naik)
     * @return posisi iklan
     * @params posisiIklan
     */
    public String getPosisiIklan(String kostName, String posisiIklan) {
        posisiIklanLocator =  page.locator("//*[.='"+kostName+"']/../../following-sibling::*//div[@id='ads-position-" + posisiIklan + "']");
        return playwright.getText(posisiIklanLocator);

    }

    /**
     * Verify the status toggle iklan
     * @return toggleStatus
     * @params  toggleStatus
     */
    public boolean getToggleStatus(String adsName, String toggleStatus) {
       toggleLocator = page.locator("//*[.='"+adsName+"']/../../following-sibling::*//input[@id='room-toggle-switch-"+toggleStatus+"']");
        return playwright.waitTillLocatorIsVisible(toggleLocator);
    }

    /**
     * user verify the alokasi ads title
     * @return alokasi title
     * @param alokasiTitleText
     */
    public String getAlokasiTitleText(String alokasiTitleText) {
        String alokasiTitleElement = "//div[@class='kos-card'][1]//div[contains(@class,'alokasi-ads')]//div[contains(text(), '"+ alokasiTitleText+ "')]";
       playwright.waitTillLocatorIsVisible(page.locator(alokasiTitleElement));
       return playwright.getText(page.locator(alokasiTitleElement));
    }

    /**
     * user verify the alokasi ads title
     * @return alokasi title
     * @param toggleAdsStatus
     */
    public boolean getToggleAdsStatus(String toggleAdsStatus) {
        String toggleAdsElement = "//div[@class='kos-card'][1]//div[contains(@class,'alokasi-ads')]//div[@class='bg-c-switch alokasi-ads__toggle bg-c-switch--"+ toggleAdsStatus +"']";
        return playwright.waitTillLocatorIsVisible(page.locator(toggleAdsElement),1000.0);
    }

    /**
     * user verify the alokasi ads title
     * @return alokasi title
     * @param adsDescText
     */
    public String getAdsDescText(String adsDescText) {
        String adsDescElement = "//div[@class='kos-card'][1]//div[contains(@class,'ads__des')]";
        playwright.waitTillLocatorIsVisible(page.locator(adsDescElement));
        return  playwright.getText(page.locator(adsDescElement));
    }

    /**
     * owner click filter aktif at mamiads dashboard
     */
    public void clickOnFilterActive(String filter){
        playwright.clickOn(selectFilter);
        filterChoice = page.locator("//*[@class='bg-c-dropdown__menu-item-content'][contains(text(), '"+filter+"')]");
        playwright.clickOn(filterChoice);
    }

    /**
     * Click On Allocation Section
     *
     * @throws InterruptedException
     */
    public void clickOnAllocationSection() throws InterruptedException {
      playwright.clickOn(quickAllocateTitle);
    }
    /**
     * Click on toggle ON OFF on property saya
     * @throws InterruptedException
     *
     */
    public void clickToggleTheAdsOnPropertySaya() throws InterruptedException {
       playwright.clickOn(toggleAds);
    }

    /**
     * Get message on pop up confirmation
     * @return message on pop up confirmation
     * @params action
     */
    public String getTextSwitchTogglePopUp(String action) {
        if (action.equals("off")) {
            playwright.waitTillLocatorIsVisible(titlePopUpConfirmation);
            return playwright.getText(titlePopUpConfirmation);
        } else {
            playwright.waitTillLocatorIsVisible(descPopUpConfirmation);
            return playwright.getText(descPopUpConfirmation).replaceAll("[\\n\\s]+", " ");
        }
    }


    /**
     * Click on Ke MamiAds button
     * @throws InterruptedException
     *
     */
    public void clickOnKeMamiAdsButton() throws InterruptedException {
       playwright.clickOn(keMamiAdsButton);
    }

    /**
     * Click on Nanti Saja button on confirmation pop up quick allocation
     * @throws InterruptedException
     *
     */
    public void clickOnNantiSaja() throws InterruptedException {
        playwright.clickOn(nantiSaja);
    }

    /**
     * Get text title in Toast Message
     *
     * @return text title in Toast Message
     */
    public String getTextTitlePopUp() {
        return playwright.getText(titlePopUp);
    }

    /**
     * Click on Ya, Nonaktifkan button on Non aktif confirmation pop up
     * @throws InterruptedException
     *
     */
    public void clickOnNonaktifkanAds() {
       playwright.clickOn(nonAktifkanAdsButton);
    }

    /**
     * user can see text on filter is iklan saya
     */
    public String getTeksFilter() {
        return playwright.getText(selectFilter);
    }

    /**
     * Get message of ads status
     * @return adsStatus message
     * @params adsName
     */
    public String getAdsStatusDesc(String adsName) {
        adsStatusLocator = page.locator("//*[.='"+adsName+"']/../../following-sibling::*//div[@id='ads-status-description']");
        return playwright.getText(adsStatusLocator);
    }

    /**
     * Get message of anggaran description
     * @return anggaranDesc message
     * @params adsName
     */
    public String getTextAnggaranDesc(String adsName) {
        playwright.hardWait(4000.0);
        anggaranDescLocator = page.locator("//*[.='"+adsName+"']/../../following-sibling::*//div[@id='ads-allocation-description']");
        return playwright.getText(anggaranDescLocator);
    }

    /**
     * Click toggle ads
     * @params toggleStatus, adsName
     */
    public void clickToggleTheAds(String toggleStatus, String adsName) {
        if (toggleStatus.equals("off")) {
            switchToggleLocator = page.locator("//*[.='" + adsName + "']/../../following-sibling::*//input[@id='room-toggle-switch-off']");;
        } else {
            switchToggleLocator = page.locator("//*[.='" + adsName + "']/../../following-sibling::*//input[@id='room-toggle-switch-on']");
        }
        if (switchToggleLocator.isChecked()){
            switchToggleLocator.uncheck();
        }
        else {
            switchToggleLocator.check();
        }
    }

    /**
     * get saldo mamiads text
     * convert from String (Rp1.000) to int (1000)
     * @return int saldo mamiads
     */
    public int getSaldoMaText() {
        String balance = playwright.getText(saldoMamiAdsValue).replaceAll("[^0-9]", "");
        return Integer.parseInt(balance);
    }

    /**
     * Get Title Pop up while appear beli saldo pop up
     * @return title pop up confirmation
     */
    public String getTitleBeliSaldoPopUp() {
        return playwright.getText(titlePopUpConfirmation);
    }

    /**
     * Click Aktifkan button
     * @params actionButton
     */
    public void clickActionButtonInPopUp(String actionButton) {
        actionButtonLocator = page.locator("//button[contains(text(), '" + actionButton + "')]");
        playwright.clickOn(actionButtonLocator);
    }

    /**
     * Get list Ads on mamiAds dashboard page
     * @return AdsName, posisiIklan, currentToggle, AvailableRoom, currentStatusDesc
     * @params listAds, index
     */
    public String listAds(String listAds, int index) {
        String element = "";
        switch (listAds) {
            case "adsName":
                element = ".name";
                break;
            case "posisiIklan":
                element = "//*[contains(@class, 'rainbow')]";
                break;
            case "availRoom":
                element = ".ads-status__kamar-penuh";
                break;
            case "currentStatusDesc":
                element = "//*[@class='ads-status__desc']";
                break;
        }
        return playwright.getText(playwright.getLocators(page.locator(element)).get(index)).replaceAll("[\\n\\s]+", " ");
    }

    /**
     * Verify the toggle on list ads
     * @return status toggle (on/ off)
     * @params toggle, index
     */
    public boolean listAdsToggle(String toggle, int index) {
        return playwright.waitTillLocatorIsVisible(playwright.getLocators(page.locator("//*[contains(@class, 'switch--" + toggle +"')]")).get(index));
    }
}
