package steps.mamikos.admin;


import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.admin.mamipay.GolplusContractPO;
import utilities.PlaywrightHelpers;


public class GolplusContractSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    private GolplusContractPO goldplusContractPO = new GolplusContractPO(page);


    @When("admin search contract based on phone number {string}")
    public void admin_search_contract_based_on_phone_number(String phone) {
        goldplusContractPO.searchContract(phone);
        goldplusContractPO.clickOnButtonSearchContract();
    }

    @Then("admin verify owner phone is {string} with goldplus package {string} and status contract is {string}")
    public void admin_verify_owner_phone_is_with_goldplus_package_and_status_contract_is(String phone, String gpPackage, String status) {
       Assert.assertEquals(goldplusContractPO.getPhoneNumber(phone),phone,"phone number doesnt match");
        Assert.assertEquals(goldplusContractPO.getGpPackage(gpPackage).replaceAll("\n", "").replaceAll("\\s+", " "),gpPackage,"gp package doesnt match");
        Assert.assertEquals(goldplusContractPO.getStatusContractGP(status),status,"status gp doesnt match");

    }

    @Then("admin search contract based on {string} is {string}")
    public void admin_search_contract_based_on_is(String ownerName, String owner){
       goldplusContractPO.selectDropdownOwnerName(ownerName);
       goldplusContractPO.searchContract(owner);
       goldplusContractPO.clickOnButtonSearchContract();
    }

    @Then("admin verify owner name is {string} with goldplus package {string} and status contract is {string}")
    public void admin_verify_owner_name_is_with_goldplus_package_and_status_contract_is(String owner, String gpPackage, String status) {
        Assert.assertEquals(goldplusContractPO.getOwnerName(owner).replaceAll("\n","").replaceAll("[0-9]", "").replaceAll("\\s+", " "),owner,"owner name doesnt match");
        Assert.assertEquals(goldplusContractPO.getGpPackage(gpPackage).replaceAll("\n", "").replaceAll("\\s+", " "),gpPackage,"gp package doesnt match");
        Assert.assertEquals(goldplusContractPO.getStatusContractGP(status),status,"status gp doesnt match");

    }

    @Then("admin select package {string}")
    public void admin_select_package(String periode) {
        goldplusContractPO.searchContractByPeriode(periode);
        goldplusContractPO.clickOnButtonSearchContract();

    }

    @Then("admin verify list of goldplus contracts is {string}")
    public void admin_verify_list_of_goldplus_contracts_is(String gpPackage) {
        Assert.assertEquals(goldplusContractPO.getTextGP(gpPackage).replaceAll("\n", "").replaceAll("\\s+", " "),gpPackage,"gp package doesnt match");
    }

    @Then("admin choose status GoldPlus Contract with {string}")
    public void admin_choose_status_gold_plus_contract_with(String periode) {
       goldplusContractPO.searchContractByStatusContract(periode);
       goldplusContractPO.clickOnButtonSearchContract();
    }

    @Then("admin verify list of goldplus contracts status is {string} {string}")
    public void admin_verify_list_of_goldplus_contracts_status_is(String status,String value) {
       for (int i = 0; i < goldplusContractPO.getResultsElement(status,value).size(); i++) {
            Assert.assertEquals(goldplusContractPO.getStatusResult(value, status, i), value, "Auto extend value is not equal to " + value);
        }

    }
    @Then("admin wants to reset form search")
    public void admin_wants_to_reset_form_search() {
        goldplusContractPO.clickOnButtonResetContract();
    }

    @When("admin wants to see detail contract")
    public void admin_wants_to_see_detail_contract() {
        goldplusContractPO.clickOnShowOrders();
    }

    @When("admin can see page contract order from phone number {string}")
    public void admin_can_see_page_contract_order_from_phone_number(String phone) {
        Assert.assertTrue(goldplusContractPO.getHeaderContractOrder(),"header not show");
        Assert.assertEquals(goldplusContractPO.getPhoneNumberFromOrder(phone).replaceAll("[^0-9]", "").replace("[!@#$%^&*:]", ""),phone,"phone number doesnt match");

    }

    @When("admin can see list {string} with status {string} , invoice status is {string}")
    public void admin_can_see_list_with_status_invoice_status_is(String gp, String status, String invoiceStatus) {
       Assert.assertEquals(goldplusContractPO.getGoldplusOrder(gp).replaceAll("\n", "").replaceAll("\\s+", " "),gp,"pacakge doesnt match");
        Assert.assertEquals(goldplusContractPO.getStatusGoldplusOrder(status),status,"status gp doesnt match");
        Assert.assertEquals(goldplusContractPO.getStatusInvoiceGoldplusOrder(invoiceStatus),invoiceStatus,"invoice status doesnt match");
    }
}
