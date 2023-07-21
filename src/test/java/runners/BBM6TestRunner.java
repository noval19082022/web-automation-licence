package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/bbm6/cucumber-report.json", "html:target/result/bbm6/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@BBM6"
)
public class BBM6TestRunner extends BaseTestRunner{
}
