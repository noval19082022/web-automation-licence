package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.owner.TenantBackgroundCheckerPO;
import pageobject.owner.chat.BroadcastChatPO;
import pageobject.owner.chat.ChatOwnerPO;
import utilities.PlaywrightHelpers;


public class TenantBackgroundCheckerSteps {
    Page page = ActiveContext.getActivePage();
    TenantBackgroundCheckerPO tenantBackgroundCheckerPO = new TenantBackgroundCheckerPO(page);
    ChatOwnerPO chat = new ChatOwnerPO(page);
    BroadcastChatPO broadcast = new BroadcastChatPO(page);
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);

    @Then("owner can see entry point TBC Lihat Profil at chatroom {string}")
    public void owner_can_see_entry_point_tbc_lihat_profil_at_chatroom(String buttonTxt){
        chat.dismissFTUEMars();
        chat.dismissFTUEMarsKuotaNol();
        broadcast.clickOnCloseTooltip();
        chat.clickButtonOnChatRoomList(buttonTxt);
        Assert.assertTrue(tenantBackgroundCheckerPO.isLihatProfilDisplayed(),"entry point not displayed");
    }

    @And("owner can see coachmark tenant background checker")
    public void owner_can_see_coachmark_tenant_background_checker() {
        playwright.hardWait(2000.0);
        Assert.assertTrue(tenantBackgroundCheckerPO.isCoachmarkDisplayed(),"coachmark not displayed");
        Assert.assertEquals(tenantBackgroundCheckerPO.getTitleCoachmark(),tenantBackgroundCheckerPO.getTitleCoachmark(),"title doesnt match");
        Assert.assertEquals(tenantBackgroundCheckerPO.getDesCoachmark(),tenantBackgroundCheckerPO.getDesCoachmark(),"desc coachmark doesnt match");
    }

    @Then("coachmark is closed")
    public void coachmark_is_closed() {
       Assert.assertFalse(tenantBackgroundCheckerPO.isCoachmarkDisplayed(),"coachmark still show");
    }

    @Then("owner can see entry point TBC Lihat Profil second time at chatroom {string}")
    public void owner_can_see_entry_point_tbc_lihat_profil_second_time_at_chatroom(String buttonTxt) {
        chat.clickButtonOnChatRoomList(buttonTxt);
        Assert.assertTrue(tenantBackgroundCheckerPO.isLihatProfilDisplayed(),"entry point not displayed");
    }

    @Then("tenant can't see entry point TBC Lihat Profil at chatroom {string}")
    public void tenant_cant_see_entry_point_tbc_lihat_profil_at_chatroom(String buttonTxt) {
        chat.clickButtonOnChatRoomList(buttonTxt);
        Assert.assertFalse(tenantBackgroundCheckerPO.isLihatProfilDisplayed(),"entry point displayed");
    }

    @And("owner open TBC Lihat Profil at chatroom {string}")
    public void owner_open_tbc_lihat_profil_at_chatroom(String buttonTxt) {
        chat.dismissFTUEMarsGPAndBroadCast();
        chat.clickButtonOnChatRoomList(buttonTxt);
        chat.dismissFTUETBC();
        tenantBackgroundCheckerPO.clickOnLihatProfil();
    }

    @When("owner click back button on TBC page")
    public void owner_click_back_button_on_tbc_page() {
        tenantBackgroundCheckerPO.clickOnBack();
    }

    @And("owner Non GP open TBC Lihat Profil at chatroom {string}")
    public void owner_non_gp_open_tbc_lihat_profil_at_chatroom(String buttonTxt) {
        chat.dismissFTUEMars();
        chat.dismissFTUEMarsKuotaNol();
        chat.clickButtonOnChatRoomList(buttonTxt);
        chat.dismissFTUETBC();
        tenantBackgroundCheckerPO.clickOnLihatProfil();
    }

    @When("owner click button {string} on TBC page")
    public void owner_click_button_on_tbc_page(String buttonTxt) {
        Assert.assertEquals(tenantBackgroundCheckerPO.getTextBeliPaket(), buttonTxt, "button is not equal");
        tenantBackgroundCheckerPO.clickOnBeliPaket();
    }

    @And("owner doesn't have GP open TBC Lihat Profil at chatroom {string}")
    public void owner_doesnt_have_gp_open_tbc_lihat_profil_at_chatroom(String buttonTxt) {
        chat.clickButtonOnChatRoomList(buttonTxt);
        chat.dismissFTUETBC();
        tenantBackgroundCheckerPO.clickOnLihatProfil();
    }

    @Then("owner should see anda belum memiliki kos aktif pop up")
    public void owner_should_see_anda_belum_memiliki_kos_aktif_pop_up() {
        playwright.hardWait(5000.0);
        Assert.assertTrue(tenantBackgroundCheckerPO.isInfoKostNotActiveDisplayed(), "Information doesn't show");
    }

    @Then("owner will back to TBC page")
    public void owner_will_back_to_tbc_page() {
        Assert.assertTrue(tenantBackgroundCheckerPO.isInfoTBCPageDisplayed(),"Information doesn't show");
    }
}