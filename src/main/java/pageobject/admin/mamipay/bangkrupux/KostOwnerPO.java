package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import utilities.PlaywrightHelpers;

public class KostOwnerPO {
    private Page page;
    PlaywrightHelpers playwright;
    Locator kosNameSearch;
    Locator kosNameSearchBookingOwnerRequest;
    Locator firstBBKDataButton;
    Locator firstRejectButton;
    Locator firstRejectReasonRadioButton;
    Locator rejectButton;
    Locator verifyIcon;
    Locator alertMessage;
    Locator verifyButton;
    Locator firstDeleteButton;
    Locator firstRejectKosButton;
    Locator reasonRejectonCheckbox;
    Locator phoneOwnerSearch;
    Locator rejectBbkButton;
    Locator firstApproveButton;
    Locator updateStatus;
    Locator actionBox;

    public KostOwnerPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        kosNameSearch = page.getByPlaceholder("Nama Kost", new Page.GetByPlaceholderOptions().setExact(true));
        kosNameSearchBookingOwnerRequest =page.locator("//input[@placeholder='Kost name']");
        firstBBKDataButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("BBK Data"));
        firstRejectButton = page.locator("//a[contains(.,'Edit Kost')]");
        alertMessage = page.locator("//div[@class='alert alert-success alert-dismissable']");
        verifyButton = page.locator("//*[@title='Verify']");
        firstRejectKosButton = page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName(Mamikos.getPropertyKosName())).getByTitle("Alasan ditolak");
        firstDeleteButton = page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName(Mamikos.getPropertyKosName())).getByTitle("Delete").first();
        phoneOwnerSearch = page.getByPlaceholder("No. Telp. Owner");
        firstApproveButton = page.locator("(//a[@title='Verify'])[1]");
        rejectBbkButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Reject").setExact(true));
        firstRejectReasonRadioButton = page.locator("//div[@class='iradio_minimal']");
        rejectButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Reject").setExact(true));
        updateStatus = page.getByText("× Success! Room has been successfully updated");
        actionBox = page.locator(".btn-action-group");
    }

    /**
     * Search kos name then hit enter
     * @param kosName of Kos Name
     */
    public void searchKosName(String kosName) {
        playwright.clickLocatorAndTypeKeyboard(kosNameSearch, kosName);
        playwright.pressKeyboardKey("Enter");
        playwright.waitTillPageLoaded(3e5);
    }

    /**
     * Search kos name then hit enter
     * @param kosName of Kos Name
     */
    public void searchKosNameBookingOwnerRequest(String kosName) {
        playwright.clickLocatorAndTypeKeyboard(kosNameSearchBookingOwnerRequest, kosName);
        playwright.pressKeyboardKey("Enter");
        playwright.hardWait(1_000.0);
        playwright.waitTillPageLoaded();
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
     *
     */
    public void clickOnFirstRadioButton() {
        playwright.pageScrollUntilElementIsVisible(firstRejectReasonRadioButton);
        playwright.clickOn(firstRejectReasonRadioButton);
    }

    /**
     * Click on Reject bulk BBK button
     */
    public void clickOnRejectBulkButton() {
        var rejectBulkButton = ActiveContext.getActivePage().getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Reject Bulk"));
        playwright.clickOn(rejectBulkButton);
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
        playwright.waitForSelectorState(actionBox.first(), WaitForSelectorState.ATTACHED, 3e5);
        playwright.clickIfElementVisible(verifyButton.first(), updateStatus, 30000.0);
        playwright.waitTillPageLoaded(30000.0);
    }

    /**
     * Click on first verify button if exist
     */
    public void clickOnFirstVerifyButtonIfExist() {
        if (playwright.waitTillLocatorIsVisible(verifyButton, 5000.0)) {
            playwright.clickOn(verifyButton);
        }
        playwright.waitTillPageLoaded(5000.0);
    }

    /**
     * Navigate to url delete kos on admin
     *
     */
    public void navigateToDeleteUrl() {
        playwright.navigateTo(this.getKosListDeleteUrl());
    }

    /**
     * Navigate to url approve kos on admin
     *
     */
    public void navigateToApproveUrl() {
        playwright.navigateTo(this.getKosListApproveUrl());
    }

    /**
     * Get url list kos delete
     *
     * @return attribute href from firstDeleteButton
     */
    public String getKosListDeleteUrl() {
        playwright.waitTillPageLoaded();
        return playwright.getAttributeValue(firstDeleteButton, "href");
    }

    /**
     * Get url list kos active
     *
     * @return attribute href from firstDeleteButton
     */
    public String getKosListApproveUrl() {
        return playwright.getAttributeValue(firstApproveButton, "href");
    }

    /**
     * Get url list kos reject
     * @return attribute href from firstRejectKosButton
     *
     */
    public String getKosListRejectUrl() {
        return playwright.getAttributeValue(firstRejectKosButton, "href");
    }

    /**
     * Navigate to reject kos on admin
     *
     *
     */
    public void navigateToRejectUrl() {
        playwright.navigateTo(this.getKosListRejectUrl());
    }

    /**
     * Select the reject reason
     * @param reason
     *
     */
    public void selectRejectReason(String reason) {
        reasonRejectonCheckbox = page.locator("label").filter(new Locator.FilterOptions().setHasText(reason)).locator("span");
        playwright.clickOn(reasonRejectonCheckbox);
    }

    /**
     * Click on reject button
     * @param text
     */
    public void clickOnRejectKos(String text) {
        playwright.clickOnTextButton(text);
    }

    /**
     * Click on send button
     * @param text
     *
     */
    public void clickOnSendReject(String text) {
        playwright.clickOnTextButton(text);
    }

    /**
     * Click Reject button on request BBK form
     */
    public void clickOnRejectBBK() {
        Locator rejectBbkButton = page.locator("//a[normalize-space()='Reject']");
        if (playwright.waitTillLocatorIsVisible(rejectBbkButton)) {
            playwright.clickOn(rejectBbkButton);
            playwright.pageScrollUntilElementIsVisible(firstRejectReasonRadioButton);
            playwright.clickOn(firstRejectReasonRadioButton);
            playwright.clickOn(rejectButton);
        } else {
            playwright.reloadPage();
        }
    }


    /**
     * Click tombol BBK Data button and open new tab Data BBK owner
     * @param textLink
     * @return activePage
     */
    public Page clickOnBBKData(String textLink){
        page = page.waitForPopup(() -> {
            playwright.clickOnLinkButton(textLink);
        });
        ActiveContext.setActivePage(page);
        return ActiveContext.getActivePage();
    }

    /**
     * Input phone number owner and press enter
     * @param phoneOwner
     *
     */
    public void searchPhoneOwner(String phoneOwner) {
        phoneOwnerSearch.fill(phoneOwner);
        page.keyboard().press("Enter");
    }
}
