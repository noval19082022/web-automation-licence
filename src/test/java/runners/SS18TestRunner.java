package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/ss18/cucumber-report.json", "html:target/result/ss18/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@SS18"
)
public class SS18TestRunner extends BaseTestRunner {
}