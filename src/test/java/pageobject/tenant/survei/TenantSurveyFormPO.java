package pageobject.tenant.survei;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

public class TenantSurveyFormPO {
    private Page page;
    private PlaywrightHelpers playwright;

    Locator clockOption;
    Locator editProfileBtn;
    Locator profileNamePlaceHolder;
    Locator saveProfileBtn;
    Locator popUpSuccessSaveProfileText;

    public TenantSurveyFormPO(Page page) {
        this.page = page;
        playwright = new PlaywrightHelpers(page);

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
}
