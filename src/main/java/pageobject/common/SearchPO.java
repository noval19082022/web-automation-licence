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
    Locator facilityFilter;
    Locator kostRuleFilter;



    public SearchPO(Page page) {
        this.playwright = new PlaywrightHelpers(page);
        this.page = page;
        this.inputSearch = page.locator("input[title]");
        this.searchKost = page.getByText("Masukan nama lokasi/area/alamat");
        this.suggetionKostOnTheSearchList = page.getByTestId("suggestionBox-roomList").nth(0);
        this.suggestionAreaOnTheSearchList = page.locator("(//div[@class='results-box'])[1]");
        this.resultBasedOnArea = page.locator(".row");
        area = page.getByRole(AriaRole.TAB, new Page.GetByRoleOptions().setName("Area"));
        suggetionKostOnTheSearchListNumberSix =page.getByTestId("results-list__item").nth(6);

        this.promoNgebutFilter = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("flash Promo Ngebut"));
        this.promoNgebutDesc = page.getByText("Dapat diskon pembayaran pertama harga sewa. ");
        this.kosAndalanFilter = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kos Andalan"));
        this.kosAndalanDesc = page.getByText("Kos favorit dengan harga hemat, ");
        this.mamiMap = page.locator("div #mamiMap");
        this.kostName = page.locator("//span[contains(@class,'rc-info__name bg-c-text bg-c-text--title-4')]");
        this.genderFilter = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("male-and-female Semua Tipe Kos"));
        this.saveFilterButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Simpan"));
        this.facilityFilter = page.getByTestId("filter-facilities");
        this.kostRuleFilter = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Aturan Kos"));



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

    public boolean listResultKeyword(String area) {
        Locator areaCity = page.getByText(area).nth(1);
        return areaCity.isVisible();
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
<<<<<<< HEAD
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

    /** Click one of city in popular search
     * @param city is name of city
     */
    public void clickPopularCity(String city) throws InterruptedException {
        Locator citty = page.getByTestId("popular-secondary").getByText(city);
        playwright.clickOn(citty);
        resultBasedOnArea.isVisible();
    }


    /**
     * search area berdasarkan kota
     * @param Kota
     */
    public void clickAreaBerdasarkanKotaBelow(String Kota){
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

    /** Click on Promo Ngebut filter button
     */
    public void clickPromoNgebutFilter(){
        promoNgebutFilter.click();
    }

    /**
     * Get Promo Ngebut description text
     * @return String data type
     */
    public String getPromoNgebutDescText() {
        return playwright.getText(promoNgebutDesc).toLowerCase();
    }

    /**
     * Click on Kos Andalan filter button
     */
    public void clickKosAndalanFilter(){
        kosAndalanFilter.click();
    }

    /**
     * Get Kos Andalan description text
     * @return String data type
     */
    public String getKosAndalanDescText() {
        return playwright.getText(kosAndalanDesc).toLowerCase();
    }

    /**
     * get property no have apartemen
     * @return
     */
    public List<String> listKostAddress(){
        List<String> addressList = new ArrayList<>();
        if(playwright.waitTillLocatorIsVisible(mamiMap)){
            List<Locator> kostList = kostName.all();
            for(Locator a : kostList) {
                addressList.add(playwright.getText(a));
            }
        }
        return addressList;
    }

    /**
     * click sugestion area first city
     */
    public void suggestionAreaClick(){
        suggestionAreaOnTheSearchList.click();
    }

    /**
     * Select filter by gender
     */
    public void selectFilterByGender(String gender){
        genderFilter.click();
        page.getByTestId("filter-gender").getByText(""+ gender +"").click();
        saveFilterButton.click();
    }

    /**
     * Get the gender label in listing
     * @return list of string gender
     * @param gender is gender option (putra, putri, campur)
     */
    public List<String> getListGender(String gender){
        List<String> genderList = new ArrayList<>();
        Locator genderLabel = page.locator("//div[@data-testid = 'kostRoomCard']//div[contains(text() , '"+ gender+"')]");
        List<Locator> elements = genderLabel.all();
        for(Locator a: elements){
            genderList.add(playwright.getText(a));
        }
        return genderList;
    }

    /**
     * Select filter by facility
     * @throws InterruptedException
     */
    public void selectFilterByFacility(String facility){
        facilityFilter.click();
        page.locator("#modalSearchFacilities").getByText(""+ facility +"").click();
        saveFilterButton.click();
    }

    /**
     * Get the facility label in listing
     * @return list of string gender
     * @param facility is facility option (Wifi, Kasur, etc.)
     */
    public List<String> getListFacility(String facility){
        List<String> facilityList = new ArrayList<>();
        Locator facilityLabel = page.locator("//span[@data-testid = 'roomCardFacilities-facility']//span[text() = '"+ facility +"']");
        List<Locator> elements = facilityLabel.all();
        for(Locator a: elements){
            facilityList.add(playwright.getText(a));
        }
        return facilityList;
    }

    /**
     * Select filter by kos rule
     */
    public void selectFilterByKostRule(String rule){
        kostRuleFilter.click();
        page.getByTestId("filter-property-rules").getByText(""+ rule +"").click();
        saveFilterButton.click();
    }

    /**
     * Get the facility label in listing
     * @return list of string gender
     * @param rule is facility option (Wifi, Kasur, etc.)
     */
    public List<String> getListKostRule(String rule){
        List<String> ruleList = new ArrayList<>();
        Locator ruleLabel = page.locator("//span[@data-testid = 'roomCardFacilities-facility']//span[text() = '"+ rule +"']");
        List<Locator> elements = ruleLabel.all();
        for(Locator a: elements){
            ruleList.add(playwright.getText(a));
        }
        return ruleList;
    }
}
