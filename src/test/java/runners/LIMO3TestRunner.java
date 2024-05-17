package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/limo3/cucumber-report.json", "html:target/result/limo3/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@createKosBBKNotActive"
)

public class LIMO3TestRunner extends BaseTestRunner {
}
