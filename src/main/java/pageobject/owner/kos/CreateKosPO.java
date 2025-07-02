package pageobject.owner.kos;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;

public class CreateKosPO {
    private final PlaywrightHelpers playwright;

    Locator tambahKosBaruButton;

    public CreateKosPO(Page page) {
        this.playwright = new PlaywrightHelpers(page);
        tambahKosBaruButton = page.getByText("Tambah Kos Baru");
    }

    public void clickOnTambahKosBaruButton() {
        playwright.waitTillLocatorIsVisible(tambahKosBaruButton);
        playwright.waitFor(tambahKosBaruButton, 3000.0);
        playwright.clickOn(tambahKosBaruButton);
    }
}
