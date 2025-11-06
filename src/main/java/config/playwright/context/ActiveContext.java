package config.playwright.context;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

/**
 * Thread-safe manager for active browser context and page.
 * Each thread maintains its own active context and page instance.
 */
public class ActiveContext {
    private static ThreadLocal<BrowserContext> activeBrowserContext = new ThreadLocal<>();
    private static ThreadLocal<Page> activePage = new ThreadLocal<>();

    /**
     * Gets the active BrowserContext for the current thread.
     * @return BrowserContext instance or null if not set
     */
    public static BrowserContext getActiveBrowserContext() {
        return activeBrowserContext.get();
    }

    /**
     * Sets the active BrowserContext for the current thread.
     * @param context BrowserContext instance to set
     */
    public static void setActiveBrowserContext(BrowserContext context) {
        activeBrowserContext.set(context);
    }

    /**
     * Gets the active Page for the current thread.
     * @return Page instance or null if not set
     */
    public static Page getActivePage() {
        return activePage.get();
    }

    /**
     * Sets the active Page for the current thread.
     * @param page Page instance to set
     */
    public static void setActivePage(Page page) {
        activePage.set(page);
    }

    /**
     * Cleans up resources for the current thread.
     * Removes ThreadLocal references to prevent memory leaks.
     * Note: Does NOT close the context/page (managed by MamikosBrowserContext).
     */
    public static void cleanup() {
        activeBrowserContext.remove();
        activePage.remove();
    }
}
