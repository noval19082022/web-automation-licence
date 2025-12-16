package steps.mamikos.common;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import config.global.FlowControl;
import config.global.GlobalConfig;
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
import pageobject.common.LoadingPO;
import pageobject.harvest.CheckPropertyPO;
import pageobject.harvest.harvestDashboard.LoginHarvestDashboardPO;
import pageobject.owner.PropertiSayaPO;
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
    LoadingPO loading = new LoadingPO(page);
    CheckPropertyPO checkProperty = new CheckPropertyPO(page);
    PropertiSayaPO propertySaya = new PropertiSayaPO(ActiveContext.getActivePage());
    LoginHarvestDashboardPO loginHarvestDashboard = new LoginHarvestDashboardPO(page);

    @Given("user go to mamikos homepage")
    public void userGoToMamikosHomepage() {
        page = ActiveContext.getActivePage();
        home = new HomePO(page);
        home.navigatesToHomepage();
    }

    @Given("admin go to mamikos mamipay admin")
    public void adminGoToMamikosMamipayAdmin() {
        if (AjukanSewaStatus.isContractPresent() || !FlowControl.isApiFlow()) {
            playwright.navigateTo(Mamikos.ADMINMAMIPAY+Mamikos.LOGIN_MAMIPAY, 60000.0);
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

        // Automatically set active page to first available page if current page was closed
        List<Page> remainingPages = ActiveContext.getActiveBrowserContext().pages();
        if (!remainingPages.isEmpty()) {
            // Set to first page (index 0) as default
            ActiveContext.setActivePage(remainingPages.get(0));
            playwright = new PlaywrightHelpers(ActiveContext.getActivePage());
        }
    }

    @When("tenant/owner/admin refresh page {int}")
    public void tenantRefreshPage(int pageNumber) {
        ActiveContext.getActiveBrowserContext().pages().get(pageNumber).reload();
    }

    @When("tenant/owner/admin set active page to {int}")
    public synchronized void tenantSetActivePageTo(int activePage) {
        List<Page> listPage = ActiveContext.getActiveBrowserContext().pages();
        if (activePage < listPage.size()) {
            ActiveContext.setActivePage(listPage.get(activePage));
            playwright = new PlaywrightHelpers(ActiveContext.getActivePage());
            playwright.bringPageToView(ActiveContext.getActivePage());
        } else {
            // If requested page doesn't exist, use the last available page
            ActiveContext.setActivePage(listPage.get(listPage.size() - 1));
            playwright = new PlaywrightHelpers(ActiveContext.getActivePage());
            playwright.bringPageToView(ActiveContext.getActivePage());
        }
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
        Assert.assertTrue(home.isSearchIklanDisplayed(), "Cari Iklan button not present!");
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
        playwright.navigateTo(Mamikos.URL + Mamikos.NOLOGIN, 30000.0, LoadState.LOAD);
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
        playwright.navigateTo(Mamikos.ADMINBANGKRUPUX, 60000.0);
        playwright.hardWait(3000.0);
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

    @Given("admin go to mamikos cek properti")
    public void admin_go_to_mamikos_cek_properti(){
        checkProperty.navigateToCheckPropertyPage();
    }

    @When("owner navigates to property saya kos")
    public void userNavigateToPropertySayaKos() {
        playwright.waitTillPageLoaded(120000.00);
        playwright.navigateTo(Mamikos.OWNER_URL + Mamikos.OWNERPAGE_KOS, GlobalConfig.LONG_TIMEOUT);
        loading.waitForLoadingIconDisappear();
        loading.waitForLoadingIconDisappear();
        if (loading.loadingAnimationIsExist()) {
            playwright.reloadPage();
            loading.waitForLoadingIconDisappear();
        }
    }

    @When("owner close pop up bbk on property saya page")
    public void closeBBK() {
        propertySaya.clickClosePopUpBBKOnPropertySaya();
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
        playwright.navigateTo(Mamikos.OWNER_URL, 30000.0);
        loading.waitForLoadingIconDisappear();
        home.clickOnSayaSetujuButton();
    }

    @And("tenant navigate to riwayat kos page")
    public void tenantNavigateToRiwayatKosPage() {
        playwright = new PlaywrightHelpers(page);
        playwright.navigateTo(Mamikos.URL + Mamikos.TENANT_RIWAYAT_KOST, 60000.0, LoadState.LOAD);
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
    }

    @And("user navigate to penyewa page")
    public void userNavigateToPenyewaPage() {
        playwright.navigateTo(Mamikos.OWNER_URL + Mamikos.PENYEWA, 50000.0, LoadState.LOAD);
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
        playwright.navigateTo(Mamikos.URL + Mamikos.MAMIPOIN_HISTORY, 60000.0, LoadState.LOAD);
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
        playwright.navigateTo(Mamikos.URL + "/admin/owner?#owner", GlobalConfig.LONG_TIMEOUT, LoadState.LOAD);
    }

    @And("admin bangkrupux navigate to booking owner request menu")
    public void adminNavigatesToBookingOwnerRequest() {
        playwright.navigateTo(Mamikos.URL + "/admin/booking/owner/request/#booking-owner", 30000.0, LoadState.LOAD);
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
        playwright.navigateTo(Mamikos.URL + path, 40000.0, LoadState.LOAD);
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

    @When("admin accsess menu boot LPL")
    public void admin_accsess_menu_boot_lpl() {
        playwright.navigateTo(Mamikos.URL + "/admin/lpl-boost", 30000.0, LoadState.LOAD);
    }

    @And("admin bangkrupux navigate to kost menu")
    public void adminBangkrupuxNavigateToKostMenu() {
        playwright.navigateTo(Mamikos.URL + "/admin/room?#room", 30000.0, LoadState.LOAD);
    }
    @When("admin accsess menu Goldplus Contract")
    public void admin_accsess_menu_goldplus_contract() {
        playwright.navigateTo(Mamikos.ADMINMAMIPAY+Mamikos.GOLDPLUS_CONTRACT);
    }

    @When("admin access user point menu")
    public void admin_access_user_point_menu() {
        playwright.navigateTo(Mamikos.URL + "/admin/point/user/index#point", 30000.0, LoadState.LOAD);
    }
    @When("user navigates to ownersini")
    public void user_navigates_to_ownersini() {
        playwright.navigateTo(Mamikos.Ownersini_URL,30000.0,LoadState.LOAD);
        playwright.hardWait(3000);
        playwright.waitTillPageLoaded();
    }

    @When("admin access point expiry menu")
    public void admin_access_point_expiry_menu() {
        playwright.navigateTo(Mamikos.URL + "/admin/point/expiry#point", 30000.0, LoadState.LOAD);
    }
    @And("admin navigate to Mamipay Owner List")
    public void adminNavigateToMamipayOwnerList() {
        playwright.navigateTo(Mamikos.ADMINMAMIPAY + Mamikos.MAMIPAY_OWNER_LIST);
    }

    @When("owner navigate to list goldplus package")
    public void owner_navigate_to_list_goldplus_package() {
        playwright.waitTillPageLoaded();
        playwright.navigateTo(Mamikos.OWNER_URL + Mamikos.GOLDPLUS_PACKAGE, 30000.0, LoadState.LOAD);
    }
    @And("owner/user navigates to financial report")
    public void userNavigatesToLaporanKeuangan() {
        playwright.navigateTo(Mamikos.OWNER_URL + Mamikos.FINANCIAL_REPORT, 30000.0, LoadState.LOAD);
        loading.waitForLoadingIconDisappear();
    }

    @When("user navigate to mamitour landing page")
    public void user_navigate_to_mamitour_landing_page() {
        playwright.waitTillPageLoaded();
        playwright.navigateTo(Mamikos.OWNER_URL + Mamikos.MAMITOUR, 30000.0, LoadState.LOAD);
    }

    @And("admin mamipay go to goldplus invoice list menu")
    public void adminMamipayGoToGoldPlusInvoiceListMenu() {
        playwright.navigateTo(Mamikos.ADMINMAMIPAY + "/backoffice/invoice/property-contracts/invoices");
    }

    @When("owner navigate to mamiads dashboard")
    public void ownerNavigateToMamiadsDashboard() {
        playwright.navigateTo(Mamikos.OWNER_URL + Mamikos.MAMIADS, 60000.0, LoadState.LOAD);
    }

    @And("user go to formulir data penyewa")
    public void ownerNavigateToFormulirDataPenyewa() {
        playwright.navigateTo(Mamikos.URL + Mamikos.FORMULIR_DATA_PENYEWA, 30000.0, LoadState.LOAD);
    }
    @And("user navigate to add contract tenant page")
    public void userNavigateToAddContractTenantPage() {
        playwright.navigateTo(Mamikos.OWNER_URL + Mamikos.ADD_CONTRACT_TENANT, 30000.0, LoadState.LOAD);
    }
    @And("owner navigate to rules enter kos")
    public void ownerNavigateToRulesEnterKosPage() {
        playwright.navigateTo(Mamikos.OWNER_URL + Mamikos.RULE_ENTER_KOS, 30000.0, LoadState.LOAD);
    }

    @Given("user navigate to popular area page")
    public void userNavigateToPopularAreaPage() {
        playwright.navigateTo(Mamikos.URL + "/area", 30000.0, LoadState.LOAD);
    }

    @Given("user navigate to near campus page")
    public void userNavigateToNearCampusPage() {
        playwright.navigateTo(Mamikos.URL + "/kampus", 30000.0, LoadState.LOAD);
    }

    @And("admin navigate to premium package invoice list")
    public void adminNavigateToPremiumPackageInvoiceList() {
        playwright.navigateTo(Mamikos.ADMINMAMIPAY + "/backoffice/invoice/premium/package");
    }
    @When("admin accsess menu whitelist feature")
    public void admin_accsess_menu_whitelist_feature() {
        playwright.navigateTo(Mamikos.URL + "/admin/whitelist-features", 30000.0, LoadState.LOAD);
    }

    @And("admin navigate to goldplus package edit form")
    public void adminNavigateToGoldplusPackageEditForm() {
        playwright.navigateTo(Mamikos.URL + "/admin/gold-plus/package/346/edit", 30000.0, LoadState.LOAD);
    }

    @Given("admin/user navigate to mantool")
    public void admin_navigate_to_mantool() {
        playwright.navigateTo(Mamikos.URL+"/agen");
    }

    @Given("admin wants to access prime setting")
    public void admin_wants_to_access_prime_setting() {
        playwright.navigateTo(Mamikos.URL + "/admin/prime", 30000.0, LoadState.LOAD);
    }
    @Given("admin navigates to Harvest Dashboard Login")
    public void admin_navigates_to_Harvest_Dashboard_login(){
        loginHarvestDashboard.navigateToHarvestDashboardLoginPage();
    }
    @When("admin navigates to Harvest Dashboard")
    public void admin_navigates_to_harvest_dashboard() {
        loginHarvestDashboard.navigateToHarvestDashboard();
    }
    @When("admin navigate to admin prime suggestion")
    public void adminNavigateToAdminPrimeSuggestion() {
        playwright.navigateTo(Mamikos.URL+Mamikos.ADMIN_PRIME_SUGGESTION);
    }

    @And("admin bangkerupux navigates landmark data menu")
    public void admin_bangkerupux_naviagtes_landmark_data_menu(){
        playwright.navigateTo(Mamikos.URL + "/admin/landmark", 40000.0, LoadState.LOAD);
    }

    @Then("admin bangkerupux navigates listing featured menu")
    public void admin_bangkerupux_naviagtes_listing_featured_menu(){
        playwright.navigateTo(Mamikos.URL + "/admin/featured/listing", 40000.0, LoadState.LOAD);
    }

}
