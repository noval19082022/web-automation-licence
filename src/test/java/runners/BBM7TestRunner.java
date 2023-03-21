package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/bbm7/cucumber-report.json", "html:target/result/bbm7/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@BBM7"
)
public class BBM7TestRunner extends BaseTestRunner {
}
