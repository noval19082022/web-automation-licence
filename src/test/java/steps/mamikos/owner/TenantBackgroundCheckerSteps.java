package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.owner.TenantBackgroundCheckerPO;
import pageobject.owner.chat.ChatOwnerPO;
import pageobject.owner.fiturpromosi.BroadcastChatPO;
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
}
