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
import pageobject.common.LoginPO;
import pageobject.owner.OwnerLoginPO;
import pageobject.pms.LoginPMSPO;
import pageobject.tenant.TenantLoginPO;

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
    OwnerLoginPO owner = new OwnerLoginPO(page);


    private List<Map<String, String>> phoneNumberCredential;
    private List<Map<String, String>> emailCredential;
    private List<Map<String, String>> pmsCredential;

    @When("user login as tenant via phone number:")
    public void userLoginAsTenantViaPhoneNumber(DataTable table) {
        phoneNumberCredential = table.asMaps(String.class, String.class);
        var phone = phoneNumberCredential.get(0).get("phone "+ Mamikos.ENV);
        var password = phoneNumberCredential.get(0).get("password");
        home.clickOnButtonMasuk()
            .clickOnPencariKostButton()
            .waitForPasswordInput()
            .fillPhoneNumber(phone)
            .fillPassword(password)
            .clickOnLoginButton()
            .waitTillLogoIsVisible();
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
    }

    @When("admin login pms :")
    public void admin_login_pms(DataTable tables) {
        pmsCredential = tables.asMaps(String.class, String.class);
        String username = pmsCredential.get(0).get("email");
        String password = pmsCredential.get(0).get("password");
        loginPMS.fillUsername(username);
        loginPMS.fillPassword(password);
        loginPMS.clickLogin();
    }

    @Then("user see login pop up in favorite page")
    public void userSeeLoginPopUpInFavoritePage() {
        login.checkLoginPopUpFromFavoritePage();
    }

    @When("admin login to bangkrupux:")
    public void adminLoginToBangkrupux(DataTable table) {
        emailCredential = table.asMaps(String.class, String.class);
        var email = emailCredential.get(0).get("email " + Mamikos.ENV);
        var password = emailCredential.get(0).get("password");
        loginAdminBangkrupux.fillEmail(email);
        loginAdminBangkrupux.fillPassword(password);
        loginAdminBangkrupux.clickOnLoginButton();
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

    @And("user click back button in login owner")
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
}
