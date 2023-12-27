package pageobject.owner;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class TenantBackgroundCheckerPO {

    private Page page;
    private PlaywrightHelpers playwright;
    Locator lihatProfilTextButton;
    Locator coachmark;
    Locator titleCoahmark;
    Locator descCochmark;

    public TenantBackgroundCheckerPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        lihatProfilTextButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat Profil"));
        coachmark = page.getByText("Baru: Lihat profil calon penyewa! Bagi pelanggan GoldPlus 2, Anda bisa cek info ");
        titleCoahmark = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Baru: Lihat profil calon penyewa!"));
        descCochmark = page.getByText("Bagi pelanggan GoldPlus 2, Anda bisa cek info dan riwayat pencari kos yang mengh");
    }

    /**
     * Check entry point TBC is visible
     *
     */
    public boolean isLihatProfilDisplayed() {
       return playwright.waitTillLocatorIsVisible(lihatProfilTextButton);
    }

    /**
     * Check coachmark TBC is visible
     *
     */
    public boolean isCoachmarkDisplayed() {
        return playwright.waitTillLocatorIsVisible(coachmark);
    }

    /**
     * get text title at coachmark tbc
     *
     */
    public String getTitleCoachmark(){
        return playwright.getText(titleCoahmark);
    }

    /**
     * get text description at coachmark tbc
     *
     */
    public String getDesCoachmark(){
        return playwright.getText(descCochmark);
    }

}
