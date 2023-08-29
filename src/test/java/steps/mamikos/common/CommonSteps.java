package steps.mamikos.common;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.HomePO;
import pageobject.tenant.TenantLoginPO;
import utilities.PlaywrightHelpers;

public class CommonSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    TenantLoginPO users = new TenantLoginPO(page);
    HomePO home = new HomePO(page);

    @When("user/owner/tenant click {string}")
    public void user_click(String text) {
        playwright.clickOnText(text);
    }

    @When("user/owner/tenant click {string} button")
    public void user_click_button(String text) {
        playwright.clickOnTextButton(text);
    }

    @Then("user/owner/tenant will see that the text {string} is displayed")
    public void user_will_see_that_the_text_is_displayed(String text) {
        Assert.assertTrue(playwright.isTextDisplayed(text, 2000));
    }

    @Then("user/owner/tenant should not be able to see the text {string}")
    public void owner_should_not_be_able_to_see_the_text(String text) {
        Assert.assertFalse(playwright.isTextDisplayed(text));
    }

    @And("user/owner/tenant logs out")
    public void userLogsOutAsTenant() {
        playwright.navigateToAndWaitLocator(Mamikos.URL, home.getMamikosLogo());
        users.logoutAsTenant();
    }

    @And("user/tenant/admin close unused browser tab")
    public void userCloseUnusedTab() {
        var tabTotal = ActiveContext.getActiveBrowserContext().pages().size();
        for (int i = tabTotal; i >= 0; i--) {
            if (i == 1) break;
            ActiveContext.getActiveBrowserContext().pages().get(i - 1).close();
        }
        ActiveContext.setActivePage(ActiveContext.getActiveBrowserContext().pages().get(0));
    }

    @Then("user/owner/tenant go back to previous page")
    public void user_go_back_to_previous_page() {
        page.goBack();
    }

    @Then("The system should display {string} button as enabled")
    public void the_system_should_display_button_as_enabled(String buttonName) {
        Assert.assertFalse(page.isVisible("//*[@disabled='disabled'][contains(., '" + buttonName + "')]"));
    }

    @Then("The system should display {string} button as disabled")
    public void the_system_should_display_button_as_disabled(String buttonName) {
        Assert.assertTrue(page.isVisible("//*[@disabled='disabled'][contains(., '" + buttonName + "')]"));
    }

    @Then("user redirected to {string}")
    public void user_redirect_link(String link) {
        Assert.assertTrue(playwright.getActivePageURL().contains(link), "Url doesn't match");
    }

    @Then("user/owner/tenant will see that the text {string} is displayed on the table")
    public void user_will_see_that_the_text_is_displayed_on_the_table(String text) {
        Assert.assertTrue(playwright.waitTillLocatorIsVisible(playwright.locatorByRoleSetName(AriaRole.CELL, text).first()));
    }

    @Then("admin/user/owner/tenant will get empty table list data")
    public void users_will_get_empty_table_list_data() {
        Assert.assertFalse(page.isVisible("//tbody/tr"));
    }
}
