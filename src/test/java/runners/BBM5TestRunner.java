package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/bbm5/cucumber-report.json", "html:target/result/bbm5/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@BBM500"
)
public class BBM5TestRunner extends BaseTestRunner {
}
