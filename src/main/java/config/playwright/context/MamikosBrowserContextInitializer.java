package config.playwright.context;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Tracing;
import config.global.GlobalConfig;
import config.playwright.PlaywrightSourceManager;
import config.playwright.browser.BrowserOptions;

import java.nio.file.Paths;
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

        MamikosBrowserContext.getBrowserContextOne().grantPermissions(grantPermissions);

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

        MamikosBrowserContext.getBrowserContextTwo().grantPermissions(grantPermissions);

        browserContext2.grantPermissions(grantPermissions);
        browserContext2.setDefaultNavigationTimeout(GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT);
        browserContext2.setDefaultTimeout(GlobalConfig.DEFAULT_TIMEOUT);

        MamikosBrowserContext.setContextTwoActivePage(MamikosBrowserContext.getBrowserContextTwo().newPage());
        ActiveContext.setActiveBrowserContext(MamikosBrowserContext.getBrowserContextTwo());
        ActiveContext.setActivePage(MamikosBrowserContext.getContextTwoActivePage());
    }

    /**
     * Initialize mobile browser context with mobile viewport and user agent
     * Uses iPhone 12 dimensions (390x844) with 3x device scale factor
     */
    public static void initializeMobileBrowserContext() {
        // Create mobile context options
        Browser.NewContextOptions mobileOptions = new Browser.NewContextOptions();
        mobileOptions.setAcceptDownloads(GlobalConfig.SET_ACCEPT_DOWNLOAD);
        mobileOptions.setViewportSize(390, 844); // iPhone 12 dimensions
        mobileOptions.setDeviceScaleFactor(3);
        mobileOptions.setIsMobile(true);
        mobileOptions.setHasTouch(true);
        mobileOptions.setUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 16_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/16.0 Mobile/15E148 Safari/604.1");

        if (GlobalConfig.SET_VIDEO_RECORD) {
            mobileOptions.setRecordVideoDir(Paths.get("target/videos/"));
        }

        // Create browser context
        MamikosBrowserContext.setBrowserContextOne(
            PlaywrightSourceManager.getLocalBrowser().newContext(mobileOptions)
        );

        BrowserContext browserContext = MamikosBrowserContext.getBrowserContextOne();

        // Start tracing
        browserContext.tracing().start(new Tracing.StartOptions()
            .setScreenshots(true)
            .setSnapshots(true)
            .setSources(false));

        // Grant permissions
        browserContext.grantPermissions(grantPermissions);

        // Set timeouts
        browserContext.setDefaultNavigationTimeout(GlobalConfig.DEFAULT_NAVIGATION_TIMEOUT);
        browserContext.setDefaultTimeout(GlobalConfig.DEFAULT_TIMEOUT);

        // Create and set active page
        MamikosBrowserContext.setContextOneActivePage(browserContext.newPage());
        ActiveContext.setActiveBrowserContext(browserContext);
        ActiveContext.setActivePage(MamikosBrowserContext.getContextOneActivePage());

        System.out.println("Mobile browser context initialized with viewport: 390x844 (iPhone 12)");
    }
}
