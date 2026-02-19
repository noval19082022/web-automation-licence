package pageobject.common.apartment;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ApartmentLandingPO {
    Page page;
    PlaywrightHelpers playwright;
    private Locator mamikosLogo;
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
    private Locator filteringFurniture;
    private Locator filteringPrice;
    private Locator filteringUnitType;
    private Locator filteringAreaDropDown;
    private Locator filteringArea;
    private Locator listTimePeriod;
    private Locator listUnitAndFurniture;
    private Locator listPrice;
    private Locator listApartementArea;
    private Locator fullyBookedOncard;


    public ApartmentLandingPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.mamikosLogo = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("logo_mamikos_white"));
        inputSearch = page.getByPlaceholder("Masukan nama apartemen/area/alamat");
        searchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(""));
        apartemenTidakDitemukanText = page.getByText("Apartemen tidak ditemukan.");
        noPropertyImage = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("Kost tidak ditemukan"));
        apartmentListNameText = page.locator("span.rc-info__name");
        favoriteHeader = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Favorit"));
        detailApartment = page.locator("#detailApartmentContainer");
        hapusHistoryButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hapus Histori"));
        rekomendasiTitle = page.locator(".premium-recom-title");
        this.filteringPeriod = page.locator("select#filterRentType");
        this.filteringFurniture = page.locator("select#filterFurniture");
        this.filteringPrice = page.locator("select#filterSorting");
        this.filteringUnitType = page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Tipe UnitSemua1-Room Studio1 BR2 BR3 BR4 BRLainnya$"))).getByRole(AriaRole.COMBOBOX);
        this.filteringAreaDropDown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Semua Kota dropdown-down"));
        this.filteringArea = page.locator("a");
        this.listTimePeriod = page.locator("//span[@class='rc-price__type bg-c-text bg-c-text--body-2']");
        this.listUnitAndFurniture = page.locator("//div[@class='rc-price__additional-data']");
        this.listPrice = page.locator("//span[@class='rc-price__text bg-c-text bg-c-text--body-1']");
        this.listApartementArea = page.locator("//span[@class='rc-info__location bg-c-text bg-c-text--body-3']");
        this.fullyBookedOncard = page.locator("div:nth-child(2) > div > .apartment-rc > .apartment-rc__inner > .apartment-rc__full > .apartment-rc__full-label");
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
        return playwright.getText(page.locator(propertyNameLocator)).replaceAll("\\[([^]]+)]", "").replaceAll("[0-9]", "").trim();
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
        String value = period.toLowerCase().equals("harian") ? "0" :
                period.toLowerCase().equals("mingguan") ? "1" :
                        period.toLowerCase().equals("bulanan") ? "2" :
                                period.toLowerCase().equals("tahunan") ? "3" : "0";
        filteringPeriod.selectOption(value, new Locator.SelectOptionOptions().setForce(true));
    }

    /**
     * get list time period apartement
     */
    public List<String> getApartmentListByPeriod() {
        playwright.waitTillPageLoaded();
        return playwright.getListInnerTextFromListLocator(listTimePeriod);
    }

    /**
     * get apartement area from list
     *
     * @return
     */
    public List<String> getCityAndAreaValidationOnList() {
        playwright.waitTillPageLoaded();
        return playwright.getListInnerTextFromListLocator(listApartementArea);
    }

    /**
     * user filtering apartment list on landing by furniture, example Furnished, Semi Furnished, Not furnished
     *
     * @param furniture
     */
    public void filterByFurniture(String furniture) {
        String value = furniture.toLowerCase().equals("furnished") ? "1" :
                furniture.toLowerCase().equals("semi furnished") ? "2" :
                        furniture.toLowerCase().equals("not furnished") ? "0" : "all";
        filteringFurniture.selectOption(value, new Locator.SelectOptionOptions().setForce(true));
    }

    /**
     * get list furniture period apartement
     *
     * @return
     */
    public List<String> getApartmentListByUnitOrFurniture() {
        playwright.waitTillPageLoaded();
        return playwright.getListInnerTextFromListLocator(listUnitAndFurniture);
    }

    /**
     * user filtering apartment list on landing by price direction, example Acak, Harga Termurah, Harga Termahal,penuh ke kosong
     *
     * @param price
     */
    public void filterByPriceDirection(String price) {
        String direction = price.toLowerCase().equals("acak") ? "-" :
                price.toLowerCase().equals("harga termurah") ? "asc" :
                        price.toLowerCase().equals("harga termahal") ? "desc" :
                                price.toLowerCase().equals("kosong ke penuh") ? "availability" : "-";
        filteringPrice.selectOption(direction, new Locator.SelectOptionOptions().setForce(true));
    }

    /**
     * get list of price
     * @return
     */
    public List<Integer> getApartmentListByPrice() {
        playwright.waitTillPageLoaded();
        return convertStringListToIntList(playwright.getListInnerTextFromListLocator(listPrice));
    }

    private List<Integer> convertStringListToIntList(List<String> stringList) {
        List<Integer> intList = new ArrayList<>();

        for (String s : stringList) {
            intList.add(JavaHelpers.extractNumber(s));
        }

        return intList;
    }

    /**
     * check if fully booked is visible
     * @return
     */
    public boolean isFullyBooked() {
        playwright.waitTillPageLoaded();
        return playwright.waitTillLocatorIsVisible(fullyBookedOncard);
    }

    /**
     * sorting apartement list by unit type
     * @param unitType
     */
    public void filterByUnit(String unitType) {
        playwright.selectDropdownByValue(filteringUnitType, unitType);
    }

    /**
     * click on mamikos logo on navbar
     */
    public void clickOnMamikosLogo() {
        playwright.clickOn(mamikosLogo);
    }

    /**
     * filtering apartment list by area
     * @param area
     */
    public void searchByArea(String area) {
        playwright.clickOn(filteringAreaDropDown);
        playwright.clickOn(
                playwright.filterLocatorHasText(filteringArea, area)
        );
    }
}
