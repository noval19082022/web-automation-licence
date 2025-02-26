package pageobject.tenant.survei;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

public class TenantSurveyFormPO {
    private Page page;
    private PlaywrightHelpers playwright;

    Locator dateOption;
    Locator dateViewSelected;
    Locator dateViewToday;
    Locator nextMonthBtn;
    Locator previousMonthBtn;
    Locator clockOption;
    Locator editProfileBtn;
    Locator profileNamePlaceHolder;
    Locator saveProfileBtn;
    Locator popUpSuccessSaveProfileText;

    public TenantSurveyFormPO(Page page) {
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        dateOption = page.getByPlaceholder("Pilih tanggal survei kos");
        dateViewSelected = page.locator("//div[@class='chat-sheet']").locator(".selected");
        dateViewToday = page.locator("//span[@class='cell day selected today']");
        nextMonthBtn = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("arrow-right"));
        previousMonthBtn = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("arrow-left"));
        clockOption = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih jam dropdown-down"));
        editProfileBtn = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("edit"));
        profileNamePlaceHolder = page.getByPlaceholder("Masukkan nama lengkap kamu");
        saveProfileBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Simpan").setExact(true));
        popUpSuccessSaveProfileText = page.locator(".mc-chat-room__toast");
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
}
