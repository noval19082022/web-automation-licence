package steps.mamikos.tenant.survei;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.admin.mamipay.bangkrupux.tenantSurveyPO;
import pageobject.common.HomePO;
import pageobject.common.KostDetailsPO;
import pageobject.common.SearchPO;
import pageobject.tenant.survei.TenantSurveyFormPO;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

import java.text.ParseException;
import java.util.List;

public class tenantSurveySteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    tenantSurveyPO surveyPO = new tenantSurveyPO(page);
    TenantSurveyFormPO tenantSurveyFormPO = new TenantSurveyFormPO(page);
    HomePO home = new HomePO(page);
    SearchPO searchPO;
    KostDetailsPO kostDetail = new KostDetailsPO(page);
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

    @When("user Login with tenant")
    public void userLoginWithTenant() {
        String phone = Mamikos.ENV.equals("stag") ? "0891111020199" : "0";
        String password = "mamikosqa123";

        home.clickOnButtonMasuk()
            .clickOnPencariKostButton()
            .waitForPasswordInput()
            .fillPhoneNumber(phone)
            .fillPassword(password)
            .clickOnLoginButton()
            .waitTillLogoIsVisible();
        home.waitForProfileMenuToBeVisible();
        home.clickOnSayaSetujuButton();
    }

    @And("user open detail page GP listing")
    public void userOpenDetailPageGPListing() {
        kostDetail.waitTillKostDetailPageVisible();
    }

    @And("user check section label below price")
    public void userCheckSectionLabelBelowPrice() {
        playwright.pageScrollToDown(300);
        Assert.assertTrue(kostDetail.isSurveyLabelSectionVisible(), "Survey label section is not visible");
    }

    @Then("Verifikasi label survey tampil {string}")
    public void verifikasiLabelSurveyTampil(String expectedText) {
        String actualText = kostDetail.getSurveyLabelText();
        Assert.assertTrue(actualText.contains(expectedText), "Expected survey label to contain: " + expectedText + " but found: " + actualText);
    }

    @Then("user check the label not displayed")
    public void userCheckTheLabelNotDisplayed() {
        playwright.pageScrollToDown(300);
        Assert.assertFalse(kostDetail.isSurveyLabelSectionVisible(), "Survey label section should not be visible for non-GP kost");
    }


    //************************************************************************************************************
    //******** NEW FLOW - SAMEDAY SURVEY STEP DEFINITIONS ********
    //************************************************************************************************************
    @And("user select survey date type {string}")
    public void userSelectSurveyDateType(String dateType) {
        tenantSurveyFormPO.selectSurveyDateType(dateType);
    }

    @And("user open survey date picker on form survey")
    public void userOpenSurveyDatePickerOnFormSurvey() {
        tenantSurveyFormPO.openSurveyDatePicker();
    }

    @And("user select date {string} on survey form")
    public void userSelectDateOnSurveyForm(String date) {
        tenantSurveyFormPO.selectDateFromPicker(date);
    }

    @And("user select survey time period {string}")
    public void userSelectSurveyTimePeriod(String period) {
        tenantSurveyFormPO.selectSurveyTimePeriod(period);
    }

    @And("user select survey time {string}")
    public void userSelectSurveyTime(String time) {
        tenantSurveyFormPO.selectSurveyTime(time);
    }

    @And("user fill phone number {string} on survey form")
    public void userFillPhoneNumberOnSurveyForm(String phoneNumber) {
        tenantSurveyFormPO.fillPhoneNumber(phoneNumber);
    }

    @And("user check TnC agreement checkbox on survey form")
    public void userCheckTnCAgreementCheckboxOnSurveyForm() {
        tenantSurveyFormPO.checkTnCCheckbox();
    }

    @And("user tap {string} on survey confirmation popup")
    public void userTapOnSurveyConfirmationPopup(String action) {
        if (action.equalsIgnoreCase("Kembali")) {
            tenantSurveyFormPO.clickKembaliOnPopup();
        } else if (action.equalsIgnoreCase("Mengerti")) {
            tenantSurveyFormPO.clickMengertiOnPopup();
        }
    }

    @And("user confirm popup ajukan survey if appear")
    public void userConfirmPopupAjukanSurveyIfAppear() {
        tenantSurveyFormPO.confirmPopupIfAppear();
    }

    //************************************************************************************************************
    //******** SAMEDAY SURVEY STEP DEFINITIONS ********
    //************************************************************************************************************

    @Then("user verify survey date type {string} is {string}")
    public void userVerifySurveyDateTypeIs(String dateType, String status) {
        if (dateType.equalsIgnoreCase("Survei Hari Ini")) {
            if (status.equalsIgnoreCase("Visible")) {
                Assert.assertTrue(tenantSurveyFormPO.isSurveyDateTypeSurveiHariIniVisible(),
                        "Survei Hari Ini should be visible");
            } else if (status.contains("disabled")) {
                Assert.assertTrue(tenantSurveyFormPO.isSurveyDateTypeSurveiHariIniDisabled(),
                        "Survei Hari Ini should be disabled");
            }
        } else if (dateType.equalsIgnoreCase("Tanggal Lain")) {
            Assert.assertTrue(tenantSurveyFormPO.isSurveyDateTypeTanggalLainVisible(),
                    "Tanggal Lain should be visible");
        }
    }

    @And("user verify survey date type {string} clickable is {string}")
    public void userVerifySurveyDateTypeClickableIs(String dateType, String clickable) {
        boolean shouldBeClickable = clickable.equalsIgnoreCase("Yes");

        if (dateType.equalsIgnoreCase("Survei Hari Ini")) {
            if (shouldBeClickable) {
                Assert.assertTrue(tenantSurveyFormPO.isSurveyDateTypeSurveiHariIniEnabled(),
                        "Survei Hari Ini should be clickable");
            } else {
                Assert.assertTrue(tenantSurveyFormPO.isSurveyDateTypeSurveiHariIniDisabled(),
                        "Survei Hari Ini should not be clickable");
            }
        } else if (dateType.equalsIgnoreCase("Tanggal Lain")) {
            Assert.assertTrue(tenantSurveyFormPO.isSurveyDateTypeTanggalLainClickable(),
                    "Tanggal Lain should be clickable");
        }
    }

    @Then("user verify survey date type {string} is visible")
    public void userVerifySurveyDateTypeIsVisible(String dateType) {
        if (dateType.equalsIgnoreCase("Tanggal Lain")) {
            Assert.assertTrue(tenantSurveyFormPO.isSurveyDateTypeTanggalLainVisible(),
                    "Tanggal Lain should be visible");
        }
    }

    @And("user verify survey date type {string} is disabled")
    public void userVerifySurveyDateTypeIsDisabled(String dateType) {
        if (dateType.equalsIgnoreCase("Survei Hari Ini")) {
            Assert.assertTrue(tenantSurveyFormPO.isSurveyDateTypeSurveiHariIniDisabled(),
                    "Survei Hari Ini should be disabled");
        }
    }

    @And("user verify survey date type {string} is grayed out")
    public void userVerifySurveyDateTypeIsGrayedOut(String dateType) {
        if (dateType.equalsIgnoreCase("Survei Hari Ini")) {
            Assert.assertTrue(tenantSurveyFormPO.isSurveyDateTypeSurveiHariIniGrayedOut(),
                    "Survei Hari Ini should appear grayed out");
        }
    }

    @And("user verify survey date type {string} is not clickable")
    public void userVerifySurveyDateTypeIsNotClickable(String dateType) {
        if (dateType.equalsIgnoreCase("Survei Hari Ini")) {
            Assert.assertTrue(tenantSurveyFormPO.isSurveyDateTypeSurveiHariIniDisabled(),
                    "Survei Hari Ini should not be clickable");
        }
    }

    @And("user verify survey date type {string} shows tooltip with unavailable message")
    public void userVerifySurveyDateTypeShowsTooltipWithUnavailableMessage(String dateType) {
        String tooltipText = tenantSurveyFormPO.getSurveyDateTypeTooltipText();
        Assert.assertFalse(tooltipText.isEmpty(), "Tooltip should be visible with unavailable message");
    }

    @And("user verify sameday survey message is visible")
    public void userVerifySamedaySurveyMessageIsVisible() {
        Assert.assertTrue(tenantSurveyFormPO.isSamedaySurveyMessageVisible(),
                "Sameday survey message should be visible");
    }

    @And("user verify only today is enabled in calendar")
    public void userVerifyOnlyTodayIsEnabledInCalendar() {
        Assert.assertTrue(tenantSurveyFormPO.isOnlyTodayEnabledInCalendar(),
                "Only today should be enabled in calendar");
    }

    @Then("user verify survey date picker placeholder is {string}")
    public void userVerifySurveyDatePickerPlaceholderIs(String expectedPlaceholder) {
        String actualPlaceholder = tenantSurveyFormPO.getSurveyDatePickerPlaceholder();
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder,
                "Survey date picker placeholder should be: " + expectedPlaceholder);
    }

    @And("user verify tanggal lain message contains {string}")
    public void userVerifyTanggalLainMessageContains(String expectedText) {
        String actualMessage = tenantSurveyFormPO.getTanggalLainMessage();
        Assert.assertTrue(actualMessage.contains(expectedText),
                "Tanggal Lain message should contain: " + expectedText);
    }

    @And("user verify date range is selectable up to {string} days from today")
    public void userVerifyDateRangeIsSelectableUpToDaysFromToday(String days) {
        int daysFromToday = Integer.parseInt(days);
        Assert.assertTrue(tenantSurveyFormPO.verifyDateRangeSelectable(daysFromToday),
                "Date range should be selectable up to " + days + " days from today");
    }

    @And("user verify past dates are disabled")
    public void userVerifyPastDatesAreDisabled() {
        Assert.assertTrue(tenantSurveyFormPO.arePastDatesDisabled(),
                "Past dates should be disabled");
    }

    @And("current time is set to {string}")
    public void currentTimeIsSetTo(String time) {
        // This step is for documentation/context
        // Actual time mocking would need to be implemented based on test environment
        // For now, this is a placeholder step
    }

    @Then("user verify time slot {string} status is {string}")
    public void userVerifyTimeSlotStatusIs(String time, String expectedStatus) {
        if (expectedStatus.equalsIgnoreCase("Enabled")) {
            Assert.assertTrue(tenantSurveyFormPO.isTimeSlotEnabled(time),
                    "Time slot " + time + " should be enabled");
        } else if (expectedStatus.equalsIgnoreCase("Disabled")) {
            Assert.assertTrue(tenantSurveyFormPO.isTimeSlotDisabled(time),
                    "Time slot " + time + " should be disabled");
        }
    }

    @Then("user verify all time slots are disabled in period {string}")
    public void userVerifyAllTimeSlotsAreDisabledInPeriod(String period) {
        Assert.assertTrue(tenantSurveyFormPO.areAllTimeSlotsDisabledInPeriod(period),
                "All time slots should be disabled in period " + period);
    }

    @Then("user verify all time slots from {string} are enabled")
    public void userVerifyAllTimeSlotsFromAreEnabled(String startTime) {
        Assert.assertTrue(tenantSurveyFormPO.areAllTimeSlotsFromTimeEnabled(startTime),
                "All time slots from " + startTime + " should be enabled");
    }

    @Then("user verify all time slots are disabled")
    public void userVerifyAllTimeSlotsAreDisabled() {
        Assert.assertTrue(tenantSurveyFormPO.areAllTimeSlotsDisabled(),
                "All time slots should be disabled");
    }

    @And("user verify {string} option becomes unselectable")
    public void userVerifyOptionBecomesUnselectable(String option) {
        if (option.equalsIgnoreCase("Survei Hari Ini")) {
            Assert.assertTrue(tenantSurveyFormPO.isSurveyHariIniUnselectable(),
                    "Survei Hari Ini option should become unselectable");
        }
    }

    @And("user verify system suggests {string} option")
    public void userVerifySystemSuggestsOption(String option) {
        if (option.equalsIgnoreCase("Tanggal Lain")) {
            Assert.assertTrue(tenantSurveyFormPO.isSuggestionToSelectTanggalLainVisible(),
                    "System should suggest Tanggal Lain option");
        }
    }

    @Then("user verify only time slots for period {string} are displayed")
    public void userVerifyOnlyTimeSlotsForPeriodAreDisplayed(String period) {
        List<String> displayedSlots = tenantSurveyFormPO.getDisplayedTimeSlotsForPeriod(period);
        Assert.assertFalse(displayedSlots.isEmpty(),
                "Time slots for period " + period + " should be displayed");
    }

    @And("user verify displayed time slots are between {string} and {string}")
    public void userVerifyDisplayedTimeSlotsAreBetweenAnd(String startTime, String endTime) {
        Assert.assertTrue(tenantSurveyFormPO.verifyDisplayedTimeSlotsRange(startTime, endTime),
                "Displayed time slots should be between " + startTime + " and " + endTime);
    }

    @And("user verify displayed time slots switch to period {string}")
    public void userVerifyDisplayedTimeSlotsSwitchToPeriod(String period) {
        List<String> displayedSlots = tenantSurveyFormPO.getDisplayedTimeSlotsForPeriod(period);
        Assert.assertFalse(displayedSlots.isEmpty(),
                "Time slots should switch to period " + period);
    }

    @And("user verify previously selected time {string} remains selected")
    public void userVerifyPreviouslySelectedTimeRemainsSelected(String time) {
        Assert.assertTrue(tenantSurveyFormPO.isTimePreviouslySelected(time),
                "Previously selected time " + time + " should remain selected");
    }

    @Then("user verify phone number validation is {string}")
    public void userVerifyPhoneNumberValidationIs(String isValid) {
        if (isValid.equalsIgnoreCase("Yes")) {
            Assert.assertTrue(tenantSurveyFormPO.isPhoneNumberValidationPassed(),
                    "Phone number validation should pass");
        } else {
            Assert.assertFalse(tenantSurveyFormPO.isPhoneNumberValidationPassed(),
                    "Phone number validation should fail");
        }
    }

    @And("user verify phone number error message is {string}")
    public void userVerifyPhoneNumberErrorMessageIs(String expectedErrorMsg) {
        if (!expectedErrorMsg.equals("-")) {
            String actualErrorMsg = tenantSurveyFormPO.getPhoneNumberErrorMessage();
            Assert.assertEquals(actualErrorMsg, expectedErrorMsg,
                    "Phone number error message should be: " + expectedErrorMsg);
        }
    }

    @Then("user verify TnC link text is {string}")
    public void userVerifyTnCLinkTextIs(String expectedText) {
        String actualText = tenantSurveyFormPO.getTnCLinkText();
        Assert.assertTrue(actualText.contains(expectedText),
                "T&C link text should contain: " + expectedText);
    }

    @When("user click on TnC link")
    public void userClickOnTnCLink() {
        tenantSurveyFormPO.clickTnCLink();
    }

    @Then("user verify TnC link opens {string}")
    public void userVerifyTnCLinkOpens(String expectedDestination) {
        String actualDestination = tenantSurveyFormPO.getTnCLinkDestination();
        Assert.assertTrue(actualDestination.contains(expectedDestination) ||
                        actualDestination.contains("kebijakan-privasi"),
                "T&C link should open: " + expectedDestination);
    }

    @And("user verify TnC section is scrollable not sticky")
    public void userVerifyTnCSectionIsScrollableNotSticky() {
        Assert.assertTrue(tenantSurveyFormPO.isTnCSectionScrollable(),
                "T&C section should be scrollable, not sticky");
    }

    @Then("user verify popup confirmation is visible")
    public void userVerifyPopupConfirmationIsVisible() {
        Assert.assertTrue(tenantSurveyFormPO.isPopupConfirmationVisible(),
                "Popup confirmation should be visible");
    }

    @And("user verify popup confirmation heading is {string}")
    public void userVerifyPopupConfirmationHeadingIs(String expectedHeading) {
        String actualHeading = tenantSurveyFormPO.getPopupConfirmationHeadingText();
        Assert.assertEquals(actualHeading, expectedHeading,
                "Popup confirmation heading should be: " + expectedHeading);
    }

    @Then("user verify navigation to chatroom is successful")
    public void userVerifyNavigationToChatroomIsSuccessful() {
        Assert.assertTrue(tenantSurveyFormPO.isNavigationToChatroomSuccessful(),
                "Navigation to chatroom should be successful");
    }

    @And("user verify survey request sent with phone number visible")
    public void userVerifySurveyRequestSentWithPhoneNumberVisible() {
        Assert.assertTrue(tenantSurveyFormPO.isSurveyRequestSentWithPhoneVisible(),
                "Survey request should be sent with phone number visible");
    }

    @And("user verify P2 autoreply message appears")
    public void userVerifyP2AutoreplyMessageAppears() {
        Assert.assertTrue(tenantSurveyFormPO.isP2AutoreplyMessageVisible(),
                "P2 autoreply message should appear");
    }

    @And("user verify survey status shows {string}")
    public void userVerifySurveyStatusShows(String expectedStatus) {
        String actualStatus = tenantSurveyFormPO.getSurveyStatusText();
        Assert.assertTrue(actualStatus.contains(expectedStatus),
                "Survey status should show: " + expectedStatus);
    }
}
