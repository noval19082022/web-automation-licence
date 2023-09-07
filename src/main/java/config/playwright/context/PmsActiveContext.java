package config.playwright.context;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import config.global.FlowControl;
import lombok.Getter;
import lombok.Setter;

public class PmsActiveContext {
    @Setter @Getter
    private static BrowserContext pmsActiveBrowserContext, pmsActiveBrowserContext1;
    @Setter @Getter
    private static Page pmsActivePage, pmsActivePage1;
    @Setter @Getter
    private static String contextName;
}
