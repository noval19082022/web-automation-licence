package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/searchkos/cucumber-report.json", "html:target/result/searchkos/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@searchKos"
)

public class SearchKosTestRunner extends BaseTestRunner {
}