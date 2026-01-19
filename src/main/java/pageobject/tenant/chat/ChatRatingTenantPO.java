package pageobject.tenant.chat;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

/**
 * Page Object for Chat Rating functionality in tenant side
 * Handles resolved chat rating modal interactions
 */
public class ChatRatingTenantPO {
    private Page page;
    private PlaywrightHelpers playwright;

    // Rating modal locators
    private Locator ratingModal;
    private Locator feedbackField;
    private Locator submitRatingButton;
    private Locator skipRatingButton;
    private Locator closeRatingModalButton;
    private Locator ratingChipButton;
    private Locator kejelasanJawabanDescription;
    private Locator kecepatanBalasDescription;
    private Locator successSubmitPopup;
    private Locator latestChatBubble;

    public ChatRatingTenantPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);

        // Initialize locators for rating modal
        ratingModal = page.locator(".bg-c-modal__inner").filter(new Locator.FilterOptions().setHasText("Bagaimana pengalaman kamu chat dengan tim kami?"));
        feedbackField = page.getByPlaceholder("Ceritakan kepada kami di sini (opsional)");
        submitRatingButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kirim"));
        skipRatingButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lewati"));
        closeRatingModalButton = ratingModal.getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("close"));
        ratingChipButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Nilai Layanan"));
        kejelasanJawabanDescription = page.locator(".mc-chat-session-review-modal__rating-description").nth(0);
        kecepatanBalasDescription = page.locator(".mc-chat-session-review-modal__rating-description").nth(1);
        successSubmitPopup = page.getByText("Terima kasih, penilaian kamu bantu kami jadi lebih baik");
        latestChatBubble = page.locator(".mc-balloon-chat__content").last();
    }

    /**
     * Check if rating chat pop up is visible
     * @return true if rating modal is visible
     */
    public boolean isRatingChatPopUpVisible() {
        playwright.hardWait(3000);
        return playwright.waitTillLocatorIsVisible(ratingModal, 30000.0);
    }

    /**
     * Click on star rating for Kejelasan Jawaban
     * @param starNumber number of stars (1-5)
     */
    public void inputRatingKejelasanJawaban(int starNumber) {
        waitForRatingModal();
        Locator star = page.getByTestId("chatSessionReviewModal-stars").nth(starNumber - 1);
        playwright.clickOn(star);
        playwright.hardWait(500);
    }

    /**
     * Click on star rating for Kecepatan Balas
     * @param starNumber number of stars (1-5)
     */
    public void inputRatingKecepatanBalas(int starNumber) {
        waitForRatingModal();
        Locator star = page.getByTestId("chatSessionReviewModal-stars").nth(starNumber + 4);
        playwright.clickOn(star);
        playwright.hardWait(500);
    }

    /**
     * Get the description text for Kejelasan Jawaban rating
     * @return description text
     */
    public String getKejelasanJawabanDescription() {
        playwright.hardWait(1000);
        playwright.waitTillLocatorIsVisible(kejelasanJawabanDescription, 5000.0);
        return playwright.getText(kejelasanJawabanDescription);
    }

    /**
     * Get the description text for Kecepatan Balas rating
     * @return description text
     */
    public String getKecepatanBalasDescription() {
        playwright.hardWait(1000);
        playwright.waitTillLocatorIsVisible(kecepatanBalasDescription, 5000.0);
        return playwright.getText(kecepatanBalasDescription);
    }

    /**
     * Check if feedback field is visible
     * @return true if feedback field is visible
     */
    public boolean isFeedbackFieldVisible() {
        playwright.hardWait(2000);
        return playwright.waitTillLocatorIsVisible(feedbackField, 5000.0);
    }

    /**
     * Check if feedback field is not visible
     * @return true if feedback field is not visible
     */
    public boolean isFeedbackFieldNotVisible() {
        playwright.hardWait(2000);
        return !feedbackField.isVisible();
    }

    /**
     * Input text to feedback field
     * @param feedbackText text to input
     */
    public void inputFeedback(String feedbackText) {
        playwright.waitTillLocatorIsVisible(feedbackField, 5000.0);
        playwright.fill(feedbackField, feedbackText);
    }

    /**
     * Click submit rating button
     */
    public void submitRating() {
        playwright.waitTillLocatorIsVisible(submitRatingButton, 5000.0);
        playwright.clickOn(submitRatingButton);
    }

    /**
     * Get the latest chat text from BSE
     * @return chat text from BSE
     */
    public String getLatestChatFromBSE() {
        playwright.hardWait(3000);
        playwright.waitTillLocatorIsVisible(latestChatBubble, 10000.0);
        return playwright.getText(latestChatBubble);
    }

    /**
     * Wait for rating modal to appear
     */
    public void waitForRatingModal() {
        playwright.waitTillLocatorIsVisible(ratingModal, 30000.0);
    }

    /**
     * Close rating modal
     */
    public void closeRatingModal() {
        if (playwright.waitTillLocatorIsVisible(closeRatingModalButton, 5000.0)) {
            playwright.clickOn(closeRatingModalButton);
        }
    }

    /**
     * Skip rating by clicking "Lewati" button
     */
    public void skipRating() {
        waitForRatingModal();
        playwright.waitTillLocatorIsVisible(skipRatingButton, 5000.0);
        playwright.clickOn(skipRatingButton);
    }

    /**
     * Check if rating chip button is visible
     * @return true if chip button is visible
     */
    public boolean isRatingChipButtonVisible() {
        playwright.hardWait(2000);
        return playwright.waitTillLocatorIsVisible(ratingChipButton, 10000.0);
    }

    /**
     * Check if rating chip button is not visible
     * @return true if chip button is not visible
     */
    public boolean isRatingChipButtonNotVisible() {
        playwright.hardWait(2000);
        return !ratingChipButton.isVisible();
    }

    /**
     * Click on rating chip button (Nilai Layanan)
     */
    public void clickRatingChipButton() {
        playwright.waitTillLocatorIsVisible(ratingChipButton, 10000.0);
        playwright.clickOn(ratingChipButton);
    }

    /**
     * Check if success submit rating popup is visible
     * @return true if success popup is visible
     */
    public boolean isSuccessSubmitPopupVisible() {
        return playwright.waitTillLocatorIsVisible(successSubmitPopup, 10000.0);
    }
}
