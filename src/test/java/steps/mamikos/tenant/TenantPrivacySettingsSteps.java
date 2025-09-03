package steps.mamikos.tenant;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.HomePO;
import pageobject.common.LoginPO;
import pageobject.tenant.TenantLoginPO;
import pageobject.tenant.profile.TenantPrivacySettingsPO;
import utilities.PlaywrightHelpers;

public class TenantPrivacySettingsSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    HomePO home = new HomePO(page);
    LoginPO loginPO = new LoginPO(page);
    TenantLoginPO tenantLogin;
    TenantPrivacySettingsPO privacySettings = new TenantPrivacySettingsPO(page);

    
    @When("user login as tenant {string} {string}")
    public void userLoginAsTenant(String phoneNumber, String password) {
        // Click on login button
        loginPO = home.clickOnButtonMasuk();
        
        // Click on pencari kost option
        tenantLogin = loginPO.clickOnPencariKostButton();
        
        // Fill phone number
        tenantLogin.fillPhoneNumber(phoneNumber);
        
        // Fill password
        tenantLogin.fillPassword(password);
        
        // Click login button
        tenantLogin.clickOnLoginButton();
        
        // Wait for login to complete
        playwright.hardWait(3000);
    }
    
    @And("tenant click on icon profil")
    public void tenantClickOnIconProfil() {
        privacySettings.clickOnIconProfile();
        playwright.hardWait(1000);
    }
    
    @And("tenant click on profile")
    public void tenantClickOnProfile() {
        privacySettings.clickOnProfileMenu();
        playwright.hardWait(1000);
    }
    
    @And("tenant click on pengaturan")
    public void tenantClickOnPengaturan() {
        privacySettings.clickOnPengaturanMenu();
        playwright.hardWait(1000);
    }
    
    @And("tenant click on toggle on to off")
    public void tenantClickOnToggleOnToOff() {
        privacySettings.togglePrivacyFromOnToOff();
        playwright.hardWait(1000);
    }
    
    @And("tenant click on lihat preview profil")
    public void tenantClickOnLihatPreviewProfil() {
        privacySettings.clickOnLihatPreviewProfil();
        playwright.hardWait(2000);
    }
}