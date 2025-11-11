package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/MTResearch/Tenant/cucumber-report.json", "html:target/result/MTResearch/Tenant/cucumber-report.html"},
        features = "src/test/resources/features/mtresearch",
        glue = "steps",
        tags = "@mtresearch and @tenant"
)
public class MTResearchTenantTestRunner extends BaseTestRunner {
}
