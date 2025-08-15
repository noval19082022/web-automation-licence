package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/ss/cucumber-report.json", "html:target/result/ss/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@ss2"
)

public class SS2TestRunner extends BaseTestRunner{
}
