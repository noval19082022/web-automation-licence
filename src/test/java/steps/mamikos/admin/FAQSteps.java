package steps.mamikos.admin;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.admin.mamipay.bangkrupux.FAQPO;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

public class FAQSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);

    FAQPO faq = new FAQPO(page);

    //---Test Data---//
    private String FAQ = "src/test/resources/testdata/bangkerupuxAdmin/faq.properties";
    private String questionResult = JavaHelpers.getPropertyValue(FAQ, "questionResult");
    private String answerResult = JavaHelpers.getPropertyValue(FAQ, "answerResult");
    private String addQuestion = JavaHelpers.getPropertyValue(FAQ, "addQuestion");
    private String addAnswer = JavaHelpers.getPropertyValue(FAQ, "addAnswer");
    private String addAlert = JavaHelpers.getPropertyValue(FAQ, "addAlert");
    private String deleteAlert = JavaHelpers.getPropertyValue(FAQ, "deleteAlert");

    @When("admin go to FAQ menu")
    public void admin_go_to_FAQ_menu(){
        faq.clicksFAQMenu();
    }

    @When("admin search {string} in FAQ {string}")
    public void admin_search_in_FAQ(String keyword, String search){
        faq.searchFAQ(search, keyword);
    }

    @Then("FAQ {string} result is displayed")
    public void FAQ_result_is_displayed(String search){
        if (search.equalsIgnoreCase("Question")){
            Assert.assertEquals(faq.getSearchResultQuestion(), questionResult, "Result does not match!");
        } else if (search.equalsIgnoreCase("Answer")) {
            Assert.assertEquals(faq.getSearchResultAnswer(), answerResult, "Result does not match!");
        } else {
            System.out.println("Result is invalid");
        }
    }

    @When("admin adds level faq")
    public void admin_adds_level_faq(){
        faq.clicksAddsFaqBtn();
        faq.inputsQuestionFaq(addQuestion);
        faq.inputsAnswerFaq(addAnswer);
        faq.clicksSaveButtonInAddFaq();
        Assert.assertEquals(faq.getAlertMessage(), addAlert, "Add Alert Message does not match!");
    }

    @Then("new Level FAQ is displayed")
    public void new_Level_FAQ_is_displayed(){
        Assert.assertEquals(faq.getSearchResultQuestion(), addQuestion, "Result does not match!");
        System.out.println(faq.getSearchResultQuestion());
    }

    @When("admin deletes level faq")
    public void admin_deletes_level_faq(){
        faq.clicksDelete();
    }

    @Then("alert message is displayed")
    public void alert_message_is_displayed(){
        Assert.assertEquals(faq.getAlertMessage(), deleteAlert, "Delete Alert Message does not match!");
        System.out.println(faq.getAlertMessage());
    }

    @Then("new Level FAQ is not displayed")
    public void new_Level_FAQ_is_not_displayed(){
        Assert.assertFalse(faq.isLevelFaqDisplayed(), "Level FAQ is still displayed!");
    }
}