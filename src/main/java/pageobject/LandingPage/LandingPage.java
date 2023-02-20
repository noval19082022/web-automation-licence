package pageobject.LandingPage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

import java.util.List;

public class LandingPage {
    private Page page;
    private PlaywrightHelpers playwright;
    Locator dikelolaMamikosButton;
    Locator dikelolaMamikosLabel;


    public LandingPage(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        dikelolaMamikosButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Dikelola Mamikos"));
        dikelolaMamikosLabel = page.getByTestId("roomCardCover-brandIcon").first();


    }

    /**
     * Click on filter Mamirooms button
     * @throws InterruptedException
     */

    public void clickFilterDikelolaMamikos() throws InterruptedException {
        playwright.clickOn(dikelolaMamikosButton);
    }

    /**
     * Check if Singgahsini/Apik label is present
     * @return displayed true, otherwise false
     */
    public boolean isDikelolaMamikosDisplayed() throws InterruptedException {
        return playwright.isLocatorVisibleAfterLoad(dikelolaMamikosLabel, 2000.0);
    }



}
