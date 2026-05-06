package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/limo1/cucumber-report.json", "html:target/result/limo1/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@license"
)

public class LIMO1TestRunner  extends BaseTestRunner{
}
