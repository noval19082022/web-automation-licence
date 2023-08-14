package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/dom2/cucumber-report.json", "html:target/result/dom2/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@TEST_DOM-672"
)
public class DOM2TestRunner extends BaseTestRunner {
}
