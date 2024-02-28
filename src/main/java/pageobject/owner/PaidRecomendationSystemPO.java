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



    public PaidRecomendationSystemPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.widgetStatisticOD = page.locator(".statistic-report-widget");
        this.titlePropertyNotActive = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Data Properti Belum Ada"));
        this.descPropertyNotActive = page.getByText("Anda belum punya properti yang terverifikasi. Data properti terverifikasi akan m");
        this.imagePropertyNotActive = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("kos-not-found"));
        this.statisticPage = page.locator(".statistic-menu");
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
     * @return String
     */
    public String getTitleStatisticDoesntHavePropertyActive() {
        return playwright.getText(titlePropertyNotActive);
    }

    /**
     * get text desc on section laporan statistic owner dashboard
     * @return String
     */
    public String getDescDoesntHavePropertyActive() {
        return playwright.getText(descPropertyNotActive);
    }

    /**
     * check is image property not active is show
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
        playwright.navigateTo(Mamikos.OWNER_URL + Mamikos.STATISTIC_PPRS, 50000.0, LoadState.LOAD);
        playwright.bringPageToView(page);
    }

    /**
     * check statistic page visible or not
     */
    public boolean isStatisticPageVisible() {
        playwright.waitForElementStateToBe(statisticPage, "visible");
        return playwright.waitTillLocatorIsVisible(statisticPage);
    }
}
