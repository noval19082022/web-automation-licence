package steps.mamikos.common;

import com.microsoft.playwright.Page;
import config.mamikos.Mamikos;
import config.playwright.context.ActiveContext;
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
}
