package steps.mamikos.owner.mamiprime;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.owner.mamiprime.MamiprimeRiwayatPembelianPO;

public class MamiprimeRiwayatPembelianSteps {
    Page page = ActiveContext.getActivePage();
    MamiprimeRiwayatPembelianPO mamiprimeRiwayatPembelianPO = new MamiprimeRiwayatPembelianPO(page);

    @Then("Owner will see empty state at tab dalam proses in halaman riwayat mamiprime")
    public void owner_will_see_empty_state_at_tab_dalam_proses_in_halaman_riwayat_mamiprime() {
        Assert.assertTrue(mamiprimeRiwayatPembelianPO.getDoesntHaveTransactionText());
        Assert.assertTrue(mamiprimeRiwayatPembelianPO.getDoesntHaveTransactionDescText());
    }

}
