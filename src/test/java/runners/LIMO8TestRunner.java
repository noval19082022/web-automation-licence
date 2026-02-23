package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/limo8/cucumber-report.json", "html:target/result/limo8/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@LIMO8"
)
public class LIMO8TestRunner extends BaseTestRunner{
}
