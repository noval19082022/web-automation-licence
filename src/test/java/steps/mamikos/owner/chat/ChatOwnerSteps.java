package steps.mamikos.owner.chat;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.KostDetailsPO;
import pageobject.owner.OwnerDashboardPO;
import pageobject.owner.chat.ChatOwnerPO;
import pageobject.owner.kelolatagihan.BillAndBookingManagementPO;

public class ChatOwnerSteps {
    Page page = ActiveContext.getActivePage();
    KostDetailsPO kostDetail = new KostDetailsPO(page);
    ChatOwnerPO chat = new ChatOwnerPO(page);
    BillAndBookingManagementPO billBookingManage = new BillAndBookingManagementPO(page);
    OwnerDashboardPO owner = new OwnerDashboardPO(page);

    @And("user click chat button in top bar owner home page")
    public void userClickChatButtonInTopBarOwnerHomePage() {
        chat.clickChatOwner();
        chat.dismissFTUEMarsGPAndSurveyIfExist();
        chat.dismissFTUEJemputBolaIfExist();
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
        Page activePage = ActiveContext.getActivePage();
        ChatOwnerPO activeChat = new ChatOwnerPO(activePage);
        KostDetailsPO activeKostDetail = new KostDetailsPO(activePage);
        activeChat.clickChatKos();
        activeKostDetail.dismissFTUEIfExist();
    }

    @And("search chat in chatlist {string}")
    public void searchChatInChatlist(String inputText) {
        chat.searchChatTenant(inputText);
    }

    @When("owner enter text {string} in chat page")
    public void ownerEnterTextInChatPage(String chatMsg) {
        chat.insertChatText(chatMsg);
    }

    @And("user clicks on Accept button from chat room")
    public void userClickOnAcceptButtonFromChatRoom() throws InterruptedException {
        chat.clickAcceptFromChatOwner();
        billBookingManage.clickOnRoomNumberInput();
        billBookingManage.clickOnPilihDitempat();
        billBookingManage.clickOnTerapkanButton();
        billBookingManage.clickOnLanjutkanButton();
        billBookingManage.clickOnSimpan();
    }

    @Then("system display title {string} after accept booking from chat room")
    public void ownerCanSeeAdditionalPriceWithPrice(String notPaidFirstRent) {
        chat.waitForChatRoomVisible();
        Assert.assertEquals(chat.getNotPaidFirstRentText(), notPaidFirstRent, "Belum bayar sewa pertama");
    }

    @And("Owner can see name of Tenant is {string}")
    public void owner_can_see_name_of_tenant_is(String tenantName) {
        Assert.assertEquals(chat.getTenantName(),tenantName,"Tenant name doesn't match");
    }

    @And("Owner can see Kost name, harga kos, sisa kamar")
    public void owner_can_see_kost_name_harga_kos_sisa_kamar() {
        Assert.assertTrue(chat.isKostNameDisplayed());
        Assert.assertTrue(chat.isPriceKostDisplayed());
        Assert.assertTrue(chat.isSisaKamarDisplayed());
    }
    @And("user dismiss FTUE MARS and FTUE Broadcast")
    public void userDismissFTUEMARSAndFTUEBroadcast() {
        chat.clickChatOwner();
        chat.dismissFTUEMars();
        chat.dismissFTUEMarsKuotaNol();
        chat.dismissFTUEJemputBolaIfExist();
    }

    @And("user dismiss FTUE MARS and FTUE Broadcast trigger from info untuk anda")
    public void userDismissFTUEMARSAndFTUEBroadcastTriggerFromInfoUntukAnda() {
        chat.dismissFTUEMars();
        chat.dismissFTUEMarsKuotaNol();
        chat.dismissFTUEJemputBolaIfExist();
    }

    @And("user dismiss FTUE survey kost")
    public void AndUserDismissFTUESurveyKost() {
        chat.dismissFTUESurvey();
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

    @And("user/owner dismiss FTUE goldplus")
    public void userDismissFTUEGoldplus() {
        owner.dismissFTUEGoldplus();
    }

    @And("user dismiss FTUE MARS Goldplus and FTUE Broadcast")
    public void userDismissFTUEMARSGoldplusAndFTUEBroadcast() {
        chat.dismissFTUEMarsGPAndSurveyIfExist();
    }

    @Then("user see attachment button is enabled")
    public void userSeeAttachmentButtonIsEnabled() {
        Assert.assertTrue(chat.isAttachmentButtonEnabled(), "Button is disabled");
    }

    @And("user see the appearence of Mars chatlist")
    public void userSeeTheAppearenceOfMarsChatlist() {
        Assert.assertTrue(chat.isWeeklyQuotaChatlistPresent(), "Weekly Quota Information in chatlist is not present");
        Assert.assertTrue(chat.isRegisterGPButtonChatlistPresent(), "Register GP Button in chatlist is not present");
    }

    @Then("user see the appearence of Mars chatroom")
    public void userSeeTheAppearenceOfMarsChatroom() {
        chat.dismissFTUELihatProfilPenyewaOnChatroomIfExist();
        Assert.assertTrue(chat.isWeeklyQuotaChatroomPresent(), "Weekly Quota Information in chatroom is not present");
        Assert.assertTrue(chat.isRegisterGPButtonChatroomPresent(), "Register GP Button in chatroom is not present");
    }

    @When("user click broadcast chat entry point")
    public void user_click_broadcast_chat_entry_point() {
        chat.clickOnBCChatPage();
    }

    @And("user dismiss FTUE TBC")
    public void userDismissFTUETBC() {
        chat.dismissFTUETBC();
    }

    @Then("owner can see label with {string}")
    public void owner_can_see_label_with(String labelText) {
        Assert.assertEquals(chat.getBookingStatusLabel(), labelText,"Label doesn't match!");
    }

    @When("owner wants to accsess chatroom")
    public void owner_wants_to_accsess_chatroom() {
        chat.clickChatOwner();
    }

    @And("user dismiss Laporan klik FTUE")
    public void userDismissLaporanKlikFTUE() {
        chat.dismissFTUEJemputBola();
    }

    @And("owner open chatroom {string} without close FTUE")
    public void ownerOpenChatroomWithoutCloseFTUE(String arg0) {
        chat.searchChatTenant(arg0);
    }
}
