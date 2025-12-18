package pageobject.tenant;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import config.playwright.context.ActiveContext;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

public class RekomendasiListingPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private LocatorHelpers locatorHelpers;
    public static String firstPropertyRekomendasi;

    Locator favoritHeader;
    Locator emptyStateMessage;
    Locator userPhoto;
    Locator userProfile;
    Locator mulaiCariDanSewaKosButton;
    Locator masukkanKodeDariPemilikButton;
    Locator rekomendasiTitle;
    Locator paginationNumberAct;
    Locator rekomendasiListingActual;
    Locator firstPropertyRekomendasiKosSaya;
    Locator propertyFavorit;
    Locator hapusHistoriButton;

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
        this.paginationNumberAct = page.locator(".premium-recom-slider-item");
        this.rekomendasiListingActual = page.locator(".premium-recom-slide .track-list-booking-kost");
        this.firstPropertyRekomendasiKosSaya =  page.locator(".rc-info__name.bg-c-text.bg-c-text--body-4").first();
        this.hapusHistoriButton = page.locator("//button[normalize-space()='Hapus']");
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
     * Pagination number get as integer (count of pagination items/pages)
     * @return integer data type
     */
    public int getPaginationActual() {
        return paginationNumberAct.count();
    }

    /**
     * Rekomendasi listing number get as integer (count of rekomendasi items)
     * @return integer data type
     */
    public int getRekomendasiActual() {
        return rekomendasiListingActual.count();
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

    /**
     * Click on menu favorite at header homepage
     */
    public void clickOnFavoriteHeader(){
        favoritHeader =  page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Favorit"));
        playwright.clickOn(favoritHeader);
    }

    /**
     * Verify property last seen is present
     * @return boolean
     */
    public boolean isPropertyVisible() {
        String element = "(//div[@data-testid='kostRoomCard'])[1]";
        return playwright.waitTillLocatorIsVisible(page.locator(element),1000.0);
    }

    /**
     * Click First rekomendasi and switch new tab
     * @return active page
     * @throws InterruptedException
     */
    public Page clickOnFirstRekomendasi(){
        page = page.waitForPopup(() -> {
            playwright.clickOn(firstPropertyRekomendasiKosSaya);
        });
        ActiveContext.setActivePage(page);
        return ActiveContext.getActivePage();
    }

    /**
     * user get first property on rekomendasi section
     * @param page
     * @return firstPropertyRekomendasi
     */
    public String getFirstProperty(String page) throws InterruptedException {
        switch (page) {
            case "Kos Saya":
                playwright.pageScrollUntilElementIsVisible(firstPropertyRekomendasiKosSaya);
                firstPropertyRekomendasi = playwright.getText(firstPropertyRekomendasiKosSaya);
                break;
        }
        return firstPropertyRekomendasi;
    }

    /**
     * User get favorit property rekomendasi
     *
     * @return firstPropertyRekomendasi
     */
    public String getFavoritPropertyRekomendasi() {
        return RekomendasiListingPO.firstPropertyRekomendasi;
    }

    /**
     * Verify the favorit property from rekomendasi is present
     * @param favoritPropertyRekomendasi
     * @return boolean
     */
    public boolean isRekomendasiAfterFavoritVisible(String favoritPropertyRekomendasi) {
        String propertyFavorit = "//span[contains(.,'"+favoritPropertyRekomendasi+"')]";
        return playwright.isLocatorVisibleAfterLoad(page.locator(propertyFavorit),3000.0);
    }

    /**
     * Click property on favorit recomendation section
     * @param favoritPropertyRekomendasi
     * @throws InterruptedException
     */
    public void clickOnPropertyFavoritRecomendation(String favoritPropertyRekomendasi) throws InterruptedException {
        String propertyFavoritRecommendation = "//span[contains(.,'"+favoritPropertyRekomendasi+"')]";
        playwright.waitTillLocatorIsVisible(page.locator(propertyFavoritRecommendation),1000.0);
        playwright.clickOn(page.locator(propertyFavoritRecommendation));
    }

    /**
     * Click property on favorit section
     * @param favoritProperty
     * @throws InterruptedException
     */
    public Page clickOnPropertyFavorit(String favoritProperty) throws InterruptedException {
        propertyFavorit = page.getByText(favoritProperty);
        playwright.waitTillLocatorIsVisible(propertyFavorit,1000.0);
        page = page.waitForPopup(() -> {
            playwright.clickOn(propertyFavorit);
        });
        ActiveContext.setActivePage(page);
        return ActiveContext.getActivePage();
    }
    /**
     * Click on Hapus Histori button on pernah dilihat
     */
    public void clickOnHapusHistoriButton() {
        playwright.clickOn(hapusHistoriButton);
    }

    /**
     * Click on "Mulai cari dan sewa kos" button
     * This button appears when tenant has no active kos
     */
    public void clickOnMulaiCariDanSewaKosButton() {
        playwright.waitTillLocatorIsVisible(mulaiCariDanSewaKosButton);
        playwright.clickOn(mulaiCariDanSewaKosButton);
    }
}
