package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

import java.nio.file.Paths;

public class ProbutDiscManagementPO {
    private PlaywrightHelpers playwrightHelpers;
    private Page page;
    private Locator bulkActionBtn;
    private Locator uploadBtn;
    private Locator removeBtn;
    private Locator choosenFileCsvInputForUpload;
    private Locator choosenFileCsvInputForRemove;
    private Locator uploadBulkBtn;
    private Locator removeBulkBtn;
    private Locator inputListingNameText;
    private Locator kostName;
    private Locator redirectionLink;
    private Locator mappingStatusType;
    private Locator mappingStatusText;
    private Locator percentageInput;
    private Locator persentageText;

    public ProbutDiscManagementPO(Page page) {
        this.page = page;
        this.playwrightHelpers = new PlaywrightHelpers(page);
        this.bulkActionBtn = page.getByRole(AriaRole.BUTTON).getByText("Bulk Action");
        this.uploadBtn = page.locator("a[data-target='#bulkUpload']");
        this.removeBtn = page.locator("a[data-target='#bulkRemove']");
        this.choosenFileCsvInputForUpload = page.locator("#bulkUploadInput");
        this.choosenFileCsvInputForRemove = page.locator("#bulkRemoveInput");
        this.uploadBulkBtn = page.locator("#bulkUploadButton");
        this.removeBulkBtn = page.locator("#bulkRemoveButton");
        this.inputListingNameText = page.locator("//input[@placeholder=\"Listing Name\"]");
        this.kostName = page.locator("//span[@class=\"font-semi-large\"]").first();
        this.redirectionLink = page.locator("//a[@class=\"text-success\"]").first();
        this.percentageInput = page.locator("//input[@name=\"percentage\"]");
    }

    public void uploadBulkDiscountCsv(String fileName) {
        playwrightHelpers.clickOn(bulkActionBtn);
        playwrightHelpers.clickOn(uploadBtn);
        choosenFileCsvInputForUpload.setInputFiles(
                Paths.get("src/main/resources/file/bulk-probut-discount-management/upload/" + fileName));
        playwrightHelpers.hardWait(500.0);
        if (playwrightHelpers.isButtonEnable(uploadBulkBtn)) {
            playwrightHelpers.clickOn(uploadBulkBtn);
        }
    }

    public void removeBulkDiscountCsv(String fileName) {
        playwrightHelpers.clickOn(bulkActionBtn);
        playwrightHelpers.clickOn(removeBtn);
        choosenFileCsvInputForRemove.setInputFiles(
                Paths.get("src/main/resources/file/bulk-probut-discount-management/remove/" + fileName));
        playwrightHelpers.hardWait(500.0);
        if (playwrightHelpers.isButtonEnable(removeBulkBtn)) {
            playwrightHelpers.clickOn(removeBulkBtn);
        }
    }

    /**
     * Search by Listing name
     * @param listingName
     */
    public void searchByListingName(String listingName) {
        playwrightHelpers.fill(inputListingNameText, listingName);

    }

    /**
     * click on redirection link
     */
    public void clickOnRedirectionLink() {
        playwrightHelpers.clickOn(redirectionLink);
    }

    /**
     * Verify search result
     * @return
     */
    public String verifyKostNameSearchResult() {
        playwrightHelpers.waitTillLocatorIsVisible(kostName);
        return playwrightHelpers.getText(kostName);
    }

    /**
     * select mapping status
     * @param text
     */
    public void selectMappingStatus(String type,String text) {
        mappingStatusType = page.locator("//select[@name='"+type+"']");
        playwrightHelpers.clickOn(mappingStatusType);
        if(text.equalsIgnoreCase("All Mapping Status")){
            playwrightHelpers.selectDropdownByValue(mappingStatusType, "all");
        }
        else if(text.equalsIgnoreCase("Live")){
            playwrightHelpers.selectDropdownByValue(mappingStatusType, "mapped");
        }
        else if(text.equalsIgnoreCase("Not Live")){
            playwrightHelpers.selectDropdownByValue(mappingStatusType, "unmapped");
        }
        else if(text.equalsIgnoreCase("All")){
            playwrightHelpers.selectDropdownByValue(mappingStatusType, "0");
        }
        else if(text.equalsIgnoreCase("Active")){
            playwrightHelpers.selectDropdownByValue(mappingStatusType, "1");
        }
        else if(text.equalsIgnoreCase("Inactive")){
            playwrightHelpers.selectDropdownByValue(mappingStatusType, "3");
        }
        else if(text.equalsIgnoreCase("All Discount")){
            playwrightHelpers.selectDropdownByValue(mappingStatusType, "all");
        }
        else if(text.equalsIgnoreCase("Mamikos")){
            playwrightHelpers.selectDropdownByValue(mappingStatusType, "mamikos");
        }
        else if(text.equalsIgnoreCase("Owner")){
            playwrightHelpers.selectDropdownByValue(mappingStatusType, "owner");
        }
    }

    /**
     * get mapping status text
     * @param text
     * @return text example "Live"
     */
    public String getMappingStatusText(String text){
        mappingStatusText = page.locator("//td[contains(.,'"+text+"')]").first();
        playwrightHelpers.waitTillPageLoaded();
        return playwrightHelpers.getText(mappingStatusText);
    }

    /**
     * input persentage
     * @param text
     */
    public void inputPersentage(String text){
        playwrightHelpers.fill(percentageInput, text);
    }

    /**
     * get persentage text on list
     * @param text
     * @return
     */
    public String getPersentageText(String text){
        persentageText = page.locator("//strong[contains(.,'"+text+"')]").first();
        playwrightHelpers.waitTillPageLoaded();
        return playwrightHelpers.getText(persentageText);
    }
}
