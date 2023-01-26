package config.playwright.browser;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import config.playwright.PlaywrightSourceManager;

public class BrowserInitialize {

    /**
     * Get browser
     *
     * @param browserName   broser name supported by playwright
     * @param launchOptions
     * @return Browser playwrigh
     */
    public Browser getBrowser(String browserName, BrowserType.LaunchOptions launchOptions) {
        BrowserType browserType = null;

        switch (browserName.toLowerCase()) {
            case "chrome" -> browserType = PlaywrightSourceManager.getLocalPlaywright().chromium();
            case "firefox" -> browserType = PlaywrightSourceManager.getLocalPlaywright().firefox();
            case "webkit" -> browserType = PlaywrightSourceManager.getLocalPlaywright().webkit();
            default ->
                    throw new RuntimeException("Unsupported playwright browser: " + browserName + " use these name instead chrome, firefox, webkit");
        }

        assert browserType != null;
        return browserType.launch(launchOptions);
    }
}