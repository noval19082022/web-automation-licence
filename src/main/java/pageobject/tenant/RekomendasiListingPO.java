package pageobject.tenant;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

public class RekomendasiListingPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private LocatorHelpers locatorHelpers;

    Locator favoritHeader;
    Locator emptyStateMessage;
    Locator userPhoto;
    Locator userProfile;
    Locator mulaiCariDanSewaKosButton;
    Locator masukkanKodeDariPemilikButton;
    Locator rekomendasiTitle;
    Locator paginationNumberAct;
    Locator rekomendasiListingActual;

    public RekomendasiListingPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.locatorHelpers = new LocatorHelpers(page);

        this.favoritHeader = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Favorit"));
        this.userPhoto = page.getByAltText("User Photo");
        this.userProfile = page.getByTestId("profileButton");
        this.mulaiCariDanSewaKosButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Mulai cari dan sewa kos"));
        this.masukkanKodeDariPemilikButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Masukkan kode dari pemilik"));
        this.rekomendasiTitle = page.locator(".premium-recom-title");
        this.paginationNumberAct = page.locator("//div[@class='premium-recom-slider-item']");
        this.rekomendasiListingActual = page.locator("//*[@class=‘premium-recom-slide’]//div[@class=‘track-list-booking-kost’]");
    }

    /**
     * Click on Favorit on header
     *
     *
     */
    public void clickOnFavoritPage() {
        favoritHeader.click();
    }

    /**
     * Verify the empty state message on favorite page
     * @param message
     * @return empty state message text
     *
     */
    public String getMessageEmptyState(String message) {
        this.emptyStateMessage = page.getByText(message);
        return emptyStateMessage.textContent();
    }

    /**
     * Click on User photo
     *
     *
     */
    public void clickOnUserPhoto() {
        playwright.clickOn(userPhoto);
    }

    /**
     * Click on Profile dropdown menu tenant
     *
     *
     */
    public void clickOnProfile() {
        playwright.clickOn(userProfile);
    }

    /**
     * Verify Mulai Cari dan Sewa Kos button visible
     * @return boolen Mulai Cari dan Sewa Kos button is visible
     *
     */
    public boolean isMulaiCariDanSewaKosIsVisible() {
      return playwright.isLocatorVisibleAfterLoad(mulaiCariDanSewaKosButton,2000.0);
    }

    /**
     * Verify Kode dari Pemilik button visible
     * @return boolen Kode dari Pemilik button is visible
     *
     */
    public boolean isMasukkanKodeDariPemilikIsVisible() {
        return masukkanKodeDariPemilikButton.isVisible();
    }

    /**
     * is rekomendasi section is present
     *
     * @return boolean
     */
    public boolean isRekomendasiSectionVisible(){
        return playwright.isLocatorVisibleAfterLoad(rekomendasiTitle,2000.0);
    }

    /**
     * Pagination number get as integer
     * @return integer data type
     */
    public int getPaginationActual() {
        try {
            return Integer.parseInt(playwright.getText(paginationNumberAct));
        }
        catch (Exception e) {
            return 0;
        }
    }

    /**
     * Rekomendasi listing number get as integer
     * @return integer data type
     */
    public int getRekomendasiActual() {
        try {
            return Integer.parseInt(playwright.getText(rekomendasiListingActual));
        }
        catch (Exception e) {
            return 0;
        }
    }

    /**
     * verify menu user tenant
     * @param menuUser for spesific menu user want to get
     * @return menuUser
     */
    public String getMenuUserTenant(String menuUser) {
        String menuUserLocator = "//li[contains(.,'"+ menuUser +"')]";
        playwright.isLocatorVisibleAfterLoad(page.locator(menuUserLocator),2000.0);
        return playwright.getText(page.locator(menuUserLocator));
    }
}
