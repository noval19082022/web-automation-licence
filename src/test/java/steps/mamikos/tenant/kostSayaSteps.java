package steps.mamikos.tenant;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.common.HomePO;
import pageobject.tenant.kostSayaPO;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;


public class kostSayaSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    JavaHelpers java = new JavaHelpers();

    HomePO home = new HomePO(page);

    kostSayaPO kostSaya = new kostSayaPO(page);


    @And("user click on masukkan kode dari pemilik button")
    public void userClickOnInputCode() {
        kostSaya.clickOnInputCodeButton();
    }

    @And("user input valid unique code {string} and click Kirim Kode unik button")
    public void userInputCodeAndClickSendButton(String code) {
        kostSaya.userInputCodeAndClickSendButton(code);
    }

    @Then("user check verification tenant phone number at owner and tenant phone number at kos saya")
    public void userCanSeeActivitiesInMyKos() {
        Assert.assertTrue(kostSaya.getTitleVerification(), "Verifikasi nomor HP");
        Assert.assertTrue(kostSaya.getTenantPhoneNum1(), "08*******714");
        Assert.assertTrue(kostSaya.getTenantPhoneNum2(), "08*******303.");
        Assert.assertTrue(kostSaya.getAlertVerif(), "Setelah verifikasi berhasil, kamu akan menggunakan nomor 08*******714 di profilmu.");
        Assert.assertTrue(kostSaya.getOtpWording(), "Kirim OTP ke 08*******714");
    }

    @And("user click on kirim OTP button")
    public void userClickOnSendOtpButton() {
        kostSaya.clickOnSendOtpButton();
    }

    @And("user click on verification via SMS")
    public void userClickOnVerificationViaSms() {
        kostSaya.clickOnVerificationViaSms();
    }
    @And("user click All Back button until first page")
    public void userClickOnAllBackUntilFirstPage() {
        kostSaya.clickOnBackUntilFirstPage();
    }
    @Then("user will see kos saya is still empty")
    public void userWillSeeKosSayaIsStillEmpty() {
        Assert.assertTrue(kostSaya.getTitleKosSayaStillEmpty(), "Kamu belum menyewa kos");
    }
}
