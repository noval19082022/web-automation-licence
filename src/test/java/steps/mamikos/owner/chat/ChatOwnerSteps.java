package steps.mamikos.owner.chat;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.owner.OwnerDashboardPO;
import pageobject.owner.chat.ChatOwnerPO;

public class ChatOwnerSteps {
    Page page = ActiveContext.getActivePage();

    ChatOwnerPO chat = new ChatOwnerPO(page);
    OwnerDashboardPO owner = new OwnerDashboardPO(page);


    @And("user click chat button in top bar owner home page")
    public void userClickChatButtonInTopBarOwnerHomePage() {
        chat.clickChatOwner();
    }

    @Then("user see chat empty image")
    public void userSeeChatEmptyImage() {
        Assert.assertTrue(chat.isEmptyChatImagePresent(), "Empty chat image is not appear");
    }

    @And("user see text {string} in empty chat description")
    public void userSeeTextInEmptyChatDescription(String textChatEmpty) {
        Assert.assertEquals(chat.getEmptyChatDescription().trim(), textChatEmpty, "Empty chat description is wrong/missing");
    }

    @And("user see indicator {string} in bottom of empty chat page")
    public void userSeeIndicatorInBottomOfEmptyChatPage(String textIndicator) {
        Assert.assertEquals(chat.getEmptyChatIndicator(), textIndicator, "Empty chat indicator is wrong/missing");
    }

    @And("user click chat in kos detail")
    public void userClickChatInKosDetail() {
        chat.clickChatKos();
    }

    @And("search chat in chatlist {string}")
    public void searchChatInChatlist(String inputText) {
        chat.searchChatTenant(inputText);

    }

    @When("owner enter text {string} in chat page")
    public void ownerEnterTextInChatPage(String chatMsg) {
        chat.insertChatText(chatMsg);
    }

    @And("user dismiss FTUE MARS and FTUE Broadcast")
    public void userDismissFTUEMARSAndFTUEBroadcast() {
        chat.dismissFTUEMars();
        chat.dismissFTUEBroadcast();
    }

    @And("user open chatroom from {string}")
    public void userOpenChatroomFrom(String inputText) {
        chat.searchChatTenant(inputText);
    }

    @And("user cancel send chat on FTUE Before Chat")
    public void userCancelSendChatOnFTUEBeforeChat() {
        chat.clickBackOnFTUEBeforeChat();
    }

    @Then("user still see FTUE before send chat")
    public void userStillSeeFTUEBeforeSendChat() {
        Assert.assertTrue(chat.isFTUEBeforeChatPresent(), "FTUE Before send chat is not appear");
        chat.clickCloseOnFTUEBeforeChat();
    }

    @Then("user see attachment button is disabled")
    public void userSeeAttachmentButtonIsDisabled() {
        Assert.assertTrue(chat.isAttachmentButtonDisabled(), "Button is enabled");
    }

    @And("user dismiss FTUE goldplus")
    public void userDismissFTUEGoldplus() {
        owner.dismissFTUEGoldplus();
    }

    @And("user dismiss FTUE MARS Goldplus and FTUE Broadcast")
    public void userDismissFTUEMARSGoldplusAndFTUEBroadcast() {
        chat.dismissFTUEMarsGPAndBroadCast();
    }

    @Then("user see attachment button is enabled")
    public void userSeeAttachmentButtonIsEnabled() {
        Assert.assertTrue(chat.isAttachmentButtonEnabled(), "Button is disabled");
    }
}
