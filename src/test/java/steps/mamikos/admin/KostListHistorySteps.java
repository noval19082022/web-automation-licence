package steps.mamikos.admin;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.admin.mamipay.bangkrupux.KostListHistoryPO;
import utilities.JavaHelpers;

import java.util.List;

public class KostListHistorySteps {
    Page page = ActiveContext.getActivePage();
    KostListHistoryPO kostListHistory = new KostListHistoryPO(page);

    private String kostPMANList = "src/test/resources/testdata/bangkerupuxAdmin/kostList.properties";
    private String roomListStaging = JavaHelpers.getPropertyValue(kostPMANList, "roomListStaging");
    private String roomListProd = JavaHelpers.getPropertyValue(kostPMANList, "roomListProd");
    private String ownerStaging = JavaHelpers.getPropertyValue(kostPMANList, "ownerStaging");
    private String ownerProd = JavaHelpers.getPropertyValue(kostPMANList, "ownerProd");

    @When("admin clicks on Kost List History")
    public void admin_clicks_on_Kost_List_History() {
        kostListHistory.clickKostListHistory();
    }

    @Then("kost list history column contains")
    public void kost_list_history_column_contains(List<String> table){
        for (String kostListHistoryColumn: table){
            Assert.assertEquals(kostListHistory.getKostListHistoryColumnTable(kostListHistoryColumn), kostListHistoryColumn, "Column Name in Kost Level Table does not match!");
        }
    }

    @Then("show kost list history room name properly")
    public void show_kost_list_history_room_name_properly() {
        if (Mamikos.ENV.equalsIgnoreCase("prod")){
            Assert.assertEquals(kostListHistory.getRoomNameText(), roomListProd);
        } else {
            Assert.assertEquals(kostListHistory.getRoomNameText(), roomListStaging);
        }
    }

    @Then("show kost list history owner name properly")
    public void show_kost_list_history_owner_name_properly() {
        if (Mamikos.ENV.equalsIgnoreCase("prod")){
            Assert.assertEquals(kostListHistory.getOwnerNameText(), ownerProd);
        } else {
            Assert.assertEquals(kostListHistory.getOwnerNameText(), ownerStaging);
        }
    }
}