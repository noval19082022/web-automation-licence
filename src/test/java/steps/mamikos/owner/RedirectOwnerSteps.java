package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.LoadingPO;
import utilities.PlaywrightHelpers;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class RedirectOwnerSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    LoadingPO loadingPO = new LoadingPO(page);

    @And("user redirected to owner dashboard")
    public void userRedirectedToOwnerDashboard() {
        assertThat(page).hasURL(Mamikos.OWNER_URL + "/");
    }

    @And("user redirected to mamiads page")
    public void userRedirectedToMamiadsPage() {
        loadingPO.waitForLoadingIconDisappear();
        Assert.assertTrue(playwright.getActivePageURL().contains(Mamikos.MAMIADS));
    }

    @And("user redirected to mamiads landing page")
    public void userRedirectedToMamiadsLandingPage() {
        assertThat(page).hasURL(Mamikos.OWNER_URL_STAG + Mamikos.MAMIADS_FROM_OWNER_DASHBOARD);
    }

    @And("user redirected to pembelian saldo mamiads page")
    public void userRedirectedToTopUpMamiadsPage() {
        playwright.waitTillPageLoaded(5000.0);
        Assert.assertTrue(playwright.getPageUrl().contains(Mamikos.TOP_UP_MAMIADS));
    }

    @When("redirected to cek properti sekitar page")
    public void redirected_to_cek_properti_sekitar_page() {
        assertThat(page).hasURL(Mamikos.OWNER_URL + Mamikos.CEK_PROPERTY_SEKITAR);
    }

    @Then("user redirected to mamitour landing page")
    public void user_redirected_to_mamitour_landing_page() {
        loadingPO.waitForLoadingIconDisappear();
        assertThat(page).hasURL(Mamikos.OWNER_URL + Mamikos.MAMITOUR);
    }

    @And("user redirected to pusat bantuan mamitour page")
    public void userRedirectedToPusatBantuanMamitourPage() {
        Page activePage = ActiveContext.getActivePage();
        PlaywrightHelpers activePlaywright = new PlaywrightHelpers(activePage);
        activePlaywright.hardWait(3000);
        activePlaywright.waitTillPageLoaded();
        Assert.assertTrue(activePlaywright.getActivePageURL().contains(Mamikos.HELP_MAMITOUR));
    }

    @Then("owner redirect to select package GP2 page")
    public void owner_redirect_to_select_package_gp2_page() {
        loadingPO.waitForLoadingIconDisappear();
        assertThat(page).hasURL(Mamikos.OWNER_URL + Mamikos.GOLDPLUS_PACKAGE2);
    }

    @Then("user redirected to mamiprime landing page")
    public void userRedirectedToMamiprimeLandingPage() {
        loadingPO.waitForLoadingIconDisappear();
        assertThat(page).hasURL(Mamikos.OWNER_URL + Mamikos.MAMIPRIME);
    }

    @Then("user redirected to mamiprime history page")
    public void userRedirectedToMamiprimeHistoryPage() {
        loadingPO.waitForLoadingIconDisappear();
        assertThat(page).hasURL(Mamikos.OWNER_URL + Mamikos.MAMIPRIME_HISTORY);
    }
}
