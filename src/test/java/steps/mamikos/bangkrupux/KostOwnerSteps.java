package steps.mamikos.bangkrupux;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.admin.mamipay.bangkrupux.KostOwnerPO;
import testdata.BangKrupuxTestData;
import utilities.PlaywrightHelpers;

public class KostOwnerSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    KostOwnerPO kostOwner = new KostOwnerPO(page);
    Page page1;

    @And("admin bangkrupux search kost owner {string} in admin kos owner page")
    public void adminBangkrupuxSearchKostOwnerInAdminKosOwnerPage(String kostName) {
        kostOwner.searchKosName(kostName);
    }

    @And("admin bangkrupux search kost owner {string} with phone number {string} in admin kos owner page")
    public void adminBangkrupuxSearchKostOwnerInAdminKosOwnerPage(String kostName, String phone) {
        kostOwner.searchKosNameAndPhoneNumber(kostName, phone);
    }

    @And("admin bangkrupux search booking owner request {string} in admin booking owner request page")
    public void adminBangkrupuxSearchBookingOwnerRequestInAdminKosOwnerPage(String kostName) {
        kostOwner.searchKosNameBookingOwnerRequest(kostName);
    }

    @And("admin reject BBK kos")
    public void adminRejectBBKKos() {
            kostOwner.clickOnRejectBBK();
    }

    @And("admin reject bulk BBK kos")
    public void adminRejectBulkBBKKos() {
        playwright.hardWait(3000.0);
        kostOwner.clickOnRejectBBK();
    }

    @And("admin verify the property {string}")
    public void adminVerifyTheProperty(String property) {
        kostOwner.clickOnVerifyIcon(property);
    }

    @Then("verify {string} displayed")
    public void verifyDisplayed(String alertMessage) {
        Assert.assertEquals(kostOwner.getAlertMessage(), alertMessage, "Alert message doesn't match!");
    }

    @And("user verify the kos in admin kos owner")
    public void userVerifyTheKosInAdminKosOwner() {
        kostOwner.clickOnFirstVerifyButton();
    }

    @And("user verify the kos in admin kos owner if exist")
    public void userVerifyTheKosInAdminKosOwnerIfExist() {
        kostOwner.clickVerifyButtonIfExists();
    }

    @And("admin bangkrupux search kost owner in admin kos owner page")
    public void adminBangkrupuxSearchKostOwnerInAdminKosOwnerPage() {
        String kosName = Mamikos.getPropertyKosName();
        if (kosName == null || kosName.isEmpty()) {
            // Use a default kos name for search if none is set
            kosName = "kos Automation TEST";
            System.out.println("Warning: Kos name not found in shared data, using default: " + kosName);
        }
        kostOwner.searchKosName(kosName);
    }

    @And("admin delete kos")
    public void adminDeleteKos() {
        BangKrupuxTestData.hrefDeleteKosUrl(kostOwner.getKosListDeleteUrl());
        kostOwner.navigateToDeleteUrl();
    }

    @And("admin accept kos")
    public void adminApproveKos() {
        kostOwner.getKosListApproveUrl();
    }

    @And("admin reject kos")
    public void adminRejectKos() {
        BangKrupuxTestData.hrefRejectKostUrl(kostOwner.getKosListRejectUrl());
        kostOwner.navigateToRejectUrl();
    }

    @And("admin input the reason {string} in reject reason page below {string}")
    public void adminInputTheReasonInRejectReasonPageBelow(String reason, String reasonRejectTitle) {
        kostOwner.selectRejectReason(reason);
        Mamikos.setRejectReason(reason);
        Mamikos.setRejectReasonTitle(reasonRejectTitle);
    }

    @And("user click {string} button in kos owner reject reason")
    public void userClickButtonInKosOwnerRejectReason(String text) {
        kostOwner.clickOnRejectKos(text);
    }

    @And("user click {string} in send reject pop up")
    public void userClickInSendRejectPopUp(String text) {
        kostOwner.clickOnSendReject(text);
    }

    @And("admin click on {string} link button")
    public void adminClickOnLinkButton(String textLink) {
      page1 = kostOwner.clickOnBBKData(textLink);
    }

    @And("admin bangkrupux search phone owner in admin kos owner page")
    public void adminBangkrupuxSearchPhoneOwnerInAdminKosOwnerPage() {
        kostOwner.searchPhoneOwner(Mamikos.getPhoneOwner());
    }

    @And("admin bangkrupux search phone owner {string} in admin kos owner page")
    public void adminBangkrupuxSearchPhoneOwnerInAdminKosOwnerPage(String phoneOwner) {
        kostOwner.searchPhoneOwner(phoneOwner);
    }
}