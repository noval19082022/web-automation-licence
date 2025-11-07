package pageobject.owner.kos;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import utilities.PlaywrightHelpers;

public class CreateKosPO {
    private final PlaywrightHelpers playwright;

    Locator tambahKosBaruButton;
    Locator ctaButtonExposeSinggahsini;
    Page page;

    public CreateKosPO(Page page) {
        this.playwright = new PlaywrightHelpers(page);
        this.page = page;
        tambahKosBaruButton = page.getByText("Tambah Kos Baru");
        ctaButtonExposeSinggahsini = page.getByText("Mau Kos Anda diurus Mamikos? Cek disini");
    }

    public void clickOnTambahKosBaruButton() {
        playwright.waitTillLocatorIsVisible(tambahKosBaruButton);
        playwright.waitFor(tambahKosBaruButton, 3000.0);
        playwright.clickOn(tambahKosBaruButton);
    }

    public String getCtaButtonExposeSinggahsiniText() {
        playwright.waitTillLocatorIsVisible(ctaButtonExposeSinggahsini);
        return playwright.getText(ctaButtonExposeSinggahsini);
    }

    public void clickCtaButtonExposeSinggahsini() {
        playwright.waitTillLocatorIsVisible(ctaButtonExposeSinggahsini);
        playwright.waitFor(ctaButtonExposeSinggahsini, 3000.0);
        Page newTab = page.waitForPopup(() -> {
            playwright.clickOn(ctaButtonExposeSinggahsini);
        });
        newTab.waitForLoadState();
        ActiveContext.setActivePage(newTab);
    }

    public String getCurrentUrl() {
        Page activePage = ActiveContext.getActivePage();
        return activePage.url();
    }
}
