package pageobject.common.apartment;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class ApartmentDetailPO {
    Page page;
    PlaywrightHelpers playwright;
    private Locator contactApartmentButton;
    private Locator favoriteBtn;
    private Locator successMsgPopUp;

    public ApartmentDetailPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        contactApartmentButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hubungi Pengelola"));
        this.favoriteBtn = page.getByTestId("btn-love");
        this.successMsgPopUp = page.getByText("Sukses tersimpan");
    }

    /**
     * Click on Hubungi Pengelola Apartnent
     */
    public void clickContactApt() {
        playwright.clickOn(contactApartmentButton);
    }

    /**
     * click on favorite btn
     */
    public void clickOnFavoriteBtn() {
        playwright.clickOn(favoriteBtn);
    }

    /**
     * get success message after favorite the apartement
     * @return
     */
    public String getSuccessMessage() {
        return playwright.getText(successMsgPopUp);
    }
}
