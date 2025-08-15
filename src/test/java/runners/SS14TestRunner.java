package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/ss14/cucumber-report.json", "html:target/result/ss14/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@SS14"
)
public class SS14TestRunner extends BaseTestRunner {
}
