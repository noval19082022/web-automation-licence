package pageobject.owner;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;

public class UpdatePricePO {
    private Page page;
    private PlaywrightHelpers playwright;
    Locator noProperty;

    public UpdatePricePO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
    }
}