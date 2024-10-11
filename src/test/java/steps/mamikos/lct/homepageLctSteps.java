package steps.mamikos.lct;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.lct.homepageLctPO;
import utilities.PlaywrightHelpers;

public class homepageLctSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    homepageLctPO lct = new homepageLctPO(page);

    @Then("agen role should be {string}")
    public void agen_role_should_be(String role) {
        Assert.assertEquals(lct.getUserRole(),role);
    }
}
