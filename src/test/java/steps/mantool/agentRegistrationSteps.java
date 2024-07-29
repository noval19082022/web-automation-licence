package steps.mantool;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.mantool.agentRegistrationPO;
import utilities.PlaywrightHelpers;

public class agentRegistrationSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    agentRegistrationPO registration = new agentRegistrationPO(page);

    @When("agen not upload photo KTP")
    public void agen_not_upload_photo_ktp() {
        registration.chooseSkemaAgen("Agen Akuisisi");
        registration.fillNamaLengkap("Agen Automation Test");
        registration.fillNomorHandphone("082290901020");
        registration.fillEmail("agenautomation@gmail.com");
        registration.fillUsia("25");
        registration.fillNoKTP("3402091290390002");
        registration.fillPassword("qwerty123");
        registration.fillKonfirmasiPassword("qwerty123");
        registration.clickBerikutnya();
    }

    @Then("show agen registration error message foto ktp {string}")
    public void show_agen_registration_error_message_foto_ktp(String error) {
        switch (error){
            case "empty KTP":
                Assert.assertEquals(registration.getUploadPhotoErrorMessage(),"Upload foto KTP Anda.");
                break;
            case "oversize KTP":
                Assert.assertEquals(registration.getUploadPhotoErrorMessage(),"File tidak dikenali atau melebihi 2 MB");
                break;
        }
    }
}
