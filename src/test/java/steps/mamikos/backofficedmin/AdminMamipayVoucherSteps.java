package steps.mamikos.backofficedmin;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import pageobject.admin.mamipay.AdminMamipayDashboardPO;
import pageobject.admin.mamipay.voucher.MamikosListMassVoucherPO;
import pageobject.admin.mamipay.voucher.MamikosVoucherFormPO;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class AdminMamipayVoucherSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    AdminMamipayDashboardPO mamipayAdmin = new AdminMamipayDashboardPO(page);
    MamikosListMassVoucherPO massVoucherList = null;
    MamikosListMassVoucherPO massVoucherListVoucher = new MamikosListMassVoucherPO(page);
    MamikosVoucherFormPO massVoucherForm = new MamikosVoucherFormPO(page);
    MamikosVoucherFormPO voucherForm = new MamikosVoucherFormPO(page);
    List<Map<String, String>> voucherAndKostName;
    List<Map<String, String>> voucherAndRules;
    List<Map<String, String>> voucherAndProfession;
    List<Map<String, String>> voucherAndMinimumTransaction;
    List<Map<String, String>> voucherAndTargetEmail;
    List<Map<String, String>> voucherList;
    private Map<String, String> userCreateNewMassVoucher;
    private Map<String, String> paymentRules;
    private Map<String, String> userInputDataVoucher;
    private String voucherPrefix;


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

    @Then("user create new mass voucher with team {string}, discount type {string}, start date {string} and end date to {string}:")
    public void userCreateNewMassVoucherWithTeamDiscountTypeStartDateAndEndDateTo(String team, String type, String startDate, String endDate, DataTable table) throws InterruptedException, ParseException {
        String currentDate = JavaHelpers.getCurrentDateOrTime("yyyy-MM-dd hh:mm");
        String yesterdayDate = JavaHelpers.getCostumDateOrTime("yyyy-MM-dd hh:mm", -1, 0, 0);
        String dayBeforeYesterday = JavaHelpers.getCostumDateOrTime("yyyy-MM-dd hh:mm", -2, 0, 0);
        userCreateNewMassVoucher = table.asMap(String.class, String.class);
        MamikosListMassVoucherPO massVoucherList = new MamikosListMassVoucherPO(page);
        MamikosVoucherFormPO massVoucherForm = new MamikosVoucherFormPO(page);
        var voucherName = userCreateNewMassVoucher.get("voucher name");
        var voucherDiscountAmount = userCreateNewMassVoucher.get("discount amount");
        var voucherTotalKosQuota = userCreateNewMassVoucher.get("total kos quota");
        var voucherTotalQuota = userCreateNewMassVoucher.get("total quota");
        var voucherDailyuota = userCreateNewMassVoucher.get("daily quota");
        var voucherMaximumDiscount = userCreateNewMassVoucher.get("max discount");
        var voucherMinimumTransaction = userCreateNewMassVoucher.get("min transaction");
        mamipayAdmin.goToMamikosVoucher();
        massVoucherList.clickOnCreateButton();
        massVoucherForm.fillVocName(voucherName);
        massVoucherForm.chooseFormStartDate(startDate);
        if (endDate.equalsIgnoreCase("")) {
            voucherForm.fillEndDate("");
        } else if (endDate.equalsIgnoreCase("yesterday")) {
            voucherForm.fillEndDate(yesterdayDate);
        }
        massVoucherForm.selectOncampaignTeam(team);
        massVoucherForm.selectOnVocTypeButton(type);
        massVoucherForm.fillDiscountAmount(voucherDiscountAmount);
        massVoucherForm.fillTotalQuota(voucherTotalQuota);
        massVoucherForm.fillTotalKosQuota(voucherTotalKosQuota);
        massVoucherForm.fillDailyQuota(voucherDailyuota);
        massVoucherForm.fillMaxDiscountAmount(voucherMaximumDiscount);
        massVoucherForm.fillMinTransaction(voucherMinimumTransaction);
    }

    @And("^admin master tick payment rules :$")
    public void admin_master_tick_payment_rules(List<String> paymentRules) throws InterruptedException {
        for (String paymentRule : paymentRules) {
            massVoucherForm.tickOnPaymentRules(paymentRule);
        }
    }


    @When("^admin select contract rules :$")
    public void admin_select_contract_rules(List<String> contractRules) throws InterruptedException {
        for (String contractRule : contractRules) {
            massVoucherForm.tickOnContractRules(contractRule);
        }
    }

    @And("admin select important rules :")
    public void adminSelectImportantRules(List<String> importantRules) throws InterruptedException {
        for (String importantRule : importantRules) {
            massVoucherForm.tickOnImportantRules(importantRule);
        }
    }

    @And("admin master clicks on add mass voucher button in voucher form")
    public void adminMasterClicksOnAddMassVoucherButtonInVoucherForm() {
        massVoucherForm.clickOnSubmitAddMassVocButton();
    }

    @And("admin master clicks on add single voucher button in voucher form")
    public void adminMasterClicksOnAddSingleVoucherButtonInVoucherForm() {
        massVoucherForm.clickOnSubmitAddSingleVocButton();
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

    @Then("admin can sees callout message is {string}")
    public void admin_can_sees_callout_message_is(String callOutMessage) {
        Assert.assertEquals(massVoucherListVoucher.getCalloutText(), callOutMessage);
    }


    @And("admin search mass voucher with name and edit index {string}:")
    public void adminSearchMassVoucherWithNameAndEditIndex(String index, DataTable table) throws InterruptedException {
        voucherAndProfession = table.asMaps(String.class, String.class);
        var voucher = voucherAndProfession.get(0).get("voucher name " + Mamikos.ENV);
        var voucherEdit = mamipayAdmin.goToMamikosVoucher();
        voucherEdit.fillCampaignVoucher(voucher);
        voucherEdit.clickOnSearchButton();
        voucherEdit.clickOnUpdateIconIndex(index);
    }

    @When("admin update mass voucher with team {string}, discount type {string}, start date {string} and end date to {string}:")
    public void adminUpdateMassVoucherWithTeamDiscountTypeStartDateAndEndDateTo(String arg0, String arg1, String arg2, String arg3) {
    }

    @And("admin master inputs mass voucher code {string}")
    public void admin_master_inputs_mass_voucher_code(String prefix) {
        int length = 4;
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        voucherPrefix = prefix + generatedString.toUpperCase();
        massVoucherForm.fillVocCode(voucherPrefix);
    }

    @And("admin master inputs prefix voucher code {string}")
    public void admin_master_inputs_prefix_voucher_code(String prefix) {
        int length = 4;
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        voucherPrefix = prefix + generatedString.toUpperCase();
        massVoucherForm.fillPrefixCode(voucherPrefix);
    }

    @And("admin search mass voucher with name:")
    public void adminSearchMassVoucherWithName(DataTable table) throws InterruptedException {
        voucherAndProfession = table.asMaps(String.class, String.class);
        var voucher = voucherAndProfession.get(0).get("voucher name " + Mamikos.ENV);
        massVoucherListVoucher.fillCampaignVoucher(voucher);
        massVoucherListVoucher.clickOnSearchButton();
    }

    @Then("admin can sees first index voucher status in mass voucher is {string}")
    public void admin_can_sees_first_index_voucher_status_in_mass_voucher_is(String status) {
        Assert.assertEquals(massVoucherForm.getVoucherListStatusIndex("1"), status);
    }

    @And("admin master clicks on edit mass voucher button in voucher form")
    public void adminMasterClicksOnEditMassVoucherButtonInVoucherForm() {
        massVoucherForm.clickOnEditAddMassVocButton();
    }

    @Then("admin can sees callout message contains {string}")
    public void admin_can_sees_callout_message_contains(String calloutText) {
        List<String> calloutTextSplit = Arrays.asList(calloutText.split(" "));
        for (int i = 0; i < calloutTextSplit.size(); i++) {
            Assert.assertTrue(massVoucherListVoucher.getCalloutText().contains(calloutTextSplit.get(i)));
        }
    }

    @And("admin master upload voucher campaign image")
    public void adminMasterUploadVoucherCampaignImage() throws InterruptedException {
        massVoucherForm.uploadCampaignImage();

    }

    @Then("user create new mass voucher with:")
    public void userCreateNewMassVoucherWith(DataTable table) throws InterruptedException {
        userInputDataVoucher = table.asMap(String.class, String.class);
        var campaignTitle = userInputDataVoucher.get("campaign title");
        var campaignTnC = userInputDataVoucher.get("campaign T&C");
        massVoucherForm.fillCampaignTitle(campaignTitle);
        massVoucherForm.fillCampaignTnC(campaignTnC);
    }

    @And("admin master upload mass voucher csv file")
    public void adminMasterUploadMassVoucherCsvFile() throws InterruptedException {
        massVoucherForm.uploadMassVoucherCSVFile();
    }

    @And("admin uncheck important rules :")
    public void adminUncheckImportantRules(List<String> importantRules) throws InterruptedException {
        for (String importantRule : importantRules) {
            massVoucherForm.untickOnImportantRules(importantRule);
        }
    }

    @And("admin activate mass voucher")
    public void adminActivateMassVoucher() throws InterruptedException {
        massVoucherForm.activateMassVoucher();
    }

    @Then("System display alert message on mamipay web")
    public void admin_can_sees_callout_message_is() {
        Assert.assertTrue(massVoucherForm.isAlertMessageDisplayed(), "Voucher AUTOVINVALID updated");
    }

    @When("admin select minimum type of contract period {string}")
    public void admin_select_minimum_contract_periode(String contractPeriod) throws InterruptedException {
            massVoucherForm.clickOnDropdownContractPeriod();
            massVoucherForm.chooseContractPeriode(contractPeriod);
    }
    @And("admin master clicks on edit pencil icon")
    public void adminClickOnEditPencilIcon() {
        massVoucherForm.clickOnEditPencilIcon();
    }

    @Then("user create new single voucher with team {string}, discount type {string}, start date {string} and end date to {string}:")
    public void userCreateNewSingleVoucherWithTeamDiscountTypeStartDateAndEndDateTo(String team, String type, String startDate, String endDate, DataTable table) throws InterruptedException, ParseException {
        String currentDate = JavaHelpers.getCurrentDateOrTime("yyyy-MM-dd hh:mm");
        String yesterdayDate = JavaHelpers.getCostumDateOrTime("yyyy-MM-dd hh:mm", -1, 0, 0);
        String dayBeforeYesterday = JavaHelpers.getCostumDateOrTime("yyyy-MM-dd hh:mm", -2, 0, 0);
        userCreateNewMassVoucher = table.asMap(String.class, String.class);
        MamikosListMassVoucherPO massVoucherList = new MamikosListMassVoucherPO(page);
        MamikosVoucherFormPO massVoucherForm = new MamikosVoucherFormPO(page);
        var voucherName = userCreateNewMassVoucher.get("voucher name");
        var voucherDiscountAmount = userCreateNewMassVoucher.get("discount amount");
        var voucherTotalKosQuota = userCreateNewMassVoucher.get("total each kos quota");
        var voucherTotalEachQuota = userCreateNewMassVoucher.get("total each quota");
        var singleVoucherDailyuota = userCreateNewMassVoucher.get("daily quota");
        var voucherMaximumDiscount = userCreateNewMassVoucher.get("max discount");
        var voucherMinimumTransaction = userCreateNewMassVoucher.get("min transaction");
        var voucherTargetedEmail = userCreateNewMassVoucher.get("targeted email");
        var voucherTotalTargetedEmail = userCreateNewMassVoucher.get("total targeted email");
        mamipayAdmin.goToMamikosVoucher();
        massVoucherList.clickSingleVoucher();
        massVoucherList.clickOnAddSingleButton();
        massVoucherForm.fillVocName(voucherName);
        massVoucherForm.chooseFormStartDate(startDate);
        if (endDate.equalsIgnoreCase("")) {
            voucherForm.fillEndDateSingleVoucher("");
        } else if (endDate.equalsIgnoreCase("yesterday")) {
            voucherForm.fillEndDateSingleVoucher(yesterdayDate);
        }
        massVoucherForm.selectOncampaignTeam(team);
        massVoucherForm.selectOnVocTypeButton(type);
        massVoucherForm.fillTotalTargetedEmail(voucherTotalTargetedEmail);
        massVoucherForm.filTotalEachQuota(voucherTotalEachQuota);
        massVoucherForm.fillDiscountAmount(voucherDiscountAmount);
        massVoucherForm.fillTotalKosQuota(voucherTotalKosQuota);
        massVoucherForm.fillSingleDailyQuota(singleVoucherDailyuota);
        massVoucherForm.fillMaxDiscountAmount(voucherMaximumDiscount);
        massVoucherForm.fillMinTransaction(voucherMinimumTransaction);
        massVoucherForm.fillTargetedEmail(voucherTargetedEmail);
    }
}