package steps.mamikos.tenant.survei;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.admin.mamipay.bangkrupux.tenantSurveyPO;
import pageobject.tenant.survei.TenantSurveyFormPO;
import utilities.JavaHelpers;

import java.text.ParseException;
import java.util.List;

public class tenantSurveySteps {
    Page page = ActiveContext.getActivePage();
    tenantSurveyPO surveyPO = new tenantSurveyPO(page);
    TenantSurveyFormPO tenantSurveyFormPO = new TenantSurveyFormPO(page);
    private JavaHelpers java = new JavaHelpers();

    @And("user edit Tenant Survey on {string}")
    public void user_edit_Tenant_Survey_on(String tenant) throws InterruptedException {
        surveyPO.clickTenantSurveyMenu();
        surveyPO.fillOnTenantNameFilter(tenant);
        surveyPO.clickOnSearchFilterButton();
        surveyPO.clickOnEditButton(tenant);
    }


    @And("user change survey status to {string}")
    public void user_change_survey_status_to(String survey) throws InterruptedException {
        surveyPO.changeSurveyStatus(survey);
    }

    @Then("user verify change survey success alert with {string}")
    public void user_verify_change_survey_success_alert_with(String text) throws InterruptedException {
        Assert.assertTrue(surveyPO.isAlertAppear(), "Success alert is not appeared");
        String actualAlertText = surveyPO.getAlertText().substring(2, 72).trim();
        Assert.assertEquals(actualAlertText, text, "Success alert text is not equal to " + text);
    }

    @And("user change survey date to {string}")
    public void user_change_survey_date_to(String date) throws ParseException, InterruptedException {
        String exactDate = "";
        if (date.equalsIgnoreCase("Tomorrow")) {
            exactDate = java.updateTime("yyyy MMM dd", java.getTimeStamp("yyy MMM dd"), "d", 1, 0, 0, 0);
        }
        surveyPO.changeSurveyDate(exactDate);
    }

    @And("user change survey time to {string}")
    public void user_change_survey_time_to(String time) throws InterruptedException {
        surveyPO.changeSurveyTime(time);
    }

    @And("user filter Tenant Survey using name on {string}")
    public void user_filter_Tenant_Survey_using_name_on(String name) throws InterruptedException {
        surveyPO.clickTenantSurveyMenu();
        surveyPO.fillOnTenantNameFilter(name);
        surveyPO.clickOnSearchFilterButton();
    }

    @And("user filter Tenant Survey using Status on {string}")
    public void user_filter_Tenant_Survey_using_Status_on(String status) throws InterruptedException {
        surveyPO.clickTenantSurveyMenu();
        surveyPO.fillOnTenantStatusFilter(status);
        surveyPO.clickOnSearchFilterButton();
    }

    @And("user filter Tenant Survey using survey date on {string}")
    public void user_filter_Tenant_Survey_using_survey_date_on(String date) throws InterruptedException {
        surveyPO.clickTenantSurveyMenu();
        surveyPO.fillOnSurveyDateFilter(date);
        Assert.assertTrue(surveyPO.isSearchButtonDisplayed(), "Search button is not displayed");
        surveyPO.clickOnSearchFilterButton();
    }

    @And("user filter Tenant Survey using phone on {string}")
    public void user_filter_Tenant_Survey_using_phone_on(String phone) throws InterruptedException {
        surveyPO.clickTenantSurveyMenu();
        surveyPO.fillOnTenantPhoneFilter(phone);
        surveyPO.clickOnSearchFilterButton();
    }

    @And("user filter Tenant Survey using Kost name on {string}")
    public void user_filter_Tenant_Survey_using_Kost_name_on(String kostName) throws InterruptedException {
        surveyPO.clickTenantSurveyMenu();
        surveyPO.fillOnTenantKostNameFilter(kostName);
        surveyPO.clickOnSearchFilterButton();
    }

    @Then("user verify Tenant Name filter result with {string}")
    public void user_verify_Tenant_Name_filter_result_with(String tenantName) {
        List<String> tenantSurveyName = surveyPO.getTenantNameTableResult();
        Assert.assertTrue(tenantSurveyName.get(0).contains(tenantName));
    }

    @Then("user verify Tenant Status filter result with {string}")
    public void userVerifyTenantStatusFilterResultWith(String tenantStatus) {
        List<String> tenantSurveyStatus = surveyPO.getTenantStatusTableResult();
        Assert.assertTrue(tenantSurveyStatus.get(0).contains(tenantStatus));
    }

