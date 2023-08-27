package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import config.playwright.context.ActiveContext;
import utilities.PlaywrightHelpers;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class KostOwnerPO {
    private Page page;
    PlaywrightHelpers playwright;
    Locator kosNameSearch;
    Locator firstBBKDataButton;
    Locator firstRejectButton;
    Locator firstRejectReasonRadioButton;
    Locator rejectButton;
    Locator firstVerifyButton;

    public KostOwnerPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        kosNameSearch = page.getByPlaceholder("Nama Kost", new Page.GetByPlaceholderOptions().setExact(true));
        firstBBKDataButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("BBK Data"));
        firstRejectButton = page.locator("//a[contains(.,'Edit Kost')]");
        firstRejectReasonRadioButton = page.locator("//div[@class='iradio_minimal']");
        rejectButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Reject").setExact(true));
        firstVerifyButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("").setExact(true));
    }

    /**
     * Search kos name then hit enter
     * @param kosName of Kos Name
     */
    public void searchKosName(String kosName) {
        kosNameSearch.fill(kosName);
        page.keyboard().press("Enter");
    }

    /**
     * Click on first BBK Data button
     */
    public void clickOnFirstBBKDataButton() {
        page = page.waitForPopup(() -> {
            playwright.clickOn(firstBBKDataButton);
        });
    }

    /**
     * Click on first Reject BBK button
     */
    public void clickOnFirstRejectButton() {
        playwright.hardWait(2000.0);
        page = ActiveContext.getActivePage();
        firstRejectButton.click();
    }

    /**
     * Click on first radio button
     */
    public void clickOnFirstRadioButton() {
        playwright.pageScrollUntilElementIsVisible(firstRejectReasonRadioButton);
        playwright.clickOn(firstRejectReasonRadioButton);
    }

    /**
     * Click on Reject BBK button
     */
    public void clickOnRejectButton() {
        playwright.clickOn(rejectButton);
    }

    /**
     * Click on first verify button
     */
    public void clickOnFirstVerifyButton() {
        playwright.clickOn(firstVerifyButton);
    }
}
