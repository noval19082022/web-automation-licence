package config.playwright.context;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Tracing;
import config.playwright.PlaywrightSourceManager;
import config.playwright.browser.BrowserOptions;

public class PmsContextInitializer1 {

    /**
     * Initialize tenant browser context
     */
    public static void initializePmsBrowserContext1() {
        BrowserContext tenantContext = PlaywrightSourceManager.getLocalBrowser().newContext(BrowserOptions.browserContextOptions());
        PmsContext.setPmsBrowserContext1(tenantContext);
    }

    /**
     * Initialize tenant page
     */
    public static void initializePmsPage1() {
        PmsContext.getPmsBrowserContext1().tracing().start(new Tracing.StartOptions()
            .setScreenshots(true)
            .setSnapshots(true)
            .setSources(false));
        PmsActiveContext.setPmsActivePage1(PmsContext.getPmsBrowserContext1().newPage());
    }
}