    @Then("user verify Tenant Phone filter result with {string}")
    public void userVerifyTenantPhoneFilterResultWith(String tenantPhone) {
        List<String> tenantSurveyPhone = surveyPO.getTenantPhoneNumberTableResult();
        Assert.assertTrue(tenantSurveyPhone.get(0).contains(tenantPhone));
    }

    @Then("user verify Tenant Kost Name filter result with {string}")
    public void userVerifyTenantKostNameFilterResultWith(String tenantKostName) {
        List<String> tenantSurveyKostName = surveyPO.getTenantKostNameTableResult();
        Assert.assertTrue(tenantSurveyKostName.get(0).contains(tenantKostName));
    }

    @Then("user verify Tenant Survey Date filter result with {string}")
    public void userVerifyTenantSurveyDateFilterResultWith(String tenantSurveyDate) {
        List<String> tenantSurveySurveyDate = surveyPO.getTenantSurveyDateTableResult();
        Assert.assertTrue(tenantSurveySurveyDate.get(0).contains(tenantSurveyDate));
    }

    @And("user tap on edit profile on survey form")
    public void userTapOnEditProfileOnSurveyForm() {
        tenantSurveyFormPO.tapOnEditProfile();
    }

    @And("user edit profile name from survey form request {string}")
    public void userEditProfileNameFromSurveyFormRequest(String name) {
        tenantSurveyFormPO.editNameProfile(name);
    }

    @And("user click on simpan profile btn")
    public void userClickOnSimpanProfileBtn() {
        tenantSurveyFormPO.setSaveProfileBtn();
    }

    @Then("user see pop up success save profile text")
    public void userSeePopUpSuccessSaveProfileText() {
        Assert.assertEquals(tenantSurveyFormPO.popUpSuccessSaveProfile(), "Data profil tersimpan.");
    }

    @Then("user verify survey date on form is {string}")
    public void userVeritfySurveyDateOnFormIs(String dateExpected) {
        var dateOnForm = dateExpected.contains("today") ?
                tenantSurveyFormPO.getSurveyDateAutoSelected() :
                tenantSurveyFormPO.getSurveyDateSelectedOnForm();

        if (dateExpected.contains("today")) {
            dateExpected = JavaHelpers.getCurrentDateOrTime("d");
        }

        Assert.assertEquals(dateOnForm, dateExpected);
    }

    @And("user open survey date option on form survey")
    public void userOpenSurveyDateOptionOnFormSurvey() {
        tenantSurveyFormPO.tapOnSurveyDateForm();
    }

    @And("user tap on next month survey date on form survey")
    public void userTapOnNextMonthSurveyDateOnFormSurvey() {
        tenantSurveyFormPO.tapOnNextMonthBtnSurveyDateForm();
    }

    @Then("user able to select date {string} on form survey")
    public void userAbleToSelectDateOnFormSurvey(String date) {
        tenantSurveyFormPO.selectSurveyDate(date);
    }

    @Then("user verify previous date is disable")
    public void userVerifyPreviousMonthButtonIsDisable() {
        var previousDate = JavaHelpers.getCostumDateOrTime("d", -1, 0, 0);
        var dateToday = JavaHelpers.getCurrentDateOrTime("d");

        if (tenantSurveyFormPO.isSurveyDateNotVisible(previousDate)) {
            Assert.assertTrue(tenantSurveyFormPO.isSurveyDateNotVisible(previousDate));
            return;
        }

        // NOTE: somtimes the button is not disable on locator but actually is disabled, so this step is to prevent failed

        // trying to click previous day
        tenantSurveyFormPO.selectSurveyDate(previousDate);

        // expected still pick today
        Assert.assertEquals(tenantSurveyFormPO.getSurveyDateAutoSelected(), dateToday);
    }

    @And("user open time survey option on form survey")
    public void userOpenTimeSurveyOptionOnFormSurvey() {
        tenantSurveyFormPO.tapOnSurveyTimeOption();
    }

    @Then("user verify available time is higher than current time")
    public void userVerifyAvailableTimeIsHigherThanCurrentTime() {
        var currentTime = JavaHelpers.getCurrentTimeServer();

        var timeAvailable = tenantSurveyFormPO.getCurrentAvailableTime();

        for (var time : timeAvailable) {
            if (currentTime.equals(time)) {
                continue;
            }

            Assert.assertTrue(
                    JavaHelpers.isTimeGreater(time, currentTime));
        }
    }

