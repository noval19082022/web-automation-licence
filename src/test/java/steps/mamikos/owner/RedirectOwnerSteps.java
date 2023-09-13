package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class RedirectOwnerSteps {
    Page page = ActiveContext.getActivePage();

    @And("user redirected to owner dashboard")
    public void userRedirectedToOwnerDashboard() {
        assertThat(page).hasURL(Mamikos.OWNER_URL + "/");
    }

    @And("user redirected to mamiads page from sidebar")
    public void userRedirectedToMamiadsPage() {
        assertThat(page).hasURL(Mamikos.OWNER_URL + Mamikos.MAMIADS);
    }

    @And("user redirected to mamiads landing page")
    public void userRedirectedToMamiadsLandingPage() {
        assertThat(page).hasURL(Mamikos.URL + Mamikos.MAMIADS_FROM_OWNER_DASHBOARD);
    }

    @And("user redirected to mamiads page from owner dashboard")
    public void userRedirectedToMamiadsPageFromOwnerDashboard() {
        assertThat(page).hasURL(Mamikos.OWNER_URL + Mamikos.MAMIADS_FROM_OWNER_DASHBOARD);
    }

    @When("redirected to cek properti sekitar page")
    public void redirected_to_cek_properti_sekitar_page() {

        assertThat(page).hasURL(Mamikos.OWNER_URL + Mamikos.CEK_PROPERTY_SEKITAR);
    }
}
