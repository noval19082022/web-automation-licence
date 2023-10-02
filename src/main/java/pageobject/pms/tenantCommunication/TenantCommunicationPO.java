package pageobject.pms.tenantCommunication;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

import java.util.List;

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
    Locator stateActionButton;
    Locator stateActionButtonText;
    Locator actionButton;
    Locator displayDataRow;
    Locator columName;
    Locator buttonTambahCatatan;
    Locator fieldNote;
    Locator simpanNoteButton;
    Locator prioritasText;
    Locator fieldNoteStatusWA;
    Locator buttonTambahStatusWA;
    Locator getStatusWA;
    Locator trackChatWAButton;

    public TenantCommunicationPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        mainPageFilterMenu = page.locator("//button[@class='bg-c-button bg-c-button--tertiary bg-c-button--lg']");
        mainPageSearchField = page.locator("//*[@class='bg-c-input__field']");
        mainPageSearchButton = page.locator("//button[.='Cari']");
        textProfilePenyewa = page.getByText("Profil Penyewa");
        textNamaPenyewa = page.locator(".tenant-profile__title");
        textRiwayatPencarian = page.getByText("Riwayat Pencarian Kos");
        paginationMenuDetailTenant = page.locator(".bg-c-pagination");
        secondPagination = page.locator("button:nth-of-type(3) > span");
        penyewaFilterButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Filter"));
        pilihFaseTahapanFilter = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih Fase"));
        pilihStatusTahapanFilter = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih Status"));
        terapkanButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Terapkan"));
        resetButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Reset"));
        emptyPageTenantTrackerText = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Data Tidak Ditemukan"));
        actionButton = page.locator("//*[@data-testid=\"row-action-icon\"]").first();
        displayDataRow = page.locator(".secondary-bar__result-text");
        buttonTambahCatatan = page.locator("//a[contains(.,'+ Tambah Catatan')]").first();
        fieldNote = page.getByPlaceholder("Tulis di sini...");
        simpanNoteButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Simpan"));
        prioritasText = page.locator("//a[contains(.,'prioritaskan')]").first();
        fieldNoteStatusWA = page.getByPlaceholder("Tulis catatan di sini");
        buttonTambahStatusWA = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tambah"));
        getStatusWA = page.locator("tbody > tr:nth-of-type(1) .table-body__label");
        trackChatWAButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("add-plusTrack Status Chat WA"));
    }

    /**
     * click Main Page filter
     * Select Main Page filter
     */
    public void selectMainPageFilter(String mainPageFilter) {
        if(playwright.waitTillLocatorIsVisible(mainPageFilterMenu,4.0)) {
            searchFieldMainPage = page.locator("//li/a[contains(., '" + mainPageFilter + "')]");
            playwright.reloadPage();
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
        playwright.waitFor(mainPageSearchButton,3000.0);
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
      //  paginationNumberButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(paginationNumber));
        paginationNumberButton = page.locator("//button[.='"+paginationNumber+"']");
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
        page.reload();
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
    public Boolean isPropertyNameOnMainPageFilter(String propertyName) {
        tenantNameOnTheFirstRow = page.locator("//*[contains(.,'" + propertyName + "')]").first();
        if (playwright.waitTillLocatorIsVisible(tenantNameOnTheFirstRow)) {
            return playwright.waitTillLocatorIsVisible(tenantNameOnTheFirstRow);
        } else {
            return playwright.waitTillLocatorIsVisible(mainPageSearchButton);
        }
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

    /**
     * Set to Tandai belum follow-up
     * click Action Button Tandai Sudah FollowUp
     */
    public void setStateActionTenantCommunication(String state) {
        stateActionButton = page.getByText(state);
        if (playwright.waitTillLocatorIsVisible(stateActionButton, 3.0)) {
            playwright.clickOn(stateActionButton);
        }
    }

    /**
     * get Text state action
     */
    public String getStateActionTextButton(String stateText) {
        stateActionButtonText = page.getByText(stateText).first();
        return playwright.getText(stateActionButtonText);
    }

    /**
     * Click action button in tenant communication
     */
    public void clickActionButton() {
        actionButton.waitFor();
        playwright.clickOn(actionButton);
    }

    /**
     * get Tenant Name on Main Page Filter
     */
    public String getTenantNameOnMainPageFilter(String tenantName) {
        tenantNameOnTheFirstRow = page.locator("//*[@class='bg-c-link bg-c-link--high'][contains(., '"+tenantName+"')]").first();
        return playwright.getText(tenantNameOnTheFirstRow);
    }

    /**
     * Verify display data row
     * @return true if actions column is visible
     */
    public boolean verifyDisplayDataRow(){
        return playwright.waitTillLocatorIsVisible(displayDataRow);
    }

    /**
     * Get Text of Head Table Segment by index
     * @param index - index head table
     * @return text of Head Table
     */
    public String getColumnName (int index){
        columName = page.locator("//thead//tr//th//div//p");
        List<Locator> elements = playwright.getLocators(columName);
        return playwright.getText(elements.get(index));
    }

    /**
     * click Tambah Catatan
     */
    public void clickOnTambahCatatan() {
        playwright.clickOn(buttonTambahCatatan);
    }

    /**
     * Enter Text in search bar note
     * @param keyword is text we want to search
     */
    public void enterTextNote(String keyword) {
        fieldNote.fill(keyword);
    }

    /**
     * Click Simpan Note
     */
    public void clickSimpanNote() {
        playwright.clickOn(simpanNoteButton);
    }

    /**
     * get Text "Filter Result Note"
     */
    public String getFilterResultNote() {
        return playwright.getText(prioritasText);
    }

    /**
     * get Text status "Whatsapp"
     */
    public String getTextStatusWA() {
        return playwright.getText(getStatusWA);
    }

    /**
     * Click Prioritaskan Note
     */
    public void clickPrioritaskan() {
        playwright.clickOn(prioritasText);
    }

    /**
     * clear Note
     */
    public void clearNoteField() {
        fieldNote.clear();
    }

    /**
     * check Note is clear
     */
    public Boolean isFieldNoteClear() {
        return playwright.waitTillLocatorIsVisible(prioritasText);
    }

    /**
     * Enter Text in tambah tracker status WA
     * @param keyword is text we want to search
     */
    public void enterTextNoteStatusWA(String keyword) {
        fieldNoteStatusWA.fill(keyword);
    }

    /**
     * click Tambah on tracker status WA
     */
    public void clickTambahStatusWA() {
        playwright.clickOn(buttonTambahStatusWA);
    }

    /**
     * Click on Track Status Chat WA
     */
    public void clickTrackStatusWAButton() {
        playwright.clickOn(trackChatWAButton);
    }

}
