package pageobject.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import config.global.GlobalConfig;
import utilities.PlaywrightHelpers;

import java.util.List;

public class LoadingPO {
    private Page page;
    private PlaywrightHelpers playwright;

    private Locator loadingIcon;
    private Locator loadingAnimation;

    public LoadingPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(this.page);
        loadingIcon = page.locator(".c-loader");
        loadingAnimation = page.getByTestId("loading-animation");
    }

    /**
     * Wait for loading icon disappear
     */
    public void waitForLoadingIconDisappear() {
        var waitDelay = 5000.0;
        var maxLoop = 15;
        if (playwright.waitTillLocatorIsVisible(loadingIcon.first()) || playwright.waitTillLocatorIsVisible(loadingAnimation)) {
            List<Locator> loadingIconList = playwright.getLocators(loadingIcon);
            if (playwright.waitTillLocatorIsVisible(loadingIconList.get(0))) {
                for (Locator loadingIcon : loadingIconList) {
                    //playwright.waitTillLocatorIsNotVisible(loadingIcon, waitDelay, maxLoop);
                    playwright.waitForSelectorState(loadingIcon, WaitForSelectorState.DETACHED, GlobalConfig.LONG_TIMEOUT);
                }
            }
            if (playwright.waitTillLocatorIsVisible(loadingAnimation)) {
                //playwright.waitTillLocatorIsNotVisible(loadingAnimation, waitDelay, maxLoop);
                playwright.waitForSelectorState(loadingAnimation, WaitForSelectorState.DETACHED, GlobalConfig.LONG_TIMEOUT);
            }
        }
    }
}
