package pageobject.tenant.chat;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import pageobject.common.KostDetailsPO;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

import java.util.ArrayList;
import java.util.List;

public class ChatTenantPO {
    private Page page;
    private PlaywrightHelpers playwright;
    String date;
    Locator questionsOption;
    Locator sendQuestionButton;
    Locator ajukanSewaButton;
    Locator latestChat;
    Locator chatTextBox;
    Locator sendButton;
    Locator disabledRoomCardBookingButton;
    Locator seeAdsButton;
    Locator ownerLastSeen;
    Locator ajukanSewaChatRoomButton;
    Locator ajukanSewaPopUpChatRoomButton;
    Locator ubahJadwalButton;
    Locator cancelSurveyButton;
    Locator surveyKosButton;
    Locator dropdownTimeSurvey;
    Locator tenantChatButton;
    Locator confirmationUbahJadwalButton;
    Locator backButtonChatroom;
    Locator charoomCardList;
    Locator ftueSlider;

    public ChatTenantPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        questionsOption = page.locator("//*[@class='wrapper-question']/child::div");
        ajukanSewaButton = page.locator("#modalChat").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Ajukan Sewa"));
        sendQuestionButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kirim"));
        latestChat = page.locator("(//div[@class='mc-balloon-chat__content']/div)[last()]");
        chatTextBox = page.getByTestId("popperReference").getByRole(AriaRole.TEXTBOX);
        sendButton = page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText("send"));
        disabledRoomCardBookingButton = page.locator(".mc-product-card__action-button");
        seeAdsButton = page.getByTestId("chatRoomHeaderWrapper");
        ownerLastSeen = page.locator(".mc-chat-room__header-content > p");
        ajukanSewaChatRoomButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ajukan Sewa"));
        ajukanSewaPopUpChatRoomButton = page.locator("//button[@class='bg-c-button booking-input-checkin-modal__footer-action bg-c-button--primary bg-c-button--lg bg-c-button--block']");
        ubahJadwalButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ubah Jadwal"));
        cancelSurveyButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Batalkan Survei"));
        surveyKosButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Survei Kos"));
        dropdownTimeSurvey =  page.locator("//div[@class='bg-c-select__trigger bg-c-select__trigger--md']");
        tenantChatButton = page.locator("#globalNavbar").getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("Chat"));
        confirmationUbahJadwalButton = page.locator("//button[normalize-space()='Batalkan Survei']//following-sibling::button");
        backButtonChatroom = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("back"));
        charoomCardList = page.locator(".mc-channel-list-card");
        this.ftueSlider = page.getByText("Lanjut");
    }

    /**
     * List all questions in pop up
     * @return list questions
     */
    public List<String> listQuestions() {
        List<String> questionsListing = new ArrayList<>();
        List<Locator> questionsList = questionsOption.all();
        for (Locator i : questionsList ){
            questionsListing.add(playwright.getText(i));
        }
        return questionsListing;
    }

    /**
     * Verify button label in question pop up is correct
     *
     * @return String text button Send
     */
    public String verifySendLabel() {
        return playwright.getText(ajukanSewaButton);
    }

    /**
     * Click one of question in radio button
     * @param text is position from top
     *
     */
    public void clickQuestion(String text) {
        Locator questionOption = page.getByText(""+text+"");
        playwright.clickOn(questionOption);
        playwright.hardWait(5000);
        KostDetailsPO ChatTenantPO = new KostDetailsPO(page);
        if (playwright.waitTillLocatorIsVisible(ftueSlider, 5000.0)) {
            ChatTenantPO.dismissFTUE();
        }
    }

    /**
     * Click one of question in chat preset button
     * @param text is position from top
     *
     */
    public void clickPresetQuestion(String text) {
        Locator questionOption = page.getByTestId("chatPretextDropdown-body").getByText(""+text+"");
        playwright.clickOn(questionOption);
        playwright.hardWait(5000);
        }

    /**
     * verify chat preset question
      * @param text
     * @return text example : Ada diskon untuk kos ini?
     */
    public boolean isChatPresetQuestionVisible(String text) {
        Locator questionOption = page.getByTestId("chatPretextDropdown-body").getByText(""+text+"");
        return playwright.waitTillLocatorIsVisible(questionOption, 3000.0);
    }

    /**
     * Click ajukan sewa button in question pop up
     *
     */
    public void clickAjukanSewaButton() {
        playwright.clickOn(ajukanSewaButton);
    }

    /**
     * Click send in question pop up
     * @throws InterruptedException
     */
    public void clickSend() {
        playwright.clickOn(sendQuestionButton);
        playwright.waitFor(latestChat);
    }

    /**
     * Get latest chat
     * @return String latest chat (most bottom chat)
     */
    public String getLatestChatText() {
        playwright.pageScrollUntilElementIsVisible(latestChat);
        playwright.waitTillLocatorIsVisible(latestChat);
        return playwright.getText(latestChat);
    }

    /**
     * tenant Enter text to textbox
     * @param message is text we want to enter
     * Hit send after enter message
     */
    public void insertChatText(String message) {
        chatTextBox.fill(message);
        playwright.clickOn(sendButton);
    }

    /**
     * Check booking button disable is present
     * @return boolean
     */
    public boolean isBookingButtonDisablePresent() {
        return playwright.isButtonDisable(disabledRoomCardBookingButton);
    }

    /**
     * Click Lihat Iklan button
     *
     */
    public void clickLihatIklanButton() {
        playwright.clickOn(seeAdsButton);
    }

    /**
     * Check Owner Last Seen chatroom is present
     * @return true if appear
     */
    public boolean isOwnerLastSeenPresent() {
        return ownerLastSeen.isVisible();
    }

    /**
     * Click on Ajukan Sewa from chatroom
     * Select booking date
     * @param date tomorrow, today, or specific date by number on string data type
     *
     * Click on Ajukan Sewa from Pop Up Chat Room Button
     */
    public void clickOnAjukanSewaChatRoomButton(String date) {
        playwright.clickOn(ajukanSewaChatRoomButton);
        Locator datePick;
        if (date.equalsIgnoreCase("tomorrow")) {
            this.date = JavaHelpers.getCostumDateOrTime("d", 1, 0, 0);
        } else if (date.equalsIgnoreCase("today")) {
            this.date = JavaHelpers.getCurrentDateOrTime("d");
        } else {
            this.date = date;
        }
        datePick = page.getByTestId("bookingInputCheckinContent-datePicker").getByText(this.date);
        List<Locator> datePicks = playwright.getLocators(datePick);
        for (Locator pick : datePicks) {
            if (pick.isEnabled() && pick.isVisible()) {
                pick.click();
            }
        }
        playwright.clickOn(ajukanSewaPopUpChatRoomButton);
    }

    /**
     * Click on ubah jadwal button
     *
     */
    public void clickOnUbahJadwalOnHeaderChatRoomButton() {
        playwright.waitTillLocatorIsVisible(ubahJadwalButton);
        playwright.clickOn(ubahJadwalButton);
    }

    /**
     * Click on batalkan survey button
     *
     */
    public void clickOnBatalkanSurveiButton() {
        playwright.clickOn(cancelSurveyButton);
    }

    /**
     * Click on survey button
     *
     */
    public void clickOnSurveyKosButton() {
        playwright.clickOn(surveyKosButton);
    }

    /**
     * admin input voucher
     *
     */
    public void inputTimeSurvey(String time) {
        playwright.waitTillLocatorIsVisible(dropdownTimeSurvey);
        playwright.clickOn(dropdownTimeSurvey);
        String text = "//div[normalize-space()='"+time+"']";
        ElementHandle element = page.querySelector(text);
        element.click();
    }
    /**
     * Click on owner chat button on header
     *
     */
    public void clickOnChatTenant() {
        playwright.hardWait(5000);
        playwright.clickOn(tenantChatButton);
    }
    /**
     * Click on owner chat button on header
     *
     */
    public void clickOnSendFormButton(String send) {
        playwright.hardWait(7000);
        playwright.waitTillPageLoaded();
        String inputTextbox = "//*[normalize-space()='"+send+"']";
        ElementHandle element = page.querySelector(inputTextbox);
        element.click();
    }

    /**
     * Click on confirmation ubah jadwal button
     *
     */
    public void clickOnConfirmationUbahJadwalButton() {
        playwright.clickOn(confirmationUbahJadwalButton);
    }

    /**
     * Check if question list displayed
     * @return true if appear
     */
    public boolean isQuestionDisplayed(String question) {
        String xpathLocator = "//p[contains(.,'" + question + "')]";
        return page.querySelector(xpathLocator) != null;
    }

    /**
     * open chat room by order on chat list
     * @param orderNumber (first order is 0, second order is 1, so on)
     */
    public void openChatroomByOrder(int orderNumber) {
        playwright.clickOn(charoomCardList.nth(orderNumber));
    }

    /**
     * click back button in chatroom
     */
    public void clickBackButtonChatroom() {
        playwright.clickOn(backButtonChatroom);
    }
}
