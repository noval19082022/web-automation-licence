package pageobject.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
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
    private Locator kosLists;
    private Locator nominatimMap;
    private Locator filterResetText;
    private Locator filterResetButton;

    public KostLandingAreaPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        headingResultText = page.getByRole(AriaRole.HEADING).first();
        filterHarga = page.getByTestId("filter-price").getByText("Harga");
        filterInputMinimalPrice = page.getByRole(AriaRole.TEXTBOX).first();
        filterInputMaximumPrice = page.getByRole(AriaRole.TEXTBOX).nth(1);
        filterPriceSimpanButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Simpan"));
        kosLists = page.locator(".nominatim-rooms-grid");
        nominatimMap = page.getByText("map Cari berdasarkan Peta Leaflet | © OpenStreetMap, Mamikos");
        filterResetText = page.getByText("Coba kurangi atau hapus filter untuk hasil pencarian yang lebih banyak.");
        filterResetButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Reset filter"));
    }

    public String getResultHeadingText() {
        return playwright.getText(headingResultText);
    }

    public void filterByHarga(int minimal, int maximal) {
        playwright.clickOn(filterHarga);
        filterInputMinimalPrice.fill(String.valueOf(minimal));
        filterInputMaximumPrice.fill(String.valueOf(maximal));
        playwright.clickOn(filterPriceSimpanButton);
    }

    public List<Locator> getKostListLocator() {
        return kosLists.all();
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

    public void clickOnResetFilterButton() {
        playwright.clickOn(filterResetButton);
    }
}
