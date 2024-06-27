package steps.mamikos.common;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
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

    @When("user clear their unregistered phone number")
    public void clear_input_phone_number_unregist() {
        forgotPassword.clearInputPhoneNumber();
    }

    @When("user choose verification by sms")
    public void user_choose_verify_by_sms() {
        forgotPassword.selectOTPBySMS();
    }

    @When("user choose verification by WA")
    public void user_choose_verify_by_wa() {
        forgotPassword.selectOTPByWA();
    }

    @And("user input invalid code otp {string}")
    public void user_input_invalid_code_otp(String otp) {
        forgotPassword.fillOTP(otp);
    }

    @And("user click back button on page otp")
    public void user_click_back() {
        forgotPassword.backButton();
    }

    @And("user click back button, batalkan")
    public void user_click_back_batalkan() {
        forgotPassword.backButtonFromSendOTPPage();
    }

    @Then("user see popup verifikasi batalkan proses {string}")
    public void verification_msg(String message) {
        Assert.assertTrue(forgotPassword.isMessageAppear(message), "Message is not equal to " + message);
    }

    @Then("user see toast message {string} {string} in forgot password")
    public void toastMsg(String message1, String message2) {
        Assert.assertTrue(forgotPassword.isMessageAppear(message1), "Message is not equal to " + message1);
        Assert.assertTrue(forgotPassword.isMessageAppear(message2), "Message is not equal to " + message2);
    }

    @Then("user verify otp form appear on page OTP {string}")
    public void verification_msg_otp(String message) {
        Assert.assertTrue(forgotPassword.isMessageAppear(message), "Message is not equal to " + message);
    }

    @Then("user verify {string} and click button resend OTP")
    public void kirim_ulang_otp_verification(String text) {
        Assert.assertTrue(forgotPassword.getResendOTPButton().contains(text), "Code verification text is not equal to " + text);
        forgotPassword.clickOnResendOtp();
    }

    @Then("user verify on page {string}")
    public void user_get_active_title(String title) {
        Assert.assertEquals(playwright.getActivePageTitle(), "Lupa Password Pemilik - Mamikos", "Active page title is not equal to Lupa Password Pemilik - Mamikos");
        Assert.assertTrue(forgotPassword.getTitleVerifikasiPage().contains(title), "Title is not equal to " + title);
    }

    @Then("user get error message {string}")
    public void user_get_error_message(String message) {
        Assert.assertTrue(forgotPassword.getErrorMessage(message).contains(message), "Error message is not equal to " + message);
    }

    @When("user click text {string}")
    public void clickText(String text) {
        this.forgotPassword = forgotPassword.clickTextAndRedierctNextPage(text);
        ActiveContext.setActivePage(ActiveContext.getActiveBrowserContext().pages().get(1));
    }

    @Then("user directed to wa and verify pretext {string}")
    public void verifyPretext(String msg){
        Assert.assertTrue(forgotPassword.isMessageAppear(msg), "message not appear");
    }

    @Then("user see button choose verify method is disabled")
    public void verify_button_is_disable() {
        Assert.assertTrue(forgotPassword.buuttonVerificationMethodIsDisable());
    }

    @Then("user verify otp form appear on page send OTP {string}")
    public void otp_message(String message) {
        Assert.assertTrue(forgotPassword.getMessage(message).contains(message), "Message is not equal to " + message);
    }

    @Then("user verify invalid OTP message {string}")
    public void invalid_otp_message(String message) {
        Assert.assertTrue(forgotPassword.isMessageAppear(message), "Message is not equal to " + message);
    }

    @And("user click on lupa password?")
    public void click_on_lupa_password() {
        forgotPassword.clickOnLupaPassword();
    }

    @Then("user verify on tenant page {string}")
    public void userVerifyOntenantPage(String title) {
        Assert.assertEquals(playwright.getActivePageTitle(), "Lupa Password Pencari - Mamikos", "Active page title is not equal to Lupa Password Pemilik - Mamikos");
        Assert.assertTrue(forgotPassword.getTitleVerifikasiPage().contains(title), "Title is not equal to " + title);
    }
}
