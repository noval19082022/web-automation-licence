package config.playwright.context;

import com.microsoft.playwright.Tracing;
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
        MamikosBrowserContext.getBrowserContextOne().tracing().start(new Tracing.StartOptions()
            .setScreenshots(true)
            .setSnapshots(true)
            .setSources(false));
        MamikosBrowserContext.getBrowserContextOne().grantPermissions(grantPermissions);
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
        MamikosBrowserContext.getBrowserContextTwo().tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(false));
        MamikosBrowserContext.getBrowserContextTwo().grantPermissions(grantPermissions);
        MamikosBrowserContext.setContextTwoActivePage(MamikosBrowserContext.getBrowserContextTwo().newPage());
        ActiveContext.setActiveBrowserContext(MamikosBrowserContext.getBrowserContextTwo());
        ActiveContext.setActivePage(MamikosBrowserContext.getContextTwoActivePage());
    }
}
