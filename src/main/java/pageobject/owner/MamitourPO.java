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
        this.titleBelumAdaPropertiPopup = page.locator("//div[@data-testid='popup-property-available']//h3");
        this.subtitleBelumAdaPropertiPopup = page.locator("//div[@data-testid='popup-property-available']//p");
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
}
