package pageobject.admin.testingtools;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import data.mamikos.Mamikos;
import utilities.PlaywrightHelpers;

public class GoldPlusPO {
    private final Page page;
    private final PlaywrightHelpers playwright;
    Locator goldPlusPhoneNumberInput;
    Locator goldPlusResetButton;

    public GoldPlusPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        goldPlusPhoneNumberInput = page.getByPlaceholder("Phone Number").first();
        goldPlusResetButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Reset")).first();
    }

    /**
     * Navigates to Goldplus testing tools page
     */
    public void navigatesToGoldPlusTestingToolsPage() {
        playwright.navigateTo(Mamikos.ADMINMAMIPAY + Mamikos.GOLDPLUS_TESTING_TOOLS);
    }

    /**
     * Input phone number to reset Goldplus
     */
    public void inputGoldplusPhoneNumber(String phoneNumberGP) {
        playwright.fill(goldPlusPhoneNumberInput, phoneNumberGP);
    }

    /**
     * Click on Goldplus reset button
     */
    public void clickOnGoldPlusResetButton() {
        playwright.clickOn(goldPlusResetButton);
    }
}
