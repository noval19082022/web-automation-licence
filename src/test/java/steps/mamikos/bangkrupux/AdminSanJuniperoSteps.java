package steps.mamikos.bangkrupux;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.admin.mamipay.bangkrupux.AdminSanJuniperoPO;
import utilities.JavaHelpers;

import java.util.UUID;


public class AdminSanJuniperoSteps {
    Page page = ActiveContext.getActivePage();
    AdminSanJuniperoPO adminSanJuniperoPO = new AdminSanJuniperoPO(page);

    @And("admin bangkerupux create new san junipero parent")
    public void adminBangkerupuxCreateNewSanJuniperoParent() {
        adminSanJuniperoPO.createNewParent();
    }

    @And("admin bangkrupux fills all field on create new san junipero parent {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void adminBangkrupuxFillsAllFieldOnCreateNewSanJuniperoParent(String slug, String kost_type, String biaya_sewa, String title_tag, String title_header, String sub_title_header, String facility, String faq, String faq_answer) {
        adminSanJuniperoPO.setSlugOnCreateSanJunipero(slug + UUID.randomUUID());
        adminSanJuniperoPO.setKostTypeOnCreateSanJunipero(kost_type);
        adminSanJuniperoPO.setBiayaSewaOnCreateSanJunipero(biaya_sewa);
        adminSanJuniperoPO.setTitleTagOnCreateSanJunipero(title_tag);
        adminSanJuniperoPO.setTitleHeaderOnCreateSanJunipero(title_header);
        adminSanJuniperoPO.setSubTitleOnCreateSanJunipero(sub_title_header);
        adminSanJuniperoPO.setFacilityOnCreateSanJunipero(facility);
        adminSanJuniperoPO.setFaqOnCreateSanJunipero(faq);
        adminSanJuniperoPO.setFaqAnswerOnCreateSanJunipero(faq_answer);
    }

    @And("admin bangkrupux fills all field on create new san junipero parent already exist {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void adminBangkrupuxFillsAllFieldOnCreateNewSanJuniperoParentAlreayEXist(String slug, String kost_type, String biaya_sewa, String title_tag, String title_header, String sub_title_header, String facility, String faq, String faq_answer) {
        adminSanJuniperoPO.setSlugOnCreateSanJunipero(slug);
        adminSanJuniperoPO.setKostTypeOnCreateSanJunipero(kost_type);
        adminSanJuniperoPO.setBiayaSewaOnCreateSanJunipero(biaya_sewa);
        adminSanJuniperoPO.setTitleTagOnCreateSanJunipero(title_tag);
        adminSanJuniperoPO.setTitleHeaderOnCreateSanJunipero(title_header);
        adminSanJuniperoPO.setSubTitleOnCreateSanJunipero(sub_title_header);
        adminSanJuniperoPO.setFacilityOnCreateSanJunipero(facility);
        adminSanJuniperoPO.setFaqOnCreateSanJunipero(faq);
        adminSanJuniperoPO.setFaqAnswerOnCreateSanJunipero(faq_answer);
    }

    @And("admin bangkrupux check the checkbox Active on create new san junipero")
    public void adminBangkrupuxCheckTheCheckboxActiveOnCreateNewSanJunipero() {
        adminSanJuniperoPO.cekActiveOnCreateSanJunipero();
    }

    @And("admin bangkrupux save Sanjunipero on create new san junipero")
    public void adminBangkrupuxSaveSanjuniperoOnCreateNewSanJunipero() {
        adminSanJuniperoPO.saveOnCreateSanJunipero();
    }

    @Then("admin bangkerupux verify success create new sanjunipero {string}")
    public void adminBangkerupuxVerifySuccessCreateNewSanjunipero(String message) {
        Assert.assertEquals(adminSanJuniperoPO.getSuccessMessageOnCreateSanJunipero(), message);
    }

    @And("admin bangkerupux preview action kost on sanjunipero page")
    public void adminBangkerupuxPreviewActionKostOnSanjuniperoPage() {
        adminSanJuniperoPO.clickOnPreviewAction();
    }

    @And("admin bangkerupux deactive first sanjunipero on sanjunipero page")
    public void adminBangkerupuxDeactiveFirstSanjuniperoOnSanjuniperoPage() {
        adminSanJuniperoPO.clickOnDeactiveAction();
    }

    @Then("admin bangkerupux will see last updated sanjunipero is current time")
    public void adminBangkerupuxWillSeeLastUpdatedSanjuniperoIsCurrentTime() {
        Assert.assertTrue(adminSanJuniperoPO
                .getCurrentTimeUpdate()
                .contains(JavaHelpers.getCurrentDateOrTime("yyyy-MM-dd HH:mm"))
                , "Time is not up to date");
    }

    @And("admin bangkerupux activate first sanjunipero on sanjunipero page")
    public void adminBangkerupuxActivateFirstSanjuniperoOnSanjuniperoPage() {
        adminSanJuniperoPO.clickOnActiveAction();
    }
}
