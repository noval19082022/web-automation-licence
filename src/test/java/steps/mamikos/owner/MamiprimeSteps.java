package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
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

    @When("owner wants to buy mamiprime from header")
    public void owner_wants_to_buy_mamiprime_from_header() {
        Assert.assertTrue(mamiprime.isBeliPaketHeaderButtonVisible(),"beli paket button not visble");
        mamiprime.clickOnBeliPaketHeader();
    }

    @Then("owner can see page {string}")
    public void owner_can_see_page(String title) {
        Assert.assertTrue(mamiprime.isPendataranMamiprimeVisible(title),"Title page not show");
    }
    @When("owner wants to buy mamiprime from product description")
    public void owner_wants_to_buy_mamiprime_from_product_description() {
       Assert.assertTrue(mamiprime.isBeliPaketDescButtonVisible(),"beli paket button not visible");
       mamiprime.clickOnBeliPaketDesc();
    }

    @When("owner access mamiprime landing page")
    public void owner_access_mamiprime_landing_page() {
        mamiprime.navigatesToMamiprime();
    }

    @Then("owner can see FAQ section")
    public void owner_can_see_faq_section() {
        Assert.assertTrue(mamiprime.isFAQsectionisVisible(),"FAQ section is not visible");
        Assert.assertTrue(mamiprime.isPusatBantuansectionisVisible(),"Pusat bantuan section is not visible");
    }

}
