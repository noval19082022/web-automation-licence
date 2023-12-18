package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/bbm3/cucumber-report.json", "html:target/result/bbm3/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@COOP3"
)
public class BBM3TestRunner extends BaseTestRunner {
}
