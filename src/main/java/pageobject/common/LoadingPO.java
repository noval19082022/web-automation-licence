package pageobject.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;
import config.global.GlobalConfig;
import utilities.PlaywrightHelpers;

import java.util.List;

public class LoadingPO {
    private Page page;
    private PlaywrightHelpers playwright;

    private Locator loadingIcon;
    private Locator loadingAnimation;
    private Locator skeletonLoader;

    public LoadingPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(this.page);
        loadingIcon = page.locator(".c-loader");
        loadingAnimation = page.getByTestId("loading-animation");
        skeletonLoader = page.locator(".skeleton:not([class*='bg-c-skeleton']), [class*='shimmer'], [class*='loading-skeleton']");
    }

    /**
     * Wait for loading icon disappear
     */
    public void waitForLoadingIconDisappear() {
        if (playwright.waitTillLocatorIsVisible(loadingIcon.first()) || playwright.waitTillLocatorIsVisible(loadingAnimation)) {
            List<Locator> loadingIconList = playwright.getLocators(loadingIcon);
            page.reload();
            if (playwright.waitTillLocatorIsVisible(loadingIconList.get(0))) {
                for (Locator loadingIcon : loadingIconList) {
                    playwright.waitForSelectorState(loadingIcon, WaitForSelectorState.HIDDEN, GlobalConfig.LONG_TIMEOUT);
                }
            }
            if (playwright.waitTillLocatorIsVisible(loadingAnimation)) {
                playwright.waitForSelectorState(loadingAnimation, WaitForSelectorState.HIDDEN, GlobalConfig.LONG_TIMEOUT);
            }
        }
    }

    public boolean loadingAnimationIsExist() {
        return playwright.waitTillLocatorIsVisible(loadingAnimation) || playwright.waitTillLocatorIsVisible(loadingIcon);
    }


    /**
     * Wait until skeleton loading animation disappears
     * Skeleton loaders typically use CSS class 'skeleton' or similar shimmer animations
     * This ensures content has fully loaded before proceeding with test actions
     *
     * @param timeout timeout in milliseconds
     */
    public void waitTillSkeletonLoadingDisappears(Double timeout) {
        // Use class-level skeleton loader locator
        // Check if skeleton exists before waiting
        if (skeletonLoader.count() > 0) {
            skeletonLoader.first().waitFor(new Locator.WaitForOptions()
                    .setState(WaitForSelectorState.HIDDEN)
                    .setTimeout(timeout));
        }
        // If skeleton doesn't exist, it's already loaded - continue execution
    }

    /**
     * Wait until all fetch API calls are finished in the browser with custom timeout
     * This method waits for network idle state with a specified timeout
     *
     * @param timeout timeout in milliseconds
     */
    public void waitTillFetchFinish(Double timeout) {
        // Wait for network to be idle with custom timeout
        page.waitForLoadState(LoadState.NETWORKIDLE, new Page.WaitForLoadStateOptions().setTimeout(timeout));

        // Additional check: evaluate JavaScript to ensure no pending fetch calls
        playwright.waitTillDomContentLoaded(timeout);

        // Wait for skeleton loaders to disappear
        waitTillSkeletonLoadingDisappears(timeout);
    }


    /**
     * Wait until skeleton loading animation disappears with default timeout
     */
    public void waitTillSkeletonLoadingDisappears() {
        waitTillSkeletonLoadingDisappears(30000.0); // Default 30 seconds
    }
}
