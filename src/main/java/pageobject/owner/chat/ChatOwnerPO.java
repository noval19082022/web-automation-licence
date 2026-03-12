package pageobject.owner.chat;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import data.mamikos.Mamikos;
import pageobject.CommonPO;
import utilities.PlaywrightHelpers;

public class ChatOwnerPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private CommonPO common;
    Locator chatRoomContainer;
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
    Locator terimaButton;
    Locator terimaButtonInDetailSurvey;
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
    Locator registerGoldplusButtonOnChatRoom;
    Locator weeklyQuotaChatroomHeader;
    Locator broadcastChatBtn;
    Locator gpPacakgeText;
    Locator lastFTUEMars;
    Locator ftueMarsBroadcast;
    Locator ftueSurveyTitle;
    Locator berikutnyaBtn;
    Locator chatListEmptyState;
    Locator buttonOnChatRoomList;
    Locator buttonOnChatRoom;
    Locator buttonOnOwnerDashboard;
    Locator Iunderstand;
    Locator sayaMengertiChatRoom;
    Locator bookingLabel;
    Locator closeIcon;
    Locator lihatFiturFTUEJB;
    Locator lihatProfilPenyewaLabelOnChatroom;
    Locator nextFtueButton;
    Locator surveyKostBtn;
    Locator FTUEMarsPresent;
    Locator lanjutkanButton;
    Locator caraIsiKuotaButton;
    Locator chatBebasKuotaButton;
    Locator apaItuKuotaChatRoomButton;
    Locator daftarGPButton;
    Locator blockingModalCloseButton;
    Locator firstChatThread;
    Locator acceptSurveyButton;

    public ChatOwnerPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.common = new CommonPO(page);
        chatRoomContainer = page.locator("div.mc-chat-room");
        ownerChatButton = page.getByText("Chat").nth(0);
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
        terimaButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Terima"));
        terimaButtonInDetailSurvey = page.locator("//div[@class='detail-survey-kost__cta-wrapper bg-u-mt-md']");
        notPaidFirstRent = page.locator("div[class='mc-chat-room-header__content'] div[class='bg-c-label bg-c-label--rainbow bg-c-label--rainbow-blue']");
        tenantName = page.locator(".bg-c-text--title-5");
        roomTitle = page.locator("//p[@class='mc-product-card__title bg-c-text bg-c-text--body-2']");
        roomPrice = page.locator("//p[contains(.,'Rp780.000')]");
        sisaKamarLabel = page.locator("//p[@class='bg-c-text bg-c-text--label-4 bg-c-text--italic mc-product-card__available-room bg-u-text-red-600']");
        FTUEBeforeChat = page.getByText("Kini berlaku sistem kuota chat. Jika lanjut kirim chat dengan calon penyewa ini,");
        backFTUEBeforeChat = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kembali"));
        closeFTUEBeforeChat = page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText("close"));
        ownerRunsOutQuotaWording = page.locator("//button[@class='bg-c-button mc-file-picker__dropdown-trigger bg-c-button--tertiary-naked bg-c-button--md bg-c-button--icon-only-md'][@disabled]");
        attachmentButton = page.locator("//button[@class='bg-c-button mc-file-picker__dropdown-trigger bg-c-button--tertiary-naked bg-c-button--md bg-c-button--icon-only-md']");
        weeklyQuotaChatlistHeader = page.getByText("Sisa Kuota: information-round");
        weeklyQuotaChatroomHeader = page.getByText("Kuota belum terpakai di chat");
        registerGoldplusButton = page.locator("//p[contains(text(),'Ingin bisa balas chat bebas kuota')]/following-sibling::button[contains(text(),'Daftar')]");
        registerGoldplusButtonOnChatRoom = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Daftar GoldPlus"));
        broadcastChatBtn = page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText("broadcast-message"));
        gpPacakgeText = page.getByTestId("popperReference");
        lastFTUEMars = page.locator(".mc-ftue-tooltip__standard-content-text");
        ftueMarsBroadcast = page.getByTestId("ftueTooltipCarousel");
        ftueSurveyTitle = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Baru! Terima Survei Kos"));
        berikutnyaBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Berikutnya"));
        chatListEmptyState = page.getByText("Chat kosong");
        Iunderstand = page.locator("//button[normalize-space()='Saya Mengerti']");
        sayaMengertiChatRoom = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Saya Mengerti"));
        bookingLabel = page.getByTestId("chatRoomHeaderWrapper").getByTestId("booking-status-label");
        closeIcon = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("close"));
        lihatFiturFTUEJB = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat Fitur"));
        lihatProfilPenyewaLabelOnChatroom = page.getByLabel("Baru: Lihat profil calon penyewa!").getByRole(AriaRole.BANNER);
        nextFtueButton = page.locator("[class*='next-button']");
        surveyKostBtn = page.getByText("Survei Kos").first();
        FTUEMarsPresent = page.getByText("Apa itu fitur Chat");
        lanjutkanButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lanjutkan"));
        caraIsiKuotaButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cara isi kuota"));
        chatBebasKuotaButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Chat bebas kuota"));
        apaItuKuotaChatRoomButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Apa itu kuota chat room?"));
        buttonOnChatRoom = page.locator("//div[@class='mc-channel-list-card__avatar']");
        buttonOnChatRoomList = page.locator("button.bg-c-button.mc-non-gp-entrypoint-card__entrypoint-button.bg-c-button--primary.bg-c-button--sm");
        daftarGPButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Daftar"));
        blockingModalCloseButton = page.locator(".bg-c-modal__action-closable");
        firstChatThread = page.locator(".mc-channel-list-card").first();
        acceptSurveyButton = page.locator("//button[contains(.,'Terima Survei')]");
    }

    /**
     * Wait for chat room to be visible.
     */
    public void waitForChatRoomVisible() {
        playwright.waitTillLocatorIsVisible(chatRoomContainer, 30000.0);
    }

    /**
     * Click on owner chat button on header
     */
    public void clickChatOwner() {
        playwright.waitTillPageLoaded();
        if (playwright.waitTillLocatorIsVisible(blockingModalCloseButton, 3000.0)) {
            playwright.clickOn(blockingModalCloseButton);
            playwright.hardWait(1000.0);
        }
        playwright.waitTillLocatorIsVisible(ownerChatButton);
        playwright.clickOn(ownerChatButton);
    }

    public void dismissFTUEMarsGPAndSurveyIfExist() {
        if (playwright.waitTillLocatorIsVisible(ftueMarsBroadcast, 5000.0)) {
            this.dismissFTUEMarsGPAndBroadCast();
        }

        this.dismissFtueSurveyIfExist();
    }

    public void dismissFtueSurveyIfExist() {
        if (playwright.waitTillLocatorIsVisible(ftueSurveyTitle, 3000.0)) {
            playwright.clickOn(berikutnyaBtn);
        }
    }

    public void dismissFTUEJemputBolaIfExist() {
        if (playwright.waitTillLocatorIsVisible(lihatFiturFTUEJB, 3000.0)) {
            this.dismissFTUEJemputBola();
        }
    }

    /**
     * Check empty chat image is present
     *
     * @return true if appear
     */
    public boolean isEmptyChatImagePresent() {
        return emptyChatImage.isVisible();
    }

    /**
     * Get empty chat description
     *
     * @return empty chat description
     */
    public String getEmptyChatDescription() {
        return playwright.getText(emptyChatDesc);
    }

    /**
     * Get empty chat indicator
     *
     * @return empty chat indicator text
     */
    public String getEmptyChatIndicator() {
        return playwright.getText(emptyChatIndicator);
    }

    /**
     * Click on "Chat" in kos Detail
     */
    public void clickChatKos() {
        playwright.waitTillLocatorIsVisible(chatKosButton, 20000.0);
        playwright.clickOn(chatKosButton);
    }

    /**
     * Search Chat
     */
    public void searchChatTenant(String inputText) {
        playwright.pressKeyboardKey("Escape");
        playwright.waitTillLocatorIsVisible(searchChat);
        Locator chatOnList = page.locator("(//h6[contains(.,'" + inputText + "')])[1]");
        playwright.clickLocatorAndTypeKeyboard(searchChat, inputText);
        playwright.hardWait(2000);
        playwright.clickOn(chatOnList);
    }

    /**
     * owner Enter text to textbox
     *
     * @param message is text we want to enter
     *                Hit send after enter message
     */
    public void insertChatText(String message) {
        chatTextBox.fill(message);
        playwright.clickOn(sendButton);
    }

    /**
     * Click on accept chat button
     */
    public void clickAcceptFromChatOwner() {
        page.keyboard().press("Escape");
        page.keyboard().press("Escape");
        playwright.clickOn(acceptFromChatRoomButton);
        playwright.waitFor(yaTerimaButton);
        playwright.clickOn(yaTerimaButton);
    }

    /**
     * Get notPaidFirstRent value text
     *
     * @return
     */
    public String getNotPaidFirstRentText() {
        // Dismiss guide if present
        common.dismissGuide();
        playwright.reloadPage();
        playwright.clickOn(ownerChatButton);
        String inputText = "Tenant Automation Accept Chat";
        Locator chatOnList = page.locator("(//h6[contains(.,'" + inputText + "')])[1]");
        searchChat.fill(inputText);
        if (nantiSajaButton.isVisible()) {
            playwright.clickOn(nantiSajaButton);
        }
        page.keyboard().press("Space");
        playwright.clickOn(chatOnList);
        return playwright.getText(notPaidFirstRent);
    }

    /**
     * Get Tenant Name from Booking Details Page
     *
     * @return Tenant Name
     */
    public String getTenantName() {
        return playwright.getText(tenantName);
    }

    /**
     * Check if kost name is displayed
     *
     * @return true if kost name otherwise false
     */
    public boolean isKostNameDisplayed() {
        return playwright.waitTillLocatorIsVisible(roomTitle);
    }

    /**
     * Check if price kost is displayed
     *
     * @return true if price kost otherwise false
     */
    public boolean isPriceKostDisplayed() {
        return playwright.waitTillLocatorIsVisible(roomPrice);
    }

    /**
     * Check if sisa kamar is displayed
     *
     * @return true if sisa kamar otherwise false
     */
    public boolean isSisaKamarDisplayed() {
        // Dismiss guide if present
        common.dismissGuide();
        return playwright.waitTillLocatorIsVisible(sisaKamarLabel);
    }

    /**
     * Dismiss FTUE Mars
     */
    public void dismissFTUEMars() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lanjutkan")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cara isi kuota")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Chat bebas kuota")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Saya Mengerti")).click();
    }

    /**
     * Dismiss FTUE Survey
     */
    public void dismissFTUESurvey() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Berikutnya")).click();
    }


    public void dismissFTUETBC() {
        playwright.waitFor(sayaMengertiChatRoom);
        playwright.clickOn(sayaMengertiChatRoom);
    }

    public void dismissFTUETBCIfExist() {
        if (playwright.waitTillLocatorIsVisible(sayaMengertiChatRoom, 3_000.0)) {
            playwright.clickOn(sayaMengertiChatRoom);
        }
    }

    /**
     * Dismiss FTUE Broadcast
     */
    public void dismissFTUEBroadcast() {
        playwright.clickOn(closeIcon);
    }

    /**
     * Check FTUE before send chat is present
     *
     * @return true if appear
     */
    public boolean isFTUEBeforeChatPresent() {
        return FTUEBeforeChat.isVisible();
    }

    /**
     * Check FTUE before send chat is present
     *
     * @return true if appear
     */
    public boolean isFTUEMarsPresent() {
        return FTUEMarsPresent.isVisible();
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
        if (playwright.waitTillLocatorIsVisible(closeFTUEBeforeChat)) {
            closeFTUEBeforeChat.click();
        }
    }

    /**
     * Check is attachment button disabled
     *
     * @return true if appear
     */
    public boolean isAttachmentButtonDisabled() {
        playwright.delayAndClickOn(sayaMengertiChatRoom, 3000.0);
        playwright.waitTillLocatorIsVisible(attachmentButton);
        return playwright.isButtonDisable(attachmentButton);
    }

    /**
     * Check is attachment button enabled
     *
     * @return true if appear
     */
    public boolean isAttachmentButtonEnabled() {
        return attachmentButton.isEnabled();
    }

    /**
     * Dismiss FTUE Mars Godlplus
     */
    public void dismissFTUEMarsGPAndBroadCast() {
        // Keep clicking through carousel buttons until FTUE is dismissed
        int maxAttempts = 5;
        int attempts = 0;
        var timeout = 1000.0;

        while (playwright.waitTillLocatorIsVisible(ftueMarsBroadcast, timeout) && attempts < maxAttempts) {
            attempts++;

            // Handle "Lanjutkan" button if it appears
            if (playwright.waitTillLocatorIsVisible(lanjutkanButton, timeout)) {
                playwright.clickOn(lanjutkanButton);
                continue;
            }

            // Handle "Cara isi kuota" button if it appears after Lanjutkan
            if (playwright.waitTillLocatorIsVisible(caraIsiKuotaButton, timeout)) {
                playwright.clickOn(caraIsiKuotaButton);
                continue;
            }

            // Handle "Chat bebas kuota" button if it appears
            if (playwright.waitTillLocatorIsVisible(chatBebasKuotaButton, timeout)) {
                playwright.clickOn(chatBebasKuotaButton);
                continue;
            }

            // Handle "Apa itu kuota chat room?" button if it appears
            if (playwright.waitTillLocatorIsVisible(apaItuKuotaChatRoomButton, timeout)) {
                playwright.clickOn(apaItuKuotaChatRoomButton);
                continue;
            }

            // Final button to dismiss the FTUE
            if (playwright.waitTillLocatorIsVisible(sayaMengertiChatRoom, timeout)) {
                playwright.clickOn(sayaMengertiChatRoom);
                break;
            }

            // If no button found, exit the loop
            break;
        }
    }

    /**
     * Check Weekly Quota Header in chatlist is present
     *
     * @return true if appear
     */
    public boolean isWeeklyQuotaChatlistPresent() {
        return weeklyQuotaChatlistHeader.isVisible();
    }

    /**
     * Check Register goldplus button in chatlist is present
     *
     * @return true if appear
     */
    public boolean isRegisterGPButtonChatlistPresent() {
        return registerGoldplusButton.isVisible();
    }

    /**
     * Click close button on FTUE Before chat FTUE Mars
     */
    public void clickHeaderMarsChatroom() {
        playwright.clickOn(weeklyQuotaChatroomHeader);
    }

    /**
     * Check Weekly Quota Header in chatroom is present
     *
     * @return true if appear
     */
    public boolean isWeeklyQuotaChatroomPresent() {
        playwright.waitTillLocatorIsVisible(weeklyQuotaChatroomHeader);
        playwright.hardWait(5000);
        return weeklyQuotaChatroomHeader.isVisible();
    }

    /**
     * Check Register goldplus button in chatroom is present
     *
     * @return true if appear
     */
    public boolean isRegisterGPButtonChatroomPresent() {
        playwright.waitTillLocatorIsVisible(registerGoldplusButtonOnChatRoom, 10000.0);
        return registerGoldplusButtonOnChatRoom.isVisible();
    }

    /**
     * Click Broadcast Chat Entry Point from Chat Page
     */
    public void clickOnBCChatPage() {
        playwright.clickOn(broadcastChatBtn);
    }

    /**
     * Click close FTUE on chatlist when kuota mars is 0
     */
    public void dismissFTUEMarsKuotaNol() {
        if (playwright.waitTillLocatorIsVisible(closeIcon)) {
            playwright.clickOn(closeIcon);
        }
    }


    /**
     * Get Gp Package text on chat menu
     *
     * @return String text "Kini, Anda bisa balas chat sepuasnya, bebas batas kuota"
     */
    public String gpPacakgeText() {
        return playwright.getText(gpPacakgeText);
    }

    /**
     * Get Ftue last text on chat menu
     *
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
        return playwright.waitTillLocatorIsVisible(chatListEmptyState, 2000.0);
    }

    /**
     * Click on button on chat list or chat room owner
     */
    public void clickButtonOnChatRoomList(String buttonText) {
        playwright.hardWait(2000);
        if (playwright.waitTillLocatorIsVisible(buttonOnChatRoomList, 2000.0)) {
            playwright.clickOn(buttonOnChatRoomList);
        } else {
            playwright.waitFor(buttonOnChatRoom);
            playwright.clickOn(buttonOnChatRoom);
        }
    }

    /**
     * Click on Daftar GoldPlus button in chat room list
     */
    public void clickDaftarGPButton() {
        playwright.waitTillLocatorIsVisible(daftarGPButton, 3000.0);
        playwright.clickOn(daftarGPButton);
    }

    /**
     * Get booking status label
     *
     * @return booking status
     */
    public String getBookingStatusLabel() {
        return playwright.getText(bookingLabel);
    }

    /**
     * click on lihat button on JB coachmark
     */
    public void dismissFTUEJemputBola() {
        this.dismissFtueSurveyIfExist();
        if (playwright.isTextDisplayed("Lihat Fitur")) {
            playwright.clickOn(lihatFiturFTUEJB);
        }
        playwright.navigateTo(Mamikos.OWNER_URL);
        if (playwright.isTextDisplayed("Lihat Fitur")) {
            playwright.clickOn(lihatFiturFTUEJB);
        } else {
            this.clickChatOwner();
        }
    }


    /**
     * dismiss FTUE lihat profil penyewa on detail chatroom
     */
    public void dismissFTUELihatProfilPenyewaOnChatroomIfExist() {
        if (playwright.waitTillLocatorIsVisible(lihatProfilPenyewaLabelOnChatroom, 7_000.0)) {
            playwright.clickOn(sayaMengertiChatRoom);
        }
    }

    /**
     * Dismiss All FTUE
     */
    public void dismissAllFTUE() {
        var maxLoop = 0;
        do {
            playwright.clickOn(nextFtueButton);
            if (maxLoop == 10) {
                break;
            }
            maxLoop++;
        } while (playwright.waitTillLocatorIsVisible(nextFtueButton, 7_000.0));
        if (playwright.waitTillLocatorIsVisible(sayaMengertiChatRoom, 3_000.0)) {
            playwright.clickOn(sayaMengertiChatRoom);
        }
    }

    /**
     * Click on first chat thread in the chat list
     */
    public void clickFirstChatThread() {
        playwright.waitTillLocatorIsVisible(firstChatThread, 10000.0);
        playwright.clickOn(firstChatThread);
    }

    /**
     * Accept survey request from chat room
     * Tries "Terima Survei" button first, falls back to banner "Terima" button
     * Then confirms with "Ya, Terima"
     */
    public void acceptSurveyRequest() {
        playwright.clickOn(terimaButton);
        playwright.clickOn(terimaButtonInDetailSurvey);
        }
    }
