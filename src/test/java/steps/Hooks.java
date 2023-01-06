package steps;

import com.microsoft.playwright.Tracing;
import config.FlowControl;
import config.playwright.context.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.nio.file.Paths;

public class Hooks extends BaseTest {

    /**
     * Will invoke before every scenario
     * @param scenario method
     */
    @Before
    public void setup(Scenario scenario) {
        for (String context : scenario.getSourceTagNames()) {
            switch (context) {
                case "@tenant" -> {
                    System.out.println("tenant init");
                    TenantContextInitializer.initializeTenantBrowserContext();
                }
                case "@owner" -> {
                    System.out.println("owner init");
                    OwnerContextInitializer.initializeOwnerBrowserContext();
                }
                case "@admin" -> System.out.println("Will add later");
            }
        }

        if (scenario.getSourceTagNames().contains("@user")) {
            UserContextInitializer.initializeUserBrowserContext();
            UserContextInitializer.initializeUserPage();
            FlowControl.setStrictFlow(true);
        }
        System.out.println(scenario.getName() + " is started");
    }

    /**
     * Will invoke after every scenario
     * @param scenario method
     */
    @After
    public void cleanUp(Scenario scenario) {
        System.out.println(ActiveContext.getActivePage());
        if (scenario.isFailed()) {
            page = ActiveContext.getActivePage();
            browserContext = ActiveContext.getActiveBrowserContext();
            byte[] screenshotBytes = ActiveContext.getActivePage().screenshot();
            scenario.attach(screenshotBytes, "image/png", scenario.getName());
            browserContext.tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get("target/trace/"+scenario.getName().trim()+"-trace.zip")));
        }

        if (TenantContext.getTenantBrowserContext()!= null) {
            TenantContext.getTenantBrowserContext().close();
        }

        if (OwnerContext.getOwnerBrowserContext() != null) {
            OwnerContext.getOwnerBrowserContext().close();
        }

        System.out.println(scenario.getName() + " is finished");
    }
}
