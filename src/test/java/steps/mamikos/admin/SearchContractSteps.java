package steps.mamikos.admin;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.admin.mamipay.AdminMamipayDashboardPO;
import pageobject.admin.mamipay.contract.SearchContractPO;
import utilities.PlaywrightHelpers;

import java.util.List;
import java.util.Map;

public class SearchContractSteps {
    List<Map<String, String>> searchData;
    private Page page = ActiveContext.getActivePage();
    private PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    private SearchContractPO searchContract = new SearchContractPO(page);
    private AdminMamipayDashboardPO admin = new AdminMamipayDashboardPO(page);

    @When("admin go to {string} menu")
    public void adminGoestToLeftMenu(String menu) {
        admin.clickOnTextHyperlink(menu);
    }

    @When("admin search contract by kost level {string}")
    public void adminSearchContractByKostLevel(String kostLevel) {
        searchContract.selectKosLevel(kostLevel);
        searchContract.clickOnSearchButton();
    }

    @And("admin want to search contract periode for {string}")
    public void searchContractFor(String periode) {
        searchContract.selectPeriodSearchContract(periode);
    }

    @When("admin search contract by {string} and input field {string}")
    public void adminSearchContractBy(String searchBy, String inputField) {
        admin.clickOnSearchContract();
        searchContract.selectSearchBy(searchBy);
        searchContract.fillSearchByValue(inputField);
        searchContract.clickOnSearchButton();
    }

    @And("admin want to edit deposit")
    public void editDeposit() {
        searchContract.clickOnEditDepositButton();
    }

    @And("admin input detail kerusakan {string} on edit deposit page")
    public void inputDetailKerusakan(String text) {
        String inputMorethan200 = null;
        for (int i = 0; i < 10; i++) {
            inputMorethan200 = inputMorethan200 + text;
        }
        searchContract.inputDetailKerusakan(inputMorethan200);
    }

    @Then("admin see maximal length {string}")
    public void maxlength(String max) {
        Assert.assertTrue(admin.getPopUpText(max), "max text not equals " + max);
    }

    @Then("admin will get blank data detail")
    public void adminGetBlankData() {
        Assert.assertTrue(admin.getPopUpText("Search Contract"), "Search Contract");
        Assert.assertTrue(searchContract.checkBlankData(), "Data Display");
    }

    @Then("admin redirect to search contract menu detail")
    public void searcContractMenu() {
        Assert.assertTrue(searchContract.isSearchContractHeaderVisible(), "Search Contract Header is not visible");
    }

    @And("admin want to see log contract")
    public void seeLog() {
        searchContract.clickOnSeeLogButton();
    }

    @Then("admin will see detail pop up {string}")
    public void detailPopUp(String popUp) {
        Assert.assertTrue(admin.getPopUpText(popUp), "pop up " + popUp + " is doesn't appear");
    }

    @And("admin input biaya kerusakan {string}")
    public void biayaKerusakan(String biayaKerusakan) {
        admin.inputBiayaKerusakanOnEditDposit(biayaKerusakan);
    }

    @Then("admin will see additional notes menu deposit")
    public void sisaDeposit() {
        Assert.assertTrue(admin.getAdditionalNotesMenuOnDetailPopup(), "Additional notes menu transaction pop up is doesn't appear");
    }

    @Then("admin want to akhiri contract but akhiri kontrak button is disabled")
    public void akhiriButtonIsDisable() {
        Assert.assertTrue(searchContract.isTerminatedContractButtonDissable(), "Akhiri Konrak button is not disable");
    }

    @When("admin search contract by tenant phone number:")
    public void adminSearchContractByTenantPhoneNumber(DataTable table) {
        searchData = table.asMaps(String.class, String.class);
        var phoneNumber = searchData.get(0).get("phone " + Mamikos.ENV);
        admin.clickOnSearchContract();
        searchContract.selectSearchBy("renter_phone_number");
        searchContract.fillSearchByValue(phoneNumber);
        searchContract.clickOnSearchButton();
    }

    @And("admin cancel contract")
    public void adminCancelContract() {
        searchContract.clickOnCancelContractButton();
    }

    @And("admin terminate contract")
    public void adminTerminateContract() {
        searchContract.clickOnTerminateContractButton();
    }

    @Then("admin should success terminate contract")
    public void adminShouldSuccessTerminateContract() {
        if (searchContract.waitUntilSuccessTerminateVisible()) {
            Assert.assertEquals(searchContract.getSuccessTerminateHeadingText().trim(), "Kontrak berhasil diakhiri.");
        }
    }

    @When("admin akhiri contract")
    public void adminAkhiriContract() {
        searchContract.clickOnAkhiriContractButton();
    }

    @When("admin search contract by tenant kost name:")
    public void adminSearchContractByTenantKostName(DataTable table) {
        searchData = table.asMaps(String.class, String.class);
        var kostName = searchData.get(0).get("kostName " + Mamikos.ENV);
        admin.clickOnSearchContract();
        searchContract.selectSearchBy("kost_name");
        searchContract.fillSearchByValue(kostName);
        searchContract.clickOnSearchButton();
    }
}
