package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/partnergacoan/cucumber-report.json", "html:target/result/partnergacoan/cucumber-report.html"},
        features = "src/test/resources/features/mamikos/LIMO/LIMO6/partnerGacoan",
        glue = "steps",
        tags = "@TEST_LIMO-10829"
)
public class PartnerGacoanTestRunner extends BaseTestRunner {
}
