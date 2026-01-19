package steps.mamikos.common;

import com.microsoft.playwright.Page;
import config.global.FlowControl;
import config.playwright.context.ActiveContext;
import data.api.AjukanSewaStatus;
import data.mamikos.Mamikos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.admin.mamipay.LoginAdminMamipayPO;
import pageobject.admin.mamipay.bangkrupux.AdminBangkrupuxLoginPO;
import pageobject.common.HomePO;
import pageobject.common.LoadingPO;
import pageobject.common.LoginPO;
import pageobject.harvest.harvestDashboard.AllLeadsPO;
import pageobject.harvest.harvestDashboard.LoginHarvestDashboardPO;
import pageobject.owner.OwnerDashboardPO;
import pageobject.owner.OwnerLoginPO;
import pageobject.pms.HomepagePO;
import pageobject.pms.LoginPMSPO;
import pageobject.tenant.TenantLoginPO;
import utilities.PlaywrightHelpers;

import java.util.List;
import java.util.Map;

public class LoginSteps {

    Page page = ActiveContext.getActivePage();
    HomePO home = new HomePO(page);
    LoginPO login = new LoginPO(page);
    LoginAdminMamipayPO loginAdmin = new LoginAdminMamipayPO(page);
    AdminBangkrupuxLoginPO loginAdminBangkrupux = new AdminBangkrupuxLoginPO(page);
    TenantLoginPO tenantLogin = new TenantLoginPO(page);
    LoginPMSPO loginPMS = new LoginPMSPO(page);
    HomepagePO homepage = new HomepagePO(page);
    OwnerLoginPO owner = new OwnerLoginPO(page);
    OwnerDashboardPO ownerDashboard = new OwnerDashboardPO(page);
    LoginHarvestDashboardPO loginHarvestDashboard = new LoginHarvestDashboardPO(page);
    AllLeadsPO allLeads = new AllLeadsPO(page);
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);

    LoadingPO loading = new LoadingPO(page);

    private List<Map<String, String>> phoneNumberCredential;
    private List<Map<String, String>> emailCredential;
    private List<Map<String, String>> pmsCredential;

    @When("user login as tenant via phone number:")
    public void userLoginAsTenantViaPhoneNumber(DataTable table) {
        Page activePage = ActiveContext.getActivePage();
        HomePO activeHome = new HomePO(activePage);

        phoneNumberCredential = table.asMaps(String.class, String.class);
        var phone = phoneNumberCredential.get(0).get("phone "+ Mamikos.ENV);
        var password = phoneNumberCredential.get(0).get("password");
        activeHome.clickOnButtonMasuk()
            .clickOnPencariKostButton()
            .waitForPasswordInput()
            .fillPhoneNumber(phone)
            .fillPassword(password);
        TenantLoginPO activeTenantLogin = new TenantLoginPO(activePage);
        activeTenantLogin.clickOnTenantLoginButton()
            .waitTillLogoIsVisible();
        activeHome.waitForProfileMenuToBeVisible();
        activeHome.clickOnSayaSetujuButton();
    }

    @When("user login as tenant via facebook:")
    public void userLoginAsTenantViaFacebook(DataTable table) {
        emailCredential = table.asMaps(String.class, String.class);
        var email = emailCredential.get(0).get("email " + Mamikos.ENV);
        var password = emailCredential.get(0).get("password");
        home.clickOnButtonMasuk()
                .clickOnPencariKostButton()
                .clickOnSignInWithFacebookButton()
                .fillEmailAddress(email)
                .fillPasswordFacebook(password)
                .clickOnLoginFacebookButton();
        login.clickOnContinueFBButton();
        home.clickOnSayaSetujuButton();
    }

    @When("user login as tenant via google")
    public void userLoginAsTenantViaGoogle() {
        System.out.println("From inside scenario login google");
    }

    @When("user login as owner:")
    public void userLoginsAsOwner(DataTable table) {
        phoneNumberCredential = table.asMaps(String.class, String.class);
        var phone = phoneNumberCredential.get(0).get("phone " + Mamikos.ENV);
        var password = phoneNumberCredential.get(0).get("password");
        home.clickOnButtonMasuk()
            .clickOnPemilikKostButton()
            .fillPhoneNumber(phone)
            .fillPassword(password)
            .clickOnLoginButton();
        Mamikos.setPhoneOwner(phone);
        loading.waitForLoadingIconDisappear();
        home.clickOnSayaSetujuButton();
        ownerDashboard.waitForOwnerDashboardToLoad();
    }

    @When("user login as owner from mamiads landing page:")
    public void userLoginsAsOwnerFromMamiAds(DataTable table) {
        phoneNumberCredential = table.asMaps(String.class, String.class);
        var phone = phoneNumberCredential.get(0).get("phone " + Mamikos.ENV);
        var password = phoneNumberCredential.get(0).get("password");
        owner.fillPhoneNumber(phone)
                .fillPassword(password)
                .clickOnLoginButtonMA();
        home.clickOnSayaSetujuButton();
    }

    @When("admin login to mamipay:")
    public void adminLoginToMamipay(DataTable table) {
        emailCredential = table.asMaps(String.class, String.class);
        var email = emailCredential.get(0).get("email " + Mamikos.ENV);
        var password = emailCredential.get(0).get("password");
        loginAdmin = new LoginAdminMamipayPO(page);
        if (AjukanSewaStatus.isContractPresent() || !FlowControl.isApiFlow()) {
            loginAdmin.fillEmail(email);
            loginAdmin.fillPassword(password);
            loginAdmin.clickOnLoginButton();
        }

        // handling 429, 502, 504
        if (playwright.isTextDisplayed("429") || playwright.isTextDisplayed("502") || playwright.isTextDisplayed("504")) {
            playwright.reloadPage();
        }
    }

    @When("admin login pms :")
    public void admin_login_pms(DataTable tables) {
        pmsCredential = tables.asMaps(String.class, String.class);
        String username = pmsCredential.get(0).get("email");
        String password = pmsCredential.get(0).get("password");
        loginPMS.fillUsername(username);
        loginPMS.fillPassword(password);
        loginPMS.clickLogin();
        Assert.assertTrue(homepage.isTotalPropertyVisible());
    }

    @Then("user see login pop up in favorite page")
    public void userSeeLoginPopUpInFavoritePage() {
        login.checkLoginPopUpFromFavoritePage();
    }

    @When("admin login to bangkrupux:")
    public void adminLoginToBangkrupux(DataTable table) {
        Page activePage = ActiveContext.getActivePage();
        AdminBangkrupuxLoginPO activeLoginAdminBangkrupux = new AdminBangkrupuxLoginPO(activePage);

        emailCredential = table.asMaps(String.class, String.class);
        var email = emailCredential.get(0).get("email " + Mamikos.ENV);
        var password = emailCredential.get(0).get("password");
        activeLoginAdminBangkrupux.fillEmail(email);
        activeLoginAdminBangkrupux.fillPassword(password);
        activeLoginAdminBangkrupux.clickOnLoginButton();
    }

    @And("user login from kost detail via phone number:")
    public void userLoginFromKostDetailViaPhoneNumber(DataTable table) {
        phoneNumberCredential = table.asMaps(String.class, String.class);
        var phone = phoneNumberCredential.get(0).get("phone "+ Mamikos.ENV);
        var password = phoneNumberCredential.get(0).get("password");
        tenantLogin.waitForPasswordInput()
                .fillPhoneNumber(phone)
                .fillPassword(password)
                .clickOnLoginButton();
    }

    @And("user verify login form owner")
    public void verify_login_owner() {
        Assert.assertTrue(login.popUpOwnerLogin(), "login owner not showing");
    }

    @And("user click back button in login page")
    public void clickBack() {
        login.clickBackOnPopUpLogin();
    }

    @And("user click button close login form")
    public void close() {
        login.clickCloseOnPopUpLogin();
    }

    @Then("user verify login form close")
    public void verifyHome() {
        Assert.assertTrue(!login.popUpLogin(), "pop up login is showing");
    }

    @And("user logs out as a Tenant user")
    public void userLogsOutAsTenant() {
        tenantLogin.logoutAsTenant();
    }

    @Then("mamikos bangkrupux admin should be successfully logged out")
    public void mamikos_bangkrupux_admin_should_be_successfully_logged_out() {
        loginAdminBangkrupux.logoutAsMamikosBangkrupuxAdmin();
    }

    @And("owner should successfully log out")
    public void owner_should_successfully_log_out(){
        owner.logoutAsOwner();
    }

    @And("user tenant profile picture is shown")
    public void userTenantProfilePictureIsShown() {
        Assert.assertTrue(tenantLogin.isTenantProfilePictureDisplayed(), "Tenant Profile Picture is not Displayed");
    }

    @When("user clicks on Enter button as tenant delete password fill")
    public void userClicksOnEnterButtonAsTenantDeletePasswordFill(DataTable table) {
        phoneNumberCredential = table.asMaps(String.class, String.class);
        var phone = phoneNumberCredential.get(0).get("phone "+ Mamikos.ENV);
        var password = phoneNumberCredential.get(0).get("password");
        home.clickOnButtonMasuk()
                .clickOnPencariKostButton()
                .waitForPasswordInput()
                .fillPhoneNumber(phone)
                .fillPassword(password);
        login.clearTextPassword();
    }

    @Then("user verify login error messages {string}")
    public void userVerifyLoginErrorMessages(String error) {
        Assert.assertEquals(login.getLoginErrorMessagesText(error), error, "Login error messages is not equal to " + error);
    }

    @When("user clicks on Enter button as tenant delete phone number fill")
    public void userClicksOnEnterButtonAsTenantDeletePhoneNumberFill(DataTable table) {
        phoneNumberCredential = table.asMaps(String.class, String.class);
        var phone = phoneNumberCredential.get(0).get("phone "+ Mamikos.ENV);
        var password = phoneNumberCredential.get(0).get("password");
        home.clickOnButtonMasuk()
                .clickOnPencariKostButton()
                .waitForPasswordInput()
                .fillPhoneNumber(phone)
                .fillPassword(password);
        login.clearTextPhoneNumber();
    }

    @When("user login with alfabet phone number")
    public void userLoginWithAlfabetPhoneNumber(DataTable table) {
        phoneNumberCredential = table.asMaps(String.class, String.class);
        var phone = phoneNumberCredential.get(0).get("phone "+ Mamikos.ENV);
        var password = phoneNumberCredential.get(0).get("password");
        home.clickOnButtonMasuk()
                .clickOnPencariKostButton()
                .waitForPasswordInput()
                .fillPhoneNumber(phone)
                .fillPassword(password);
    }

    @When("user masuk sebagai")
    public void userMasukSebagai() {
        home.clickOnButtonMasuk();
    }

    @And("user click close on pop up login")
    public void userClickCloseOnPopUpLogin() {
        login.clickCloseOnPopUpLogin();
    }

    @Then("user verify pop up {string} {string}")
    public void userVerifyPopUp(String title, String subtitle) {
        Assert.assertEquals(login.getLoginTitlePopUpText(title), title, "Pop up login title is not equal to " + title);
        Assert.assertEquals(login.getLoginSubtitleText(subtitle), subtitle, "Pop up login subtitle is not equal to " + subtitle);
    }

    @Then("user verify pop up {string} {string} are not appeared")
    public void userVerifyPopUpAreNotAppeared(String title, String subtitle) {
        Assert.assertFalse(login.isPopupTitleTextAppeared(title), "Pop up title text is appear");
        Assert.assertFalse(login.isPopupSubtitleTextAppeared(subtitle), "Pop up subtitle text is appear");
    }

    @Then("user tenant verify profil picture is null")
    public void userTenantVerifyProfilPictureIsNull() {
        Assert.assertTrue(tenantLogin.isProfilePictureNotNull(), "Profile picture is not null");
    }
    @Then("user/owner redirect to login pemilik page")
    public void user_redirect_to_login_pemilik_page() {
        Assert.assertEquals(playwright.getPageUrl(),Mamikos.LoginPemilik_URL);
    }
    @Then("owner redirect to homepage mamikos")
    public void owner_redirect_to_homepage_mamikos() {
        Assert.assertEquals(playwright.getPageUrl(),Mamikos.URL+"/");
    }

    @When("user login as owner with wrong phone number:")
    public void userLoginAsOwnerWithWrongPhoneNumber(DataTable table) {
        phoneNumberCredential = table.asMaps(String.class, String.class);
        var phone = phoneNumberCredential.get(0).get("phone " + Mamikos.ENV);
        var password = phoneNumberCredential.get(0).get("password");
        home.clickOnButtonMasuk()
                .clickOnPemilikKostButton()
                .fillPhoneNumber(phone)
                .fillPassword(password);
    }

    @When("user login as tenant via phone number in popular area page")
    public void userLoginAsTenantViaPhoneNumberInPopularAreaPage(DataTable table) {
        phoneNumberCredential = table.asMaps(String.class, String.class);
        var phone = phoneNumberCredential.get(0).get("phone "+ Mamikos.ENV);
        var password = phoneNumberCredential.get(0).get("password");
        home.clickOnButtonMasukOnPopularArea()
                .clickOnPencariKostButton()
                .waitForPasswordInput()
                .fillPhoneNumber(phone)
                .fillPassword(password);
        tenantLogin = new TenantLoginPO(page);
        tenantLogin.clickOnTenantLoginButton()
                .waitTillLogoIsVisible();
    }

    @When("user login as owner in popular area page:")
    public void userLoginAsOwnerInPopularAreaPage(DataTable table) {
        phoneNumberCredential = table.asMaps(String.class, String.class);
        var phone = phoneNumberCredential.get(0).get("phone " + Mamikos.ENV);
        var password = phoneNumberCredential.get(0).get("password");
        home.clickOnButtonMasukOnPopularArea()
                .clickOnPemilikKostButton()
                .fillPhoneNumber(phone)
                .fillPassword(password)
                .clickOnLoginButton();
        Mamikos.setPhoneOwner(phone);
        loading.waitForLoadingIconDisappear();
    }

    @When("user login as tenant via facebook from popular area page:")
    public void userLoginAsTenantViaFacebookFromPopularAreaPage(DataTable table) {
        emailCredential = table.asMaps(String.class, String.class);
        var email = emailCredential.get(0).get("email " + Mamikos.ENV);
        var password = emailCredential.get(0).get("password");
        home.clickOnButtonMasukOnPopularArea()
                .clickOnPencariKostButton()
                .clickOnSignInWithFacebookButton()
                .fillEmailAddress(email)
                .fillPasswordFacebook(password)
                .clickOnLoginFacebookButton();
        login.clickOnContinueFBButton();
    }

    @When("user click on enter button tenant in popular area page")
    public void userClickOnEnterButtonTenantInPopularAreaPage() {
        home.clickOnButtonMasukOnPopularArea()
                .clickOnPencariKostButton();
    }

    @And("user click on enter button owner in popular area page")
    public void userClickOnEnterButtonOwnerInPopularAreaPage() {
        home.clickOnButtonMasukOnPopularArea()
                .clickOnPemilikKostButton();
    }

    @Then("user/owner redirect to login page")
    public void user_redirect_to_login_page() {
        Assert.assertEquals(playwright.getPageUrl(),Mamikos.LOGIN_USER);
    }

    @When("admin login Harvest Dashboard:")
    public void admin_login_Harvest_Dashboard(DataTable tables){
        pmsCredential = tables.asMaps(String.class, String.class);
        String username = pmsCredential.get(0).get("email");
        String password = pmsCredential.get(0).get("password");
        loginHarvestDashboard.fillsUsername(username);
        loginHarvestDashboard.fillsPassword(password);
        loginHarvestDashboard.clicksLogin();
    }
}
