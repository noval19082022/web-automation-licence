package steps.mamikos.common;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.ForgotPasswordPO;
import pageobject.common.HomePO;
import utilities.PlaywrightHelpers;

public class ForgotPasswordSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    HomePO home = new HomePO(page);
    ForgotPasswordPO forgotPassword = new ForgotPasswordPO(page);

    @When("user want to change the owner password")
    public void user_want_to_change_owner_password() {
        home.clickOnEntryToLoginPage();
        forgotPassword.clickOnLoginAsOwner();
        forgotPassword.clickOnLupaPassword();
    }

    @When("user fill their registered phone number {string}")
    public void input_phone_number(String phoneNumber) {
        forgotPassword.fillPhoneNumber(phoneNumber);
        forgotPassword.chooseVerificationMethod();
    }

    @When("user fill their unregistered phone number {string}")
    public void input_phone_number_unregist(String phoneNumber) {
        forgotPassword.fillPhoneNumber(phoneNumber);
    }

    @When("user choose verification by sms")
    public void user_choose_verify_by_sms() {
        forgotPassword.selectOTPBySMS();
    }

    @When("user choose verification by WA")
    public void user_choose_verify_by_wa() {
        forgotPassword.selectOTPByWA();
    }

    @Then("user verify {string} and click button resend OTP")
    public void kirim_ulang_otp_verification(String text) {
        playwright.hardWait(60_000);
        Assert.assertTrue(forgotPassword.getResendOTPButton().contains(text), "Code verification text is not equal to " + text);
        forgotPassword.clickOnResendOtp();
    }

    @Then("user redirected to {string}")
    public void user_redirect_link(String link) {
        Assert.assertTrue(playwright.getActivePageURL().contains(link), "Url doesn't match");
    }

    @Then("user verify on page {string}")
    public void user_get_active_title(String title) {
        Assert.assertEquals(playwright.getActivePageTitle(), "Lupa Password Pemilik - Mamikos", "Active page title is not equal to Lupa Password Pemilik - Mamikos");
        Assert.assertTrue(forgotPassword.getTitleVerifikasiPage().contains(title), "Title is not equal to " + title);
    }

    @Then("user get error message {string}")
    public void user_get_error_message(String message) {
        Assert.assertTrue(forgotPassword.getErrorMessage().contains(message), "Error message is not equal to " + message);
    }
}
