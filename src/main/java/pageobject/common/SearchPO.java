package pageobject.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SearchPO {
    Page page;
    Locator inputSearch;
    private Locator searchKost;
    private Locator searchBoxInput;
    private Locator suggetionKostOnTheSearchList;

    public SearchPO(Page page) {
        this.page = page;
        this.inputSearch = page.locator("input[title]");
        this.searchKost = page.getByText("Masukan nama lokasi/area/alamat");
        this.searchBoxInput = page.locator("input[type='search']");
        this.suggetionKostOnTheSearchList = page.locator("//div[@data-testid='suggestionBox-roomList']//a[1]");
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

    public void searchKostFromHomePage(String kostName) {
        searchKost.click();
        searchBoxInput.fill(kostName);
        searchBoxInput.press("Enter");
        suggetionKostOnTheSearchList.click();
    }
}
