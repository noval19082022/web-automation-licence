package config.playwright.context;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

public class ActiveContext {
    private static BrowserContext activeBrowserContext;
    private static Page activePage;
    private static String contextName;

    public static void setActiveBrowserContext(BrowserContext activeBrowserContext) {
        ActiveContext.activeBrowserContext = activeBrowserContext;
    }

    public static BrowserContext getActiveBrowserContext() {
        return activeBrowserContext;
    }

    public static void setActivePage(Page activePage) {
        ActiveContext.activePage = activePage;
    }

    public static Page getActivePage() {
        return activePage;
    }

    public static void setContextName(String contextName) {
        ActiveContext.contextName = contextName;
    }

    public static String getContextName() {
        return contextName;
    }
}
