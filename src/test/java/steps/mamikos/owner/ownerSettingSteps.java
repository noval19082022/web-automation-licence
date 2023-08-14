package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
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
}
