package steps.mamikos.owner.mamiads;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.owner.mamiads.MamiAdsPO;
import utilities.PlaywrightHelpers;

public class MamiAdsSteps {
    Page page = ActiveContext.getActivePage();
    MamiAdsPO mamiAdsPO = new MamiAdsPO(page);
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    private Integer riwayatBeforeBeliSaldo;

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

    @And("user click Coba Sekarang on MamiAds landing page")
    public void userClickOnMamiAdsPage() {
        mamiAdsPO.clickOnCobaSekarang();
    }

    @And("user verify count of riwayat before beli saldo")
    public void userVerifyCountOfRiwayatBeforeBeliSaldo() {
        riwayatBeforeBeliSaldo = mamiAdsPO.getCountRiwayatBeliSaldo();
    }

    @And("user wants to buy saldo MamiAds {string}")
    public void userWantsToBuySaldoMamiAds(String saldo) {
        mamiAdsPO.clickOnBeliSaldoBtn();
        mamiAdsPO.choosingSaldoToBuy(saldo);
        mamiAdsPO.isDetailTagihanPresent();
        mamiAdsPO.clicksOnBayarSekarangButton();
    }

    @Then("user verify count of riwayat added {int}")
    public void userVerifyCountOfRiwayatAdded(int numberAdded) {
        int riwayatAfterBeliSaldo = mamiAdsPO.getCountRiwayatBeliSaldo();
        Assert.assertEquals(riwayatAfterBeliSaldo, (riwayatBeforeBeliSaldo+numberAdded), "Count of riwayat doesn't Match");
    }

    @And("will see title {string} and message {string} on Dalam Proses tab")
    public void willSeeTitleAndMessageOnDalamProsesTab(String title, String message) {
        Assert.assertEquals(mamiAdsPO.getTitleDalamProsesText(), title, "Title doesn't match!");
        Assert.assertTrue(playwright.isTextDisplayed(message), "Message doesn't match!");
    }

    @Then("will see title {string} and message {string} on Selesai tab")
    public void willSeeTitleAndMessageOnSelesaiTab(String title, String message) {
        Assert.assertEquals(mamiAdsPO.getTitleSelesaiText(), title, "Title doesn't match!");
        Assert.assertTrue(playwright.isTextDisplayed(message), "Message doesn't match!");
    }
}
