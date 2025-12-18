package pageobject.tenant;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;

public class SuccessBookingPO {
    Page page;
    PlaywrightHelpers playwrightHelpers;
    Locator successBookingHeadingText;
    Locator bookingContainer;
    public SuccessBookingPO(Page page) {
        this.page = page;
        this.playwrightHelpers = new PlaywrightHelpers(page);
        this.bookingContainer = page.locator("#bookingContainer");
        this.successBookingHeadingText = page.locator("//*[@class=\"booking-success__cta\"]/button");
    }

    /**
     * Wait until booking is process is finished
     */
    public void waitUntilSuccessBookingHeadingVisible() {
        playwrightHelpers.waitForElementStateToBe(successBookingHeadingText, "visible");
    }

    /**
     * Get success booking heading text
     * @return String data type
     */
    public String getSuccessBookingHeadingText() {
        return successBookingHeadingText.textContent();
    }
}
