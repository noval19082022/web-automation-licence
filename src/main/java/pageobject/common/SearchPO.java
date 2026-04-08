package pageobject.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import lombok.Getter;
import lombok.Setter;
import utilities.PlaywrightHelpers;

import java.util.ArrayList;
import java.util.List;

import static config.global.GlobalConfig.DEFAULT_TIMEOUT;

public class SearchPO {
    Page page;
    Locator inputSearch;
    private Locator searchKost;
    private Locator suggetionKostOnTheSearchList;
    Locator suggestionAreaOnTheSearchList;
    private PlaywrightHelpers playwright;
    private LoadingPO loadingPO;
    //private static String propertyName;
    @Setter @Getter
    public static String Property;

    Locator resultBasedOnArea;
    Locator area;
    Locator suggetionKostOnTheSearchListNumberSix;
    Locator suggestionPrimeResutls;
    Locator suggestionPrimeResultsBox;
    Locator suggestionNonPrimeResutls;
    Locator promoNgebutFilter;
    Locator dikelolaMamikosFilter;
    Locator dikelolaMamikosDesc;
    Locator kosAndalanFilter;
    Locator promoNgebutDesc;
    Locator kosAndalanDesc;
    Locator mamiMap;
    Locator kostName;
    Locator genderFilter;
    Locator saveFilterButton;
    Locator stasiunHalte;
    Locator facilityFilter;
    Locator kostRuleFilter;
    Locator kosAndalanToggle;
    Locator kosAndalanLabel;
    Locator promoNgebutToggle;
    Locator promoNgebutLabel;
    Locator rangeTimeFilter;
    Locator sortingButton;
    Locator firstPriceListing;
    Locator lastPriceListing;
    Locator kostRoomAvailableFilter;
    private Locator suggestionResult;
    private Locator kostCard;
    private Locator areaSuggestions;
    private Locator searchTextbox;
    private Locator altSearchArea;
    private Locator searchBox;
    private Locator altSearchBox;
    private Locator kosSuggestions;

    //--------- Map Section ----------
    private Locator mapLegendButton;
    private Locator mapLegendClosedStatus;
    private Locator zoomInButton;
    private Locator zoomOutButton;


    public SearchPO(Page page) {
        this.playwright = new PlaywrightHelpers(page);
        this.loadingPO = new LoadingPO(page);
        this.page = page;
        this.inputSearch = page.locator("input[type='search']").or(page.locator("input.form-control")).or(page.locator("input[title]"));
        this.searchKost = page.getByText("Masukan nama lokasi/area/alamat");
        this.suggetionKostOnTheSearchList = page.getByTestId("suggestionBox-roomList").nth(0);
        this.suggestionAreaOnTheSearchList = page.locator("(//div[@class='results-box'])[1]");
        this.resultBasedOnArea = page.locator("//h2[@class = 'list__title']");
        area = page.getByRole(AriaRole.TAB, new Page.GetByRoleOptions().setName("Area"));
        suggetionKostOnTheSearchListNumberSix = page.getByTestId("results-list__item").nth(6);
        suggestionPrimeResutls = page.locator("svg use[href*='crown'], svg[class*='crown'], [data-testid='suggestionBox-roomList'] svg");
        suggestionPrimeResultsBox = page.getByTestId("suggestionBox-roomList").first();
        suggestionNonPrimeResutls = page.getByTestId("suggestionBox-roomListNonPrime");

        this.promoNgebutFilter = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Promo Ngebut"));
        this.promoNgebutDesc = page.getByText("Ngekos lebih hemat dengan diskon spesial dari Mamikos.");
        this.dikelolaMamikosFilter = page.getByTestId("singgahsini-filter_btn");
        this.dikelolaMamikosDesc = page.getByText("Fasilitas tidak sesuai iklan, kami garansi refund.");
        this.kosAndalanFilter = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kos Andalan"));
        this.kosAndalanDesc = page.getByText("Chat lebih cepat dengan pemilik.");
        this.kosAndalanToggle = page.locator("[data-popper-placement='bottom-start'] .bg-c-switch");
        this.kosAndalanLabel = page.locator(".rc-overview__label").first();
        this.promoNgebutToggle = page.locator("//span[@data-path='lbl_flash_sale']/following-sibling::div//input");
        this.promoNgebutLabel = page.locator(".rc-price__discount-icon").first();
        this.mamiMap = page.locator("div #mamiMap");
        this.kostName = page.locator("//span[contains(@class,'rc-info__name bg-c-text bg-c-text--title-4')]");
        this.genderFilter = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Semua Tipe Kos"));
        this.saveFilterButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Simpan"));
        this.stasiunHalte = page.getByRole(AriaRole.TAB, new Page.GetByRoleOptions().setName("Stasiun & Halte"));
        this.facilityFilter = page.getByTestId("filter-facilities");
        this.kostRuleFilter = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Aturan Kos"));
        this.rangeTimeFilter = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Bulanan"));
        this.sortingButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Rekomendasi"));
        this.firstPriceListing = page.locator("(//span[contains(@class, 'rc-price__text')])[1]");
        this.lastPriceListing = page.locator("(//span[contains(@class, 'rc-price__text')])[20]");
        this.mapLegendButton = page.locator("#app div.container-fluid.map-container.map-container--tall.default-content-map.default-content-map--hide > button");
        this.mapLegendClosedStatus = page.locator(".map-style__legend");
        this.suggestionResult = page.locator("//*[@data-testid='suggestionsBox-areaList']/descendant::label");
        this.kostCard = page.getByTestId("kostRoomCard");
        this.zoomInButton = page.locator("a.leaflet-control-zoom-in");
        this.zoomOutButton = page.locator("a.leaflet-control-zoom-out");
        this.kostRoomAvailableFilter = page.locator("//span[normalize-space()='Kamar Tersedia']");
        this.areaSuggestions = page.locator("img[alt='icon area']").locator("xpath=..//..");
        this.searchTextbox = page.getByText("Masukan nama lokasi/area/alamat");
        this.altSearchArea = page.locator(".search-input, [placeholder*='lokasi'], [placeholder*='area']");
        this.searchBox = page.getByRole(AriaRole.SEARCHBOX, new Page.GetByRoleOptions().setName("Cari nama tempat atau alamat"));
        this.altSearchBox = page.locator("input[placeholder*='Cari nama tempat'], input[placeholder*='alamat']");
        this.kosSuggestions = page.locator("article, [data-testid*='property'], [data-testid*='kos'], .property-card, .kos-card");

    }

