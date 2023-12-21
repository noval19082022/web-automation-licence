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
    Locator gantiPaketTextButton;
    Locator sayaMengertiButton;
    Locator backButton;
    Locator beliPaketButton;
    Locator kostNotActiveInformation;
    Locator gp2TBCInformation;

    public TenantBackgroundCheckerPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        lihatProfilTextButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat Profil"));
        coachmark = page.getByText("Baru: Lihat profil calon penyewa! Bagi pelanggan GoldPlus 2, Anda bisa cek info ");
        titleCoahmark = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Baru: Lihat profil calon penyewa!"));
        descCochmark = page.getByText("Bagi pelanggan GoldPlus 2, Anda bisa cek info dan riwayat pencari kos yang mengh");
        gantiPaketTextButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ganti Paket"));
        sayaMengertiButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Saya Mengerti"));
        backButton = page.getByTestId("back-button");
        beliPaketButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Beli Paket"));
        kostNotActiveInformation = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Anda belum memiliki kos aktif"));
        gp2TBCInformation = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Fitur ini khusus pengguna GoldPlus 2"));
    }

    /**
     * Check if Lihat Profil displayed
     *
     * @return true if displayed
     */
    public boolean isLihatProfilDisplayed() {
       return playwright.waitTillLocatorIsVisible(lihatProfilTextButton);
    }

    /**
     * Check if coachmark displayed
     *
     * @return true if displayed
     */
    public boolean isCoachmarkDisplayed() {
        return playwright.waitTillLocatorIsVisible(coachmark);
    }

    /**
     * Get text on Title Coachmark
     *
     * @return text title
     */
    public String getTitleCoachmark(){
        return playwright.getText(titleCoahmark);
    }

    /**
     * Get text on Description Coachmark
     *
     * @return text description
     */
    public String getDesCoachmark(){
        return playwright.getText(descCochmark);
    }

    /**
     * Click on Lihat Profil text button
     */
    public void clickOnLihatProfil(){
        playwright.clickOn(lihatProfilTextButton);
    }

    /**
     * Click on Back TBC page button
     */
    public void clickOnBack(){
        playwright.clickOn(backButton);
    }

    /**
     * Get text on button Beli Paket
     *
     * @return text button
     */
    public String getTextBeliPaket(){
        return playwright.getText(beliPaketButton);
    }

    /**
     * Click on Beli Paket TBC page button
     */
    public void clickOnBeliPaket(){
        playwright.clickOn(beliPaketButton);
    }

    /**
     * Check if information Kost Not Active displayed
     *
     * @return true if displayed
     */
    public Boolean isInfoKostNotActiveDisplayed() {
        return playwright.waitTillLocatorIsVisible(kostNotActiveInformation);
    }

    /**
     * Check if information GP2 TBC displayed
     *
     * @return true if displayed
     */
    public Boolean isInfoTBCPageDisplayed() {
        return playwright.waitTillLocatorIsVisible(gp2TBCInformation);
    }
}
