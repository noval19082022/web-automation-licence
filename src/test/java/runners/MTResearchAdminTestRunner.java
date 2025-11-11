package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/MTResearch/Admin/cucumber-report.json", "html:target/result/MTResearch/Admin/cucumber-report.html"},
        features = "src/test/resources/features/mtresearch",
        glue = "steps",
        tags = "@mtresearch and @admin"
)
public class MTResearchAdminTestRunner extends BaseTestRunner {
}
