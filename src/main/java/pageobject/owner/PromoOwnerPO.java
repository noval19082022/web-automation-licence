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

    /**
     * Click selengkapnya button on kost list on property saya kos
     *
     *
     */
    public void clickOnSelengkapnya() {
        playwright.clickOn(lihatSelengkapnyaButton);

    }

    /**
     * Click atur promo owner from property saya -> kos -> selengkapnya
     *
     *
     */
    public void clickAturPromo() {
        playwright.clickOn(aturPromoButton);
    }
}
