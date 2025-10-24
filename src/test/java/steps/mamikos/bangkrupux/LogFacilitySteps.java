package steps.mamikos.bangkrupux;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.admin.mamipay.bangkrupux.LogFacilityPO;

import java.util.List;
import java.util.Map;

public class LogFacilitySteps {
    Page page = ActiveContext.getActivePage();
    LogFacilityPO logFacility = new LogFacilityPO(page);

    private List<Map<String, String>> log;

    @Then("admin can see log facility {string}")
    public void admin_can_see_log_facility(String row, DataTable tables) {
        log = tables.asMaps(String.class, String.class);

        String before = log.get(0).get("Old Data");
        String after = log.get(0).get("New Data");
        String pic = log.get(0).get("Updated by");

        Assert.assertEquals(logFacility.getOldData(row),before);
        Assert.assertEquals(logFacility.getNewData(row),after);
        Assert.assertEquals(logFacility.updateBy(row),pic);
    }
}
