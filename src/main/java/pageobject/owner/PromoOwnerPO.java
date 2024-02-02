package pageobject.owner;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import config.playwright.context.ActiveContext;
import lombok.Getter;
import lombok.Setter;
import pageobject.common.LoadingPO;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;


public class PromoOwnerPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private LoadingPO loading;
    @Setter @Getter private String judulPromoOwner;

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
    Locator theNextMonthButton;

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

    /**
     * Click atur promo button
     * redefine variable page because when click atur promo button will be open new tab
     * @return active page
     *
     */
    public Page clickOnAturPromo(){
        page = page.waitForPopup(() -> {
            playwright.clickOn(aturPromo);
        });
        ActiveContext.setActivePage(page);
        return ActiveContext.getActivePage();
    }

    /**
     * Get Text promo status
     * @param promoStatus
     * @return status (Belum Ada, Menunggu Verifikasi, Aktif)
     *
     */
    public String getTextStatus(String promoStatus) {
        Locator status = page.getByText(promoStatus);
        return playwright.getText(status);
    }

    /**
     * Verify is Button Promo
     * @param buttonText
     * @return promoButton
     *
     */
    public boolean isButtonPromo(String buttonText) {
        Locator promoButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(buttonText));
        return playwright.waitTillLocatorIsVisible(promoButton,1000.0);
    }

    /**
     * Click buat promo button
     * All status promo, the button still Buat Promo
     *
     */
    public void clickOnBuatPromo() {
        Locator buatPromoButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Buat Promo"));
        playwright.clickOn(buatPromoButton);
    }

    /**
     * Input promo owner (judul, deskripsi, start date, end date promo)
     * @param titleText
     */
    public void inputPromoOwner(String titleText) {
        judulPromoField = page.locator("(//*[@class='input'])[1]");
        detailPromoField = page.locator("//*[@class='textarea']");

        setJudulPromoOwner(titleText);
        playwright.forceFill(judulPromoField, titleText);
        playwright.forceFill(detailPromoField, "Deskripsi promo create owner");
    }

    /**
     * Select start date promo
     * @param periodePromo
     *
     */
    public void selectStartDatePromo(String periodePromo) {
        startDatePicker = page.locator("//div[contains(@class, 'period1')]//input[@class='input']");
        playwright.pageScrollUntilElementIsVisible(startDatePicker);
        playwright.clickOn(startDatePicker);
        String locatorElement;
        var todayDate = JavaHelpers.getCurrentDateOrTime("d");
        var tomorrowDate = JavaHelpers.getCostumDateOrTime("d", 1, 0, 0);
        theNextMonthButton = page.getByTestId("premiumPromo").getByRole(AriaRole.BANNER).locator("i").nth(1);
        if (!(Integer.parseInt(todayDate) < Integer.parseInt(tomorrowDate))){
            playwright.forceClickOn(theNextMonthButton);
        }
        var theDayAfterTomorrowDate = JavaHelpers.getCostumDateOrTime("d", 2, 0, 0);
        try {
            switch (periodePromo){
                case "tomorrow":
                    locatorElement = tomorrowDate;
                    break;
                case "the day after tomorrow":
                    locatorElement = theDayAfterTomorrowDate;
                    break;
                default:
                    locatorElement = periodePromo;
            }
        } catch (Exception e) {
            throw new IllegalStateException("Unexpected value: " + periodePromo);
        }
        Locator startDatePromo = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(locatorElement).setExact(true));
        playwright.clickOn(startDatePromo);
    }

    /**
     * Select end date promo
     * @param periodePromo
     *
     */
    public void selectEndDatePromo(String periodePromo) {
        endDatePicker = page.locator("//div[contains(@class, 'period2')]//input[@class='input']");
        playwright.clickOn(endDatePicker);
        var todayDate = JavaHelpers.getCurrentDateOrTime("d");
        theNextMonthButton = page.getByTestId("premiumPromo").getByRole(AriaRole.BANNER).locator("i").nth(1);

        String locatorElement;
        var tomorrowDate = JavaHelpers.getCostumDateOrTime("d", 1, 0, 0);
        if (!(Integer.parseInt(todayDate) < Integer.parseInt(tomorrowDate))){
            playwright.forceClickOn(theNextMonthButton);
        }
        var theDayAfterTomorrowDate = JavaHelpers.getCostumDateOrTime("d", 2, 0, 0);
        var theNextMonthDate = page.locator("//i[@class='mdi mdi-chevron-right mdi-24px']/following::*//div[@class='dropdown-menu']");

        try {
            switch (periodePromo){
                case "tomorrow":
                    locatorElement = tomorrowDate;
                    break;
                case "the day after tomorrow":
                    locatorElement = theDayAfterTomorrowDate;
                    break;
                default:
                    locatorElement = periodePromo;
            }
        } catch (Exception e) {
            throw new IllegalStateException("Unexpected value: " + periodePromo);
        }
        Locator endDatePromo = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(locatorElement).setExact(true));
        playwright.clickOn(endDatePromo);
    }

    /**
     * Click button Pasang promo
     * Appear when status promo is Belum Ada
     *
     */
    public void clickOnPasangPromo() {
        pasangPromoButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pasang Promo"));
        playwright.clickOn(pasangPromoButton);
    }

    /**
     * Verify edit promo displayed
     * @return boolean (true, false)
     *
     */
    public boolean isEditPromoButton() {
        return playwright.isButtonWithTextDisplayed("Edit Promo");
    }

    /**
     * Edit judul promo owner
     * @param titleText
     *
     */
    public void editPromoOwner(String titleText) {
        judulPromoField = page.locator("(//*[@class='input'])[1]");
        playwright.forceFill(judulPromoField, titleText);
        setJudulPromoOwner(titleText);

        playwright.clickOnText("Edit Promo");
    }

    /**
     * Get warning message
     * @param warningText
     * @return
     */
    public String getTextWarningMessage(String warningText) {
        warningMessagePromo = page.locator(".premium-promo-field__date-error");
        return playwright.getText(warningMessagePromo);
    }

    /**
     * Click Seacrh promo box on admin
     *
     */
    public void clickOnSeachPromo(String promoTitle) {
        playwright.forceFill(searchPromoBox, "Update promo owner AT");
        playwright.clickOn(searchButton);
    }

    /**
     * Verify status promo is Unverified on admin
     * @return boolean verificationAdminStatus
     */
    public boolean isUnverifiedStatus() {
        return playwright.waitTillLocatorIsVisible(verificationAdminStatus);
    }

    /**
     * Click verification promo button
     *
     *
     */
    public void clickOnVerificationPromo() {
        playwright.clickOn(verifiedPromoButton);
    }

    /**
     * Get alert success update message on admin
     * @return alertSuccessAdmin message
     *
     */
    public String getAlertSuccessUpdate() {
        playwright.waitTillLocatorIsVisible(alertSuccessAdmin);
        return playwright.getText(alertSuccessAdmin).replaceAll("×\\s+", "");
    }

    /**
     * Click unverification promo button
     *
     *
     */
    public void clickOnUnverificationPromo() {
        playwright.clickOn(unverificationPromoButton);
    }

    /**
     * Click edit promo button
     *
     *
     */
    public void clickOnEditPromo() {
        editPromoButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Edit Promo"));

        playwright.clickOn(editPromoButton);
    }

    /**
     * Click delete promo from admin
     * click OK on dialog confirmation pop up
     *
     */
    public void clickOnDeletePromo() {
        if (playwright.waitTillLocatorIsVisible(deletePromoButton)){
            playwright.clickOn(deletePromoButton);
            playwright.acceptDialog(deletePromoButton);
        }
    }

    /**
     * Click promo owner for non GP
     * if owner non GP, there is no new tab
     *
     */
    public void clickOnPromoNonGP() {
       playwright.clickOn(lihatSelengkapnyaButton);
       playwright.clickOn(aturPromo);
    }
}