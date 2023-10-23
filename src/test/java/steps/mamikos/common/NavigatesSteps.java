package steps.mamikos.common;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import config.global.FlowControl;
import config.playwright.context.ActiveContext;
import data.api.AjukanSewaStatus;
import data.mamikos.Mamikos;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.ForgotPasswordPO;
import pageobject.common.HomePO;
import pageobject.pms.LoginPMSPO;
import pageobject.tenant.profile.VerifikasiAkunPO;
import utilities.PlaywrightHelpers;

import java.util.List;

public class NavigatesSteps {
    Page page = ActiveContext.getActivePage();
    Page page1;
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    HomePO home = new HomePO(page);
    ForgotPasswordPO forgotPassword = new ForgotPasswordPO(page);
    LoginPMSPO loginPMS = new LoginPMSPO(page);
    VerifikasiAkunPO verifikasiAkun = new VerifikasiAkunPO(page);

    @Given("user go to mamikos homepage")
    public void userGoToMamikosHomepage() {
        page = ActiveContext.getActivePage();
        home = new HomePO(page);
        home.navigatesToHomepage();
    }

    @Given("admin go to mamikos mamipay admin")
    public void adminGoToMamikosMamipayAdmin() {
        if (AjukanSewaStatus.isContractPresent() || !FlowControl.isApiFlow()) {
            playwright.navigateTo(Mamikos.ADMINMAMIPAY+Mamikos.LOGIN_MAMIPAY, 30000.0);
        }
    }

    @When("admin navigates to Admin Goldplus Package")
    public void adminNavigatesToAdminGoldplusPackage() {
        playwright.navigateTo(Mamikos.URL+Mamikos.ADMIN_GOLDPLUS_PACKAGE);
    }

    @When("scenario is {string}")
    public void scenarioIsContinue(String isContinue) {
        FlowControl.setContinueFlow(isContinue.equalsIgnoreCase("continue"));
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
        List<Page> listPage = ActiveContext.getActiveBrowserContext().pages();
        ActiveContext.setActivePage(listPage.get(activePage));
        playwright = new PlaywrightHelpers(ActiveContext.getActivePage());
        playwright.bringPageToView(ActiveContext.getActivePage());
    }

    @When("tenant/owner/admin open new page")
    public void tenantOpenNewPage() {
        page = ActiveContext.getActiveBrowserContext().waitForPage(() -> {
            ActiveContext.getActiveBrowserContext().newPage();
        });
        ActiveContext.setActivePage(page);
    }

    @When("tenant navigate to riwayat and draf booking")
    public void tenantNavigateToRiwayatAndDrafBooking() {
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
        loginPMS.navigateToPmsLoginPage();
    }

    @When("owner navigates to property saya kos")
    public void userNavigateToPropertySayaKos() {
        playwright.navigateTo(Mamikos.OWNER_URL + Mamikos.OWNERPAGE_KOS, 30000.0, LoadState.LOAD);
    }

    @When("owner navigates to {string}")
    public void userNavigateTo(String path) {
        playwright.navigateTo(Mamikos.OWNER_URL+path, 30000.0, LoadState.LOAD);
        playwright.waitTillUrlToBe(Mamikos.OWNER_URL+path, 30000.0);
    }

    @And("tenant navigates to voucher saya page")
    public void tenantNavigatesToVoucherSayaPage() {
        playwright.navigateTo(Mamikos.URL + Mamikos.VOUCHER_SAYA, 30000.0, LoadState.LOAD);
    }

    @When("admin navigates to Search Invoice Page")
    public void adminNavigatesToSearchInvoicePage() {
        playwright.navigateTo(Mamikos.ADMINMAMIPAY+Mamikos.SEARCH_INVOICE);
    }

    @And("owner/user navigates to owner dashboard")
    public void userNavigatesToOwnerDashboard() {
        playwright.navigateTo(Mamikos.OWNER_URL, 30000.0, LoadState.LOAD);
    }

    @And("tenant navigate to riwayat kos page")
    public void tenantNavigateToRiwayatKosPage() {
        playwright = new PlaywrightHelpers(page);
        playwright.navigateTo(Mamikos.URL + Mamikos.TENANT_RIWAYAT_KOST, 30000.0, LoadState.LOAD);
    }

    @When("owner navigate to pengajuan booking page")
    public void userNavigateToPengajuanBooking() {
        playwright.navigateTo(Mamikos.OWNER_URL + Mamikos.PENGAJUAN_BOOKING, 60000.0, LoadState.LOAD);
    }

    @When("user/owner/tenant navigates to old prophoto page")
    public void owner_navigates_to_old_prophoto_page() {
        playwright.navigateTo(Mamikos.URL + Mamikos.PROPHOTO, 30000.0, LoadState.LOAD);
    }

    @When("tenant/user navigate to kost saya page")
    public void userNavigateToKostSayaPage() {
        playwright.navigateTo(Mamikos.URL + Mamikos.KOST_SAYA, 30000.0, LoadState.LOAD);
    }

    @When("tenant/user navigate to kontrak kost saya")
    public void userNavigateToKontrakKostSaya() {
        playwright.navigateTo(Mamikos.URL + Mamikos.KONTRAK_KOST_SAYA, 30000.0, LoadState.LOAD);
    }

