package config.global;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;

import java.nio.file.Paths;

public class BrowserOptions {
    public BrowserType.LaunchOptions launchOptions() {
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.headless = GlobalConfig.HEADLESS;
        launchOptions.devtools = GlobalConfig.DEV_TOOLS;
        launchOptions.slowMo = GlobalConfig.SLOW_MO;
        return launchOptions;
    }

    public Browser.NewContextOptions browserContextOptions() {
        Browser.NewContextOptions contextOptions = new Browser.NewContextOptions();
        contextOptions.setAcceptDownloads(GlobalConfig.SET_ACCEPT_DOWNLOAD);
        contextOptions.setRecordVideoDir(Paths.get("target/videos/"));
        return contextOptions;
    }
}
