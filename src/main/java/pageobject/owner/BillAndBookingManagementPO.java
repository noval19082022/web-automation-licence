package pageobject.owner;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

public class BillAndBookingManagementPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private LocatorHelpers locator;
    Locator nomorKamarInput;
    Locator pilihDiTempatRadio;
    Locator terapkanButton;
    Locator lanjutkanButton;
    Locator simpanButton;
    Locator okButton;
    public BillAndBookingManagementPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.locator = new LocatorHelpers(page);
        nomorKamarInput = page.locator("#inputRoomNumber");
        pilihDiTempatRadio = page.locator(".mami-radio").first();
        terapkanButton = playwright.locatorByRoleSetName(locator.roleButton, "Terapkan");
        lanjutkanButton = playwright.locatorByRoleSetName(locator.roleButton, "Lanjutkan");
        simpanButton = playwright.locatorByRoleSetName(locator.roleButton, "Simpan");
        okButton = playwright.locatorByRoleSetName(locator.roleButton, "OK");
    }

    /**
     * Click on room number input
     */
    public void clickOnRoomNumberInput() throws InterruptedException {
        int maxLoop = 0;
        do {
            maxLoop++;
            playwright.forceClickOn(nomorKamarInput);
            Thread.sleep(1000);
            if (maxLoop == 2)
                break;
        }
        while (!pilihDiTempatRadio.isVisible());
    }

    /**
     * Click on pilih ditempat radio
     */
    public void clickOnPilihDitempat() {
        pilihDiTempatRadio.click();
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
}
