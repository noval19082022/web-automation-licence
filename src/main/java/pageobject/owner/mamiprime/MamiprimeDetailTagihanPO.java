package pageobject.owner.mamiprime;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class MamiprimeDetailTagihanPO {
    private Page page;
    private PlaywrightHelpers playwright;
    Locator bayarSekarangBtnOnDetailTagihan;
    Locator propertyNameText;

    public MamiprimeDetailTagihanPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.bayarSekarangBtnOnDetailTagihan = playwright.locatorByRoleAndText(AriaRole.BUTTON, "Bayar Sekarang");
        this.propertyNameText = page.locator(".bg-u-mt-xxs");
    }

    /**
     * Verify property name at detail tagihan mamiprime
     * @return "Kos Greenpeace Denpasar Barat Denpasar"
     */
    public String getPropertyNameDetailTagihanMamiprime() {
        return playwright.getText(propertyNameText);
    }

}
