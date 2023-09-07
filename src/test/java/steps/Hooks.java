package steps;

import com.microsoft.playwright.Tracing;
import config.global.FlowControl;
import config.global.GlobalConfig;
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
        if (scenario.getSourceTagNames().contains("@multipleContext")) {
            if (!scenario.getSourceTagNames().contains("@continue") || !FlowControl.isContinueFlow()) {
                if (scenario.getSourceTagNames().contains("@pmsContext")) {
                    System.out.println("saya ke sini karena pmsContext true");
                    if(PmsContext.getPmsBrowserContext() == null || PmsContext.getPmsBrowserContext().pages().isEmpty()) {
                        PmsContextInitializer.initializePmsBrowserContext();
                        PmsContextInitializer.initializePmsPage();
                        FlowControl.setPmsFlow(true);
                        FlowControl.setPmsFlow1(false);
                    }
                }
                if (scenario.getSourceTagNames().contains("@pmsContext1")) {
                    System.out.println("saya ke sini karena pmsContext1 true");
                    if(PmsContext.getPmsBrowserContext1() == null || PmsContext.getPmsBrowserContext1().pages().isEmpty()) {
                        PmsContextInitializer1.initializePmsBrowserContext1();
                        PmsContextInitializer1.initializePmsPage1();
                        FlowControl.setPmsFlow1(true);
                        FlowControl.setPmsFlow(false);
                    }
                }
            }
            FlowControl.setMultipleContextFlow(true);
        }

        if (scenario.getSourceTagNames().contains("@continue")) {
            FlowControl.setContinueFlow(true);
        }

        if ((!scenario.getSourceTagNames().contains("@continue") && !FlowControl.isMultipleContextFlow()) || !FlowControl.isContinueFlow()) {
            System.out.println("seharusnya tidak ke sini");
            System.out.println(!scenario.getSourceTagNames().contains("@continue") && !scenario.getSourceTagNames().contains("@multipleContext"));
            System.out.println(!FlowControl.isContinueFlow());
            if (ActiveContext.getActiveBrowserContext() == null || ActiveContext.getActiveBrowserContext().pages().isEmpty()) {
                UserContextInitializer.initializeUserBrowserContext();
                UserContextInitializer.initializeUserPage();
                ActiveContext.setActiveBrowserContext(UserContext.getUserBrowserContext());
                FlowControl.setStrictFlow(true);
            }
        }

        System.out.println("\n" + scenario.getName() + " is started");
    }

    /**
     * Will invoke after every scenario
     *
     * @param scenario method
     */
    @After
    public void cleanUp(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println(scenario.getName() + " is failed");
            scenario.attach(ActiveContext.getActivePage().screenshot(), "image/png", scenario.getName());
            if (GlobalConfig.SET_TRACING) {
                ActiveContext.getActiveBrowserContext().tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get("target/trace/" + scenario.getName().replace(" ", "-").toLowerCase() + "-trace.zip")));
            }
            System.out.println("Failed URL is: " + ActiveContext.getActivePage().url());
        }

        if (!scenario.getSourceTagNames().contains("@continue")) {
            if (TenantContext.getTenantBrowserContext() != null) TenantContext.getTenantBrowserContext().close();
            if (OwnerContext.getOwnerBrowserContext() != null) OwnerContext.getOwnerBrowserContext().close();
            if (AdminContext.getAdminBrowserContext() != null) AdminContext.getAdminBrowserContext().close();
            if (UserContext.getUserBrowserContext() != null) UserContext.getUserBrowserContext().close();
            if (ActiveContext.getActiveBrowserContext() != null) ActiveContext.getActiveBrowserContext().close();
            if (PmsContext.getPmsBrowserContext() != null) PmsContext.getPmsBrowserContext().close();
            if (PmsContext.getPmsBrowserContext1() != null) PmsContext.getPmsBrowserContext1().close();
            FlowControl.setContinueFlow(false);
        }

        System.out.println(scenario.getName() + " is finished");
    }
}
