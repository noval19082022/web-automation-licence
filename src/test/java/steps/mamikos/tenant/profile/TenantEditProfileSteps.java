package steps.mamikos.tenant.profile;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
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
}
