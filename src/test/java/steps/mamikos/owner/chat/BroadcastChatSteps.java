package steps.mamikos.owner.chat;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.owner.chat.BroadcastChatPO;
import utilities.PlaywrightHelpers;

public class BroadcastChatSteps {
    Page page = ActiveContext.getActivePage();
    BroadcastChatPO broadcast = new BroadcastChatPO(page);
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);

    @Then("user verify pop up message {string} is appear")
    public void user_verify_pop_up_message_is_appear(String message) {
        Assert.assertEquals(broadcast.getWarningBroadcastText(), message, "Warning Message is different");
        playwright.hardWait(3000);
    }

    @When("user enter text {string} on Broadcast list kos")
    public void user_enter_text_on_broadcast_list_kos(String text) {
        broadcast.searchKostBC(text);
    }

    @Then("user verify kost card is disable")
    public void user_verify_kost_card_is_disable() {
        Assert.assertTrue(broadcast.isKostCardDisabled());
    }

    @When("user selects message row number {int} on the broadcast chat dashboard")
    public void user_selects_message_row_number_on_the_broadcast_chat_dashboard(int option) {
        broadcast.selectMessageOptionBC(option);
    }

    @When("user click back arrow button on BC page")
    public void user_click_back_arrow_button_on_BC_page() {
        broadcast.clickOnBackButtonBC();
    }

    @Then("user verify input broadcast message is not visible")
    public void user_verify_input_broadcast_message_is_not_visible() {
        broadcast.isTextFieldBCMessageDisplayed();
    }

    @When("user clicks on the close icon next to the search bar to reset it")
    public void user_clicks_on_the_close_icon_next_to_the_search_bar_to_reset_it() {
        broadcast.clickOnCloseSearchBroadcastSearchIcon();
    }

    @Then("the list of Kosts should be displayed")
    public void the_list_of_Kosts_should_be_displayed() {
        Assert.assertTrue(broadcast.isKosListDisplayed(), "kost list not displayed");
    }

    @Then("the selected message should be visible on the details page of the broadcast:")
    public void the_selected_message_should_be_visible_on_the_details_page_of_the_broadcast(String docString) {
        Assert.assertEquals(broadcast.getMessageBCselected(),docString.replaceAll("\\s", ""));
    }

    @When("user clicked ubah button to modify template broadcast message")
    public void user_clicked_ubah_button_to_modify_broadcast_message() {
        broadcast.clickUbahTemplateBroadcastText();
    }

    @When("user input message on Broadcast Chat {string}")
    public void user_input_message_on_broadcast_chat(String message) {
        broadcast.inputBroadcastMessage(message);
    }

    @When("user input multiple lanes message on Broadcast Chat:")
    public void user_input_multiple_lanes_message_on_broadcast_chat(String message) {
        broadcast.inputBroadcastMessage(message);
    }

    @Then("counter text area message show {string}")
    public void counter_text_area_message_show(String countText) {
        Assert.assertEquals(broadcast.getCountText(),countText);
    }

    @Then("user should see the message {string} displayed under text field")
    public void userShouldSeeTheMessageDisplayedUnderTextField(String error) {
        Assert.assertEquals(broadcast.getErrorInputBroadcastText().trim(), error, "Error message is wrong");
    }

    @Then("user see {string} on Preview Broadcast Message")
    public void user_see_on_Preview_Broadcast_Message(String error) {
        Assert.assertEquals(broadcast.getPreviewMessageBC().trim(), error, "Error message is wrong");
    }

    @Then("user see tooltip broadcast chat")
    public void user_see_tooltip_broadcast_chat() {
        Assert.assertTrue(broadcast.isTooltipBroadcastDisplayed(), "Tooltip is not present");
    }

    @When("user click icon close at tooltip")
    public void user_click_icon_close_at_tooltip() {
        broadcast.clickOnCloseTooltip();
    }

    @Then("broadcast chat tooltip should not be visible")
    public void broadcast_chat_tooltip_should_not_be_visible() {
        Assert.assertFalse(broadcast.isTooltipBroadcastDisplayed(), "Tooltip is present!");
    }

    @When("user click on the broadcast message icon in the chat page")
    public void user_click_on_broadcast_message_icon_in_the_chat_page() {
        broadcast.clickOnBroadcastChatIcon();
    }

    @Then("user see intercept closed and user stay in Kelola Page")
    public void user_see_intercept_closed_and_user_stay_in_kelola_page() {
        broadcast.clickOnCancelGPbutton();
        Assert.assertEquals(playwright.getActivePageURL(), "https://owner-jambu.kerupux.com/");
    }

    @Then ("Lihat penerima page is displayed")
    public void lihat_penerima_page_is_displayed(){
        Assert.assertTrue(broadcast.isLihatPenerimaPageDisplayed());
    }

}
