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
import pageobject.admin.mamipay.voucher.MamikosListVoucherOwnerPO;
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
    MamikosListVoucherOwnerPO ownerVoucher = new MamikosListVoucherOwnerPO(page);
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

    @And("admin search single voucher with name and edit index {string}:")
    public void adminSearchSingleVoucherWithNameAndEditIndex(String index, DataTable table) throws InterruptedException {
        voucherAndProfession = table.asMaps(String.class, String.class);
        var voucher = voucherAndProfession.get(0).get("voucher name " + Mamikos.ENV);
        var voucherEdit = mamipayAdmin.goToMamikosVoucher();
        MamikosListMassVoucherPO massVoucherList = new MamikosListMassVoucherPO(page);
        massVoucherList.clickSingleVoucher();
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

    @And("admin search single voucher with name:")
    public void adminSearchSingleVoucherWithName(DataTable table) throws InterruptedException {
        voucherAndProfession = table.asMaps(String.class, String.class);
        var voucher = voucherAndProfession.get(0).get("voucher name " + Mamikos.ENV);
        MamikosListMassVoucherPO massVoucherList = new MamikosListMassVoucherPO(page);
        massVoucherList.clickSingleVoucher();
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

    @And("admin master clicks on edit single voucher button in voucher form")
    public void adminMasterClicksOnSingleMassVoucherButtonInVoucherForm() {
        massVoucherForm.clickOnEditSingleVocButton();
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

    @And("admin deactivate mass voucher")
    public void adminDeactivateMassVoucher() throws InterruptedException {
        massVoucherForm.deactivateMassVoucher();
    }

    @Then("System display alert message on mamipay web")
    public void admin_can_sees_callout_message_is() {
        Assert.assertTrue(massVoucherForm.isAlertMessageDisplayed(), "Voucher AUTOVINVALID updated");
    }

    @When("admin select minimum type of contract period {string}")
    public void admin_select_minimum_contract_periode(String contractPeriod) throws InterruptedException {
        massVoucherForm.selectContractPeriod(contractPeriod);
    }

    @When("admin unselect minimum type of contract period {string}")
    public void admin_unselect_minimum_contract_periode(String contractPeriod) throws InterruptedException {
        massVoucherForm.unselectContractPeriod(contractPeriod);
    }

    @When("admin select multiple contract periods {string}")
    public void admin_select_multiple_contract_periods(String contractPeriods) throws InterruptedException {
        massVoucherForm.selectMultipleContractPeriods(contractPeriods);
    }

    @When("admin unselect all contract periods")
    public void admin_unselect_all_contract_periods() throws InterruptedException {
        massVoucherForm.unselectAllContractPeriods();
    }

    @Then("admin can see contract period {string} is selected")
    public void admin_can_see_contract_period_is_selected(String contractPeriod) {
        Assert.assertTrue(massVoucherForm.isContractPeriodSelected(contractPeriod), 
            "Contract period " + contractPeriod + " should be selected but it's not");
    }

    @Then("admin can see contract period {string} is not selected")
    public void admin_can_see_contract_period_is_not_selected(String contractPeriod) {
        Assert.assertFalse(massVoucherForm.isContractPeriodSelected(contractPeriod), 
            "Contract period " + contractPeriod + " should not be selected but it is");
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

    @Then("user create new single voucher with team {string}, discount type {string}, start date {string} and end date to {string} without email:")
    public void userCreateNewSingleVoucherWithTeamDiscountTypeStartDateAndEndDateToWithoutEmail(String team, String type, String startDate, String endDate, DataTable table) throws InterruptedException, ParseException {
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
    }

    @And("admin edit voucher with name and set voucher aplicable on city:")
    public void adminEditVoucherWithNameAndSetVoucherAplicableOnCity(DataTable table) throws InterruptedException {
        voucherAndRules = table.asMaps(String.class, String.class);
        var voucher = voucherAndRules.get(0).get("voucher name " + Mamikos.ENV);
        var city = voucherAndRules.get(0).get("voucher City");
        var voucherEdit = mamipayAdmin.goToMamikosVoucher();
        voucherEdit.fillCampaignVoucher(voucher);
        voucherEdit.clickOnSearchButton();
        var voucherForm = voucherEdit.clickOnEditButton();
        voucherForm.selectVoucherAplicableOnCity(city);
        massVoucherList = voucherForm.doneEditMassVoucher();
    }

    @And("admin edit voucher with name and set voucher not aplicable on city:")
    public void adminEditVoucherWithNameAndSetVoucherNotAplicableOnCity(DataTable table) throws InterruptedException {
        voucherAndRules = table.asMaps(String.class, String.class);
        var voucher = voucherAndRules.get(0).get("voucher name " + Mamikos.ENV);
        var city = voucherAndRules.get(0).get("voucher City");
        var voucherEdit = mamipayAdmin.goToMamikosVoucher();
        voucherEdit.fillCampaignVoucher(voucher);
        voucherEdit.clickOnSearchButton();
        var voucherForm = voucherEdit.clickOnEditButton();
        voucherForm.selectVoucherNotAplicableOnCity(city);
        massVoucherList = voucherForm.doneEditMassVoucher();
    }

    @And("user edit voucher {string} in index {string} and set voucher code is {string}")
    public void userEditVoucherInIndexAndSetVoucherCodeIs(String voucher, String index, String voucherCode) throws InterruptedException, ParseException {
        massVoucherListVoucher.fillCampaignVoucher(voucher);
        massVoucherListVoucher.clickOnSearchButton();
        massVoucherListVoucher.clickOnUpdateIconIndex(index);
        massVoucherForm.fillPartnerVoucherCode(voucherCode);
    }

    @Then("failed update voucher and display text validation {string}")
    public void failed_update_voucher_and_display_text_validation(String message) {
        Assert.assertEquals(massVoucherForm.getMessageError(), message, "message is not match");
    }

    @And("user edit voucher {string} in index {string} and set voucher title is {string}")
    public void userEditVoucherInIndexAndSetVoucherTitleIs(String voucher, String index, String voucherTitle) throws InterruptedException, ParseException {
        massVoucherListVoucher.fillCampaignVoucher(voucher);
        massVoucherListVoucher.clickOnSearchButton();
        massVoucherListVoucher.clickOnUpdateIconIndex(index);
        massVoucherForm.fillPartnerVoucherTitle(voucherTitle);
    }

    @And("admin master clicks on edit Partner voucher button in voucher form")
    public void adminMasterClicksOnEditPartnerVoucherButtonInVoucherForm() {
        massVoucherForm.clickOnUpdatePartnerVocButton();
    }

    @And("user access Partner voucher page")
    public void userAccessPartnerVoucherPage() {
        mamipayAdmin.goToPartneroucher();
    }

    @And("user create new partner voucher:")
    public void userCreateNewPartnerVoucher(DataTable table) throws InterruptedException, ParseException {
        userCreateNewMassVoucher = table.asMap(String.class, String.class);
        MamikosListMassVoucherPO partnerVoucherList = new MamikosListMassVoucherPO(page);
        MamikosVoucherFormPO partnerVoucherForm = new MamikosVoucherFormPO(page);
        var voucherCode = userCreateNewMassVoucher.get("voucher code");
        var totalQuota = userCreateNewMassVoucher.get("total quota");
        partnerVoucherList.clickOnCreatePartnerVoucherButton();
        partnerVoucherForm.fillPartnerVoucherCode(voucherCode);
        partnerVoucherForm.fillPartnerVoucherTotalQuota(totalQuota);
    }

    @And("admin master clicks on add Partner voucher button in voucher form")
    public void adminMasterClicksOnAddPartnerVoucherButtonInVoucherForm() {
        massVoucherForm.clickOnAddPartnerVocButton();
    }

    @Then("user see validation error field is required")
    public void user_see_validation_error_field_is_required(List<String> listValidationRequired) {
        for (int i = 0; i < listValidationRequired.size(); i++) {
            Assert.assertEquals(massVoucherForm.getMessageValidationFieldRequired(listValidationRequired.get(i)), listValidationRequired.get(i), "Messaga validation not match");
        }

    }

    @And("user add bulk add voucher partners")
    public void userAddBulkAddVoucherPartners() {
        massVoucherListVoucher.clickOnCreatePartnerVoucherButton();
    }

    @When("admin want to see Single Voucher List owner for index {string}")
    public void admin_want_to_see_single_voucher_list_owner_for_index(String index) throws InterruptedException {
        ownerVoucher.goToOwnerVoucher();
        ownerVoucher.clickVoucherListOwner(index);
    }

    @Then("admin redirected to View Usage page")
    public void admin_redirected_to_view_usage_page() {
        Assert.assertTrue(ownerVoucher.isHeaderUsagePageIsDisplayed(), "header usage voucher is not displayed");
        Assert.assertTrue(ownerVoucher.isVoucherInformationIsDisplayed(), "voucher infromation is not displayed");
        Assert.assertTrue(ownerVoucher.isTableUsageVoucherOwnerIsDisplayed(), "table is not displayed");
    }

    @Then("admin redirected to Update page")
    public void admin_redirected_to_update_page() {
        Assert.assertTrue(ownerVoucher.isHeaderUpdateVoucherOwnerAppear(), "Header update voucher is not appear");
        Assert.assertTrue(ownerVoucher.isCampaignHeaderAppear(), "Campaign header not appear");
        ownerVoucher.clickOnCancelButtonOwnerVoucher();
    }

    @Then("admin redirected to Single Voucher List owner")
    public void admin_redirected_to_single_voucher_list_owner() {
        Assert.assertTrue(ownerVoucher.isVocherCodeListDisplayed(), "Voucher code list is not displayed");
        Assert.assertTrue(ownerVoucher.isTableListVoucherDisplayed(), "Table list is not displayed");
        ownerVoucher.clickOnBackButtonVoucher();
    }

    @When("admin want to see View Usage List owner for index {string}")
    public void admin_want_to_see_view_usage_list_owner_for_index(String index) throws InterruptedException {
        ownerVoucher.clickUsageListOwner(index);
    }

    @When("admin want to see update page for index {string}")
    public void admin_want_to_see_update_page_for_index(String index) throws InterruptedException {
        ownerVoucher.clickUpdateVoucherOwner(index);
    }


    @When("admin want to see Voucher History page for index {string}")
    public void adminWantToSeeHistoryPageForIndex(String index) {
        ownerVoucher.clickHistoryVoucherOwner(index);
    }

    @And("Admin go to Single Voucher List Owner")
    public void adminGoToSingleVoucherListOwner() {
        ownerVoucher.goToOwnerVoucher();
    }

    @And("Admin want to create single voucher owner")
    public void adminWantToCreateSingleVoucherOwner() {
        ownerVoucher.clickOnAddSingleVoucher();
    }

    @And("Admin select Goldplus on product field create single voucher")
    public void adminSelectGoldplusOnProductFieldCreateSingleVoucher() {
        ownerVoucher.selectOptionProductGP();
    }

    @And("Admin fill all required campaign field on create single voucher")
    public void adminFillAllRequiredCampaignFieldOnCreateSingleVoucher(DataTable dataTable) {
        List<Map<String, String>> table = dataTable.asMaps();
        ownerVoucher.inputCampaignName(table.get(0).get("Campaign Name"));
        ownerVoucher.inputStartDateCampaign(table.get(0).get("Start Date"));
        ownerVoucher.inputEndDateCampaign(table.get(0).get("End Date"));
    }

    @And("Admin fill all required voucher field on create single voucher")
    public void adminFillAllRequiredVoucherFieldOnCreateSingleVoucher(DataTable tables) {
        List<Map<String, String>> table = tables.asMaps();
        ownerVoucher.inputVoucherPrefix(table.get(0).get("Voucher PrefixCode"));
        ownerVoucher.inputTotalVoucher(table.get(0).get("Total Voucher"));
        ownerVoucher.inputDiscountType(table.get(0).get("Discount Type"));
        ownerVoucher.inputDiscountAmount(table.get(0).get("Discount Amount"));
        ownerVoucher.uploadOwnerList(table.get(0).get("Upload Owner List"));
       // ownerVoucher.inputInvoiceType(table.get(0).get("Invoice Type"));
      //  ownerVoucher.inputDoubleRedeemWithMamiPoin(table.get(0).get("Double Redeem With MamiPoin"));
    }

    @And("Admin click Create Voucher Single list button")
    public void adminClickCreateVoucherSingleListButton() {
        ownerVoucher.clickOnCreateVoucherBtn();
    }
}
