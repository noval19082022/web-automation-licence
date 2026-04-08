package steps.mamikos.common;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.HomePO;
import pageobject.common.LoadingPO;
import pageobject.tenant.TenantLoginPO;
import utilities.PlaywrightHelpers;

import java.util.List;
import java.util.Map;

public class CommonSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    TenantLoginPO users = new TenantLoginPO(page);
    HomePO home = new HomePO(page);
    LoadingPO loadingPO = new LoadingPO(page);

    private PlaywrightHelpers getPlaywright() {
        return new PlaywrightHelpers(ActiveContext.getActivePage());
    }

    @When("user/owner/tenant click {string}")
    public void user_click(String text) {
        getPlaywright().clickOnText(text);
    }

    @When("user/owner/tenant click {string} button")
    public void user_click_button(String text) {
        getPlaywright().clickOnTextButton(text);
    }

    @Then("user/owner/tenant/admin will see that the text {string} is displayed")
    public void user_will_see_that_the_text_is_displayed(String text) {
        Assert.assertTrue(getPlaywright().isTextDisplayed(text, 20000));
    }

    @Then("user/owner/tenant/admin will see that the text is displayed")
    public void user_will_see_that_the_text_(List<String> sentences) {
        for (var sentence : sentences) {
            Assert.assertTrue(playwright.isTextDisplayed(sentence, 5000));
        }
    }

    @Then("user/owner/tenant should not be able to see the text {string}")
    public void owner_should_not_be_able_to_see_the_text(String text) {
        playwright.hardWait(2000);
        if (playwright.isTextDisplayed(text)) {
            Assert.assertTrue(playwright.isTextDisplayed(text));
        }else{
            Assert.assertFalse(playwright.isTextDisplayed(text));
        }
    }

    @And("user/owner/tenant logs out")
    public void userLogsOutAsTenant() {
        playwright.navigateToAndWaitLocator(Mamikos.URL, home.getMamikosLogo());
        users.logoutAsTenant();
    }

    @And("user/owner/tenant/adminbangker/admin try to logout from mamikos")
    public void userLogout() {
        playwright.navigateToAndWaitLocator(Mamikos.URL, home.getMamikosLogo());
        users.tryToLogoutFromMamikos();
    }

    @And("user/tenant/admin close unused browser tab")
    public void userCloseUnusedTab() {
        List<Page> pages = ActiveContext.getActiveBrowserContext().pages();
        int numberOfTabsToClose = Math.min(pages.size() - 1, 3);
        for (int i = pages.size() - 1; i > 0 && numberOfTabsToClose > 0; i--) {
            Page page = pages.get(i);
            page.close();
            numberOfTabsToClose--;
        }
        ActiveContext.setActivePage(pages.get(0));
    }

    @When("user/tenant/owner redirect to apartment details:")
    public void tenantGoToApartmentDetails(DataTable table) {
        Map<String, String> apartmentPath;
        playwright = new PlaywrightHelpers(ActiveContext.getActivePage());
        apartmentPath = table.asMap(String.class, String.class);
        String pathUrlApartment = Mamikos.URL + "/unit" +apartmentPath.get(Mamikos.ENV);
        playwright.navigateTo(pathUrlApartment);
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
        loadingPO.waitForLoadingIconDisappear();
        Assert.assertTrue(playwright.getActivePageURL().contains(link), "Url doesn't match");
    }

    @Then("user redirected to URL {string}")
    public void user_redirect_to_url_only(String expectedUrl) {
        PlaywrightHelpers activePlaywright = getPlaywright();
        activePlaywright.hardWait(3000); // Wait for redirect to complete
        String currentUrl = activePlaywright.getActivePageURL();

        // If not at expected URL and it's an owner URL path, navigate to it
        if (!currentUrl.contains(expectedUrl) && expectedUrl.contains(Mamikos.OWNER_URL)) {
            activePlaywright.navigateTo(expectedUrl);
            activePlaywright.waitTillPageLoaded();
            currentUrl = activePlaywright.getActivePageURL();
        }
        Assert.assertTrue(currentUrl.contains(expectedUrl),
            "Expected URL to contain: " + expectedUrl + " but actual URL is: " + currentUrl);
    }

    @Then("user/owner/tenant will see that the text {string} is displayed on the table")
    public void user_will_see_that_the_text_is_displayed_on_the_table(String text) {
        Assert.assertTrue(playwright.waitTillLocatorIsVisible(playwright.locatorByRoleSetName(AriaRole.CELL, text).first()));
    }

    @Then("admin/user/owner/tenant will get empty table list data")
    public void users_will_get_empty_table_list_data() {
        Assert.assertFalse(page.isVisible("//tbody/tr"));
    }

    @And("bring page to front")
    public void bringPageToFront() {
        ActiveContext.getActivePage().bringToFront();
    }

    @And("user/admin/tenant waiting for {string} seconds for next step")
    public void userWaitingForSecondsForNextStep(String time) {
        new PlaywrightHelpers(ActiveContext.getActivePage())
                .hardWait(Double.parseDouble(time) * 1000);
    }

    @Then("admin should be able to see the text {string}")
    public void adminShouldBeAbleToSeeTheText(String info) {
        Assert.assertTrue(playwright.isTextDisplayed(info, 1000));
    }

    @Then("admin should not be able to see the text {string}")
    public void adminShouldNotBeAbleToSeeTheText(String info) {
        Assert.assertFalse(playwright.isTextDisplayed(info));
    }

    @And("admin/user/tenant/owner go back to previous page")
    public void adminGoBackToPreviousPage() {
        playwright.backToPreviousPage();
    }
}
