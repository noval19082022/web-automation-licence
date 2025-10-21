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
    Locator sectionBenefitPrime;
    Locator beliPaketButtonDesc;
    Locator sectionTestimonialPrime;
    Locator sectionFAQPrime;
    Locator pusatBantuanPrime;
    Locator sectionContactPrime;
    Locator textOnLandingPage;
    Locator firstBenefitImage;
    Locator secondBenefitImage;
    Locator thirdBenefitImage;
    Locator productDescImage;
    Locator CSButton;

    // Pendaftaran Mamiprime page
    Locator titlePagePendaftaranPrime;

    // Popup Beli Paket
    Locator titleBelumAdaPropertiPopup;
    Locator subtitleBelumAdaPropertiPopup;
    Locator tambahKosButton;
    Locator nantiSajaButton;

    public MamiprimePO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        lihatRiwayatButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat Riwayat"));
        beliPaketButtonHeader = page.getByTestId("prime-landing-page-banner").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Beli Paket"));
        sectionBenefitPrime = page.getByTestId("prime-landing-page-benefit");
        beliPaketButtonDesc =  page.getByTestId("prime-landing-page-ad-serving").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Beli Paket"));
        sectionTestimonialPrime = page.getByTestId("prime-landing-page-testimonial");
        sectionFAQPrime = page.locator(".prime-landing-faq");
        pusatBantuanPrime = page.locator(".prime-landing-faq__cta");
        sectionContactPrime = page.getByTestId("prime-landing-contact");
        firstBenefitImage = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("benefit-1"));
        secondBenefitImage = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("benefit-2"));
        thirdBenefitImage = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("benefit-3"));
        productDescImage = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("ad-serving"));
        CSButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hubungi CS Mamikos"));
        titleBelumAdaPropertiPopup = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Anda Belum Dapat Mendaftar MamiPrime"));
        subtitleBelumAdaPropertiPopup = page.getByText("Tambahkan properti kos aktif dahulu agar dapat bergabung dengan MamiPrime.");
        tambahKosButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tambah Kos"));
        nantiSajaButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Nanti Saja"));
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
        playwright.navigateTo(Mamikos.OWNER_URL + Mamikos.MAMIPRIME, 120000.0, LoadState.LOAD);
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

    /**
     * Check is benefit section is visible or not
     *
     * @return boolean, true if visible
     */
    public boolean isBenefitSectionisVisible() {
        playwright.pageScrollUntilElementIsVisible(sectionBenefitPrime);
        return playwright.waitTillLocatorIsVisible(sectionBenefitPrime);
    }

    /**
     * Check is testimonial section is visible or not
     *
     * @return boolean, true if visible
     */
    public boolean isTestimonialSectionisVisible() {
        playwright.pageScrollUntilElementIsVisible(sectionTestimonialPrime);
        return playwright.waitTillLocatorIsVisible(sectionTestimonialPrime);
    }

    /**
     * Check is hubungi cs mamikos section is visible or not
     *
     * @return boolean, true if visible
     */
    public boolean isContactSectionisVisible() {
        playwright.pageScrollUntilElementIsVisible(sectionContactPrime);
        return playwright.waitTillLocatorIsVisible(sectionContactPrime);
    }

    /**
     * Check title and subtitle on mamiprime
     * @return boolean, true if visible
     */
    public boolean textOnLandingPageMamiprime(String subtitleText) {
        textOnLandingPage = page.getByText(subtitleText).first();
        return playwright.waitTillLocatorIsVisible(textOnLandingPage);
    }

    /**
     * Check first benefit image on mamiprime
     * @return boolean, true if visible
     */
    public boolean isFirstBenefitImageVisible() {
        return playwright.waitTillLocatorIsVisible(firstBenefitImage);
    }

    /**
     * Check second benefit image on mamiprime
     * @return boolean, true if visible
     */
    public boolean isSecondBenefitImageVisible() {
        return playwright.waitTillLocatorIsVisible(secondBenefitImage);
    }

    /**
     * Check third benefit image on mamiprime
     * @return boolean, true if visible
     */
    public boolean isThirdBenefitImageVisible() {
        return playwright.waitTillLocatorIsVisible(thirdBenefitImage);
    }

    /**
     * Check product description image on mamiprime
     * @return boolean, true if visible
     */
    public boolean isProductDescImageVisible() {
        return playwright.waitTillLocatorIsVisible(productDescImage);
    }

    /**
     * Check Hubungi CS Button visible
     * @return boolean, true if visible
     */
    public boolean isCSButtonVisible() {
        return playwright.waitTillLocatorIsVisible(CSButton);
    }

    /**
     * get text title on popup belum ada properti aktif
     * @return boolean, true if visible
     */
    public boolean getTitleBelumAdaProperti() {
        return playwright.waitTillLocatorIsVisible(titleBelumAdaPropertiPopup);
    }

    /**
     * get text subtitle on popup belum ada properti aktif
     * @return boolean, true if visible
     */
    public boolean getSubtitleBelumAdaProperti() {
        return playwright.waitTillLocatorIsVisible(subtitleBelumAdaPropertiPopup);
    }

    /**
     * check nanti saja button visible on popup
     * @return boolean, true if visible
     */
    public boolean isNantiSajaBtnVisible() {
        return playwright.waitTillLocatorIsVisible(nantiSajaButton);
    }

    /**
     * check tambah kos button visible on popup
     * @return boolean, true if visible
     */
    public boolean isTambahKosBtnVisible() {
        return playwright.waitTillLocatorIsVisible(tambahKosButton);
    }
}
