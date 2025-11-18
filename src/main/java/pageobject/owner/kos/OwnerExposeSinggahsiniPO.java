package pageobject.owner.kos;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class OwnerExposeSinggahsiniPO {
    private Page page;
    private PlaywrightHelpers playwright;

    public OwnerExposeSinggahsiniPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(this.page);
    }

    /**
     * Wait for page to be fully loaded to ensure popup has time to appear
     */
    public void waitForPageLoad() {
        playwright.waitTillPageLoaded(30000.0);
    }

    /**
     * Get locator for message text in popup
     * @param messageText The message text to find
     * @return Locator for the message
     */
    public Locator getPopupMessageLocator(String messageText) {
        return page.getByText(messageText);
    }

    /**
     * Get locator for button in popup
     * @param buttonText The button text to find
     * @return Locator for the button
     */
    public Locator getPopupButtonLocator(String buttonText) {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(buttonText));
    }

    /**
     * Wait for message to be visible in popup
     * @param messageText The message text to wait for
     */
    public void waitForPopupMessage(String messageText) {
        Locator messageLocator = getPopupMessageLocator(messageText);
        playwright.waitFor(messageLocator, 10000.0);
    }

    /**
     * Wait for button to be visible in popup
     * @param buttonText The button text to wait for
     */
    public void waitForPopupButton(String buttonText) {
        Locator buttonLocator = getPopupButtonLocator(buttonText);
        playwright.waitFor(buttonLocator, 10000.0);
    }

    /**
     * Check if message is visible in popup
     * @param messageText The message text to check
     * @return true if visible, false otherwise
     */
    public boolean isPopupMessageVisible(String messageText) {
        Locator messageLocator = getPopupMessageLocator(messageText);
        return messageLocator.isVisible();
    }

    /**
     * Check if button is visible in popup
     * @param buttonText The button text to check
     * @return true if visible, false otherwise
     */
    public boolean isPopupButtonVisible(String buttonText) {
        Locator buttonLocator = getPopupButtonLocator(buttonText);
        return buttonLocator.isVisible();
    }

    /**
     * Click button on the popup
     * @param buttonText The button text to click
     */
    public void clickPopupButton(String buttonText) {
        Locator button = getPopupButtonLocator(buttonText);
        playwright.clickOn(button);
        // Wait for navigation to complete after clicking the button
        playwright.waitTillPageLoaded(60000.0);
    }

    /**
     * Get the current page URL
     * @return Current URL
     */
    public String getCurrentUrl() {
        return page.url();
    }

    /**
     * Check if current URL contains specified text
     * @param urlPart The text to check in URL
     * @return true if URL contains the text, false otherwise
     */
    public boolean urlContains(String urlPart) {
        return getCurrentUrl().contains(urlPart);
    }

    /**
     * Check if URL contains singgahsini.id domain
     * @return true if redirected to singgahsini.id, false otherwise
     */
    public boolean isRedirectedToSinggahsini() {
        return urlContains("singgahsini.id");
    }

    /**
     * Check if URL contains source parameter with specified value
     * The source parameter can be in various encoded formats:
     * - redirection_source='value' (with quotes)
     * - spaces encoded as + or %20
     * - quotes encoded as %27
     * @param source The source value to check for
     * @return true if URL contains the source parameter, false otherwise
     */
    public boolean urlContainsSourceParameter(String source) {
        String currentUrl = getCurrentUrl();

        // Check for various formats of the source parameter
        boolean hasSourceParam = currentUrl.contains("redirection_source") ||
                                currentUrl.contains("source=" + source) ||
                                currentUrl.contains("source=" + source.replace(" ", "+")) ||
                                currentUrl.contains("source=" + source.replace(" ", "%20"));

        return hasSourceParam;
    }
}
