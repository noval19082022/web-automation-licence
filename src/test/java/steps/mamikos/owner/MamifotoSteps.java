package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.owner.MamifotoPO;
import testdata.MamifotoTitle;
import utilities.PlaywrightHelpers;

public class MamifotoSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    MamifotoPO mamifoto = new MamifotoPO (page);


    @When("owner click menu sidebar Mamifoto")
    public void owner_click_menu_sidebar_mamifoto() {
        mamifoto.clickOnFiturPromosi();
       mamifoto.clickOnMamifotoSidebar();
    }

    @Then("owner can see mamifoto page")
    public void owner_can_see_mamifoto_page() {
        Assert.assertTrue(mamifoto.mamifotoHeaderLandingPageisAppear(),"Mamifoto Landing Page Doesnt Appear!");
    }


    @When("owner back to owner dashboard")
    public void owner_back_to_owner_dashboard() {
      mamifoto.clickOnHomeMenuOwner();
    }

    @Then("owner click section Tingkatkan Kinerja Kost")
    public void owner_click_section_tingkatkan_kinerja_kost() throws InterruptedException {
        MamifotoTitle.TitletingkatkanKinerja = mamifoto.getKinerjaTitle();
        Assert.assertEquals(MamifotoTitle.TitletingkatkanKinerja,mamifoto.getKinerjaTitle());
        MamifotoTitle.subTitleTingkatkan = mamifoto.getKinerjaSubTitle();
        Assert.assertEquals(MamifotoTitle.subTitleTingkatkan,mamifoto.getKinerjaSubTitle());
        mamifoto.clickOnSewaMamifoto();
    }
    @Then("owner click info untuk anda for mamifoto")
    public void owner_click_info_untuk_anda_for_mamifoto() throws InterruptedException {
       MamifotoTitle.MamifotoInfoUntukAnda = mamifoto.getMamifotoInfoUntukAndaText();
       Assert.assertEquals(MamifotoTitle.MamifotoInfoUntukAnda,mamifoto.getMamifotoInfoUntukAndaText());
       mamifoto.clickOnMamifotoInfoUntukAnda();
    }
    @When("owner click Lihat Paket button")
    public void owner_click_lihat_paket_button() {
        mamifoto.clickOnLihatPaket();
    }

    @And("owner select package mamifoto")
    public void owner_select_package_mamifoto() {
       mamifoto.clickOnMamifotoPackageNonGPFirst();
    }

    @Then("owner see pop up doesnt have property")
    public void owner_see_pop_up_doesnt_have_property() {
        Assert.assertTrue(mamifoto.getAddedNewKostPopUpButton(),"Button doesnt appear");
        Assert.assertTrue(mamifoto.getNantiSajaButton(),"Button doesnt appear");
        Assert.assertTrue(mamifoto.getPopUpDoesntHaveProperty(),"Pop Up Doesnt Appear");
        mamifoto.clickOnNantiSajaButton();
    }
    @Then("owner see pilih paket page")
    public void owner_see_pilih_paket_page() {
        Assert.assertTrue(mamifoto.mamifotoHeaderSelectPackageisAppear(),"Lihat Paket is not Appear");
    }

    @When("owner back to Mamifoto Landing Page")
    public void owner_back_to_mamifoto_landing_page() {
       mamifoto.clickOnBackSelectPackage();
    }

    @When("owner click Baca Panduan button")
    public void owner_click_button() {
       mamifoto.clickOnBacaPanduan();
    }

    @Then("owner see detail panduan pop up")
    public void owner_see_detail_panduan_pop_up() {
        Assert.assertTrue(mamifoto.mamifotoHeaderBacaPanduanisAppear(),"Pop Up Baca Panduan doesnt Appear");
        mamifoto.clickOnCloseBacaPanduan();
    }

    @When("owner click any faq button")
    public void owner_click_any_faq_button() {
        mamifoto.clickOnFirstListFAQ();
    }

    @Then("owner see detail FAQ")
    public void owner_see_detail_faq() {
        Assert.assertTrue(mamifoto.contentFirstFAQisAppear(),"content is not appear");
    }

    @Then("owner click info untuk anda for mamifoto non property")
    public void owner_click_info_untuk_anda_for_mamifoto_non_property() throws InterruptedException {
        MamifotoTitle.MamifotoInfoUntukAnda = mamifoto.getMamifotoInfoUntukAndaNonPropertyText();
        Assert.assertEquals(MamifotoTitle.MamifotoInfoUntukAnda,mamifoto.getMamifotoInfoUntukAndaNonPropertyText());
        mamifoto.clickOnMamifotoInfoUntukAndaNonProperty();
    }
}
