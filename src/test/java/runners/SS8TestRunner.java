package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/ss8/cucumber-report.json", "html:target/result/ss8/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@SS8"
)
public class SS8TestRunner extends BaseTestRunner{
}
