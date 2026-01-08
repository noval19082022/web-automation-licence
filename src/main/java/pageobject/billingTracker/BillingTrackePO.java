package pageobject.billingTracker;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class BillingTrackePO {
    private Page page;
    private final PlaywrightHelpers playwright;

    Locator searchTypeButton;
    Locator searchTypeText;
    Locator searchInputField;
    Locator searchButton;
    Locator resultDataTable;
    Locator resetButton;
    Locator filterButton;
    Locator filterBseButton;
    Locator applyButton;
    Locator iconActionButton;
    Locator createNotesButton;
    Locator createNotesButtonOnAction;
    Locator typeNotesButton;
    Locator selectTypeNoted;
    Locator inputNotesCatatan;
    Locator lihatLebihBanyakDropdown;
    Locator adminEditNote;
    Locator tagDropdown;
    Locator saveButtonNotes;
    Locator adminChooseCalender;
    Locator sembunyikanButton;
    Locator nextPaginationButton;
    Locator propertyNameText;

    //-----billing announcement------//
    Locator announcementExpand;
    Locator tambahAnnouncementButton;
    Locator editAnnouncementButton;
    Locator inputAnnouncementTextField;

    public BillingTrackePO(Page page) {
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        searchTypeButton = page.locator("div.bg-c-dropdown__trigger > div > span");
        searchInputField = page.getByPlaceholder("Cari");
        searchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("search Cari"));
        resultDataTable = page.locator("tbody > tr:nth-child(1)").first();
        resetButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Reset"));
        filterButton = page.locator("//button[@class=\"bg-c-button bg-u-mr-md bg-c-button--tertiary bg-c-button--md\"]");
        filterBseButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih akun BSE dropdown-down"));
        applyButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Terapkan"));
        iconActionButton = page.locator("div.table-action-menu__activator").first();
        createNotesButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("add-plus Tambah Catatan")).first();
        createNotesButtonOnAction = page.locator("//p[@class=\"bg-c-text bg-c-text--body-2\"]").first();
        typeNotesButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih tag dropdown-down"));
        inputNotesCatatan = page.getByPlaceholder("Tulis catatan di sini");
        lihatLebihBanyakDropdown = page.locator(".billing-tracker-note-list__expand-toggle").last();
        adminEditNote = page.locator(".billing-tracker-note-list__item-tag").first();
        saveButtonNotes = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Simpan"));
        tagDropdown = page.locator("//div[@class='bg-c-select__trigger bg-c-select__trigger--lg']");
        adminChooseCalender = page.locator("//div[@class='vdp-datepicker bg-c-input bg-c-input--has-right-icon bg-c-input--md']");
        sembunyikanButton = page.locator("//button[contains(., 'Sembunyikan')]");
        nextPaginationButton = page.locator("//button[@class=\"bg-c-button bg-c-pagination__item bg-c-button--tertiary bg-c-button--sm bg-c-button--icon-only-sm\"][2]");
        propertyNameText = page.locator("//a[@class=\"bg-c-link bg-c-link--high\"]");

        //-----------billing announcement----------//
        announcementExpand = page.locator("//*[@class=\"bg-c-text bg-c-text--title-3\"]");
        tambahAnnouncementButton = page.getByTestId("announcementBoard").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("add-plus Tambah"));
        editAnnouncementButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ubah"));
        inputAnnouncementTextField = page.getByTestId("billingAnnoucementForm-content");
    }

    public void searchType(String type, String text) {
        playwright.clickOn(searchTypeButton);
        searchTypeText = page.locator("a").filter(new Locator.FilterOptions().setHasText(type));
        playwright.clickOn(searchTypeText);
        playwright.fill(searchInputField, text);
        playwright.clickOn(searchButton);
        playwright.waitTillNetworkIdle();
    }

    /**
     * get validation on search
     *
     * @param text
     * @return text
     */
    public boolean getValidationBillingTrackertext(String text) {
        Locator tenantName = page.getByText(text);
        return playwright.waitTillLocatorIsVisible(tenantName);
    }

    /**
     * get result data after search
     *
     * @return data list
     */
    public boolean getResutlDataTable() {
        return playwright.waitTillLocatorIsVisible(resultDataTable, 3000.0);
    }

    /**
     * click on reset button
     */
    public void clickResetButton() {
        playwright.clickOn(resetButton);
    }

    /**
     * click on filter button
     *
     * @param text example : bse name
     */
    public void clickFilterButton(String text) {
        playwright.clickOn(filterButton);
        playwright.clickOn(filterBseButton);
        Locator bseFilter = page.locator("a").filter(new Locator.FilterOptions().setHasText(text));
        playwright.clickOn(bseFilter);
        playwright.clickOn(applyButton);
        playwright.clickOn(searchButton);
    }

    /**
     * click on bulk follow up
     *
     * @param text example "Tandai sudah follow-up
     */
    public void clickBulkFollowUp(String text) {
        playwright.clickOn(iconActionButton);
        playwright.hardWait(100);
        Locator bulkFollow = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("file-booking " + text));
        playwright.clickOn(bulkFollow);
    }

    /**
     * validate bulk will visible
     *
     * @param text example: Tandai sudah follow-up
     * @return text Tandai sudah follow-up
     */
    public String getBulkText(String text) {
        playwright.clickOn(iconActionButton);
        Locator bulkText = page.locator("//p[contains(., '" + text + "')]");
        return playwright.getText(bulkText);
    }

    /**
     * validate Tambah catatan button on main page
     *
     * @return
     */
    public boolean getCreateNotesButtonVisible() {
        return playwright.waitTillLocatorIsVisible(createNotesButton, 3000.0);
    }

    /**
     * Click tambah catatan
     */
    public void clickCreateNotesAction() {
        // Wait for page to be fully loaded
        playwright.waitTillPageLoaded();
        playwright.hardWait(2000);
        
        // Wait for action button to be visible with extended timeout
        playwright.waitTillLocatorIsVisible(iconActionButton, 20000.0);
        playwright.clickOn(iconActionButton);
        
        // Wait for dropdown menu to appear
        playwright.hardWait(1000);
        playwright.waitTillLocatorIsVisible(createNotesButtonOnAction, 10000.0);
        playwright.clickOn(createNotesButtonOnAction);
    }

    /**
     * set notes type on popup
     *
     * @param type example : Pindah tipe kamar
     */
    public void setAndInputNotesType(String type) {
        playwright.clickOn(typeNotesButton);
        selectTypeNoted = page.locator("a").filter(new Locator.FilterOptions().setHasText(type));
        playwright.clickOn(selectTypeNoted);
    }

    /**
     * fill catatan on notes popup
     *
     * @param notes
     */
    public void fillNotesCatatan(String notes) {
        inputNotesCatatan.fill(notes);
    }

    /**
     * Click save button on noted popup
     */
    public void clickSaveButton() {
        playwright.clickOn(saveButtonNotes);
    }

    /**
     * validate noted type on main page
     * @param  type
     * @return text
     */
    public boolean getResutlDataTableType(String type){
        Locator getResutlDataTable = page.locator("(//tr[1]//div[normalize-space()='" + type + "'])");
        return playwright.waitTillLocatorIsVisible(getResutlDataTable, 3000.0);
    }
    /**
     * validate noted on main page
     * @param notes
     * @return text
     */
    public boolean getResultDataTableNote(String notes){
        Locator getResultDataTableNoteText = page.locator("//p[contains(.,'"+notes+"')]");
        return playwright.waitTillLocatorIsVisible(getResultDataTableNoteText,3000.0);
    }

    /**
     * validate for jatuh tempo
     *
     * @param jatuhTempo
     * @return text
     */
    public boolean getResutlDataTableReccuring(String jatuhTempo, String namaBiaya) {
        Locator getResutlDataTableReccuring = page.locator("(//td[normalize-space()='" + jatuhTempo + "'])");
        return playwright.waitTillLocatorIsVisible(getResutlDataTableReccuring, 3000.0);
    }

    /**
     * click on text
     */
    public void clickOnLihatLebihBanyakDropdown() {
        // Wait for page to load and dropdown to be visible
        playwright.waitTillPageLoaded();
        playwright.hardWait(2000);
        
        // Wait for dropdown with extended timeout
        playwright.waitTillLocatorIsVisible(lihatLebihBanyakDropdown, 20000.0);
        playwright.clickOn(lihatLebihBanyakDropdown);
    }

    /**
     * Admin edit note
     */
    public void adminEditNote(String text) {
        // Wait for page to be ready
        playwright.waitTillPageLoaded();
        playwright.hardWait(2000);
        
        // Wait for note to be visible with extended timeout
        playwright.waitTillLocatorIsVisible(adminEditNote, 20000.0);
        playwright.clickOn(adminEditNote);
        
        // Wait for tag dropdown
        playwright.waitTillLocatorIsVisible(tagDropdown, 10000.0);
        playwright.clickOn(tagDropdown);
        
        Locator textButton = page.locator("a").filter(new Locator.FilterOptions().setHasText(text));
        playwright.waitTillLocatorIsVisible(textButton, 10000.0);
        playwright.clickOn(textButton);
        playwright.clickOn(saveButtonNotes);
    }
    /**
     * Admin choose date
     */
    public void adminChooseMonth(String month) {
        playwright.clickOn(adminChooseCalender);
        String monthButton = "//span[normalize-space()='"+month+"']";
        playwright.clickOn(page.locator(monthButton));
    }

    /**
     * click on announcement title
     */
    public void clickAnnouncementTitle(){
        playwright.clickOn(announcementExpand);
    }

    /**
     * click on BSE name
     * @param bseName
     */
    public void clickBseName(String bseName){
        Locator bseNameText = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(""+bseName+""));
        playwright.clickOn(bseNameText);
    }

    /**
     * Click on Tambah announcement button
     * Note: This button only appears when no announcement exists for the selected BSE
     */
    public void clickTambahAnnouncement(){
        playwright.clickOn(tambahAnnouncementButton);
    }

    /**
     * Click on Ubah announcement
     */
    public void clickEditAnnouncement(){
        playwright.clickOn(editAnnouncementButton);
    }

    /**
     * input announcement on modals
     */
    public void inputAnnouncement(String text){
        playwright.forceFill(inputAnnouncementTextField, text);
    }

    /**
     * get toast after submit button
     * @param text
     * @return text
     */
    public String getSuccessToast(String text) {
        Locator getToastText = page.getByText(""+text+"");
        return playwright.getText(getToastText);
    }

    /**
     * get blank annnouncement
     * @param text
     * @return Belum ada announcement untuk akun BSE ini
     */
    public String getBlankAnnouncement(String text){
        Locator getBlanktext = page.locator("#announcement-2").getByText(""+text+"");
        return playwright.getText(getBlanktext);
    }

    /**
     * Assert bse name on billing announcement
     * return Bella, Okta, maya, Dida, Shintia
     */
    public boolean getBseNametext(String text){
        Locator bseNametext = page.locator("//h4[contains(., '"+text+"')]");
       return playwright.waitTillLocatorIsVisible(bseNametext,2000.0);
    }

    /**
     * click filter button and filter contract status
     * @param text example : Sudah Check-out
     */
    public void chooseContractStatus(String text){
        playwright.clickOn(filterButton);
        Locator contractStatusText = page.getByTestId("billingTrackerFilterContractStatus-col-1").getByText(""+text+"");
        playwright.clickOn(contractStatusText);
        playwright.clickOn(applyButton);
        playwright.clickOn(searchButton);
        playwright.waitTillNetworkIdle();
    }

    /**
     * validate contract status on list will appears or not
     * @param text example Sudah Check-out
     * @return text Sudah Check-out
     */
    public boolean getContractStatusOnListText(String text){
        Locator contractStatusLabelText = page.locator("//div[contains(., '"+text+"')]").last();
        return playwright.waitTillLocatorIsVisible(contractStatusLabelText, 10000.0);
    }

    /**
     * validate text sembunyikan
     * @return text sembunyikan
     */
    public boolean getSembunyikantextButton(){
        return playwright.waitTillLocatorIsVisible(sembunyikanButton);
    }

    /**
     * validate phone number appears on result list
     * @param text
     * @return phonenumber example = 08100000021
     */
    public boolean getTenantPhoneNumbertext(String text){
        Locator tenantPhoneNumberText = page.locator("//a[contains(., '"+text+"')]").first();
        return playwright.waitTillLocatorIsVisible(tenantPhoneNumberText);
    }

    /**
     * click next on pagination
     */
    public void clickOnPagination(){
            playwright.clickOn(nextPaginationButton);
    }

    /**
     * click on property name
     */
    public void clickOnPropertyNametext(){
        playwright.clickOn(propertyNameText);
    }

    /**
     * verify status on filter popup
     * @param text
     * @return text example : Aktif, Ajukan Check-out
     */
    public boolean checkFilteringContractStatusText(String text) {
        Locator contractStatusText = page.locator("//p[@class=\"bg-c-text bg-c-text--body-2\"][contains(., '"+text+"')]");
        return playwright.waitTillLocatorIsVisible(contractStatusText);
    }

    /**
     * click on status pembayaran filtering
     * @param text
     */
    public void clickFilterPaidStatus(String text){
        Locator paidStatusText = page.locator("//p[contains(., '"+text+"')]");
        playwright.clickOn(paidStatusText);
    }

}

