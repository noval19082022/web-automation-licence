package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/ss7/cucumber-report.json", "html:target/result/ss7/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@SS7"
)
public class SS7TestRunner extends BaseTestRunner {
}
