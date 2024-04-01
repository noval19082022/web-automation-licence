package pageobject.admin.mamipay.bangkrupux;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.PlaywrightHelpers;

import java.nio.file.Paths;

public class ProbutDiscManagementPO {
    private PlaywrightHelpers playwrightHelpers;
    private Locator bulkActionBtn;
    private Locator uploadBtn;
    private Locator removeBtn;
    private Locator choosenFileCsvInputForUpload;
    private Locator choosenFileCsvInputForRemove;
    private Locator uploadBulkBtn;
    private Locator removeBulkBtn;

    public ProbutDiscManagementPO(Page page) {
        this.playwrightHelpers = new PlaywrightHelpers(page);
        this.bulkActionBtn = page.getByRole(AriaRole.BUTTON).getByText("Bulk Action");
        this.uploadBtn = page.locator("a[data-target='#bulkUpload']");
        this.removeBtn = page.locator("a[data-target='#bulkRemove']");
        this.choosenFileCsvInputForUpload = page.locator("#bulkUploadInput");
        this.choosenFileCsvInputForRemove = page.locator("#bulkRemoveInput");
        this.uploadBulkBtn = page.locator("#bulkUploadButton");
        this.removeBulkBtn = page.locator("#bulkRemoveButton");
    }

    public void uploadBulkDiscountCsv(String fileName) {
        playwrightHelpers.clickOn(bulkActionBtn);
        playwrightHelpers.clickOn(uploadBtn);
        choosenFileCsvInputForUpload.setInputFiles(
                Paths.get("src/main/resources/file/bulk-probut-discount-management/upload/" + fileName));
        playwrightHelpers.hardWait(500.0);
        playwrightHelpers.clickOn(uploadBulkBtn);
    }

    public void removeBulkDiscountCsv(String fileName) {
        playwrightHelpers.clickOn(bulkActionBtn);
        playwrightHelpers.clickOn(removeBtn);
        choosenFileCsvInputForRemove.setInputFiles(
                Paths.get("src/main/resources/file/bulk-probut-discount-management/remove/" + fileName));
        playwrightHelpers.hardWait(500.0);
        playwrightHelpers.clickOn(removeBulkBtn);
    }
}
