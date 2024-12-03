package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import lombok.Getter;
import lombok.Setter;
import utilities.PlaywrightHelpers;

public class AdminApproveBookingPO {
    private Page page;
    private PlaywrightHelpers playwright;
    @Setter
    @Getter

    Locator expandFilterButton;
    Locator textBoxFilterDataPhone;
    Locator dropdownFilterDataKosType;
    Locator searchButton;
    Locator actionButton;
    Locator confirmButton;
    Locator confirmBooking;
    Locator nextConfirmBooking;
    Locator deleteOtherPrice;
    Locator confirmDeleteOtherPrice;
    Locator detailButton;
    Locator toggleOtherPrice;

    public AdminApproveBookingPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        expandFilterButton = page.getByText("Tampilkan Filter");
        textBoxFilterDataPhone = page.getByPlaceholder("Ex: 081987654321");
        dropdownFilterDataKosType = page.locator("#select2-kost_type-container");
        searchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Cari"));
        actionButton = page.locator("(//button[@type='button'][normalize-space()='Actions'])[1]");
        confirmButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Confirm"));
        nextConfirmBooking = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Lanjutkan"));
        confirmBooking = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Konfirmasi"));
        deleteOtherPrice =  page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hapus"));
        confirmDeleteOtherPrice =  page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ya, Hapus"));
        detailButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Detail"));
        toggleOtherPrice = page.locator("label").filter(new Locator.FilterOptions().setHasText("Biaya Lainnya Per Bulan")).locator("span").first();
    }

    /**
     * click Tampilkan/Sembunyikan button to show/hide filter data booking
     *
     * @throws InterruptedException
     */
    public void showOrHideFilter() {
        playwright.clickOn(expandFilterButton);
    }
    /**
     * fill other price
     */
    public void fillFilterDataBooking(String tenantPhone,String kosType) {
        playwright.clickOn(textBoxFilterDataPhone);
        Locator dataFilterPhone = page.locator("//input[@placeholder='Ex: 081987654321']");
        playwright.fill(dataFilterPhone,tenantPhone);
        playwright.clickOn(dropdownFilterDataKosType);
        Locator fillTextboxKosType = page.locator("//span[@class='select2-search select2-search--dropdown']//input[@role='searchbox']");
        playwright.fill(fillTextboxKosType,kosType);
        Locator dataFilterkosType = page.locator("//li[@class='select2-results__option select2-results__option--highlighted']");
        playwright.clickOn(dataFilterkosType);
        playwright.clickOn(searchButton);
    }
    /**
     * click action button in data booking
     */
    public void clickActionButton() {
        playwright.clickOn(actionButton);
    }
    /**
     * admin accept booking
     */
    public void adminAcceptBooking() {
        playwright.clickOn(confirmButton);
        for (int i = 0; i < 3; i++) {
            playwright.clickOn(nextConfirmBooking);
        }
        playwright.clickOn(confirmBooking);
    }

    /**
     * click detail button in action button
     */
    public void clickDetailButton() {
        playwright.clickOn(detailButton);
    }
    /**
     * Get text other price name on confirmation screen
     *
     * @return string data type "Biaya lainnya"
     */
    public AdminApproveBookingPO getTextOtherPrice(String otherPriceName, String totalPrice) {
        Locator priceName = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(totalPrice).setName(otherPriceName));
        playwright.clickOn(priceName);
        return new AdminApproveBookingPO(page);
    }

    /**
     * click on confirm booking until next button after input room number
     */
    public void clickNextOnConfirmBooking(){
        playwright.clickOn(confirmButton);
        playwright.clickOn(nextConfirmBooking);
    }

    /**
     * click next button after validate pms kk section and batalkan for DP section
     */
    public void clickOnNextButonConfirmBooking(){
        playwright.clickOn(nextConfirmBooking);
        Locator cancelDPButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Batalkan"));
        playwright.clickOn(cancelDPButton);
        playwright.clickOn(nextConfirmBooking);
        playwright.clickOn(confirmBooking);
    }

    /**
     * validate add fee on confirm booking admin page
     */
    public boolean isAddFeeTextVisible(String addfeeName){
        Locator addFeeName = page.locator("//input[@value='"+addfeeName+"']");
        return playwright.waitTillLocatorIsVisible(addFeeName);
    }
}
