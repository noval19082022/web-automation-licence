package steps;

import com.microsoft.playwright.Tracing;
import config.global.FlowControl;
import config.playwright.context.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.nio.file.Paths;

public class Hooks{

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
                    TenantContextInitializer.initializeTenantPage();
                }
                case "@owner" -> {
                    System.out.println("owner init");
                    OwnerContextInitializer.initializeOwnerBrowserContext();
                    OwnerContextInitializer.initializeOwnerPage();
                }
                case "@admin" -> System.out.println("Will add later");
            }
        }

        if (scenario.getSourceTagNames().contains("@user")) {
            UserContextInitializer.initializeUserBrowserContext();
            UserContextInitializer.initializeUserPage();
            ActiveContext.setActiveBrowserContext(UserContext.getUserBrowserContext());
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
        if (scenario.isFailed()) {
            byte[] screenshotBytes = ActiveContext.getActivePage().screenshot();
            scenario.attach(screenshotBytes, "image/png", scenario.getName());
            ActiveContext.getActiveBrowserContext().tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get("target/trace/"+scenario.getName().replace(" ", "-").toLowerCase()+"-trace.zip")));
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
