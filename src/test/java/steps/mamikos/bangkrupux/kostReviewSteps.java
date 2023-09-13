package steps.mamikos.bangkrupux;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.admin.mamipay.bangkrupux.kostReviewPO;
import pageobject.admin.mamipay.bangkrupux.tenantSurveyPO;
import utilities.PlaywrightHelpers;

import java.text.ParseException;
import java.util.Map;

public class kostReviewSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    private Map<String, String> userCreateKostReview;
    kostReviewPO kostReview = new kostReviewPO(page);


    @And("user Create Review without contract data:")
    public void userCreateReviewWithoutContractData(DataTable table) throws InterruptedException, ParseException {
        userCreateKostReview = table.asMap(String.class, String.class);
        var annonymous = userCreateKostReview.get("annonymous");
        var reviewType = userCreateKostReview.get("review type");
        var OTA = userCreateKostReview.get("OTA");
        var tenantName = userCreateKostReview.get("tenant name");
        var tenantPhoneNumber = userCreateKostReview.get("tenant phoneNumber");
        var kostName = userCreateKostReview.get("kost name");
        var startDate = userCreateKostReview.get("start date");
        var endDate = userCreateKostReview.get("end date");
        kostReview.goToKostReviewMenu();
        kostReview.clickOnCreateReviewButton();
        kostReview.fillOnAnonymous(annonymous);
        kostReview.fillOnReviewType(reviewType);
        kostReview.fillOnOTA(OTA);
        kostReview.fillOnTenantNameField(tenantName);
        kostReview.fillOnTenantNumberField(tenantPhoneNumber);
        kostReview.fillOnKostNameField(kostName);
        kostReview.chooseFormStartDate(startDate);
        kostReview.chooseFormEndtDate(endDate);
    }

    @And("user fill second Create Review data")
    public void userFillSecondCreateReviewData(DataTable table) throws InterruptedException, ParseException {
        userCreateKostReview = table.asMap(String.class, String.class);
        var clean = userCreateKostReview.get("kebersihan");
        var happy = userCreateKostReview.get("kenyamanan");
        var roomFacilities = userCreateKostReview.get("fasilitas kamar");
        var security = userCreateKostReview.get("keamanan");
        var publicFacilities = userCreateKostReview.get("fasilitas umum");
        var price = userCreateKostReview.get("kesesuaian harga");
        var reviewField = userCreateKostReview.get("review field");
        kostReview.fillOnKebersihan(clean);
        kostReview.fillOnKenyamanan(happy);
        kostReview.fillOnFasilitasKamar(roomFacilities);
        kostReview.fillOnKeamanan(security);
        kostReview.fillOnFasilitasUmum(publicFacilities);
        kostReview.fillOnKesesuaianHarga(price);
        kostReview.fillOnReviewField(reviewField);
    }

    @And("user click Save on Create Review section")
    public void userClickSavelOnCreateReviewSection() {
        kostReview.clickOnSaveReviewButton();
    }

    @Then("user verify success alert with {string}")
    public void userVerifySuccessAlertWith(String text) throws InterruptedException {
        tenantSurveyPO surveyPO = new tenantSurveyPO(page);
        Assert.assertTrue(surveyPO.isAlertAppear(), "Success alert is not appeared");
        String actualAlertText = surveyPO.getAlertText().substring(2,42).trim();
        Assert.assertEquals(actualAlertText, text, "Success alert text is not equal to " + text);
    }

    @And("user Edit Review without contract data on {string}:")
    public void userEditReviewWithoutContractDataOn(String content, DataTable table) throws InterruptedException, ParseException {
        userCreateKostReview = table.asMap(String.class, String.class);
        var annonymous = userCreateKostReview.get("annonymous");
        var OTA = userCreateKostReview.get("OTA");
        var tenantName = userCreateKostReview.get("tenant name");
        var tenantPhoneNumber = userCreateKostReview.get("tenant phoneNumber");
        var kostName = userCreateKostReview.get("kost name");
        var startDate = userCreateKostReview.get("start date");
        var endDate = userCreateKostReview.get("end date");
        kostReview.goToKostReviewMenu();
        kostReview.clickOnEditButton(content);
        kostReview.fillOnAnonymous(annonymous);
        kostReview.fillOnOTA(OTA);
        kostReview.fillOnTenantNameField(tenantName);
        kostReview.fillOnTenantNumberField(tenantPhoneNumber);
        kostReview.fillOnKostNameField(kostName);
        kostReview.chooseFormStartDate(startDate);
        kostReview.chooseFormEndtDate(endDate);
    }

    @Then("user verify success edit alert with {string}")
    public void userVerifySuccessEditAlertWith(String text) throws InterruptedException {
        tenantSurveyPO surveyPO = new tenantSurveyPO(page);
        Assert.assertTrue(surveyPO.isAlertAppear(), "Success created kost review alert is not appeared");
        String actualAlertText = surveyPO.getAlertText().substring(2,30).trim();
        Assert.assertEquals(actualAlertText, text, "Success created alert text is not equal to " + text);
    }

    @And("user click Live button on {string}")
    public void userClickLiveButtonOn(String content) throws InterruptedException {
        kostReview.goToKostReviewMenu();
        kostReview.clickOnLiveButton(content);
    }

    @Then("user receive success alert for kost review updated to live with text {string}")
    public void userReceiveSuccessAlertForKostReviewUpdatedToLiveWithText(String text) throws InterruptedException {
        tenantSurveyPO surveyPO = new tenantSurveyPO(page);
        Assert.assertTrue(surveyPO.isAlertAppear(), "Success created kost review alert is not appeared");
        String actualAlertText = surveyPO.getAlertText().substring(2,38).trim();
        Assert.assertEquals(actualAlertText, text, "Success created alert text is not equal to " + text);

    }

    @And("user click Reject button on {string}")
    public void userClickRejectButtonOn(String content) throws InterruptedException {
        kostReview.goToKostReviewMenu();
        kostReview.clickOnRejectButton(content);
    }

    @Then("user receive success alert for kost review updated to reject with text {string}")
    public void userReceiveSuccessAlertForKostReviewUpdatedToRejectWithText(String text) throws InterruptedException {
        tenantSurveyPO surveyPO = new tenantSurveyPO(page);
        Assert.assertTrue(surveyPO.isAlertAppear(), "Success created kost review alert is not appeared");
        String actualAlertText = surveyPO.getAlertText().substring(2,39).trim();
        Assert.assertEquals(actualAlertText, text, "Success created alert text is not equal to " + text);
    }

    @And("user click Delete button on {string}")
    public void userClickDeleteButtonOn(String content) throws InterruptedException {
        kostReview.goToKostReviewMenu();
        kostReview.clickOnDeleteReviewButton(content);
    }

    @Then("user receive success alert for deleted kost review with text {string}")
    public void userReceiveSuccessAlertForDeletedKostReviewWithText(String text) throws InterruptedException {
        tenantSurveyPO surveyPO = new tenantSurveyPO(page);
        Assert.assertTrue(surveyPO.isAlertAppear(), "Success created kost review alert is not appeared");
        String actualAlertText = surveyPO.getAlertText().substring(2,39).trim();
        Assert.assertEquals(actualAlertText, text, "Success created alert text is not equal to " + text);
    }

    @And("user Create Review with contract data:")
    public void userCreateReviewWithContractData(DataTable table) throws InterruptedException, ParseException {
        userCreateKostReview = table.asMap(String.class, String.class);
        var annonymous = userCreateKostReview.get("annonymous");
        var reviewType = userCreateKostReview.get("review type");
        var contractId = userCreateKostReview.get("contract id");
        kostReview.goToKostReviewMenu();
        kostReview.clickOnCreateReviewButton();
        kostReview.fillOnAnonymous(annonymous);
        kostReview.fillOnReviewType(reviewType);
        kostReview.fillOnContractId(contractId);
    }

    @And("user Edit Review wit contract data on {string}:")
    public void userEditReviewWitContractDataOn(String content, DataTable table) throws InterruptedException, ParseException {
        userCreateKostReview = table.asMap(String.class, String.class);
        var annonymous = userCreateKostReview.get("annonymous");
        var contractId = userCreateKostReview.get("contract id");
        kostReview.goToKostReviewMenu();
        kostReview.clickOnEditButton(content);
        kostReview.fillOnAnonymous(annonymous);
        kostReview.fillOnContractId(contractId);
    }

    @And("user click cancel on Create Review section")
    public void userClickCancelOnCreateReviewSection() throws InterruptedException  {
        kostReview.clickOnCancelReviewButton();
    }
}
