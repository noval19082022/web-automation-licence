package steps.mamikos.owner.chat;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.owner.chat.ChatOwnerPO;

public class ChatOwnerSteps {
    Page page = ActiveContext.getActivePage();

    ChatOwnerPO chat = new ChatOwnerPO(page);


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
}
