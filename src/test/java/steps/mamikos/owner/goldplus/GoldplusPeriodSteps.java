package steps.mamikos.owner.goldplus;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.LoadingPO;
import pageobject.owner.goldplus.GoldPlusSubmissionPO;
import pageobject.owner.goldplus.GoldplusPO;
import utilities.PlaywrightHelpers;

import java.util.List;
import java.util.Map;

public class GoldplusPeriodSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    GoldplusPO goldplus = new GoldplusPO(page);
    GoldPlusSubmissionPO gpSubmission = new GoldPlusSubmissionPO(page);
    LoadingPO loading = new LoadingPO(page);


    @Then("user verify list of Periode Berlangganan is appear")
    public void user_verify_list_of_period_berlangganan_is_appear(DataTable dataTable) {
        playwright.waitTillPageLoaded();
        loading.waitForLoadingIconDisappear();
        List<Map<String, String>> table = dataTable.asMaps();
        int i=0;
        for (Map<String, String> content : table) {
            Assert.assertEquals(goldplus.listPeriod("periodGP",i).replaceAll("\\s", ""),content.get("periodGP").replaceAll("\\s", ""));
            Assert.assertEquals(goldplus.listPeriod("freeMamiAds",i),content.get("freeMamiAds"));
            Assert.assertEquals(goldplus.listPeriod("actualPrice",i),content.get("actualPrice"));
            Assert.assertEquals(goldplus.listPeriod("discPrice",i),content.get("discPrice"));
            i++;
        }
    }

    @Then("user verify list of Goldplus Weekly is appear")
    public void user_verify_list_of_goldplus_weekly_is_appear(DataTable dataTable) {
        playwright.hardWait(2000);
        List<Map<String, String>> table = dataTable.asMaps();
        int i=0;
        for (Map<String, String> content : table) {
            Assert.assertEquals(goldplus.listPeriod("periodGP",i).replaceAll("\\s", ""),content.get("periodGP").replaceAll("\\s", ""));
            Assert.assertEquals(goldplus.listPeriod("actualPrice",i),content.get("price"));
            i++;
        }
    }

    @When("owner choose periode goldplus {string}")
    public void owner_choose_periode_goldplus(String period){
        goldplus.clickOnPeriodGoldPlus(period);
        gpSubmission.clicksOnPilihPeriodeButton();
    }

}
