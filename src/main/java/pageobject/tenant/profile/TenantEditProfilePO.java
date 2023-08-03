package pageobject.tenant.profile;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TenantEditProfilePO {
    Page page;
    PlaywrightHelpers playwright;
    Locator selectedProfession;
    Locator selectedJob;
    Locator professionMahasiswa;
    Locator professionKaryawan;
    Locator universityOrProfessionDropdown;
    Locator saveButton;
    Locator okButton;
    Locator popUpHeadTitle;
    Locator popUpDescriptionContent;
    Locator simpanButton;
    Locator searchTextBox;
    Locator emptyDataMessage;
    Locator closePopup;
    Locator ubahInformasiPenyewa;
    Locator professionLainnya;
    Locator lainnyaField;
    Locator searchTextBoxOnEditProfile;
    Locator profileCard;

    public TenantEditProfilePO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        selectedProfession = page.locator("#profileProfession .bg-c-radio--checked");
        selectedJob = page.getByTestId("inputProfession-jobDetailOptions");
        professionMahasiswa = page.locator("label").filter(new Locator.FilterOptions().setHasText("Mahasiswa"));
        professionKaryawan = page.locator("label").filter(new Locator.FilterOptions().setHasText("Karyawan"));
        universityOrProfessionDropdown = page.locator("//div[@class='bg-c-select']");
        saveButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Simpan"));
        popUpHeadTitle = page.locator("h2[id]");
        popUpDescriptionContent = page.locator("div[id='swal2-content']");
        okButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("OK"));
        simpanButton = page.locator(".hidden-xs.btn-primary");
        searchTextBox = page.getByPlaceholder("Search").first();
        closePopup = page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText("close")).first();
        ubahInformasiPenyewa = page.locator(".booking-form-tenant-info .booking-form-section__action .bg-c-text");
        professionLainnya = page.locator("label").filter(new Locator.FilterOptions().setHasText("Lainnya"));
        lainnyaField = page.getByTestId("jobDescription-input");
        searchTextBoxOnEditProfile = page.getByTestId("inputProfession-jobDetailOptions").getByPlaceholder("Search");
        profileCard = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("chevron-right"));
    }

    /**
     * Get selected profession
     * @return String data type
     */
    public String getSelectedProfessionText() {
        return playwright.getText(selectedProfession);
    }

    /**
     * click on radio mahasiswa
     */
    public void clickOnRadioMahasiswa() {
        playwright.clickOn(professionMahasiswa);
    }

    /**
     * Select university
     * @param name String type university name
     */
    public void selectUniversity(String name) {
        Locator universityName = page.locator("//a[contains(.,'"+ name +"')]");
        playwright.clickOn(universityOrProfessionDropdown);
        playwright.clickOn(universityName);
    }

    /**
     * Click on save button
     */
    public void clickONSaveButton() {
        playwright.clickOn(saveButton);
    }

    /**
     * Click on OK button;
     * @return TenantProfilePO class
     */
    public TenantProfilePO clickOkButton() {
        playwright.clickOn(okButton);
        return new TenantProfilePO(page);
    }

    /**
     * Get pop up title after edit profile success
      * @return String type
     */
    public String getPopUpHeadTitle() {
        return playwright.getText(popUpHeadTitle);
    }

    /**
     * Get pop up description after edit profile success
     * @return String type
     */
    public String getPopUpDescriptionContent() {
        return playwright.getText(popUpDescriptionContent);
    }

    /**
     * Click on radio karyawan
     */
    public void clickOnRadioKaryawan() {
        playwright.clickOn(professionKaryawan);
    }

    /**
     * Select company for karyawan
     * @param companyName String type company name
     */
    public void selectCompany(String companyName){
        Locator company = page.locator("//a[contains(.,'"+ companyName +"')]");
        playwright.clickOn(universityOrProfessionDropdown);
        playwright.clickOn(company);
    }

    /**
     * get text alert on edit profile
     * @return string
     */
    public String getAlertOnProfile(String alert) {
        Locator alertValue = page.locator("//p[contains(.,'"+alert+"')]");
        return playwright.getText(alertValue);
    }

    /**
     * Assert simpan button are disable
     */
    public void assertSimpanButtonDisable(){
        assertThat(simpanButton).isDisabled();
    }

    /**
     * Click dropdown and fill search textbox
     * @param textSearch String type company name or university name
     */
    public void clickOnAndFillDropdown(String textSearch){
        playwright.clickOn(universityOrProfessionDropdown);
        if (playwright.waitTillLocatorIsVisible(searchTextBox, 1000.0)){
            searchTextBox.fill(textSearch);
        }else {
            searchTextBoxOnEditProfile.fill(textSearch);
        }
    }

    /**
     * Get message empty data after input search value
     * @return String type
     */
    public String getMessageEmptyData(String message) {
        emptyDataMessage = page.getByText(message);
        return playwright.getText(emptyDataMessage);
    }

    /**
     * Click close on popup
     *
     */
    public void clickOnClosePopUp(){
        if (playwright.waitTillLocatorIsVisible(closePopup, 1000.0)){
            playwright.clickOn(closePopup);
        }
    }

    /**
     * click on Ubah button
     *
     */
    public void clickOnUbahInformasiPenyewa() {
        ubahInformasiPenyewa.click();
    }


    /**
     * click on Profession button on form booking page
     *
     */
    public void clickOnUbahProfessionTo(String profession) {
        Locator professionRadioFormBooking = page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName(profession));
        professionRadioFormBooking.click();
    }

    /**
     * click on Profession button on edit profile page
     *
     */
    public void clickOnUbahProfessionToOnEditProfile(String profession) {
        Locator professionRadioEditProfile = page.locator("label").filter(new Locator.FilterOptions().setHasText(profession));
        professionRadioEditProfile.click();
    }

    /**
     * Click on radio lainnya
     */
    public void clickOnRadioLainnya() {
        playwright.clickOn(professionLainnya);
    }

    /**
     * Input value in Lainnya field
     * @param lainnya
     */
    public void setLainnyaJobs (String lainnya) {
        lainnyaField.fill(lainnya);
    }

    /**
     * Select company or university
     *
     * @param valueInput String type company or university
     */
    public void selectValueDropdown(String valueInput) {
        Locator dropdownValue = page.locator("//a[contains(.,'" + valueInput + "')]");
        playwright.clickOn(dropdownValue);
    }

    /**
     * Click on profile card
     */
    public void clickOnProfileCard() {
        playwright.clickOn(profileCard);
    }
}
