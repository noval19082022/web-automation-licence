package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.LoadingPO;
import pageobject.owner.OwnerDashboardPO;
import pageobject.owner.kelolatagihan.BillDetailsPO;
import pageobject.owner.kelolatagihan.TenantBillManagementPO;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

import java.util.Locale;

public class OwnerManageBillSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    OwnerDashboardPO ownerDashboard = new OwnerDashboardPO(page);
    TenantBillManagementPO billManage = new TenantBillManagementPO(page);
    BillDetailsPO billdetail = new BillDetailsPO(page);
    LoadingPO loading = new LoadingPO(page);


    @When("owner go to bill page of kost {string} on month of {string}")
    public void ownerGoToBillPageOfKostOnMonthOf(String kostName, String month) {
        var selectedMonthFilter = "";
        var currentMonth = JavaHelpers.getMonthName(new Locale("id", "ID"), 0);
        if (month.equalsIgnoreCase("next")) {
            selectedMonthFilter = JavaHelpers.getMonthName(new Locale("id", "ID"), 1);
        } else if(month.equalsIgnoreCase("current")) {
            selectedMonthFilter = JavaHelpers.getMonthName(new Locale("id", "ID"), 0);
        }
        loading.waitForLoadingIconDisappear();
        ownerDashboard.clickOnManagementKost();
        billManage = ownerDashboard.clickOnKelolaKos();
        billManage.reloadOnEmptyKelolaTagihanPage();
        loading.waitForLoadingIconDisappear();
        billManage.selectKosBillPageFilter(kostName);
        if (month.equalsIgnoreCase("next") && currentMonth.equalsIgnoreCase("Desember")) {
            billManage.clickOnFilterMonth();
            billManage.clickArrowNextMonthFilterButton();
            billManage.clickOnMonthNameOnFilterMonth(selectedMonthFilter);
        } else {
            billManage.selectMonthFilter(selectedMonthFilter);
        }
    }

    @When("owner go to detail tagihan")
    public void ownerGoToDetailTagihan() {
        billdetail = billManage.clickOnInvoiceList();
    }

    @When("owner go to detail tagihan with jatuh tempo is {string}")
    public void ownerGoToDetailTagihanWithJatuhTempoIs(String jatuhTempo) {
        billdetail = billManage.clickOnInvoiceList(jatuhTempo);
    }

    @Then("owner can see additional price {string} with price {string}")
    public void ownerCanSeeAdditionalPriceWithPrice(String additionalPriceTitle, String additionalPriceValue) {
        Assert.assertEquals(billdetail.getAdditionalPriceValueText(additionalPriceTitle), additionalPriceValue);
    }

    @And("owner go to detail tagihan with tenant name is {string} and jatuh tempo is {string}")
    public void ownerGoToDetailTagihanWithTenantNameIsAndJatuhTempoIs(String tenantName, String jatuhTempoDate) {
        billdetail = billManage.clickOnInvoiceList(tenantName, jatuhTempoDate);
    }

    @And("owner go to detail tagihan with tenant name is {string} and jatuh tempo is current month length")
    public void ownerGoToDetailTagihanWithTenantNameIsAndCurrenMonthLengthJatuhTempo(String tenantName) {
        int monthLength = JavaHelpers.getMonthLength();
        String jatuhTempo = "Belum bayar - Tenggat "+monthLength+" hari lagi";
        billdetail = billManage.clickOnInvoiceList(tenantName, jatuhTempo);
    }

    @And("user clicks Sudah bayar tab")
    public void userClicksSudahBayarTab() {
        billManage.clicksOnSudahBayarTab();
    }

    @Then("user will see Status Tagihan and money disbursed to owner’s bank {string}")
    public void userWillSeeStatusTagihanAndMoneyDisbursedToOwnerSBank(String labelSuccess) {
        Assert.assertEquals(billManage.getLabelSuccessTransfer(), labelSuccess);
    }

    @Then("user can see Penyewa list")
    public void userCanSeePenyewaList() {
        
    }

    @Then("user can see room number with {string}")
    public void userCanSeeRoomNumberWith(String roomNumber) {
        Assert.assertEquals(billManage.getRoomNumberText(),roomNumber, "doesn't not match for room number");
    }

    @And("user change room number with {string}")
    public void userChangeRoomNumberWith(String roomNumber) {
        billManage.clickOnUbahRoomNumberBtn();
        billManage.chooseRoomNumber(roomNumber);
    }

    @And("owner go to Penyewa page of kost {string}")
    public void ownerGoToPenyewaPageOfKost(String kostName) {
        ownerDashboard.clickOnManagementKost();
        billManage = ownerDashboard.clickOnPenyewaKos();
        billManage.searchKostPenyewa(kostName);
    }

    @Then("user can not see update room number button")
    public void userCannotSeeUpdateRoomNumber() {
        Assert.assertFalse(billManage.isUpdateRoomNumberVisible());
    }

    @And("user search kost in penyewa menu {string}")
    public void userSearchKostInPenyewaMenu(String kostName) {
        billManage.searchKostInPenyewaMenu(kostName);
    }

    @And("user click on kontrak sewa button")
    public void userClickOnKontrakSewaButton() {
        billManage.clickOnKontrakSewaButton();
    }

    @And("user click on tolak button")
    public void userClickOnTolakButton() {
        billManage.clickOnTolakButton();
    }

    @And("user click on Ubah kontrak penyewa button")
    public void userClickOnUbahKontrakPenyewaButton() {
        billManage.clickOnUbahKontrakPenyewaButton();
    }
    @And("user check prices penyewa owner are same to contract at kos saya {string}")
    public void userCheckPricePenyewaOnOwner(String price) {
        Assert.assertEquals(billManage.isPriceDisplayed(price), "Rp1.100.000 / bulan");
    }

    @Then("user can see {string} as tenant name, {string} as phone number, {string} status, and photo")
    public void user_can_see_tenant_name_phone_number_status_and_photo(String name, String phoneNumber, String status) {
        Assert.assertEquals(billManage.getTenantHeaderName(name),name);
        Assert.assertEquals(billManage.getHeaderPhoneNumber(phoneNumber),phoneNumber);
        Assert.assertEquals(billManage.getHeaderContractStatus(),status);
        billManage.isTenantPhotoVisible();
    }

    @When("user can see detail tenant \\({string}, {string}, {string}, {string})")
    public void user_can_see_detail_tenant(String name, String gender, String status, String job) {
        Assert.assertEquals(billManage.getDetailTenantName(name), name);
        Assert.assertEquals(billManage.getDetailTenantGender(gender),gender);
        Assert.assertEquals(billManage.getDetailTenantStatus(status),status);
        Assert.assertEquals(billManage.getDetailTenantJob(job),job);
    }

    @Then("user cannot see checkin tenant disclaimer alert")
    public void user_cannot_see_disclaimer() {
        Assert.assertFalse(billManage.isDisclaimerTextVisible());
    }

    @Then("user can see detail contract \\({string}, {string}, {string}, {string}, {string})")
    public void user_can_see_detail_contract(String start, String end, String total, String duration, String nearestBill) {
        Assert.assertEquals(billManage.getDetailStartContract(start),start);
        Assert.assertEquals(billManage.getDetailEndContract(end),end);
        Assert.assertTrue(billManage.getDetailTotalBill().contains(total));
        Assert.assertEquals(billManage.getDetailRentDuration(duration),duration);
        Assert.assertEquals(billManage.getDetailNearestBill(nearestBill),nearestBill);
    }

    @When("system display change contract rent button")
    public void system_display_change_contract_rent() {
        billManage.ubahKontrakPenyewaIsVisible();
    }

    @Then("system display terminate contract link")
    public void system_display_terminate_contract_link() {
        billManage.displayTerminateContract();
    }

    @And("user search kost {string}")
    public void user_search_kost(String searchKost) throws InterruptedException{
        billManage.searchKostPenyewa(searchKost);
    }

    @And("user click Selengkapnya button on {string} contract")
    public void user_click_selengkapnya_button_on_contract(String contract) throws InterruptedException {
        int numberOfList = billManage.getNumberListOfContract();
        for (int i=1; i<=numberOfList; i++){
            if (billManage.getContractName(i).equals(contract)){
                playwright.hardWait(2);
                billManage.clickSelengkapnyaContract(i);
                break;
            }
        }
    }

    @Then("user can see disclaimer {string}")
    public void user_can_see_disclaimer(String disclaimer) {
        Assert.assertTrue(billManage.getDisclaimerText().contains(disclaimer));
    }
}