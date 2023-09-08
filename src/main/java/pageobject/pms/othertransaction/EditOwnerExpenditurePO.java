package pageobject.pms.othertransaction;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class EditOwnerExpenditurePO {
    private Page page;

    Locator actionButton;
    Locator actionUbahButton;
    Locator deleteAttachmentButton;
    Locator ubahDataButton;
    Locator confirmUbahButton;

    public EditOwnerExpenditurePO(Page page) {
        this.page = page;

        actionButton = page.getByTestId("table-action-trigger");
        actionUbahButton = page.getByText("Ubah");
        deleteAttachmentButton = page.getByTestId("soft-delete-attachment");
        ubahDataButton = page.getByTestId("update-expenditure");
        confirmUbahButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ubah").setExact(true));
    }

    /**
     * Ubah Owner Expenditure
     */
    public void editOwnerExpenditure() {
        actionButton.first().click();
        actionUbahButton.first().click();
    }

    /**
     * Delete existing attachment
     */
    public void deleteAttachment() {
        deleteAttachmentButton.click();
    }

    /**
     * submit ubah owner expenditure
     */
    public void ubahOwnerExpenditure() {
        ubahDataButton.click();
        confirmUbahButton.click();
    }
}
