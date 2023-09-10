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

    /**
     * Will invoke before every scenario
     * @param scenario method
     */
    @Before
    public void setup(Scenario scenario) {
        tags = scenario.getSourceTagNames();
        FlowControl.setMultipleContextFlow(tags.contains("@context1") || tags.contains("@context2"));
        FlowControl.setContinueTag(tags.contains("@continue"));

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
                MamikosBrowserContextInitializer.initializeBrowserContextOne();
                MamikosBrowserContextInitializer.initializeBrowserContextOnePage();
            }
        }

        if (tags.contains("@continue")) {
            FlowControl.setContinueFlow(true);
            FlowControl.setStrictFlow(false);
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
        FlowControl.setContinueFlow(tags.contains("@continue"));
        FlowControl.setStrictFlow(true);
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
            if (MamikosBrowserContext.getBrowserContextOne() != null) MamikosBrowserContext.getBrowserContextOne().close();
            if (MamikosBrowserContext.getBrowserContextTwo() != null) MamikosBrowserContext.getBrowserContextTwo().close();
            FlowControl.setContinueFlow(false);
        }

        System.out.println(scenario.getName() + " is finished");
    }
}
