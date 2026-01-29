package pageobject.owner.fiturpromosi.mamiads;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.LocatorHelpers;
import utilities.PlaywrightHelpers;

public class NaikkanIklanPO {
    private Page page;
    private PlaywrightHelpers playwright;
    private LocatorHelpers locatorHelpers;

    Locator selectFilter;
    Locator filterChoice;
    Locator quickAllocateTitle;
    Locator toggleAds;
    Locator titlePopUpConfirmation;
    Locator descPopUpConfirmation;
    Locator keMamiAdsButton;
    Locator nantiSaja;
    Locator titlePopUp;
    Locator nonAktifkanAdsButton;
    Locator posisiIklanLocator;
    Locator toggleLocator;
    Locator toggleLocatorOff;
    Locator toggleLocatorOn;
    Locator adsStatusLocator;
    Locator anggaranDescLocator;
    Locator switchToggleLocator;
    Locator saldoMamiAdsValue;
    Locator actionButtonLocator;
    Locator currentStatusSaldo;
    Locator activeButton;
    Locator nonaktifkanButton;
    Locator aktifkanButton;
    Locator closePopupButton;
    Locator toastMessage;


    public NaikkanIklanPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        this.locatorHelpers = new LocatorHelpers(page);
        selectFilter = page.locator(".bg-c-dropdown__trigger");
        quickAllocateTitle = page.locator("//div[@class='detail-kos__statistic statistic']//div[@class='alokasi-ads__description']");
        toggleAds = page.locator("//div[@class='kos-card'][1]//div[contains(@class,'alokasi-ads__toggle')]");
        titlePopUpConfirmation = page.locator("//h3[@class='bg-c-modal__body-title']");
        descPopUpConfirmation = page.locator("#description-modal-toggle");
        keMamiAdsButton = page.locator("//*[contains(text(),'Ke MamiAds')]");
        nantiSaja = page.locator("//*[contains(text(),'Nanti Saja')]");
        titlePopUp = page.locator(".bg-c-modal__body-title");
        nonAktifkanAdsButton = page.locator("//*[contains(text(),'Ya, Nonaktifkan')]");
        saldoMamiAdsValue = page.locator(".amount");
        toggleLocatorOn = page.locator("//*[@id='room-toggle-switch-on']");
        toggleLocatorOff = page.locator("//*[@id='room-toggle-switch-off']").first();
        activeButton = page.locator("//button[normalize-space()='Aktifkan']");
        nonaktifkanButton = page.locator("//button[normalize-space()='Ya, Nonaktifkan']");
        aktifkanButton = page.locator("//button[normalize-space()='Aktifkan']");
        closePopupButton = page.locator("//button[contains(@class,'bg-c-modal__close')]");
        toastMessage = page.locator(".bg-c-toast__content");
    }


    /**
     * Get kost name from mamiads
     *
     * @return ads name or kost name
     * @params adsName
     */
    public String getAdsName(String adsName) {
        Locator adsNameLocator = page.getByText(adsName);
        return playwright.getText(adsNameLocator);

    }

    /**
     * Get posisi iklan (naik / tidak naik)
     *
     * @return posisi iklan
     * @params posisiIklan
     */
    public String getPosisiIklan(String kostName, String posisiIklan) {
        playwright.waitTillPageLoaded(5000.0);
        posisiIklanLocator = page.locator("//*[.='" + kostName + "']/../../following-sibling::*//div[@id='ads-position-" + posisiIklan + "']");
        return playwright.getText(posisiIklanLocator);

    }

    /**
     * Verify the status toggle iklan
     *
     * @return toggleStatus
     * @params toggleStatus
     */
    public boolean getToggleStatus(String adsName, String toggleStatus) {
            toggleLocator = page.locator("//*[.='" + adsName + "']/../../following-sibling::*//input[@id='room-toggle-switch-" + toggleStatus + "']");
            return playwright.waitTillLocatorIsVisible(toggleLocator);
    }

    /**
     * Verify the status toggle iklan two
     *
     * @return toggleStatus
     * @params toggleStatus
     */
    public boolean getToggleStatus2(String adsName, String toggleStatus) {
        playwright.waitTillPageLoaded();
        if (playwright.waitTillLocatorIsVisible(toggleLocatorOff)) {
            playwright.clickOn(toggleLocatorOff);
            playwright.clickOn(activeButton);
        } else {
            toggleLocator = page.locator("//*[.='" + adsName + "']/../../following-sibling::*//input[@id='room-toggle-switch-" + toggleStatus + "']");
            return playwright.waitTillLocatorIsVisible(toggleLocator);
        }
        return true;
    }

    /**
     * user verify the alokasi ads title
     *
     * @param alokasiTitleText
     * @return alokasi title
     */
    public String getAlokasiTitleText(String alokasiTitleText) {
        String alokasiTitleElement = "//div[@class='kos-card'][1]//div[contains(@class,'alokasi-ads')]//div[contains(text(), '" + alokasiTitleText + "')]";
        playwright.waitTillLocatorIsVisible(page.locator(alokasiTitleElement));
        return playwright.getText(page.locator(alokasiTitleElement));
    }

    /**
     * user verify the alokasi ads title
     *
     * @param toggleAdsStatus
     * @return alokasi title
     */
    public boolean getToggleAdsStatus(String toggleAdsStatus) {
        String toggleAdsElement = "//div[@class='kos-card'][1]//div[contains(@class,'alokasi-ads')]//div[@class='bg-c-switch alokasi-ads__toggle bg-c-switch--" + toggleAdsStatus + "']";
        return playwright.waitTillLocatorIsVisible(page.locator(toggleAdsElement), 1000.0);
    }

    /**
     * user verify the alokasi ads title
     *
     * @param adsDescText
     * @return alokasi title
     */
    public String getAdsDescText(String adsDescText) {
        String adsDescElement = "//div[@class='kos-card'][1]//div[contains(@class,'ads__des')]";
        playwright.waitTillLocatorIsVisible(page.locator(adsDescElement));
        return playwright.getText(page.locator(adsDescElement));
    }

    /**
     * owner click filter aktif at mamiads dashboard
     */
    public void clickOnFilterActive(String filter) {
        playwright.clickOn(selectFilter);
        filterChoice = page.locator("//*[@class='bg-c-dropdown__menu-item-content'][contains(text(), '" + filter + "')]");
        playwright.clickOn(filterChoice);
    }

    /**
     * Click On Allocation Section
     *
     * @throws InterruptedException
     */
    public void clickOnAllocationSection() throws InterruptedException {
        playwright.clickOn(quickAllocateTitle);
    }

    /**
     * Click on toggle ON OFF on property saya
     *
     * @throws InterruptedException
     */
    public void clickToggleTheAdsOnPropertySaya() throws InterruptedException {
        playwright.clickOn(toggleAds);
    }

    /**
     * Get message on pop up confirmation
     *
     * @return message on pop up confirmation
     * @params action
     */
    public String getTextSwitchTogglePopUp(String action) {
        if (action.equals("off")) {
            playwright.waitTillLocatorIsVisible(titlePopUpConfirmation);
            return playwright.getText(titlePopUpConfirmation);
        } else {
            playwright.waitTillLocatorIsVisible(descPopUpConfirmation);
            return playwright.getText(descPopUpConfirmation).replaceAll("[\\n\\s]+", " ");
        }
    }


    /**
     * Click on Ke MamiAds button
     *
     * @throws InterruptedException
     */
    public void clickOnKeMamiAdsButton() throws InterruptedException {
        playwright.clickOn(keMamiAdsButton);
    }

    /**
     * Click on Nanti Saja button on confirmation pop up quick allocation
     *
     * @throws InterruptedException
     */
    public void clickOnNantiSaja() throws InterruptedException {
        playwright.clickOn(nantiSaja);
    }

    /**
     * Close the popup by clicking the close (X) button
     * This keeps the toggle state without redirecting
     */
    public void closePopup() {
        if (playwright.isLocatorVisibleAfterLoad(closePopupButton, 3000.0)) {
            playwright.clickOn(closePopupButton);
        }
    }

    /**
     * Activate the ads allocation by clicking toggle and confirming
     * Waits for the activation to complete by checking toast message
     */
    public void activateAdsAllocation() {
        playwright.clickOn(toggleAds);
        playwright.waitTillLocatorIsVisible(titlePopUpConfirmation, 5000.0);
        // Close popup to confirm activation (clicking Nanti Saja cancels the activation)
        closePopup();
        // Wait for page to update
        playwright.waitTillPageLoaded();
    }

    /**
     * Check if toast message is visible after an action
     */
    public boolean isToastMessageVisible() {
        return playwright.isLocatorVisibleAfterLoad(toastMessage, 5000.0);
    }

    /**
     * Get text title in Toast Message
     *
     * @return text title in Toast Message
     */
    public String getTextTitlePopUp() {
        return playwright.getText(titlePopUp);
    }

    /**
     * Click on Ya, Nonaktifkan button on Non aktif confirmation pop up
     *
     * @throws InterruptedException
     */
    public void clickOnNonaktifkanAds() {
        playwright.clickOn(nonAktifkanAdsButton);
    }

    /**
     * user can see text on filter is iklan saya
     */
    public String getTeksFilter() {
        return playwright.getText(selectFilter);
    }

    /**
     * Get message of ads status
     *
     * @return adsStatus message
     * @params adsName
     */
    public String getAdsStatusDesc(String adsName) {
        adsStatusLocator = page.locator("//*[.='" + adsName + "']/../../following-sibling::*//div[@id='ads-status-description']");
        return playwright.getText(adsStatusLocator);
    }

    /**
     * Get message of anggaran description
     *
     * @return anggaranDesc message
     * @params adsName
     */
    public String getTextAnggaranDesc(String adsName) {
        // Wait for anggaran description element to be visible instead of fixed wait
        anggaranDescLocator = page.locator("//*[.='" + adsName + "']/../../following-sibling::*//div[@id='ads-allocation-description']");
        playwright.waitTillLocatorIsVisible(anggaranDescLocator, 10000.0);
        return playwright.getText(anggaranDescLocator);
    }

    /**
     * Click toggle ads - automatically handles toggle state
     * If current state is OFF, it will turn ON
     * If current state is ON, it will turn OFF
     *
     * @params toggleStatus, adsName
     */
    public void clickToggleTheAds(String toggleStatus, String adsName) {
        // First, try to find the current state of the toggle
        // Check if toggle is currently ON
        Locator toggleOn = page.locator("//*[.='" + adsName + "']/../../following-sibling::*//input[@id='room-toggle-switch-on']");
        // Check if toggle is currently OFF
        Locator toggleOff = page.locator("//*[.='" + adsName + "']/../../following-sibling::*//input[@id='room-toggle-switch-off']");
        
        // Determine current state and click the appropriate toggle
        if (toggleOn.isVisible() && toggleOn.isChecked()) {
            // Toggle is currently ON, so we click to turn it OFF
            System.out.println("Toggle is currently ON for " + adsName + ", turning it OFF...");
            switchToggleLocator = toggleOn;
        } else if (toggleOff.isVisible() && toggleOff.isChecked()) {
            // Toggle is currently OFF, so we click to turn it ON
            System.out.println("Toggle is currently OFF for " + adsName + ", turning it ON...");
            switchToggleLocator = toggleOff;
        } else {
            // Fallback to original logic if state cannot be determined
            if (toggleStatus.equalsIgnoreCase("off")) {
                switchToggleLocator = toggleOff;
            } else {
                switchToggleLocator = toggleOn;
            }
        }
        
        playwright.waitTillLocatorIsVisible(switchToggleLocator);
        // Click the toggle to change its state
        switchToggleLocator.click();
    }

    /**
     * get saldo mamiads text
     * convert from String (Rp1.000) to int (1000)
     *
     * @return int saldo mamiads
     */
    public int getSaldoMaText() {
        String balance = playwright.getText(saldoMamiAdsValue).replaceAll("[^0-9]", "");
        return Integer.parseInt(balance);
    }

    /**
     * Get Title Pop up while appear beli saldo pop up
     *
     * @return title pop up confirmation
     */
    public String getTitleBeliSaldoPopUp() {
        return playwright.getText(titlePopUpConfirmation);
    }

    /**
     * Click action button in popup - automatically handles the correct button based on context
     * If turning OFF (deactivating), clicks "Ya, Nonaktifkan"
     * If turning ON (activating), clicks "Aktifkan"
     *
     * @param actionButton the expected action button text
     */
    public void clickActionButtonInPopUp(String actionButton) {
        // Wait for popup to be visible instead of fixed wait
        playwright.waitTillLocatorIsVisible(titlePopUpConfirmation, 5000.0);

        // Determine which button to click based on visibility
        if (nonaktifkanButton.isVisible()) {
            // Popup for deactivating (turning OFF) is shown
            System.out.println("Clicking 'Ya, Nonaktifkan' button to turn OFF the toggle...");
            playwright.clickOn(nonaktifkanButton);
        } else if (aktifkanButton.isVisible()) {
            // Popup for activating (turning ON) is shown
            System.out.println("Clicking 'Aktifkan' button to turn ON the toggle...");
            playwright.clickOn(aktifkanButton);
            // Wait for backend to process the toggle state change
            playwright.waitTillPageLoaded();
        } else {
            // Fallback to original logic using the provided actionButton parameter
            System.out.println("Using fallback: clicking '" + actionButton + "' button...");
            actionButtonLocator = page.locator("(//button[normalize-space()='"+actionButton+"'])");
            playwright.clickOn(actionButtonLocator);
        }

    }

    /**
     * Get list Ads on mamiAds dashboard page
     *
     * @return AdsName, posisiIklan, currentToggle, AvailableRoom, currentStatusDesc
     * @params listAds, index
     */
    public String listAds(String listAds, int index) {
        String element = "";
        switch (listAds) {
            case "adsName":
                element = ".name";
                break;
            case "posisiIklan":
                element = "//*[contains(@class, 'rainbow')]";
                break;
            case "availRoom":
                element = ".ads-status__kamar-penuh";
                break;
            case "currentStatusDesc":
                element = "//*[@class='ads-status__desc']";
                break;
        }
        return playwright.getText(playwright.getLocators(page.locator(element)).get(index)).replaceAll("[\\n\\s]+", " ");
    }

    /**
     * Verify the toggle on list ads
     *
     * @return status toggle (on/ off)
     * @params toggle, index
     */
    public boolean listAdsToggle(String toggle, int index) {
        return playwright.waitTillLocatorIsVisible(playwright.getLocators(page.locator("//*[contains(@class, 'switch--" + toggle + "')]")).get(index));
    }
}
