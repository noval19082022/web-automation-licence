package steps.mamikos.common;

import com.microsoft.playwright.Page;
import config.mamikos.Mamikos;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.Given;
import utilities.PlaywrightHelpers;

public class NavigatesSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);

    @Given("user go to mamikos homepage")
    public void userGoToMamikosHomepage() {
        page.navigate("https://jambu.kerupux.com");
    }

    @Given("admin go to mamikos mamipay admin")
    public void adminGoToMamikosMamipayAdmin() {
        playwright.navigateTo(Mamikos.ADMINMAMIPAY);
    }
}
