package steps.common;

import com.microsoft.playwright.Page;
import config.FlowControl;
import config.playwright.context.ActiveContext;
import config.playwright.context.OwnerContextInitializer;
import config.playwright.context.TenantContextInitializer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.common.HeaderPO;

public class LoginSteps {

    Page page = ActiveContext.getActivePage();
    HeaderPO login = new HeaderPO(page);

    @Given("user go to mamikos homepage")
    public void userGoToMamikosHomepage() {
        page.navigate("https://jambu.kerupux.com");
    }

    @When("user login as tenant")
    public void userLoginAsTenant() {
    }

    @Then("tenant redirect back to homepage")
    public void tenantRedirectBackToHomepage() {
    }

    @When("user login as tenant via phone number")
    public void userLoginAsTenantViaPhoneNumber() {
        if (!FlowControl.getStrictFlow()) {
            TenantContextInitializer.initializeTenantPage();
            page = ActiveContext.getActivePage();
            login = new HeaderPO(page);
        }
        page.navigate("https://jambu.kerupux.com/");
        login.clickOnButtonMasuk()
            .clickOnPencariKostButton()
            .fillPhoneNumber("087708777615")
            .fillPassword("qwerty123")
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
            OwnerContextInitializer.initializeOwnerPage();
            page = ActiveContext.getActivePage();
            login = new HeaderPO(page);
            page.navigate("https://jambu.kerupux.com");
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
