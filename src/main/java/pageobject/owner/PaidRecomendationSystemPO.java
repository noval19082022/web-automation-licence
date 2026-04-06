package pageobject.owner;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import data.mamikos.Mamikos;
import utilities.PlaywrightHelpers;

public class PaidRecomendationSystemPO {
    private Page page;
    private PlaywrightHelpers playwright;
    // ---  Owner Dashboard property not active   --- //

    private Locator widgetStatisticOD;
    private Locator titlePropertyNotActive;
    private Locator descPropertyNotActive;
    private Locator imagePropertyNotActive;
    private Locator statisticPage;
    private Locator apartementTitle;
    private Locator apartementDesc;
    private Locator nextPprsSlide;
    private Locator previousPprsSlide;


    public PaidRecomendationSystemPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.widgetStatisticOD = page.locator(".statistic-report-widget");
        this.titlePropertyNotActive = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Data Properti Belum Ada"));
        this.descPropertyNotActive = page.getByText("Anda belum punya properti yang terverifikasi. Data properti terverifikasi akan m");
        this.imagePropertyNotActive = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("kos-not-found"));
        this.statisticPage = page.locator(".statistic-menu");
        this.apartementTitle = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Statistik Apartemen Belum Ada"));
        this.apartementDesc = page.getByText("Mohon maaf, saat ini data performa untuk apartemen belum dapat ditampilkan. Tung");
        this.nextPprsSlide = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next slide")).first();
        this.previousPprsSlide = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Previous slide")).first();

    }

    /**
     * check section statistic visible or not
     */
    public boolean isStatisticSectionVisible() {
        playwright.waitForElementStateToBe(widgetStatisticOD, "visible");
        return playwright.waitTillLocatorIsVisible(widgetStatisticOD);
    }

    /**
     * get text title on section laporan statistic owner dashboard
     *
     * @return String
     */
    public String getTitleStatisticDoesntHavePropertyActive() {
        return playwright.getText(titlePropertyNotActive);
    }

    /**
     * get text desc on section laporan statistic owner dashboard
     *
     * @return String
     */
    public String getDescDoesntHavePropertyActive() {
        return playwright.getText(descPropertyNotActive);
    }

    /**
     * check is image property not active is show
     *
     * @return boolean
     */
    public boolean isImagePropertyNotActiveShow() {
        playwright.waitForElementStateToBe(imagePropertyNotActive, "visible");
        return playwright.waitTillLocatorIsVisible(imagePropertyNotActive);
    }

    /**
     * Navigates to Statistic page
     */
    public void navigatesToStatisticPage() {
        playwright.navigateTo(Mamikos.OWNER_URL + Mamikos.STATISTIC_PPRS, 5000.0, LoadState.LOAD);
        playwright.bringPageToView(page);
    }

    /**
     * check statistic page visible or not
     */
    public boolean isStatisticPageVisible() {
        playwright.waitForElementStateToBe(statisticPage, "visible");
        return playwright.waitTillLocatorIsVisible(statisticPage);
    }

    /**
     * get text title for condition apartement only on section laporan statistic owner dashboard
     *
     * @return String
     */
    public String getTitleStatisticApartement() {
        return playwright.getText(apartementTitle);
    }

    /**
     * get text title for condition apartement only on section laporan statistic page
     *
     * @return String
     */
    public String getTitleStatisticDescApartement() {
        return playwright.getText(apartementDesc);
    }

    public void tapNextPprsSlideIfExist() {
        if (playwright.isButtonEnable(nextPprsSlide)) {
            playwright.clickOn(nextPprsSlide);
        }
    }

    public void tapPreviousPprsSlideIfExist() {
        if (playwright.isButtonEnable(previousPprsSlide)) {
            playwright.clickOn(previousPprsSlide);
        }
    }
}
