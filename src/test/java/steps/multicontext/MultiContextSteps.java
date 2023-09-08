package steps.multicontext;

import config.playwright.context.ActiveContext;
import config.playwright.context.MamikosBrowserContext;
import io.cucumber.java.en.When;

public class MultiContextSteps {
    @When("owner/admin/tenant/pms set browser context to {string}")
    public void userSetBrowserContextTo(String browserContext) throws InterruptedException {
        if (browserContext.equalsIgnoreCase("context1")) {
            ActiveContext.setActiveBrowserContext(MamikosBrowserContext.getBrowserContextOne());
            ActiveContext.setActivePage(MamikosBrowserContext.getContextOneActivePage());
        } else if (browserContext.equalsIgnoreCase("context2")) {
            ActiveContext.setActiveBrowserContext(MamikosBrowserContext.getBrowserContextTwo());
            ActiveContext.setActivePage(MamikosBrowserContext.getContextTwoActivePage());
        }
    }
}
