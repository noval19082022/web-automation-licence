package pageobject.pms.otherTransaction;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class listOwnerExpenditurePO {
    private Page page;

    Locator expandButton;
    Locator detailSection;
    Locator lihatLampiranLink;
    Locator filterButton;

    //Filter Pop Up
    Locator konfirmasiManagerDropdown;
    Locator konfirmasiFinanceDropdown;
    Locator kategoriBiayaDropdown;
    Locator tujuanTransferDropdown;
    Locator statusKonfirmasiManager;
    Locator statusKonfirmasiFinance;
    Locator kategoriBiaya;
    Locator searchFilterTujuanTransfer;
    Locator tujuanTransfer;
    //Filter Pop Up


    public listOwnerExpenditurePO(Page page){
        this.page = page;

        expandButton = page.getByTestId("expand-toggle");
        detailSection = page.locator("tr.sub-item.is-open");
        lihatLampiranLink = page.locator("td>a");
        filterButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("filter Filter"));
        konfirmasiManagerDropdown = page.getByTestId("search-checkbox").nth(0);
        konfirmasiFinanceDropdown = page.getByTestId("search-checkbox").nth(1);
        kategoriBiayaDropdown = page.getByTestId("search-checkbox").nth(2);
        tujuanTransferDropdown = page.getByTestId("search-checkbox").nth(3);
        searchFilterTujuanTransfer = page.getByTestId("search-checkbox-searchbar");
        tujuanTransfer = page.locator(".checkbox-list").nth(3).getByRole(AriaRole.PARAGRAPH).nth(0);
    }

    /**
     * expand first data in owner expenditure list
     */
    public void expandFirstList() {
        expandButton.first().click();
    }

    /**
     * assert first data detail section is expand in owner expenditure list
     */
    public void assertFirstListDetailVisible() {
        assertThat(detailSection.first()).isVisible();
    }

    /**
     * click lihat lampiran at first data in owner expenditure list
     * @return list owner expenditure page
     */
    public listOwnerExpenditurePO clickFirstLihatLampiran() {
        page = page.waitForPopup(() -> {
            lihatLampiranLink.first().click();
        });
        return new listOwnerExpenditurePO(page);
    }

    /**
     * assert lampiran image is open in new tab
     */
    public void assertNewTabOpen() {
        assertThat(page).hasTitle("books-kFqUBptWHhXu.jpeg (800×566)");
    }

    /**
     * click to open Filter
     */
    public void clickFilter() {
        filterButton.click();
    }

    /**
     * Click to expand Status Konfirmasi Manager in Filter pop up
     */
    public void expandStatusKonfirmasiManagerFilter() {
        konfirmasiManagerDropdown.click();
    }

    /**
     * Click to expand Status Konfirmasi Finance in Filter pop up
     */
    public void expandStatusKonfirmasiFinanceFilter() {
        konfirmasiFinanceDropdown.click();
    }

    /**
     * Click to expand Kategori Biaya in Filter pop up
     */
    public void expandKategoriBiayaFilter() {
        kategoriBiayaDropdown.click();
    }

    /**
     * Click to expand Tujuan Transfer in Filter pop up
     */
    public void expandTujuanTransferFilter() {
        tujuanTransferDropdown.click();
    }

    /**
     * Assert Status Konfirmasi Manager Option ke-i in Filter Pop up
     * @param i index
     * @param x Status Konfirmasi Manager
     */
    public void assertStatusKonfirmasiManager(int i,String x) {
        statusKonfirmasiManager = page.locator(".checkbox-list").nth(0).getByRole(AriaRole.PARAGRAPH).nth(i);
        assertThat(statusKonfirmasiManager).hasText(x);
    }

    /**
     * Assert Status Konfirmasi Finance Option ke-i in Filter Pop up
     * @param i index
     * @param x Status Konfirmasi Finance
     */
    public void assertStatusKonfirmasiFinance(int i, String x) {
        statusKonfirmasiFinance = page.locator(".checkbox-list").nth(1).getByRole(AriaRole.PARAGRAPH).nth(i);
        assertThat(statusKonfirmasiFinance).hasText(x);
    }

    /**
     * Assert Kategori Biaya Option ke-i in Filter Pop up
     * @param i index
     * @param s Kategori Biaya
     */
    public void assertKategoriBiaya(int i, String s) {
        kategoriBiaya = page.locator(".checkbox-list").nth(2).getByRole(AriaRole.PARAGRAPH).nth(i);
        assertThat(kategoriBiaya).hasText(s);
    }

    /**
     * Search Tujuan Transfer x and assert tujuan is correct
     * @param x tujuan transfer
     */
    public void searchAndAssertTujuanTransfer(String x) {
        searchFilterTujuanTransfer.fill(x);
        assertThat(tujuanTransfer).hasText(x);
    }
}
