package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/ss12/cucumber-report.json", "html:target/result/ss12/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@SS12"
)
public class SS12TestRunner extends BaseTestRunner {
}
