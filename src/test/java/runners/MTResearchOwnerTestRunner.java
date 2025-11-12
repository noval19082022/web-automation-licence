package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/result/MTResearch/Owner/cucumber-report.json", "html:target/result/MTResearch/Owner/cucumber-report.html"},
        features = "src/test/resources/features/mtresearch",
        glue = "steps",
        tags = "@mtresearch and @owner"
)
public class MTResearchOwnerTestRunner extends BaseTestRunner {
}
// runner for MTResearch Owner tests
// check the testng xml runner for mutli-threading execution example