package pageobject.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class PromoNgebutLandingAreaPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private Locator promoHeadingText;
    private Locator promoSubtitleText;
    private Locator filterCityText;
    private Locator filterCityCmb;
    private Locator kostList;

    public PromoNgebutLandingAreaPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        promoHeadingText = page.getByText("Promo dan Event dari Mamikos");
        promoSubtitleText = page.getByText("Promo dari Kost");
        filterCityText = page.getByText("Filter dari Kota");
        filterCityCmb = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Filter dari Kota"));
        kostList = page.locator(".row");
    }

    /**
     * Check the visibility of promo heading text
     * @return boolean
     */
    public boolean isPromoHeadingTextVisible() {
        return playwright.waitTillLocatorIsVisible(promoHeadingText);
    }

    /**
     * Check the visibility of promo subtitle text
     * @return boolean
     */
    public boolean isPromoSubtitleTextVisible() {
        return playwright.waitTillLocatorIsVisible(promoSubtitleText);
    }

    /**
     * Check the visibility of city filter
     * @return boolean
     */
    public boolean isFilterCityTextVisible() {
        return playwright.waitTillLocatorIsVisible(filterCityText);
    }

    /**
     * Get filter combo box value
     * @return String data type
     */
    public String getFilterComboBoxValue() {
        return filterCityCmb.inputValue();
    }

    /**
     * Check the visibility of kost list
     * @return boolean
     */
    public boolean isKostListVisible() {
        return playwright.waitTillLocatorIsVisible(kostList);
    }
}
