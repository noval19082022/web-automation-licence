package steps.mamikos.tenant;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.HomePO;
import pageobject.common.LoadingPO;
import pageobject.tenant.kostSayaPO;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;


public class kostSayaSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    JavaHelpers java = new JavaHelpers();

    HomePO home = new HomePO(page);

    kostSayaPO kostSaya = new kostSayaPO(page);

    LoadingPO loading = new LoadingPO(page);

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
        Assert.assertTrue(kostSaya.getTenantPhoneNum2(), "08*****303.");
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
        loading.waitForLoadingIconDisappear();
        Assert.assertTrue(kostSaya.getTitleKosSayaStillEmpty(), "Kamu belum menyewa kos");
    }

    @When("tenant/user click Lihat informasi kos")
    public void tenantClickLihatInformasiKos() {
        kostSaya.clickLihatInformasiKosButton();
    }

    @Then ("tenant/user will redirect to lihat informasi kos page")
    public void tenantWillredirectToLihatInformasiKosPage() {
        Assert.assertTrue(kostSaya.getTitleInformasiKosText(), "Informasi Kos");
    }

    @And("tenant/user will see {string} on informasi kos")
    public void tenantWillSeeXOnInformasiKos(String text) {
        kostSaya.getFasilitas(text);
    }

    @When("tenant/user click Lihat semua fasilitas button")
    public void tenantClickLihatSemuaFasilitasButton(){
        kostSaya.clickLihatSemuaFasilitasButton();
    }

    @And("tenant clicks on forum menu")
    public void tenantClickOnForumMenu(){
        kostSaya.clickForumMenuButton();
    }

    @Then("tenant will see pop up for upcoming forum")
    public void tenantWillSeePopupForUpcommingForum(){
        kostSaya.getTitleCommingSoonPopup();
    }

    @When("tenant clicks on Oke button")
    public void tenantClicksOnOkeButton(){
        kostSaya.clickOkeButtonUpCoomingPopup();
    }

    @And("tenant tick on checkbox popup upcoming")
    public void tenantTickOnCheckBoxPopupUpcomming(){
        kostSaya.checklistBerlangganan();
    }

    @Then("tenant will see information {string}")
    public void tenantWillSeeInformation(String text){
        kostSaya.getInformationUpComming(text);
    }
}
