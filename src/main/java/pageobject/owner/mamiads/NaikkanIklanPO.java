package pageobject.owner.mamiads;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

public class NaikkanIklanPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private LocatorHelpers locatorHelpers;
    Locator selectFilter;
    Locator filterActive;
    Locator adsFullOccupied;


    public NaikkanIklanPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.locatorHelpers = new LocatorHelpers(page);
        selectFilter = page.getByText("Semua Iklandropdown-down");
        filterActive =  page.locator("#filter-status-2");
        adsFullOccupied = page.locator(".ads-status__kamar-penuh");


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
}
