package config.playwright.context;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Tracing;
import config.playwright.PlaywrightSourceManager;
import config.playwright.browser.BrowserOptions;

public class MamikosBrowserContextInitializer {
    private static BrowserContext browserContext1 = PlaywrightSourceManager.getLocalBrowser().newContext(BrowserOptions.browserContextOptions());
    private static BrowserContext browserContext2 = PlaywrightSourceManager.getLocalBrowser().newContext(BrowserOptions.browserContextOptions());

    /**
     * Initialize browser context number one
     */
    public static void initializeBrowserContextOne() {
        MamikosBrowserContext.setBrowserContextOne(browserContext1);
    }

    /**
     * Initialize browser context number one page
     */
    public static void initializeBrowserContextOnePage() {
        MamikosBrowserContext.getBrowserContextOne().tracing().start(new Tracing.StartOptions()
            .setScreenshots(true)
            .setSnapshots(true)
            .setSources(false));
        MamikosBrowserContext.setContextOneActivePage(MamikosBrowserContext.getBrowserContextOne().newPage());
        ActiveContext.setActivePage(MamikosBrowserContext.getContextOneActivePage());
    }

    /**
     * Initialize browser context number two
     */
    public static void initializeBrowserContextTwo() {
        MamikosBrowserContext.setBrowserContextTwo(browserContext2);
    }

    /**
     * Initialize browser context number two page
     */
    public static void initializeBrowserContextTwoPage() {
        MamikosBrowserContext.getBrowserContextTwo().tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(false));
        MamikosBrowserContext.setContextTwoActivePage(MamikosBrowserContext.getBrowserContextTwo().newPage());
        ActiveContext.setActivePage(MamikosBrowserContext.getContextTwoActivePage());
    }
}
