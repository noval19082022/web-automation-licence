package steps.mamikos.backofficedmin;

import com.microsoft.playwright.Page;
import config.mamikos.Mamikos;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
    List<Map<String, String>> voucherAndRules;
    List<Map<String, String>> voucherAndProfession;
    List<Map<String, String>> voucherAndMinimumTransaction;
    List<Map<String, String>> voucherAndTargetEmail;
    List<Map<String, String>> voucherList;

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

    @When("admin edit voucher with id name and {string} it to kost:")
    public void adminEditVoucherWithIdNameAndApplyItToKost(String voucherApplyRule, DataTable table) throws InterruptedException {
        voucherAndKostName = table.asMaps(String.class, String.class);
        var voucher = voucherAndKostName.get(0).get("voucher name " + Mamikos.ENV);
        var kostName = voucherAndKostName.get(0).get("kost name " + Mamikos.ENV);
        var voucherId = voucherAndKostName.get(0).get("voucher id " + Mamikos.ENV);
        var voucherEdit = mamipayAdmin.goToMamikosVoucher();
        voucherEdit.fillCampaignVoucher(voucher);
        voucherEdit.clickOnSearchButton();
        var voucherForm = voucherEdit.clickOnEditButton(voucherId, voucher);
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

    @When("admin edit voucher with name and set payment rules:")
    public void adminEditVoucherWithNameAndSetPaymentRules(DataTable table) {
        voucherAndRules = table.asMaps(String.class, String.class);
        var voucher = voucherAndRules.get(0).get("voucher name " + Mamikos.ENV);
        var rule = voucherAndRules.get(0).get("voucher rule");
        var voucherEdit = mamipayAdmin.goToMamikosVoucher();
        voucherEdit.fillCampaignVoucher(voucher);
        voucherEdit.clickOnSearchButton();
        var voucherForm = voucherEdit.clickOnEditButton();
        voucherForm.checkOnRules(rule);
        massVoucherList = voucherForm.doneEditMassVoucher();
    }

    @Then("admin can see below voucher is updated:")
    public void adminCanSeeBelowVoucherIsUpdated(DataTable table) {
        voucherList = table.asMaps(String.class, String.class);
        var voucher = voucherList.get(0).get("voucher name " + Mamikos.ENV);
        Assert.assertEquals(massVoucherList.getCalloutText(), "Voucher " + voucher + " updated");
    }

    @When("admin edit voucher with name and unset payment rules:")
    public void adminEditVoucherWithNameAndUnsetPaymentRules(DataTable table) {
        voucherAndRules = table.asMaps(String.class, String.class);
        var voucher = voucherAndRules.get(0).get("voucher name " + Mamikos.ENV);
        var rule = voucherAndRules.get(0).get("voucher rule");
        var voucherEdit = mamipayAdmin.goToMamikosVoucher();
        voucherEdit.fillCampaignVoucher(voucher);
        voucherEdit.clickOnSearchButton();
        var voucherForm = voucherEdit.clickOnEditButton();
        voucherForm.unCheckOnRules(rule);
        massVoucherList = voucherForm.doneEditMassVoucher();
    }

    @When("admin edit voucher with name and set profession:")
    public void adminEditVoucherWithNameAndSetProfession(DataTable table) {
        voucherAndProfession = table.asMaps(String.class, String.class);
        var voucher = voucherAndProfession.get(0).get("voucher name " + Mamikos.ENV);
        var profession = voucherAndProfession.get(0).get("profession");
        var voucherEdit = mamipayAdmin.goToMamikosVoucher();
        voucherEdit.fillCampaignVoucher(voucher);
        voucherEdit.clickOnSearchButton();
        var voucherForm = voucherEdit.clickOnEditButton();
        voucherForm.selectProfession(profession);
        massVoucherList = voucherForm.doneEditMassVoucher();
    }

    @When("admin edit voucher with name and set minimum transaction:")
    public void adminEditVoucherWithNameAndSetMinimumTransaction(DataTable table) {
        voucherAndMinimumTransaction = table.asMaps(String.class, String.class);
        var voucher = voucherAndMinimumTransaction.get(0).get("voucher name " + Mamikos.ENV);
        var minimumTransaction = voucherAndMinimumTransaction.get(0).get("minimum transaction");
        var voucherEdit = mamipayAdmin.goToMamikosVoucher();
        voucherEdit.fillCampaignVoucher(voucher);
        voucherEdit.clickOnSearchButton();
        var voucherForm = voucherEdit.clickOnEditButton();
        voucherForm.fillMinimumTransaction(minimumTransaction);
        massVoucherList = voucherForm.doneEditMassVoucher();
    }

    @When("admin edit voucher with name and {string} target email:")
    public void adminEditVoucherWithNameAndSetTargetEmail(String apply, DataTable table) {
        voucherAndTargetEmail = table.asMaps(String.class, String.class);
        var voucher = voucherAndTargetEmail.get(0).get("voucher name " + Mamikos.ENV);
        var targetEmail = voucherAndTargetEmail.get(0).get("target email");
        var voucherEdit = mamipayAdmin.goToMamikosVoucher();
        voucherEdit.fillCampaignVoucher(voucher);
        voucherEdit.clickOnSearchButton();
        var voucherForm = voucherEdit.clickOnEditButton();
        if (apply.equalsIgnoreCase("apply") && !voucherForm.applicableEmailContent().equalsIgnoreCase(targetEmail)) {
            voucherForm.fillNotApplicableForEmail("");
            voucherForm.fillApplicableForEmail(targetEmail);
        } else if (apply.equalsIgnoreCase("not apply") && !voucherForm.notApplicableForEmailContent().equalsIgnoreCase(targetEmail)) {
            voucherForm.fillApplicableForEmail("");
            voucherForm.fillNotApplicableForEmail(targetEmail);
        }
        massVoucherList = voucherForm.doneEditMassVoucher();
    }
}
