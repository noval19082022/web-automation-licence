package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/bbm4/cucumber-report.json", "html:target/result/bbm5/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@BBM5"
)
public class BBM5TestRunner extends BaseTestRunner {
}
