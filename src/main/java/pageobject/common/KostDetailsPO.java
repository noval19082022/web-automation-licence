package pageobject.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import pageobject.tenant.BookingFormPO;
import utilities.JavaHelpers;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

public class KostDetailsPO {
    Page page;
    PlaywrightHelpers playwright;
    LocatorHelpers locator;
    String date;
    Locator kostDetailsContainer;
    Locator mulaiKosInput;
    Locator datePicker;
    Locator ftueSlider;
    Locator roomFacilities;
    Locator bookingPeriodInput;
    Locator ajukanSewaButton;
    public KostDetailsPO(Page page) {
        this.page = page;
        this.playwright= new PlaywrightHelpers(page);
        this.locator = new LocatorHelpers(page);
        this.kostDetailsContainer = page.locator("#detailKostContainer");
        this.datePicker = page.getByTestId("bookingInputCheckinContent-datePicker");
        this.ftueSlider = playwright.locatorByRoleSetName(locator.roleButton, "Next slide");
        this.mulaiKosInput = page.getByPlaceholder("Mulai kos");
        this.roomFacilities = page.getByTestId("detailKostFacilityCategory");
        this.bookingPeriodInput = page.locator("input.booking-rent-type__input");
        this.ajukanSewaButton = playwright.locatorByRoleSetName(locator.roleButton, "Ajukan Sewa");
    }

    /**
     * Wait until kost detail kontainer id is visible
     */
    public void waitTillKostDetailPageVisible() {
        playwright.waitForElementStateToBe(kostDetailsContainer, "visible");
    }

    /**
     * Dismiss FTUE screen
     */
    public void dismissFTUE() {
        int maxLoop = 0;
        do {
            maxLoop++;
            playwright.tapKeyboard("ArrowDown");
            if (maxLoop == 4) {
                break;
            }
        }
        while (!roomFacilities.isVisible());
        do {
            playwright.forceClickOn(ftueSlider);
        }
        while (ftueSlider.isVisible());
    }

    /**
     * Select booking date
     * @param date tomorrow, today, or specific date by number on string data type
     */
    public void selectBookingDate(String date) {
        if (date.equalsIgnoreCase("tomorrow")) {
            this.date = JavaHelpers.getCostumDateOrTime("D", 1, 0, 0);
        }
        else if(date.equalsIgnoreCase("today")) {
            this.date = JavaHelpers.getCurrentDateOrTime("D");
        }
        else {
            this.date = date;
        }
        mulaiKosInput.click();
        datePicker.getByText(this.date).nth(1).click();
    }

    /**
     * select booking period
     * @param bookingPeriod string data type
     */
    public void selectBookingPeriod(String bookingPeriod) {
        if (!page.getByText(bookingPeriod).isVisible()) {
            bookingPeriodInput.click();
        }
        page.getByText(bookingPeriod).click();
    }

    /**
     * Click on ajukan sewa button
     * @return BookingFormPO class
     */
    public BookingFormPO clickOnAjukanSewaButton() {
        ajukanSewaButton.click();
        return new BookingFormPO(page);
    }
}
