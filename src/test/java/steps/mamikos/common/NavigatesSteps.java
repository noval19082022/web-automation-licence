package steps.mamikos.common;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import config.global.FlowControl;
import config.playwright.context.ActiveContext;
import config.playwright.context.OwnerContext;
import config.playwright.context.TenantContext;
import data.mamikos.Mamikos;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
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
        page = ActiveContext.getActivePage();
        playwright.navigateTo(Mamikos.URL + Mamikos.TENANT_EDIT_PROFILE, 60000.0);
    }

    @When("tenant/owner/admin close page number {int}")
    public synchronized void tenantClosePageNumber(int pageNumber) throws InterruptedException {
        ActiveContext.getActiveBrowserContext().pages().get(pageNumber).close();
        Thread.sleep(2000);
    }

    @When("tenant/owner/admin refresh page {int}")
    public void tenantRefreshPage(int pageNumber) {
        ActiveContext.getActiveBrowserContext().pages().get(pageNumber).reload();
    }

    @When("tenant/owner/admin set active page to {int}")
    public synchronized void tenantSetActivePageTo(int activePage) {
        ActiveContext.setActivePage(ActiveContext.getActiveBrowserContext().pages().get(activePage));
    }

    @When("tenant/owner/admin open new page")
    public void tenantOpenNewPage() {
        page = ActiveContext.getActiveBrowserContext().waitForPage(() -> {
            ActiveContext.getActiveBrowserContext().newPage();
        });

    }

    @When("tenant navigate to riwayat booking")
    public void tenantNavigateToRiwayatBooking() {
        playwright = new PlaywrightHelpers(page);
        playwright.navigateTo(Mamikos.URL + Mamikos.TENANT_RIWAYAT_BOOKING, 30000.0, LoadState.LOAD);
    }

    @When("tenant/user navigate to tagihan kost saya")
    public void userNavigateToTagihanKostSaya() {
        playwright.navigateTo(Mamikos.URL + Mamikos.KOST_SAYA_BILLING, 30000.0, LoadState.LOAD);
    }

    @When("owner/user navigate to billing management")
    public void userNavigateToBillingManagement() {
        playwright.navigateTo(Mamikos.OWNER_URL + Mamikos.KELOLA_TAGIHAN, 30000.0, LoadState.LOAD);
    }

    @Given("tenant navigate to favorite page")
    public void tenantNavigateToFavoritePage() {
        playwright.navigateTo(Mamikos.URL + Mamikos.FAVORITE_PAGE, 30000.0, LoadState.LOAD);
    }

    @Given("user navigates to mamikos-kost")
    public void userNavigatesToMamikosKost() {
        playwright =new PlaywrightHelpers(page);
        playwright.navigateTo(Mamikos.URL + Mamikos.KOST, 30000.0, LoadState.LOAD);
    }

    @Then("navbar kost before login appears")
    public void navbarKostBeforeLoginAppears() {
        Assert.assertTrue(home.isBookingKosDisplayed(), "Download App button not present!");
        Assert.assertTrue(home.isSearchAdsDisplayed(), "Cari Iklan button not present!");
        Assert.assertTrue(home.isHelpCenterDisplayed(), "Pusat Bantuan button not present!");
        Assert.assertTrue(home.isTermConditionDisplayed(), "Syarat Ketentuan button not present!");
        Assert.assertTrue(home.isPromosiAdsDisplayed(), "Promosi Iklan button not present!");
        Assert.assertTrue(home.isEnterButtonDisplayed(), "Enter button not present!");
    }

    @Given("user navigates to mamikos-booking")
    public void userNavigatesToMamikosBooking() {
        playwright =new PlaywrightHelpers(page);
        playwright.navigateTo(Mamikos.URL + Mamikos.BOOKING, 30000.0, LoadState.LOAD);
    }
}
