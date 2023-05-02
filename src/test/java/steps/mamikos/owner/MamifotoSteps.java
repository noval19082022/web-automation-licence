package steps.mamikos.owner;

import pageobject.tenant.InvoicePO;
import testdata.InvoiceTestData;
import testdata.MamifotoTitle;
import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.owner.MamifotoPO;
import utilities.PlaywrightHelpers;
import java.util.Locale;

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



}
