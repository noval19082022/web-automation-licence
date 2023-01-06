package config.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Playwright;

public class PlaywrightSourceManager {
    private static Browser localBrowser;
    private static Playwright localPlaywright;

    public static void setLocalBrowser(Browser localBrowser) {
        PlaywrightSourceManager.localBrowser = localBrowser;
    }

    public static Browser getLocalBrowser() {
        return PlaywrightSourceManager.localBrowser;
    }

    public static Playwright getLocalPlaywright() {
        return localPlaywright;
    }

    public static void setLocalPlaywright(Playwright localPlaywright) {
        PlaywrightSourceManager.localPlaywright = localPlaywright;
    }
}
