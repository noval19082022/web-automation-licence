package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/ss9/cucumber-report.json", "html:target/result/ss9/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@SS9"
)
public class SS9TestRunner extends BaseTestRunner {
}
