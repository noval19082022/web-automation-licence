package steps.mamikos.common;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import config.global.FlowControl;
import config.playwright.context.ActiveContext;
import config.playwright.context.OwnerContext;
import config.playwright.context.TenantContext;
import data.mamikos.Mamikos;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.ForgotPasswordPO;
import pageobject.common.HomePO;
import utilities.PlaywrightHelpers;

public class NavigatesSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    HomePO home = new HomePO(page);
    ForgotPasswordPO forgotPassword = new ForgotPasswordPO(page);

    @Given("user go to mamikos homepage")
    public void userGoToMamikosHomepage() {
        playwright.navigateToAndWaitLocator(Mamikos.URL, home.getMamikosLogo());
    }

    @Given("admin go to mamikos mamipay admin")
    public void adminGoToMamikosMamipayAdmin() {
        playwright.navigateTo(Mamikos.ADMINMAMIPAY);
    }

    @When("scenario is {string}")
    public void scenarioIsContinue(String isContinue) {
        FlowControl.setContinueFlow(isContinue.equalsIgnoreCase("continue"));
    }

    @Given("tenant open browser page {string}")
    public void tenantOpenBrowserPage(String pageNumber) {
        ActiveContext.setActivePage(TenantContext.getTenantBrowserContext().pages().get(Integer.parseInt(pageNumber)));
    }

    @When("owner open browser page {string}")
    public void ownerOpenBrowserPage(String pageNumber) {
        ActiveContext.setActivePage(OwnerContext.getOwnerBrowserContext().pages().get(Integer.parseInt(pageNumber)));
    }

    @When("tenant navigates to edit profile")
    public void tenantNavigatesToEditProfile() {
        page = ActiveContext.getActivePage();
        playwright.navigateTo(Mamikos.URL + Mamikos.TENANT_EDIT_PROFILE, 60000.0);
    }

    @When("tenant/owner/admin close page number {int}")
    public synchronized void tenantClosePageNumber(int pageNumber) throws InterruptedException {
        ActiveContext.getActiveBrowserContext().pages().get(pageNumber).close();
        Thread.sleep(2000);
    }

    @When("tenant/owner/admin refresh page {int}")
    public void tenantRefreshPage(int pageNumber) {
        ActiveContext.getActiveBrowserContext().pages().get(pageNumber).reload();
    }

    @When("tenant/owner/admin set active page to {int}")
    public synchronized void tenantSetActivePageTo(int activePage) {
        ActiveContext.setActivePage(ActiveContext.getActiveBrowserContext().pages().get(activePage));
    }

    @When("tenant/owner/admin open new page")
    public void tenantOpenNewPage() {
        page = ActiveContext.getActiveBrowserContext().waitForPage(() -> {
            ActiveContext.getActiveBrowserContext().newPage();
        });

    }

    @When("tenant navigate to riwayat booking")
    public void tenantNavigateToRiwayatBooking() {
        playwright = new PlaywrightHelpers(page);
        playwright.navigateTo(Mamikos.URL + Mamikos.TENANT_RIWAYAT_BOOKING, 30000.0, LoadState.LOAD);
    }

    @When("tenant/user navigate to tagihan kost saya")
    public void userNavigateToTagihanKostSaya() {
        playwright.navigateTo(Mamikos.URL + Mamikos.KOST_SAYA_BILLING, 30000.0, LoadState.LOAD);
    }

    @When("owner/user navigate to billing management")
    public void userNavigateToBillingManagement() {
        playwright.navigateTo(Mamikos.OWNER_URL + Mamikos.KELOLA_TAGIHAN, 30000.0, LoadState.LOAD);
    }

    @Given("tenant navigate to favorite page")
    public void tenantNavigateToFavoritePage() {
        playwright.navigateTo(Mamikos.URL + Mamikos.FAVORITE_PAGE, 30000.0, LoadState.LOAD);
    }

    @Given("user navigates to mamikos-kost")
    public void userNavigatesToMamikosKost() {
        playwright = new PlaywrightHelpers(page);
        playwright.navigateTo(Mamikos.URL + Mamikos.KOST, 30000.0, LoadState.LOAD);
    }

    @Then("navbar kost before login appears")
    public void navbarKostBeforeLoginAppears() {
        Assert.assertTrue(home.isDownloadAppDisplayed(), "Download App button not present!");
        Assert.assertTrue(home.isSearchAdsDisplayed(), "Cari Iklan button not present!");
        Assert.assertTrue(home.isHelpCenterDisplayed(), "Pusat Bantuan button not present!");
        Assert.assertTrue(home.isTermConditionDisplayed(), "Syarat Ketentuan button not present!");
        Assert.assertTrue(home.isPromosiAdsDisplayed(), "Promosi Iklan button not present!");
        Assert.assertTrue(home.isEnterButtonDisplayed(), "Enter button not present!");
    }

    @Given("user navigates to mamikos-booking")
    public void userNavigatesToMamikosBooking() {
        playwright = new PlaywrightHelpers(page);
        playwright.navigateTo(Mamikos.URL + Mamikos.BOOKING, 30000.0, LoadState.LOAD);
    }

    @Given("user navigates to mamikos-promo-kost")
    public void userNavigatesToMamikosPromoKost() {
        playwright = new PlaywrightHelpers(page);
        playwright.navigateTo(Mamikos.URL + Mamikos.PROMO_KOST, 30000.0, LoadState.LOAD);
    }

    @Given("user navigates to mamikos-history")
    public void userNavigatesToMamikosHistory() {
        playwright = new PlaywrightHelpers(page);
        playwright.navigateTo(Mamikos.URL + Mamikos.HISTORY, 30000.0, LoadState.LOAD);
    }

    @Given("user navigates to promo ngebut landing page")
    public void userNavigatesToPromoNgebutLandingPage() {
        playwright = new PlaywrightHelpers(page);
        playwright.navigateTo(Mamikos.URL + Mamikos.PROMO_NGEBUT, 30000.0, LoadState.LOAD);
    }

    @Given("user navigates to promo ngebut landing area")
    public void userNavigatesToPromoNgebutLandingArea() {
        playwright = new PlaywrightHelpers(page);
        playwright.navigateTo(Mamikos.URL + Mamikos.PROMO_NGEBUT_AREA, 30000.0, LoadState.LOAD);
    }

    @Given("admin go to mamikos bangkrupux admin")
    public void adminGoToMamikosBangkrupuxAdmin() {
        playwright.navigateTo(Mamikos.ADMINBANGKRUPUX);
    }

    @Given("user go to landing apartment")
    public void userGoToLandingApartment() {
        playwright = new PlaywrightHelpers(page);
        playwright.navigateTo(Mamikos.URL + Mamikos.APARTMENT, 30000.0, LoadState.LOAD);
    }

    @Given("admin go to pms singgahsini")
    public void admin_go_to_pms_singgahsini() {
        playwright.navigateTo(Mamikos.PMS_URL);
    }

    @When("user want to change the owner password")
    public void user_want_to_change_owner_password() {
        forgotPassword.clickOnEntryToLoginPage();
        forgotPassword.clickOnLoginAsOwner();
        forgotPassword.clickOnLupaPassword();
    }

    @When("user fill their registered phone number {string}")
    public void input_phone_number(String phoneNumber) {
        forgotPassword.fillPhoneNumber(phoneNumber);
        forgotPassword.chooseVerificationMethod();
    }

    @When("user choose verification by sms")
    public void user_choose_verify_by_sms() {
        forgotPassword.selectOTPBySMS();
    }

    @Then("user verify {string} and click button resend OTP")
    public void kirim_ulang_otp_verification(String text) {
        playwright.hardWait60Seconds();
        Assert.assertTrue(forgotPassword.getResendOTPButton().contains(text), "Code verification text is not equal to " + text);
        forgotPassword.clickOnResendOtp();
    }
}
