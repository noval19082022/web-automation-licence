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
        Locator responseCell = row.locator("td").nth(5);
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
        Locator responseElement = row.locator("td").nth(5).locator("div, span, p").first();
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
