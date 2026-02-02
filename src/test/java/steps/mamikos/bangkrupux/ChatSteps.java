package steps.mamikos.bangkrupux;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.admin.mamipay.bangkrupux.ChatPO;
import testdata.BangKrupuxTestData;
import utilities.PlaywrightHelpers;


public class ChatSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    ChatPO chatAdmin = new ChatPO(page);

    @When("user click on the Group Chat")
    public void user_click_on_the_group_chat() {
        chatAdmin.clickOnTenantChat();
    }

    @When("user open chat room {string}")
    public void user_open_chat_room(String bse) {
        Page activePage = ActiveContext.getActivePage();
        ChatPO activeChatAdmin = new ChatPO(activePage);
        activeChatAdmin.openChatRoom(bse);
    }

    @Then("resolved button is disable")
    public void resolved_button_is_disable() {
        Page activePage = ActiveContext.getActivePage();
        ChatPO activeChatAdmin = new ChatPO(activePage);
        Assert.assertTrue(activeChatAdmin.isResolvedButtonDisable());
    }

    @Then("resolved button is enable")
    public void resolved_button_is_enable(){
        Page activePage = ActiveContext.getActivePage();
        ChatPO activeChatAdmin = new ChatPO(activePage);
        Assert.assertFalse(activeChatAdmin.isResolvedButtonDisable());
    }

    @When("admin resolve chat")
    public void admin_resolve_chat(){
        Page activePage = ActiveContext.getActivePage();
        ChatPO activeChatAdmin = new ChatPO(activePage);
        activeChatAdmin.clickResolveButton();
    }

    @Then("sent closing chat {string}")
    public void sent_closing_chat(String message) {
        Assert.assertEquals(chatAdmin.getLastMessage(),message);
    }

    @And("user go to Rajawali Chat Room")
    public void user_go_to_rajawali_chat_room() {
        Page activePage = ActiveContext.getActivePage();
        ChatPO activeChatAdmin = new ChatPO(activePage);
        activeChatAdmin.clickOnChatRoomMenu();
    }

    @When("admin chat {string}")
    public void admin_chat(String message){
        chatAdmin.sendChat(message);
    }

    @Then("user able to see Kos Name")
    public void user_able_to_see_kost_name() {
        BangKrupuxTestData.setKostName(chatAdmin.getChatKosTitle());
        chatAdmin.clickOnKosTitleChatHeader();
    }

    @When("user click on Kos Name from chat list")
    public void user_click_on_kost_name_from_chat_list() {
        chatAdmin.clickOnKosTitleChatList();
    }

    @Then("user will directed to Kos Detail in new tab")
    public void user_will_directed_to_kost_detail_in_newTab() {
        page = ActiveContext.getActivePage();
        playwright = new PlaywrightHelpers(page);
        playwright.waitTillPageLoaded();
        Assert.assertTrue(playwright.getActivePageURL().contains(BangKrupuxTestData.getKostName()), "Url doesn't match");
    }

    @When("admin select filter {string}")
    public void admin_select_filter(String type) {
        chatAdmin.setChatSearchType(type);
    }

    @And("admin fill search chat with {string}")
    public void admin_fill_search_chat_with_x(String text) {
        Page activePage = ActiveContext.getActivePage();
        ChatPO activeChatAdmin = new ChatPO(activePage);
        if(text != null){
            activeChatAdmin.fillSearch(text);
        }
        activeChatAdmin.clickOnAllCategory();
    }

    @Then("admin can see result data")
    public void admin_can_see_result_data(){
        chatAdmin.getResutlSearch();
    }

    @And("admin click {string} on chat list")
    public void admin_click_on_chat_list(String text){
        if(text.equalsIgnoreCase("mark important")){
            chatAdmin.clickMarkImportant();
        }
        else if(text.equalsIgnoreCase("unmark important")){
            chatAdmin.clickUnmarkImportan();
        }
    }

    @Then("admin can see mark important on list")
    public void admin_can_see_mark_important_on_list(){
        Assert.assertTrue(chatAdmin.getImportantButtonOnList(), "not appears mark important");
    }

    @And("admin filter {string} on chat list")
    public void admin_filter_on_chat_list(String text){
            chatAdmin.clickImportantFilterButton(text);
    }

    @Then("admin can see unread counter on list with {string}")
    public void admin_can_see_unread_counter_on_list_with(String text){
        chatAdmin.getUnreadCounterText(text);
    }

    @Then("unresolved counter increase by {int}")
    public void unresolved_counter_increase_by(Integer counter) {
        Assert.assertEquals(chatAdmin.getUnresolvedCounter(),counter);
    }

    @Then("unresolved counter is not visible")
    public void unresolved_counter_is_not_visible() {
        Assert.assertTrue(chatAdmin.isUnresolvedCounterNotVisible(), "Unresolved counter should not be visible");
    }

    @When("admin click Jawab Cepat button")
    public void admin_click_jawab_cepat_button() {
        Page activePage = ActiveContext.getActivePage();
        ChatPO activeChatAdmin = new ChatPO(activePage);
        activeChatAdmin.clickJawabCepatButton();
    }

    @And("admin search jawab cepat template {string}")
    public void admin_search_jawab_cepat_template(String templateText) {
        Page activePage = ActiveContext.getActivePage();
        ChatPO activeChatAdmin = new ChatPO(activePage);
        activeChatAdmin.searchJawabCepatTemplate(templateText);
    }

    @And("admin click Kirim button")
    public void admin_click_kirim_button() {
        Page activePage = ActiveContext.getActivePage();
        ChatPO activeChatAdmin = new ChatPO(activePage);
        activeChatAdmin.clickKirimButton();
    }

    @When("admin send jawab cepat template {string}")
    public void admin_send_jawab_cepat_template(String templateText) {
        Page activePage = ActiveContext.getActivePage();
        ChatPO activeChatAdmin = new ChatPO(activePage);
        activeChatAdmin.sendJawabCepatTemplate(templateText);
    }
}
