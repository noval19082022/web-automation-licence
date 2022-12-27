package config.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FrameworkManager {
    private static Page localPage;
    private static BrowserContext localBrowserContext;
    private static Browser localBrowser;
    private static Playwright localPlaywright;

    public static Page getLocalPage() {
        return localPage;
    }

    public static synchronized void setLocalPage(Page localPage) {
        FrameworkManager.localPage = localPage;
    }

    public static BrowserContext getLocalBrowserContext() {
        return localBrowserContext;
    }

    public static synchronized void setLocalBrowserContext(BrowserContext localBrowserContext) {
        FrameworkManager.localBrowserContext = localBrowserContext;
    }

    public static synchronized void setLocalBrowser(Browser localBrowser) {
        FrameworkManager.localBrowser = localBrowser;
    }

    public static Browser getLocalBrowser() {
        return FrameworkManager.localBrowser;
    }

    public static Playwright getLocalPlaywright() {
        return localPlaywright;
    }

    public static synchronized void setLocalPlaywright(Playwright localPlaywright) {
        FrameworkManager.localPlaywright = localPlaywright;
    }
}
