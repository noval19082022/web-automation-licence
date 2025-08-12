package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/ss11/cucumber-report.json", "html:target/result/ss11/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@SS11"
)
public class SS11TestRunner extends BaseTestRunner {
}
