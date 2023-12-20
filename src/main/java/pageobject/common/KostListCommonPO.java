package pageobject.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class KostListCommonPO {

    private PlaywrightHelpers playwright;

    // pop up probut
    private Locator promoNgebutPopUp;
    private Locator sayaMengertiBtn;

    // room card
    private Locator roomCardLocationList;

    // facility element
    private Locator roomCardFacilityList;
    private Locator roomCardDetailFacilityList;
    private Locator roomCardRattingFacilityList;

    // bottom
    private Locator lihatLebihBanyakBtn;

    public KostListCommonPO(Page page) {
        this.playwright = new PlaywrightHelpers(page);
        this.promoNgebutPopUp = page.getByText("Mamikos Promo Ngebut Promo seminggu untuk diskon harga sewa kos Potongan harga");
        this.sayaMengertiBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Saya mengerti"));
        this.roomCardLocationList = page.locator(".rc-info__location");
        this.roomCardFacilityList = page.getByTestId("roomCardFacilities");
        this.roomCardDetailFacilityList = page.getByTestId("roomCardFacilities-facility");
        this.roomCardRattingFacilityList = page.getByTestId("roomCardFacilities-rating");
        this.lihatLebihBanyakBtn = page.getByText("Lihat lebih banyak lagi");
    }

    /**
     * click On Saya Mengerti Btn On Pop Up probut if exist
     */
    public void dismissProbutPopUpOnKostList() {
        playwright.pageScrollToDown(200);
        if (playwright.waitTillLocatorIsVisible(promoNgebutPopUp, 2.0)) playwright.clickOn(sayaMengertiBtn);
    }

    /**
     * click On Lihat Lebih Banyak
     */
    public void clickOnLihatLebihBanyakBtn() {
        playwright.waitTillPageLoaded();
        if (playwright.isLocatorVisibleAfterLoad(lihatLebihBanyakBtn, 2.0)) {
            playwright.pageScrollInView(lihatLebihBanyakBtn);
            playwright.clickOn(lihatLebihBanyakBtn);
            playwright.pageScrollHeightToBottom();
            playwright.waitTillPageLoaded();
        }
    }

    /**
     * checking if room card location is not null
     *
     * @return
     */
    public boolean roomCardLocationIsVisible() {
        playwright.waitTillPageLoaded();
        return roomCardLocationList.all().size() != 0;
    }

    /**
     * checking room card facility is not null
     *
     * @return
     */
    public boolean roomCardFacilityIsVisible() {
        playwright.waitTillPageLoaded();
        return roomCardFacilityList.all().size() != 0;
    }

    /**
     * checking room card detail facility is not null
     *
     * @return
     */
    public boolean roomCardDetailFacilityIsVisible() {
        playwright.waitTillPageLoaded();
        return roomCardDetailFacilityList.all().size() != 0;
    }

    /**
     * checking room card review is not null
     *
     * @return
     */
    public boolean roomCardRatingIsVisible() {
        playwright.waitTillPageLoaded();
        return roomCardRattingFacilityList.all().size() != 0;
    }
}
