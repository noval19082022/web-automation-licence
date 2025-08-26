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
import utilities.JavaHelpers;
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
    public void user_verify_list_of_period_berlangganan_is_appear(String expectedAriaSnapshot) {
        playwright.waitTillPageLoaded();
        loading.waitForLoadingIconDisappear();

        // Get the actual aria snapshot from the current page
        String actualAriaSnapshot = goldplus.getPeriodeBerlanggananAriaSnapshot();

        // Compare the snapshots directly without normalization for better visualization
        Assert.assertEquals(actualAriaSnapshot, expectedAriaSnapshot,
            "Periode Berlangganan package structure does not match expected layout");
    }

    @Then("owner should not see {string} on Paket Jangka Panjang")
    public void owner_should_not_see_favorit_on_paket_jangka_panjang(String text) {
        playwright.waitTillPageLoaded();
        loading.waitForLoadingIconDisappear();

        // Get the aria snapshot from the 2nd div.goldplus-periode-select__list (Paket Jangka Panjang section)
        String paketJangkaPanjangAriaSnapshot = goldplus.getPaketJangkaPanjangAriaSnapshot();

        // Normalize the aria snapshot
        String normalizedSnapshot = JavaHelpers.normalizeAriaSnapshot(paketJangkaPanjangAriaSnapshot);

        // Verify that the text (e.g., "Favorit") is NOT present in the aria snapshot
        Assert.assertFalse(normalizedSnapshot.contains(text),
            "Text '" + text + "' should not be present in Paket Jangka Panjang section but was found");
    }

    @Then("user verify list of Goldplus Weekly is appear")
    public void user_verify_list_of_goldplus_weekly_is_appear(DataTable dataTable) {
        playwright.hardWait(2000);
        List<Map<String, String>> table = dataTable.asMaps();
        int i=0;
        for (Map<String, String> content : table) {
            Assert.assertEquals(goldplus.listPeriod("periodGP",i).replaceAll("\\s", ""),content.get("periodGP").replaceAll("\\s", ""));
            Assert.assertEquals(goldplus.listPeriod("actualPrice",i + 1),content.get("price"));
            i++;
        }
    }

    @When("owner choose periode goldplus {string}")
    public void owner_choose_periode_goldplus(String period){
        goldplus.clickOnPeriodGoldPlus(period);
        gpSubmission.clicksOnPilihPeriodeButton();
    }

}
