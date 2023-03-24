package pageobject.common.promongebut;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class PromoNgebutLandingPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private Locator countdownTimer;
    private Locator promoNgebutHeading;
    private Locator btnCariKostPromo;
    private Locator imgFlashSaleBanner;
    private Locator btnCariSekarang;
    private Locator faqHeading;

    public PromoNgebutLandingPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        promoNgebutHeading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Mamikos Promo Ngebut akan berakhir dalam"));
        countdownTimer = page.locator(".countdown-section");
        btnCariKostPromo = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cari Kos Promo Ngebut"));
        imgFlashSaleBanner = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("flash sale banner"));
        btnCariSekarang = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cari Sekarang"));
        faqHeading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Frequently asked questions"));
    }

    /**
     * Check the visibility of promo ngebut heading
     * @return boolean
     */
    public boolean isPromoNgebutHeadingVisible() {
        return playwright.waitTillLocatorIsVisible(promoNgebutHeading);
    }

    /**
     * Check the visibility of count down timer
     * @return boolean
     */
    public boolean isCountDownTimerVisible() {
        return playwright.waitTillLocatorIsVisible(countdownTimer);
    }

    /**
     * Check the visibility of button cari kost
     * @return boolean
     */
    public boolean isBtnCariKostPromoVisible() {
        return playwright.waitTillLocatorIsVisible(btnCariKostPromo);
    }

    /**
     * Check the visibility of flash sale banner visible
     * @return boolean
     */
    public boolean isFlashSaleBannerVisible() {
        return playwright.waitTillLocatorIsVisible(imgFlashSaleBanner);
    }

    /**
     * Check the visibility of button cari sekarang
     * @return boolean
     */
    public boolean isButtonCariSekarangVisible() {
        return playwright.waitTillLocatorIsVisible(btnCariSekarang);
    }

    /**
     * Check the visibility of faq heading
     * @return boolean
     */
    public boolean isFaqHeadingVisible() {
        return playwright.waitTillLocatorIsVisible(faqHeading);
    }

    /**
     * Click on cari kos promo ngebut button
     */
    public void clickOnCariKosPromoNgebut() {
        playwright.clickOn(btnCariKostPromo);
    }

    /**
     * Click on cari sekarang button
     */
    public void clickOnCariSekarangButton() {
        playwright.clickOn(btnCariSekarang);
    }
}
