package pageobject.owner.mamiprime;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;

public class MamiprimeDetailTagihanPO {
    private PlaywrightHelpers playwright;
    Locator bayarSekarangBtnOnDetailTagihan;
    Locator propertyNameText;

    public MamiprimeDetailTagihanPO(Page page) {
        this.playwright = new PlaywrightHelpers(page);
        this.bayarSekarangBtnOnDetailTagihan = page.getByTestId("primeButtonPay");
        this.propertyNameText = page.locator(".bg-u-mt-xxs");
    }

    /**
     * Verify property name at detail tagihan mamiprime
     *
     * @return "Kos Greenpeace Denpasar Barat Denpasar"
     */
    public String getPropertyNameDetailTagihanMamiprime() {
        return playwright.getText(propertyNameText);
    }

    /**
     * Click on bayar sekarang button and wait until page loaded
     */
    public void clicksOnBayarSekarangButton() {
        playwright.clickOn(bayarSekarangBtnOnDetailTagihan);
        playwright.waitTillPageLoaded();
    }
}
