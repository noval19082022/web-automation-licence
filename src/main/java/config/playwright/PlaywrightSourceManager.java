package config.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Playwright;

/**
 * Thread-safe manager for Playwright and Browser instances.
 * Each thread gets its own isolated Browser and Playwright instance.
 */
public class PlaywrightSourceManager {
    private static ThreadLocal<Browser> localBrowser = new ThreadLocal<>();
    private static ThreadLocal<Playwright> localPlaywright = new ThreadLocal<>();

    /**
     * Gets the Browser instance for the current thread.
     * @return Browser instance or null if not set
     */
    public static Browser getLocalBrowser() {
        return localBrowser.get();
    }

    /**
     * Sets the Browser instance for the current thread.
     * @param browser Browser instance to set
     */
    public static void setLocalBrowser(Browser browser) {
        localBrowser.set(browser);
    }

    /**
     * Gets the Playwright instance for the current thread.
     * @return Playwright instance or null if not set
     */
    public static Playwright getLocalPlaywright() {
        return localPlaywright.get();
    }

    /**
     * Sets the Playwright instance for the current thread.
     * @param playwright Playwright instance to set
     */
    public static void setLocalPlaywright(Playwright playwright) {
        localPlaywright.set(playwright);
    }

    /**
     * Cleans up resources for the current thread.
     * Closes Browser and Playwright instances and removes them from ThreadLocal.
     * MUST be called in @AfterTest to prevent memory leaks.
     */
    public static void cleanup() {
        Browser browser = localBrowser.get();
        if (browser != null) {
            browser.close();
            localBrowser.remove();
        }

        Playwright playwright = localPlaywright.get();
        if (playwright != null) {
            playwright.close();
            localPlaywright.remove();
        }
    }
}
