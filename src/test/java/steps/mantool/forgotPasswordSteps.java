package steps.mantool;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.mantool.forgotPasswordPO;

public class forgotPasswordSteps {
    Page page = ActiveContext.getActivePage();
    forgotPasswordPO forgotPassword = new forgotPasswordPO(page);

    @When("user input phone number {string}")
    public void user_input_phone_number(String phone) {
        Assert.assertTrue(forgotPassword.isForgotPasswordPage());
        forgotPassword.setPhoneNumberForgotPassword(phone);
    }

    @Then("field no handphone can only accept number")
    public void field_no_handphone_can_only_accept_number() {
        Assert.assertEquals(forgotPassword.getPhoneNumber(),"");
    }

    @Then("button verifikasi is {string}")
    public void button_verifikasi_is(String visibilty) {
        if (visibilty.equalsIgnoreCase("enable")){
            Assert.assertFalse(forgotPassword.isVerifikasiStatusDisable());
        } else if (visibilty.equalsIgnoreCase("disable")) {
            Assert.assertTrue(forgotPassword.isVerifikasiStatusDisable());
        } else {
            System.out.println("Invalid status button visiblity");
        }
    }

    @When("user click button verifikasi forgot password mantool")
    public void user_click_button_verifikasi_forgot_password_mantool() {
        forgotPassword.clickVerifikasiButton();
    }

    @Then("show forgot password error message {string}")
    public void show_forgot_password_error_message(String error) {
        Assert.assertEquals(forgotPassword.getForgotPasswordMantoolErrorMessage(),error);
    }

    @Then("user redirect to request otp method page")
    public void user_redirect_to_request_otp_method_page() {
        Assert.assertEquals(forgotPassword.getTitlePage(),"Pilih Metode Verifikasi");
    }
}
