package pageobject.owner;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class PromoOwnerPO {
    private Page page;
    private PlaywrightHelpers playwright;
    Locator lihatSelengkapnyaButton;
    Locator aturPromoButton;

    public PromoOwnerPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);

        lihatSelengkapnyaButton = page.getByText("Lihat Selengkapnya").first();
        aturPromoButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Atur Promo"));
    }

    public void clickOnSelengkapnya() {
        playwright.clickOn(lihatSelengkapnyaButton);

    }

    public void clickAturPromo() {
        playwright.clickOn(aturPromoButton);
    }
}
