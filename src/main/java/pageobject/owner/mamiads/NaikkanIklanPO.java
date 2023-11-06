package pageobject.owner.mamiads;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

public class NaikkanIklanPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private LocatorHelpers locatorHelpers;
    Locator posisiIklanX;


    public NaikkanIklanPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.locatorHelpers = new LocatorHelpers(page);

    }


    /**
     * Get posisi iklan (naik / tidak naik)
     *
     * @return posisi iklan
     * @params adsName, posisiIklan
     */
    public String getPosisiIklan(String adsName, String posisiIklan) throws InterruptedException {
        posisiIklanX =  page.locator("'p:has-text('" + adsName + "'), //div[@id='ads-position-':has-text("+ posisiIklan +")'");
        playwright.waitTillLocatorIsVisible(posisiIklanX,1000.0);
        playwright.pageScrollUntilElementIsVisible(posisiIklanX);
        return playwright.getText(posisiIklanX);
    }

    /**
     * Verify the status toggle iklan
     *
     * @return toggleStatus
     * @params adsName, toggleStatus
     */
    public boolean getToggleStatus(String adsName, String toggleStatus) {
        String toggleLocator = "//*[.='" + adsName + "']/parent::*/following-sibling::*//input[@id='room-toggle-switch-" + toggleStatus + "']";
        playwright.pageScrollUntilElementIsVisible(page.locator(toggleLocator));
        return playwright.waitTillLocatorIsVisible(page.locator(toggleLocator));
    }

    /**
     * Verify the description full occupancy active ads
     *
     * @return message full occupancy
     * @params adsName
     */
    public String isFullOcuppancyActiveAds(String adsName) {
        String adsFullOccupancyActiveAds = "//*[.='" + adsName + "']/parent::*/following-sibling::*//div[@class='ads-status__kamar-penuh']";
        playwright.waitTillLocatorIsVisible(page.locator(adsFullOccupancyActiveAds));
        return playwright.getText(page.locator(adsFullOccupancyActiveAds));
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
}
