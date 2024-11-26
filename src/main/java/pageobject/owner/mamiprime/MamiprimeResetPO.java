package pageobject.owner.mamiprime;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class MamiprimeResetPO {

    private PlaywrightHelpers playwright;
    Locator propertyIDInput;
    Locator searchBtn;
    Locator deleteBtn;
    Locator yesBtn;

    public MamiprimeResetPO(Page page) {
        this.playwright = new PlaywrightHelpers(page);
        this.propertyIDInput = page.getByPlaceholder("Listing ID / Song ID");
        this.searchBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Search"));
        this.deleteBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(""));
        this.yesBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Yes"));
    }

    /**
     * Input property ID to reset mamiprime
     */
    public void inputProperyID(String propertyID) {
        playwright.clickLocatorAndTypeKeyboard(propertyIDInput, propertyID);
    }

    public void clickOnSearchBtn() {
        playwright.clickOn(searchBtn);
    }

    public void clickOnDeleteBtn() {
        playwright.clickOn(deleteBtn);
    }

    public void acceptDeletePopUp() {
        playwright.clickOn(yesBtn);
    }
}
