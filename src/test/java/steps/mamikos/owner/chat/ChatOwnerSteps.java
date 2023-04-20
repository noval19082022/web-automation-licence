package steps.mamikos.owner.chat;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.owner.chat.ChatOwnerPO;
import pageobject.owner.kelolatagihan.BillAndBookingManagementPO;

public class ChatOwnerSteps {
    Page page = ActiveContext.getActivePage();
    ChatOwnerPO chat = new ChatOwnerPO(page);
    BillAndBookingManagementPO billBookingManage = new BillAndBookingManagementPO(page);

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

    @And("user clicks on Accept button from chat room")
    public void userClickOnAcceptButtonFromChatRoom() throws InterruptedException {
        chat.clickAcceptFromChatOwner();
        billBookingManage.clickOnRoomNumberInput();
        billBookingManage.clickOnPilihDitempat();
        billBookingManage.clickOnTerapkanButton();
        billBookingManage.clickOnLanjutkanButton();
        billBookingManage.clickOnSimpan();
      //  billBookingManage.clickOkButton();
    }

    @Then("system display title {string} after accept booking from chat room")
    public void ownerCanSeeAdditionalPriceWithPrice(String notPaidFirstRent) {
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
}
