package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/bbm8/cucumber-report.json", "html:target/result/bbm8/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@BBM8"
)
public class BBM8TestRunner extends BaseTestRunner {
}
