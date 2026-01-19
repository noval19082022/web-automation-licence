package utilities;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.Paths;
import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@Slf4j
public class PlaywrightHelpers {
    Page page;
    String date;

    public PlaywrightHelpers(Page page) {
        this.page = page;
    }

    /**
     * Reload page
     */
    public void reloadPage() {
        page.reload();
    }

    /**
     * this method will be reload the active page if element is not visible after loading
     *
     * @param times   how many you would to reload
     * @param locator the expected locator that you want to visible
     */
    public void reloadPageIfLocatorNotVisibleAfterLoad(int times, Locator locator) {
        if (this.isLocatorVisibleAfterLoad(locator, 1000.0)) {
            for (int i = 0; i < times; i++) {
                reloadPage();
                if (waitTillLocatorIsVisible(locator)) break;
            }
        }
    }

    /**
     * Reloads the current page if a specific element is not visible.
     * This method checks if the provided locator element is visible within a short timeout (e.g., 1 second) after the page loads.
     * If not, it attempts to reload the page up to the specified number of times (`times`) until the element becomes visible.
     *
     * @param times   The maximum number of times to attempt reloading the page.
     * @param locator The expected locator element to check for visibility.
     */
    public void reloadPageIfElementNotVisible(int times, Locator locator) {
        for (int i = 0; i < times; i++) {
            reloadPage();
            if (waitTillLocatorIsVisible(locator)) break;
        }
    }

