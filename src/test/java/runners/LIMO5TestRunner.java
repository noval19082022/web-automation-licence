package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/limo5/cucumber-report.json", "html:target/result/limo5/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@LIMO5"
)
public class LIMO5TestRunner extends BaseTestRunner{
}
