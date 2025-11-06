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

    public TenantSurveyFormPO(Page page) {
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        dateOption = page.getByPlaceholder("Pilih tanggal survei kos");
        dateViewSelected = page.locator("//div[@class='chat-sheet']").locator(".selected");
        dateViewToday = page.locator("//span[@class='cell day selected today']");
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
        tncCheckbox = page.locator("span").filter(new Locator.FilterOptions().setHasText("checkmark"));
        popupConfirmationHeading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Pastikan Datamu Benar"));
        popupConfirmationKembaliBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kembali"));
        popupConfirmationMengertiBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Mengerti, Kirim"));
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


    public boolean isAjukanSurveyBtnDisable() {
        return playwright.isButtonDisable(ajukanSurveyBtn);
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

        var basedLocator = page.locator("//div[@class='date-wrapper__cell-parent']/span[@class='cell day']");

        var date = basedLocator.getByText(randomStr).first();

        if (!playwright.waitTillLocatorIsVisible(date)) {
            randomStr = String.valueOf(randomNum + 1);
            date = basedLocator.getByText(randomStr).first();
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

        // Try multiple scroll approaches
        try {
            // Approach 1: Direct scrollTop
            surveyFormContainer.evaluate("el => el.scrollTop += " + scrollAmount);
        } catch (Exception e1) {
            try {
                // Approach 2: Scroll using scrollTo
                surveyFormContainer.evaluate("el => el.scrollTo({top: el.scrollTop + " + scrollAmount + ", behavior: 'smooth'})");
            } catch (Exception e2) {
                // Approach 3: Force scroll on body inside container
                surveyFormContainer.evaluate("el => { const target = el.scrollTop + " + scrollAmount + "; el.scrollTop = target; }");
            }
        }

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
        var dateLocator = page.getByText(date, new Page.GetByTextOptions().setExact(true));
        playwright.waitTillLocatorIsVisible(dateLocator);
        playwright.clickOn(dateLocator);
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
     * @param phoneNumber - phone number to fill
     */
    public void fillPhoneNumber(String phoneNumber) {
        // Scroll to phone number field
        phoneNumberInput.scrollIntoViewIfNeeded();
        playwright.waitTillLocatorIsVisible(phoneNumberInput);
        playwright.clearText(phoneNumberInput);
        playwright.clickLocatorAndTypeKeyboard(phoneNumberInput, phoneNumber);
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
        try {
            if (isPopupConfirmationVisible()) {
                clickMengertiOnPopup();
            }
        } catch (Exception e) {
            // Popup not visible, continue
        }
    }
}
