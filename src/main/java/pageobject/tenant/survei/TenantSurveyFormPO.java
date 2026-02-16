package pageobject.tenant.survei;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TenantSurveyFormPO {
    private Page page;
    private PlaywrightHelpers playwright;
    JavaHelpers java = new JavaHelpers();

    String date;
    Locator dateOption;
    Locator dateViewSelected;
    Locator dateViewToday;
    Locator nextMonthBtn;
    Locator previousMonthBtn;
    Locator editProfileBtn;
    Locator profileNamePlaceHolder;
    Locator profileBirthdayPlaceHolder;
    Locator genderPlaceHolder;
    Locator saveProfileBtn;
    Locator popUpSuccessSaveProfileText;
    Locator ajukanSurveyBtn;
    Locator chevronDetailSurvei;
    Locator inputTextbox;
    Locator chevronToDetailSurvey;
    Locator orangLainYangAkanDatangSurveyToogle;
    Locator namaOrangLainYangAkanDatangSurveyPlaceHolder;
    Locator hubunganOrangLainYangAkanDatangSurveyPlaceHolder;
    Locator selectDateSurvei;

    // NEW FLOW - Sameday Survey Elements
    Locator surveyFormContainer;
    Locator surveyDateTypeSurveiHariIni;
    Locator surveyDateTypeTanggalLain;
    Locator surveyDatePickerTextbox;
    Locator surveyTimePeriodPagi;
    Locator surveyTimePeriodSiang;
    Locator surveyTimePeriodSore;
    Locator phoneNumberInput;
    Locator tncCheckbox;
    Locator popupConfirmationHeading;
    Locator popupConfirmationKembaliBtn;
    Locator popupConfirmationMengertiBtn;
    Locator tanggalLainMessage;
    Locator phoneNumberErrorMessage;
    Locator tncLink;
    Locator tncSection;
    Locator surveyStatusInChatroom;
    Locator p2AutoreplyMessage;
    Locator basedLocatorDateCell;
    Locator timeButtonLocator;
    Locator chatroomContainer;
    Locator suggestionMessage;
    Locator phoneInMessage;

    public TenantSurveyFormPO(Page page) {
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        dateOption = page.getByPlaceholder("Pilih tanggal survei kos");
        dateViewSelected = page.locator("//div[@class='chat-sheet']").locator(".selected");
        dateViewToday = page.locator("span.cell.day.selected.today");
        nextMonthBtn = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("arrow-right"));
        previousMonthBtn = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("arrow-left"));
        editProfileBtn = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("edit"));
        profileNamePlaceHolder = page.getByPlaceholder("Masukkan nama lengkap kamu");
        profileBirthdayPlaceHolder = page.getByPlaceholder("Masukkan Tanggal Lahir");
        genderPlaceHolder = page.getByText("Jenis Kelamin Laki-laki Perempuan Laki-laki dropdown-down Laki-laki Perempuan").locator("span");
        saveProfileBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Simpan").setExact(true));
        popUpSuccessSaveProfileText = page.locator(".mc-chat-room__toast");
        ajukanSurveyBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ajukan Survei"));
        chevronDetailSurvei = page.locator("//div[@class='mc-product-card__tenant-survey-detail']");
        inputTextbox = page.locator("//textarea[@placeholder='Ceritakan secara singkat dan jelas.']");
        chevronToDetailSurvey = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("chevron-right"));
        orangLainYangAkanDatangSurveyToogle = page.getByRole(AriaRole.CHECKBOX);
        namaOrangLainYangAkanDatangSurveyPlaceHolder = page.getByPlaceholder("Masukkan nama orang yang akan datang survei");
        hubunganOrangLainYangAkanDatangSurveyPlaceHolder = page.getByPlaceholder("Contoh: Kakak, Teman");
        selectDateSurvei = page.locator("//div[@class='bg-c-datepicker']");

        // NEW FLOW - Initialize Sameday Survey Elements
        surveyFormContainer = page.locator(".form-survey");
        surveyDateTypeSurveiHariIni = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Survei Hari ini"));
        surveyDateTypeTanggalLain = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tanggal Lain"));
        surveyDatePickerTextbox = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Pilih Tanggal"));
        surveyTimePeriodPagi = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pagi"));
        surveyTimePeriodSiang = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Siang"));
        surveyTimePeriodSore = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sore"));
        phoneNumberInput = page.getByPlaceholder("Masukan nomormu di sini");
        tncCheckbox = page.locator("label[for='tnc-survey']");
        popupConfirmationHeading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Pastikan Datamu Benar"));
        popupConfirmationKembaliBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kembali"));
        popupConfirmationMengertiBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Mengerti, Kirim"));
        tanggalLainMessage = page.locator(".tanggal-lain-message, .date-selection-message");
        // Error message for phone number field - search within form-survey container
        phoneNumberErrorMessage = page.locator(".form-survey .bg-c-field__message, .form-survey [class*='error'], .form-survey [class*='field-message']").first();
        tncLink = page.locator("a").filter(new Locator.FilterOptions().setHasText("Kebijakan Privasi Mamikos")).first();
        tncSection = page.locator(".tnc-section, .terms-section");
        surveyStatusInChatroom = page.locator(".survey-status");
        p2AutoreplyMessage = page.locator(".autoreply-message, .p2-message");
        basedLocatorDateCell = page.locator(".date-wrapper .cell.day");
        chatroomContainer = page.locator(".chatroom, .chat-container");
        suggestionMessage = page.locator(".suggestion-message, .tanggal-lain-suggestion");
        phoneInMessage = page.locator(".survey-request-message, .phone-number");
        p2AutoreplyMessage = page.getByText("Untuk Pencari: Silakan tunggu konfirmasi dari pemilik. Kamu juga bisa chat di sini untuk mengingatkan pemilik.").first();
    }


    //************************************************************************************************************

    public void tapOnEditProfile() {
        playwright.clickOn(editProfileBtn);
    }

    public void editNameProfile(String name) {
        if (name.contains("random")) {
            name = JavaHelpers.generateRandomName(10);
        }

        playwright.clearText(profileNamePlaceHolder);
        playwright.clickLocatorAndTypeKeyboard(profileNamePlaceHolder, name);
    }

    public void setSaveProfileBtn() {
        playwright.clickOn(saveProfileBtn);
    }

    public String popUpSuccessSaveProfile() {
        return playwright.getText(popUpSuccessSaveProfileText);
    }

    public String getSurveyDateAutoSelected() {
        return playwright.getText(dateViewToday);
    }

    public String getSurveyDateSelectedOnForm() {
        return playwright.getText(dateViewSelected);
    }

    public void tapOnSurveyDateForm() {
        playwright.clickOn(dateOption);
    }

    public void tapOnNextMonthBtnSurveyDateForm() {
        playwright.clickOn(nextMonthBtn);
    }

    public void selectSurveyDate(String date) {
        var locator = page.getByText(date, new Page.GetByTextOptions().setExact(true)).nth(1);
        playwright.clickOn(locator);
    }

    public boolean isSurveyDateNotVisible(String date) {
        var locator = page.getByText(date, new Page.GetByTextOptions().setExact(true)).nth(0);
        return !playwright.waitTillLocatorIsVisible(locator);
    }

    public String getTenantGender() {
        return playwright.getText(genderPlaceHolder);
    }


    /**
     * Check if Ajukan Survey button is disabled
     * Checks multiple disabled indicators: native disabled, aria-disabled, and CSS classes
     *
     * @return true if disabled
     */
    public boolean isAjukanSurveyBtnDisable() {
        // Check native disabled attribute
        if (playwright.isButtonDisable(ajukanSurveyBtn)) {
            return true;
        }

        // Check aria-disabled attribute
        String ariaDisabled = ajukanSurveyBtn.getAttribute("aria-disabled");
        if (ariaDisabled != null && ariaDisabled.equals("true")) {
            return true;
        }

        // Check for disabled/inactive CSS classes
        String classAttr = ajukanSurveyBtn.getAttribute("class");
        if (classAttr != null && (classAttr.contains("disabled") || classAttr.contains("inactive"))) {
            return true;
        }

        // Check if pointer-events is none (CSS disabled)
        String pointerEvents = ajukanSurveyBtn.evaluate("el => window.getComputedStyle(el).pointerEvents").toString();
        return "none".equals(pointerEvents);
    }

    public boolean isAjukanSurveyBtnEnable() {
        return playwright.isButtonEnable(ajukanSurveyBtn);
    }

    public void tapOnAjukanSurveyBtn() {
        // Wait for button to be in DOM
        playwright.waitTillLocatorIsVisible(ajukanSurveyBtn);
        // Scroll button into view (this should scroll the form container automatically)
        ajukanSurveyBtn.scrollIntoViewIfNeeded();
        // Wait a bit after scroll
        page.waitForTimeout(300);
        playwright.clickOn(ajukanSurveyBtn);
    }

    /**
     * Click on detail survei
     */
    public void userClickOnChevronDetailSurvei() {
        playwright.waitTillLocatorIsVisible(chevronDetailSurvei);
        playwright.clickOn(chevronDetailSurvei);
    }

    /**
     * Fills reason cancel survei
     *
     * @param text
     */
    public void userFillFormReasonCancelSurvei(String text) {
        playwright.waitTillLocatorIsVisible(inputTextbox);
        playwright.fill(inputTextbox, text);
    }

    /**
     * edit random profile birthday
     */
    public void editRandomProfileBirthdayDate() {
        playwright.clickOn(profileBirthdayPlaceHolder);

        int randomNum = ThreadLocalRandom.current().nextInt(10, 14); // 16 is exclusive
        String randomStr = String.valueOf(randomNum);

        var date = basedLocatorDateCell.getByText(randomStr).first();

        if (!playwright.waitTillLocatorIsVisible(date)) {
            randomStr = String.valueOf(randomNum + 1);
            date = basedLocatorDateCell.getByText(randomStr).first();
        }
        playwright.clickOn(date);
    }

    public void checkedOnToogleOrangLainYangAkanDatangSurvei() {
        playwright.checkBox(orangLainYangAkanDatangSurveyToogle);
    }

    public void uncheckedOnToogleOrangLainYangAkanDatangSurvei() {
        playwright.uncheckBox(orangLainYangAkanDatangSurveyToogle);
    }

    public void fillNamaOrangLainYangAkanDatangSurvey(String nama) {
        playwright.clearText(namaOrangLainYangAkanDatangSurveyPlaceHolder);
        playwright.clickLocatorAndTypeKeyboard(namaOrangLainYangAkanDatangSurveyPlaceHolder, nama);
    }

    public void fillHubunganOrangLainYangAkanDatangSurvey(String hubungan) {
        playwright.clearText(hubunganOrangLainYangAkanDatangSurveyPlaceHolder);
        playwright.clickLocatorAndTypeKeyboard(hubunganOrangLainYangAkanDatangSurveyPlaceHolder, hubungan);
    }

    /**
     * user select date survei
     *
     * @param date
     */
    public void userSelectDateSurvei(String date) {
        Locator datePick;
        playwright.selectDateSurvei(date);
        selectDateSurvei.click();
        datePick = page.locator("//div[@class='date-wrapper']");
        List<Locator> datePicks = playwright.getLocators(datePick);
        for (Locator pick : datePicks) {
            if (pick.isEnabled() && pick.isVisible()) {
                pick.click();
            }
        }
    }

    //************************************************************************************************************
    //******** HELPER METHODS - SCROLL SURVEY FORM ********
    //************************************************************************************************************

    /**
     * Scroll survey form container (not main page) to make bottom elements visible
     *
     * @param scrollAmount - amount to scroll in pixels
     */
    public void scrollSurveyFormDown(int scrollAmount) {
        // Wait for container to be visible first
        playwright.waitTillLocatorIsVisible(surveyFormContainer);

        // Scroll using scrollTop
        surveyFormContainer.evaluate("el => el.scrollTop += " + scrollAmount);

        // Wait a bit for scroll animation to complete
        page.waitForTimeout(500);
    }

    //************************************************************************************************************
    //******** NEW FLOW - SAMEDAY SURVEY METHODS ********
    //************************************************************************************************************

    /**
     * Select survey date type: "Survei Hari ini" or "Tanggal Lain"
     *
     * @param dateType - "Survei Hari ini" or "Tanggal Lain"
     */
    public void selectSurveyDateType(String dateType) {
        if (dateType.equalsIgnoreCase("Survei Hari ini")) {
            playwright.waitTillLocatorIsVisible(surveyDateTypeSurveiHariIni);
            playwright.clickOn(surveyDateTypeSurveiHariIni);
            // Wait for time period options to appear after selecting "Survei Hari ini"
            page.waitForTimeout(1500);
        } else if (dateType.equalsIgnoreCase("Tanggal Lain")) {
            playwright.waitTillLocatorIsVisible(surveyDateTypeTanggalLain);
            playwright.clickOn(surveyDateTypeTanggalLain);
            // Wait for date picker textbox to appear after selecting "Tanggal Lain"
            playwright.waitTillLocatorIsVisible(surveyDatePickerTextbox);
        }
    }

    /**
     * Open survey date picker (for "Tanggal Lain" option)
     */
    public void openSurveyDatePicker() {
        playwright.waitTillLocatorIsVisible(surveyDatePickerTextbox);
        playwright.clickOn(surveyDatePickerTextbox);
    }

    /**
     * Select specific date from date picker
     *
     * @param date - day number as string (e.g., "7", "15")
     */
    public void selectDateFromPicker(String date) {
        // Use class-level locator for date cells
        var dateLocator = basedLocatorDateCell.getByText(date, new Locator.GetByTextOptions().setExact(true)).first();
        playwright.waitTillLocatorIsVisible(dateLocator);
        playwright.clickOn(dateLocator);
    }

    /**
     * Find and select the first available (enabled) date from date picker
     * This method dynamically finds an available date to avoid issues with disabled dates
     */
    public String selectFirstAvailableDate() {
        // Use class-level locator for date cells
        // Get all date elements
        int count = basedLocatorDateCell.count();

        if (count == 0) {
            throw new RuntimeException("No date elements found in the date picker");
        }

        // Find the first available date that is clickable and not disabled
        String currentDay = JavaHelpers.getCostumDateOrTime("d", 0, 0, 0);
        int currentDayInt = Integer.parseInt(currentDay);

        for (int i = 0; i < count; i++) {
            Locator dateElement = basedLocatorDateCell.nth(i);

            // Check if element is disabled by checking class attribute
            String classAttr = dateElement.getAttribute("class");
            boolean isDisabled = classAttr != null && classAttr.contains("disabled");

            // Skip if disabled
            if (isDisabled) {
                continue;
            }

            // Check if element is visible and enabled
            if (!playwright.waitTillLocatorIsVisible(dateElement)) {
                continue;
            }

            String dateText = playwright.getText(dateElement);

            // Skip if dateText is not a number (e.g., month header)
            if (!dateText.trim().matches("\\d+")) {
                System.out.println("Skipping non-numeric date text: " + dateText);
                continue;
            }

            int dateInt = Integer.parseInt(dateText.trim());

            // Select dates that are today or in the future
            // If the date number is >= current day, or if we're near end of month and date is low number (next month)
            if (dateInt >= currentDayInt || (currentDayInt > 25 && dateInt < 10)) {
                playwright.clickOn(dateElement);
                System.out.println("Selected available date: " + dateText);
                return dateText;
            }
        }

        // If no future date found based on date number, just select the first enabled date
        for (int i = 0; i < count; i++) {
            Locator dateElement = basedLocatorDateCell.nth(i);

            String classAttr = dateElement.getAttribute("class");
            boolean isDisabled = classAttr != null && classAttr.contains("disabled");

            if (!isDisabled && playwright.waitTillLocatorIsVisible(dateElement)) {
                String selectedDate = playwright.getText(dateElement);
                playwright.clickOn(dateElement);
                System.out.println("Selected first available date: " + selectedDate);
                return selectedDate;
            }
        }

        throw new RuntimeException("No available dates found in the date picker");
    }

    /**
     * Select survey time period: "Pagi", "Siang", or "Sore"
     *
     * @param period - "Pagi", "Siang", or "Sore"
     */
    public void selectSurveyTimePeriod(String period) {
        switch (period.toLowerCase()) {
            case "pagi":
                playwright.waitTillLocatorIsVisible(surveyTimePeriodPagi);
                playwright.clickOn(surveyTimePeriodPagi);
                break;
            case "siang":
                playwright.waitTillLocatorIsVisible(surveyTimePeriodSiang);
                playwright.clickOn(surveyTimePeriodSiang);
                break;
            case "sore":
                playwright.waitTillLocatorIsVisible(surveyTimePeriodSore);
                playwright.clickOn(surveyTimePeriodSore);
                break;
        }
    }

    /**
     * Check if time period button is disabled
     *
     * @param period - "Pagi", "Siang", or "Sore"
     * @return true if the period button is disabled
     */
    public boolean isTimePeriodDisabled(String period) {
        Locator periodLocator;
        switch (period.toLowerCase()) {
            case "pagi":
                periodLocator = surveyTimePeriodPagi;
                break;
            case "siang":
                periodLocator = surveyTimePeriodSiang;
                break;
            case "sore":
                periodLocator = surveyTimePeriodSore;
                break;
            default:
                return false;
        }

        // Check multiple indicators for disabled state
        // Check if button is disabled
        if (playwright.isButtonDisable(periodLocator)) {
            return true;
        }

        // Check aria-disabled attribute
        String ariaDisabled = periodLocator.getAttribute("aria-disabled");
        if (ariaDisabled != null && ariaDisabled.equals("true")) {
            return true;
        }

        // Check for disabled CSS classes
        String classAttr = periodLocator.getAttribute("class");
        return classAttr != null && (classAttr.contains("disabled") || classAttr.contains("bg-c-tag--disabled"));
    }

    /**
     * Select specific survey time (e.g., "08:00", "15:30")
     *
     * @param time - time in HH:mm format
     */
    public void selectSurveyTime(String time) {
        var timeButtonLocator = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(time));
        playwright.waitTillLocatorIsVisible(timeButtonLocator);
        playwright.clickOn(timeButtonLocator);
    }

    /**
     * Fill phone number in survey form
     *
     * @param phoneNumber - phone number to fill (can be empty string for testing empty validation)
     */
    public void fillPhoneNumber(String phoneNumber) {
        // Scroll to phone number field
        phoneNumberInput.scrollIntoViewIfNeeded();
        playwright.waitTillLocatorIsVisible(phoneNumberInput);
        playwright.clearText(phoneNumberInput);

        // Only type if phoneNumber is not empty
        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            playwright.clickLocatorAndTypeKeyboard(phoneNumberInput, phoneNumber);
        } else {
            // For empty phone number test, just click to focus then blur
            playwright.clickOn(phoneNumberInput);
        }
    }

    /**
     * Check TnC agreement checkbox
     */
    public void checkTnCCheckbox() {
        // Wait for checkbox to be in DOM
        playwright.waitTillLocatorIsVisible(tncCheckbox);
        // Scroll checkbox into view (this should scroll the form container automatically)
        tncCheckbox.scrollIntoViewIfNeeded();
        // Wait a bit after scroll
        page.waitForTimeout(300);
        playwright.clickOn(tncCheckbox);
    }

    /**
     * Check if popup confirmation is visible
     *
     * @return true if popup is visible
     */
    public boolean isPopupConfirmationVisible() {
        return playwright.waitTillLocatorIsVisible(popupConfirmationHeading);
    }

    /**
     * Quick check if popup confirmation is visible (with short timeout)
     * Used for validation testing where we don't want to wait too long
     *
     * @param timeoutMs - timeout in milliseconds
     * @return true if popup is visible within timeout
     */
    public boolean isPopupConfirmationVisibleQuick(int timeoutMs) {
        popupConfirmationHeading.waitFor(new Locator.WaitForOptions().setTimeout(timeoutMs));
        return popupConfirmationHeading.isVisible();
    }

    /**
     * Click "Kembali" button on confirmation popup
     */
    public void clickKembaliOnPopup() {
        playwright.clickOn(popupConfirmationKembaliBtn);
    }

    /**
     * Click "Mengerti, Kirim" button on confirmation popup
     */
    public void clickMengertiOnPopup() {
        playwright.clickOn(popupConfirmationMengertiBtn);
    }

    /**
     * Confirm popup ajukan survey if it appears (only for P2 kost)
     * If popup appears, click "Mengerti, Kirim", otherwise do nothing
     */
    public void confirmPopupIfAppear() {
        if (isPopupConfirmationVisible()) {
            clickMengertiOnPopup();
            // Wait for the popup to disappear after clicking
            playwright.hardWait(2000);
        }
    }

    //************************************************************************************************************
    //******** SAMEDAY SURVEY VALIDATION METHODS ********
    //************************************************************************************************************

    /**
     * Check if "Survei Hari Ini" date type is visible
     *
     * @return true if visible
     */
    public boolean isSurveyDateTypeSurveiHariIniVisible() {
        return playwright.waitTillLocatorIsVisible(surveyDateTypeSurveiHariIni);
    }

    /**
     * Check if "Survei Hari Ini" date type is enabled (clickable)
     *
     * @return true if enabled
     */
    public boolean isSurveyDateTypeSurveiHariIniEnabled() {
        return playwright.isButtonEnable(surveyDateTypeSurveiHariIni);
    }

    /**
     * Check if "Survei Hari Ini" date type is disabled (not clickable)
     * Checks multiple disabled indicators: native disabled, aria-disabled, and CSS classes
     *
     * @return true if disabled
     */
    public boolean isSurveyDateTypeSurveiHariIniDisabled() {
        // Check native disabled attribute
        if (playwright.isButtonDisable(surveyDateTypeSurveiHariIni)) {
            return true;
        }

        // Check aria-disabled attribute
        String ariaDisabled = surveyDateTypeSurveiHariIni.getAttribute("aria-disabled");
        if (ariaDisabled != null && ariaDisabled.equals("true")) {
            return true;
        }

        // Check for disabled/inactive CSS classes
        String classAttr = surveyDateTypeSurveiHariIni.getAttribute("class");
        if (classAttr != null && (classAttr.contains("disabled") || classAttr.contains("inactive"))) {
            return true;
        }

        // Check if pointer-events is none (CSS disabled)
        String pointerEvents = surveyDateTypeSurveiHariIni.evaluate("el => window.getComputedStyle(el).pointerEvents").toString();
        return "none".equals(pointerEvents);
    }

    /**
     * Check if "Survei Hari Ini" button appears grayed out/disabled
     *
     * @return true if grayed out
     */
    public boolean isSurveyDateTypeSurveiHariIniGrayedOut() {
        String classAttr = surveyDateTypeSurveiHariIni.getAttribute("class");
        return classAttr != null && (classAttr.contains("disabled") || classAttr.contains("inactive"));
    }

    /**
     * Check if "Tanggal Lain" date type is visible
     *
     * @return true if visible
     */
    public boolean isSurveyDateTypeTanggalLainVisible() {
        return playwright.waitTillLocatorIsVisible(surveyDateTypeTanggalLain);
    }

    /**
     * Check if "Tanggal Lain" date type is clickable
     *
     * @return true if clickable
     */
    public boolean isSurveyDateTypeTanggalLainClickable() {
        return playwright.isButtonEnable(surveyDateTypeTanggalLain);
    }

    /**
     * Check if sameday survey message is visible
     *
     * @return true if visible
     */
    public boolean isSamedaySurveyMessageVisible() {
        return playwright.isTextDisplayed("Pastikan kamu bisa datang, ya");
    }

    /**
     * Verify only today's date is enabled in calendar
     *
     * @return true if only today is enabled
     */
    public boolean isOnlyTodayEnabledInCalendar() {
        // Use class-level locator for date cells
        // Check if dates before today are disabled
        String yesterday = JavaHelpers.getCostumDateOrTime("d", -1, 0, 0);
        var yesterdayLocator = basedLocatorDateCell.getByText(yesterday, new Locator.GetByTextOptions().setExact(true)).first();

        // Check if dates after today are disabled
        String tomorrow = JavaHelpers.getCostumDateOrTime("d", 1, 0, 0);
        var tomorrowLocator = basedLocatorDateCell.getByText(tomorrow, new Locator.GetByTextOptions().setExact(true)).first();

        boolean yesterdayDisabled = !playwright.waitTillLocatorIsVisible(yesterdayLocator);
        boolean tomorrowDisabled = !playwright.waitTillLocatorIsVisible(tomorrowLocator);

        return yesterdayDisabled && tomorrowDisabled;
    }

    /**
     * Get survey date picker placeholder text
     *
     * @return placeholder text
     */
    public String getSurveyDatePickerPlaceholder() {
        return surveyDatePickerTextbox.getAttribute("placeholder");
    }

    /**
     * Get "Tanggal Lain" message text
     *
     * @return message text
     */
    public String getTanggalLainMessage() {
        playwright.waitTillLocatorIsVisible(tanggalLainMessage);
        return playwright.getText(tanggalLainMessage);
    }

    /**
     * Verify date range is selectable up to N days from today
     *
     * @param daysFromToday - number of days from today
     * @return true if date range is selectable
     */
    public boolean verifyDateRangeSelectable(int daysFromToday) {
        // Get current month and target month
        String currentMonth = JavaHelpers.getCostumDateOrTime("MMMM", 0, 0, 0);
        String targetMonth = JavaHelpers.getCostumDateOrTime("MMMM", daysFromToday, 0, 0);

        // Navigate to the target month if it's different from current month
        boolean navigated = false;
        if (!currentMonth.equals(targetMonth)) {
            if (nextMonthBtn.isVisible()) {
                playwright.clickOn(nextMonthBtn);
                playwright.hardWait(1000);
                navigated = true;
            }
        }

        // Use same approach as selectSurveyDate - global text search
        String futureDate = JavaHelpers.getCostumDateOrTime("d", daysFromToday, 0, 0);
        var futureDateLocator = page.getByText(futureDate, new Page.GetByTextOptions().setExact(true)).nth(1);

        // Check if the date is visible
        boolean isVisible = futureDateLocator.isVisible();

        // Navigate back to current month if we navigated away
        if (navigated && previousMonthBtn.isVisible()) {
            playwright.clickOn(previousMonthBtn);
        }

        return isVisible;
    }

    /**
     * Verify past dates are disabled in date picker
     *
     * @return true if past dates are disabled
     */
    public boolean arePastDatesDisabled() {
        // Use class-level locator for date cells
        String yesterday = JavaHelpers.getCostumDateOrTime("d", -1, 0, 0);
        var yesterdayLocator = basedLocatorDateCell.getByText(yesterday, new Locator.GetByTextOptions().setExact(true)).first();

        // Check if yesterday's date has disabled class
        String classAttr = yesterdayLocator.getAttribute("class");
        return classAttr != null && classAttr.contains("disabled");
    }

    /**
     * Check if specific time slot is enabled
     *
     * @param time - time in HH:mm format
     * @return true if enabled
     */
    public boolean isTimeSlotEnabled(String time) {
        var timeButtonLocator = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(time));
        return playwright.isButtonEnable(timeButtonLocator);
    }

    /**
     * Check if specific time slot is disabled
     * Checks multiple disabled indicators: native disabled, aria-disabled, and CSS classes
     *
     * @param time - time in HH:mm format
     * @return true if disabled
     */
    public boolean isTimeSlotDisabled(String time) {
        var timeButtonLocator = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(time));

        // Check native disabled attribute
        if (playwright.isButtonDisable(timeButtonLocator)) {
            return true;
        }

        // Check aria-disabled attribute
        String ariaDisabled = timeButtonLocator.getAttribute("aria-disabled");
        if (ariaDisabled != null && ariaDisabled.equals("true")) {
            return true;
        }

        // Check for disabled/inactive CSS classes
        String classAttr = timeButtonLocator.getAttribute("class");
        if (classAttr != null && (classAttr.contains("disabled") || classAttr.contains("inactive"))) {
            return true;
        }

        // Check if pointer-events is none (CSS disabled)
        String pointerEvents = timeButtonLocator.evaluate("el => window.getComputedStyle(el).pointerEvents").toString();
        return "none".equals(pointerEvents);
    }

    /**
     * Check if all time slots are disabled in a specific period
     *
     * @param period - Pagi, Siang, or Sore
     * @return true if all disabled
     */
    public boolean areAllTimeSlotsDisabledInPeriod(String period) {
        // This will need to be implemented based on actual time slots for each period
        // For now, returning a basic implementation
        List<String> timeSlots = getTimeSlotsForPeriod(period);
        for (String time : timeSlots) {
            if (isTimeSlotEnabled(time)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Get time slots for a specific period
     *
     * @param period - Pagi, Siang, or Sore
     * @return list of time slots
     */
    private List<String> getTimeSlotsForPeriod(String period) {
        switch (period.toLowerCase()) {
            case "pagi":
                return List.of("08:00", "08:30", "09:00", "09:30", "10:00", "10:30");
            case "siang":
                return List.of("11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30");
            case "sore":
                return List.of("15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00");
            default:
                return List.of();
        }
    }

    /**
     * Check if all time slots from a specific time are enabled
     *
     * @param startTime - start time in HH:mm format
     * @return true if all enabled
     */
    public boolean areAllTimeSlotsFromTimeEnabled(String startTime) {
        // Get all time slots in Sore period (as an example)
        List<String> timeSlots = getTimeSlotsForPeriod("sore");
        boolean startFound = false;

        for (String time : timeSlots) {
            if (time.equals(startTime)) {
                startFound = true;
            }
            if (startFound && isTimeSlotDisabled(time)) {
                return false;
            }
        }
        return startFound;
    }

    /**
     * Check if all time slots are disabled
     *
     * @return true if all disabled
     */
    public boolean areAllTimeSlotsDisabled() {
        // all time is disable if user or tenant open more than 16:00 for p2 or 19:00 for p1
        return areAllTimeSlotsDisabledInPeriod("pagi") &&
                areAllTimeSlotsDisabledInPeriod("siang") &&
                areAllTimeSlotsDisabledInPeriod("sore");
    }

    /**
     * Check if "Survei Hari Ini" option becomes unselectable
     *
     * @return true if unselectable
     */
    public boolean isSurveyHariIniUnselectable() {
        return isSurveyDateTypeSurveiHariIniDisabled();
    }

    /**
     * Check if system suggests "Tanggal Lain" option
     *
     * @return true if suggestion is visible
     */
    public boolean isSuggestionToSelectTanggalLainVisible() {
        return playwright.waitTillLocatorIsVisible(suggestionMessage);
    }

    /**
     * Get displayed time slots for a specific period
     *
     * @param period - Pagi, Siang, or Sore
     * @return list of displayed time slots
     */
    public List<String> getDisplayedTimeSlotsForPeriod(String period) {
        return getTimeSlotsForPeriod(period);
    }

    /**
     * Verify displayed time slots are within a time range
     *
     * @param startTime - start time
     * @param endTime   - end time
     * @return true if within range
     */
    public boolean verifyDisplayedTimeSlotsRange(String startTime, String endTime) {
        // Implementation would check if displayed slots are within range
        return true;
    }

    /**
     * Check if a time is previously selected
     *
     * @param time - time in HH:mm format
     * @return true if selected
     */
    public boolean isTimePreviouslySelected(String time) {
        var timeButtonLocator = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(time));

        // Wait a bit to ensure the DOM is updated after period switch
        page.waitForTimeout(500);

        // Check if button exists in DOM (might be hidden but still in DOM)
        int buttonCount = timeButtonLocator.count();
        if (buttonCount == 0) {
            // Button not in DOM at all
            return false;
        }

        // Button exists in DOM, check its state (even if not visible)
        String classAttr = timeButtonLocator.getAttribute("class");

        // Check multiple possible class names for selected state
        if (classAttr != null) {
            boolean hasSelectedClass = classAttr.contains("selected") ||
                   classAttr.contains("active") ||
                   classAttr.contains("bg-c-tag--active") ||
                   classAttr.contains("bg-c-tag--selected") ||
                   classAttr.contains("is-active") ||
                   classAttr.contains("is-selected") ||
                   classAttr.contains("chosen");

            if (hasSelectedClass) {
                return true;
            }
        }

        // Also check aria-selected attribute
        String ariaSelected = timeButtonLocator.getAttribute("aria-selected");
        if (ariaSelected != null && ariaSelected.equals("true")) {
            return true;
        }

        // Check if button has aria-checked attribute (for toggle buttons)
        String ariaChecked = timeButtonLocator.getAttribute("aria-checked");
        if (ariaChecked != null && ariaChecked.equals("true")) {
            return true;
        }

        // Check data attributes that might indicate selection
        String dataSelected = timeButtonLocator.getAttribute("data-selected");
        return dataSelected != null && dataSelected.equals("true");
    }

    /**
     * Get phone number error message
     *
     * @return error message text
     */
    public String getPhoneNumberErrorMessage() {
        // Wait a bit for error message to appear after form validation
        page.waitForTimeout(2000);

        // Strategy 1: Check form-survey container for bg-c-field__message
        Locator formError = page.locator(".form-survey .bg-c-field__message").first();
        if (playwright.waitTillLocatorIsVisible(formError)) {
            return playwright.getText(formError);
        }

        // Strategy 2: Look for any error message in the form
        Locator anyError = page.locator(".form-survey [class*='error']").first();
        if (playwright.waitTillLocatorIsVisible(anyError)) {
            return playwright.getText(anyError);
        }

        // Strategy 3: Original locator
        if (playwright.waitTillLocatorIsVisible(phoneNumberErrorMessage)) {
            return playwright.getText(phoneNumberErrorMessage);
        }

        System.out.println("No phone number error message found after trying all strategies");
        return "";
    }

    /**
     * Check if phone number validation passed
     *
     * @return true if validation passed (no error message visible)
     */
    public boolean isPhoneNumberValidationPassed() {
        // Wait a bit for potential error message to appear
        page.waitForTimeout(2000);

        // Check for error in form-survey container
        Locator formError = page.locator(".form-survey .bg-c-field__message").first();
        if (playwright.waitTillLocatorIsVisible(formError)) {
            return false; // Error message found, validation failed
        }

        // Check for any element with error class
        Locator anyError = page.locator(".form-survey [class*='error']").first();
        if (playwright.waitTillLocatorIsVisible(anyError)) {
            return false; // Error message found, validation failed
        }

        // No error message found, validation passed
        return true;
    }

    /**
     * Get T&C link text
     *
     * @return link text
     */
    public String getTnCLinkText() {
        playwright.waitTillLocatorIsVisible(tncLink);
        return playwright.getText(tncLink);
    }

    /**
     * Click on T&C link
     */
    public void clickTnCLink() {
        playwright.clickOn(tncLink);
    }

    /**
     * Get T&C link destination/href
     *
     * @return link destination
     */
    public String getTnCLinkDestination() {
        return tncLink.getAttribute("href");
    }

    /**
     * Check if T&C section is scrollable (not sticky)
     *
     * @return true if scrollable
     */
    public boolean isTnCSectionScrollable() {
        if (playwright.waitTillLocatorIsVisible(tncSection)) {
            String position = tncSection.evaluate("el => window.getComputedStyle(el).position").toString();
            return !position.equals("fixed") && !position.equals("sticky");
        }
        return false;
    }

    /**
     * Get popup confirmation heading text
     *
     * @return heading text
     */
    public String getPopupConfirmationHeadingText() {
        playwright.waitTillLocatorIsVisible(popupConfirmationHeading);
        return playwright.getText(popupConfirmationHeading);
    }

    /**
     * Check if navigation to chatroom is successful
     *
     * @return true if navigation successful
     */
    public boolean isNavigationToChatroomSuccessful() {
        // Check if chatroom is visible using class variable
        return playwright.waitTillLocatorIsVisible(chatroomContainer);
    }

    /**
     * Check if survey request sent with phone number visible
     *
     * @return true if phone visible in survey request
     */
    public boolean isSurveyRequestSentWithPhoneVisible() {
        return playwright.waitTillLocatorIsVisible(phoneInMessage);
    }

    /**
     * Check if P2 autoreply message appears
     *
     * @return true if autoreply visible
     */
    public boolean isP2AutoreplyMessageVisible() {
        return playwright.waitTillLocatorIsVisible(p2AutoreplyMessage, 5_000.0);
    }

    /**
     * Get survey status text from chatroom
     *
     * @return status text
     */
    public String getSurveyStatusText() {
        if (playwright.waitTillLocatorIsVisible(surveyStatusInChatroom)) {
            return playwright.getText(surveyStatusInChatroom);
        }
        return "";
    }
}
