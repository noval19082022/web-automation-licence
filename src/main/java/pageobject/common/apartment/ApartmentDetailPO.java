package pageobject.common.apartment;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class ApartmentDetailPO {
    Page page;
    PlaywrightHelpers playwright;
    private Locator contactApartmentButton;
    private Locator favoriteBtn;
    Locator favoriteRedBtn;
    private Locator favoriteBtnActive;
    private Locator successMsgPopUp;
    private Locator unfavoriteSuccessMsg;
    private Locator apartDetailContainer;
    private Locator firstApartment;
    private Locator hubungiPengelola;
    private Locator lihatNomorTelepon;

    public ApartmentDetailPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        contactApartmentButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hubungi Pengelola"));
        this.favoriteBtn = page.getByTestId("btn-love");
        this.favoriteBtnActive = page.locator("[data-testid='btn-love'].active, [data-testid='btn-love'][class*='active'], [data-testid='btn-love'][class*='loved']");
        this.successMsgPopUp = page.getByText("Sukses tersimpan");
        this.unfavoriteSuccessMsg = page.getByText("Berhasil dihapus dari favorit");
        this.apartDetailContainer = page.locator("//div[@class='detail']");
        firstApartment = page.locator(".room-list__card");
        hubungiPengelola = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hubungi Pengelola"));
        lihatNomorTelepon = page.locator("#priceCard").getByText("Lihat Nomor Telepon");
        favoriteRedBtn = page.locator("//button[@class='bg-c-button bg-c-button--tertiary bg-c-button--md btn-love--red-icon']");
    }

    /**
     * Click on Hubungi Pengelola Apartnent
     */
    public void clickContactApt() {
        playwright.hardWait(2000);
        playwright.waitTillLocatorIsVisible(hubungiPengelola, 10000.0);
        playwright.pageScrollToDown(300);
        playwright.hardWait(1000);
        playwright.clickOn(hubungiPengelola);
    }

    /**
     * Click on Lihat Nomor Telepon Apartnent
     */
    public void clicklihatNomorTeleponApt() {
        playwright.pageScrollToDown(300);
        playwright.clickOn(lihatNomorTelepon);
    }


    /**
     * Click on favorite btn
     * If already favorited, unfavorite first then favorite again
     */
    public void clickOnFavoriteBtn() {
        // If already favorited, unfavorite first
        if (playwright.waitTillLocatorIsVisible(favoriteRedBtn)) {
            playwright.clickOn(favoriteRedBtn);
            playwright.hardWait(2000);
        }
        playwright.clickOn(favoriteBtn);
    }

    /**
     * Click on unfavorite btn
     * If already favorited, unfavorite first then favorite again
     */
    public void clickOnUnFavoriteBtn() {
        playwright.clickOn(favoriteBtn);
    }

    /**
     * get success message after favorite the apartement
     * @return
     */
    public String getSuccessMessage() {
        playwright.waitTillLocatorIsVisible(successMsgPopUp);
        return playwright.getText(successMsgPopUp);
    }

    /**
     * Verify the detal apartement is visible after load
     */
    public void waitTillApartDetailPageVisible() {
        playwright.waitForElementStateToBe(apartDetailContainer, "visible");
    }

    /**
     * Click on apartment detail
     */
    public void clickOnApartmentDetail() {
        playwright.clickOn(firstApartment);
    }
}
