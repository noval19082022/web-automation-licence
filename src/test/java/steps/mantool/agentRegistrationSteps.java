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
        registration.fillUsia("21");
        registration.fillNoKTP("3402091290390002");
        registration.fillPassword("qwerty123");
        registration.fillKonfirmasiPassword("qwerty123");
        registration.clickBerikutnya();
    }

    @When("agen upload KTP using file {string}")
    public void agen_upload_ktp_using_file(String file) {
        if (file.equalsIgnoreCase("more than 2MB")){
            registration.uploadPhotoKTP("src/main/resources/images/upload5Mb.jpg");
        } else if (file.equalsIgnoreCase("less than 2MB")) {
            registration.uploadPhotoKTP("src/main/resources/images/kos tampak depan.jpg");
        }
    }

    @Then("no agen registration error message foto ktp")
    public void no_agen_registration_error_message_foto_ktp() {
        Assert.assertFalse(registration.isFotoKTPErrorMessageVisible());
    }

    @When("agen input age {string}")
    public void agen_input_age(String age) {
        registration.fillUsia(age);
    }
    @Then("show agen registration error message {string}")
    public void show_agen_registration_error_message(String message) {
        Assert.assertEquals(registration.getErrorMessage(),message);
    }

    @Then("show agen registration error message upload ktp {string}")
    public void show_agen_registration_error_message_upload_ktp(String message) {
        Assert.assertEquals(registration.getUploadPhotoErrorMessage(), message);
    }

    @Then("no agen registration error message")
    public void no_agen_registration_error_message() {
        Assert.assertFalse(registration.isErrorMessageVisible());
    }
    @When("agen input ktp {string}")
    public void agen_input_ktp(String noKtp) {
        registration.fillNoKTP(noKtp);
    }
    @Then("show agen registration error message ktp {string}")
    public void show_agen_registration_error_message_ktp(String message) {
        Assert.assertEquals(registration.getErrorMessage(),message);
    }
}
