package steps.mamikos.owner.mamiprime;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import data.mamikos.Mamikos;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.owner.mamiprime.MamiprimeResetPO;
import utilities.PlaywrightHelpers;

public class MamiprimeResetSteps {
    Page page = ActiveContext.getActivePage();
    PlaywrightHelpers playwright = new PlaywrightHelpers(page);
    MamiprimeResetPO mamiprimeResetPO = new MamiprimeResetPO(page);

    @When("admin wants to reset mamiprime for owner with property ID {string}")
    public void admin_wants_to_reset_mamiprime_for_owner_with_property_id(String propertyID) {
        playwright.navigateTo(Mamikos.ADMINBANGKRUPUX + "/lpl-boost");
        mamiprimeResetPO.inputProperyID(propertyID);
        mamiprimeResetPO.clickOnSearchBtn();
        mamiprimeResetPO.clickOnDeleteBtn();
        mamiprimeResetPO.acceptDeletePopUp();
    }

    @When("admin mamipay wants to reset mamiprime srp for owner with property ID {string}")
    public void admin__mamipay_wants_to_reset_mamiprime_for_owner_with_property_id(String propertyID) {
        playwright.navigateTo(Mamikos.ADMINMAMIPAY + "/backoffice/testing-tools/mamiprime");
        mamiprimeResetPO.resetMamiprimeSrp(propertyID);
    }

}
