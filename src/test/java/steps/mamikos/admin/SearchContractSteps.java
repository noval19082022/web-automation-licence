package steps.mamikos.admin;

import com.microsoft.playwright.Page;
import config.global.FlowControl;
import config.playwright.context.ActiveContext;
import data.api.AjukanSewaStatus;
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
        if (!playwright.getActivePageURL().contains("/backoffice/contract/search")) {
            playwright.navigateTo(Mamikos.ADMINMAMIPAY + "/backoffice/contract/search");
        }

        searchContract.selectKosLevel(kostLevel);
        searchContract.clickOnSearchButton();
    }

    @And("admin search contract by Renter Phone Number and input field {string}")
    public void adminSearchContractByRenterPhoneNumberAndInputField(String phoneNumber) {
        admin.clickOnSearchContract();
        searchContract.selectRenterPhoneNumber(phoneNumber);
        searchContract.clickOnSearchButton();
    }

    @And("admin want to search contract periode for {string}")
    public void searchContractFor(String periode) {
        searchContract.selectPeriodSearchContract(periode);
        searchContract.clickOnSearchButton();
    }

    @When("admin search contract by {string} and input field {string}")
    public void adminSearchContractBy(String searchBy, String inputField) {
        admin.clickOnSearchContract();
        searchContract.selectSearchBy(searchBy);
        searchContract.fillSearchByValue(inputField);
        searchContract.clickOnSearchButton();
    }

    @And("admin want to batalkan contract if exist")
    public void cancelIfExist() {
        searchContract.batalkanContractIfExist();
    }

    @And("admin want to edit deposit")
    public void editDeposit() {
        searchContract.clickOnEditDepositButton();
    }

    @And("admin want to extend contract")
    public void extendContract() {
        searchContract.clickOnExtendContractButton();
    }

    @And("admin input detail kerusakan {string} on edit deposit page")
    public void inputDetailKerusakan(String text) {
        String inputMorethan200 = null;
        for (int i = 0; i < 10; i++) {
            inputMorethan200 = inputMorethan200 + text;
        }
        searchContract.inputDetailKerusakan(inputMorethan200);
    }

    @And("admin want to choose {string} for transfer deposit")
    public void chooseBank(String bankName) {
        searchContract.chooseBankOnEditDepositPage(bankName);
    }

    @And("admin input nomor rekening on edit deposit page {string}")
    public void inputRekening(String rekening) {
        searchContract.inputRekeningOnEditDepositPage(rekening);
    }

    @And("admin input nama pemilik rekening on edit deposit page {string}")
    public void inputRekname(String rekeningName) {
        searchContract.inputRekeningNameOnEditDepositPage(rekeningName);
    }

    @And("admin input transfer date on edit deposit page {string}")
    public void inputDate(String date) {
        searchContract.inputTransferDateOnEditDepositPage(date);
    }

    @Then("admin see dropdown close and see bank {string}")
    public void bank(String bankName) {
        Assert.assertEquals(searchContract.getTextBankOnEditDeposit(bankName), bankName);
    }

    @Then("admin will see Konfirmasi Sisa Deposit button hidden")
    public void sisaDepositBtn() {
        Assert.assertTrue(searchContract.isSisaDepositBtnDisable());
    }

    @Then("admin verify see text {string}")
    public void seeText(String text) {
        boolean textFound = admin.getPopUpText(text);
        if (!textFound) {
            String actualMessages = admin.getAllVisibleMessages();
            Assert.assertTrue(textFound, "Expected text '" + text + "' not found. Actual messages found:\n" + actualMessages);
        }
    }

    @Then("admin see maximal length {string}")
    public void maxlength(String max) {
        Assert.assertTrue(admin.getPopUpText(max), "max text not equals " + max);
    }

    @Then("admin will get blank data detail")
    public void adminGetBlankData() {
        Assert.assertTrue(admin.getPopUpText("Search Contract"), "Search Contract");
        Assert.assertFalse(searchContract.isContractDataVisible(), "Data contract is Display");
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

    @And("admin want to simpan draft edit deposit")
    public void adminWantToSimpanDraftEditDeposit() {
        searchContract.simpanDraftEditDeposit();
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
        Assert.assertTrue(searchContract.waitForCalloutMessage(), "Callout message did not appear after terminating contract");
        String calloutText = searchContract.getCalloutText();
        Assert.assertTrue(calloutText.contains("Kontrak berhasil"), "Expected callout to contain 'Kontrak berhasil' but got: " + calloutText);
    }

    @When("admin akhiri contract")
    public void adminAkhiriContract() {
        searchContract.clickOnAkhiriContractButton();
    }

    @And("admin search contract by tenant phone number and akhiri contract:")
    public void adminSearchContractByTenantPhoneNumberAndAkhiriContract(DataTable table) {
        searchData = table.asMaps(String.class, String.class);
        var phoneNumber = searchData.get(0).get("phone " + Mamikos.ENV);
        var akhiriContractButtonSize = 0;
        if (AjukanSewaStatus.isContractPresent() || !FlowControl.isApiFlow()) {
            admin.clickOnSearchContract();
            searchContract.selectSearchBy("renter_phone_number");
            searchContract.fillSearchByValue(phoneNumber);
            searchContract.clickOnSearchButton();
            if (searchContract.isAkhiriContractButtonVisible()) {
                akhiriContractButtonSize = searchContract.getAkhiriContractButtonSize();
                for(int i = 0; i < akhiriContractButtonSize; i++) {
                    searchContract.clickOnAkhiriContractButton();
                    Assert.assertTrue(searchContract.waitForCalloutMessage(), "Callout message did not appear after terminating contract");
                    String calloutText = searchContract.getCalloutText();
                    Assert.assertTrue(calloutText.contains("Kontrak berhasil"), "Expected callout to contain 'Kontrak berhasil' but got: " + calloutText);
                    if (akhiriContractButtonSize > 1) {
                        //improvement should add break condition when iterate is equal to akhiriContractButtonSize
                        searchContract.selectSearchBy("renter_phone_number");
                        searchContract.fillSearchByValue(phoneNumber);
                        searchContract.clickOnSearchButton();
                    }
                }
            }
        }
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

    @When("admin clicks on invoice number {string} on first index contract")
    public void admin_clicks_on_invoice_number_on_first_index_contract(String index) {
        searchContract.clicksOnInvoiceNumberOnFirstIndex(index);
    }

    @Then("admin verify table header row is displayed with name:")
    public void admin_verify_table_header_row_is_displayed_with_name(List<String> tableHeader) {
        for (String s : tableHeader) {
            searchContract.isTableHeaderVisible(s);
        }
    }
}
