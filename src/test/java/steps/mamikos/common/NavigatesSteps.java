package steps.mamikos.common;

import com.microsoft.playwright.Page;
import config.global.FlowControl;
import config.mamikos.Mamikos;
import config.playwright.context.ActiveContext;
import config.playwright.context.OwnerContext;
import config.playwright.context.TenantContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageobject.common.HomePO;
import utilities.PlaywrightHelpers;

public class NavigatesSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    HomePO home = new HomePO(page);

    @Given("user go to mamikos homepage")
    public void userGoToMamikosHomepage() {
        playwright.navigateToAndWaitLocator(Mamikos.URL, home.getMamikosLogo());
    }

    @Given("admin go to mamikos mamipay admin")
    public void adminGoToMamikosMamipayAdmin() {
        playwright.navigateTo(Mamikos.ADMINMAMIPAY);
    }

    @When("user navigate to tagihan kost saya")
    public void userNavigateToTagihanKostSaya() {
        playwright.navigateTo(Mamikos.URL + Mamikos.KOST_SAYA_BILLING);
    }

    @When("scenario is {string}")
    public void scenarioIsContinue(String isContinue) {
        FlowControl.setContinueFlow(isContinue.equalsIgnoreCase("continue"));
    }

    @Given("tenant open browser page {string}")
    public void tenantOpenBrowserPage(String pageNumber) {
        ActiveContext.setActivePage(TenantContext.getTenantBrowserContext().pages().get(Integer.parseInt(pageNumber)));
    }

    @When("owner open browser page {string}")
    public void ownerOpenBrowserPage(String pageNumber) {
        ActiveContext.setActivePage(OwnerContext.getOwnerBrowserContext().pages().get(Integer.parseInt(pageNumber)));
    }

    @When("tenant navigates to edit profile")
    public void tenantNavigatesToEditProfile() {
        playwright.navigateTo(Mamikos.URL + Mamikos.TENANT_EDIT_PROFILE, 60000.0);
    }

    @When("tenant close page number {int}")
    public void tenantClosePageNumber(int pageNumber) {
        ActiveContext.getActiveBrowserContext().pages().get(pageNumber).close();
    }
}
