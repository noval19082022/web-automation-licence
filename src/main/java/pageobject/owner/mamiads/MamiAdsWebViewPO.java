package pageobject.owner.mamiads;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import data.mamikos.Mamikos;
import utilities.PlaywrightHelpers;

public class MamiAdsWebViewPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private Locator cobaSekarangBtn;

    public MamiAdsWebViewPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.cobaSekarangBtn = playwright.locatorByRoleAndText(AriaRole.BUTTON, "Coba Sekarang").first();
    }

    /**
     * this method is use for if owner redirect to mamiads webview
     * example page is 'https://jambu.kerupux.com/mamiads?redirectionSource=Owner%20Dashboard'
     */
    public void handleRedirectToMamiadsWebview() {
        // this condition will handle if owner redirect to the https://jambu.kerupux.com/mamiads?redirectionSource=Owner%20Dashboard
        if (playwright.getActivePageURL().equals(Mamikos.URL + "/mamiads?redirectionSource=Owner%20Dashboard") ||
                playwright.waitTillLocatorIsVisible(cobaSekarangBtn)) {
            playwright.clickOn(cobaSekarangBtn);
        }
    }
}
