package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.owner.OwnerDashboardPO;

public class OwnerDashboardSteps {
    Page page = ActiveContext.getActivePage();
    OwnerDashboardPO ownerDashboardPO = new OwnerDashboardPO(page);

    @When("user/owner/tenant click {string}")
    public void user_click(String text) {
        ownerDashboardPO.clickOnText(text);
    }

    @When("user/owner/tenant click {string} button")
    public void user_click_button(String text) {
        ownerDashboardPO.clickOnTextButton(text);
    }

    @Then("user/owner will see that the text {string} is displayed")
    public void owner_will_see_that_the_text_is_displayed(String text) {
        Assert.assertTrue(ownerDashboardPO.isTextDisplayed(text));
    }

    @Then("owner should not be able to see the text {string}")
    public void owner_should_not_be_able_to_see_the_text(String text) {
        Assert.assertFalse(ownerDashboardPO.isTextDisplayed(text));
    }

    @When("Check if the button with label {string} is visible on the {string} page.")
    public void check_if_button_with_label_is_visible_on_the_page(String button, String page){
        Assert.assertTrue(ownerDashboardPO.isButtonWithTextDisplayed(button));
    }

    @When("user clicks on the close button")
    public void user_clicks_on_close_button() {
        ownerDashboardPO.clickOnButtonIconClose();
    }

    @And("user click on widget Penyewa")
    public void userClickOnWidgetPenyewa() {

    }
}
