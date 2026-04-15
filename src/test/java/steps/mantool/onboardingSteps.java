package steps.mantool;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.mantool.onboardingPO;
import utilities.PlaywrightHelpers;

import java.util.List;

public class onboardingSteps {
    Page page = ActiveContext.getActivePage();
    Page page1;
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    onboardingPO onboarding = new onboardingPO(page);

    @Then("should redirect to onboarding page")
    public void should_redirect_to_onboarding_page() {
        playwright.hardWait(5000.0);
        Assert.assertEquals(playwright.getPageUrl(), Mamikos.URL+"/leads/mitra-agen/onboarding");
    }
    @Then("agen name is {string}")
    public void agen_name_is(String agentName) {
        Assert.assertEquals(onboarding.getAgentName(),agentName,"Agen Name Berbeda");
    }
    @Then("onboarding page breadcrumb title is {string}")
    public void onboarding_page_breadcrumb_title_is(String title) {
        Assert.assertEquals(onboarding.getBreadcrumbTitle(),title,"title breadcrumb berbeda");
    }
    @Then("onboarding title is {string}")
    public void onboarding_title_is(String title) {
        Assert.assertEquals(onboarding.getOnboardingTitle(),title,"onboarding title berbeda");
    }
    @Then("onboarding description are")
    public void onboarding_description_are(List<String> description) {
        for (int i=1;i<=description.size();i++){
            Assert.assertEquals(onboarding.getOnboardingDescription(i),description.get(i-1),"Description paragraf "+i+" berbeda");
        }
    }
    @When("agen open surat keterangan")
    public void agen_open_surat_keterangan() {
        page1 = ActiveContext.getActiveBrowserContext().waitForPage(()->{
            onboarding.clickSuratKeterangan();
        });
        ActiveContext.setActivePage(page1);
    }
    @Then("surat keterangan pdf open in new tab")
    public void surat_keterangan_pdf_open_in_new_tab() {
        String urlSuratKeterangan = "https://jambu.kerupux.com/agent/onboarding/confirmation-letter.pdf";
        playwright = new PlaywrightHelpers(page1);
        Assert.assertEquals(playwright.getPageUrl(),urlSuratKeterangan,"Bukan URL Surat Konfirmasi");
    }
    @Then("progress title is {string}")
    public void progress_title_is(String title) {
        Assert.assertEquals(onboarding.getProgressTitle(), title, "progress title tidak sesuai");
    }
    @Then("step {int} title is {string}")
    public void step_title_is(Integer step, String title) {
        Assert.assertEquals(onboarding.getStepTitle(step),title,"Step title "+step+" tidak sesuai");
    }
    @Then("step {int} description are")
    public void step_description_are(Integer step, List<String> description) {
        switch (step){
            case 1 :
                Assert.assertEquals(onboarding.getStepDescription(1),description.get(0));
                Assert.assertEquals(onboarding.getStepDescription(2),description.get(1));
                Assert.assertEquals(onboarding.getStepDescription(3),description.get(2));
                Assert.assertEquals(onboarding.getStepDescription(4),description.get(3));
                break;

            case 2 :
                Assert.assertEquals(onboarding.getStepDescription(6),description.get(0));
                Assert.assertEquals(onboarding.getStepDescription(7),description.get(1));
                break;

            case 3 :
                Assert.assertEquals(onboarding.getStepDescription(9),description.get(0));
                Assert.assertEquals(onboarding.getStepDescription(10),description.get(1));
                break;

            case 4:
                Assert.assertEquals(onboarding.getStepDescription(12),description.get(0));
                Assert.assertEquals(onboarding.getStepDescription(13),description.get(1));
                break;

            case 5 :
                Assert.assertEquals(onboarding.getStepDescription(15),description.get(0));
                Assert.assertEquals(onboarding.getStepDescription(16),description.get(1));
                break;
            default:
                System.out.println("Invalid Step");
        }
    }
    @Then("step {int} have button {string}")
    public void step_have_button(Integer step, String buttonName) {
        Assert.assertEquals(onboarding.getButtonName(step),buttonName, "button name tidak sesuai");
    }
    @When("admin tick step {int}")
    public void admin_tick_step(Integer step) {
        onboarding.checkStep(step);
    }
    @Then("steps show progress {string}")
    public void steps_show_progress(String progress) {
        Assert.assertEquals(onboarding.getStepProgress(),progress, "Progress tidak sesuai");
    }
    @Then("admin can't untick step {int}")
    public void admin_can_t_untick_step(Integer step) {
        onboarding.checkStep(step);
        Assert.assertTrue(onboarding.isStepChecked(step));
    }
    @When("agen click button {string}")
    public void agen_click_button(String name) {
        Page currentPage = ActiveContext.getActivePage();
        page1 = currentPage.waitForPopup(()->{
            onboarding.clickStepButton(name);
        });
        page1.waitForLoadState(LoadState.LOAD);
        ActiveContext.setActivePage(page1);
    }
    @Then("agen should redirect to {string} in new tab")
    public void agen_should_redirect_to_in_new_tab(String url) {
        playwright = new PlaywrightHelpers(page1);
        playwright.hardWait(5000.0);
        if (url.equalsIgnoreCase("LCT")){
            String lctUrl = Mamikos.HOMEPAGE_LCT+"?activeTab=submitted";
            Assert.assertEquals(playwright.getPageUrl(), lctUrl, "URL tidak sesuai");
        } else {
            Assert.assertEquals(playwright.getPageUrl(), url, "URL tidak sesuai");
        }
    }
    @When("admin click in breadcrumb {string}")
    public void admin_click_in_breadcrumb(String menu) {
        playwright.waitTillPageLoaded();
        if (menu.equalsIgnoreCase("Mitra Agen")){
            onboarding.clickBreadcrumbMitraAgen();
        } else if (menu.equalsIgnoreCase("Mamikos")) {
            onboarding.clickBreadcrumbMamikos();
        }
    }
    @Then("admin should redirect to mantool")
    public void admin_should_redirect_to_mantool() {
        Assert.assertEquals(playwright.getPageUrl(),Mamikos.URL+"/agen","URL Mantool tidak sesuai");
    }
    @Then("admin should redirect to mamikos")
    public void admin_should_redirect_to_mamikos() {
        Assert.assertEquals(playwright.getPageUrl(),Mamikos.URL+"/","URL Mamikos tidak sesuai");
    }

    @Then("step section header is {string}")
    public void step_section_header_is(String header) {
        Assert.assertEquals(onboarding.getStepHeader(),header);
    }

    @When("agen logout from onboarding page")
    public void agen_logout_from_onboarding_page() {
        onboarding.logoutAgen();
    }

    @Then("agen should redirect to mantool landing page")
    public void agen_should_redirect_to_mantool_landing_page() {
        String landingPageURL = "https://jambu.kerupux.com/agen";

        playwright.hardWait(3000.0);
        Assert.assertEquals(playwright.getPageUrl(), landingPageURL);
    }

    @When("agen visit onboarding page agen")
    public void agen_visit_onboarding_page_agen() {
        playwright.navigateTo("https://jambu.kerupux.com/leads/mitra-agen/onboarding",3000.0, LoadState.LOAD);
    }

    @When("agen visit LCT")
    public void agen_visit_lct() {
        playwright.navigateTo("https://jambu.kerupux.com/leads/agen/leads-management?activeTab=submitted",3000.0, LoadState.LOAD);
        playwright.hardWait(3000.0);
    }
}
