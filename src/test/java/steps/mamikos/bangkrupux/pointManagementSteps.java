package steps.mamikos.bangkrupux;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.admin.mamipay.bangkrupux.PointManagementPO;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

public class pointManagementSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    LocatorHelpers locator = new LocatorHelpers(page);
    PointManagementPO pointManagement = new PointManagementPO(page);

    @When("admin successfully {string} user named {string} with status {string}")
    public void admin_successfully_do_action_for_user_point(String action, String user, String status) {
        playwright.pageScrollUntilElementIsVisible(playwright.filterLocatorHasText(locator.span, "User Point"));
        playwright.clickOnText("User Point");
        pointManagement.searchUserpoinTextBox(user);
        playwright.clickOnText("Search");
        pointManagement.statusUser(status).click();
        playwright.clickOnTextButton("Yes, Do It!");
        Assert.assertTrue(playwright.isTextDisplayed("Success! " + user + " successfully "+action));
    }

}
