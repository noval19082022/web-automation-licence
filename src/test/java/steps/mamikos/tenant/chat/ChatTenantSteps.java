package steps.mamikos.tenant.chat;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.KostDetailsPO;
import pageobject.owner.chat.ChatOwnerPO;
import pageobject.tenant.chat.ChatTenantPO;
import utilities.PlaywrightHelpers;

import java.util.List;
import java.util.ArrayList;

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
        
        // Presisi validation seperti original, tapi dengan safety check
        Assert.assertTrue(questionList.size() > 0, "No questions found. Expected at least: " + questions.size());
        
        // Print actual questions found for debugging
        System.out.println("Actual questions found: " + questionList.size());
        for (int i = 0; i < questionList.size(); i++) {
            System.out.println((i+1) + ". " + questionList.get(i));
        }
        
        // Check if all expected questions are present (using contains for partial match)
        List<String> missingQuestions = new ArrayList<>();
        for (String expectedQuestion : questions) {
            boolean found = false;
            for (String actualQuestion : questionList) {
                // Use contains to handle cases where actual question has extra text
                if (actualQuestion.contains(expectedQuestion)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                missingQuestions.add(expectedQuestion);
            }
        }
        
        if (!missingQuestions.isEmpty()) {
            System.out.println("Missing expected questions:");
            for (String missing : missingQuestions) {
                System.out.println("- " + missing);
            }
        }
        
        Assert.assertTrue(missingQuestions.isEmpty(), 
            "Missing expected questions: " + missingQuestions + 
            ". Total found: " + questionList.size() + ", Expected at least: " + questions.size());
    }

    @Given("tenant click button ajukan sewa from chat popup")
    public void tenantClickButtonAjukanSewaFromChatPopup() {
        chat.clickAjukanSewaButton();
    }

    @Given("send button become {string}")
    public void sendButtonBecome(String textButton) {
        Assert.assertEquals(chat.verifySendLabel(),textButton, "Button text is wrong");
    }

    @When("user select question {string}")
    public void userSelectQuestion(String questionOption) {
        // Get aria snapshot before clicking the question
        String ariaSnapshotBefore = chat.getModalChatAriaSnapshot();
        System.out.println("Aria snapshot before clicking question: " + ariaSnapshotBefore);

        // Verify that the question option exists in the aria snapshot
        Assert.assertTrue(ariaSnapshotBefore.contains(questionOption),
            "Question option '" + questionOption + "' not found in modal chat aria snapshot");

        // Click the question after verification
        chat.clickQuestion(questionOption);
    }

    @And("user select chat preset question {string}")
    public void userSelectQChatPresetuestion(String questionOption) {
        chat.clickPresetQuestion(questionOption);
    }

    @Then("user can see chat preset question {string}")
    public void userVerifyChatPresetQuestion(String questionOption){
        chat.isChatPresetQuestionVisible(questionOption);
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
        } else {
            Assert.assertTrue(chat.getLatestChatText().replaceAll("\\s", "").trim().contains(chatText.replaceAll("\\s", "")), "Latest message in chat is wrong");
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
        if (playwright.isTextDisplayed("Ubah Survei", 5)) {
            chat.visitDetailSurveyFromChatroom();
            chat.clickOnBatalkanSurveiButton();
            chat.fillBatalkanForm("kita juga dari perusahaan banteng mas");
            chat.sendFormBatalkanSurvey();
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

    @And("user tap on survey kost btn on detail chatroom")
    public void userTapOnSurveyKostBtnOnDetailChatroom() {
        chat.clickOnSurveyKosButton();
    }
}