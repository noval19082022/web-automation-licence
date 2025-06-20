package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class PropertyManagementPO {
    Page page;
    PlaywrightHelpers playwrightHelpers;
    private Locator propertyManagementMenu;
    private Locator propertyMenu;
    private Locator searchPropertyNamePlaceHolder;
    private Locator searchBtn;
    private Locator quickAllocationCheckBox;
    private Locator acceptDeactiveQuickAllocationBtn;

    public PropertyManagementPO(Page page) {
        this.page = page;
        this.playwrightHelpers = new PlaywrightHelpers(page);
        this.propertyManagementMenu = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Property Management"));
        this.propertyMenu = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Property").setExact(true));
        this.searchPropertyNamePlaceHolder = page.getByPlaceholder("Nama Property");
        this.searchBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Search"));
        this.quickAllocationCheckBox = page.getByRole(AriaRole.CHECKBOX).first();
        this.acceptDeactiveQuickAllocationBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ya, Nonaktifkan"));
    }

    /**
     * open up Property Management menu on left side bangkerupux admin
     */
    public void openUpPropertyManagementMenu() {
        playwrightHelpers.clickOn(propertyManagementMenu);
    }

    /**
     * click On Property menu after open up property management menu
     */
    public void clickOnPropertyMenu() {
        playwrightHelpers.clickOn(propertyMenu);
    }

    /**
     * search property name
     *
     * @param propertyName
     */
    public void searchPropertyName(String propertyName) {
        playwrightHelpers.clickLocatorAndTypeKeyboard(searchPropertyNamePlaceHolder, propertyName);
        playwrightHelpers.clickOn(searchBtn);
    }

    public void deactivateQuickAllocationIfActive() {
        if (playwrightHelpers.isRadioButtonChecked(quickAllocationCheckBox)) {
            playwrightHelpers.uncheckBox(quickAllocationCheckBox);
            playwrightHelpers.clickOn(acceptDeactiveQuickAllocationBtn);
        }
        playwrightHelpers.reloadPage();
    }
}
