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

    @When("owner click Pusat Bantuan")
    public void owner_click_pusat_bantuan() {
        ownerDashboardPO.clickHelpCenterOwner();
    }

    @When("owner open notification icon")
    public void owner_open_notification_icon() {
       ownerDashboardPO.clickNotificationButton();

    }

    @And("owner wants to see all notification")
    public void owner_wants_to_see_all_notification() {
        ownerDashboardPO.clicOnSeeAllNotification();
    }
}
