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

}
