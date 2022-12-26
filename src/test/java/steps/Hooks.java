package steps;

import com.microsoft.playwright.Tracing;
import config.browser.FrameworkConfig;
import config.browser.FrameworkInitialize;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.nio.file.Paths;

public class Hooks {
    @Before
    public void setup(Scenario scenario) {
        FrameworkConfig.localPage = new FrameworkInitialize().initializePlaywright();
        System.out.println(scenario.getName() + " is started");
    }

    @After
    public void cleanUp(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshotBytes = FrameworkConfig.localPage.screenshot();
            scenario.attach(screenshotBytes, "image/png", scenario.getName());
        }
        FrameworkConfig.localBrowserContext.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("target/trace/"+scenario.getName().trim()+"-trace.zip")));
        FrameworkConfig.localPage.close();
        FrameworkConfig.localBrowserContext.close();
        System.out.println(scenario.getName() + " is finished");
    }
}
