package pageobject.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
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
    Locator favoriteKostButton;
    Locator unFavoriteKostButton;
    Locator successFavoritePopUp;
    Locator successUnfavoritePopUp;
    private Locator kostTitle;
    private Locator propertyGender;
    private Locator propertyLocation;
    private Locator roomAvailability;
    String datePickXpath = "//span[not(contains(@class, 'disabled'))][contains(text(), '%s')]";
    Locator kosDetailPage;

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
        this.kostTitle = page.locator("#detailTitle");
        this.propertyGender = page.locator(".detail-kost-overview__gender-box");
        this.propertyLocation = page.locator(".detail-kost-overview__area");
        this.roomAvailability = page.locator(".detail-kost-overview__availability");
        this.kosDetailPage = page.locator("detailKostContainer");
        this.favoriteKostButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("wishlist Simpan"));
        this.unFavoriteKostButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("wishlist-glyph Hapus"));
        this.successFavoritePopUp = page.getByText("Berhasil ditambahkan ke favorit.");
        this.successUnfavoritePopUp = page.getByText("Berhasil dihapus dari favorit.");
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
        for (int i = 0; i < 4; i++) {
            playwright.pageScrollToDown(500);
            if (ftueSlider.isVisible()) {
                break;
            }
        }
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
     * get title detail kost page
     *
     * @return 'string' kost title
     */
    public String getKostTitle() {
        playwright.waitTillLocatorIsVisible(kostTitle, 1.0);
        return kostTitle.textContent();
    }

    /**
     * get gender detail kost page
     *
     * @return 'boolean' property gender element visibility
     */
    public boolean isPropertyGenderDisplayed() {
        playwright.waitTillLocatorIsVisible(propertyGender);
        return propertyGender.isVisible();
    }

    /**
     * get location detail kost page
     *
     * @return 'boolean' property location element visibility
     */
    public boolean isPropertyLocationDisplayed() {
        playwright.waitTillLocatorIsVisible(propertyLocation);
        return propertyLocation.isVisible();
    }

    /**
     * get room detail kost page
     *
     * @return 'boolean' room element visibility
     */
    public boolean isRoomAvailabilityDisplayed() {
        playwright.waitTillLocatorIsVisible(roomAvailability);
        return roomAvailability.isVisible();
    }

    /**
     * Check detail kos page reached
     *
     * @return Boolean
     * @throws InterruptedException
     */
    public boolean isInKosDetail() {
        kosDetailPage.isVisible();
        return true;
    }

    /**
     * Click on favorite kost button
     *
     */
    public void clickOnFavoriteKostButton() {
        favoriteKostButton.click();
    }

    /**
     * Check if success favorite pop up displayed
     *
     */
    public boolean isSuccessFavoriteKostDisplayed() {
        playwright.waitTillLocatorIsVisible(successFavoritePopUp);
        return successFavoritePopUp.isVisible();
    }

    /**
     * Click on unfavorite kost button
     *
     */
    public void clickOnUnfavoriteKostButton() {
        unFavoriteKostButton.click();
    }

    /**
     * Check if success unfavorite pop up displayed
     *
     */
    public boolean isSuccessUnfavoriteKostDisplayed() {
        playwright.waitTillLocatorIsVisible(successUnfavoritePopUp);
        return successUnfavoritePopUp.isVisible();
    }
}
