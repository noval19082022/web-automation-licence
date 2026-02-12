package pageobject.owner;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

/**
 * Page Object for Pilih Property Page (Pilih Jenis Properti)
 * This page appears when listingless owner clicks on "Pasang Iklan Pertama" button
 */
public class PilihPropertyPagePO {
    private final Page page;
    private final PlaywrightHelpers playwright;

    private Locator pilihJenisPropertiTitle;
    private Locator kosOptionButton;
    private Locator apartemenOptionButton;
    private Locator buatKosButton;
    private Locator buatApartemenButton;
    private Locator closeButton;

    public PilihPropertyPagePO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);

        pilihJenisPropertiTitle = page.getByText("Pilih Jenis Properti");
        kosOptionButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kos")).first();
        apartemenOptionButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Apartemen")).first();
        buatKosButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Buat Kos"));
        buatApartemenButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Buat Apartemen"));
        closeButton = page.locator("use[href='#basic-close']");
    }

    /**
     * Check if pilih property page is visible
     * @return true if pilih property page is visible
     */
    public boolean isPageVisible() {
        return playwright.waitTillLocatorIsVisible(pilihJenisPropertiTitle, 10000.0);
    }

    /**
     * Check if Kos option is visible
     * @return true if Kos option is visible
     */
    public boolean isKosOptionVisible() {
        return playwright.waitTillLocatorIsVisible(kosOptionButton, 5000.0);
    }

    /**
     * Check if Apartemen option is visible
     * @return true if Apartemen option is visible
     */
    public boolean isApartemenOptionVisible() {
        return playwright.waitTillLocatorIsVisible(apartemenOptionButton, 5000.0);
    }

    /**
     * Check if "Buat Kos" button is visible
     * @return true if Buat Kos button is visible
     */
    public boolean isBuatKosButtonVisible() {
        return playwright.waitTillLocatorIsVisible(buatKosButton, 5000.0);
    }

    /**
     * Check if "Buat Apartemen" button is visible
     * @return true if Buat Apartemen button is visible
     */
    public boolean isBuatApartemenButtonVisible() {
        return playwright.waitTillLocatorIsVisible(buatApartemenButton, 5000.0);
    }

    /**
     * Click on Kos option
     */
    public void clickOnKosOption() {
        playwright.waitTillLocatorIsVisible(kosOptionButton, 5000.0);
        playwright.clickOn(kosOptionButton);
    }

    /**
     * Click on Apartemen option
     */
    public void clickOnApartemenOption() {
        playwright.waitTillLocatorIsVisible(apartemenOptionButton, 5000.0);
        playwright.clickOn(apartemenOptionButton);
    }

    /**
     * Click on "Buat Kos" button
     */
    public void clickOnBuatKosButton() {
        playwright.waitTillLocatorIsVisible(buatKosButton, 5000.0);
        playwright.clickOn(buatKosButton);
    }

    /**
     * Click on "Buat Apartemen" button
     */
    public void clickOnBuatApartemenButton() {
        playwright.waitTillLocatorIsVisible(buatApartemenButton, 5000.0);
        playwright.clickOn(buatApartemenButton);
    }

    /**
     * Check if Kos option is selected/highlighted
     * @return true if Kos option is selected
     */
    public boolean isKosOptionSelected() {
        playwright.hardWait(500);
        String classAttr = kosOptionButton.getAttribute("class");
        return classAttr != null && (classAttr.contains("selected") || classAttr.contains("active") || classAttr.contains("checked"));
    }

    /**
     * Check if Apartemen option is selected/highlighted
     * @return true if Apartemen option is selected
     */
    public boolean isApartemenOptionSelected() {
        playwright.hardWait(500);
        String classAttr = apartemenOptionButton.getAttribute("class");
        return classAttr != null && (classAttr.contains("selected") || classAttr.contains("active") || classAttr.contains("checked"));
    }

    /**
     * Check if Buat Kos button is enabled
     * @return true if button is enabled
     */
    public boolean isBuatKosButtonEnabled() {
        playwright.waitTillLocatorIsVisible(buatKosButton, 5000.0);
        return buatKosButton.isEnabled();
    }

    /**
     * Check if Buat Apartemen button is enabled
     * @return true if button is enabled
     */
    public boolean isBuatApartemenButtonEnabled() {
        playwright.waitTillLocatorIsVisible(buatApartemenButton, 5000.0);
        return buatApartemenButton.isEnabled();
    }

    /**
     * Dismiss/close pilih property page
     */
    public void dismissPage() {
        playwright.clickOn(closeButton);
    }

    /**
     * Check if pilih property page is closed/not visible
     * @return true if page is not visible
     */
    public boolean isPageClosed() {
        return !playwright.waitTillLocatorIsVisible(pilihJenisPropertiTitle, 3000.0);
    }
}
