package utilities;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.ElementState;

public class PlaywrightHelpers {
    Page page;
    public PlaywrightHelpers(Page page) {
        this.page = page;
    }

    //----- Action Part ----\\

    /**
     * Click on a desired locator
     * @param locator target locator
     */
    public void clickOn(Locator locator) {
        locator.click();
    }

    /**
     * Force click on desired locator
     * Use this method for locator that have disabled set to true
     * @param locator target locator
     */
    public void forceClickOn(Locator locator) {
        locator.click(new Locator.ClickOptions().setForce(true));
    }

    /**
     * Delay and then click to a locator
     * @param locator Locator data type
     * @param delayTime Delay time in millisecond Double data type
     */
    public void delayAndClickOn(Locator locator, Double delayTime) {
        locator.click(new Locator.ClickOptions().setDelay(delayTime));
    }

    /**
     * Double-click on a desired locator
     * @param locator target locator
     */
    public void doubleClick(Locator locator) {
        locator.dblclick();
    }

    public void scrollTo(double deltaX, double deltaY) {
        page.mouse().wheel(deltaX, deltaX);
    }

    public void tapKeyboard(String key) {
        page.keyboard().down(key);
    }

    public void forceFill(Locator locator, String data) {
        locator.fill(data, new Locator.FillOptions().setForce(true));
    }

    /**
     * Select dropdown by value
     * @param locator Locator type
     * @param value String data type
     */
    public void selectDropdownByValue(Locator locator, String value) {
        locator.selectOption(value);
    }

    /**
     * Accept dialog
     */
    public void acceptDialog(Locator locator) {
        page.onceDialog(Dialog::accept);
        locator.click();
    }
    //----- Action Part ----\\

    //----- Get Part ----\\

    /**
     * Get locator attribute value
     * @param locator target locator
     * @param att target attribute
     * @return String data type
     */
    public String getAttributeValue(Locator locator, String att) {
        return locator.getAttribute(att);
    }

    /**
     * Get text content of an locator
     * @param locator target locator
     * @return String data type
     */
    public String getText(Locator locator) {
        return locator.textContent().trim();
    }

    //----- Get Part ----\\

    //---- Wait Part ----\\
    /**
     * Wait for element state to be
     * @param locator target locator
     * @param state visible, hidden, stable, enabled, disabled, editable
     */
    public void waitForElementStateToBe(Locator locator, String state) {
        locator.elementHandle().waitForElementState(ElementState.valueOf(state.toUpperCase()));
    }

    /**
     * Wait for element state to be
     * @param locator target locator
     * @param state visible, hidden, stable, enabled, disabled, editable
     * @Param timeout wait timeout on milisecond
     */
    public void waitForElementStateToBe(Locator locator, String state, Double timeout) {
        var elementOptionsHandler = new ElementHandle.WaitForElementStateOptions();
        locator.elementHandle().waitForElementState(ElementState.valueOf(state.toUpperCase()), elementOptionsHandler.setTimeout(timeout));
    }

    /**
     * Wait until url to be
     * @param url String data type url format
     * @return String data type URL
     */
    public String waitTillUrlToBe(String url) {
        page.waitForURL(url);
        return page.url();
    }

    /**
     * Wait until url to be with timeout
     * @param url String data type url format
     * @param waitTime Double type
     * @return String data type URL
     */
    public String waitTillUrlToBe(String url,Double waitTime) {
        page.waitForURL(url, new Page.WaitForURLOptions().setTimeout(waitTime));
        return page.url();
    }

    public String clickAndWaitNavigation(Locator locator) {
        Response response = this.page.waitForNavigation(locator::click);
        return response.url();
    }

    /**
     * Wait until element locator is visible
     * @param locator Locator type
     * @return boolean
     */
    public boolean waitTillLocatorIsVisible(Locator locator) {
        return locator.isVisible();
    }

    /**
     * Wait until element locator is visible
     * @param locator Locator type
     * @param timeout Double type
     * @return boolean
     */
    public boolean waitTillLocatorIsVisible(Locator locator, Double timeout) {
        return locator.isVisible(new Locator.IsVisibleOptions().setTimeout(timeout));
    }
    //---- Wait Part ----\\

    //---- Locator Part ----\\

    /**
     * Filter html tag locator that contains target text
     * @param locator Locator data type
     * @param text target text
     * @return Locator data type
     */
    public Locator filterLocatorHasText(Locator locator, String text) {
        return locator.filter(new Locator.FilterOptions().setHasText(text));
    }

    /**
     * Get locator set by role and name
     * @param role AriaRole e.g AriaRole.BUTTON
     * @param setName name of the button
     * @return Locator data type
     */
    public Locator locatorByRoleSetName(AriaRole role, String setName) {
        return page.getByRole(role, new Page.GetByRoleOptions().setName(setName));
    }

    /**
     * Get locator by role and by text
     * @param role AriaRole
     * @param text Text data type string
     * @return Locator type
     */
    public Locator locatorByRoleAndText(AriaRole role, String text) {
        return page.getByRole(role).getByText(text);
    }
}
