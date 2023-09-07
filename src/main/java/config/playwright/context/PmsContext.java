package config.playwright.context;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import lombok.Getter;
import lombok.Setter;

public class PmsContext {
    @Setter @Getter
    private static Page pmsPage, pmsPage1;
    @Setter @Getter
    private static BrowserContext pmsBrowserContext, pmsBrowserContext1;
}
