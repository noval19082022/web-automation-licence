package pageobject.harvest.harvestDashboard;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import data.mamikos.Mamikos;
import utilities.PlaywrightHelpers;

import java.time.LocalDate;

public class LeadsDetailPO {

    private Page page;
    private PlaywrightHelpers playwright;

    // LBT Table
    private Locator assignToMeButton;
    private Locator followUpTab;
    private Locator doneTab;
    private Locator visitTab;
    private Locator lbtTableHeaders;
    private Locator lbtTableRows;

    // Attempts
    private Locator addAttemptButton;
    private Locator jenisFollowUpDropdown;
    private Locator responseDropdown;
    private Locator saveAttemptButton;

    // LBT Search
    private Locator lbtSearchTypeDropdown;
    private Locator lbtSearchInput;
    private Locator lbtSearchTypeOption;

    // LBT Filter
    private Locator filterButton;
    private Locator closeFilterButton;
    private Locator resetFilterButton;
    private Locator terapkanButton;
    private Locator leadsSourceCheckbox;
    private Locator leadsSourceLabel;
    private Locator filterField;
    private Locator filterDropdownTrigger;

    // LBT Pagination
    private Locator paginationButton;
    private Locator selectedPageButton;

    // Leads Detail
    private Locator cancelButton;
    private Locator confirmCancelButton;
    private Locator rejectReasonDropdown;
    private Locator bdRejectReasonDropdown;
    private Locator assignBDDropdown;
    private Locator jenisVisitDropdown;
    private Locator visitDateInput;
    private Locator bdVisitDateInput;
    private Locator calendarDays;
    private Locator pilihButton;
    private Locator bdCard;
    private Locator bdResponseDropdown;
    private Locator leadsRow;
    private Locator dropdownOption;
    private Locator notesText;
    private Locator leadsDetailTab;
    private Locator lbtTableCell;
    private Locator leadsResponseCell;
    private Locator leadsResponseColorElement;

    // Update & Success
    private Locator updateButton;
    private Locator successToast;

    public LeadsDetailPO(Page page) {
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        assignToMeButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Assign to me"));
        updateButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Update"));
        followUpTab = page.getByText("Follow Up", new Page.GetByTextOptions().setExact(true));
        doneTab = page.getByText("Done", new Page.GetByTextOptions().setExact(true));
        visitTab = page.getByText("Visit", new Page.GetByTextOptions().setExact(true));

        addAttemptButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tambah Attempt"));

        // LBT Search
        lbtSearchTypeDropdown = page.locator("div.bg-c-select.bg-c-searchbar__select-input > div > div.bg-c-dropdown__trigger");
        lbtSearchInput = page.locator(".bg-c-searchbar input[type='text']");

        // LBT Table
        lbtTableHeaders = page.locator("table th");
        lbtTableRows = page.locator("table tbody tr");

        // LBT Filter
        filterButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Filter"));
        closeFilterButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("close"));
        resetFilterButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Reset"));
        terapkanButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Terapkan"));

        // LBT Pagination
        selectedPageButton = page.locator("button.bg-c-button--primary.bg-c-pagination__item--selected");

