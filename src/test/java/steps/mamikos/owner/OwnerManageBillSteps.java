package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
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


    @When("owner go to bill page of kost {string} on month of {string}")
    public void ownerGoToBillPageOfKostOnMonthOf(String kostName, String month) {
        if (month.equalsIgnoreCase("next")) {
            month = JavaHelpers.getMonthName(new Locale("id", "ID"), 1);
        } else if(month.equalsIgnoreCase("current")) {
            month = JavaHelpers.getMonthName(new Locale("id", "ID"), 0);
        }
        ownerDashboard.clickOnManagementKost();
        billManage = ownerDashboard.clickOnKelolaKos();
        billManage.reloadOnEmptyKelolaTagihanPage();
        billManage.selectKosBillPageFilter(kostName);
        billManage.selectMonthFilter(month);
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
        billManage.clicksOnLihatSelengkapnya();

    }
}
