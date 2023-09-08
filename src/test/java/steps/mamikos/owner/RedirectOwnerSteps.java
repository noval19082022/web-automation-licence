package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.java.en.And;
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
        Assert.assertTrue(playwright.getActivePageURL().contains(Mamikos.MAMIADS));
    }

    @And("user redirected to mamiads landing page")
    public void userRedirectedToMamiadsLandingPage() {
        assertThat(page).hasURL(Mamikos.URL + Mamikos.MAMIADS_FROM_OWNER_DASHBOARD);
    }

    @And("user redirected to top up mamiads page")
    public void userRedirectedToTopUpMamiadsPage() {
        Assert.assertTrue(playwright.getPageUrl().contains(Mamikos.TOP_UP_MAMIADS));
    }
}
