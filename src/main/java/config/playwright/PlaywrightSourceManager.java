package config.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Playwright;

public class PlaywrightSourceManager {
    private static Browser localBrowser;
    private static Playwright localPlaywright;

    /**
     * Set local browser
     * @param localBrowser Browser Type
     */
    public static void setLocalBrowser(Browser localBrowser) {
        PlaywrightSourceManager.localBrowser = localBrowser;
    }

    /**
     * Get local browser
     * @return Browser type
     */
    public static Browser getLocalBrowser() {
        return PlaywrightSourceManager.localBrowser;
    }

    /**
     * Get local playwright
     * @return Playwright type
     */
    public static Playwright getLocalPlaywright() {
        return localPlaywright;
    }

    /**
     * Set local playwright
     * @param localPlaywright Playwright type
     */
    public static void setLocalPlaywright(Playwright localPlaywright) {
        PlaywrightSourceManager.localPlaywright = localPlaywright;
    }
}
