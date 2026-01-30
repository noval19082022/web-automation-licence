package steps;

import com.microsoft.playwright.Tracing;
import config.global.FlowControl;
import config.global.GlobalConfig;
import config.playwright.context.ActiveContext;
import config.playwright.context.MamikosBrowserContext;
import config.playwright.context.MamikosBrowserContextInitializer;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import testdata.ScenarioInformations;

import java.nio.file.Paths;
import java.util.Collection;

public class Hooks{
    private Collection<String> tags = null;

    /**
     * Will invoke before every scenario
     * @param scenario method
     */
    @Before
    public void setup(Scenario scenario) {
        tags = scenario.getSourceTagNames();
        FlowControl.setMultipleContextFlow(tags.contains("@context1") || tags.contains("@context2"));
        FlowControl.setContinueTag(tags.contains("@continue"));
        FlowControl.setMobileFlow(tags.contains("@mobile"));
        FlowControl.setScenarioName(scenario.getName());

        if (FlowControl.isMultipleContextFlow()) {
            if (!FlowControl.isContinueTag() || !FlowControl.isContinueFlow()) {
                if (tags.contains("@context1")) {
                    if(MamikosBrowserContext.getBrowserContextOne() == null || MamikosBrowserContext.getBrowserContextOne().pages().isEmpty()) {
                        MamikosBrowserContextInitializer.initializeBrowserContextOne();
                        MamikosBrowserContextInitializer.initializeBrowserContextOnePage();
                        FlowControl.setContextOneFlow(true);
                    }
                }
                if (tags.contains("@context2")) {
                    if(MamikosBrowserContext.getBrowserContextTwo() == null || MamikosBrowserContext.getBrowserContextTwo().pages().isEmpty()) {
                        MamikosBrowserContextInitializer.initializeBrowserContextTwo();
                        MamikosBrowserContextInitializer.initializeBrowserContextTwoPage();
                        FlowControl.setContextTwoFlow(true);
                    }
                }
            }
            FlowControl.setStrictFlow(false);
        }

        if (FlowControl.isStrictFlow() && !FlowControl.isContinueFlow()) {
            if (ActiveContext.getActiveBrowserContext() == null || ActiveContext.getActiveBrowserContext().pages().isEmpty()) {
                if (FlowControl.isMobileFlow()) {
                    MamikosBrowserContextInitializer.initializeMobileBrowserContext();
                } else {
                    MamikosBrowserContextInitializer.initializeBrowserContextOne();
                    MamikosBrowserContextInitializer.initializeBrowserContextOnePage();
                }
            }
        }

        if (tags.contains("@continue")) {
            FlowControl.setContinueFlow(true);
            FlowControl.setStrictFlow(false);
        }
        if (tags.contains("@apiflow")) {
            FlowControl.setApiFlow(true);
        }

        System.out.println("\n" + scenario.getName() + " is started");
        ScenarioInformations.setScenarioName(scenario.getName());
        ScenarioInformations.setScenarioTags(scenario.getSourceTagNames());
    }

    /**
     * Will invoke after every scenario
     *
     * @param scenario method
     */
    @After
    public void cleanUp(Scenario scenario) {
        FlowControl.setContinueFlow(tags.contains("@continue"));
        FlowControl.setApiFlow(false);

        if (scenario.isFailed()) {
            System.out.println(scenario.getName() + " is failed");
            scenario.attach(ActiveContext.getActivePage().screenshot(), "image/png", scenario.getName());
            if (GlobalConfig.SET_TRACING) {
                ActiveContext.getActiveBrowserContext().tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get("target/trace/" + scenario.getName().replace(" ", "-").toLowerCase() + "-trace.zip")));
            }
            System.out.println("Failed URL is: " + ActiveContext.getActivePage().url());
        }

        if (!tags.contains("@continue")) {
            // Close browser contexts if not continuing
            if (MamikosBrowserContext.getBrowserContextOne() != null) {
                MamikosBrowserContext.getBrowserContextOne().close();
            }
            if (MamikosBrowserContext.getBrowserContextTwo() != null) {
                MamikosBrowserContext.getBrowserContextTwo().close();
            }
            FlowControl.setContinueFlow(false);

            // Reset flow control for next scenario (but don't cleanup ThreadLocal - that's in @AfterTest)
            FlowControl.reset();
        } else {
            // For @continue scenarios, only reset strict flow
            FlowControl.setStrictFlow(true);
        }

        System.out.println(scenario.getName() + " is finished");
    }
}