    /**
     * Reload page with timeout
     *
     * @param timeout
     */
    public void reloadPage(Double timeout) {
        page.reload(new Page.ReloadOptions().setTimeout(timeout));
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
     * @param timeout Double data type of specific timeout
     * @param state The load state to wait for before navigating.
     */
    public void navigateTo(String url, Double timeout, LoadState state) {
        page.waitForLoadState(state, new Page.WaitForLoadStateOptions().setTimeout(timeout));
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

    /**
     * This overloaded version of the navigateTo method navigates to a URL and waits for a specific locator.
     *
     * @param url     String data type of URL format
     * @param locator The locator to wait for.
     * @param timeout Double data type of specific timeout
     */
    public void navigateToAndWaitLocator(String url, Locator locator, Double timeout) {
        page.navigate(url);
        locator.waitFor(new Locator.WaitForOptions().setTimeout(timeout));
    }

    /**
     * Back to previous page
     */
    public void backToPreviousPage() {
        page.goBack();
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
     * Click on a desired locator
     *
     * @param locator target locator
     * @param timeout timeout in milliseconds
     * @param state   WaitForSelectorState VISIBLE ATTACHED DETACHED
     */
    public void clickOn(Locator locator, Double timeout, WaitForSelectorState state) {
        locator.waitFor(new Locator.WaitForOptions().setState(state).setTimeout(timeout));
        locator.click(new Locator.ClickOptions());
    }

    /**
     * click on locator and typing inside of placeholder like real keyboard
     *
     * @param element
     * @param type
     */
    public void clickLocatorAndTypeKeyboard(Locator element, String type) {
        clickOn(element);
        realKeyboardType(type);
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
     * Delay and then force click to a locator
     *
     * @param locator   Locator data type
     * @param delayTime Delay time in millisecond Double data type
     */
    public void delayAndForceClickOn(Locator locator, Double delayTime) {
        locator.click(new Locator.ClickOptions().setForce(true).setDelay(delayTime));
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

    /**
     * Double-click on a desired locator
     *
     * @param locator   target locator
     * @param delayTime Delay time in millisecond Double data type
     */
    public void doubleClickAndDelay(Locator locator, Double delayTime) {
        locator.dblclick(new Locator.DblclickOptions().setDelay(delayTime));
    }

    /**
     * Wait till locator is visible then click on desired locator
     *
     * @param locator target locator
     */
    public void waitForLocatorVisibleAndClickOn(Locator locator) {
        waitTillLocatorIsVisible(locator);
        locator.click();
    }

    /**
     * click locator if some locator exist
     * this method is suitable for dynamic element
     *
     * @param locatorCLick target click locator
     */
    public void clickIfElementVisible(Locator locatorCLick) {
        if (waitTillLocatorIsVisible(locatorCLick)) {
            clickOn(locatorCLick);
        } else {
            logElementNotClickable(locatorCLick);
        }
    }

    /**
     * click locator if some locator exist
     * this method is suitable for dynamic element
     *
     * @param locatorCLick target click locator
     * @param locatorWait  locator wait
     * @param timeout      timeout in milliseconds
     */
    public void clickIfElementVisible(Locator locatorCLick, Locator locatorWait, Double timeout) {
        if (waitTillLocatorIsVisible(locatorCLick)) {
            forceClickOn(locatorCLick);
            waitForSelectorState(locatorWait, WaitForSelectorState.VISIBLE, timeout);
        } else {
            logElementNotClickable(locatorCLick);
        }
    }

    /**
     * click locator if some locator exist after load
     * this method is suitable for dynamic pop up
     *
     * @param locatorCLick target click locator
     * @param timeout      timeout
     */
    public void clickIfElementVisibleAfterLoad(Locator locatorCLick, double timeout) {
        if (isLocatorVisibleAfterLoad(locatorCLick, timeout)) {
            clickOn(locatorCLick);
        } else {
            logElementNotClickable(locatorCLick);
        }
    }

    /**
     * Scroll to coordinate
     *
     * @param deltaX
     * @param deltaY
     */
    public void scrollTo(double deltaX, double deltaY) {
        page.mouse().wheel(deltaX, deltaX);
    }

    /**
     * Simulate tap keyboard
     *
     * @param key
     */
    public void tapKeyboard(String key) {
        page.keyboard().down(key);
    }

    /**
     * Force fill input to locator with disabled fill attribute
     *
     * @param locator targeted locator
     * @param data    String data type
     */
    public void forceFill(Locator locator, String data) {
        locator.fill(data, new Locator.FillOptions().setForce(true));
    }

    /**
     * Fill input to locator
     *
     * @param locator targeted locator
     * @param data    String data type
     */
    public void fill(Locator locator, String data) {
        locator.fill(data);
    }

    /**
     * Input to locator character by character
     *
     * @param locator locator targeted locator
     * @param data    data String data type
     */
    public void fillCharacterByCharacter(Locator locator, String data) {
        locator.pressSequentially(data, new Locator.PressSequentiallyOptions().setDelay(1000.0));
    }

    /**
     * Input to locator character by character with delay
     *
     * @param locator input
     * @param data    text
     * @param delay   delay
     */
    public void fillCharacterByCharacter(Locator locator, String data, Double delay) {
        locator.pressSequentially(data, new Locator.PressSequentiallyOptions().setDelay(delay));
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
     * Select dropdown by value
     *
     * @param locator Locator type
     * @param object  SelectOption object type
     */
    public void selectDropdownBySelectOption(Locator locator, SelectOption object) {
        locator.selectOption(object);
    }

    /**
     * By default, playwright will dismiss dialog/alert.
     * Set accept dialog then click element that trigger the dialog.
     */
    public void acceptDialog(Locator locator) {
        page.onDialog(Dialog::accept);
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
     * Get text content of a locator
     *
     * @param locator target locator
     * @return String data type
     */
    public String getText(Locator locator) {
        return locator.textContent().trim();
    }

    /**
     * Get text content of a locator
     *
     * @param locator target locator
     * @return String data type
     */
    public String getText(Locator locator, Double waitTime) {
        waitTillLocatorIsVisible(locator, waitTime);
        return locator.textContent().trim();
    }

    /**
     * Get text content of a locator and normalize all (enter) in it
     *
     * @param locator target locator
     * @return String
     */
    public String getNormalizeText(Locator locator) {
        return locator.textContent().trim().replaceAll("[\\t\\n\\r\\s]+", " ");
    }

    /**
     * get list text from locator that represent list, for example kost name on listing
     *
     * @param locator
     * @return list string
     */
    public List<String> getListInnerTextFromListLocator(Locator locator) {
        waitTillLocatorIsVisible(locator.first());
        return locator.allInnerTexts();
    }

    /**
     * Get list text content from locator
     *
     * @param locator target locator
     * @return List of string
     */
    public List<String> getListTextContentsFromLocator(Locator locator) {
        waitTillLocatorIsVisible(locator);
        return locator.allTextContents();
    }

    /**
     * Get text content from locator
     *
     * @param locator target Locator playwright locator
     * @return String data type
     */
    public String getLocatorTextContent(Locator locator) {
        return locator.textContent();
    }

    /**
     * Get value from input element
     *
     * @param locator playwright locator
     * @return String data type
     */
    public String getInputValue(Locator locator) {
        return locator.inputValue();
    }

    /**
     * check box
     */
    public void checkBox(Locator locator) {
        locator.check();
    }

    /**
     * uncheck box
     */
    public void uncheckBox(Locator locator) {
        locator.uncheck();
    }

    /**
     * Get button by aria role contain text
     *
     * @param buttonText text on button
     * @return Locator playwright
     */
    public Locator getButtonByText(String buttonText) {
        return page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText(buttonText));
    }

    /**
     * Get button by aria role with set name
     *
     * @param buttonText text on button
     * @return Locator playwright
     */
    public Locator getButtonBySetName(String buttonText) {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(buttonText));
    }

    /**
     * Get button by aria role with set name and exact
     *
     * @param buttonText text on button
     * @param exact      boolean
     * @return Locator playwright
     */
    public Locator getButtonBySetName(String buttonText, boolean exact) {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(buttonText).setExact(exact));
    }

    /**
     * Get total locator found
     *
     * @param locator
     */
    public int countLocator(Locator locator) {
        return locator.count();
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

    /**
     * Wait for load state before and check visibility of target locator
     *
     * @param locator
     * @param timeout
     * @return
     */
    public boolean isLocatorVisibleAfterLoad(Locator locator, Double timeout) {
        page.waitForLoadState(LoadState.LOAD);
        page.waitForTimeout(timeout);
        return locator.isVisible();
    }

    /**
     * Wait for a locator
     *
     * @param locator Locator data type
     */
    public void waitFor(Locator locator) {
        locator.waitFor();
    }

    /**
     * Wait for a locator with timeout
     *
     * @param locator  Locator data type
     * @param duration set duration in double
     */
    public void waitFor(Locator locator, Double duration) {
        locator.waitFor(new Locator.WaitForOptions().setTimeout(duration));
    }

    /**
     * Wait till page loaded
     * Default wait time is 30 seconds
     */
    public void waitTillPageLoaded() {
        page.waitForLoadState(LoadState.LOAD);
    }

    /**
     * Wait till page loaded
     * @param timeout double data type in millisecond
     */
    public void waitTillPageLoaded(Double timeout) {
        page.waitForLoadState(LoadState.LOAD, new Page.WaitForLoadStateOptions().setTimeout(timeout));
    }

    /**
     * Wait until no network activity
     */
    public void waitTillNetworkIdle() {
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }

    public void waitTillDomContentLoaded() {
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
    }

    public void waitTillDomContentLoaded(Double timeout) {
        page.waitForLoadState(LoadState.DOMCONTENTLOADED, new Page.WaitForLoadStateOptions().setTimeout(timeout));
    }

    /**
     * Hard wait until a locator visibility is ended
     *
     * @param locator       Locator data type
     * @param waitTimeDelay Double data type
     * @param maxLoop       int data type
     */
    public void waitTillLocatorIsNotVisible(Locator locator, Double waitTimeDelay, int maxLoop) {
        if (waitTillLocatorIsVisible(locator)) {
            var loop = 0;
            do {
                hardWait(waitTimeDelay);
                loop++;
                if (loop >= maxLoop || !waitTillLocatorIsVisible(locator)) {
                    break;
                }
            } while (waitTillLocatorIsVisible(locator));
        }
    }

    /**
     * Wait for locator have target state
     *
     * @param locator target locator
     * @param state   WaitForSelectorState VISIBLE ATTACHED DETACHED
     * @param timeout timeout wait duration in millisecond
     */
    public void waitForSelectorState(Locator locator, WaitForSelectorState state, Double timeout) {
        locator.waitFor(new Locator.WaitForOptions().setState(state).setTimeout(timeout));
    }

    //---- Wait Part ----\\

    //---- Locator Part ----\\

    /**
     * hover specific locator
     *
     * @param locator
     */
    public void hover(Locator locator) {
        locator.hover();
    }

    /**
     * hover specific locator
     * @param locator
     */
    public void hover(Locator locator, Boolean force) {
        locator.hover(new Locator.HoverOptions().setForce(force));
    }



    /**
     * Hover on specific locator with position options
     *
     * @param locator target locator to hover
     * @param x horizontal position (0.0 to 1.0, where 0.5 is center)
     * @param y vertical position (0.0 to 1.0, where 0.5 is center)
     */
    public void hoverAtPosition(Locator locator, double x, double y) {
        locator.hover(new Locator.HoverOptions().setPosition(x, y));
    }

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
     * Clear text
     *
     * @param locator target locator
     */
    public void clearText(Locator locator) {
        locator.clear();
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
     * Scroll Down Helper until locator is visible (per 200 pixel)
     */
    public void pageScrollUntilElementIsVisible(Locator locator) {
        for (int i = 0; i < 200; i++) {
            page.evaluate("window.scrollBy(0,200)");
            if (waitTillLocatorIsVisible(locator)) break;
        }
    }

    /**
     * Scroll Down Helper until locator is visible
     *
     * @param locator
     * @param scrollPerPixel
     */
    public void pageScrollUntilElementIsVisibleWithPixel(Locator locator, int scrollPerPixel) {
        for (int i = 0; i < 200; i++) {
            page.evaluate("window.scrollBy(0," + scrollPerPixel + ")");
            if (waitTillLocatorIsVisible(locator)) break;
        }
    }

    /**
     * Scroll down to locator
     *
     * @param locator
     */
    public void pageScrollInView(Locator locator) {
        locator.scrollIntoViewIfNeeded();
    }

    /**
     * Move Page helper, it will return page object, so it can use to implement in next page taget
     * for example when select kost on promo side from home page, it will be move to kost detail
     * so this helper can be implement to return kost detail object on kostdetailPO with argument this page inside of the kost detail object
     * real example you can see DOM 4 on feature:kost detail and Scenario: [Dweb][Kost Detail] Check promo owner section login
     */
    public Page movePageByClickLocator(Page pageActive, Locator locatorTarget) {
        // move page
        Page nextPage = pageActive.waitForPopup(new Page.WaitForPopupOptions().setTimeout(3000.0), locatorTarget::click);
        nextPage.bringToFront();
        return nextPage;
    }

    /**
     * @param pageActive
     * @return
     */
    public Page bringPageToView(Page pageActive) {
        pageActive.bringToFront();
        return pageActive;
    }

    /**
     * Hard wait before an action
     * @param time Double data type
     */
    public void hardWait(double time) {
        page.waitForTimeout(time);
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
     * Get page URL
     *
     * @return string data type
     */
    public String getPageUrl() {
        return page.url();
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

    /**
     * Click on a desired locator based on text
     *
     * @param words target locator
     *              default timeout
     */
    public void clickOnText(String words) {
        clickOn(page.getByText(words).first());
    }

    /**
     * Click on a desired locator based on text
     *
     * @param words   locator target locator
     * @param timeout Double data type of specific timeout
     */
    public void clickOnText(String words, Double timeout) {
        delayAndClickOn(page.getByText(words), timeout);
    }

    /**
     * Click on a desired locator based on button text
     *
     * @param buttonText target locator
     *                   default timeout
     */
    public void clickOnTextButton(String buttonText) {
        clickOn(locatorByRoleSetName(AriaRole.BUTTON, buttonText));
    }

    /**
     * Click on a desired locator based on button text
     *
     * @param buttonText target locator
     * @param duration   Double data type of specific timeout
     */
    public void clickOnTextButton(String buttonText, double duration) {
        clickOn(locatorByRoleSetName(AriaRole.BUTTON, buttonText));
        hardWait(duration);
    }

    /**
     * Check element based on text is displayed
     *
     * @return status true / false
     */
    public boolean isTextDisplayed(String text) {
        return waitTillLocatorIsVisible(page.getByText(text));
    }

    /**
     * Wait until element locator is visible
     *
     * @param text     Locator type based on text
     * @param duration Double type
     * @return boolean
     */
    public Boolean isTextDisplayed(String text, double duration) {
        Boolean result = isLocatorVisibleAfterLoad(page.getByText(text).first(), duration);
        if (!result) {
            log.info("Locator text target is not visible: {}", text);
        }
        return  result;
    }

    /**
     * Wait until element locator button based on text is visible
     *
     * @param button Locator type based on text
     *               default timeout
     * @return boolean
     */
    public boolean isButtonWithTextDisplayed(String button) {
        return waitTillLocatorIsVisible(locatorByRoleSetName(AriaRole.BUTTON, button));
    }

    /**
     * Helper to type like real keyboard
     * note: this method need some action such as click locator
     *
     * @param text string
     */
    public void realKeyboardType(String text) {
        page.keyboard().type(text);
    }

    /**
     * press real keyboard, for ex 'Enter'
     *
     * @param keyboardKey
     */
    public void pressKeyboardKey(String keyboardKey) {
        page.keyboard().press(keyboardKey);
    }

    /**
     * Wait until element locator button based on text is visible
     *
     * @param button   Locator type based on text
     * @param duration Double type
     * @return boolean
     */
    public boolean isButtonWithTextDisplayed(String button, double duration) {
        return isLocatorVisibleAfterLoad(locatorByRoleSetName(AriaRole.BUTTON, button), duration);
    }

    public boolean isButtonDisable(Locator locator) {
        return locator.isDisabled();
    }

    public boolean isButtonEnable(Locator locator) {
        return locator.isEnabled();
    }

    /**
     * check if data is null or blank
     *
     * @param locator
     * @return
     */
    public boolean isDataBlankorNull(Locator locator) {
        return locator.textContent().isBlank();
    }

    //---- Assert Part ----\\

    /**
     * Playwright Assert locator is visible
     *
     * @param locator Locator type
     */
    public void assertVisible(Locator locator) {
        assertThat(locator).isVisible();
    }

    /**
     * Playwright Assert locator is disabled
     *
     * @param locator Locator type
     */
    public void assertDisable(Locator locator) {
        assertThat(locator).isDisabled();
    }

    /**
     * Click on a desired locator based on button text
     *
     * @param linkText target locator
     *                 default timeout
     */
    public void clickOnLinkButton(String linkText) {
        clickOn(locatorByRoleSetName(AriaRole.LINK, linkText).first());
    }

    /**
     * Verify radio button is check
     *
     * @param locator
     */
    public boolean isRadioButtonChecked(Locator locator) {
        return locator.isChecked();
    }

    /**
     * Assert CSS in locator
     *
     * @param locator
     * @param css     CSS property name.
     * @param value   CSS property value.
     */
    public void assertHaveCss(Locator locator, String css, String value) {
        assertThat(locator).hasCSS(css, value);
    }
    //---- Assert Part ----\\

    // private method part

    /**
     * logging into console if element is clicked or not
     *
     * @param locator clickable
     */
    private void logElementNotClickable(Locator locator) {
        // log.info("locator is not clicked or visible {}", locator);
        System.out.println("locator is not clicked or visible " + locator);
    }

    /**
     * This method will be used to scroll to up
     */
    public void scrollToUp(Page page) {
        page.evaluate("async () => { " +
                "while (document.documentElement.scrollTop > 0) { " +
                "  document.documentElement.scrollTop -= 100; " +
                "  await new Promise(resolve => requestAnimationFrame(resolve)); " +
                "} " +
                "document.documentElement.scrollTop = 0; " +
                "}");
    }

    /**
     * Get page title
     *
     * @return String
     */
    public String getPageTitle() {
        return page.title();
    }

    /**
     * Uplaod file using file from resources folder
     *
     * @param locator
     * @param path
     */
    public void uploadFile(Locator locator, String path) {
        String projectpath = System.getProperty("user.dir");

        locator.setInputFiles(Paths.get(projectpath + "/" + path));
    }

    /**
     * Simulates zooming out the browser by applying a CSS scale transformation to the page's body.
     * <p>
     * This does not perform an actual browser zoom (like Ctrl + -), but visually scales the entire
     * page content using CSS. Useful for layout or screenshot testing when a zoomed-out view is needed.
     *
     * @param percentageInDecimal A string representing the zoom scale factor (e.g., "0.8" for 80% zoom).
     */
    public void zoomOutBrowser(String percentageInDecimal) {
        var expression = String.format("document.body.style.transform = 'scale(%s)'", percentageInDecimal);
        page.evaluate(expression);
    }

    /**
     * Select date survei
     *
     */
    public void selectDateSurvei(String date) {
        if (date.equalsIgnoreCase("tomorrow")) {
            this.date = JavaHelpers.getCostumDateOrTime("d", 1, 0, 0);
        } else if (date.equalsIgnoreCase("today")) {
            this.date = JavaHelpers.getCurrentDateOrTime("d");
        } else {
            this.date = date;
        }
    }

    /**
     * Get accessibility tree snapshot of a specific element
     * This method captures the ARIA accessibility tree representation of the specified element
     * Useful for accessibility testing and debugging
     * 
     * @param locator The locator for the element to capture the aria snapshot
     * @return String representation of the accessibility tree
     */
    public String getAriaSnapshot(Locator locator) {
        return locator.ariaSnapshot();
    }
}
