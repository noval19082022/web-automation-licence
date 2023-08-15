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
    Locator acceptFromChatRoomButton;
    Locator yaTerimaButton;
    Locator notPaidFirstRent;
    Locator tenantName;
    Locator roomTitle;
    Locator roomPrice;
    Locator sisaKamarLabel;
    Locator FTUEBeforeChat;
    Locator backFTUEBeforeChat;
    Locator closeFTUEBeforeChat;
    Locator ownerRunsOutQuotaWording;
    Locator attachmentButton;
    Locator weeklyQuotaChatlistHeader;
    Locator registerGoldplusButton;
    Locator weeklyQuotaChatroomHeader;
    Locator broadcastChatBtn;
    Locator gpPacakgeText;
    Locator lastFTUEMars;
    Locator chatListEmptyState;

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
        FTUEBeforeChat = page.getByText("Kuota chat room akan berkurang Kini berlaku sistem kuota chat mingguan. Jika lan");
        backFTUEBeforeChat = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kembali"));
        closeFTUEBeforeChat = page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText("close"));
        ownerRunsOutQuotaWording = page.locator("//button[@class='bg-c-button mc-file-picker__dropdown-trigger bg-c-button--tertiary-naked bg-c-button--md bg-c-button--icon-only-md'][@disabled]");
        attachmentButton = page.locator(".mc-file-picker.mc-chat-room__file-picker button");
        weeklyQuotaChatlistHeader = page.getByText("Sisa kuota mingguan information-round");
        weeklyQuotaChatroomHeader =  page.locator(".mc-chat-room-quota-info__detail");
        registerGoldplusButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Daftar GoldPlus"));
        broadcastChatBtn = page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText("broadcast-message"));
        gpPacakgeText = page.locator("//*[@data-testid='popperReference']");
        lastFTUEMars = page.locator(".mc-ftue-tooltip__standard-content-text");
        chatListEmptyState = page.locator("//div[@class='mc-channel-list__empty']");
    }

    /**
     * Click on owner chat button on header
     *
     */
    public void clickChatOwner() {
        playwright.hardWait(5000);
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
        playwright.hardWait(5000);
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

    /**
     * Dismiss FTUE Mars
     */
    public void dismissFTUEMars() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lanjutkan")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cara isi kuota")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat cara kedua")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Saya Mengerti")).click();
    }

    /**
     * Dismiss FTUE Broadcast
     */
    public void dismissFTUEBroadcast() {
        page.getByTestId("ftueTooltipStandard").click();
        page.getByTestId("ftueTooltipComponent").getByRole(AriaRole.BUTTON).click();
    }

    /**
     * Check FTUE before send chat is present
     * @return true if appear
     */
    public boolean isFTUEBeforeChatPresent() {
        return FTUEBeforeChat.isVisible();
    }

    /**
     * Click back on FTUE Before chat FTUE Mars
     */
    public void clickBackOnFTUEBeforeChat() {
        backFTUEBeforeChat.click();
    }

    /**
     * Click close button on FTUE Before chat FTUE Mars
     */
    public void clickCloseOnFTUEBeforeChat() {
        closeFTUEBeforeChat.click();
    }

    /**
     * Check is attachment button disabled
     * @return true if appear
     */
    public boolean isAttachmentButtonDisabled() {
        return attachmentButton.isDisabled();
    }

    /**
     * Check is attachment button enabled
     * @return true if appear
     */
    public boolean isAttachmentButtonEnabled() {
        return attachmentButton.isEnabled();
    }

    /**
     * Dismiss FTUE Mars Godlplus
     */
    public void dismissFTUEMarsGPAndBroadCast() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Apa itu kuota chat room?")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Saya Mengerti")).click();
        page.getByRole(AriaRole.TOOLTIP, new Page.GetByRoleOptions().setName("Baru! Anda bisa menawarkan kos ke banyak orang lewat Broadcast Chat.")).getByRole(AriaRole.BUTTON).click();
    }

    /**
     * Check Weekly Quota Header in chatlist is present
     * @return true if appear
     */
    public boolean isWeeklyQuotaChatlistPresent() {
        return weeklyQuotaChatlistHeader.isVisible();
    }

    /**
     * Check Register goldplus button in chatlist is present
     * @return true if appear
     */
    public boolean isRegisterGPButtonChatlistPresent() {
        return registerGoldplusButton.isVisible();
    }

    /**
     * Click close button on FTUE Before chat FTUE Mars
     */
    public void clickHeaderMarsChatroom() {
        weeklyQuotaChatroomHeader.click();
    }

    /**
     * Check Weekly Quota Header in chatroom is present
     * @return true if appear
     */
    public boolean isWeeklyQuotaChatroomPresent() {
        return weeklyQuotaChatroomHeader.isVisible();
    }

    /**
     * Check Register goldplus button in chatroom is present
     * @return true if appear
     */
    public boolean isRegisterGPButtonChatroomPresent() {
        return registerGoldplusButton.isVisible();
    }

    /**
     * Click Broadcast Chat Entry Point from Chat Page
     */
    public void clickOnBCChatPage() {
        playwright.clickOn(broadcastChatBtn);
    }

    /**
     * Click close FTUE on chatlist when kuota mars is 0
     *
     *
     */
    public void dismissFTUEMarsKuotaNol() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("close")).click();
    }

    /**
     * Get Gp Package text on chat menu
     * @return String text "Kini, Anda bisa balas chat sepuasnya, bebas batas kuota"
     */
    public String gpPacakgeText() {
        return playwright.getText(gpPacakgeText);
    }

    /**
     * Get Ftue last text on chat menu
     * @return String text "Anda hanya bisa balas 1 chat room per minggu. Kuota tidak berlaku akumulasi(tidak dapat dikumpul)."
     */
    public String lastFTUEnonGoldplusText() {
        return playwright.getText(lastFTUEMars);
    }

    /**
     * Verify is chat list empty state present
     * return boolean true or false
     */
    public boolean isChatListEmptyStatePresent() {
        return playwright.waitTillLocatorIsVisible(chatListEmptyState,2000.0);
    }

}
