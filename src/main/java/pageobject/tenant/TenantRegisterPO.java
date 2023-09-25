package pageobject.tenant;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;

public class TenantRegisterPO {
    private Page page;
    private PlaywrightHelpers playwright;
    Locator passwordInputText;

    public TenantRegisterPO(Page page){
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        passwordInputText = page.locator("//*[@data-testid='passwordTextbox']");

    }

    /**
     * Get Password Input Text
     * @return string
     */
    public String getPasswordInputText(){
        return playwright.getInputValue(passwordInputText);
    }

}
