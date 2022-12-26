package config.browser;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Tracing;
import config.global.GlobalConfig;

import java.nio.file.Paths;

public class FrameworkInitialize {

    public Page initializePlaywright() {
        BrowserInitialize browserInitialize = new BrowserInitialize();

        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.headless = GlobalConfig.HEADLESS;
        launchOptions.devtools = GlobalConfig.DEV_TOOLS;
        launchOptions.slowMo = GlobalConfig.SLOW_MO;

        FrameworkConfig.localBrowser = browserInitialize.getBrowser(GlobalConfig.BROWSER_NAME, launchOptions);

        Browser.NewContextOptions contextOptions = new Browser.NewContextOptions();
        contextOptions.setAcceptDownloads(GlobalConfig.SET_ACCEPT_DOWNLOAD);
        contextOptions.setRecordVideoDir(Paths.get("target/videos/"));

        FrameworkConfig.localBrowserContext = browserInitialize.getBrowserContext(FrameworkConfig.localBrowser, contextOptions);
        FrameworkConfig.localBrowserContext.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(false));
        return FrameworkConfig.localPage = browserInitialize.getPage(FrameworkConfig.localBrowserContext);
    }
}
