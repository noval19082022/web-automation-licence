package steps.mantool;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.mantool.landingPagePO;
import utilities.PlaywrightHelpers;

import java.util.List;
import java.util.Map;

public class landingPageSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    landingPagePO landingPage = new landingPagePO(page);

    private List<Map<String, String>> mantoolCredential;

    @When("admin login agen mantool")
    public void admin_login_agen_mantool(DataTable table) {
        mantoolCredential = table.asMaps(String.class, String.class);

        String phoneNumber = mantoolCredential.get(0).get("No Handphone");
        String password = mantoolCredential.get(0).get("password");

        landingPage.loginAgenMantool(phoneNumber,password);
    }

    @When("admin click profile picture")
    public void admin_click_profile_picture() {
        landingPage.clickProfile();
    }

    @Then("should contains menu")
    public void should_contains_menu(List<String> menu) {
        for (int i=0;i< menu.size();i++) {
            Assert.assertEquals(landingPage.getProfileMenu(i),menu.get(i),"Profile Menu berbeda");
        }
    }
    @When("admin go to onboarding page")
    public void admin_go_to_onboarding_page() {
        landingPage.goToOnboarding();
    }
    @When("admin logout mantool")
    public void admin_logout_mantool() {
       landingPage.logoutMantool();
    }
}
