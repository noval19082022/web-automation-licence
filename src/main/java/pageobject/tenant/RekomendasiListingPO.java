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

    public RekomendasiListingPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.locatorHelpers = new LocatorHelpers(page);

        this.favoritHeader = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Favorit"));
        this.userPhoto = page.getByAltText("User Photo");
        this.userProfile = page.getByTestId("profileButton");
        this.mulaiCariDanSewaKosButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Mulai cari dan sewa kos"));
        this.masukkanKodeDariPemilikButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Masukkan kode dari pemilik"));
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
}
