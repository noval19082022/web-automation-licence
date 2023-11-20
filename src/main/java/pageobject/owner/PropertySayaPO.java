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
import java.util.Objects;

public class PropertySayaPO {
    private Page page;
    private PlaywrightHelpers playwright;
    @Setter
    @Getter
    private String searchPropertyName;

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
    Locator kostNameField;
    Locator roomTypeCheckbox;
    Locator roomTypeField;
    Locator kostTypeImage;
    Locator descKosField;
    Locator selectYear;
    Locator noteKosField;
    Locator uploadPeraturanButton;
    Locator errorMessage;
    Locator yearDropdown;
    Locator ubahFoto;
    Locator lanjutkanButton;
    Locator inputLocation;
    Locator firstLocationSuggestion;
    Locator searchInput;
    Locator firstEditButton;
    Locator alreadyInhabitedCheckbox;
    Locator statusRoom;
    Locator roomFilterDropdown;
    Locator filterTable;
    Locator floorFieldInput;
    Locator roomName;
    Locator errorMessageRoomName;
    Locator errorMessageFloor;
    Locator emptyTable;
    Locator mapField;
    Locator roomSizeProperty;
    Locator totalRoomField;
    Locator roomAvailableField;
    Locator priceMonthlyField;
    Locator minRentDuractionCheckbox;
    Locator otherPriceCheckbox;
    Locator otherKostPriceMonthlyCheckbox;
    Locator otherKostPriceMonthlyField;
    Locator minRentDurationDropdown;
    Locator minRentDurationChoose;
    Locator hapusDraftKos;
    Locator hapusKonfirm;
    Locator existingKosName;
    Locator existingRoomType;
    Locator roomTypeWarning;
    Locator roomTypeFieldInPopUp;
    Locator titleChangeIntercept;
    Locator descChangeIntercept;
    Locator additionalPriceCheckbox;
    Locator additionalPriceNameField;
    Locator additionalTotalPriceField;
    Locator downPaymentCheckbox;
    Locator percentageDownPaymentChoosed;
    Locator percentageDownPaymentDropdown;
    Locator penaltyCheckbox;
    Locator penaltyField;
    Locator descFieldDisabled;
    Locator lengkapiDataKosDraft;

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
        addNewKosButton = page.getByText("+ Tambah Kos Baru");
        closePopupBBKIcon = page.locator(".owner-intercept-booking-modal__close-button");
        fullnameTextbox = page.getByPlaceholder("Masukkan nama lengkap");
        bankAccountNumberTextbox = page.getByPlaceholder("Masukkan nomor rekening Anda");
        bankOwnerNameTextbox = page.getByPlaceholder("Masukkan nama pemilik rekening");
        bankNameDropdown = page.getByPlaceholder("Masukkan nama bank");
        termAndConsCheckbox = page.locator(".check");
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
        kostNameField = page.locator("input[type='text']").first();
        roomTypeCheckbox = page.locator("//span[@class='bg-c-checkbox__icon']").first();
        roomTypeField = page.locator("input[type='text']").nth(1);
        descKosField = page.locator("textarea").first();
        selectYear = page.locator(".bg-c-select__trigger");
        noteKosField = page.locator("textarea").nth(1);
        uploadPeraturanButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Upload Peraturan"));
        errorMessage = page.locator(".images__error");
        ubahFoto = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ubah Foto"));
        lanjutkanButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lanjutkan"));
        inputLocation = page.locator("//*[@data-testid='mamikosInput']");
        firstLocationSuggestion = page.locator("//*[@data-testid='suggestionItem']").first();
        searchInput = page.getByPlaceholder("Masukkan nama atau nomor kamar");
        firstEditButton = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("edit")).first();
        alreadyInhabitedCheckbox = page.locator("span").filter(new Locator.FilterOptions().setHasText("checkmark"));
        statusRoom = page.locator(".bg-c-label").first();
        roomFilterDropdown = page.locator(".availability-option__button");
        floorFieldInput = page.locator("#modalAddFloorInput_txt");
        errorMessageRoomName = page.locator(".bg-c-field__message");
        errorMessageFloor = page.getByText("Maks. 50 karakter.");
        emptyTable = page.locator(".is-empty");
        mapField = page.locator("[src='/_nuxt/img/de2002c.svg']");
        totalRoomField = page.getByPlaceholder("Jumlah kamar", new Page.GetByPlaceholderOptions().setExact(true));
        roomAvailableField = page.getByPlaceholder("Jumlah kamar yang kosong");
        priceMonthlyField = page.locator("//div[@class='step-seven__content']/div[@class='step-seven__field']/div[@class='bg-c-field']/input[@class='input step-seven__input']");
        minRentDuractionCheckbox = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Anda ingin terapkan minimum durasi sewa? Jangka waktu minimum untuk bisa menyewa kamar kos Anda.")).locator("span");
        otherPriceCheckbox = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Harga sewa selain bulanan")).locator("span");
        minRentDurationDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Min. 1 Bln dropdown-down"));
        hapusDraftKos = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hapus Kos")).first();
        hapusKonfirm = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hapus").setExact(true));
        roomTypeFieldInPopUp = page.locator("input[type='text']");
        descChangeIntercept = page.locator(".changes-interception__message");
        additionalPriceCheckbox = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Ada Biaya Tambahan? Contoh: Cuci Baju, Listrik, dll.")).locator("span");
        additionalPriceNameField = page.locator("//input[@class='bg-c-input__field']");
        additionalTotalPriceField = page.locator("//input[@class='input additional-cost__input']");
        downPaymentCheckbox = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Terapkan Uang Muka? Uang muka/ DP akan diambil dari biaya sewa pertama.")).locator("span");
        percentageDownPaymentDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("10% dropdown-down"));
        penaltyCheckbox = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Anda ingin terapkan denda keterlambatan?")).locator("span");
        penaltyField = page.locator("div:nth-child(7) > div > .bg-c-field > .input");
        descFieldDisabled = page.locator("//div[@class='content']//div[@class='bg-c-field']//textarea[contains(@class, 'disabled')]");
        lengkapiDataKosDraft = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Lengkapi Data Kos")).first();
    }

    /**
     * user as owner click kost dropdown
     * user enter kost name
     * user choose kost name
     */
    public void searchKostPropertySaya(String kostName) {
        playwright.clickOn(kostDropdown);
        searchKostTextbox.fill(kostName);
        Locator kostSearch = page.locator("a").filter(new Locator.FilterOptions().setHasText(kostName)).first();
        playwright.clickOn(kostSearch);
    }

    /**
     * user as owner click update kamar button
     */
    public void clickUpdateKamarButton() {
        playwright.clickOn(lihatSelengkapnyaButton);
        playwright.clickOn(updateKamarButton);
    }

    /**
     * user as owner click update kamar kost button
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
     *
     * @return string kos name
     */
    public String getFirstKosName() {
        return playwright.getText(firstKosNameLabel);
    }

    /**
     * Get first kos status in kos list
     *
     * @return string kos status
     */
    public String getFirstKosStatus(String status) {
        firstKosStatusLabel = page.getByText(status).first();
        return playwright.getText(firstKosStatusLabel);
    }

    /**
     * Get first kos type in kos list
     *
     * @return string kos type
     */
    public String getFirstKosType(String type) {
        firstKosTypeLabel = page.getByText(type).first();
        return playwright.getText(firstKosTypeLabel);
    }

    /**
     * Click on kos name in update price
     *
     * @param kosName is kos name
     */
    public void clickOnKosName(String kosName) {
        kostNameText = page.locator("//span[.='" + kosName + "']");
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
     *
     * @param dailyPrice is text we want to search
     */
    public void inputDailyPriceKos(String dailyPrice) {
        priceKostTextBox.nth(1).clear();
        priceKostTextBox.nth(1).fill(dailyPrice);
    }

    /**
     * Enter Text in weekly price text box
     *
     * @param weeklyPrice is text we want to search
     */
    public void inputWeeklyPrice(String weeklyPrice) {
        priceKostTextBox.nth(2).clear();
        priceKostTextBox.nth(2).fill(weeklyPrice);
    }

    /**
     * Enter Text in monthly price text box
     *
     * @param monthlyPrice is text we want to search
     */
    public void inputMonthlyPrice(String monthlyPrice) {
        priceKostTextBox.first().clear();
        priceKostTextBox.first().fill(monthlyPrice);
    }

    /**
     * Enter Text in three monthly price text box
     *
     * @param threeMonthlyPrice is text we want to search
     */
    public void inputThreeMonthlyPrice(String threeMonthlyPrice) {
        priceKostTextBox.nth(3).clear();
        priceKostTextBox.nth(3).fill(threeMonthlyPrice);
    }

    /**
     * Enter Text in six monthly price text box
     *
     * @param sixMonthlyPrice is text we want to search
     */
    public void inputSixMonthlyPrice(String sixMonthlyPrice) {
        priceKostTextBox.nth(4).clear();
        priceKostTextBox.nth(4).fill(sixMonthlyPrice);
    }

    /**
     * Enter Text yearly price text box
     *
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
     *
     * @return Integer weekly price
     */
    public String getWeeklyPrice() {
        int number = JavaHelpers.extractNumber(playwright.getInputValue(priceKostTextBox.nth(2)));
        return String.valueOf(number);
    }

    /**
     * Get text price monthly
     *
     * @return Integer monthly price
     */
    public String getMonthlyPrice() {
        int number = JavaHelpers.extractNumber(playwright.getInputValue(priceKostTextBox.first()));
        return String.valueOf(number);
    }

    /**
     * Get text price three monthly
     *
     * @return Integer three monthly price
     */
    public String getThreeMonthlyPrice() {
        int number = JavaHelpers.extractNumber(playwright.getInputValue(priceKostTextBox.nth(3)));
        return String.valueOf(number);
    }

    /**
     * Get text price six monthly
     *
     * @return Integer six monthly price
     */
    public String getSixMonthlyPrice() {
        int number = JavaHelpers.extractNumber(playwright.getInputValue(priceKostTextBox.nth(4)));
        return String.valueOf(number);
    }

    /**
     * Get text price yearly
     *
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
        if (playwright.waitTillLocatorIsVisible(continueInputDataButton)) {
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
     *
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
        playwright.reloadPage();
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
        optionProperty = page.locator("//label[contains(.,'" + option + "')]");
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
        if (playwright.waitTillLocatorIsVisible(closePopupBBKIcon)) {
            playwright.clickOn(closePopupBBKIcon);
        }
    }

    /**
     * Get Full Name inputted text in Mamipay Form
     *
     * @return String Full Name inputted text
     */
    public String getInputTextFullName() {
        return playwright.getInputValue(fullnameTextbox);
    }

    /**
     * Get Bank account number inputted text in Mamipay Form
     *
     * @return String Bank account number inputted text
     */
    public String getInputTextBankAcc() {
        return playwright.getInputValue(bankAccountNumberTextbox);
    }

    /**
     * Get Bank owner name inputted text in Mamipay Form
     *
     * @return String Bank owner name inputted text
     */
    public String getInputTextBankOwnerName() {
        return playwright.getInputValue(bankOwnerNameTextbox);
    }

    /**
     * Get Bank name inputted text in Mamipay Form
     *
     * @return String Bank name inputted text
     */
    public String getInputTextBankName() {
        return playwright.getInputValue(bankNameDropdown);
    }

    /**
     * Fill out Full Name
     *
     * @param fullName
     */
    public void fillInputNameForm(String fullName) {
        playwright.clearText(fullnameTextbox);
        playwright.clickLocatorAndTypeKeyboard(fullnameTextbox, fullName);
    }

    /**
     * Fill out Bank Account Number Form
     *
     * @param bankAccountNumber bank account number
     */
    public void fillBankAccountNumberForm(String bankAccountNumber) {
        playwright.clearText(bankAccountNumberTextbox);
        playwright.clickLocatorAndTypeKeyboard(bankAccountNumberTextbox, bankAccountNumber);
    }

    /**
     * Fill out Bank Account Name Form
     *
     * @param bankAccountName bank account name
     */
    public void fillBankAccountNameForm(String bankAccountName) {
        playwright.clearText(bankOwnerNameTextbox);
        playwright.clickLocatorAndTypeKeyboard(bankOwnerNameTextbox, bankAccountName);
    }

    /**
     * Fill out Bank Name
     *
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
     *
     * @param dataKos which part to edit
     */
    public void clickEditDataKos(String dataKos) {
        page.waitForLoadState(LoadState.LOAD);
        editDataKos = page.locator("//span[contains(.,'" + dataKos + "')]/following-sibling::span");
        playwright.clickOn(editDataKos);
    }

    /**
     * Click facilities checkbox
     *
     * @param section  is facility section, example "Fasilitas Umum"
     * @param facility is facility name
     */
    public void clickFacilitiesCheckbox(String section, String facility) {
        fasilitasFeature = page.locator("//h4[contains(., '" + section + "')]/following::div//span[contains(text(), '" + facility + "')]").first();
        playwright.pageScrollUntilElementIsVisible(fasilitasFeature);
        playwright.clickOn(fasilitasFeature);
    }

    /**
     * Verify button edit finish is disabled
     *
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
     *
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
     *
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
     *
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
        playwright.fill(locationTextBox, locationName);
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
     *
     * @param notes is address notes
     */
    public void enterAddressNotes(String notes) {
        playwright.pageScrollUntilElementIsVisible(addressNotesInput);
        playwright.clearText(addressNotesInput);
        playwright.fill(addressNotesInput, notes);
    }

    /**
     * Get text in promo ngebut infobar
     *
     * @return String promo ngebut info
     */
    public String getPromoNgebutInfo() {
        return playwright.getText(promoNgebutLabel);
    }

    /**
     * Verify if monthly price field is enable
     *
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
     *
     * @return boolean true, false
     */
    public boolean isPopUpModalVisible() {
        return playwright.isLocatorVisibleAfterLoad(modalPopUp, 3000.0);
    }

    /**
     * Verify status kos
     *
     * @return statusKos
     */
    public boolean isStatusKos() {
        return playwright.waitTillLocatorIsVisible(statusKos, 3000.0);
    }

    /**
     * Get text warning price daily, weekly, monthly, three monthly,six monthly, yearly price
     *
     * @return String warning daily, weekly, monthly, three monthly,six monthly, yearly price
     */
    public String getWarningYearlyPrice(Integer i) {
        warningPrice = page.locator(".media-content");
        return playwright.getText(warningPrice.nth(i));
    }

    /**
     * Check if button update price is disable
     *
     * @return true if disable
     */
    public boolean isButtonUpdatePriceDisable() {
        return updatePriceButton.isDisabled();
    }

    /**
     * Click tambah data iklan -> tambah iklan baru -> choose add kos or apartement
     *
     * @param jenisProperti e.g Kost, Apartemen
     */
    public void clickTambahDataIklan(String jenisProperti) {
        playwright.waitTillPageLoaded(10000.0);
        playwright.clickOn(tambahDataIklan);
        playwright.clickOn(tambahIklanBaru);
        jenisPropertiRadioButton = page.locator("#ownerModalAdd").getByText(jenisProperti);
        playwright.waitTillLocatorIsVisible(jenisPropertiRadioButton, 3000.0);
        playwright.clickOn(jenisPropertiRadioButton);
        playwright.clickOnTextButton("Tambahkan Data", 3000.0);
    }

    /**
     * Input property name
     *
     * @param propertyName Can use add and edit
     *                     If edit nama project field doesn't appear
     */
    public void inputPropertyName(String propertyName) {
        if (propertyNameField.isVisible()) {
            playwright.forceFill(propertyNameField, propertyName);
        }
    }

    /**
     * Input nama unit apartemen
     *
     * @param namaUnit
     */
    public void inputNamaUnit(String namaUnit) {
        playwright.forceFill(unitNameField, namaUnit);
    }

    /**
     * Input nomor unit
     *
     * @param nomorUnit
     */
    public void inputNoUnit(String nomorUnit) {
        playwright.forceFill(unitNumberField, nomorUnit);
    }

    /**
     * Select tipe unit
     *
     * @param tipeUnit e.g 1-Room Studio, 2 BR, 3 BR, 4 BR, Lainnya
     */
    public void selectUnitType(String tipeUnit) {
        playwright.selectDropdownByValue(unitTypeField, tipeUnit);
    }

    /**
     * input lantai apartemen
     *
     * @param lantai
     */
    public void inputLantai(String lantai) {
        playwright.forceFill(floorPropertyField, lantai);
    }

    /**
     * Input unit size
     *
     * @param luasUnit
     */
    public void inputUnitSize(String luasUnit) {
        playwright.forceFill(unitSizeField, luasUnit);
    }

    /**
     * Select price type
     *
     * @param priceType
     */
    public void selectPriceType(String priceType) {
        priceTypeCheckBox = page.locator("label").filter(new Locator.FilterOptions().setHasText(priceType));
        playwright.clickOn(priceTypeCheckBox);
    }

    /**
     * Input apartemen price
     * After check price type, then input the price
     *
     * @param priceType e.g Perhari, Perminggu, Perbulan, Pertahun
     * @param price
     */
    public void inputApartementPrice(String priceType, String price) {
        String element;
        switch (priceType) {
            case "Perhari":
                element = "Daily";
                break;
            case "Perminggu":
                element = "Weekly";
                break;
            case "Perbulan":
                element = "Monthly";
                break;
            case "Pertahun":
                element = "Yearly";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + priceType);
        }
        priceApartementField = page.locator("//input[@id='inputPrice" + element + "']");
        playwright.waitTillLocatorIsVisible(priceApartementField, 3000.0);
        playwright.forceFill(priceApartementField, price);
    }

    /**
     * Select fasilitas unit
     *
     * @param fasilitasUnit
     */
    public void selectFasilitasUnit(String fasilitasUnit) {
        String element = "//label[contains(.,'" + fasilitasUnit + "')]";
        playwright.clickOn(page.locator(element));
    }

    /**
     * Select fasilitas kamar
     *
     * @param fasilitasKamar
     */
    public void selectFasilitasKamar(String fasilitasKamar) {
        String element = "";
        switch (fasilitasKamar) {
            case "Not Furnished":
                element = "[for='isFurnished0']";
                break;
            case "Semi Furnished":
                element = "[for='isFurnished1']";
                break;
            case "Furnished":
                element = "[for='isFurnished2']";
                break;
        }
        playwright.clickOn(page.locator(element));
    }

    /**
     * Upload phoyo cover apartemen
     * Photo can't > 5mb
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
     *
     * @param photoType e.g photo kamar, kamar mandi, dan lainnya
     *                  photo can't > 5mb
     */
    public void uploadPhotoApartemen(String photoType) {
        String element = "";
        switch (photoType) {
            case "kamar":
                element = "Bedroom";
                break;
            case "kamar mandi":
                element = "Bath";
                break;
            case "lainnya":
                element = "Other";
                break;
        }
        uploadPhotoApartement = page.locator("//div[@id='photo" + element + "']");

        String imagePath = "src/main/resources/images/upload5Mb.jpg";
        FileChooser fileChooser = page.waitForFileChooser(() -> uploadPhotoApartement.click());
        fileChooser.setFiles(Paths.get(imagePath));
        playwright.waitTillLocatorIsVisible(uploadPhotoApartement);
        playwright.hardWait(3000);
    }

    /**
     * Select property name
     * After owner input property name, will be display dropdown suggestion of property name
     */
    public void selectPropertyName(String namaProject) {
        if (propertyNameField.isVisible()) {
            playwright.clickOnText(namaProject);
        }
    }

    /**
     * Click furniture if check fasilitas kamar is semi furnished and furnished
     *
     * @param furniture
     */
    public void clickFurnished(String furniture) {
        playwright.clickOnText(furniture);
    }

    /**
     * Click edit apartemen link
     * Property name from getSearchPropertyName
     */
    public void clickEditDataApartemen() {
        editDataApartemenLink = page.locator("//p[contains(., '" + getSearchPropertyName() + "')]/following::a[@class='clickable-link edit-data-link'][1]");
        playwright.clickOn(editDataApartemenLink);
    }

    /**
     * Get status property
     *
     * @param searchPropertyName
     * @return statusApartement
     * e.g Aktif, Diperiksa Admin
     */
    public String getStatusProperty(String searchPropertyName) {
        statusApartement = page.locator("//p[contains(., '" + searchPropertyName + "')]/parent::*/preceding::span[@class='status unverified-waiting']");
        return playwright.getText(statusApartement);
    }

    /**
     * Search apartemen property
     *
     * @param namaUnit
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
     */
    public void clickOnSubmitButton() {
        playwright.clickOnTextButton("Submit", 3000.0);
        playwright.hardWait(2000);
    }

    /**
     * Click on selesai button
     */
    public void clickOnSelesaiButton() {
        playwright.waitTillLocatorIsVisible(selesaiLink, 3000.0);
        playwright.clickOn(selesaiLink);
    }

    /**
     * Input descirption
     *
     * @param deskripsi
     */
    public void inputDescription(String deskripsi) {
        playwright.forceFill(descriptionField, deskripsi);
    }

    /**
     * Input kos name
     *
     * @param kosName (include random text from property saya steps)
     */
    public void inputKosName(String kosName) {
        playwright.waitTillLocatorIsVisible(kostNameField, 3000.0);
        playwright.waitFor(kostNameField, 10000.0);
        playwright.forceFill(kostNameField, kosName);
    }

    /**
     * Checklist roomtype
     *
     * @param roomTypeCheck
     */
    public void checkRoomType(String roomTypeCheck) {
        if (roomTypeCheck.equals("yes")) {
            playwright.clickOn(roomTypeCheckbox);
        }
    }

    /**
     * input room type name
     *
     * @param roomTypeName
     */
    public void inputRoomTypeName(String roomTypeName) {
        if (roomTypeCheckbox.isChecked()) {
            playwright.forceFill(roomTypeField, roomTypeName);
        }
    }

    /**
     * Select kost type
     *
     * @param kosType e.g putra, putri, campur
     */
    public void selectKostType(String kosType) {
        kostTypeImage = page.locator("[alt='type-kost-" + kosType + "']");
        playwright.clickOn(kostTypeImage);
    }

    /**
     * Input description kos
     *
     * @param descKos
     */
    public void inputDescKos(String descKos) {
        playwright.forceFill(descKosField, Objects.requireNonNullElse(descKos, ""));
    }

    /**
     * Select the year of build kos
     *
     * @param buildKos
     */
    public void selectBuildKos(String buildKos) {
        playwright.clickOn(selectYear);
        yearDropdown = page.locator("a").filter(new Locator.FilterOptions().setHasText(buildKos));
        playwright.waitTillLocatorIsVisible(yearDropdown);
        playwright.clickOn(yearDropdown);
    }

    /**
     * Input other note on data kos
     *
     * @param otherNote
     */
    public void inputOtherNote(String otherNote) {
        playwright.forceFill(noteKosField, Objects.requireNonNullElse(otherNote, ""));
    }

    /**
     * Click atur peraturan button
     */
    public void clickOnAturPeraturanKos() {
        playwright.clickOnTextButton("Atur Peraturan");
    }

    /**
     * Check 1 of the kost rule
     *
     * @param rule
     */
    public void clickKosRulesCheckbox(String rule) {
        playwright.clickOnText(rule);
    }

    /**
     * Upload the invalid aturan kos
     */
    public void uploadInvalidAturanKos() {
        String imagePath = "src/main/resources/images/mamikos.gif";
        FileChooser fileChooser = page.waitForFileChooser(() -> uploadPeraturanButton.click());
        fileChooser.setFiles(Paths.get(imagePath));
        playwright.waitTillLocatorIsVisible(uploadPeraturanButton);
        playwright.hardWait(3000);
    }

    /**
     * Get error message upload foto
     *
     * @return errorMessage
     */
    public String getErrorUpload() {
        return playwright.getText(errorMessage).replaceAll("closeerror-round-glyph", "");
    }

    /**
     * Upload valid aturan kos
     * If ubah foto visible using element ubah foto
     * If ubah foto invisible using element upload peraturan button
     */
    public void uploadValidAturanKos() {
        String imagePath = "src/main/resources/images/aturan-kos.png";
        if (ubahFoto.isVisible()) {
            FileChooser fileChooser = page.waitForFileChooser(() -> ubahFoto.click());
            fileChooser.setFiles(Paths.get(imagePath));
            playwright.waitTillLocatorIsVisible(ubahFoto);
            playwright.hardWait(3000);
        } else {
            FileChooser fileChooser = page.waitForFileChooser(() -> uploadPeraturanButton.click());
            fileChooser.setFiles(Paths.get(imagePath));
            playwright.waitTillLocatorIsVisible(uploadPeraturanButton);
            playwright.hardWait(3000);
        }

    }

    /**
     * check error upload visible or no
     *
     * @return errorMessage
     */
    public boolean isErrorUploadDisappear() {
        return playwright.isLocatorVisibleAfterLoad(errorMessage, 3000.0);
    }

    /**
     * CLick Lanjutkan button from data kos to alamat kos
     * Allow the geolocation permission
     */
    public void allowLocation() {
        playwright.acceptDialog(lanjutkanButton);
        playwright.hardWait(5000.0);
    }

    /**
     * Input location kos
     *
     * @param keyLocation select the first location suggestion
     */
    public void inputLocationKos(String keyLocation) {
        page.reload();
        playwright.clickOn(inputLocation);
        playwright.realKeyboardType(keyLocation);
        ;
        playwright.hardWait(10000.0);
        playwright.clickOn(firstLocationSuggestion);
    }

    /**
     * Insert text to search bar in room allotment and hit enter
     *
     * @param text is text we want to insert
     */
    public void searchNameOrRoomNo(String text) {
        playwright.fill(searchInput, text);
        playwright.pressKeyboardKey("Enter");
    }

    /**
     * Click on first Edit Button in room name/number table
     */
    public void clickFirstEditButton() {
        playwright.clickOn(firstEditButton);
    }

    /**
     * Click on already inhabited checkbox
     */
    public void clickAlreadyInhabitedCheckbox() throws InterruptedException {
        playwright.clickOn(alreadyInhabitedCheckbox);
    }

    /**
     * Get room status after update room
     *
     * @return return toast text e.g Anda berhasil update kamar
     */
    public String getRoomStatus() {
        playwright.hardWait(2000.0);
        return playwright.getText(statusRoom);
    }

    /**
     * Filter room table with selected text in param
     *
     * @param filter is room filter text
     */
    public void filterRoomTable(String filter) {
        playwright.hardWait(1000.0);
        playwright.clickOn(roomFilterDropdown);
        filterTable = page.getByText(filter).first();
        playwright.clickOn(filterTable);
    }

    /**
     * Fill floor field with text
     *
     * @param floor is text for floor
     */
    public void insertTextFloor(String floor) {
        playwright.clearText(floorFieldInput);
        playwright.fill(floorFieldInput, floor);
    }

    /**
     * Fill room name field with text
     *
     * @param room is text for room name/number
     */
    public void insertTextRoomName(String room) {
        playwright.clearText(roomNameField);
        playwright.fill(roomNameField, room);
    }

    /**
     * Get goldplus label beside room Name/number
     *
     * @param roomNo is room name/number
     * @return text goldplus
     */
    public String getGoldPlusLabel(String roomNo) {
        roomName = page.locator("//td[normalize-space()='" + roomNo + "']");
        return playwright.getText(roomName);
    }

    /**
     * Get error message below room name field
     *
     * @return error message below room name field
     */
    public String getErrorRoomName() {
        return playwright.getText(errorMessageRoomName);
    }

    /**
     * Get error message below floor field
     *
     * @return error message below floor field
     */
    public String getErrorFloor() {
        return playwright.getText(errorMessageFloor);
    }

    /**
     * Verify if table is empty
     *
     * @return true if empty
     */
    public boolean isTableEmpty() {
        return playwright.waitTillLocatorIsVisible(emptyTable);
    }

    /**
     * Click Lanjutkan button (without access geolocation permission)
     */
    public void clickOnLanjutkan() {
        playwright.waitTillLocatorIsVisible(lanjutkanButton);
        playwright.clickOn(lanjutkanButton);
    }

    /**
     * upload invalid photo kos
     *
     * @param photoName
     */
    public void uploadInvalidPhotoKos(String photoName) {
        String imagePath = "src/main/resources/images/mamikos.gif";
        Locator uploadPhotoKos = page.getByText("camera + Tambah foto " + photoName);
        FileChooser fileChooser = page.waitForFileChooser(() -> uploadPhotoKos.click());
        fileChooser.setFiles(Paths.get(imagePath));
        playwright.waitTillLocatorIsVisible(uploadPhotoKos);
        playwright.hardWait(3000);
    }

    /**
     * Upload valid photo kos
     */
    public void ubahValidPhotoKos() {
        String imagePath = "src/main/resources/images/upload5Mb.jpg";
        FileChooser fileChooser = page.waitForFileChooser(() -> ubahFoto.click());
        fileChooser.setFiles(Paths.get(imagePath));
        playwright.waitTillLocatorIsVisible(ubahFoto);
        playwright.hardWait(3000);
    }

    /**
     * select room size
     *
     * @param roomSize
     */
    public void selectRoomSize(String roomSize) {
        roomSizeProperty = page.locator("//span[.='" + roomSize + "']");
        playwright.clickOn(roomSizeProperty);
    }

    /**
     * Input total room
     *
     * @param totalRoom
     */
    public void inputTotalRoom(String totalRoom) {
        playwright.forceFill(totalRoomField, totalRoom);
    }

    /**
     * input room available
     *
     * @param roomAvailable
     */
    public void inputRoomAvailable(String roomAvailable) {
        playwright.forceFill(roomAvailableField, roomAvailable);
    }

    /**
     * Input monthly price
     *
     * @param monthlyPrice
     */
    public void inputMonthyPrice(String monthlyPrice) {
        playwright.clickOn(priceMonthlyField);
        playwright.pressKeyboardKey("Control+KeyA");
        playwright.pressKeyboardKey("Delete");
        playwright.realKeyboardType(monthlyPrice);
        playwright.pressKeyboardKey("Tab");
    }

    /**
     * Select minimum rent duration
     *
     * @param minRentDuration
     * @param min_rent_duration
     */
    public void selectMinRentDuration(String minRentDuration, String min_rent_duration) {
        minRentDurationChoose = page.locator("a").filter(new Locator.FilterOptions().setHasText(min_rent_duration));
        if (minRentDuration.equals("yes")) {
            playwright.clickOn(minRentDuractionCheckbox);
            playwright.clickOn(minRentDurationDropdown);
            playwright.clickOn(minRentDurationChoose);
        }
    }

    /**
     * checklist the other price
     *
     * @param checkOtherPrice
     */
    public void selectOtherPrice(String checkOtherPrice) {
        if (checkOtherPrice.equals("yes")) {
            playwright.clickOn(otherPriceCheckbox);
        }
    }

    /**
     * Input other price
     *
     * @param priceType
     * @param otherPrice
     * @param index      eg. harga per hari, harga per minggu, per 3 bulan, per 6 bulan, per tahun
     */
    public void inputOtherPrice(String priceType, String otherPrice, int index) {
        otherKostPriceMonthlyCheckbox = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Harga Per " + priceType)).locator("span");
        otherKostPriceMonthlyField = page.locator("//div[@class='step-seven__content']/div[@class='step-seven__field']/div[" + index + "]/div[@class='bg-c-field']/input[@class='input step-seven__input']");
        if (otherKostPriceMonthlyCheckbox.isChecked()) {
            playwright.clickOn(otherKostPriceMonthlyField);
            playwright.pressKeyboardKey("Control+KeyA");
            playwright.pressKeyboardKey("Delete");
            playwright.realKeyboardType(otherPrice);
            playwright.pressKeyboardKey("Tab");
        } else {
            playwright.clickOn(otherKostPriceMonthlyCheckbox);
            playwright.clickOn(otherKostPriceMonthlyField);
            playwright.realKeyboardType(otherPrice);
            playwright.pressKeyboardKey("Tab");
        }
    }

    /**
     * Click Selesai button for add kos
     */
    public void clickOnSelesaiSubmit() {
        playwright.hardWait(5000.0);
        playwright.clickOnTextButton("Selesai");
    }

    /**
     * Waiting the page loaded
     */
    public void waitPageLoaded() {
        playwright.waitTillPageLoaded(10000.0);
    }

    /**
     * Click delete button on kos draft
     */
    public void clickDeleteKosDraft() {
        playwright.clickOn(hapusDraftKos);
    }

    /**
     * Click delete button on pop up confirmation
     */
    public void clickHapusOnPopUpConfirmation() {
        playwright.clickOn(hapusKonfirm);
    }

    /**
     * Click hapus button on pop up konfirmasi Hapus draft kos
     *
     * @param text
     */
    public void clickOnNewBBKPopUp(String text) {
        playwright.clickOnTextButton(text);
    }

    /**
     * Click on existing kos name on Tambah Data kos
     *
     * @param kosName
     */
    public void clickAddAnotherTypeFromKos(String kosName) {
        playwright.hardWait(5000.0);
        existingKosName = page.getByText(kosName + " chevron-right");
        playwright.clickOn(existingKosName);
    }

    /**
     * Create kos from existing room type
     *
     * @param kosType
     * @throws InterruptedException
     */
    public void clickNewRoomType(String kosType) throws InterruptedException {
        playwright.waitTillPageLoaded(20000.0);
        playwright.hardWait(5000.0);
        existingRoomType = page.locator("label").filter(new Locator.FilterOptions().setHasText(kosType)).locator("span").first();
        playwright.waitFor(existingRoomType, 10000.0);
        playwright.clickOn(existingRoomType);
        playwright.clickOn(lanjutkanButton.first());
    }

    /**
     * Get room type message on bottom the field room type after click duplicate kos from room type
     *
     * @param roomTypeMessageText
     * @return
     */
    public String getRoomTypeMessage(String roomTypeMessageText) {
        roomTypeWarning = page.getByText(roomTypeMessageText);
        return playwright.getText(roomTypeWarning);
    }

    /**
     * Verify the lanjutkan button is disable
     *
     * @return boolean
     */
    public boolean isLanjutkanDisable() {
        return playwright.isButtonDisable(lanjutkanButton);
    }

    /**
     * Input room type name on pop up when duplicate kos
     *
     * @param text
     */
    public void inputRoomTypeNameInPopUp(String text) {
        playwright.forceFill(roomTypeFieldInPopUp, text);
    }

    public void isLanjutkanInPopUpDisable() {
        playwright.isButtonDisable(lanjutkanButton.first());
    }

    /**
     * Get title on change interupcept popup when cancel create kos
     *
     * @return titleChangeIntercept
     */
    public String getTitleChangeInterceptPopUp() {
        titleChangeIntercept = page.locator(".changes-interception__title");
        return playwright.getText(titleChangeIntercept);
    }

    /**
     * Get message description on change intercept pop up
     *
     * @return descChangeIntercept
     */
    public String getMessageChangeInterceptPopUp() {
        return playwright.getText(descChangeIntercept);
    }

    /**
     * Click on action of intercept pop up cancel create kos
     *
     * @param actionText
     */
    public void clickOnActionInterceptInputData(String actionText) {
        playwright.clickOnTextButton(actionText);
    }

    /**
     * Click to previous page
     */
    public void clickOnBackFromInputKos() {
        playwright.backToPreviousPage();
    }

    /**
     * Upload valid photo kos
     *
     * @param photoName
     */
    public void uploadValidPhotoKos(String photoName) {
        String imagePath = "src/main/resources/images/upload5Mb.jpg";
        Locator uploadPhotoKos = page.getByText("camera + Tambah foto " + photoName);
        FileChooser fileChooser = page.waitForFileChooser(() -> uploadPhotoKos.click());
        fileChooser.setFiles(Paths.get(imagePath));
        playwright.waitTillLocatorIsVisible(uploadPhotoKos);
        playwright.hardWait(3000);
    }

    /**
     * Select additional price checkbox
     */
    public void selectAdditionalPrice() {
        playwright.clickOn(additionalPriceCheckbox);
    }

    /**
     * Input additional price name
     *
     * @param priceName
     */
    public void inputAdditionalPriceName(String priceName) {
        playwright.forceFill(additionalPriceNameField, priceName);
    }

    /**
     * Input total additional price
     *
     * @param priceTotal
     */
    public void inputTotalAdditionalPrice(String priceTotal) {
        playwright.clickOn(additionalTotalPriceField);
        playwright.realKeyboardType(priceTotal);
        playwright.pressKeyboardKey("Tab");
    }

    /**
     * Select the down payment checkbox
     */
    public void selectDownPayment() {
        playwright.clickOn(downPaymentCheckbox);
    }

    /**
     * Select the percentage of down payment from rent price
     *
     * @param downPaymentPercentage
     */
    public void selectPercentageOfDownPayment(String downPaymentPercentage) {
        percentageDownPaymentChoosed = page.locator("a").filter(new Locator.FilterOptions().setHasText(downPaymentPercentage));
        playwright.clickOn(percentageDownPaymentDropdown);
        playwright.clickOn(percentageDownPaymentChoosed);
    }

    /**
     * Select penalty checkbox
     */
    public void selectPenalty() {
        playwright.clickOn(penaltyCheckbox);
    }

    /**
     * Input penalty amount
     *
     * @param penaltyAmount
     */
    public void inputPenalty(String penaltyAmount) {
        playwright.clickOn(penaltyField);
        playwright.realKeyboardType(penaltyAmount);
        playwright.pressKeyboardKey("Tab");
    }

    /**
     * Click lanjutkan button after input type room while duplicat kos
     */
    public void clickOnLanjutkanAfterInputTypeRoom() {
        playwright.clickOn(lanjutkanButton.first());
    }

    /**
     * Verify the description kos is disable
     *
     * @return boolean
     */
    public boolean isDescriptionKosDisable() {
        return playwright.isButtonDisable(descFieldDisabled);
    }

    /**
     * Verify the build kos is disable
     *
     * @return boolean
     */
    public boolean isBuildKosDisable() {
        return playwright.isButtonDisable(selectYear);
    }

    /**
     * Click on lengkapi button in add or duplicate kos
     *
     * @param text
     */
    public void clickOnLengkapiDataAddKos(String text) {
        playwright.clickOnTextButton(text, 3000.0);
    }

    /**
     * Click on Atur ketersediaan kamar on ketersediaan kamar form
     *
     * @param text
     */
    public void clickOnKetersediaanKamar(String text) {
        playwright.clickOnTextButton(text);
    }

    /**
     * Click on selesai atur kamar button
     * @param text
     *
     */
    public void clickOnSelesaiAturKamar(String text) {
        playwright.clickOnTextButton(text, 3000.0);
    }

    /**
     * Select payment expired date
     * @param number
     * @param rangeTime
     *
     */
    public void selectPaymentExpiredDate(String number, String rangeTime) {
        playwright.clickOnTextButton("1 dropdown-down");
        Locator numberSelected = page.locator("//div[contains(@class,'bg-c-dropdown__menu bg-c-dropdown__menu--open bg-c-dropdown__menu--scrollable bg-c-dropdown__menu--fit-to-trigger bg-c-dropdown__menu--text-lg')]//li["+number+"]/a");
        playwright.clickOn(numberSelected);
        Locator rangeTimeDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hari dropdown-down").setExact(true));
        playwright.clickOn(rangeTimeDropdown);
        Locator rangeTimeSelected = page.locator("a").filter(new Locator.FilterOptions().setHasText(rangeTime));
        playwright.clickOn(rangeTimeSelected);
    }

    /**
     * Click on lengkapi button
     *
     */
    public void clickOnLengkapiDataKosDraft() {
        playwright.clickOn(lengkapiDataKosDraft);
        playwright.hardWait(5000.0);
    }

    /**
     * Get error price add kos
     * @param i
     * @return warningPrice
     */
    public String getErrorPriceAddKos(int i) {
        warningPrice = page.locator(".bg-c-field__message");
        return playwright.getText(warningPrice.nth(i));
    }
}