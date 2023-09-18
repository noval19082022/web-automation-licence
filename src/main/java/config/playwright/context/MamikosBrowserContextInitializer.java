package config.playwright.context;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Tracing;
import config.global.GlobalConfig;
import config.playwright.PlaywrightSourceManager;
import config.playwright.browser.BrowserOptions;

import java.util.List;

public class MamikosBrowserContextInitializer {
    private static List<String> grantPermissions = List.of("geolocation");

    /**
     * Initialize browser context number one
     */
    public static void initializeBrowserContextOne() {
        MamikosBrowserContext.setBrowserContextOne(PlaywrightSourceManager.getLocalBrowser().newContext(BrowserOptions.browserContextOptions()));
    }

    /**
     * Initialize browser context number one page
     */
    public static void initializeBrowserContextOnePage() {
        BrowserContext browserContext1 = MamikosBrowserContext.getBrowserContextOne();
        MamikosBrowserContext.getBrowserContextOne().tracing().start(new Tracing.StartOptions()
            .setScreenshots(true)
            .setSnapshots(true)
            .setSources(false));
        browserContext1.grantPermissions(grantPermissions);
        browserContext1.setDefaultNavigationTimeout(GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT);
        browserContext1.setDefaultTimeout(GlobalConfig.DEFAULT_TIMEOUT);
        MamikosBrowserContext.setContextOneActivePage(MamikosBrowserContext.getBrowserContextOne().newPage());
        ActiveContext.setActiveBrowserContext(MamikosBrowserContext.getBrowserContextOne());
        ActiveContext.setActivePage(MamikosBrowserContext.getContextOneActivePage());
    }

    /**
     * Initialize browser context number two
     */
    public static void initializeBrowserContextTwo() {
        MamikosBrowserContext.setBrowserContextTwo(PlaywrightSourceManager.getLocalBrowser().newContext(BrowserOptions.browserContextOptions()));
    }

    /**
     * Initialize browser context number two page
     */
    public static void initializeBrowserContextTwoPage() {
        BrowserContext browserContext2 = MamikosBrowserContext.getBrowserContextTwo();
        MamikosBrowserContext.getBrowserContextTwo().tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(false));
        browserContext2.grantPermissions(grantPermissions);
        browserContext2.setDefaultNavigationTimeout(GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT);
        browserContext2.setDefaultTimeout(GlobalConfig.DEFAULT_TIMEOUT);
        MamikosBrowserContext.setContextTwoActivePage(MamikosBrowserContext.getBrowserContextTwo().newPage());
        ActiveContext.setActiveBrowserContext(MamikosBrowserContext.getBrowserContextTwo());
        ActiveContext.setActivePage(MamikosBrowserContext.getContextTwoActivePage());
    }
}
