package steps.mamikos.common;

import com.microsoft.playwright.Page;
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
    public void owner_will_see_that_the_text_is_displayed(String text) {
        Assert.assertTrue(playwright.isTextDisplayed(text,1000));
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
}
