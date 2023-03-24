package pageobject.common.apartment;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class ApartmentDetailPO {
    Page page;
    PlaywrightHelpers playwright;
    private Locator contactApartmentButton;

    public ApartmentDetailPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        contactApartmentButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hubungi Pengelola"));
    }

    /**
     * Click on Hubungi Pengelola Apartnent
     */
    public void clickContactApt() {
        playwright.clickOn(contactApartmentButton);
    }
}
