package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/dom4/cucumber-report.json", "html:target/result/dom4/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@DOM4"
)
public class DOM4TestRunner extends BaseTestRunner {
}
