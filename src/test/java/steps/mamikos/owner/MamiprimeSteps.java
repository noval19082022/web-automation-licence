package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.owner.MamiprimePO;
import utilities.PlaywrightHelpers;

public class MamiprimeSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    MamiprimePO mamiprime = new MamiprimePO(page);


    @Then("user see lihat riwayat button")
    public void user_see_lihat_riwayat_button() {
        mamiprime.isLihatRiwayatVisible();
    }

    @When("user click lihat riwayat mamiprime button")
    public void user_click_lihat_riwayat_mamiprime_button() {
        mamiprime.clickOnLihatRiwayat();
    }
}
