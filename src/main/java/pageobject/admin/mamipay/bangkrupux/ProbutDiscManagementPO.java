package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

import java.nio.file.Path;
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
    private Locator searchButton;
    private Locator kostName;
    private Locator redirectionLink;
    private Locator kostNameOnDetail;
    private Locator mappingStatusType;
    private Locator mappingStatusText;

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
        this.searchButton = page.locator("//button[@id=\"buttonSearch\"]");
        this.kostName = page.locator("//span[@class=\"font-semi-large\"]").first();
        this.redirectionLink = page.locator("//a[@class=\"text-success\"]").first();
        this.mappingStatusType = page.locator("//select[@name=\"mapping-status\"]");
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

//    /**
//     * click on search button
//     */
//    public void clickOnSearchButton() {
//        playwrightHelpers.clickOn(searchButton);
//    }

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
    public void selectMappingStatus(String text) {
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
}