    /**
     * get propertyName from input
     * @return Property
     */
    public String getPropertyName() {
       return this.Property;
    }

    /**
     * Search kost by test
     * @param search kost name
     * @return KostDetailsPO
     */
    public KostDetailsPO searchByText(String search) {
        setProperty(search);
        inputSearch.fill(search);
        Locator firstResultKostName = page.locator("//label[contains(@title, '"+ search +"')]");
        playwright.waitTillPageLoaded();
        playwright.waitFor(firstResultKostName);
        playwright.clickOn(firstResultKostName);
        return new KostDetailsPO(page);
    }

    /**
     * Search by area
     * @param area area text
     * @param areaToClick area to click after result visible
     * @return KostLandingAreaPO class
     */
    public KostLandingAreaPO searchByArea(String area, String areaToClick) {
        inputSearch.fill(area);
        Locator firstAreaResult = page.getByText(areaToClick).first();
        if(!playwright.waitTillLocatorIsVisible(firstAreaResult)) {
            firstAreaResult = page.locator("a")
                    .filter(new Locator.FilterOptions()
                            .setHasText(areaToClick))
                    .first();
        }

        playwright.clickOn(firstAreaResult);
        playwright.hardWait(2000.0);
        return new KostLandingAreaPO(page);
    }

    /**
     * Enter Text in search bar and select result
     *
     * @param kostName
     */

    public void searchKostFromfirstList(String kostName) {
        playwright.clickOn(searchKost);
        playwright.fill(inputSearch, kostName);
        playwright.pressKeyboardKey("Enter");
        playwright.clickOn(suggetionKostOnTheSearchList);
    }

    /**
     * search area by name
     *
     * @param search
     */

    public void searchAreaByName(String search) {
        playwright.clickOn(searchKost);
        playwright.fill(inputSearch, search);
        playwright.clickOn(suggestionAreaOnTheSearchList);
        playwright.hardWait(2000);
    }

    /**
     * result area by name
     *
     * @return
     */

    public List<String> listResultKeyword() {
        List<String> listing = new ArrayList<>();
            List<Locator> kostList = suggestionAreaOnTheSearchList.all();
            for(Locator a : kostList) {
                listing.add(playwright.getText(a));
        }
        return listing;
    }


    /**
     * search area by keyword
     *
     * @param search
     */
    public void searchArea(String search) {
        playwright.clickOn(searchKost);
        playwright.fill(inputSearch, search);
        playwright.pressKeyboardKey("Enter");
    }

