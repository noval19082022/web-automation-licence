package pageobject.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import data.mamikos.Mamikos;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

import java.util.List;

public class ModalPopUpPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private Locator modalCloseIcon;

    public ModalPopUpPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.modalCloseIcon = page.locator(".bg-c-modal__action-closable");
    }

    /**
     * Clicks on modal close icon
     */
    public void clicksModalCloseIcon() {
        playwright.clickOn(modalCloseIcon);
    }

    /**
     * Wait for check pop up modal visible.
     * @return true if visible otherwise false.
     */
    public Boolean isModalCloseIconVisible() {
        return playwright.waitTillLocatorIsVisible(modalCloseIcon, 3000.0);
    }
}
