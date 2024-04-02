package steps.mamikos.lct;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.lct.homepageLctPO;
import utilities.PlaywrightHelpers;

public class homepageLctSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    homepageLctPO lct = new homepageLctPO(page);

    @Then("owner should redirect to lct")
    public void owner_should_redirect_to_lct() {
        playwright.hardWait(3000.0);
        Assert.assertEquals(lct.getLctUrl(),Mamikos.HOMEPAGE_LCT+"?activeTab=submitted");
    }
    @Then("owner role should be {string}")
    public void owner_role_should_be(String role) {
        Assert.assertEquals(lct.getUserRole(),role);
    }
}
