package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/ss6/cucumber-report.json", "html:target/result/ss6/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@SS6"
)
public class SS6TestRunner extends BaseTestRunner {
}
