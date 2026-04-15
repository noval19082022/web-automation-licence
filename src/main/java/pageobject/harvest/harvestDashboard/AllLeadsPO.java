package pageobject.harvest.harvestDashboard;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class AllLeadsPO {

    private Page page;
    private PlaywrightHelpers playwright;

    Locator allLeadsTitlePage;
    Locator profileNameText;
    Locator logoutButton;
    Locator columnName;
    Locator leadsCurationStatus;
    Locator row;

    //--- Edit Table ---//
    Locator manageLeadsButton;
    Locator yesButton;
    Locator noButton;
    Locator submitToLBTButtonOption;
    Locator submitToLBTButton;
    Locator confirmSubmitToLBTButton;

    //--- Batalkan Edit ---//
    Locator batalkanEditButton;

    //--- Filter ---//
    Locator filterButton;
    Locator checkBoxILB;
    Locator checkBoxAO;
    Locator checkBoxScrapping;
    Locator checkBoxAreaNonP1;
    Locator checkBoxAllArea;
    Locator checkBoxNoArea;
    Locator checkBoxAreaP1;
    Locator dropdownJumlahKamar;
    Locator roomMoreThanFour;
    Locator dropdownLeadsCuration;
    Locator terapkanButton;
    Locator resetFilterButton;

    //--- Confirmation Batalkan ---//
    Locator titleConfirmationBatalkan;
    Locator subtitleConfirmationBatalkan;
    Locator closeConfirmationButton;
    Locator yaBatalkanButton;
    Locator tidakButton;

    //--- Pagination ---//
    Locator nextPageButton;

    //--- Confirmation Perubahan Belum Tersimpan ---//
    Locator titleConfirmationPerubahanBelumTersimpan;
    Locator subtitleConfirmationPerubahanBelumTersimpan;

    //-------------Search and filter all leads table -------------//
    Locator searchTypeLeads;
    Locator searchButton;
    Locator searchInput;

    public AllLeadsPO(Page page){
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        allLeadsTitlePage = page.getByText("All Leads Table");
        profileNameText = page.locator(".user-data-profile p").first();
        logoutButton = page.getByText("Logout", new Page.GetByTextOptions().setExact(true));
        columnName = page.locator("th p");
        leadsCurationStatus = page.locator("td:nth-of-type(16) p");
        row = page.locator("tr.content");

        //--- Edit Table ---//
        manageLeadsButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Manage Leads"));
        submitToLBTButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit to LBT"));
        confirmSubmitToLBTButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kirim"));

        //--- Batalkan Edit ---//
        batalkanEditButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cancel"));

        //--- Filter ---//
        filterButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("filter Filter"));
        checkBoxILB = page.getByText("ILB");
        checkBoxAO = page.getByText("Agent Offline");
        checkBoxScrapping = page.getByText("Scraping");
        checkBoxAreaNonP1 = page.getByText("Area Non P1");
        checkBoxAllArea = page.getByText("All Area");
        checkBoxNoArea = page.getByText("No Area");
        checkBoxAreaP1 = page.getByText("Area P1", new Page.GetByTextOptions().setExact(true));
        dropdownJumlahKamar = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(">4 Kamar dropdown-down"));
        dropdownLeadsCuration = page.locator(".bg-c-modal .bg-c-dropdown__trigger").first();
        roomMoreThanFour = page.locator("a").filter(new Locator.FilterOptions().setHasText(">4 Kamar"));
        terapkanButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Terapkan"));
        resetFilterButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Reset"));

        //--- Confirmation Batalkan ---//
        titleConfirmationBatalkan = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Yakin ingin batalkan?"));
        subtitleConfirmationBatalkan = page.getByText("Data yang sudah diisi tidak tersimpan dan tidak dapat dikembalikan.");
        closeConfirmationButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("close").setExact(true));
        yaBatalkanButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ya, Batalkan"));
        tidakButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tidak"));

        //--- Confirmation Perubahan Belum Tersimpan ---//
        titleConfirmationPerubahanBelumTersimpan = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Perubahan Belum Tersimpan"));
        subtitleConfirmationPerubahanBelumTersimpan = page.getByText("Terdapat perubahan yang belum disimpan. Simpan perubahan sebelum melanjutkan?");

        //-------------Search and filter all leads table -------------//
        searchTypeLeads = page.locator("div.bg-c-select.bg-c-searchbar__select-input > div > div.bg-c-dropdown__trigger");
        searchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cari").setExact(true));
        searchInput = page.locator(".bg-c-searchbar input[type=\"text\"]");

    }

    /**
     * Check if All Leads Table Page is Visible
     * True = Visible
     * False = Invisible
     * @return All Leads Table Page
     */
    public boolean isAllLeadsTableVisible() {
        return playwright.isLocatorVisibleAfterLoad(allLeadsTitlePage, 30000.0);
    }

    //--- Edit Table ---//
    /**
     * Clicks Edit Table Button
     */
    public void clicksEditTableButton() {
        playwright.waitTillPageLoaded();
        allLeadsTitlePage.waitFor(new Locator.WaitForOptions().setTimeout(30000.0));
        manageLeadsButton.waitFor(new Locator.WaitForOptions().setTimeout(30000.0));
        playwright.clickOn(manageLeadsButton);
    }

    /**
     * Get All Radio Button in Page
     * @return All Radio Button in Page
     */
    public int totalAllYesButton(){
        yesButton = page.locator("tr td:nth-of-type(1)");
        return yesButton.count();
    }

    /**
     * Check if Yes Button is Visible
     * @param indexYesButton
     * @return Yes Button
     */
    public boolean isYesButtonsVisible(int indexYesButton) {
        yesButton = page.locator("(//tr)").nth(indexYesButton).locator("(//td)[1]//child::p[contains(., 'Yes')]");
        return playwright.isLocatorVisibleAfterLoad(yesButton, 2000.0);
    }

    /**
     * Get String Yes Button in Every Row
     * @param indexYesButton
     * @return String Yes Button in Every Row
     */
    public String yesButton(int indexYesButton){
        yesButton = page.locator("(//tr)").nth(indexYesButton).locator("(//td)[1]//child::p[contains(., 'Yes')]");
        return playwright.getText(yesButton);
    }

    /**
     * Check if No Button is Visible
     * True = Visible
     * False = Invisible
     * @param indexNoButton
     * @return No Button
     */
    public boolean isNoButtonsVisible(int indexNoButton) {
        noButton = page.locator("(//tr)").nth(indexNoButton).locator("(//td)[2]//child::p[contains(., 'No')]");
        return playwright.isLocatorVisibleAfterLoad(noButton, 2000.0);
    }

    /**
     * Get String No Button in Every Row
     * @param indexNoButton
     * @return String No Button in Every Row
     */
    public String noButton(int indexNoButton){
        noButton = page.locator("(//tr)").nth(indexNoButton).locator("(//td)[2]//child::p[contains(., 'No')]");
        return playwright.getText(noButton);
    }

    /**
     * Selects on Yes Radio Button on first enabled row
     */
    public void selectsYesRadioButton() {
        yesButton = page.locator("tr.content td:nth-child(1) .bg-c-radio:not(.bg-c-radio--disabled)").first();
        yesButton.waitFor(new Locator.WaitForOptions().setTimeout(15000.0));
        playwright.clickOn(yesButton);
    }

    /**
     * Selects on No Radio Button on first enabled row
     */
    public void selectsNoRadioButton() {
        noButton = page.locator("tr.content td:nth-child(2) .bg-c-radio:not(.bg-c-radio--disabled)").first();
        noButton.waitFor(new Locator.WaitForOptions().setTimeout(15000.0));
        playwright.clickOn(noButton);
    }
    //--- End of Edit Table ---//

    //--- Batalkan Edit ---//
    /**
     * Clicks on Batalkan Edit button
     */
    public void clicksBatalkanEdit() {
        playwright.clickOn(batalkanEditButton);
    }
    //--- End of Batalkan Edit ---//

    //--- Filter ---//
    /**
     * Clicks on Filter
     */
    public void clicksFilter() {
        playwright.clickOn(filterButton);
    }

    /**
     * Clicks on Check Box ILB
     */
    public void clicksOnCheckBoxILB() {
        playwright.clickOn(checkBoxILB);
    }

    /**
     * Clicks on Check Box Agent Offline
     */
    public void clicksOnCheckBoxAgentOffline() {
        playwright.clickOn(checkBoxAO);
    }

    /**
     * Clicks on Check Box Scrapping
     */
    public void clicksOnCheckBoxScrapping() {
        playwright.clickOn(checkBoxScrapping);
    }

    /**
     * Clicks on Check Box Area Non P1
     */
    public void clicksOnCheckBoxAreaNonP1() {
        playwright.clickOn(checkBoxAreaNonP1);
    }

    /**
     * Clicks on Check Box All Area
     */
    public void clicksOnCheckBoxAllArea() {
        playwright.clickOn(checkBoxAllArea);
    }

    /**
     * Clicks on Check Box No Area
     */
    public void clicksOnCheckBoxNoArea() {
        playwright.clickOn(checkBoxNoArea);
    }

    /**
     * Clicks on Check Box Area P1
     */
    public void clickOnCheckBoxAreaP1() {
        playwright.clickOn(checkBoxAreaP1);
    }

    /**
     * Selects on >4 at Jumlah Kamar Dropdown
     */
    public void selectsRoomsMoreThanFour() {
        playwright.clickOn(dropdownJumlahKamar);
        playwright.clickOn(roomMoreThanFour);
    }

    /**
     * Clicks on Terapkan button at Filter
     */
    public void clicksTerapkan() {
        playwright.clickOn(terapkanButton);
    }

    /**
     * select kota
     * @param text
     * @param kabupaten
     */
    public void inputKota(String text, String kabupaten) {
        Locator pilihKota = page.locator("//p[text()='"+text+"']/parent::div//span[text()='Pilih']");
        playwright.clickOn(pilihKota);
        Locator inputKotaText = page.locator("//p[text()='"+text+"']/parent::div//div//ul//span//input");
        playwright.fill(inputKotaText, kabupaten);
        Locator clickKotaName = page.locator("//p[text()='"+text+"']/parent::div//div//ul//li//div[text()='"+kabupaten+"']");
        playwright.clickOn(clickKotaName);
    }

    /**
     * get name on data listing
     * @param text
     * @return
     */
    public String getKotaName(String text) {
        Locator getKotaName = page.locator("//p[@class=\"bg-c-text bg-c-text--body-4\"][contains(., '"+text+"')]").first();
        return playwright.getText(getKotaName);
    }

    /**
     * Clicks on Reset Filter button
     */
    public void clicksResetFilter() {
        playwright.clickOn(resetFilterButton);
    }

    /**
     * Clear search input field
     */
    public void clearSearchField() {
        playwright.clearText(searchInput);
    }

    /**
     * Clicks on Search button
     */
    public void clicksSearchButton() {
        playwright.clickOn(searchButton);
    }
    //--- End of Filter ---//

    //--- Confirmation Batalkan ---//
    /**
     * Get String Title of Confirmation Batalkan Pop Up
     * @return String Title of Confirmation Batalkan Pop Up
     */
    public String titleConfirmationBatalkanPopUp() {
        return playwright.getText(titleConfirmationBatalkan);
    }

    /**
     * Get String Subtitle of Confirmation Batalkan Pop Up
     * @return String Subtitle of Confirmation Batalkan Pop Up
     */
    public String subtitleConfirmationBatalkanPopUp() {
        return playwright.getText(subtitleConfirmationBatalkan);
    }

    /**
     * Clicks Close Button on Confirmation Pop Up
     */
    public void clicksCloseButton() {
        playwright.clickOn(closeConfirmationButton);
    }

    /**
     * Clicks on Ya, Batalkan Button
     */
    public void clicksYaBatalkanButton() {
        playwright.clickOn(yaBatalkanButton);
    }

    /**
     * Clicks on Tidak Button
     */
    public void clicksTidakButton() {
        playwright.clickOn(tidakButton);
    }

    /**
     * Check if Confirmation Batalkan Pop Up is Visible
     * True = Visible
     * False = Invisble
     * @return Confirmation Batalkan Pop Up
     */
    public boolean isConfirmationBatalkanPopUpVisible() {
        return playwright.isLocatorVisibleAfterLoad(titleConfirmationBatalkan, 5000.0);
    }
    //--- End of Confirmation Batalkan ---//

    //--- Pagination ---//
    /**
     * Clicks on Pagination
     * @param nextPage
     */
    public void clicksOnPage(String nextPage) {
        nextPageButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(nextPage).setExact(true));
        playwright.clickOn(nextPageButton);
    }
    //--- End of Pagination ---//

    //--- Confirmation Perubahan Belum Tersimpan ---//
    /**
     * Get String Title of Confirmation Perubahan Belum Tersimpan Pop Up
     * @return String Title of Confirmation Perubahan Belum Tersimpan Pop Up
     */
    public String titleConfirmationPerubahanBelumTersimpanPopUp() {
        return playwright.getText(titleConfirmationPerubahanBelumTersimpan);
    }

    /**
     * Get String Subtitle of Confirmation Perubahan Belum Tersimpan Pop Up
     * @return String Subtitle of Confirmation Perubahan Belum Tersimpan Pop Up
     */
    public String subtitleConfirmationPerubahanBelumTersimpanPopUp() {
        String full = playwright.getText(subtitleConfirmationPerubahanBelumTersimpan);
        String[] resultSplit = full.split("\\n");
        String result = resultSplit[0].concat(" "+resultSplit[1].trim());
        System.out.println(result);
        return result;
    }

    /**
     * Get profile name
     * @return String
     */
    public String getProfileName() {
        return playwright.getText(profileNameText);
    }

    /**
     * Logout harvest
     */
    public void logoutHarvest() {
        playwright.clickOn(logoutButton);
    }

    /**
     * Get Column Name
     * @return String
     */
    public String getColumnName(int i) {
        return playwright.getText(columnName.nth(i));
    }
    //--- End of Confirmation Perubahan Belum Tersimpan ---//


    //-------------Search and filter all leads table -------------//

    /**
     * Search type leads and input text
     * @param typeLeads
     * @param text
     */
    public void searchTypeLeads(String typeLeads, String text) {
        playwright.clickOn(searchTypeLeads);
        Locator searchTypeLeadsDropdown = page.locator("a").filter(new Locator.FilterOptions().setHasText(""+typeLeads+""));
        playwright.clickOn(searchTypeLeadsDropdown);
        searchInput.fill(text);
        playwright.clickOn(searchButton);
    }

    /**
     * Get result search leads
     * @param text
     * @return
     */
    public String getDataInTable(String text){
        Locator searchData = page.getByText(""+text+"");
        return playwright.getText(searchData);
    }

    /**
     * Select Leads Curation
     * @param value example "Submitted to LBT"
     */
    public void selectsLeadsCuration(String value) {
        playwright.clickOn(dropdownLeadsCuration);
        Locator selectLeadsCuration = page.locator("a").filter(new Locator.FilterOptions().setHasText(value));
        playwright.clickOn(selectLeadsCuration);
    }

    /**
     * Get Row Count
     * @return int
     */
    public int rowCount() {
        return playwright.countLocator(row);
    }

    /**
     * Get Leads Curation Status
     * @param i index
     * @return String
     */
    public String getLeadsCurationStatus(int i) {
        playwright.pageScrollInView(leadsCurationStatus.nth(i));
        return playwright.getText(leadsCurationStatus.nth(i));
    }

    /**
     * Click on Manage Leads button
     */
    public void clickManageLeads() {
        playwright.clickOn(manageLeadsButton);
    }

    /**
     * Selects on Submit to LBT button
     * @param value example "Submitted to LBT"
     */
    public void selectsSubmitToLBT(String value) {
        submitToLBTButtonOption = page.locator("tr.content:nth-of-type(1) .bg-c-radio").filter(new Locator.FilterOptions().setHasText(value));
        playwright.clickOn(submitToLBTButtonOption);
    }

    /**
     * Clicks on Submit to LBT button
     */
    public void clicksSubmitToLBT() {
        playwright.clickOn(submitToLBTButton);
    }

    /**
     * Clicks on Confirm Submit to LBT button
     */
    public void confirmSubmitToLBT() {
        playwright.clickOn(confirmSubmitToLBTButton);
    }
}
