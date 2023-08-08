package pageobject.owner;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import config.playwright.context.ActiveContext;
import utilities.PlaywrightHelpers;

public class PromoOwnerPO {
    private Page page;
    private PlaywrightHelpers playwright;
    public String judulPromoOwner;

    Locator lihatSelengkapnyaButton;
    Locator aturPromo;
    Locator judulPromoField;
    Locator detailPromoField;
    Locator startDatePicker;
    Locator endDatePicker;
    Locator pasangPromoButton;
    Locator editPromoButton;
    Locator searchPromoBox;
    Locator searchButton;
    Locator verifiedPromoButton;
    Locator verificationAdminStatus;
    Locator alertSuccessAdmin;
    Locator unverificationPromoButton;
    Locator warningMessagePromo;
    Locator deletePromoButton;

    public PromoOwnerPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);

        lihatSelengkapnyaButton = page.getByText("Lihat Selengkapnya").first();
        aturPromo = page.getByText("Atur Promo");
        searchPromoBox = page.locator("//*[@class = 'form-control input-sm']");
        searchButton = page.locator("//button[@id='buttonSearch']");
        verifiedPromoButton = page.locator("//a[@class='btn btn-xs btn-primary']");
        verificationAdminStatus = page.locator("//label[@class='label label-danger']");
        alertSuccessAdmin = page.locator("//div[@class='alert alert-success alert-dismissable']");
        unverificationPromoButton = page.locator("td:nth-of-type(7) .fa-times");
        deletePromoButton = page.locator("//i[@class='fa fa-trash-o']");
    }

    /**
     * Click selengkapnya button on kost list on property saya kos
     *
     *
     */
    public void clickOnSelengkapnya() {
        playwright.clickOn(lihatSelengkapnyaButton);
    }

    public Page clickOnAturPromo(){
        page = page.waitForPopup(() -> {
            playwright.clickOn(aturPromo);
        });
        ActiveContext.setActivePage(page);
        return ActiveContext.getActivePage();
    }

    public String getTextStatus(String promoStatus) {
        Locator status = page.getByText(promoStatus);
        return playwright.getText(status);
    }

    public boolean isButtonPromo(String buttonText) {
        Locator promoButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(buttonText));
        return playwright.waitTillLocatorIsVisible(promoButton,1000.0);
    }

    public void clickOnBuatPromo() {
        Locator buatPromoButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Buat Promo"));
        playwright.clickOn(buatPromoButton);
    }

    public void inputPromoOwner(String titleText) {
        judulPromoField = page.locator("(//*[@class='input'])[1]");
        detailPromoField = page.locator("//*[@class='textarea']");
        playwright.clickOn(judulPromoField);
        setJudulPromo(titleText);
        judulPromoField.fill(titleText);
        playwright.clickOn(detailPromoField);
        detailPromoField.fill("Deskripsi promo create owner");
    }

    private void setJudulPromo(String judulText) {
        judulPromoOwner = judulText;
    }

    public String getJudulPromoOwner() {
        return judulPromoOwner;
    }

    public void selectStartDatePromo(String periodePromo) {
        startDatePicker = page.locator("//div[contains(@class, 'period1')]//input[@class='input']");
        playwright.pageScrollUntilElementIsVisible(startDatePicker);
        playwright.clickOn(startDatePicker);
        Locator startDatePromo = null;
        String locatorElement;

        switch (periodePromo){
            case "tomorrow": locatorElement = "//*[@class='datepicker-cell is-selectable dots manual-selected']"; break;
            case "the day after tomorrow": locatorElement = ".datepicker1 div:nth-of-type(2) > a:nth-of-type(2)"; break;
            default:
                throw new IllegalStateException("Unexpected value: " + periodePromo);
        }

        startDatePromo = page.locator(locatorElement);
        playwright.hardWait(2000.0);
        playwright.clickOn(startDatePromo);
    }

    public void selectEndDatePromo(String periodePromo) {
        endDatePicker = page.locator("//div[contains(@class, 'period2')]//input[@class='input']");
        playwright.clickOn(endDatePicker);
        Locator endDatePromo = null;
        String locatorElement;

        switch (periodePromo){
            case "tomorrow": locatorElement = ".datepicker2 div:nth-of-type(2) > a:nth-of-type(1)"; break;
            case "the day after tomorrow": locatorElement = ".datepicker2 div:nth-of-type(2) > a:nth-of-type(2)"; break;
            default:
                throw new IllegalStateException("Unexpected value: " + periodePromo);
        }

        endDatePromo = page.locator(locatorElement);
        playwright.clickOn(endDatePromo);
    }

    public void clickOnPasangPromo() {
        pasangPromoButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pasang Promo"));
        playwright.clickOn(pasangPromoButton);
    }

    public String getPromoAnda() {
        return judulPromoOwner;
    }

    public boolean isEditPromoButton() {
        return playwright.isButtonWithTextDisplayed("Edit Promo");
    }

    public void editPromoOwner(String titleText) {
        judulPromoField = page.locator("(//*[@class='input'])[1]");
        playwright.clickOn(judulPromoField);
        judulPromoField.fill(titleText);
        setJudulPromo(titleText);

        playwright.clickOnText("Edit Promo");
    }

    public String getTextWarningMessage(String warningText) {
        warningMessagePromo = page.locator(".premium-promo-field__date-error");
        return playwright.getText(warningMessagePromo);
    }

    public boolean isWarningPeriodePromoDisplayed(String warningText) {
        System.out.println(playwright.isTextDisplayed(warningText));
        return playwright.isTextDisplayed(warningText);
    }

    public void clickOnSeachPromo() {
        playwright.clickOn(searchPromoBox);
        searchPromoBox.fill("Update promo owner AT");
        playwright.clickOn(searchButton);
    }

    public boolean isUnverifiedStatus() {
        return playwright.waitTillLocatorIsVisible(verificationAdminStatus);
    }

    public void clickOnVerificationPromo() {
        playwright.clickOn(verifiedPromoButton);
    }

    public String getAlertSuccessUpdate() {
        playwright.waitTillLocatorIsVisible(alertSuccessAdmin);
        return playwright.getText(alertSuccessAdmin).replaceAll("×\\s+", "");
    }

    public void clickOnUnverificationPromo() {
        playwright.clickOn(unverificationPromoButton);
    }

    public void clickOnEditPromo() {
        editPromoButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Edit Promo"));

        playwright.clickOn(editPromoButton);
    }

    public void clickOnDeletePromo() {
        playwright.clickOn(deletePromoButton);
        playwright.acceptDialog(deletePromoButton);
    }


}
