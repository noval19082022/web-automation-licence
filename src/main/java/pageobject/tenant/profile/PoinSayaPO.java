package pageobject.tenant.profile;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class PoinSayaPO {
    Page page;
    PlaywrightHelpers playwright;
    Locator titleDapatkanPoinPage;
    Locator tabPetunjukDapatkanPoinPage;
    Locator tabSyaratDanKetentuanDapatkanPoinPage;
    Locator linkPusatBantuanDapatkanPoinPage;
    Locator dapatkanPoinHeadline;
    Locator dapatkanPoinSubtitle;
    Locator navHeader;
    Locator entryPointTenantMamipoin;
    Locator getMamipoinTenant;
    Locator titleMamipoinLandingPage;
    Locator informasiPoinButton;
    Locator riwayatPoinButton;
    Locator dapatkanPoinButton;
    Locator expiredPoinInfo;
    Locator noHaveMamipoinText;
    Locator titleInformasiPoinPage;
    Locator subtitleInformasiPoinPage;
    Locator lihatCaranyaButon;
    Locator tableTitleTanggalKedaluwarsa;
    Locator tableTitleJumlahMamipoin;
    Locator fieldValueTable;
    Locator subtitleTidakAdaPoinYangTersedia;

    public PoinSayaPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        titleDapatkanPoinPage = page.getByText("Dapatkan Poin");
        tabPetunjukDapatkanPoinPage = page.getByText("Petunjuk");
        tabSyaratDanKetentuanDapatkanPoinPage = page.locator("#contentBox").getByText("Syarat dan Ketentuan");
        linkPusatBantuanDapatkanPoinPage = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Pusat Bantuan"));
        dapatkanPoinHeadline = page.getByText("Cara Mudah Mendapatkan MamiPoin");
        dapatkanPoinSubtitle = page.getByText("Kamu bisa mengumpulkan MamiPoin dengan melakukan aktivitas-aktivitas berikut.");
        navHeader = page.locator(".nav-section");
        entryPointTenantMamipoin = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Poin Saya Baru"));
        titleMamipoinLandingPage = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("MamiPoin").setExact(true));
        informasiPoinButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Lihat Informasi Poin"));
        riwayatPoinButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Lihat Semua")).first();
        dapatkanPoinButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Lihat Semua")).nth(1);
        expiredPoinInfo = page.locator(".card__info-poin");
        noHaveMamipoinText = page.getByText("Poin kamu masih 0. Yuk, bayar dulu dan dapatkan poinnya.");
        titleInformasiPoinPage = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Tanggal Kedaluwarsa")).first();
        subtitleInformasiPoinPage = page.getByText("Poin Kamu akan kedaluwarsa dalam waktu 6 bulan dari saat Kamu mendapatkan poin.");
        lihatCaranyaButon = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Lihat Caranya"));
        tableTitleTanggalKedaluwarsa = page.locator("//h1[@class='table-title'][text()='Tanggal Kedaluwarsa']");
        tableTitleJumlahMamipoin = page.locator("//h1[@class='table-title-right'][text()='Jumlah MamiPoin']");
        subtitleTidakAdaPoinYangTersedia = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Tidak Ada Poin yang Tersedia"));
    }

    /**
     * Verify title in the dapatkan poin page is displayed
     * @return boolean
     */
    public Boolean isTitleInTheDapatkanPoinPageDisplayed() {
        return playwright.waitTillLocatorIsVisible(titleDapatkanPoinPage);
    }

    /**
     * Verify tab petunjuk in the dapatkan poin page is displayed
     * @return boolean
     */
    public Boolean isTabPetunjukInTheDapatkanPoinPageDisplayed() {
        return playwright.waitTillLocatorIsVisible(tabPetunjukDapatkanPoinPage);
    }

    /**
     * Verify tab syarat dan ketentuan in the dapatkan poin page is displayed
     * @return boolean
     */
    public Boolean isTabSyaratDanKetentuanInTheDapatkanPoinPageDisplayed() {
        return playwright.waitTillLocatorIsVisible(tabSyaratDanKetentuanDapatkanPoinPage);
    }

    /**
     * Verify link pusat bantuan in the dapatkan poin page is displayed
     * @return boolean
     */
    public Boolean isLinkPusatBantuanInTheDapatkanPoinPageDisplayed()  {
        return playwright.waitTillLocatorIsVisible(linkPusatBantuanDapatkanPoinPage);
    }

    /**
     * Get Dapatkan Point Headline Text
     * @return text
     */
    public String getDapatkanPointHeadline() {
        return playwright.getText(dapatkanPoinHeadline);
    }

    /**
     * Get Dapatkan Point Subtitle Text
     * @return text
     */
    public String getDapatkanPoinSubtitle() {
        return playwright.getText(dapatkanPoinSubtitle).replace("\n","");
    }

    /**
     * Is Footer On Dapatkan Poin Page Appear?
     * @return true or false
     */
    public Boolean isFooterOnDapatkanPoinAppear() {
        return playwright.waitTillLocatorIsVisible(titleDapatkanPoinPage) ;
    }

    /**
     * Get Header Element Attribute
     * @return string
     */
    public String getHeaderElementAttribute(){
        return playwright.getAttributeValue(navHeader, "class");
    }

    /**
     * Click on Syarat dan Ketentuan Tab
     */
    public void clickOnSyaratDanKetentuanTab() {
        playwright.clickOn(tabSyaratDanKetentuanDapatkanPoinPage);
    }

    /**
     * Get Syarat dan Ketentuan Tab Text
     * @return string
     */
    public String getSyaratDanKetentuanTabText(){
        return playwright.getText(tabSyaratDanKetentuanDapatkanPoinPage);
    }

    /**
     * Get Syarat dan Ketentuan Attribute
     * @return string
     */
    public String getSyaratDanKetentuanAttribute() {
        return playwright.getAttributeValue(tabSyaratDanKetentuanDapatkanPoinPage, "class");
    }

    /**
     * Click link on pusat bantuan
     */
    public void clickLinkOnPusatBantuan() {
        playwright.clickOn(linkPusatBantuanDapatkanPoinPage);
    }

    /**
     * Verify mamipoin tenant entry point is not displayed
     * @return boolean
     */
    public Boolean isMamipoinTenantEntryPointNotDisplayed() {
        return playwright.waitTillLocatorIsVisible(entryPointTenantMamipoin);
    }

    /**
     * Verify the amount of poin owned by the tenant
     * @param poin
     * @return amount of poin
     */
    public String verifyAmountOfPoinOwnedByTenant(String poin) {
        getMamipoinTenant = page.locator("//*[@href='/user/mamipoin']//span[contains(text(),'" + poin + "')]");
        return playwright.getText(getMamipoinTenant);
    }

    /**
     * Click on Entry Point Tenant Mamipoin
     */
    public void clickOnEntryPointTenantMamipoin() {
        playwright.clickOn(entryPointTenantMamipoin);
    }

    /**
     * Verify title in the mamipoin tenant landing page is displayed
     * @return boolean
     */
    public Boolean isTitleInTheMamipoinTenantLandingPageDisplayed() {
        return playwright.waitTillLocatorIsVisible(titleMamipoinLandingPage);
    }

    /**
     * Verify informasi poin button is displayed
     * @return boolean
     */
    public Boolean isInformasiPoinButtonDisplayed() {
        return playwright.waitTillLocatorIsVisible(informasiPoinButton);
    }

    /**
     * Verify riwayat poin button is displayed
     * @return boolean
     */
    public Boolean isRiwayatPoinButtonDisplayed() {
        return playwright.waitTillLocatorIsVisible(riwayatPoinButton);
    }

    /**
     * Verify dapatkan poin button is displayed
     * @return boolean
     */
    public Boolean isDapatkanPoinButtonDisplayed() {
        return playwright.waitTillLocatorIsVisible(dapatkanPoinButton);
    }

    /**
     * Get Expired Point Information on Mamipoin Landing Page
     * @return String
     */
    public String getTextExpiredPointInfoOnLandingPage() {
        return playwright.getText(expiredPoinInfo);
    }

    /**
     * Get Text No Have Mamipoin
     * @return string
     */
    public String getTextNoHaveMamipoin() {
        return playwright.getText(noHaveMamipoinText);
    }

    /**
     * Verify title in the informasi poin page is displayed
     * @return boolean
     */
    public Boolean isTitleInTheInformasiPoinPageDisplayed() {
        return playwright.waitTillLocatorIsVisible(titleInformasiPoinPage);
    }

    /**
     * Verify subtitle in the informasi poin page is displayed
     * @return boolean
     */
    public Boolean isSubtitleInTheInformasiPoinPageDisplayed() {
        return playwright.waitTillLocatorIsVisible(subtitleInformasiPoinPage);
    }

    /**
     * Click on lihat caranya button
     */
    public void clickOnLihatCaranyaButton() {
        playwright.clickOn(lihatCaranyaButon);
    }

    /**
     * Verify table title tanggal kedaluwarsa is displayed
     * @return boolean
     */
    public Boolean isTableTitleTanggalKedaluwarsaDisplayed() {
        return playwright.waitTillLocatorIsVisible(tableTitleTanggalKedaluwarsa);
    }

    /**
     * Verify table title jumlah mamipoin is displayed
     * @return boolean
     */
    public Boolean isTableTitleJumlahMamipoinDisplayed() {
        return playwright.waitTillLocatorIsVisible(tableTitleJumlahMamipoin);
    }

    /**
     * check expired date is visible or not
     * @param fieldValue refer to table contents
     */
    public void isFieldValueVisible(String fieldValue) {
        fieldValueTable = page.locator("//div[text()='" + fieldValue + "']");
        assertThat(fieldValueTable).isVisible();
    }

    /**
     * Verify subtitle tidak ada poin yang tersedia is displayed
     * @return boolean
     */
    public Boolean isSubtitleTidakAdaPoinYangTersediaDisplayed() {
        return playwright.waitTillLocatorIsVisible(subtitleTidakAdaPoinYangTersedia);
    }
}
