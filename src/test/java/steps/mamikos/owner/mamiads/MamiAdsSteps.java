package steps.mamikos.owner.mamiads;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import org.testng.Assert;
import pageobject.owner.mamiads.MamiAdsPO;

public class MamiAdsSteps {
    Page page = ActiveContext.getActivePage();
    MamiAdsPO mamiAdsPO = new MamiAdsPO(page);

    @And("owner want to buy mamiads saldo with nominal {string}")
    public void ownerWantToBuyMamiadsSaldo(String saldo) {
        mamiAdsPO.purchaseOwnerSaldoFromMamiads(saldo);
    }

    @And("user filter iklan by iklan nonaktif")
    public void userFilterIklanByIklanNonaktif() {
        mamiAdsPO.clickOnSemuaIklan();
        mamiAdsPO.clickOnIklanNonaktif();
    }

    @And("user close mamiads onboarding popup")
    public void userCloseMamiadsOnboardingPopup() {
        mamiAdsPO.handlePopupMamiAds();
    }

    @And("user see title {string} with message {string}")
    public void user_see_title_x_with_message_x(String title, String message) {
        Assert.assertEquals(mamiAdsPO.getTitleText(), title);
        Assert.assertEquals(mamiAdsPO.getMessageText(), message);

    }
}
