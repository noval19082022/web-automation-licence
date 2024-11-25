package pageobject.owner.mamiprime;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.PlaywrightHelpers;

public class MamiprimePeriodePO {
    private Page page;
    private PlaywrightHelpers playwright;

    public MamiprimePeriodePO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
    }

    /**
     * Verify periode prime
     *
     * @param periode return periode
     */
    public String getPeriodPrime(String periode) {
        Locator periodeResult = page.getByText(periode).first();
        return playwright.getText(periodeResult);
    }

    /**
     * Verify price at periode prime
     *
     * @param pricePrime return price peride
     */
    public String getPricePeriod(String pricePrime) {
        Locator pricePrimeResult = page.getByText(pricePrime).first();
        return playwright.getText(pricePrimeResult);
    }

    /**
     * Click on periode selected
     */
    public void clickOnPeriodePrime(String pricePrime) {
        Locator pricePrimeResult = page.getByText(pricePrime);
        playwright.waitFor(pricePrimeResult);
        playwright.clickOn(pricePrimeResult);
    }

}