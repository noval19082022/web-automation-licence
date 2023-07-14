package pageobject.pms.tenantCommunication;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class TenantCommunicationPO {
    private Page page;
    private PlaywrightHelpers playwright;
    Locator mainPageFilterMenu;
    Locator searchFieldMainPage;
    Locator mainPageSearchField;
    Locator mainPageSearchButton;
    Locator tenantNameOnTheFirstRow;
    Locator textProfilePenyewa;
    Locator textNamaPenyewa;
    Locator textRiwayatPencarian;
    Locator paginationMenuDetailTenant;
    Locator secondPagination;
    Locator paginationNumberButton;
    Locator penyewaFilterButton;
    Locator pilihFaseTahapanFilter;
    Locator pilihStatusTahapanFilter;
    Locator pilihFaseTahapanValue;
    Locator pilihStatusTahapanValue;
    Locator terapkanButton;
    Locator resetButton;
    Locator emptyPageTenantTrackerText;

    public TenantCommunicationPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        mainPageFilterMenu = page.locator(".action-bar__search-type");
        mainPageSearchField = page.getByTestId("search-field");
        mainPageSearchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cari"));
        textProfilePenyewa = page.getByText("Profil Penyewa");
        textNamaPenyewa = page.locator(".tenant-profile__title");
        textRiwayatPencarian = page.getByText("Riwayat Pencarian Kos");
        paginationMenuDetailTenant = page.getByTestId("tenat-tracker-pagination");
        secondPagination = page.locator("button:nth-of-type(3) > span");
        penyewaFilterButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Filter"));
        pilihFaseTahapanFilter = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih Fase"));
        pilihStatusTahapanFilter = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih Status"));
        terapkanButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Terapkan"));
        resetButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Reset"));
        emptyPageTenantTrackerText = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Data Tidak Ditemukan"));
    }

    /**
     * click Main Page filter
     * Select Main Page filter
     */
    public void selectMainPageFilter(String mainPageFilter) {
        if(playwright.waitTillLocatorIsVisible(mainPageFilterMenu,2.0)) {
            searchFieldMainPage = page.locator("//li/a[contains(., '" + mainPageFilter + "')]");
            playwright.clickOn(mainPageFilterMenu);
            playwright.clickOn(searchFieldMainPage);
        }
    }

    /**
     * Enter Text in search bar
     * @param keyword is text we want to search
     */
    public void inputSearchFieldMainPage(String keyword) {
        mainPageSearchField.fill(keyword);
    }

    /**
     * click Search button main page filter
     *
     */
    public void clickSearchButtonMainPageFilter() {
        playwright.clickOn(mainPageSearchButton);
    }

    /**
     * click Tenant Name on the First Row
     */
    public void clickTenantNameOnTheFirstRow() {
        tenantNameOnTheFirstRow = page.locator("//a[contains(.,'Adisinggahsini')]").first();
        playwright.clickOn(tenantNameOnTheFirstRow);
    }

    /**
     * get Text "TextProfilPenyewa"
     */
    public String getTextProfilPenyewa() {
        return playwright.getText(textProfilePenyewa);
    }

    /**
     * get Text Nama Penyewa
     */
    public String getRenterName() {
        return playwright.getText(textNamaPenyewa);
    }

    /**
     * get Text "RiwayatPencarianKos"
     */
    public String getTextRiwayatPencarianKos() {
        return playwright.getText(textRiwayatPencarian);
    }

    /**
     * Verify pagination menu is visible
     * @return true if actions column is visible
     */
    public boolean verifyPaginationMenuOnDetailTenant() {
        paginationMenuDetailTenant.scrollIntoViewIfNeeded();
        return playwright.waitTillLocatorIsVisible(paginationMenuDetailTenant);
    }

    /**
     * Select Pagination Number
     */
    public void clickPaginationNumber(String paginationNumber) {
        paginationNumberButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(paginationNumber));
        playwright.clickOn(paginationNumberButton);
    }

    /**
     * Verify 2nd Pagination
     * @return true if actions column is visible
     */
    public boolean verifySecondPagination(){
        return playwright.waitTillLocatorIsVisible(secondPagination);
    }

    /**
     * click Filter Penyewa
     */
    public void clickFilterPenyewa() {
        playwright.clickOn(penyewaFilterButton);
    }

    /**
     * Select Filter Tahapan
     */
    public void selectFilterTahapan(String filterTahapan) {
        playwright.clickOn(pilihFaseTahapanFilter);
        pilihFaseTahapanValue = page.locator("//li/a[contains(., '" + filterTahapan + "')]");
        playwright.clickOn(pilihFaseTahapanValue);
    }

    /**
     * Select Filter Status
     */
    public void selectFilterStatus(String filterStatus) {
        playwright.clickOn(pilihStatusTahapanFilter);
        pilihStatusTahapanValue = page.locator("//li/a[contains(., '" + filterStatus + "')]");
        playwright.clickOn(pilihStatusTahapanValue);
    }

    /**
     * click Terapkan
     */
    public void  clickOnTerapkanButton() {
        playwright.clickOn(terapkanButton);
    }

    /**
     * click Reset
     */
    public void clickOnReset() {
        playwright.clickOn(resetButton);
    }

    /**
     * get icon Reset is disabled
     */
    public boolean isIconResetIsDisabled() {
        return resetButton.isDisabled();
    }

    /**
     * Get Property Name on Main Page Filter
     * @return true or false property name
     */
    public Boolean isPropertyNameOnMainPageFilter(String propertyName){
        tenantNameOnTheFirstRow = page.locator("//a[contains(.,'"+propertyName+"')]").first();
        return playwright.waitTillLocatorIsVisible(tenantNameOnTheFirstRow);
    }

    /**
     * Get Property Name on Profile Page Filter
     * @return property name e.g. Mindful Peaks
     */
    public Boolean isPropertyNameOnProfilePageFilter(String propertyName){
        tenantNameOnTheFirstRow = page.locator("//td[contains(.,'"+propertyName+"')]").first();
        return playwright.waitTillLocatorIsVisible(tenantNameOnTheFirstRow);
    }

    /**
     * get Text Empty Page
     */
    public String getEmptyPageTenatTrackerText() {
        return playwright.getText(emptyPageTenantTrackerText);
    }

}
