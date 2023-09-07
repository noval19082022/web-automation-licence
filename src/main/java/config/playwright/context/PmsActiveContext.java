package config.playwright.context;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import lombok.Getter;
import lombok.Setter;

public class PmsActiveContext {
    @Setter @Getter
    private static BrowserContext pmsActiveBrowserContext, pmsActiveBrowserContext1;
    @Setter @Getter
    private static Page pmsActivePage, pmsActivePage1;
    @Setter @Getter
    private static String contextName;

    /**
     * Active tenant context for multiple context scenario
     * @param pageIndex index page
     */
    public synchronized static void pmsActiveContext(int pageIndex) {
        PmsActiveContext.setPmsActiveBrowserContext(PmsContext.getPmsBrowserContext());
        PmsActiveContext.setPmsActivePage(PmsContext.getPmsBrowserContext().pages().get(pageIndex));
    }

    /**
     * Activate owner context for multiple context scenario
     * @param pageIndex index page
     */
    public synchronized static void pmsActiveContext1(int pageIndex) {
        PmsActiveContext.setPmsActiveBrowserContext1(PmsContext.getPmsBrowserContext1());
        PmsActiveContext.setPmsActivePage1(PmsContext.getPmsBrowserContext1().pages().get(pageIndex));
    }
}
