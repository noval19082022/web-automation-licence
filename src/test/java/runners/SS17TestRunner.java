package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/ss17/cucumber-report.json", "html:target/result/ss17/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@SS17"
)
public class SS17TestRunner extends BaseTestRunner {
}
