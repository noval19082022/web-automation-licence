package runners;

import com.microsoft.playwright.Playwright;
import com.trivago.cluecumber.core.CluecumberCore;
import com.trivago.cluecumber.engine.exceptions.CluecumberException;
import com.trivago.cluecumber.engine.logging.CluecumberLogger;
import config.global.FlowControl;
import config.global.GlobalConfig;
import config.playwright.PlaywrightSourceManager;
import config.playwright.browser.BrowserInitialize;
import config.playwright.browser.BrowserOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseTestRunner extends AbstractTestNGCucumberTests {
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() throws CluecumberException {
        BrowserInitialize browserInitialize = new BrowserInitialize();

        PlaywrightSourceManager.setLocalPlaywright(Playwright.create());
        PlaywrightSourceManager.setLocalBrowser(browserInitialize.getBrowser(GlobalConfig.BROWSER_NAME, BrowserOptions.launchOptions()));
        FlowControl.setStrictFlow(false);
    }

    //@BeforeTest
    //public void beforeTest() {
    //}
    //
    //    @BeforeClass
    //    public void beforeClass() {
    //    }
    //
    //    @AfterClass
    //    public void afterClass() {
    //    }
    //
    //    @AfterTest
    //    public void afterTest(){
    //    }

    @Parameters({"squadName"})
    @AfterSuite(alwaysRun = true)
    public void afterSuite(String squadName) throws CluecumberException {
        String jsonDirectory = "target/result/" + squadName;
        String reportDirectory = "target/result/" + squadName + "/cluecumber_report";
        PlaywrightSourceManager.getLocalBrowser().close();
        PlaywrightSourceManager.getLocalPlaywright().close();
        new CluecumberCore.Builder()
                .setCustomCssFile("src/test/resources/cluecumber-style/cluecumberStyle.css")
                .setLogLevel(CluecumberLogger.CluecumberLogLevel.MINIMAL)
                .setCustomPageTitle(squadName + "Report")
                .setExpandAttachments(true)
                .build().generateReports(jsonDirectory, reportDirectory);
    }
}
