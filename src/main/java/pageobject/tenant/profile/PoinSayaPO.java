package pageobject.tenant.profile;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

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
}
