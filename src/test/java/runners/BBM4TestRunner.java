package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/bbm4/cucumber-report.json", "html:target/result/bbm4/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@BBM4"
)
public class BBM4TestRunner extends BaseTestRunner {
}
