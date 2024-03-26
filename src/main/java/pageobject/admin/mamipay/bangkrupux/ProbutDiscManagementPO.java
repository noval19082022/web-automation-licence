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
    private Locator choosenFileCsvInput;
    private Locator uploadBulkBtn;

    public ProbutDiscManagementPO(Page page) {
        this.playwrightHelpers = new PlaywrightHelpers(page);
        this.bulkActionBtn = page.getByRole(AriaRole.BUTTON).getByText("Bulk Action");
        this.uploadBtn = page.locator("a[data-target='#bulkUpload']");
        this.choosenFileCsvInput = page.locator("#bulkUploadInput");
        this.uploadBulkBtn = page.locator("#bulkUploadButton");
    }

    public void uploadBulkDiscountCsv(String fileName) {
        playwrightHelpers.clickOn(bulkActionBtn);
        playwrightHelpers.clickOn(uploadBtn);
        choosenFileCsvInput.setInputFiles(Paths.get("src/main/resources/file/bulk-probut-discount-management/" + fileName));
        playwrightHelpers.hardWait(500.0);
        playwrightHelpers.clickOn(uploadBulkBtn);
    }
}
