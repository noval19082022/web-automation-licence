package runners;

import com.microsoft.playwright.Playwright;
import com.trivago.cluecumber.core.CluecumberCore;
import com.trivago.cluecumber.engine.exceptions.CluecumberException;
import config.global.FlowControl;
import config.global.GlobalConfig;
import config.playwright.PlaywrightSourceManager;
import config.playwright.browser.BrowserInitialize;
import config.playwright.browser.BrowserOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

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

    @AfterSuite(alwaysRun = true)
    public void afterSuite() throws CluecumberException {
        String jsonDirectory = "target/result/essential-test";
        String reportDirectory = "target/result/cluecumber_report";
        PlaywrightSourceManager.getLocalBrowser().close();
        PlaywrightSourceManager.getLocalPlaywright().close();
        new CluecumberCore.Builder()
                .build().generateReports(jsonDirectory, reportDirectory);
    }
}
