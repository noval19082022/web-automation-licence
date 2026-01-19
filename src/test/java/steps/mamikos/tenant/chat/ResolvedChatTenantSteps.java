package steps.mamikos.tenant.chat;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.tenant.chat.ChatRatingTenantPO;

/**
 * Step definitions for resolved chat tenant scenarios
 * Handles rating chat functionality when BSE resolves the chat
 */
public class ResolvedChatTenantSteps {

    /**
     * Get active ChatRatingTenantPO instance from current context
     */
    private ChatRatingTenantPO getChatRating() {
        Page activePage = ActiveContext.getActivePage();
        return new ChatRatingTenantPO(activePage);
    }

    @Then("tenant can see chat from BSE with {string}")
    public void tenantCanSeeChatFromBSEWith(String expectedMessage) {
        ChatRatingTenantPO chatRating = getChatRating();
        String actualMessage = chatRating.getLatestChatFromBSE();
        Assert.assertEquals(actualMessage, expectedMessage,
                "Chat from BSE message mismatch");
    }

    @Then("rating chat pop up appear")
    public void ratingChatPopUpAppear() {
        ChatRatingTenantPO chatRating = getChatRating();
        Assert.assertTrue(chatRating.isRatingChatPopUpVisible(),
                "Rating chat pop up should be visible");
    }

    @When("tenant input rating kejelasan jawaban {int} star")
    public void tenantInputRatingKejelasanJawaban(int starNumber) {
        ChatRatingTenantPO chatRating = getChatRating();
        chatRating.inputRatingKejelasanJawaban(starNumber);
    }

    @Then("show kejelasan jawaban description {string}")
    public void showKejelasanJawabanDescription(String expectedDescription) {
        ChatRatingTenantPO chatRating = getChatRating();
        String actualDescription = chatRating.getKejelasanJawabanDescription();
        Assert.assertEquals(actualDescription, expectedDescription,
                "Kejelasan Jawaban description mismatch");
    }

    @When("tenant input rating kecepatan balas {int} star")
    public void tenantInputRatingKecepatanBalas(int starNumber) {
        ChatRatingTenantPO chatRating = getChatRating();
        chatRating.inputRatingKecepatanBalas(starNumber);
    }

    @Then("show kecepatan balas description {string}")
    public void showKecepatanBalasDescription(String expectedDescription) {
        ChatRatingTenantPO chatRating = getChatRating();
        String actualDescription = chatRating.getKecepatanBalasDescription();
        Assert.assertEquals(actualDescription, expectedDescription,
                "Kecepatan Balas description mismatch");
    }

    @Then("tenant can see feedback field")
    public void tenantCanSeeFeedbackField() {
        ChatRatingTenantPO chatRating = getChatRating();
        Assert.assertTrue(chatRating.isFeedbackFieldVisible(),
                "Feedback field should be visible");
    }

    @Then("tenant can't see feedback field")
    public void tenantCantSeeFeedbackField() {
        ChatRatingTenantPO chatRating = getChatRating();
        Assert.assertTrue(chatRating.isFeedbackFieldNotVisible(),
                "Feedback field should not be visible");
    }

    @And("tenant input feedback {string}")
    public void tenantInputFeedback(String feedbackText) {
        ChatRatingTenantPO chatRating = getChatRating();
        chatRating.inputFeedback(feedbackText);
    }

    @And("tenant submit rating")
    public void tenantSubmitRating() {
        ChatRatingTenantPO chatRating = getChatRating();
        chatRating.submitRating();
    }

    @And("tenant close rating modal")
    public void tenantCloseRatingModal() {
        ChatRatingTenantPO chatRating = getChatRating();
        chatRating.closeRatingModal();
    }

    @When("tenant skip rating chat")
    public void tenantSkipRatingChat() {
        ChatRatingTenantPO chatRating = getChatRating();
        chatRating.skipRating();
    }

    @Then("chip button {string} is appear")
    public void chipButtonIsAppear(String chipText) {
        ChatRatingTenantPO chatRating = getChatRating();
        Assert.assertTrue(chatRating.isRatingChipButtonVisible(),
                "Chip button '" + chipText + "' should be visible");
    }

    @Then("chip button {string} should disappear")
    public void chipButtonShouldDisappear(String chipText) {
        ChatRatingTenantPO chatRating = getChatRating();
        Assert.assertTrue(chatRating.isRatingChipButtonNotVisible(),
                "Chip button '" + chipText + "' should not be visible");
    }

    @When("tenant click Nilai Layanan chip button")
    public void tenantClickNilaiLayananChipButton() {
        ChatRatingTenantPO chatRating = getChatRating();
        chatRating.clickRatingChipButton();
    }

    @Then("success submit rating pop up appear")
    public void successSubmitRatingPopUpAppear() {
        ChatRatingTenantPO chatRating = getChatRating();
        Assert.assertTrue(chatRating.isSuccessSubmitPopupVisible(),
                "Success submit rating pop up should be visible");
    }
}
