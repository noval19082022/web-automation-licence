package steps.mamipay;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import pageobject.admin.mamipay.AdminMamipayDashboardPO;
import utilities.PlaywrightHelpers;

public class AdminMamipaySteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    AdminMamipayDashboardPO adminMamipay = new AdminMamipayDashboardPO(page);

    @And("admin search owner phone {string} in mamipay owner list")
    public void adminSearchOwnerPhoneInMamipayOwnerList(String phoneOwner) {
        adminMamipay.searchPhoneOwner(phoneOwner);
    }

    @And("admin delete the mamipay data from first list")
    public void adminDeleteTheMamipayDataFromFirstList() {
        if (adminMamipay.isFirstDeleteMamipayDisplayed()){
            adminMamipay.clickOnFirstDeleteMamipay();
        }
    }
}