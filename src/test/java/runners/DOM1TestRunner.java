package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/dom1/cucumber-report.json", "html:target/result/dom1/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@DOM11"
)
public class DOM1TestRunner extends BaseTestRunner {
}
