package config.playwright.context;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

public class UserContext {
    private static Page userPage;
    private static BrowserContext userBrowserContext;

    public static Page getUserPage() {
        return userPage;
    }

    public static void setUserPage(Page userPage){
        UserContext.userPage = userPage;
    }

    public static BrowserContext getUserBrowserContext() {
        return userBrowserContext;
    }

    public synchronized static void setUserBrowserContext(BrowserContext userBrowserContext) {
        UserContext.userBrowserContext = userBrowserContext;
    }
}
