package pageobject.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;

import java.awt.*;
import java.util.List;

public class LoadingPO {
    private Page page;
    private PlaywrightHelpers playwright;

    private Locator loadingIcon;
    private Locator loadingAnimation;

    public LoadingPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(this.page);
        loadingIcon = page.locator("span.c-loader");
        loadingAnimation = page.getByTestId("loading-animation");
    }

    /**
     * Wait for loading icon disappear
     */
    public void waitForLoadingIconDisappear() {
        var waitDelay = 1000.0;
        var maxLoop = 10;
        List<Locator> loadingIconList = playwright.getLocators(loadingIcon);
        if (playwright.waitTillLocatorIsVisible(loadingIconList.get(0))) {
            for (Locator loadingIcon : loadingIconList) {
                playwright.waitTillLocatorIsNotVisible(loadingIcon, waitDelay, maxLoop);
            }
        }
        playwright.waitTillLocatorIsNotVisible(loadingAnimation, waitDelay, maxLoop);
    }
}
