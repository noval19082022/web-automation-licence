package utilities;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.ElementState;
import com.microsoft.playwright.options.LoadState;

import java.util.List;

public class PlaywrightHelpers {
    Page page;

    public PlaywrightHelpers(Page page) {
        this.page = page;
    }

    /**
     * This method navigates to a specified URL
     * default timeout
     */
    public void navigateTo(String url) {
        page.navigate(url);
    }

    /**
     * This method navigates to a specified URL with a specified timeout for the navigation to complete.
     *
     * @param url     String data type of URL format
     * @param timeout Double data type of specific timeout
     */
    public void navigateTo(String url, Double timeout) {
        page.navigate(url, new Page.NavigateOptions().setTimeout(timeout));
    }

    /**
     * This overloaded version of the navigateTo method waits for a specific load state before navigating to the URL.
     *
     * @param url   String data type of URL format
     * @param state The load state to wait for before navigating.
     */
    public void navigateTo(String url, Double timeout, LoadState state) {
        page.waitForLoadState(state);
        page.navigate(url, new Page.NavigateOptions().setTimeout(timeout));
    }

    /**
     * This overloaded version of the navigateTo method navigates to a URL and waits for a specific locator.
     *
     * @param url     String data type of URL format
     * @param locator The locator to wait for.
     */
    public void navigateToAndWaitLocator(String url, Locator locator) {
        page.navigate(url);
        locator.waitFor();
    }

    //----- Action Part ----\\

    /**
     * Click on a desired locator
     *
     * @param locator target locator
     */
    public void clickOn(Locator locator) {
        locator.click();
    }

    /**
     * Force click on desired locator
     * Use this method for locator that have disabled set to true
     *
     * @param locator target locator
     */
    public void forceClickOn(Locator locator) {
        locator.click(new Locator.ClickOptions().setForce(true));
    }

    /**
     * Delay and then click to a locator
     *
     * @param locator   Locator data type
     * @param delayTime Delay time in millisecond Double data type
     */
    public void delayAndClickOn(Locator locator, Double delayTime) {
        locator.click(new Locator.ClickOptions().setDelay(delayTime));
    }

    /**
     * Double-click on a desired locator
     *
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
     *
     * @param locator Locator type
     * @param value   String data type
     */
    public void selectDropdownByValue(Locator locator, String value) {
        locator.selectOption(value);
    }

    /**
     * By default, playwright will dismiss dialog/alert.
     * Set accept dialog then click element that trigger the dialog.
     */
    public void acceptDialog(Locator locator) {
        page.onceDialog(Dialog::accept);
        locator.click();
    }
    //----- Action Part ----\\

    //----- Get Part ----\\

    /**
     * Get locator attribute value
     *
     * @param locator target locator
     * @param att     target attribute
     * @return String data type
     */
    public String getAttributeValue(Locator locator, String att) {
        return locator.getAttribute(att);
    }

    /**
     * Get text content of an locator
     *
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
     *
     * @param locator target locator
     * @param state   visible, hidden, stable, enabled, disabled, editable
     */
    public void waitForElementStateToBe(Locator locator, String state) {
        locator.elementHandle().waitForElementState(ElementState.valueOf(state.toUpperCase()));
    }

    /**
     * Wait for element state to be
     *
     * @param locator target locator
     * @param state   visible, hidden, stable, enabled, disabled, editable
     * @Param timeout wait timeout on milisecond
     */
    public void waitForElementStateToBe(Locator locator, String state, Double timeout) {
        var elementOptionsHandler = new ElementHandle.WaitForElementStateOptions();
        locator.elementHandle().waitForElementState(ElementState.valueOf(state.toUpperCase()), elementOptionsHandler.setTimeout(timeout));
    }

    /**
     * Wait until url to be
     *
     * @param url String data type url format
     * @return String data type URL
     */
    public String waitTillUrlToBe(String url) {
        page.waitForURL(url);
        return page.url();
    }

    /**
     * Wait until url to be with timeout
     *
     * @param url      String data type url format
     * @param waitTime Double type
     * @return String data type URL
     */
    public String waitTillUrlToBe(String url, Double waitTime) {
        page.waitForURL(url, new Page.WaitForURLOptions().setTimeout(waitTime));
        return page.url();
    }

    public String clickAndWaitNavigation(Locator locator) {
        Response response = this.page.waitForNavigation(locator::click);
        return response.url();
    }

