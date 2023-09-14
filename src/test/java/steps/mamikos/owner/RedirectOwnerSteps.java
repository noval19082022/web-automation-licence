package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utilities.PlaywrightHelpers;


import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class RedirectOwnerSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);

    @And("user redirected to owner dashboard")
    public void userRedirectedToOwnerDashboard() {
        assertThat(page).hasURL(Mamikos.OWNER_URL + "/");
    }

    @And("user redirected to mamiads page")
    public void userRedirectedToMamiadsPage() {
        playwright.waitTillPageLoaded();
        Assert.assertTrue(playwright.getActivePageURL().contains(Mamikos.MAMIADS));
    }

    @And("user redirected to mamiads landing page")
    public void userRedirectedToMamiadsLandingPage() {
        assertThat(page).hasURL(Mamikos.URL + Mamikos.MAMIADS_FROM_OWNER_DASHBOARD);
    }

    @And("user redirected to pembelian saldo mamiads page")
    public void userRedirectedToTopUpMamiadsPage() {
        playwright.waitTillPageLoaded();
        Assert.assertTrue(playwright.getPageUrl().contains(Mamikos.TOP_UP_MAMIADS));
    }

    @When("redirected to cek properti sekitar page")
    public void redirected_to_cek_properti_sekitar_page() {

        assertThat(page).hasURL(Mamikos.OWNER_URL + Mamikos.CEK_PROPERTY_SEKITAR);
    }
}
