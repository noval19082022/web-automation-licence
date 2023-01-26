package steps.mamikos.common;

import com.microsoft.playwright.Page;
import config.global.FlowControl;
import config.mamikos.Mamikos;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pageobject.admin.mamipay.LoginAdminMamipayPO;
import pageobject.common.HomePO;

import java.util.List;
import java.util.Map;

public class LoginSteps {

    Page page = ActiveContext.getActivePage();
    HomePO login = new HomePO(page);
    LoginAdminMamipayPO loginAdmin = new LoginAdminMamipayPO(page);
    private List<Map<String, String>> phoneNumberCredential;
    private List<Map<String, String>> emailCredential;

    @When("user login as tenant via phone number:")
    public void userLoginAsTenantViaPhoneNumber(DataTable table) {
        phoneNumberCredential = table.asMaps(String.class, String.class);
        var phone = phoneNumberCredential.get(0).get("phone "+ Mamikos.ENV);
        var password = phoneNumberCredential.get(0).get("password");
        if (!FlowControl.getStrictFlow()) {
            ActiveContext.activateTenant(0);
            login = new HomePO(ActiveContext.getActivePage());
            ActiveContext.getActivePage().navigate("https://jambu.kerupux.com");
        }
        login.clickOnButtonMasuk()
            .clickOnPencariKostButton()
            .fillPhoneNumber(phone)
            .fillPassword(password)
            .clickOnLoginButton();
    }

    @When("user login as tenant via facebook")
    public void userLoginAsTenantViaFacebook() {
        System.out.println("From inside scenario login facebook");
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
        if (!FlowControl.getStrictFlow()) {
            ActiveContext.activateOwner(0);
            login = new HomePO(ActiveContext.getActivePage());
            ActiveContext.getActivePage().navigate("https://jambu.kerupux.com");
        }
        login.clickOnButtonMasuk()
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
        loginAdmin.fillEmail(email);
        loginAdmin.fillPassword(password);
        loginAdmin.clickOnLoginButton();
    }
}