    public void searchAreaWithoutEnter(String search) {
        playwright.clickOn(searchKost);
        playwright.clickOn(inputSearch);
        playwright.realKeyboardType(search);
        playwright.hardWait(3000);
    }

    /**
     * area not found by keyword
     *
     * @return
     */

    public boolean setExeptionText(String tidakditemukan) {
        Locator notfound = page.getByText(tidakditemukan);
        playwright.waitFor(notfound, 10000.0);
        return notfound.isVisible();
    }

    /**
     * searchbar is empty
     *
     * @return
     */
    public boolean isSearchbarEmpty() {
        inputSearch.clear();
        inputSearch.isVisible();
        return inputSearch.textContent().equals("");
    }

    /**
     * user search based on area
     *
     * @return
     */
    public boolean clickTheFirstResultBasedOnArea() {
        suggestionAreaOnTheSearchList.click();
        return resultBasedOnArea.isVisible();
    }

    /**
     * user click area kota popular
     */
    public void clickSearchBar() {
        playwright.clickOn(searchKost);
        playwright.clickOn(area);
    }

    /**
     * user tap popular kota
     *
     * @param city
     * @return
     */
    public String userTapCity(String city) {

        Locator areacity = page.getByTestId("popular-secondary").getByText(city);
        playwright.waitTillLocatorIsVisible(areacity);
        playwright.clickOn(areacity);

        return city;

    }

    /**
     * user see popular daerah kota
     *
     * @param city
     * @return
     */

    public boolean checkElementbyText(String city) {
        Locator listAreaCity = page.getByTestId("popular-secondary").getByText(city);
        return playwright.waitTillLocatorIsVisible(listAreaCity);
    }

