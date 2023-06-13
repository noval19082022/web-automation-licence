package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/bbm1/cucumber-report.json", "html:target/result/bbm1/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@BBM1"
)
public class BBM1TestRunner extends BaseTestRunner {
}
