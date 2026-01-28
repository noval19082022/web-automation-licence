package pageobject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;

public class CommonPO {
    private Page page;
    private PlaywrightHelpers playwright;

    Locator guideDialog;
    Locator guideButton;

    public CommonPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);

        guideDialog = page.locator("[role='dialog'][aria-modal='true']");
        guideButton = page.locator("[role='dialog'][aria-modal='true'] button").first();
    }

    /**
     * Check if error page is displayed
     * @return true if error page is displayed
     */
    public boolean isErrorPageDisplayed() {
        try {
            // First check the page title for error codes
            String pageTitle = page.title();
            if (pageTitle != null) {
                String lowerTitle = pageTitle.toLowerCase();
                if (lowerTitle.contains("429") || lowerTitle.contains("502") || lowerTitle.contains("504") ||
                    lowerTitle.contains("error") || lowerTitle.contains("bad gateway") || lowerTitle.contains("timeout")) {
                    return true;
                }
            }

            // Check for error pages using a single efficient selector
            return playwright.waitTillLocatorIsVisible(
                page.locator("center h1:text-matches('(502|504|429|Bad Gateway|Gateway Timeout|Too Many Requests)'), body > h1:text-matches('(502|504|429)')"),
                1000.0
            );
        } catch (Exception e) {
            // If any error occurs while checking, assume no error page
            return false;
        }
    }

    /**
     * Check if guide dialog is visible
     * @return boolean true if visible, false otherwise
     */
    public boolean isGuideVisible() {
        return playwright.waitTillLocatorIsVisible(guideDialog, 3000.0);
    }

    /**
     * Dismiss guide by clicking the primary action button
     * This will click the first visible guide button (e.g., "Lihat Fitur", "Saya Mengerti", etc.)
     */
    public void dismissGuide() {
        if (playwright.waitTillLocatorIsVisible(guideDialog, 5000.0)) {
            playwright.hardWait(1000);
            playwright.forceClickOn(guideButton);
            playwright.hardWait(1000);
        }
    }

}