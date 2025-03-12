package steps.mamikos.tenant.survei;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import org.testng.Assert;
import pageobject.tenant.survei.CustomQuestionPO;
import utilities.PlaywrightHelpers;

public class customQuestionsStep {
    Page page = ActiveContext.getActivePage();
    CustomQuestionPO customQuestion = new CustomQuestionPO(page);
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);


    @And("user click on filter survei kos")
    public void userClickOnFilterSurveiKos(){
        customQuestion.userClickOnFilterSurveiKos();
    }

    @And("user click on pengaturan survei kos")
    public void userClickOnPengaturanSurveiKos(){
        customQuestion.userClickOnPengaturanSurveiKos();
    }

    @And("user click on tambah button")
    public void userClickOnTambahButton(){
        customQuestion.userClickOnTambahButton();
    }

    @And("user fills first questions {string}")
    public void userFillsQuestions(String text){
        customQuestion.userFillsQuestions(text);
    }

    @And("user click on simpan pengaturan button")
    public void userClickOnSimpanPengaturanButton(){
        customQuestion.userClickOnSimpanPengaturan();
    }

    @And("User see {string} questions appear")
    public void UserSeeThreeQuestionsAppear(String value){
        Assert.assertTrue(customQuestion.userSeeThreeQuestionsAppear(value));
    }

    @And("user click on tambah button {int} times")
    public void userClickOnTambahButton3Times(Integer value){
        customQuestion.userClickOnTambahButton3Times(value);
    }
    @And("user delete questions {int}")
    public void userDeleteQuestions(Integer value){
        customQuestion.userDeleteQuestions(String.valueOf(value));
    }
}
