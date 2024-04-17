package pageobject.owner;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import data.mamikos.Mamikos;
import utilities.PlaywrightHelpers;

public class MamiprimePO {
    private Page page;
    private PlaywrightHelpers playwright;

    // Landing Page
    Locator lihatRiwayatButton;
    Locator beliPaketButtonHeader;
    Locator beliPaketButtonDesc;
    Locator sectionFAQPrime;
    Locator pusatBantuanPrime;

    // Pendaftaran Mamiprime page
    Locator titlePagePendaftaranPrime;

    public MamiprimePO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        lihatRiwayatButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat Riwayat"));
        beliPaketButtonHeader = page.getByTestId("prime-landing-page-banner").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Beli Paket"));
        beliPaketButtonDesc =  page.getByTestId("prime-landing-page-ad-serving").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Beli Paket"));
        sectionFAQPrime = page.locator(".prime-landing-faq");
        pusatBantuanPrime = page.locator(".prime-landing-faq__cta");
    }

    /**
     * Check is it lihat riwayat button is visible or not
     * @return boolean, true if visible
     */
    public boolean isLihatRiwayatVisible() {
        return playwright.waitTillLocatorIsVisible(lihatRiwayatButton);
    }

    /**
     * Click on Lihat Riwayat Button on landing page
     */
    public void clickOnLihatRiwayat() {
        playwright.clickOn(lihatRiwayatButton);
    }

    /**
     * Check is beli paket button at header is visible or not
     * @return boolean, true if visible
     */
    public boolean isBeliPaketHeaderButtonVisible() {
        return playwright.waitTillLocatorIsVisible(beliPaketButtonHeader);
    }


    /**
     * Check is beli paket button at product description is visible or not
     * @return boolean, true if visible
     */
    public boolean isBeliPaketDescButtonVisible() {
        playwright.pageScrollUntilElementIsVisible(beliPaketButtonDesc);
        return playwright.waitTillLocatorIsVisible(beliPaketButtonDesc);
    }

    /**
     * Click on Beli Paket button at header mamiprime
     */
    public void clickOnBeliPaketHeader() {
        playwright.clickOn(beliPaketButtonHeader);
    }

    /**
     * Click on Beli Paket button at product description mamiprime
     */
    public void clickOnBeliPaketDesc() {
        playwright.clickOn(beliPaketButtonDesc);
    }

    /**
     * Check is Pendaftaran Mamiprime page is visible or not
     *
     * @return boolean, true if visible
     */
    public boolean isPendataranMamiprimeVisible(String title) {
       titlePagePendaftaranPrime = page.getByText(title);
        playwright.waitFor(titlePagePendaftaranPrime);
       return playwright.waitTillLocatorIsVisible(titlePagePendaftaranPrime);
    }

    /**
     * Navigates to Mamiprime page
     */
    public void navigatesToMamiprime() {
        playwright.navigateTo(Mamikos.OWNER_URL + Mamikos.MAMIPRIME, 50000.0, LoadState.LOAD);
    }

    /**
     * Check is FAQ section is visible or not
     *
     * @return boolean, true if visible
     */
    public boolean isFAQsectionisVisible() {
        playwright.pageScrollUntilElementIsVisible(sectionFAQPrime);
        return playwright.waitTillLocatorIsVisible(sectionFAQPrime);
    }

    /**
     * Check is pusat bantuan section is visible or not
     *
     * @return boolean, true if visible
     */
    public boolean isPusatBantuansectionisVisible() {
        playwright.pageScrollUntilElementIsVisible(pusatBantuanPrime);
        return playwright.waitTillLocatorIsVisible(pusatBantuanPrime);
    }
}
