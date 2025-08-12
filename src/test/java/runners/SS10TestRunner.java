package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/ss10/cucumber-report.json", "html:target/result/ss10/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@SS10"
)
public class SS10TestRunner extends BaseTestRunner {
}
