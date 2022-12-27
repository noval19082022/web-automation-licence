package config.playwright;

import com.microsoft.playwright.Tracing;
import config.global.BrowserOptions;

public class FrameworkInitialize {
    BrowserInitialize browserInitialize = new BrowserInitialize();
    BrowserOptions browserOptions = new BrowserOptions();

    public void initializeBrowserContext() {
        FrameworkManager.setLocalBrowserContext(browserInitialize.getBrowserContext(FrameworkManager.getLocalBrowser(), browserOptions.browserContextOptions()));
    }

    public void initializePage() {
        FrameworkManager.getLocalBrowserContext().tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(false));
        FrameworkManager.setLocalPage(browserInitialize.getPage(FrameworkManager.getLocalBrowserContext()));
    }
}
