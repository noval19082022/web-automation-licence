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

    @When("admin go to FAQ menu")
    public void admin_go_to_FAQ_menu(){
        faq.clicksFAQMenu();
    }

    @When("admin search {string} in FAQ {string}")
    public void admin_search_in_FAQ(String keyword, String search){
        faq.searchFAQ(search, keyword);
    }

    @Then("FAQ {string} result {string} is displayed")
    public void FAQ_result_is_displayed(String search, String result){
        if (search.equalsIgnoreCase("Question")){
            Assert.assertEquals(faq.getSearchResultQuestion(result), questionResult, "Result does not match!");
        } else if (search.equalsIgnoreCase("Answer")) {
            Assert.assertEquals(faq.getSearchResultAnswer(result), answerResult, "Result does not match!");
        } else {
            System.out.println("Result is invalid");
        }
    }
}