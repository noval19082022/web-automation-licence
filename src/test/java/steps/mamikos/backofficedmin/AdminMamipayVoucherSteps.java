package steps.mamikos.backofficedmin;

import com.microsoft.playwright.Page;
import config.mamikos.Mamikos;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.admin.mamipay.AdminMamipayDashboardPO;
import pageobject.admin.mamipay.voucher.MamikosListMassVoucherPO;
import utilities.PlaywrightHelpers;

import java.util.List;
import java.util.Map;

public class AdminMamipayVoucherSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    AdminMamipayDashboardPO mamipayAdmin = new AdminMamipayDashboardPO(page);
    MamikosListMassVoucherPO massVoucherList = null;
    List<Map<String, String>> voucherAndKostName;

    @And("admin edit voucher and {string} it to kost:")
    public void adminEditVoucherAndApplyItToKost(String voucherApplyRule, DataTable table) throws InterruptedException {
        voucherAndKostName = table.asMaps(String.class, String.class);
        var voucher = voucherAndKostName.get(0).get("voucher name " + Mamikos.ENV);
        var kostName = voucherAndKostName.get(0).get("kost name " + Mamikos.ENV);
        var voucherEdit = mamipayAdmin.goToMamikosVoucher();
        voucherEdit.fillCampaignVoucher(voucher);
        voucherEdit.clickOnSearchButton();
        var voucherForm = voucherEdit.clickOnEditButton();
        if (voucherForm.getAllApplyKostNameInnerText().size() >= 1) {
            voucherForm.removeKostName();
        }
        if (voucherApplyRule.equalsIgnoreCase("apply")) {
            voucherForm.fillKostName(0, kostName);
        } else if (voucherApplyRule.equalsIgnoreCase("not apply")) {
            voucherForm.fillKostName(1, kostName);
        }
        massVoucherList = voucherForm.doneEditMassVoucher();
    }

    @Then("admin can see message voucher is updated")
    public void adminCanSeeAlertMessageIsUpdated() throws InterruptedException {
        var voucher = voucherAndKostName.get(0).get("voucher name " + Mamikos.ENV);
        Assert.assertEquals(massVoucherList.getCalloutText(), "Voucher " + voucher + " updated");
    }
}
