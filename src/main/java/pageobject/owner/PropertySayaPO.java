package pageobject.owner;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

public class PropertySayaPO {
    private Page page;
    private PlaywrightHelpers playwright;
    Locator kostDropdown;
    Locator searchKostTextbox;
    Locator lihatSelengkapnyaButton;
    Locator updateKamarButton;
    Locator editAction;
    Locator updateKamarCheckbox;
    Locator updateKamarButtonPopup;
    Locator firstKosNameLabel;
    Locator firstKosStatusLabel;
    Locator firstKosTypeLabel;
    Locator kostNameText;
    Locator seeOtherPriceButton;
    Locator priceKostTextBox;
    Locator continueInputDataButton;
    Locator updatePriceButton;
    Locator messageSuccessUpdatePrice;
    Locator firstSeeKosButton;
    Locator statisticChoiceSelection;
    Locator chatButton;
    Locator reviewButton;
    Locator addRoomButton;
    Locator roomNameField;
    Locator textTotalRoom;
    Locator firstDeleteButton;
    Locator deleteButtonInPopUp;
    Locator icnClose;
    Locator optionProperty;
    Locator addDataButton;
    Locator addNewKosButton;
    Locator closePopupBBKIcon;
    Locator fullnameTextbox;
    Locator bankAccountNumberTextbox;
    Locator bankOwnerNameTextbox;
    Locator bankNameDropdown;
    Locator termAndConsCheckbox;
    Locator submitDataMamipayButton;
    Locator backButtonActivationSent;
    Locator editDataKos;
    Locator fasilitasFeature;
    Locator editSelesaiButton;
    Locator titleSuccessEditPopUpText;
    Locator doneButtonEditKosPopUp;
    Locator locationTextBox;
    Locator locationAutoComplete;
    Locator addressNotesInput;
    Locator promoNgebutLabel;
    Locator closeInfobarButton;
    Locator priceKostTextBoxDisable;

