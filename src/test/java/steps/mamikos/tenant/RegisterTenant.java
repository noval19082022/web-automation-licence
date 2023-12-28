package steps.mamikos.tenant;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.common.HomePO;
import pageobject.tenant.TenantLoginPO;
import pageobject.tenant.TenantRegisterPO;
import utilities.PlaywrightHelpers;


public class RegisterTenant {
    Page page = ActiveContext.getActivePage();
    HomePO home = new HomePO(page);
    TenantRegisterPO tenatRegisterPO = new TenantRegisterPO(page);
    TenantLoginPO tenantLogin = new TenantLoginPO(page);

    @When("user clicks on Enter button Tenant")
    public void userClicksOnEnterButtonTenant() {
        home.EnterButton();
        tenantLogin.clickOnPencariKostButton();
    }

    @Then("user verify password more than {int} characters")
    public void userVerifyPasswordMoreThanCharacters(int character) {
        int counter = 0;
        for (int i = 0; i < tenatRegisterPO.getPasswordInputText().length(); i++) {
            counter++;
        }
        Assert.assertTrue(counter > character, "Password is less than or equal to " + character);
    }

    @When("user want to register as tenant")
    public void userWantToRegisterAsTenant() {
        new PlaywrightHelpers(ActiveContext.getActivePage())
                .navigateTo(Mamikos.URL + "/register-pencari?source=homepage");
    }
}
