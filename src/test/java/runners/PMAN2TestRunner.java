package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/pman/cucumber-report.json", "html:target/result/pman/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@pman2"
)

public class PMAN2TestRunner extends BaseTestRunner{
}