    public PropertySayaPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        kostDropdown = page.getByText("Cari kos Anda disini...");
        searchKostTextbox = page.getByPlaceholder("Search");
        lihatSelengkapnyaButton = page.getByText("Lihat Selengkapnya").first();
        updateKamarButton = page.getByText("Update Kamar", new Page.GetByTextOptions().setExact(true));
        editAction = page.locator("(//*[@class='room-table__cta bg-c-icon bg-c-icon--md'])[1]");
        updateKamarCheckbox = page.locator("span").filter(new Locator.FilterOptions().setHasText("checkmark")).locator("svg");
        updateKamarButtonPopup = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Simpan"));
        firstKosNameLabel = page.locator(".owner-kos-list > div:nth-of-type(1) .kos-card__title > .text");
        seeOtherPriceButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat harga lainnya"));
        priceKostTextBox = page.locator("//*[@class='input property-room__price-item-input-currency satu']");
        continueInputDataButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lanjut Isi Data"));
        updatePriceButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Update Harga"));
        messageSuccessUpdatePrice = page.getByText("Harga berhasil diupdate");
        firstSeeKosButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Lihat Kos"));
        statisticChoiceSelection = page.locator(".statistic__choice");
        chatButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Chat 0"));
        reviewButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Review 0"));
        addRoomButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Tambahkan Kamar"));
        roomNameField = page.getByLabel("Nama/ Nomor Kamar");
        textTotalRoom = page.locator(".room-table__total-room-label");
        firstDeleteButton = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("delete")).first();
        deleteButtonInPopUp = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hapus"));
        icnClose = page.locator("a").filter(new Locator.FilterOptions().setHasText("close"));
        addDataButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tambahkan Data"));
        addNewKosButton= page.getByText("+ Tambah Kos Baru");
        closePopupBBKIcon = page.locator(".owner-intercept-booking-modal__close-button");
        fullnameTextbox = page.getByPlaceholder("Masukkan nama lengkap");
        bankAccountNumberTextbox = page.getByPlaceholder("Masukkan nomor rekening Anda");
        bankOwnerNameTextbox = page.getByPlaceholder("Masukkan nama pemilik rekening");
        bankNameDropdown = page.getByPlaceholder("Masukkan nama bank");
        termAndConsCheckbox= page.locator(".check");
        submitDataMamipayButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kirim Data"));
        backButtonActivationSent = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kembali"));
        editSelesaiButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Edit Selesai"));
        titleSuccessEditPopUpText = page.locator(".bg-c-modal__body-title");
        doneButtonEditKosPopUp = page.locator(".bg-c-button--md.bg-c-button--primary");
        locationTextBox = page.getByTestId("mamikosInput");
        addressNotesInput = page.getByRole(AriaRole.TEXTBOX).nth(2);
        promoNgebutLabel = page.locator(".media-content");
        closeInfobarButton = page.locator(".delete");
        priceKostTextBoxDisable = page.locator("//*[@class='input property-room__price-item-input-currency satu --disabled']");
    }

    /**
     * user as owner click kost dropdown
     * user enter kost name
     * user choose kost name
     */
    public void searchKostPropertySaya(String kostName){
        playwright.clickOn(kostDropdown);
        searchKostTextbox.fill(kostName);
        Locator kostSearch = page.locator("a").filter(new Locator.FilterOptions().setHasText(kostName)).first();
        playwright.clickOn(kostSearch);
    }

    /**
     * user as owner click update kamar button
     *
     */
    public void clickUpdateKamarButton() {
        playwright.clickOn(lihatSelengkapnyaButton);
        playwright.clickOn(updateKamarButton);
    }

    /**
     * user as owner click update kamar kost button
     *
     */
    public void clickUpdateKamarEmptyButton() {
        playwright.waitTillLocatorIsVisible(editAction);
        playwright.clickOn(editAction);
        if (updateKamarCheckbox.isChecked()) {
            playwright.clickOn(updateKamarCheckbox);
            playwright.clickOn(updateKamarButtonPopup);
        }
    }

    /**
     * Get first kos name in kos list
     * @return string kos name
     */
    public String getFirstKosName() {
        return playwright.getText(firstKosNameLabel);
    }

    /**
     * Get first kos status in kos list
     * @return string kos status
     */
    public String getFirstKosStatus(String status) {
        firstKosStatusLabel = page.getByText(status).first();
        return playwright.getText(firstKosStatusLabel);
    }

    /**
     * Get first kos type in kos list
     * @return string kos type
     */
    public String getFirstKosType(String type) {
        firstKosTypeLabel = page.getByText(type).first();
        return playwright.getText(firstKosTypeLabel);
    }

    /**
     * Click on kos name in update price
     * @param kosName is kos name
     */
    public void clickOnKosName(String kosName) {
        kostNameText = page.locator("//span[.='"+kosName+"']");
        playwright.clickOn(kostNameText);
    }

    /**
     * Click on see other price button
     */
    public void clickSeeOtherPrices() {
        playwright.clickOn(seeOtherPriceButton);
    }

    /**
     * Enter Text in daily price text box
     * @param dailyPrice is text we want to search
     */
    public void inputDailyPriceKos(String dailyPrice) {
        priceKostTextBox.nth(1).clear();
        priceKostTextBox.nth(1).fill(dailyPrice);
    }

    /**
     * Enter Text in weekly price text box
     * @param weeklyPrice is text we want to search
     */
    public void inputWeeklyPrice(String weeklyPrice) {
        priceKostTextBox.nth(2).clear();
        priceKostTextBox.nth(2).fill(weeklyPrice);
    }

    /**
     * Enter Text in monthly price text box
     * @param monthlyPrice is text we want to search
     */
    public void inputMonthlyPrice(String monthlyPrice) {
        priceKostTextBox.first().clear();
        priceKostTextBox.first().fill(monthlyPrice);
    }

    /**
     * Enter Text in three monthly price text box
     * @param threeMonthlyPrice is text we want to search
     */
    public void inputThreeMonthlyPrice(String threeMonthlyPrice) {
        priceKostTextBox.nth(3).clear();
        priceKostTextBox.nth(3).fill(threeMonthlyPrice);
    }

    /**
     * Enter Text in six monthly price text box
     * @param sixMonthlyPrice is text we want to search
     */
    public void inputSixMonthlyPrice(String sixMonthlyPrice) {
        priceKostTextBox.nth(4).clear();
        priceKostTextBox.nth(4).fill(sixMonthlyPrice);
    }

    /**
     * Enter Text yearly price text box
     * @param yearlyPrice is text we want to search
     */
    public void inputYearlyPrice(String yearlyPrice) {
        priceKostTextBox.nth(5).clear();
        priceKostTextBox.nth(5).fill(yearlyPrice);
    }

    /**
     * Get text price daily
     *
     * @return Integer daily price
     */
    public int getDailyPrice() {
        return JavaHelpers.extractNumber(playwright.getInputValue(priceKostTextBox.nth(1)));
    }

    /**
     * Get text price weekly
     * @return Integer weekly price
     */
    public int getWeeklyPrice() {
        return JavaHelpers.extractNumber(playwright.getInputValue(priceKostTextBox.nth(2)));
    }

    /**
     * Get text price monthly
     * @return Integer monthly price
     */
    public int getMonthlyPrice() {
        return JavaHelpers.extractNumber(playwright.getInputValue(priceKostTextBox.first()));
    }

    /**
     * Get text price three monthly
     * @return Integer three monthly price
     */
    public int getThreeMonthlyPrice() {
        return JavaHelpers.extractNumber(playwright.getInputValue(priceKostTextBox.nth(3)));
    }

    /**
     * Get text price six monthly
     * @return Integer six monthly price
     */
    public int getSixMonthlyPrice() {
        return JavaHelpers.extractNumber(playwright.getInputValue(priceKostTextBox.nth(4)));
    }

    /**
     * Get text price yearly
     * @return Integer yearly price
     */
    public int getYearlyPrice() {
        return JavaHelpers.extractNumber(playwright.getInputValue(priceKostTextBox.nth(5)));
    }

    /**
     * Click 'Lanjut Isi Data' in attention pop up
     */
    public void clickContinueInputDataPopUp() {
        if (playwright.waitTillLocatorIsVisible(continueInputDataButton)){
            playwright.clickOn(continueInputDataButton);
        }
    }

    /**
     * Click on update button
     */
    public void clickButtonUpdate() {
        playwright.pageScrollUntilElementIsVisible(updatePriceButton);
        playwright.clickOn(updatePriceButton);
    }

    /**
     * Get message success update price
     * @return message success update price
     */
    public String getToastSuccessUpdatePrice() {
        return playwright.getText(messageSuccessUpdatePrice);
    }

    /**
     * Click on see kos button in first kos list
     */
    public void clickFirstSeeKos() {
        playwright.clickOn(firstSeeKosButton);
    }

    /**
     * Click on lihat selengkapnya button in first kos list
     */
    public void clickOnLihatSelengkapnyaButton() {
        playwright.clickOn(lihatSelengkapnyaButton);
    }

    /**
     * Click on chat button in kos list
     */
    public void clickChat() {
        playwright.clickOn(chatButton);
    }

    /**
     * Click on review button in kos list
     */
    public void clickReview() {
        playwright.clickOn(reviewButton);
    }

    /**
     * Click on add room button in room allotment
     * Fill room name field with text
     * Click on update room button in pop up
     */
    public void addRoom(String roomName) {
        playwright.clickOn(addRoomButton);
        roomNameField.fill(roomName);
        playwright.clickOn(updateKamarButtonPopup);
    }

    /**
     * Get number of total room
     */
    public String getTextTotalRoom() {
        playwright.hardWait(3000.0);
        return playwright.getText(textTotalRoom);
    }

    /**
     * click on Delete Room Icon
     */
    public void clickOnFirstDeleteRoomIcon() {
        playwright.hardWait(3000.0);
        playwright.clickOn(firstDeleteButton);
        playwright.clickOn(deleteButtonInPopUp);
    }

    /**
     * Click icon close on page Pilih Jenis Properti
     */
    public void clickOnIconClose() {
        playwright.clickOn(icnClose);
    }

    /**
     * Click on radio button "Kos" or "Apartemen"
     * Click on add data button
     */
    public void selectOptionAddProperty(String option) {
        optionProperty = page.locator("//label[contains(.,'"+option+"')]");
        playwright.clickOn(optionProperty);
        playwright.clickOn(addDataButton);
    }

    /**
     * Click on add new kos button
     */
    public void clickAddNewKos() {
        playwright.clickOn(addNewKosButton);
    }

    /**
     * Click on close at pop up BBL
     */
    public void clickClosePopUpBBK() {
        if (playwright.waitTillLocatorIsVisible(closePopupBBKIcon)){
            playwright.clickOn(closePopupBBKIcon);
        }
    }

    /**
     * Get Full Name inputted text in Mamipay Form
     * @return String Full Name inputted text
     */
    public String getInputTextFullName() {
        return playwright.getInputValue(fullnameTextbox);
    }

    /**
     * Get Bank account number inputted text in Mamipay Form
     * @return String Bank account number inputted text
     */
    public String getInputTextBankAcc() {
        return playwright.getInputValue(bankAccountNumberTextbox);
    }

    /**
     * Get Bank owner name inputted text in Mamipay Form
     * @return String Bank owner name inputted text
     */
    public String getInputTextBankOwnerName() {
        return playwright.getInputValue(bankOwnerNameTextbox);
    }

    /**
     * Get Bank name inputted text in Mamipay Form
     * @return String Bank name inputted text
     */
    public String getInputTextBankName() {
        return playwright.getInputValue(bankNameDropdown);
    }

    /**
     * Fill out Full Name
     * @param fullName
     */
    public void fillInputNameForm(String fullName) {
        playwright.clearText(fullnameTextbox);
        playwright.clickLocatorAndTypeKeyboard(fullnameTextbox, fullName);
    }

    /**
     * Fill out Bank Account Number Form
     * @param bankAccountNumber bank account number
     */
    public void fillBankAccountNumberForm(String bankAccountNumber) {
        playwright.clearText(bankAccountNumberTextbox);
        playwright.clickLocatorAndTypeKeyboard(bankAccountNumberTextbox, bankAccountNumber);
    }

    /**
     * Fill out Bank Account Name Form
     * @param bankAccountName bank account name
     */
    public void fillBankAccountNameForm(String bankAccountName) {
        playwright.clearText(bankOwnerNameTextbox);
        playwright.clickLocatorAndTypeKeyboard(bankOwnerNameTextbox, bankAccountName);
    }

    /**
     * Fill out Bank Name
     * @param bankName
     */
    public void fillInputBankName(String bankName) {
        playwright.clickOn(bankNameDropdown);
        playwright.clearText(bankNameDropdown);
        playwright.clickLocatorAndTypeKeyboard(bankNameDropdown, bankName);
        Locator element = page.locator("a").filter(new Locator.FilterOptions().setHasText(bankName));
        playwright.clickOn(element);
    }

    /**
     * Click on the term and conditions checkbox
     */
    public void clickTermsAndConsCheckbox() {
        playwright.clickOn(termAndConsCheckbox);
    }

    /**
     * Click on Submit mamipay datd
     */
    public void clickSubmitButtonMamipay() {
        playwright.clickOn(submitDataMamipayButton);
        playwright.clickOn(backButtonActivationSent);
    }

    /**
     * Click button edit kost
     * @param dataKos which part to edit
     */
    public void clickEditDataKos(String dataKos) {
        page.waitForLoadState(LoadState.LOAD);
        editDataKos = page.locator("//span[contains(.,'"+dataKos+"')]/following-sibling::span");
        playwright.clickOn(editDataKos);
    }

    /**
     * Click facilities checkbox
     * @param section  is facility section, example "Fasilitas Umum"
     * @param facility is facility name
     */
    public void clickFacilitiesCheckbox(String section, String facility) {
        fasilitasFeature = page.locator("//h4[contains(., '"+section+"')]/following::div//span[contains(text(), '"+facility+"')]").first();
        playwright.pageScrollUntilElementIsVisible(fasilitasFeature);
        playwright.clickOn(fasilitasFeature);
    }

    /**
     * Verify button edit finish is disabled
     * @return true if disabled
     */
    public boolean isEditFinishedButtonDisabled() {
        return editSelesaiButton.isDisabled();
    }

    /**
     * Click on edit done in add kos form page
     */
    public void clickEditDoneButton() {
        playwright.hardWait(2000.0);
        playwright.clickOn(editSelesaiButton);
    }

    /**
     * Get warning title in certain facility
     * @param facility is facility section
     * @return error message title
     */
    public String getWarningTitleFacility(String facility) {
        Locator element = page.locator("//h4[contains(text(), '" + facility + "')]/following-sibling::div[1]//p[1]").first();
        playwright.pageScrollUntilElementIsVisible(element);
        return playwright.getText(element);
    }

    /**
     * Get warning description in certain facility
     * @param facility is facility section
     * @return error message description
     */
    public String getWarningDescFacility(String facility) {
        Locator element = page.locator("//h4[contains(text(), '" + facility + "')]/following-sibling::div[1]//p[2]").first();
        playwright.pageScrollUntilElementIsVisible(element);
        return playwright.getText(element);
    }

    /**
     * Get title for success edit pop up
     * @return String pop up title
     */
    public String getTitlePopUpSuccessEditKos() {
        return playwright.getText(titleSuccessEditPopUpText);
    }

    /**
     * Click 'Done' in success edit kos pop up
     */
    public void clickDoneEditKosPopUp() {
        playwright.clickOn(doneButtonEditKosPopUp);
    }

    /**
     * Input kost location in create kost page
     */
    public void insertKosLocation(String locationName) {
        playwright.hardWait(3000.0);
        page.onDialog(dialog -> {
            System.out.println(String.format("Allow", dialog.message()));
            dialog.dismiss();
        });
        playwright.clickOn(locationTextBox);
        playwright.fill(locationTextBox,locationName);
    }

    /**
     * Click on the first autocomplete result
     */
    public void clickOnFirstResult(String location) {
        locationAutoComplete = page.getByText(location).first();
        playwright.clickOn(locationAutoComplete);
    }

    /**
     * Enter address notes
     * @param notes is address notes
     */
    public void enterAddressNotes(String notes) {
        playwright.pageScrollUntilElementIsVisible(addressNotesInput);
        playwright.clearText(addressNotesInput);
        playwright.fill(addressNotesInput,notes);
    }

    /**
     * Get text in promo ngebut infobar
     * @return String promo ngebut info
     */
    public String getPromoNgebutInfo() {
        return playwright.getText(promoNgebutLabel);
    }

    /**
     * Verify if monthly price field is enable
     * @return true if enable
     */
    public boolean isMonthlyPriceFieldDisable() {
        return playwright.isButtonDisable(priceKostTextBoxDisable.first());
    }

    /**
     * Click close infobar button
     */
    public void clickCloseInfobar() {
        playwright.clickOn(closeInfobarButton);
    }

}