    @And("tenant navigate to mamipoint guideline page")
    public void tenantNavigateToMamipointGuidelinePage() {
        playwright.navigateTo(Mamikos.URL + Mamikos.MAMIPOIN_GUIDELINE, 30000.0, LoadState.LOAD);
    }

    @When("user/admin/tenant visit page {string}")
    public void userVisitPage(String pathUrl) {
        page.navigate(Mamikos.URL + pathUrl);
    }
    
    @And("user navigates to help page")
    public void userNavigateToHelpPage() {
        page.bringToFront();
        playwright.navigateTo(Mamikos.URL + Mamikos.HELP_PAGE, 30000.0, LoadState.LOAD);
        playwright.hardWait(3);
    }

    @And("user navigate to penyewa page")
    public void userNavigateToPenyewaPage() {
        playwright.navigateTo(Mamikos.OWNER_URL + Mamikos.PENYEWA, 30000.0, LoadState.LOAD);
    }

    @And("admin navigate to mamikos voucher menu")
    public void tenantNavigateToMamikosVoucherPage() {
        playwright.navigateTo(Mamikos.ADMINMAMIPAY + Mamikos.MAMIKOS_VOUCHER, 30000.0, LoadState.LOAD);
    }

    @And("admin navigate to mamipay refund page")
    public void adminVisitRefundPageOnMamipay() {
        playwright.navigateTo(Mamikos.ADMINMAMIPAY + "/backoffice/refund", 30000.0, LoadState.LOAD);
    }

    @And("admin bangkrupux navigate to data booking menu")
    public void adminAccessToDataBookingMenu() {
        playwright.navigateTo(Mamikos.URL + "/admin/booking/users", 30000.0, LoadState.LOAD);
    }

    @And("tenant navigate to mamipoint expired page")
    public void tenantNavigateToMamipointExpiredPage() {
        playwright.navigateTo(Mamikos.URL + Mamikos.MAMIPOIN_EXPIRED, 30000.0, LoadState.LOAD);
    }

    @And("tenant navigate to mamipoin history page")
    public void tenantNavigateToMamipoinHistoryPage() {
        playwright.navigateTo(Mamikos.URL + Mamikos.MAMIPOIN_HISTORY, 30000.0, LoadState.LOAD);
    }

    @And("admin bangkrupux navigates to Promo Owner")
    public void adminNavigatesToPromoOwner() {
        playwright.navigateTo(Mamikos.URL + "/admin/promo", 30000.0, LoadState.LOAD);
    }

    @When("owner navigates to property saya apartemen")
    public void userNavigateToPropertySayaApartemen() {
        playwright.navigateTo(Mamikos.OWNER_URL + Mamikos.OWNERPAGE_APARTEMEN, 30000.0, LoadState.LOAD);
    }

    @And("owner navigates to Akun menu")
    public void ownerNavigatesToAkunMenu() {
        playwright.navigateTo(Mamikos.URL + Mamikos.AKUN, 30000.0, LoadState.LOAD);
    }

    @And("admin bangkrupux navigate to kost owner menu")
    public void adminNavigatesToKostOwnerMenu() {
        playwright.navigateTo(Mamikos.URL + "/admin/owner?#owner", 30000.0, LoadState.LOAD);
    }

    @And("admin go to kost level menu")
    public void adminGoToKostLevelMenu() {
        playwright.navigateTo(Mamikos.URL + "/admin/kost-level/level", 30000.0, LoadState.LOAD);
    }

    @And("admin go to room level menu")
    public void adminGoToRoomLevelMenu() {
        playwright.navigateTo(Mamikos.URL + "/admin/kost-level/room-level", 30000.0, LoadState.LOAD);
    }

    @When("owner navigates to broadcast chat page")
    public void ownerNavigatesToBroadcastChatPage() {
        playwright.waitTillPageLoaded();
        playwright.navigateTo(Mamikos.OWNER_URL + Mamikos.BROADCAST_CHAT, 30000.0, LoadState.LOAD);
        playwright.bringPageToView(page);
    }

    @When("admin navigates to {string}")
    public void adminNavigateTo(String path) {
        playwright.navigateTo(Mamikos.ADMINBANGKRUPUX+path, 30000.0, LoadState.LOAD);
        playwright.waitTillUrlToBe(Mamikos.ADMINBANGKRUPUX+path, 30000.0);
    }

    @When("admin navigates to Kontrak Kerja Sama")
    public void admin_navigates_to_Kontrak_Kerja_Sama(){
        playwright = new PlaywrightHelpers(page);
        playwright.navigateTo(Mamikos.KONTRAK_KERJA_SAMA, 30000.0, LoadState.LOAD);
    }

    @Given("user navigate to SBMPTN page")
    public void userNavigateToSBMPTNPage() {
        playwright.navigateTo(Mamikos.URL + "/download-soal/download-soal-sbmptn-tkpa-saintek-soshum-dan-campuran-beserta-pembahasannya-gratis", 30000.0, LoadState.LOAD);
    }

    @And("user go to mailhog and login")
    public void userGoToMailhogAndLogin() {
        verifikasiAkun.navigatesToMailHogAndLogin();
    }

    @Given("user navigates to promo mamikos")
    public void userNavigatesToPromoMamikos() {
        playwright.navigateTo(Mamikos.PROMO_MAMIKOS);
    }
}
