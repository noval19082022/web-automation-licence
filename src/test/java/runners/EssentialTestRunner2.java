package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/essential-test2/cucumber-report.json", "html:target/result/essential-test2/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@essentialTest2"
)
public class EssentialTestRunner2 extends BaseTestRunner{
}
