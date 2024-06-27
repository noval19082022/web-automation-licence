package steps.mamikos.owner.mamiprime;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.owner.mamiprime.MamiprimeRiwayatPembelianPO;

public class MamiprimeRiwayatPembelianSteps {
    Page page = ActiveContext.getActivePage();
    MamiprimeRiwayatPembelianPO mamiprimeRiwayatPembelianPO = new MamiprimeRiwayatPembelianPO(page);

    @Then("Owner will see empty state at tab dalam proses in halaman riwayat mamiprime")
    public void owner_will_see_empty_state_at_tab_dalam_proses_in_halaman_riwayat_mamiprime() {
        Assert.assertTrue(mamiprimeRiwayatPembelianPO.isNoTransactionDalamProsesTextDisplayed());
        Assert.assertTrue(mamiprimeRiwayatPembelianPO.isNoTransactionDalamProsesDescTextDisplayed());
    }

    @Then("Owner will see empty state at tab selesai in halaman riwayat mamiprime")
    public void owner_will_see_empty_state_at_tab_selesai_in_halaman_riwayat_mamiprime() {
        Assert.assertTrue(mamiprimeRiwayatPembelianPO.isNoTransactionSelesaiTextDisplayed());
        Assert.assertTrue(mamiprimeRiwayatPembelianPO.isNoTransactionSelesaiDescTextDisplayed());
    }

    @When("Owner click tab Selesai at riwayat pembelian mamiprime")
    public void owner_click_tab_selesai_at_riwayat_pembelian_mamiprime(){
        mamiprimeRiwayatPembelianPO.clickOnMamiprimeSelesaiTab();
    }

}
