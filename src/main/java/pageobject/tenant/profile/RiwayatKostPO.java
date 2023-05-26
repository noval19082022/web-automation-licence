package pageobject.tenant.profile;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

import java.util.Locale;

public class RiwayatKostPO {
    Page page;
    PlaywrightHelpers playwright;
    Locator reviewKostCardEmpty;
    Locator reviewKostTitle;
    Locator closeButtonReviewKost;
    Locator yesKeluarButton;
    Locator lihatDetailButton;
    Locator lihatFasilitasButton;
    Locator closeButton;
    Locator lihatRiwayatTransaksiButton;
    Locator kembaliKeBookingButton;
    Locator bookingUlangButton;
    Locator bookingFormTitle;
    Locator emptyStateTitleRiwayatKos;
    Locator emptyStateSubtitleRiwayatKos;

    public RiwayatKostPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        reviewKostCardEmpty = page.getByText("Bagaimana pengalaman ngekosmu?").first();
        reviewKostTitle = page.getByText("Yuk, kasih review untuk kos yang kamu sewa");
        closeButtonReviewKost = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tutup"));
        yesKeluarButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Keluar"));
        lihatDetailButton = page.locator("div.history-kost-card:nth-child(1) > a");
        lihatFasilitasButton = page.getByText("Lihat Fasilitas");
        closeButton = page.locator("#bookingModalFacilities").getByTitle("Tutup");
        lihatRiwayatTransaksiButton = page.getByText("Lihat Riwayat Transaksi");
        kembaliKeBookingButton = page.locator("a").filter(new Locator.FilterOptions().setHasText("Kembali ke Booking"));
        bookingUlangButton = page.getByText("Booking Ulang");
        bookingFormTitle = page.getByTestId("booking-request-form__container").getByText("Pengajuan Sewa", new Locator.GetByTextOptions().setExact(true));
        emptyStateTitleRiwayatKos = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Belum Ada Kos"));
        emptyStateSubtitleRiwayatKos = page.getByText("Semua kos yang pernah kamu sewa di Mamikos nantinya akan muncul di halaman ini.");
    }

    /**
     * Click review kost card when user not review kos yet
     */
    public void clickReviewKos() {
        playwright.clickOn(reviewKostCardEmpty);
    }

    /**
     * Is review kost page present
     */
    public boolean isReviewKostPagePresent(){
        return reviewKostTitle.isVisible();
    }

    /**
     * This method also use on :
     * - Click close button on review kost page
     * - Click close button on Lihat Fasilitas page
     */
    public void clickCloseRiviewKost() {
        playwright.clickOn(closeButtonReviewKost);
        playwright.waitTillLocatorIsVisible(yesKeluarButton);
        playwright.clickOn(yesKeluarButton);
    }

    /**
     * Click on Lihat Detail button on riwayat kost
     */
    public void clickLihatDetail() {
        playwright.clickOn(lihatDetailButton);
    }

    /**
     * Click Lihat Fasilitas on Riwayat Kost detail
     */
    public void clickLihatFasilitas() {
        playwright.clickOn(lihatFasilitasButton);
    }

    /**
     * Click close on facility popup
     */
    public void clickCloseFacility() {
       playwright.clickOn(closeButton);
    }

    /**
     * Click Lihat Riwayat Transaksi on Riwayat Kost detail
     */
    public void clickLihatRiwayatTransaksi() {
        playwright.clickOn(lihatRiwayatTransaksiButton);
    }

    /**
     * Click Kembali ke Booking
     */
    public void clickKembaliKeBooking() {
        playwright.clickOn(kembaliKeBookingButton);
    }

    /**
     * Click booking ulang on riwayat kost detail
     */
    public void clickBookingUlang() {
        playwright.pageScrollUntilElementIsVisible(bookingUlangButton);
        playwright.clickOn(bookingUlangButton);
    }

    /**
     * Is title Booking form present
     */
    public boolean isTitleBookingFormPresent(){
        return bookingFormTitle.isVisible();
    }

    /**
     * Get empty state title at Riwayat kos
     */
    public String getEmptyStateTitle(){
        return playwright.getText(emptyStateTitleRiwayatKos);
    }

    /**
     * Get empty state subtitle at Riwayat kos
     */
    public boolean isEmptyStateSubtitlePresent(){
        return emptyStateSubtitleRiwayatKos.isVisible();
    }
}
