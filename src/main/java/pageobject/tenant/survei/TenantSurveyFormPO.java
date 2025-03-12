package pageobject.tenant.survei;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TenantSurveyFormPO {
    private Page page;
    private PlaywrightHelpers playwright;

    Locator dateOption;
    Locator dateViewSelected;
    Locator dateViewToday;
    Locator nextMonthBtn;
    Locator previousMonthBtn;
    Locator timeOption;
    Locator editProfileBtn;
    Locator profileNamePlaceHolder;
    Locator genderPlaceHolder;
    Locator saveProfileBtn;
    Locator popUpSuccessSaveProfileText;
    Locator ajukanSurveyBtn;
    Locator chevronDetailSurvei;
    Locator inputTextbox;
    Locator chevronToDetailSurvey;

    public TenantSurveyFormPO(Page page) {
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        dateOption = page.getByPlaceholder("Pilih tanggal survei kos");
        dateViewSelected = page.locator("//div[@class='chat-sheet']").locator(".selected");
        dateViewToday = page.locator("//span[@class='cell day selected today']");
        nextMonthBtn = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("arrow-right"));
        previousMonthBtn = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("arrow-left"));
        timeOption = page.getByTestId("available-time");
        editProfileBtn = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("edit"));
        profileNamePlaceHolder = page.getByPlaceholder("Masukkan nama lengkap kamu");
        genderPlaceHolder = page.getByText("Jenis Kelamin Laki-laki Perempuan Laki-laki dropdown-down Laki-laki Perempuan").locator("span");
        saveProfileBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Simpan").setExact(true));
        popUpSuccessSaveProfileText = page.locator(".mc-chat-room__toast");
        ajukanSurveyBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ajukan Survei"));
        chevronDetailSurvei = page.locator("//div[@class='mc-product-card__tenant-survey-detail']");
        inputTextbox = page.locator("//textarea[@placeholder='Ceritakan secara singkat dan jelas.']");
        chevronToDetailSurvey = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("chevron-right"));
    }

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
        var locator = page.getByText(date, new Page.GetByTextOptions().setExact(true)).nth(1);
        return !playwright.waitTillLocatorIsVisible(locator);
    }

    public void tapOnSurveyTimeOption() {
        playwright.clickOn(timeOption);
    }

    public String[] getCurrentAvailableTime() {
        var timeAvailable = playwright.getText(timeOption);

        // this condition will prevent if automation run more than 19:00
        if (timeAvailable.equals("There is no data")) {
            var timeCustom = JavaHelpers.getModifiedTimeGMT7(1);
            return extractAllTimes(timeCustom);
        }

        return extractAllTimes(timeAvailable);
    }

    public void selectTimeOption(String time) {
        var timeOptionLocator = page.locator("a").filter(new Locator.FilterOptions().setHasText(time));
        playwright.clickOn(timeOptionLocator);
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
        playwright.clickOn(ajukanSurveyBtn);
    }


    //******** Private METHOD PART ********

    /**
     * Extracts all valid time strings in "HH:mm" format from a given string.
     *
     * @param text The input string containing multiple times.
     * @return Array of valid time strings in "HH:mm" format.
     */
    private String[] extractAllTimes(String text) {
        List<String> times = new ArrayList<>();

        // Define a regex pattern to match "HH:mm" format (24-hour time)
        Pattern pattern = Pattern.compile("\\b(\\d{2}:\\d{2})\\b");
        Matcher matcher = pattern.matcher(text);

        // Find all occurrences and add to list
        while (matcher.find()) {
            times.add(matcher.group(1));
        }

        // Convert List to String[]
        return times.toArray(new String[0]);
    }

    /**
     * Click on detail survei
     *
     */
    public void userClickOnChevronDetailSurvei() {
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

}
