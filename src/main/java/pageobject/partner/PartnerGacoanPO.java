package pageobject.partner;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import data.mamikos.Mamikos;
import utilities.PlaywrightHelpers;

public class PartnerGacoanPO {
    private Page page;
    private PlaywrightHelpers playwright;

    // Login Page Locators
    private Locator usernameField;
    private Locator passwordField;
    private Locator loginButton;

    // Listing Catalog Locators
    private Locator sortingButton;
    private Locator filterForm;
    private Locator tambahPenyewaButton;
    private Locator kostLinksWithId;
    private Locator kostLinksWithText;
    private Locator kostLinksWithHref;

    // Booking Form Locators
    private Locator phoneNumberField;
    private Locator phoneNumberFieldFallback;
    private Locator tambahButton;
    private Locator tambahButtonRegex;
    private Locator tambahButtonFallback;
    private Locator namaLengkapField;
    private Locator namaLengkapFieldFallback;
    private Locator genderDropdown;
    private Locator selanjutnyaButton;
    private Locator kirimPengajuanSewaButton;
    private Locator ajukanSewaLagiLink;

    // Modal Locators
    private Locator addTenantModal;

    // Logout Locators
    private Locator logoutButton;
    private Locator profileMenu;
    private Locator logoutLink;

    public PartnerGacoanPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        initLocators();
    }

    private void initLocators() {
        // Login Page Locators
        usernameField = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username"));
        passwordField = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password"));
        loginButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("LOGIN"));

        // Listing Catalog Locators
        filterForm = page.locator("#filterForm");
        tambahPenyewaButton = page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText("Tambah Penyewa"));
        kostLinksWithId = page.locator("a").filter(new Locator.FilterOptions().setHasText(java.util.regex.Pattern.compile("^\\[\\d+\\]")));
        kostLinksWithText = page.getByRole(AriaRole.LINK).filter(new Locator.FilterOptions().setHasText("Kost"));
        kostLinksWithHref = page.locator("a[href*='kost']");

        // Booking Form Locators - Primary
        phoneNumberField = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Contoh:"));
        phoneNumberFieldFallback = page.locator("input[type='text'], input[type='tel']");
        tambahButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Tambah").setExact(true));
        tambahButtonRegex = page.locator("button").filter(new Locator.FilterOptions().setHasText(java.util.regex.Pattern.compile("^\\s*Tambah\\s*$")));
        tambahButtonFallback = page.locator("#btnAddPhone, button[type='submit']");
        namaLengkapField = page.locator("//input[@placeholder='Masukkan nama lengkap']");
        namaLengkapFieldFallback = page.locator("input[placeholder*='nama'], input[name*='name']");
        genderDropdown = page.getByRole(AriaRole.COMBOBOX);
        selanjutnyaButton = page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText("Selanjutnya"));
        kirimPengajuanSewaButton = page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText("Kirim Pengajuan Sewa"));
        ajukanSewaLagiLink = page.getByRole(AriaRole.LINK).filter(new Locator.FilterOptions().setHasText("Ajukan Sewa Lagi"));

        // Modal Locators
        addTenantModal = page.locator("#addTenantModal.show, #addTenantModal[style*='block'], .modal.show");

        // Logout Locators
        logoutButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Logout"));
        profileMenu = page.locator(".dropdown-toggle, .user-menu, .profile-menu");
        logoutLink = page.getByText("Logout");
    }

    /**
     * Navigate to partner portal page
     */
    public void navigateToPartnerPortal() {
        playwright.navigateTo(Mamikos.URL + Mamikos.PARTNER_PORTAL_URL);
        playwright.waitTillPageLoaded();
    }

    /**
     * Fill username field
     * @param username username to fill
     */
    public void fillUsername(String username) {
        playwright.clickOn(usernameField);
        playwright.fill(usernameField, username);
    }

    /**
     * Fill password field
     * @param password password to fill
     */
    public void fillPassword(String password) {
        playwright.clickOn(passwordField);
        playwright.fill(passwordField, password);
    }

    /**
     * Click login button
     */
    public void clickLogin() {
        playwright.clickOn(loginButton);
        playwright.waitTillPageLoaded();
    }

    /**
     * Login to partner portal
     * @param username username
     * @param password password
     */
    public void login(String username, String password) {
        fillUsername(username);
        fillPassword(password);
        clickLogin();
    }

    /**
     * Check if listing catalog is visible
     * @return true if visible
     */
    public boolean isListingCatalogVisible() {
        return playwright.waitTillLocatorIsVisible(filterForm);
    }

    /**
     * Click on sorting button by name
     * @param sortingName sorting button name (e.g., "Direkomendasikan", "Harga Terendah", "Harga Tertinggi")
     */
    public void clickSortingButton(String sortingName) {
        Locator button = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" " + sortingName + " "));
        playwright.clickOn(button);
    }

    /**
     * Click on sorting option text
     * @param optionText sorting option text
     */
    public void clickSortingOption(String optionText) {
        playwright.clickOnText(optionText);
    }

    /**
     * Click on filter form to close dropdown
     */
    public void clickFilterForm() {
        playwright.clickOn(filterForm);
    }

    /**
     * Select sorting option
     * @param currentSort current sorting name
     * @param newSort new sorting option to select
     */
    public void selectSorting(String currentSort, String newSort) {
        clickSortingButton(currentSort);
        clickSortingOption(newSort);
        clickFilterForm();
    }

    /**
     * Click on kost listing by name
     * @param kostName kost name to click
     */
    public void clickKostListing(String kostName) {
        Locator kostLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(kostName));
        playwright.clickOn(kostLink);
        playwright.waitTillPageLoaded();
    }

    /**
     * Get first kost link from listing dynamically
     * @return first kost locator from the listing
     */
    public Locator getFirstKostLink() {
        playwright.waitTillPageLoaded();
        playwright.hardWait(2000);

        // Find link with pattern like "[12345] Kost Name" - these are the kost listing links
        if (kostLinksWithId.count() > 0 && playwright.waitTillLocatorIsVisible(kostLinksWithId.first(), 3000.0)) {
            return kostLinksWithId.first();
        }

        // Fallback - find link containing "Kost" text
        if (kostLinksWithText.count() > 0) {
            return kostLinksWithText.first();
        }

        // Last fallback - any link with href containing 'kost'
        return kostLinksWithHref.first();
    }

    /**
     * Click on first kost listing
     */
    public void clickFirstKostListing() {
        playwright.hardWait(1000);
        Locator firstKost = getFirstKostLink();
        playwright.waitFor(firstKost, 5000.0);
        playwright.clickOn(firstKost);
        playwright.waitTillPageLoaded();
        playwright.hardWait(2000); // Additional wait for page content to load
    }

    /**
     * Check if booking form is visible
     * @return true if Tambah Penyewa button is visible
     */
    public boolean isBookingFormVisible() {
        playwright.hardWait(2000); // Wait for page to fully load
        playwright.waitTillPageLoaded();
        return playwright.isLocatorVisibleAfterLoad(tambahPenyewaButton, 5000.0);
    }

    /**
     * Click Tambah Penyewa button
     */
    public void clickTambahPenyewa() {
        playwright.clickOn(tambahPenyewaButton);
    }

    /**
     * Fill phone number field
     * @param phoneNumber phone number to fill
     */
    public void fillPhoneNumber(String phoneNumber) {
        playwright.clickOn(phoneNumberField);
        playwright.fill(phoneNumberField, phoneNumber);
    }

    /**
     * Click Tambah button
     */
    public void clickTambahButton() {
        playwright.clickOn(tambahButton);
    }

    /**
     * Fill nama lengkap field
     * @param name name to fill
     */
    public void fillNamaLengkap(String name) {
        playwright.clickOn(namaLengkapField);
        playwright.fill(namaLengkapField, name);
    }

    /**
     * Select gender from dropdown
     * @param gender gender value (e.g., "male", "female")
     */
    public void selectGender(String gender) {
        playwright.selectDropdownByValue(genderDropdown, gender);
    }

    /**
     * Click Selanjutnya button
     */
    public void clickSelanjutnya() {
        playwright.clickOn(selanjutnyaButton);
    }

    /**
     * Click Kirim Pengajuan Sewa button
     */
    public void clickKirimPengajuanSewa() {
        playwright.clickOn(kirimPengajuanSewaButton);
    }

    /**
     * Click Ajukan Sewa Lagi link
     */
    public void clickAjukanSewaLagi() {
        playwright.clickOn(ajukanSewaLagiLink);
    }

    /**
     * Check if Kirim Pengajuan Sewa button is visible
     * @return true if visible
     */
    public boolean isKirimPengajuanSewaButtonVisible() {
        return playwright.waitTillLocatorIsVisible(kirimPengajuanSewaButton);
    }

    /**
     * Check if Ajukan Sewa Lagi link is visible (booking success)
     * @return true if visible
     */
    public boolean isAjukanSewaLagiLinkVisible() {
        return playwright.waitTillLocatorIsVisible(ajukanSewaLagiLink);
    }

    /**
     * Fill all required booking form fields
     * @param phoneNumber phone number
     * @param name tenant name
     * @param gender gender value
     */
    public void fillBookingForm(String phoneNumber, String name, String gender) {
        // Wait for modal to be visible
        playwright.waitFor(addTenantModal.first(), 5000.0);
        playwright.hardWait(1500);

        // Fill phone number - use primary locator, fallback if not visible
        Locator phoneInput = phoneNumberField;
        if (!playwright.waitTillLocatorIsVisible(phoneInput, 2000.0)) {
            phoneInput = phoneNumberFieldFallback.first();
        }
        playwright.clickOn(phoneInput);
        playwright.clickLocatorAndTypeKeyboard(phoneInput, phoneNumber);

        // Click Tambah button - try primary, then regex, then fallback
        Locator addButton = tambahButton;
        if (!playwright.waitTillLocatorIsVisible(addButton, 2000.0)) {
            addButton = tambahButtonRegex;
        }
        if (!playwright.waitTillLocatorIsVisible(addButton, 2000.0)) {
            addButton = tambahButtonFallback.first();
        }
        playwright.clickOn(addButton);
        playwright.hardWait(1500);

        // Fill name field - use primary locator, fallback if not visible
        Locator namaInput = namaLengkapField;
        if (!playwright.waitTillLocatorIsVisible(namaInput, 2000.0)) {
            namaInput = namaLengkapFieldFallback.first();
        }
        if (playwright.waitTillLocatorIsVisible(namaInput, 3000.0)) {
            playwright.clickOn(namaInput);
            playwright.forceFill(namaInput, name);

            // Select gender
            if (playwright.waitTillLocatorIsVisible(genderDropdown, 2000.0)) {
                playwright.selectDropdownByValue(genderDropdown, gender);
            }
        }
    }

    /**
     * Submit booking form
     */
    public void submitBooking() {
        clickSelanjutnya();
        playwright.hardWait(1000);
        clickKirimPengajuanSewa();
    }

    /**
     * Logout from partner portal
     */
    public void logout() {
        if (playwright.waitTillLocatorIsVisible(logoutButton)) {
            playwright.clickOn(logoutButton);
        } else {
            // Try alternative logout method - click on profile menu first
            if (playwright.waitTillLocatorIsVisible(profileMenu.first())) {
                playwright.clickOn(profileMenu.first());
                playwright.hardWait(500);
                playwright.clickOn(logoutLink);
            }
        }
        playwright.waitTillPageLoaded();
    }
}
