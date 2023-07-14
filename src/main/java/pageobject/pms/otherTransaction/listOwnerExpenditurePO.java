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
    Locator firstInvoiceNumber;
    Locator resetFilterButton;
    Locator counterFilter;
    Locator tipePengajuanCashoutFirstData;
    Locator propertyNameFirstData;
    Locator totalPengeluaranFirstData;
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
    Locator menungguKonfirmasiManagerCheckbox;
    Locator menungguKonfirmasiFinanceCheckbox;
    Locator dikonfirmasiManagerCheckbox;
    Locator dikonfirmasiFinanceCheckbox;
    Locator ditolakManagerCheckbox;
    Locator ditolakFinanceCheckbox;
    Locator terapkanButton;
    Locator kategoriBiayaCheckbox;
    Locator resetFilterPopUp;
    Locator closePopUpButton;
    //Filter Pop Up

    String urlLampiran;

    public listOwnerExpenditurePO(Page page){
        this.page = page;

        expandButton = page.getByTestId("expand-toggle");
        detailSection = page.locator("tr.sub-item.is-open");
        lihatLampiranLink = page.locator("td>a");
        filterButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Filter"));
        konfirmasiManagerDropdown = page.locator(".search-checkbox__dropdown").nth(0);
        konfirmasiFinanceDropdown = page.locator(".search-checkbox__dropdown").nth(1);
        kategoriBiayaDropdown = page.locator(".search-checkbox__dropdown").nth(2);
        tujuanTransferDropdown = page.locator(".search-checkbox__dropdown").nth(3);
        searchFilterTujuanTransfer = page.getByTestId("filter-modal").getByPlaceholder("Cari");
        tujuanTransfer = page.getByTestId("search-checkbox-dropdown").nth(3).locator(".search-checkbox__checkbox").getByRole(AriaRole.PARAGRAPH);
        menungguKonfirmasiManagerCheckbox = page.locator("label[for='search-checkbox-managerConfirmationStatus-0']");
        menungguKonfirmasiFinanceCheckbox = page.locator("label[for='search-checkbox-financeConfirmationStatus-0']");
        dikonfirmasiManagerCheckbox = page.locator("label[for='search-checkbox-managerConfirmationStatus-1']");
        dikonfirmasiFinanceCheckbox = page.locator("label[for='search-checkbox-financeConfirmationStatus-1']");
        ditolakManagerCheckbox = page.locator("label[for='search-checkbox-managerConfirmationStatus-2']");
        ditolakFinanceCheckbox = page.locator("label[for='search-checkbox-financeConfirmationStatus-2']");
        terapkanButton = page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText("Terapkan"));
        emptyTable = page.locator(".not-found");
        rowData = page.locator("tbody.one-row");
        resetFilterPopUp = page.getByTestId("filter-modal").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Reset"));
        closePopUpButton = page.locator(".bg-c-modal__action-closable");
        resetFilterButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Reset")).first();
        counterFilter = page.locator(".bg-c-badge-counter--black");
        tipePengajuanCashoutFirstData = page.locator("(//*[@class='main-item'])[1]/td").nth(2);
        propertyNameFirstData = page.locator("(//*[@class='main-item'])[1]/td").nth(3);
        totalPengeluaranFirstData = page.locator("((//*[@class='main-item'])[1]/td)[6]/p");
        firstInvoiceNumber = page.locator(".bg-is-col-3 p").nth(7);
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
        statusKonfirmasiManager = page.getByTestId("search-checkbox-dropdown").nth(0).locator(".search-checkbox__checkbox").getByRole(AriaRole.PARAGRAPH).nth(i);
        assertThat(statusKonfirmasiManager).hasText(x);
    }

    /**
     * Assert Status Konfirmasi Finance Option ke-i in Filter Pop up
     * @param i index
     * @param x Status Konfirmasi Finance
     */
    public void assertStatusKonfirmasiFinance(int i, String x) {
        statusKonfirmasiFinance = page.getByTestId("search-checkbox-dropdown").nth(1).locator(".search-checkbox__checkbox").getByRole(AriaRole.PARAGRAPH).nth(i);
        assertThat(statusKonfirmasiFinance).hasText(x);
    }

    /**
     * Assert Kategori Biaya Option ke-i in Filter Pop up
     * @param i index
     * @param s Kategori Biaya
     */
    public void assertKategoriBiaya(int i, String s) {
        kategoriBiaya = page.getByTestId("search-checkbox-dropdown").nth(2).locator(".search-checkbox__checkbox").getByRole(AriaRole.PARAGRAPH).nth(i);
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
            menungguKonfirmasiManagerCheckbox.click();
        } else if (status.equalsIgnoreCase("Dikonfirmasi")) {
            dikonfirmasiManagerCheckbox.click();
        } else if (status.equalsIgnoreCase("Ditolak")) {
            ditolakManagerCheckbox.click();
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
            menungguKonfirmasiFinanceCheckbox.click();
        } else if (status.equalsIgnoreCase("Dikonfirmasi")) {
            dikonfirmasiFinanceCheckbox.click();
        } else if (status.equalsIgnoreCase("Ditolak")) {
            ditolakFinanceCheckbox.click();
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
        kategoriBiayaCheckbox = page.locator(".search-checkbox__checkbox").getByText(kategori);
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
                expandButton.nth(i).scrollIntoViewIfNeeded();
                expandButton.nth(i).click();
                kategoriData = page.locator(".detail-table tbody").nth(i);
                kategoriData.scrollIntoViewIfNeeded();
                assertThat(kategoriData).containsText(kategori);
                expandButton.nth(i).click();
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

            expandButton.nth(i).scrollIntoViewIfNeeded();
            expandButton.nth(i).click();
            vendorAccName.scrollIntoViewIfNeeded();
            assertThat(vendorName).hasText(vendor);
            assertThat(vendorBank).hasText(bank);
            assertThat(vendorAccNumber).hasText(accNumber);
            assertThat(vendorAccName).hasText(accName);
            expandButton.nth(i).click();
        }
    }

    /**
     * click reset button in filter modal
     */
    public void clickResetPopUp() {
        resetFilterPopUp.click();
    }

    /**
     * close filter owner expenditure modal
     */
    public void closeFilter() {
        closePopUpButton.click();
    }

    /**
     * Assert counter in Status Konfirmasi Manager hidden
     */
    public void assertCounterStatusKonfirmasiManagerNotVisible() {
        assertThat(counterFilter.nth(1)).isHidden();
    }

    /**
     * Assert counter in Status Konfirmasi Finance hidden
     */
    public void assertCounterStatusKonfirmasiFinanceNotVisible() {
        assertThat(counterFilter.nth(2)).isHidden();
    }

    /**
     * Assert counter in kategori biaya hidden
     */
    public void assertCounterKategoriBiayaNotVisible() {
        assertThat(counterFilter.nth(3)).isHidden();
    }

    /**
     * Assert counter filter hidden
     */
    public void assertCounterFilterHidden() {
        assertThat(counterFilter.first()).isHidden();
    }

    /**
     * Assert counter filter visible
     */
    public void assertCounterFilterVisible() {
        assertThat(counterFilter.first()).isVisible();
    }

    /**
     * click Reset button in owner expenditure
     */
    public void clickResetButton() {
        resetFilterButton.click();
    }

    /**
     * assert Tipe Pengajuan Cashout in first data list owner expenditure
     * @param tipe
     */
    public void assertTipePengajuanCashoutFirstData(String tipe) {
        assertThat(tipePengajuanCashoutFirstData).hasText(tipe);
    }

    /**
     * assert property name in first data list owner expenditure
     * @param prop property name
     */
    public void assertPropertynameFirstData(String prop) {
        assertThat(propertyNameFirstData).hasText(prop);
    }

    /**
     * assert total pengeluaran in first data list owner expenditure
     * @param total
     */
    public void assertTotalPengeluaranFirstData(String total) {
        assertThat(totalPengeluaranFirstData).hasText(total);
    }

    /**
     * assert pengeluaran in first data list owner expenditure
     * @param pengeluaran
     */
    public void assertFirstDataContainsPengeluaran(String pengeluaran) {
        expandButton.first().click();
        kategoriData = page.locator(".detail-table tbody").first();
        kategoriData.scrollIntoViewIfNeeded();
        assertThat(kategoriData).containsText(pengeluaran);
        expandButton.first().click();
    }

    /**
     * Assert first no invoice biaya
     * @param invoice
     */
    public void assertFirstNoInvoice(String invoice) {
        assertThat(firstInvoiceNumber).hasText(invoice);
    }

    /**
     * Assert first data vendor
     * @param vendor vendor name
     * @param owner vendor owner name
     * @param acc vendor bank account number
     * @param bank vendor bank account name
     */
    public void assertFirstVendorName(String vendor, String owner, String acc, String bank) {
        vendorName = page.locator(".bg-is-col-3").nth(3).getByRole(AriaRole.PARAGRAPH).last();
        vendorBank = page.locator(".bg-is-col-3").nth(5).getByRole(AriaRole.PARAGRAPH).last();
        vendorAccNumber = page.locator(".bg-is-col-3").nth(6).getByRole(AriaRole.PARAGRAPH).last();
        vendorAccName = page.locator(".bg-is-col-3").nth(7).getByRole(AriaRole.PARAGRAPH).last();

        expandButton.first().scrollIntoViewIfNeeded();
        expandButton.first().click();
        vendorAccName.scrollIntoViewIfNeeded();
        assertThat(vendorName).hasText(vendor);
        assertThat(vendorBank).hasText(bank);
        assertThat(vendorAccNumber).hasText(acc);
        assertThat(vendorAccName).hasText(owner);
        expandButton.first().click();
    }
}
