package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/ss15/cucumber-report.json", "html:target/result/ss15/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@SS15"
)
public class SS15TestRunner extends BaseTestRunner {
}
