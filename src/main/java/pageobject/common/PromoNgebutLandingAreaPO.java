package pageobject.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class PromoNgebutLandingAreaPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private Locator countdownTimer;
    private Locator promoNgebutHeading;
    private Locator btnCariKostPromo;
    private Locator imgFlashSaleBanner;
    private Locator btnCariSekarang;
    private Locator faqHeading;

    public PromoNgebutLandingAreaPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        promoNgebutHeading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Mamikos Promo Ngebut akan berakhir dalam"));
        countdownTimer = page.locator(".countdown-section");
        btnCariKostPromo = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cari Kos Promo Ngebut"));
        imgFlashSaleBanner = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("flash sale banner"));
        btnCariSekarang = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cari Sekarang"));
        faqHeading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Frequently asked questions"));
    }

    public boolean isPromoNgebutHeadingVisible() {
        return playwright.waitTillLocatorIsVisible(promoNgebutHeading);
    }

    public boolean isCountDownTimerVisible() {
        return playwright.waitTillLocatorIsVisible(countdownTimer);
    }

    public boolean isBtnCariKostPromoVisible() {
        return playwright.waitTillLocatorIsVisible(btnCariKostPromo);
    }

    public boolean isFlashSaleBannerVisible() {
        return playwright.waitTillLocatorIsVisible(imgFlashSaleBanner);
    }

    public boolean isButtonCariSekarangVisible() {
        return playwright.waitTillLocatorIsVisible(btnCariSekarang);
    }

    public boolean isFaqHeadingVisible() {
        return playwright.waitTillLocatorIsVisible(faqHeading);
    }
}
