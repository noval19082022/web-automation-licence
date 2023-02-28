package pageobject.common.promongebut;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

import java.util.List;

public class PromoNgebutLandingAreaPO {
    Page page;
    PlaywrightHelpers playwright;
    private Locator subFilterInformationText;
    private Locator promoNgebutBanner;
    private Locator filterContainer;
    private Locator discountIcon;

    public PromoNgebutLandingAreaPO(Page page) {
        this.page = page;
        playwright = new PlaywrightHelpers(page);
        subFilterInformationText = page.locator(".sub-filter-information");
        promoNgebutBanner = page.getByRole(AriaRole.BANNER).getByRole(AriaRole.HEADING, new Locator.GetByRoleOptions().setName("Mamikos Promo Ngebut"));
        filterContainer = page.locator(".filter-wrapper-container");
        discountIcon = page.locator(".rc-price__discount-icon > use");
    }

    /**
     * Get sub filter information text
     * @return String
     */
    public String getSubFilterInformationText() {
        return playwright.getText(subFilterInformationText);
    }

    /**
     * Check the visibility of promo ngebut banner
     * @return boolean
     */
    public boolean isPromoNgebutBannerVisible() {
        return playwright.waitTillLocatorIsVisible(promoNgebutBanner);
    }

    /**
     * Check the visibility of filter container
     * @return boolean
     */
    public boolean isFilterContainerVisible() {
        return playwright.waitTillLocatorIsVisible(filterContainer);
    }

    /**
     * Get all discount icon locators
     * @return List<Locator>
     */
    public List<Locator> getDiscountIconLocators() {
        return discountIcon.all();
    }
}
