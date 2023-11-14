package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;
import lombok.Setter;
import utilities.PlaywrightHelpers;

public class LevelManagementPO {
    private Page page;
    private PlaywrightHelpers playwright;
    @Setter @Getter private String kostLevelName;
    @Setter @Getter private String roomLevelName;

    Locator benefitField;
    Locator searchField;
    Locator searchButton;
    Locator messagePopUp;
    Locator editIcon;
    Locator deleteIcon;
    Locator successMessage;
    Locator chargingTypeField;
    Locator kostListMenu;

    public LevelManagementPO(Page page){
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);

        benefitField = page.locator("//input[@name='benefits[]']");
        searchField = page.locator("//input[@placeholder='Level Name']");
        searchButton = page.locator("//button[@id='buttonSearch']");
        messagePopUp = page.locator("//h2[@id='swal2-title']");
        editIcon = page.locator("//i[@class='fa fa-pencil']");
        deleteIcon = page.locator("//i[@class='fa fa-trash']");
        successMessage = page.locator("//div[@class='alert alert-success alert-dismissable']");
        chargingTypeField = page.locator("//select[@name='charging_type']");
    }

    /**
     * Click Add kost or room level button
     * @param levelType
     * e.g kost, room
     *
     */
    public void clickAddKostLevel(String levelType) {
        String element = "//a[contains(., 'Add "+ levelType +" Level')]";
        playwright.clickOn(page.locator(element));
    }

    /**
     * Input level name, notes on form kost level
     * @param idLocator
     * @param inputText
     *
     */
    public void inputFormKostLevel(String idLocator, String inputText) {
        String element = "//input[@id='"+ idLocator +"']";
        playwright.forceFill(page.locator(element), inputText);
    }


    /**
     * Input benefit on form kost level
     *
     *
     */
    public void inputBenefits() {
        playwright.forceFill(benefitField, "Untuk testing");
    }

    /**
     * Click save button
     *
     *
     */
    public void clickOnSaveButton() {
        playwright.clickOnTextButton("Save");
    }

    /**
     * Click on button save or cancel on confirmation pop up
     * @param actionText (confirm for save, and cancel for cancel)
     *
     */
    public void clickOnButtonPopUpConfirmation(String actionText) {
        String element = "//button[@class='swal2-"+ actionText +" swal2-styled']";
        playwright.clickOn(page.locator(element));
    }

    /**
     * Input new level name on search level name field
     * getKostLevelName take from variable KostLevelName
     * getRoomLevelName take from varibale RoomLevelName
     * @param type
     * e.g kost, room for type
     *
     */
    public void searchLevelName(String type) {
        if (type.equals("kost")){
            playwright.forceFill(searchField, getKostLevelName());
        } else if (type.equals("room")){
            playwright.forceFill(searchField, getRoomLevelName());
        }
    }

    /**
     * click search button kost level
     *
     *
     */
    public void clickOnSearchButton() {
        playwright.clickOn(searchButton);
    }

    /**
     * Get message validation on pop up confirmation
     * @return message pop up
     *
     */
    public String getMessageValidation() {
        return playwright.getText(messagePopUp);
    }

    /**
     * click edit icon kost level
     *
     *
     */
    public void clickEditKostLevel() {
        playwright.clickOn(editIcon);
    }

    /**
     * click delete icon kost level
     *
     *
     */
    public void clickDeleteKostLevel() {
        playwright.clickOn(deleteIcon);
        playwright.acceptDialog(deleteIcon);
    }

    /**
     * Get message success after add, edit, and delete rooms or kost
     * @return successMessage
     *
     */
    public String getSuccessDeleteMessage() {
        playwright.waitTillLocatorIsVisible(successMessage);
        return playwright.getText(successMessage).replaceAll("×\\s+", "");
    }

    /**
     * Select the dropdown charging type
     * @param chargingType
     * e.g Percentage, Amount for chargingType
     * Percentage value is added element selected on dropdown
     *
     */
    public void selectChargingType(String chargingType) {
        playwright.selectDropdownByValue(chargingTypeField, chargingType);
    }

    /**
     * Clicks Kost List menu
     * @param submenu
     */
    public void clickOnSubMenuOfManagementLevel(String submenu){
        playwright.waitTillPageLoaded();
        kostListMenu = page.locator("//a[@id='kost-level']/following-sibling::ul//span[text()='" +submenu+ "']");
        playwright.pageScrollInView(kostListMenu);
        playwright.clickOn(kostListMenu);
    }
}