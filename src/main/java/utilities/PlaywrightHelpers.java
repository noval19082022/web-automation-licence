package utilities;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Response;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.ElementState;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.SelectOption;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class PlaywrightHelpers {
    Page page;

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
     * Reload page with timeout
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
     * Scroll to coordinate
     * @param deltaX
     * @param deltaY
     */
    public void scrollTo(double deltaX, double deltaY) {
        page.mouse().wheel(deltaX, deltaX);
    }

    /**
     * Simulate tap keyboard
     * @param key
     */
    public void tapKeyboard(String key) {
        page.keyboard().down(key);
    }

    /**
     * Force fill input to locator with disabled fill attribute
     * @param locator targeted locator
     * @param data String data type
     */
    public void forceFill(Locator locator, String data) {
        locator.fill(data, new Locator.FillOptions().setForce(true));
    }

    /**
     * Fill input to locator
     * @param locator targeted locator
     * @param data String data type
     */
    public void fill(Locator locator, String data) {
        locator.fill(data);
    }

    /**
     * Input to locator character by character
     * @param locator locator targeted locator
     * @param data data String data type
     */
    public void fillCharacterByCharacter(Locator locator, String data){
        locator.type(data);
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
        page.onDialog(dialog -> {
            dialog.accept();
        });
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
     * @param locator target locator
     * @return String data type
     */
    public String getText(Locator locator) {
        return locator.textContent().trim();
    }

    /**
     * get list text from locator that represent list, for example kost name on listing
     * @param locator
     * @return list string
     */
    public List<String> getListInnerTextFromListLocator(Locator locator) {
        return locator.allInnerTexts();
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
     * uncheck box
     */
    public void uncheckBox(Locator locator) {
        locator.uncheck();
    }

    /**
     * Get button by aria role contain text
     * @param buttonText text on button
     * @return Locator playwright
     */
    public Locator getButtonByText(String buttonText) {
        return page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText(buttonText));
    }

    /**
     * Get button by aria role with set name
     * @param buttonText text on button
     * @return Locator playwright
     */
    public Locator getButtonBySetName(String buttonText) {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(buttonText));
    }

    /**
     * Get button by aria role with set name and exact
     * @param buttonText text on button
     * @param exact boolean
     * @return Locator playwright
     */
    public Locator getButtonBySetName(String buttonText, boolean exact) {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(buttonText).setExact(exact));
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
     * @param locator  Locator data type
     */
    public void waitFor(Locator locator) {
        locator.waitFor();
    }

    /**
     * Wait for a locator with timeout
     * @param locator  Locator data type
     * @param duration set duration in double
     */
    public void waitFor(Locator locator, Double duration) {
        locator.waitFor(new Locator.WaitForOptions().setTimeout(duration));
    }

    /**
     * Wait till page loaded
     */
    public void waitTillPageLoaded() {
        page.waitForLoadState(LoadState.LOAD);
    }

    /**
     * Wait till page loaded
     * @param timeout double data type
     */
    public void waitTillPageLoaded(Double timeout) {
        page.waitForLoadState(LoadState.LOAD, new Page.WaitForLoadStateOptions().setTimeout(timeout));
    }

    public void waitTillDomContentLoaded() {
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
    }

    public void waitTillDomContentLoaded(Double timeout) {
        page.waitForLoadState(LoadState.DOMCONTENTLOADED, new Page.WaitForLoadStateOptions().setTimeout(timeout));
    }

    /**
     * Hard wait until a locator visibility is ended
     * @param locator Locator data type
     * @param waitTimeDelay Double data type
     * @param maxLoop int data type
     */
    public void waitTillLocatorIsNotVisible(Locator locator, Double waitTimeDelay, int maxLoop) {
        if (waitTillLocatorIsVisible(locator)) {
            var loop = 0;
            do {
                hardWait(1000.0);
                loop++;
                if (loop >= maxLoop) {
                    break;
                }
            } while (waitTillLocatorIsVisible(locator));
        }
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
     * Clear text
     *
     * @param locator target locator
     */
    public void clearText(Locator locator){
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
     *
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
    public boolean isTextDisplayed(String text, double duration) {
        return isLocatorVisibleAfterLoad(page.getByText(text).first(), duration);
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

    /**
     * check if data is null or blank
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

    //---- Assert Part ----\\

}
