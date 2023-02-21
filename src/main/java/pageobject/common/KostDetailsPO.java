package pageobject.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pageobject.tenant.BookingFormPO;
import utilities.JavaHelpers;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

import java.util.List;

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
    private Locator kostTitle_DOM_PLM_A;
    private Locator propertyGenderCampur;
    private Locator propertyLocation;
    private Locator roomAvailability;
    String datePickXpath = "//span[not(contains(@class, 'disabled'))][contains(text(), '%s')]";

    public KostDetailsPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.locator = new LocatorHelpers(page);
        this.kostDetailsContainer = page.locator("#detailKostContainer");
        this.datePicker = page.getByTestId("bookingInputCheckinContent-datePicker");
        this.ftueSlider = playwright.locatorByRoleSetName(locator.roleButton, "Next slide");
        this.mulaiKosInput = page.getByPlaceholder("Mulai kos");
        this.roomFacilities = page.getByTestId("detailKostFacilityCategory");
        this.bookingPeriodInput = page.locator("input.booking-rent-type__input");
        this.ajukanSewaButton = playwright.locatorByRoleSetName(locator.roleButton, "Ajukan Sewa");
        this.kostTitle_DOM_PLM_A = page.getByText("Kos Dom Automation PLM Tipe A Kretek Bantul").nth(2);
        this.propertyGenderCampur = page.getByText("Kos Campur");
        this.propertyLocation = page.getByText("place-holder Kecamatan Kretek");
        this.roomAvailability = page.getByText("more-choices Banyak pilihan kamar untukmu");
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
//        for (int i = 0; i < 4; i++) {
//            playwright.tapKeyboard("ArrowDown");
//            if (ftueSlider.isVisible()) {
//                break;
//            }
//        }
        playwright.pageScrollToDown(500);
        do {
            playwright.forceClickOn(ftueSlider);
        }
        while (ftueSlider.isVisible());
    }

    /**
     * Select booking date
     *
     * @param date tomorrow, today, or specific date by number on string data type
     */
    public void selectBookingDate(String date) {
        Locator datePick;
        if (date.equalsIgnoreCase("tomorrow")) {
            this.date = JavaHelpers.getCostumDateOrTime("d", 1, 0, 0);
        } else if (date.equalsIgnoreCase("today")) {
            this.date = JavaHelpers.getCurrentDateOrTime("d");
        } else {
            this.date = date;
        }
        mulaiKosInput.click();
        datePick = page.getByTestId("bookingInputCheckinContent-datePicker").getByText(this.date);
        List<Locator> datePicks = playwright.getLocators(datePick);
        for (Locator pick : datePicks) {
            if (pick.isEnabled() && pick.isVisible()) {
                pick.click();
            }
        }
    }

    /**
     * select booking period
     *
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
     *
     * @return BookingFormPO class
     */
    public BookingFormPO clickOnAjukanSewaButton() {
        ajukanSewaButton.click();
        return new BookingFormPO(page);
    }

    /**
     * get detail page
     *
     * @return
     */

    public String getKostTitlePLMA() {
        playwright.waitTillLocatorIsVisible(kostTitle_DOM_PLM_A, 1.0);
        return kostTitle_DOM_PLM_A.textContent();
    }

    public boolean isPropertyGenderCampurDisplayed() {
        playwright.waitTillLocatorIsVisible(propertyGenderCampur);
        return propertyGenderCampur.isVisible();
    }

    public boolean isPropertyLocationPLMADisplayed() {
        playwright.waitTillLocatorIsVisible(propertyLocation);
        return propertyLocation.isVisible();
    }

    public boolean isRoomAvailabilityPLMADisplayed() {
        playwright.waitTillLocatorIsVisible(roomAvailability);
        return roomAvailability.isVisible();
    }
}