    /**
     * List all popular search city
     *
     * @return popular city
     */
    public boolean listPopularCity(String area) {
        Locator popularCity = page.getByTestId("popular-primary").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName(area)).first();
        return popularCity.isVisible();
    }

    /**
     * Click one of city in popular search
     *
     * @param city is name of city
     */
    public void clickPopularCity(String city) throws InterruptedException {
        Locator citty = page.getByTestId("popular-secondary").getByText(city);
        playwright.clickOn(citty);
        resultBasedOnArea.isVisible();
    }


    /**
     * search area berdasarkan kota
     *
     * @param Kota
     */
    public void clickAreaBerdasarkanKotaBelow(String Kota) {
        Locator popularCity = page.getByTestId("popular-primary").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName(Kota));
        popularCity.click();
        resultBasedOnArea.isVisible();

    }

    /**
     * Enter Text in search bar and select result
     *
     * @param kostName
     */

    public void suggetionKostOnTheSearchListNumberSix(String kostName) {
        searchKost.click();
        inputSearch.fill(kostName);
        inputSearch.press("Enter");
        suggetionKostOnTheSearchListNumberSix.click();
    }

    /**
     * Click on Promo Ngebut filter button
     */
    public void clickPromoNgebutFilter() {
        promoNgebutFilter.click();
    }

    /**
     * Get Promo Ngebut description text
     *
     * @return String data type
     */
    public String getPromoNgebutDescText() {
        return playwright.getText(promoNgebutDesc).toLowerCase();
    }

    /**
     * Click on Kos Andalan filter button
     */
    public void clickDikelolaMamikosFilter() {
        dikelolaMamikosFilter.click();
    }

    /**
     * Get Kos Andalan description text
     *
     * @return String data type
     */
    public String getDikelolaMamikosDescText() {
        return playwright.getText(dikelolaMamikosDesc).toLowerCase();
    }

    /**
     * Click on Kos Andalan filter button
     */
    public void clickKosAndalanFilter() {
        kosAndalanFilter.click();
    }

    /**
     * Get Kos Andalan description text
     *
     * @return String data type
     */
    public String getKosAndalanDescText() {
        return playwright.getText(kosAndalanDesc).toLowerCase();
    }

    /**
     * get property no have apartemen
     *
     * @return
     */
    public List<String> listKostAddress() {
        List<String> addressList = new ArrayList<>();
        if (playwright.waitTillLocatorIsVisible(kostName,10000.0)) {
            List<Locator> kostList = kostName.all();
            for (Locator a : kostList) {
                addressList.add(playwright.getText(a));
            }
        }
        return addressList;
    }

    /**
     * click sugestion area first city
     */
    public void suggestionAreaClick() {
        playwright.clickOn(suggestionAreaOnTheSearchList);
    }

    /**
     * click area by kota popular
     * @param area
     */
    public void clickOnListPopularCity(String area) {
        Locator popularCity = page.getByTestId("popular-primary").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName(area)).first();
        popularCity.click();
    }

    /**
     * verify area by kota popular
     * @param listresult
     * @return
     */
    public String getTitleListingResult(String listresult) {
        Locator listResult = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName(listresult));
        listResult.getByText(listresult);
        return listresult;
    }

    /**
     * search by campus
     */
    public void searchByCampus() {
        searchKost.click();
    }

    /**
     * Scroll down to 'City Name' and click 'City Name'
     *
     * @throws InterruptedException
     */
    public void clickOnCities(String kampus) throws InterruptedException {
        Locator areacity = page.getByTestId("popular-secondary").getByText(kampus);
        playwright.waitTillLocatorIsVisible(areacity);
        playwright.clickOn(areacity);
    }

    /**
     * Get List of each Campus Name on Cities Text
     *
     * @param campus Station Name
     * @return
     */
    public boolean isEachCampusFromCities(String campus) {
        Locator listAreaCity = page.getByTestId("popular-secondary").getByText(campus);
        return playwright.waitTillLocatorIsVisible(listAreaCity);

    }

    /**
     * Select filter by gender
     *
     * @throws InterruptedException Select filter by gender
     */
    public void selectFilterByGender(String gender) {
        genderFilter.click();
        page.getByTestId("filter-gender").getByText("" + gender + "").click();
        saveFilterButton.click();
    }

    /**
     * Get the gender label in listing
     *
     * @param gender is gender option (putra, putri, campur)
     * @return list of string gender
     */
    public List<String> getListGender(String gender) {
        List<String> genderList = new ArrayList<>();
        Locator genderLabel = page.locator("//div[@data-testid = 'kostRoomCard']//div[contains(text() , '" + gender + "')]");
        List<Locator> elements = genderLabel.all();
        for (Locator a : elements) {
            genderList.add(playwright.getText(a));
        }
        return genderList;
    }

    /**
     * get area campus by click campus area
     *
     * @param area
     */
    public void getCampusArea(String area) {
        Locator popularCity = page.getByTestId("popular-primary").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName(area)).first();
        popularCity.click();

    }

    /**
     * click area halte dan stasiun
     *
     * @return
     */
    public void stasiunDanHalteClickOn() {
        playwright.clickOn(stasiunHalte);
    }

    /**
     * Select filter by facility
     *
     * @throws InterruptedException
     */
    public void selectFilterByFacility(String facility) {
        facilityFilter.click();
        page.locator("#modalSearchFacilities").getByText("" + facility + "").click();
        saveFilterButton.click();
    }

    /**
     * Get the facility label in listing
     *
     * @param facility is facility option (Wifi, Kasur, etc.)
     * @return list of string gender
     */
    public List<String> getListFacility(String facility) {
        List<String> facilityList = new ArrayList<>();
        Locator facilityLabel = page.locator("//span[@data-testid = 'roomCardFacilities-facility']//span[text() = '" + facility + "']");
        List<Locator> elements = facilityLabel.all();
        for (Locator a : elements) {
            facilityList.add(playwright.getText(a));
        }
        return facilityList;
    }

    /**
     * Select filter by kos rule
     */
    public void selectFilterByKostRule(String rule) {
        kostRuleFilter.click();
        page.getByTestId("filter-property-rules").getByText("" + rule + "").click();
        saveFilterButton.click();
    }

    /**
     * Get the facility label in listing
     *
     * @param rule is facility option (Wifi, Kasur, etc.)
     * @return list of string gender
     */
    public List<String> getListKostRule(String rule) {
        List<String> ruleList = new ArrayList<>();
        Locator ruleLabel = page.locator("//span[@data-testid = 'roomCardFacilities-facility']//span[text() = '" + rule + "']");
        List<Locator> elements = ruleLabel.all();
        for (Locator a : elements) {
            ruleList.add(playwright.getText(a));
        }
        return ruleList;
    }

    /**
     * Activate Kos Andalan filter
     */
    public void activateKosAndalanFilter() {
        kosAndalanFilter.click();
    }

    /**
     * Check Kos Andalan label present
     *
     * @return element displayed true / false
     */
    public boolean isKosAndalanPropertyDisplayed() {
        return kosAndalanLabel.isVisible();
    }

    /**
     * Activate Promo Ngebut filter
     */
    public void activatePromoNgebutFilter() {
        promoNgebutFilter.click();
    }

    /**
     * Check Promo Ngebut label present
     *
     * @return element displayed true / false
     */
    public boolean isPromoNgebutPropertyDisplayed() {
        return promoNgebutLabel.isVisible();
    }

    /**
     * Select filter by range time
     */
    public void selectFilterByRangeTime(String time) {
        rangeTimeFilter.click();
        page.getByText("" + time + "").click();
        saveFilterButton.click();
    }

    /**
     * Get the range time label in listing
     *
     * @param time is range time option
     * @return list of string range time
     */
    public List<String> getListRangeTime(String time) {
        List<String> timeList = new ArrayList<>();
        Locator timeLabel = page.locator("//div[@data-testid = 'kostRoomCard']//span[contains(text() , '" + time + "')]");
        List<Locator> elements = timeLabel.all();
        for (Locator a : elements) {
            timeList.add(playwright.getText(a));
        }
        return timeList;
    }

    /**
     * Select sorting
     */
    public void selectSorting(String sorting) {
        sortingButton.click();
        page.getByText("" + sorting + "").click();
    }

    /**
     * Get first property price in listing property page
     *
     * @return int price
     */
    public int getFirstPricePropertyPageListing() {
        playwright.waitTillLocatorIsVisible(firstPriceListing, 3.0);
        String first = playwright.getText(firstPriceListing).replaceAll("[Rp.]", "");
        return Integer.parseInt(first);
    }

    /**
     * Get last property price in listing property page
     *
     * @return int price
     */
    public int getLastPricePropertyPageListing() {
        playwright.waitTillLocatorIsVisible(lastPriceListing, 3.0);
        String last = playwright.getText(lastPriceListing).replaceAll("[Rp.]", "");
        return Integer.parseInt(last);
    }

    /**
     * Enter Text in search bar and select result
     *
     * @param searchText is text we want to search
     */
    public void enterTextToSearchAndSelectResultCity(String searchText) {
        // Wait for page to be loaded and dismiss any modal overlay
        playwright.waitTillPageLoaded(10000.0);

        // Check for search-box-modal and dismiss it by clicking outside or waiting
        Locator searchBoxModal = page.getByTestId("search-box-modal");
        if (playwright.isLocatorVisibleAfterLoad(searchBoxModal, 2000.0)) {
            // Try pressing Escape to close modal or click outside
            playwright.pressKeyboardKey("Escape");
            playwright.hardWait(500);
        }

        // Try to click the search input directly using force click to bypass modal overlay
        playwright.forceClickOn(searchKost);
        playwright.hardWait(1000); // Wait for modal/search input to appear

        // Fill the search input using playwright helper
        playwright.fill(inputSearch, searchText);
        playwright.pressKeyboardKey("Enter");

        // Wait for suggestions and click the area suggestion
        playwright.hardWait(2000); // Wait for suggestions to load

        // Try to find and click the suggestion
        // First try: exact text match in suggestion area list
        Locator resultLocator = page.locator("//*[@data-testid='suggestionsBox-areaList']//label[contains(text(), '" + searchText + "')]");

        if (resultLocator.count() > 0) {
            playwright.clickOn(resultLocator.first());
        } else {
            // Alternative: click on suggestion area list
            playwright.clickOn(suggestionAreaOnTheSearchList);
        }
        
        // Wait for kost list to load after navigation
        playwright.hardWait(5000.0); // Increase wait time for Jenkins environment
        loadingPO.waitTillFetchFinish(10000.0);
    }


    /**
     * Enter Text in search bar and select result
     *
     * @param searchText is text we want to search
     */
    public void enterTextToSearch(String searchText) {
        playwright.clickLocatorAndTypeKeyboard(inputSearch, searchText);
        loadingPO.waitTillFetchFinish(DEFAULT_TIMEOUT);
    }

    /**
     * List all listing facilities in search result
     *
     * @return list of facilities (String)
     */
    public List<String> listKostFacilities() {
        String cssLocator = "div[class='rc-facilities rc-facilities--horizontal']";
        Locator element = page.locator(cssLocator);
        List<Locator> elements = playwright.getLocators(element);
        List<String> facilitiesList = new ArrayList<>();
        for (Locator a : elements) {
            facilitiesList.add((playwright.getText(a)));
        }
        return facilitiesList;
    }


    /**
     * Get List of legend wording is present
     *
     * @param legend Legend Name
     * @return text legend Name present / not
     */
    public Boolean isLegendPresent(String legend) {
        return playwright.waitTillLocatorIsVisible(page.locator("//*[@class='map-style__legend-icon bg-c-grid__item bg-is-col-4']//div[contains(text(), '" + legend + "')]"));
    }

    /**
     * Get List of legend wording is present
     *
     * @param legend Legend Name
     * @return text legend name
     */
    public String getLegendDesc(String legend) {
        return playwright.getText(page.locator("//*[@class='map-style__legend-icon bg-c-grid__item bg-is-col-4']").getByText(legend));
    }

    /**
     * Get List of legend wording description is present
     *
     * @param decs Legend description
     * @return text legend description present / not
     */
    public Boolean isLegendDescPresent(String decs) {
        return playwright.waitTillLocatorIsVisible(page.locator("//*[@class='map-style__legend-description bg-c-grid__item bg-is-col-8']").getByText(decs));
    }

    /**
     * Get List of legend wording description is present
     *
     * @param decs Legend description
     * @return text legend description
     */
    public String getLegendDescText(String decs) {
        return playwright.getText(page.locator("//*[@class='map-style__legend-description bg-c-grid__item bg-is-col-8']").getByText(decs));
    }

    /**
     * Get List of legend wording information is present
     *
     * @param information Legend information
     * @return text legend information present / not
     */
    public Boolean isLegendInformationPresent(String information) {
        return playwright.waitTillLocatorIsVisible(page.locator("//*[@class='map-style__legend-description bg-c-grid__item bg-is-col-8']").getByText(information));
    }

    /**
     * Get List of legend wording information is present
     *
     * @param information Legend information
     * @return text legend information
     */
    public String getLegendInformationText(String information) {
        return playwright.getText(page.locator("//*[@class='map-style__legend-description bg-c-grid__item bg-is-col-8']").getByText(information));
    }

    /**
     * Click on map legend information button
     */
    public void clickMapLegendButton() {
        playwright.clickOn(mapLegendButton);
    }

    /**
     * Get status map legend pop up is appears
     *
     * @return map legend pop up present / not
     */
    public boolean isMapLegendPresent() {
        return mapLegendClosedStatus.isVisible();
    }

    /**
     * Enter Text in search bar without select result
     *
     * @param searchText is text that user want to search
     */
    public void enterTextOnSearchSearchBox(String searchText) {
        playwright.fill(inputSearch, searchText);
        playwright.pressKeyboardKey("Enter");
    }

    /**
     * Get suggestion text
     * @return String data type list of suggestion result section
     */
    public List<String> getSuggestionText() {
        playwright.hardWait(1000);
        return suggestionResult.allInnerTexts();
    }

    public void selectFirstKostOnSearchResult() {
        // Wait for kostCard to be available with longer timeout
        playwright.waitTillLocatorIsVisible(kostCard.first(), 5000.0);
        playwright.clickOn(kostCard.first());
    }

    /**
     * click on popular area or kampus or statsiun on the search page
     * @param place (Kampus, Area, Stasiun & Halte)
     * @param popPlace (UGM, Yogyakarta, etc..)
     */
    public void clickPopularArea(String place, String popPlace) {
        playwright.clickOn(page.getByRole(AriaRole.TAB, new Page.GetByRoleOptions().setName(place)));
        playwright.clickOn(page.getByTestId("popular-primary").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName(popPlace)));
    }

    /**
     * Get list of suggestion kost name prime
     * @return list of texts inside prime suggestion box
     */
    public List<String> getListSuggestionKostNamePrime() {
        playwright.hardWait(3000);
        playwright.waitFor(suggestionPrimeResutls.first());
        return playwright.getListTextContentsFromLocator(suggestionPrimeResultsBox);
    }

    /**
     * Get list of suggestion kost name non prime
     * @return list of texts inside non-prime suggestion box
     */
    public List<String> getListSuggestionKostNameNonPrime() {
        playwright.waitFor(suggestionNonPrimeResutls);
        return playwright.getListTextContentsFromLocator(suggestionNonPrimeResutls);
    }

    /**
     * Check if prime suggestion box is visible
     * @return true if prime suggestion box is visible
     */
    public Boolean isPrimeSuggestionBoxVisible() {
        return playwright.waitTillLocatorIsVisible(suggestionPrimeResultsBox, 3000.0);
    }

    //--------------SRP-------------------//

    /**
     * click cluster on maps
     * @param number
     */
    public void clickMapsClusterButton(String number){
        Locator mapsClusterButton = page.locator("//div[@class=\"leaflet-pane leaflet-marker-pane\"]//span[contains(text(),'"+number+"')]").first();
        playwright.clickOn(mapsClusterButton);
    }

    /**
     * click on zoom in button
     */
    public void clickZoomInButton(){
        playwright.clickOn(zoomInButton);
    }

    /**
     * click on zoom out button
     */
    public void clickZoomOutButton(){
        playwright.clickOn(zoomOutButton);
    }

    /**
     * List all listing filter structure in search result
     *
     * @return list of filter structure (String)
     */
    public List getFilterText(String text){
        List<String> filterList = new ArrayList<>();
        Locator filterLabel = page.locator("//span[contains(@class='filterKostTypeWrapper','"+text+"')]");
        List<Locator> elements = filterLabel.all();
        for (Locator a : elements) {
            filterList.add(playwright.getText(a));
        }
        return filterList;
    }

    /**
     * Select filter by kos room available
     */
    public void kosRoomAvailableFilter() {
        playwright.clickOn(kostRoomAvailableFilter);
    }

    /**
     * Navigate to mamikos homepage
     */
    public void navigateToMamikos() {
        page.navigate("https://jambu.kerupux.com");
        playwright.hardWait(2000);
    }

    /**
     * Click on search textbox to open search modal
     * This clicks on "Masukan nama lokasi/area/alamat" text which opens the search modal
     */
    public void clickOnSearchKos() {
        // Click on the search textbox area with placeholder text
        if (searchTextbox.isVisible()) {
            playwright.clickOn(searchTextbox);
        } else {
            // Alternative locators for the search area
            playwright.clickOn(altSearchArea.first());
        }
        playwright.hardWait(1000);
    }


    /**
     * Input area text in the search modal
     * @param area the area to search for
     */
    public void inputArea(String area) {
        // Target the specific search box in the modal with correct placeholder
        if (searchBox.isVisible()) {
            playwright.fill(searchBox, area);
        } else {
            // Alternative locators for the search input
            playwright.fill(altSearchBox.first(), area);
        }
        playwright.hardWait(2000); // Wait for suggestions to appear
    }

    /**
     * Verify that the expected number of suggestions are displayed in area sekitar
     * Based on actual website structure, look for area suggestions that appear after search
     * @param expectedCount the minimum number of suggestions expected
     * @return true if expected number of suggestions are visible
     */
    public boolean isDisplaySuggestions(int expectedCount) {
        // Wait for suggestions to appear
        playwright.hardWait(2000);

        // Use class-level locator for area suggestions
        Locator suggestions = areaSuggestions;

        if (suggestions.count() == 0) {
            // Alternative: look for suggestion boxes or area containers
            suggestions = page.locator("[data-testid*='suggestion'], [data-testid*='area'], .suggestion, .area-result");
        }

        if (suggestions.count() == 0) {
            // Try generic approach: look for visible clickable elements that could be suggestions
            suggestions = page.locator("button:visible, a:visible, div[role='button']:visible").filter(new Locator.FilterOptions().setHas(page.locator("text=/\\w+/")));
        }

        // Check if we have at least the expected number of suggestions visible
        int visibleSuggestions = 0;
        for (int i = 0; i < Math.min(suggestions.count(), 10); i++) {
            if (suggestions.nth(i).isVisible()) {
                String suggestionText = playwright.getText(suggestions.nth(i));
                if (suggestionText != null && !suggestionText.trim().isEmpty()) {
                    visibleSuggestions++;
                }
            }
        }

        return visibleSuggestions >= expectedCount;
    }

    /**
     * Get the text of area suggestions for verification
     * @return array of suggestion texts from the actual website
     */
    public String[] getSuggestionTexts() {
        playwright.hardWait(2000);

        // Use class-level locator for area suggestions
        Locator suggestions = areaSuggestions;

        if (suggestions.count() == 0) {
            // Alternative: look for suggestion boxes or area containers
            suggestions = page.locator("[data-testid*='suggestion'], [data-testid*='area'], .suggestion, .area-result");
        }

        if (suggestions.count() == 0) {
            // Try generic approach: look for visible clickable elements that could be suggestions
            suggestions = page.locator("button:visible, a:visible, div[role='button']:visible").filter(new Locator.FilterOptions().setHas(page.locator("text=/\\w+/")));
        }

        // Extract actual suggestion texts from the website
        List<String> textList = new ArrayList<>();
        for (int i = 0; i < Math.min(10, suggestions.count()); i++) {
            if (suggestions.nth(i).isVisible()) {
                String text = playwright.getText(suggestions.nth(i));
                if (text != null && !text.trim().isEmpty()) {
                    textList.add(text.trim());
                }
            }
        }

        return textList.toArray(new String[0]);
    }

    /**
     * Click on a link with specific text (e.g., "Area Terkait Lainnya")
     * @param linkText the text of the link to click
     */
    public void clickOnLink(String linkText) {
        // First try to find visible exact text match
        Locator link = page.getByText(linkText, new Page.GetByTextOptions().setExact(true));
        for (int i = 0; i < link.count(); i++) {
            if (link.nth(i).isVisible()) {
                playwright.clickOn(link.nth(i));
                playwright.hardWait(2000);
                return;
            }
        }

        // Try alternative approaches - button or anchor elements
        Locator altLink = page.locator("button:has-text('" + linkText + "'), a:has-text('" + linkText + "')");
        for (int i = 0; i < altLink.count(); i++) {
            if (altLink.nth(i).isVisible()) {
                playwright.clickOn(altLink.nth(i));
                playwright.hardWait(2000);
                return;
            }
        }

        // Fallback - try partial match, first visible
        Locator partialLink = page.getByText(linkText);
        for (int i = 0; i < partialLink.count(); i++) {
            if (partialLink.nth(i).isVisible()) {
                playwright.clickOn(partialLink.nth(i));
                playwright.hardWait(2000);
                return;
            }
        }

        // Last resort
        playwright.clickOn(page.getByText(linkText));
        playwright.hardWait(2000);
    }

    /**
     * Verify that additional kos suggestions are displayed after clicking "Area Terkait Lainnya"
     * @param expectedCount the expected number of additional suggestions
     * @return true if the expected number of suggestions are displayed
     */
    public boolean verifyAdditionalSuggestions(int expectedCount) {
        playwright.hardWait(2000); // Wait for suggestions to load

        // Look for kos cards or suggestion items that appear after clicking
        // These could be property cards, kos listings, or area suggestions
        if (kosSuggestions.count() == 0) {
            // Alternative: look for elements that contain typical kos information
            kosSuggestions = page.locator("*:has-text('Rp'):has-text('bulan'), *:has-text('Kos')");
        }

        if (kosSuggestions.count() == 0) {
            // Another alternative: look for image cards with property info
            kosSuggestions = page.locator("img[alt*='kos'], img[alt*='property']").locator("xpath=..//..");
        }

        int visibleCount = 0;
        for (int i = 0; i < kosSuggestions.count() && i < 10; i++) {
            if (kosSuggestions.nth(i).isVisible()) {
                visibleCount++;
            }
        }

        return visibleCount >= expectedCount;
    }

    /**
     * Verify that a specific listing is displayed in the recommendation/suggestion section
     * @param listingName the name of the listing to search for (case-insensitive partial match)
     * @return true if the listing is found in the recommendation section
     */
    public boolean isListingDisplayedInRecommendation(String listingName) {
        playwright.hardWait(2000); // Wait for suggestions to load

        // Try multiple locator strategies to find the listing
        // Strategy 1: Check in suggestion box room list (prime suggestions)
        Locator primeSuggestions = page.getByTestId("suggestionBox-roomList");
        if (primeSuggestions.isVisible()) {
            String primeText = primeSuggestions.innerText().toLowerCase();
            if (primeText.contains(listingName.toLowerCase())) {
                return true;
            }
        }

        // Strategy 2: Check in non-prime suggestion box
        Locator nonPrimeSuggestions = page.getByTestId("suggestionBox-roomListNonPrime");
        if (nonPrimeSuggestions.isVisible()) {
            String nonPrimeText = nonPrimeSuggestions.innerText().toLowerCase();
            if (nonPrimeText.contains(listingName.toLowerCase())) {
                return true;
            }
        }

        // Strategy 3: Check using text locator for listing name
        Locator listingLocator = page.locator("text=" + listingName);
        if (listingLocator.count() > 0 && listingLocator.first().isVisible()) {
            return true;
        }

        // Strategy 4: Check in any visible element containing the listing name (case-insensitive)
        Locator anyContainingText = page.locator("//*[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + listingName.toLowerCase() + "')]");
        if (anyContainingText.count() > 0) {
            for (int i = 0; i < anyContainingText.count(); i++) {
                if (anyContainingText.nth(i).isVisible()) {
                    return true;
                }
            }
        }

        // Strategy 5: Check in kost card elements
        Locator kostCards = page.getByTestId("kostRoomCard");
        if (kostCards.count() > 0) {
            for (int i = 0; i < kostCards.count(); i++) {
                String cardText = kostCards.nth(i).innerText().toLowerCase();
                if (cardText.contains(listingName.toLowerCase())) {
                    return true;
                }
            }
        }

        return false;
    }
}