package config.browser;

import com.microsoft.playwright.*;

public class BrowserInitialize {

    public Browser getBrowser(String browserName, BrowserType.LaunchOptions launchOptions) {
        FrameworkConfig.localPlaywright = Playwright.create();
        BrowserType browserType = null;

        switch (browserName.toLowerCase()) {
            case "chrome" -> browserType = FrameworkConfig.localPlaywright.chromium();
            case "firefox" -> browserType = FrameworkConfig.localPlaywright.firefox();
            case "webkit" -> browserType = FrameworkConfig.localPlaywright.webkit();
            default -> throw new RuntimeException("Unsupported playwright browser: " + browserName + " use these name instead chrome, firefox, webkit");
        }

        assert browserType != null;
        return browserType.launch(launchOptions);
    }

    public BrowserContext getBrowserContext(Browser browser, Browser.NewContextOptions newContextOptions) {
        return browser.newContext(newContextOptions);
    }

    public Page getPage(BrowserContext browserContext) {
        return browserContext.newPage();
    }
}