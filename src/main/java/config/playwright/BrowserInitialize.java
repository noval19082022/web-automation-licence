package config.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;

public class BrowserInitialize {

    /**
     * Get browser
     * @param browserName broser name supported by playwright
     * @param launchOptions
     * @return Browser playwrigh
     */
    public Browser getBrowser(String browserName, BrowserType.LaunchOptions launchOptions) {
        BrowserType browserType = null;

        switch (browserName.toLowerCase()) {
            case "chrome" -> browserType = FrameworkManager.getLocalPlaywright().chromium();
            case "firefox" -> browserType = FrameworkManager.getLocalPlaywright().firefox();
            case "webkit" -> browserType = FrameworkManager.getLocalPlaywright().webkit();
            default -> throw new RuntimeException("Unsupported playwright browser: " + browserName + " use these name instead chrome, firefox, webkit");
        }

        assert browserType != null;
        return browserType.launch(launchOptions);
    }

    /**
     * Get browser context
     * @param browser
     * @param newContextOptions browser context options
     * @return BrowserContext playwright
     */
    public BrowserContext getBrowserContext(Browser browser, Browser.NewContextOptions newContextOptions) {
        return browser.newContext(newContextOptions);
    }

    /**
     * Get page
     * @param browserContext browser context
     * @return Page playwright
     */
    public Page getPage(BrowserContext browserContext) {
        return browserContext.newPage();
    }
}