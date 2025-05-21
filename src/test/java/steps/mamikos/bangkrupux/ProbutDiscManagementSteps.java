package steps.mamikos.bangkrupux;

import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
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

    @And("Admin search by listing name with {string}")
    public void adminSearchByListingNameWith(String listingName) {
        probutDiscManagementPO.searchByListingName(listingName);
    }

    @Then("admin can see kost name on discount management page")
    public void adminCanSeeKostNameOnDiscountManagementPage() {
        probutDiscManagementPO.verifyKostNameSearchResult();
    }

    @And("admin click on redirection link kost name")
    public void adminClickOnRedirectionLinkKostName() {
        probutDiscManagementPO.clickOnRedirectionLink();
    }

    @And("admin choose filter Mapping status with {string}")
    public void adminChooseFilterMappingStatusWith(String text) {
        probutDiscManagementPO.selectMappingStatus(text);
    }

    @Then("admin can see status {string} on list")
    public void adminCanSeeStatusOnList(String text) {
        Assert.assertEquals(probutDiscManagementPO.getMappingStatusText(text), text, "live not found");
    }

}
