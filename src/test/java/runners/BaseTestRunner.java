package runners;

import com.microsoft.playwright.Playwright;
import config.global.BrowserOptions;
import config.global.GlobalConfig;
import config.playwright.BrowserInitialize;
import config.playwright.FrameworkManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.*;

public class BaseTestRunner extends AbstractTestNGCucumberTests {
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("From Before suite");
        BrowserOptions browserOptions = new BrowserOptions();
        BrowserInitialize browserInitialize = new BrowserInitialize();


        FrameworkManager.setLocalPlaywright(Playwright.create());
        FrameworkManager.setLocalBrowser(browserInitialize.getBrowser(GlobalConfig.BROWSER_NAME, browserOptions.launchOptions()));
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("From Before test");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("From Before class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("From After class");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("From After test");
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        FrameworkManager.getLocalBrowser().close();
        FrameworkManager.getLocalPlaywright().close();
        System.out.println("From After suite");
    }
}
