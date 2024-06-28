package pageobject.owner.mamiprime;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;

public class MamiprimeResetPO {

    private Page page;
    private PlaywrightHelpers playwright;
    Locator propertyIDInput;

    public MamiprimeResetPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.propertyIDInput = page.locator("//input[@name='room_type_id']");
    }

    /**
     * Input property ID to reset mamiprime
     *
     */
    public void inputProperyID(String propertyID) {
        propertyIDInput.fill(propertyID);
    }

}
