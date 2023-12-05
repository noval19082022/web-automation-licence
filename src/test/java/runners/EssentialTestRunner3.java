package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/essential-test3/cucumber-report.json", "html:target/result/essential-test3/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@essentialTest3"
)
public class EssentialTestRunner3 extends BaseTestRunner{
}
