package config.playwright.context;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Tracing;
import config.playwright.PlaywrightSourceManager;
import config.playwright.browser.BrowserOptions;

public class PmsContextInitializer {
    private BrowserContext pmsBrowserContext;

    /**
     * Initialize tenant browser context
     */
    public static void initializePmsBrowserContext() {
        BrowserContext pmsBrowserContext = PlaywrightSourceManager.getLocalBrowser().newContext(BrowserOptions.browserContextOptions());
        PmsContext.setPmsBrowserContext(pmsBrowserContext);
    }

    /**
     * Initialize tenant page
     */
    public static void initializePmsPage() {
        PmsContext.getPmsBrowserContext().tracing().start(new Tracing.StartOptions()
            .setScreenshots(true)
            .setSnapshots(true)
            .setSources(false));
        PmsActiveContext.setPmsActivePage(PmsContext.getPmsBrowserContext().newPage());
        ActiveContext.setActivePage(PmsActiveContext.getPmsActivePage());
    }
}
