package config.playwright.context;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import lombok.Getter;
import lombok.Setter;

public class MamikosBrowserContext {
    @Setter @Getter
    private static BrowserContext browserContextOne, browserContextTwo;
    @Setter @Getter
    private static Page contextOneActivePage, contextTwoActivePage;
    @Setter @Getter
    private static String contextName;
}
