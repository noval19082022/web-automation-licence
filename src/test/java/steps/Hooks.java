package steps;

import com.microsoft.playwright.Tracing;
import config.global.FlowControl;
import config.global.GlobalConfig;
import config.playwright.context.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.nio.file.Paths;
import java.util.Collection;

public class Hooks{
    private Collection<String> tags = null;
    private Boolean multipleContext = false;

    /**
     * Will invoke before every scenario
     * @param scenario method
     */
    @Before
    public void setup(Scenario scenario) {
        tags = scenario.getSourceTagNames();
        multipleContext = tags.contains("@context1") || tags.contains("@context2");
        if (multipleContext) {
            if (!scenario.getSourceTagNames().contains("@continue") || !FlowControl.isContinueFlow()) {
                if (scenario.getSourceTagNames().contains("@context1")) {
                    System.out.println("saya ke sini karena context1 true");
                    if(MamikosBrowserContext.getBrowserContextOne() == null || MamikosBrowserContext.getBrowserContextOne().pages().isEmpty()) {
                        MamikosBrowserContextInitializer.initializeBrowserContextOne();
                        MamikosBrowserContextInitializer.initializeBrowserContextOnePage();
                        FlowControl.setContextOneFlow(true);
                    }
                }
                if (scenario.getSourceTagNames().contains("@context2")) {
                    System.out.println("saya ke sini karena context2 true");
                    if(MamikosBrowserContext.getBrowserContextTwo() == null || MamikosBrowserContext.getBrowserContextTwo().pages().isEmpty()) {
                        MamikosBrowserContextInitializer.initializeBrowserContextTwo();
                        MamikosBrowserContextInitializer.initializeBrowserContextTwoPage();
                        FlowControl.setContextTwoFlow(true);
                    }
                }
            }
            FlowControl.setMultipleContextFlow(true);
        }

        if (scenario.getSourceTagNames().contains("@continue")) {
            FlowControl.setContinueFlow(true);
        }

        if (!scenario.getSourceTagNames().contains("@continue") && !FlowControl.isMultipleContextFlow() && !FlowControl.isContinueFlow()) {
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
            if (AdminContext.getAdminBrowserContext() != null) AdminContext.getAdminBrowserContext().close();
            if (UserContext.getUserBrowserContext() != null) UserContext.getUserBrowserContext().close();
            if (ActiveContext.getActiveBrowserContext() != null) ActiveContext.getActiveBrowserContext().close();
            if (MamikosBrowserContext.getBrowserContextOne() != null) MamikosBrowserContext.getBrowserContextOne().close();
            if (MamikosBrowserContext.getBrowserContextTwo() != null) MamikosBrowserContext.getBrowserContextTwo().close();
            FlowControl.setContinueFlow(false);
        }

        System.out.println(scenario.getName() + " is finished");
    }
}
