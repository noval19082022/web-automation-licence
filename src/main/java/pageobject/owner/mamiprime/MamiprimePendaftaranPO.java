package pageobject.owner.mamiprime;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import data.mamikos.Mamikos;
import utilities.PlaywrightHelpers;

public class MamiprimePendaftaranPO {

    private Page page;
    private PlaywrightHelpers playwright;
    Locator nonGPInformationText;
    Locator labelPropertyFull;
    Locator propertyNamePrime;

    public MamiprimePendaftaranPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.nonGPInformationText = page.locator(".bg-c-alert__content-description");
        this.labelPropertyFull = page.locator("//div[@class='bg-c-label bg-c-label--rainbow bg-c-label--rainbow-grey']");
        this.propertyNamePrime = page.locator(".prime-property-list__list-item-name");

    }

    /**
     * Navigates to Pendaftaran Mamiprime page
     */
    public void navigatesToPendaftaranMamiprime() {
        playwright.navigateTo(Mamikos.OWNER_URL + Mamikos.MAMIPRIME_PENDAFTARAN, 30000.0, LoadState.LOAD);
    }

    /**
     * Get Text Non GP Information about Mamiprime
     *
     * @return string
     */
    public String getNonGPInformationText()  {
        return playwright.getText(nonGPInformationText).replaceAll("\\s", "");
    }

    /**
     * Get Text property name from list property
     *
     * @return string
     */
    public String getPropertyNamePrime()  {
        return playwright.getText(propertyNamePrime);
    }

    /**
     * Get Text at label property prime
     *
     * @return string
     */
    public String getLabelTextFull()  {
        return playwright.getText(labelPropertyFull);
    }


}
