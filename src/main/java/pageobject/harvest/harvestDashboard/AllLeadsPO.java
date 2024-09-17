package pageobject.harvest.harvestDashboard;

import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;

public class AllLeadsPO {

    private Page page;
    private PlaywrightHelpers playwright;

    Locator allLeadsTitlePage;
    Locator profileNameText;
    Locator logoutButton;

    //--- Edit Table ---//
    Locator editTableButton;
    Locator yesButton;
    Locator noButton;

    //--- Batalkan Edit ---//
    Locator batalkanEditButton;

    //--- Filter ---//
    Locator filterButton;
    Locator checkBoxILB;
    Locator checkBoxAO;
    Locator checkBoxScrapping;
    Locator checkBoxAreaNonP1;
    Locator checkBoxAllArea;
    Locator dropdownJumlahKamar;
    Locator roomZeroToFive;
    Locator terapkanButton;

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

    public AllLeadsPO(Page page){
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        allLeadsTitlePage = page.getByText("All Leads Table");
        profileNameText = page.locator(".user-data-profile p").first();
        logoutButton = page.getByText("Logout", new Page.GetByTextOptions().setExact(true));

        //--- Edit Table ---//
        editTableButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Manage Leads"));

        //--- Batalkan Edit ---//
        batalkanEditButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cancel"));

        //--- Filter ---//
        filterButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("filter Filter"));
        checkBoxILB = page.getByText("ILB");
        checkBoxAO = page.getByText("Agent Offline");
        checkBoxScrapping = page.getByText("Scraping");
        checkBoxAreaNonP1 = page.getByText("Area Non P1");
        checkBoxAllArea = page.getByText("All Area");
        dropdownJumlahKamar = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(">5 Kamar dropdown-down"));
        roomZeroToFive = page.locator("a").filter(new Locator.FilterOptions().setHasText("0-5 Kamar"));
        terapkanButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Terapkan"));

        //--- Confirmation Batalkan ---//
        titleConfirmationBatalkan = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Yakin ingin batalkan?"));
        subtitleConfirmationBatalkan = page.getByText("Data yang sudah diisi tidak tersimpan dan tidak dapat dikembalikan.");
        closeConfirmationButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("close").setExact(true));
        yaBatalkanButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ya, Batalkan"));
        tidakButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tidak"));

        //--- Confirmation Perubahan Belum Tersimpan ---//
        titleConfirmationPerubahanBelumTersimpan = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Perubahan Belum Tersimpan"));
        subtitleConfirmationPerubahanBelumTersimpan = page.getByText("Terdapat perubahan yang belum disimpan. Simpan perubahan sebelum melanjutkan?");
    }

    /**
     * Check if All Leads Table Page is Visible
     * True = Visible
     * False = Invisible
     * @return All Leads Table Page
     */
    public boolean isAllLeadsTableVisible() {
        playwright.waitTillLocatorIsVisible(allLeadsTitlePage);
        return playwright.isLocatorVisibleAfterLoad(allLeadsTitlePage, 30000.0);
    }

    //--- Edit Table ---//
    /**
     * Clicks Edit Table Button
     */
    public void clicksEditTableButton() {
        playwright.waitTillPageLoaded();
        playwright.clickOn(editTableButton);
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
     * Selects on Yes Radio Button
     */
    public void selectsYesRadioButton() {
        yesButton = page.locator("(//tr)").first().locator("(//td)[1]//child::p[contains(., 'Yes')]");
        playwright.clickOn(yesButton);
    }

    /**
     * Selects on No Radio Button
     */
    public void selectsNoRadioButton() {
        noButton = page.locator("(//tr)").first().locator("(//td)[2]//child::p[contains(., 'No')]");
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
     * Selects on 0-5 at Jumlah Kamar Dropdown
     */
    public void selectsRoomsZeroToFive() {
        playwright.clickOn(dropdownJumlahKamar);
        playwright.clickOn(roomZeroToFive);
    }

    /**
     * Clicks on Terapkan button at Filter
     */
    public void clicksTerapkan() {
        playwright.clickOn(terapkanButton);
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
    //--- End of Confirmation Perubahan Belum Tersimpan ---//
}
