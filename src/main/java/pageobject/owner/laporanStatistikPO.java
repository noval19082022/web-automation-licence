package pageobject.owner;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;

public class laporanStatistikPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private Locator selectedKosTopOrder;
    private Locator tooltip;
    private Locator totalSewaElement;
    private Locator totalChatElement;
    private Locator totalClickElement;
    private Locator elementPeriode;
    private Locator greenGraphic;
    private Locator redGraphic;
    private Locator grayGraphic;

    public laporanStatistikPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.selectedKosTopOrder = page.locator(".bg-c-link.statistic-kos-list__list-item.bg-c-link--high-naked.statistic-kos-list__list-item--active");
        this.tooltip = page.locator("div[class='statistic-container__icon'] svg");
        this.totalSewaElement = page.locator(".statistic-kos-data > div:nth-of-type(1) > .statistic-kos-data__value");
        this.totalChatElement = page.locator(".statistic-kos-data > div:nth-of-type(2) > .statistic-kos-data__value");
        this.totalClickElement = page.locator(".statistic-kos-data > div:nth-of-type(3) > .statistic-kos-data__value");
        this.elementPeriode = page.locator(".bg-u-mr-xxs");
        this.greenGraphic = page.locator(".bg-u-text-green-500 > .bg-c-icon");
        this.redGraphic = page.locator(".bg-u-text-red-500 > .bg-c-icon");
        this.grayGraphic = page.locator(".statistic-kos-data > div:nth-of-type(3) .bg-c-icon");
    }

    /**
     * select listing top order
     */
    public void autoSelectedListingTopOrder() {
        playwright.getLocators(selectedKosTopOrder);
    }

    /**
     * System selected listing
     *
     * @return
     */
    public String autoSelectedListing(String type) {
        Locator getResutlDataTable = page.locator("//p[@class='statistic-kos-list__list-item-name bg-c-text bg-c-text--title-5'][normalize-space()='" + type + "']");
        return playwright.getText(getResutlDataTable);
    }

    /**
     * empty state laporan statistik
     */
    public String ownerSeeEmptyState(String text) {
        playwright.waitTillPageLoaded();
        Locator nameKos = page.locator("//h4[normalize-space()='" + text + "']");
        return playwright.getText(nameKos);
    }

    /**
     * click on tooltip
     */
    public void ownerClickOnTooltip() {
        playwright.clickOn(tooltip);
    }

    /**
     * click on filter
     */
    public void ownerClickOnFilter(String filter) {
        Locator buttonFilter = page.locator("//span[normalize-space()='" + filter + "']");
        playwright.clickOn(buttonFilter);
    }

    /**
     * get total data sewa at laporan statistik
     *
     * @return
     */
    public boolean getDataTotalSewa() {
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
     * get total data chat at laporan statistik
     *
     * @return
     */
    public boolean getDataTotalChat() {
        String totalSewaText = totalChatElement.textContent();
        int totalSewa = Integer.parseInt(totalSewaText.trim());
        if (totalSewa == 0) {
            System.out.println("Assertion passed: Total Sewa is 0");
        } else {
            System.out.println("Assertion failed: Total Sewa is not 0");
        }
        return playwright.waitTillLocatorIsVisible(totalSewaElement);
    }

    /**
     * get total data click at laporan statistik
     *
     * @return
     */
    public boolean getDataTotalClick() {
        String totalSewaText = totalClickElement.textContent();
        int totalSewa = Integer.parseInt(totalSewaText.trim());
        if (totalSewa == 0) {
            System.out.println("Assertion passed: Total Sewa is 0");
        } else {
            System.out.println("Assertion failed: Total Sewa is not 0");
        }
        return playwright.waitTillLocatorIsVisible(totalSewaElement);
    }

    /**
     * get total data periode at laporan statistik
     *
     * @return
     */
    public boolean getDataperiode() {
        return playwright.waitTillLocatorIsVisible(elementPeriode);
    }

    /**
     * Graphic at laporan statistik
     *
     * @return
     */
    public boolean ownerSeeGraphic() {
        if (playwright.waitTillLocatorIsVisible(greenGraphic)) {
            return playwright.waitTillLocatorIsVisible(greenGraphic);
        } else if (playwright.waitTillLocatorIsVisible(redGraphic)) {
            return playwright.waitTillLocatorIsVisible(redGraphic);
        } else {
            return playwright.waitTillLocatorIsVisible(grayGraphic);
        }
    }
}