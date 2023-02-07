package steps.mamikos.owner;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.owner.kelolatagihan.BillDetailsPO;
import pageobject.owner.OwnerDashboardPO;
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
        month = month.equalsIgnoreCase("next")
                ? JavaHelpers.getMonthName(new Locale("id", "ID"), 1)
                : month;
        ownerDashboard.clickOnManagementKost();
        billManage = ownerDashboard.clickOnKelolaKos();
        billManage.selectKosFilter(kostName);
        billManage.selectMonthFilter(month);
    }

    @And("owner go to detail tagihan")
    public void ownerGoToDetailTagihan() {
        billdetail = billManage.clickOnInvoiceList();
    }

    @Then("owner can see additional price biaya lainnya {string} with price {string}")
    public void ownerCanSeeAdditionalPriceBiayaLainnyaWithPrice(String additionalPriceTitle, String additionalPriceValue) {
        Assert.assertEquals(billdetail.getAdditionalPriceValueText(additionalPriceTitle), additionalPriceValue);
    }
}
