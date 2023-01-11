package pageobject.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

public class HomePO {
    private Page page;
    private PlaywrightHelpers playwright;
    private LocatorHelpers locatorHelpers;
    private Locator btnMasuk;
    private Locator cariButton;
    public HomePO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.locatorHelpers = new LocatorHelpers(page);
        this.btnMasuk = page.getByTestId("entryButton");
        this.cariButton = playwright.filterLocatorHasText(locatorHelpers.span, "Cari");
    }

    /**
     * Click on button masuk on home page
      * @return LoginPO class
     */
    public LoginPO clickOnButtonMasuk() {
        btnMasuk.click();
        return new LoginPO(page);
    }

    /**
     * Click on search button
     * @return SearchPO
     */
    public SearchPO clickOnSearchButton() {
        cariButton.click();
        return new SearchPO(page);
    }
}
