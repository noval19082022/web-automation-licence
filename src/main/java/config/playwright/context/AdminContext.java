package config.playwright.context;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import lombok.Getter;
import lombok.Setter;

public class AdminContext {
    @Setter @Getter
    private static Page adminPage;
    @Setter @Getter
    private static BrowserContext adminBrowserContext;
}
