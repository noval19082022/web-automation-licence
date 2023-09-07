package steps.multicontext;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import config.playwright.context.PmsActiveContext;
import config.playwright.context.UserContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pageobject.pms.HomepagePO;

public class MultiContextSteps {
    @When("owner/admin/tenant/pms set browser context to {string}")
    public void userSetBrowserContextTo(String browserContext) {
        if (browserContext.equalsIgnoreCase("pmsContext")) {
            ActiveContext.setActiveBrowserContext(PmsActiveContext.getPmsActiveBrowserContext());
            ActiveContext.setActivePage(PmsActiveContext.getPmsActivePage());
        } else if (browserContext.equalsIgnoreCase("pmsContext1")) {
            ActiveContext.setActiveBrowserContext(PmsActiveContext.getPmsActiveBrowserContext1());
            ActiveContext.setActivePage(PmsActiveContext.getPmsActivePage1());
        }
    }
}
