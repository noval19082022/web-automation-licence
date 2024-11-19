package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/ss16/cucumber-report.json", "html:target/result/ss16/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@SS16"
)
public class SS16TestRunner extends BaseTestRunner {
}
