package pageobject.owner;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class MamitourPO {
    private Page page;
    private PlaywrightHelpers playwright;

    private Locator pesanSekarangBtn;
    private Locator titleBelumAdaPropertiPopup;
    private Locator subtitleBelumAdaPropertiPopup;
    private Locator pusatBantuan;

    public MamitourPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.pesanSekarangBtn = page.getByTestId("mamitour-landing-header-button");
        this.titleBelumAdaPropertiPopup = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Belum Ada Properti Aktif"));
        this.subtitleBelumAdaPropertiPopup = page.getByText("Tambahkan kos/apartemen terlebih dahulu untuk bisa memesan MamiTour.");
        this.pusatBantuan = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ke Pusat Bantuan"));
    }

    /**
     * click on pesan sekarang in mamitour landing page
     */
    public void clickOnPesanSekarang() {
        playwright.clickOn(pesanSekarangBtn);
    }

    /**
     * get text title on popup belum ada properti aktif
     * @return String
     */
    public String getTitleBelumAdaProperti() {
        return playwright.getText(titleBelumAdaPropertiPopup);
    }

    /**
     * get text subtitle on popup belum ada properti aktif
     * @return String
     */
    public String getSubtitleBelumAdaProperti() {
        return playwright.getText(subtitleBelumAdaPropertiPopup);
    }

    /**
     * click on pusat bantuan on mamitour
     */
    public void clickOnPusatBantuan() {
        playwright.clickOn(pusatBantuan);
    }

    /**
     * Check is it title content is visible
     * @return boolean type, appear true otherwise false
     */
    public boolean isContentOnMamitourVisible(String titleContent) {
        Locator title = page.getByText(titleContent);
        playwright.waitTillLocatorIsVisible(title);
        return playwright.waitTillLocatorIsVisible(title);
    }
}