    @Then("user select survey available time")
    public void userSelectSurveyTimeHoursFromCurrentTime() {
        var timeAvailable = tenantSurveyFormPO.getCurrentAvailableTime();
        if (timeAvailable.length != 0) {
            tenantSurveyFormPO.selectTimeOption(timeAvailable[0]);
        } else {
            tenantSurveyFormPO.tapOnSurveyDateForm();
            tenantSurveyFormPO.tapOnNextMonthBtnSurveyDateForm();
            tenantSurveyFormPO.selectSurveyDate("15");
            tenantSurveyFormPO.tapOnSurveyTimeOption();
            tenantSurveyFormPO.selectTimeOption("08:00");
        }
    }

    @Then("user see there is no available survey time for today if open more than 19:00")
    public void userSeeThereIsNoAvailableSurveyTimeForTodayIfOpenMoreThan() {
        var currentTime = JavaHelpers.getCurrentTimeGMT7();

        if (JavaHelpers.isTimeGreater(currentTime, "19:00")) {
            var timeAvailable = tenantSurveyFormPO.getCurrentAvailableTime();
            Assert.assertEquals(timeAvailable.length, 0);
        }
    }

    @Then("user see the gender on survey form is {string}")
    public void userSeeTheGenderOnSurveyFormIs(String gender) {
        var genderOnForm = tenantSurveyFormPO.getTenantGender();

        Assert.assertEquals(genderOnForm, gender);
    }

    @Then("user verify ajukan survey btn is disable on survey form")
    public void userVerifyAjukanSurveyBtnIsDisableOnSurveyForm() {
        Assert.assertTrue(tenantSurveyFormPO.isAjukanSurveyBtnDisable());
    }

    @Then("user verify ajukan survey btn is enable on survey form")
    public void userVerifyAjukanSurveyBtnIsEnableOnSurveyForm() {
        Assert.assertTrue(tenantSurveyFormPO.isAjukanSurveyBtnEnable());
    }

    @And("user click on chevron detail survei")
    public void userClickOnChevronDetailSurvei() {
        tenantSurveyFormPO.userClickOnChevronDetailSurvei();
    }

    @Then("user tap on ajukan survey btn on form")
    public void tapAjukanSurveyBtn() {
        tenantSurveyFormPO.tapOnAjukanSurveyBtn();
    }

    @And("user fill form reason cancel survei {string}")
    public void userFillFormReasonCancelSurvei(String text){
        tenantSurveyFormPO.userFillFormReasonCancelSurvei(text);
    }

    @And("user edit random birthday from survey form request")
    public void userEditBirthdayFromSurveyFormRequest() {
        tenantSurveyFormPO.editRandomProfileBirthdayDate();
    }

    @And("user check on toggle button orang lain yang akan datang survei")
    public void userCheckOnToggleButtonOrangLainYangAkanDatangSurvei() {
        tenantSurveyFormPO.checkedOnToogleOrangLainYangAkanDatangSurvei();
    }

    @And("user uncheck on toggle button orang lain yang akan datang survei")
    public void userUnCheckOnToggleButtonOrangLainYangAkanDatangSurvei() {
        tenantSurveyFormPO.uncheckedOnToogleOrangLainYangAkanDatangSurvei();
    }

    @And("user fill nama for orang lain yang akan datang survey with value {string}")
    public void userFillNamaForOrangLainYangAkanDatangSurveyWithValue(String nama) {
        tenantSurveyFormPO.fillNamaOrangLainYangAkanDatangSurvey(nama);
    }

    @And("user fill hubungan for orang lain yang akan datang survey with value {string}")
    public void userFillHubunganForOrangLainYangAkanDatangSurveyWithValue(String hubungan) {
        tenantSurveyFormPO.fillHubunganOrangLainYangAkanDatangSurvey(hubungan);
    }

    @And("user select date {string} survei")
    public void userSelectDateSurvei(String date) throws ParseException {
        String dateTime = "";
        if (date.equalsIgnoreCase("tomorrow")) {
            dateTime = java.updateTimeLocal("yyyy MMM dd", java.getTimeStamp("yyy MMM dd"), "d", "en", 0, 1, 0, 0, 0);
            tenantSurveyFormPO.userSelectDateSurvei(dateTime);
        }
    }
}
