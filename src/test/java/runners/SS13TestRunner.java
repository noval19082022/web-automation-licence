package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/ss13/cucumber-report.json", "html:target/result/ss13/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@SS13"
)
public class SS13TestRunner extends BaseTestRunner {
}