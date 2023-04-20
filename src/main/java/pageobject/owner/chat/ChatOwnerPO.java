package pageobject.owner.chat;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions;
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
    Locator acceptFromChatRoomButton;
    Locator yaTerimaButton;
    Locator notPaidFirstRent;
    Locator tenantName;
    Locator roomTitle;
    Locator roomPrice;
    Locator sisaKamarLabel;

    public ChatOwnerPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        ownerChatButton = page.locator("//p[normalize-space()='Chat']");
        emptyChatImage = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("chat kosong"));
        emptyChatDesc = page.getByText("Tidak ada percakapan saat ini.");
        emptyChatIndicator = page.getByText("Chat kosong");
        chatKosButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tanya Pemilik"));
        searchChat = page.getByPlaceholder("Cari...");
        chatTextBox = page.getByRole(AriaRole.TEXTBOX);
        sendButton = page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText("send"));
        nantiSajaButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Nanti Saja"));
        acceptFromChatRoomButton = page.getByRole(AriaRole.BANNER).getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Terima"));
        yaTerimaButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ya, Terima"));
        notPaidFirstRent = page.locator(".mc-chat-room__header-content > .bg-c-label");
        tenantName = page.locator(".bg-c-tooltip__target > .bg-c-text");
        roomTitle = page.locator("//p[@class='mc-product-link-card__content-name bg-c-text bg-c-text--body-2']");
        roomPrice = page.getByText("Rp780.000/bulan");
        sisaKamarLabel = page.locator("//div[@class='mc-product-link-card__wrapper-left']");
    }

    /**
     * Click on owner chat button on header
     *
     */
    public void clickChatOwner() {
        playwright.hardWait(5);
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

    /**
     * Click on accept chat button
     *
     */
    public void clickAcceptFromChatOwner() {
        playwright.clickOn(acceptFromChatRoomButton);
        playwright.clickOn(yaTerimaButton);
    }

    /**
     * Get notPaidFirstRent value text
     * @return
     */
    public String getNotPaidFirstRentText(){
        playwright.hardWait(5);
        return playwright.getText(notPaidFirstRent);
    }

    /**
     * Get Tenant Name from Booking Details Page
     * @return Tenant Name
     */
    public  String getTenantName(){
        return playwright.getText(tenantName);
    }

    /**
     * Check if kost name is displayed
     * @return true if kost name otherwise false
     */
    public boolean isKostNameDisplayed() {
        Locator closeToast = page.locator("page.getByRole('button', { name: 'close' })");
       // playwright.clickOn(closeToast);
        return playwright.waitTillLocatorIsVisible(roomTitle);
    }

    /**
     * Check if price kost is displayed
     * @return true if price kost otherwise false
     */
    public boolean isPriceKostDisplayed() {
        return playwright.waitTillLocatorIsVisible(roomPrice);
    }

    /**
     * Check if sisa kamar is displayed
     * @return true if sisa kamar otherwise false
     */
    public boolean isSisaKamarDisplayed() {
        return playwright.waitTillLocatorIsVisible(sisaKamarLabel);
    }

}
