package steps.mamikos.tenant.chat;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.owner.chat.ChatOwnerPO;
import pageobject.tenant.chat.ChatTenantPO;

import java.util.List;

public class ChatTenantSteps {
    Page page = ActiveContext.getActivePage();

    ChatTenantPO chat = new ChatTenantPO(page);
    ChatOwnerPO chatOwner = new ChatOwnerPO(page);


    @Then("user see phone number field and selectable question options :")
    public void userSeePhoneNumberFieldAndSelectableQuestionOptions(List<String> questions) {
        List<String> questionList = chat.listQuestions();
        for (int i=0; i<questions.size(); i++) {
            Assert.assertEquals(questionList.get(i), questions.get(i), "Question " + i + " not match");
        }
    }

    @Given("tenant click button ajukan sewa from chat popup")
    public void tenantClickButtonAjukanSewaFromChatPopup() {
        chat.clickAjukanSewaButton();
    }

    @Given("send button become {string}")
    public void sendButtonBecome(String textButton) {
        Assert.assertEquals(chat.verifySendLabel(),textButton, "Button text is wrong");
    }

    @And("user select question {string}")
    public void userSelectQuestion(String questionOption) {
        chat.clickQuestion(questionOption);
    }

    @Then("it will redirect to Booking page")
    public void itWillRedirectToBookingPage() {
    }

    @And("user click send chat from popup")
    public void userClickSendChatFromPopup() {
        chat.clickSend();
    }

    @And("chat room appear with latest message {string}")
    public void chatRoomAppearWithLatestMessage(String chatText) {
        Assert.assertTrue(chat.getLatestChatText().trim().replaceAll("\\s", "").contains(chatText.replaceAll("\\s", "")), "Kos address in title is wrong");
    }

    @And("tenant enter text {string} in chat page")
    public void tenantEnterTextInChatPage(String chatMsg) {
        chat.insertChatText(chatMsg);
    }

    @Then("user sees the Booking button disable")
    public void userSeesTheBookingButtonDisable() {
        Assert.assertTrue(chat.isBookingButtonDisablePresent(), "booking button is not disable!");
    }

    @And("user clicks the Lihat Iklan button and redirect to detail property")
    public void userClicksTheLihatIklanButtonAndRedirectToDetailProperty() {
        chat.clickLihatIklanButton();
    }

    @Then("user cant see last owner seen")
    public void userCantSeeLastOwnerSeen() {
        Assert.assertFalse(chat.isOwnerLastSeenPresent(), "owner last seen is display");
    }
}
