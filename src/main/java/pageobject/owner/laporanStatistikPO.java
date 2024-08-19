package pageobject.owner;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;

public class laporanStatistikPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private Locator selectedKosTopOrder;
    //   private  Locator clickOnFilter;


    public laporanStatistikPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.selectedKosTopOrder = page.locator(".bg-c-link.statistic-kos-list__list-item.bg-c-link--high-naked.statistic-kos-list__list-item--active");
        // this.clickOnFilter = page.locator("//p[contains(text(),'Properti yang sudah terverifikasi akan muncul di s')]/following::div[4]");

    }

    /**
     *
     */
    public void autoSelectedListingTopOrder() {
        playwright.getLocators(selectedKosTopOrder);
    }

    /**
     * @return
     */
    public String autoSelectedListing(String type) {
        Locator getResutlDataTable = page.locator("//p[@class='statistic-kos-list__list-item-name bg-c-text bg-c-text--title-5'][normalize-space()='" + type + "']");
        return playwright.getText(getResutlDataTable);
    }

    /**
     *
     */
    public String ownerSeeEmptyState(String text) {
        playwright.waitTillPageLoaded();
        Locator nameKos = page.locator("//h4[normalize-space()='" + text + "']");
        return playwright.getText(nameKos);
    }

    /**
     *
     */
    public void ownerClickOnTooltip() {
        Locator tooltip = page.locator("div[class='statistic-container__icon'] svg");
        playwright.clickOn(tooltip);
    }

    /**
     *
     */
    public void ownerClickOnFilter(String filter) {
        Locator buttonFilter = page.locator("//span[normalize-space()='" + filter + "']");
        playwright.clickOn(buttonFilter);
    }

    /**
     * @return
     */
    public boolean getDataTotalSewa() {
        Locator totalSewaElement = page.locator(".statistic-kos-data > div:nth-of-type(1) > .statistic-kos-data__value");
        String totalSewaText = totalSewaElement.textContent();
        int totalSewa = Integer.parseInt(totalSewaText.trim());
        if (totalSewa == 0) {
            System.out.println("Assertion passed: Total Sewa is 0");
        } else {
            System.out.println("Assertion failed: Total Sewa is not 0");
        }
        return playwright.waitTillLocatorIsVisible(totalSewaElement);
    }

    /**
     * @return
     */
    public boolean getDataTotalChat() {
        Locator totalSewaElement = page.locator(".statistic-kos-data > div:nth-of-type(2) > .statistic-kos-data__value");
        String totalSewaText = totalSewaElement.textContent();
        int totalSewa = Integer.parseInt(totalSewaText.trim());
        if (totalSewa == 0) {
            System.out.println("Assertion passed: Total Sewa is 0");
        } else {
            System.out.println("Assertion failed: Total Sewa is not 0");
        }
        return playwright.waitTillLocatorIsVisible(totalSewaElement);
    }

    /**
     * @return
     */
    public boolean getDataTotalClick() {
        Locator totalSewaElement = page.locator(".statistic-kos-data > div:nth-of-type(3) > .statistic-kos-data__value");
        String totalSewaText = totalSewaElement.textContent();
        int totalSewa = Integer.parseInt(totalSewaText.trim());
        if (totalSewa == 0) {
            System.out.println("Assertion passed: Total Sewa is 0");
        } else {
            System.out.println("Assertion failed: Total Sewa is not 0");
        }
        return playwright.waitTillLocatorIsVisible(totalSewaElement);
    }
    /**
     * @return
     */
    public boolean getDataperiode() {
        Locator elementPeriode = page.locator(".bg-u-mr-xxs");
        return playwright.waitTillLocatorIsVisible(elementPeriode);
    }
    /**
     * @return
     */
    public boolean ownerSeeGraphic() {
        Locator graphic = page.locator(".bg-u-text-green-500 > .bg-c-icon");
        return playwright.waitTillLocatorIsVisible(graphic);
    }
}