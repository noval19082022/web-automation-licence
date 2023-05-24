package pageobject.owner;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class GoldplusPO {
    private Page page;
    private PlaywrightHelpers playwright;
    Locator broadcastChatBtn;
    Locator warningBroadcastText;
    Locator closePopUpIcon;
    Locator goldplusPhoneNumberInput;
    Locator editPackageAdminGP1Button;
    Locator editPackageAdminGP2Button;
    Locator selectRadioButtonNo;
    Locator selectRadioButtonYes;

    public GoldplusPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        broadcastChatBtn = page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText("'broadcast-message'"));
        warningBroadcastText = page.locator("//h3[@class='bg-c-modal__body-title']");
        closePopUpIcon = page.locator(".bg-c-modal__action-closable");
        goldplusPhoneNumberInput = page.locator("form").filter(new Locator.FilterOptions().setHasText("Reset")).getByPlaceholder("Phone Number");
        editPackageAdminGP1Button = page.locator("//tr[4]//div[@class='btn-group']");
        editPackageAdminGP2Button = page.locator("//tr[5]//div[@class='btn-group']");
        selectRadioButtonNo = page.locator("[value='0'][name='is_recommended']");
        selectRadioButtonYes = page.locator("[value='1'][name='is_recommended']");
    }

    /**
     * Input phone number to reset Goldplus
     */
    public void inputGoldplusPhoneNumber (String phoneNumberGP) {
        goldplusPhoneNumberInput.fill(phoneNumberGP);
    }

    /**
     * Get list periode gp, salldo free mamiads, actual price, discount price
     *
     * @param index input with listPeriod
     * @return String periode gp, salldo free mamiads, actual price, discount price
     */
    public String listPeriod(String listPeriod, int index) {
        String element = "";
        switch (listPeriod) {
            case "periodGP":
                element = ".goldplus-periode-select__option-label-package";
                break;
            case "freeMamiAds":
                element = ".goldplus-periode-select__option-label-mamiads";
                break;
            case "actualPrice":
                element = ".goldplus-periode-select__option-price-actual";
                break;
            case "discPrice":
                element = ".goldplus-periode-select__option-price-discount";
                break;
        }
        return playwright.getText(playwright.getLocators(page.locator(element)).get(index));
    }

    /**
     * Click on edit golplus button
     *
     */
    public void clickOnEditGP1Button() {
        playwright.clickOn(editPackageAdminGP1Button);
    }

    /**
     * Click on edit golplus button
     *
     */
    public void clickOnEditGP2Button() {
        playwright.clickOn(editPackageAdminGP2Button);
    }

    /**
     * Click on radio button No
     *
     */
    public void clickNoRadioButton() {
        playwright.clickOn(selectRadioButtonNo);
    }

    /**
     * Click on radio button Yes
     *
     */
    public void clickYesRadioButton() {
        playwright.clickOn(selectRadioButtonYes);
    }

}
