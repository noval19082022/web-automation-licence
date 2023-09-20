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

    @And("user will see title and message on Dalam Proses tab")
    public void willSeeTitleAndMessageOnDalamProsesTab() {
        Assert.assertEquals(mamiAdsPO.getTitleDalamProsesText(), "Belum Ada Transaksi");
        Assert.assertTrue(playwright.isTextDisplayed("Transaksi yang masih dalam proses akan muncul di halaman ini."));
    }

    @And("user will see title and message on Selesai tab")
    public void willSeeTitleAndMessageOnSelesaiTab() {
        Assert.assertEquals(mamiAdsPO.getTitleSelesaiText(), "Belum Ada Transaksi");
        Assert.assertTrue(playwright.isTextDisplayed("Transaksi yang sudah selesai akan muncul di halaman ini."));
    }
}
