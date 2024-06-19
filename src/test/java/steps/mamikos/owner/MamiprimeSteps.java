package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
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
        if (!mamiprime.isBeliPaketHeaderButtonVisible()) {
            playwright.reloadPage();
        }
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

    @Then("owner can see benefit section")
    public void owner_can_see_benefit_section() {
        Assert.assertTrue(mamiprime.isBenefitSectionisVisible(), "Benefit section is not visible");
    }

    @Then("owner can see testimonial section")
    public void owner_can_see_testimonial_section() {
        Assert.assertTrue(mamiprime.isTestimonialSectionisVisible(), "Testimonial section is not visible");
    }

    @Then("owner can see contact section")
    public void owner_can_see_contact_section() {
        Assert.assertTrue(mamiprime.isContactSectionisVisible(), "Contact section is not visible");
    }

    @And("user will see text {string} on landing page mamiprime")
    public void user_will_see_text_x_on_landing_page_mamiprime(String title) {
        Assert.assertTrue(mamiprime.textOnLandingPageMamiprime(title), "text does not appear");
    }

    @And("user will see image on benefit section")
    public void user_will_see_image_on_benefit_section() {
        Assert.assertTrue(mamiprime.isFirstBenefitImageVisible(), "first benefit image does not appear");
        Assert.assertTrue(mamiprime.isSecondBenefitImageVisible(), "second benefit image does not appear");
        Assert.assertTrue(mamiprime.isThirdBenefitImageVisible(), "third benefit image does not appear");
    }

    @And("user will see image on product description section")
    public void user_will_see_image_on_product_description_section() {
        Assert.assertTrue(mamiprime.isProductDescImageVisible(), "product description image does not appear");
    }

    @And("user will see CS Button on contact section")
    public void user_will_see_cs_buton_on_contact_section() {
        Assert.assertTrue(mamiprime.isCSButtonVisible(), "CS Button does not appear");
    }

    @Then("user will see pop up doesnt have property on mamiprime")
    public void user_will_see_pop_up_doesnt_have_property_on_mamiprime() {
        Assert.assertTrue(mamiprime.getTitleBelumAdaProperti());
        Assert.assertTrue(mamiprime.getSubtitleBelumAdaProperti());
        Assert.assertTrue(mamiprime.isTambahKosBtnVisible());
        Assert.assertTrue(mamiprime.isNantiSajaBtnVisible());
    }

}
