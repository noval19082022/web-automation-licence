package steps.mamikos.tenant.profile;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.tenant.profile.TenantEditProfilePO;
import utilities.PlaywrightHelpers;

public class TenantEditProfileSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    TenantEditProfilePO tenantEditProfile = new TenantEditProfilePO(page);
    @When("tenant choose profession as mahasiswa studying at {string}")
    public void tenantChooseProfessionAsStudyAt(String university) {
        tenantEditProfile.clickOnRadioMahasiswa();
        tenantEditProfile.selectUniversity(university);
        tenantEditProfile.clickONSaveButton();
    }

    @Then("tenant success update profile")
    public void tenantSuccessUpdateProfile() throws InterruptedException {
        Assert.assertEquals(tenantEditProfile.getPopUpHeadTitle(), "Profil Disimpan");
        Assert.assertEquals(tenantEditProfile.getPopUpDescriptionContent(), "Kamu telah berhasil menyimpan profil");
        tenantEditProfile.clickOkButton();
    }

    @When("tenant choose profession as karyawan working at {string}")
    public void tenantChooseProfessionAsKaryawanWorkingAt(String company) {
        tenantEditProfile.clickOnRadioKaryawan();
        tenantEditProfile.selectCompany(company);
        tenantEditProfile.clickONSaveButton();
    }

    @Then("user can see {string} on profile page")
    public void user_can_see_x_on_profile_page(String textAlert) {
        Assert.assertEquals(tenantEditProfile.getAlertOnProfile(textAlert),textAlert,"not appears alert on profile");
    }

    @Then("user see button simpan edit profile disable")
    public void user_see_button_simpan_edit_profile_disable () {
        tenantEditProfile.assertSimpanButtonDisable();
    }

    @And("user click dropdown and fills {string} on edit profile")
    public void userClickDropdownAndFillsOnEditProfile(String textSearch) {
        tenantEditProfile.clickOnAndFillDropdown(textSearch);
    }

    @Then("user can see information {string}")
    public void userCanSeeInformation(String messageEmptyData) {
        Assert.assertEquals(tenantEditProfile.getMessageEmptyData(messageEmptyData), messageEmptyData, "message don't natch");
        tenantEditProfile.clickOnClosePopUp();
    }

    @Then("red hint {string} text will show up")
    public void redHintTextWillShowUp(String warningMessage) {
        Assert.assertEquals(tenantEditProfile.getMessageEmptyData(warningMessage), warningMessage, "message don't natch");
        tenantEditProfile.clickOnClosePopUp();
    }

    @And("user click on ubah button on informasi penyewa")
    public void user_click_on_ubah_button_on_informasi_penyewa() {
        tenantEditProfile.clickOnUbahInformasiPenyewa();
    }

    @And("user choose profession {string} on ubah informasi penyewa")
    public void userChooseProfessionOnUbahInformasiPenyewa(String profession) {
        tenantEditProfile.clickOnUbahProfesiToKaryawan(profession);
    }

    @When("user choose pekerjaan {string} from dropdown")
    public void userChoosePekerjaanFromDropdown(String company) {
        tenantEditProfile.selectCompany(company);
        tenantEditProfile.clickONSaveButton();
    }
}
