package pageobject.tenant;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

public class PromoMamikosPO {
    Page page;
    PlaywrightHelpers playwright;
    LocatorHelpers locator;
    Locator nextPageButton;
    Locator currentPageIndexButton;
    Locator previousPageButton;
    Locator firstCopyButton;
    Locator firstPromoCode;

    public PromoMamikosPO(Page page) {
        nextPageButton = page.locator("//a[.='>']");
        currentPageIndexButton = page.locator("//li[@class='page-item active']/a");
        previousPageButton = page.locator("//a[.='<']");
        firstCopyButton = page.locator("(//button[contains(text(),'SALIN')])[1]");
        firstPromoCode = page.locator("(//*[text()='Kode Promo']/following-sibling::p)[1]");
    }

    /**
     * Click On next page
     *
     * @throws InterruptedException
     */
    public void clickNextPage() throws InterruptedException {
        if (playwright.waitTillLocatorIsVisible(nextPageButton)) {
            playwright.clickOn(nextPageButton);
        }
    }

    /**
     * Get current pagination index
     *
     * @return String page index
     */
    public String getPageIndex() {
        String currentPage;
        if (playwright.waitTillLocatorIsVisible(nextPageButton)) {
            currentPage = playwright.getText(currentPageIndexButton);
        } else
            currentPage = null;
        return currentPage;
    }

    /**
     * Click On previous page
     *
     * @throws InterruptedException
     */
    public void clickPrevPage() {
        if (playwright.waitTillLocatorIsVisible(previousPageButton)) {
            playwright.clickOn(previousPageButton);
        }
    }

    /**
     * Click On certain page
     *
     * @throws InterruptedException
     */
    public void clickPageIndex(String index) {
        String pageIndex = "//a[text()='" + index + "']";
        if (playwright.waitTillLocatorIsVisible(page.locator(pageIndex))) {
            playwright.clickOn(page.locator(pageIndex));
        }
    }
    /**
     * Click On first copy promo button
     * @throws InterruptedException
     */
    public void clickOnFirstCopyPromo() {
        playwright.clickOn(firstCopyButton);
    }
    /**
     * Get promo code
     * @return String promo code
     */
    public String getClipboardText2() {
        return playwright.getText(firstPromoCode);
    }

    /**
     * promo code not found
     * @return
     */
    public boolean isGetClipboardText() {
        return playwright.waitTillLocatorIsVisible(firstPromoCode);
    }
}
