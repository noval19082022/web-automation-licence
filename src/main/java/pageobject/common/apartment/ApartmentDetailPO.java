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
    private Locator successMsgPopUp;
    private Locator apartDetailContainer;
    private Locator firstApartment;
    private Locator hubungiPengelola;
    private Locator lihatNomorTelepon;

    public ApartmentDetailPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        contactApartmentButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hubungi Pengelola"));
        this.favoriteBtn = page.getByTestId("btn-love");
        this.successMsgPopUp = page.getByText("Sukses tersimpan");
        this.apartDetailContainer = page.locator("//div[@class='detail']");
        firstApartment = page.locator(".room-list__card");
        hubungiPengelola = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hubungi Pengelola"));
        lihatNomorTelepon = page.locator("#priceCard").getByText("Lihat Nomor Telepon");
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
     * click on favorite btn
     */
    public void clickOnFavoriteBtn() {
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
