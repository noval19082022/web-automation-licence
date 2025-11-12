package config.playwright.context;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

/**
 * Thread-safe manager for multi-context scenarios.
 * Each thread can have two independent browser contexts (for multi-user tests).
 * Used with @context1 and @context2 tags.
 */
public class MamikosBrowserContext {
    private static ThreadLocal<BrowserContext> browserContextOne = new ThreadLocal<>();
    private static ThreadLocal<BrowserContext> browserContextTwo = new ThreadLocal<>();
    private static ThreadLocal<Page> contextOneActivePage = new ThreadLocal<>();
    private static ThreadLocal<Page> contextTwoActivePage = new ThreadLocal<>();

    /**
     * Gets the first browser context for the current thread.
     * @return BrowserContext instance or null if not set
     */
    public static BrowserContext getBrowserContextOne() {
        return browserContextOne.get();
    }

    /**
     * Sets the first browser context for the current thread.
     * @param context BrowserContext instance to set
     */
    public static void setBrowserContextOne(BrowserContext context) {
        browserContextOne.set(context);
    }

    /**
     * Gets the second browser context for the current thread.
     * @return BrowserContext instance or null if not set
     */
    public static BrowserContext getBrowserContextTwo() {
        return browserContextTwo.get();
    }

    /**
     * Sets the second browser context for the current thread.
     * @param context BrowserContext instance to set
     */
    public static void setBrowserContextTwo(BrowserContext context) {
        browserContextTwo.set(context);
    }

    /**
     * Gets the active page for context one in the current thread.
     * @return Page instance or null if not set
     */
    public static Page getContextOneActivePage() {
        return contextOneActivePage.get();
    }

    /**
     * Sets the active page for context one in the current thread.
     * @param page Page instance to set
     */
    public static void setContextOneActivePage(Page page) {
        contextOneActivePage.set(page);
    }

    /**
     * Gets the active page for context two in the current thread.
     * @return Page instance or null if not set
     */
    public static Page getContextTwoActivePage() {
        return contextTwoActivePage.get();
    }

    /**
     * Sets the active page for context two in the current thread.
     * @param page Page instance to set
     */
    public static void setContextTwoActivePage(Page page) {
        contextTwoActivePage.set(page);
    }

    /**
     * Cleans up resources for the current thread.
     * Closes both browser contexts and removes all ThreadLocal references.
     * MUST be called in @After hook to prevent memory leaks.
     */
    public static void cleanup() {
        BrowserContext ctx1 = browserContextOne.get();
        if (ctx1 != null) {
            ctx1.close();
            browserContextOne.remove();
        }

        BrowserContext ctx2 = browserContextTwo.get();
        if (ctx2 != null) {
            ctx2.close();
            browserContextTwo.remove();
        }

        contextOneActivePage.remove();
        contextTwoActivePage.remove();
    }
}
