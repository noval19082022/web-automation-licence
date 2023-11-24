package steps.mamikos.bangkrupux;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.admin.mamipay.bangkrupux.KostOwnerPO;
import pageobject.owner.PropertySayaPO;
import testdata.BangKrupuxTestData;
import utilities.PlaywrightHelpers;

public class KostOwnerSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    KostOwnerPO kostOwner = new KostOwnerPO(page);
    PropertySayaPO propertySaya = new PropertySayaPO(page);

    @And("admin bangkrupux search kost owner {string} in admin kos owner page")
    public void adminBangkrupuxSearchKostOwnerInAdminKosOwnerPage(String kostName) {
        kostOwner.searchKosName(kostName);
    }

    @And("admin reject BBK kos")
    public void adminRejectBBKKos() {
        playwright.navigateTo(Mamikos.URL + "/admin/booking/owner/reject-reason/1000032089r", 30000.0, LoadState.LOAD);
        kostOwner.clickOnFirstRadioButton();
        kostOwner.clickOnRejectButton();
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

    @And("admin bangkrupux search kost owner in admin kos owner page")
    public void adminBangkrupuxSearchKostOwnerInAdminKosOwnerPage() {
        kostOwner.searchKosName(Mamikos.getPropertyKosName());
    }

    @And("admin delete kos")
    public void adminDeleteKos() {
        BangKrupuxTestData.hrefDeleteKosUrl(kostOwner.getKosListDeleteUrl());
        kostOwner.navigateToDeleteUrl();
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
}
