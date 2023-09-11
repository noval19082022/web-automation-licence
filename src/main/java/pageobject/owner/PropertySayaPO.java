package pageobject.owner;

import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import lombok.Getter;
import lombok.Setter;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;
import java.nio.file.Paths;

public class PropertySayaPO {
    private Page page;
    private PlaywrightHelpers playwright;
    @Setter @Getter private String searchPropertyName;
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
    Locator modalPopUp;
    Locator statusKos;
    Locator warningPrice;
    Locator tambahDataIklan;
    Locator tambahIklanBaru;
    Locator jenisPropertiRadioButton;
    Locator propertyNameField;
    Locator unitNameField;
    Locator unitNumberField;
    Locator unitTypeField;
    Locator floorPropertyField;
    Locator unitSizeField;
    Locator priceTypeCheckBox;
    Locator priceApartementField;
    Locator uploadCoverPhotoField;
    Locator uploadPhotoApartement;
    Locator gantiFotoButton;
    Locator editDataApartemenLink;
    Locator statusApartement;
    Locator apartDropdown;
    Locator selesaiLink;
    Locator descriptionField;

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
        modalPopUp = page.locator("//div[@class='modal-content']");
        statusKos = page.locator(".kos-card__status-name--kos-verified");
        tambahDataIklan = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Tambahkan Data Iklan"));
        tambahIklanBaru = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tambah Iklan Baru"));
        propertyNameField = page.locator("//input[@id='propertyName']");
        unitNameField = page.locator("//input[@name='Nama unit']");
        unitNumberField = page.locator("//input[@name='Nomor unit']");
        unitTypeField = page.locator("//select[@id='unitType']");
        floorPropertyField = page.locator("//input[@id='propertyFloor']");
        unitSizeField = page.locator("//input[@id='unitSize']");
        uploadCoverPhotoField = page.locator("//div[@id='photoCover']");
        gantiFotoButton = page.locator("//a[.='Ganti Foto']");
        apartDropdown = page.getByText("Cari apartemen Anda disini...");
        selesaiLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("SELESAI"));
        descriptionField = page.locator("//textarea[@id='propertyDescription']");
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
    public String getDailyPrice() {
        int number = JavaHelpers.extractNumber(playwright.getInputValue(priceKostTextBox.nth(1)));
        return String.valueOf(number);
    }

    /**
     * Get text price weekly
     * @return Integer weekly price
     */
    public String getWeeklyPrice() {
        int number = JavaHelpers.extractNumber(playwright.getInputValue(priceKostTextBox.nth(2)));
        return String.valueOf(number);
    }

    /**
     * Get text price monthly
     * @return Integer monthly price
     */
    public String getMonthlyPrice() {
        int number = JavaHelpers.extractNumber(playwright.getInputValue(priceKostTextBox.first()));
        return String.valueOf(number);
    }

    /**
     * Get text price three monthly
     * @return Integer three monthly price
     */
    public String getThreeMonthlyPrice() {
        int number = JavaHelpers.extractNumber(playwright.getInputValue(priceKostTextBox.nth(3)));
        return String.valueOf(number);
    }

    /**
     * Get text price six monthly
     * @return Integer six monthly price
     */
    public String getSixMonthlyPrice() {
        int number = JavaHelpers.extractNumber(playwright.getInputValue(priceKostTextBox.nth(4)));
        return String.valueOf(number);
    }

    /**
     * Get text price yearly
     * @return Integer yearly price
     */
    public String getYearlyPrice() {
        int number = JavaHelpers.extractNumber(playwright.getInputValue(priceKostTextBox.nth(5)));
        return String.valueOf(number);
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

    /**
     * Verify Pop up modal visible
     * @return boolean true, false
     */
    public boolean isPopUpModalVisible() {
        return playwright.isLocatorVisibleAfterLoad(modalPopUp, 3000.0);
    }

    /**
     * Verify status kos
     * @return statusKos
     */
    public boolean isStatusKos() {
        return playwright.waitTillLocatorIsVisible(statusKos, 3000.0);
    }

    /**
     * Get text warning price daily, weekly, monthly, three monthly,six monthly, yearly price
     * @return String warning daily, weekly, monthly, three monthly,six monthly, yearly price
     */
    public String getWarningYearlyPrice(Integer i) {
        warningPrice = page.locator(".media-content");
        return playwright.getText(warningPrice.nth(i));
    }

    /**
     * Check if button update price is disable
     * @return true if disable
     */
    public boolean isButtonUpdatePriceDisable() {
        return updatePriceButton.isDisabled();
    }

    /**
     * Click tambah data iklan -> tambah iklan baru -> choose add kos or apartement
     * @param jenisProperti
     * e.g Kost, Apartemen
     *
     */
    public void clickTambahDataIklan(String jenisProperti) {
        playwright.clickOn(tambahDataIklan);
        playwright.clickOn(tambahIklanBaru);
        jenisPropertiRadioButton = page.locator("#ownerModalAdd").getByText(jenisProperti);
        playwright.waitTillLocatorIsVisible(jenisPropertiRadioButton, 3000.0);
        playwright.clickOn(jenisPropertiRadioButton);
        playwright.clickOnTextButton("Tambahkan Data", 3000.0);
    }

    /**
     * Input property name
     * @param propertyName
     * Can use add and edit
     * If edit nama project field doesn't appear
     *
     */
    public void inputPropertyName(String propertyName) {
        if (propertyNameField.isVisible()) {
            playwright.forceFill(propertyNameField, propertyName);
        }
    }

    /**
     * Input nama unit apartemen
     * @param namaUnit
     *
     */
    public void inputNamaUnit(String namaUnit) {
        playwright.forceFill(unitNameField, namaUnit);
    }

    /**
     * Input nomor unit
     * @param nomorUnit
     *
     */
    public void inputNoUnit(String nomorUnit) {
        playwright.forceFill(unitNumberField, nomorUnit);
    }

    /**
     * Select tipe unit
     * @param tipeUnit
     * e.g 1-Room Studio, 2 BR, 3 BR, 4 BR, Lainnya
     *
     */
    public void selectUnitType(String tipeUnit) {
        playwright.selectDropdownByValue(unitTypeField, tipeUnit);
    }

    /**
     * input lantai apartemen
     * @param lantai
     *
     */
    public void inputLantai(String lantai) {
        playwright.forceFill(floorPropertyField, lantai);
    }

    /**
     * Input unit size
     * @param luasUnit
     *
     */
    public void inputUnitSize(String luasUnit) {
        playwright.forceFill(unitSizeField, luasUnit);
    }

    /**
     * Select price type
     * @param priceType
     *
     */
    public void selectPriceType(String priceType) {
        priceTypeCheckBox = page.locator("label").filter(new Locator.FilterOptions().setHasText(priceType));
        playwright.clickOn(priceTypeCheckBox);
    }

    /**
     * Input apartemen price
     * After check price type, then input the price
     * @param priceType e.g Perhari, Perminggu, Perbulan, Pertahun
     * @param price
     *
     */
    public void inputApartementPrice(String priceType, String price) {
        String element;
        switch (priceType){
            case "Perhari": element = "Daily"; break;
            case "Perminggu": element = "Weekly"; break;
            case "Perbulan": element = "Monthly"; break;
            case "Pertahun": element = "Yearly"; break;
            default:
                throw new IllegalStateException("Unexpected value: " + priceType);
        }
        priceApartementField = page.locator("//input[@id='inputPrice"+element+"']");
        playwright.waitTillLocatorIsVisible(priceApartementField, 3000.0);
        playwright.forceFill(priceApartementField, price);
    }

    /**
     * Select fasilitas unit
     * @param fasilitasUnit
     *
     */
    public void selectFasilitasUnit(String fasilitasUnit) {
        String element = "//label[contains(.,'"+ fasilitasUnit +"')]";
        playwright.clickOn(page.locator(element));
    }

    /**
     * Select fasilitas kamar
     * @param fasilitasKamar
     */
    public void selectFasilitasKamar(String fasilitasKamar) {
        String element = "";
        switch (fasilitasKamar){
            case "Not Furnished": element = "[for='isFurnished0']"; break;
            case "Semi Furnished": element = "[for='isFurnished1']"; break;
            case "Furnished": element = "[for='isFurnished2']"; break;
        }
        playwright.clickOn(page.locator(element));
    }

    /**
     * Upload phoyo cover apartemen
     * Photo can't > 5mb
     *
     */
    public void uploadCoverPhotoApartemen() {
        String imagePath = "src/main/resources/images/upload5Mb.jpg";
        FileChooser fileChooser = page.waitForFileChooser(() -> uploadCoverPhotoField.click());
        fileChooser.setFiles(Paths.get(imagePath));
        playwright.waitTillLocatorIsVisible(uploadCoverPhotoField);
        playwright.hardWait(3000);
    }

    /**
     * Upload photo apartemen
     * @param photoType e.g photo kamar, kamar mandi, dan lainnya
     * photo can't > 5mb
     */
    public void uploadPhotoApartemen(String photoType) {
        String element = "";
        switch (photoType){
            case "kamar": element = "Bedroom"; break;
            case "kamar mandi": element = "Bath"; break;
            case "lainnya": element = "Other"; break;
        }
        uploadPhotoApartement = page.locator("//div[@id='photo"+element+"']");

        String imagePath = "src/main/resources/images/upload5Mb.jpg";
        FileChooser fileChooser = page.waitForFileChooser(() -> uploadPhotoApartement.click());
        fileChooser.setFiles(Paths.get(imagePath));
        playwright.waitTillLocatorIsVisible(uploadPhotoApartement);
        playwright.hardWait(3000);
    }

    /**
     * Select property name
     * After owner input property name, will be display dropdown suggestion of property name
     *
     */
    public void selectPropertyName(String namaProject) {
        if (propertyNameField.isVisible()) {
            playwright.clickOnText(namaProject);
        }
    }

    /**
     * Click furniture if check fasilitas kamar is semi furnished and furnished
     * @param furniture
     *
     */
    public void clickFurnished(String furniture) {
        playwright.clickOnText(furniture);
    }

    /**
     * Click edit apartemen link
     * Property name from getSearchPropertyName
     *
     */
    public void clickEditDataApartemen() {
        editDataApartemenLink = page.locator("//p[contains(., '"+getSearchPropertyName()+"')]/following::a[@class='clickable-link edit-data-link'][1]");
        playwright.clickOn(editDataApartemenLink);
    }

    /**
     * Get status property
     * @param searchPropertyName
     * @return statusApartement
     * e.g Aktif, Diperiksa Admin
     *
     */
    public String getStatusProperty(String searchPropertyName) {
        statusApartement = page.locator("//p[contains(., '"+searchPropertyName+"')]/parent::*/preceding::span[@class='status unverified-waiting']");
        return playwright.getText(statusApartement);
    }

    /**
     * Search apartemen property
     * @param namaUnit
     *
     */
    public void searchApartPropertySaya(String namaUnit) {
        setSearchPropertyName(namaUnit);
        playwright.clickOn(apartDropdown);
        searchKostTextbox.fill(namaUnit);
        Locator apartSearch = page.locator("a").filter(new Locator.FilterOptions().setHasText(namaUnit));
        playwright.clickOn(apartSearch);
    }

    /**
     * Click submit button
     *
     *
     */
    public void clickOnSubmitButton() {
        playwright.clickOnTextButton("Submit", 3000.0);
        playwright.hardWait(2000);
    }

    /**
     * Click on selesai button
     *
     *
     */
    public void clickOnSelesaiButton() {
        playwright.waitTillLocatorIsVisible(selesaiLink, 3000.0);
        playwright.clickOn(selesaiLink);
    }

    /**
     * Input descirption
     * @param deskripsi
     */
    public void inputDescription(String deskripsi) {
        playwright.forceFill(descriptionField, deskripsi);
    }
}
