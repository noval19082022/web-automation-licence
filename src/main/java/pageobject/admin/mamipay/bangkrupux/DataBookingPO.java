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
    Locator selectRoom;
    Locator searchRoomInput;
    Locator firstSuggestionRoom;
    Locator nextButton;
    Locator searchTenantDropdown;
    Locator searchTenantInputText;
    Locator searchTenantButton;

    public DataBookingPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.dataBookingMenu = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Data Booking"));
        this.bookingNowButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Booking Now"));
        this.selectRoom = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Room"));
        this.searchRoomInput = page.locator("input[type='search']");
        this.firstSuggestionRoom = page.locator("//li[contains(@class,'highlighted')]");
        this.nextButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("next"));
        this.searchTenantDropdown = page.locator("select#searchTenantCategory");
        this.searchTenantInputText = page.locator("#inputTenant");
        this.searchTenantButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search"));
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
     * the first/highlighted kost name on suggestion will be click
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
    public void searchTenantBy(String type, String value) {
        isSectionTitleVisible("Identity");
        playwright.selectDropdownByValue(searchTenantDropdown, type);
        searchTenantInputText.fill(value);
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
            dialog.message().equals(text);
            dialog.accept();
        });
    }
}
