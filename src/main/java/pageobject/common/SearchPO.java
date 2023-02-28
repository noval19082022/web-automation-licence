package pageobject.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

import java.util.ArrayList;
import java.util.List;

public class SearchPO {
    Page page;
    Locator inputSearch;
    private Locator searchKost;
    private Locator suggetionKostOnTheSearchList;
    Locator suggestionAreaOnTheSearchList;
    private PlaywrightHelpers playwright;
    Locator resultBasedOnArea;
    Locator area;
    Locator suggetionKostOnTheSearchListNumberSix;
    Locator promoNgebutFilter;
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
    private Locator FTUETitleText;
    private Locator popUpConfirmationbutton;


    public SearchPO(Page page) {
        this.playwright = new PlaywrightHelpers(page);
        this.page = page;
        this.inputSearch = page.locator("input[title]");
        this.searchKost = page.getByText("Masukan nama lokasi/area/alamat");
        this.suggetionKostOnTheSearchList = page.getByTestId("suggestionBox-roomList").nth(0);
        this.suggestionAreaOnTheSearchList = page.locator("(//div[@class='results-box'])[1]");
        this.resultBasedOnArea = page.locator("//h2[@class = 'list__title']");
        area = page.getByRole(AriaRole.TAB, new Page.GetByRoleOptions().setName("Area"));
        suggetionKostOnTheSearchListNumberSix = page.getByTestId("results-list__item").nth(6);

        this.promoNgebutFilter = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("flash Promo Ngebut"));
        this.promoNgebutDesc = page.getByText("Dapat diskon pembayaran pertama harga sewa. ");
        this.kosAndalanFilter = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kos Andalan"));
        this.kosAndalanDesc = page.getByText("Kos favorit dengan harga hemat, ");
        this.kosAndalanToggle = page.locator("[data-popper-placement='bottom-start'] .bg-c-switch");
        this.kosAndalanLabel = page.locator(".rc-overview__label").first();
        this.promoNgebutToggle = page.locator("//span[@data-path='lbl_flash_sale']/following-sibling::div//input");
        this.promoNgebutLabel = page.locator(".rc-price__discount-icon").first();
        this.mamiMap = page.locator("div #mamiMap");
        this.kostName = page.locator("//span[contains(@class,'rc-info__name bg-c-text bg-c-text--title-4')]");
        this.genderFilter = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("male-and-female Semua Tipe Kos"));
        this.saveFilterButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Simpan"));
        this.stasiunHalte = page.getByRole(AriaRole.TAB, new Page.GetByRoleOptions().setName("Stasiun & Halte"));
        this.facilityFilter = page.getByTestId("filter-facilities");
        this.kostRuleFilter = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Aturan Kos"));
        this.rangeTimeFilter = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Bulanan"));
        this.sortingButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("sorting Rekomendasi"));
        this.firstPriceListing = page.locator("(//span[contains(@class, 'rc-price__text')])[1]");
        this.lastPriceListing = page.locator("(//span[contains(@class, 'rc-price__text')])[20]");
        this.FTUETitleText = page.locator("//h2[@data-path='lbl_popperTitle']");
        this.popUpConfirmationbutton = page.locator("button[data-path='btn_popperAction']");
    }

    /**
     * Search kost by test
     *
     * @param search kost name
     * @return KostDetailsPO
     */
    public KostDetailsPO searchByText(String search) {
        inputSearch.fill(search);
        Locator firstResultKostName = page.locator("label").filter(new Locator.FilterOptions().setHasText(search));
        firstResultKostName.click();
        return new KostDetailsPO(page);
    }

    /**
     * Enter Text in search bar and select result
     *
     * @param kostName
     */

    public void searchKostFromfirstList(String kostName) {
        searchKost.click();
        inputSearch.fill(kostName);
        inputSearch.press("Enter");
        suggetionKostOnTheSearchList.click();
    }

    /**
     * search area by name
     *
     * @param search
     */

    public void searchAreaByName(String search) {
        searchKost.click();
        inputSearch.fill(search);
        suggestionAreaOnTheSearchList.click();
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
        searchKost.click();
        inputSearch.fill(search);
        inputSearch.press("Enter");

    }

    /**
     * area not found by keyword
     *
     * @return
     */

    public boolean setExeptionText(String tidakditemukan) {
        Locator notfound = page.getByText(tidakditemukan);
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
        searchKost.click();
        area.click();
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
        if (playwright.waitTillLocatorIsVisible(mamiMap)) {
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
        suggestionAreaOnTheSearchList.click();
    }

    /**
     * <<<<<<< HEAD
     * click area by kota popular
     *
     * @param area
     */
    public void clickOnListPopularCity(String area) {
        Locator popularCity = page.getByTestId("popular-primary").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName(area)).first();
        popularCity.click();
    }

    /**
     * verify area by kota popular
     *
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
        kosAndalanToggle.click();
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
        promoNgebutToggle.click();
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
        inputSearch.fill(searchText);
        inputSearch.press("Enter");
        Locator resultLocator = page.getByText(searchText);
        resultLocator.first().click();
    }

    /**
     * @return true if FTUE present, otherwise false.
     */
    public boolean isFTUE_screenPresent() {
        return playwright.waitTillLocatorIsVisible(FTUETitleText)
                || playwright.waitTillLocatorIsVisible(popUpConfirmationbutton);
    }

    /**
     * Will check First Time User Experience screen first. And then will click on close button on FTUE if present in the screen.
     * Dismiss FTUE first time user experience by click on close button if present.
     */
    public void clickFTUEKosListingPopUp() {
        while (isFTUE_screenPresent()) {
            if (playwright.waitTillLocatorIsVisible(popUpConfirmationbutton)) {
                playwright.clickOn(popUpConfirmationbutton);
            } else {
                break;
            }
        }
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
}