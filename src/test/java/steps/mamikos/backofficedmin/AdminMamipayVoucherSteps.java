package steps.mamikos.backofficedmin;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.admin.mamipay.AdminMamipayDashboardPO;
import pageobject.admin.mamipay.voucher.MamikosListMassVoucherPO;
import utilities.JavaHelpers;
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

    @When("admin edit voucher with name end date to {string}:")
    public void adminEditVoucherWithNameEndDateTo(String endDate, DataTable table) {
        String currentDate = JavaHelpers.getCurrentDateOrTime("yyyy-MM-dd hh:mm");
        String yesterdayDate = JavaHelpers.getCostumDateOrTime("yyyy-MM-dd hh:mm", -1, 0, 0);
        String dayBeforeYesterday = JavaHelpers.getCostumDateOrTime("yyyy-MM-dd hh:mm", -2, 0, 0);
        voucherList = table.asMaps(String.class, String.class);
        var voucher = voucherList.get(0).get("voucher name " + Mamikos.ENV);
        var voucherEdit = mamipayAdmin.goToMamikosVoucher();
        voucherEdit.fillCampaignVoucher(voucher);
        voucherEdit.clickOnSearchButton();
        var voucherForm = voucherEdit.clickOnEditButton();
        if (endDate.equalsIgnoreCase("")) {
            voucherForm.fillStartDate(currentDate);
            voucherForm.fillEndDate("");
        } else if (endDate.equalsIgnoreCase("yesterday")) {
            voucherForm.fillStartDate(dayBeforeYesterday);
            voucherForm.fillEndDate(yesterdayDate);
        }
        massVoucherList = voucherForm.doneEditMassVoucher();
    }
    @Then("admin see {string} filter list option on voucher menu:")
    public void admin_see_all_filter_list_option_are(String filter) {
        String title = mamipayAdmin.getAllFilterOptions(filter);
        Assert.assertEquals(filter, title);
    }
    @And("admin click on dropdown filter status")
    public void user_click_on_filter_status_dropdown() {
        mamipayAdmin.clickOnFilterStatusDropdown();
    }

    @And("admin click on dropdown filter rules")
    public void user_click_on_filter_rules_dropdown() {
        mamipayAdmin.clickOnFilterRulesDropdown();
    }

    @And("admin click on dropdown filter team")
    public void user_click_on_filter_team_dropdown() {
        mamipayAdmin.clickOnFilterTeamDropdown();
    }

    @When("admin choose to filter {string} and click search button:")
    public void admin_choose_filter_and_click_on_search_button(String filter) {
        String title = mamipayAdmin.getAllFilterOptions(filter);
        Assert.assertEquals(filter, title);
        mamipayAdmin.clickOnFilter(filter);
        mamipayAdmin.clickOnSearchButton();
    }
    @When("admin see voucher with selected filter {string} is displayed:")
    public void admin_see_voucher_with_select_filter_is_displayed(String filter) {
        String title = mamipayAdmin.getResultSelectFilter(filter);
        Assert.assertEquals(filter, title);
    }
    @And("admin input voucher with value {string} and click search button:")
    public void user_click_on_input_voucher(String id) {
        mamipayAdmin.clickOnInputVoucher(id);
        mamipayAdmin.clickOnSearchButton();
    }
}