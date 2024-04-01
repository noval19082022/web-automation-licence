package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/dom2/cucumber-report.json", "html:target/result/dom2/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@TEST_COOP-6478"
)
public class DOM2TestRunner extends BaseTestRunner {
}
