package pageobject.owner.ownersini;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class OwnersiniPO {
    private Page page;
    private PlaywrightHelpers playwright;

    //---Profil Top Right Corner---//
    private Locator skipFtueBtn;
    private Locator profilTopRightCorner;
    private Locator kembaliKeMamikosBtn;

    //---Left Side Menu---//
    private Locator profilPropertiChevron;
    private Locator profilMenu;

    //---Profil Menu Page---//
    private Locator profilPage;
    private Locator facilitySection;
    private Locator kosRulesSection;
    private Locator biayaTambahanSection;
    private Locator informasiTambahanSection;
    private Locator propertyPhoto;

    public OwnersiniPO(Page page){
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        //---Profil Top Right Corner---//
        skipFtueBtn = page.getByTestId("ss-ftue-button-0");
        profilTopRightCorner = page.locator("#profile-trigger");
        kembaliKeMamikosBtn = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Kembali ke Mamikos"));

        //---Left Side Menu---//
        profilPropertiChevron = page.getByText("home-left-side-viewProfil Propertichevron-right").first();
        profilMenu = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Profil"));

        //---Profil Menu Page---//
        profilPage = page.locator("//p[@class='bg-c-text bg-c-text--body-2']");
        facilitySection = page.locator("(//*[@class='mb-4 bg-c-text bg-c-text--title-2'])[6]/following-sibling::*");
        kosRulesSection = page.locator(".property-profile-card__rules");
        biayaTambahanSection = page.locator("(//div[@class='bg-c-grid bg-c-grid--vtop bg-c-grid--left '])[5]//p");
        informasiTambahanSection = page.locator(".property-profile-card__info");
        propertyPhoto = page.locator("//div[@class='bg-c-grid__item bg-is-col-4']");
    }

    /**
     * Clicks Lewati on FTUE Ownersini
     */
    public void dismissFtueOwnersini(){
        playwright.clickOn(skipFtueBtn);
    }

    /**
     * Clicks on Profil on Top Right Corner
     */
    public void clicksTopRightCornerProfil() {
        playwright.clickOn(profilTopRightCorner);
    }

    /**
     * Clicks on Kembali ke Mamikos on Profil
     */
    public void clicksKembaliKeMamikos() {
        playwright.clickOn(kembaliKeMamikosBtn);
    }

    /**
     * Get String URL Owner Dashboard Pillar 2
     * @return String URL Owner Dashboard Pillar 2
     */
    public String getURL() {
        playwright.waitTillPageLoaded();
        return playwright.getPageUrl();
    }

    public void clicksProfilProperti() {
        playwright.clickOn(profilPropertiChevron);
    }

    public void clicksProfilMenu() {
        playwright.clickOn(profilMenu);
    }

    public String getNamaProp() {
        return playwright.getText(profilPage.nth(1));
    }

    public String getAlamat() {
        return playwright.getText(profilPage.nth(2));
    }

    public String getTipeKamar() {
        return playwright.getText(profilPage.nth(3));
    }

    public String getTipeKos() {
        return playwright.getText(profilPage.nth(4));
    }

    public void clicksLocation() {
        playwright.clickOn(profilPage.nth(5));
    }

    public boolean isFasBersamaVisible() {
        return playwright.isLocatorVisibleAfterLoad(facilitySection.nth(1), 10000.0);
    }

    public boolean isFasParkirVisible() {
        return playwright.waitTillLocatorIsVisible(facilitySection.nth(2));
    }

    public boolean isFasDekatKosVisible() {
        return playwright.waitTillLocatorIsVisible(facilitySection.nth(3));
    }

    public boolean isKostRulesVisible() {
        return playwright.waitTillLocatorIsVisible(kosRulesSection);
    }

    public String getBiayaTmbhn1() {
        return playwright.getText(biayaTambahanSection.first());
    }

    public String getBiayaTmbhnPrice1() {
        return playwright.getText(biayaTambahanSection.nth(1));
    }

    public String getBiayaTmbhn2() {
        return playwright.getText(biayaTambahanSection.nth(2));
    }

    public String getBiayaTmbhnPrice2() {
        return playwright.getText(biayaTambahanSection.nth(3));
    }

    public String getBiayaTmbhn3() {
        return playwright.getText(biayaTambahanSection.nth(4));
    }

    public String getBiayaTmbhnPrice3() {
        return playwright.getText(biayaTambahanSection.nth(5));
    }

    public boolean isInfoTambahanVisible() {
        return playwright.isLocatorVisibleAfterLoad(informasiTambahanSection, 10000.0);
    }

    public int getTotalCol() {
        return propertyPhoto.count();
    }

//    public boolean isLihatSemuaVisible(int i) {
//
//    }

//    page.locator("a").filter(new Locator.FilterOptions().setHasText("Om Yudh")).click();
//      page.getByText("Dashboard Singgahsini").click();
//      page.navigate("https://ownersini-jambu.kerupux.com/owner/property-income-report");

}