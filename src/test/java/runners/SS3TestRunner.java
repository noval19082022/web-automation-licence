package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/SS3/cucumber-report.json", "html:target/result/SS3/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@SS3"
)
public class SS3TestRunner extends BaseTestRunner {
}
