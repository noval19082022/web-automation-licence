package pageobject.harvest.harvestDashboard;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class RoleManagementPO {
    private Page page;
    private PlaywrightHelpers playwright;

    private Locator roleManagementMenu;
    private Locator tambahRoleButton;
    private Locator namaRoleText;
    private Locator searchByDropdown;
    private Locator searchByValue;
    private Locator searchMemberText;
    private Locator suggestionMemberText;

    public RoleManagementPO(Page page){
        this.page = page;
        playwright = new PlaywrightHelpers(page);

        roleManagementMenu = page.locator(".nav-sidebar__list-item").nth(5);
        tambahRoleButton = page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Tambah Role"));
        namaRoleText = page.getByPlaceholder("Input Nama Role");
        searchMemberText = page.getByPlaceholder("Cari");
        searchByDropdown = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Nama Lengkap dropdown-down"));
        searchByValue = page.locator("a").filter(new Locator.FilterOptions().setHasText("Nama Lengkap"));
    }

    /**
     * click menu Role Management
     */
    public void clickRoleManagementMenu() {
        playwright.clickOn(roleManagementMenu);
    }

    /**
     * click on Tambah Role Button
     */
    public void clickTambahRoleButton() {
        playwright.clickOn(tambahRoleButton);
    }

    /**
     * fill nama role
     * @param roleName
     */
    public void fillNamaRole(String roleName) {
        playwright.fill(namaRoleText,roleName);
    }

    /**
     * fill member name, char by char
     * @param memberName
     */
    public void fillMemberName(String memberName) {
        playwright.clearText(searchMemberText);
        playwright.fillCharacterByCharacter(searchMemberText,memberName,500.0);
    }

    /**
     * Check suggestion member exist
     * @param suggestion
     * @return
     */
    public boolean isSuggestionVisible(String suggestion) {
        suggestionMemberText = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(suggestion));

        return playwright.isLocatorVisibleAfterLoad(suggestionMemberText,10000.0);
    }

    /**
     * change search by in tambah role
     * @param value
     */
    public void searchBy(String value) {
        searchByValue = page.locator("a").filter(new Locator.FilterOptions().setHasText(value));

        playwright.clickOn(searchByDropdown);
        playwright.clickOn(searchByValue);
    }
}
