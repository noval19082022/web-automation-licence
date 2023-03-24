package pageobject.owner.chat;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class ChatOwnerPO {
    private Page page;
    private PlaywrightHelpers playwright;
    Locator ownerChatButton;
    Locator emptyChatImage;
    Locator emptyChatDesc;
    Locator emptyChatIndicator;
    Locator chatKosButton;
    Locator searchChat;
    Locator chatTextBox;
    Locator sendButton;
    Locator nantiSajaButton;

    public ChatOwnerPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        ownerChatButton = page.locator(".chat-menu > .bg-c-text");
        emptyChatImage = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("chat kosong"));
        emptyChatDesc = page.getByText("Tidak ada percakapan saat ini.");
        emptyChatIndicator = page.getByText("Chat kosong");
        chatKosButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tanya Pemilik"));
        searchChat = page.getByPlaceholder("Cari...");
        chatTextBox = page.getByRole(AriaRole.TEXTBOX);
        sendButton = page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText("send"));
        nantiSajaButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Nanti Saja"));
    }

    /**
     * Click on owner chat button on header
     *
     */
    public void clickChatOwner() {
        playwright.waitTillLocatorIsVisible(ownerChatButton);
        playwright.clickOn(ownerChatButton);
    }

    /**
     * Check empty chat image is present
     * @return true if appear
     */
    public boolean isEmptyChatImagePresent() {
        return emptyChatImage.isVisible();
    }

    /**
     * Get empty chat description
     * @return empty chat description
     */
    public String getEmptyChatDescription() {
        return playwright.getText(emptyChatDesc);
    }

    /**
     * Get empty chat indicator
     * @return empty chat indicator text
     */
    public String getEmptyChatIndicator() {
        return playwright.getText(emptyChatIndicator);
    }

    /**
     * Click on "Chat" in kos Detail
     *
     */
    public void clickChatKos() {
        playwright.clickOn(chatKosButton);
    }

    /**
     * Search Chat
     *
     * @throws InterruptedException
     */
    public void searchChatTenant(String inputText) {
        Locator chatOnList = page.locator("(//h6[contains(.,'"+inputText+"')])[1]");
        searchChat.fill(inputText);
        if (nantiSajaButton.isVisible()){
            playwright.clickOn(nantiSajaButton);
        }
        playwright.clickOn(chatOnList);
    }

    /**
     * owner Enter text to textbox
     * @param message is text we want to enter
     * Hit send after enter message
     */
    public void insertChatText(String message) {
        chatTextBox.fill(message);
        playwright.clickOn(sendButton);
    }

}
