package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/limo6/cucumber-report.json", "html:target/result/limo6/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@LIMO6"
)
public class LIMO6TestRunner extends BaseTestRunner{
}
