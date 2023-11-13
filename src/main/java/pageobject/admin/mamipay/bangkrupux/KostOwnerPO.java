package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import utilities.PlaywrightHelpers;

public class KostOwnerPO {
    private Page page;
    PlaywrightHelpers playwright;
    Locator kosNameSearch;
    Locator firstBBKDataButton;
    Locator firstRejectButton;
    Locator firstRejectReasonRadioButton;
    Locator rejectButton;
    Locator verifyIcon;
    Locator statusProperty;
    Locator alertMessage;
    Locator firstVerifyButton;
    Locator firstDeleteButton;
    Locator actionDropdown;
    Locator deleteKost;


    public KostOwnerPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        kosNameSearch = page.getByPlaceholder("Nama Kost", new Page.GetByPlaceholderOptions().setExact(true));
        firstBBKDataButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("BBK Data"));
        firstRejectButton = page.locator("//a[contains(.,'Edit Kost')]");
        firstRejectReasonRadioButton = page.locator("//div[@class='iradio_minimal']");
        rejectButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Reject").setExact(true));

        alertMessage = page.locator("//div[@class='alert alert-success alert-dismissable']");

        firstVerifyButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("").setExact(true));
    }

    /**
     * Search kos name then hit enter
     * @param kosName of Kos Name
     */
    public void searchKosName(String kosName) {
        kosNameSearch.fill(kosName);
        page.keyboard().press("Enter");
    }

    /**
     * Click on first BBK Data button
     */
    public void clickOnFirstBBKDataButton() {
        page = page.waitForPopup(() -> {
            playwright.clickOn(firstBBKDataButton);
        });
    }

    /**
     * Click on first Reject BBK button
     */
    public void clickOnFirstRejectButton() {
        playwright.hardWait(2000.0);
        page = ActiveContext.getActivePage();
        firstRejectButton.click();
    }

    /**
     * Click on first radio button
     */
    public void clickOnFirstRadioButton() {
        playwright.pageScrollUntilElementIsVisible(firstRejectReasonRadioButton);
        playwright.clickOn(firstRejectReasonRadioButton);
    }

    /**
     * Click on Reject BBK button
     */
    public void clickOnRejectButton() {
        playwright.clickOn(rejectButton);
    }

    /**
     * Click verify icon
     * @param property
     *
     */
    public void clickOnVerifyIcon(String property) {
        verifyIcon = page.locator("//td[contains(., '"+ property +"')]/following-sibling::*//i[@class='fa fa-check']");
        playwright.clickOn(verifyIcon);
    }

    /**
     * Get alert message after doing action
     * @return alertMessage
     *
     */
    public String getAlertMessage() {
        playwright.waitTillLocatorIsVisible(alertMessage);
        return playwright.getText(alertMessage).replaceAll("×\\s+", "");

    }
    /**
     * Click on first verify button
     */
    public void clickOnFirstVerifyButton() {
        playwright.clickOn(firstVerifyButton);
    }

    /**
     * Navigate to url delete kos on admin
     *
     */
    public void navigateToDeleteUrl() {
        playwright.navigateTo(this.getKosListDeleteUrl());
    }

    /**
     * Get url list kos delete
     *
     * @return attribute href from firstDeleteButton
     */
    public String getKosListDeleteUrl() {
        firstDeleteButton = page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName(Mamikos.getPropertyKosName())).getByTitle("Delete").first();
        return playwright.getAttributeValue(firstDeleteButton, "href");
    }
}