        // Leads Detail
        cancelButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cancel"));
        confirmCancelButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ya, Batalkan"));
        rejectReasonDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih Reject Reason"));
        bdRejectReasonDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Select"));
        assignBDDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih BD"));
        jenisVisitDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih Jenis Visit"));
        visitDateInput = page.getByPlaceholder("Pilih Tanggal dan Jam Visit");
        bdVisitDateInput = page.getByPlaceholder("Pilih Tanggal dan Jam Visit Baru");
        calendarDays = page.locator("[aria-label='Calendar days']");
        pilihButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih"));
        bdCard = page.locator("xpath=//p[text()='BD Update']/ancestor::div[contains(@class,'bg-c-card')]");
        notesText = page.locator(".lead-base-tracker-owner-property-form__notes p");
    }

    /**
     * Search leads in LBT by selecting search type and entering text
     * @param searchType the search type (e.g. "Nama Properti", "No. HP Pemilik", "Nama Pemilik", "Leadbase ID")
     * @param text the search text
     */
    public void searchLBT(String searchType, String text) {
        playwright.waitTillPageLoaded();
        playwright.clickOn(lbtSearchTypeDropdown);
        lbtSearchTypeOption = page.locator("a").filter(new Locator.FilterOptions().setHasText(searchType));
        playwright.clickOn(lbtSearchTypeOption);
        playwright.fill(lbtSearchInput, text);
        playwright.pressKeyboardKey("Enter");
        playwright.hardWait(3000);
    }

    /**
     * Get the column header name corresponding to the search type dropdown label
     */
    private String getColumnHeaderForSearchType(String searchType) {
        switch (searchType) {
            case "No. HP Pemilik": return "No Hp Pemilik";
            case "Leadbase ID": return "Lead ID";
            case "Nama Properti": return "Nama Properti";
            case "Nama Pemilik": return "Nama Pemilik";
            default: return searchType;
        }
    }

    /**
     * Validate search result appears in the correct column of the LBT table
     * @param searchType the search type used (e.g. "No. HP Pemilik", "Leadbase ID")
     * @param expectedText the expected text in that column
     * @return the actual text found in the column cell of the first result row
     */
    public String getDataInLBTTableByColumn(String searchType, String expectedText) {
        playwright.waitTillPageLoaded();
        String columnHeader = getColumnHeaderForSearchType(searchType);

        // Find the column index from the header row
        int columnIndex = -1;
        int headerCount = lbtTableHeaders.count();
        for (int i = 0; i < headerCount; i++) {
            String headerText = lbtTableHeaders.nth(i).textContent().trim();
            if (headerText.equals(columnHeader)) {
                columnIndex = i;
                break;
            }
        }

        // Get the cell value from the first data row at the found column index
        lbtTableCell = lbtTableRows.first().locator("td").nth(columnIndex);
        return playwright.getText(lbtTableCell);
    }

    /**
     * Clear LBT search input and search with new keyword without re-selecting search type
     * @param text the search text
     */
    public void clearAndSearchLBT(String text) {
        playwright.clearText(lbtSearchInput);
        playwright.fill(lbtSearchInput, text);
        playwright.pressKeyboardKey("Enter");
        playwright.hardWait(3000);
    }

    /**
     * Clear LBT search input
     */
    public void clearLBTSearch() {
        playwright.clearText(lbtSearchInput);
    }

    // ---- LBT Filter Methods ----

    /**
     * Click the Filter button on LBT page
     */
    public void clickLBTFilter() {
        playwright.waitTillPageLoaded();
        playwright.clickOn(filterButton);
        playwright.hardWait(1000);
    }

    /**
     * Close the filter dialog by clicking the close button
     */
    public void closeLBTFilter() {
        playwright.clickOn(closeFilterButton);
        playwright.hardWait(500);
    }

    /**
     * Click Reset button in filter dialog
     */
    public void clickLBTResetFilter() {
        playwright.clickOn(resetFilterButton);
        playwright.hardWait(1000);
    }

    /**
     * Click Terapkan button in filter dialog
     */
    public void clickLBTTerapkan() {
        playwright.clickOn(terapkanButton);
        playwright.hardWait(3000);
    }

    /**
     * Toggle a Leads Source checkbox in filter dialog by clicking its label
     * @param source the leads source (e.g. "MLB", "ILB", "CLB", "NLB")
     * @param check true to check, false to uncheck
     */
    public void toggleLeadsSource(String source, boolean check) {
        leadsSourceCheckbox = page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName(source));
        boolean isChecked = leadsSourceCheckbox.isChecked();
        if (check != isChecked) {
            // Click the paragraph label next to the checkbox to avoid SVG icon interception
            leadsSourceLabel = page.locator("p").filter(new Locator.FilterOptions().setHasText(source)).first();
            playwright.clickOn(leadsSourceLabel);
        }
    }

    /**
     * Select a filter dropdown option by label and value
     * @param label the filter label (e.g. "Kota/ Kabupaten", "Kecamatan", "Kelurahan", "Area Priority")
     * @param value the option value to select
     */
    public void selectLBTFilterDropdown(String label, String value) {
        // Label is inside div.bg-c-field__label, parent is div.bg-c-field which also contains the dropdown trigger
        filterField = page.locator("div.bg-c-field").filter(new Locator.FilterOptions().setHasText(label)).first();
        filterDropdownTrigger = filterField.locator("div.bg-c-dropdown__trigger");
        playwright.clickOn(filterDropdownTrigger);
        playwright.hardWait(500);
        dropdownOption = page.locator("a:visible").filter(new Locator.FilterOptions().setHasText(value));
        playwright.clickOn(dropdownOption.first());
        playwright.hardWait(1000);
    }

    /**
     * Get LBT table row count
     * @return number of rows in the table
     */
    public int getLBTTableRowCount() {
        playwright.waitTillPageLoaded();
        return lbtTableRows.count();
    }

    /**
     * Get cell text from a specific row and column in LBT table
     * @param rowIndex 0-based row index
     * @param columnName the column header name
     * @return text content of the cell
     */
    public String getLBTCellByColumnName(int rowIndex, String columnName) {
        int columnIndex = -1;
        int headerCount = lbtTableHeaders.count();
        for (int i = 0; i < headerCount; i++) {
            if (lbtTableHeaders.nth(i).textContent().trim().equals(columnName)) {
                columnIndex = i;
                break;
            }
        }
        lbtTableCell = lbtTableRows.nth(rowIndex).locator("td").nth(columnIndex);
        return playwright.getText(lbtTableCell);
    }

    /**
     * Check if LBT search input field is empty
     * @return true if the search field has no value
     */
    public boolean isLBTSearchFieldEmpty() {
        return lbtSearchInput.inputValue().isEmpty();
    }

    /**
     * Check if any Leads Source checkbox is checked in the filter dialog
     * @return true if at least one checkbox is checked
     */
    public boolean hasAnyLeadsSourceChecked() {
        String[] sources = {"ILB", "CLB", "Canvassing Online", "Canvassing Offline", "Agent Offline", "MLB", "NLB", "Scraping", "Instagram", "Cove", "Infokost", "Sewakost", "Reddoorz", "Google Maps"};
        for (String source : sources) {
            leadsSourceCheckbox = page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName(source));
            if (leadsSourceCheckbox.count() > 0 && leadsSourceCheckbox.isChecked()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if LBT table contains multiple different lead sources (e.g. MLB, ILB, CLB, NLB)
     * @return true if at least 2 different lead source prefixes are found
     */
    public boolean hasMultipleLeadSources() {
        playwright.waitTillPageLoaded();
        playwright.hardWait(3000);
        int rowCount = lbtTableRows.count();
        java.util.Set<String> sources = new java.util.HashSet<>();
        for (int i = 0; i < rowCount && i < 20; i++) {
            String leadId = getLBTCellByColumnName(i, "Lead ID");
            if (leadId != null && leadId.length() >= 3) {
                sources.add(leadId.substring(0, 3));
            }
        }
        return sources.size() >= 2;
    }

    /**
     * Navigate to a specific page number in LBT pagination
     * @param pageNumber the page number to navigate to
     */
    public void navigateToLBTPage(int pageNumber) {
        playwright.waitTillPageLoaded();
        paginationButton = page.locator("button.bg-c-pagination__item").filter(
                new Locator.FilterOptions().setHasText(String.valueOf(pageNumber)));
        playwright.clickOn(paginationButton);
        playwright.hardWait(3000);
    }

    /**
     * Get the current active page number in LBT pagination
     * @return current page number
     */
    public int getLBTCurrentPage() {
        return Integer.parseInt(selectedPageButton.textContent().trim());
    }

    /**
     * Click the first leads row in LBT table
     */
    public void clickFirstLeadsRow() {
        playwright.waitTillPageLoaded();
        playwright.clickOn(lbtTableRows.first());
        playwright.hardWait(2000);
    }

    /**
     * Click Cancel button on leads detail page
     */
    public void clickCancelOnLeadsDetail() {
        playwright.waitTillPageLoaded();
        playwright.clickOn(cancelButton);
        playwright.hardWait(1000);
    }

    /**
     * Confirm cancel edit by clicking "Ya, Batalkan" on the confirmation popup
     */
    public void confirmCancelEdit() {
        playwright.clickOn(confirmCancelButton);
        playwright.hardWait(3000);
    }

    /**
     * Navigate back to LBT list page
     */
    public void navigateBackToLBT() {
        playwright.navigateTo(Mamikos.URL + "/leads/harvest/lead-base-tracker", 30000.0, LoadState.LOAD);
        playwright.hardWait(2000);
    }

    /**
     * Click on leads row by phone number in LBT table
     * @param phoneNumber phone number to identify the row
     */
    public void clickLeadsRow(String phoneNumber) {
        playwright.waitTillPageLoaded();
        leadsRow = page.locator("tr").filter(new Locator.FilterOptions().setHasText(phoneNumber));
        playwright.clickOn(leadsRow.first());
    }

    /**
     * Click on Assign to me button and then click Update to save.
     * After Update, the page auto-navigates to Follow Up tab.
     */
    public void clickAssignToMe() {
        playwright.waitTillPageLoaded();
        playwright.clickOn(assignToMeButton);
        playwright.clickOn(updateButton);
    }

    /**
     * Check if Assign to me button is visible
     * @return true if visible
     */
    public boolean isAssignToMeVisible() {
        return playwright.isLocatorVisibleAfterLoad(assignToMeButton, 10000.0);
    }

    /**
     * Click on Follow Up tab
     */
    public void clickFollowUpTab() {
        playwright.waitTillPageLoaded();
        playwright.clickOn(followUpTab);
        playwright.hardWait(2000);
    }

    /**
     * Click on Done tab
     */
    public void clickDoneTab() {
        playwright.waitTillPageLoaded();
        playwright.clickOn(doneTab);
        playwright.hardWait(2000);
    }

    /**
     * Click on Visit tab
     */
    public void clickVisitTab() {
        playwright.waitTillPageLoaded();
        playwright.clickOn(visitTab);
        playwright.hardWait(2000);
    }

    /**
     * Select Reject Reason from dropdown (required when response is "Tidak Tertarik")
     * @param reason the reject reason text
     */
    public void selectRejectReason(String reason) {
        playwright.clickOn(rejectReasonDropdown);
        dropdownOption = page.locator("a").filter(new Locator.FilterOptions().setHasText(reason)).last();
        playwright.clickOn(dropdownOption);
    }

    /**
     * Select Reject Reason from dropdown in BD Update section (button name is "Select")
     * @param reason the reject reason text
     */
    public void selectBDRejectReason(String reason) {
        playwright.clickOn(bdRejectReasonDropdown);
        dropdownOption = page.locator("a:visible").filter(new Locator.FilterOptions().setHasText(reason)).last();
        playwright.clickOn(dropdownOption);
    }

    /**
     * Select Assign BD from dropdown (required when response is "Tertarik")
     * @param bd the BD name to assign
     */
    public void selectAssignBD(String bd) {
        playwright.clickOn(assignBDDropdown);
        dropdownOption = page.locator("a:visible").filter(new Locator.FilterOptions().setHasText(bd)).first();
        playwright.clickOn(dropdownOption);
    }

    /**
     * Select Jenis Visit from dropdown (required when response is "Tertarik")
     * @param jenisVisit the visit type (e.g. "Online", "Offline")
     */
    public void selectJenisVisit(String jenisVisit) {
        playwright.clickOn(jenisVisitDropdown);
        dropdownOption = page.locator("a").filter(new Locator.FilterOptions().setHasText(jenisVisit)).last();
        playwright.clickOn(dropdownOption);
    }

    /**
     * Select a visit date (tomorrow) from the date picker (required when response is "Tertarik")
     */
    public void selectVisitDate() {
        playwright.clickOn(visitDateInput);
        playwright.hardWait(1000);

        int tomorrowDay = LocalDate.now().plusDays(1).getDayOfMonth();
        String dayStr = String.valueOf(tomorrowDay);

        playwright.clickOn(calendarDays.getByText(dayStr, new Locator.GetByTextOptions().setExact(true)).last());

        playwright.clickOn(pilihButton);
    }

    /**
     * Select a new visit date (tomorrow) from the BD Update date picker (required when BD response is "Reschedule")
     */
    public void selectBDVisitDate() {
        // Two elements match this placeholder (one disabled, one enabled). Use last() to get the enabled one.
        playwright.clickOn(bdVisitDateInput.last());
        playwright.hardWait(1000);

        int tomorrowDay = LocalDate.now().plusDays(1).getDayOfMonth();
        String dayStr = String.valueOf(tomorrowDay);

        playwright.clickOn(calendarDays.getByText(dayStr, new Locator.GetByTextOptions().setExact(true)).last());

        playwright.clickOn(pilihButton);
    }

    /**
     * Select BD response from dropdown in BD Update section.
     * The BD Update section is scoped by the text "BD Update" to avoid conflict with MDR's "Pilih Response".
     * @param status the response (e.g. "Reschedule", "Awaiting", "Tidak Tertarik", "Unqualified", "Cancel", "Tertarik")
     */
    public void selectBDResponse(String status) {
        // The BD Update section's Response dropdown. Navigate from "BD Update" paragraph up to the card,
        // then find the Response field's dropdown trigger (role="button") within it.
        bdResponseDropdown = bdCard.locator("label:text('Response')").locator("xpath=ancestor::div[contains(@class,'bg-c-field__label')]/following-sibling::div//div[@role='button']");
        playwright.clickOn(bdResponseDropdown);
        dropdownOption = page.locator("a:visible").filter(new Locator.FilterOptions().setHasText(status));
        if (status.equals("Tertarik")) {
            playwright.clickOn(dropdownOption.first());
        } else {
            playwright.clickOn(dropdownOption.last());
        }
    }

    /**
     * Update BD visit status and save
     * @param status the visit status response
     */
    public void updateBDVisitStatus(String status) {
        playwright.waitTillPageLoaded();
        selectBDResponse(status);

        if (status.equals("Tidak Tertarik")) {
            selectBDRejectReason("Okupansi tinggi (>67%)");
        } else if (status.equals("Reschedule")) {
            selectJenisVisit("Online");
            selectBDVisitDate();
        }

        saveAttempt();
    }

    /**
     * Click on leads detail row by phone number in Follow Up tab
     * @param phoneNumber phone number to identify the leads
     */
    public void clickLeadsDetailByPhone(String phoneNumber) {
        playwright.waitTillPageLoaded();
        leadsRow = page.locator("tr").filter(new Locator.FilterOptions().setHasText(phoneNumber));
        playwright.clickOn(leadsRow.first());
    }

    /**
     * Click on Tambah Attempt button if it is enabled.
     * For the first attempt, the form is already visible and the button is disabled.
     */
    public void clickAddAttempt() {
        playwright.waitTillPageLoaded();
        if (addAttemptButton.isEnabled()) {
            playwright.clickOn(addAttemptButton);
        }
    }

    /**
     * Select Jenis Follow Up from dropdown
     * @param jenis the jenis follow up value (e.g. "Call", "Chat")
     */
    public void selectJenisFollowUp(String jenis) {
        jenisFollowUpDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Jenis Follow Up"));
        playwright.clickOn(jenisFollowUpDropdown);
        dropdownOption = page.locator("a").filter(new Locator.FilterOptions().setHasText(jenis)).last();
        playwright.clickOn(dropdownOption);
    }

    /**
     * Select Response from dropdown
     * @param response the response value (e.g. "No Response", "Awaiting", "Tidak Tertarik", "Tertarik")
     */
    public void selectResponse(String response) {
        responseDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih Response"));
        playwright.clickOn(responseDropdown);
        // Use :visible to only match options from the currently open dropdown
        dropdownOption = page.locator("a:visible").filter(new Locator.FilterOptions().setHasText(response));
        if (response.equals("Tertarik")) {
            // "Tertarik" is a substring of "Tidak Tertarik", use first() to get exact match
            playwright.clickOn(dropdownOption.first());
        } else {
            playwright.clickOn(dropdownOption.last());
        }
    }

    /**
     * Click Update button to save attempt
     */
    public void saveAttempt() {
        playwright.clickOn(updateButton);
    }

    /**
     * Check if success toast is visible after saving attempt
     * @return true if success toast is visible
     */
    public boolean isSuccessToastVisible() {
        successToast = page.getByText("updated successfully");
        return playwright.isLocatorVisibleAfterLoad(successToast, 10000.0);
    }

    /**
     * Check if current page URL contains Follow Up tab parameter
     * @return true if on Follow Up tab
     */
    public boolean isOnFollowUpTab() {
        playwright.waitTillPageLoaded();
        return page.url().contains("active_tab=follow_up");
    }

    /**
     * Check if current page URL is on LBT list page (any tab), not on detail/update page
     * @return true if on LBT list page
     */
    public boolean isOnLBTPage() {
        playwright.waitTillPageLoaded();
        String url = page.url();
        return url.contains("lead-base-tracker") && !url.contains("/update");
    }

    /**
     * Check if Tambah Attempt button is visible
     * @return true if visible
     */
    public boolean isAddAttemptButtonVisible() {
        return playwright.isLocatorVisibleAfterLoad(addAttemptButton, 10000.0);
    }

    /**
     * Get response text from leads table row by phone number
     * @param phoneNumber phone number to identify the row
     * @return response text displayed in the row
     */
    public String getLeadsResponseText(String phoneNumber) {
        playwright.waitTillPageLoaded();
        leadsRow = page.locator("tr").filter(new Locator.FilterOptions().setHasText(phoneNumber));
        leadsResponseCell = leadsRow.locator("td").nth(8);
        return playwright.getText(leadsResponseCell);
    }

    /**
     * Get text from a specific column in leads table row by phone number
     * @param phoneNumber phone number to identify the row
     * @param columnIndex the column index (0-based)
     * @return text displayed in the cell
     */
    public String getLeadsCellText(String phoneNumber, int columnIndex) {
        playwright.waitTillPageLoaded();
        leadsRow = page.locator("tr").filter(new Locator.FilterOptions().setHasText(phoneNumber));
        lbtTableCell = leadsRow.locator("td").nth(columnIndex);
        return playwright.getText(lbtTableCell);
    }

    /**
     * Get response text from Visit/Done tab (Response column is at index 8)
     * @param phoneNumber phone number to identify the row
     * @return response text
     */
    public String getBDResponseText(String phoneNumber) {
        return getLeadsCellText(phoneNumber, 8);
    }

    /**
     * Get Leads Status text from Visit/Done tab (Leads Status column is at index 20)
     * @param phoneNumber phone number to identify the row
     * @return leads status text
     */
    public String getLeadsStatusInVisitDoneTab(String phoneNumber) {
        return getLeadsCellText(phoneNumber, 20);
    }

    /**
     * Get response text color from leads table row by phone number
     * @param phoneNumber phone number to identify the row
     * @return color CSS value of the response text (e.g. "rgb(245, 166, 35)")
     */
    public String getLeadsResponseColor(String phoneNumber) {
        playwright.waitTillPageLoaded();
        leadsRow = page.locator("tr").filter(new Locator.FilterOptions().setHasText(phoneNumber));
        leadsResponseColorElement = leadsRow.locator("td").nth(8).locator("div, span, p").first();
        return leadsResponseColorElement.evaluate("el => getComputedStyle(el).color").toString();
    }

    /**
     * Get BD response color from Visit/Done tab (Response column is at index 8)
     * @param phoneNumber phone number to identify the row
     * @return color CSS value of the response text
     */
    public String getBDResponseColor(String phoneNumber) {
        playwright.waitTillPageLoaded();
        leadsRow = page.locator("tr").filter(new Locator.FilterOptions().setHasText(phoneNumber));
        leadsResponseColorElement = leadsRow.locator("td").nth(8).locator("div, span, p").first();
        return leadsResponseColorElement.evaluate("el => getComputedStyle(el).color").toString();
    }

    /**
     * Click on a tab by name in leads detail page
     * @param tabName the tab name (e.g. "Data Pemilik & Properti")
     */
    public void clickTab(String tabName) {
        playwright.waitTillPageLoaded();
        leadsDetailTab = page.getByText(tabName, new Page.GetByTextOptions().setExact(true));
        playwright.clickOn(leadsDetailTab);
        playwright.hardWait(2000);
    }

    /**
     * Get Notes text content from leads detail page
     * @return notes text
     */
    public String getNotesText() {
        playwright.waitTillPageLoaded();
        return playwright.getText(notesText);
    }

    /**
     * Filter leads by source in LBT (e.g. "NLB", "ILB")
     * @param source the lead source to filter
     */
    public void filterLeadsSource(String source) {
        playwright.waitTillPageLoaded();
        playwright.clickOn(filterButton);
        leadsSourceCheckbox = page.getByText(source, new Page.GetByTextOptions().setExact(true));
        playwright.clickOn(leadsSourceCheckbox);
        playwright.clickOn(terapkanButton);
        playwright.hardWait(2000);
    }

    /**
     * Click on a tab by name in leads detail page
     * @param tabName the tab name (e.g. "Data Pemilik & Properti")
     */
    public void clickTab(String tabName) {
        playwright.waitTillPageLoaded();
        Locator tab = page.getByText(tabName, new Page.GetByTextOptions().setExact(true));
        playwright.clickOn(tab);
        playwright.hardWait(2000);
    }

    /**
     * Get Notes text content from leads detail page
     * @return notes text
     */
    public String getNotesText() {
        playwright.waitTillPageLoaded();
        Locator notesValue = page.locator(".lead-base-tracker-owner-property-form__notes p");
        return playwright.getText(notesValue);
    }

    /**
     * Filter leads by source in LBT (e.g. "NLB", "ILB")
     * @param source the lead source to filter
     */
    public void filterLeadsSource(String source) {
        playwright.waitTillPageLoaded();
        Locator filterButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("filter Filter"));
        playwright.clickOn(filterButton);
        Locator sourceCheckbox = page.getByText(source, new Page.GetByTextOptions().setExact(true));
        playwright.clickOn(sourceCheckbox);
        Locator terapkanButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Terapkan"));
        playwright.clickOn(terapkanButton);
        playwright.hardWait(2000);
    }
}
