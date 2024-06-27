package steps.mamikos.tenant.chat;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.common.KostDetailsPO;
import pageobject.owner.chat.ChatOwnerPO;
import pageobject.tenant.chat.ChatTenantPO;
import utilities.PlaywrightHelpers;

import java.util.List;

public class ChatTenantSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    ChatTenantPO chat = new ChatTenantPO(page);
    ChatOwnerPO chatOwner = new ChatOwnerPO(page);
    KostDetailsPO kostDetail = new KostDetailsPO(page);


    @Then("user see phone number field and selectable question options :")
    public void userSeePhoneNumberFieldAndSelectableQuestionOptions(List<String> questions) {
        playwright.hardWait(5000);
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
        if (playwright.isTextDisplayed("Saya Mengerti", 5)) {
            kostDetail.dismissFTUE();
            Assert.assertTrue(chat.getLatestChatText().trim().replaceAll("\\s", "").contains(chatText.replaceAll("\\s", "")), "Latest message in chat is wrong");
        }
        else{
            Assert.assertTrue(chat.getLatestChatText().trim().replaceAll("\\s", "").contains(chatText.replaceAll("\\s", "")), "Latest message in chat is wrong");
        }
    }

    @And("tenant enter text {string} in chat page")
    public void tenantEnterTextInChatPage(String chatMsg) {
        chat.insertChatText(chatMsg);
    }

    @Then("user sees the Booking button disable")
    public void userSeesTheBookingButtonDisable() {
        Assert.assertTrue(chat.isBookingButtonDisablePresent(), "booking button is not disabled!");
    }

    @And("user clicks the Lihat Iklan button and redirect to detail property")
    public void userClicksTheLihatIklanButtonAndRedirectToDetailProperty() {
        chat.clickLihatIklanButton();
    }

    @Then("user cant see last owner seen")
    public void userCantSeeLastOwnerSeen() {
        Assert.assertFalse(chat.isOwnerLastSeenPresent(), "owner last seen is display");
    }

    @And("user click Ajukan Sewa {string} from chat room")
    public void userClickAjukanSewaFromChatRoom(String dateToday) {
        chat.clickOnAjukanSewaChatRoomButton(dateToday);
    }

    @And("user batalkan survey if the survey already submitted")
    public void user_cancel_survey() {
        if (playwright.isTextDisplayed("Ubah Jadwal", 5)) {
            chat.clickOnUbahJadwalOnHeaderChatRoomButton();
            chat.clickOnBatalkanSurveiButton();
            chat.clickOnSurveyKosButton();
        }else {
            chat.clickOnSurveyKosButton();
        }
    }

    @And("user change schedule survey if the survey already submitted")
    public void user_change_schedule_survey() {
            chat.clickOnUbahJadwalOnHeaderChatRoomButton();
        }
    @And("user click on survey kos button")
    public void user_click_on_survey_kos_button() {
        chat.clickOnSurveyKosButton();
    }

    @And("user input time survey {string}")
    public void user_input_time_survey(String time) {
        chat.inputTimeSurvey(time);
    }

    @And("user click on chat button in top bar tenant home page")
    public void userClickOnChatButtonInTopBarTenantHomePage() {
        chat.clickOnChatTenant();
    }

    @And("user click on {string} button")
    public void userClickOnSendFormButton(String send) {
        chat.clickOnSendFormButton(send);
    }

    @And("user click on Ubah Jadwal button")
    public void userClickOnUbahJadwalButton() {
        chat.clickOnConfirmationUbahJadwalButton();
    }

    @Then("question {string} is not displayed")
    public void question_is_not_displayed(String question){
        Assert.assertFalse(chat.isQuestionDisplayed(question), "Question is not displayed");
    }

    @Then("user see autoreply message {string}")
    public void userSeeAutoreplyMessage(String chatText) {
        Assert.assertTrue(chat.getLatestChatText().trim().replaceAll("\\s", "").contains(chatText.replaceAll("\\s", "")), "Latest message in chat is wrong");
    }

    @And("user opens the chatroom in the {string} order on chat list")
    public void userOpensTheChatroomInTheOrderOnChatList(String order) {
        var orderNumber = Integer.parseInt(order) - 1;
        chat.openChatroomByOrder(orderNumber);
    }

    @And("user click back button chatroom")
    public void userClickBackButtonChatroom() {
        chat.clickBackButtonChatroom();
    }
}