package pageobject.owner;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class GoldplusPO {
    private Page page;
    private PlaywrightHelpers playwright;
    Locator broadcastChatBtn;
    Locator warningBroadcastText;
    Locator closePopUpIcon;
    Locator goldplusPhoneNumberInput;

    public GoldplusPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        broadcastChatBtn = page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText("'broadcast-message'"));
        warningBroadcastText = page.locator("//h3[@class='bg-c-modal__body-title']");
        closePopUpIcon = page.locator(".bg-c-modal__action-closable");
        goldplusPhoneNumberInput = page.locator("form").filter(new Locator.FilterOptions().setHasText("Reset")).getByPlaceholder("Phone Number");
    }

    /**
     * Input phone number to reset Goldplus
     */
    public void inputGoldplusPhoneNumber (String phoneNumberGP) {
        goldplusPhoneNumberInput.fill(phoneNumberGP);
    }

}
