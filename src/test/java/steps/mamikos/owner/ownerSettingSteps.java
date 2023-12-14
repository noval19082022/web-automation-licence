package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.owner.OwnerSettingPO;
import utilities.PlaywrightHelpers;

public class ownerSettingSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    OwnerSettingPO ownerSettingPO = new OwnerSettingPO(ActiveContext.getActivePage());

    @And("owner click on Ubah {string}")
    public void ownerClickOnUbah(String infoPribadi) {
        ownerSettingPO.clickOnUbahInfoPribadi(infoPribadi);
    }

    @Then("owner delete nomor handphone owner")
    public void ownerDeleteNomorHandphoneOwner() {
        ownerSettingPO.clearPhoneNumber();
        Assert.assertEquals(ownerSettingPO.getTextPlaceholder(), "Masukkan nomor handphone", "Placeholder doesn't match!");
        Assert.assertTrue(ownerSettingPO.isSimpanDisable(), "Button is enable!");
    }

    @And("owner fills nomor handphone owner {string}")
    public void ownerFillsNomorHandphoneOwner(String phoneNumber) {
        ownerSettingPO.inputPhoneNumber(phoneNumber);
        Assert.assertFalse(ownerSettingPO.isSimpanDisable(), "Button is disable!");

        ownerSettingPO.clickOnSubmitButton();
    }

    @Then("verify pop up message {string}")
    public void verifyPopUpMessage(String messageText) {
       Assert.assertEquals(ownerSettingPO.getMessageValidation(), messageText, "Message doesn't match!");
       ownerSettingPO.clickOnConfirmValidation();
    }

    @And("owner click resend code verification")
    public void ownerClickResendCodeVerification() {
        ownerSettingPO.clickOnResendCode();
    }

    @Then("verify pop up input valid nomor handphone")
    public void verifyPopUpInputValidNomorHandphone() {
        if (equals(ownerSettingPO.isVerifikasiNomorPopUp())){
            ownerSettingPO.clickOnResendCode();
        } else if (ownerSettingPO.getMessageValidation() == "Tunggu 01.00 menit untuk kirim ulang kode."){
            ownerSettingPO.clickOnConfirmValidation();
        } else if (ownerSettingPO.getMessageValidation() == "Terjadi Galat. Silahkan coba lagi atau tunggu beberapa menit."){
            ownerSettingPO.clickOnConfirmValidation();
        }
    }

    @And("owner fills nama lengkap owner {string}")
    public void ownerFillsNamaLengkapOwner(String text) {
        ownerSettingPO.inputNameOwner(text);
        ownerSettingPO.clickOnSubmitButton();
        playwright.hardWait(2);
    }

    @Then("verify nama lengkap owner")
    public void verifyNamaLengkapOwner() {
        Assert.assertEquals(ownerSettingPO.getUsername(), ownerSettingPO.getNameOwner(), "Username doesn't match!");
    }

    @Then("verify the profile picture is displayed")
    public void verifyTheProfilePictureIsDisplayed() {
        Assert.assertTrue(ownerSettingPO.isProfilePictureDisplayed(), "Profile picture doesn't match!");
    }

    @And("owner uncheck on {string}")
    public void ownerUncheckOn(String textDescription) {
        ownerSettingPO.clickOnPengaturanAkun(textDescription);
    }

    @When("owner check on {string}")
    public void ownerCheckOn(String textDescription) {
        ownerSettingPO.checkPengaturanAkun(textDescription);
    }

    @When("owner delete nama lengkap owner")
    public void ownerDeleteNamaLengkapOwner() {
        ownerSettingPO.clearNamaLengkapOwner();
        Assert.assertTrue(ownerSettingPO.isSimpanDisable(), "Button is enable!");
    }

    @When("user clicks on Owner Settings button")
    public void userClicksOnOwnerSettingsButton() {
        ownerSettingPO.clickOnSettingAccount();
    }
}