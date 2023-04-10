package pageobject.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

import java.util.List;

public class KostLandingAreaPO {
    Page page;
    PlaywrightHelpers playwright;
    private Locator headingResultText;
    private Locator filterHarga;
    private Locator filterInputMinimalPrice;
    private Locator filterInputMaximumPrice;
    private Locator filterPriceSimpanButton;
    private Locator kostRoomCard;
    private Locator nominatimMap;
    private Locator filterResetText;
    private Locator filterResetButton;
    private Locator imgKosTidakDitemukan;
    private Locator headingNoKosInAreaText;
    private Locator subtitleNoKosInAreaText;
    private Locator nominatimEmptyList;
    private Locator lihatLebihBanyakButton;
    private Locator backToTopButton;
    private Locator areaText;
    private Locator cariBerdasarkanPetaButton;
    private Locator kosTidakDitemukanHeading;
    private Locator hapusSemuaFilterButton;
    private Locator sortButton;
    private Locator kosPrice;
    Locator dikelolaMamikosButton;
    Locator dikelolaMamikosToggle;
    Locator dikelolaMamikosLabel;

    //------ Recomendation Section------
    private Locator recommendationListTitle;
    private Locator mixGenderFilter;

    public KostLandingAreaPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        headingResultText = page.getByRole(AriaRole.HEADING).first();
        filterHarga = page.getByTestId("filter-price").getByText("Harga");
        filterInputMinimalPrice = page.getByRole(AriaRole.TEXTBOX).first();
        filterInputMaximumPrice = page.getByRole(AriaRole.TEXTBOX).nth(1);
        filterPriceSimpanButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Simpan"));
        kostRoomCard = page.getByTestId("kostRoomCard");
        nominatimMap = page.getByText("map Cari berdasarkan Peta Leaflet | © OpenStreetMap, Mamikos");
        filterResetText = page.getByText("Coba kurangi atau hapus filter untuk hasil pencarian yang lebih banyak.");
        filterResetButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Reset filter"));
        imgKosTidakDitemukan = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("kos tidak ditemukan"));
        headingNoKosInAreaText = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Belum Ada Kos di Area Ini"));
        subtitleNoKosInAreaText = page.getByText("Cari di Area lain untuk meningkatkan hasil pencarian kos.");
        nominatimEmptyList = page.locator("div.nominatim-list__empty");
        lihatLebihBanyakButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat lebih banyak lagi"));
        backToTopButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("back-top"));
        areaText = page.locator("span.rc-info__location");
        cariBerdasarkanPetaButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("map Cari berdasarkan Peta"));
        kosTidakDitemukanHeading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Kos Tidak Ditemukan"));
        hapusSemuaFilterButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hapus semua filter"));
        sortButton = page.getByTestId("filter-kost-sorting");
        kosPrice = page.locator("span.rc-price__text");
        dikelolaMamikosButton = page.getByTestId("singgahsini-filter_btn");
        dikelolaMamikosToggle = page.locator("div").getByTestId("singgahsini-filter_tgl");
        dikelolaMamikosLabel = page.getByTestId("roomCardCover-brandIcon").first();
        this.recommendationListTitle = page.locator("//*[@id='app']/div/h1");
        this.mixGenderFilter = page.getByText("Campur").first();
    }

    /**
     * Check visibility of result heading text
     * @return boolean
     */
    public String getResultHeadingText() {
        return playwright.getText(headingResultText);
    }

    /**
     * Filter kost by price/harga
     * @param minimal minimal price
     * @param maximal maximal price
     */
    public void filterByHarga(int minimal, int maximal) {
        playwright.clickOn(filterHarga);
        filterInputMinimalPrice.fill(String.valueOf(minimal));
        filterInputMaximumPrice.fill(String.valueOf(maximal));
        playwright.clickOn(filterPriceSimpanButton);
    }

    /**
     * Get all kost list locators
     * @return List<Locator>
     */
    public List<Locator> getKostListLocator() {
        kostRoomCard.first().waitFor(new Locator.WaitForOptions().setTimeout(30000));
        return kostRoomCard.all();
    }

    /**
     * Check visibility of nominatim map
     * @return boolean
     */
    public boolean isNominatimMapVisible() {
        return playwright.waitTillLocatorIsVisible(nominatimMap);
    }

    /**
     * Check visibility of filter reset text
     * @return boolean
     */
    public boolean isFilterResetTextVisible() {
        return playwright.waitTillLocatorIsVisible(filterResetText);
    }

    /**
     * Check visibility of reset filter button
     * @return boolean
     */
    public boolean isFilterResetButtonVisible() {
        return playwright.waitTillLocatorIsVisible(filterResetButton);
    }

    /**
     * Click on reset filter button
     */
    public void clickOnResetFilterButton() {
        playwright.clickOn(filterResetButton);
    }

    /**
     * Check visibility of image banner kos tidak ditemukan
     * @return boolean
     */
    public boolean isImageKosTidakDitemukanVisible() {
        playwright.waitFor(imgKosTidakDitemukan, 30000.0);
        return playwright.waitTillLocatorIsVisible(imgKosTidakDitemukan);
    }

    /**
     * Check visibility of wording "Belum Ada Kos di Area Ini".
     * @return boolean
     */
    public boolean isNoKostInAreaHeadingTextVisible() {
        return playwright.waitTillLocatorIsVisible(headingNoKosInAreaText);
    }

    /**
     * Check visibility of wording "Cari di Area lain untuk meningkatkan hasil pencarian kos".
     * @return boolean
     */
    public boolean isNoKostInAreaSubtitleTextVisible() {
        return playwright.waitTillLocatorIsVisible(subtitleNoKosInAreaText);
    }

    /**
     * Get text content of nominatim empty list
     * @return List<String>
     */
    public List<String> getAllContentNominatimEmptyList() {
        nominatimEmptyList.textContent();
        return nominatimEmptyList.allTextContents();
    }

    /**
     * Check visibility of lihat lebih banyak lagi button visibility
     * @return boolean
     */
    public boolean isLihatLebihBanyakButtonVisible() {
        return playwright.waitTillLocatorIsVisible(lihatLebihBanyakButton);
    }

    /**
     * Check visibility of back to top button
     * @return boolean
     */
    public boolean isBackToTopButtonVisible() {
        return playwright.waitTillLocatorIsVisible(backToTopButton);
    }

    /**
     * click on lihat lebih banyak button
     */
    public void clickOnLihatLebihBanyakButton() {
        playwright.clickOn(lihatLebihBanyakButton);
    }

    /**
     * Check availability of back to top button
     * @return boolean
     */
    public boolean isBackToTopButtonEnabled() {
        return backToTopButton.isEnabled();
    }

    /**
     * Click on back to top button
     */
    public void clickOnBackToTopButton() {
        playwright.clickOn(backToTopButton);
    }

    /**
     * Get kos area text based on it index
     * @param index desired index int data type
     * @return String
     */
    public String getKosAreaText(int index) {
        List<Locator> listArea = areaText.all();
        return playwright.getText(listArea.get(index));
    }

    /**
     * Get kos area size
     * @return int data type
     */
    public int getKosAreaSize() {
        playwright.waitFor(areaText.first(), 30000.0);
        return areaText.all().size();
    }

    /**
     * Click on cari berdasarkan peta
     */
    public void clickOnCariBerdasarkanPeta() {
        playwright.clickOn(cariBerdasarkanPetaButton);
    }

    /**
     * Click on filter
     * @param filter one of the available filter Dikelola Mamikos etc
     */
    public void clickOnFilter(String filter) {
        var filterButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(filter)).first();
        playwright.clickOn(filterButton);
        if (filter.toLowerCase().equals("dikelola mamikos")) {
            page.locator("div.singgahsini-filter__content").locator("input[type='checkbox']").click();
        }
    }

    /**
     * Check visibility kos tidak ditemukan heading
     * @return boolean
     */
    public boolean isKosTidakDitemukanHeadingVisible() {
        playwright.waitFor(kosTidakDitemukanHeading, 30000.0);
        return playwright.waitTillLocatorIsVisible(kosTidakDitemukanHeading);
    }

    /**
     * Check visibility hapus semua filter button
     * @return boolean
     */
    public boolean hapusSemuaFilterButtonVisible() {
        playwright.waitFor(hapusSemuaFilterButton, 30000.0);
        return playwright.waitTillLocatorIsVisible(hapusSemuaFilterButton);
    }

    /**
     * Set price sorting from cheaper to expensive or vise versa, or recommended kos
     * @param sorting "Harga Termahal" or "Harga Termurah" or "Rekomendasi"
     */
    public void setPriceSortingFrom(String sorting) {
        Locator sortingFromButton = page.getByText(sorting);
        playwright.clickOn(sortButton);
        playwright.clickOn(sortingFromButton);
    }

    /**
     * Get kos price by index list
     * @param index index of list
     * @return
     */
    public int getKostPrice(int index) {
        playwright.waitFor(kosPrice.last(), 30000.0);
        List<Locator> kosPriceList = kosPrice.all();
        return JavaHelpers.extractNumber(playwright.getText(kosPriceList.get(index)));
    }

    /**
     * Get kos price list size
     * @return int data type
     */
    public int getKosPriceListSize() {
        playwright.waitFor(kosPrice.last(), 30000.0);
        return kosPrice.all().size();
    }

    /**
     * Click on filter Mamirooms button
     *
     * @throws InterruptedException
     */

    public void activateFilterDikelolaMamikos() throws InterruptedException {
        playwright.clickOn(dikelolaMamikosButton);
        playwright.forceClickOn(dikelolaMamikosToggle);
        playwright.clickOn(dikelolaMamikosButton);
    }

    /**
     * Check if Singgahsini/Apik label is present
     *
     * @return displayed true, otherwise false
     */
    public boolean isDikelolaMamikosDisplayed() throws InterruptedException {
        return playwright.isLocatorVisibleAfterLoad(dikelolaMamikosButton, 2000.0);
    }


    /**
     * Get arround recommendation kos list Desc Text
     *
     * @return recomendation title in listing
     */
    public String getRecommendationKosList() {
        playwright.waitTillLocatorIsVisible(recommendationListTitle, 5000.0);
        playwright.pageScrollUntilElementIsVisible(recommendationListTitle);
        System.out.println(playwright.getText(recommendationListTitle));
        return playwright.getText(recommendationListTitle);
    }

    /**
     * Check Mix gender is displayed
     *
     * @return status true / false
     */
    public boolean isMixGenderDisplay() {
        return playwright.waitTillLocatorIsVisible(mixGenderFilter, 5000.0);
    }
}
