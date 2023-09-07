package steps.mamikos.bangkrupux;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.admin.mamipay.bangkrupux.KostOwnerPO;
import utilities.PlaywrightHelpers;

public class KostOwnerSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    KostOwnerPO kostOwner = new KostOwnerPO(page);

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
}
