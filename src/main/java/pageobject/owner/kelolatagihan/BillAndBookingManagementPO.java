package pageobject.owner.kelolatagihan;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

public class BillAndBookingManagementPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private LocatorHelpers locator;
    Locator nomorKamarInput;
    Locator pilihKamarRadio;
    Locator terapkanButton;
    Locator lanjutkanButton;
    Locator simpanButton;
    Locator okButton;
    String roomAllotmentWrapper;
    Locator reasonChoice;
    Locator IUnderstandBtn;
    Locator statusTandC;
    Locator pilihButton;
    Locator doneButton;
    Locator lihatDetailButton;
    Locator confirmationPopup;
    Locator makeRuleButton;
    Locator makeRuleBookingPage;


    public BillAndBookingManagementPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.locator = new LocatorHelpers(page);
        nomorKamarInput = page.getByPlaceholder("Silakan pilih nomor kamar");
        pilihKamarRadio = page.locator(".mami-radio");
        terapkanButton = playwright.locatorByRoleSetName(locator.roleButton, "Terapkan");
        lanjutkanButton = playwright.locatorByRoleSetName(locator.roleButton, "Lanjutkan");
        simpanButton = playwright.locatorByRoleSetName(locator.roleButton, "Simpan");
        okButton = playwright.locatorByRoleSetName(locator.roleButton, "OK");
        roomAllotmentWrapper = "#roomAllotmentWrapper.modal.fade";
        IUnderstandBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Saya Mengerti"));
        statusTandC = page.locator("span").filter(new Locator.FilterOptions().setHasText("checkmark"));
        pilihButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pilih"));
        reasonChoice = page.locator(".reject-modal__reason-option-overlay").first();
        doneButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Selesai"));
        lihatDetailButton = page.locator("(//span[normalize-space()='Lihat Detail'])[1]");
        confirmationPopup = page.locator("//h3[@class='bg-c-modal__body-title']");
        makeRuleButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Buat peraturan"));
        makeRuleBookingPage = page.getByText("Peraturan saat masuk kos");
    }

    /**
     * Click on room number input
     */
    public void clickOnRoomNumberInput() throws InterruptedException {
        try {
            int maxLoop = 0;
            while (!pilihKamarRadio.first().isVisible() && maxLoop < 3) {
                playwright.forceClickOn(nomorKamarInput);
                page.waitForTimeout(3000);
                maxLoop++;
            }
        } catch (Exception e) {
            playwright.forceClickOn(nomorKamarInput);
            page.waitForSelector(roomAllotmentWrapper, new Page.WaitForSelectorOptions().setTimeout(3000));
        }
    }


    /**
     * Click on pilih ditempat radio
     */
    public void clickOnPilihDitempat() {
        pilihKamarRadio.first().click();
    }

    /**
     * Click on terapkan button
     */
    public void clickOnTerapkanButton() {
        terapkanButton.click();
    }

    /**
     * Click on lanjutkan button
     */
    public void clickOnLanjutkanButton() {
        lanjutkanButton.click();
    }

    /**
     * Click on simpan button
     */
    public void clickOnSimpan() {
        simpanButton.click();
    }

    /**
     * Click ok button after owner accepted new tenant
     */
    public PengajuanBookingPO clickOkButton() {
        playwright.clickAndWaitNavigation(okButton);
        return new PengajuanBookingPO(page);
    }

    /**
     * Click on one of the rooms radio
     */
    public void clickOnOneRooms() {
        pilihKamarRadio.nth(1).click();
    }

    /**
     * choose reason to reject booking
     */
    public void ownerChooseReasonReject () {
        playwright.clickOn(reasonChoice);
        playwright.waitTillLocatorIsVisible(IUnderstandBtn);
        playwright.clickOn(IUnderstandBtn);
        playwright.clickOn(statusTandC);
    }

    /**
     * Click pilih button after owner reject  tenant
     */
    public PengajuanBookingPO clickPilihButton() {
        playwright.clickOn(pilihButton);
        playwright.clickOn(doneButton);
        return new PengajuanBookingPO(page);
    }

    /**
     * Click on lihat detail
     */
    public void clickOnLihatDetailButton() {
        lihatDetailButton.waitFor();
        lihatDetailButton.click();
    }

    /**
     * Click on reason reject booking
     */
    public PengajuanBookingPO ownerSelectRejectBookingKos(String reason) {
        String selector = "//div[@class='reject-modal__reason-list']/div[contains(.,'"+reason+"')]";
        ElementHandle element = page.querySelector(selector);
        element.click();
        playwright.pageScrollUntilElementIsVisible(statusTandC);
        playwright.clickOn(statusTandC);
        playwright.clickOn(pilihButton);
        return new PengajuanBookingPO(page);
    }

    /**
     * Check confirmation Atur Booking popup
     * @return confirmation Atur Booking popup
     */
    public boolean isAppearConfirmationPopup() {
        return playwright.waitTillLocatorIsVisible(confirmationPopup);
    }
    /**
     * Click on reason reject booking
     */
    public PengajuanBookingPO ownerClickOnMakeRulesBookingButton() {
        playwright.clickOn(makeRuleButton);
        return new PengajuanBookingPO(page);
    }
    /**
     * Check direct make rule page
     * @return make rule page
     */
    public boolean isAppearMakeRuleBookingPage() {
        return playwright.waitTillLocatorIsVisible(makeRuleBookingPage);
    }
}
