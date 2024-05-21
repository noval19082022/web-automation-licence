package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.owner.LandingPageOwnerPO;
import utilities.PlaywrightHelpers;

public class LandingPageOwnerSteps {
    Page page = ActiveContext.getActivePage();
    LandingPageOwnerPO landingPageOwnerPO = new LandingPageOwnerPO(page);
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);

    @And("user scroll into entry point landing page owner")
    public void user_scroll_into_entry_point_landing_page_owner(){
        landingPageOwnerPO.scrollIntoEntryPointLPOwner();
    }

    @Then("user can see {string} and button {string} on Homepage")
    public void user_can_see_and_button_on_homepage(String text, String buttonText) {
        Assert.assertEquals(landingPageOwnerPO.getTitleEntryPointLPOwner(), text, "Title doesn't match");
        Assert.assertEquals(landingPageOwnerPO.getTextButtonEntryPointLPOwner(), buttonText, "Button doesn't match");
    }

    @Then("user cannot see entry point landing page owner")
    public void user_cannot_see_entry_point_landing_page_owner() {
        Assert.assertFalse(landingPageOwnerPO.isEntryPointLPOwnerVisible(),"Entry Point is displayed");
    }

    @Then("user can see title {string} on Landing Page Owner")
    public void user_can_see_title_on_landing_page_owner(String text) {
        Assert.assertEquals(landingPageOwnerPO.getTitleLandingPageOwner(text), text, "Title doesn't match");
    }

    @And("user can see information {string} on Landing Page Owner")
    public void user_can_see_message_on_landing_page_owner(String text) {
        Assert.assertEquals(landingPageOwnerPO.getTextInfoLandingPageOwner(text), text, "Information doesn't match");
    }

    @And("user can see image header on Landing Page Owner")
    public void user_can_see_image_header_on_landing_page_owner() {
        Assert.assertTrue(landingPageOwnerPO.isImageHeaderLPOwnerVisible(), "image doesn't display");
    }

    @When("user click {string} on Landing Page Owner")
    public void user_click_on_landing_page_owner(String buttonText) {
        Assert.assertEquals(landingPageOwnerPO.getTextDaftarkanKosButton(buttonText), buttonText);
        landingPageOwnerPO.clickOnDaftarkanKosButton();
    }

    @And("user scroll to section USP")
    public void user_scroll_to_section_usp() {
        landingPageOwnerPO.scrollIntoUSPSection();
    }

    @And("user scroll and see section {string}")
    public void user_scroll_and_see_section(String text) {
        landingPageOwnerPO.scrollIntoMBLMSection();
        Assert.assertEquals(landingPageOwnerPO.getTitleLandingPageOwner(text), text, "Title doesn't match");
    }

    @When("user click on {string} and see list with subtitle {string} on Landing Page Owner")
    public void user_click_on_and_see_list_with_subtitle_on_landing_page_owner(String titleText, String infoText) {
        landingPageOwnerPO.clickOnTextLPOwner(titleText);
        Assert.assertEquals(landingPageOwnerPO.getTitleLandingPageOwner(titleText), titleText, "Title doesn't match");
        Assert.assertEquals(landingPageOwnerPO.getTextInfoLandingPageOwner(infoText), infoText, "Subtitle doesn't match");
    }

    @When("user scroll and click {string} button")
    public void user_scroll_and_click_button(String buttontext) {
        landingPageOwnerPO.clickOnButtonLPOwner(buttontext);
    }


    @When("user see question {string} on Landing Page Owner")
    public void user_see_question_on_landing_page_owner(String question) {
       landingPageOwnerPO.clickOnQuestionSection(question);

    }

    @Then("user verify answer text at LP owner {string}")
    public void user_verify_answer_text_at_lp_owner(String answer) {
        Assert.assertTrue(landingPageOwnerPO.answerFAQisApppear(answer).contains(answer),"title doesnt appear");

    }

    @When("user scroll to pusat bantuan")
    public void user_scroll_to_pusat_bantuan() {
       landingPageOwnerPO.scrollIntoPusatBantuanSection();
    }

    @Then("user want to accsess Pusat Bantuan")
    public void user_want_to_accsess_pusat_bantuan() {
       landingPageOwnerPO.clickOnButtonHelpCenter();
    }

    @When("user can see title {string} and sub title {string} at section pusat bantuan")
    public void user_can_see_title_and_sub_title_at_section_pusat_bantuan(String title, String subTitle) {
        Assert.assertEquals(landingPageOwnerPO.getTextTitlePusatBantuan(),title,"title doesnt match");
        Assert.assertEquals(landingPageOwnerPO.getTextSubTitlePusatBantuan(),subTitle,"sub title doesnt match");
    }

    @Then("user can see footer mamikos")
    public void user_can_see_footer_mamikos() {
       Assert.assertTrue(landingPageOwnerPO.isFooterMamikosAppear(),"footer doesnt appear");
    }
}
