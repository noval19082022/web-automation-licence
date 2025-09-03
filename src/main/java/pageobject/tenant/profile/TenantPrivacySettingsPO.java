package pageobject.tenant.profile;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class TenantPrivacySettingsPO {
    private Page page;
    private Locator iconProfile;
    private Locator profileMenu;
    private Locator pengaturanMenu;
    private Locator privacyToggle;
    private Locator lihatPreviewProfilButton;
    
    public TenantPrivacySettingsPO(Page page) {
        this.page = page;
        this.iconProfile = page.getByRole(AriaRole.BUTTON, 
                new Page.GetByRoleOptions().setName("User Photo"));
        this.profileMenu = page.getByText("Profil");
        this.pengaturanMenu = page.getByText("Pengaturan");
        this.privacyToggle = page.getByTestId("switchPrivacy-personal_information_status");
        this.lihatPreviewProfilButton = page.getByText("Lihat Preview Profil");
    }

    /**
     * Click on User Photo profile button (based on actual website inspection)
     */
    public void clickOnIconProfile() {
        iconProfile.click();
    }

    /**
     * Click on "Profil" menu item from dropdown (based on actual website inspection)
     */
    public void clickOnProfileMenu() {
        profileMenu.click();
    }

    /**
     * Click on Pengaturan (Settings) menu
     */
    public void clickOnPengaturanMenu() {
        try {
            pengaturanMenu.click();
        } catch (Exception e) {
            pengaturanMenu.click();
        }
    }

    /**
     * Toggle privacy setting from on to off - target enabled checkbox (Informasi data diri)
     */
    public void togglePrivacyFromOnToOff() {
        privacyToggle.click();
    }

    /**
     * Click on "Lihat Preview Profil" button
     */
    public void clickOnLihatPreviewProfil() {
        lihatPreviewProfilButton.click();
    }

}