package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.owner.GoldplusPO;
import pageobject.owner.OwnerDashboardPO;
import steps.mamikos.common.NavigatesSteps;
import utilities.PlaywrightHelpers;

import java.util.List;
import java.util.Map;

public class GoldplusSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    NavigatesSteps navigate = new NavigatesSteps();
    GoldplusPO goldplus = new GoldplusPO(page);

    @When("user wants to subscribe Goldplus {int}")
    public void user_wants_to_subscribe_goldplus(int pacakge) {
        navigate.userNavigateTo("/goldplus/submission/periode/gp"+pacakge);
        playwright.clickOnTextButton("Pilih");
        playwright.hardWait(3000);
        playwright.clickOnText("Bayar Sekarang");
    }

    @When("user wants to reset Goldplus for owner with phone number {string}")
    public void user_wants_to_reset_Goldplus_for_owner_with_phone_number(String phoneNumber) {
        goldplus.inputGoldplusPhoneNumber(phoneNumber);
        playwright.clickOnTextButton("Reset");
    }

    @Then("user verify list of Periode Berlangganan is appear")
    public void user_verify_list_of_period_berlangganan_is_appear(DataTable dataTable) {
        playwright.hardWait(1000);
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

    @Then("admin successfully sets favorite label to none")
    public void admin_successfully_sets_favorite_label_to_none() {
        goldplus.clickOnEditGP1Button();
        goldplus.clickNoRadioButton();
        playwright.clickOnText("Save");
    }

    @When("admin successfully sets favorite label to active")
    public void admin_successfully_sets_favorite_label_to_active() {
        goldplus.clickOnEditGP1Button();
        goldplus.clickYesRadioButton();
        playwright.clickOnText("Save");
    }

    @When("admin successfully adds additional favorite labels")
    public void admin_successfully_adds_additional_favorite_labels() {
        goldplus.clickOnEditGP2Button();
        goldplus.clickYesRadioButton();
        playwright.clickOnText("Save");
    }

    @When("admin successfully remove additional favorite labels")
    public void admin_successfully_remove_additional_favorite_labels() {
        goldplus.clickOnEditGP2Button();
        goldplus.clickNoRadioButton();
        playwright.clickOnTextButton("Save");
    }

}
