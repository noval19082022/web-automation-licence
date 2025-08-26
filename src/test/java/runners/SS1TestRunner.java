package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/ss1/cucumber-report.json", "html:target/result/ss1/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@SS1"
)

public class SS1TestRunner extends BaseTestRunner{
}
