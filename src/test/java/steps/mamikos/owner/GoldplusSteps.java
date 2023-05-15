package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.When;
import pageobject.owner.GoldplusPO;
import pageobject.owner.OwnerDashboardPO;
import steps.mamikos.common.NavigatesSteps;
import utilities.PlaywrightHelpers;

public class GoldplusSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    OwnerDashboardPO owner = new OwnerDashboardPO(page);
    NavigatesSteps navigate = new NavigatesSteps();
    GoldplusPO goldplus = new GoldplusPO(page);

    @When("user wants to subscribe Goldplus {int}")
    public void user_wants_to_subscribe_goldplus(int pacakge) {
        navigate.userNavigateTo("/goldplus/submission/periode/gp"+pacakge);
        owner.clickOnTextButton("Pilih");
        playwright.hardWait(3000);
        owner.clickOnText("Bayar Sekarang");
    }

    @When("user wants to reset Goldplus for owner with phone number {string}")
    public void user_wants_to_reset_Goldplus_for_owner_with_phone_number(String phoneNumber) {
        goldplus.inputGoldplusPhoneNumber(phoneNumber);
        owner.clickOnTextButton("Reset");
    }

}
