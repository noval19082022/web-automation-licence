package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;


public class BlacklistUserPO {
    private Page page;
    private PlaywrightHelpers playwright;
    Locator blacklistUserMenu;
    Locator resultBlacklistFilter;
    Locator searchUserButton;
    Locator blacklistAUserButton;
    Locator valueTextBox;
    Locator continueButton;
    Locator userIDLabel;
    Locator userNameLabel;
    Locator phoneNumberLabel;
    Locator emailLabel;
    Locator noteTextBox;
    Locator submitButton;
    Locator adminSuccessMessage;
    Locator accountBlacklistMessage;
    Locator unblacklistBtn;
    Locator blacklistBtn;

    public BlacklistUserPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        blacklistUserMenu = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Blacklist User"));
        searchUserButton =  page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search user"));
        blacklistAUserButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Blacklist a user"));
        valueTextBox = page.locator("[name='blacklistValue']");
        continueButton = page.locator("//*[@class='btn btn-danger']");
        userIDLabel = page.locator("//label[contains(text(), 'User ID')]/parent::div");
        userNameLabel = page.locator("//label[contains(text(), 'User Name')]/parent::div");
        phoneNumberLabel = page.locator("//label[contains(text(), 'Phone Number')]/parent::div");
        emailLabel = page.locator("//label[contains(text(), 'Email')]/parent::div");
        noteTextBox = page.locator("[name='note']");
        submitButton = page.locator(".btn-danger");
        adminSuccessMessage = page.locator(".alert");
        accountBlacklistMessage = page.getByText("Ada kendala pada akun Anda. Harap hubungi customer service Mamikos.");
        unblacklistBtn = page.locator(".btn-success");
        blacklistBtn = page.locator("//a[.='Blacklist']");
    }

    /**
     * click menu Blacklist User
     */
    public void clickBlacklistUserMenu() {
        playwright.clickOn(blacklistUserMenu);
    }

    /**
     * Select DropDown
     * @param dropDown String type search by
     */
    public void selectBlacklistSearchBy(String dropDown, String value) {
        page.getByRole(AriaRole.COMBOBOX).selectOption(dropDown);
        page.getByRole(AriaRole.TEXTBOX).fill(value);
        playwright.clickOn(searchUserButton);
    }

    /**
     *
     * @param value String value search by
     * @return result after choose search by
     */
    public String getResultSearchBy (String value) {
        resultBlacklistFilter = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(value));
        return playwright.getText(resultBlacklistFilter);
    }

    /**
     * click button Blacklist a User
     */
    public void clickBlacklistUserAButton() {
        playwright.clickOn(blacklistAUserButton);
    }

    /**
     * user input phone number
     * user choose dropdown
     * user click continue button
     */
    public void insertPhoneNumberBlacklistAUser(String phoneNumber) {
        page.getByRole(AriaRole.COMBOBOX).selectOption("phone_number");
        valueTextBox.fill(phoneNumber);
        playwright.clickOn(continueButton);
    }

    /**
     * Check whether User ID appear/not
     * @return true if User ID present
     */
    public boolean isUserIDPresent() {
        return userIDLabel.isVisible();
    }

    /**
     * Check whether Userame appear/not
     * @return true if Username present
     */
    public boolean isUserNamePresent() {
        return userNameLabel.isVisible();
    }

    /**
     * Check whether Phone Number appear/not
     * @return true if Phone Number present
     */
    public boolean isPhoneNumberPresent() {
        return phoneNumberLabel.isVisible();
    }

    /**
     * Check whether Email appear/not
     * @return true if email present
     */
    public boolean isEmailPresent() {
        return emailLabel.isVisible();
    }

    /**
     * user input note
     *
     */
    public void insertNote(String note) {
        noteTextBox.fill(note);
    }

    /**
     * click button Submit
     */
    public void clickSubmitButton() {
        playwright.clickOn(submitButton);
    }

    /**
     * Check whether success message appear/not
     * @return true if success message present
     */
    public boolean isSuccessMessagePresent() {
        return adminSuccessMessage.isVisible();
    }

    /**
     * get message after account blacklist
     */
    public String getMessageAcoountBlacklist() {
        return playwright.getText(accountBlacklistMessage);
    }

    /**
     * click button Unblacklist user
     */
    public void clickUnblacklistButton() {
        playwright.clickOn(unblacklistBtn);
    }

    /**
     * click blacklist button on home page
     */
    public void clickBlacklistButtonOnHomepage() {
        playwright.clickOn(blacklistBtn);
    }
}
