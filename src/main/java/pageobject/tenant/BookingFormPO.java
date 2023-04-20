package pageobject.tenant;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class BookingFormPO {
    Page page;
    Locator ajukanSewaButton;
    Locator bookingConfirmationCheckmark;
    Locator kirimPengajuanKePemilikButton;
    Locator lihatSelengkapnyaTextLink;
    Locator batalkanBookingButton;
    Locator cancelReasonButton;
    Locator confirmCancelButton;
    Locator successCancel;
    Locator okCancelButton;
    Locator rentDurationIncreaseButton;
    Locator ubahButton;
    Locator selectPayWithDP;
    Locator simpanButton;

    public BookingFormPO(Page page) {
        this.page = page;
        this.ajukanSewaButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ajukan Sewa"));
        this.bookingConfirmationCheckmark = page.getByTestId("booking-confirmationModal").locator("span").filter(new Locator.FilterOptions().setHasText("checkmark"));
        this.kirimPengajuanKePemilikButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kirim pengajuan ke pemilik"));
        this.lihatSelengkapnyaTextLink = page.getByText("Lihat selengkapnya").first();
        this.batalkanBookingButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Batalkan Booking"));
        this.confirmCancelButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ya, Batalkan"));
        this.successCancel = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Booking Anda berhasil dibatalkan"));
        this.okCancelButton = page.locator(".bg-c-button");
        this.cancelReasonButton = page.locator("label").filter(new Locator.FilterOptions().setHasText("Berubah pikiran/ada rencana lain")).locator("span");
        this.rentDurationIncreaseButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("add-plus"));
        this.ubahButton = page.locator(".booking-payment-option .booking-form-section__action .bg-c-text");
        this.selectPayWithDP = page.locator("[for='bookingFormRadio-paymentSelect-0'] > .bg-c-radio__icon");
        this.simpanButton = page.locator(".bg-c-button--secondary");
    }

    /**
     * Click on ajukan sewa button on booking form
     */
    public void clickOnAjukanSewaButton() {
        ajukanSewaButton.click();
    }

    /**
     * Click on booking confirmation checkmark
     */
    public void clickOnBookingConfirmationCheckmark() {
        bookingConfirmationCheckmark.click();
    }

    /**
     * click on kirim pengajuan ke pemilik button
     *
     * @return SuccessBookingPO class;
     */
    public SuccessBookingPO clickOnKirimPengajuanKePemilik() {
        kirimPengajuanKePemilikButton.click();
        return new SuccessBookingPO(page);
    }

    ;

    /**
     * click on Lihat Selengkapnya
     * click on Batalkan Booking
     * click on cancel reason button
     * click on Ya Batalkan button
     */
    public void cancelBooking() {
        for (int i = 0; i < 2; i++) {
            lihatSelengkapnyaTextLink.click();
        }
        if (batalkanBookingButton.isVisible()) {
            batalkanBookingButton.click();
            cancelReasonButton.click();
            confirmCancelButton.click();
        }
    }

    /**
     * Wait until terminated is process is finished
     *
     * @return
     */
    public boolean waitUntilSuccessCancelHeadingVisible() {
        return successCancel.isVisible();
    }

    /**
     * Get success cancel booking pop-up text
     *
     * @return String data type
     */
    public String getSuccessCancelText() {
        return successCancel.textContent();
    }

    /**
     * Close booking pop-up
     */
    public void closeCancelPopUp() {
        if (okCancelButton.isVisible()) {
            okCancelButton.click();
        }
    }

    /**
     * Increase Rent Duration
     * @throws InterruptedException
     */
    public void increaseRateDuration() throws InterruptedException {
        if(rentDurationIncreaseButton.isVisible()) {
            rentDurationIncreaseButton.click();
        }
    }

    /**
     * Click on ubah button on booking form
     */
    public void clickUbahButton() {
        ubahButton.click();
    }

    /**
     * Click on DP button on booking form
     */
    public void selectPayWithDP() {
        selectPayWithDP.click();
    }

    /**
     * Click on Simpan button on booking form
     */
    public void clickSimpanButton() {
        simpanButton.click();
    }
}
