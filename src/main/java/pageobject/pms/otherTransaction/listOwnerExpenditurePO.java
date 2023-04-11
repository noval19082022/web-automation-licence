package pageobject.pms.otherTransaction;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class listOwnerExpenditurePO {
    private Page page;

    //table owner expenditure
    Locator expandButton;
    Locator detailSection;
    Locator lihatLampiranLink;
    Locator filterButton;
    Locator emptyTable;
    Locator rowData;
    Locator statusManagerTable;
    Locator statusFinanceTable;
    Locator kategoriData;
    Locator vendorName;
    Locator vendorBank;
    Locator vendorAccNumber;
    Locator vendorAccName;
    //table owner expenditure

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
    Locator menungguKonfirmasiCheckbox;
    Locator dikonfirmasiCheckbox;
    Locator ditolakCheckbox;
    Locator terapkanButton;
    Locator kategoriBiayaCheckbox;
    //Filter Pop Up

    String urlLampiran;

    public listOwnerExpenditurePO(Page page){
        this.page = page;

        expandButton = page.getByTestId("expand-toggle");
        detailSection = page.locator("tr.sub-item.is-open");
        lihatLampiranLink = page.locator("td>a");
        filterButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Filter"));
        konfirmasiManagerDropdown = page.getByTestId("search-checkbox").nth(0);
        konfirmasiFinanceDropdown = page.getByTestId("search-checkbox").nth(1);
        kategoriBiayaDropdown = page.getByTestId("search-checkbox").nth(2);
        tujuanTransferDropdown = page.getByTestId("search-checkbox").nth(3);
        searchFilterTujuanTransfer = page.getByTestId("search-checkbox-searchbar");
        tujuanTransfer = page.locator(".checkbox-list").nth(3).getByRole(AriaRole.PARAGRAPH).nth(0);
        menungguKonfirmasiCheckbox = page.getByTestId("search-checkbox-unconfirmed-0");
        dikonfirmasiCheckbox = page.getByTestId("search-checkbox-confirmed-1");
        ditolakCheckbox = page.getByTestId("search-checkbox-rejected-2");
        terapkanButton = page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText("Terapkan"));
        emptyTable = page.locator(".not-found");
        rowData = page.locator("tbody.one-row");
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
            urlLampiran = lihatLampiranLink.first().getAttribute("href");
        });
        return new listOwnerExpenditurePO(page);
    }

    /**
     * assert lampiran image is open in new tab
     */
    public void assertNewTabOpen() {
        assertThat(page).hasURL(urlLampiran);
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

    /**
     * select one of status konfirmasi manager in filter
     * @param status (Menunggu Konfirmasi,Dikonfirmasi,Ditolak)
     */
    public void selectStatusKonfirmasiManager(String status) {
        konfirmasiManagerDropdown.click();
        if (status.equalsIgnoreCase("Menunggu Konfirmasi")){
            menungguKonfirmasiCheckbox.first().click();
        } else if (status.equalsIgnoreCase("Dikonfirmasi")) {
            dikonfirmasiCheckbox.first().click();
        } else if (status.equalsIgnoreCase("Ditolak")) {
            ditolakCheckbox.first().click();
        }
    }

    /**
     * click terapkan in filter owner expenditure
     */
    public void applyFilter() {
        terapkanButton.click();
    }

    /**
     * Assert status konfirmasi manager in list owner expenditure
     * @param status
     */
    public void assertStatusKonfirmasiManagerData(String status) {
        if (emptyTable.isVisible()){
            System.out.println("There is no data");
        } else {
            int r = rowData.count();
            for (int i=0;i<r;i++){
                statusManagerTable = page.locator("div.bg-c-label").nth((2*i));
                assertThat(statusManagerTable).hasText(status);
            }
        }
    }

    /**
     * select one of status konfirmasi finance in filter
     * @param status (Menunggu Konfirmasi,Dikonfirmasi,Ditolak)
     */
    public void selectStatusKonfirmasiFinance(String status) {
        konfirmasiFinanceDropdown.click();
        if (status.equalsIgnoreCase("Menunggu Konfirmasi")){
            menungguKonfirmasiCheckbox.nth(1).click();
        } else if (status.equalsIgnoreCase("Dikonfirmasi")) {
            dikonfirmasiCheckbox.nth(1).click();
        } else if (status.equalsIgnoreCase("Ditolak")) {
            ditolakCheckbox.nth(1).click();
        }
    }

    /**
     * Assert status konfirmasi finance in list owner expenditure
     * @param status
     */
    public void assertStatusKonfirmasiFinanceData(String status) {
        if (emptyTable.isVisible()){
            System.out.println("There is no data");
        } else {
            int r = rowData.count();
            for (int i = 0; i < r; i++) {
                statusFinanceTable = page.locator("div.bg-c-label").nth(1+(2*i));
                assertThat(statusFinanceTable).hasText(status);
            }
        }
    }

    /**
     * select filter kategori biaya
     * @param kategori
     */
    public void selectKategoriBiaya(String kategori) {
        kategoriBiayaDropdown.click();
        kategoriBiayaCheckbox = page.locator(".checkbox-list").nth(2).getByText(kategori);
        kategoriBiayaCheckbox.focus();
        kategoriBiayaCheckbox.click();
    }

    /**
     * assert Biaya contains selected kategori filter
     * @param kategori filter kategori
     */
    public void assertDataContainsKategoriBiaya(String kategori) {
        if (emptyTable.isVisible()){
            System.out.println("There is no data");
        } else {
            int r = rowData.count();
            for (int i = 0; i < r; i++) {
                expandButton.nth(i).focus();
                expandButton.nth(i).click();
                kategoriData = page.locator(".detail-table tbody").nth(i);
                kategoriData.focus();
                assertThat(kategoriData).containsText(kategori);
            }
        }
    }

    /**
     * Search and choose filter tujuan transfer
     * @param vendor vendor name
     */
    public void selectTujuanTransfer(String vendor) {
        tujuanTransferDropdown.click();
        searchFilterTujuanTransfer.focus();
        searchFilterTujuanTransfer.fill(vendor);
        tujuanTransfer.click();
    }

    /**
     * Assert vendor name, bank, account name, and account number in every row
     * @param vendor vendor name
     * @param accName bank account name
     * @param accNumber bank account number
     * @param bank bank name
     */
    public void assertVendorName(String vendor,String accName, String accNumber, String bank) {
        int r = rowData.count();

        for (int i=0;i<r;i++){
            vendorName = page.locator(".bg-is-col-3").nth(3+(8*i)).getByRole(AriaRole.PARAGRAPH).last();
            vendorBank = page.locator(".bg-is-col-3").nth(5+(8*i)).getByRole(AriaRole.PARAGRAPH).last();
            vendorAccNumber = page.locator(".bg-is-col-3").nth(6+(8*i)).getByRole(AriaRole.PARAGRAPH).last();
            vendorAccName = page.locator(".bg-is-col-3").nth(7+(8*i)).getByRole(AriaRole.PARAGRAPH).last();

            expandButton.nth(i).click();
            vendorAccName.scrollIntoViewIfNeeded();
            assertThat(vendorName).hasText(vendor);
            assertThat(vendorBank).hasText(bank);
            assertThat(vendorAccNumber).hasText(accNumber);
            assertThat(vendorAccName).hasText(accName);
            expandButton.nth(i).click();
        }
    }
}
