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

    // Attempts
    private Locator addAttemptButton;
    private Locator jenisFollowUpDropdown;
    private Locator responseDropdown;
    private Locator saveAttemptButton;

    // LBT Search
    private Locator lbtSearchTypeDropdown;
    private Locator lbtSearchInput;

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
    }

    /**
     * Search leads in LBT by selecting search type and entering text
     * @param searchType the search type (e.g. "Nama Properti", "No. HP Pemilik", "Nama Pemilik", "Leadbase ID")
     * @param text the search text
     */
    public void searchLBT(String searchType, String text) {
        playwright.waitTillPageLoaded();
        playwright.clickOn(lbtSearchTypeDropdown);
        Locator option = page.locator("a").filter(new Locator.FilterOptions().setHasText(searchType));
        playwright.clickOn(option);
        lbtSearchInput.fill(text);
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
        Locator headers = page.locator("table th");
        int columnIndex = -1;
        int headerCount = headers.count();
        for (int i = 0; i < headerCount; i++) {
            String headerText = headers.nth(i).textContent().trim();
            if (headerText.equals(columnHeader)) {
                columnIndex = i;
                break;
            }
        }

        // Get the cell value from the first data row at the found column index
        Locator firstRow = page.locator("table tbody tr").first();
        Locator cell = firstRow.locator("td").nth(columnIndex);
        return playwright.getText(cell);
    }

    /**
     * Clear LBT search input and search with new keyword without re-selecting search type
     * @param text the search text
     */
    public void clearAndSearchLBT(String text) {
        lbtSearchInput.clear();
        lbtSearchInput.fill(text);
        playwright.pressKeyboardKey("Enter");
        playwright.hardWait(3000);
    }

    /**
     * Clear LBT search input
     */
    public void clearLBTSearch() {
        lbtSearchInput.clear();
    }

    // ---- LBT Filter Methods ----

    /**
     * Click the Filter button on LBT page
     */
    public void clickLBTFilter() {
        playwright.waitTillPageLoaded();
        Locator filterButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Filter"));
        playwright.clickOn(filterButton);
        playwright.hardWait(1000);
    }

    /**
     * Close the filter dialog by clicking the close button
     */
    public void closeLBTFilter() {
        Locator closeButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("close"));
        playwright.clickOn(closeButton);
        playwright.hardWait(500);
    }

    /**
     * Click Reset button in filter dialog
     */
    public void clickLBTResetFilter() {
        Locator resetButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Reset"));
        playwright.clickOn(resetButton);
        playwright.hardWait(1000);
    }

    /**
     * Click Terapkan button in filter dialog
     */
    public void clickLBTTerapkan() {
        Locator terapkanButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Terapkan"));
        playwright.clickOn(terapkanButton);
        playwright.hardWait(3000);
    }

    /**
     * Toggle a Leads Source checkbox in filter dialog by clicking its label
     * @param source the leads source (e.g. "MLB", "ILB", "CLB", "NLB")
     * @param check true to check, false to uncheck
     */
    public void toggleLeadsSource(String source, boolean check) {
        Locator checkbox = page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName(source));
        boolean isChecked = checkbox.isChecked();
        if (check != isChecked) {
            // Click the paragraph label next to the checkbox to avoid SVG icon interception
            Locator label = page.locator("p").filter(new Locator.FilterOptions().setHasText(source)).first();
            playwright.clickOn(label);
        }
    }

    /**
     * Select a filter dropdown option by label and value
     * @param label the filter label (e.g. "Kota/ Kabupaten", "Kecamatan", "Kelurahan", "Area Priority")
     * @param value the option value to select
     */
    public void selectLBTFilterDropdown(String label, String value) {
        // Label is inside div.bg-c-field__label, parent is div.bg-c-field which also contains the dropdown trigger
        Locator field = page.locator("div.bg-c-field").filter(new Locator.FilterOptions().setHasText(label)).first();
        Locator dropdownTrigger = field.locator("div.bg-c-dropdown__trigger");
        playwright.clickOn(dropdownTrigger);
        playwright.hardWait(500);
        Locator option = page.locator("a:visible").filter(new Locator.FilterOptions().setHasText(value));
        playwright.clickOn(option.first());
        playwright.hardWait(1000);
    }

    /**
     * Get all column values from LBT table for a given column name
     * @param columnName the column header name
     * @return array of text values from that column across all rows
     */
    public int getLBTTableRowCount() {
        playwright.waitTillPageLoaded();
        return page.locator("table tbody tr").count();
    }

    /**
     * Get cell text from a specific row and column in LBT table
     * @param rowIndex 0-based row index
     * @param columnName the column header name
     * @return text content of the cell
     */
    public String getLBTCellByColumnName(int rowIndex, String columnName) {
        Locator headers = page.locator("table th");
        int columnIndex = -1;
        int headerCount = headers.count();
        for (int i = 0; i < headerCount; i++) {
            if (headers.nth(i).textContent().trim().equals(columnName)) {
                columnIndex = i;
                break;
            }
        }
        Locator row = page.locator("table tbody tr").nth(rowIndex);
        Locator cell = row.locator("td").nth(columnIndex);
        return playwright.getText(cell);
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
            Locator checkbox = page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName(source));
            if (checkbox.count() > 0 && checkbox.isChecked()) {
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
        int rowCount = page.locator("table tbody tr").count();
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
        Locator pageButton = page.locator("button.bg-c-pagination__item").filter(
                new Locator.FilterOptions().setHasText(String.valueOf(pageNumber)));
        playwright.clickOn(pageButton);
        playwright.hardWait(3000);
    }

    /**
     * Get the current active page number in LBT pagination
     * @return current page number
     */
    public int getLBTCurrentPage() {
        Locator selectedPage = page.locator("button.bg-c-button--primary.bg-c-pagination__item--selected");
        return Integer.parseInt(selectedPage.textContent().trim());
    }

    /**
     * Click the first leads row in LBT table
     */
    public void clickFirstLeadsRow() {
        playwright.waitTillPageLoaded();
        Locator firstRow = page.locator("table tbody tr").first();
        playwright.clickOn(firstRow);
        playwright.hardWait(2000);
    }

    /**
     * Click Cancel button on leads detail page
     */
    public void clickCancelOnLeadsDetail() {
        playwright.waitTillPageLoaded();
        Locator cancelButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cancel"));
        playwright.clickOn(cancelButton);
        playwright.hardWait(1000);
    }

    /**
     * Confirm cancel edit by clicking "Ya, Batalkan" on the confirmation popup
     */
    public void confirmCancelEdit() {
        Locator confirmButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ya, Batalkan"));
        playwright.clickOn(confirmButton);
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
        Locator row = page.locator("tr").filter(new Locator.FilterOptions().setHasText(phoneNumber));
        playwright.clickOn(row.first());
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
        Locator rejectReasonDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih Reject Reason"));
        playwright.clickOn(rejectReasonDropdown);
        Locator option = page.locator("a").filter(new Locator.FilterOptions().setHasText(reason)).last();
        playwright.clickOn(option);
    }

    /**
     * Select Reject Reason from dropdown in BD Update section (button name is "Select")
     * @param reason the reject reason text
     */
    public void selectBDRejectReason(String reason) {
        Locator rejectReasonDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Select"));
        playwright.clickOn(rejectReasonDropdown);
        Locator option = page.locator("a:visible").filter(new Locator.FilterOptions().setHasText(reason)).last();
        playwright.clickOn(option);
    }

    /**
     * Select Assign BD from dropdown (required when response is "Tertarik")
     * @param bd the BD name to assign
     */
    public void selectAssignBD(String bd) {
        Locator assignBDDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih BD"));
        playwright.clickOn(assignBDDropdown);
        Locator option = page.locator("a:visible").filter(new Locator.FilterOptions().setHasText(bd)).first();
        playwright.clickOn(option);
    }

    /**
     * Select Jenis Visit from dropdown (required when response is "Tertarik")
     * @param jenisVisit the visit type (e.g. "Online", "Offline")
     */
    public void selectJenisVisit(String jenisVisit) {
        Locator jenisVisitDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih Jenis Visit"));
        playwright.clickOn(jenisVisitDropdown);
        Locator option = page.locator("a").filter(new Locator.FilterOptions().setHasText(jenisVisit)).last();
        playwright.clickOn(option);
    }

    /**
     * Select a visit date (tomorrow) from the date picker (required when response is "Tertarik")
     */
    public void selectVisitDate() {
        Locator dateInput = page.getByPlaceholder("Pilih Tanggal dan Jam Visit");
        playwright.clickOn(dateInput);
        playwright.hardWait(1000);

        int tomorrowDay = LocalDate.now().plusDays(1).getDayOfMonth();
        String dayStr = String.valueOf(tomorrowDay);

        Locator calendarDays = page.locator("[aria-label='Calendar days']");
        calendarDays.getByText(dayStr, new Locator.GetByTextOptions().setExact(true)).last().click();

        Locator pilihButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih"));
        playwright.clickOn(pilihButton);
    }

    /**
     * Select a new visit date (tomorrow) from the BD Update date picker (required when BD response is "Reschedule")
     */
    public void selectBDVisitDate() {
        // Two elements match this placeholder (one disabled, one enabled). Use last() to get the enabled one.
        Locator dateInput = page.getByPlaceholder("Pilih Tanggal dan Jam Visit Baru").last();
        playwright.clickOn(dateInput);
        playwright.hardWait(1000);

        int tomorrowDay = LocalDate.now().plusDays(1).getDayOfMonth();
        String dayStr = String.valueOf(tomorrowDay);

        Locator calendarDays = page.locator("[aria-label='Calendar days']");
        calendarDays.getByText(dayStr, new Locator.GetByTextOptions().setExact(true)).last().click();

        Locator pilihButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih"));
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
        Locator bdCard = page.locator("xpath=//p[text()='BD Update']/ancestor::div[contains(@class,'bg-c-card')]");
        Locator bdResponseDropdown = bdCard.locator("label:text('Response')").locator("xpath=ancestor::div[contains(@class,'bg-c-field__label')]/following-sibling::div//div[@role='button']");
        playwright.clickOn(bdResponseDropdown);
        Locator option = page.locator("a:visible").filter(new Locator.FilterOptions().setHasText(status));
        if (status.equals("Tertarik")) {
            playwright.clickOn(option.first());
        } else {
            playwright.clickOn(option.last());
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
        Locator leadsRow = page.locator("tr").filter(new Locator.FilterOptions().setHasText(phoneNumber));
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
        Locator option = page.locator("a").filter(new Locator.FilterOptions().setHasText(jenis)).last();
        playwright.clickOn(option);
    }

    /**
     * Select Response from dropdown
     * @param response the response value (e.g. "No Response", "Awaiting", "Tidak Tertarik", "Tertarik")
     */
    public void selectResponse(String response) {
        responseDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih Response"));
        playwright.clickOn(responseDropdown);
        // Use :visible to only match options from the currently open dropdown
        Locator options = page.locator("a:visible").filter(new Locator.FilterOptions().setHasText(response));
        if (response.equals("Tertarik")) {
            // "Tertarik" is a substring of "Tidak Tertarik", use first() to get exact match
            playwright.clickOn(options.first());
        } else {
            playwright.clickOn(options.last());
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
        Locator row = page.locator("tr").filter(new Locator.FilterOptions().setHasText(phoneNumber));
        Locator responseCell = row.locator("td").nth(8);
        return playwright.getText(responseCell);
    }

    /**
     * Get text from a specific column in leads table row by phone number
     * @param phoneNumber phone number to identify the row
     * @param columnIndex the column index (0-based)
     * @return text displayed in the cell
     */
    public String getLeadsCellText(String phoneNumber, int columnIndex) {
        playwright.waitTillPageLoaded();
        Locator row = page.locator("tr").filter(new Locator.FilterOptions().setHasText(phoneNumber));
        Locator cell = row.locator("td").nth(columnIndex);
        return playwright.getText(cell);
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
        Locator row = page.locator("tr").filter(new Locator.FilterOptions().setHasText(phoneNumber));
        Locator responseElement = row.locator("td").nth(8).locator("div, span, p").first();
        return responseElement.evaluate("el => getComputedStyle(el).color").toString();
    }

    /**
     * Get BD response color from Visit/Done tab (Response column is at index 8)
     * @param phoneNumber phone number to identify the row
     * @return color CSS value of the response text
     */
    public String getBDResponseColor(String phoneNumber) {
        playwright.waitTillPageLoaded();
        Locator row = page.locator("tr").filter(new Locator.FilterOptions().setHasText(phoneNumber));
        Locator responseElement = row.locator("td").nth(8).locator("div, span, p").first();
        return responseElement.evaluate("el => getComputedStyle(el).color").toString();
    }
}
