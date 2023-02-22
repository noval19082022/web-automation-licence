package pageobject.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class SearchPO {
    Page page;
    Locator inputSearch;
    private Locator searchKost;
    private Locator suggetionKostOnTheSearchList;
    Locator suggestionAreaOnTheSearchList;
    private PlaywrightHelpers playwright;
    Locator resultBasedOnArea;
    Locator area;


    public SearchPO(Page page) {
        this.playwright = new PlaywrightHelpers(page);
        this.page = page;
        this.inputSearch = page.locator("input[title]");
        this.searchKost = page.getByText("Masukan nama lokasi/area/alamat");
        this.suggetionKostOnTheSearchList = page.locator("(//label[@class='results-title'])[6]");
        this.suggestionAreaOnTheSearchList = page.locator("(//label[@class='results-title'])[1]");
        this.resultBasedOnArea = page.locator(".row");
        area = page.getByRole(AriaRole.TAB, new Page.GetByRoleOptions().setName("Area"));


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
}
