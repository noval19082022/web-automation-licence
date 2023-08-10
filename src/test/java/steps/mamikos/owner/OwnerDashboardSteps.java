package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.owner.OwnerDashboardPO;
import utilities.PlaywrightHelpers;

public class OwnerDashboardSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers plawright = new PlaywrightHelpers(page);
    OwnerDashboardPO ownerDashboardPO = new OwnerDashboardPO(page);

    @When("Check if the button with label {string} is visible on the {string} page.")
    public void check_if_button_with_label_is_visible_on_the_page(String button, String page){
        Assert.assertTrue(plawright.isButtonWithTextDisplayed(button));
    }

    @When("user clicks on the close button")
    public void user_clicks_on_close_button() {
        ownerDashboardPO.clickOnButtonIconClose();
    }

    @And("user click on widget Penyewa")
    public void userClickOnWidgetPenyewa() {

    }

    @When("user click mamipoin in owner's menu")
    public void user_click_mamipoin_in_owner_s_menu() {
        ownerDashboardPO.clickMamipoinButton();
    }

    @Then("owner can see pengajuan sewa detail on dashboard")
    public void ownerCanSeePengajuanSewaDetailOnDashboard() {
        Assert.assertTrue(ownerDashboardPO.isPengajuanSewaSectionPresent(), "pengajuan sewa not appears");
    }

    @When("owner open notification icon")
    public void owner_open_notification_icon() {
       ownerDashboardPO.clickNotificationButton();

    }

    @And("owner wants to see all notification")
    public void owner_wants_to_see_all_notification() {
        ownerDashboardPO.clicOnSeeAllNotification();
    }

    @Then("validate that owner have {string}")
    public void validate_that_owner_have(String gpStatus) {
        Assert.assertEquals(ownerDashboardPO.getTextGPStatus(), gpStatus, "GP Level is not equal to " + gpStatus);

    }

    @When("owner click close icon pop up")
    public void ownerClickCloseIconPopUp() {
        plawright.clickOnTextButton("close");
    }

    @Then("user verify text {string} on section info untuk anda is appear")
    public void user_verify_text_on_section_info_untuk_anda_is_appear(String textInfoUntukAnda) {
       plawright.clickOnText(textInfoUntukAnda);
    }

    @And("user click menu {string} on feature waktunya mengelola property")
    public void userClickOnFeatureWaktunyaMengelolaProperty(String menu) {
        ownerDashboardPO.clickOnMenuKelolaProperty(menu);
    }

    @When("verify ftue {string}")
    public void verify_ftue(String isDisplayed) {
        if (isDisplayed.equals("displayed")) {
            Assert.assertTrue(ownerDashboardPO.isFTUEChatDisplayed(), "FTUE doesn't displayed!" );
        }else {
            Assert.assertFalse(ownerDashboardPO.isFTUEChatDisplayed(), "FTUE displayed!");
        }

    }

    @When("verify title ftue is {string} and description {string}")
    public void verify_title_ftue_is_and_description(String titleFtue, String descFtue) {
        Assert.assertEquals(ownerDashboardPO.getTitleFtue(titleFtue), titleFtue, "Title FTUE doesn't match!");
        Assert.assertEquals(ownerDashboardPO.getDescFtue(descFtue), descFtue, "Description FTUE doesn't match!");
    }

    @When("user click close icon tooltip broadcast chat on chatlist")
    public void user_click_close_icon_tooltip_broadcast_chat_on_chatlist() throws InterruptedException {
        ownerDashboardPO.clickOnCloseIconBcTooltip();
    }

    @Then("verify label goldplus on chatlist")
    public void verify_label_goldplus_on_chatlist() {
        Assert.assertTrue(ownerDashboardPO.isGoldplusLabelDisplayed(), "Owner doesn't goldplus member!");
    }
}

