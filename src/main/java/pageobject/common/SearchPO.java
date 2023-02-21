package pageobject.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SearchPO {
    Page page;
    Locator inputSearch;
    private Locator searchKost;
    private Locator searchBoxInput;
    private Locator suggetionKostOnTheSearchList;
    Locator suggestionAreaOnTheSearchList;


    public SearchPO(Page page) {
        this.page = page;
        this.inputSearch = page.locator("input[title]");
        this.searchKost = page.getByText("Masukan nama lokasi/area/alamat");
        this.searchBoxInput = page.locator("input[type='search']");
        this.suggetionKostOnTheSearchList = page.getByTestId("suggestionBox-roomList").nth(0);
        this.suggestionAreaOnTheSearchList = page.locator("(//label[@class='results-title'])[1]");

    }

    /**
     * Search kost by test
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
     * @param kostName
     */

    public void searchKostFromHomePage(String kostName) {
        searchKost.click();
        searchBoxInput.fill(kostName);
        searchBoxInput.press("Enter");
        suggetionKostOnTheSearchList.click();
    }

    /**
     * search area by name
     * @param search
     */

    public void searchAreaByName(String search) {
        searchKost.click();
        searchBoxInput.fill(search);
        suggestionAreaOnTheSearchList.click();
    }
}
