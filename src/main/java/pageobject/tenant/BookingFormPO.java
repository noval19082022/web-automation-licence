package pageobject.tenant;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class BookingFormPO {
    Page page;
    Locator ajukanSewaButton;
    Locator bookingConfirmationCheckmark;
    Locator kirimPengajuanKePemilikButton;
    public BookingFormPO(Page page) {
        this.page = page;
        this.ajukanSewaButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ajukan Sewa"));
        this.bookingConfirmationCheckmark = page.getByTestId("booking-confirmationModal").locator("span").filter(new Locator.FilterOptions().setHasText("checkmark"));
        this.kirimPengajuanKePemilikButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kirim pengajuan ke pemilik"));
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
     * @return SuccessBookingPO class;
     */
    public SuccessBookingPO clickOnKirimPengajuanKePemilik() {
        kirimPengajuanKePemilikButton.click();
        return new SuccessBookingPO(page);
    };
}
