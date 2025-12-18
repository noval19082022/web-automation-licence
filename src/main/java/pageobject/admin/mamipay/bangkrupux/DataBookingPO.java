package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DataBookingPO {
    private Page page;
    PlaywrightHelpers playwright;
    Locator dataBookingMenu;
    Locator bookingNowButton;
    Locator sectionTitle;
    Locator nextButton;
    Locator submitButton;
    Locator succesPopupMessage;

    //------------ Select room booking now section ----------------
    Locator selectRoom;
    Locator searchRoomInput;
    Locator firstSuggestionRoom;

    //------------ Identity booking now section ----------------
    Locator searchTenantDropdown;
    Locator searchTenantInputText;
    Locator searchTenantButton;

    //------------ Duration booking now section ----------------
    Locator bookingTypeDropdown;
    Locator oldContractIdInput;
    Locator checkOldContractId;
    Locator contractValidMessage;
    Locator rentCountDropdown;
    Locator checkinDate;
    Locator rentDurationDropdown;

    //------------ Action booking now section ----------------
    Locator firstActionButton;
    Locator rejectActionButton;
    Locator rejectReasonDropdown;
    Locator sendRejectButton;

    //------------search data---------//
    Locator showAllButton;
    Locator allKostDropdown;
    Locator allKostTestingDropdown;
    Locator filterButton;
    Locator phoneNumberTextField;
    Locator noteCategoryDropdown;
    Locator noteCategoryTextbox;

    public DataBookingPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.dataBookingMenu = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Data Booking"));
        this.bookingNowButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Booking Now"));
        this.nextButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("next"));
        this.submitButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit"));
        this.succesPopupMessage = page.locator("//*[@class='alert alert-success alert-dismissable']");
        this.selectRoom = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Room"));
        this.searchRoomInput = page.locator("input[type='search']");
        this.firstSuggestionRoom = page.locator("//li[contains(@class,'highlighted')]");
        this.searchTenantDropdown = page.locator("select#searchTenantCategory");
        this.searchTenantInputText = page.locator("#inputTenant");
        this.searchTenantButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search"));
        this.bookingTypeDropdown = page.locator("#bookingType");
        this.oldContractIdInput = page.locator("#inputOldContractIdCheck");
        this.checkOldContractId = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Check"));
        this.rentCountDropdown = page.locator("#inputRentCount");
        this.checkinDate = page.locator("#inputCheckin");
        this.rentDurationDropdown = page.locator("#inputDuration");
        this.firstActionButton = page.locator("//button[@class=\"btn btn-default btn-sm dropdown-toggle\"]").first();
        this.rejectActionButton = page.locator("//*[@title=\"Tolak Booking\"]").first();
        this.rejectReasonDropdown = page.getByRole(AriaRole.COMBOBOX);
        this.sendRejectButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Send"));
        this.showAllButton = page.getByText("Tampilkan Filter");
        this.allKostDropdown = page.locator("#select2-kost_type-container");
        this.allKostTestingDropdown = page.locator("//ul[@class=\"select2-results__options select2-results__options--nested\"]//li[contains(.,'All Testing')]");
        this.filterButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Cari"));
        this.phoneNumberTextField = page.getByPlaceholder("Ex: 081987654321");
        this.noteCategoryDropdown = page.locator("#select2-note-category-container");
        this.noteCategoryTextbox = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("-"));
    }

    /**
     * click Data Booking menu
     */
    public void goToDataBookingMenu() {
        dataBookingMenu.click();
    }

    /**
     * click Booking Now on data booking
     */
    public void clickBookingNow() {
        bookingNowButton.waitFor();
        bookingNowButton.click();
    }

    /**
     * check what section is visible
     * e.g Rooms, Identity, Duration
     * @param title refers to title with string type
     */
    public void isSectionTitleVisible(String title) {
        sectionTitle = page.locator("//h3[text()='" + title + "']");
        assertThat(sectionTitle).isVisible();
    }

    /**
     * click, fill, and choose kost name
     * the first/highlighted kost name on suggestion will be clicked
     * @param listing refers to kost name
     */
    public void chooseListingName(String listing) {
        isSectionTitleVisible("Rooms");
        selectRoom.click();
        searchRoomInput.fill(listing);
        firstSuggestionRoom.click();
    }

    /**
     * choose search with name or phone number
     * and fill the value that wanna search
     * @param type refres to by name or ny phone number
     * @param value refers to name or phone number of the tenant
     *              and the name should be unique
     */
    public void fillSearchTenantBy(String type, String value) {
        isSectionTitleVisible("Identity");
        playwright.selectDropdownByValue(searchTenantDropdown, type);
        searchTenantInputText.fill(value);
    }

    /**
     * click on search tenant on identity section
     */
    public void clickSearchButton() {
        searchTenantButton.click();
    }

    /**
     * click next button on booking now form
     */
    public void clickNextButton() {
        nextButton.click();
    }

    /**
     * get and compare dialog alert message
     * @param text refers to dialog message
     */
    public void assertDialogMessageTextTo(String text) {
        page.onceDialog(dialog -> {
            String message = dialog.message();
            dialog.accept();
            System.out.println("Actual = " + message);
            assert message.equals(text);
        });
    }

    /**
     * wait until duration section visible and select booking type
     * @param type refers to booking type
     *             e.g. New Booking, Reschedule, or Relocation
     */
    public void setBookingTypeTo(String type) {
        isSectionTitleVisible("Duration");
        playwright.selectDropdownByValue(bookingTypeDropdown, type);
    }

    /**
     * fill old contract id to input field and click check
     * @param contractId refers to old contract id
     */
    public void fillOldContractId(String contractId) {
        oldContractIdInput.fill(contractId);
    }

    /**
     * click on check on input old contract id
     */
    public void clickCheckOldContract() {
        checkOldContractId.click();
    }

    /**
     * wait until contract valid message on check
     * old contract id duration section
     * @return boolean, true if visible
     */
    public boolean isContractValidOrNotMessageVisible(String message) {
        contractValidMessage = page.getByText(message);
        return playwright.waitTillLocatorIsVisible(contractValidMessage);
    }

    /**
     * choose rent count in duration section
     * @param rentCount refers to rent count
     *                  e.g. Weekly, Monthly, etc
     */
    public void selectRentCount(String rentCount) {
        playwright.selectDropdownByValue(rentCountDropdown, rentCount);
    }

    /**
     * fill checkin date input field in duration section
     * @param date
     */
    public void selectCheckInDate(String date) {
        checkinDate.fill(date);
    }

    /**
     * choose rent duration in duration section
     * @param duration refers to rent duration
     *                 e.g. 1 Minggu, 1 Bulan, etc
     */
    public void selectRentDuration(String duration) {
        playwright.selectDropdownByValue(rentDurationDropdown, duration);
    }

    /**
     * wait and click submit button on booking now last step
     */
    public void clickSubmitButton() {
        submitButton.waitFor();
        submitButton.click();
    }

    /**
     * check is success message visible or not
     * @param alertMessage refers to text that wanna compare
     * @return boolean, true if text contains the expectation
     */
    public boolean isSuccessMessageVisible(String alertMessage) {
        playwright.waitTillLocatorIsVisible(succesPopupMessage);
        String text = succesPopupMessage.innerText();
        return text.contains(alertMessage);
    }

    /**
     * click the first action button on Data Booking page
     */
    public void clickFirstActionButton() {
        firstActionButton.waitFor();
        firstActionButton.click();
    }

    /**
     * click rejected on action Data Booking page
     */
    public void clickOnRejectedListButton() {
        rejectActionButton.click();
    }

    /**
     * choose reject reason on reject
     * @param rejectReason
     */
    public void chooseRejectReason(String rejectReason) {
        rejectReasonDropdown.waitFor();
        playwright.selectDropdownByValue(rejectReasonDropdown, rejectReason);
    }

    /**
     * click send on reject booking and
     * wait till the button disappear
     */
    public void clickOnSendRejectBookingButton() {
        sendRejectButton.click();
        playwright.hardWait(3000);
    }

    /**
     * search phone number and all testing kost
     */
    public void searchAllTestingKost(String text){
        playwright.clickOn(showAllButton);
        playwright.forceFill(phoneNumberTextField, text);
        playwright.clickOn(allKostDropdown);
        playwright.clickOn(allKostTestingDropdown);
        playwright.clickOn(filterButton);
    }

    /**
     * Click on Show Filter button to display filter options
     * @return AdminBookingDataPO
     */
    public void clickOnShowFilter() {
        playwright.clickOn(showAllButton);
    }

    /**
     * Click on note category dropdown to open options
     * @return AdminBookingDataPO
     */
    public void clickOnNoteCategoryDropdown() {
        playwright.clickOn(noteCategoryDropdown);
    }

    /**
     * Select note category option by name
     * @param categoryName name of the category (e.g., "-", "Akan Survey")
     * @return AdminBookingDataPO
     */
    public void selectNoteCategoryOption(String categoryName) {
        Locator option = page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName(categoryName));
        playwright.clickOn(option);
    }

    /**
     * Click on textbox with specific name and select option
     * @param textboxName name of the textbox
     * @param optionName name of the option to select
     * @return AdminBookingDataPO
     */
    public void selectFromTextboxDropdown(String textboxName, String optionName) {
        Locator textbox = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(textboxName));
        playwright.clickOn(textbox);
        Locator option = page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName(optionName));
        playwright.clickOn(option);
    }

    /**
     * Verify if specific remarks text is displayed in the results
     * @param remarksText the remarks text to verify (e.g., "Remarks : -")
     * @return boolean true if the remarks text is visible
     */
    public boolean isRemarksTextDisplayed(String remarksText) {
        Locator remarksLocator = page.getByText(remarksText).first();
        return playwright.waitTillLocatorIsVisible(remarksLocator, 5000.0);
    }

    /**
     * click search button on filter section
     */
    public void clickSearchFilterButton(){
        playwright.clickOn(filterButton);
    }

}
