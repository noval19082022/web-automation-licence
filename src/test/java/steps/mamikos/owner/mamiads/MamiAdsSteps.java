package steps.mamikos.owner.mamiads;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.owner.mamiads.MamiAdsPO;

public class MamiAdsSteps {
    Page page = ActiveContext.getActivePage();
    MamiAdsPO mamiAdsPO = new MamiAdsPO(page);
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

    @And("user see title {string} with message {string} on page {string}")
    public void userSeeTitleWithMessageOnPage(String title, String message, String page) {
        switch (page){
            case "selesai":
                Assert.assertEquals(mamiAdsPO.getTitleSelesaiText(), title);
                Assert.assertEquals(mamiAdsPO.getMessageSelesaiText(), message); break;
            default:
                Assert.assertEquals(mamiAdsPO.getTitleDalamProsesText(), title);
                Assert.assertEquals(mamiAdsPO.getMessageDalamProsesText(), message);
                break;
        }
    }

    @And("user verify count of riwayat before beli saldo")
    public void userVerifyCountOfRiwayatBeforeBeliSaldo() {
        riwayatBeforeBeliSaldo = mamiAdsPO.getCountRiwayatBeliSaldo();
    }

    @And("user choose saldo MamiAds {string}")
    public void userChooseSaldoMamiAds(String saldo) {
        mamiAdsPO.choosingSaldoToBuy(saldo);
    }

    @And("user see title {string}")
    public void userSeeTitle(String title) {
        Assert.assertEquals(mamiAdsPO.getDetailTagihanText(), title);
    }

    @Then("user verify count of riwayat added {int}")
    public void userVerifyCountOfRiwayatAdded(int numberAdded) {
        int riwayatAfterBeliSaldo = mamiAdsPO.getCountRiwayatBeliSaldo();
        Assert.assertEquals(riwayatAfterBeliSaldo, (riwayatBeforeBeliSaldo+numberAdded), "Count of riwayat doesn't Match");
    }
}
