package pageobject.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HeaderPO {
    private Page page;
    private Locator btnMasuk;
    public HeaderPO(Page page) {
        this.page = page;
        this.btnMasuk = page.getByTestId("entryButton");
    }

    public LoginPO clickOnButtonMasuk() {
        btnMasuk.click();
        return new LoginPO(page);
    }
}
