package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.owner.MamitourPO;

public class MamitourSteps {
    Page page = ActiveContext.getActivePage();
    MamitourPO mamitour = new MamitourPO(page);

    @And("user click on pesan sekarang button")
    public void user_click_on_pesan_sekarang_button() {
        mamitour.clickOnPesanSekarang();
    }

    @Then("user will see text title with {string} and subtitle with {string}")
    public void user_will_see_text_title_with_x_and_subtitle_with_x(String title, String subtitle) {
        Assert.assertEquals(mamitour.getTitleBelumAdaProperti(), title, "String doesn't match");
        Assert.assertEquals(mamitour.getSubtitleBelumAdaProperti(), subtitle, "String doesn't match");
    }

    @When("user click on pusat bantuan mamitour")
    public void user_click_on_pusat_bantuan_mamitour() {
        mamitour.clickOnPusatBantuan();
    }

    @And("user will see title {string} on landing page mamitour")
    public void user_will_see_title_x_on_landing_page_mamitour(String title) {
        mamitour.isContentOnMamitourVisible(title);
    }

    @Then("user will {string} Lihat Riwayat button")
    public void user_will_x_riwayat_button(String state) {
        if (state.equals("see")) {
            Assert.assertTrue(mamitour.isRiwayatButtonVisible(), "Riwayat button is not visible");
        } else {
            Assert.assertFalse(mamitour.isRiwayatButtonVisible(), "Riwayat button is visible");
        }
    }

    @And("user click on Lihat Riwayat Button")
    public void user_click_on_lihat_riwayat_button() {
        mamitour.clickOnRiwayatButton();
    }

    @And("user click on tab dalam proses")
    public void user_click_on_tab_dalam_proses() {
        mamitour.clickOnDalamProsesTab();
    }

    @And("user click on tab selesai")
    public void user_click_on_tab_selesai() {
        mamitour.clickOnSelesaiTab();
    }

    @Then("user will see empty state text {string} as title and {string} as subtitle")
    public void user_will_see_empty_state_text_x_as_title_and_x_as_subtitle(String title, String subtitle) {
        Assert.assertEquals(mamitour.getEmptyStateTitleText(), title, "Title text is not match");
        Assert.assertEquals(mamitour.getEmptyStateSubtitleText(), subtitle, "Subtitle text is not match");
    }

    @Then("user verify there is transaction")
    public void user_verify_there_is_transaction() {
        Assert.assertTrue(mamitour.isHistoryListVisible(), "List history is not visible");
    }
}
