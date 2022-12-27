package steps;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Tracing;
import config.playwright.FrameworkInitialize;
import config.playwright.FrameworkManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.nio.file.Paths;

public class Hooks {
    BrowserContext browserContext;
    Page page;

    /**
     * Will invoke before every scenario
     * @param scenario method
     */
    @Before
    public void setup(Scenario scenario) {
        System.out.println("From before hooks");
        //FrameworkConfig.localPage = new FrameworkInitialize().initializePlaywright();
        FrameworkInitialize frameworkInitialize = new FrameworkInitialize();
        frameworkInitialize.initializeBrowserContext();
        frameworkInitialize.initializePage();
        browserContext = FrameworkManager.getLocalBrowserContext();
        page = FrameworkManager.getLocalPage();
        System.out.println(scenario.getName() + " is started");
    }

    /**
     * Will invoke after every scenario
     * @param scenario method
     */
    @After
    public void cleanUp(Scenario scenario) {
        System.out.println("From after hooks");
        if (scenario.isFailed()) {
            byte[] screenshotBytes = page.screenshot();
            scenario.attach(screenshotBytes, "image/png", scenario.getName());
        }
        browserContext.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("target/trace/"+scenario.getName().trim()+"-trace.zip")));
        page.close();
        browserContext.close();
        System.out.println(scenario.getName() + " is finished");
    }
}
