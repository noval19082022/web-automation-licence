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
    Locator questionTextLabels;
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
    Locator cancelSurveyButton;
    Locator surveyKosButton;
    Locator dropdownTimeSurvey;
    Locator tenantChatButton;
    Locator confirmationUbahJadwalButton;
    Locator backButtonChatroom;
    Locator charoomCardList;
    Locator ftueSlider;
    Locator chevronToDetailSurvey;
    Locator batalkanSurveyForm;
    Locator sendBatalkanSurveyBtn;
    Locator backBtnToChatroomFromSurveyDetail;
    Locator chevronDetailSurvei;
    Locator inputTextbox;
    Locator modalChat;
    Locator modalChatInner;
    Locator wrapperQuestion;
    Locator alternativeQuestionSelector;
    Locator questionLabelWithFilter;
    Locator modalChatForm;
    private Locator reviewChatModal;
    private Locator closeButtonReviewChat;

    public ChatTenantPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        questionsOption = page.locator("[data-testid='wrapper-question'] .question-option");
        questionTextLabels = page.locator("[data-testid='wrapper-question'] .wrapper-question__label p");
        ajukanSewaButton = page.locator("#modalChat").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Ajukan Sewa"));
        sendQuestionButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kirim"));
        latestChat = page.locator("(//div[@class='mc-balloon-chat__content']//div)[last()]");
        chatTextBox = page.getByTestId("popperReference").getByRole(AriaRole.TEXTBOX);
        sendButton = page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText("send"));
        disabledRoomCardBookingButton = page.locator(".track_request_booking");
        seeAdsButton = page.locator("#chatRoomHeaderWrapper");
        ownerLastSeen = page.locator(".mc-chat-room__header-content > p");
        ajukanSewaChatRoomButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ajukan Sewa"));
        ajukanSewaPopUpChatRoomButton = page.locator("//button[@class='bg-c-button booking-input-checkin-modal__footer-action bg-c-button--primary bg-c-button--lg bg-c-button--block']");
        cancelSurveyButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Batalkan"));
        surveyKosButton = page.locator("button").filter(new Locator.FilterOptions().setHasText("Survei Kos")).first();
        dropdownTimeSurvey = page.locator("//div[@class='bg-c-select__trigger bg-c-select__trigger--md']");
        tenantChatButton = page.locator("#globalNavbar").getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("Chat"));
        confirmationUbahJadwalButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ubah Survei"));
        backButtonChatroom = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("back"));
        charoomCardList = page.locator(".mc-channel-list-card");
        this.ftueSlider = page.getByText("Lanjut");
        chevronToDetailSurvey = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("chevron-right"));
        batalkanSurveyForm = page.getByPlaceholder("Ceritakan secara singkat dan jelas.");
        sendBatalkanSurveyBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kirim"));
        backBtnToChatroomFromSurveyDetail = page.getByTestId("back-icon");
        chevronDetailSurvei = page.locator("//div[@class='mc-product-card__tenant-survey-detail']");
        inputTextbox = page.locator("//textarea[@placeholder='Ceritakan secara singkat dan jelas.']");
        modalChat = page.locator("#modalChat");
        modalChatInner = page.locator("#modalChat .bg-c-modal__inner");
        wrapperQuestion = page.locator("[data-testid='wrapper-question']");
        alternativeQuestionSelector = page.locator("[data-testid='wrapper-question'] .wrapper-question__label");
        questionLabelWithFilter = page.locator("[data-testid='wrapper-question'] .wrapper-question__label");
        modalChatForm = page.locator("#modalChat form");
        reviewChatModal = page.locator(".bg-c-modal__inner");
        closeButtonReviewChat = page.getByTestId("chatSessionReviewModal").getByRole(AriaRole.BUTTON,new Locator.GetByRoleOptions().setName("close"));
    }

    /**
     * List all questions in pop up
     *
     * @return list questions
     */
    public List<String> listQuestions() {
        playwright.waitFor(modalChatInner, 15000.0);
        playwright.waitFor(wrapperQuestion, 15000.0);
        playwright.hardWait(2000);

        List<String> questionsListing = new ArrayList<>();
        List<Locator> questionsList = questionTextLabels.all();

        for (Locator questionText : questionsList) {
            String text = playwright.getText(questionText);
            if (!text.isEmpty()) {
                questionsListing.add(text);
            }
        }

        return questionsListing;
    }

    /**
     * Verify button label in question pop up is correct
     *
     * @return String text button Send
     */
    public String verifySendLabel() {
        // Wait for modal inner to be visible first (parent #modalChat has height 0)
        playwright.waitTillLocatorIsVisible(modalChatInner, 10000.0);
        
        // Wait for the button to appear with the expected text after question selection
        playwright.waitTillLocatorIsVisible(ajukanSewaButton, 20000.0);
        return playwright.getText(ajukanSewaButton);
    }

    /**
     * Click one of question in radio button
     *
     * @param text is position from top
     */
    public void clickQuestion(String text) {
        // Wait for question options to be visible
        playwright.waitTillLocatorIsVisible(questionsOption.first(), 10000.0);

        // Find the clickable question label that contains the text
        Locator questionLabel = questionLabelWithFilter
            .filter(new Locator.FilterOptions().setHasText(text));
        playwright.waitTillLocatorIsVisible(questionLabel, 5000.0);
        playwright.clickOn(questionLabel);

        // Check and dismiss FTUE if present
        KostDetailsPO kostDetailsPO = new KostDetailsPO(page);
        if (playwright.waitTillLocatorIsVisible(ftueSlider, 2000.0)) {
            kostDetailsPO.dismissFTUE();
        }
    }

    /**
     * Click one of question in chat preset button
     *
     * @param text is position from top
     */
    public void clickPresetQuestion(String text) {
        Locator questionOption = page.getByTestId("chatPretextDropdown-body").getByText("" + text + "");
        playwright.clickOn(questionOption);
        playwright.hardWait(5000);
    }

    /**
     * verify chat preset question
     *
     * @param text
     * @return text example : Ada diskon untuk kos ini?
     */
    public boolean isChatPresetQuestionVisible(String text) {
        Locator questionOption = page.getByTestId("chatPretextDropdown-body").getByText("" + text + "");
        return playwright.waitTillLocatorIsVisible(questionOption, 3000.0);
    }

    /**
     * Click ajukan sewa button in question pop up
     */
    public void clickAjukanSewaButton() {
        playwright.waitTillLocatorIsVisible(ajukanSewaButton, 50000.0);
        playwright.clickOn(ajukanSewaButton);
    }

    /**
     * Click send in question pop up
     *
     * @throws InterruptedException
     */
    public void clickSend() {
        playwright.clickOn(sendQuestionButton);
        playwright.waitFor(latestChat);
    }

    /**
     * Get latest chat
     *
     * @return String latest chat (most bottom chat)
     */
    public String getLatestChatText() {
        playwright.hardWait(5);
        playwright.pageScrollUntilElementIsVisible(latestChat);
        playwright.waitTillLocatorIsVisible(latestChat);
        String chatText = playwright.getText(latestChat);
        System.out.println("Isi chat terakhir: " + chatText);
        return playwright.getText(latestChat);
    }

    /**
     * tenant Enter text to textbox
     *
     * @param message is text we want to enter
     *                Hit send after enter message
     */
    public void insertChatText(String message) {
        chatTextBox.fill(message);
        playwright.clickOn(sendButton);
    }

    /**
     * Check booking button disable is present
     *
     * @return boolean
     */
    public boolean isBookingButtonDisablePresent() {
        return playwright.isButtonDisable(disabledRoomCardBookingButton);
    }

    /**
     * Click Lihat Iklan button
     */
    public void clickLihatIklanButton() {
        // Dismiss FTUE if present before clicking header
        KostDetailsPO kostDetailsPO = new KostDetailsPO(page);
        if (playwright.waitTillLocatorIsVisible(ftueSlider, 3000.0)) {
            kostDetailsPO.dismissFTUE();
        }
        
        playwright.waitTillLocatorIsVisible(seeAdsButton, 10000.0);
        playwright.clickOn(seeAdsButton);
    }

    /**
     * Check Owner Last Seen chatroom is present
     *
     * @return true if appear
     */
    public boolean isOwnerLastSeenPresent() {
        return ownerLastSeen.isVisible();
    }

    /**
     * Click on Ajukan Sewa from chatroom
     * Select booking date
     *
     * @param date tomorrow, today, or specific date by number on string data type
     *             <p>
     *             Click on Ajukan Sewa from Pop Up Chat Room Button
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

    public void visitDetailSurveyFromChatroom() {
        playwright.clickOn(chevronToDetailSurvey);
    }

    /**
     * Click on batalkan survey button
     */
    public void clickOnBatalkanSurveiButton() {
        playwright.clickOn(cancelSurveyButton);
    }

    /**
     * Click on survey button
     */
    public void clickOnSurveyKosButton() {
        // Wait for chatroom to load properly
        playwright.hardWait(3000);

        // Wait for chatroom header or content to be visible (indicating chatroom is loaded)
        playwright.waitTillPageLoaded();

        // Check if survey already submitted (Ubah Survei button is visible)
        if (playwright.isButtonWithTextDisplayed("Survei Diajukan", 2000.0)){
            // Survey already submitted, need to cancel it first
            playwright.clickOn(chevronDetailSurvei);
            playwright.clickOn(cancelSurveyButton);
            playwright.waitTillLocatorIsVisible(inputTextbox);
            playwright.fill(inputTextbox, "Saya ingin membatalkan ajukan survei");
            playwright.clickOnText("Kirim");
            playwright.hardWait(5000);
        }

        // Click survey button with extended timeout
        playwright.hardWait(2000);

        // Use extended timeout for survey button (30 seconds instead of default 15)
        playwright.waitTillLocatorIsVisible(surveyKosButton, 30000.0);

        // Scroll button into view before clicking
        surveyKosButton.scrollIntoViewIfNeeded();
        playwright.hardWait(500);

        playwright.clickOn(surveyKosButton);
        playwright.hardWait(2000);
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

    /**
     * Click on ubah jadwal button
     *
     */
    public void clickOnUbahJadwalOnHeaderChatRoomButton() {
        playwright.waitTillLocatorIsVisible(confirmationUbahJadwalButton);
        playwright.clickOn(confirmationUbahJadwalButton);
    }

    public void fillBatalkanForm(String text) {
        playwright.clickOn(batalkanSurveyForm);
        playwright.clickLocatorAndTypeKeyboard(batalkanSurveyForm, text);
    }

    public void sendFormBatalkanSurvey() {
        playwright.clickOn(sendBatalkanSurveyBtn);
    }

    public void backToChatroomFromSurveyDetail() {
        playwright.clickOn(backBtnToChatroomFromSurveyDetail);
    }

    /**
     * Get aria snapshot of the modal chat form
     * Useful for accessibility testing and debugging modal chat interactions
     * @return String representation of the modal chat accessibility tree
     */
    public String getModalChatAriaSnapshot() {
        playwright.waitTillLocatorIsVisible(modalChatForm, 10000.0);
        return playwright.getAriaSnapshot(modalChatForm);
    }

    /**
     * Check if chat review modal is visible
     * @return true if review chat modal is visible, false otherwise
     */
    public boolean isChatReviewVisible() {
        return playwright.isLocatorVisibleAfterLoad(reviewChatModal, 30000.0);
    }

    /**
     * Close the review chat modal by clicking close button
     */
    public void closeReviewChat() {
        playwright.clickOn(closeButtonReviewChat);
    }

    /**
     * Verify that a label text is displayed below a specific option in chat pretext dropdown
     * @param labelText the label text to find (e.g. "Kos melayani Survei Hari Ini")
     * @param optionText the option text above the label (e.g. "Saya mau survei")
     * @return true if both option and label are visible in pretext dropdown
     */
    public boolean isLabelDisplayedBelowOptionInPretext(String labelText, String optionText) {
        Locator pretextBody = page.getByTestId("chatPretextDropdown-body");
        playwright.waitTillLocatorIsVisible(pretextBody, 10000.0);

        // Verify both option and label text are visible
        Locator option = page.locator("//p[normalize-space()='" + optionText + "']");
        Locator label = page.locator("//p[normalize-space()='" + labelText + "']");
        return playwright.waitTillLocatorIsVisible(option, 5000.0)
                && playwright.waitTillLocatorIsVisible(label, 5000.0);
    }

    /**
     * Verify that a label text is displayed below a specific option in chat pretext dropdown
     * @param labelText the label text to find (e.g. "Kos melayani Survei Hari Ini")
     * @param optionText not the option text above the label (e.g. "Saya mau survei")
     * @return true if both option and label are visible in pretext dropdown
     */
    public boolean isLabelNotDisplayedBelowOptionInPretext(String labelText, String optionText) {
        Locator pretextBody = page.getByTestId("chatPretextDropdown-body");
        playwright.waitTillLocatorIsVisible(pretextBody, 10000.0);

        // Option text MUST exist (confirm we are on the correct page)
        Locator option = page.locator("//p[normalize-space()='" + labelText + "']");
        playwright.waitTillLocatorIsVisible(option, 5000.0);

        // Label text should NOT be visible
        Locator label = page.locator("//p[normalize-space()='" + optionText + "']");
        return !playwright.waitTillLocatorIsVisible(label, 3000.0);
    }
}
