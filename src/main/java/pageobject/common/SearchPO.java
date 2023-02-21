package pageobject.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SearchPO {
    Page page;
    Locator inputSearch;

    public SearchPO(Page page) {
        this.page = page;
        this.inputSearch = page.locator("input[title]");
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
}
