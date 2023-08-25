package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/limo4/cucumber-report.json", "html:target/result/limo4/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@LIMO41"
)
public class LIMO4TestRunner extends BaseTestRunner{
}
