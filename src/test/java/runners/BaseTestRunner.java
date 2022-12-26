package runners;

import config.browser.FrameworkConfig;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterSuite;

public class BaseTestRunner extends AbstractTestNGCucumberTests {

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        FrameworkConfig.localBrowser.close();
        FrameworkConfig.localPlaywright.close();
    }
}
