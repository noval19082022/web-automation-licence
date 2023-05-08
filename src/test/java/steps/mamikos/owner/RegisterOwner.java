package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.HomePO;
import pageobject.owner.OwnerRegisterPO;

import java.util.List;

public class RegisterOwner {
    Page page = ActiveContext.getActivePage();
    HomePO home = new HomePO(page);
    OwnerRegisterPO ownerRegister = new OwnerRegisterPO(page);

    @When("user clicks on Enter button")
    public void userClicksOnEnterButton() {
        home.EnterButton();
        ownerRegister.pemilikKostLogin();

    }

    @And("user clicks on Register button")
    public void userClicksOnRegisterButton() {
        ownerRegister.RegisterSekarang();

    }

    @Then("button daftar will be disable")
    public void buttonDaftarWillBeDisable() {
        Assert.assertTrue(ownerRegister.disableButtonRegister(), "Button is enable");
    }

    @And("user fills out registration form without click register {string}, {string}, {string}, {string}")
    public void userFillsOutRegistrationFormWithoutClickRegister(String name, String phone, String email, String password) throws InterruptedException {
        ownerRegister.fillOutRegistrationFormWithoutClickRegister(name, phone, email, password);
    }

    @Then("user verify error messages")
    public void userVerifyErrorMessages(List<String> errorMessage) {
        for (int i = 0; i < errorMessage.size(); i++) {
            Assert.assertEquals(ownerRegister.getErrorMessages(errorMessage.get(i)), errorMessage.get(i), "Error message is not equal to " + errorMessage.get(i));
        }
    }

    @And("user click on show password button")
    public void userClickOnShowPasswordButton() throws InterruptedException {
        ownerRegister.clickPasswordEyeButton();
    }

    @Then("user verify password is equal or more than {int} characters")
    public void userVerifyPasswordIsEqualOrMoreThanCharacters(int character) throws InterruptedException {
        int counter = 0;
        for (int i = 0; i < ownerRegister.getPasswordInputText().length(); i++) {
            counter++;
        }
        Assert.assertTrue(counter >= character, "Password kurang dari " + character + "karakter");
    }

    @Then("user validate email input")
    public void userValidateEmailInput() {
        Assert.assertTrue(ownerRegister.getEmailInputText().matches("^\\S+@\\S+$"), "Email format invalid");
    }

    @Then("user see email title is displayed")
    public void userSeeEmailTitleIsDisplayed() {
        Assert.assertTrue(ownerRegister.isEmailTitleAvailable(), "Email (Opsional) not displayed");
    }

    @Then("user verify name is equal or more than {int} characters")
    public void userVerifyNameIsEqualOrMoreThanCharacters(int character) {
        int counter = 0;
        for (int i = 0; i < ownerRegister.getNameInputText().length(); i++) {
            counter++;
        }
        Assert.assertTrue(counter >= character, "Name is less than " + character);
    }

    @Then("user verify profile picture is null")
    public void userVerifyProfilePictureIsNull() {
        Assert.assertTrue(ownerRegister.isProfilePictureNul(), "Profile picture is not null");
    }

    @Then("user verify profile picture is show")
    public void userVerifyProfilePictureIsShow() {
        Assert.assertTrue(ownerRegister.isProfilePictureNotNull(), "Profile picture is null");
    }
}
