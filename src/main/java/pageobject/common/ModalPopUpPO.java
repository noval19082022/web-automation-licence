package pageobject.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;

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
