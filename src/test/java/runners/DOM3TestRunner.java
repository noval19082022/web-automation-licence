package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/dom3/cucumber-report.json", "html:target/result/dom3/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@DOM3"
)
public class DOM3TestRunner extends BaseTestRunner {
}