package pageobject.common.apartment;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

import java.util.List;
import java.util.regex.Pattern;

public class ApartmentLandingPO {
    Page page;
    PlaywrightHelpers playwright;
    private Locator inputSearch;
    private Locator searchButton;
    private Locator apartemenTidakDitemukanText;
    private Locator noPropertyImage;
    private Locator apartmentListNameText;
    private Locator favoriteHeader;
    private Locator hapusHistoryButton;
    private Locator detailApartment;
    private Locator rekomendasiTitle;
    private Locator filteringPeriod;
    private Locator listTimePeriod;


    public ApartmentLandingPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        inputSearch = page.getByPlaceholder("Ketik yang Anda cari...");
        searchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(""));
        apartemenTidakDitemukanText = page.getByText("Apartemen tidak ditemukan.");
        noPropertyImage = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("Kost tidak ditemukan"));
        apartmentListNameText = page.locator("span.rc-info__name");
        favoriteHeader = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Favorit"));
        detailApartment = page.locator("#detailApartmentContainer");
        hapusHistoryButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hapus Histori"));
        rekomendasiTitle = page.locator(".premium-recom-title");
        this.filteringPeriod = page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Jangka Waktu Harian Mingguan Bulanan Tahunan$"))).getByRole(AriaRole.COMBOBOX);
        this.listTimePeriod = page.locator("//span[@class='rc-price__type bg-c-text bg-c-text--body-2']");
    }

    /**
     * Fill apartment search input
     *
     * @param area
     */
    public void fillApartmentSearchInput(String area) {
        playwright.forceFill(inputSearch, area);
    }

    /**
     * Click on search button right side of search input
     */
    public void clickOnSearch() {
        playwright.clickOn(searchButton);
    }

    /**
     * Check visibility of apartemen tidak ditemukan text
     *
     * @return boolean
     */
    public boolean isApartemenTidakDitemukanTextVisible() {
        playwright.waitFor(apartemenTidakDitemukanText, 30000.0);
        return playwright.waitTillLocatorIsVisible(apartemenTidakDitemukanText);
    }

    /**
     * Check visibility of no property image
     *
     * @return boolean
     */
    public boolean isImageNoPropertyVisible() {
        playwright.waitFor(noPropertyImage, 30000.0);
        return playwright.waitTillLocatorIsVisible(noPropertyImage);
    }

    /**
     * Get apartment list size
     *
     * @return int data tipe
     */
    public int getApartmentListSize() {
        playwright.waitFor(apartmentListNameText.last(), 30000.0);
        return playwright.getLocators(apartmentListNameText).size();
    }

    /**
     * Click on apartement list based on it index
     *
     * @param i int type index apartment list
     */
    public void clickOnApartmentListNumber(int i) {
        playwright.clickOn(apartmentListNameText.nth(i));
    }

    /**
     * Click on tab pernah dilihat apartment
     */
    public void clickOnHistoryApartment() {
        playwright.clickOn(favoriteHeader);
        playwright.clickOnText("Pernah Dilihat");
    }

    /**
     * Get properti name on pernah dilihat tab
     *
     * @param propertyName for specific menu want to get
     * @return properti name
     */
    public String getLastSeenDetailProperti(String propertyName) {
        String propertyNameLocator = "//*[contains(text(),'" + propertyName + "')]";
        playwright.waitTillLocatorIsVisible(page.locator(propertyNameLocator));
        return playwright.getText(page.locator(propertyNameLocator));
    }

    /**
     * is hapus histori button present
     *
     * @return true
     */
    public boolean isHapusHistoryVisible() {
        playwright.waitTillLocatorIsVisible(hapusHistoryButton, 2000.0);
        return hapusHistoryButton.isVisible();
    }


    /**
     * Wait container for apartment is visible
     *
     * @return true
     */
    public void waitTillApartmentDetailPageVisible() {
        playwright.waitForElementStateToBe(detailApartment, "visible");
    }

    /**
     * Click on tab difavoritkan apartment
     */
    public void clickOnFavoriteApartment() {
        playwright.clickOn(favoriteHeader);
        playwright.clickOnText("Difavoritkan");
    }

    /**
     * is rekomendasi section is present
     *
     * @return boolean
     */
    public boolean isRekomendasiSectionVisible() {
        return playwright.waitTillLocatorIsVisible(rekomendasiTitle);
    }

    /**
     * user filtering apartment list on landing by time period, example mingguan, bulanan, harian
     *
     * @param period
     */
    public void filterByTimePeriod(String period) {
        playwright.selectDropdownByValue(filteringPeriod, period);
    }

    /**
     * get list time period apartement
     */
    public List<String> getApartmentListByPeriod() {
        playwright.waitTillPageLoaded();
        return playwright.getListInnerTextFromListLocator(listTimePeriod);
    }
}
