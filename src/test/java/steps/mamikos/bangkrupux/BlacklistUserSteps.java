package steps.mamikos.bangkrupux;
import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.admin.mamipay.AdminMamipayDashboardPO;
import pageobject.admin.mamipay.bangkrupux.AdminBangkrupuxLoginPO;
import pageobject.admin.mamipay.bangkrupux.BlacklistUserPO;
import pageobject.admin.mamipay.voucher.MamikosListMassVoucherPO;
import pageobject.common.HomePO;
import utilities.JavaHelpers;
import utilities.PlaywrightHelpers;

import java.util.List;
import java.util.Map;

public class BlacklistUserSteps {
    Page page = ActiveContext.getActivePage();

     BlacklistUserPO blacklistUser = new BlacklistUserPO(page);
    HomePO home = new HomePO(page);

    @When("user access menu blacklist user")
    public void userAccessMenuBlacklistUser() {
        blacklistUser.clickBlacklistUserMenu();
    }

    @Then("user choose dropdown {string} enter value {string} and validate filter result {string}")
    public void userChooseDropdownEnterValueAndValidateFilterResult(String dropDown, String value, String result) {
        if (dropDown.equalsIgnoreCase("phone_number")){
            blacklistUser.selectBlacklistSearchBy(dropDown, value);
            Assert.assertEquals(blacklistUser.getResultSearchBy(value), value, "result don't match");
        } else if (dropDown.equalsIgnoreCase("email")) {
            blacklistUser.selectBlacklistSearchBy(dropDown, value);
            Assert.assertEquals(blacklistUser.getResultSearchBy(value), value, "result don't match");
        }
    }

    @And("user click blacklist a user button")
    public void userClickBlacklistAUserButton() {
        blacklistUser.clickBlacklistUserAButton();
    }

    @And("user add with phone number {string}")
    public void userAddWithPhoneNumber(String phoneNumber) {
        blacklistUser.insertPhoneNumberBlacklistAUser(phoneNumber);
    }

    @Then("user see overview blacklist user data")
    public void userSeeOverviewBlacklistUserData() {
        Assert.assertTrue(blacklistUser.isUserIDPresent(), "User ID is not present!");
        Assert.assertTrue(blacklistUser.isUserNamePresent(), "User Name is not present!");
        Assert.assertTrue(blacklistUser.isPhoneNumberPresent(), "Phone Number is not present!");
        Assert.assertTrue(blacklistUser.isEmailPresent(), "User Email is not present!");
    }

    @And("user fill note {string}")
    public void userFillNote(String note) {
        blacklistUser.insertNote(note);
    }

    @And("user click button submit")
    public void userClickButtonSubmit() {
        blacklistUser.clickSubmitButton();
    }

    @Then("user see blacklist updated success message")
    public void userSeeBlacklistUpdatedSuccessMessage() {
        Assert.assertTrue(blacklistUser.isSuccessMessagePresent(), "Update Success message is not present!");
    }

    @Then("user see message error validation {string}")
    public void userSeeMessageErrorValidation(String message) {
        Assert.assertEquals(blacklistUser.getMessageAcoountBlacklist(),message, "error messages is not equal to " + message);
    }

    @And("user click on button masuk pencari kos")
    public void userClickOnButtonMasukPencariKos() {
        home.clickOnButtonMasuk()
            .clickOnPencariKostButton();
    }

    @And("user click on unblacklist")
    public void userClickOnUnblacklist() {
        blacklistUser.clickUnblacklistButton();
    }

    @And("user click blacklist on homepage blacklist")
    public void userClickBlacklistOnHomepageBlacklist() {
        blacklistUser.clickBlacklistButtonOnHomepage();
    }
}
