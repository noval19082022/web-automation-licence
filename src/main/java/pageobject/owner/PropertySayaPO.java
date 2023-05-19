package pageobject.owner;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class PropertySayaPO {
    private Page page;
    private PlaywrightHelpers playwright;
    Locator kostDropdown;
    Locator searchKostTextbox;
    Locator lihatSelengkapnyaButton;
    Locator updateKamarButton;
    Locator editAction;
    Locator updateKamarCheckbox;
    Locator updateKamarButtonPopup;

    public PropertySayaPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        kostDropdown = page.getByText("Cari kos Anda disini...");
        searchKostTextbox = page.getByPlaceholder("Search");
        lihatSelengkapnyaButton = page.getByText("Lihat Selengkapnya").first();
        updateKamarButton = page.getByText("Update Kamar", new Page.GetByTextOptions().setExact(true));
        editAction = page.locator("(//*[@class='room-table__cta bg-c-icon bg-c-icon--md'])[1]");
        updateKamarCheckbox = page.locator(".check");
        updateKamarButtonPopup = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Update Kamar"));
    }

    /**
     * user as owner click kost dropdown
     * user enter kost name
     * user choose kost name
     */
    public void searchKostPropertySaya(String kostName){
        playwright.clickOn(kostDropdown);
        searchKostTextbox.fill(kostName);
        Locator kostSearch = page.locator("a").filter(new Locator.FilterOptions().setHasText(kostName));
        playwright.clickOn(kostSearch);
    }

    /**
     * user as owner click update kamar button
     *
     */
    public void clickUpdateKamarButton() {
        playwright.clickOn(lihatSelengkapnyaButton);
        playwright.clickOn(updateKamarButton);
    }

    /**
     * user as owner click update kamar kost button
     *
     */
    public void clickUpdateKamarEmptyButton() {
        playwright.clickOn(editAction);
        playwright.clickOn(updateKamarCheckbox);
        playwright.clickOn(updateKamarButtonPopup);
    }


}
