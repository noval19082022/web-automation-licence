package pageobject.owner.mamiads;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

public class NaikkanIklanPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private LocatorHelpers locatorHelpers;
    private static String kostName;
    Locator selectFilter;
    Locator filterActive;
    Locator adsFullOccupied;
    Locator quickAllocateTitle;
    Locator toggleAds;
    Locator titlePopUpConfirmation;
    Locator descPopUpConfirmation;
    Locator keMamiAdsButton;
    Locator nantiSaja;
    Locator titlePopUp;
    Locator nonAktifkanAdsButton;


    public NaikkanIklanPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.locatorHelpers = new LocatorHelpers(page);
        selectFilter = page.getByText("Semua Iklandropdown-down");
        filterActive =  page.locator("#filter-status-2");
        adsFullOccupied = page.locator(".ads-status__kamar-penuh");
        quickAllocateTitle = page.locator("//div[@class='owner-kos-list col-xs-12']/div[1]//div[@class='alokasi-ads__purchase-desc']");
        toggleAds = page.locator("//div[@class='owner-kos-list col-xs-12']/div[1]//input[@class='bg-c-switch__input']");
        titlePopUpConfirmation = page.locator("//h3[@class='bg-c-modal__body-title']");
        descPopUpConfirmation = page.locator("description.bg-c-text.bg-c-text--body-2");
        keMamiAdsButton = page.locator("//*[contains(text(),'Ke MamiAds')]");
        nantiSaja = page.locator("//*[contains(text(),'Nanti Saja')]");
        titlePopUp = page.locator(".bg-c-modal__body-title");
        nonAktifkanAdsButton = page.locator("//*[contains(text(),'Ya, Nonaktifkan')]");

    }


    /**
     * Get kost name from mamiads
     *
     * @return ads name or kost name
     * @params adsName
     */
    public String getAdsName(String adsName) throws InterruptedException {
        Locator adsNameLocator = page.getByText(adsName);
        return playwright.getText(adsNameLocator);

    }

    /**
     * Get posisi iklan (naik / tidak naik)
     *
     * @return posisi iklan
     * @params posisiIklan
     */
    public String getPosisiIklan(String posisiIklan) throws InterruptedException {
        Locator posisiIklanLocator =  page.getByText(posisiIklan, new Page.GetByTextOptions().setExact(true)).nth(3);
        return playwright.getText(posisiIklanLocator);

    }

    /**
     * Verify the status toggle iklan
     *
     * @return toggleStatus
     * @params  toggleStatus
     */
    public boolean getToggleStatus(String toggleStatus) {
       Locator toggleLocator = page.locator("#room-toggle-switch-" + toggleStatus + "").nth(3);
        return playwright.waitTillLocatorIsVisible(toggleLocator);
    }

    /**
     * Verify the description full occupancy active ads
     *
     * @return message full occupancy
     */
    public String isFullOcuppancyActiveAds() {
        return playwright.getText(adsFullOccupied);
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
    public void clickOnFilterActive(){
        playwright.clickOn(selectFilter);
        playwright.clickOn(filterActive);
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
     *
     * @return message on pop up confirmation
     * @params action
     */
    public String getTextSwitchTogglePopUp(String action) {
        if (action.equals("off")) {
            playwright.waitTillLocatorIsVisible(titlePopUpConfirmation);
            return playwright.getText(titlePopUpConfirmation);
        } else {
            playwright.waitTillLocatorIsVisible(descPopUpConfirmation);
            return playwright.getText(descPopUpConfirmation);
        }
    }

    /**
     * Set kos name owner from input user
     * @params nameKos
     *
     */
    public void setKosOwner(String kostName) {
        NaikkanIklanPO.kostName = kostName;
    }

    /**
     * Get Name Kos from input user
     * @return kosName
     *
     */
    public String getNameKos() {
        return kostName;
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
    public void clickOnNonaktifkanAds() throws InterruptedException {
       playwright.clickOn(nonAktifkanAdsButton);
    }
}
