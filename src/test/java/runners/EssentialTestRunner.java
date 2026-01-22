package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/essential-test/cucumber-report.json", "html:target/result/essential-test/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@checkchangesthursday"
)
public class EssentialTestRunner extends BaseTestRunner{
}
