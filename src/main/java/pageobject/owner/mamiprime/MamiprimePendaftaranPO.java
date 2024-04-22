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

    public MamiprimePendaftaranPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.nonGPInformationText = page.locator(".bg-c-alert__content-description");
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

}
