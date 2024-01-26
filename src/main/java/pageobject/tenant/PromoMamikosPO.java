package pageobject.tenant;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class PromoMamikosPO {
    Page page;
    PlaywrightHelpers playwright;
    Locator nextPageButton;
    Locator currentPageIndexButton;
    Locator previousPageButton;
    Locator firstCopyButton;
    Locator firstPromoCode;
    Locator firstPromoTitleLabel;
    Locator firstSeeDetailButton;
    Locator gunakanPromoButton;

    public PromoMamikosPO(Page page) {
        this.playwright = new PlaywrightHelpers(page);
        this.page = page;
        nextPageButton = page.locator("//a[.='>']");
        currentPageIndexButton = page.locator("//li[@class='page-item active']/a");
        previousPageButton = page.locator("//a[.='<']");
        firstCopyButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("SALIN"));
        firstPromoCode = page.locator("(//*[text()='Kode Promo']/following-sibling::p)[1]");
        firstPromoTitleLabel = page.locator("//article[1]//*[@class='promo-meta-title']/h2/a");
        firstSeeDetailButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat Detail"));
        gunakanPromoButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("GUNAKAN PROMO"));

    }

    /**
     * Click On next page
     *
     */
    public void clickNextPage() {
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
     */
    public void clickPrevPage() {
        if (playwright.waitTillLocatorIsVisible(previousPageButton)) {
            playwright.clickOn(previousPageButton);
        }
    }

    /**
     * Click On certain page
     *
     */
    public void clickPageIndex(String index) {
        String pageIndex = "//a[text()='" + index + "']";
        if (playwright.waitTillLocatorIsVisible(page.locator(pageIndex))) {
            playwright.clickOn(page.locator(pageIndex));
        }
    }
    /**
     * Click On first copy promo button
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

    /**
     * Get first promo title
     * @return String promo title
     */
    public String getFirstPromoTitle() {
        return playwright.getText(firstPromoTitleLabel);
    }

    /**
     * Click On first see detail promo button
     * @throws InterruptedException
     */
    public void clickFirstSeeDetail() {
        playwright.clickOn(firstSeeDetailButton);
    }

    /**
     * Get promo title
     * @return String promo title
     */
    public String getPromoTitle(String promo) {
        Locator title = playwright.locatorByRoleSetName(AriaRole.HEADING, promo);
        return playwright.getText(title);
    }

    /**
     * Check button use now exist
     * @return boolean true if button exist
     */
    public boolean bookingNowButtonDisplayed() {
        return playwright.waitTillLocatorIsVisible(gunakanPromoButton);
    }
}
