package pageobject.owner;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;

public class PromoOwnerPO {
    private Page page;
    private PlaywrightHelpers playwright;
    Locator lihatSelengkapnyaButton;

    public PromoOwnerPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);

        lihatSelengkapnyaButton = page.getByText("Lihat Selengkapnya").first();
    }

    /**
     * Click selengkapnya button on kost list on property saya kos
     *
     *
     */
    public void clickOnSelengkapnya() {
        playwright.clickOn(lihatSelengkapnyaButton);

    }
}