    /**
     * Wait until element locator is visible
     *
     * @param locator Locator type
     * @return boolean
     */
    public boolean waitTillLocatorIsVisible(Locator locator) {
        return locator.isVisible();
    }

    /**
     * Wait until element locator is visible
     *
     * @param locator Locator type
     * @param timeout Double type
     * @return boolean
     */
    public boolean waitTillLocatorIsVisible(Locator locator, Double timeout) {
        return locator.isVisible(new Locator.IsVisibleOptions().setTimeout(timeout));
    }

    public boolean isLocatorVisibleAfterLoad(Locator locator, Double timeout) {
        page.waitForLoadState(LoadState.LOAD);
        page.waitForTimeout(timeout);
        return locator.isVisible();
    }

    /**
     * Wait for a locator
     *
     * @param locator  Locator data type
     * @param duration set duration in double
     */
    public void waitFor(Locator locator, Double duration) {
        locator.waitFor(new Locator.WaitForOptions().setTimeout(duration));
    }
    //---- Wait Part ----\\

    //---- Locator Part ----\\

    /**
     * Filter html tag locator that contains target text
     *
     * @param locator Locator data type
     * @param text    target text
     * @return Locator data type
     */
    public Locator filterLocatorHasText(Locator locator, String text) {
        return locator.filter(new Locator.FilterOptions().setHasText(text));
    }

    /**
     * Get locator set by role and name
     *
     * @param role    AriaRole e.g AriaRole.BUTTON
     * @param setName name of the button
     * @return Locator data type
     */
    public Locator locatorByRoleSetName(AriaRole role, String setName) {
        return page.getByRole(role, new Page.GetByRoleOptions().setName(setName));
    }

    /**
     * Get locator by role and by text
     *
     * @param role AriaRole
     * @param text Text data type string
     * @return Locator type
     */
    public Locator locatorByRoleAndText(AriaRole role, String text) {
        return page.getByRole(role).getByText(text);
    }

    /**
     * Get locators as array list
     *
     * @param locator Locator type
     * @return List of locators
     */
    public List<Locator> getLocators(Locator locator) {
        return locator.all();
    }

    //---- Scroll Part ----\\

    /**
     * Scroll Helper horizontal and vertikal (per pixel)
     */
    public void pageScrollUsingCoordinate(int x, int y) {
        page.evaluate("scroll(" + x + "," + y + ")");
    }

    /**
     * Scroll Helper to the bottom page
     */
    public void pageScrollHeightToBottom() {
        page.evaluate("window.scrollBy(0,document.body.scrollHeight)");
    }

    /**
     * Scroll Helper vertical (per pixel)
     */
    public void pageScrollToDown(int y) {
        page.evaluate("window.scrollBy(0," + y + ")");
    }

    /**
     * Scroll Down Helper until locator is visible (per 100 pixel)
     */
    public void pageScrollUntilElementIsVisible(Locator locator) {
        for (int i = 0; i < 100; i++) {
            page.evaluate("window.scrollBy(0,100)");
            if (locator.isVisible()) {
                break;
            }
        }
    }

    /**
     * Move Page helper, it will return page object, so it can use to implement in next page taget
     * for example when select kost on promo side from home page, it will be move to kost detail
     * so this helper can be implement to return kost detail object on kostdetailPO with argument this page inside of the kost detail object
     * real example you can see DOM 4 on feature:kost detail and Scenario: [Dweb][Kost Detail] Check promo owner section login
     */
    public Page movePageByClickLocator(Page pageActive, Locator locatorTarget) {
        // move page
        Page nextPage = pageActive.waitForPopup(() -> {
            locatorTarget.click();
        });
        nextPage.bringToFront();
        return nextPage;
    }

    /*
     * hard wait 60 second
     *
     * */
    public void hardWait60Seconds() {
        page.waitForTimeout(60_000);
    }

    /**
     * Get Active URL page
     *
     * @return String URL Active page
     */
    public String getActivePageURL() {
        String activeUrl = page.evaluate("window.location.href").toString();
        return activeUrl;
    }

    /**
     * Get Active Title page
     *
     * @return String Title Active page
     */
    public String getActivePageTitle() {
        String activeTitle = page.evaluate("document.title").toString();
        return activeTitle;
    }
}
