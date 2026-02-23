package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/limo7/cucumber-report.json", "html:target/result/limo7/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@LIMO7"
)
public class LIMO7TestRunner extends BaseTestRunner{
}
