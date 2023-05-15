package pageobject.owner.chat;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class BroadcastChatPO {
    private Page page;
    private PlaywrightHelpers playwright;
    Locator warningBroadcastText;
    Locator searchKostInputBC;
    Locator listSelectBroadcastKost;
    Locator firstBroadcastChatOption;
    Locator backButtonBC;
    Locator brodcastMessageField;
    Locator closeSearchBroadcastSearchIcon;
    Locator kostListBroadcastChat;
    Locator messageBroadcastText;
    Locator ubahTemplateBroadcastText;
    Locator broadcastMessageInput;
    Locator errorInputBroadcastText;
    Locator counterCharText;
    Locator previewBroadcastMessageText;
    Locator tooltipBroadcast;
    Locator tooltipClose;
    Locator broadcastChatIcon;
    Locator cancelGoldPlusButton;
    Locator backGoldplusbutton;
    Locator lihatPenerimaSection;

    public BroadcastChatPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        warningBroadcastText =page.locator(".bg-c-modal__body-title");
        searchKostInputBC = page.getByTestId("broadcastChat-searchBarKosList");
        listSelectBroadcastKost = page.locator(".disabled-card");
        firstBroadcastChatOption = page.locator(".broadcast-chat-message-card__message");
        backButtonBC = page.getByRole(AriaRole.IMG).filter(new Locator.FilterOptions().setHasText("back"));
        brodcastMessageField = page.locator(".bg-c-textarea__field");
        closeSearchBroadcastSearchIcon = page.getByRole(AriaRole.BUTTON).nth(3);
        kostListBroadcastChat = page.getByTestId("broadcastChat-listKos");
        messageBroadcastText = page.locator("//div[@class='broadcast-chat-detail__select-message__inner']//p");
        ubahTemplateBroadcastText = page.getByText("Ubah").nth(1);
        broadcastMessageInput = page.locator(".bg-c-textarea__field");
        errorInputBroadcastText = page.locator(".bg-c-field__message");
        counterCharText = page.locator(".bg-c-textarea__counter");
        previewBroadcastMessageText = page.locator("b:nth-of-type(2)");
        tooltipBroadcast = page.locator(".mc-channel-list__broadcast-tooltip-content");
        tooltipClose = page.locator(".bg-c-button--tertiary-naked-inversed");
        broadcastChatIcon = page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText("broadcast-message"));
        cancelGoldPlusButton = page.locator("//a[@class='back-icon']");
        backGoldplusbutton = page.locator("//span[@class='goldplus-header__back-button']");
        lihatPenerimaSection = page.getByTestId("broadcastChat-sectionRecepientMessage");
    }

    /**
     * Get warning broadcast
     *
     * @return Text of broadcast
     */
    public String getWarningBroadcastText() {
        playwright.hardWait(5);
        playwright.waitTillLocatorIsVisible(warningBroadcastText,5.0);
        return playwright.getText(warningBroadcastText);
    }

    /**
     * Wait till element Input Search Kost BC visible
     * Insert text to search kost BroadcastChat
     */
    public void searchKostBC(String text) {
        searchKostInputBC.fill(text);
    }

    /**
     * verify kost card is disable
     *
     */
    public boolean isKostCardDisabled() {
        playwright.hardWait(3);
        return listSelectBroadcastKost.isVisible();
    }


    /**
     * click on icon close at search bar broadcast chat
     */
    public void clickOnCloseSearchBroadcastSearchIcon() {
        playwright.clickOn(closeSearchBroadcastSearchIcon);
        page.reload();
        playwright.hardWait(5);
    }

    /**
     * verify kost list at broadcast chat is show
     */
    public boolean isKosListDisplayed() {
        playwright.waitTillLocatorIsVisible(playwright.getLocators(kostListBroadcastChat).get(0),5000.0);
        return playwright.isLocatorVisibleAfterLoad(playwright.getLocators(kostListBroadcastChat).get(0),5000.0);
    }

    /**
     * click on button masukan pesan broadcast chat
     */
    public void selectMessageOptionBC(int messageOption) {
        playwright.clickOn(playwright.getLocators(firstBroadcastChatOption).get(messageOption-1));
    }

    /**
     * Get message BC after selected
     * @return error message after selected
     */
    public String getMessageBCselected() {
        return playwright.getText(messageBroadcastText).replaceAll("\\s", "");
    }

    /**
     * click on button ubah template message button
     */
    public void clickUbahTemplateBroadcastText() {
        playwright.clickOn(ubahTemplateBroadcastText);
    }

    /**
     * Wait till element Input Search Kost BC visible
     * Insert text to search kost BroadcastChat
     */
    public void inputBroadcastMessage(String text) {
        broadcastMessageInput.fill(text);
        playwright.clickOn(broadcastMessageInput);
        page.keyboard().press("Enter");
    }

    /**
     * verify textfield broadcast chat message is not displayed
     */
    public boolean isTextFieldBCMessageDisplayed() {
        return brodcastMessageField.isVisible();
    }

    /**
     * Get counter char text at input Broadcast message
     * @return counter wrong
     */
    public String getCountText() {
        return playwright.getText(counterCharText);
    }

    /**
     * Get error Input Template Broadcast Chat Template Message
     * @return error Input Template Broadcast Chat Template Message
     */
    public String getErrorInputBroadcastText() {
        playwright.waitTillLocatorIsVisible(errorInputBroadcastText);
        return playwright.getText(errorInputBroadcastText);
    }

    /**
     * Get Preview Message Broadcast Chat
     * @return Preview Message Broadcast Chat
     */
    public String getPreviewMessageBC() {
        return playwright.getText(previewBroadcastMessageText);
    }
    /**
     * click on back Button BC
     */
    public void clickOnBackButtonBC() {
        playwright.hardWait(3);
        playwright.clickOn(backButtonBC);
    }

    /**
     * click on icon broadcast chat at owner chat page
     */
    public void clickOnBroadcastChatIcon() {
        playwright.clickOn(broadcastChatIcon);
        playwright.hardWait(10);
    }

    /**
     * Verify tooltip broadcast chat is present
     *
     * @return tooltip broadcast chat is present
     */
    public boolean isTooltipBroadcastDisplayed() {
        return playwright.waitTillLocatorIsVisible(tooltipBroadcast, 2.0);
    }

    /**
     * click on close button tooltip
     */
    public void clickOnCloseTooltip() {
        playwright.clickOn(tooltipClose);
    }

    /**
     * click on gp cancel button and then back to kelola page
     */
    public void clickOnCancelGPbutton() {
        playwright.clickOn(cancelGoldPlusButton);
        playwright.waitTillLocatorIsVisible(backGoldplusbutton, 5000.0);
        playwright.clickOn(backGoldplusbutton);
    }

    /**
     * Verify tooltip broadcast chat is present
     *
     * @return tooltip broadcast chat is present
     */
    public boolean isLihatPenerimaPageDisplayed() {
        return playwright.waitTillLocatorIsVisible(lihatPenerimaSection, 2.0);
    }
}
