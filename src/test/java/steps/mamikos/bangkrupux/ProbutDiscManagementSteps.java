package steps.mamikos.bangkrupux;

import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.java.en.And;
import pageobject.admin.mamipay.bangkrupux.ProbutDiscManagementPO;
import utilities.PlaywrightHelpers;

public class ProbutDiscManagementSteps {

    ProbutDiscManagementPO probutDiscManagementPO = new ProbutDiscManagementPO(ActiveContext.getActivePage());

    @And("Admin bangkrupux visit promo ngebut discount management")
    public void probutDiscountManagement() {
        new PlaywrightHelpers(ActiveContext.getActivePage())
                .navigateTo(Mamikos.URL + "/admin/booking/discount");
    }

    @And("Admin upload csv discount management with file names {string}")
    public void adminUploadCsvDiscountManagementWithFileNames(String fileName) {
        probutDiscManagementPO.uploadBulkDiscountCsv(fileName);
    }

    @And("Admin remove using csv discount management with file names {string}")
    public void adminRemoveUsingCsvDiscountManagementWithFileNames(String fileName) {
        probutDiscManagementPO.removeBulkDiscountCsv(fileName);
    }
}
