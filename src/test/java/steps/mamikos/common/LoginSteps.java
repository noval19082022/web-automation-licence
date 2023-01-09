package steps.mamikos.common;

import com.microsoft.playwright.Page;
import config.global.FlowControl;
import config.mamikos.Mamikos;
import config.playwright.context.ActiveContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.common.HomePO;

import java.util.List;
import java.util.Map;

public class LoginSteps {

    Page page = ActiveContext.getActivePage();
    HomePO login = new HomePO(page);
    private List<Map<String, String>> phoneNumberCredential;

    @Given("user go to mamikos homepage")
    public void userGoToMamikosHomepage() {
        page.navigate("https://jambu.kerupux.com");
    }

    @Then("tenant redirect back to homepage")
    public void tenantRedirectBackToHomepage() {
    }

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

    @When("user logins as owner")
    public void userLoginsAsOwner() {
        if (!FlowControl.getStrictFlow()) {
            ActiveContext.activateOwner(0);
            login = new HomePO(ActiveContext.getActivePage());
            ActiveContext.getActivePage().navigate("https://jambu.kerupux.com");
        }
        login.clickOnButtonMasuk()
            .clickOnPemilikKostButton()
            .fillPhoneNumber("089604239098")
            .fillPassword("widyarini1")
            .clickOnLoginButton()
            .clickOnOwnerProfile();
    }

    @Then("user can sees owner's page")
    public void userCanSeesOwnerSPage() {

    }
}
