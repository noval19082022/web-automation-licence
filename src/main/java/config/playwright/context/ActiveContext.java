package config.playwright.context;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import lombok.Getter;
import lombok.Setter;

public class ActiveContext {
    @Setter @Getter
    private static BrowserContext activeBrowserContext;
    @Setter @Getter
    private static Page activePage;
    @Setter @Getter
    private static String contextName;

    /**
     * Active tenant context for multiple context scenario
     * @param pageIndex index page
     */
    public synchronized static void activateTenant(int pageIndex) {
        ActiveContext.setActiveBrowserContext(TenantContext.getTenantBrowserContext());
        ActiveContext.setActivePage(TenantContext.getTenantBrowserContext().pages().get(pageIndex));
    }

    /**
     * Activate owner context for multiple context scenario
     * @param pageIndex index page
     */
    public synchronized static void activateOwner(int pageIndex) {
        ActiveContext.setActiveBrowserContext(OwnerContext.getOwnerBrowserContext());
        ActiveContext.setActivePage(OwnerContext.getOwnerBrowserContext().pages().get(pageIndex));
    }

    /**
     * Activate admin context for multiple context scenario
     * @param pageIndex
     */
    public static void activateAdmin(int pageIndex) {
        System.out.println("later" + pageIndex);
    }
}
