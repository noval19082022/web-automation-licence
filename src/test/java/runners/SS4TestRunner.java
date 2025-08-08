package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/ss4/cucumber-report.json", "html:target/result/ss4/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@SS4"
)
public class SS4TestRunner extends BaseTestRunner {
}
