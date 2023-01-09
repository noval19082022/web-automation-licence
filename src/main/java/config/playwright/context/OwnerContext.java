package config.playwright.context;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

public class OwnerContext {
    private static Page ownerPage;
    private static BrowserContext ownerBrowserContext;

    /**
     * Get owner page
     * @return Page type
     */
    public static Page getOwnerPage() {
        return ownerPage;
    }

    /**
     * Set owner page
     * @param ownerPage Page type
     */
    public static void setOwnerPage(Page ownerPage) {
        OwnerContext.ownerPage = ownerPage;
    }

    /**
     * Get owner browser context
     * @return BrowserContext
     */
    public static BrowserContext getOwnerBrowserContext() {
        return ownerBrowserContext;
    }

    /**
     * Set owner browser context
     * @param ownerBrowserContext BrowserContext
     */
    public synchronized static void setOwnerBrowserContext(BrowserContext ownerBrowserContext) {
        OwnerContext.ownerBrowserContext = ownerBrowserContext;
    }
}
