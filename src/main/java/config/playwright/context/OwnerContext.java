package config.playwright.context;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

public class OwnerContext {
    private static Page ownerPage;
    private static BrowserContext ownerBrowserContext;

    public static Page getOwnerPage() {
        return ownerPage;
    }

    public static void setOwnerPage(Page ownerPage) {
        OwnerContext.ownerPage = ownerPage;
    }

    public static BrowserContext getOwnerBrowserContext() {
        return ownerBrowserContext;
    }

    public static void setOwnerBrowserContext(BrowserContext ownerBrowserContext) {
        OwnerContext.ownerBrowserContext = ownerBrowserContext;
    }
}
