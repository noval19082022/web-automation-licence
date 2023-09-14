package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/limo2/cucumber-report.json", "html:target/result/limo2/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@LIMO21"
)
public class LIMO2TestRunner  extends BaseTestRunner{
}
