package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

public class AdditionalKostPO {
    private Page page;
    private PlaywrightHelpers playwright;
    Locator additionalKostMenuButton;
    Locator searchTextField;
    Locator searchButton;
    Locator aturKetersediaanButton;
    Locator roomStatusButton;
    Locator updateRoomStatusButton;
    Locator errorAlertInformationText;
    Locator successAlertInfromationText;
    Locator floorTextField;
    Locator searchRoomId;
    Locator deleteRoomButton;
    Locator deletePopupText;


    public AdditionalKostPO(Page page) {
        this.page = page;
        this.playwright = new PlaywrightHelpers(page);
        additionalKostMenuButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Kost (Additional)"));
        searchTextField = page.getByPlaceholder("Nama Kost");
        searchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Search"));
        aturKetersediaanButton = page.locator("//a[contains(text(),'Atur Ketersediaan')]");
        roomStatusButton = page.locator("//*[@class='form-group'][3]/select");
        updateRoomStatusButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Update"));
        errorAlertInformationText = page.getByText("Kamar dengan aktif tenant kontrak tidak bisa diubah.");
        successAlertInfromationText = page.locator("//*[@class='alert alert-success alert-dismissable']/b");
        floorTextField = page.locator("#floor");
        searchRoomId= page.getByLabel("Search:");
        deleteRoomButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Delete"));
        deletePopupText = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Delete Confirmation"));
    }

    /**
     * click menu Additional Kost
     */
    public void clickAdditionalKostMenu(){
        playwright.waitTillLocatorIsVisible(additionalKostMenuButton);
        playwright.clickOn(additionalKostMenuButton);

    }

    /**
     * search kos in Kos Additional menu
     * @param keyword kos name
     */
    public void searchKosAdditional(String keyword){
        playwright.clickOn(searchTextField);
        playwright.fill(searchTextField, keyword);
        playwright.clickOn(searchButton);
    }

    /**
     * click Atur Ketersediaan Button
     */
    public void clickButtonAturKetersediaan(){
        playwright.waitTillLocatorIsVisible(aturKetersediaanButton);
        playwright.clickOn(aturKetersediaanButton);
    }

    /**
     * click Edit Button
     *
     */
    public void clickOnEditButton(String name){
        Locator editButton = page.locator("//*[@class='btn btn-sm btn-info'][@data-name=" +name+ "]");
        playwright.clickOn(editButton);
    }
    /**
     * select roomstatus and click update button
     *
     */
    public void updateRoomStatusToEmpty(String updateRoom) {
       playwright.clickOn(roomStatusButton);
       playwright.selectDropdownByValue(roomStatusButton, updateRoom);
       playwright.clickOn(updateRoomStatusButton);
    }

    /**
     * Get error alert after udpate
     */
    public String getAlertText(String text){
        return playwright.getText(errorAlertInformationText);
    }

    /**
     * Get success alert after udpate
     */
    public String getSuccessAlertText(String text){
      return playwright.getText(successAlertInfromationText);
    }

    /**
     * update floor text
     */
    public void updateFloorName(String keyword){
      playwright.clearText(floorTextField);
      playwright.clickLocatorAndTypeKeyboard(floorTextField, keyword);
      playwright.clickOn(updateRoomStatusButton);
    }

    /**
     * click Delete  Button
     */
    public void clickOnDeteleButton(String text){
        playwright.clickLocatorAndTypeKeyboard(searchRoomId, text);
        playwright.clickOn(deleteRoomButton);
    }

    /**
     * Get delete confirmation popup
     */
    public String getPopupDeleteConfirmationText() {
        return playwright.getText(deletePopupText);
    }
}
