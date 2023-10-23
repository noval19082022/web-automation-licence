package steps.mamikos.tenant.profile;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.tenant.profile.VerifikasiAkunPO;
import utilities.PlaywrightHelpers;

public class VerifikasiAkunSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);

    VerifikasiAkunPO verifikasiakun = new VerifikasiAkunPO(page);

    @And("user open verifikasi akun menu")
    public void userOpenVerifikasiAkunMenu() {
        verifikasiakun.clickOnVerifikasiAkunMenu();
    }

    @And("user change email to {string}")
    public void userChangeEmailTo(String email){
        verifikasiakun.changeEmail(email);
    }

    @And("user confirm change email")
    public void userConfirmChangeEmail(){
        verifikasiakun.confirmEmailFromMailHog();
    }

    @And("user edit phone number with {string}")
    public void userEditPhoneNumberWith(String phone) {
        verifikasiakun.changePhoneNumber(phone);
    }

    @Then("user verify OTP verification message was sent {string}")
    public void userVerifyOTPVerificationMessageWasSent(String message) {
        Assert.assertEquals(verifikasiakun.getOTPVerificationMessage(),message, "OTP verification messages is not equal to " + message);
    }
}
