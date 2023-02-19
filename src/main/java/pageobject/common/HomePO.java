package pageobject.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

public class HomePO {
    private Page page;
    private PlaywrightHelpers playwright;
    private LocatorHelpers locatorHelpers;
    private Locator btnMasuk;
    private Locator cariButton;
    private Locator mamikosLogo;
    private Locator userPhoto;
    private Locator kostPromo;
    private Locator lastRoomCardRecomendationSection;

    public HomePO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.locatorHelpers = new LocatorHelpers(page);
        this.btnMasuk = page.getByTestId("entryButton");
        this.cariButton = playwright.filterLocatorHasText(locatorHelpers.span, "Cari");
        mamikosLogo = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Mamikos Logo"));
        userPhoto = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("User Photo"));
//        this.kostPromo = page.locator("div[class='promoted-item__room']");
        this.kostPromo = page.locator("#promoted").getByTestId("roomCardCover-photo");
        this.lastRoomCardRecomendationSection = page.locator(".promoted-item");
    }

    /**
     * Click on button masuk on home page
     *
     * @return LoginPO class
     */
    public LoginPO clickOnButtonMasuk() {
        btnMasuk.click();
        return new LoginPO(page);
    }

    /**
     * Click on search button
     *
     * @return SearchPO
     */
    public SearchPO clickOnSearchButton() {
        cariButton.click();
        return new SearchPO(page);
    }

    /**
     * Wait till mamikos logo is visible
     */
    public void waitTillLogoIsVisible() {
        page.waitForLoadState(LoadState.LOAD);
        playwright.waitFor(mamikosLogo, 30000.0);
        playwright.waitFor(userPhoto, 3000.0);
    }

    /**
     * Get mamikos logo
     *
     * @return Locator data type of mamikos logo
     */
    public Locator getMamikosLogo() {
        return mamikosLogo;
    }

    /**
     * kost promo
     */
    public KostDetailsPO selectKostOnPromoSection(Boolean isLogin) {
        if (isLogin) {
            playwright.pageScrollToDown(2000);
        } else {
            playwright.pageScrollToDown(3000);
        }
//        playwright.pageScrollInView(lastRoomCardRecomendationSection);
        page = playwright.movePageByClickLocator(page, kostPromo);
        return new KostDetailsPO(page);
    }
}
