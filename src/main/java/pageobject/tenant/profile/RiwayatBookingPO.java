package pageobject.tenant.profile;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import config.playwright.context.ActiveContext;
import pageobject.tenant.InvoicePO;
import utilities.PlaywrightHelpers;

public class RiwayatBookingPO {
    Page page;
    PlaywrightHelpers playwright;
    Locator bayarSekarangButton;
    Locator checkinButton;
    Locator chekcinOnPopUpButton;
    Locator doneToKostSayaButton;
    Locator bayarPelunasanButton;
    Locator lihatSelengkapnyaButton;
    Locator refundText;
    Locator userBookingSection;
    Locator textBookingStatusFirstList;
    Locator textRejectReasonFirstList;
    Locator ajukanSewaText;

    public RiwayatBookingPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        bayarSekarangButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Bayar Sekarang")).first();
        checkinButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Check-in Kos"));
        chekcinOnPopUpButton = page.getByRole(AriaRole.DIALOG).filter(new Locator.FilterOptions().setHasText("close Pastikan")).getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Check-in"));
        doneToKostSayaButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Selesai & ke Kos Saya"));
        bayarPelunasanButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Bayar Pelunasan Sekarang"));
        lihatSelengkapnyaButton = page.getByText("Lihat selengkapnya").first();
        refundText = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Apakah uang saya bisa dikembalikan?"));
        userBookingSection = page.locator("#userBookingSection");
        textBookingStatusFirstList = page.locator(".booking-list-card:nth-child(1) .card-header label");
        textRejectReasonFirstList = page.locator(".header-reject-reason:nth-child(1) span");
        ajukanSewaText = page.locator("//*[contains(text(), 'Ajukan Sewa')]").first();
    }

    /**
     * Click on bayar sekarang button
     *
     * @return InvoicePO class
     */
    public InvoicePO clickOnBayarSekarangButton() {
        // Wait for page to load and button to be available
        playwright.waitTillPageLoaded();
        playwright.hardWait(2000);
        
        // Wait for button with extended timeout
        playwright.waitTillLocatorIsVisible(bayarSekarangButton, 20000.0);
        
        page = page.waitForPopup(() -> {
            playwright.clickOn(bayarSekarangButton);
        });
        ActiveContext.setActivePage(page);
        return new InvoicePO(page);
    }

    /**
     * go to invoice after tenant dp
     *
     * @return InvoicePO class
     */
    public InvoicePO goToSettlementInvoice() {
        playwright.reloadPage();
        playwright.waitFor(bayarSekarangButton);
        playwright.clickOn(bayarSekarangButton);
        page = playwright.movePageByClickLocator(page, bayarPelunasanButton);
        ActiveContext.setActivePage(page);
        return new InvoicePO(page);
    }

    /**
     * Click on check-in button
     */
    public void clickOnCheckinButton() {
        playwright.clickOn(checkinButton);
    }

    /**
     * Click on check-in pop-up button
     */
    public void clickOnCheckinPopUpButton() {
        playwright.clickOn(chekcinOnPopUpButton);
    }

    /**
     * Click on selesai and go to kost saya
     */
    public void clickOnSelesaiAndKeKostSaya() {
        playwright.clickOn(doneToKostSayaButton);
        playwright.waitTillPageLoaded();
    }

    /**
     * click on Lihat selengkapnya urutan pertama
     */
    public void clickFirstSelengkapnyaButton() {
        playwright.clickOn(lihatSelengkapnyaButton);
    }

    /**
     * click on Apakah uang saya bisa dikembalikan link
     */
    public void clickOnRefundLink() {
        page.waitForPopup(() -> {
            playwright.clickOn(refundText);
        });
    }

    /**
     * Check if history booking section id is visible in the viewport
     *
     * @return true if booking section id is visible
     */
    public boolean isInHistoryBookingSection() {
        playwright.waitTillLocatorIsVisible(userBookingSection);
        return userBookingSection.isVisible();
    }

    /**
     * get first booking status on riwayat and draft booking page
     *
     * @return String booking status e.g Pemilik menolak
     */
    public String getFirstListBookingStatusText() {
        return playwright.getText(textBookingStatusFirstList);
    }

    /**
     * click lihat selengkapnya and get reject reason
     *
     * @return String reason e.g Saya sudah ada yang punya
     */
    public String getRejectReasonOnDetailsFirstKostList() {
        lihatSelengkapnyaButton.click();
        return playwright.getText(textRejectReasonFirstList);
    }

    /**
     * check if ajukan sewa text button is visible
     *
     * @return Ajukan Sewa text button
     */
    public Boolean getAjukanSewatext() {
        return ajukanSewaText.isVisible();
    }

    /**
     * click on Ajukan sewa button on draft or baru dilihat section
     */
    public void clickAjukanSewaButtonDraft() {
        playwright.clickOn(ajukanSewaText);
    }
}
