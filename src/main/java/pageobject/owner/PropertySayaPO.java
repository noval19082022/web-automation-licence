package pageobject.owner;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

import java.util.List;

public class PropertySayaPO {
    private Page page;
    private PlaywrightHelpers playwright;
    Locator kostDropdown;
    Locator searchKostTextbox;
    Locator lihatSelengkapnyaButton;
    Locator updateKamarButton;
    Locator editAction;
    Locator updateKamarCheckbox;
    Locator updateKamarButtonPopup;
    Locator firstKosNameLabel;
    Locator firstKosStatusLabel;
    Locator firstKosTypeLabel;
    Locator kostNameText;
    Locator seeOtherPriceButton;
    Locator priceKostTextBox;
    Locator continueInputDataButton;
    Locator updatePriceButton;
    Locator messageSuccessUpdatePrice;
    Locator firstSeeKosButton;
    Locator statisticChoiceSelection;
    Locator chatButton;
    Locator reviewButton;

    public PropertySayaPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        kostDropdown = page.getByText("Cari kos Anda disini...");
        searchKostTextbox = page.getByPlaceholder("Search");
        lihatSelengkapnyaButton = page.getByText("Lihat Selengkapnya").first();
        updateKamarButton = page.getByText("Update Kamar", new Page.GetByTextOptions().setExact(true));
        editAction = page.locator("(//*[@class='room-table__cta bg-c-icon bg-c-icon--md'])[1]");
        updateKamarCheckbox = page.locator("span").filter(new Locator.FilterOptions().setHasText("checkmark")).locator("svg");
        updateKamarButtonPopup = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Simpan"));
        firstKosNameLabel = page.locator(".owner-kos-list > div:nth-of-type(1) .kos-card__title > .text");
        seeOtherPriceButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lihat harga lainnya"));
        priceKostTextBox = page.locator("//*[@class='input property-room__price-item-input-currency satu']");
        continueInputDataButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lanjut Isi Data"));
        updatePriceButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Update Harga"));
        messageSuccessUpdatePrice = page.getByText("Harga berhasil diupdate");
        firstSeeKosButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Lihat Kos"));
        statisticChoiceSelection = page.locator(".statistic__choice");
        chatButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Chat 0"));
        reviewButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Review 0"));

    }

    /**
     * user as owner click kost dropdown
     * user enter kost name
     * user choose kost name
     */
    public void searchKostPropertySaya(String kostName){
        playwright.clickOn(kostDropdown);
        searchKostTextbox.fill(kostName);
        Locator kostSearch = page.locator("a").filter(new Locator.FilterOptions().setHasText(kostName));
        playwright.clickOn(kostSearch);
    }

    /**
     * user as owner click update kamar button
     *
     */
    public void clickUpdateKamarButton() {
        playwright.clickOn(lihatSelengkapnyaButton);
        playwright.clickOn(updateKamarButton);
    }

    /**
     * user as owner click update kamar kost button
     *
     */
    public void clickUpdateKamarEmptyButton() {
        playwright.waitTillLocatorIsVisible(editAction);
        playwright.clickOn(editAction);
        if (updateKamarCheckbox.isChecked()) {
            playwright.clickOn(updateKamarCheckbox);
            playwright.clickOn(updateKamarButtonPopup);
        }
    }

    /**
     * Get first kos name in kos list
     * @return string kos name
     */
    public String getFirstKosName() {
        return playwright.getText(firstKosNameLabel);
    }

    /**
     * Get first kos status in kos list
     * @return string kos status
     */
    public String getFirstKosStatus(String status) {
        firstKosStatusLabel = page.getByText(status).first();
        return playwright.getText(firstKosStatusLabel);
    }

    /**
     * Get first kos type in kos list
     * @return string kos type
     */
    public String getFirstKosType(String type) {
        firstKosTypeLabel = page.getByText(type).first();
        return playwright.getText(firstKosTypeLabel);
    }

    /**
     * Click on kos name in update price
     * @param kosName is kos name
     */
    public void clickOnKosName(String kosName) {
        kostNameText = page.locator("//span[.='"+kosName+"']");
        playwright.clickOn(kostNameText);
    }

    /**
     * Click on see other price button
     */
    public void clickSeeOtherPrices() {
        playwright.clickOn(seeOtherPriceButton);
    }

    /**
     * Enter Text in daily price text box
     * @param dailyPrice is text we want to search
     */
    public void inputDailyPriceKos(String dailyPrice) {
        priceKostTextBox.nth(1).clear();
        priceKostTextBox.nth(1).fill(dailyPrice);
    }

    /**
     * Enter Text in weekly price text box
     * @param weeklyPrice is text we want to search
     */
    public void inputWeeklyPrice(String weeklyPrice) {
        priceKostTextBox.nth(2).clear();
        priceKostTextBox.nth(2).fill(weeklyPrice);
    }

    /**
     * Enter Text in monthly price text box
     * @param monthlyPrice is text we want to search
     */
    public void inputMonthlyPrice(String monthlyPrice) {
        priceKostTextBox.first().clear();
        priceKostTextBox.first().fill(monthlyPrice);
    }

    /**
     * Enter Text in three monthly price text box
     * @param threeMonthlyPrice is text we want to search
     */
    public void inputThreeMonthlyPrice(String threeMonthlyPrice) {
        priceKostTextBox.nth(3).clear();
        priceKostTextBox.nth(3).fill(threeMonthlyPrice);
    }

    /**
     * Enter Text in six monthly price text box
     * @param sixMonthlyPrice is text we want to search
     */
    public void inputSixMonthlyPrice(String sixMonthlyPrice) {
        priceKostTextBox.nth(4).clear();
        priceKostTextBox.nth(4).fill(sixMonthlyPrice);
    }

    /**
     * Enter Text yearly price text box
     * @param yearlyPrice is text we want to search
     */
    public void inputYearlyPrice(String yearlyPrice) {
        priceKostTextBox.nth(5).clear();
        priceKostTextBox.nth(5).fill(yearlyPrice);
    }

    /**
     * Click 'Lanjut Isi Data' in attention pop up
     */
    public void clickContinueInputDataPopUp() {
        if (playwright.waitTillLocatorIsVisible(continueInputDataButton)){
            playwright.clickOn(continueInputDataButton);
        }
    }

    /**
     * Click on update button
     */
    public void clickButtonUpdate() {
        playwright.pageScrollUntilElementIsVisible(updatePriceButton);
        playwright.clickOn(updatePriceButton);
    }

    /**
     * Get message success update price
     * @return message success update price
     */
    public String getToastSuccessUpdatePrice() {
        return playwright.getText(messageSuccessUpdatePrice);
    }

    /**
     * Click on see kos button in first kos list
     */
    public void clickFirstSeeKos() {
        playwright.clickOn(firstSeeKosButton);
    }

    /**
     * Click on lihat selengkapnya button in first kos list
     */
    public void clickOnLihatSelengkapnyaButton() {
        playwright.clickOn(lihatSelengkapnyaButton);
    }

    /**
     * Click on chat button in kos list
     */
    public void clickChat() {
        playwright.clickOn(chatButton);
    }

    /**
     * Click on review button in kos list
     */
    public void clickReview() {
        playwright.clickOn(reviewButton);
    }

}
