package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/ss5/cucumber-report.json", "html:target/result/ss5/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@SS5"
)
public class SS5TestRunner extends BaseTestRunner {
}
